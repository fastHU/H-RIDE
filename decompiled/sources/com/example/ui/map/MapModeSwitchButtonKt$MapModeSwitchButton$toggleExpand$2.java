package com.example.ui.map;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: MapModeSwitchButton.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.ui.map.MapModeSwitchButtonKt$MapModeSwitchButton$toggleExpand$2", f = "MapModeSwitchButton.kt", i = {0, 0, 1, 1, 2, 2, 3, 3}, l = {80, 81, 85, 93}, m = "invokeSuspend", n = {"$this$launch", "collapseJob", "$this$launch", "collapseJob", "$this$launch", "collapseJob", "$this$launch", "collapseJob"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
final class MapModeSwitchButtonKt$MapModeSwitchButton$toggleExpand$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $buttonOffsetY;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $expandProgress;
    final /* synthetic */ MutableState<Boolean> $isAnimating$delegate;
    final /* synthetic */ MutableState<Boolean> $isExpanded$delegate;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MapModeSwitchButtonKt$MapModeSwitchButton$toggleExpand$2(Animatable<Float, AnimationVector1D> animatable, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Animatable<Float, AnimationVector1D> animatable2, Continuation<? super MapModeSwitchButtonKt$MapModeSwitchButton$toggleExpand$2> continuation) {
        super(2, continuation);
        this.$buttonOffsetY = animatable;
        this.$isAnimating$delegate = mutableState;
        this.$isExpanded$delegate = mutableState2;
        this.$expandProgress = animatable2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MapModeSwitchButtonKt$MapModeSwitchButton$toggleExpand$2 mapModeSwitchButtonKt$MapModeSwitchButton$toggleExpand$2 = new MapModeSwitchButtonKt$MapModeSwitchButton$toggleExpand$2(this.$buttonOffsetY, this.$isAnimating$delegate, this.$isExpanded$delegate, this.$expandProgress, continuation);
        mapModeSwitchButtonKt$MapModeSwitchButton$toggleExpand$2.L$0 = obj;
        return mapModeSwitchButtonKt$MapModeSwitchButton$toggleExpand$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MapModeSwitchButtonKt$MapModeSwitchButton$toggleExpand$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00e1 A[PHI: r3
      0x00e1: PHI (r3v8 kotlinx.coroutines.Job) = (r3v7 kotlinx.coroutines.Job), (r3v14 kotlinx.coroutines.Job) binds: [B:21:0x00de, B:11:0x002e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00f6, code lost:
    
        if (r3.join(r22) == r1) goto L25;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Job jobLaunch$default;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                jobLaunch$default = (Job) this.L$1;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i == 2) {
                    jobLaunch$default = (Job) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = jobLaunch$default;
                    this.label = 3;
                    if (Animatable.animateTo$default(this.$buttonOffsetY, Boxing.boxFloat(0.0f), AnimationSpecKt.spring$default(0.38f, 280.0f, null, 4, null), null, null, this, 12, null) != coroutine_suspended) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(jobLaunch$default);
                        this.label = 4;
                    }
                    return coroutine_suspended;
                }
                if (i == 3) {
                    jobLaunch$default = (Job) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(jobLaunch$default);
                    this.label = 4;
                } else {
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            }
            MapModeSwitchButtonKt.MapModeSwitchButton$lambda$5(this.$isAnimating$delegate, false);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        MapModeSwitchButtonKt.MapModeSwitchButton$lambda$5(this.$isAnimating$delegate, true);
        MapModeSwitchButtonKt.MapModeSwitchButton$lambda$2(this.$isExpanded$delegate, false);
        jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MapModeSwitchButtonKt$MapModeSwitchButton$toggleExpand$2$collapseJob$1(this.$expandProgress, null), 3, null);
        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
        this.L$1 = jobLaunch$default;
        this.label = 1;
        if (DelayKt.delay(90L, this) != coroutine_suspended) {
        }
        return coroutine_suspended;
        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
        this.L$1 = jobLaunch$default;
        this.label = 2;
        if (Animatable.animateTo$default(this.$buttonOffsetY, Boxing.boxFloat(12.0f), AnimationSpecKt.tween$default(75, 0, EasingKt.getFastOutSlowInEasing(), 2, null), null, null, this, 12, null) != coroutine_suspended) {
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = jobLaunch$default;
            this.label = 3;
            if (Animatable.animateTo$default(this.$buttonOffsetY, Boxing.boxFloat(0.0f), AnimationSpecKt.spring$default(0.38f, 280.0f, null, 4, null), null, null, this, 12, null) != coroutine_suspended) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(jobLaunch$default);
                this.label = 4;
            }
        }
        return coroutine_suspended;
    }
}
