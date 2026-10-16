package com.example.ui.theme;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: GlassComponents.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.ui.theme.GlassComponentsKt$LiquidFilterDock$1$1", f = "GlassComponents.kt", i = {0}, l = {526}, m = "invokeSuspend", n = {"$this$pointerInput"}, s = {"L$0"})
final class GlassComponentsKt$LiquidFilterDock$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Float> $dragOffsetPx$delegate;
    final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
    final /* synthetic */ float $maxDragPx;
    final /* synthetic */ State<Function1<String, Unit>> $onOptionSelectedState;
    final /* synthetic */ List<String> $options;
    final /* synthetic */ State<String> $selectedOptionState;
    final /* synthetic */ float $tabWidthPx;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    GlassComponentsKt$LiquidFilterDock$1$1(State<String> state, List<String> list, float f, float f2, State<? extends Function1<? super String, Unit>> state2, MutableState<Boolean> mutableState, MutableState<Float> mutableState2, Continuation<? super GlassComponentsKt$LiquidFilterDock$1$1> continuation) {
        super(2, continuation);
        this.$selectedOptionState = state;
        this.$options = list;
        this.$tabWidthPx = f;
        this.$maxDragPx = f2;
        this.$onOptionSelectedState = state2;
        this.$isPressed$delegate = mutableState;
        this.$dragOffsetPx$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GlassComponentsKt$LiquidFilterDock$1$1 glassComponentsKt$LiquidFilterDock$1$1 = new GlassComponentsKt$LiquidFilterDock$1$1(this.$selectedOptionState, this.$options, this.$tabWidthPx, this.$maxDragPx, this.$onOptionSelectedState, this.$isPressed$delegate, this.$dragOffsetPx$delegate, continuation);
        glassComponentsKt$LiquidFilterDock$1$1.L$0 = obj;
        return glassComponentsKt$LiquidFilterDock$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((GlassComponentsKt$LiquidFilterDock$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.example.ui.theme.GlassComponentsKt$LiquidFilterDock$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: GlassComponents.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.ui.theme.GlassComponentsKt$LiquidFilterDock$1$1$1", f = "GlassComponents.kt", i = {0, 1, 1, 1}, l = {528, 533}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "down", "dragAccumulator"}, s = {"L$0", "L$0", "L$1", "F$0"})
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<Float> $dragOffsetPx$delegate;
        final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
        final /* synthetic */ float $maxDragPx;
        final /* synthetic */ State<Function1<String, Unit>> $onOptionSelectedState;
        final /* synthetic */ List<String> $options;
        final /* synthetic */ State<String> $selectedOptionState;
        final /* synthetic */ float $tabWidthPx;
        float F$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(State<String> state, List<String> list, float f, float f2, State<? extends Function1<? super String, Unit>> state2, MutableState<Boolean> mutableState, MutableState<Float> mutableState2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$selectedOptionState = state;
            this.$options = list;
            this.$tabWidthPx = f;
            this.$maxDragPx = f2;
            this.$onOptionSelectedState = state2;
            this.$isPressed$delegate = mutableState;
            this.$dragOffsetPx$delegate = mutableState2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$selectedOptionState, this.$options, this.$tabWidthPx, this.$maxDragPx, this.$onOptionSelectedState, this.$isPressed$delegate, this.$dragOffsetPx$delegate, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:31:0x00a7  */
        /* JADX WARN: Code duplicated, block: B:47:0x004b A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:48:0x00b4 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:49:? A[LOOP:0: B:29:0x00a1->B:49:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x005a -> B:18:0x005d). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:47:0x004b
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instruction units count: 337
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.example.ui.theme.GlassComponentsKt$LiquidFilterDock$1$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(pointerInputScope);
            this.label = 1;
            if (pointerInputScope.awaitPointerEventScope(new AnonymousClass1(this.$selectedOptionState, this.$options, this.$tabWidthPx, this.$maxDragPx, this.$onOptionSelectedState, this.$isPressed$delegate, this.$dragOffsetPx$delegate, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
