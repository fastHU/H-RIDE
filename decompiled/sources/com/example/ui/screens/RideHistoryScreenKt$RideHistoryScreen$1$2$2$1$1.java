package com.example.ui.screens;

import androidx.compose.runtime.MutableState;
import com.example.data.db.RideRecordEntity;
import com.example.data.db.RideRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RideHistoryScreen.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.ui.screens.RideHistoryScreenKt$RideHistoryScreen$1$2$2$1$1", f = "RideHistoryScreen.kt", i = {}, l = {291}, m = "invokeSuspend", n = {}, s = {})
final class RideHistoryScreenKt$RideHistoryScreen$1$2$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $newTitle;
    final /* synthetic */ RideRepository $repository;
    final /* synthetic */ RideRecordEntity $ride;
    final /* synthetic */ MutableState<RideRecordEntity> $selectedRideForDetail$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RideHistoryScreenKt$RideHistoryScreen$1$2$2$1$1(RideRepository rideRepository, RideRecordEntity rideRecordEntity, String str, MutableState<RideRecordEntity> mutableState, Continuation<? super RideHistoryScreenKt$RideHistoryScreen$1$2$2$1$1> continuation) {
        super(2, continuation);
        this.$repository = rideRepository;
        this.$ride = rideRecordEntity;
        this.$newTitle = str;
        this.$selectedRideForDetail$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RideHistoryScreenKt$RideHistoryScreen$1$2$2$1$1(this.$repository, this.$ride, this.$newTitle, this.$selectedRideForDetail$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RideHistoryScreenKt$RideHistoryScreen$1$2$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$repository.updateTitle(this.$ride.getId(), this.$newTitle, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$selectedRideForDetail$delegate.setValue(null);
        return Unit.INSTANCE;
    }
}
