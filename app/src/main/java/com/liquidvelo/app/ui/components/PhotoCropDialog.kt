package com.liquidvelo.app.ui.components

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.graphics.Paint
import android.media.ExifInterface
import android.net.Uri
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.RotateLeft
import androidx.compose.material.icons.rounded.RotateRight
import androidx.compose.material.icons.rounded.ZoomIn
import androidx.compose.material.icons.rounded.ZoomOut
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.liquidvelo.app.theme.LocalThemePalette
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

/**
 * Fullscreen Interactive Photo Crop & Rotation Dialog
 * - Supports pinch-to-zoom, panning/dragging, free rotation and 90-degree step rotations
 * - Preset to 16:9 card aspect ratio to perfectly fit and fill the profile header card
 * - Exports a high-resolution cropped bitmap directly to destination file
 */
@Composable
fun PhotoCropDialog(
    imageUri: Uri,
    targetAspectRatio: Float = 16f / 9f,
    onCropConfirmed: (File) -> Unit,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    val palette = LocalThemePalette.current
    val density = LocalDensity.current
    val scope = rememberCoroutineScope()

    var sourceBitmap by remember { mutableStateOf<Bitmap?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var isExporting by remember { mutableStateOf(false) }

    // Transformation States
    var userScale by remember { mutableFloatStateOf(1.0f) }
    var userRotation by remember { mutableFloatStateOf(0f) }
    var userOffsetX by remember { mutableFloatStateOf(0f) }
    var userOffsetY by remember { mutableFloatStateOf(0f) }

    // Load and orient source bitmap on background dispatcher
    LaunchedEffect(imageUri) {
        isLoading = true
        withContext(Dispatchers.IO) {
            sourceBitmap = loadAndOrientBitmap(context, imageUri)
        }
        isLoading = false
    }

    Dialog(
        onDismissRequest = { if (!isExporting) onDismiss() },
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            dismissOnBackPress = !isExporting,
            dismissOnClickOutside = false
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF090B0E))
                .statusBarsPadding()
                .navigationBarsPadding()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // ==========================================
                // TOP BAR: Cancel, Title, Confirm
                // ==========================================
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { if (!isExporting) onDismiss() },
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.08f))
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Close,
                            contentDescription = "取消",
                            tint = Color.White
                        )
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "裁切与旋转背景",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = "双指缩放 · 拖拽平移",
                            fontSize = 11.sp,
                            color = Color.White.copy(alpha = 0.55f)
                        )
                    }

                    Button(
                        onClick = {
                            val bmp = sourceBitmap
                            if (bmp != null && !isExporting) {
                                isExporting = true
                                scope.launch {
                                    val destFile = withContext(Dispatchers.IO) {
                                        cropAndSaveBitmap(
                                            context = context,
                                            source = bmp,
                                            aspectRatio = targetAspectRatio,
                                            userScale = userScale,
                                            userRotation = userRotation,
                                            userOffsetX = userOffsetX,
                                            userOffsetY = userOffsetY
                                        )
                                    }
                                    isExporting = false
                                    if (destFile != null) {
                                        onCropConfirmed(destFile)
                                    } else {
                                        onDismiss()
                                    }
                                }
                            }
                        },
                        enabled = !isLoading && !isExporting && sourceBitmap != null,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = palette.accent,
                            contentColor = palette.onAccent
                        ),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        if (isExporting) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(16.dp),
                                strokeWidth = 2.dp,
                                color = palette.onAccent
                            )
                        } else {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Rounded.Done,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "完成",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }

                // ==========================================
                // MIDDLE: INTERACTIVE CROP VIEWPORT
                // ==========================================
                BoxWithConstraints(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    val maxWidthPx = constraints.maxWidth.toFloat()
                    val maxHeightPx = constraints.maxHeight.toFloat()

                    // Compute maximum fitting crop frame maintaining targetAspectRatio
                    val frameWidthPx = min(maxWidthPx - 32f, maxHeightPx * targetAspectRatio - 32f).coerceAtLeast(100f)
                    val frameHeightPx = frameWidthPx / targetAspectRatio

                    val frameWidthDp = with(density) { frameWidthPx.toDp() }
                    val frameHeightDp = with(density) { frameHeightPx.toDp() }

                    if (isLoading || sourceBitmap == null) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            CircularProgressIndicator(color = palette.accent)
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = "正在解析高质量图像...",
                                fontSize = 13.sp,
                                color = Color.White.copy(alpha = 0.65f)
                            )
                        }
                    } else {
                        val bmp = sourceBitmap!!

                        // Base scale factor so image initially covers the viewport completely
                        val baseScale = max(
                            frameWidthPx / bmp.width.toFloat(),
                            frameHeightPx / bmp.height.toFloat()
                        )

                        Box(
                            modifier = Modifier
                                .size(frameWidthDp, frameHeightDp)
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color.Black)
                                .border(1.5.dp, Color.White.copy(alpha = 0.85f), RoundedCornerShape(20.dp))
                                .pointerInput(Unit) {
                                    detectTransformGestures { _, pan, zoom, rotation ->
                                        userScale = (userScale * zoom).coerceIn(0.6f, 5.0f)
                                        userRotation = (userRotation + rotation) % 360f
                                        userOffsetX += pan.x
                                        userOffsetY += pan.y
                                    }
                                }
                        ) {
                            // Canvas rendering transformed bitmap
                            Canvas(modifier = Modifier.fillMaxSize()) {
                                val totalScale = baseScale * userScale

                                withTransform({
                                    // 1. Move to crop frame center + pan offset
                                    translate(size.width / 2f + userOffsetX, size.height / 2f + userOffsetY)
                                    // 2. Rotate
                                    rotate(userRotation)
                                    // 3. Scale
                                    scale(totalScale, totalScale)
                                    // 4. Center bitmap at (0,0)
                                    translate(-bmp.width / 2f, -bmp.height / 2f)
                                }) {
                                    drawImage(bmp.asImageBitmap())
                                }

                                // Rule of Thirds Guide Grid
                                val strokeW = 1.dp.toPx()
                                val gridColor = Color.White.copy(alpha = 0.22f)
                                // Vertical lines
                                drawLine(gridColor, Offset(size.width / 3f, 0f), Offset(size.width / 3f, size.height), strokeW)
                                drawLine(gridColor, Offset(size.width * 2f / 3f, 0f), Offset(size.width * 2f / 3f, size.height), strokeW)
                                // Horizontal lines
                                drawLine(gridColor, Offset(0f, size.height / 3f), Offset(size.width, size.height / 3f), strokeW)
                                drawLine(gridColor, Offset(0f, size.height * 2f / 3f), Offset(size.width, size.height * 2f / 3f), strokeW)
                            }
                        }
                    }
                }

                // ==========================================
                // BOTTOM TOOLBAR: Zoom Slider, 90° Rotations, Reset
                // ==========================================
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 14.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Zoom Slider Row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = { userScale = (userScale - 0.15f).coerceAtLeast(0.6f) },
                            modifier = Modifier.size(36.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.ZoomOut,
                                contentDescription = "缩小",
                                tint = Color.White.copy(alpha = 0.75f)
                            )
                        }

                        Slider(
                            value = userScale,
                            onValueChange = { userScale = it },
                            valueRange = 0.6f..4.0f,
                            colors = SliderDefaults.colors(
                                thumbColor = palette.accent,
                                activeTrackColor = palette.accent,
                                inactiveTrackColor = Color.White.copy(alpha = 0.15f)
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 8.dp)
                        )

                        IconButton(
                            onClick = { userScale = (userScale + 0.15f).coerceAtMost(4.0f) },
                            modifier = Modifier.size(36.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.ZoomIn,
                                contentDescription = "放大",
                                tint = Color.White.copy(alpha = 0.75f)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Action Buttons Row: Rotate Left, Rotate Right, Reset
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ToolActionButton(
                            icon = Icons.Rounded.RotateLeft,
                            label = "向左 90°",
                            onClick = {
                                userRotation = (userRotation - 90f)
                            }
                        )

                        ToolActionButton(
                            icon = Icons.Rounded.RotateRight,
                            label = "向右 90°",
                            onClick = {
                                userRotation = (userRotation + 90f)
                            }
                        )

                        ToolActionButton(
                            icon = Icons.Rounded.Refresh,
                            label = "重置比例",
                            onClick = {
                                userScale = 1.0f
                                userRotation = 0f
                                userOffsetX = 0f
                                userOffsetY = 0f
                            }
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "16 : 9 比例 · 确认后自动平铺填满名片背景",
                        fontSize = 12.sp,
                        color = Color.White.copy(alpha = 0.45f)
                    )
                }
            }
        }
    }
}

