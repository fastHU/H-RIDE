package com.example.ui.navigation;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osmdroid.util.GeoPoint;

/* JADX INFO: compiled from: NavigationManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\fHÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\fHÆ\u0003J[\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\fHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\tHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001b¨\u0006*"}, d2 = {"Lcom/example/ui/navigation/RouteResult;", "", "destinationName", "", "destinationPoint", "Lorg/osmdroid/util/GeoPoint;", "totalDistanceKm", "", "estimatedDurationMin", "", "elevationGainMeters", "points", "", "steps", "Lcom/example/ui/navigation/NavStep;", "<init>", "(Ljava/lang/String;Lorg/osmdroid/util/GeoPoint;DIILjava/util/List;Ljava/util/List;)V", "getDestinationName", "()Ljava/lang/String;", "getDestinationPoint", "()Lorg/osmdroid/util/GeoPoint;", "getTotalDistanceKm", "()D", "getEstimatedDurationMin", "()I", "getElevationGainMeters", "getPoints", "()Ljava/util/List;", "getSteps", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RouteResult {
    public static final int $stable = 8;
    private final String destinationName;
    private final GeoPoint destinationPoint;
    private final int elevationGainMeters;
    private final int estimatedDurationMin;
    private final List<GeoPoint> points;
    private final List<NavStep> steps;
    private final double totalDistanceKm;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RouteResult copy$default(RouteResult routeResult, String str, GeoPoint geoPoint, double d, int i, int i2, List list, List list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = routeResult.destinationName;
        }
        if ((i3 & 2) != 0) {
            geoPoint = routeResult.destinationPoint;
        }
        if ((i3 & 4) != 0) {
            d = routeResult.totalDistanceKm;
        }
        if ((i3 & 8) != 0) {
            i = routeResult.estimatedDurationMin;
        }
        if ((i3 & 16) != 0) {
            i2 = routeResult.elevationGainMeters;
        }
        if ((i3 & 32) != 0) {
            list = routeResult.points;
        }
        if ((i3 & 64) != 0) {
            list2 = routeResult.steps;
        }
        double d2 = d;
        return routeResult.copy(str, geoPoint, d2, i, i2, list, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDestinationName() {
        return this.destinationName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final GeoPoint getDestinationPoint() {
        return this.destinationPoint;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final double getTotalDistanceKm() {
        return this.totalDistanceKm;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getEstimatedDurationMin() {
        return this.estimatedDurationMin;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getElevationGainMeters() {
        return this.elevationGainMeters;
    }

    public final List<GeoPoint> component6() {
        return this.points;
    }

    public final List<NavStep> component7() {
        return this.steps;
    }

    public final RouteResult copy(String destinationName, GeoPoint destinationPoint, double totalDistanceKm, int estimatedDurationMin, int elevationGainMeters, List<? extends GeoPoint> points, List<NavStep> steps) {
        Intrinsics.checkNotNullParameter(destinationName, "destinationName");
        Intrinsics.checkNotNullParameter(destinationPoint, "destinationPoint");
        Intrinsics.checkNotNullParameter(points, "points");
        Intrinsics.checkNotNullParameter(steps, "steps");
        return new RouteResult(destinationName, destinationPoint, totalDistanceKm, estimatedDurationMin, elevationGainMeters, points, steps);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RouteResult)) {
            return false;
        }
        RouteResult routeResult = (RouteResult) other;
        return Intrinsics.areEqual(this.destinationName, routeResult.destinationName) && Intrinsics.areEqual(this.destinationPoint, routeResult.destinationPoint) && Double.compare(this.totalDistanceKm, routeResult.totalDistanceKm) == 0 && this.estimatedDurationMin == routeResult.estimatedDurationMin && this.elevationGainMeters == routeResult.elevationGainMeters && Intrinsics.areEqual(this.points, routeResult.points) && Intrinsics.areEqual(this.steps, routeResult.steps);
    }

    public int hashCode() {
        return (((((((((((this.destinationName.hashCode() * 31) + this.destinationPoint.hashCode()) * 31) + Double.hashCode(this.totalDistanceKm)) * 31) + Integer.hashCode(this.estimatedDurationMin)) * 31) + Integer.hashCode(this.elevationGainMeters)) * 31) + this.points.hashCode()) * 31) + this.steps.hashCode();
    }

    public String toString() {
        return "RouteResult(destinationName=" + this.destinationName + ", destinationPoint=" + this.destinationPoint + ", totalDistanceKm=" + this.totalDistanceKm + ", estimatedDurationMin=" + this.estimatedDurationMin + ", elevationGainMeters=" + this.elevationGainMeters + ", points=" + this.points + ", steps=" + this.steps + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RouteResult(String destinationName, GeoPoint destinationPoint, double d, int i, int i2, List<? extends GeoPoint> points, List<NavStep> steps) {
        Intrinsics.checkNotNullParameter(destinationName, "destinationName");
        Intrinsics.checkNotNullParameter(destinationPoint, "destinationPoint");
        Intrinsics.checkNotNullParameter(points, "points");
        Intrinsics.checkNotNullParameter(steps, "steps");
        this.destinationName = destinationName;
        this.destinationPoint = destinationPoint;
        this.totalDistanceKm = d;
        this.estimatedDurationMin = i;
        this.elevationGainMeters = i2;
        this.points = points;
        this.steps = steps;
    }

    public final String getDestinationName() {
        return this.destinationName;
    }

    public final GeoPoint getDestinationPoint() {
        return this.destinationPoint;
    }

    public final double getTotalDistanceKm() {
        return this.totalDistanceKm;
    }

    public final int getEstimatedDurationMin() {
        return this.estimatedDurationMin;
    }

    public final int getElevationGainMeters() {
        return this.elevationGainMeters;
    }

    public final List<GeoPoint> getPoints() {
        return this.points;
    }

    public final List<NavStep> getSteps() {
        return this.steps;
    }
}
