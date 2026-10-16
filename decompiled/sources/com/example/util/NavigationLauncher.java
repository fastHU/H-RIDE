package com.example.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavigationLauncher.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ&\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ&\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ&\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ$\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00132\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0002¨\u0006\u0016"}, d2 = {"Lcom/example/util/NavigationLauncher;", "", "<init>", "()V", "openGaodeMapNavi", "", "context", "Landroid/content/Context;", "destLat", "", "destLon", "destName", "", "openBaiduMapNavi", "openTencentMapNavi", "openGaodeWebNavi", "", "openSystemGeoMap", "gcj02ToBd09", "Lkotlin/Pair;", "gcjLat", "gcjLon", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NavigationLauncher {
    public static final int $stable = 0;
    public static final NavigationLauncher INSTANCE = new NavigationLauncher();

    private NavigationLauncher() {
    }

    public final boolean openGaodeMapNavi(Context context, double destLat, double destLon, String destName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(destName, "destName");
        try {
            Pair<Double, Double> pairWgs84ToGcj02 = GpsCoordinateUtils.INSTANCE.wgs84ToGcj02(destLat, destLon);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("amapuri://route/plan/?dlat=" + pairWgs84ToGcj02.component1().doubleValue() + "&dlon=" + pairWgs84ToGcj02.component2().doubleValue() + "&dname=" + Uri.encode(destName) + "&dev=0&t=3"));
            intent.setPackage("com.autonavi.minimap");
            intent.addFlags(268435456);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
                return true;
            }
            openGaodeWebNavi(context, destLat, destLon, destName);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            openGaodeWebNavi(context, destLat, destLon, destName);
            return false;
        }
    }

    public final boolean openBaiduMapNavi(Context context, double destLat, double destLon, String destName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(destName, "destName");
        try {
            Pair<Double, Double> pairWgs84ToGcj02 = GpsCoordinateUtils.INSTANCE.wgs84ToGcj02(destLat, destLon);
            Pair<Double, Double> pairGcj02ToBd09 = gcj02ToBd09(pairWgs84ToGcj02.component1().doubleValue(), pairWgs84ToGcj02.component2().doubleValue());
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("baidumap://map/direction?destination=latlng:" + pairGcj02ToBd09.component1().doubleValue() + "," + pairGcj02ToBd09.component2().doubleValue() + "|name:" + Uri.encode(destName) + "&mode=riding&coord_type=bd09ll"));
            intent.setPackage("com.baidu.BaiduMap");
            intent.addFlags(268435456);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
                return true;
            }
            Toast.makeText(context, "未检测到百度地图App，改用网页导航", 0).show();
            openGaodeWebNavi(context, destLat, destLon, destName);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            openGaodeWebNavi(context, destLat, destLon, destName);
            return false;
        }
    }

    public final boolean openTencentMapNavi(Context context, double destLat, double destLon, String destName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(destName, "destName");
        try {
            Pair<Double, Double> pairWgs84ToGcj02 = GpsCoordinateUtils.INSTANCE.wgs84ToGcj02(destLat, destLon);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("qqmap://map/routeplan?type=bike&to=" + Uri.encode(destName) + "&tocoord=" + pairWgs84ToGcj02.component1().doubleValue() + "," + pairWgs84ToGcj02.component2().doubleValue()));
            intent.setPackage("com.tencent.map");
            intent.addFlags(268435456);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
                return true;
            }
            Toast.makeText(context, "未检测到腾讯地图App，改用网页导航", 0).show();
            openGaodeWebNavi(context, destLat, destLon, destName);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            openGaodeWebNavi(context, destLat, destLon, destName);
            return false;
        }
    }

    public final void openGaodeWebNavi(Context context, double destLat, double destLon, String destName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(destName, "destName");
        try {
            Pair<Double, Double> pairWgs84ToGcj02 = GpsCoordinateUtils.INSTANCE.wgs84ToGcj02(destLat, destLon);
            double dDoubleValue = pairWgs84ToGcj02.component1().doubleValue();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://uri.amap.com/navigation?to=" + pairWgs84ToGcj02.component2().doubleValue() + "," + dDoubleValue + "," + Uri.encode(destName) + "&mode=bike&policy=1"));
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            openSystemGeoMap(context, destLat, destLon, destName);
        }
    }

    public final void openSystemGeoMap(Context context, double destLat, double destLon, String destName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(destName, "destName");
        try {
            Pair<Double, Double> pairWgs84ToGcj02 = GpsCoordinateUtils.INSTANCE.wgs84ToGcj02(destLat, destLon);
            double dDoubleValue = pairWgs84ToGcj02.component1().doubleValue();
            double dDoubleValue2 = pairWgs84ToGcj02.component2().doubleValue();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + dDoubleValue + "," + dDoubleValue2 + "?q=" + dDoubleValue + "," + dDoubleValue2 + "(" + Uri.encode(destName) + ")"));
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "无法唤起地图应用", 0).show();
        }
    }

    private final Pair<Double, Double> gcj02ToBd09(double gcjLat, double gcjLon) {
        double dSqrt = Math.sqrt((gcjLon * gcjLon) + (gcjLat * gcjLat)) + (Math.sin(gcjLat * 52.35987755982988d) * 2.0E-5d);
        double dAtan2 = Math.atan2(gcjLat, gcjLon) + (Math.cos(gcjLon * 52.35987755982988d) * 3.0E-6d);
        return new Pair<>(Double.valueOf((dSqrt * Math.sin(dAtan2)) + 0.006d), Double.valueOf((Math.cos(dAtan2) * dSqrt) + 0.0065d));
    }
}
