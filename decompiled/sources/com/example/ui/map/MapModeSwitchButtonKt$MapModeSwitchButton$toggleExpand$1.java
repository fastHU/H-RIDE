package com.example.ui.map;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MapModeSwitchButton.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.ui.map.MapModeSwitchButtonKt$MapModeSwitchButton$toggleExpand$1", f = "MapModeSwitchButton.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
final class MapModeSwitchButtonKt$MapModeSwitchButton$toggleExpand$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $expandProgress;
    final /* synthetic */ MutableState<Boolean> $isAnimating$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MapModeSwitchButtonKt$MapModeSwitchButton$toggleExpand$1(Animatable<Float, AnimationVector1D> animatable, MutableState<Boolean> mutableState, Continuation<? super MapModeSwitchButtonKt$MapModeSwitchButton$toggleExpand$1> continuation) {
        super(2, continuation);
        this.$expandProgress = animatable;
        this.$isAnimating$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MapModeSwitchButtonKt$MapModeSwitchButton$toggleExpand$1(this.$expandProgress, this.$isAnimating$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MapModeSwitchButtonKt$MapModeSwitchButton$toggleExpand$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MapModeSwitchButtonKt.MapModeSwitchButton$lambda$5(this.$isAnimating$delegate, true);
            this.label = 1;
            if (Animatable.animateTo$default(this.$expandProgress, Boxing.boxFloat(1.0f), AnimationSpecKt.spring$default(0.55f, 320.0f, null, 4, null), null, null, this, 12, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        MapModeSwitchButtonKt.MapModeSwitchButton$lambda$5(this.$isAnimating$delegate, false);
        return Unit.INSTANCE;
    }
}
