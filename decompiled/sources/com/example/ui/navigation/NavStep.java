package com.example.ui.navigation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavigationManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/example/ui/navigation/NavStep;", "", "instruction", "", "distanceMeters", "", "iconType", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getInstruction", "()Ljava/lang/String;", "getDistanceMeters", "()I", "getIconType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class NavStep {
    public static final int $stable = 0;
    private final int distanceMeters;
    private final String iconType;
    private final String instruction;

    public static /* synthetic */ NavStep copy$default(NavStep navStep, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = navStep.instruction;
        }
        if ((i2 & 2) != 0) {
            i = navStep.distanceMeters;
        }
        if ((i2 & 4) != 0) {
            str2 = navStep.iconType;
        }
        return navStep.copy(str, i, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getInstruction() {
        return this.instruction;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDistanceMeters() {
        return this.distanceMeters;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getIconType() {
        return this.iconType;
    }

    public final NavStep copy(String instruction, int distanceMeters, String iconType) {
        Intrinsics.checkNotNullParameter(instruction, "instruction");
        Intrinsics.checkNotNullParameter(iconType, "iconType");
        return new NavStep(instruction, distanceMeters, iconType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NavStep)) {
            return false;
        }
        NavStep navStep = (NavStep) other;
        return Intrinsics.areEqual(this.instruction, navStep.instruction) && this.distanceMeters == navStep.distanceMeters && Intrinsics.areEqual(this.iconType, navStep.iconType);
    }

    public int hashCode() {
        return (((this.instruction.hashCode() * 31) + Integer.hashCode(this.distanceMeters)) * 31) + this.iconType.hashCode();
    }

    public String toString() {
        return "NavStep(instruction=" + this.instruction + ", distanceMeters=" + this.distanceMeters + ", iconType=" + this.iconType + ")";
    }

    public NavStep(String instruction, int i, String iconType) {
        Intrinsics.checkNotNullParameter(instruction, "instruction");
        Intrinsics.checkNotNullParameter(iconType, "iconType");
        this.instruction = instruction;
        this.distanceMeters = i;
        this.iconType = iconType;
    }

    public final String getInstruction() {
        return this.instruction;
    }

    public final int getDistanceMeters() {
        return this.distanceMeters;
    }

    public final String getIconType() {
        return this.iconType;
    }
}
