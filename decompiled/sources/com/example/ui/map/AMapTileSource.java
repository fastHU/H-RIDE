package com.example.ui.map;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osmdroid.tileprovider.tilesource.XYTileSource;
import org.osmdroid.util.MapTileIndex;

/* JADX INFO: compiled from: OsmMapView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/example/ui/map/AMapTileSource;", "Lorg/osmdroid/tileprovider/tilesource/XYTileSource;", "name", "", "style", "", "isSatellite", "", "zoomMin", "zoomMax", "<init>", "(Ljava/lang/String;IZII)V", "getTileURLString", "pMapTileIndex", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class AMapTileSource extends XYTileSource {
    private final boolean isSatellite;
    private final int style;

    public /* synthetic */ AMapTileSource(String str, int i, boolean z, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i4 & 4) != 0 ? false : z, (i4 & 8) != 0 ? 3 : i2, (i4 & 16) != 0 ? 18 : i3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AMapTileSource(String name, int i, boolean z, int i2, int i3) {
        String[] strArr;
        Intrinsics.checkNotNullParameter(name, "name");
        if (z) {
            strArr = new String[]{"https://webst01.is.autonavi.com/appmaptile", "https://webst02.is.autonavi.com/appmaptile", "https://webst03.is.autonavi.com/appmaptile", "https://webst04.is.autonavi.com/appmaptile"};
        } else {
            strArr = new String[]{"https://webrd01.is.autonavi.com/appmaptile", "https://webrd02.is.autonavi.com/appmaptile", "https://webrd03.is.autonavi.com/appmaptile", "https://webrd04.is.autonavi.com/appmaptile"};
        }
        super(name, i2, i3, 256, ".png", strArr, "© 高德地图 AMap");
        this.style = i;
        this.isSatellite = z;
    }

    @Override // org.osmdroid.tileprovider.tilesource.XYTileSource, org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase
    public String getTileURLString(long pMapTileIndex) {
        int zoom = MapTileIndex.getZoom(pMapTileIndex);
        int x = MapTileIndex.getX(pMapTileIndex);
        int y = MapTileIndex.getY(pMapTileIndex);
        String baseUrl = getBaseUrl();
        boolean z = this.isSatellite;
        int i = this.style;
        return z ? baseUrl + "?style=" + i + "&x=" + x + "&y=" + y + "&z=" + zoom : baseUrl + "?lang=zh_cn&size=1&scale=1&style=" + i + "&x=" + x + "&y=" + y + "&z=" + zoom;
    }
}
