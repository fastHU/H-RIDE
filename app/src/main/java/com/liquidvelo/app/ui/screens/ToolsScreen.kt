package com.liquidvelo.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.liquidvelo.app.model.BikeDiscipline
import com.liquidvelo.app.model.MtbCasing
import com.liquidvelo.app.model.RoadCasing
import com.liquidvelo.app.model.RoadCondition
import com.liquidvelo.app.model.TirePressureCalculator
import com.liquidvelo.app.model.TrailTerrain
import com.liquidvelo.app.theme.LocalThemePalette
import java.util.Locale
import kotlin.math.roundToInt

@Composable
fun ToolsScreen(modifier: Modifier = Modifier) {
    val palette = LocalThemePalette.current

    var selectedDiscipline by remember { mutableStateOf(BikeDiscipline.MTB) }

    var riderWeight by remember { mutableFloatStateOf(70f) }
    var bikeWeightMtb by remember { mutableFloatStateOf(14.0f) }
    var bikeWeightRoad by remember { mutableFloatStateOf(8.2f) }

    // MTB Specific parameters
    var selectedMtbWidth by remember { mutableFloatStateOf(2.35f) }
    var selectedMtbCasing by remember { mutableStateOf(MtbCasing.TUBELESS) }
    var selectedMtbTerrain by remember { mutableStateOf(TrailTerrain.ROOTS_ROCKS) }

    // Road Bike Specific parameters
    var selectedRoadWidthMm by remember { mutableIntStateOf(28) } // 25, 28, 30, 32
    var selectedRoadCasing by remember { mutableStateOf(RoadCasing.TUBELESS) }
    var selectedRoadCondition by remember { mutableStateOf(RoadCondition.SMOOTH_TARMAC) }

    val activeBikeWeight = if (selectedDiscipline == BikeDiscipline.MTB) bikeWeightMtb else bikeWeightRoad

    val pressureResult = remember(
        selectedDiscipline,
        riderWeight,
        activeBikeWeight,
        selectedMtbWidth,
        selectedMtbCasing,
        selectedMtbTerrain,
        selectedRoadWidthMm,
        selectedRoadCasing,
        selectedRoadCondition
    ) {
        if (selectedDiscipline == BikeDiscipline.MTB) {
            TirePressureCalculator.calculateMtb(
                riderWeightKg = riderWeight,
                bikeWeightKg = bikeWeightMtb,
                tireWidthInches = selectedMtbWidth,
                casing = selectedMtbCasing,
                terrain = selectedMtbTerrain
            )
        } else {
            TirePressureCalculator.calculateRoad(
                riderWeightKg = riderWeight,
                bikeWeightKg = bikeWeightRoad,
                tireWidthMm = selectedRoadWidthMm,
                casing = selectedRoadCasing,
                condition = selectedRoadCondition
            )
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(palette.background)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            contentPadding = PaddingValues(top = 54.dp, bottom = 120.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // TOP HEADER: Title "胎压测算" on left, Discipline Toggle on right
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "胎压测算",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = palette.primaryText
                    )

                    // Road / MTB Switch Pills
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(palette.surfaceContainer)
                            .padding(3.dp),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        BikeDiscipline.values().forEach { discipline ->
                            val isSel = selectedDiscipline == discipline
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(13.dp))
                                    .background(if (isSel) palette.accent else palette.surfaceContainerHigh)
                                    .clickable { selectedDiscipline = discipline }
                                    .padding(horizontal = 14.dp, vertical = 7.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = discipline.displayName,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isSel) palette.onAccent else palette.primaryText
                                )
                            }
                        }
                    }
                }
            }

            // Dual Result Cards: Front and Rear
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    PressureResultCard(
                        title = "前轮推荐气压",
                        psi = pressureResult.frontPsi,
                        bar = pressureResult.frontBar,
                        modifier = Modifier.weight(1f)
                    )

                    PressureResultCard(
                        title = "后轮推荐气压",
                        psi = pressureResult.rearPsi,
                        bar = pressureResult.rearBar,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            // Calculation Inputs Container (Material 3 Surface)
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(24.dp))
                        .background(palette.surface)
                        .padding(20.dp)
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(22.dp)) {

                        // 1. Rider Weight Stepper + Slider (Symmetrical layout)
                        Column {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "骑手体重",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = palette.primaryText
                                )
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    WeightStepperButton(icon = Icons.Rounded.Remove) {
                                        if (riderWeight > 40f) riderWeight -= 1f
                                    }
                                    Text(
                                        text = "${riderWeight.roundToInt()} kg",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily.Monospace,
                                        color = palette.accent,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.width(80.dp)
                                    )
                                    WeightStepperButton(icon = Icons.Rounded.Add) {
                                        if (riderWeight < 125f) riderWeight += 1f
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(6.dp))
                            Slider(
                                value = riderWeight,
                                onValueChange = { riderWeight = (it * 10f).roundToInt() / 10f },
                                valueRange = 40f..125f,
                                colors = SliderDefaults.colors(
                                    thumbColor = palette.accent,
                                    activeTrackColor = palette.accent,
                                    inactiveTrackColor = palette.surfaceContainerHighest
                                )
                            )
                        }

                        // 2. Bike Weight Stepper + Slider (Symmetrical and identical button sizes, strictly "整车重量")
                        Column {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "整车重量",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = palette.primaryText
                                )
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    WeightStepperButton(icon = Icons.Rounded.Remove) {
                                        if (selectedDiscipline == BikeDiscipline.MTB) {
                                            if (bikeWeightMtb > 8.0f) bikeWeightMtb = ((bikeWeightMtb - 0.5f) * 10f).roundToInt() / 10f
                                        } else {
                                            if (bikeWeightRoad > 5.5f) bikeWeightRoad = ((bikeWeightRoad - 0.2f) * 10f).roundToInt() / 10f
                                        }
                                    }
                                    Text(
                                        text = String.format(Locale.US, "%.1f kg", activeBikeWeight),
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily.Monospace,
                                        color = palette.primaryText,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.width(80.dp)
                                    )
                                    WeightStepperButton(icon = Icons.Rounded.Add) {
                                        if (selectedDiscipline == BikeDiscipline.MTB) {
                                            if (bikeWeightMtb < 30.0f) bikeWeightMtb = ((bikeWeightMtb + 0.5f) * 10f).roundToInt() / 10f
                                        } else {
                                            if (bikeWeightRoad < 16.0f) bikeWeightRoad = ((bikeWeightRoad + 0.2f) * 10f).roundToInt() / 10f
                                        }
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(6.dp))
                            val bikeRange = if (selectedDiscipline == BikeDiscipline.MTB) 8.0f..30.0f else 5.5f..16.0f
                            Slider(
                                value = activeBikeWeight.coerceIn(bikeRange.start, bikeRange.endInclusive),
                                onValueChange = {
                                    val rounded = (it * 10f).roundToInt() / 10f
                                    if (selectedDiscipline == BikeDiscipline.MTB) {
                                        bikeWeightMtb = rounded
                                    } else {
                                        bikeWeightRoad = rounded
                                    }
                                },
                                valueRange = bikeRange,
                                colors = SliderDefaults.colors(
                                    thumbColor = palette.primaryText,
                                    activeTrackColor = palette.primaryText,
                                    inactiveTrackColor = palette.surfaceContainerHighest
                                )
                            )
                        }

                        // 3. Tire Width Selector (MTB in inches vs Road in mm/c)
                        if (selectedDiscipline == BikeDiscipline.MTB) {
                            Column {
                                Text(
                                    text = "外胎胎宽 (英寸)",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = palette.primaryText
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    listOf(2.10f, 2.25f, 2.35f, 2.40f, 2.50f, 2.60f).forEach { widthInches ->
                                        val isSelected = selectedMtbWidth == widthInches
                                        Box(
                                            modifier = Modifier
                                                .weight(1f)
                                                .clip(RoundedCornerShape(14.dp))
                                                .background(if (isSelected) palette.accent else palette.surfaceContainerHigh)
                                                .clickable { selectedMtbWidth = widthInches }
                                                .padding(vertical = 11.dp),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = "${widthInches}\"",
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold,
                                                fontFamily = FontFamily.Monospace,
                                                color = if (isSelected) palette.onAccent else palette.primaryText
                                            )
                                        }
                                    }
                                }
                            }
                        } else {
                            Column {
                                Text(
                                    text = "外胎胎宽规格",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = palette.primaryText
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    listOf(25, 28, 30, 32).forEach { widthMm ->
                                        val isSelected = selectedRoadWidthMm == widthMm
                                        Box(
                                            modifier = Modifier
                                                .weight(1f)
                                                .clip(RoundedCornerShape(14.dp))
                                                .background(if (isSelected) palette.accent else palette.surfaceContainerHigh)
                                                .clickable { selectedRoadWidthMm = widthMm }
                                                .padding(vertical = 11.dp),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = "${widthMm}c",
                                                fontSize = 13.sp,
                                                fontWeight = FontWeight.Bold,
                                                fontFamily = FontFamily.Monospace,
                                                color = if (isSelected) palette.onAccent else palette.primaryText
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        // 4. Casing / System Selector
                        Column {
                            Text(
                                text = "轮胎胎体系统",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = palette.primaryText
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                if (selectedDiscipline == BikeDiscipline.MTB) {
                                    MtbCasing.values().forEach { casing ->
                                        val isSelected = selectedMtbCasing == casing
                                        SelectionOptionRow(
                                            label = casing.displayName,
                                            isSelected = isSelected,
                                            onClick = { selectedMtbCasing = casing }
                                        )
                                    }
                                } else {
                                    RoadCasing.values().forEach { casing ->
                                        val isSelected = selectedRoadCasing == casing
                                        SelectionOptionRow(
                                            label = casing.displayName,
                                            isSelected = isSelected,
                                            onClick = { selectedRoadCasing = casing }
                                        )
                                    }
                                }
                            }
                        }

                        // 5. Road / Trail Conditions Selector
                        Column {
                            Text(
                                text = if (selectedDiscipline == BikeDiscipline.MTB) "骑行林道路况" else "铺装道路工况",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = palette.primaryText
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                if (selectedDiscipline == BikeDiscipline.MTB) {
                                    TrailTerrain.values().forEach { terrain ->
                                        val isSelected = selectedMtbTerrain == terrain
                                        SelectionOptionRow(
                                            label = terrain.displayName,
                                            isSelected = isSelected,
                                            onClick = { selectedMtbTerrain = terrain }
                                        )
                                    }
                                } else {
                                    RoadCondition.values().forEach { condition ->
                                        val isSelected = selectedRoadCondition == condition
                                        SelectionOptionRow(
                                            label = condition.displayName,
                                            isSelected = isSelected,
                                            onClick = { selectedRoadCondition = condition }
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SelectionOptionRow(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val palette = LocalThemePalette.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(if (isSelected) palette.accent else palette.surfaceContainerHigh)
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = 13.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
            color = if (isSelected) palette.onAccent else palette.primaryText
        )
        if (isSelected) {
            Icon(
                imageVector = Icons.Rounded.Check,
                contentDescription = null,
                tint = palette.onAccent,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
private fun PressureResultCard(
    title: String,
    psi: Float,
    bar: Float,
    modifier: Modifier = Modifier
) {
    val palette = LocalThemePalette.current
    val unitWidth = 26.dp

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .background(palette.surface)
            .padding(vertical = 18.dp, horizontal = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = title,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = palette.secondaryText
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Symmetric Row: left spacer equals right unit width, ensuring numeric value is centered precisely
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.width(unitWidth))

                Text(
                    text = String.format(Locale.US, "%.1f", psi),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    color = palette.primaryText
                )

                Text(
                    text = "psi",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.Monospace,
                    color = palette.accent,
                    modifier = Modifier
                        .width(unitWidth)
                        .padding(start = 3.dp, bottom = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = String.format(Locale.US, "%.2f bar", bar),
                fontSize = 12.sp,
                fontFamily = FontFamily.Monospace,
                color = palette.secondaryText
            )
        }
    }
}

@Composable
private fun WeightStepperButton(
    icon: ImageVector,
    onClick: () -> Unit
) {
    val palette = LocalThemePalette.current
    Box(
        modifier = Modifier
            .size(36.dp)
            .clip(CircleShape)
            .background(palette.surfaceContainerHigh)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = palette.primaryText,
            modifier = Modifier.size(16.dp)
        )
    }
}
