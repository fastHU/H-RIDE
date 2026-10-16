package com.example.data.db;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: RideRecordDao.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H'J\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\u0006\u0010\u0007\u001a\u00020\bH'J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\u0013¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/example/data/db/RideRecordDao;", "", "getAllRides", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/data/db/RideRecordEntity;", "getRideById", "id", "", "insertRide", "ride", "(Lcom/example/data/db/RideRecordEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRideTitle", "", "newTitle", "", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRide", "deleteRideById", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface RideRecordDao {
    Object deleteRide(RideRecordEntity rideRecordEntity, Continuation<? super Unit> continuation);

    Object deleteRideById(long j, Continuation<? super Unit> continuation);

    Flow<List<RideRecordEntity>> getAllRides();

    Flow<RideRecordEntity> getRideById(long id);

    Object insertRide(RideRecordEntity rideRecordEntity, Continuation<? super Long> continuation);

    Object updateRideTitle(long j, String str, Continuation<? super Unit> continuation);
}
