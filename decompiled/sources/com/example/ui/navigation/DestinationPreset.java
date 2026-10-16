package com.example.ui.navigation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osmdroid.util.GeoPoint;

/* JADX INFO: compiled from: NavigationManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/example/ui/navigation/DestinationPreset;", "", "name", "", "description", "point", "Lorg/osmdroid/util/GeoPoint;", "category", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lorg/osmdroid/util/GeoPoint;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getDescription", "getPoint", "()Lorg/osmdroid/util/GeoPoint;", "getCategory", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DestinationPreset {
    public static final int $stable = 8;
    private final String category;
    private final String description;
    private final String name;
    private final GeoPoint point;

    public static /* synthetic */ DestinationPreset copy$default(DestinationPreset destinationPreset, String str, String str2, GeoPoint geoPoint, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = destinationPreset.name;
        }
        if ((i & 2) != 0) {
            str2 = destinationPreset.description;
        }
        if ((i & 4) != 0) {
            geoPoint = destinationPreset.point;
        }
        if ((i & 8) != 0) {
            str3 = destinationPreset.category;
        }
        return destinationPreset.copy(str, str2, geoPoint, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GeoPoint getPoint() {
        return this.point;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    public final DestinationPreset copy(String name, String description, GeoPoint point, String category) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(point, "point");
        Intrinsics.checkNotNullParameter(category, "category");
        return new DestinationPreset(name, description, point, category);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DestinationPreset)) {
            return false;
        }
        DestinationPreset destinationPreset = (DestinationPreset) other;
        return Intrinsics.areEqual(this.name, destinationPreset.name) && Intrinsics.areEqual(this.description, destinationPreset.description) && Intrinsics.areEqual(this.point, destinationPreset.point) && Intrinsics.areEqual(this.category, destinationPreset.category);
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.description.hashCode()) * 31) + this.point.hashCode()) * 31) + this.category.hashCode();
    }

    public String toString() {
        return "DestinationPreset(name=" + this.name + ", description=" + this.description + ", point=" + this.point + ", category=" + this.category + ")";
    }

    public DestinationPreset(String name, String description, GeoPoint point, String category) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(point, "point");
        Intrinsics.checkNotNullParameter(category, "category");
        this.name = name;
        this.description = description;
        this.point = point;
        this.category = category;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }

    public final GeoPoint getPoint() {
        return this.point;
    }

    public /* synthetic */ DestinationPreset(String str, String str2, GeoPoint geoPoint, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, geoPoint, (i & 8) != 0 ? "经典骑行线" : str3);
    }

    public final String getCategory() {
        return this.category;
    }
}