@Composable
private fun ToolActionButton(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 14.dp, vertical = 8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White.copy(alpha = 0.75f)
        )
    }
}

/**
 * Loads the source bitmap and applies initial EXIF orientation so phone camera pictures stay upright.
 */
private fun loadAndOrientBitmap(context: Context, uri: Uri): Bitmap? {
    return try {
        val inputStream = context.contentResolver.openInputStream(uri) ?: return null
        val bytes = inputStream.readBytes()
        inputStream.close()

        val boundsOpts = BitmapFactory.Options().apply { inJustDecodeBounds = true }
        BitmapFactory.decodeByteArray(bytes, 0, bytes.size, boundsOpts)

        // Subsample down to at most 2560px to prevent OutOfMemory on 48MP+ cameras
        var sampleSize = 1
        val maxDim = max(boundsOpts.outWidth, boundsOpts.outHeight)
        while (maxDim / sampleSize > 2560) {
            sampleSize *= 2
        }

        val decodeOpts = BitmapFactory.Options().apply { inSampleSize = sampleSize }
        val decoded = BitmapFactory.decodeByteArray(bytes, 0, bytes.size, decodeOpts) ?: return null

        var rotation = 0f
        try {
            val exif = ExifInterface(bytes.inputStream())
            when (exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)) {
                ExifInterface.ORIENTATION_ROTATE_90 -> rotation = 90f
                ExifInterface.ORIENTATION_ROTATE_180 -> rotation = 180f
                ExifInterface.ORIENTATION_ROTATE_270 -> rotation = 270f
            }
        } catch (e: Throwable) {
            e.printStackTrace()
        }

        if (rotation != 0f) {
            val matrix = Matrix().apply { postRotate(rotation) }
            val rotated = Bitmap.createBitmap(decoded, 0, 0, decoded.width, decoded.height, matrix, true)
            if (rotated != decoded) decoded.recycle()
            rotated
        } else {
            decoded
        }
    } catch (e: Throwable) {
        e.printStackTrace()
        null
    }
}

