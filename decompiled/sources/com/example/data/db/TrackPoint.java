package com.example.data.db;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RideRecordEntity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/example/data/db/TrackPoint;", "", "latitude", "", "longitude", "altitude", "speedMeterPerSec", "", "timestampMs", "", "<init>", "(DDDFJ)V", "getLatitude", "()D", "getLongitude", "getAltitude", "getSpeedMeterPerSec", "()F", "getTimestampMs", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TrackPoint {
    public static final int $stable = 0;
    private final double altitude;
    private final double latitude;
    private final double longitude;
    private final float speedMeterPerSec;
    private final long timestampMs;

    public static /* synthetic */ TrackPoint copy$default(TrackPoint trackPoint, double d, double d2, double d3, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            d = trackPoint.latitude;
        }
        double d4 = d;
        if ((i & 2) != 0) {
            d2 = trackPoint.longitude;
        }
        return trackPoint.copy(d4, d2, (i & 4) != 0 ? trackPoint.altitude : d3, (i & 8) != 0 ? trackPoint.speedMeterPerSec : f, (i & 16) != 0 ? trackPoint.timestampMs : j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getLatitude() {
        return this.latitude;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getLongitude() {
        return this.longitude;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getAltitude() {
        return this.altitude;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getSpeedMeterPerSec() {
        return this.speedMeterPerSec;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getTimestampMs() {
        return this.timestampMs;
    }

    public final TrackPoint copy(double latitude, double longitude, double altitude, float speedMeterPerSec, long timestampMs) {
        return new TrackPoint(latitude, longitude, altitude, speedMeterPerSec, timestampMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPoint)) {
            return false;
        }
        TrackPoint trackPoint = (TrackPoint) other;
        return Double.compare(this.latitude, trackPoint.latitude) == 0 && Double.compare(this.longitude, trackPoint.longitude) == 0 && Double.compare(this.altitude, trackPoint.altitude) == 0 && Float.compare(this.speedMeterPerSec, trackPoint.speedMeterPerSec) == 0 && this.timestampMs == trackPoint.timestampMs;
    }

    public int hashCode() {
        return (((((((Double.hashCode(this.latitude) * 31) + Double.hashCode(this.longitude)) * 31) + Double.hashCode(this.altitude)) * 31) + Float.hashCode(this.speedMeterPerSec)) * 31) + Long.hashCode(this.timestampMs);
    }

    public String toString() {
        return "TrackPoint(latitude=" + this.latitude + ", longitude=" + this.longitude + ", altitude=" + this.altitude + ", speedMeterPerSec=" + this.speedMeterPerSec + ", timestampMs=" + this.timestampMs + ")";
    }

    public TrackPoint(double d, double d2, double d3, float f, long j) {
        this.latitude = d;
        this.longitude = d2;
        this.altitude = d3;
        this.speedMeterPerSec = f;
        this.timestampMs = j;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final double getAltitude() {
        return this.altitude;
    }

    public final float getSpeedMeterPerSec() {
        return this.speedMeterPerSec;
    }

    public /* synthetic */ TrackPoint(double d, double d2, double d3, float f, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, d2, (i & 4) != 0 ? 0.0d : d3, (i & 8) != 0 ? 0.0f : f, (i & 16) != 0 ? System.currentTimeMillis() : j);
    }

    public final long getTimestampMs() {
        return this.timestampMs;
    }
}
