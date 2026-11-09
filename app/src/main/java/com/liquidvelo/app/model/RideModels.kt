package com.liquidvelo.app.model

import java.io.Serializable
import java.util.UUID

data class RideTrackPoint(
    val latitude: Double,
    val longitude: Double,
    val altitude: Double,
    val speedKmh: Float,
    val timestamp: Long,
    val gX: Float = 0f,
    val gY: Float = 0f,
    val gZ: Float = 1f,
    val totalG: Float = 1f
) : Serializable

data class RideRecord(
    val id: String = UUID.randomUUID().toString(),
    var title: String = "晨间巡航记录",
    val startTime: Long = System.currentTimeMillis(),
    val endTime: Long = System.currentTimeMillis(),
    val durationSeconds: Long = 0L,
    val distanceKm: Double = 0.0,
    val avgSpeedKmh: Double = 0.0,
    val maxSpeedKmh: Double = 0.0,
    val elevationGainM: Double = 0.0,
    val maxAltitudeM: Double = 0.0,
    val minAltitudeM: Double = 0.0,
    val maxGForce: Float = 1.0f,
    val avgGForce: Float = 1.0f,
    val points: List<RideTrackPoint> = emptyList()
) : Serializable

data class LiveRideState(
    val isRiding: Boolean = false,
    val isPaused: Boolean = false,
    val currentSpeedKmh: Float = 0f,
    val distanceKm: Double = 0.0,
    val elapsedSeconds: Long = 0L,
    val currentAltitudeM: Double = 0.0,
    val elevationGainM: Double = 0.0,
    val gX: Float = 0f,
    val gY: Float = 0f,
    val gZ: Float = 1.0f,
    val totalG: Float = 1.0f,
    val maxG: Float = 1.0f,
    val maxSpeedKmh: Float = 0f,
    val trackPoints: List<RideTrackPoint> = emptyList()
)
