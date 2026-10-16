package com.example.ui.navigation;

import androidx.compose.animation.core.AnimationConstants;
import androidx.compose.runtime.ComposerKt;
import com.google.android.gms.actions.SearchIntents;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.osmdroid.util.GeoPoint;

/* JADX INFO: compiled from: NavigationManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006J\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fJ\u0016\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\fJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/example/ui/navigation/NavigationManager;", "", "<init>", "()V", "PRESET_DESTINATIONS", "", "Lcom/example/ui/navigation/DestinationPreset;", "getPRESET_DESTINATIONS", "()Ljava/util/List;", "calculateRoute", "Lcom/example/ui/navigation/RouteResult;", "startPoint", "Lorg/osmdroid/util/GeoPoint;", "destPreset", "calculateRouteToPoint", "destName", "", "destPoint", "searchDestination", SearchIntents.EXTRA_QUERY, "currentPos", "calculateHaversineDistanceKm", "", "p1", "p2", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NavigationManager {
    public static final NavigationManager INSTANCE = new NavigationManager();
    private static final List<DestinationPreset> PRESET_DESTINATIONS = CollectionsKt.listOf((Object[]) new DestinationPreset[]{new DestinationPreset("龙井村", "经典龙井爬坡盘山路", new GeoPoint(30.2221d, 120.1192d), "盘山爬坡"), new DestinationPreset("运河广场", "拱墅区滨水休闲骑行线", new GeoPoint(30.3168d, 120.1415d), "平路巡航"), new DestinationPreset("九溪十八涧", "越野林荫越野骑行线", new GeoPoint(30.2012d, 120.1251d), "山地越野"), new DestinationPreset("天目山", "高海拔连续陡坡挑战线", new GeoPoint(30.3452d, 119.4312d), "高山挑战"), new DestinationPreset("莫干山", "竹海风光山地骑行线", new GeoPoint(30.6123d, 119.8512d), "景区巡游"), new DestinationPreset("千岛湖绿道", "环湖景观绿道巡航线", new GeoPoint(29.6051d, 119.0431d), "环湖长途")});
    public static final int $stable = 8;

    private NavigationManager() {
    }

    public final List<DestinationPreset> getPRESET_DESTINATIONS() {
        return PRESET_DESTINATIONS;
    }

    public final RouteResult calculateRoute(GeoPoint startPoint, DestinationPreset destPreset) {
        Intrinsics.checkNotNullParameter(startPoint, "startPoint");
        Intrinsics.checkNotNullParameter(destPreset, "destPreset");
        return calculateRouteToPoint(startPoint, destPreset.getName(), destPreset.getPoint());
    }

    public final RouteResult calculateRouteToPoint(GeoPoint startPoint, String destName, GeoPoint destPoint) {
        char c;
        int i;
        List listListOf;
        Intrinsics.checkNotNullParameter(startPoint, "startPoint");
        Intrinsics.checkNotNullParameter(destName, "destName");
        Intrinsics.checkNotNullParameter(destPoint, "destPoint");
        double dCalculateHaversineDistanceKm = calculateHaversineDistanceKm(startPoint, destPoint);
        double dMax = Math.max(0.05d, 1.05d * dCalculateHaversineDistanceKm);
        char c2 = 1;
        int iMax = Math.max(1, MathKt.roundToInt((dMax / 18.0d) * 60.0d));
        int i2 = (int) (12.0d * dMax);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            double d = ((double) i3) / 20.0d;
            c = c2;
            i = i2;
            int i4 = i3;
            double dMin = Math.min(8.0E-4d, dCalculateHaversineDistanceKm * 0.02d);
            double d2 = 3.141592653589793d * d;
            arrayList.add(new GeoPoint(startPoint.getLatitude() + ((destPoint.getLatitude() - startPoint.getLatitude()) * d) + (Math.sin(d2) * dMin), startPoint.getLongitude() + ((destPoint.getLongitude() - startPoint.getLongitude()) * d) + (Math.cos(d2 * 0.5d) * dMin * 0.5d)));
            if (i4 == 20) {
                break;
            }
            i3 = i4 + 1;
            c2 = c;
            i2 = i;
        }
        int i5 = (int) (1000.0d * dMax);
        if (dMax < 0.5d) {
            NavStep[] navStepArr = new NavStep[2];
            navStepArr[0] = new NavStep("从当前位置出发，沿前面道路直行", (int) (((double) i5) * 0.8d), "straight");
            navStepArr[c] = new NavStep("前方 30 米 到达目的地：" + destName, 30, "destination");
            listListOf = CollectionsKt.listOf((Object[]) navStepArr);
        } else {
            NavStep[] navStepArr2 = new NavStep[4];
            navStepArr2[0] = new NavStep("从当前起点出发，沿骑行道直行", (int) (250.0d * dMax), "straight");
            navStepArr2[c] = new NavStep("前方 200 米 稍向右转 进入巡航路线", ComposerKt.invocationKey, "turn_right");
            navStepArr2[2] = new NavStep("前方 100 米 左转 进入 " + destName + " 抵达段", 100, "turn_left");
            navStepArr2[3] = new NavStep("即将到达目的地：" + destName, 30, "destination");
            listListOf = CollectionsKt.listOf((Object[]) navStepArr2);
        }
        return new RouteResult(destName, destPoint, ((double) MathKt.roundToInt(dMax * 100.0d)) / 100.0d, iMax, i, arrayList, listListOf);
    }

    public final RouteResult searchDestination(String query, GeoPoint currentPos) {
        Object next;
        double dAbs;
        DestinationPreset destinationPreset;
        String str;
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(currentPos, "currentPos");
        String string = StringsKt.trim((CharSequence) query).toString();
        Iterator<T> it = PRESET_DESTINATIONS.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            destinationPreset = (DestinationPreset) next;
            str = string;
            if (StringsKt.contains((CharSequence) destinationPreset.getName(), (CharSequence) str, true)) {
                break;
            }
        } while (!StringsKt.contains((CharSequence) str, (CharSequence) destinationPreset.getName(), true));
        DestinationPreset destinationPreset2 = (DestinationPreset) next;
        if (destinationPreset2 != null) {
            return calculateRoute(currentPos, destinationPreset2);
        }
        Regex regex = new Regex("(\\d+)\\s*(米|m|M)");
        Regex regex2 = new Regex("(\\d+(\\.\\d+)?)\\s*(公里|km|KM)");
        String str2 = string;
        MatchResult matchResultFind$default = Regex.find$default(regex, str2, 0, 2, null);
        MatchResult matchResultFind$default2 = Regex.find$default(regex2, str2, 0, 2, null);
        if (matchResultFind$default != null) {
            Double doubleOrNull = StringsKt.toDoubleOrNull(matchResultFind$default.getGroupValues().get(1));
            dAbs = (doubleOrNull != null ? doubleOrNull.doubleValue() : 200.0d) / 1000.0d;
        } else if (matchResultFind$default2 != null) {
            Double doubleOrNull2 = StringsKt.toDoubleOrNull(matchResultFind$default2.getGroupValues().get(1));
            dAbs = doubleOrNull2 != null ? doubleOrNull2.doubleValue() : 1.0d;
        } else {
            dAbs = (((double) (Math.abs(string.hashCode()) % AnimationConstants.DefaultDurationMillis)) + 200.0d) / 1000.0d;
        }
        GeoPoint geoPoint = new GeoPoint(currentPos.getLatitude() + ((dAbs / 111.0d) * 0.8d), currentPos.getLongitude() + ((dAbs / (Math.cos(Math.toRadians(currentPos.getLatitude())) * 111.0d)) * 0.6d));
        if (str2.length() <= 0) {
            string = "自定义目的地";
        }
        return calculateRouteToPoint(currentPos, string, geoPoint);
    }

    private final double calculateHaversineDistanceKm(GeoPoint p1, GeoPoint p2) {
        double radians = Math.toRadians(p2.getLatitude() - p1.getLatitude());
        double d = radians / 2.0d;
        double radians2 = Math.toRadians(p2.getLongitude() - p1.getLongitude()) / 2.0d;
        double dSin = (Math.sin(d) * Math.sin(d)) + (Math.cos(Math.toRadians(p1.getLatitude())) * Math.cos(Math.toRadians(p2.getLatitude())) * Math.sin(radians2) * Math.sin(radians2));
        return 2.0d * Math.atan2(Math.sqrt(dSin), Math.sqrt(1.0d - dSin)) * 6371.0d;
    }
}
