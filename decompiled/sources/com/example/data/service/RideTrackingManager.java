package com.example.data.service;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import com.example.data.db.RideRecordEntity;
import com.example.data.db.RideRepository;
import com.example.data.db.TrackPoint;
import io.ktor.http.LinkHeader;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RideTrackingManager.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u00106\u001a\u0002072\u0006\u00108\u001a\u00020$J\u0006\u00109\u001a\u000207J\u0006\u0010:\u001a\u000207J\u000e\u0010;\u001a\u0002072\u0006\u0010<\u001a\u00020=J\u000e\u0010?\u001a\u0002072\u0006\u0010@\u001a\u00020(J\u000e\u0010A\u001a\u0002072\u0006\u0010<\u001a\u00020=J*\u0010B\u001a\u00020\r2\u0006\u0010<\u001a\u00020=2\u0006\u0010C\u001a\u00020D2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010FH\u0086@¢\u0006\u0002\u0010GR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\tR\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\tR\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\tR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\tR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00110\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\tR\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\tR\u0016\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\tR\u001a\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0\b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\tR\u000e\u00100\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/example/data/service/RideTrackingManager;", "", "<init>", "()V", "_isRecording", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isRecording", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "_isPaused", "isPaused", "_durationSeconds", "", "durationSeconds", "getDurationSeconds", "_distanceMeters", "", "distanceMeters", "getDistanceMeters", "_currentSpeedKmH", "currentSpeedKmH", "getCurrentSpeedKmH", "_avgSpeedKmH", "avgSpeedKmH", "getAvgSpeedKmH", "_maxSpeedKmH", "maxSpeedKmH", "getMaxSpeedKmH", "_currentElevationMeters", "currentElevationMeters", "getCurrentElevationMeters", "_elevationGainMeters", "elevationGainMeters", "getElevationGainMeters", "_maxGForce", "", "maxGForce", "getMaxGForce", "_currentLocation", "Landroid/location/Location;", "currentLocation", "getCurrentLocation", "_trackPoints", "", "Lcom/example/data/db/TrackPoint;", "trackPoints", "getTrackPoints", "startTimeMs", "lastLocation", "timerJob", "Lkotlinx/coroutines/Job;", "managerScope", "Lkotlinx/coroutines/CoroutineScope;", "updateGForce", "", "g", "pauseRecording", "resumeRecording", "startRecording", "context", "Landroid/content/Context;", "lastElevationRef", "onLocationReceived", "location", "discardRecording", "stopRecording", "repository", "Lcom/example/data/db/RideRepository;", "customTitle", "", "(Landroid/content/Context;Lcom/example/data/db/RideRepository;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RideTrackingManager {
    public static final int $stable;
    public static final RideTrackingManager INSTANCE = new RideTrackingManager();
    private static final MutableStateFlow<Double> _avgSpeedKmH;
    private static final MutableStateFlow<Double> _currentElevationMeters;
    private static final MutableStateFlow<Location> _currentLocation;
    private static final MutableStateFlow<Double> _currentSpeedKmH;
    private static final MutableStateFlow<Double> _distanceMeters;
    private static final MutableStateFlow<Long> _durationSeconds;
    private static final MutableStateFlow<Double> _elevationGainMeters;
    private static final MutableStateFlow<Boolean> _isPaused;
    private static final MutableStateFlow<Boolean> _isRecording;
    private static final MutableStateFlow<Float> _maxGForce;
    private static final MutableStateFlow<Double> _maxSpeedKmH;
    private static final MutableStateFlow<List<TrackPoint>> _trackPoints;
    private static final StateFlow<Double> avgSpeedKmH;
    private static final StateFlow<Double> currentElevationMeters;
    private static final StateFlow<Location> currentLocation;
    private static final StateFlow<Double> currentSpeedKmH;
    private static final StateFlow<Double> distanceMeters;
    private static final StateFlow<Long> durationSeconds;
    private static final StateFlow<Double> elevationGainMeters;
    private static final StateFlow<Boolean> isPaused;
    private static final StateFlow<Boolean> isRecording;
    private static double lastElevationRef;
    private static Location lastLocation;
    private static final CoroutineScope managerScope;
    private static final StateFlow<Float> maxGForce;
    private static final StateFlow<Double> maxSpeedKmH;
    private static long startTimeMs;
    private static Job timerJob;
    private static final StateFlow<List<TrackPoint>> trackPoints;

    /* JADX INFO: renamed from: com.example.data.service.RideTrackingManager$stopRecording$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RideTrackingManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.data.service.RideTrackingManager", f = "RideTrackingManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {369}, m = "stopRecording", n = {"context", "repository", "customTitle", "intent", "points", "dateStr", LinkHeader.Parameters.Title, "jsonArray", "record", "endTimeMs", "duration", "distance", "avgSpeed", "maxSpeed", "elevationGain", "currentElevation", "maxG"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "J$0", "J$1", "D$0", "D$1", "D$2", "D$3", "D$4", "F$0"})
    static final class C06651 extends ContinuationImpl {
        double D$0;
        double D$1;
        double D$2;
        double D$3;
        double D$4;
        float F$0;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C06651(Continuation<? super C06651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RideTrackingManager.this.stopRecording(null, null, null, this);
        }
    }

    private RideTrackingManager() {
    }

    static {
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        _isRecording = MutableStateFlow;
        isRecording = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(false);
        _isPaused = MutableStateFlow2;
        isPaused = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<Long> MutableStateFlow3 = StateFlowKt.MutableStateFlow(0L);
        _durationSeconds = MutableStateFlow3;
        durationSeconds = FlowKt.asStateFlow(MutableStateFlow3);
        Double dValueOf = Double.valueOf(0.0d);
        MutableStateFlow<Double> MutableStateFlow4 = StateFlowKt.MutableStateFlow(dValueOf);
        _distanceMeters = MutableStateFlow4;
        distanceMeters = FlowKt.asStateFlow(MutableStateFlow4);
        MutableStateFlow<Double> MutableStateFlow5 = StateFlowKt.MutableStateFlow(dValueOf);
        _currentSpeedKmH = MutableStateFlow5;
        currentSpeedKmH = FlowKt.asStateFlow(MutableStateFlow5);
        MutableStateFlow<Double> MutableStateFlow6 = StateFlowKt.MutableStateFlow(dValueOf);
        _avgSpeedKmH = MutableStateFlow6;
        avgSpeedKmH = FlowKt.asStateFlow(MutableStateFlow6);
        MutableStateFlow<Double> MutableStateFlow7 = StateFlowKt.MutableStateFlow(dValueOf);
        _maxSpeedKmH = MutableStateFlow7;
        maxSpeedKmH = FlowKt.asStateFlow(MutableStateFlow7);
        MutableStateFlow<Double> MutableStateFlow8 = StateFlowKt.MutableStateFlow(dValueOf);
        _currentElevationMeters = MutableStateFlow8;
        currentElevationMeters = FlowKt.asStateFlow(MutableStateFlow8);
        MutableStateFlow<Double> MutableStateFlow9 = StateFlowKt.MutableStateFlow(dValueOf);
        _elevationGainMeters = MutableStateFlow9;
        elevationGainMeters = FlowKt.asStateFlow(MutableStateFlow9);
        MutableStateFlow<Float> MutableStateFlow10 = StateFlowKt.MutableStateFlow(Float.valueOf(1.0f));
        _maxGForce = MutableStateFlow10;
        maxGForce = FlowKt.asStateFlow(MutableStateFlow10);
        MutableStateFlow<Location> MutableStateFlow11 = StateFlowKt.MutableStateFlow(null);
        _currentLocation = MutableStateFlow11;
        currentLocation = FlowKt.asStateFlow(MutableStateFlow11);
        MutableStateFlow<List<TrackPoint>> MutableStateFlow12 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        _trackPoints = MutableStateFlow12;
        trackPoints = FlowKt.asStateFlow(MutableStateFlow12);
        managerScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        $stable = 8;
    }

    public final StateFlow<Boolean> isRecording() {
        return isRecording;
    }

    public final StateFlow<Boolean> isPaused() {
        return isPaused;
    }

    public final StateFlow<Long> getDurationSeconds() {
        return durationSeconds;
    }

    public final StateFlow<Double> getDistanceMeters() {
        return distanceMeters;
    }

    public final StateFlow<Double> getCurrentSpeedKmH() {
        return currentSpeedKmH;
    }

    public final StateFlow<Double> getAvgSpeedKmH() {
        return avgSpeedKmH;
    }

    public final StateFlow<Double> getMaxSpeedKmH() {
        return maxSpeedKmH;
    }

    public final StateFlow<Double> getCurrentElevationMeters() {
        return currentElevationMeters;
    }

    public final StateFlow<Double> getElevationGainMeters() {
        return elevationGainMeters;
    }

    public final StateFlow<Float> getMaxGForce() {
        return maxGForce;
    }

    public final StateFlow<Location> getCurrentLocation() {
        return currentLocation;
    }

    public final StateFlow<List<TrackPoint>> getTrackPoints() {
        return trackPoints;
    }

    public final void updateGForce(float g) {
        if (!_isRecording.getValue().booleanValue() || _isPaused.getValue().booleanValue()) {
            return;
        }
        MutableStateFlow<Float> mutableStateFlow = _maxGForce;
        if (g > mutableStateFlow.getValue().floatValue()) {
            mutableStateFlow.setValue(Float.valueOf(g));
        }
    }

    public final void pauseRecording() {
        if (_isRecording.getValue().booleanValue()) {
            MutableStateFlow<Boolean> mutableStateFlow = _isPaused;
            if (mutableStateFlow.getValue().booleanValue()) {
                return;
            }
            mutableStateFlow.setValue(true);
            _currentSpeedKmH.setValue(Double.valueOf(0.0d));
        }
    }

    public final void resumeRecording() {
        if (_isRecording.getValue().booleanValue()) {
            MutableStateFlow<Boolean> mutableStateFlow = _isPaused;
            if (mutableStateFlow.getValue().booleanValue()) {
                mutableStateFlow.setValue(false);
            }
        }
    }

    public final void startRecording(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MutableStateFlow<Boolean> mutableStateFlow = _isRecording;
        if (mutableStateFlow.getValue().booleanValue()) {
            return;
        }
        mutableStateFlow.setValue(true);
        _isPaused.setValue(false);
        _durationSeconds.setValue(0L);
        _distanceMeters.setValue(Double.valueOf(0.0d));
        _currentSpeedKmH.setValue(Double.valueOf(0.0d));
        _avgSpeedKmH.setValue(Double.valueOf(0.0d));
        _maxSpeedKmH.setValue(Double.valueOf(0.0d));
        _currentElevationMeters.setValue(Double.valueOf(0.0d));
        _elevationGainMeters.setValue(Double.valueOf(0.0d));
        _maxGForce.setValue(Float.valueOf(1.0f));
        _trackPoints.setValue(CollectionsKt.emptyList());
        lastLocation = null;
        lastElevationRef = 0.0d;
        startTimeMs = System.currentTimeMillis();
        Job job = timerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        timerJob = BuildersKt__Builders_commonKt.launch$default(managerScope, null, null, new AnonymousClass1(null), 3, null);
        Intent intent = new Intent(context, (Class<?>) RideTrackingService.class);
        intent.setAction(RideTrackingService.ACTION_START);
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    /* JADX INFO: renamed from: com.example.data.service.RideTrackingManager$startRecording$1, reason: invalid class name */
    /* JADX INFO: compiled from: RideTrackingManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.data.service.RideTrackingManager$startRecording$1", f = "RideTrackingManager.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x002a  */
        /* JADX WARN: Code duplicated, block: B:13:0x0037 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:16:0x0048  */
        /* JADX WARN: Code duplicated, block: B:18:0x0074  */
        /* JADX WARN: Code duplicated, block: B:20:0x0095  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0035 -> B:14:0x0038). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:16:0x0048
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r10)
                goto L38
            Lf:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L17:
                kotlin.ResultKt.throwOnFailure(r10)
            L1a:
                kotlinx.coroutines.flow.MutableStateFlow r10 = com.example.data.service.RideTrackingManager.access$get_isRecording$p()
                java.lang.Object r10 = r10.getValue()
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                if (r10 == 0) goto La4
                r10 = r9
                kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
                r9.label = r2
                r3 = 1000(0x3e8, double:4.94E-321)
                java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r3, r10)
                if (r10 != r0) goto L38
                return r0
            L38:
                kotlinx.coroutines.flow.MutableStateFlow r10 = com.example.data.service.RideTrackingManager.access$get_isPaused$p()
                java.lang.Object r10 = r10.getValue()
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                if (r10 != 0) goto L1a
                kotlinx.coroutines.flow.MutableStateFlow r10 = com.example.data.service.RideTrackingManager.access$get_durationSeconds$p()
                java.lang.Object r1 = r10.getValue()
                java.lang.Number r1 = (java.lang.Number) r1
                long r3 = r1.longValue()
                r5 = 1
                long r3 = r3 + r5
                java.lang.Long r1 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r3)
                r10.setValue(r1)
                kotlinx.coroutines.flow.MutableStateFlow r10 = com.example.data.service.RideTrackingManager.access$get_durationSeconds$p()
                java.lang.Object r10 = r10.getValue()
                java.lang.Number r10 = (java.lang.Number) r10
                long r3 = r10.longValue()
                r5 = 0
                int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r10 <= 0) goto L1a
                kotlinx.coroutines.flow.MutableStateFlow r10 = com.example.data.service.RideTrackingManager.access$get_distanceMeters$p()
                java.lang.Object r10 = r10.getValue()
                java.lang.Number r10 = (java.lang.Number) r10
                double r5 = r10.doubleValue()
                r7 = 4652007308841189376(0x408f400000000000, double:1000.0)
                double r5 = r5 / r7
                double r3 = (double) r3
                r7 = 4660134898793709568(0x40ac200000000000, double:3600.0)
                double r3 = r3 / r7
                r7 = 0
                int r10 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
                if (r10 <= 0) goto L97
                double r7 = r5 / r3
            L97:
                kotlinx.coroutines.flow.MutableStateFlow r10 = com.example.data.service.RideTrackingManager.access$get_avgSpeedKmH$p()
                java.lang.Double r1 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r7)
                r10.setValue(r1)
                goto L1a
            La4:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.example.data.service.RideTrackingManager.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:114:0x0243  */
    /* JADX WARN: Code duplicated, block: B:138:0x029e  */
    /* JADX WARN: Code duplicated, block: B:139:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:141:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:145:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:155:0x030b  */
    public final void onLocationReceived(Location location) {
        double d;
        char c;
        double speed;
        double dCoerceAtMost;
        double d2;
        double d3;
        double d4;
        double d5;
        TrackPoint trackPoint;
        double dMax;
        float f;
        MutableStateFlow<Double> mutableStateFlow;
        Intrinsics.checkNotNullParameter(location, "location");
        _currentLocation.setValue(location);
        if (!_isRecording.getValue().booleanValue() || _isPaused.getValue().booleanValue()) {
            return;
        }
        if (!location.hasAccuracy() || location.getAccuracy() <= 50.0f) {
            Location location2 = lastLocation;
            double speed2 = 0.0d;
            boolean z = location.hasAltitude() && location.getAltitude() != 0.0d && (Build.VERSION.SDK_INT < 26 || !location.hasVerticalAccuracy() || location.getVerticalAccuracyMeters() <= 50.0f);
            double altitude = z ? location.getAltitude() : _currentElevationMeters.getValue().doubleValue();
            MutableStateFlow<Double> mutableStateFlow2 = _currentElevationMeters;
            double dDoubleValue = mutableStateFlow2.getValue().doubleValue();
            if (dDoubleValue == 0.0d) {
                d = altitude;
            } else if (z) {
                altitude = (altitude * 0.15d) + (dDoubleValue * 0.85d);
                d = altitude;
            } else {
                d = dDoubleValue;
            }
            mutableStateFlow2.setValue(Double.valueOf(d));
            if (location2 == null) {
                lastLocation = location;
                if (d > 0.0d) {
                    lastElevationRef = d;
                }
                if (location.hasSpeed() && location.getSpeed() > 0.2f) {
                    speed2 = location.getSpeed() * 3.6f;
                }
                if (0.5d <= speed2 && speed2 <= 150.0d) {
                    _currentSpeedKmH.setValue(Double.valueOf(speed2));
                    MutableStateFlow<Double> mutableStateFlow3 = _maxSpeedKmH;
                    mutableStateFlow3.setValue(Double.valueOf(Math.max(mutableStateFlow3.getValue().doubleValue(), speed2)));
                }
                _trackPoints.setValue(CollectionsKt.listOf(new TrackPoint(location.getLatitude(), location.getLongitude(), d, (float) (speed2 / 3.6d), location.getTime())));
                return;
            }
            double dDistanceTo = location2.distanceTo(location);
            double time = location.getTime() > location2.getTime() ? (location.getTime() - location2.getTime()) / 1000.0d : 1.0d;
            boolean z2 = location.hasSpeed() && location.getSpeed() >= 0.0f;
            if (z2) {
                c = 0;
                speed = location.getSpeed() * 3.6f;
            } else {
                c = 0;
                speed = -1.0d;
            }
            double d6 = time > 0.1d ? (dDistanceTo / time) * 3.6d : speed2;
            double d7 = z2 ? speed : d6;
            char c2 = (d7 < 0.8d || (dDistanceTo < 0.25d && (speed < 0.8d || !z2))) ? (char) 1 : c;
            if (d7 > r8) {
                lastLocation = location;
                return;
            }
            if (c2 == 0) {
                double dDoubleValue2 = _currentSpeedKmH.getValue().doubleValue();
                if (dDoubleValue2 == speed2) {
                    dCoerceAtMost = d7;
                } else if (d7 >= dDoubleValue2) {
                    d2 = 1.0d;
                    speed = speed;
                    dCoerceAtMost = (dDoubleValue2 * 0.4d) + ((!z2 ? RangesKt.coerceAtMost(d7, dDoubleValue2 + Math.max(time * 15.0d, 10.0d)) : d7) * 0.6d);
                } else if (d7 < 0.6d * dDoubleValue2 || d7 < 2.0d) {
                    dCoerceAtMost = d7;
                } else {
                    dCoerceAtMost = (dDoubleValue2 * 0.25d) + (0.75d * d7);
                }
                d3 = dCoerceAtMost;
                _currentSpeedKmH.setValue(Double.valueOf(RangesKt.coerceIn(dCoerceAtMost, 0.0d, 150.0d)));
                if (c2 == 0 && 0.8d <= d3 && d3 <= 4639481672377565184) {
                    mutableStateFlow = _maxSpeedKmH;
                    if (d3 > mutableStateFlow.getValue().doubleValue()) {
                        mutableStateFlow.setValue(Double.valueOf(d3));
                    }
                }
                char c3 = (z2 || speed >= 15.0d ? d6 > 120.0d : dDistanceTo > (((speed / 3.6d) * time) * 3.0d) + 8.0d) ? c : (char) 1;
                if (c2 == 0 && dDistanceTo >= 0.3d && c3 != 0) {
                    MutableStateFlow<Double> mutableStateFlow4 = _distanceMeters;
                    mutableStateFlow4.setValue(Double.valueOf(mutableStateFlow4.getValue().doubleValue() + dDistanceTo));
                }
                if (lastElevationRef == speed2 && d != speed2) {
                    lastElevationRef = d;
                }
                d4 = lastElevationRef;
                d5 = d - d4;
                if (d5 >= 0.8d) {
                    MutableStateFlow<Double> mutableStateFlow5 = _elevationGainMeters;
                    mutableStateFlow5.setValue(Double.valueOf(mutableStateFlow5.getValue().doubleValue() + d5));
                    lastElevationRef = d;
                } else if (d < d4 - d2) {
                    lastElevationRef = d;
                }
                lastLocation = location;
                MutableStateFlow<List<TrackPoint>> mutableStateFlow6 = _trackPoints;
                trackPoint = (TrackPoint) CollectionsKt.lastOrNull((List) mutableStateFlow6.getValue());
                if (trackPoint != null) {
                    float[] fArr = new float[1];
                    Location.distanceBetween(trackPoint.getLatitude(), trackPoint.getLongitude(), location.getLatitude(), location.getLongitude(), fArr);
                    f = fArr[c];
                    long time2 = location.getTime() - trackPoint.getTimestampMs();
                    if (f < 2.0d && time2 < 5000) {
                        return;
                    }
                }
                if (c2 == 0 || d7 <= speed2) {
                    dMax = speed2;
                } else {
                    dMax = Math.max(d7, d3);
                }
                mutableStateFlow6.setValue(CollectionsKt.plus((Collection<? extends TrackPoint>) mutableStateFlow6.getValue(), new TrackPoint(location.getLatitude(), location.getLongitude(), d, (float) (dMax / 3.6d), location.getTime())));
            }
            dCoerceAtMost = 0.0d;
            d2 = 1.0d;
            d3 = dCoerceAtMost;
            _currentSpeedKmH.setValue(Double.valueOf(RangesKt.coerceIn(dCoerceAtMost, 0.0d, 150.0d)));
            if (c2 == 0) {
                mutableStateFlow = _maxSpeedKmH;
                if (d3 > mutableStateFlow.getValue().doubleValue()) {
                    mutableStateFlow.setValue(Double.valueOf(d3));
                }
            }
            if (z2) {
            }
            if (c2 == 0) {
                MutableStateFlow<Double> mutableStateFlow7 = _distanceMeters;
                mutableStateFlow7.setValue(Double.valueOf(mutableStateFlow7.getValue().doubleValue() + dDistanceTo));
            }
            if (lastElevationRef == speed2) {
                lastElevationRef = d;
            }
            d4 = lastElevationRef;
            d5 = d - d4;
            if (d5 >= 0.8d) {
                MutableStateFlow<Double> mutableStateFlow8 = _elevationGainMeters;
                mutableStateFlow8.setValue(Double.valueOf(mutableStateFlow8.getValue().doubleValue() + d5));
                lastElevationRef = d;
            } else if (d < d4 - d2) {
                lastElevationRef = d;
            }
            lastLocation = location;
            MutableStateFlow<List<TrackPoint>> mutableStateFlow9 = _trackPoints;
            trackPoint = (TrackPoint) CollectionsKt.lastOrNull((List) mutableStateFlow9.getValue());
            if (trackPoint != null) {
                float[] fArr2 = new float[1];
                Location.distanceBetween(trackPoint.getLatitude(), trackPoint.getLongitude(), location.getLatitude(), location.getLongitude(), fArr2);
                f = fArr2[c];
                long time3 = location.getTime() - trackPoint.getTimestampMs();
                if (f < 2.0d) {
                    return;
                }
            }
            if (c2 == 0) {
                dMax = speed2;
            } else {
                dMax = speed2;
            }
            mutableStateFlow9.setValue(CollectionsKt.plus((Collection<? extends TrackPoint>) mutableStateFlow9.getValue(), new TrackPoint(location.getLatitude(), location.getLongitude(), d, (float) (dMax / 3.6d), location.getTime())));
        }
    }

    public final void discardRecording(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MutableStateFlow<Boolean> mutableStateFlow = _isRecording;
        if (mutableStateFlow.getValue().booleanValue()) {
            mutableStateFlow.setValue(false);
            _isPaused.setValue(false);
            Job job = timerJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            Intent intent = new Intent(context, (Class<?>) RideTrackingService.class);
            intent.setAction(RideTrackingService.ACTION_STOP);
            context.stopService(intent);
            _durationSeconds.setValue(0L);
            _distanceMeters.setValue(Double.valueOf(0.0d));
            _currentSpeedKmH.setValue(Double.valueOf(0.0d));
            _avgSpeedKmH.setValue(Double.valueOf(0.0d));
            _maxSpeedKmH.setValue(Double.valueOf(0.0d));
            _elevationGainMeters.setValue(Double.valueOf(0.0d));
            _maxGForce.setValue(Float.valueOf(1.0f));
            _trackPoints.setValue(CollectionsKt.emptyList());
            lastLocation = null;
        }
    }

    public static /* synthetic */ Object stopRecording$default(RideTrackingManager rideTrackingManager, Context context, RideRepository rideRepository, String str, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        return rideTrackingManager.stopRecording(context, rideRepository, str, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object stopRecording(Context context, RideRepository rideRepository, String str, Continuation<? super Long> continuation) throws JSONException {
        C06651 c06651;
        if (continuation instanceof C06651) {
            c06651 = (C06651) continuation;
            if ((c06651.label & Integer.MIN_VALUE) != 0) {
                c06651.label -= Integer.MIN_VALUE;
            } else {
                c06651 = new C06651(continuation);
            }
        } else {
            c06651 = new C06651(continuation);
        }
        Object objInsertRide = c06651.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06651.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objInsertRide);
            MutableStateFlow<Boolean> mutableStateFlow = _isRecording;
            if (!mutableStateFlow.getValue().booleanValue()) {
                return Boxing.boxLong(-1L);
            }
            mutableStateFlow.setValue(Boxing.boxBoolean(false));
            _isPaused.setValue(Boxing.boxBoolean(false));
            Job job = timerJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            Intent intent = new Intent(context, (Class<?>) RideTrackingService.class);
            intent.setAction(RideTrackingService.ACTION_STOP);
            context.stopService(intent);
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jLongValue = _durationSeconds.getValue().longValue();
            double dDoubleValue = _distanceMeters.getValue().doubleValue();
            double dDoubleValue2 = _avgSpeedKmH.getValue().doubleValue();
            double dDoubleValue3 = _maxSpeedKmH.getValue().doubleValue();
            double dDoubleValue4 = _elevationGainMeters.getValue().doubleValue();
            double dDoubleValue5 = _currentElevationMeters.getValue().doubleValue();
            float fFloatValue = _maxGForce.getValue().floatValue();
            List<TrackPoint> value = _trackPoints.getValue();
            String str2 = new SimpleDateFormat("yyyy年MM月dd日", Locale.CHINA).format(new Date(startTimeMs));
            String str3 = str == null ? "骑行 " + str2 : str;
            JSONArray jSONArray = new JSONArray();
            for (TrackPoint trackPoint : value) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("latitude", trackPoint.getLatitude());
                jSONObject.put("longitude", trackPoint.getLongitude());
                jSONObject.put("altitude", trackPoint.getAltitude());
                jSONObject.put("speedMeterPerSec", Boxing.boxFloat(trackPoint.getSpeedMeterPerSec()));
                jSONObject.put("timestampMs", trackPoint.getTimestampMs());
                jSONArray.put(jSONObject);
                value = value;
                intent = intent;
            }
            Intent intent2 = intent;
            List<TrackPoint> list = value;
            long j = startTimeMs;
            String string = jSONArray.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            RideRecordEntity rideRecordEntity = new RideRecordEntity(0L, str3, j, jCurrentTimeMillis, jLongValue, dDoubleValue, dDoubleValue2, dDoubleValue3, dDoubleValue4, dDoubleValue5, fFloatValue, string, 1, null);
            c06651.L$0 = SpillingKt.nullOutSpilledVariable(context);
            c06651.L$1 = SpillingKt.nullOutSpilledVariable(rideRepository);
            c06651.L$2 = SpillingKt.nullOutSpilledVariable(str);
            c06651.L$3 = SpillingKt.nullOutSpilledVariable(intent2);
            c06651.L$4 = SpillingKt.nullOutSpilledVariable(list);
            c06651.L$5 = SpillingKt.nullOutSpilledVariable(str2);
            c06651.L$6 = SpillingKt.nullOutSpilledVariable(str3);
            c06651.L$7 = SpillingKt.nullOutSpilledVariable(jSONArray);
            c06651.L$8 = SpillingKt.nullOutSpilledVariable(rideRecordEntity);
            c06651.J$0 = jCurrentTimeMillis;
            c06651.J$1 = jLongValue;
            c06651.D$0 = dDoubleValue;
            c06651.D$1 = dDoubleValue2;
            c06651.D$2 = dDoubleValue3;
            c06651.D$3 = dDoubleValue4;
            c06651.D$4 = dDoubleValue5;
            c06651.F$0 = fFloatValue;
            c06651.label = 1;
            objInsertRide = rideRepository.insertRide(rideRecordEntity, c06651);
            if (objInsertRide == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            float f = c06651.F$0;
            double d = c06651.D$4;
            double d2 = c06651.D$3;
            double d3 = c06651.D$2;
            double d4 = c06651.D$1;
            double d5 = c06651.D$0;
            long j2 = c06651.J$1;
            long j3 = c06651.J$0;
            ResultKt.throwOnFailure(objInsertRide);
        }
        long jLongValue2 = ((Number) objInsertRide).longValue();
        _durationSeconds.setValue(Boxing.boxLong(0L));
        _distanceMeters.setValue(Boxing.boxDouble(0.0d));
        _currentSpeedKmH.setValue(Boxing.boxDouble(0.0d));
        _avgSpeedKmH.setValue(Boxing.boxDouble(0.0d));
        _maxSpeedKmH.setValue(Boxing.boxDouble(0.0d));
        _elevationGainMeters.setValue(Boxing.boxDouble(0.0d));
        _maxGForce.setValue(Boxing.boxFloat(1.0f));
        return Boxing.boxLong(jLongValue2);
    }
}
