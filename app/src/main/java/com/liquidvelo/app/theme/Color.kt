package com.liquidvelo.app.theme

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

val MatteObsidian = Color(0xFF0C0E12)
val PureTitanium = Color(0xFFFAF8F5)
val WarmCream = Color(0xFFEBE5DA)

val GlassSurfaceDark = Color(0xFF14171E)
val TextPrimaryLight = Color(0xFFFAF8F5)
val TextSecondaryMuted = Color(0xFF8E95A2)
val TextDim = Color(0xFF565E6D)

val SignalSafeGreen = Color(0xFF34C759)
val SignalWarningAmber = Color(0xFFFF9500)
val SignalDangerRed = Color(0xFFFF3B30)
val SignalGpsActive = Color(0xFF30D158)

enum class ThemePreset(val displayName: String, val subtitle: String) {
    TITANIUM_CREAM("极简钛金米白", "曜石深空黑配温润钛金米白，高阶安卓原生质感"),
    MONOCHROME_PURE("纯粹黑白高对比", "极限纯黑配纯净冷白，极简无反光视觉")
}

data class AccentOption(val name: String, val color: Color, val hex: String)

val DefaultAccents = listOf(
    AccentOption("钛金米白", Color(0xFFEBE5DA), "#EBE5DA"),
    AccentOption("冰川纯白", Color(0xFFFFFFFF), "#FFFFFF"),
    AccentOption("竞速暗红", Color(0xFFFF3B30), "#FF3B30"),
    AccentOption("赛道暖金", Color(0xFFF59E0B), "#F59E0B"),
    AccentOption("破风冰青", Color(0xFF00E5FF), "#00E5FF"),
    AccentOption("极速翠绿", Color(0xFF30D158), "#30D158")
)

val AvailableAccents: List<AccentOption> get() = ThemeManager.quickAccents

data class ThemePalette(
    val background: Color,
    val surface: Color,
    val surfaceContainer: Color,
    val surfaceContainerHigh: Color,
    val surfaceContainerHighest: Color,
    val primaryText: Color,
    val secondaryText: Color,
    val accent: Color,
    val secondaryAccent: Color,
    val onAccent: Color,
    val borderHighlight: Color
)

fun parseHexColor(input: String?): Color? {
    if (input.isNullOrBlank()) return null
    val clean = input.trim()
    if (!clean.startsWith("#")) return null
    val hex = clean.substring(1)
    return try {
        when (hex.length) {
            3 -> { // #RGB -> #RRGGBB
                val r = hex[0].toString().repeat(2).toInt(16)
                val g = hex[1].toString().repeat(2).toInt(16)
                val b = hex[2].toString().repeat(2).toInt(16)
                Color(r, g, b)
            }
            6 -> { // #RRGGBB
                val r = hex.substring(0, 2).toInt(16)
                val g = hex.substring(2, 4).toInt(16)
                val b = hex.substring(4, 6).toInt(16)
                Color(r, g, b)
            }
            8 -> { // #AARRGGBB
                val a = hex.substring(0, 2).toInt(16)
                val r = hex.substring(2, 4).toInt(16)
                val g = hex.substring(4, 6).toInt(16)
                val b = hex.substring(6, 8).toInt(16)
                Color(r, g, b, a)
            }
            else -> null
        }
    } catch (e: Throwable) {
        null
    }
}

object ThemeManager {
    private const val PREFS_NAME = "h_ride_theme_settings"
    private const val KEY_PRESET = "theme_preset"
    private const val KEY_MAX_SPEED = "max_speed_limit"
    private const val KEY_CUSTOM_HEX_1 = "custom_hex_1"
    private const val KEY_CUSTOM_HEX_2 = "custom_hex_2"
    private const val KEY_CUSTOM_HEX_3 = "custom_hex_3"
    private const val KEY_CUSTOM_ACTIVE = "custom_theme_active"
    private const val KEY_SPEEDO_BG_PATH = "speedometer_bg_path"
    private const val KEY_SPEEDO_BG_IS_VIDEO = "speedometer_bg_is_video"
    private const val KEY_QUICK_ACCENTS = "quick_accents_list"

    var currentPreset by mutableStateOf(ThemePreset.TITANIUM_CREAM)
    var customAccent by mutableStateOf<Color?>(null)
    var maxSpeedSetting by mutableIntStateOf(50)

