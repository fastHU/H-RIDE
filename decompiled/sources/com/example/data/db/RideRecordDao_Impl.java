package com.example.data.db;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: RideRecordDao_Impl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00130\u0012H\u0016J\u0018\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00122\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u001e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/example/data/db/RideRecordDao_Impl;", "Lcom/example/data/db/RideRecordDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfRideRecordEntity", "Landroidx/room/EntityInsertAdapter;", "Lcom/example/data/db/RideRecordEntity;", "__deleteAdapterOfRideRecordEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "insertRide", "", "ride", "(Lcom/example/data/db/RideRecordEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRide", "", "getAllRides", "Lkotlinx/coroutines/flow/Flow;", "", "getRideById", "id", "updateRideTitle", "newTitle", "", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRideById", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RideRecordDao_Impl implements RideRecordDao {
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<RideRecordEntity> __deleteAdapterOfRideRecordEntity;
    private final EntityInsertAdapter<RideRecordEntity> __insertAdapterOfRideRecordEntity;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public RideRecordDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfRideRecordEntity = new EntityInsertAdapter<RideRecordEntity>() { // from class: com.example.data.db.RideRecordDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `ride_records` (`id`,`title`,`startTimeMs`,`endTimeMs`,`durationSeconds`,`distanceMeters`,`avgSpeedKmH`,`maxSpeedKmH`,`elevationGainMeters`,`currentElevationMeters`,`maxGForce`,`trackPointsJson`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            public void bind(SQLiteStatement statement, RideRecordEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo6569bindLong(1, entity.getId());
                statement.mo6571bindText(2, entity.getTitle());
                statement.mo6569bindLong(3, entity.getStartTimeMs());
                statement.mo6569bindLong(4, entity.getEndTimeMs());
                statement.mo6569bindLong(5, entity.getDurationSeconds());
                statement.mo6568bindDouble(6, entity.getDistanceMeters());
                statement.mo6568bindDouble(7, entity.getAvgSpeedKmH());
                statement.mo6568bindDouble(8, entity.getMaxSpeedKmH());
                statement.mo6568bindDouble(9, entity.getElevationGainMeters());
                statement.mo6568bindDouble(10, entity.getCurrentElevationMeters());
                statement.mo6568bindDouble(11, entity.getMaxGForce());
                statement.mo6571bindText(12, entity.getTrackPointsJson());
            }
        };
        this.__deleteAdapterOfRideRecordEntity = new EntityDeleteOrUpdateAdapter<RideRecordEntity>() { // from class: com.example.data.db.RideRecordDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String createQuery() {
                return "DELETE FROM `ride_records` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            public void bind(SQLiteStatement statement, RideRecordEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.mo6569bindLong(1, entity.getId());
            }
        };
    }

    @Override // com.example.data.db.RideRecordDao
    public Object insertRide(final RideRecordEntity rideRecordEntity, Continuation<? super Long> continuation) {
        return DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.db.RideRecordDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(RideRecordDao_Impl.insertRide$lambda$0(this.f$0, rideRecordEntity, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    static final long insertRide$lambda$0(RideRecordDao_Impl rideRecordDao_Impl, RideRecordEntity rideRecordEntity, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return rideRecordDao_Impl.__insertAdapterOfRideRecordEntity.insertAndReturnId(_connection, rideRecordEntity);
    }

    @Override // com.example.data.db.RideRecordDao
    public Object deleteRide(final RideRecordEntity rideRecordEntity, Continuation<? super Unit> continuation) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.db.RideRecordDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RideRecordDao_Impl.deleteRide$lambda$1(this.f$0, rideRecordEntity, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    static final Unit deleteRide$lambda$1(RideRecordDao_Impl rideRecordDao_Impl, RideRecordEntity rideRecordEntity, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        rideRecordDao_Impl.__deleteAdapterOfRideRecordEntity.handle(_connection, rideRecordEntity);
        return Unit.INSTANCE;
    }

    @Override // com.example.data.db.RideRecordDao
    public Flow<List<RideRecordEntity>> getAllRides() {
        final String str = "SELECT * FROM ride_records ORDER BY startTimeMs DESC";
        return FlowUtil.createFlow(this.__db, false, new String[]{"ride_records"}, new Function1() { // from class: com.example.data.db.RideRecordDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RideRecordDao_Impl.getAllRides$lambda$2(str, (SQLiteConnection) obj);
            }
        });
    }

    static final List getAllRides$lambda$2(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, LinkHeader.Parameters.Title);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "startTimeMs");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "endTimeMs");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "durationSeconds");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "distanceMeters");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "avgSpeedKmH");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "maxSpeedKmH");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "elevationGainMeters");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "currentElevationMeters");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "maxGForce");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trackPointsJson");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new RideRecordEntity(sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getLong(columnIndexOrThrow3), sQLiteStatementPrepare.getLong(columnIndexOrThrow4), sQLiteStatementPrepare.getLong(columnIndexOrThrow5), sQLiteStatementPrepare.getDouble(columnIndexOrThrow6), sQLiteStatementPrepare.getDouble(columnIndexOrThrow7), sQLiteStatementPrepare.getDouble(columnIndexOrThrow8), sQLiteStatementPrepare.getDouble(columnIndexOrThrow9), sQLiteStatementPrepare.getDouble(columnIndexOrThrow10), (float) sQLiteStatementPrepare.getDouble(columnIndexOrThrow11), sQLiteStatementPrepare.getText(columnIndexOrThrow12)));
            }
            sQLiteStatementPrepare.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.example.data.db.RideRecordDao
    public Flow<RideRecordEntity> getRideById(final long id) {
        final String str = "SELECT * FROM ride_records WHERE id = ?";
        return FlowUtil.createFlow(this.__db, false, new String[]{"ride_records"}, new Function1() { // from class: com.example.data.db.RideRecordDao_Impl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RideRecordDao_Impl.getRideById$lambda$3(str, id, (SQLiteConnection) obj);
            }
        });
    }

    static final RideRecordEntity getRideById$lambda$3(String str, long j, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo6569bindLong(1, j);
            return sQLiteStatementPrepare.step() ? new RideRecordEntity(sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, LinkHeader.Parameters.Title)), sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "startTimeMs")), sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "endTimeMs")), sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "durationSeconds")), sQLiteStatementPrepare.getDouble(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "distanceMeters")), sQLiteStatementPrepare.getDouble(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "avgSpeedKmH")), sQLiteStatementPrepare.getDouble(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "maxSpeedKmH")), sQLiteStatementPrepare.getDouble(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "elevationGainMeters")), sQLiteStatementPrepare.getDouble(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "currentElevationMeters")), (float) sQLiteStatementPrepare.getDouble(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "maxGForce")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "trackPointsJson"))) : null;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.example.data.db.RideRecordDao
    public Object updateRideTitle(final long j, final String str, Continuation<? super Unit> continuation) {
        final String str2 = "UPDATE ride_records SET title = ? WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.db.RideRecordDao_Impl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RideRecordDao_Impl.updateRideTitle$lambda$4(str2, str, j, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    static final Unit updateRideTitle$lambda$4(String str, String str2, long j, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo6571bindText(1, str2);
            sQLiteStatementPrepare.mo6569bindLong(2, j);
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.example.data.db.RideRecordDao
    public Object deleteRideById(final long j, Continuation<? super Unit> continuation) {
        final String str = "DELETE FROM ride_records WHERE id = ?";
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new Function1() { // from class: com.example.data.db.RideRecordDao_Impl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RideRecordDao_Impl.deleteRideById$lambda$5(str, j, (SQLiteConnection) obj);
            }
        }, continuation);
        return objPerformSuspending == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPerformSuspending : Unit.INSTANCE;
    }

    static final Unit deleteRideById$lambda$5(String str, long j, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo6569bindLong(1, j);
            sQLiteStatementPrepare.step();
            return Unit.INSTANCE;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: compiled from: RideRecordDao_Impl.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/example/data/db/RideRecordDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<KClass<?>> getRequiredConverters() {
            return CollectionsKt.emptyList();
        }
    }
}
