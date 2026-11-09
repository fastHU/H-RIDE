package com.liquidvelo.app.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.liquidvelo.app.model.RideRecord
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.File

class RideRepository(private val context: Context) {
    private val gson = Gson()
    private val file = File(context.filesDir, "rides_store.json")

    private val _ridesFlow = MutableStateFlow<List<RideRecord>>(emptyList())
    val ridesFlow: StateFlow<List<RideRecord>> = _ridesFlow.asStateFlow()

    init {
        loadRides()
    }

    private fun loadRides() {
        if (file.exists()) {
            try {
                val json = file.readText()
                val type = object : TypeToken<List<RideRecord>>() {}.type
                val loaded: List<RideRecord>? = gson.fromJson(json, type)
                if (loaded != null) {
                    // Filter out any legacy dummy seed items if present
                    val filtered = loaded.filterNot {
                        it.title == "外滩滨江沿线晨巡破风" ||
                        it.title == "西湖龙井龙井路爬坡训练" ||
                        it.title.contains("晨间巡航记录")
                    }
                    _ridesFlow.value = filtered
                    if (filtered.size != loaded.size) {
                        persist()
                    }
                    return
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        // Completely empty on fresh download
        _ridesFlow.value = emptyList()
    }

    fun saveRide(record: RideRecord) {
        val updated = ArrayList(_ridesFlow.value)
        updated.add(0, record)
        _ridesFlow.value = updated
        persist()
    }

    fun renameRide(id: String, newTitle: String) {
        val updated = _ridesFlow.value.map {
            if (it.id == id) it.copy(title = newTitle.trim()) else it
        }
        _ridesFlow.value = updated
        persist()
    }

    fun deleteRide(id: String) {
        val updated = _ridesFlow.value.filterNot { it.id == id }
        _ridesFlow.value = updated
        persist()
    }

    fun getRideById(id: String): RideRecord? {
        return _ridesFlow.value.find { it.id == id }
    }

    private fun persist() {
        try {
            val json = gson.toJson(_ridesFlow.value)
            file.writeText(json)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
