package com.liquidvelo.app.data

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.math.abs
import kotlin.math.sqrt

data class GForceData(
    val gX: Float = 0f,
    val gY: Float = 0f,
    val gZ: Float = 1.0f,
    val totalG: Float = 1.0f,
    val peakG: Float = 1.0f,
    val isStationary: Boolean = true,
    val baroAltitudeM: Double? = null
)

class SensorManagerHelper(context: Context) : SensorEventListener {
    private val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as? SensorManager
    private val accelerometer = sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    private val barometer = sensorManager?.getDefaultSensor(Sensor.TYPE_PRESSURE)

    private val _gForceFlow = MutableStateFlow(GForceData())
    val gForceFlow: StateFlow<GForceData> = _gForceFlow.asStateFlow()

    private var peakGRecorded = 1.0f
    private val gravityStandard = 9.80665f

    private var filteredGx = 0f
    private var filteredGy = 0f
    private var filteredGz = 1.0f
    private var filteredTotalG = 1.0f
    private var smoothedDynamicDeviation = 0f

    private var smoothedPressureHpa: Float? = null
    private var currentBaroAlt: Double? = null

    fun startListening() {
        peakGRecorded = 1.0f
        smoothedDynamicDeviation = 0f
        accelerometer?.let {
            sensorManager?.registerListener(this, it, SensorManager.SENSOR_DELAY_GAME)
        }
        barometer?.let {
            sensorManager?.registerListener(this, it, SensorManager.SENSOR_DELAY_UI)
        }
    }

    fun stopListening() {
        try {
            sensorManager?.unregisterListener(this)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    fun resetPeak() {
        peakGRecorded = 1.0f
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event == null) return

        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            val ax = event.values[0] / gravityStandard
            val ay = event.values[1] / gravityStandard
            val az = event.values[2] / gravityStandard

            val instantTotalG = sqrt((ax * ax + ay * ay + az * az).toDouble()).toFloat()

            // Filter component axes
            filteredGx += 0.40f * (ax - filteredGx)
            filteredGy += 0.40f * (ay - filteredGy)
            filteredGz += 0.40f * (az - filteredGz)

            // Fast attack on acceleration spikes, smooth decay back to 1.0G
            if (instantTotalG > filteredTotalG) {
                filteredTotalG += 0.85f * (instantTotalG - filteredTotalG)
            } else {
                filteredTotalG += 0.32f * (instantTotalG - filteredTotalG)
            }

            val dyn = abs(instantTotalG - 1.0f)
            smoothedDynamicDeviation += 0.10f * (dyn - smoothedDynamicDeviation)

            if (instantTotalG > peakGRecorded) {
                peakGRecorded = instantTotalG
            }

            _gForceFlow.value = GForceData(
                gX = filteredGx,
                gY = filteredGy,
                gZ = filteredGz,
                totalG = filteredTotalG,
                peakG = peakGRecorded,
                isStationary = smoothedDynamicDeviation < 0.015f,
                baroAltitudeM = currentBaroAlt
            )
        } else if (event.sensor.type == Sensor.TYPE_PRESSURE) {
            val pressure = event.values[0]
            if (pressure in 300f..1100f) {
                val prevP = smoothedPressureHpa
                val nextP = if (prevP == null) pressure else prevP + 0.12f * (pressure - prevP)
                smoothedPressureHpa = nextP
                val alt = SensorManager.getAltitude(SensorManager.PRESSURE_STANDARD_ATMOSPHERE, nextP).toDouble()
                currentBaroAlt = alt
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}
