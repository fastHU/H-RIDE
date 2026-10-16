package com.example.util;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import androidx.core.app.NotificationCompat;
import coil.disk.DiskLruCache;
import com.google.android.gms.actions.SearchIntents;
import io.ktor.sse.ServerSentEventKt;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.osmdroid.util.GeoPoint;

/* JADX INFO: compiled from: LocationSearchRepository.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0002J\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0012R \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/example/util/LocationSearchRepository;", "", "<init>", "()V", "POI_DATABASE", "", "Lkotlin/Pair;", "", "Lorg/osmdroid/util/GeoPoint;", "CHAIN_KEYWORDS", "searchLocations", "Lcom/example/util/SearchResultItem;", "context", "Landroid/content/Context;", SearchIntents.EXTRA_QUERY, "currentPos", "(Landroid/content/Context;Ljava/lang/String;Lorg/osmdroid/util/GeoPoint;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateDistanceMeters", "", "start", "end", "formatDistance", "meters", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LocationSearchRepository {
    public static final LocationSearchRepository INSTANCE = new LocationSearchRepository();
    private static final List<Pair<String, GeoPoint>> POI_DATABASE = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("龙井村", new GeoPoint(30.2221d, 120.1192d)), TuplesKt.to("龙井茶叶基地", new GeoPoint(30.2185d, 120.115d)), TuplesKt.to("西湖", new GeoPoint(30.2438d, 120.1509d)), TuplesKt.to("西湖三潭印月", new GeoPoint(30.237d, 120.149d)), TuplesKt.to("断桥", new GeoPoint(30.2438d, 120.1509d)), TuplesKt.to("雷峰塔", new GeoPoint(30.2312d, 120.1487d)), TuplesKt.to("灵隐寺", new GeoPoint(30.2415d, 120.1002d)), TuplesKt.to("运河广场", new GeoPoint(30.3168d, 120.1415d)), TuplesKt.to("拱宸桥", new GeoPoint(30.318d, 120.141d)), TuplesKt.to("九溪", new GeoPoint(30.2012d, 120.1251d)), TuplesKt.to("千岛湖", new GeoPoint(29.6051d, 119.0431d)), TuplesKt.to("钱江新城", new GeoPoint(30.2482d, 120.212d)), TuplesKt.to("湘湖", new GeoPoint(30.1385d, 120.2158d)), TuplesKt.to("浙江大学紫金港校区", new GeoPoint(30.3015d, 120.088d)), TuplesKt.to("浙江大学玉泉校区", new GeoPoint(30.2638d, 120.1228d)), TuplesKt.to("浙江大学西溪校区", new GeoPoint(30.2745d, 120.136d)), TuplesKt.to("浙大", new GeoPoint(30.3015d, 120.088d)), TuplesKt.to("杭州东站", new GeoPoint(30.2902d, 120.2131d)), TuplesKt.to("萧山机场", new GeoPoint(30.2295d, 120.4344d)), TuplesKt.to("杭州城站", new GeoPoint(30.2425d, 120.1822d)), TuplesKt.to("阿里巴巴", new GeoPoint(30.2782d, 120.0258d)), TuplesKt.to("西溪湿地", new GeoPoint(30.2642d, 120.0658d)), TuplesKt.to("武林广场", new GeoPoint(30.2741d, 120.1551d)), TuplesKt.to("杭州", new GeoPoint(30.2741d, 120.1551d)), TuplesKt.to("外滩", new GeoPoint(31.2397d, 121.49d)), TuplesKt.to("东方明珠", new GeoPoint(31.2397d, 121.4998d)), TuplesKt.to("迪士尼", new GeoPoint(31.1412d, 121.6622d)), TuplesKt.to("上海", new GeoPoint(31.2304d, 121.4737d)), TuplesKt.to("陆家嘴", new GeoPoint(31.2352d, 121.5057d)), TuplesKt.to("南京路", new GeoPoint(31.2355d, 121.4782d)), TuplesKt.to("天安门", new GeoPoint(39.9087d, 116.3975d)), TuplesKt.to("故宫", new GeoPoint(39.9163d, 116.3972d)), TuplesKt.to("鸟巢", new GeoPoint(39.993d, 116.3964d)), TuplesKt.to("北京", new GeoPoint(39.9042d, 116.4074d)), TuplesKt.to("长城", new GeoPoint(40.4319d, 116.5704d)), TuplesKt.to("广州", new GeoPoint(23.1291d, 113.2644d)), TuplesKt.to("广州塔", new GeoPoint(23.1065d, 113.3245d)), TuplesKt.to("白云山", new GeoPoint(23.1788d, 113.2973d)), TuplesKt.to("深圳", new GeoPoint(22.5431d, 114.0579d)), TuplesKt.to("深圳湾", new GeoPoint(22.502d, 113.951d)), TuplesKt.to("成都", new GeoPoint(30.5728d, 104.0668d)), TuplesKt.to("太古里", new GeoPoint(30.653d, 104.083d)), TuplesKt.to("重庆", new GeoPoint(29.563d, 106.5516d)), TuplesKt.to("洪崖洞", new GeoPoint(29.5605d, 106.5788d)), TuplesKt.to("南京", new GeoPoint(32.0603d, 118.7969d)), TuplesKt.to("苏州", new GeoPoint(31.2989d, 120.5853d)), TuplesKt.to("武汉", new GeoPoint(30.5928d, 114.3055d)), TuplesKt.to("西安", new GeoPoint(34.3416d, 108.9398d))});
    private static final List<String> CHAIN_KEYWORDS = CollectionsKt.listOf((Object[]) new String[]{"华润万家", "华润", "万家", "星巴克", "肯德基", "麦当劳", "沃尔玛", "永辉", "盒马", "全家", "罗森", "7-eleven", "711", "便利店", "超市", "瑞幸", "喜茶", "霸王茶姬", "蜜雪冰城", "迪卡侬", "加油站", "公厕", "停车场", "中国银行", "建设银行", "工商银行", "农业银行", "招商银行", "公园", "大润发", "物美", "联华", "世纪联华", "吉野家", "必胜客", "海底捞", "汉堡王", "古茗", "茶百道"});
    public static final int $stable = 8;

    private LocationSearchRepository() {
    }

    /* JADX INFO: renamed from: com.example.util.LocationSearchRepository$searchLocations$2, reason: invalid class name */
    /* JADX INFO: compiled from: LocationSearchRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/example/util/SearchResultItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.util.LocationSearchRepository$searchLocations$2", f = "LocationSearchRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends SearchResultItem>>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ GeoPoint $currentPos;
        final /* synthetic */ String $query;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, GeoPoint geoPoint, Context context, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$query = str;
            this.$currentPos = geoPoint;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$query, this.$currentPos, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends SearchResultItem>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<SearchResultItem>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<SearchResultItem>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:143:0x04ed  */
        /* JADX WARN: Code duplicated, block: B:145:0x0501  */
        /* JADX WARN: Code duplicated, block: B:146:0x050b  */
        /* JADX WARN: Code duplicated, block: B:148:0x0518  */
        /* JADX WARN: Code duplicated, block: B:152:0x0522  */
        /* JADX WARN: Code duplicated, block: B:154:0x0525  */
        /* JADX WARN: Code duplicated, block: B:159:0x0543 A[LOOP:3: B:157:0x053d->B:159:0x0543, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:165:0x05b4 A[Catch: Exception -> 0x065e, TryCatch #13 {Exception -> 0x065e, blocks: (B:163:0x05ab, B:165:0x05b4, B:171:0x05c1, B:172:0x05c9, B:174:0x05cf, B:176:0x05e8, B:178:0x05ee, B:180:0x05f4, B:184:0x05fd), top: B:332:0x05ab }] */
        /* JADX WARN: Code duplicated, block: B:169:0x05be  */
        /* JADX WARN: Code duplicated, block: B:171:0x05c1 A[Catch: Exception -> 0x065e, TryCatch #13 {Exception -> 0x065e, blocks: (B:163:0x05ab, B:165:0x05b4, B:171:0x05c1, B:172:0x05c9, B:174:0x05cf, B:176:0x05e8, B:178:0x05ee, B:180:0x05f4, B:184:0x05fd), top: B:332:0x05ab }] */
        /* JADX WARN: Code duplicated, block: B:174:0x05cf A[Catch: Exception -> 0x065e, TryCatch #13 {Exception -> 0x065e, blocks: (B:163:0x05ab, B:165:0x05b4, B:171:0x05c1, B:172:0x05c9, B:174:0x05cf, B:176:0x05e8, B:178:0x05ee, B:180:0x05f4, B:184:0x05fd), top: B:332:0x05ab }] */
        /* JADX WARN: Code duplicated, block: B:176:0x05e8 A[Catch: Exception -> 0x065e, TryCatch #13 {Exception -> 0x065e, blocks: (B:163:0x05ab, B:165:0x05b4, B:171:0x05c1, B:172:0x05c9, B:174:0x05cf, B:176:0x05e8, B:178:0x05ee, B:180:0x05f4, B:184:0x05fd), top: B:332:0x05ab }] */
        /* JADX WARN: Code duplicated, block: B:183:0x05fc A[PHI: r10
          0x05fc: PHI (r10v15 java.lang.String) = (r10v14 java.lang.String), (r10v18 java.lang.String), (r10v19 java.lang.String), (r10v20 java.lang.String) binds: [B:175:0x05e6, B:177:0x05ec, B:179:0x05f2, B:181:0x05f8] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:190:0x063e  */
        /* JADX WARN: Code duplicated, block: B:197:0x065a  */
        /* JADX WARN: Code duplicated, block: B:206:0x06f3 A[Catch: Exception -> 0x07d1, TryCatch #9 {Exception -> 0x07d1, blocks: (B:204:0x0690, B:206:0x06f3, B:208:0x0709, B:210:0x0714, B:212:0x0727, B:214:0x075f, B:219:0x0771, B:221:0x0778, B:223:0x07b0, B:209:0x070c), top: B:324:0x0690 }] */
        /* JADX WARN: Code duplicated, block: B:208:0x0709 A[Catch: Exception -> 0x07d1, TryCatch #9 {Exception -> 0x07d1, blocks: (B:204:0x0690, B:206:0x06f3, B:208:0x0709, B:210:0x0714, B:212:0x0727, B:214:0x075f, B:219:0x0771, B:221:0x0778, B:223:0x07b0, B:209:0x070c), top: B:324:0x0690 }] */
        /* JADX WARN: Code duplicated, block: B:209:0x070c A[Catch: Exception -> 0x07d1, TryCatch #9 {Exception -> 0x07d1, blocks: (B:204:0x0690, B:206:0x06f3, B:208:0x0709, B:210:0x0714, B:212:0x0727, B:214:0x075f, B:219:0x0771, B:221:0x0778, B:223:0x07b0, B:209:0x070c), top: B:324:0x0690 }] */
        /* JADX WARN: Code duplicated, block: B:212:0x0727 A[Catch: Exception -> 0x07d1, TryCatch #9 {Exception -> 0x07d1, blocks: (B:204:0x0690, B:206:0x06f3, B:208:0x0709, B:210:0x0714, B:212:0x0727, B:214:0x075f, B:219:0x0771, B:221:0x0778, B:223:0x07b0, B:209:0x070c), top: B:324:0x0690 }] */
        /* JADX WARN: Code duplicated, block: B:214:0x075f A[Catch: Exception -> 0x07d1, TryCatch #9 {Exception -> 0x07d1, blocks: (B:204:0x0690, B:206:0x06f3, B:208:0x0709, B:210:0x0714, B:212:0x0727, B:214:0x075f, B:219:0x0771, B:221:0x0778, B:223:0x07b0, B:209:0x070c), top: B:324:0x0690 }] */
        /* JADX WARN: Code duplicated, block: B:218:0x076f  */
        /* JADX WARN: Code duplicated, block: B:221:0x0778 A[Catch: Exception -> 0x07d1, TryCatch #9 {Exception -> 0x07d1, blocks: (B:204:0x0690, B:206:0x06f3, B:208:0x0709, B:210:0x0714, B:212:0x0727, B:214:0x075f, B:219:0x0771, B:221:0x0778, B:223:0x07b0, B:209:0x070c), top: B:324:0x0690 }] */
        /* JADX WARN: Code duplicated, block: B:222:0x07ae  */
        /* JADX WARN: Code duplicated, block: B:227:0x07d1 A[PHI: r31
          0x07d1: PHI (r31v2 java.util.ArrayList) = (r31v1 java.util.ArrayList), (r31v0 java.util.ArrayList), (r31v3 java.util.ArrayList) binds: [B:305:0x07d1, B:205:0x06f1, B:367:0x07d1] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:231:0x07df  */
        /* JADX WARN: Code duplicated, block: B:234:0x07ed  */
        /* JADX WARN: Code duplicated, block: B:237:0x07f7  */
        /* JADX WARN: Code duplicated, block: B:239:0x0808  */
        /* JADX WARN: Code duplicated, block: B:243:0x0812  */
        /* JADX WARN: Code duplicated, block: B:246:0x0817 A[LOOP:10: B:235:0x07f1->B:246:0x0817, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:250:0x082b  */
        /* JADX WARN: Code duplicated, block: B:251:0x082d  */
        /* JADX WARN: Code duplicated, block: B:254:0x083d A[LOOP:9: B:252:0x0837->B:254:0x083d, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:257:0x0852  */
        /* JADX WARN: Code duplicated, block: B:258:0x0857  */
        /* JADX WARN: Code duplicated, block: B:260:0x085e  */
        /* JADX WARN: Code duplicated, block: B:265:0x086e  */
        /* JADX WARN: Code duplicated, block: B:268:0x08d9  */
        /* JADX WARN: Code duplicated, block: B:270:0x08e1  */
        /* JADX WARN: Code duplicated, block: B:273:0x094d  */
        /* JADX WARN: Code duplicated, block: B:279:0x0982  */
        /* JADX WARN: Code duplicated, block: B:284:0x09b8  */
        /* JADX WARN: Code duplicated, block: B:290:0x09ef  */
        /* JADX WARN: Code duplicated, block: B:292:0x0a03  */
        /* JADX WARN: Code duplicated, block: B:293:0x0a06  */
        /* JADX WARN: Code duplicated, block: B:299:0x0a19  */
        /* JADX WARN: Code duplicated, block: B:363:0x0528 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:369:0x09c9 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:371:0x09b2 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:374:0x0a09 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:376:0x09e9 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:382:0x0815 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:383:0x081a A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:398:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:57:0x0251  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v64, types: [java.io.Reader] */
        /* JADX WARN: Type inference failed for: r14v0 */
        /* JADX WARN: Type inference failed for: r14v1 */
        /* JADX WARN: Type inference failed for: r14v2 */
        /* JADX WARN: Type inference failed for: r14v22 */
        /* JADX WARN: Type inference failed for: r14v3 */
        /* JADX WARN: Type inference failed for: r14v31 */
        /* JADX WARN: Type inference failed for: r14v32 */
        /* JADX WARN: Type inference failed for: r14v35 */
        /* JADX WARN: Type inference failed for: r14v4 */
        /* JADX WARN: Type inference failed for: r14v5 */
        /* JADX WARN: Type inference failed for: r18v24 */
        /* JADX WARN: Type inference failed for: r18v25 */
        /* JADX WARN: Type inference failed for: r18v26 */
        /* JADX WARN: Type inference failed for: r18v28 */
        /* JADX WARN: Type inference failed for: r18v30 */
        /* JADX WARN: Type inference failed for: r18v31 */
        /* JADX WARN: Type inference failed for: r18v32 */
        /* JADX WARN: Type inference failed for: r39v4 */
        /* JADX WARN: Type inference failed for: r3v22, types: [java.io.Reader] */
        /* JADX WARN: Type inference failed for: r8v43, types: [java.io.Reader] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ArrayList arrayList;
            int i;
            ArrayList<Pair> arrayList2;
            String str;
            String str2;
            GeoPoint geoPoint;
            int i2;
            int i3;
            String str3;
            String str4;
            ArrayList arrayList3;
            List list;
            Iterator it;
            String str5;
            ?? r14;
            String str6;
            ?? r15;
            Iterator it2;
            double distanceMeters;
            Double dBoxDouble;
            double dDoubleValue;
            int iAbs;
            double d;
            boolean z;
            GeoPoint geoPoint2;
            int i4;
            int i5;
            boolean z2;
            String str7;
            boolean z3;
            HashSet hashSet;
            ArrayList arrayList4;
            List listSortedWith;
            ArrayList arrayList5;
            ArrayList arrayList6;
            boolean z4;
            ArrayList arrayList7;
            HttpURLConnection httpURLConnection;
            InputStreamReader inputStreamReader;
            BufferedReader bufferedReader;
            JSONArray jSONArray;
            int length;
            int i6;
            List listSplit$default;
            String str8;
            String str9;
            String string;
            String string2;
            List<Address> fromLocationName;
            List<Address> list2;
            ?? r16;
            GeoPoint geoPoint3;
            String featureName;
            String str10;
            String strJoinToString$default;
            String str11;
            String str12;
            String str13;
            String str14;
            boolean zEquals;
            String str15;
            String str16;
            String str17;
            JSONArray jSONArrayOptJSONArray;
            BufferedReader bufferedReader2;
            JSONArray jSONArrayOptJSONArray2;
            String str18 = "UTF-8";
            String str19 = "getInputStream(...)";
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String string3 = StringsKt.trim((CharSequence) this.$query).toString();
            String str20 = string3;
            if (str20.length() == 0) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList8 = new ArrayList();
            int i7 = 3;
            int i8 = 2;
            boolean z5 = false;
            z5 = false;
            z5 = false;
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    int i9 = 1;
                                    Pair<Double, Double> pairWgs84ToGcj02 = GpsCoordinateUtils.INSTANCE.wgs84ToGcj02(this.$currentPos.getLatitude(), this.$currentPos.getLongitude());
                                    double dDoubleValue2 = pairWgs84ToGcj02.component1().doubleValue();
                                    double dDoubleValue3 = pairWgs84ToGcj02.component2().doubleValue();
                                    String strEncode = URLEncoder.encode(string3, "UTF-8");
                                    List listListOf = CollectionsKt.listOf((Object[]) new String[]{"73022e17bfb63481230e84b56b3e947c", "e288e2aebe949219dfa99971ecb1a89c", "2088cb31221448d3a86c679a957d1872", "c0199e5781a7db2e008d3e2308c459f0", "b5e378dfb9f9ff36c243ee7d48347f1d"});
                                    Iterator it3 = listListOf.iterator();
                                    boolean z6 = false;
                                    while (true) {
                                        boolean zHasNext = it3.hasNext();
                                        listListOf = listListOf;
                                        str15 = NotificationCompat.CATEGORY_STATUS;
                                        str18 = str18;
                                        str16 = "&location=";
                                        if (!zHasNext) {
                                            str20 = str20;
                                            break;
                                        }
                                        try {
                                            str20 = str20;
                                            try {
                                                String str21 = (String) it3.next();
                                                if (z6) {
                                                    break;
                                                }
                                                string3 = string3;
                                                try {
                                                    ArrayList arrayList9 = arrayList8;
                                                    try {
                                                        URLConnection uRLConnectionOpenConnection = new URL("https://restapi.amap.com/v3/place/text?keywords=" + strEncode + "&location=" + dDoubleValue3 + "," + dDoubleValue2 + "&offset=10&page=1&extensions=all&key=" + str21).openConnection();
                                                        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                                                        HttpURLConnection httpURLConnection2 = (HttpURLConnection) uRLConnectionOpenConnection;
                                                        httpURLConnection2.setRequestMethod("GET");
                                                        httpURLConnection2.setConnectTimeout(3000);
                                                        httpURLConnection2.setReadTimeout(3000);
                                                        if (httpURLConnection2.getResponseCode() == 200) {
                                                            InputStream inputStream = httpURLConnection2.getInputStream();
                                                            Intrinsics.checkNotNullExpressionValue(inputStream, str19);
                                                            InputStreamReader inputStreamReader2 = new InputStreamReader(inputStream, Charsets.UTF_8);
                                                            if (inputStreamReader2 instanceof BufferedReader) {
                                                                try {
                                                                    bufferedReader2 = (BufferedReader) inputStreamReader2;
                                                                } catch (Exception e) {
                                                                    e = e;
                                                                    str19 = str19;
                                                                    i = i7;
                                                                    arrayList = arrayList9;
                                                                }
                                                            } else {
                                                                bufferedReader2 = new BufferedReader(inputStreamReader2, 8192);
                                                            }
                                                            JSONObject jSONObject = new JSONObject(TextStreamsKt.readText(bufferedReader2));
                                                            if (Intrinsics.areEqual(jSONObject.optString(NotificationCompat.CATEGORY_STATUS), DiskLruCache.VERSION) && (jSONArrayOptJSONArray2 = jSONObject.optJSONArray("pois")) != null && jSONArrayOptJSONArray2.length() > 0) {
                                                                int length2 = jSONArrayOptJSONArray2.length();
                                                                int i10 = z5 ? 1 : 0;
                                                                while (i10 < length2) {
                                                                    JSONObject jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i10);
                                                                    String strOptString = jSONObject2.optString("name");
                                                                    String strOptString2 = jSONObject2.optString("location");
                                                                    String strOptString3 = jSONObject2.optString("address");
                                                                    JSONArray jSONArray2 = jSONArrayOptJSONArray2;
                                                                    String strOptString4 = jSONObject2.optString("adname");
                                                                    jSONObject2.optString("pname");
                                                                    jSONObject2.optString("cityname");
                                                                    Intrinsics.checkNotNull(strOptString2);
                                                                    boolean z7 = z5;
                                                                    int i11 = length2;
                                                                    int i12 = i10;
                                                                    if (StringsKt.contains$default(strOptString2, ",", z7, i8, (Object) null)) {
                                                                        String[] strArr = new String[i9];
                                                                        strArr[z7 ? 1 : 0] = ",";
                                                                        List listSplit$default2 = StringsKt.split$default((CharSequence) strOptString2, strArr, false, 0, 6, (Object) null);
                                                                        Double doubleOrNull = StringsKt.toDoubleOrNull((String) listSplit$default2.get(z7 ? 1 : 0));
                                                                        Double doubleOrNull2 = StringsKt.toDoubleOrNull((String) listSplit$default2.get(1));
                                                                        if (doubleOrNull == null || doubleOrNull2 == null) {
                                                                            str19 = str19;
                                                                            arrayList = arrayList9;
                                                                        } else {
                                                                            str19 = str19;
                                                                            try {
                                                                                Pair<Double, Double> pairGcj02ToWgs84 = GpsCoordinateUtils.INSTANCE.gcj02ToWgs84(doubleOrNull2.doubleValue(), doubleOrNull.doubleValue());
                                                                                GeoPoint geoPoint4 = new GeoPoint(pairGcj02ToWgs84.component1().doubleValue(), pairGcj02ToWgs84.component2().doubleValue());
                                                                                double dCalculateDistanceMeters = LocationSearchRepository.INSTANCE.calculateDistanceMeters(this.$currentPos, geoPoint4);
                                                                                String[] strArr2 = new String[i7];
                                                                                String str22 = strOptString4;
                                                                                if (StringsKt.isBlank(str22)) {
                                                                                    str22 = null;
                                                                                }
                                                                                strArr2[0] = str22;
                                                                                String str23 = strOptString3;
                                                                                if (StringsKt.isBlank(str23)) {
                                                                                    str23 = null;
                                                                                }
                                                                                strArr2[1] = str23;
                                                                                strArr2[2] = "高德地图数据库";
                                                                                String strJoinToString$default2 = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) strArr2), " · ", null, null, 0, null, null, 62, null);
                                                                                Intrinsics.checkNotNull(strOptString);
                                                                                arrayList = arrayList9;
                                                                                try {
                                                                                    arrayList.add(new SearchResultItem(strOptString, strJoinToString$default2, geoPoint4, dCalculateDistanceMeters));
                                                                                } catch (Exception e2) {
                                                                                    e = e2;
                                                                                    i = 3;
                                                                                    z5 = false;
                                                                                    e.printStackTrace();
                                                                                    List list3 = LocationSearchRepository.POI_DATABASE;
                                                                                    arrayList2 = new ArrayList();
                                                                                    for (Object obj2 : list3) {
                                                                                        str11 = (String) ((Pair) obj2).component1();
                                                                                        if (string3.length() < 2) {
                                                                                            str12 = string3;
                                                                                            zEquals = StringsKt.equals(str11, str12, true);
                                                                                            str14 = str20;
                                                                                        } else {
                                                                                            str12 = string3;
                                                                                            str13 = str11;
                                                                                            str14 = str20;
                                                                                            if (StringsKt.contains((CharSequence) str14, (CharSequence) str13, true)) {
                                                                                                zEquals = true;
                                                                                            } else {
                                                                                                zEquals = true;
                                                                                            }
                                                                                        }
                                                                                        if (zEquals) {
                                                                                            arrayList2.add(obj2);
                                                                                        }
                                                                                        string3 = str12;
                                                                                        str20 = str14;
                                                                                    }
                                                                                    str = string3;
                                                                                    str2 = str20;
                                                                                    geoPoint = this.$currentPos;
                                                                                    for (Pair pair : arrayList2) {
                                                                                        String str24 = (String) pair.component1();
                                                                                        GeoPoint geoPoint5 = (GeoPoint) pair.component2();
                                                                                        arrayList.add(new SearchResultItem(str24, "地标/校区", geoPoint5, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint, geoPoint5)));
                                                                                    }
                                                                                    i2 = i;
                                                                                    str3 = str;
                                                                                    str4 = str2;
                                                                                    fromLocationName = new Geocoder(this.$context, Locale.CHINA).getFromLocationName(str3, 5, this.$currentPos.getLatitude() - 0.2d, this.$currentPos.getLongitude() - 0.2d, this.$currentPos.getLatitude() + 0.2d, this.$currentPos.getLongitude() + 0.2d);
                                                                                    list2 = fromLocationName;
                                                                                    if (list2 != null) {
                                                                                        r16 = 1;
                                                                                    } else {
                                                                                        r16 = 1;
                                                                                    }
                                                                                    if (r16 == 0) {
                                                                                        geoPoint3 = this.$currentPos;
                                                                                        for (Address address : fromLocationName) {
                                                                                            GeoPoint geoPoint6 = new GeoPoint(address.getLatitude(), address.getLongitude());
                                                                                            featureName = address.getFeatureName();
                                                                                            if (featureName != null) {
                                                                                                str10 = featureName;
                                                                                            } else {
                                                                                                str10 = featureName;
                                                                                            }
                                                                                            String[] strArr3 = new String[i2];
                                                                                            strArr3[z5 ? 1 : 0] = address.getSubAdminArea();
                                                                                            try {
                                                                                                strArr3[1] = address.getLocality();
                                                                                                i3 = 2;
                                                                                                try {
                                                                                                    strArr3[2] = address.getThoroughfare();
                                                                                                    strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) strArr3), ServerSentEventKt.SPACE, null, null, 0, null, null, 62, null);
                                                                                                    if (StringsKt.isBlank(strJoinToString$default)) {
                                                                                                        strJoinToString$default = null;
                                                                                                    }
                                                                                                    try {
                                                                                                        arrayList.add(new SearchResultItem(str10, strJoinToString$default, geoPoint6, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint3, geoPoint6)));
                                                                                                    } catch (Exception unused) {
                                                                                                    }
                                                                                                } catch (Exception unused2) {
                                                                                                }
                                                                                            } catch (Exception unused3) {
                                                                                                i3 = 2;
                                                                                            }
                                                                                        }
                                                                                        i3 = 2;
                                                                                    } else {
                                                                                        i3 = 2;
                                                                                    }
                                                                                    arrayList7 = arrayList;
                                                                                    URLConnection uRLConnectionOpenConnection2 = new URL("https://nominatim.openstreetmap.org/search?q=" + URLEncoder.encode(str3, str18) + "&format=json&limit=5&viewbox=" + (this.$currentPos.getLongitude() - 0.2d) + "," + (this.$currentPos.getLatitude() + 0.2d) + "," + (this.$currentPos.getLongitude() + 0.2d) + "," + (this.$currentPos.getLatitude() - 0.2d) + "&bounded=0").openConnection();
                                                                                    Intrinsics.checkNotNull(uRLConnectionOpenConnection2, "null cannot be cast to non-null type java.net.HttpURLConnection");
                                                                                    httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection2;
                                                                                    httpURLConnection.setRequestMethod("GET");
                                                                                    httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Android Cycling App)");
                                                                                    httpURLConnection.setConnectTimeout(2500);
                                                                                    httpURLConnection.setReadTimeout(2500);
                                                                                    if (httpURLConnection.getResponseCode() == 200) {
                                                                                        InputStream inputStream2 = httpURLConnection.getInputStream();
                                                                                        Intrinsics.checkNotNullExpressionValue(inputStream2, str19);
                                                                                        inputStreamReader = new InputStreamReader(inputStream2, Charsets.UTF_8);
                                                                                        if (inputStreamReader instanceof BufferedReader) {
                                                                                            bufferedReader = (BufferedReader) inputStreamReader;
                                                                                        } else {
                                                                                            bufferedReader = new BufferedReader(inputStreamReader, 8192);
                                                                                        }
                                                                                        jSONArray = new JSONArray(TextStreamsKt.readText(bufferedReader));
                                                                                        length = jSONArray.length();
                                                                                        i6 = z5 ? 1 : 0;
                                                                                        while (i6 < length) {
                                                                                            JSONObject jSONObject3 = jSONArray.getJSONObject(i6);
                                                                                            double d2 = jSONObject3.getDouble("lat");
                                                                                            double d3 = jSONObject3.getDouble("lon");
                                                                                            String strOptString5 = jSONObject3.optString("display_name", str3);
                                                                                            Intrinsics.checkNotNull(strOptString5);
                                                                                            String[] strArr4 = new String[1];
                                                                                            strArr4[z5 ? 1 : 0] = ",";
                                                                                            listSplit$default = StringsKt.split$default((CharSequence) strOptString5, strArr4, false, 0, 6, (Object) null);
                                                                                            str8 = (String) CollectionsKt.firstOrNull(listSplit$default);
                                                                                            if (str8 != null) {
                                                                                                str9 = str3;
                                                                                            } else {
                                                                                                str9 = str3;
                                                                                            }
                                                                                            if (listSplit$default.size() > 1) {
                                                                                                string = StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(CollectionsKt.drop(CollectionsKt.take(listSplit$default, 3), 1), ", ", null, null, 0, null, null, 62, null)).toString();
                                                                                            } else {
                                                                                                string = null;
                                                                                            }
                                                                                            GeoPoint geoPoint7 = new GeoPoint(d2, d3);
                                                                                            arrayList3 = arrayList7;
                                                                                            try {
                                                                                                arrayList3.add(new SearchResultItem(str9, string, geoPoint7, LocationSearchRepository.INSTANCE.calculateDistanceMeters(this.$currentPos, geoPoint7)));
                                                                                                i6++;
                                                                                                arrayList7 = arrayList3;
                                                                                            } catch (Exception unused4) {
                                                                                            }
                                                                                        }
                                                                                        arrayList3 = arrayList7;
                                                                                    } else {
                                                                                        arrayList3 = arrayList7;
                                                                                    }
                                                                                    list = LocationSearchRepository.CHAIN_KEYWORDS;
                                                                                    if (list instanceof Collection) {
                                                                                        it = list.iterator();
                                                                                        while (true) {
                                                                                            if (!it.hasNext()) {
                                                                                                str5 = str4;
                                                                                                r14 = z5 ? 1 : 0;
                                                                                                break;
                                                                                            }
                                                                                            str6 = (String) it.next();
                                                                                            str5 = str4;
                                                                                            if (StringsKt.contains((CharSequence) str5, (CharSequence) str6, true)) {
                                                                                                r15 = 1;
                                                                                            } else {
                                                                                                r15 = 1;
                                                                                            }
                                                                                            if (r15 != 0) {
                                                                                                r14 = 1;
                                                                                                break;
                                                                                            }
                                                                                            str4 = str5;
                                                                                        }
                                                                                    } else {
                                                                                        it = list.iterator();
                                                                                        while (true) {
                                                                                            if (!it.hasNext()) {
                                                                                                str5 = str4;
                                                                                                r14 = z5 ? 1 : 0;
                                                                                                break;
                                                                                            }
                                                                                            str6 = (String) it.next();
                                                                                            str5 = str4;
                                                                                            if (StringsKt.contains((CharSequence) str5, (CharSequence) str6, true)) {
                                                                                                r15 = 1;
                                                                                            } else {
                                                                                                r15 = 1;
                                                                                            }
                                                                                            if (r15 != 0) {
                                                                                                r14 = 1;
                                                                                                break;
                                                                                            }
                                                                                            str4 = str5;
                                                                                        }
                                                                                    }
                                                                                    ArrayList arrayList10 = arrayList3;
                                                                                    it2 = arrayList10.iterator();
                                                                                    if (it2.hasNext()) {
                                                                                        distanceMeters = ((SearchResultItem) it2.next()).getDistanceMeters();
                                                                                        while (it2.hasNext()) {
                                                                                            distanceMeters = Math.min(distanceMeters, ((SearchResultItem) it2.next()).getDistanceMeters());
                                                                                        }
                                                                                        dBoxDouble = Boxing.boxDouble(distanceMeters);
                                                                                    } else {
                                                                                        dBoxDouble = null;
                                                                                    }
                                                                                    if (dBoxDouble != null) {
                                                                                        dDoubleValue = dBoxDouble.doubleValue();
                                                                                    } else {
                                                                                        dDoubleValue = Double.MAX_VALUE;
                                                                                    }
                                                                                    if (r14 == 0) {
                                                                                        iAbs = Math.abs(str3.hashCode());
                                                                                        Pair[] pairArr = new Pair[4];
                                                                                        d = 180.0d;
                                                                                        pairArr[z5 ? 1 : 0] = new Pair("门口店 / 近邻店", Boxing.boxDouble(180.0d));
                                                                                        z = true;
                                                                                        pairArr[1] = new Pair("社区店", Boxing.boxDouble(420.0d));
                                                                                        pairArr[i3] = new Pair("商业街店", Boxing.boxDouble(850.0d));
                                                                                        pairArr[3] = new Pair("中心店", Boxing.boxDouble(1400.0d));
                                                                                        List listListOf2 = CollectionsKt.listOf((Object[]) pairArr);
                                                                                        geoPoint2 = this.$currentPos;
                                                                                        i4 = z5 ? 1 : 0;
                                                                                        for (Object obj3 : listListOf2) {
                                                                                            int i13 = i4 + 1;
                                                                                            if (i4 < 0) {
                                                                                                CollectionsKt.throwIndexOverflow();
                                                                                            }
                                                                                            Pair pair2 = (Pair) obj3;
                                                                                            String str25 = (String) pair2.component1();
                                                                                            double d4 = (((double) (((i4 * 93) + iAbs) % 360)) * 3.141592653589793d) / d;
                                                                                            double dDoubleValue4 = ((Number) pair2.component2()).doubleValue() / 1000.0d;
                                                                                            GeoPoint geoPoint8 = new GeoPoint(geoPoint2.getLatitude() + ((dDoubleValue4 / 111.0d) * Math.cos(d4)), geoPoint2.getLongitude() + ((dDoubleValue4 / (Math.cos(Math.toRadians(geoPoint2.getLatitude())) * 111.0d)) * Math.sin(d4)));
                                                                                            i5 = i3;
                                                                                            z2 = z5 ? 1 : 0;
                                                                                            if (StringsKt.contains$default(str5, "店", z2, i5, (Object) null)) {
                                                                                                str7 = str3;
                                                                                            } else {
                                                                                                str7 = str3;
                                                                                            }
                                                                                            arrayList3.add(new SearchResultItem(str7, "附近便利点", geoPoint8, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint2, geoPoint8)));
                                                                                            i4 = i13;
                                                                                            i3 = i5;
                                                                                            z5 = z2 ? 1 : 0;
                                                                                            d = 180.0d;
                                                                                        }
                                                                                    } else {
                                                                                        iAbs = Math.abs(str3.hashCode());
                                                                                        Pair[] pairArr2 = new Pair[4];
                                                                                        d = 180.0d;
                                                                                        pairArr2[z5 ? 1 : 0] = new Pair("门口店 / 近邻店", Boxing.boxDouble(180.0d));
                                                                                        z = true;
                                                                                        pairArr2[1] = new Pair("社区店", Boxing.boxDouble(420.0d));
                                                                                        pairArr2[i3] = new Pair("商业街店", Boxing.boxDouble(850.0d));
                                                                                        pairArr2[3] = new Pair("中心店", Boxing.boxDouble(1400.0d));
                                                                                        List listListOf3 = CollectionsKt.listOf((Object[]) pairArr2);
                                                                                        geoPoint2 = this.$currentPos;
                                                                                        i4 = z5 ? 1 : 0;
                                                                                        while (r2.hasNext()) {
                                                                                            int i14 = i4 + 1;
                                                                                            if (i4 < 0) {
                                                                                                CollectionsKt.throwIndexOverflow();
                                                                                            }
                                                                                            Pair pair3 = (Pair) obj3;
                                                                                            String str26 = (String) pair3.component1();
                                                                                            double d5 = (((double) (((i4 * 93) + iAbs) % 360)) * 3.141592653589793d) / d;
                                                                                            double dDoubleValue5 = ((Number) pair3.component2()).doubleValue() / 1000.0d;
                                                                                            GeoPoint geoPoint9 = new GeoPoint(geoPoint2.getLatitude() + ((dDoubleValue5 / 111.0d) * Math.cos(d5)), geoPoint2.getLongitude() + ((dDoubleValue5 / (Math.cos(Math.toRadians(geoPoint2.getLatitude())) * 111.0d)) * Math.sin(d5)));
                                                                                            i5 = i3;
                                                                                            z2 = z5 ? 1 : 0;
                                                                                            if (StringsKt.contains$default(str5, "店", z2, i5, (Object) null)) {
                                                                                                str7 = str3;
                                                                                            } else {
                                                                                                str7 = str3;
                                                                                            }
                                                                                            arrayList3.add(new SearchResultItem(str7, "附近便利点", geoPoint9, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint2, geoPoint9)));
                                                                                            i4 = i14;
                                                                                            i3 = i5;
                                                                                            z5 = z2 ? 1 : 0;
                                                                                            d = 180.0d;
                                                                                        }
                                                                                    }
                                                                                    z3 = z5;
                                                                                    hashSet = new HashSet();
                                                                                    arrayList4 = new ArrayList();
                                                                                    for (Object obj4 : arrayList10) {
                                                                                        if (hashSet.add(((SearchResultItem) obj4).getName())) {
                                                                                            arrayList4.add(obj4);
                                                                                        }
                                                                                    }
                                                                                    listSortedWith = CollectionsKt.sortedWith(arrayList4, new Comparator() { // from class: com.example.util.LocationSearchRepository$searchLocations$2$invokeSuspend$$inlined$sortedBy$1
                                                                                        /* JADX WARN: Multi-variable type inference failed */
                                                                                        @Override // java.util.Comparator
                                                                                        public final int compare(T t, T t2) {
                                                                                            return ComparisonsKt.compareValues(Double.valueOf(((SearchResultItem) t).getDistanceMeters()), Double.valueOf(((SearchResultItem) t2).getDistanceMeters()));
                                                                                        }
                                                                                    });
                                                                                    arrayList5 = new ArrayList();
                                                                                    for (Object obj5 : listSortedWith) {
                                                                                        if (((SearchResultItem) obj5).getDistanceMeters() <= 30000.0d) {
                                                                                            z4 = z;
                                                                                        } else {
                                                                                            z4 = z3 ? 1 : 0;
                                                                                        }
                                                                                        if (z4) {
                                                                                            arrayList5.add(obj5);
                                                                                        }
                                                                                    }
                                                                                    arrayList6 = arrayList5;
                                                                                    if (arrayList6.isEmpty()) {
                                                                                        return CollectionsKt.take(listSortedWith, 5);
                                                                                    }
                                                                                    return arrayList6;
                                                                                }
                                                                            } catch (Exception e3) {
                                                                                e = e3;
                                                                                arrayList = arrayList9;
                                                                                i = 3;
                                                                                z5 = false;
                                                                                e.printStackTrace();
                                                                                List list4 = LocationSearchRepository.POI_DATABASE;
                                                                                arrayList2 = new ArrayList();
                                                                                while (r0.hasNext()) {
                                                                                    str11 = (String) ((Pair) obj2).component1();
                                                                                    if (string3.length() < 2) {
                                                                                        str12 = string3;
                                                                                        zEquals = StringsKt.equals(str11, str12, true);
                                                                                        str14 = str20;
                                                                                    } else {
                                                                                        str12 = string3;
                                                                                        str13 = str11;
                                                                                        str14 = str20;
                                                                                        if (StringsKt.contains((CharSequence) str14, (CharSequence) str13, true)) {
                                                                                            zEquals = true;
                                                                                        } else {
                                                                                            zEquals = true;
                                                                                        }
                                                                                    }
                                                                                    if (zEquals) {
                                                                                        arrayList2.add(obj2);
                                                                                    }
                                                                                    string3 = str12;
                                                                                    str20 = str14;
                                                                                }
                                                                                str = string3;
                                                                                str2 = str20;
                                                                                geoPoint = this.$currentPos;
                                                                                while (r2.hasNext()) {
                                                                                    String str27 = (String) pair.component1();
                                                                                    GeoPoint geoPoint10 = (GeoPoint) pair.component2();
                                                                                    arrayList.add(new SearchResultItem(str27, "地标/校区", geoPoint10, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint, geoPoint10)));
                                                                                }
                                                                                i2 = i;
                                                                                str3 = str;
                                                                                str4 = str2;
                                                                                fromLocationName = new Geocoder(this.$context, Locale.CHINA).getFromLocationName(str3, 5, this.$currentPos.getLatitude() - 0.2d, this.$currentPos.getLongitude() - 0.2d, this.$currentPos.getLatitude() + 0.2d, this.$currentPos.getLongitude() + 0.2d);
                                                                                list2 = fromLocationName;
                                                                                if (list2 != null) {
                                                                                    r16 = 1;
                                                                                } else {
                                                                                    r16 = 1;
                                                                                }
                                                                                if (r16 == 0) {
                                                                                    geoPoint3 = this.$currentPos;
                                                                                    while (r0.hasNext()) {
                                                                                        GeoPoint geoPoint11 = new GeoPoint(address.getLatitude(), address.getLongitude());
                                                                                        featureName = address.getFeatureName();
                                                                                        if (featureName != null) {
                                                                                            str10 = featureName;
                                                                                        } else {
                                                                                            str10 = featureName;
                                                                                        }
                                                                                        String[] strArr5 = new String[i2];
                                                                                        strArr5[z5 ? 1 : 0] = address.getSubAdminArea();
                                                                                        strArr5[1] = address.getLocality();
                                                                                        i3 = 2;
                                                                                        strArr5[2] = address.getThoroughfare();
                                                                                        strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) strArr5), ServerSentEventKt.SPACE, null, null, 0, null, null, 62, null);
                                                                                        if (StringsKt.isBlank(strJoinToString$default)) {
                                                                                            strJoinToString$default = null;
                                                                                        }
                                                                                        arrayList.add(new SearchResultItem(str10, strJoinToString$default, geoPoint11, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint3, geoPoint11)));
                                                                                    }
                                                                                    i3 = 2;
                                                                                } else {
                                                                                    i3 = 2;
                                                                                }
                                                                                arrayList7 = arrayList;
                                                                                URLConnection uRLConnectionOpenConnection3 = new URL("https://nominatim.openstreetmap.org/search?q=" + URLEncoder.encode(str3, str18) + "&format=json&limit=5&viewbox=" + (this.$currentPos.getLongitude() - 0.2d) + "," + (this.$currentPos.getLatitude() + 0.2d) + "," + (this.$currentPos.getLongitude() + 0.2d) + "," + (this.$currentPos.getLatitude() - 0.2d) + "&bounded=0").openConnection();
                                                                                Intrinsics.checkNotNull(uRLConnectionOpenConnection3, "null cannot be cast to non-null type java.net.HttpURLConnection");
                                                                                httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection3;
                                                                                httpURLConnection.setRequestMethod("GET");
                                                                                httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Android Cycling App)");
                                                                                httpURLConnection.setConnectTimeout(2500);
                                                                                httpURLConnection.setReadTimeout(2500);
                                                                                if (httpURLConnection.getResponseCode() == 200) {
                                                                                    InputStream inputStream3 = httpURLConnection.getInputStream();
                                                                                    Intrinsics.checkNotNullExpressionValue(inputStream3, str19);
                                                                                    inputStreamReader = new InputStreamReader(inputStream3, Charsets.UTF_8);
                                                                                    if (inputStreamReader instanceof BufferedReader) {
                                                                                        bufferedReader = (BufferedReader) inputStreamReader;
                                                                                    } else {
                                                                                        bufferedReader = new BufferedReader(inputStreamReader, 8192);
                                                                                    }
                                                                                    jSONArray = new JSONArray(TextStreamsKt.readText(bufferedReader));
                                                                                    length = jSONArray.length();
                                                                                    i6 = z5 ? 1 : 0;
                                                                                    while (i6 < length) {
                                                                                        JSONObject jSONObject4 = jSONArray.getJSONObject(i6);
                                                                                        double d6 = jSONObject4.getDouble("lat");
                                                                                        double d7 = jSONObject4.getDouble("lon");
                                                                                        String strOptString6 = jSONObject4.optString("display_name", str3);
                                                                                        Intrinsics.checkNotNull(strOptString6);
                                                                                        String[] strArr6 = new String[1];
                                                                                        strArr6[z5 ? 1 : 0] = ",";
                                                                                        listSplit$default = StringsKt.split$default((CharSequence) strOptString6, strArr6, false, 0, 6, (Object) null);
                                                                                        str8 = (String) CollectionsKt.firstOrNull(listSplit$default);
                                                                                        if (str8 != null) {
                                                                                            str9 = str3;
                                                                                        } else {
                                                                                            str9 = str3;
                                                                                        }
                                                                                        if (listSplit$default.size() > 1) {
                                                                                            string = StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(CollectionsKt.drop(CollectionsKt.take(listSplit$default, 3), 1), ", ", null, null, 0, null, null, 62, null)).toString();
                                                                                        } else {
                                                                                            string = null;
                                                                                        }
                                                                                        GeoPoint geoPoint12 = new GeoPoint(d6, d7);
                                                                                        arrayList3 = arrayList7;
                                                                                        arrayList3.add(new SearchResultItem(str9, string, geoPoint12, LocationSearchRepository.INSTANCE.calculateDistanceMeters(this.$currentPos, geoPoint12)));
                                                                                        i6++;
                                                                                        arrayList7 = arrayList3;
                                                                                    }
                                                                                    arrayList3 = arrayList7;
                                                                                } else {
                                                                                    arrayList3 = arrayList7;
                                                                                }
                                                                                list = LocationSearchRepository.CHAIN_KEYWORDS;
                                                                                if (list instanceof Collection) {
                                                                                    it = list.iterator();
                                                                                    while (true) {
                                                                                        if (!it.hasNext()) {
                                                                                            str5 = str4;
                                                                                            r14 = z5 ? 1 : 0;
                                                                                            break;
                                                                                        }
                                                                                        str6 = (String) it.next();
                                                                                        str5 = str4;
                                                                                        if (StringsKt.contains((CharSequence) str5, (CharSequence) str6, true)) {
                                                                                            r15 = 1;
                                                                                        } else {
                                                                                            r15 = 1;
                                                                                        }
                                                                                        if (r15 != 0) {
                                                                                            r14 = 1;
                                                                                            break;
                                                                                        }
                                                                                        str4 = str5;
                                                                                    }
                                                                                } else {
                                                                                    it = list.iterator();
                                                                                    while (true) {
                                                                                        if (!it.hasNext()) {
                                                                                            str5 = str4;
                                                                                            r14 = z5 ? 1 : 0;
                                                                                            break;
                                                                                        }
                                                                                        str6 = (String) it.next();
                                                                                        str5 = str4;
                                                                                        if (StringsKt.contains((CharSequence) str5, (CharSequence) str6, true)) {
                                                                                            r15 = 1;
                                                                                        } else {
                                                                                            r15 = 1;
                                                                                        }
                                                                                        if (r15 != 0) {
                                                                                            r14 = 1;
                                                                                            break;
                                                                                        }
                                                                                        str4 = str5;
                                                                                    }
                                                                                }
                                                                                ArrayList arrayList11 = arrayList3;
                                                                                it2 = arrayList11.iterator();
                                                                                if (it2.hasNext()) {
                                                                                    dBoxDouble = null;
                                                                                } else {
                                                                                    distanceMeters = ((SearchResultItem) it2.next()).getDistanceMeters();
                                                                                    while (it2.hasNext()) {
                                                                                        distanceMeters = Math.min(distanceMeters, ((SearchResultItem) it2.next()).getDistanceMeters());
                                                                                    }
                                                                                    dBoxDouble = Boxing.boxDouble(distanceMeters);
                                                                                }
                                                                                if (dBoxDouble != null) {
                                                                                    dDoubleValue = dBoxDouble.doubleValue();
                                                                                } else {
                                                                                    dDoubleValue = Double.MAX_VALUE;
                                                                                }
                                                                                if (r14 == 0) {
                                                                                    iAbs = Math.abs(str3.hashCode());
                                                                                    Pair[] pairArr3 = new Pair[4];
                                                                                    d = 180.0d;
                                                                                    pairArr3[z5 ? 1 : 0] = new Pair("门口店 / 近邻店", Boxing.boxDouble(180.0d));
                                                                                    z = true;
                                                                                    pairArr3[1] = new Pair("社区店", Boxing.boxDouble(420.0d));
                                                                                    pairArr3[i3] = new Pair("商业街店", Boxing.boxDouble(850.0d));
                                                                                    pairArr3[3] = new Pair("中心店", Boxing.boxDouble(1400.0d));
                                                                                    List listListOf4 = CollectionsKt.listOf((Object[]) pairArr3);
                                                                                    geoPoint2 = this.$currentPos;
                                                                                    i4 = z5 ? 1 : 0;
                                                                                    while (r2.hasNext()) {
                                                                                        int i15 = i4 + 1;
                                                                                        if (i4 < 0) {
                                                                                            CollectionsKt.throwIndexOverflow();
                                                                                        }
                                                                                        Pair pair4 = (Pair) obj3;
                                                                                        String str28 = (String) pair4.component1();
                                                                                        double d8 = (((double) (((i4 * 93) + iAbs) % 360)) * 3.141592653589793d) / d;
                                                                                        double dDoubleValue6 = ((Number) pair4.component2()).doubleValue() / 1000.0d;
                                                                                        GeoPoint geoPoint13 = new GeoPoint(geoPoint2.getLatitude() + ((dDoubleValue6 / 111.0d) * Math.cos(d8)), geoPoint2.getLongitude() + ((dDoubleValue6 / (Math.cos(Math.toRadians(geoPoint2.getLatitude())) * 111.0d)) * Math.sin(d8)));
                                                                                        i5 = i3;
                                                                                        z2 = z5 ? 1 : 0;
                                                                                        if (StringsKt.contains$default(str5, "店", z2, i5, (Object) null)) {
                                                                                            str7 = str3;
                                                                                        } else {
                                                                                            str7 = str3;
                                                                                        }
                                                                                        arrayList3.add(new SearchResultItem(str7, "附近便利点", geoPoint13, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint2, geoPoint13)));
                                                                                        i4 = i15;
                                                                                        i3 = i5;
                                                                                        z5 = z2 ? 1 : 0;
                                                                                        d = 180.0d;
                                                                                    }
                                                                                } else {
                                                                                    iAbs = Math.abs(str3.hashCode());
                                                                                    Pair[] pairArr4 = new Pair[4];
                                                                                    d = 180.0d;
                                                                                    pairArr4[z5 ? 1 : 0] = new Pair("门口店 / 近邻店", Boxing.boxDouble(180.0d));
                                                                                    z = true;
                                                                                    pairArr4[1] = new Pair("社区店", Boxing.boxDouble(420.0d));
                                                                                    pairArr4[i3] = new Pair("商业街店", Boxing.boxDouble(850.0d));
                                                                                    pairArr4[3] = new Pair("中心店", Boxing.boxDouble(1400.0d));
                                                                                    List listListOf5 = CollectionsKt.listOf((Object[]) pairArr4);
                                                                                    geoPoint2 = this.$currentPos;
                                                                                    i4 = z5 ? 1 : 0;
                                                                                    while (r2.hasNext()) {
                                                                                        int i16 = i4 + 1;
                                                                                        if (i4 < 0) {
                                                                                            CollectionsKt.throwIndexOverflow();
                                                                                        }
                                                                                        Pair pair5 = (Pair) obj3;
                                                                                        String str29 = (String) pair5.component1();
                                                                                        double d9 = (((double) (((i4 * 93) + iAbs) % 360)) * 3.141592653589793d) / d;
                                                                                        double dDoubleValue7 = ((Number) pair5.component2()).doubleValue() / 1000.0d;
                                                                                        GeoPoint geoPoint14 = new GeoPoint(geoPoint2.getLatitude() + ((dDoubleValue7 / 111.0d) * Math.cos(d9)), geoPoint2.getLongitude() + ((dDoubleValue7 / (Math.cos(Math.toRadians(geoPoint2.getLatitude())) * 111.0d)) * Math.sin(d9)));
                                                                                        i5 = i3;
                                                                                        z2 = z5 ? 1 : 0;
                                                                                        if (StringsKt.contains$default(str5, "店", z2, i5, (Object) null)) {
                                                                                            str7 = str3;
                                                                                        } else {
                                                                                            str7 = str3;
                                                                                        }
                                                                                        arrayList3.add(new SearchResultItem(str7, "附近便利点", geoPoint14, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint2, geoPoint14)));
                                                                                        i4 = i16;
                                                                                        i3 = i5;
                                                                                        z5 = z2 ? 1 : 0;
                                                                                        d = 180.0d;
                                                                                    }
                                                                                }
                                                                                z3 = z5;
                                                                                hashSet = new HashSet();
                                                                                arrayList4 = new ArrayList();
                                                                                while (r2.hasNext()) {
                                                                                    if (hashSet.add(((SearchResultItem) obj4).getName())) {
                                                                                        arrayList4.add(obj4);
                                                                                    }
                                                                                }
                                                                                listSortedWith = CollectionsKt.sortedWith(arrayList4, new Comparator() { // from class: com.example.util.LocationSearchRepository$searchLocations$2$invokeSuspend$$inlined$sortedBy$1
                                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                                    @Override // java.util.Comparator
                                                                                    public final int compare(T t, T t2) {
                                                                                        return ComparisonsKt.compareValues(Double.valueOf(((SearchResultItem) t).getDistanceMeters()), Double.valueOf(((SearchResultItem) t2).getDistanceMeters()));
                                                                                    }
                                                                                });
                                                                                arrayList5 = new ArrayList();
                                                                                while (r2.hasNext()) {
                                                                                    if (((SearchResultItem) obj5).getDistanceMeters() <= 30000.0d) {
                                                                                        z4 = z;
                                                                                    } else {
                                                                                        z4 = z3 ? 1 : 0;
                                                                                    }
                                                                                    if (z4) {
                                                                                        arrayList5.add(obj5);
                                                                                    }
                                                                                }
                                                                                arrayList6 = arrayList5;
                                                                                if (arrayList6.isEmpty()) {
                                                                                    return arrayList6;
                                                                                }
                                                                                return CollectionsKt.take(listSortedWith, 5);
                                                                            }
                                                                        }
                                                                    } else {
                                                                        str19 = str19;
                                                                        arrayList = arrayList9;
                                                                    }
                                                                    i10 = (i12 == true ? 1 : 0) + 1;
                                                                    arrayList9 = arrayList;
                                                                    jSONArrayOptJSONArray2 = jSONArray2;
                                                                    length2 = i11;
                                                                    str19 = str19;
                                                                    i7 = 3;
                                                                    i8 = 2;
                                                                    z5 = false;
                                                                    i9 = 1;
                                                                }
                                                                arrayList8 = arrayList9;
                                                                i7 = 3;
                                                                i8 = 2;
                                                                z5 = false;
                                                                i9 = 1;
                                                                z6 = true;
                                                            }
                                                        }
                                                        arrayList8 = arrayList9;
                                                        str19 = str19;
                                                        i7 = 3;
                                                        i8 = 2;
                                                        z5 = false;
                                                        i9 = 1;
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        str19 = str19;
                                                    }
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    str19 = str19;
                                                    arrayList = arrayList8;
                                                    i = 3;
                                                    z5 = false;
                                                    e.printStackTrace();
                                                    List list5 = LocationSearchRepository.POI_DATABASE;
                                                    arrayList2 = new ArrayList();
                                                    while (r0.hasNext()) {
                                                        str11 = (String) ((Pair) obj2).component1();
                                                        if (string3.length() < 2) {
                                                            str12 = string3;
                                                            zEquals = StringsKt.equals(str11, str12, true);
                                                            str14 = str20;
                                                        } else {
                                                            str12 = string3;
                                                            str13 = str11;
                                                            str14 = str20;
                                                            if (StringsKt.contains((CharSequence) str14, (CharSequence) str13, true)) {
                                                                zEquals = true;
                                                            } else {
                                                                zEquals = true;
                                                            }
                                                        }
                                                        if (zEquals) {
                                                            arrayList2.add(obj2);
                                                        }
                                                        string3 = str12;
                                                        str20 = str14;
                                                    }
                                                    str = string3;
                                                    str2 = str20;
                                                    geoPoint = this.$currentPos;
                                                    while (r2.hasNext()) {
                                                        String str210 = (String) pair.component1();
                                                        GeoPoint geoPoint15 = (GeoPoint) pair.component2();
                                                        arrayList.add(new SearchResultItem(str210, "地标/校区", geoPoint15, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint, geoPoint15)));
                                                    }
                                                    i2 = i;
                                                    str3 = str;
                                                    str4 = str2;
                                                    fromLocationName = new Geocoder(this.$context, Locale.CHINA).getFromLocationName(str3, 5, this.$currentPos.getLatitude() - 0.2d, this.$currentPos.getLongitude() - 0.2d, this.$currentPos.getLatitude() + 0.2d, this.$currentPos.getLongitude() + 0.2d);
                                                    list2 = fromLocationName;
                                                    if (list2 != null) {
                                                        r16 = 1;
                                                    } else {
                                                        r16 = 1;
                                                    }
                                                    if (r16 == 0) {
                                                        geoPoint3 = this.$currentPos;
                                                        while (r0.hasNext()) {
                                                            GeoPoint geoPoint16 = new GeoPoint(address.getLatitude(), address.getLongitude());
                                                            featureName = address.getFeatureName();
                                                            if (featureName != null) {
                                                                str10 = featureName;
                                                            } else {
                                                                str10 = featureName;
                                                            }
                                                            String[] strArr7 = new String[i2];
                                                            strArr7[z5 ? 1 : 0] = address.getSubAdminArea();
                                                            strArr7[1] = address.getLocality();
                                                            i3 = 2;
                                                            strArr7[2] = address.getThoroughfare();
                                                            strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) strArr7), ServerSentEventKt.SPACE, null, null, 0, null, null, 62, null);
                                                            if (StringsKt.isBlank(strJoinToString$default)) {
                                                                strJoinToString$default = null;
                                                            }
                                                            arrayList.add(new SearchResultItem(str10, strJoinToString$default, geoPoint16, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint3, geoPoint16)));
                                                        }
                                                        i3 = 2;
                                                    } else {
                                                        i3 = 2;
                                                    }
                                                    arrayList7 = arrayList;
                                                    URLConnection uRLConnectionOpenConnection4 = new URL("https://nominatim.openstreetmap.org/search?q=" + URLEncoder.encode(str3, str18) + "&format=json&limit=5&viewbox=" + (this.$currentPos.getLongitude() - 0.2d) + "," + (this.$currentPos.getLatitude() + 0.2d) + "," + (this.$currentPos.getLongitude() + 0.2d) + "," + (this.$currentPos.getLatitude() - 0.2d) + "&bounded=0").openConnection();
                                                    Intrinsics.checkNotNull(uRLConnectionOpenConnection4, "null cannot be cast to non-null type java.net.HttpURLConnection");
                                                    httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection4;
                                                    httpURLConnection.setRequestMethod("GET");
                                                    httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Android Cycling App)");
                                                    httpURLConnection.setConnectTimeout(2500);
                                                    httpURLConnection.setReadTimeout(2500);
                                                    if (httpURLConnection.getResponseCode() == 200) {
                                                        InputStream inputStream4 = httpURLConnection.getInputStream();
                                                        Intrinsics.checkNotNullExpressionValue(inputStream4, str19);
                                                        inputStreamReader = new InputStreamReader(inputStream4, Charsets.UTF_8);
                                                        if (inputStreamReader instanceof BufferedReader) {
                                                            bufferedReader = (BufferedReader) inputStreamReader;
                                                        } else {
                                                            bufferedReader = new BufferedReader(inputStreamReader, 8192);
                                                        }
                                                        jSONArray = new JSONArray(TextStreamsKt.readText(bufferedReader));
                                                        length = jSONArray.length();
                                                        i6 = z5 ? 1 : 0;
                                                        while (i6 < length) {
                                                            JSONObject jSONObject5 = jSONArray.getJSONObject(i6);
                                                            double d10 = jSONObject5.getDouble("lat");
                                                            double d11 = jSONObject5.getDouble("lon");
                                                            String strOptString7 = jSONObject5.optString("display_name", str3);
                                                            Intrinsics.checkNotNull(strOptString7);
                                                            String[] strArr8 = new String[1];
                                                            strArr8[z5 ? 1 : 0] = ",";
                                                            listSplit$default = StringsKt.split$default((CharSequence) strOptString7, strArr8, false, 0, 6, (Object) null);
                                                            str8 = (String) CollectionsKt.firstOrNull(listSplit$default);
                                                            if (str8 != null) {
                                                                str9 = str3;
                                                            } else {
                                                                str9 = str3;
                                                            }
                                                            if (listSplit$default.size() > 1) {
                                                                string = StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(CollectionsKt.drop(CollectionsKt.take(listSplit$default, 3), 1), ", ", null, null, 0, null, null, 62, null)).toString();
                                                            } else {
                                                                string = null;
                                                            }
                                                            GeoPoint geoPoint17 = new GeoPoint(d10, d11);
                                                            arrayList3 = arrayList7;
                                                            arrayList3.add(new SearchResultItem(str9, string, geoPoint17, LocationSearchRepository.INSTANCE.calculateDistanceMeters(this.$currentPos, geoPoint17)));
                                                            i6++;
                                                            arrayList7 = arrayList3;
                                                        }
                                                        arrayList3 = arrayList7;
                                                    } else {
                                                        arrayList3 = arrayList7;
                                                    }
                                                    list = LocationSearchRepository.CHAIN_KEYWORDS;
                                                    if (list instanceof Collection) {
                                                        it = list.iterator();
                                                        while (true) {
                                                            if (!it.hasNext()) {
                                                                str5 = str4;
                                                                r14 = z5 ? 1 : 0;
                                                                break;
                                                            }
                                                            str6 = (String) it.next();
                                                            str5 = str4;
                                                            if (StringsKt.contains((CharSequence) str5, (CharSequence) str6, true)) {
                                                                r15 = 1;
                                                            } else {
                                                                r15 = 1;
                                                            }
                                                            if (r15 != 0) {
                                                                r14 = 1;
                                                                break;
                                                            }
                                                            str4 = str5;
                                                        }
                                                    } else {
                                                        it = list.iterator();
                                                        while (true) {
                                                            if (!it.hasNext()) {
                                                                str5 = str4;
                                                                r14 = z5 ? 1 : 0;
                                                                break;
                                                            }
                                                            str6 = (String) it.next();
                                                            str5 = str4;
                                                            if (StringsKt.contains((CharSequence) str5, (CharSequence) str6, true)) {
                                                                r15 = 1;
                                                            } else {
                                                                r15 = 1;
                                                            }
                                                            if (r15 != 0) {
                                                                r14 = 1;
                                                                break;
                                                            }
                                                            str4 = str5;
                                                        }
                                                    }
                                                    ArrayList arrayList12 = arrayList3;
                                                    it2 = arrayList12.iterator();
                                                    if (it2.hasNext()) {
                                                        dBoxDouble = null;
                                                    } else {
                                                        distanceMeters = ((SearchResultItem) it2.next()).getDistanceMeters();
                                                        while (it2.hasNext()) {
                                                            distanceMeters = Math.min(distanceMeters, ((SearchResultItem) it2.next()).getDistanceMeters());
                                                        }
                                                        dBoxDouble = Boxing.boxDouble(distanceMeters);
                                                    }
                                                    if (dBoxDouble != null) {
                                                        dDoubleValue = dBoxDouble.doubleValue();
                                                    } else {
                                                        dDoubleValue = Double.MAX_VALUE;
                                                    }
                                                    if (r14 == 0) {
                                                        iAbs = Math.abs(str3.hashCode());
                                                        Pair[] pairArr5 = new Pair[4];
                                                        d = 180.0d;
                                                        pairArr5[z5 ? 1 : 0] = new Pair("门口店 / 近邻店", Boxing.boxDouble(180.0d));
                                                        z = true;
                                                        pairArr5[1] = new Pair("社区店", Boxing.boxDouble(420.0d));
                                                        pairArr5[i3] = new Pair("商业街店", Boxing.boxDouble(850.0d));
                                                        pairArr5[3] = new Pair("中心店", Boxing.boxDouble(1400.0d));
                                                        List listListOf6 = CollectionsKt.listOf((Object[]) pairArr5);
                                                        geoPoint2 = this.$currentPos;
                                                        i4 = z5 ? 1 : 0;
                                                        while (r2.hasNext()) {
                                                            int i17 = i4 + 1;
                                                            if (i4 < 0) {
                                                                CollectionsKt.throwIndexOverflow();
                                                            }
                                                            Pair pair6 = (Pair) obj3;
                                                            String str211 = (String) pair6.component1();
                                                            double d12 = (((double) (((i4 * 93) + iAbs) % 360)) * 3.141592653589793d) / d;
                                                            double dDoubleValue8 = ((Number) pair6.component2()).doubleValue() / 1000.0d;
                                                            GeoPoint geoPoint18 = new GeoPoint(geoPoint2.getLatitude() + ((dDoubleValue8 / 111.0d) * Math.cos(d12)), geoPoint2.getLongitude() + ((dDoubleValue8 / (Math.cos(Math.toRadians(geoPoint2.getLatitude())) * 111.0d)) * Math.sin(d12)));
                                                            i5 = i3;
                                                            z2 = z5 ? 1 : 0;
                                                            if (StringsKt.contains$default(str5, "店", z2, i5, (Object) null)) {
                                                                str7 = str3;
                                                            } else {
                                                                str7 = str3;
                                                            }
                                                            arrayList3.add(new SearchResultItem(str7, "附近便利点", geoPoint18, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint2, geoPoint18)));
                                                            i4 = i17;
                                                            i3 = i5;
                                                            z5 = z2 ? 1 : 0;
                                                            d = 180.0d;
                                                        }
                                                    } else {
                                                        iAbs = Math.abs(str3.hashCode());
                                                        Pair[] pairArr6 = new Pair[4];
                                                        d = 180.0d;
                                                        pairArr6[z5 ? 1 : 0] = new Pair("门口店 / 近邻店", Boxing.boxDouble(180.0d));
                                                        z = true;
                                                        pairArr6[1] = new Pair("社区店", Boxing.boxDouble(420.0d));
                                                        pairArr6[i3] = new Pair("商业街店", Boxing.boxDouble(850.0d));
                                                        pairArr6[3] = new Pair("中心店", Boxing.boxDouble(1400.0d));
                                                        List listListOf7 = CollectionsKt.listOf((Object[]) pairArr6);
                                                        geoPoint2 = this.$currentPos;
                                                        i4 = z5 ? 1 : 0;
                                                        while (r2.hasNext()) {
                                                            int i18 = i4 + 1;
                                                            if (i4 < 0) {
                                                                CollectionsKt.throwIndexOverflow();
                                                            }
                                                            Pair pair7 = (Pair) obj3;
                                                            String str212 = (String) pair7.component1();
                                                            double d13 = (((double) (((i4 * 93) + iAbs) % 360)) * 3.141592653589793d) / d;
                                                            double dDoubleValue9 = ((Number) pair7.component2()).doubleValue() / 1000.0d;
                                                            GeoPoint geoPoint19 = new GeoPoint(geoPoint2.getLatitude() + ((dDoubleValue9 / 111.0d) * Math.cos(d13)), geoPoint2.getLongitude() + ((dDoubleValue9 / (Math.cos(Math.toRadians(geoPoint2.getLatitude())) * 111.0d)) * Math.sin(d13)));
                                                            i5 = i3;
                                                            z2 = z5 ? 1 : 0;
                                                            if (StringsKt.contains$default(str5, "店", z2, i5, (Object) null)) {
                                                                str7 = str3;
                                                            } else {
                                                                str7 = str3;
                                                            }
                                                            arrayList3.add(new SearchResultItem(str7, "附近便利点", geoPoint19, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint2, geoPoint19)));
                                                            i4 = i18;
                                                            i3 = i5;
                                                            z5 = z2 ? 1 : 0;
                                                            d = 180.0d;
                                                        }
                                                    }
                                                    z3 = z5;
                                                    hashSet = new HashSet();
                                                    arrayList4 = new ArrayList();
                                                    while (r2.hasNext()) {
                                                        if (hashSet.add(((SearchResultItem) obj4).getName())) {
                                                            arrayList4.add(obj4);
                                                        }
                                                    }
                                                    listSortedWith = CollectionsKt.sortedWith(arrayList4, new Comparator() { // from class: com.example.util.LocationSearchRepository$searchLocations$2$invokeSuspend$$inlined$sortedBy$1
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        @Override // java.util.Comparator
                                                        public final int compare(T t, T t2) {
                                                            return ComparisonsKt.compareValues(Double.valueOf(((SearchResultItem) t).getDistanceMeters()), Double.valueOf(((SearchResultItem) t2).getDistanceMeters()));
                                                        }
                                                    });
                                                    arrayList5 = new ArrayList();
                                                    while (r2.hasNext()) {
                                                        if (((SearchResultItem) obj5).getDistanceMeters() <= 30000.0d) {
                                                            z4 = z;
                                                        } else {
                                                            z4 = z3 ? 1 : 0;
                                                        }
                                                        if (z4) {
                                                            arrayList5.add(obj5);
                                                        }
                                                    }
                                                    arrayList6 = arrayList5;
                                                    if (arrayList6.isEmpty()) {
                                                        return arrayList6;
                                                    }
                                                    return CollectionsKt.take(listSortedWith, 5);
                                                }
                                            } catch (Exception e6) {
                                                e = e6;
                                                string3 = string3;
                                                arrayList = arrayList8;
                                                i = 3;
                                                z5 = false;
                                                e.printStackTrace();
                                                List list6 = LocationSearchRepository.POI_DATABASE;
                                                arrayList2 = new ArrayList();
                                                while (r0.hasNext()) {
                                                    str11 = (String) ((Pair) obj2).component1();
                                                    if (string3.length() < 2) {
                                                        str12 = string3;
                                                        zEquals = StringsKt.equals(str11, str12, true);
                                                        str14 = str20;
                                                    } else {
                                                        str12 = string3;
                                                        str13 = str11;
                                                        str14 = str20;
                                                        if (StringsKt.contains((CharSequence) str14, (CharSequence) str13, true)) {
                                                            zEquals = true;
                                                        } else {
                                                            zEquals = true;
                                                        }
                                                    }
                                                    if (zEquals) {
                                                        arrayList2.add(obj2);
                                                    }
                                                    string3 = str12;
                                                    str20 = str14;
                                                }
                                                str = string3;
                                                str2 = str20;
                                                geoPoint = this.$currentPos;
                                                while (r2.hasNext()) {
                                                    String str213 = (String) pair.component1();
                                                    GeoPoint geoPoint110 = (GeoPoint) pair.component2();
                                                    arrayList.add(new SearchResultItem(str213, "地标/校区", geoPoint110, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint, geoPoint110)));
                                                }
                                                i2 = i;
                                                str3 = str;
                                                str4 = str2;
                                                fromLocationName = new Geocoder(this.$context, Locale.CHINA).getFromLocationName(str3, 5, this.$currentPos.getLatitude() - 0.2d, this.$currentPos.getLongitude() - 0.2d, this.$currentPos.getLatitude() + 0.2d, this.$currentPos.getLongitude() + 0.2d);
                                                list2 = fromLocationName;
                                                if (list2 != null) {
                                                    r16 = 1;
                                                } else {
                                                    r16 = 1;
                                                }
                                                if (r16 == 0) {
                                                    geoPoint3 = this.$currentPos;
                                                    while (r0.hasNext()) {
                                                        GeoPoint geoPoint111 = new GeoPoint(address.getLatitude(), address.getLongitude());
                                                        featureName = address.getFeatureName();
                                                        if (featureName != null) {
                                                            str10 = featureName;
                                                        } else {
                                                            str10 = featureName;
                                                        }
                                                        String[] strArr9 = new String[i2];
                                                        strArr9[z5 ? 1 : 0] = address.getSubAdminArea();
                                                        strArr9[1] = address.getLocality();
                                                        i3 = 2;
                                                        strArr9[2] = address.getThoroughfare();
                                                        strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) strArr9), ServerSentEventKt.SPACE, null, null, 0, null, null, 62, null);
                                                        if (StringsKt.isBlank(strJoinToString$default)) {
                                                            strJoinToString$default = null;
                                                        }
                                                        arrayList.add(new SearchResultItem(str10, strJoinToString$default, geoPoint111, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint3, geoPoint111)));
                                                    }
                                                    i3 = 2;
                                                } else {
                                                    i3 = 2;
                                                }
                                                arrayList7 = arrayList;
                                                URLConnection uRLConnectionOpenConnection5 = new URL("https://nominatim.openstreetmap.org/search?q=" + URLEncoder.encode(str3, str18) + "&format=json&limit=5&viewbox=" + (this.$currentPos.getLongitude() - 0.2d) + "," + (this.$currentPos.getLatitude() + 0.2d) + "," + (this.$currentPos.getLongitude() + 0.2d) + "," + (this.$currentPos.getLatitude() - 0.2d) + "&bounded=0").openConnection();
                                                Intrinsics.checkNotNull(uRLConnectionOpenConnection5, "null cannot be cast to non-null type java.net.HttpURLConnection");
                                                httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection5;
                                                httpURLConnection.setRequestMethod("GET");
                                                httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Android Cycling App)");
                                                httpURLConnection.setConnectTimeout(2500);
                                                httpURLConnection.setReadTimeout(2500);
                                                if (httpURLConnection.getResponseCode() == 200) {
                                                    InputStream inputStream5 = httpURLConnection.getInputStream();
                                                    Intrinsics.checkNotNullExpressionValue(inputStream5, str19);
                                                    inputStreamReader = new InputStreamReader(inputStream5, Charsets.UTF_8);
                                                    if (inputStreamReader instanceof BufferedReader) {
                                                        bufferedReader = (BufferedReader) inputStreamReader;
                                                    } else {
                                                        bufferedReader = new BufferedReader(inputStreamReader, 8192);
                                                    }
                                                    jSONArray = new JSONArray(TextStreamsKt.readText(bufferedReader));
                                                    length = jSONArray.length();
                                                    i6 = z5 ? 1 : 0;
                                                    while (i6 < length) {
                                                        JSONObject jSONObject6 = jSONArray.getJSONObject(i6);
                                                        double d14 = jSONObject6.getDouble("lat");
                                                        double d15 = jSONObject6.getDouble("lon");
                                                        String strOptString8 = jSONObject6.optString("display_name", str3);
                                                        Intrinsics.checkNotNull(strOptString8);
                                                        String[] strArr10 = new String[1];
                                                        strArr10[z5 ? 1 : 0] = ",";
                                                        listSplit$default = StringsKt.split$default((CharSequence) strOptString8, strArr10, false, 0, 6, (Object) null);
                                                        str8 = (String) CollectionsKt.firstOrNull(listSplit$default);
                                                        if (str8 != null) {
                                                            str9 = str3;
                                                        } else {
                                                            str9 = str3;
                                                        }
                                                        if (listSplit$default.size() > 1) {
                                                            string = StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(CollectionsKt.drop(CollectionsKt.take(listSplit$default, 3), 1), ", ", null, null, 0, null, null, 62, null)).toString();
                                                        } else {
                                                            string = null;
                                                        }
                                                        GeoPoint geoPoint112 = new GeoPoint(d14, d15);
                                                        arrayList3 = arrayList7;
                                                        arrayList3.add(new SearchResultItem(str9, string, geoPoint112, LocationSearchRepository.INSTANCE.calculateDistanceMeters(this.$currentPos, geoPoint112)));
                                                        i6++;
                                                        arrayList7 = arrayList3;
                                                    }
                                                    arrayList3 = arrayList7;
                                                } else {
                                                    arrayList3 = arrayList7;
                                                }
                                                list = LocationSearchRepository.CHAIN_KEYWORDS;
                                                if (list instanceof Collection) {
                                                    it = list.iterator();
                                                    while (true) {
                                                        if (!it.hasNext()) {
                                                            str5 = str4;
                                                            r14 = z5 ? 1 : 0;
                                                            break;
                                                        }
                                                        str6 = (String) it.next();
                                                        str5 = str4;
                                                        if (StringsKt.contains((CharSequence) str5, (CharSequence) str6, true)) {
                                                            r15 = 1;
                                                        } else {
                                                            r15 = 1;
                                                        }
                                                        if (r15 != 0) {
                                                            r14 = 1;
                                                            break;
                                                        }
                                                        str4 = str5;
                                                    }
                                                } else {
                                                    it = list.iterator();
                                                    while (true) {
                                                        if (!it.hasNext()) {
                                                            str5 = str4;
                                                            r14 = z5 ? 1 : 0;
                                                            break;
                                                        }
                                                        str6 = (String) it.next();
                                                        str5 = str4;
                                                        if (StringsKt.contains((CharSequence) str5, (CharSequence) str6, true)) {
                                                            r15 = 1;
                                                        } else {
                                                            r15 = 1;
                                                        }
                                                        if (r15 != 0) {
                                                            r14 = 1;
                                                            break;
                                                        }
                                                        str4 = str5;
                                                    }
                                                }
                                                ArrayList arrayList13 = arrayList3;
                                                it2 = arrayList13.iterator();
                                                if (it2.hasNext()) {
                                                    dBoxDouble = null;
                                                } else {
                                                    distanceMeters = ((SearchResultItem) it2.next()).getDistanceMeters();
                                                    while (it2.hasNext()) {
                                                        distanceMeters = Math.min(distanceMeters, ((SearchResultItem) it2.next()).getDistanceMeters());
                                                    }
                                                    dBoxDouble = Boxing.boxDouble(distanceMeters);
                                                }
                                                if (dBoxDouble != null) {
                                                    dDoubleValue = dBoxDouble.doubleValue();
                                                } else {
                                                    dDoubleValue = Double.MAX_VALUE;
                                                }
                                                if (r14 == 0) {
                                                    iAbs = Math.abs(str3.hashCode());
                                                    Pair[] pairArr7 = new Pair[4];
                                                    d = 180.0d;
                                                    pairArr7[z5 ? 1 : 0] = new Pair("门口店 / 近邻店", Boxing.boxDouble(180.0d));
                                                    z = true;
                                                    pairArr7[1] = new Pair("社区店", Boxing.boxDouble(420.0d));
                                                    pairArr7[i3] = new Pair("商业街店", Boxing.boxDouble(850.0d));
                                                    pairArr7[3] = new Pair("中心店", Boxing.boxDouble(1400.0d));
                                                    List listListOf8 = CollectionsKt.listOf((Object[]) pairArr7);
                                                    geoPoint2 = this.$currentPos;
                                                    i4 = z5 ? 1 : 0;
                                                    while (r2.hasNext()) {
                                                        int i19 = i4 + 1;
                                                        if (i4 < 0) {
                                                            CollectionsKt.throwIndexOverflow();
                                                        }
                                                        Pair pair8 = (Pair) obj3;
                                                        String str214 = (String) pair8.component1();
                                                        double d16 = (((double) (((i4 * 93) + iAbs) % 360)) * 3.141592653589793d) / d;
                                                        double dDoubleValue10 = ((Number) pair8.component2()).doubleValue() / 1000.0d;
                                                        GeoPoint geoPoint113 = new GeoPoint(geoPoint2.getLatitude() + ((dDoubleValue10 / 111.0d) * Math.cos(d16)), geoPoint2.getLongitude() + ((dDoubleValue10 / (Math.cos(Math.toRadians(geoPoint2.getLatitude())) * 111.0d)) * Math.sin(d16)));
                                                        i5 = i3;
                                                        z2 = z5 ? 1 : 0;
                                                        if (StringsKt.contains$default(str5, "店", z2, i5, (Object) null)) {
                                                            str7 = str3;
                                                        } else {
                                                            str7 = str3;
                                                        }
                                                        arrayList3.add(new SearchResultItem(str7, "附近便利点", geoPoint113, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint2, geoPoint113)));
                                                        i4 = i19;
                                                        i3 = i5;
                                                        z5 = z2 ? 1 : 0;
                                                        d = 180.0d;
                                                    }
                                                } else {
                                                    iAbs = Math.abs(str3.hashCode());
                                                    Pair[] pairArr8 = new Pair[4];
                                                    d = 180.0d;
                                                    pairArr8[z5 ? 1 : 0] = new Pair("门口店 / 近邻店", Boxing.boxDouble(180.0d));
                                                    z = true;
                                                    pairArr8[1] = new Pair("社区店", Boxing.boxDouble(420.0d));
                                                    pairArr8[i3] = new Pair("商业街店", Boxing.boxDouble(850.0d));
                                                    pairArr8[3] = new Pair("中心店", Boxing.boxDouble(1400.0d));
                                                    List listListOf9 = CollectionsKt.listOf((Object[]) pairArr8);
                                                    geoPoint2 = this.$currentPos;
                                                    i4 = z5 ? 1 : 0;
                                                    while (r2.hasNext()) {
                                                        int i110 = i4 + 1;
                                                        if (i4 < 0) {
                                                            CollectionsKt.throwIndexOverflow();
                                                        }
                                                        Pair pair9 = (Pair) obj3;
                                                        String str215 = (String) pair9.component1();
                                                        double d17 = (((double) (((i4 * 93) + iAbs) % 360)) * 3.141592653589793d) / d;
                                                        double dDoubleValue11 = ((Number) pair9.component2()).doubleValue() / 1000.0d;
                                                        GeoPoint geoPoint114 = new GeoPoint(geoPoint2.getLatitude() + ((dDoubleValue11 / 111.0d) * Math.cos(d17)), geoPoint2.getLongitude() + ((dDoubleValue11 / (Math.cos(Math.toRadians(geoPoint2.getLatitude())) * 111.0d)) * Math.sin(d17)));
                                                        i5 = i3;
                                                        z2 = z5 ? 1 : 0;
                                                        if (StringsKt.contains$default(str5, "店", z2, i5, (Object) null)) {
                                                            str7 = str3;
                                                        } else {
                                                            str7 = str3;
                                                        }
                                                        arrayList3.add(new SearchResultItem(str7, "附近便利点", geoPoint114, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint2, geoPoint114)));
                                                        i4 = i110;
                                                        i3 = i5;
                                                        z5 = z2 ? 1 : 0;
                                                        d = 180.0d;
                                                    }
                                                }
                                                z3 = z5;
                                                hashSet = new HashSet();
                                                arrayList4 = new ArrayList();
                                                while (r2.hasNext()) {
                                                    if (hashSet.add(((SearchResultItem) obj4).getName())) {
                                                        arrayList4.add(obj4);
                                                    }
                                                }
                                                listSortedWith = CollectionsKt.sortedWith(arrayList4, new Comparator() { // from class: com.example.util.LocationSearchRepository$searchLocations$2$invokeSuspend$$inlined$sortedBy$1
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    @Override // java.util.Comparator
                                                    public final int compare(T t, T t2) {
                                                        return ComparisonsKt.compareValues(Double.valueOf(((SearchResultItem) t).getDistanceMeters()), Double.valueOf(((SearchResultItem) t2).getDistanceMeters()));
                                                    }
                                                });
                                                arrayList5 = new ArrayList();
                                                while (r2.hasNext()) {
                                                    if (((SearchResultItem) obj5).getDistanceMeters() <= 30000.0d) {
                                                        z4 = z;
                                                    } else {
                                                        z4 = z3 ? 1 : 0;
                                                    }
                                                    if (z4) {
                                                        arrayList5.add(obj5);
                                                    }
                                                }
                                                arrayList6 = arrayList5;
                                                if (arrayList6.isEmpty()) {
                                                    return arrayList6;
                                                }
                                                return CollectionsKt.take(listSortedWith, 5);
                                            }
                                        } catch (Exception e7) {
                                            e = e7;
                                            str20 = str20;
                                        }
                                        e.printStackTrace();
                                        List list7 = LocationSearchRepository.POI_DATABASE;
                                        arrayList2 = new ArrayList();
                                        while (r0.hasNext()) {
                                            str11 = (String) ((Pair) obj2).component1();
                                            if (string3.length() < 2) {
                                                str12 = string3;
                                                zEquals = StringsKt.equals(str11, str12, true);
                                                str14 = str20;
                                            } else {
                                                str12 = string3;
                                                str13 = str11;
                                                str14 = str20;
                                                if (StringsKt.contains((CharSequence) str14, (CharSequence) str13, true) || StringsKt.contains((CharSequence) str13, (CharSequence) str14, true)) {
                                                    zEquals = true;
                                                } else {
                                                    zEquals = z5 ? 1 : 0;
                                                }
                                            }
                                            if (zEquals) {
                                                arrayList2.add(obj2);
                                            }
                                            string3 = str12;
                                            str20 = str14;
                                        }
                                        str = string3;
                                        str2 = str20;
                                        geoPoint = this.$currentPos;
                                        while (r2.hasNext()) {
                                            String str216 = (String) pair.component1();
                                            GeoPoint geoPoint115 = (GeoPoint) pair.component2();
                                            arrayList.add(new SearchResultItem(str216, "地标/校区", geoPoint115, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint, geoPoint115)));
                                        }
                                        i2 = i;
                                        str3 = str;
                                        str4 = str2;
                                        fromLocationName = new Geocoder(this.$context, Locale.CHINA).getFromLocationName(str3, 5, this.$currentPos.getLatitude() - 0.2d, this.$currentPos.getLongitude() - 0.2d, this.$currentPos.getLatitude() + 0.2d, this.$currentPos.getLongitude() + 0.2d);
                                        list2 = fromLocationName;
                                        if (list2 != null || list2.isEmpty()) {
                                            r16 = 1;
                                        } else {
                                            r16 = z5 ? 1 : 0;
                                        }
                                        if (r16 == 0) {
                                            geoPoint3 = this.$currentPos;
                                            while (r0.hasNext()) {
                                                GeoPoint geoPoint116 = new GeoPoint(address.getLatitude(), address.getLongitude());
                                                featureName = address.getFeatureName();
                                                if (featureName != null && (featureName = address.getThoroughfare()) == null && (featureName = address.getSubLocality()) == null && (featureName = address.getLocality()) == null) {
                                                    str10 = str3;
                                                } else {
                                                    str10 = featureName;
                                                }
                                                String[] strArr11 = new String[i2];
                                                strArr11[z5 ? 1 : 0] = address.getSubAdminArea();
                                                strArr11[1] = address.getLocality();
                                                i3 = 2;
                                                strArr11[2] = address.getThoroughfare();
                                                strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) strArr11), ServerSentEventKt.SPACE, null, null, 0, null, null, 62, null);
                                                if (StringsKt.isBlank(strJoinToString$default)) {
                                                    strJoinToString$default = null;
                                                }
                                                arrayList.add(new SearchResultItem(str10, strJoinToString$default, geoPoint116, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint3, geoPoint116)));
                                            }
                                            i3 = 2;
                                        } else {
                                            i3 = 2;
                                        }
                                        arrayList7 = arrayList;
                                        URLConnection uRLConnectionOpenConnection6 = new URL("https://nominatim.openstreetmap.org/search?q=" + URLEncoder.encode(str3, str18) + "&format=json&limit=5&viewbox=" + (this.$currentPos.getLongitude() - 0.2d) + "," + (this.$currentPos.getLatitude() + 0.2d) + "," + (this.$currentPos.getLongitude() + 0.2d) + "," + (this.$currentPos.getLatitude() - 0.2d) + "&bounded=0").openConnection();
                                        Intrinsics.checkNotNull(uRLConnectionOpenConnection6, "null cannot be cast to non-null type java.net.HttpURLConnection");
                                        httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection6;
                                        httpURLConnection.setRequestMethod("GET");
                                        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Android Cycling App)");
                                        httpURLConnection.setConnectTimeout(2500);
                                        httpURLConnection.setReadTimeout(2500);
                                        if (httpURLConnection.getResponseCode() == 200) {
                                            InputStream inputStream6 = httpURLConnection.getInputStream();
                                            Intrinsics.checkNotNullExpressionValue(inputStream6, str19);
                                            inputStreamReader = new InputStreamReader(inputStream6, Charsets.UTF_8);
                                            if (inputStreamReader instanceof BufferedReader) {
                                                bufferedReader = (BufferedReader) inputStreamReader;
                                            } else {
                                                bufferedReader = new BufferedReader(inputStreamReader, 8192);
                                            }
                                            jSONArray = new JSONArray(TextStreamsKt.readText(bufferedReader));
                                            length = jSONArray.length();
                                            i6 = z5 ? 1 : 0;
                                            while (i6 < length) {
                                                JSONObject jSONObject7 = jSONArray.getJSONObject(i6);
                                                double d18 = jSONObject7.getDouble("lat");
                                                double d19 = jSONObject7.getDouble("lon");
                                                String strOptString9 = jSONObject7.optString("display_name", str3);
                                                Intrinsics.checkNotNull(strOptString9);
                                                String[] strArr12 = new String[1];
                                                strArr12[z5 ? 1 : 0] = ",";
                                                listSplit$default = StringsKt.split$default((CharSequence) strOptString9, strArr12, false, 0, 6, (Object) null);
                                                str8 = (String) CollectionsKt.firstOrNull(listSplit$default);
                                                if (str8 != null || (string2 = StringsKt.trim((CharSequence) str8).toString()) == null) {
                                                    str9 = str3;
                                                } else {
                                                    str9 = string2;
                                                }
                                                if (listSplit$default.size() > 1) {
                                                    string = StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(CollectionsKt.drop(CollectionsKt.take(listSplit$default, 3), 1), ", ", null, null, 0, null, null, 62, null)).toString();
                                                } else {
                                                    string = null;
                                                }
                                                GeoPoint geoPoint117 = new GeoPoint(d18, d19);
                                                arrayList3 = arrayList7;
                                                arrayList3.add(new SearchResultItem(str9, string, geoPoint117, LocationSearchRepository.INSTANCE.calculateDistanceMeters(this.$currentPos, geoPoint117)));
                                                i6++;
                                                arrayList7 = arrayList3;
                                            }
                                            arrayList3 = arrayList7;
                                        } else {
                                            arrayList3 = arrayList7;
                                        }
                                        list = LocationSearchRepository.CHAIN_KEYWORDS;
                                        if ((list instanceof Collection) || !list.isEmpty()) {
                                            it = list.iterator();
                                            while (true) {
                                                if (!it.hasNext()) {
                                                    str5 = str4;
                                                    r14 = z5 ? 1 : 0;
                                                    break;
                                                }
                                                str6 = (String) it.next();
                                                str5 = str4;
                                                if (StringsKt.contains((CharSequence) str5, (CharSequence) str6, true) || StringsKt.contains((CharSequence) str6, (CharSequence) str5, true)) {
                                                    r15 = 1;
                                                } else {
                                                    r15 = z5 ? 1 : 0;
                                                }
                                                if (r15 != 0) {
                                                    r14 = 1;
                                                    break;
                                                }
                                                str4 = str5;
                                            }
                                        } else {
                                            r14 = z5 ? 1 : 0;
                                            str5 = str4;
                                        }
                                        ArrayList arrayList14 = arrayList3;
                                        it2 = arrayList14.iterator();
                                        if (it2.hasNext()) {
                                            dBoxDouble = null;
                                        } else {
                                            distanceMeters = ((SearchResultItem) it2.next()).getDistanceMeters();
                                            while (it2.hasNext()) {
                                                distanceMeters = Math.min(distanceMeters, ((SearchResultItem) it2.next()).getDistanceMeters());
                                            }
                                            dBoxDouble = Boxing.boxDouble(distanceMeters);
                                        }
                                        if (dBoxDouble != null) {
                                            dDoubleValue = dBoxDouble.doubleValue();
                                        } else {
                                            dDoubleValue = Double.MAX_VALUE;
                                        }
                                        if (r14 == 0 || dDoubleValue > 15000.0d) {
                                            iAbs = Math.abs(str3.hashCode());
                                            Pair[] pairArr9 = new Pair[4];
                                            d = 180.0d;
                                            pairArr9[z5 ? 1 : 0] = new Pair("门口店 / 近邻店", Boxing.boxDouble(180.0d));
                                            z = true;
                                            pairArr9[1] = new Pair("社区店", Boxing.boxDouble(420.0d));
                                            pairArr9[i3] = new Pair("商业街店", Boxing.boxDouble(850.0d));
                                            pairArr9[3] = new Pair("中心店", Boxing.boxDouble(1400.0d));
                                            List listListOf10 = CollectionsKt.listOf((Object[]) pairArr9);
                                            geoPoint2 = this.$currentPos;
                                            i4 = z5 ? 1 : 0;
                                            while (r2.hasNext()) {
                                                int i111 = i4 + 1;
                                                if (i4 < 0) {
                                                    CollectionsKt.throwIndexOverflow();
                                                }
                                                Pair pair10 = (Pair) obj3;
                                                String str217 = (String) pair10.component1();
                                                double d110 = (((double) (((i4 * 93) + iAbs) % 360)) * 3.141592653589793d) / d;
                                                double dDoubleValue12 = ((Number) pair10.component2()).doubleValue() / 1000.0d;
                                                GeoPoint geoPoint118 = new GeoPoint(geoPoint2.getLatitude() + ((dDoubleValue12 / 111.0d) * Math.cos(d110)), geoPoint2.getLongitude() + ((dDoubleValue12 / (Math.cos(Math.toRadians(geoPoint2.getLatitude())) * 111.0d)) * Math.sin(d110)));
                                                i5 = i3;
                                                z2 = z5 ? 1 : 0;
                                                if (StringsKt.contains$default(str5, "店", z2, i5, (Object) null) || StringsKt.contains$default(str5, "超市", z2, i5, (Object) null) || StringsKt.contains$default(str5, "场", z2, i5, (Object) null)) {
                                                    str7 = str3;
                                                } else {
                                                    str7 = str3 + " (" + str217 + ")";
                                                }
                                                arrayList3.add(new SearchResultItem(str7, "附近便利点", geoPoint118, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint2, geoPoint118)));
                                                i4 = i111;
                                                i3 = i5;
                                                z5 = z2 ? 1 : 0;
                                                d = 180.0d;
                                            }
                                        } else {
                                            z = true;
                                        }
                                        z3 = z5;
                                        hashSet = new HashSet();
                                        arrayList4 = new ArrayList();
                                        while (r2.hasNext()) {
                                            if (hashSet.add(((SearchResultItem) obj4).getName())) {
                                                arrayList4.add(obj4);
                                            }
                                        }
                                        listSortedWith = CollectionsKt.sortedWith(arrayList4, new Comparator() { // from class: com.example.util.LocationSearchRepository$searchLocations$2$invokeSuspend$$inlined$sortedBy$1
                                            /* JADX WARN: Multi-variable type inference failed */
                                            @Override // java.util.Comparator
                                            public final int compare(T t, T t2) {
                                                return ComparisonsKt.compareValues(Double.valueOf(((SearchResultItem) t).getDistanceMeters()), Double.valueOf(((SearchResultItem) t2).getDistanceMeters()));
                                            }
                                        });
                                        arrayList5 = new ArrayList();
                                        while (r2.hasNext()) {
                                            if (((SearchResultItem) obj5).getDistanceMeters() <= 30000.0d) {
                                                z4 = z;
                                            } else {
                                                z4 = z3 ? 1 : 0;
                                            }
                                            if (z4) {
                                                arrayList5.add(obj5);
                                            }
                                        }
                                        arrayList6 = arrayList5;
                                        if (arrayList6.isEmpty()) {
                                            return arrayList6;
                                        }
                                        return CollectionsKt.take(listSortedWith, 5);
                                    }
                                    str19 = str19;
                                    string3 = string3;
                                    arrayList = arrayList8;
                                    if (!z6) {
                                        Iterator it4 = listListOf.iterator();
                                        while (it4.hasNext()) {
                                            String str30 = (String) it4.next();
                                            if (z6) {
                                                break;
                                            }
                                            it4 = it4;
                                            URLConnection uRLConnectionOpenConnection7 = new URL("https://restapi.amap.com/v3/assistant/inputtips?keywords=" + strEncode + str16 + dDoubleValue3 + "," + dDoubleValue2 + "&key=" + str30).openConnection();
                                            Intrinsics.checkNotNull(uRLConnectionOpenConnection7, "null cannot be cast to non-null type java.net.HttpURLConnection");
                                            HttpURLConnection httpURLConnection3 = (HttpURLConnection) uRLConnectionOpenConnection7;
                                            httpURLConnection3.setRequestMethod("GET");
                                            httpURLConnection3.setConnectTimeout(2500);
                                            httpURLConnection3.setReadTimeout(2500);
                                            if (httpURLConnection3.getResponseCode() == 200) {
                                                InputStream inputStream7 = httpURLConnection3.getInputStream();
                                                String str31 = str19;
                                                try {
                                                    Intrinsics.checkNotNullExpressionValue(inputStream7, str31);
                                                    str17 = strEncode;
                                                    InputStreamReader inputStreamReader3 = new InputStreamReader(inputStream7, Charsets.UTF_8);
                                                    JSONObject jSONObject8 = new JSONObject(TextStreamsKt.readText(inputStreamReader3 instanceof BufferedReader ? (BufferedReader) inputStreamReader3 : new BufferedReader(inputStreamReader3, 8192)));
                                                    if (!Intrinsics.areEqual(jSONObject8.optString(str15), DiskLruCache.VERSION) || (jSONArrayOptJSONArray = jSONObject8.optJSONArray("tips")) == null || jSONArrayOptJSONArray.length() <= 0) {
                                                        str19 = str31;
                                                    } else {
                                                        int length3 = jSONArrayOptJSONArray.length();
                                                        int i20 = 0;
                                                        while (i20 < length3) {
                                                            String str32 = str16;
                                                            JSONObject jSONObject9 = jSONArrayOptJSONArray.getJSONObject(i20);
                                                            JSONArray jSONArray3 = jSONArrayOptJSONArray;
                                                            String strOptString10 = jSONObject9.optString("name");
                                                            String strOptString11 = jSONObject9.optString("location");
                                                            String strOptString12 = jSONObject9.optString("district");
                                                            String strOptString13 = jSONObject9.optString("address");
                                                            Intrinsics.checkNotNull(strOptString11);
                                                            int i21 = length3;
                                                            int i22 = i20;
                                                            str19 = str31;
                                                            try {
                                                                if (StringsKt.contains$default((CharSequence) strOptString11, (CharSequence) ",", false, 2, (Object) null)) {
                                                                    List listSplit$default3 = StringsKt.split$default((CharSequence) strOptString11, new String[]{","}, false, 0, 6, (Object) null);
                                                                    Double doubleOrNull3 = StringsKt.toDoubleOrNull((String) listSplit$default3.get(0));
                                                                    Double doubleOrNull4 = StringsKt.toDoubleOrNull((String) listSplit$default3.get(1));
                                                                    if (doubleOrNull3 != null && doubleOrNull4 != null) {
                                                                        Pair<Double, Double> pairGcj02ToWgs85 = GpsCoordinateUtils.INSTANCE.gcj02ToWgs84(doubleOrNull4.doubleValue(), doubleOrNull3.doubleValue());
                                                                        GeoPoint geoPoint20 = new GeoPoint(pairGcj02ToWgs85.component1().doubleValue(), pairGcj02ToWgs85.component2().doubleValue());
                                                                        double dCalculateDistanceMeters2 = LocationSearchRepository.INSTANCE.calculateDistanceMeters(this.$currentPos, geoPoint20);
                                                                        i = 3;
                                                                        try {
                                                                            String[] strArr13 = new String[3];
                                                                            String str33 = strOptString12;
                                                                            if (StringsKt.isBlank(str33)) {
                                                                                str33 = null;
                                                                            }
                                                                            z5 = false;
                                                                            try {
                                                                                strArr13[0] = str33;
                                                                                String str34 = strOptString13;
                                                                                if (StringsKt.isBlank(str34)) {
                                                                                    str34 = null;
                                                                                }
                                                                                strArr13[1] = str34;
                                                                                strArr13[2] = "高德地图数据";
                                                                                String strJoinToString$default3 = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) strArr13), " · ", null, null, 0, null, null, 62, null);
                                                                                Intrinsics.checkNotNull(strOptString10);
                                                                                arrayList.add(new SearchResultItem(strOptString10, strJoinToString$default3, geoPoint20, dCalculateDistanceMeters2));
                                                                            } catch (Exception e8) {
                                                                                e = e8;
                                                                            }
                                                                        } catch (Exception e9) {
                                                                            e = e9;
                                                                            z5 = false;
                                                                        }
                                                                    }
                                                                }
                                                                i20 = i22 + 1;
                                                                str15 = str15;
                                                                str16 = str32;
                                                                jSONArrayOptJSONArray = jSONArray3;
                                                                length3 = i21;
                                                                str31 = str19;
                                                            } catch (Exception e10) {
                                                                e = e10;
                                                                z5 = false;
                                                                i = 3;
                                                            }
                                                        }
                                                        str19 = str31;
                                                        strEncode = str17;
                                                        z6 = true;
                                                    }
                                                } catch (Exception e11) {
                                                    e = e11;
                                                    str19 = str31;
                                                    i = 3;
                                                    z5 = false;
                                                    e.printStackTrace();
                                                    List list8 = LocationSearchRepository.POI_DATABASE;
                                                    arrayList2 = new ArrayList();
                                                    while (r0.hasNext()) {
                                                        str11 = (String) ((Pair) obj2).component1();
                                                        if (string3.length() < 2) {
                                                            str12 = string3;
                                                            zEquals = StringsKt.equals(str11, str12, true);
                                                            str14 = str20;
                                                        } else {
                                                            str12 = string3;
                                                            str13 = str11;
                                                            str14 = str20;
                                                            if (StringsKt.contains((CharSequence) str14, (CharSequence) str13, true)) {
                                                                zEquals = true;
                                                            } else {
                                                                zEquals = true;
                                                            }
                                                        }
                                                        if (zEquals) {
                                                            arrayList2.add(obj2);
                                                        }
                                                        string3 = str12;
                                                        str20 = str14;
                                                    }
                                                    str = string3;
                                                    str2 = str20;
                                                    geoPoint = this.$currentPos;
                                                    while (r2.hasNext()) {
                                                        String str218 = (String) pair.component1();
                                                        GeoPoint geoPoint119 = (GeoPoint) pair.component2();
                                                        arrayList.add(new SearchResultItem(str218, "地标/校区", geoPoint119, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint, geoPoint119)));
                                                    }
                                                    i2 = i;
                                                    str3 = str;
                                                    str4 = str2;
                                                    fromLocationName = new Geocoder(this.$context, Locale.CHINA).getFromLocationName(str3, 5, this.$currentPos.getLatitude() - 0.2d, this.$currentPos.getLongitude() - 0.2d, this.$currentPos.getLatitude() + 0.2d, this.$currentPos.getLongitude() + 0.2d);
                                                    list2 = fromLocationName;
                                                    if (list2 != null) {
                                                        r16 = 1;
                                                    } else {
                                                        r16 = 1;
                                                    }
                                                    if (r16 == 0) {
                                                        geoPoint3 = this.$currentPos;
                                                        while (r0.hasNext()) {
                                                            GeoPoint geoPoint1110 = new GeoPoint(address.getLatitude(), address.getLongitude());
                                                            featureName = address.getFeatureName();
                                                            if (featureName != null) {
                                                                str10 = featureName;
                                                            } else {
                                                                str10 = featureName;
                                                            }
                                                            String[] strArr14 = new String[i2];
                                                            strArr14[z5 ? 1 : 0] = address.getSubAdminArea();
                                                            strArr14[1] = address.getLocality();
                                                            i3 = 2;
                                                            strArr14[2] = address.getThoroughfare();
                                                            strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) strArr14), ServerSentEventKt.SPACE, null, null, 0, null, null, 62, null);
                                                            if (StringsKt.isBlank(strJoinToString$default)) {
                                                                strJoinToString$default = null;
                                                            }
                                                            arrayList.add(new SearchResultItem(str10, strJoinToString$default, geoPoint1110, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint3, geoPoint1110)));
                                                        }
                                                        i3 = 2;
                                                    } else {
                                                        i3 = 2;
                                                    }
                                                    arrayList7 = arrayList;
                                                    URLConnection uRLConnectionOpenConnection8 = new URL("https://nominatim.openstreetmap.org/search?q=" + URLEncoder.encode(str3, str18) + "&format=json&limit=5&viewbox=" + (this.$currentPos.getLongitude() - 0.2d) + "," + (this.$currentPos.getLatitude() + 0.2d) + "," + (this.$currentPos.getLongitude() + 0.2d) + "," + (this.$currentPos.getLatitude() - 0.2d) + "&bounded=0").openConnection();
                                                    Intrinsics.checkNotNull(uRLConnectionOpenConnection8, "null cannot be cast to non-null type java.net.HttpURLConnection");
                                                    httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection8;
                                                    httpURLConnection.setRequestMethod("GET");
                                                    httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Android Cycling App)");
                                                    httpURLConnection.setConnectTimeout(2500);
                                                    httpURLConnection.setReadTimeout(2500);
                                                    if (httpURLConnection.getResponseCode() == 200) {
                                                        InputStream inputStream8 = httpURLConnection.getInputStream();
                                                        Intrinsics.checkNotNullExpressionValue(inputStream8, str19);
                                                        inputStreamReader = new InputStreamReader(inputStream8, Charsets.UTF_8);
                                                        if (inputStreamReader instanceof BufferedReader) {
                                                            bufferedReader = (BufferedReader) inputStreamReader;
                                                        } else {
                                                            bufferedReader = new BufferedReader(inputStreamReader, 8192);
                                                        }
                                                        jSONArray = new JSONArray(TextStreamsKt.readText(bufferedReader));
                                                        length = jSONArray.length();
                                                        i6 = z5 ? 1 : 0;
                                                        while (i6 < length) {
                                                            JSONObject jSONObject10 = jSONArray.getJSONObject(i6);
                                                            double d111 = jSONObject10.getDouble("lat");
                                                            double d112 = jSONObject10.getDouble("lon");
                                                            String strOptString14 = jSONObject10.optString("display_name", str3);
                                                            Intrinsics.checkNotNull(strOptString14);
                                                            String[] strArr15 = new String[1];
                                                            strArr15[z5 ? 1 : 0] = ",";
                                                            listSplit$default = StringsKt.split$default((CharSequence) strOptString14, strArr15, false, 0, 6, (Object) null);
                                                            str8 = (String) CollectionsKt.firstOrNull(listSplit$default);
                                                            if (str8 != null) {
                                                                str9 = str3;
                                                            } else {
                                                                str9 = str3;
                                                            }
                                                            if (listSplit$default.size() > 1) {
                                                                string = StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(CollectionsKt.drop(CollectionsKt.take(listSplit$default, 3), 1), ", ", null, null, 0, null, null, 62, null)).toString();
                                                            } else {
                                                                string = null;
                                                            }
                                                            GeoPoint geoPoint1111 = new GeoPoint(d111, d112);
                                                            arrayList3 = arrayList7;
                                                            arrayList3.add(new SearchResultItem(str9, string, geoPoint1111, LocationSearchRepository.INSTANCE.calculateDistanceMeters(this.$currentPos, geoPoint1111)));
                                                            i6++;
                                                            arrayList7 = arrayList3;
                                                        }
                                                        arrayList3 = arrayList7;
                                                    } else {
                                                        arrayList3 = arrayList7;
                                                    }
                                                    list = LocationSearchRepository.CHAIN_KEYWORDS;
                                                    if (list instanceof Collection) {
                                                        it = list.iterator();
                                                        while (true) {
                                                            if (!it.hasNext()) {
                                                                str5 = str4;
                                                                r14 = z5 ? 1 : 0;
                                                                break;
                                                            }
                                                            str6 = (String) it.next();
                                                            str5 = str4;
                                                            if (StringsKt.contains((CharSequence) str5, (CharSequence) str6, true)) {
                                                                r15 = 1;
                                                            } else {
                                                                r15 = 1;
                                                            }
                                                            if (r15 != 0) {
                                                                r14 = 1;
                                                                break;
                                                            }
                                                            str4 = str5;
                                                        }
                                                    } else {
                                                        it = list.iterator();
                                                        while (true) {
                                                            if (!it.hasNext()) {
                                                                str5 = str4;
                                                                r14 = z5 ? 1 : 0;
                                                                break;
                                                            }
                                                            str6 = (String) it.next();
                                                            str5 = str4;
                                                            if (StringsKt.contains((CharSequence) str5, (CharSequence) str6, true)) {
                                                                r15 = 1;
                                                            } else {
                                                                r15 = 1;
                                                            }
                                                            if (r15 != 0) {
                                                                r14 = 1;
                                                                break;
                                                            }
                                                            str4 = str5;
                                                        }
                                                    }
                                                    ArrayList arrayList15 = arrayList3;
                                                    it2 = arrayList15.iterator();
                                                    if (it2.hasNext()) {
                                                        dBoxDouble = null;
                                                    } else {
                                                        distanceMeters = ((SearchResultItem) it2.next()).getDistanceMeters();
                                                        while (it2.hasNext()) {
                                                            distanceMeters = Math.min(distanceMeters, ((SearchResultItem) it2.next()).getDistanceMeters());
                                                        }
                                                        dBoxDouble = Boxing.boxDouble(distanceMeters);
                                                    }
                                                    if (dBoxDouble != null) {
                                                        dDoubleValue = dBoxDouble.doubleValue();
                                                    } else {
                                                        dDoubleValue = Double.MAX_VALUE;
                                                    }
                                                    if (r14 == 0) {
                                                        iAbs = Math.abs(str3.hashCode());
                                                        Pair[] pairArr10 = new Pair[4];
                                                        d = 180.0d;
                                                        pairArr10[z5 ? 1 : 0] = new Pair("门口店 / 近邻店", Boxing.boxDouble(180.0d));
                                                        z = true;
                                                        pairArr10[1] = new Pair("社区店", Boxing.boxDouble(420.0d));
                                                        pairArr10[i3] = new Pair("商业街店", Boxing.boxDouble(850.0d));
                                                        pairArr10[3] = new Pair("中心店", Boxing.boxDouble(1400.0d));
                                                        List listListOf11 = CollectionsKt.listOf((Object[]) pairArr10);
                                                        geoPoint2 = this.$currentPos;
                                                        i4 = z5 ? 1 : 0;
                                                        while (r2.hasNext()) {
                                                            int i112 = i4 + 1;
                                                            if (i4 < 0) {
                                                                CollectionsKt.throwIndexOverflow();
                                                            }
                                                            Pair pair11 = (Pair) obj3;
                                                            String str219 = (String) pair11.component1();
                                                            double d113 = (((double) (((i4 * 93) + iAbs) % 360)) * 3.141592653589793d) / d;
                                                            double dDoubleValue13 = ((Number) pair11.component2()).doubleValue() / 1000.0d;
                                                            GeoPoint geoPoint1112 = new GeoPoint(geoPoint2.getLatitude() + ((dDoubleValue13 / 111.0d) * Math.cos(d113)), geoPoint2.getLongitude() + ((dDoubleValue13 / (Math.cos(Math.toRadians(geoPoint2.getLatitude())) * 111.0d)) * Math.sin(d113)));
                                                            i5 = i3;
                                                            z2 = z5 ? 1 : 0;
                                                            if (StringsKt.contains$default(str5, "店", z2, i5, (Object) null)) {
                                                                str7 = str3;
                                                            } else {
                                                                str7 = str3;
                                                            }
                                                            arrayList3.add(new SearchResultItem(str7, "附近便利点", geoPoint1112, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint2, geoPoint1112)));
                                                            i4 = i112;
                                                            i3 = i5;
                                                            z5 = z2 ? 1 : 0;
                                                            d = 180.0d;
                                                        }
                                                    } else {
                                                        iAbs = Math.abs(str3.hashCode());
                                                        Pair[] pairArr11 = new Pair[4];
                                                        d = 180.0d;
                                                        pairArr11[z5 ? 1 : 0] = new Pair("门口店 / 近邻店", Boxing.boxDouble(180.0d));
                                                        z = true;
                                                        pairArr11[1] = new Pair("社区店", Boxing.boxDouble(420.0d));
                                                        pairArr11[i3] = new Pair("商业街店", Boxing.boxDouble(850.0d));
                                                        pairArr11[3] = new Pair("中心店", Boxing.boxDouble(1400.0d));
                                                        List listListOf12 = CollectionsKt.listOf((Object[]) pairArr11);
                                                        geoPoint2 = this.$currentPos;
                                                        i4 = z5 ? 1 : 0;
                                                        while (r2.hasNext()) {
                                                            int i113 = i4 + 1;
                                                            if (i4 < 0) {
                                                                CollectionsKt.throwIndexOverflow();
                                                            }
                                                            Pair pair12 = (Pair) obj3;
                                                            String str2110 = (String) pair12.component1();
                                                            double d114 = (((double) (((i4 * 93) + iAbs) % 360)) * 3.141592653589793d) / d;
                                                            double dDoubleValue14 = ((Number) pair12.component2()).doubleValue() / 1000.0d;
                                                            GeoPoint geoPoint1113 = new GeoPoint(geoPoint2.getLatitude() + ((dDoubleValue14 / 111.0d) * Math.cos(d114)), geoPoint2.getLongitude() + ((dDoubleValue14 / (Math.cos(Math.toRadians(geoPoint2.getLatitude())) * 111.0d)) * Math.sin(d114)));
                                                            i5 = i3;
                                                            z2 = z5 ? 1 : 0;
                                                            if (StringsKt.contains$default(str5, "店", z2, i5, (Object) null)) {
                                                                str7 = str3;
                                                            } else {
                                                                str7 = str3;
                                                            }
                                                            arrayList3.add(new SearchResultItem(str7, "附近便利点", geoPoint1113, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint2, geoPoint1113)));
                                                            i4 = i113;
                                                            i3 = i5;
                                                            z5 = z2 ? 1 : 0;
                                                            d = 180.0d;
                                                        }
                                                    }
                                                    z3 = z5;
                                                    hashSet = new HashSet();
                                                    arrayList4 = new ArrayList();
                                                    while (r2.hasNext()) {
                                                        if (hashSet.add(((SearchResultItem) obj4).getName())) {
                                                            arrayList4.add(obj4);
                                                        }
                                                    }
                                                    listSortedWith = CollectionsKt.sortedWith(arrayList4, new Comparator() { // from class: com.example.util.LocationSearchRepository$searchLocations$2$invokeSuspend$$inlined$sortedBy$1
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        @Override // java.util.Comparator
                                                        public final int compare(T t, T t2) {
                                                            return ComparisonsKt.compareValues(Double.valueOf(((SearchResultItem) t).getDistanceMeters()), Double.valueOf(((SearchResultItem) t2).getDistanceMeters()));
                                                        }
                                                    });
                                                    arrayList5 = new ArrayList();
                                                    while (r2.hasNext()) {
                                                        if (((SearchResultItem) obj5).getDistanceMeters() <= 30000.0d) {
                                                            z4 = z;
                                                        } else {
                                                            z4 = z3 ? 1 : 0;
                                                        }
                                                        if (z4) {
                                                            arrayList5.add(obj5);
                                                        }
                                                    }
                                                    arrayList6 = arrayList5;
                                                    if (arrayList6.isEmpty()) {
                                                        return arrayList6;
                                                    }
                                                    return CollectionsKt.take(listSortedWith, 5);
                                                }
                                            } else {
                                                str17 = strEncode;
                                            }
                                            str15 = str15;
                                            strEncode = str17;
                                            str16 = str16;
                                        }
                                    }
                                    i = 3;
                                    z5 = false;
                                } catch (Exception e12) {
                                    e = e12;
                                    str18 = str18;
                                    str19 = str19;
                                    str20 = str20;
                                    string3 = string3;
                                    arrayList = arrayList8;
                                    i = i7;
                                }
                            } catch (Exception e13) {
                                e = e13;
                                str18 = "UTF-8";
                                str19 = "getInputStream(...)";
                                str20 = str20;
                                string3 = string3;
                                arrayList = arrayList8;
                                i = 3;
                            }
                            fromLocationName = new Geocoder(this.$context, Locale.CHINA).getFromLocationName(str3, 5, this.$currentPos.getLatitude() - 0.2d, this.$currentPos.getLongitude() - 0.2d, this.$currentPos.getLatitude() + 0.2d, this.$currentPos.getLongitude() + 0.2d);
                            list2 = fromLocationName;
                            if (list2 != null) {
                                r16 = 1;
                            } else {
                                r16 = 1;
                            }
                            if (r16 == 0) {
                                geoPoint3 = this.$currentPos;
                                while (r0.hasNext()) {
                                    GeoPoint geoPoint1114 = new GeoPoint(address.getLatitude(), address.getLongitude());
                                    featureName = address.getFeatureName();
                                    if (featureName != null) {
                                        str10 = featureName;
                                    } else {
                                        str10 = featureName;
                                    }
                                    String[] strArr16 = new String[i2];
                                    strArr16[z5 ? 1 : 0] = address.getSubAdminArea();
                                    strArr16[1] = address.getLocality();
                                    i3 = 2;
                                    strArr16[2] = address.getThoroughfare();
                                    strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) strArr16), ServerSentEventKt.SPACE, null, null, 0, null, null, 62, null);
                                    if (StringsKt.isBlank(strJoinToString$default)) {
                                        strJoinToString$default = null;
                                    }
                                    arrayList.add(new SearchResultItem(str10, strJoinToString$default, geoPoint1114, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint3, geoPoint1114)));
                                }
                                i3 = 2;
                            } else {
                                i3 = 2;
                            }
                        } catch (Exception unused5) {
                        }
                        str3 = str;
                        str4 = str2;
                    } catch (Exception unused6) {
                        i3 = 2;
                        str3 = str;
                        str4 = str2;
                    }
                    URLConnection uRLConnectionOpenConnection9 = new URL("https://nominatim.openstreetmap.org/search?q=" + URLEncoder.encode(str3, str18) + "&format=json&limit=5&viewbox=" + (this.$currentPos.getLongitude() - 0.2d) + "," + (this.$currentPos.getLatitude() + 0.2d) + "," + (this.$currentPos.getLongitude() + 0.2d) + "," + (this.$currentPos.getLatitude() - 0.2d) + "&bounded=0").openConnection();
                    Intrinsics.checkNotNull(uRLConnectionOpenConnection9, "null cannot be cast to non-null type java.net.HttpURLConnection");
                    httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection9;
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Android Cycling App)");
                    httpURLConnection.setConnectTimeout(2500);
                    httpURLConnection.setReadTimeout(2500);
                    if (httpURLConnection.getResponseCode() == 200) {
                        InputStream inputStream9 = httpURLConnection.getInputStream();
                        Intrinsics.checkNotNullExpressionValue(inputStream9, str19);
                        inputStreamReader = new InputStreamReader(inputStream9, Charsets.UTF_8);
                        if (inputStreamReader instanceof BufferedReader) {
                            bufferedReader = (BufferedReader) inputStreamReader;
                        } else {
                            bufferedReader = new BufferedReader(inputStreamReader, 8192);
                        }
                        jSONArray = new JSONArray(TextStreamsKt.readText(bufferedReader));
                        length = jSONArray.length();
                        i6 = z5 ? 1 : 0;
                        while (i6 < length) {
                            JSONObject jSONObject11 = jSONArray.getJSONObject(i6);
                            double d115 = jSONObject11.getDouble("lat");
                            double d116 = jSONObject11.getDouble("lon");
                            String strOptString15 = jSONObject11.optString("display_name", str3);
                            Intrinsics.checkNotNull(strOptString15);
                            String[] strArr17 = new String[1];
                            strArr17[z5 ? 1 : 0] = ",";
                            listSplit$default = StringsKt.split$default((CharSequence) strOptString15, strArr17, false, 0, 6, (Object) null);
                            str8 = (String) CollectionsKt.firstOrNull(listSplit$default);
                            if (str8 != null) {
                                str9 = str3;
                            } else {
                                str9 = str3;
                            }
                            if (listSplit$default.size() > 1) {
                                string = StringsKt.trim((CharSequence) CollectionsKt.joinToString$default(CollectionsKt.drop(CollectionsKt.take(listSplit$default, 3), 1), ", ", null, null, 0, null, null, 62, null)).toString();
                            } else {
                                string = null;
                            }
                            GeoPoint geoPoint1115 = new GeoPoint(d115, d116);
                            arrayList3 = arrayList7;
                            arrayList3.add(new SearchResultItem(str9, string, geoPoint1115, LocationSearchRepository.INSTANCE.calculateDistanceMeters(this.$currentPos, geoPoint1115)));
                            i6++;
                            arrayList7 = arrayList3;
                        }
                        arrayList3 = arrayList7;
                    } else {
                        arrayList3 = arrayList7;
                    }
                } catch (Exception unused7) {
                }
                arrayList7 = arrayList;
            } catch (Exception unused8) {
                arrayList3 = arrayList;
            }
            List list9 = LocationSearchRepository.POI_DATABASE;
            arrayList2 = new ArrayList();
            while (r0.hasNext()) {
                str11 = (String) ((Pair) obj2).component1();
                if (string3.length() < 2) {
                    str12 = string3;
                    zEquals = StringsKt.equals(str11, str12, true);
                    str14 = str20;
                } else {
                    str12 = string3;
                    str13 = str11;
                    str14 = str20;
                    if (StringsKt.contains((CharSequence) str14, (CharSequence) str13, true)) {
                        zEquals = true;
                    } else {
                        zEquals = true;
                    }
                }
                if (zEquals) {
                    arrayList2.add(obj2);
                }
                string3 = str12;
                str20 = str14;
            }
            str = string3;
            str2 = str20;
            geoPoint = this.$currentPos;
            while (r2.hasNext()) {
                String str2111 = (String) pair.component1();
                GeoPoint geoPoint1116 = (GeoPoint) pair.component2();
                arrayList.add(new SearchResultItem(str2111, "地标/校区", geoPoint1116, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint, geoPoint1116)));
            }
            i2 = i;
            list = LocationSearchRepository.CHAIN_KEYWORDS;
            if (list instanceof Collection) {
                it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str5 = str4;
                        r14 = z5 ? 1 : 0;
                        break;
                    }
                    str6 = (String) it.next();
                    str5 = str4;
                    if (StringsKt.contains((CharSequence) str5, (CharSequence) str6, true)) {
                        r15 = 1;
                    } else {
                        r15 = 1;
                    }
                    if (r15 != 0) {
                        r14 = 1;
                        break;
                    }
                    str4 = str5;
                }
            } else {
                it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str5 = str4;
                        r14 = z5 ? 1 : 0;
                        break;
                    }
                    str6 = (String) it.next();
                    str5 = str4;
                    if (StringsKt.contains((CharSequence) str5, (CharSequence) str6, true)) {
                        r15 = 1;
                    } else {
                        r15 = 1;
                    }
                    if (r15 != 0) {
                        r14 = 1;
                        break;
                    }
                    str4 = str5;
                }
            }
            ArrayList arrayList16 = arrayList3;
            it2 = arrayList16.iterator();
            if (it2.hasNext()) {
                dBoxDouble = null;
            } else {
                distanceMeters = ((SearchResultItem) it2.next()).getDistanceMeters();
                while (it2.hasNext()) {
                    distanceMeters = Math.min(distanceMeters, ((SearchResultItem) it2.next()).getDistanceMeters());
                }
                dBoxDouble = Boxing.boxDouble(distanceMeters);
            }
            if (dBoxDouble != null) {
                dDoubleValue = dBoxDouble.doubleValue();
            } else {
                dDoubleValue = Double.MAX_VALUE;
            }
            if (r14 == 0) {
                iAbs = Math.abs(str3.hashCode());
                Pair[] pairArr12 = new Pair[4];
                d = 180.0d;
                pairArr12[z5 ? 1 : 0] = new Pair("门口店 / 近邻店", Boxing.boxDouble(180.0d));
                z = true;
                pairArr12[1] = new Pair("社区店", Boxing.boxDouble(420.0d));
                pairArr12[i3] = new Pair("商业街店", Boxing.boxDouble(850.0d));
                pairArr12[3] = new Pair("中心店", Boxing.boxDouble(1400.0d));
                List listListOf13 = CollectionsKt.listOf((Object[]) pairArr12);
                geoPoint2 = this.$currentPos;
                i4 = z5 ? 1 : 0;
                while (r2.hasNext()) {
                    int i114 = i4 + 1;
                    if (i4 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Pair pair13 = (Pair) obj3;
                    String str2112 = (String) pair13.component1();
                    double d117 = (((double) (((i4 * 93) + iAbs) % 360)) * 3.141592653589793d) / d;
                    double dDoubleValue15 = ((Number) pair13.component2()).doubleValue() / 1000.0d;
                    GeoPoint geoPoint1117 = new GeoPoint(geoPoint2.getLatitude() + ((dDoubleValue15 / 111.0d) * Math.cos(d117)), geoPoint2.getLongitude() + ((dDoubleValue15 / (Math.cos(Math.toRadians(geoPoint2.getLatitude())) * 111.0d)) * Math.sin(d117)));
                    i5 = i3;
                    z2 = z5 ? 1 : 0;
                    if (StringsKt.contains$default(str5, "店", z2, i5, (Object) null)) {
                        str7 = str3;
                    } else {
                        str7 = str3;
                    }
                    arrayList3.add(new SearchResultItem(str7, "附近便利点", geoPoint1117, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint2, geoPoint1117)));
                    i4 = i114;
                    i3 = i5;
                    z5 = z2 ? 1 : 0;
                    d = 180.0d;
                }
            } else {
                iAbs = Math.abs(str3.hashCode());
                Pair[] pairArr13 = new Pair[4];
                d = 180.0d;
                pairArr13[z5 ? 1 : 0] = new Pair("门口店 / 近邻店", Boxing.boxDouble(180.0d));
                z = true;
                pairArr13[1] = new Pair("社区店", Boxing.boxDouble(420.0d));
                pairArr13[i3] = new Pair("商业街店", Boxing.boxDouble(850.0d));
                pairArr13[3] = new Pair("中心店", Boxing.boxDouble(1400.0d));
                List listListOf14 = CollectionsKt.listOf((Object[]) pairArr13);
                geoPoint2 = this.$currentPos;
                i4 = z5 ? 1 : 0;
                while (r2.hasNext()) {
                    int i115 = i4 + 1;
                    if (i4 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Pair pair14 = (Pair) obj3;
                    String str2113 = (String) pair14.component1();
                    double d118 = (((double) (((i4 * 93) + iAbs) % 360)) * 3.141592653589793d) / d;
                    double dDoubleValue16 = ((Number) pair14.component2()).doubleValue() / 1000.0d;
                    GeoPoint geoPoint1118 = new GeoPoint(geoPoint2.getLatitude() + ((dDoubleValue16 / 111.0d) * Math.cos(d118)), geoPoint2.getLongitude() + ((dDoubleValue16 / (Math.cos(Math.toRadians(geoPoint2.getLatitude())) * 111.0d)) * Math.sin(d118)));
                    i5 = i3;
                    z2 = z5 ? 1 : 0;
                    if (StringsKt.contains$default(str5, "店", z2, i5, (Object) null)) {
                        str7 = str3;
                    } else {
                        str7 = str3;
                    }
                    arrayList3.add(new SearchResultItem(str7, "附近便利点", geoPoint1118, LocationSearchRepository.INSTANCE.calculateDistanceMeters(geoPoint2, geoPoint1118)));
                    i4 = i115;
                    i3 = i5;
                    z5 = z2 ? 1 : 0;
                    d = 180.0d;
                }
            }
            z3 = z5;
            hashSet = new HashSet();
            arrayList4 = new ArrayList();
            while (r2.hasNext()) {
                if (hashSet.add(((SearchResultItem) obj4).getName())) {
                    arrayList4.add(obj4);
                }
            }
            listSortedWith = CollectionsKt.sortedWith(arrayList4, new Comparator() { // from class: com.example.util.LocationSearchRepository$searchLocations$2$invokeSuspend$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Double.valueOf(((SearchResultItem) t).getDistanceMeters()), Double.valueOf(((SearchResultItem) t2).getDistanceMeters()));
                }
            });
            arrayList5 = new ArrayList();
            while (r2.hasNext()) {
                if (((SearchResultItem) obj5).getDistanceMeters() <= 30000.0d) {
                    z4 = z;
                } else {
                    z4 = z3 ? 1 : 0;
                }
                if (z4) {
                    arrayList5.add(obj5);
                }
            }
            arrayList6 = arrayList5;
            if (arrayList6.isEmpty()) {
                return arrayList6;
            }
            return CollectionsKt.take(listSortedWith, 5);
        }
    }

    public final Object searchLocations(Context context, String str, GeoPoint geoPoint, Continuation<? super List<SearchResultItem>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(str, geoPoint, context, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double calculateDistanceMeters(GeoPoint start, GeoPoint end) {
        float[] fArr = new float[1];
        Location.distanceBetween(start.getLatitude(), start.getLongitude(), end.getLatitude(), end.getLongitude(), fArr);
        return fArr[0];
    }

    public final String formatDistance(double meters) {
        if (meters < 1000.0d) {
            return ((int) meters) + " m";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.getDefault(), "%.1f km", Arrays.copyOf(new Object[]{Double.valueOf(meters / 1000.0d)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
