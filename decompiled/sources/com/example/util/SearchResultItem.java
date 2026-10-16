package com.example.util;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osmdroid.util.GeoPoint;

/* JADX INFO: compiled from: LocationSearchRepository.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/example/util/SearchResultItem;", "", "name", "", "branchDetail", "point", "Lorg/osmdroid/util/GeoPoint;", "distanceMeters", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lorg/osmdroid/util/GeoPoint;D)V", "getName", "()Ljava/lang/String;", "getBranchDetail", "getPoint", "()Lorg/osmdroid/util/GeoPoint;", "getDistanceMeters", "()D", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SearchResultItem {
    public static final int $stable = 8;
    private final String branchDetail;
    private final double distanceMeters;
    private final String name;
    private final GeoPoint point;

    public static /* synthetic */ SearchResultItem copy$default(SearchResultItem searchResultItem, String str, String str2, GeoPoint geoPoint, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = searchResultItem.name;
        }
        if ((i & 2) != 0) {
            str2 = searchResultItem.branchDetail;
        }
        if ((i & 4) != 0) {
            geoPoint = searchResultItem.point;
        }
        if ((i & 8) != 0) {
            d = searchResultItem.distanceMeters;
        }
        GeoPoint geoPoint2 = geoPoint;
        return searchResultItem.copy(str, str2, geoPoint2, d);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBranchDetail() {
        return this.branchDetail;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GeoPoint getPoint() {
        return this.point;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final double getDistanceMeters() {
        return this.distanceMeters;
    }

    public final SearchResultItem copy(String name, String branchDetail, GeoPoint point, double distanceMeters) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(point, "point");
        return new SearchResultItem(name, branchDetail, point, distanceMeters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchResultItem)) {
            return false;
        }
        SearchResultItem searchResultItem = (SearchResultItem) other;
        return Intrinsics.areEqual(this.name, searchResultItem.name) && Intrinsics.areEqual(this.branchDetail, searchResultItem.branchDetail) && Intrinsics.areEqual(this.point, searchResultItem.point) && Double.compare(this.distanceMeters, searchResultItem.distanceMeters) == 0;
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        String str = this.branchDetail;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.point.hashCode()) * 31) + Double.hashCode(this.distanceMeters);
    }

    public String toString() {
        return "SearchResultItem(name=" + this.name + ", branchDetail=" + this.branchDetail + ", point=" + this.point + ", distanceMeters=" + this.distanceMeters + ")";
    }

    public SearchResultItem(String name, String str, GeoPoint point, double d) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(point, "point");
        this.name = name;
        this.branchDetail = str;
        this.point = point;
        this.distanceMeters = d;
    }

    public /* synthetic */ SearchResultItem(String str, String str2, GeoPoint geoPoint, double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, geoPoint, d);
    }

    public final String getName() {
        return this.name;
    }

    public final String getBranchDetail() {
        return this.branchDetail;
    }

    public final GeoPoint getPoint() {
        return this.point;
    }

    public final double getDistanceMeters() {
        return this.distanceMeters;
    }
}