    var quickAccents by mutableStateOf(DefaultAccents)

    var customHex1 by mutableStateOf("#EBE5DA") // Primary Accent
    var customHex2 by mutableStateOf("#00E5FF") // Secondary Highlight
    var customHex3 by mutableStateOf("#1A1E28") // Surface Container
    var isCustomThemeActive by mutableStateOf(false)

    var speedometerBgPath by mutableStateOf<String?>(null)
    var speedometerBgIsVideo by mutableStateOf(false)

    fun init(context: Context) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val presetName = prefs.getString(KEY_PRESET, ThemePreset.TITANIUM_CREAM.name)
        currentPreset = try {
            ThemePreset.valueOf(presetName ?: ThemePreset.TITANIUM_CREAM.name)
        } catch (e: Exception) {
            ThemePreset.TITANIUM_CREAM
        }
        maxSpeedSetting = prefs.getInt(KEY_MAX_SPEED, 50)
        customHex1 = prefs.getString(KEY_CUSTOM_HEX_1, "#EBE5DA") ?: "#EBE5DA"
        customHex2 = prefs.getString(KEY_CUSTOM_HEX_2, "#00E5FF") ?: "#00E5FF"
        customHex3 = prefs.getString(KEY_CUSTOM_HEX_3, "#1A1E28") ?: "#1A1E28"
        isCustomThemeActive = prefs.getBoolean(KEY_CUSTOM_ACTIVE, false)
        if (isCustomThemeActive) {
            customAccent = parseHexColor(customHex1)
        }
        speedometerBgPath = prefs.getString(KEY_SPEEDO_BG_PATH, null)
        speedometerBgIsVideo = prefs.getBoolean(KEY_SPEEDO_BG_IS_VIDEO, false)

