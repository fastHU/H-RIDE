package com.example.ui.screens;

import android.content.Context;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RideRecordingScreen.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.ui.screens.RideRecordingScreenKt$RideRecordingScreen$2$1", f = "RideRecordingScreen.kt", i = {0}, l = {70}, m = "invokeSuspend", n = {"i"}, s = {"I$0"})
final class RideRecordingScreenKt$RideRecordingScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableIntState $countdownValue$delegate;
    final /* synthetic */ MutableState<Boolean> $isCountingDown$delegate;
    int I$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RideRecordingScreenKt$RideRecordingScreen$2$1(Context context, MutableState<Boolean> mutableState, MutableIntState mutableIntState, Continuation<? super RideRecordingScreenKt$RideRecordingScreen$2$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$isCountingDown$delegate = mutableState;
        this.$countdownValue$delegate = mutableIntState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RideRecordingScreenKt$RideRecordingScreen$2$1(this.$context, this.$isCountingDown$delegate, this.$countdownValue$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RideRecordingScreenKt$RideRecordingScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0028  */
    /* JADX WARN: Code duplicated, block: B:14:0x003c A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:15:0x003d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L19
            if (r1 != r2) goto L11
            int r1 = r5.I$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L3d
        L11:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L19:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.compose.runtime.MutableState<java.lang.Boolean> r6 = r5.$isCountingDown$delegate
            boolean r6 = com.example.ui.screens.RideRecordingScreenKt.access$RideRecordingScreen$lambda$7(r6)
            if (r6 == 0) goto L4d
            r6 = 3
            r1 = r6
        L26:
            if (r1 <= 0) goto L40
            androidx.compose.runtime.MutableIntState r6 = r5.$countdownValue$delegate
            com.example.ui.screens.RideRecordingScreenKt.access$RideRecordingScreen$lambda$5(r6, r1)
            r6 = r5
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r5.I$0 = r1
            r5.label = r2
            r3 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r6)
            if (r6 != r0) goto L3d
            return r0
        L3d:
            int r1 = r1 + (-1)
            goto L26
        L40:
            androidx.compose.runtime.MutableState<java.lang.Boolean> r6 = r5.$isCountingDown$delegate
            r0 = 0
            com.example.ui.screens.RideRecordingScreenKt.access$RideRecordingScreen$lambda$8(r6, r0)
            com.example.data.service.RideTrackingManager r6 = com.example.data.service.RideTrackingManager.INSTANCE
            android.content.Context r5 = r5.$context
            r6.startRecording(r5)
        L4d:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.screens.RideRecordingScreenKt$RideRecordingScreen$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
