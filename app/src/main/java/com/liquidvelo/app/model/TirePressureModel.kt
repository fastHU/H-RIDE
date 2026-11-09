package com.liquidvelo.app.model

import kotlin.math.pow
import kotlin.math.roundToInt

enum class BikeDiscipline(val displayName: String) {
    MTB("山地车"),
    ROAD("公路车")
}

enum class MtbCasing(val displayName: String, val factor: Float) {
    TUBELESS("真空胎系统 (Tubeless)", 1.00f),
    CUSHCORE("真空胎带防爆内衬 (Insert)", 0.92f),
    WITH_TUBE("带内胎系统 (Tube)", 1.10f)
}

enum class TrailTerrain(val displayName: String, val factor: Float) {
    FLOW_TRAIL("硬质林道 (Flow Trail)", 1.02f),
    ROOTS_ROCKS("碎石树根 (Roots & Rocks)", 0.98f),
    WET_MUDDY("湿滑泥泞 (Wet & Mud)", 0.92f),
    ROCK_GARDEN("重度岩石速降 (Enduro / DH)", 1.06f)
}

enum class RoadCasing(val displayName: String, val factor: Float) {
    TUBELESS("真空胎系统 (Tubeless)", 1.00f),
    TPU_LATEX("开口胎配 TPU / 乳胶内胎", 1.04f),
    BUTYL_TUBE("开口胎配普通丁基内胎", 1.09f),
    TUBULAR("竞技管胎系统 (Tubular)", 1.03f)
}

enum class RoadCondition(val displayName: String, val factor: Float) {
    SMOOTH_TARMAC("平整铺装沥青 (Smooth Tarmac)", 1.02f),
    ROUGH_ASPHALT("粗糙磨耗柏油 (Rough Asphalt)", 0.96f),
    WET_ROAD("湿滑微雨路面 (Wet Road)", 0.92f),
    COBBLE_MIXED("石板与混合铺装 (Cobble / Mixed)", 0.88f)
}

data class TirePressureResult(
    val frontPsi: Float,
    val rearPsi: Float,
    val frontBar: Float,
    val rearBar: Float
)

object TirePressureCalculator {
    /**
     * Professional Mountain Bike (MTB) Low-Pressure Pneumatic Dynamics.
     * Mountain bike tires have massive air volumes (2.1" - 2.6") operating at low pressures.
     * 25 PSI is already noticeably hard for an MTB.
     * Front/Rear distribution: 42% Front / 58% Rear.
     * Bike weight supports up to 30.0kg (covering modern full-power e-MTB).
     */
    fun calculateMtb(
        riderWeightKg: Float,
        bikeWeightKg: Float,
        tireWidthInches: Float,
        casing: MtbCasing,
        terrain: TrailTerrain
    ): TirePressureResult {
        val totalWeight = riderWeightKg + bikeWeightKg
        val refWeight = 85.0 // Reference: 72kg rider + 13kg bike

        // Weight scaling factor (sublinear 0.85 power)
        val weightFactor = (totalWeight.toDouble() / refWeight).pow(0.85)

        // Tire width volume factor (reference 2.35"): wider tires need less pressure
        val widthFactor = (2.35 / tireWidthInches.toDouble()).pow(1.20)

        // Base calibrated MTB values for 85kg on 2.35" tubeless:
        // Front: 19.5 PSI, Rear: 22.0 PSI
        val baseFrontPsi = 19.5
        val baseRearPsi = 22.0

        val envMultiplier = casing.factor * terrain.factor

        var frontPsi = (baseFrontPsi * weightFactor * widthFactor * envMultiplier).toFloat()
        var rearPsi = (baseRearPsi * weightFactor * widthFactor * envMultiplier).toFloat()

        // Clamp to physical Mountain Bike boundaries (14.0 PSI to 32.0 PSI; 25 PSI is already noticeably stiff)
        val clampedFrontPsi = (frontPsi.coerceIn(14.0f, 30.0f) * 10f).roundToInt() / 10f
        val clampedRearPsi = (rearPsi.coerceIn(16.0f, 32.0f) * 10f).roundToInt() / 10f

        val frontBar = ((clampedFrontPsi * 0.0689476f) * 100f).roundToInt() / 100f
        val rearBar = ((clampedRearPsi * 0.0689476f) * 100f).roundToInt() / 100f

        return TirePressureResult(
            frontPsi = clampedFrontPsi,
            rearPsi = clampedRearPsi,
            frontBar = frontBar,
            rearBar = rearBar
        )
    }

    /**
     * Professional Road Bike Pneumatic Dynamics (based on SRAM/Silca/Zipp impedance models).
     * Road tires operate at higher pressures (45 - 95 PSI) on narrow casings (25c - 32c).
     * Front/Rear weight distribution: 46% Front / 54% Rear.
     * Reference: 78kg total on 28c Tubeless -> Front ~64 PSI, Rear ~68 PSI.
     */
    fun calculateRoad(
        riderWeightKg: Float,
        bikeWeightKg: Float,
        tireWidthMm: Int, // 25, 28, 30, 32
        casing: RoadCasing,
        condition: RoadCondition
    ): TirePressureResult {
        val totalWeight = riderWeightKg + bikeWeightKg
        val refWeight = 78.0 // 70kg rider + 8kg road bike

        val weightFactor = (totalWeight.toDouble() / refWeight).pow(0.88)

        // Width factor reference: 28mm
        val widthFactor = (28.0 / tireWidthMm.toDouble()).pow(1.50)

        // Baseline for 78kg on 28c tubeless on smooth tarmac
        val baseFrontPsi = 64.0
        val baseRearPsi = 68.5

        val envMultiplier = casing.factor * condition.factor

        val frontPsi = (baseFrontPsi * weightFactor * widthFactor * envMultiplier).toFloat()
        val rearPsi = (baseRearPsi * weightFactor * widthFactor * envMultiplier).toFloat()

        // Clamp to safe Road Bike boundaries (38.0 PSI to 110.0 PSI)
        val clampedFrontPsi = (frontPsi.coerceIn(38.0f, 105.0f) * 10f).roundToInt() / 10f
        val clampedRearPsi = (rearPsi.coerceIn(42.0f, 110.0f) * 10f).roundToInt() / 10f

        val frontBar = ((clampedFrontPsi * 0.0689476f) * 100f).roundToInt() / 100f
        val rearBar = ((clampedRearPsi * 0.0689476f) * 100f).roundToInt() / 100f

        return TirePressureResult(
            frontPsi = clampedFrontPsi,
            rearPsi = clampedRearPsi,
            frontBar = frontBar,
            rearBar = rearBar
        )
    }

    // Keep backwards-compatibility alias for MTB
    fun calculate(
        riderWeightKg: Float,
        bikeWeightKg: Float,
        tireWidthInches: Float,
        casing: MtbCasing,
        terrain: TrailTerrain
    ): TirePressureResult = calculateMtb(riderWeightKg, bikeWeightKg, tireWidthInches, casing, terrain)
}
