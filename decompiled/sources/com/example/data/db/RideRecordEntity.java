package com.example.data.db;

import android.location.Location;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: RideRecordEntity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010$\u001a\u00020%J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\t\u00100\u001a\u00020\u0010HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\u0081\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0005HÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017¨\u00069"}, d2 = {"Lcom/example/data/db/RideRecordEntity;", "", "id", "", LinkHeader.Parameters.Title, "", "startTimeMs", "endTimeMs", "durationSeconds", "distanceMeters", "", "avgSpeedKmH", "maxSpeedKmH", "elevationGainMeters", "currentElevationMeters", "maxGForce", "", "trackPointsJson", "<init>", "(JLjava/lang/String;JJJDDDDDFLjava/lang/String;)V", "getId", "()J", "getTitle", "()Ljava/lang/String;", "getStartTimeMs", "getEndTimeMs", "getDurationSeconds", "getDistanceMeters", "()D", "getAvgSpeedKmH", "getMaxSpeedKmH", "getElevationGainMeters", "getCurrentElevationMeters", "getMaxGForce", "()F", "getTrackPointsJson", "getCleanedStats", "Lcom/example/data/db/CleanedRideStats;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RideRecordEntity {
    public static final int $stable = 0;
    private final double avgSpeedKmH;
    private final double currentElevationMeters;
    private final double distanceMeters;
    private final long durationSeconds;
    private final double elevationGainMeters;
    private final long endTimeMs;
    private final long id;
    private final float maxGForce;
    private final double maxSpeedKmH;
    private final long startTimeMs;
    private final String title;
    private final String trackPointsJson;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final double getCurrentElevationMeters() {
        return this.currentElevationMeters;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final float getMaxGForce() {
        return this.maxGForce;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getTrackPointsJson() {
        return this.trackPointsJson;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getStartTimeMs() {
        return this.startTimeMs;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getEndTimeMs() {
        return this.endTimeMs;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getDurationSeconds() {
        return this.durationSeconds;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final double getDistanceMeters() {
        return this.distanceMeters;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final double getAvgSpeedKmH() {
        return this.avgSpeedKmH;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final double getMaxSpeedKmH() {
        return this.maxSpeedKmH;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final double getElevationGainMeters() {
        return this.elevationGainMeters;
    }

    public final RideRecordEntity copy(long id, String title, long startTimeMs, long endTimeMs, long durationSeconds, double distanceMeters, double avgSpeedKmH, double maxSpeedKmH, double elevationGainMeters, double currentElevationMeters, float maxGForce, String trackPointsJson) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(trackPointsJson, "trackPointsJson");
        return new RideRecordEntity(id, title, startTimeMs, endTimeMs, durationSeconds, distanceMeters, avgSpeedKmH, maxSpeedKmH, elevationGainMeters, currentElevationMeters, maxGForce, trackPointsJson);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RideRecordEntity)) {
            return false;
        }
        RideRecordEntity rideRecordEntity = (RideRecordEntity) other;
        return this.id == rideRecordEntity.id && Intrinsics.areEqual(this.title, rideRecordEntity.title) && this.startTimeMs == rideRecordEntity.startTimeMs && this.endTimeMs == rideRecordEntity.endTimeMs && this.durationSeconds == rideRecordEntity.durationSeconds && Double.compare(this.distanceMeters, rideRecordEntity.distanceMeters) == 0 && Double.compare(this.avgSpeedKmH, rideRecordEntity.avgSpeedKmH) == 0 && Double.compare(this.maxSpeedKmH, rideRecordEntity.maxSpeedKmH) == 0 && Double.compare(this.elevationGainMeters, rideRecordEntity.elevationGainMeters) == 0 && Double.compare(this.currentElevationMeters, rideRecordEntity.currentElevationMeters) == 0 && Float.compare(this.maxGForce, rideRecordEntity.maxGForce) == 0 && Intrinsics.areEqual(this.trackPointsJson, rideRecordEntity.trackPointsJson);
    }

    public int hashCode() {
        return (((((((((((((((((((((Long.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + Long.hashCode(this.startTimeMs)) * 31) + Long.hashCode(this.endTimeMs)) * 31) + Long.hashCode(this.durationSeconds)) * 31) + Double.hashCode(this.distanceMeters)) * 31) + Double.hashCode(this.avgSpeedKmH)) * 31) + Double.hashCode(this.maxSpeedKmH)) * 31) + Double.hashCode(this.elevationGainMeters)) * 31) + Double.hashCode(this.currentElevationMeters)) * 31) + Float.hashCode(this.maxGForce)) * 31) + this.trackPointsJson.hashCode();
    }

    public String toString() {
        return "RideRecordEntity(id=" + this.id + ", title=" + this.title + ", startTimeMs=" + this.startTimeMs + ", endTimeMs=" + this.endTimeMs + ", durationSeconds=" + this.durationSeconds + ", distanceMeters=" + this.distanceMeters + ", avgSpeedKmH=" + this.avgSpeedKmH + ", maxSpeedKmH=" + this.maxSpeedKmH + ", elevationGainMeters=" + this.elevationGainMeters + ", currentElevationMeters=" + this.currentElevationMeters + ", maxGForce=" + this.maxGForce + ", trackPointsJson=" + this.trackPointsJson + ")";
    }

    public RideRecordEntity(long j, String title, long j2, long j3, long j4, double d, double d2, double d3, double d4, double d5, float f, String trackPointsJson) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(trackPointsJson, "trackPointsJson");
        this.id = j;
        this.title = title;
        this.startTimeMs = j2;
        this.endTimeMs = j3;
        this.durationSeconds = j4;
        this.distanceMeters = d;
        this.avgSpeedKmH = d2;
        this.maxSpeedKmH = d3;
        this.elevationGainMeters = d4;
        this.currentElevationMeters = d5;
        this.maxGForce = f;
        this.trackPointsJson = trackPointsJson;
    }

    public /* synthetic */ RideRecordEntity(long j, String str, long j2, long j3, long j4, double d, double d2, double d3, double d4, double d5, float f, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, str, j2, j3, j4, d, d2, d3, d4, d5, (i & 1024) != 0 ? 1.0f : f, str2);
    }

    public final long getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final long getStartTimeMs() {
        return this.startTimeMs;
    }

    public final long getEndTimeMs() {
        return this.endTimeMs;
    }

    public final long getDurationSeconds() {
        return this.durationSeconds;
    }

    public final double getDistanceMeters() {
        return this.distanceMeters;
    }

    public final double getAvgSpeedKmH() {
        return this.avgSpeedKmH;
    }

    public final double getMaxSpeedKmH() {
        return this.maxSpeedKmH;
    }

    public final double getElevationGainMeters() {
        return this.elevationGainMeters;
    }

    public final double getCurrentElevationMeters() {
        return this.currentElevationMeters;
    }

    public final float getMaxGForce() {
        return this.maxGForce;
    }

    public final String getTrackPointsJson() {
        return this.trackPointsJson;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0213  */
    /* JADX WARN: Code duplicated, block: B:107:0x021b  */
    /* JADX WARN: Code duplicated, block: B:110:0x022c  */
    /* JADX WARN: Code duplicated, block: B:111:0x022f  */
    /* JADX WARN: Code duplicated, block: B:121:0x0174 A[EDGE_INSN: B:121:0x0174->B:70:0x0174 BREAK  A[LOOP:1: B:22:0x0084->B:129:0x0084], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x00b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:123:0x00dc A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:0x00de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x0090  */
    /* JADX WARN: Code duplicated, block: B:29:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:34:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:37:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:45:0x0106  */
    /* JADX WARN: Code duplicated, block: B:46:0x0119  */
    /* JADX WARN: Code duplicated, block: B:49:0x0124  */
    /* JADX WARN: Code duplicated, block: B:50:0x012e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0138  */
    /* JADX WARN: Code duplicated, block: B:54:0x0144  */
    /* JADX WARN: Code duplicated, block: B:57:0x014e  */
    /* JADX WARN: Code duplicated, block: B:60:0x0154  */
    /* JADX WARN: Code duplicated, block: B:66:0x0166 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:72:0x0181  */
    /* JADX WARN: Code duplicated, block: B:73:0x0184  */
    /* JADX WARN: Code duplicated, block: B:75:0x0188  */
    /* JADX WARN: Code duplicated, block: B:76:0x018b  */
    /* JADX WARN: Code duplicated, block: B:79:0x0193  */
    /* JADX WARN: Code duplicated, block: B:82:0x01a8 A[PHI: r4
      0x01a8: PHI (r4v14 double) = (r4v7 double), (r4v12 double) binds: [B:81:0x01a6, B:87:0x01b8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:83:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:91:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:93:0x01d7  */
    public final CleanedRideStats getCleanedStats() {
        double d;
        char c;
        ArrayList arrayList;
        Iterator it;
        TrackPoint trackPoint;
        double d2;
        double dMax;
        int i;
        ArrayList arrayList2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double dMax2;
        double d9;
        ArrayList arrayList3;
        int size;
        TrackPoint trackPoint2;
        TrackPoint trackPoint3;
        double d10;
        double timestampMs;
        double d11;
        double speedMeterPerSec;
        double speedMeterPerSec2;
        ArrayList arrayList4 = new ArrayList();
        double d12 = 0.0d;
        try {
            if (!StringsKt.isBlank(this.trackPointsJson)) {
                JSONArray jSONArray = new JSONArray(this.trackPointsJson);
                int length = jSONArray.length();
                int i2 = 0;
                while (i2 < length) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    c = 0;
                    try {
                        int i3 = length;
                        int i4 = i2;
                        d = d12;
                        try {
                            arrayList4.add(new TrackPoint(jSONObject.getDouble("latitude"), jSONObject.getDouble("longitude"), jSONObject.optDouble("altitude", d12), (float) jSONObject.optDouble("speedMeterPerSec", d12), jSONObject.optLong("timestampMs", 0L)));
                            i2 = i4 + 1;
                            length = i3;
                            d12 = d;
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            arrayList = new ArrayList();
                            it = arrayList4.iterator();
                            trackPoint = null;
                            d2 = d;
                            dMax = d2;
                            while (true) {
                                if (it.hasNext()) {
                                    break;
                                }
                                trackPoint3 = (TrackPoint) it.next();
                                if (trackPoint3.getLatitude() != d) {
                                    if (trackPoint == null) {
                                        arrayList.add(trackPoint3);
                                        if (trackPoint3.getSpeedMeterPerSec() > 0.0f) {
                                            speedMeterPerSec2 = trackPoint3.getSpeedMeterPerSec() * 3.6f;
                                        } else {
                                            speedMeterPerSec2 = d;
                                        }
                                        if (0.8d <= speedMeterPerSec2) {
                                        }
                                        trackPoint = trackPoint3;
                                    } else {
                                        float[] fArr = new float[1];
                                        Location.distanceBetween(trackPoint.getLatitude(), trackPoint.getLongitude(), trackPoint3.getLatitude(), trackPoint3.getLongitude(), fArr);
                                        d10 = fArr[c];
                                        if (trackPoint3.getTimestampMs() > trackPoint.getTimestampMs()) {
                                            timestampMs = (trackPoint3.getTimestampMs() - trackPoint.getTimestampMs()) / 1000.0d;
                                        } else {
                                            timestampMs = 1.0d;
                                        }
                                        if (timestampMs > 0.1d) {
                                            d11 = (d10 / timestampMs) * 3.6d;
                                        } else {
                                            d11 = d;
                                        }
                                        if (trackPoint3.getSpeedMeterPerSec() > 0.0f) {
                                            speedMeterPerSec = trackPoint3.getSpeedMeterPerSec() * 3.6f;
                                        } else {
                                            speedMeterPerSec = d;
                                        }
                                        if (speedMeterPerSec > d) {
                                            d11 = speedMeterPerSec;
                                        }
                                        if (d11 <= 180.0d) {
                                            d2 += d10;
                                            if (d11 > dMax) {
                                                dMax = d11;
                                            }
                                            arrayList.add(trackPoint3);
                                            trackPoint = trackPoint3;
                                        }
                                        arrayList4 = arrayList4;
                                        it = it;
                                    }
                                } else if (trackPoint == null) {
                                    arrayList.add(trackPoint3);
                                    if (trackPoint3.getSpeedMeterPerSec() > 0.0f) {
                                        speedMeterPerSec2 = trackPoint3.getSpeedMeterPerSec() * 3.6f;
                                    } else {
                                        speedMeterPerSec2 = d;
                                    }
                                    if (0.8d <= speedMeterPerSec2) {
                                    }
                                    trackPoint = trackPoint3;
                                } else {
                                    float[] fArr2 = new float[1];
                                    Location.distanceBetween(trackPoint.getLatitude(), trackPoint.getLongitude(), trackPoint3.getLatitude(), trackPoint3.getLongitude(), fArr2);
                                    d10 = fArr2[c];
                                    if (trackPoint3.getTimestampMs() > trackPoint.getTimestampMs()) {
                                        timestampMs = (trackPoint3.getTimestampMs() - trackPoint.getTimestampMs()) / 1000.0d;
                                    } else {
                                        timestampMs = 1.0d;
                                    }
                                    if (timestampMs > 0.1d) {
                                        d11 = (d10 / timestampMs) * 3.6d;
                                    } else {
                                        d11 = d;
                                    }
                                    if (trackPoint3.getSpeedMeterPerSec() > 0.0f) {
                                        speedMeterPerSec = trackPoint3.getSpeedMeterPerSec() * 3.6f;
                                    } else {
                                        speedMeterPerSec = d;
                                    }
                                    if (speedMeterPerSec > d) {
                                        d11 = speedMeterPerSec;
                                    }
                                    if (d11 <= 180.0d) {
                                        d2 += d10;
                                        if (d11 > dMax) {
                                            dMax = d11;
                                        }
                                        arrayList.add(trackPoint3);
                                        trackPoint = trackPoint3;
                                    }
                                    arrayList4 = arrayList4;
                                    it = it;
                                }
                            }
                            arrayList2 = arrayList4;
                            d3 = this.distanceMeters;
                            if (d3 > d) {
                                d4 = d3;
                            } else if (d2 > d) {
                                d4 = d2;
                            } else {
                                d4 = d;
                            }
                            d5 = this.maxSpeedKmH;
                            if (d5 > d) {
                                dMax = Math.max(d5, dMax);
                            }
                            double d13 = dMax;
                            d6 = this.durationSeconds / 3600.0d;
                            d7 = this.avgSpeedKmH;
                            if (d7 > d) {
                                if (d6 > 1.0E-4d) {
                                }
                                d8 = d;
                            } else {
                                d8 = d7;
                            }
                            if (arrayList.size() >= 2) {
                                double altitude = ((TrackPoint) CollectionsKt.first((List) arrayList)).getAltitude();
                                size = arrayList.size();
                                dMax2 = d;
                                for (i = 1; i < size; i++) {
                                    trackPoint2 = (TrackPoint) arrayList.get(i - 1);
                                    TrackPoint trackPoint4 = (TrackPoint) arrayList.get(i);
                                    if (trackPoint2.getAltitude() <= d) {
                                    }
                                }
                            } else {
                                dMax2 = d;
                            }
                            d9 = this.elevationGainMeters;
                            if (d9 > d) {
                                dMax2 = Math.max(d9, dMax2);
                            }
                            double d14 = dMax2;
                            if (arrayList.isEmpty()) {
                                arrayList3 = arrayList2;
                            } else {
                                arrayList3 = arrayList;
                            }
                            return new CleanedRideStats(d4, d8, d13, d14, arrayList3);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        d = d12;
                    }
                }
            }
            d = d12;
            c = 0;
            while (true) {
                if (it.hasNext()) {
                    break;
                    break;
                }
                trackPoint3 = (TrackPoint) it.next();
                if (trackPoint3.getLatitude() != d && trackPoint3.getLongitude() == d) {
                    arrayList4 = arrayList4;
                    it = it;
                } else if (trackPoint == null) {
                    arrayList.add(trackPoint3);
                    if (trackPoint3.getSpeedMeterPerSec() > 0.0f) {
                        speedMeterPerSec2 = trackPoint3.getSpeedMeterPerSec() * 3.6f;
                    } else {
                        speedMeterPerSec2 = d;
                    }
                    if (0.8d <= speedMeterPerSec2 || speedMeterPerSec2 > 180.0d || speedMeterPerSec2 <= dMax) {
                        trackPoint = trackPoint3;
                    } else {
                        trackPoint = trackPoint3;
                        dMax = speedMeterPerSec2;
                    }
                } else {
                    float[] fArr3 = new float[1];
                    Location.distanceBetween(trackPoint.getLatitude(), trackPoint.getLongitude(), trackPoint3.getLatitude(), trackPoint3.getLongitude(), fArr3);
                    d10 = fArr3[c];
                    if (trackPoint3.getTimestampMs() > trackPoint.getTimestampMs()) {
                        timestampMs = (trackPoint3.getTimestampMs() - trackPoint.getTimestampMs()) / 1000.0d;
                    } else {
                        timestampMs = 1.0d;
                    }
                    if (timestampMs > 0.1d) {
                        d11 = (d10 / timestampMs) * 3.6d;
                    } else {
                        d11 = d;
                    }
                    if (trackPoint3.getSpeedMeterPerSec() > 0.0f) {
                        speedMeterPerSec = trackPoint3.getSpeedMeterPerSec() * 3.6f;
                    } else {
                        speedMeterPerSec = d;
                    }
                    if (speedMeterPerSec > d) {
                        d11 = speedMeterPerSec;
                    }
                    if (d11 <= 180.0d && (timestampMs >= 1.0d || d10 <= 500.0d)) {
                        d2 += d10;
                        if (d11 > dMax && d11 <= 180.0d) {
                            dMax = d11;
                        }
                        arrayList.add(trackPoint3);
                        trackPoint = trackPoint3;
                    }
                }
                arrayList4 = arrayList4;
                it = it;
            }
        } catch (Exception e3) {
            e = e3;
            d = d12;
            c = 0;
        }
        arrayList = new ArrayList();
        it = arrayList4.iterator();
        trackPoint = null;
        d2 = d;
        dMax = d2;
        arrayList2 = arrayList4;
        d3 = this.distanceMeters;
        if (d3 > d) {
            d4 = d3;
        } else if (d2 > d) {
            d4 = d2;
        } else {
            d4 = d;
        }
        d5 = this.maxSpeedKmH;
        if (d5 > d) {
            dMax = Math.max(d5, dMax);
        }
        double d15 = dMax;
        d6 = this.durationSeconds / 3600.0d;
        d7 = this.avgSpeedKmH;
        if (d7 > d) {
            d8 = d7;
        } else if (d6 > 1.0E-4d || d4 <= d) {
            d8 = d;
        } else {
            d7 = (d4 / 1000.0d) / d6;
            d8 = d7;
        }
        if (arrayList.size() >= 2) {
            double altitude2 = ((TrackPoint) CollectionsKt.first((List) arrayList)).getAltitude();
            size = arrayList.size();
            dMax2 = d;
            while (i < size) {
                trackPoint2 = (TrackPoint) arrayList.get(i - 1);
                TrackPoint trackPoint5 = (TrackPoint) arrayList.get(i);
                if (trackPoint2.getAltitude() <= d && trackPoint5.getAltitude() > d) {
                    double altitude3 = trackPoint5.getAltitude() - altitude2;
                    if (altitude3 >= 0.8d) {
                        dMax2 += altitude3;
                        altitude2 = trackPoint5.getAltitude();
                    } else if (trackPoint5.getAltitude() < altitude2) {
                        altitude2 = trackPoint5.getAltitude();
                    }
                }
            }
        } else {
            dMax2 = d;
        }
        d9 = this.elevationGainMeters;
        if (d9 > d) {
            dMax2 = Math.max(d9, dMax2);
        }
        double d16 = dMax2;
        if (arrayList.isEmpty()) {
            arrayList3 = arrayList;
        } else {
            arrayList3 = arrayList2;
        }
        return new CleanedRideStats(d4, d8, d15, d16, arrayList3);
    }
}
