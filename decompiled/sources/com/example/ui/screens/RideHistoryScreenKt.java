package com.example.ui.screens;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.widget.Toast;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AccountCircleKt;
import androidx.compose.material.icons.filled.ArrowBackKt;
import androidx.compose.material.icons.filled.PedalBikeKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import coil.compose.SingletonAsyncImageKt;
import com.example.data.db.CleanedRideStats;
import com.example.data.db.RideRecordEntity;
import com.example.data.db.RideRepository;
import com.example.ui.map.MapMode;
import com.example.ui.theme.GlassComponentsKt;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.osmdroid.tileprovider.constants.OpenStreetMapTileProviderConstants;

/* JADX INFO: compiled from: RideHistoryScreen.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a#\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0007¢\u0006\u0002\u0010\f\u001a3\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0003¢\u0006\u0002\u0010\u0013\u001a-\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0003¢\u0006\u0002\u0010\u0018¨\u0006\u0019²\u0006\f\u0010\u001a\u001a\u0004\u0018\u00010\u0001X\u008a\u008e\u0002²\u0006\u0010\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001cX\u008a\u0084\u0002²\u0006\n\u0010\u001d\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\f\u0010\u001e\u001a\u0004\u0018\u00010\u0016X\u008a\u008e\u0002"}, d2 = {"saveAvatarToInternalStorage", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "RideHistoryScreen", "", "repository", "Lcom/example/data/db/RideRepository;", "onNavigateHome", "Lkotlin/Function0;", "(Lcom/example/data/db/RideRepository;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "FilterChipItem", "label", "isSelected", "", "testTag", "onClick", "(Ljava/lang/String;ZLjava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "RideCardItem", "ride", "Lcom/example/data/db/RideRecordEntity;", "isLightBg", "(Lcom/example/data/db/RideRecordEntity;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app", "avatarPath", "ridesList", "", "selectedFilter", "selectedRideForDetail"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RideHistoryScreenKt {

    /* JADX INFO: compiled from: RideHistoryScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MapMode.values().length];
            try {
                iArr[MapMode.LIGHT_STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MapMode.SATELLITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static final Unit FilterChipItem$lambda$53(String str, boolean z, String str2, Function0 function0, int i, Composer composer, int i2) {
        FilterChipItem(str, z, str2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit RideCardItem$lambda$65(RideRecordEntity rideRecordEntity, boolean z, Function0 function0, int i, int i2, Composer composer, int i3) {
        RideCardItem(rideRecordEntity, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit RideHistoryScreen$lambda$51(RideRepository rideRepository, Function0 function0, int i, Composer composer, int i2) {
        RideHistoryScreen(rideRepository, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final String saveAvatarToInternalStorage(Context context, Uri uri) {
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                return null;
            }
            File file = new File(context.getFilesDir(), "user_avatar.jpg");
            InputStream inputStream = inputStreamOpenInputStream;
            try {
                InputStream inputStream2 = inputStream;
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    ByteStreamsKt.copyTo$default(inputStream2, fileOutputStream, 0, 2, null);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    CloseableKt.closeFinally(inputStream, null);
                    return file.getAbsolutePath();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(fileOutputStream, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(inputStream, th3);
                    throw th4;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final void RideHistoryScreen(final RideRepository repository, final Function0<Unit> onNavigateHome, Composer composer, final int i) {
        long jM3857getWhite0d7_KjU;
        long alpinePrimary;
        int i2;
        Object obj;
        float f;
        int i3;
        Object obj2;
        float f2;
        Composer composer2;
        final MutableState mutableState;
        MapMode mapModeValueOf;
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(onNavigateHome, "onNavigateHome");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1409176562);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RideHistoryScreen)P(1)75@2795L7,76@2819L77,77@2919L107,83@3155L455,81@3058L552,96@3637L24,97@3703L37,99@3768L33,100@3855L52,102@3931L76,103@4034L85,104@4145L193,124@4879L412,136@5297L6623:RideHistoryScreen.kt#2thlc2");
        int i4 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(repository) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onNavigateHome) ? 32 : 16;
        }
        int i5 = i4;
        if ((i5 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1409176562, i5, -1, "com.example.ui.screens.RideHistoryScreen (RideHistoryScreen.kt:74)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Context context = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1303972741, "CC(remember):RideHistoryScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = context.getSharedPreferences("user_prefs", 0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final SharedPreferences sharedPreferences = (SharedPreferences) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1303969511, "CC(remember):RideHistoryScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                String string = sharedPreferences.getString("avatar_path", null);
                if (string == null || !new File(string).exists()) {
                    string = null;
                }
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(string, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ActivityResultContracts.GetContent getContent = new ActivityResultContracts.GetContent();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1303961611, "CC(remember):RideHistoryScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(sharedPreferences);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.example.ui.screens.RideHistoryScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        return RideHistoryScreenKt.RideHistoryScreen$lambda$9$lambda$8(context, sharedPreferences, mutableState2, (Uri) obj3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(getContent, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -954367824, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue4 = compositionScopedCoroutineScopeCanceller;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            State stateCollectAsState = SnapshotStateKt.collectAsState(repository.getAllRides(), CollectionsKt.emptyList(), null, composerStartRestartGroup, 48, 2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1303942417, "CC(remember):RideHistoryScreen.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("全部", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1303939614, "CC(remember):RideHistoryScreen.kt#9igjgp");
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            final MutableState mutableState4 = (MutableState) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1303937158, "CC(remember):RideHistoryScreen.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(context);
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = PreferenceManager.getDefaultSharedPreferences(context);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            SharedPreferences sharedPreferences2 = (SharedPreferences) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1303933853, "CC(remember):RideHistoryScreen.kt#9igjgp");
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = sharedPreferences2.getString("user_selected_map_mode", "DARK_SLATE");
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            String str = (String) objRememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1303930193, "CC(remember):RideHistoryScreen.kt#9igjgp");
            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                try {
                    mapModeValueOf = MapMode.valueOf(str != null ? str : "DARK_SLATE");
                } catch (Exception unused) {
                    mapModeValueOf = MapMode.DARK_SLATE;
                }
                objRememberedValue9 = mapModeValueOf;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            MapMode mapMode = (MapMode) objRememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i6 = WhenMappings.$EnumSwitchMapping$0[mapMode.ordinal()];
            if (i6 == 1) {
                jM3857getWhite0d7_KjU = Color.INSTANCE.m3857getWhite0d7_KjU();
            } else if (i6 == 2) {
                jM3857getWhite0d7_KjU = ColorKt.Color(4279901991L);
            } else {
                jM3857getWhite0d7_KjU = com.example.ui.theme.ColorKt.getAlpineBackground();
            }
            long j = jM3857getWhite0d7_KjU;
            boolean z = mapMode == MapMode.LIGHT_STANDARD;
            final long jColor = z ? ColorKt.Color(4279179050L) : com.example.ui.theme.ColorKt.getAlpinePrimary();
            final long jColor2 = z ? ColorKt.Color(4279179050L) : com.example.ui.theme.ColorKt.getAlpineOnSurface();
            final long jColor3 = z ? ColorKt.Color(4281549141L) : com.example.ui.theme.ColorKt.getAlpineOnSurfaceVariant();
            List<RideRecordEntity> listRideHistoryScreen$lambda$10 = RideHistoryScreen$lambda$10(stateCollectAsState);
            String strRideHistoryScreen$lambda$12 = RideHistoryScreen$lambda$12(mutableState3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1303906486, "CC(remember):RideHistoryScreen.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(listRideHistoryScreen$lambda$10) | composerStartRestartGroup.changed(strRideHistoryScreen$lambda$12);
            ArrayList arrayListRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || arrayListRememberedValue == Composer.INSTANCE.getEmpty()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                String strRideHistoryScreen$lambda$13 = RideHistoryScreen$lambda$12(mutableState3);
                if (!Intrinsics.areEqual(strRideHistoryScreen$lambda$13, "本月")) {
                    if (!Intrinsics.areEqual(strRideHistoryScreen$lambda$13, "今年")) {
                        arrayListRememberedValue = RideHistoryScreen$lambda$10(stateCollectAsState);
                    } else {
                        List<RideRecordEntity> listRideHistoryScreen$lambda$11 = RideHistoryScreen$lambda$10(stateCollectAsState);
                        ArrayList arrayList = new ArrayList();
                        for (Object obj3 : listRideHistoryScreen$lambda$11) {
                            if (jCurrentTimeMillis - ((RideRecordEntity) obj3).getStartTimeMs() <= OpenStreetMapTileProviderConstants.ONE_YEAR) {
                                arrayList.add(obj3);
                            }
                        }
                        arrayListRememberedValue = arrayList;
                    }
                } else {
                    List<RideRecordEntity> listRideHistoryScreen$lambda$12 = RideHistoryScreen$lambda$10(stateCollectAsState);
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj4 : listRideHistoryScreen$lambda$12) {
                        if (jCurrentTimeMillis - ((RideRecordEntity) obj4).getStartTimeMs() <= OpenStreetMapTileProviderConstants.TILE_EXPIRY_TIME_MILLISECONDS) {
                            arrayList2.add(obj4);
                        }
                    }
                    arrayListRememberedValue = arrayList2;
                }
                composerStartRestartGroup.updateRememberedValue(arrayListRememberedValue);
            }
            final List list = (List) arrayListRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM225backgroundbw27NRU$default = BackgroundKt.m225backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), j, null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM225backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3313constructorimpl = Updater.m3313constructorimpl(composerStartRestartGroup);
            Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -785386826, "C141@5413L5818:RideHistoryScreen.kt#2thlc2");
            Modifier modifierNavigationBarsPadding = WindowInsetsPadding_androidKt.navigationBarsPadding(WindowInsetsPadding_androidKt.statusBarsPadding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null)));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierNavigationBarsPadding);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3313constructorimpl2 = Updater.m3313constructorimpl(composerStartRestartGroup);
            Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2107037737, "C148@5613L2529,212@8468L2753,206@8190L3031:RideHistoryScreen.kt#2thlc2");
            Modifier modifierM671paddingVpY3zN4 = PaddingKt.m671paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6261constructorimpl(20.0f), Dp.m6261constructorimpl(12.0f));
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM671paddingVpY3zN4);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3313constructorimpl3 = Updater.m3313constructorimpl(composerStartRestartGroup);
            Updater.m3320setimpl(composerM3313constructorimpl3, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3320setimpl(composerM3313constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2034442708, "C155@5919L802,181@7160L41,175@6739L1389:RideHistoryScreen.kt#2thlc2");
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3313constructorimpl4 = Updater.m3313constructorimpl(composerStartRestartGroup);
            Updater.m3320setimpl(composerM3313constructorimpl4, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                composerM3313constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composerM3313constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3320setimpl(composerM3313constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1385485517, "C159@6152L255,156@5993L414,166@6428L39,167@6488L215:RideHistoryScreen.kt#2thlc2");
            IconButtonKt.IconButton(onNavigateHome, TestTagKt.testTag(Modifier.INSTANCE, "history_back_button"), false, null, null, ComposableLambdaKt.rememberComposableLambda(-1904950899, true, new Function2() { // from class: com.example.ui.screens.RideHistoryScreenKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj5, Object obj6) {
                    return RideHistoryScreenKt.RideHistoryScreen$lambda$50$lambda$42$lambda$28$lambda$24$lambda$23(jColor, (Composer) obj5, ((Integer) obj6).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i5 >> 3) & 14) | 196656, 28);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(8.0f)), composerStartRestartGroup, 6);
            TextKt.m2354Text4IGK_g("H RIDE", (Modifier) null, jColor, TextUnitKt.getSp(24), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 199686, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierClip = ClipKt.clip(SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(36.0f)), RoundedCornerShapeKt.getCircleShape());
            if (z) {
                alpinePrimary = Color.INSTANCE.m3846getBlack0d7_KjU();
                i2 = 14;
                obj = null;
                f = 0.08f;
            } else {
                alpinePrimary = com.example.ui.theme.ColorKt.getAlpinePrimary();
                i2 = 14;
                obj = null;
                f = 0.15f;
            }
            Modifier modifierM236borderxT4_qwU = BorderKt.m236borderxT4_qwU(BackgroundKt.m225backgroundbw27NRU$default(modifierClip, Color.m3819copywmQWz5c$default(alpinePrimary, f, 0.0f, 0.0f, 0.0f, i2, obj), null, 2, null), Dp.m6261constructorimpl(1.5f), z ? Color.m3819copywmQWz5c$default(Color.INSTANCE.m3846getBlack0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null) : Color.m3819copywmQWz5c$default(com.example.ui.theme.ColorKt.getAlpinePrimary(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1042713929, "CC(remember):RideHistoryScreen.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult);
            Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue10 = new Function0() { // from class: com.example.ui.screens.RideHistoryScreenKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RideHistoryScreenKt.RideHistoryScreen$lambda$50$lambda$42$lambda$28$lambda$26$lambda$25(managedActivityResultLauncherRememberLauncherForActivityResult);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierTestTag = TestTagKt.testTag(ClickableKt.m258clickableXHw0xAI$default(modifierM236borderxT4_qwU, false, null, null, (Function0) objRememberedValue10, 7, null), "account_button");
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor5);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3313constructorimpl5 = Updater.m3313constructorimpl(composerStartRestartGroup);
            Updater.m3320setimpl(composerM3313constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl5.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                composerM3313constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                composerM3313constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            Updater.m3320setimpl(composerM3313constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -233317021, "C:RideHistoryScreen.kt#2thlc2");
            if (RideHistoryScreen$lambda$5(mutableState2) != null) {
                composerStartRestartGroup.startReplaceGroup(-233304126);
                ComposerKt.sourceInformation(composerStartRestartGroup, "186@7400L360");
                String strRideHistoryScreen$lambda$5 = RideHistoryScreen$lambda$5(mutableState2);
                Intrinsics.checkNotNull(strRideHistoryScreen$lambda$5);
                i3 = 1;
                obj2 = null;
                f2 = 0.0f;
                SingletonAsyncImageKt.m6606AsyncImagegl8XCv8(new File(strRideHistoryScreen$lambda$5), "个人中心头像", ClipKt.clip(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.getCircleShape()), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, false, null, composerStartRestartGroup, 1572912, 0, 4024);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            } else {
                i3 = 1;
                obj2 = null;
                f2 = 0.0f;
                composerStartRestartGroup.startReplaceGroup(-232896104);
                ComposerKt.sourceInformation(composerStartRestartGroup, "195@7814L274");
                IconKt.m1811Iconww6aTOc(AccountCircleKt.getAccountCircle(Icons.INSTANCE.getDefault()), "个人中心", SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(30.0f)), jColor, composerStartRestartGroup, 432, 0);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifierM672paddingVpY3zN4$default = PaddingKt.m672paddingVpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, f2, i3, obj2), Dp.m6261constructorimpl(20.0f), f2, 2, obj2);
            PaddingValues paddingValuesM667PaddingValuesa9UjIt4$default = PaddingKt.m667PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6261constructorimpl(110.0f), 7, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_4 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(16.0f));
            ComposerKt.sourceInformationMarkerStart(composer2, -1178868525, "CC(remember):RideHistoryScreen.kt#9igjgp");
            boolean zChanged3 = composer2.changed(jColor3) | composer2.changed(jColor2) | composer2.changedInstance(list);
            Object objRememberedValue11 = composer2.rememberedValue();
            if (zChanged3 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                final boolean z2 = z;
                objRememberedValue11 = new Function1() { // from class: com.example.ui.screens.RideHistoryScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj5) {
                        return RideHistoryScreenKt.RideHistoryScreen$lambda$50$lambda$42$lambda$41$lambda$40(list, jColor2, jColor3, z2, mutableState3, mutableState4, (LazyListScope) obj5);
                    }
                };
                mutableState = mutableState4;
                composer2.updateRememberedValue(objRememberedValue11);
            } else {
                mutableState = mutableState4;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Composer composer3 = composer2;
            LazyDslKt.LazyColumn(modifierM672paddingVpY3zN4$default, null, paddingValuesM667PaddingValuesa9UjIt4$default, false, horizontalOrVerticalM550spacedBy0680j_4, null, null, false, (Function1) objRememberedValue11, composer3, 24966, 234);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            final RideRecordEntity rideRecordEntityRideHistoryScreen$lambda$15 = RideHistoryScreen$lambda$15(mutableState);
            if (rideRecordEntityRideHistoryScreen$lambda$15 == null) {
                composer3.startReplaceGroup(-779739992);
                composer3.endReplaceGroup();
                composerStartRestartGroup = composer3;
            } else {
                composer3.startReplaceGroup(-779739991);
                ComposerKt.sourceInformation(composer3, "*287@11389L32,288@11455L216,294@11700L190,285@11315L589");
                ComposerKt.sourceInformationMarkerStart(composer3, -1114164245, "CC(remember):RideHistoryScreen.kt#9igjgp");
                Object objRememberedValue12 = composer3.rememberedValue();
                if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue12 = new Function0() { // from class: com.example.ui.screens.RideHistoryScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return RideHistoryScreenKt.RideHistoryScreen$lambda$50$lambda$49$lambda$44$lambda$43(mutableState);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue12);
                }
                Function0 function0 = (Function0) objRememberedValue12;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1114161949, "CC(remember):RideHistoryScreen.kt#9igjgp");
                boolean zChangedInstance3 = composer3.changedInstance(coroutineScope) | composer3.changedInstance(repository) | composer3.changed(rideRecordEntityRideHistoryScreen$lambda$15);
                Object objRememberedValue13 = composer3.rememberedValue();
                if (zChangedInstance3 || objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue13 = new Function1() { // from class: com.example.ui.screens.RideHistoryScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj5) {
                            return RideHistoryScreenKt.RideHistoryScreen$lambda$50$lambda$49$lambda$46$lambda$45(coroutineScope, repository, rideRecordEntityRideHistoryScreen$lambda$15, mutableState, (String) obj5);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue13);
                }
                Function1 function1 = (Function1) objRememberedValue13;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1114154135, "CC(remember):RideHistoryScreen.kt#9igjgp");
                boolean zChangedInstance4 = composer3.changedInstance(coroutineScope) | composer3.changedInstance(repository) | composer3.changed(rideRecordEntityRideHistoryScreen$lambda$15);
                Object objRememberedValue14 = composer3.rememberedValue();
                if (zChangedInstance4 || objRememberedValue14 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue14 = new Function0() { // from class: com.example.ui.screens.RideHistoryScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return RideHistoryScreenKt.RideHistoryScreen$lambda$50$lambda$49$lambda$48$lambda$47(coroutineScope, repository, rideRecordEntityRideHistoryScreen$lambda$15, mutableState);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue14);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composerStartRestartGroup = composer3;
                RideDetailModalKt.RideDetailModal(rideRecordEntityRideHistoryScreen$lambda$15, function0, function1, (Function0) objRememberedValue14, composerStartRestartGroup, 48);
                Unit unit = Unit.INSTANCE;
                composerStartRestartGroup.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.screens.RideHistoryScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj5, Object obj6) {
                    return RideHistoryScreenKt.RideHistoryScreen$lambda$51(repository, onNavigateHome, i, (Composer) obj5, ((Integer) obj6).intValue());
                }
            });
        }
    }

    private static final String RideHistoryScreen$lambda$5(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    static final Unit RideHistoryScreen$lambda$9$lambda$8(Context context, SharedPreferences sharedPreferences, MutableState mutableState, Uri uri) {
        if (uri != null) {
            String strSaveAvatarToInternalStorage = saveAvatarToInternalStorage(context, uri);
            if (strSaveAvatarToInternalStorage != null) {
                sharedPreferences.edit().putString("avatar_path", strSaveAvatarToInternalStorage).apply();
                mutableState.setValue(strSaveAvatarToInternalStorage);
                Toast.makeText(context, "头像已更新", 0).show();
            } else {
                Toast.makeText(context, "更新头像失败", 0).show();
            }
        }
        return Unit.INSTANCE;
    }

    private static final String RideHistoryScreen$lambda$12(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final RideRecordEntity RideHistoryScreen$lambda$15(MutableState<RideRecordEntity> mutableState) {
        return mutableState.getValue();
    }

    static final Unit RideHistoryScreen$lambda$50$lambda$42$lambda$28$lambda$24$lambda$23(long j, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C160@6178L207:RideHistoryScreen.kt#2thlc2");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1904950899, i, -1, "com.example.ui.screens.RideHistoryScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RideHistoryScreen.kt:160)");
            }
            IconKt.m1811Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.INSTANCE.getDefault()), "返回", (Modifier) null, j, composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit RideHistoryScreen$lambda$50$lambda$42$lambda$28$lambda$26$lambda$25(ManagedActivityResultLauncher managedActivityResultLauncher) {
        managedActivityResultLauncher.launch("image/*");
        return Unit.INSTANCE;
    }

    static final Unit RideHistoryScreen$lambda$50$lambda$42$lambda$41$lambda$40(final List list, final long j, final long j2, final boolean z, final MutableState mutableState, final MutableState mutableState2, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1779863938, true, new Function3() { // from class: com.example.ui.screens.RideHistoryScreenKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return RideHistoryScreenKt.RideHistoryScreen$lambda$50$lambda$42$lambda$41$lambda$40$lambda$30(j, j2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-560652889, true, new Function3() { // from class: com.example.ui.screens.RideHistoryScreenKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return RideHistoryScreenKt.RideHistoryScreen$lambda$50$lambda$42$lambda$41$lambda$40$lambda$34(z, mutableState, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        if (list.isEmpty()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(129051139, true, new Function3() { // from class: com.example.ui.screens.RideHistoryScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RideHistoryScreenKt.RideHistoryScreen$lambda$50$lambda$42$lambda$41$lambda$40$lambda$36(j2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        } else {
            final Function2 function2 = new Function2() { // from class: com.example.ui.screens.RideHistoryScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RideHistoryScreenKt.RideHistoryScreen$lambda$50$lambda$42$lambda$41$lambda$40$lambda$37(((Integer) obj).intValue(), (RideRecordEntity) obj2);
                }
            };
            LazyColumn.items(list.size(), new Function1<Integer, Object>() { // from class: com.example.ui.screens.RideHistoryScreenKt$RideHistoryScreen$lambda$50$lambda$42$lambda$41$lambda$40$$inlined$itemsIndexed$default$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int i) {
                    return function2.invoke(Integer.valueOf(i), list.get(i));
                }
            }, new Function1<Integer, Object>() { // from class: com.example.ui.screens.RideHistoryScreenKt$RideHistoryScreen$lambda$50$lambda$42$lambda$41$lambda$40$$inlined$itemsIndexed$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int i) {
                    list.get(i);
                    return null;
                }
            }, ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.example.ui.screens.RideHistoryScreenKt$RideHistoryScreen$lambda$50$lambda$42$lambda$41$lambda$40$$inlined$itemsIndexed$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                    int i3;
                    ComposerKt.sourceInformation(composer, "C188@8866L26:LazyDsl.kt#428nma");
                    if ((i2 & 6) == 0) {
                        i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
                    } else {
                        i3 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        i3 |= composer.changed(i) ? 32 : 16;
                    }
                    if ((i3 & 147) == 146 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1091073711, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:188)");
                    }
                    final RideRecordEntity rideRecordEntity = (RideRecordEntity) list.get(i);
                    composer.startReplaceGroup(-1219115243);
                    ComposerKt.sourceInformation(composer, "C*276@11109L32,273@10965L202:RideHistoryScreen.kt#2thlc2");
                    boolean z2 = z;
                    ComposerKt.sourceInformationMarkerStart(composer, 237772804, "CC(remember):RideHistoryScreen.kt#9igjgp");
                    boolean zChanged = composer.changed(rideRecordEntity);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        final MutableState mutableState3 = mutableState2;
                        objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.example.ui.screens.RideHistoryScreenKt$RideHistoryScreen$1$1$2$1$5$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                mutableState3.setValue(rideRecordEntity);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    RideHistoryScreenKt.RideCardItem(rideRecordEntity, z2, (Function0) objRememberedValue, composer, 48, 0);
                    composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
        }
        return Unit.INSTANCE;
    }

    static final Unit RideHistoryScreen$lambda$50$lambda$42$lambda$41$lambda$40$lambda$30(long j, long j2, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C215@8553L788:RideHistoryScreen.kt#2thlc2");
        if ((i & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1779863938, i, -1, "com.example.ui.screens.RideHistoryScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RideHistoryScreen.kt:215)");
            }
            Modifier modifierM674paddingqDBjuR0$default = PaddingKt.m674paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6261constructorimpl(12.0f), 0.0f, Dp.m6261constructorimpl(8.0f), 5, null);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM674paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM3313constructorimpl = Updater.m3313constructorimpl(composer);
            Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 735403246, "C220@8762L284,227@9071L40,228@9136L183:RideHistoryScreen.kt#2thlc2");
            TextKt.m2354Text4IGK_g("骑行历史", (Modifier) null, j, TextUnitKt.getSp(44), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, TextUnitKt.getSp(-0.5d), (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 199686, 0, 130898);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(4.0f)), composer, 6);
            TextKt.m2354Text4IGK_g("回顾您的往期骑行记录与表现", (Modifier) null, j2, TextUnitKt.getSp(15), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 3078, 0, 131058);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit RideHistoryScreen$lambda$50$lambda$42$lambda$41$lambda$40$lambda$34(boolean z, final MutableState mutableState, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C238@9461L642:RideHistoryScreen.kt#2thlc2");
        if ((i & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-560652889, i, -1, "com.example.ui.screens.RideHistoryScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RideHistoryScreen.kt:238)");
            }
            Modifier modifierM672paddingVpY3zN4$default = PaddingKt.m672paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6261constructorimpl(4.0f), 1, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM672paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM3313constructorimpl = Updater.m3313constructorimpl(composer);
            Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1755291606, "C247@9907L97,244@9717L364:RideHistoryScreen.kt#2thlc2");
            List listListOf = CollectionsKt.listOf((Object[]) new String[]{"全部", "本月", "今年"});
            String strRideHistoryScreen$lambda$12 = RideHistoryScreen$lambda$12(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, -774655870, "CC(remember):RideHistoryScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.ui.screens.RideHistoryScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RideHistoryScreenKt.RideHistoryScreen$lambda$50$lambda$42$lambda$41$lambda$40$lambda$34$lambda$33$lambda$32$lambda$31(mutableState, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            GlassComponentsKt.LiquidFilterDock(listListOf, strRideHistoryScreen$lambda$12, (Function1) objRememberedValue, z, null, composer, 3462, 16);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit RideHistoryScreen$lambda$50$lambda$42$lambda$41$lambda$40$lambda$34$lambda$33$lambda$32$lambda$31(MutableState mutableState, String filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        mutableState.setValue(filter);
        return Unit.INSTANCE;
    }

    static final Unit RideHistoryScreen$lambda$50$lambda$42$lambda$41$lambda$40$lambda$36(long j, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C258@10257L500:RideHistoryScreen.kt#2thlc2");
        if ((i & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(129051139, i, -1, "com.example.ui.screens.RideHistoryScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RideHistoryScreen.kt:258)");
            }
            Modifier modifierM701height3ABfNKs = SizeKt.m701height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6261constructorimpl(200.0f));
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM701height3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM3313constructorimpl = Updater.m3313constructorimpl(composer);
            Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 582646810, "C264@10527L204:RideHistoryScreen.kt#2thlc2");
            TextKt.m2354Text4IGK_g("暂无骑行记录，开始你的第一次骑行吧！", (Modifier) null, j, TextUnitKt.getSp(15), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 3078, 0, 131058);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Object RideHistoryScreen$lambda$50$lambda$42$lambda$41$lambda$40$lambda$37(int i, RideRecordEntity ride) {
        Intrinsics.checkNotNullParameter(ride, "ride");
        return "ride_" + ride.getId() + "_" + ride.getStartTimeMs() + "_" + i;
    }

    static final Unit RideHistoryScreen$lambda$50$lambda$49$lambda$44$lambda$43(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    static final Unit RideHistoryScreen$lambda$50$lambda$49$lambda$46$lambda$45(CoroutineScope coroutineScope, RideRepository rideRepository, RideRecordEntity rideRecordEntity, MutableState mutableState, String newTitle) {
        Intrinsics.checkNotNullParameter(newTitle, "newTitle");
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new RideHistoryScreenKt$RideHistoryScreen$1$2$2$1$1(rideRepository, rideRecordEntity, newTitle, mutableState, null), 3, null);
        return Unit.INSTANCE;
    }

    static final Unit RideHistoryScreen$lambda$50$lambda$49$lambda$48$lambda$47(CoroutineScope coroutineScope, RideRepository rideRepository, RideRecordEntity rideRecordEntity, MutableState mutableState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new RideHistoryScreenKt$RideHistoryScreen$1$2$3$1$1(rideRepository, rideRecordEntity, mutableState, null), 3, null);
        return Unit.INSTANCE;
    }

    private static final void FilterChipItem(final String str, final boolean z, final String str2, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1104457013);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilterChipItem)P(1!1,3)312@12061L751:RideHistoryScreen.kt#2thlc2");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i2 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1104457013, i2, -1, "com.example.ui.screens.FilterChipItem (RideHistoryScreen.kt:311)");
            }
            Modifier modifierM671paddingVpY3zN4 = PaddingKt.m671paddingVpY3zN4(ClickableKt.m258clickableXHw0xAI$default(GlassComponentsKt.m6638glassPanelIBj4UiM$default(TestTagKt.testTag(Modifier.INSTANCE, str2), RoundedCornerShapeKt.getCircleShape(), Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), z ? 0.2f : 0.04f, 0.0f, 0.0f, 0.0f, 14, null), Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), z ? 0.35f : 0.1f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0.0f, 24, null), false, null, null, function0, 7, null), Dp.m6261constructorimpl(22.0f), Dp.m6261constructorimpl(8.0f));
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM671paddingVpY3zN4);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3313constructorimpl = Updater.m3313constructorimpl(composerStartRestartGroup);
            Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066120878, "C324@12602L204:RideHistoryScreen.kt#2thlc2");
            composer2 = composerStartRestartGroup;
            TextKt.m2354Text4IGK_g(str, (Modifier) null, z ? com.example.ui.theme.ColorKt.getAlpinePrimaryContainer() : com.example.ui.theme.ColorKt.getAlpineOnSurfaceVariant(), TextUnitKt.getSp(13), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, (i2 & 14) | 199680, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.screens.RideHistoryScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RideHistoryScreenKt.FilterChipItem$lambda$53(str, z, str2, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:103:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0045  */
    /* JADX WARN: Code duplicated, block: B:25:0x004d  */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:36:0x0069  */
    /* JADX WARN: Code duplicated, block: B:38:0x006c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0073  */
    /* JADX WARN: Code duplicated, block: B:44:0x008f  */
    /* JADX WARN: Code duplicated, block: B:46:0x0097  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:57:0x0162  */
    /* JADX WARN: Code duplicated, block: B:59:0x0188  */
    /* JADX WARN: Code duplicated, block: B:61:0x018c  */
    /* JADX WARN: Code duplicated, block: B:62:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:65:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:66:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:69:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:70:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:73:0x01de  */
    /* JADX WARN: Code duplicated, block: B:74:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:77:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:78:0x0209  */
    /* JADX WARN: Code duplicated, block: B:81:0x0226  */
    /* JADX WARN: Code duplicated, block: B:82:0x022b  */
    /* JADX WARN: Code duplicated, block: B:85:0x0233  */
    /* JADX WARN: Code duplicated, block: B:86:0x023f  */
    /* JADX WARN: Code duplicated, block: B:89:0x0256  */
    /* JADX WARN: Code duplicated, block: B:90:0x025b  */
    /* JADX WARN: Code duplicated, block: B:92:0x0261  */
    /* JADX WARN: Code duplicated, block: B:93:0x0266  */
    /* JADX WARN: Code duplicated, block: B:96:0x026e  */
    /* JADX WARN: Code duplicated, block: B:97:0x0274  */
    /* JADX WARN: Instruction removed from duplicated block: B:36:0x0069, please report this as an issue */
    public static final void RideCardItem(final RideRecordEntity rideRecordEntity, boolean z, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        RideRecordEntity rideRecordEntity2;
        int i3;
        boolean z2;
        Function0<Unit> function1;
        boolean zChanged;
        Object objRememberedValue;
        boolean z3;
        Object objRememberedValue2;
        long j;
        boolean z4;
        long j2;
        long j3;
        String str;
        long alpineOnSurface;
        long alpineOnSurfaceVariant;
        long alpineSurfaceContainerHighest;
        Color.Companion companion;
        long jM3857getWhite0d7_KjU;
        int i4;
        Object obj;
        float f;
        final long alpinePrimaryContainer;
        Color.Companion companion2;
        long jM3857getWhite0d7_KjU2;
        int i5;
        Object obj2;
        float f2;
        long alpinePrimaryContainer2;
        long alpineOnSurface2;
        long j4;
        final boolean z5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(1294905509);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RideCardItem)P(2)339@12966L129,343@13120L53,377@14702L3721,373@14567L3856:RideHistoryScreen.kt#2thlc2");
        if ((i & 6) == 0) {
            rideRecordEntity2 = rideRecordEntity;
            i3 = (composerStartRestartGroup.changed(rideRecordEntity2) ? 4 : 2) | i;
        } else {
            rideRecordEntity2 = rideRecordEntity;
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 == 0) {
            if ((i & 48) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                function1 = function0;
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i6 = 256;
                } else {
                    i6 = 128;
                }
                i3 |= i6;
            } else {
                function1 = function0;
            }
            if ((i3 & 147) != 146 && composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i7 != 0) {
                    z2 = false;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1294905509, i3, -1, "com.example.ui.screens.RideCardItem (RideHistoryScreen.kt:338)");
                }
                long startTimeMs = rideRecordEntity2.getStartTimeMs();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1136316762, "CC(remember):RideHistoryScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(startTimeMs);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new SimpleDateFormat("yyyy年MM月dd日 • HH:mm a", Locale.CHINA).format(new Date(rideRecordEntity2.getStartTimeMs()));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final String str2 = (String) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1136311910, "CC(remember):RideHistoryScreen.kt#9igjgp");
                z3 = (i3 & 14) == 4;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = rideRecordEntity2.getCleanedStats();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                CleanedRideStats cleanedRideStats = (CleanedRideStats) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                final String str3 = String.format(Locale.getDefault(), "%.1f km", Arrays.copyOf(new Object[]{Double.valueOf(cleanedRideStats.getDistanceMeters() / 1000.0d)}, 1));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                final String str4 = String.format(Locale.getDefault(), "%.1f km/h", Arrays.copyOf(new Object[]{Double.valueOf(cleanedRideStats.getAvgSpeedKmH())}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                final String str5 = String.format(Locale.getDefault(), "%.2fG", Arrays.copyOf(new Object[]{Float.valueOf(rideRecordEntity2.getMaxGForce())}, 1));
                Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                long durationSeconds = rideRecordEntity2.getDurationSeconds();
                j = durationSeconds / 3600;
                z4 = z2;
                j2 = (durationSeconds % 3600) / 60;
                j3 = durationSeconds % 60;
                if (j > 0) {
                    str = j + "小时" + j2 + "分" + j3 + "秒";
                } else if (j2 > 0) {
                    str = j2 + "分" + j3 + "秒";
                } else {
                    str = j3 + "秒";
                }
                final String str6 = str;
                if (z4) {
                    alpineOnSurface = ColorKt.Color(4279179050L);
                } else {
                    alpineOnSurface = com.example.ui.theme.ColorKt.getAlpineOnSurface();
                }
                final long j5 = alpineOnSurface;
                if (z4) {
                    alpineOnSurfaceVariant = ColorKt.Color(4282865001L);
                } else {
                    alpineOnSurfaceVariant = com.example.ui.theme.ColorKt.getAlpineOnSurfaceVariant();
                }
                final long j6 = alpineOnSurfaceVariant;
                if (z4) {
                    alpineSurfaceContainerHighest = Color.m3819copywmQWz5c$default(Color.INSTANCE.m3846getBlack0d7_KjU(), 0.06f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    alpineSurfaceContainerHighest = com.example.ui.theme.ColorKt.getAlpineSurfaceContainerHighest();
                }
                final long j7 = alpineSurfaceContainerHighest;
                companion = Color.INSTANCE;
                if (z4) {
                    jM3857getWhite0d7_KjU = companion.m3846getBlack0d7_KjU();
                    i4 = 14;
                    obj = null;
                    f = 0.12f;
                } else {
                    jM3857getWhite0d7_KjU = companion.m3857getWhite0d7_KjU();
                    i4 = 14;
                    obj = null;
                    f = 0.08f;
                }
                final long jM3819copywmQWz5c$default = Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU, f, 0.0f, 0.0f, 0.0f, i4, obj);
                if (z4) {
                    alpinePrimaryContainer = ColorKt.Color(4278355143L);
                } else {
                    alpinePrimaryContainer = com.example.ui.theme.ColorKt.getAlpinePrimaryContainer();
                }
                companion2 = Color.INSTANCE;
                if (z4) {
                    jM3857getWhite0d7_KjU2 = companion2.m3846getBlack0d7_KjU();
                    i5 = 14;
                    obj2 = null;
                    f2 = 0.1f;
                } else {
                    jM3857getWhite0d7_KjU2 = companion2.m3857getWhite0d7_KjU();
                    i5 = 14;
                    obj2 = null;
                    f2 = 0.08f;
                }
                final long jM3819copywmQWz5c$default2 = Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU2, f2, 0.0f, 0.0f, 0.0f, i5, obj2);
                if (z4) {
                    alpinePrimaryContainer2 = ColorKt.Color(4278355143L);
                } else {
                    alpinePrimaryContainer2 = com.example.ui.theme.ColorKt.getAlpinePrimaryContainer();
                }
                if (z4) {
                    alpineOnSurface2 = ColorKt.Color(4279179050L);
                } else {
                    alpineOnSurface2 = com.example.ui.theme.ColorKt.getAlpineOnSurface();
                }
                final long j8 = alpineOnSurface2;
                if (z4) {
                    j4 = 4292441862L;
                } else {
                    j4 = 4294956367L;
                }
                final long jColor = ColorKt.Color(j4);
                final long j9 = alpinePrimaryContainer2;
                z2 = z4;
                GlassComponentsKt.GlassCard(TestTagKt.testTag(Modifier.INSTANCE, "ride_card_" + rideRecordEntity2.getId()), z2, function1, ComposableLambdaKt.rememberComposableLambda(-1448301389, true, new Function3() { // from class: com.example.ui.screens.RideHistoryScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj3, Object obj4, Object obj5) {
                        return RideHistoryScreenKt.RideCardItem$lambda$64(jM3819copywmQWz5c$default2, j7, jM3819copywmQWz5c$default, alpinePrimaryContainer, rideRecordEntity, j5, str2, j6, str3, j9, str6, j8, str4, str5, jColor, (ColumnScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 112) | 3072 | (i3 & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            z5 = z2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.screens.RideHistoryScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        return RideHistoryScreenKt.RideCardItem$lambda$65(rideRecordEntity, z5, function0, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        z2 = z;
        if ((i & 384) == 0) {
            function1 = function0;
            if (composerStartRestartGroup.changedInstance(function1)) {
                i6 = 256;
            } else {
                i6 = 128;
            }
            i3 |= i6;
        } else {
            function1 = function0;
        }
        if ((i3 & 147) != 146) {
            if (i7 != 0) {
                z2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1294905509, i3, -1, "com.example.ui.screens.RideCardItem (RideHistoryScreen.kt:338)");
            }
            long startTimeMs2 = rideRecordEntity2.getStartTimeMs();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1136316762, "CC(remember):RideHistoryScreen.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(startTimeMs2);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new SimpleDateFormat("yyyy年MM月dd日 • HH:mm a", Locale.CHINA).format(new Date(rideRecordEntity2.getStartTimeMs()));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new SimpleDateFormat("yyyy年MM月dd日 • HH:mm a", Locale.CHINA).format(new Date(rideRecordEntity2.getStartTimeMs()));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final String str7 = (String) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1136311910, "CC(remember):RideHistoryScreen.kt#9igjgp");
            if ((i3 & 14) == 4) {
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z3) {
                objRememberedValue2 = rideRecordEntity2.getCleanedStats();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = rideRecordEntity2.getCleanedStats();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            CleanedRideStats cleanedRideStats2 = (CleanedRideStats) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
            final String str8 = String.format(Locale.getDefault(), "%.1f km", Arrays.copyOf(new Object[]{Double.valueOf(cleanedRideStats2.getDistanceMeters() / 1000.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
            StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
            final String str9 = String.format(Locale.getDefault(), "%.1f km/h", Arrays.copyOf(new Object[]{Double.valueOf(cleanedRideStats2.getAvgSpeedKmH())}, 1));
            Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
            StringCompanionObject stringCompanionObject6 = StringCompanionObject.INSTANCE;
            final String str10 = String.format(Locale.getDefault(), "%.2fG", Arrays.copyOf(new Object[]{Float.valueOf(rideRecordEntity2.getMaxGForce())}, 1));
            Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
            long durationSeconds2 = rideRecordEntity2.getDurationSeconds();
            j = durationSeconds2 / 3600;
            z4 = z2;
            j2 = (durationSeconds2 % 3600) / 60;
            j3 = durationSeconds2 % 60;
            if (j > 0) {
                str = j + "小时" + j2 + "分" + j3 + "秒";
            } else if (j2 > 0) {
                str = j2 + "分" + j3 + "秒";
            } else {
                str = j3 + "秒";
            }
            final String str11 = str;
            if (z4) {
                alpineOnSurface = ColorKt.Color(4279179050L);
            } else {
                alpineOnSurface = com.example.ui.theme.ColorKt.getAlpineOnSurface();
            }
            final long j10 = alpineOnSurface;
            if (z4) {
                alpineOnSurfaceVariant = ColorKt.Color(4282865001L);
            } else {
                alpineOnSurfaceVariant = com.example.ui.theme.ColorKt.getAlpineOnSurfaceVariant();
            }
            final long j11 = alpineOnSurfaceVariant;
            if (z4) {
                alpineSurfaceContainerHighest = Color.m3819copywmQWz5c$default(Color.INSTANCE.m3846getBlack0d7_KjU(), 0.06f, 0.0f, 0.0f, 0.0f, 14, null);
            } else {
                alpineSurfaceContainerHighest = com.example.ui.theme.ColorKt.getAlpineSurfaceContainerHighest();
            }
            final long j12 = alpineSurfaceContainerHighest;
            companion = Color.INSTANCE;
            if (z4) {
                jM3857getWhite0d7_KjU = companion.m3846getBlack0d7_KjU();
                i4 = 14;
                obj = null;
                f = 0.12f;
            } else {
                jM3857getWhite0d7_KjU = companion.m3857getWhite0d7_KjU();
                i4 = 14;
                obj = null;
                f = 0.08f;
            }
            final long jM3819copywmQWz5c$default3 = Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU, f, 0.0f, 0.0f, 0.0f, i4, obj);
            if (z4) {
                alpinePrimaryContainer = ColorKt.Color(4278355143L);
            } else {
                alpinePrimaryContainer = com.example.ui.theme.ColorKt.getAlpinePrimaryContainer();
            }
            companion2 = Color.INSTANCE;
            if (z4) {
                jM3857getWhite0d7_KjU2 = companion2.m3846getBlack0d7_KjU();
                i5 = 14;
                obj2 = null;
                f2 = 0.1f;
            } else {
                jM3857getWhite0d7_KjU2 = companion2.m3857getWhite0d7_KjU();
                i5 = 14;
                obj2 = null;
                f2 = 0.08f;
            }
            final long jM3819copywmQWz5c$default4 = Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU2, f2, 0.0f, 0.0f, 0.0f, i5, obj2);
            if (z4) {
                alpinePrimaryContainer2 = ColorKt.Color(4278355143L);
            } else {
                alpinePrimaryContainer2 = com.example.ui.theme.ColorKt.getAlpinePrimaryContainer();
            }
            if (z4) {
                alpineOnSurface2 = ColorKt.Color(4279179050L);
            } else {
                alpineOnSurface2 = com.example.ui.theme.ColorKt.getAlpineOnSurface();
            }
            final long j13 = alpineOnSurface2;
            if (z4) {
                j4 = 4292441862L;
            } else {
                j4 = 4294956367L;
            }
            final long jColor2 = ColorKt.Color(j4);
            final long j14 = alpinePrimaryContainer2;
            z2 = z4;
            GlassComponentsKt.GlassCard(TestTagKt.testTag(Modifier.INSTANCE, "ride_card_" + rideRecordEntity2.getId()), z2, function1, ComposableLambdaKt.rememberComposableLambda(-1448301389, true, new Function3() { // from class: com.example.ui.screens.RideHistoryScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                    return RideHistoryScreenKt.RideCardItem$lambda$64(jM3819copywmQWz5c$default4, j12, jM3819copywmQWz5c$default3, alpinePrimaryContainer, rideRecordEntity, j10, str7, j11, str8, j14, str11, j13, str9, str10, jColor2, (ColumnScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 112) | 3072 | (i3 & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            if (i7 != 0) {
                z2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1294905509, i3, -1, "com.example.ui.screens.RideCardItem (RideHistoryScreen.kt:338)");
            }
            long startTimeMs3 = rideRecordEntity2.getStartTimeMs();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1136316762, "CC(remember):RideHistoryScreen.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(startTimeMs3);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new SimpleDateFormat("yyyy年MM月dd日 • HH:mm a", Locale.CHINA).format(new Date(rideRecordEntity2.getStartTimeMs()));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new SimpleDateFormat("yyyy年MM月dd日 • HH:mm a", Locale.CHINA).format(new Date(rideRecordEntity2.getStartTimeMs()));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final String str12 = (String) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1136311910, "CC(remember):RideHistoryScreen.kt#9igjgp");
            if ((i3 & 14) == 4) {
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z3) {
                objRememberedValue2 = rideRecordEntity2.getCleanedStats();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = rideRecordEntity2.getCleanedStats();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            CleanedRideStats cleanedRideStats3 = (CleanedRideStats) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            StringCompanionObject stringCompanionObject7 = StringCompanionObject.INSTANCE;
            final String str13 = String.format(Locale.getDefault(), "%.1f km", Arrays.copyOf(new Object[]{Double.valueOf(cleanedRideStats3.getDistanceMeters() / 1000.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(str13, "format(...)");
            StringCompanionObject stringCompanionObject8 = StringCompanionObject.INSTANCE;
            final String str14 = String.format(Locale.getDefault(), "%.1f km/h", Arrays.copyOf(new Object[]{Double.valueOf(cleanedRideStats3.getAvgSpeedKmH())}, 1));
            Intrinsics.checkNotNullExpressionValue(str14, "format(...)");
            StringCompanionObject stringCompanionObject9 = StringCompanionObject.INSTANCE;
            final String str15 = String.format(Locale.getDefault(), "%.2fG", Arrays.copyOf(new Object[]{Float.valueOf(rideRecordEntity2.getMaxGForce())}, 1));
            Intrinsics.checkNotNullExpressionValue(str15, "format(...)");
            long durationSeconds3 = rideRecordEntity2.getDurationSeconds();
            j = durationSeconds3 / 3600;
            z4 = z2;
            j2 = (durationSeconds3 % 3600) / 60;
            j3 = durationSeconds3 % 60;
            if (j > 0) {
                str = j + "小时" + j2 + "分" + j3 + "秒";
            } else if (j2 > 0) {
                str = j2 + "分" + j3 + "秒";
            } else {
                str = j3 + "秒";
            }
            final String str16 = str;
            if (z4) {
                alpineOnSurface = ColorKt.Color(4279179050L);
            } else {
                alpineOnSurface = com.example.ui.theme.ColorKt.getAlpineOnSurface();
            }
            final long j15 = alpineOnSurface;
            if (z4) {
                alpineOnSurfaceVariant = ColorKt.Color(4282865001L);
            } else {
                alpineOnSurfaceVariant = com.example.ui.theme.ColorKt.getAlpineOnSurfaceVariant();
            }
            final long j16 = alpineOnSurfaceVariant;
            if (z4) {
                alpineSurfaceContainerHighest = Color.m3819copywmQWz5c$default(Color.INSTANCE.m3846getBlack0d7_KjU(), 0.06f, 0.0f, 0.0f, 0.0f, 14, null);
            } else {
                alpineSurfaceContainerHighest = com.example.ui.theme.ColorKt.getAlpineSurfaceContainerHighest();
            }
            final long j17 = alpineSurfaceContainerHighest;
            companion = Color.INSTANCE;
            if (z4) {
                jM3857getWhite0d7_KjU = companion.m3846getBlack0d7_KjU();
                i4 = 14;
                obj = null;
                f = 0.12f;
            } else {
                jM3857getWhite0d7_KjU = companion.m3857getWhite0d7_KjU();
                i4 = 14;
                obj = null;
                f = 0.08f;
            }
            final long jM3819copywmQWz5c$default5 = Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU, f, 0.0f, 0.0f, 0.0f, i4, obj);
            if (z4) {
                alpinePrimaryContainer = ColorKt.Color(4278355143L);
            } else {
                alpinePrimaryContainer = com.example.ui.theme.ColorKt.getAlpinePrimaryContainer();
            }
            companion2 = Color.INSTANCE;
            if (z4) {
                jM3857getWhite0d7_KjU2 = companion2.m3846getBlack0d7_KjU();
                i5 = 14;
                obj2 = null;
                f2 = 0.1f;
            } else {
                jM3857getWhite0d7_KjU2 = companion2.m3857getWhite0d7_KjU();
                i5 = 14;
                obj2 = null;
                f2 = 0.08f;
            }
            final long jM3819copywmQWz5c$default6 = Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU2, f2, 0.0f, 0.0f, 0.0f, i5, obj2);
            if (z4) {
                alpinePrimaryContainer2 = ColorKt.Color(4278355143L);
            } else {
                alpinePrimaryContainer2 = com.example.ui.theme.ColorKt.getAlpinePrimaryContainer();
            }
            if (z4) {
                alpineOnSurface2 = ColorKt.Color(4279179050L);
            } else {
                alpineOnSurface2 = com.example.ui.theme.ColorKt.getAlpineOnSurface();
            }
            final long j18 = alpineOnSurface2;
            if (z4) {
                j4 = 4292441862L;
            } else {
                j4 = 4294956367L;
            }
            final long jColor3 = ColorKt.Color(j4);
            final long j19 = alpinePrimaryContainer2;
            z2 = z4;
            GlassComponentsKt.GlassCard(TestTagKt.testTag(Modifier.INSTANCE, "ride_card_" + rideRecordEntity2.getId()), z2, function1, ComposableLambdaKt.rememberComposableLambda(-1448301389, true, new Function3() { // from class: com.example.ui.screens.RideHistoryScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                    return RideHistoryScreenKt.RideCardItem$lambda$64(jM3819copywmQWz5c$default6, j17, jM3819copywmQWz5c$default5, alpinePrimaryContainer, rideRecordEntity, j15, str12, j16, str13, j19, str16, j18, str14, str15, jColor3, (ColumnScope) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 112) | 3072 | (i3 & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        z5 = z2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.screens.RideHistoryScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return RideHistoryScreenKt.RideCardItem$lambda$65(rideRecordEntity, z5, function0, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    static final Unit RideCardItem$lambda$64(long j, long j2, long j3, long j4, RideRecordEntity rideRecordEntity, long j5, String str, long j6, String str2, long j7, String str3, long j8, String str4, String str5, long j9, ColumnScope GlassCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(GlassCard, "$this$GlassCard");
        ComposerKt.sourceInformation(composer, "C379@14738L1295,417@16043L41,418@16093L39,419@16141L41,422@16255L2162:RideHistoryScreen.kt#2thlc2");
        if ((i & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1448301389, i, -1, "com.example.ui.screens.RideCardItem.<anonymous> (RideHistoryScreen.kt:379)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_4 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(16.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_4, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM3313constructorimpl = Updater.m3313constructorimpl(composer);
            Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 305840693, "C385@14968L563,401@15545L478:RideHistoryScreen.kt#2thlc2");
            Modifier modifierM236borderxT4_qwU = BorderKt.m236borderxT4_qwU(BackgroundKt.m225backgroundbw27NRU$default(ClipKt.clip(SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(56.0f)), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6261constructorimpl(16.0f))), j2, null, 2, null), Dp.m6261constructorimpl(1.0f), j3, RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6261constructorimpl(16.0f)));
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM236borderxT4_qwU);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM3313constructorimpl2 = Updater.m3313constructorimpl(composer);
            Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 506825728, "C393@15299L218:RideHistoryScreen.kt#2thlc2");
            IconKt.m1811Iconww6aTOc(PedalBikeKt.getPedalBike(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(28.0f)), j4, composer, 432, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer composerM3313constructorimpl3 = Updater.m3313constructorimpl(composer);
            Updater.m3320setimpl(composerM3313constructorimpl3, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3320setimpl(composerM3313constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1491429203, "C402@15602L189,408@15808L40,409@15865L144:RideHistoryScreen.kt#2thlc2");
            TextKt.m2354Text4IGK_g(rideRecordEntity.getTitle(), (Modifier) null, j5, TextUnitKt.getSp(20), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 199680, 0, 131026);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(2.0f)), composer, 6);
            Intrinsics.checkNotNull(str);
            TextKt.m2354Text4IGK_g(str, (Modifier) null, j6, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 3072, 0, 131058);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(16.0f)), composer, 6);
            DividerKt.m1733HorizontalDivider9IZ8Weo(null, 0.0f, j, composer, 0, 3);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(12.0f)), composer, 6);
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceBetween, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default2);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor4);
            } else {
                composer.useNode();
            }
            Composer composerM3313constructorimpl4 = Updater.m3313constructorimpl(composer);
            Updater.m3320setimpl(composerM3313constructorimpl4, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                composerM3313constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composerM3313constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3320setimpl(composerM3313constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1152890515, "C426@16393L494,442@16901L498,458@17413L491,474@17918L489:RideHistoryScreen.kt#2thlc2");
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer, companion);
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor5);
            } else {
                composer.useNode();
            }
            Composer composerM3313constructorimpl5 = Updater.m3313constructorimpl(composer);
            Updater.m3320setimpl(composerM3313constructorimpl5, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl5.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                composerM3313constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                composerM3313constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            Updater.m3320setimpl(composerM3313constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 74427162, "C427@16418L189,433@16624L40,434@16681L192:RideHistoryScreen.kt#2thlc2");
            TextKt.m2354Text4IGK_g("距离", (Modifier) null, j6, TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 199686, 0, 131026);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(2.0f)), composer, 6);
            TextKt.m2354Text4IGK_g(str2, (Modifier) null, j7, TextUnitKt.getSp(16), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 199680, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap6 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer, companion2);
            Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor6);
            } else {
                composer.useNode();
            }
            Composer composerM3313constructorimpl6 = Updater.m3313constructorimpl(composer);
            Updater.m3320setimpl(composerM3313constructorimpl6, measurePolicyColumnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl6.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                composerM3313constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                composerM3313constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
            }
            Updater.m3320setimpl(composerM3313constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -2116507507, "C443@16926L189,449@17132L40,450@17189L196:RideHistoryScreen.kt#2thlc2");
            TextKt.m2354Text4IGK_g("时长", (Modifier) null, j6, TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 199686, 0, 131026);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(2.0f)), composer, 6);
            TextKt.m2354Text4IGK_g(str3, (Modifier) null, j8, TextUnitKt.getSp(16), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 199680, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap7 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composer, companion3);
            Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor7);
            } else {
                composer.useNode();
            }
            Composer composerM3313constructorimpl7 = Updater.m3313constructorimpl(composer);
            Updater.m3320setimpl(composerM3313constructorimpl7, measurePolicyColumnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl7.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                composerM3313constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                composerM3313constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
            }
            Updater.m3320setimpl(composerM3313constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -850436939, "C459@17438L191,465@17646L40,466@17703L187:RideHistoryScreen.kt#2thlc2");
            TextKt.m2354Text4IGK_g("平均速度", (Modifier) null, j6, TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 199686, 0, 131026);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(2.0f)), composer, 6);
            TextKt.m2354Text4IGK_g(str4, (Modifier) null, j8, TextUnitKt.getSp(16), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 199680, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Modifier.Companion companion4 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap8 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composer, companion4);
            Function0<ComposeUiNode> constructor8 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor8);
            } else {
                composer.useNode();
            }
            Composer composerM3313constructorimpl8 = Updater.m3313constructorimpl(composer);
            Updater.m3320setimpl(composerM3313constructorimpl8, measurePolicyColumnMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl8.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash8))) {
                composerM3313constructorimpl8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash8));
                composerM3313constructorimpl8.apply(Integer.valueOf(currentCompositeKeyHash8), setCompositeKeyHash8);
            }
            Updater.m3320setimpl(composerM3313constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 415633784, "C475@17943L191,481@18151L40,482@18208L185:RideHistoryScreen.kt#2thlc2");
            TextKt.m2354Text4IGK_g("最高G值", (Modifier) null, j6, TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 199686, 0, 131026);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(2.0f)), composer, 6);
            TextKt.m2354Text4IGK_g(str5, (Modifier) null, j9, TextUnitKt.getSp(16), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 199680, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final List<RideRecordEntity> RideHistoryScreen$lambda$10(State<? extends List<RideRecordEntity>> state) {
        return state.getValue();
    }
}
