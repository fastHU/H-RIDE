package com.example.util;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Pair;
import org.osmdroid.util.GeoPoint;

/* JADX INFO: compiled from: GpsCoordinateUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/example/util/GpsCoordinateUtils;", "", "<init>", "()V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "EE", "gcj02ToWgs84", "Lkotlin/Pair;", "lat", "lon", "gcj02ToWgs84GeoPoint", "Lorg/osmdroid/util/GeoPoint;", "point", "wgs84ToGcj02", "wgs84ToGcj02GeoPoint", "outOfChina", "", "transformLat", "x", "y", "transformLon", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GpsCoordinateUtils {
    public static final int $stable = 0;
    private static final double A = 6378245.0d;
    private static final double EE = 0.006693421622965943d;
    public static final GpsCoordinateUtils INSTANCE = new GpsCoordinateUtils();

    private final boolean outOfChina(double lat, double lon) {
        return lon < 72.004d || lon > 137.8347d || lat < 0.8293d || lat > 55.8271d;
    }

    private GpsCoordinateUtils() {
    }

    public final Pair<Double, Double> gcj02ToWgs84(double lat, double lon) {
        if (outOfChina(lat, lon)) {
            return new Pair<>(Double.valueOf(lat), Double.valueOf(lon));
        }
        Pair<Double, Double> pairWgs84ToGcj02 = wgs84ToGcj02(lat, lon);
        return new Pair<>(Double.valueOf(lat - (pairWgs84ToGcj02.component1().doubleValue() - lat)), Double.valueOf(lon - (pairWgs84ToGcj02.component2().doubleValue() - lon)));
    }

    public final GeoPoint gcj02ToWgs84GeoPoint(GeoPoint point) {
        if (point == null) {
            return null;
        }
        Pair<Double, Double> pairGcj02ToWgs84 = gcj02ToWgs84(point.getLatitude(), point.getLongitude());
        return new GeoPoint(pairGcj02ToWgs84.component1().doubleValue(), pairGcj02ToWgs84.component2().doubleValue());
    }

    public final Pair<Double, Double> wgs84ToGcj02(double lat, double lon) {
        if (outOfChina(lat, lon)) {
            return new Pair<>(Double.valueOf(lat), Double.valueOf(lon));
        }
        double d = lon - 105.0d;
        double d2 = lat - 35.0d;
        double dTransformLat = transformLat(d, d2);
        double dTransformLon = transformLon(d, d2);
        double d3 = (lat / 180.0d) * 3.141592653589793d;
        double dSin = Math.sin(d3);
        double d4 = 1.0d - ((EE * dSin) * dSin);
        double dSqrt = Math.sqrt(d4);
        return new Pair<>(Double.valueOf(lat + ((dTransformLat * 180.0d) / ((6335552.717000426d / (d4 * dSqrt)) * 3.141592653589793d))), Double.valueOf(lon + ((dTransformLon * 180.0d) / (((A / dSqrt) * Math.cos(d3)) * 3.141592653589793d))));
    }

    public final GeoPoint wgs84ToGcj02GeoPoint(GeoPoint point) {
        if (point == null) {
            return null;
        }
        Pair<Double, Double> pairWgs84ToGcj02 = wgs84ToGcj02(point.getLatitude(), point.getLongitude());
        return new GeoPoint(pairWgs84ToGcj02.component1().doubleValue(), pairWgs84ToGcj02.component2().doubleValue());
    }

    private final double transformLat(double x, double y) {
        double d = x * 2.0d;
        double dSqrt = (-100.0d) + d + (y * 3.0d) + (y * 0.2d * y) + (0.1d * x * y) + (Math.sqrt(Math.abs(x)) * 0.2d) + ((((Math.sin((6.0d * x) * 3.141592653589793d) * 20.0d) + (Math.sin(d * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d);
        double d2 = y * 3.141592653589793d;
        return dSqrt + ((((Math.sin(d2) * 20.0d) + (Math.sin((y / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((y / 12.0d) * 3.141592653589793d) * 160.0d) + (320.0d * Math.sin(d2 / 30.0d))) * 2.0d) / 3.0d);
    }

    private final double transformLon(double x, double y) {
        double d = x * 0.1d;
        return x + 300.0d + (y * 2.0d) + (d * x) + (d * y) + (Math.sqrt(Math.abs(x)) * 0.1d) + ((((Math.sin((6.0d * x) * 3.141592653589793d) * 20.0d) + (Math.sin((x * 2.0d) * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(x * 3.141592653589793d) * 20.0d) + (Math.sin((x / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((x / 12.0d) * 3.141592653589793d) * 150.0d) + (Math.sin((x / 30.0d) * 3.141592653589793d) * 300.0d)) * 2.0d) / 3.0d);
    }
}
