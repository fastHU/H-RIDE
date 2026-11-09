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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.DeleteOutline
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.liquidvelo.app.data.RideRepository
import com.liquidvelo.app.model.RideRecord
import com.liquidvelo.app.theme.LocalThemePalette
import com.liquidvelo.app.theme.SignalDangerRed
import com.liquidvelo.app.ui.components.ElevationChart
import com.liquidvelo.app.ui.components.GForceRadarView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun HistoryScreen(
    repository: RideRepository,
    modifier: Modifier = Modifier
) {
    val palette = LocalThemePalette.current
    val focusManager = LocalFocusManager.current
    val rides by repository.ridesFlow.collectAsState()
    var searchQuery by remember { mutableStateOf("") }
    var isSearchFocused by remember { mutableStateOf(false) }

    var editingRide by remember { mutableStateOf<RideRecord?>(null) }
    var selectedRideDetail by remember { mutableStateOf<RideRecord?>(null) }
    var rideToDelete by remember { mutableStateOf<RideRecord?>(null) }

    val filteredRides = remember(rides, searchQuery) {
        if (searchQuery.isBlank()) rides
        else rides.filter { it.title.contains(searchQuery, ignoreCase = true) }
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
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item {
                Text(
                    text = "骑行数据管理",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = palette.primaryText
                )
                Spacer(modifier = Modifier.height(6.dp))
            }

            // Search Bar (Hides placeholder immediately on focus so cursor NEVER overlaps placeholder text!)
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .clip(RoundedCornerShape(18.dp))
                        .background(palette.surface)
                        .padding(horizontal = 16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = "搜索",
                            tint = if (isSearchFocused) palette.accent else palette.secondaryText,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Box(
                            modifier = Modifier.weight(1f),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            if (searchQuery.isEmpty() && !isSearchFocused) {
                                Text(
                                    text = "搜索骑行记录...",
                                    fontSize = 14.sp,
                                    color = palette.secondaryText
                                )
                            }
                            BasicTextField(
                                value = searchQuery,
                                onValueChange = { searchQuery = it },
                                singleLine = true,
                                textStyle = TextStyle(
                                    color = palette.primaryText,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium
                                ),
                                cursorBrush = SolidColor(palette.accent),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .onFocusChanged { isSearchFocused = it.isFocused }
                            )
                        }
                        if (searchQuery.isNotEmpty() || isSearchFocused) {
                            Spacer(modifier = Modifier.width(8.dp))
                            Box(
                                modifier = Modifier
                                    .size(26.dp)
                                    .clip(CircleShape)
                                    .background(palette.surfaceContainerHigh)
                                    .clickable {
                                        searchQuery = ""
                                        focusManager.clearFocus()
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Close,
                                    contentDescription = "清除",
                                    tint = palette.primaryText,
                                    modifier = Modifier.size(14.dp)
                                )
                            }
                        }
                    }
                }
            }

            // Stats Quick Overview
            item {
                val totalKm = rides.sumOf { it.distanceKm }
                val maxSpeed = rides.maxOfOrNull { it.maxSpeedKmh } ?: 0.0
                val peakG = rides.maxOfOrNull { it.maxGForce } ?: 1.0f

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .background(palette.surface)
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    HistoryStatCol(label = "总记录", value = "${rides.size} 次")
                    HistoryStatCol(label = "累计距离", value = String.format(Locale.US, "%.1f km", totalKm))
                    HistoryStatCol(label = "极速", value = String.format(Locale.US, "%.1f km/h", maxSpeed))
                    HistoryStatCol(label = "历史最大G", value = String.format(Locale.US, "%.2f G", peakG), isHighlight = true)
                }
            }

            item {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "近期骑行记录 (${filteredRides.size})",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = palette.primaryText,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

            if (filteredRides.isEmpty()) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 40.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "未找到骑行数据", fontSize = 13.sp, color = palette.secondaryText)
                    }
                }
            } else {
                items(filteredRides, key = { it.id }) { record ->
                    RideRecordCard(
                        record = record,
                        onClick = { selectedRideDetail = record },
                        onRename = { editingRide = record },
                        onDelete = { rideToDelete = record }
                    )
                }
            }
        }

        // Rename Dialog
        editingRide?.let { r ->
            RenameDialog(
                currentTitle = r.title,
                onDismiss = { editingRide = null },
                onConfirm = { newTitle ->
                    repository.renameRide(r.id, newTitle)
                    editingRide = null
                }
            )
        }

        // Delete Confirmation Dialog
        rideToDelete?.let { target ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(palette.background.copy(alpha = 0.88f))
                    .clickable { rideToDelete = null },
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.86f)
                        .clickable(enabled = false) {}
                        .clip(RoundedCornerShape(24.dp))
                        .background(palette.surfaceContainer)
                        .padding(22.dp)
                ) {
                    Text(
                        text = "删除骑行记录",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = palette.primaryText
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "确定要永久删除「${target.title}」吗？此操作无法撤销。",
                        fontSize = 13.sp,
                        color = palette.secondaryText,
                        lineHeight = 18.sp
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Button(
                            onClick = { rideToDelete = null },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = palette.surfaceContainerHigh,
                                contentColor = palette.primaryText
                            ),
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text(text = "取消", fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = palette.primaryText)
                        }

                        Button(
                            onClick = {
                                repository.deleteRide(target.id)
                                rideToDelete = null
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = SignalDangerRed,
                                contentColor = palette.primaryText
                            ),
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text(text = "确认删除", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = palette.primaryText)
                        }
                    }
                }
            }
        }

        // Detail View Modal
        selectedRideDetail?.let { detail ->
            RideDetailView(
                record = detail,
                onClose = { selectedRideDetail = null }
            )
        }
    }
}