        val savedAccents = prefs.getString(KEY_QUICK_ACCENTS, null)
        if (!savedAccents.isNullOrBlank()) {
            val list = mutableListOf<AccentOption>()
            savedAccents.split(";").forEach { item ->
                val parts = item.split(",")
                if (parts.size >= 2) {
                    val name = parts[0]
                    val hex = parts[1]
                    val col = parseHexColor(hex)
                    if (col != null) {
                        list.add(AccentOption(name, col, hex))
                    }
                }
            }
            if (list.isNotEmpty()) {
                quickAccents = list.take(6)
            }
        }
    }

    fun removeQuickAccent(index: Int, context: Context) {
        if (index in quickAccents.indices && quickAccents.size > 1) {
            val list = quickAccents.toMutableList()
            list.removeAt(index)
            quickAccents = list
            saveQuickAccents(context)
        }
    }

    fun addQuickAccent(hex: String, context: Context): Boolean {
        val color = parseHexColor(hex) ?: return false
        if (quickAccents.size < 6) {
            val formattedHex = if (hex.startsWith("#")) hex.uppercase() else "#${hex.uppercase()}"
            val newOpt = AccentOption("自定义", color, formattedHex)
            quickAccents = quickAccents + newOpt
            saveQuickAccents(context)
            return true
        }
        return false
    }

    private fun saveQuickAccents(context: Context) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val joined = quickAccents.joinToString(";") { "${it.name},${it.hex}" }
        prefs.edit().putString(KEY_QUICK_ACCENTS, joined).apply()
    }

    fun setSpeedometerBackground(path: String?, isVideo: Boolean, context: Context) {
        speedometerBgPath = path
        speedometerBgIsVideo = isVideo
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit()
            .putString(KEY_SPEEDO_BG_PATH, path)
            .putBoolean(KEY_SPEEDO_BG_IS_VIDEO, isVideo)
            .apply()
    }

    fun clearSpeedometerBackground(context: Context) {
        speedometerBgPath = null
        speedometerBgIsVideo = false
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit()
            .remove(KEY_SPEEDO_BG_PATH)
            .remove(KEY_SPEEDO_BG_IS_VIDEO)
            .apply()
    }

    fun applyCustomHexColors(hex1: String, hex2: String, hex3: String, context: Context): Boolean {
        val c1 = parseHexColor(hex1)
        val c2 = parseHexColor(hex2)
        val c3 = parseHexColor(hex3)
        if (c1 != null || c2 != null || c3 != null) {
            if (c1 != null) customHex1 = hex1
            if (c2 != null) customHex2 = hex2
            if (c3 != null) customHex3 = hex3
            isCustomThemeActive = true
            customAccent = c1 ?: parseHexColor(customHex1)
            val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            prefs.edit()
                .putString(KEY_CUSTOM_HEX_1, customHex1)
                .putString(KEY_CUSTOM_HEX_2, customHex2)
                .putString(KEY_CUSTOM_HEX_3, customHex3)
                .putBoolean(KEY_CUSTOM_ACTIVE, true)
                .apply()
            return true
        }
        return false
    }

    fun setPreset(preset: ThemePreset, context: Context) {
        currentPreset = preset
        isCustomThemeActive = false
        customAccent = null
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit()
            .putString(KEY_PRESET, preset.name)
            .putBoolean(KEY_CUSTOM_ACTIVE, false)
            .apply()
    }

    fun setQuickAccent(option: AccentOption, context: Context) {
        customAccent = option.color
        customHex1 = option.hex
        isCustomThemeActive = true
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit()
            .putString(KEY_CUSTOM_HEX_1, option.hex)
            .putBoolean(KEY_CUSTOM_ACTIVE, true)
            .apply()
    }

    fun setMaxSpeed(limit: Int, context: Context) {
        maxSpeedSetting = limit
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putInt(KEY_MAX_SPEED, limit).apply()
    }

    fun getActivePalette(): ThemePalette {
        val baseAccent = when (currentPreset) {
            ThemePreset.TITANIUM_CREAM -> Color(0xFFEBE5DA)
            ThemePreset.MONOCHROME_PURE -> Color(0xFFFFFFFF)
        }

        val primaryColor = if (isCustomThemeActive) {
            parseHexColor(customHex1) ?: (customAccent ?: baseAccent)
        } else {
            customAccent ?: baseAccent
        }

        val secondaryColor = if (isCustomThemeActive) {
            parseHexColor(customHex2) ?: Color(0xFF00E5FF)
        } else {
            primaryColor
        }

        val customSurfaceColor = if (isCustomThemeActive) {
            parseHexColor(customHex3)
        } else null

        val computedOnAccent = if (primaryColor.luminance() > 0.38f) {
            Color(0xFF0C0E12)
        } else {
            Color(0xFFFFFFFF)
        }

        val defaultSurface = when (currentPreset) {
            ThemePreset.TITANIUM_CREAM -> Color(0xFF151820)
            ThemePreset.MONOCHROME_PURE -> Color(0xFF121214)
        }
        val defaultSurfaceContainer = when (currentPreset) {
            ThemePreset.TITANIUM_CREAM -> Color(0xFF1A1E28)
            ThemePreset.MONOCHROME_PURE -> Color(0xFF19191C)
        }
        val defaultSurfaceContainerHigh = when (currentPreset) {
            ThemePreset.TITANIUM_CREAM -> Color(0xFF232834)
            ThemePreset.MONOCHROME_PURE -> Color(0xFF222226)
        }
        val defaultSurfaceContainerHighest = when (currentPreset) {
            ThemePreset.TITANIUM_CREAM -> Color(0xFF2D3342)
            ThemePreset.MONOCHROME_PURE -> Color(0xFF2C2C32)
        }

        val surfaceColor = customSurfaceColor ?: defaultSurface
        val containerColor = customSurfaceColor ?: defaultSurfaceContainer
        val containerHighColor = if (customSurfaceColor != null) {
            customSurfaceColor.copy(alpha = 0.92f)
        } else defaultSurfaceContainerHigh
        val containerHighestColor = if (customSurfaceColor != null) {
            customSurfaceColor.copy(alpha = 0.85f)
        } else defaultSurfaceContainerHighest

        return ThemePalette(
            background = if (currentPreset == ThemePreset.MONOCHROME_PURE) Color(0xFF000000) else Color(0xFF0C0E12),
            surface = surfaceColor,
            surfaceContainer = containerColor,
            surfaceContainerHigh = containerHighColor,
            surfaceContainerHighest = containerHighestColor,
            primaryText = Color(0xFFFAF8F5),
            secondaryText = Color(0xFF949BA8),
            accent = primaryColor,
            secondaryAccent = secondaryColor,
            onAccent = computedOnAccent,
            borderHighlight = Color(0x18FFFFFF)
        )
    }
}
