package com.example.data.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.example.MainActivity;
import com.example.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RideTrackingService.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\"\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0003J\b\u0010\u0012\u001a\u00020\tH\u0002J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/example/data/service/RideTrackingService;", "Landroid/app/Service;", "<init>", "()V", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "locationCallback", "Lcom/google/android/gms/location/LocationCallback;", "onCreate", "", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "startForegroundWithNotification", "requestLocationUpdates", "stopLocationUpdates", "onBind", "Landroid/os/IBinder;", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RideTrackingService extends Service {
    public static final String ACTION_START = "ACTION_START_RIDE_TRACKING";
    public static final String ACTION_STOP = "ACTION_STOP_RIDE_TRACKING";
    public static final int NOTIFICATION_ID = 1001;
    private FusedLocationProviderClient fusedLocationClient;
    private LocationCallback locationCallback;
    public static final int $stable = 8;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        Intrinsics.checkNotNullExpressionValue(fusedLocationProviderClient, "getFusedLocationProviderClient(...)");
        this.fusedLocationClient = fusedLocationProviderClient;
        this.locationCallback = new LocationCallback() { // from class: com.example.data.service.RideTrackingService.onCreate.1
            @Override // com.google.android.gms.location.LocationCallback
            public void onLocationResult(LocationResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                for (Location location : result.getLocations()) {
                    RideTrackingManager rideTrackingManager = RideTrackingManager.INSTANCE;
                    Intrinsics.checkNotNull(location);
                    rideTrackingManager.onLocationReceived(location);
                }
            }
        };
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent != null ? intent.getAction() : null;
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode != -342146728) {
                if (iHashCode == 850258250 && action.equals(ACTION_STOP)) {
                    stopLocationUpdates();
                    stopForeground(1);
                    stopSelf();
                }
            } else if (action.equals(ACTION_START)) {
                startForegroundWithNotification();
                requestLocationUpdates();
            }
        }
        return 1;
    }

    private final void startForegroundWithNotification() {
        Object systemService = getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("ride_tracking_channel", "骑行记录服务", 2);
            notificationChannel.setDescription("在后台持续获取 GPS 定位并记录骑行轨迹");
            notificationManager.createNotificationChannel(notificationChannel);
        }
        RideTrackingService rideTrackingService = this;
        Notification notificationBuild = new NotificationCompat.Builder(rideTrackingService, "ride_tracking_channel").setContentTitle("SummitPath 骑行记录中").setContentText("实时记录您的山地车轨迹与速度数据...").setSmallIcon(R.mipmap.ic_launcher).setContentIntent(PendingIntent.getActivity(rideTrackingService, 0, new Intent(rideTrackingService, (Class<?>) MainActivity.class), 201326592)).setOngoing(true).setPriority(-1).build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                startForeground(1001, notificationBuild, 8);
            } else {
                startForeground(1001, notificationBuild);
            }
        } catch (SecurityException e) {
            e.printStackTrace();
            try {
                startForeground(1001, notificationBuild);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private final void requestLocationUpdates() {
        LocationRequest locationRequestBuild = new LocationRequest.Builder(100, 1000L).setMinUpdateIntervalMillis(500L).setMinUpdateDistanceMeters(0.0f).build();
        Intrinsics.checkNotNullExpressionValue(locationRequestBuild, "build(...)");
        try {
            FusedLocationProviderClient fusedLocationProviderClient = this.fusedLocationClient;
            LocationCallback locationCallback = null;
            if (fusedLocationProviderClient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fusedLocationClient");
                fusedLocationProviderClient = null;
            }
            LocationCallback locationCallback2 = this.locationCallback;
            if (locationCallback2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationCallback");
            } else {
                locationCallback = locationCallback2;
            }
            Intrinsics.checkNotNull(fusedLocationProviderClient.requestLocationUpdates(locationRequestBuild, locationCallback, Looper.getMainLooper()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void stopLocationUpdates() {
        try {
            FusedLocationProviderClient fusedLocationProviderClient = this.fusedLocationClient;
            LocationCallback locationCallback = null;
            if (fusedLocationProviderClient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fusedLocationClient");
                fusedLocationProviderClient = null;
            }
            LocationCallback locationCallback2 = this.locationCallback;
            if (locationCallback2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationCallback");
            } else {
                locationCallback = locationCallback2;
            }
            Intrinsics.checkNotNull(fusedLocationProviderClient.removeLocationUpdates(locationCallback));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
