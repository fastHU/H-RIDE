package com.example.data.db;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: RideRepository.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00072\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0018\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/example/data/db/RideRepository;", "", "dao", "Lcom/example/data/db/RideRecordDao;", "<init>", "(Lcom/example/data/db/RideRecordDao;)V", "allRides", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/data/db/RideRecordEntity;", "getAllRides", "()Lkotlinx/coroutines/flow/Flow;", "getRideById", "id", "", "insertRide", "ride", "(Lcom/example/data/db/RideRecordEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTitle", "", "newTitle", "", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRide", "deleteRideById", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RideRepository {
    public static final int $stable = 8;
    private final Flow<List<RideRecordEntity>> allRides;
    private final RideRecordDao dao;

    public RideRepository(RideRecordDao dao) {
        Intrinsics.checkNotNullParameter(dao, "dao");
        this.dao = dao;
        this.allRides = dao.getAllRides();
    }

    public final Flow<List<RideRecordEntity>> getAllRides() {
        return this.allRides;
    }

    public final Flow<RideRecordEntity> getRideById(long id) {
        return this.dao.getRideById(id);
    }

    public final Object insertRide(RideRecordEntity rideRecordEntity, Continuation<? super Long> continuation) {
        return this.dao.insertRide(rideRecordEntity, continuation);
    }

    public final Object updateTitle(long j, String str, Continuation<? super Unit> continuation) {
        Object objUpdateRideTitle = this.dao.updateRideTitle(j, str, continuation);
        return objUpdateRideTitle == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateRideTitle : Unit.INSTANCE;
    }

    public final Object deleteRide(RideRecordEntity rideRecordEntity, Continuation<? super Unit> continuation) {
        Object objDeleteRide = this.dao.deleteRide(rideRecordEntity, continuation);
        return objDeleteRide == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteRide : Unit.INSTANCE;
    }

    public final Object deleteRideById(long j, Continuation<? super Unit> continuation) {
        Object objDeleteRideById = this.dao.deleteRideById(j, continuation);
        return objDeleteRideById == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteRideById : Unit.INSTANCE;
    }
}