/**
 * Renders the transformed bitmap into a 1280x720 output and saves to app internal storage.
 */
private fun cropAndSaveBitmap(
    context: Context,
    source: Bitmap,
    aspectRatio: Float,
    userScale: Float,
    userRotation: Float,
    userOffsetX: Float,
    userOffsetY: Float
): File? {
    return try {
        val outWidth = 1280
        val outHeight = (outWidth / aspectRatio).roundToInt()

        val outBitmap = Bitmap.createBitmap(outWidth, outHeight, Bitmap.Config.ARGB_8888)
        val canvas = android.graphics.Canvas(outBitmap)

        // Assume preview frame dimensions mapped to output
        val previewFrameW = 360f
        val previewFrameH = previewFrameW / aspectRatio
        val sOut = outWidth.toFloat() / previewFrameW

        val baseScale = max(
            previewFrameW / source.width.toFloat(),
            previewFrameH / source.height.toFloat()
        )
        val totalScale = baseScale * userScale

        val matrix = Matrix()
        // 1. Move bitmap center to origin
        matrix.postTranslate(-source.width / 2f, -source.height / 2f)
        // 2. Rotate
        matrix.postRotate(userRotation)
        // 3. Scale
        matrix.postScale(totalScale, totalScale)
        // 4. Translate to viewport center + pan offset
        matrix.postTranslate(previewFrameW / 2f + userOffsetX, previewFrameH / 2f + userOffsetY)
        // 5. Scale to output resolution
        matrix.postScale(sOut, sOut)

        val paint = Paint(Paint.FILTER_BITMAP_FLAG or Paint.ANTI_ALIAS_FLAG)
        canvas.drawBitmap(source, matrix, paint)

        val destFile = File(context.filesDir, "header_banner.jpg")
        FileOutputStream(destFile).use { outStream ->
            outBitmap.compress(Bitmap.CompressFormat.JPEG, 92, outStream)
        }
        outBitmap.recycle()
        destFile
    } catch (e: Throwable) {
        e.printStackTrace()
        null
    }
}
