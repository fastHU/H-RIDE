package com.example.data.db;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RideRecordEntity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003JA\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/example/data/db/CleanedRideStats;", "", "distanceMeters", "", "avgSpeedKmH", "maxSpeedKmH", "elevationGainMeters", "trackPoints", "", "Lcom/example/data/db/TrackPoint;", "<init>", "(DDDDLjava/util/List;)V", "getDistanceMeters", "()D", "getAvgSpeedKmH", "getMaxSpeedKmH", "getElevationGainMeters", "getTrackPoints", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CleanedRideStats {
    public static final int $stable = 8;
    private final double avgSpeedKmH;
    private final double distanceMeters;
    private final double elevationGainMeters;
    private final double maxSpeedKmH;
    private final List<TrackPoint> trackPoints;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CleanedRideStats copy$default(CleanedRideStats cleanedRideStats, double d, double d2, double d3, double d4, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            d = cleanedRideStats.distanceMeters;
        }
        double d5 = d;
        if ((i & 2) != 0) {
            d2 = cleanedRideStats.avgSpeedKmH;
        }
        return cleanedRideStats.copy(d5, d2, (i & 4) != 0 ? cleanedRideStats.maxSpeedKmH : d3, (i & 8) != 0 ? cleanedRideStats.elevationGainMeters : d4, (i & 16) != 0 ? cleanedRideStats.trackPoints : list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getDistanceMeters() {
        return this.distanceMeters;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getAvgSpeedKmH() {
        return this.avgSpeedKmH;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getMaxSpeedKmH() {
        return this.maxSpeedKmH;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final double getElevationGainMeters() {
        return this.elevationGainMeters;
    }

    public final List<TrackPoint> component5() {
        return this.trackPoints;
    }

    public final CleanedRideStats copy(double distanceMeters, double avgSpeedKmH, double maxSpeedKmH, double elevationGainMeters, List<TrackPoint> trackPoints) {
        Intrinsics.checkNotNullParameter(trackPoints, "trackPoints");
        return new CleanedRideStats(distanceMeters, avgSpeedKmH, maxSpeedKmH, elevationGainMeters, trackPoints);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CleanedRideStats)) {
            return false;
        }
        CleanedRideStats cleanedRideStats = (CleanedRideStats) other;
        return Double.compare(this.distanceMeters, cleanedRideStats.distanceMeters) == 0 && Double.compare(this.avgSpeedKmH, cleanedRideStats.avgSpeedKmH) == 0 && Double.compare(this.maxSpeedKmH, cleanedRideStats.maxSpeedKmH) == 0 && Double.compare(this.elevationGainMeters, cleanedRideStats.elevationGainMeters) == 0 && Intrinsics.areEqual(this.trackPoints, cleanedRideStats.trackPoints);
    }

    public int hashCode() {
        return (((((((Double.hashCode(this.distanceMeters) * 31) + Double.hashCode(this.avgSpeedKmH)) * 31) + Double.hashCode(this.maxSpeedKmH)) * 31) + Double.hashCode(this.elevationGainMeters)) * 31) + this.trackPoints.hashCode();
    }

    public String toString() {
        return "CleanedRideStats(distanceMeters=" + this.distanceMeters + ", avgSpeedKmH=" + this.avgSpeedKmH + ", maxSpeedKmH=" + this.maxSpeedKmH + ", elevationGainMeters=" + this.elevationGainMeters + ", trackPoints=" + this.trackPoints + ")";
    }

    public CleanedRideStats(double d, double d2, double d3, double d4, List<TrackPoint> trackPoints) {
        Intrinsics.checkNotNullParameter(trackPoints, "trackPoints");
        this.distanceMeters = d;
        this.avgSpeedKmH = d2;
        this.maxSpeedKmH = d3;
        this.elevationGainMeters = d4;
        this.trackPoints = trackPoints;
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

    public final List<TrackPoint> getTrackPoints() {
        return this.trackPoints;
    }
}