@Composable
private fun HistoryStatCol(
    label: String,
    value: String,
    isHighlight: Boolean = false
) {
    val palette = LocalThemePalette.current
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = label, fontSize = 11.sp, color = palette.secondaryText)
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = value,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            color = if (isHighlight) palette.accent else palette.primaryText
        )
    }
}

@Composable
private fun RideRecordCard(
    record: RideRecord,
    onClick: () -> Unit,
    onRename: () -> Unit,
    onDelete: () -> Unit
) {
    val palette = LocalThemePalette.current
    val dateFormat = SimpleDateFormat("MM月dd日 HH:mm", Locale.CHINA)
    val dateStr = dateFormat.format(Date(record.startTime))

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(palette.surface)
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = record.title,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = palette.primaryText
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(text = dateStr, fontSize = 11.sp, color = palette.secondaryText)
                }

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Box(
                        modifier = Modifier
                            .size(34.dp)
                            .clip(CircleShape)
                            .background(palette.surfaceContainerHigh)
                            .clickable { onRename() },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Edit,
                            contentDescription = "重命名",
                            tint = palette.primaryText,
                            modifier = Modifier.size(15.dp)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(34.dp)
                            .clip(CircleShape)
                            .background(SignalDangerRed.copy(alpha = 0.16f))
                            .clickable { onDelete() },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.DeleteOutline,
                            contentDescription = "删除",
                            tint = SignalDangerRed,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MetricItem(label = "距离", value = String.format(Locale.US, "%.2f km", record.distanceKm))
                MetricItem(label = "均速", value = String.format(Locale.US, "%.1f km/h", record.avgSpeedKmh))
                MetricItem(label = "爬升", value = "+${record.elevationGainM.toInt()}m")
                MetricItem(label = "最大 G", value = String.format(Locale.US, "%.2f G", record.maxGForce), isHighlight = true)
            }
        }
    }
}

@Composable
private fun MetricItem(
    label: String,
    value: String,
    isHighlight: Boolean = false
) {
    val palette = LocalThemePalette.current
    Column {
        Text(text = label, fontSize = 10.sp, color = palette.secondaryText)
        Text(
            text = value,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            color = if (isHighlight) palette.accent else palette.primaryText
        )
    }
}

@Composable
private fun RenameDialog(
    currentTitle: String,
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {
    val palette = LocalThemePalette.current
    var text by remember { mutableStateOf(currentTitle) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(palette.background.copy(alpha = 0.90f))
            .clickable(onClick = onDismiss),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.88f)
                .clickable(enabled = false) {}
                .clip(RoundedCornerShape(24.dp))
                .background(palette.surfaceContainer)
                .padding(22.dp)
        ) {
            Text(
                text = "重命名记录",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = palette.primaryText
            )

            Spacer(modifier = Modifier.height(14.dp))

            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = palette.accent,
                    unfocusedBorderColor = palette.surfaceContainerHighest,
                    cursorColor = palette.accent,
                    focusedTextColor = palette.primaryText,
                    unfocusedTextColor = palette.primaryText
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = onDismiss,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = palette.surfaceContainerHigh,
                        contentColor = palette.primaryText
                    ),
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = "取消",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = palette.primaryText
                    )
                }

                Button(
                    onClick = {
                        if (text.isNotBlank()) onConfirm(text)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = palette.accent,
                        contentColor = palette.onAccent
                    ),
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = "保存",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = palette.onAccent
                    )
                }
            }
        }
    }
}

@Composable
private fun RideDetailView(
    record: RideRecord,
    onClose: () -> Unit
) {
    val palette = LocalThemePalette.current
    val lastPt = record.points.lastOrNull()

    Box(
        modifier = Modifier
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
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = record.title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = palette.primaryText
                    )
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(palette.surfaceContainerHigh)
                            .clickable { onClose() },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(imageVector = Icons.Rounded.Close, contentDescription = "关闭", tint = palette.primaryText)
                    }
                }
            }

            item {
                SafeTrajectoryMinimap(
                    trackPoints = record.points,
                    currentLat = lastPt?.latitude ?: 31.2304,
                    currentLng = lastPt?.longitude ?: 121.4737,
                    hasGpsFix = true
                )
            }

            item {
                ElevationChart(
                    points = record.points,
                    elevationGainM = record.elevationGainM
                )
            }

            item {
                GForceRadarView(
                    totalG = record.avgGForce,
                    peakG = record.maxGForce
                )
            }
        }
    }
}
