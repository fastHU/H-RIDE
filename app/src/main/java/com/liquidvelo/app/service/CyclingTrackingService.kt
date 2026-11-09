package com.liquidvelo.app.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.liquidvelo.app.MainActivity
import com.liquidvelo.app.R
import java.util.Locale

/**
 * Android 16 (API 36) Safe Ongoing Ride Telemetry Notification Manager & Service.
 * Avoids ForegroundServiceStartNotAllowedException & RemoteServiceException on Android 14-16
 * by posting ongoing workout notifications directly via NotificationManager with full safety guards.
 */
class CyclingTrackingService : Service() {

    companion object {
        const val CHANNEL_ID = "h_ride_tracking_channel_v67"
        const val NOTIFICATION_ID = 1001

        @Volatile
        var isServiceRunning: Boolean = false

        fun startService(context: Context) {
            try {
                val appCtx = context.applicationContext
                val nm = appCtx.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager ?: return
                ensureChannel(nm)
                isServiceRunning = true
                val notif = buildSafeNotification(appCtx, 0f, 0.0, 0L)
                nm.notify(NOTIFICATION_ID, notif)
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }

        fun updateMetrics(context: Context, speedKmh: Float, distanceKm: Double, elapsedSeconds: Long) {
            if (!isServiceRunning) return
            try {
                val appCtx = context.applicationContext
                val nm = appCtx.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager ?: return
                val notif = buildSafeNotification(appCtx, speedKmh, distanceKm, elapsedSeconds)
                nm.notify(NOTIFICATION_ID, notif)
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }

        fun stopService(context: Context) {
            isServiceRunning = false
            try {
                val appCtx = context.applicationContext
                val nm = appCtx.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
                nm?.cancel(NOTIFICATION_ID)
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }

        private fun ensureChannel(nm: NotificationManager) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                runCatching {
                    nm.deleteNotificationChannel("h_ride_tracking_channel_v1")
                    nm.deleteNotificationChannel("h_ride_tracking_channel_v2")
                    nm.deleteNotificationChannel("h_ride_tracking_channel_v3")
                }
                val channel = NotificationChannel(
                    CHANNEL_ID,
                    "H RIDE 骑行实时遥测",
                    NotificationManager.IMPORTANCE_LOW
                ).apply {
                    description = "在锁屏与后台实时通知骑行速度与里程"
                    setShowBadge(false)
                    lockscreenVisibility = Notification.VISIBILITY_PUBLIC
                }
                nm.createNotificationChannel(channel)
            }
        }

        private fun getAppIconBitmap(context: Context): Bitmap? {
            return runCatching {
                val drawable = ContextCompat.getDrawable(context, R.mipmap.ic_launcher) ?: return null
                val w = if (drawable.intrinsicWidth > 0) drawable.intrinsicWidth else 192
                val h = if (drawable.intrinsicHeight > 0) drawable.intrinsicHeight else 192
                val bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
                val canvas = Canvas(bitmap)
                drawable.setBounds(0, 0, canvas.width, canvas.height)
                drawable.draw(canvas)
                bitmap
            }.getOrNull()
        }

        private fun buildSafeNotification(
            context: Context,
            speedKmh: Float,
            distanceKm: Double,
            elapsedSeconds: Long
        ): Notification {
            val intent = Intent(context, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            val pendingFlags = PendingIntent.FLAG_UPDATE_CURRENT or
                (if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0)
            val pendingIntent = PendingIntent.getActivity(context, 0, intent, pendingFlags)

            val hours = elapsedSeconds / 3600
            val mins = (elapsedSeconds % 3600) / 60
            val secs = elapsedSeconds % 60
            val timeFormatted = if (hours > 0) {
                String.format(Locale.US, "%02d:%02d:%02d", hours, mins, secs)
            } else {
                String.format(Locale.US, "%02d:%02d:%02d", mins, secs)
            }

            val contentStr = String.format(
                Locale.US,
                "速度 %04.1f km/h  ·  里程 %.2f km  ·  耗时 %s",
                speedKmh.coerceAtLeast(0f),
                distanceKm.coerceAtLeast(0.0),
                timeFormatted
            )

            val largeIconBitmap = getAppIconBitmap(context)

            val builder = NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentTitle("H RIDE · 正在骑行记录")
                .setContentText(contentStr)
                .setSmallIcon(R.drawable.ic_stat_notification)
                .setContentIntent(pendingIntent)
                .setOngoing(true)
                .setOnlyAlertOnce(true)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_WORKOUT)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)

            if (largeIconBitmap != null) {
                builder.setLargeIcon(largeIconBitmap)
            }

            return builder.build()
        }
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
