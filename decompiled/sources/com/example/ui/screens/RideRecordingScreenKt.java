package com.example.ui.screens;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.material3.RippleKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawScope;
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
import com.example.data.db.RideRepository;
import com.example.data.service.RideTrackingManager;
import com.example.ui.theme.ColorKt;
import com.example.ui.theme.GlassComponentsKt;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RideRecordingScreen.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\u001aE\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u008e\u0002²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010\u0010\u001a\u00020\rX\u008a\u008e\u0002²\u0006\n\u0010\u0011\u001a\u00020\u0006X\u008a\u0084\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010\u0019\u001a\u00020\rX\u008a\u0084\u0002²\u0006\n\u0010\u001a\u001a\u00020\u001bX\u008a\u008e\u0002²\u0006\n\u0010\u001c\u001a\u00020\u001bX\u008a\u0084\u0002"}, d2 = {"RideRecordingScreen", "", "repository", "Lcom/example/data/db/RideRepository;", "onRideStopped", "Lkotlin/Function1;", "", "onNavigateHome", "Lkotlin/Function0;", "onNavigateHistory", "(Lcom/example/data/db/RideRepository;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app", "showStopConfirmDialog", "", "countdownValue", "", "isCountingDown", "durationSeconds", "distanceMeters", "", "currentSpeedKmH", "avgSpeedKmH", "maxSpeedKmH", "currentElevationMeters", "elevationGainMeters", "isPaused", "currentGValue", "", "maxGForce"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RideRecordingScreenKt {
    static final int RideRecordingScreen$lambda$74$lambda$62$lambda$61(int i) {
        return i;
    }

    static final Unit RideRecordingScreen$lambda$75(RideRepository rideRepository, Function1 function1, Function0 function0, Function0 function2, int i, Composer composer, int i2) {
        RideRecordingScreen(rideRepository, function1, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void RideRecordingScreen(final RideRepository repository, final Function1<? super Long, Unit> onRideStopped, final Function0<Unit> onNavigateHome, final Function0<Unit> onNavigateHistory, Composer composer, final int i) {
        int i2;
        CoroutineContext coroutineContext;
        String str;
        int i3;
        Easing easing;
        int i4;
        int i5;
        boolean z;
        final Context context;
        Composer composer2;
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(onRideStopped, "onRideStopped");
        Intrinsics.checkNotNullParameter(onNavigateHome, "onNavigateHome");
        Intrinsics.checkNotNullParameter(onNavigateHistory, "onNavigateHistory");
        Composer composerStartRestartGroup = composer.startRestartGroup(1980003117);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RideRecordingScreen)P(3,2,1)53@2042L7,54@2075L24,55@2133L34,56@2194L33,57@2254L33,60@2406L44,60@2378L72,65@2531L252,65@2510L273,76@2848L16,77@2926L16,78@3006L16,79@3078L16,80@3150L16,81@3244L16,82@3332L16,83@3398L16,86@3487L39,87@3557L1213,87@3531L1239,116@4823L16,133@5764L19098:RideRecordingScreen.kt#2thlc2");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(repository) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onRideStopped) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onNavigateHome) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1980003117, i2, -1, "com.example.ui.screens.RideRecordingScreen (RideRecordingScreen.kt:52)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Context context2 = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -954367824, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 112492815, "CC(remember):RideRecordingScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 112494766, "CC(remember):RideRecordingScreen.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(3);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableIntState mutableIntState = (MutableIntState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 112496686, "CC(remember):RideRecordingScreen.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 112501561, "CC(remember):RideRecordingScreen.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.example.ui.screens.RideRecordingScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RideRecordingScreenKt.RideRecordingScreen$lambda$10$lambda$9(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BackHandlerKt.BackHandler(true, (Function0) objRememberedValue5, composerStartRestartGroup, 54, 0);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 112505769, "CC(remember):RideRecordingScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(context2);
            RideRecordingScreenKt$RideRecordingScreen$2$1 rideRecordingScreenKt$RideRecordingScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || rideRecordingScreenKt$RideRecordingScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                coroutineContext = null;
                rideRecordingScreenKt$RideRecordingScreen$2$1RememberedValue = new RideRecordingScreenKt$RideRecordingScreen$2$1(context2, mutableState2, mutableIntState, null);
                composerStartRestartGroup.updateRememberedValue(rideRecordingScreenKt$RideRecordingScreen$2$1RememberedValue);
            } else {
                coroutineContext = null;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rideRecordingScreenKt$RideRecordingScreen$2$1RememberedValue, composerStartRestartGroup, 6);
            State stateCollectAsState = SnapshotStateKt.collectAsState(RideTrackingManager.INSTANCE.getDurationSeconds(), coroutineContext, composerStartRestartGroup, 0, 1);
            State stateCollectAsState2 = SnapshotStateKt.collectAsState(RideTrackingManager.INSTANCE.getDistanceMeters(), coroutineContext, composerStartRestartGroup, 0, 1);
            State stateCollectAsState3 = SnapshotStateKt.collectAsState(RideTrackingManager.INSTANCE.getCurrentSpeedKmH(), coroutineContext, composerStartRestartGroup, 0, 1);
            State stateCollectAsState4 = SnapshotStateKt.collectAsState(RideTrackingManager.INSTANCE.getAvgSpeedKmH(), coroutineContext, composerStartRestartGroup, 0, 1);
            State stateCollectAsState5 = SnapshotStateKt.collectAsState(RideTrackingManager.INSTANCE.getMaxSpeedKmH(), coroutineContext, composerStartRestartGroup, 0, 1);
            State stateCollectAsState6 = SnapshotStateKt.collectAsState(RideTrackingManager.INSTANCE.getCurrentElevationMeters(), coroutineContext, composerStartRestartGroup, 0, 1);
            State stateCollectAsState7 = SnapshotStateKt.collectAsState(RideTrackingManager.INSTANCE.getElevationGainMeters(), coroutineContext, composerStartRestartGroup, 0, 1);
            final State stateCollectAsState8 = SnapshotStateKt.collectAsState(RideTrackingManager.INSTANCE.isPaused(), coroutineContext, composerStartRestartGroup, 0, 1);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 112536148, "CC(remember):RideRecordingScreen.kt#9igjgp");
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            final MutableFloatState mutableFloatState = (MutableFloatState) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 112539562, "CC(remember):RideRecordingScreen.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(context2);
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: com.example.ui.screens.RideRecordingScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RideRecordingScreenKt.RideRecordingScreen$lambda$25$lambda$24(context2, mutableFloatState, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(context2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue7, composerStartRestartGroup, 0);
            State stateCollectAsState9 = SnapshotStateKt.collectAsState(RideTrackingManager.INSTANCE.getMaxGForce(), null, composerStartRestartGroup, 0, 1);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str2 = String.format(Locale.getDefault(), "%,.0fm", Arrays.copyOf(new Object[]{Double.valueOf(RideRecordingScreen$lambda$17(stateCollectAsState6))}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String str3 = String.format(Locale.getDefault(), "%,.0fm", Arrays.copyOf(new Object[]{Double.valueOf(RideRecordingScreen$lambda$18(stateCollectAsState7))}, 1));
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String str4 = String.format(Locale.getDefault(), "%.2fG", Arrays.copyOf(new Object[]{Float.valueOf(RideRecordingScreen$lambda$21(mutableFloatState))}, 1));
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(String.format(Locale.getDefault(), "%.2fG", Arrays.copyOf(new Object[]{Float.valueOf(RideRecordingScreen$lambda$26(stateCollectAsState9))}, 1)), "format(...)");
            StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
            String str5 = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(RideRecordingScreen$lambda$13(stateCollectAsState2) / 1000.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
            StringCompanionObject stringCompanionObject6 = StringCompanionObject.INSTANCE;
            String str6 = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(RideRecordingScreen$lambda$14(stateCollectAsState3))}, 1));
            Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
            StringCompanionObject stringCompanionObject7 = StringCompanionObject.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(RideRecordingScreen$lambda$15(stateCollectAsState4))}, 1)), "format(...)");
            StringCompanionObject stringCompanionObject8 = StringCompanionObject.INSTANCE;
            String str7 = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(RideRecordingScreen$lambda$16(stateCollectAsState5))}, 1));
            Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
            long jRideRecordingScreen$lambda$12 = RideRecordingScreen$lambda$12(stateCollectAsState) / 3600;
            long jRideRecordingScreen$lambda$13 = (RideRecordingScreen$lambda$12(stateCollectAsState) % 3600) / 60;
            long jRideRecordingScreen$lambda$14 = RideRecordingScreen$lambda$12(stateCollectAsState) % 60;
            StringCompanionObject stringCompanionObject9 = StringCompanionObject.INSTANCE;
            String str8 = String.format(Locale.getDefault(), "%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(jRideRecordingScreen$lambda$12), Long.valueOf(jRideRecordingScreen$lambda$13), Long.valueOf(jRideRecordingScreen$lambda$14)}, 3));
            Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
            Modifier modifierM225backgroundbw27NRU$default = BackgroundKt.m225backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), ColorKt.getAlpineBackground(), null, 2, null);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 526063518, "C138@5882L12324,514@21958L28,517@22127L2729,510@21756L3100:RideRecordingScreen.kt#2thlc2");
            Modifier modifierM671paddingVpY3zN4 = PaddingKt.m671paddingVpY3zN4(WindowInsetsPadding_androidKt.navigationBarsPadding(WindowInsetsPadding_androidKt.statusBarsPadding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null))), Dp.m6261constructorimpl(16.0f), Dp.m6261constructorimpl(16.0f));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, centerHorizontally, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM671paddingVpY3zN4);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1497906825, "C148@6315L2641,214@9014L1879,261@10940L2842,333@13796L41,336@13917L4279:RideRecordingScreen.kt#2thlc2");
            Modifier modifierM674paddingqDBjuR0$default = PaddingKt.m674paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6261constructorimpl(16.0f), 0.0f, 0.0f, 13, null);
            Arrangement.HorizontalOrVertical spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical top = Alignment.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween2, top, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM674paddingqDBjuR0$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 7695771, "C156@6611L725,175@7409L747,194@8210L732:RideRecordingScreen.kt#2thlc2");
            Alignment.Horizontal start = Alignment.INSTANCE.getStart();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), start, composerStartRestartGroup, 48);
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
            Updater.m3320setimpl(composerM3313constructorimpl4, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                composerM3313constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composerM3313constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3320setimpl(composerM3313constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2037091757, "C157@6679L267,164@6967L40,165@7028L290:RideRecordingScreen.kt#2thlc2");
            TextKt.m2354Text4IGK_g("海拔", (Modifier) null, ColorKt.getAlpineOnSurfaceVariant(), TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, TextUnitKt.getSp(0.5d), (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 12782982, 0, 130898);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(2.0f)), composerStartRestartGroup, 6);
            TextKt.m2354Text4IGK_g(str2, TestTagKt.testTag(Modifier.INSTANCE, "recording_elevation"), ColorKt.getAlpinePrimary(), TextUnitKt.getSp(22), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 200112, 0, 131024);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
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
            Updater.m3320setimpl(composerM3313constructorimpl5, measurePolicyColumnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl5.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                composerM3313constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                composerM3313constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            Updater.m3320setimpl(composerM3313constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1548773179, "C176@7490L269,183@7780L40,184@7841L297:RideRecordingScreen.kt#2thlc2");
            TextKt.m2354Text4IGK_g("实时G值", (Modifier) null, ColorKt.getAlpineOnSurfaceVariant(), TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, TextUnitKt.getSp(0.5d), (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 12782982, 0, 130898);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(2.0f)), composerStartRestartGroup, 6);
            TextKt.m2354Text4IGK_g(str4, TestTagKt.testTag(Modifier.INSTANCE, "recording_current_g_force"), androidx.compose.ui.graphics.ColorKt.Color(4294956367L), TextUnitKt.getSp(22), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 200112, 0, 131024);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Alignment.Horizontal end = Alignment.INSTANCE.getEnd();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), end, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
            Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor6);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3313constructorimpl6 = Updater.m3313constructorimpl(composerStartRestartGroup);
            Updater.m3320setimpl(composerM3313constructorimpl6, measurePolicyColumnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl6.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                composerM3313constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                composerM3313constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
            }
            Updater.m3320setimpl(composerM3313constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 129449148, "C195@8276L267,202@8564L40,203@8625L299:RideRecordingScreen.kt#2thlc2");
            TextKt.m2354Text4IGK_g("爬升", (Modifier) null, ColorKt.getAlpineOnSurfaceVariant(), TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, TextUnitKt.getSp(0.5d), (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 12782982, 0, 130898);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(2.0f)), composerStartRestartGroup, 6);
            TextKt.m2354Text4IGK_g(str3, TestTagKt.testTag(Modifier.INSTANCE, "recording_elevation_gain"), ColorKt.getAlpinePrimary(), TextUnitKt.getSp(22), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 200112, 0, 131024);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Alignment.Horizontal centerHorizontally3 = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Modifier modifierWeight$default = ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(center, centerHorizontally3, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
            Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor7);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3313constructorimpl7 = Updater.m3313constructorimpl(composerStartRestartGroup);
            Updater.m3320setimpl(composerM3313constructorimpl7, measurePolicyColumnMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl7.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                composerM3313constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                composerM3313constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
            }
            Updater.m3320setimpl(composerM3313constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -720239372, "C219@9227L243,226@9487L40,227@9544L369,236@9930L192:RideRecordingScreen.kt#2thlc2");
            TextKt.m2354Text4IGK_g("实时速度", (Modifier) null, ColorKt.getAlpineOnSurfaceVariant(), TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, TextUnitKt.getSp(1), (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 12782982, 0, 130898);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(8.0f)), composerStartRestartGroup, 6);
            TextKt.m2354Text4IGK_g(str6, TestTagKt.testTag(Modifier.INSTANCE, "recording_current_speed"), ColorKt.getAlpinePrimaryContainer(), TextUnitKt.getSp(MenuKt.InTransitionDuration), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, TextUnitKt.getSp(-2), (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(MenuKt.InTransitionDuration), 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 12783024, 6, 129872);
            TextKt.m2354Text4IGK_g("km/h", (Modifier) null, ColorKt.getAlpineOutline(), TextUnitKt.getSp(24), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 200070, 0, 131026);
            Composer composer3 = composerStartRestartGroup;
            if (RideRecordingScreen$lambda$19(stateCollectAsState8)) {
                composer3.startReplaceGroup(-719349487);
                ComposerKt.sourceInformation(composer3, "243@10175L41,244@10237L624");
                SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(10.0f)), composer3, 6);
                SurfaceKt.m2204SurfaceT9BRK9s(null, RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6261constructorimpl(12.0f)), Color.m3819copywmQWz5c$default(androidx.compose.ui.graphics.ColorKt.Color(4294956367L), 0.18f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0.0f, 0.0f, BorderStrokeKt.m252BorderStrokecXLIe8U(Dp.m6261constructorimpl(1.0f), Color.m3819copywmQWz5c$default(androidx.compose.ui.graphics.ColorKt.Color(4294956367L), 0.5f, 0.0f, 0.0f, 0.0f, 14, null)), ComposableSingletons$RideRecordingScreenKt.INSTANCE.getLambda$959087749$app(), composer3, 14156160, 57);
                composer3 = composer3;
            } else {
                composer3.startReplaceGroup(-729444761);
            }
            composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            Modifier modifierM674paddingqDBjuR0$default2 = PaddingKt.m674paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6261constructorimpl(20.0f), 7, null);
            Arrangement.HorizontalOrVertical spaceBetween3 = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceBetween3, centerVertically, composer3, 54);
            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
            CompositionLocalMap currentCompositionLocalMap8 = composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composer3, modifierM674paddingqDBjuR0$default2);
            Function0<ComposeUiNode> constructor8 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor8);
            } else {
                composer3.useNode();
            }
            Composer composerM3313constructorimpl8 = Updater.m3313constructorimpl(composer3);
            Updater.m3320setimpl(composerM3313constructorimpl8, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl8.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash8))) {
                composerM3313constructorimpl8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash8));
                composerM3313constructorimpl8.apply(Integer.valueOf(currentCompositeKeyHash8), setCompositeKeyHash8);
            }
            Updater.m3320setimpl(composerM3313constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer3, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, 1227243833, "C269@11252L865,292@12167L686,310@12900L868:RideRecordingScreen.kt#2thlc2");
            Alignment.Horizontal centerHorizontally4 = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Modifier.Companion companion4 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally4, composer3, 48);
            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash9 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
            CompositionLocalMap currentCompositionLocalMap9 = composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composer3, companion4);
            Function0<ComposeUiNode> constructor9 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor9);
            } else {
                composer3.useNode();
            }
            Composer composerM3313constructorimpl9 = Updater.m3313constructorimpl(composer3);
            Updater.m3320setimpl(composerM3313constructorimpl9, measurePolicyColumnMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash9 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl9.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl9.rememberedValue(), Integer.valueOf(currentCompositeKeyHash9))) {
                composerM3313constructorimpl9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash9));
                composerM3313constructorimpl9.apply(Integer.valueOf(currentCompositeKeyHash9), setCompositeKeyHash9);
            }
            Updater.m3320setimpl(composerM3313constructorimpl9, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer3, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, 1634841797, "C270@11333L219,276@11573L40,277@11634L292,284@11947L152:RideRecordingScreen.kt#2thlc2");
            Composer composer4 = composer3;
            TextKt.m2354Text4IGK_g("距离", (Modifier) null, ColorKt.getAlpineOnSurfaceVariant(), TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 200070, 0, 131026);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(2.0f)), composer4, 6);
            TextKt.m2354Text4IGK_g(str5, TestTagKt.testTag(Modifier.INSTANCE, "recording_distance"), ColorKt.getAlpineOnSurface(), TextUnitKt.getSp(22), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 200112, 0, 131024);
            TextKt.m2354Text4IGK_g("km", (Modifier) null, ColorKt.getAlpineOutline(), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 3462, 0, 131058);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            Alignment.Horizontal centerHorizontally5 = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composer4, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Modifier.Companion companion5 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy7 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally5, composer4, 48);
            ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash10 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
            CompositionLocalMap currentCompositionLocalMap10 = composer4.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composer4, companion5);
            Function0<ComposeUiNode> constructor10 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer4.startReusableNode();
            if (composer4.getInserting()) {
                composer4.createNode(constructor10);
            } else {
                composer4.useNode();
            }
            Composer composerM3313constructorimpl10 = Updater.m3313constructorimpl(composer4);
            Updater.m3320setimpl(composerM3313constructorimpl10, measurePolicyColumnMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl10, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash10 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl10.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl10.rememberedValue(), Integer.valueOf(currentCompositeKeyHash10))) {
                composerM3313constructorimpl10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash10));
                composerM3313constructorimpl10.apply(Integer.valueOf(currentCompositeKeyHash10), setCompositeKeyHash10);
            }
            Updater.m3320setimpl(composerM3313constructorimpl10, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer4, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance7 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer4, 511849935, "C293@12248L219,299@12488L40,300@12549L286:RideRecordingScreen.kt#2thlc2");
            TextKt.m2354Text4IGK_g("时间", (Modifier) null, ColorKt.getAlpineOnSurfaceVariant(), TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 200070, 0, 131026);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(2.0f)), composer4, 6);
            TextKt.m2354Text4IGK_g(str8, TestTagKt.testTag(Modifier.INSTANCE, "recording_duration"), ColorKt.getAlpineOnSurface(), TextUnitKt.getSp(22), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 200112, 0, 131024);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            Alignment.Horizontal centerHorizontally6 = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composer4, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Modifier.Companion companion6 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy8 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally6, composer4, 48);
            ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash11 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
            CompositionLocalMap currentCompositionLocalMap11 = composer4.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composer4, companion6);
            Function0<ComposeUiNode> constructor11 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer4.startReusableNode();
            if (composer4.getInserting()) {
                composer4.createNode(constructor11);
            } else {
                composer4.useNode();
            }
            Composer composerM3313constructorimpl11 = Updater.m3313constructorimpl(composer4);
            Updater.m3320setimpl(composerM3313constructorimpl11, measurePolicyColumnMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl11, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash11 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl11.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl11.rememberedValue(), Integer.valueOf(currentCompositeKeyHash11))) {
                composerM3313constructorimpl11.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash11));
                composerM3313constructorimpl11.apply(Integer.valueOf(currentCompositeKeyHash11), setCompositeKeyHash11);
            }
            Updater.m3320setimpl(composerM3313constructorimpl11, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer4, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance8 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer4, -1953905382, "C311@12981L221,317@13223L40,318@13284L291,325@13596L154:RideRecordingScreen.kt#2thlc2");
            TextKt.m2354Text4IGK_g("最高速度", (Modifier) null, ColorKt.getAlpineOnSurfaceVariant(), TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 200070, 0, 131026);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(2.0f)), composer4, 6);
            TextKt.m2354Text4IGK_g(str7, TestTagKt.testTag(Modifier.INSTANCE, "recording_max_speed"), ColorKt.getAlpineOnSurface(), TextUnitKt.getSp(22), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 200112, 0, 131024);
            TextKt.m2354Text4IGK_g("km/h", (Modifier) null, ColorKt.getAlpineOutline(), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 3462, 0, 131058);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(60.0f)), composer4, 6);
            Modifier modifierM674paddingqDBjuR0$default3 = PaddingKt.m674paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m6261constructorimpl(24.0f), 7, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_4 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(16.0f));
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer4, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_4, centerVertically2, composer4, 54);
            ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash12 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
            CompositionLocalMap currentCompositionLocalMap12 = composer4.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composer4, modifierM674paddingqDBjuR0$default3);
            Function0<ComposeUiNode> constructor12 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer4.startReusableNode();
            if (composer4.getInserting()) {
                composer4.createNode(constructor12);
            } else {
                composer4.useNode();
            }
            Composer composerM3313constructorimpl12 = Updater.m3313constructorimpl(composer4);
            Updater.m3320setimpl(composerM3313constructorimpl12, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash12 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl12.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl12.rememberedValue(), Integer.valueOf(currentCompositeKeyHash12))) {
                composerM3313constructorimpl12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash12));
                composerM3313constructorimpl12.apply(Integer.valueOf(currentCompositeKeyHash12), setCompositeKeyHash12);
            }
            Updater.m3320setimpl(composerM3313constructorimpl12, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer4, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer4, -904364307, "C355@14822L39,357@14977L301,344@14245L2211,403@17086L39,405@17235L32,392@16510L1672:RideRecordingScreen.kt#2thlc2");
            Modifier modifierM6638glassPanelIBj4UiM$default = GlassComponentsKt.m6638glassPanelIBj4UiM$default(TestTagKt.testTag(RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), "pause_ride_button"), RoundedCornerShapeKt.getCircleShape(), Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, null), Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.25f, 0.0f, 0.0f, 0.0f, 14, null), Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 16, null);
            ComposerKt.sourceInformationMarkerStart(composer4, 247936188, "CC(remember):RideRecordingScreen.kt#9igjgp");
            Object objRememberedValue8 = composer4.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = InteractionSourceKt.MutableInteractionSource();
                composer4.updateRememberedValue(objRememberedValue8);
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composer4);
            IndicationNodeFactory indicationNodeFactoryM2065rippleH2RKhps$default = RippleKt.m2065rippleH2RKhps$default(false, 0.0f, androidx.compose.ui.graphics.ColorKt.Color(4294956367L), 3, null);
            ComposerKt.sourceInformationMarkerStart(composer4, 247941410, "CC(remember):RideRecordingScreen.kt#9igjgp");
            boolean zChanged = composer4.changed(stateCollectAsState8);
            Object objRememberedValue9 = composer4.rememberedValue();
            if (zChanged || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = new Function0() { // from class: com.example.ui.screens.RideRecordingScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RideRecordingScreenKt.RideRecordingScreen$lambda$74$lambda$50$lambda$49$lambda$38$lambda$37(stateCollectAsState8);
                    }
                };
                composer4.updateRememberedValue(objRememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(composer4);
            Modifier modifierM672paddingVpY3zN4$default = PaddingKt.m672paddingVpY3zN4$default(ClickableKt.m256clickableO2vRcR0$default(modifierM6638glassPanelIBj4UiM$default, mutableInteractionSource, indicationNodeFactoryM2065rippleH2RKhps$default, false, null, null, (Function0) objRememberedValue9, 28, null), 0.0f, Dp.m6261constructorimpl(16.0f), 1, null);
            Alignment center2 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash13 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
            CompositionLocalMap currentCompositionLocalMap13 = composer4.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composer4, modifierM672paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor13 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer4.startReusableNode();
            if (composer4.getInserting()) {
                composer4.createNode(constructor13);
            } else {
                composer4.useNode();
            }
            Composer composerM3313constructorimpl13 = Updater.m3313constructorimpl(composer4);
            Updater.m3320setimpl(composerM3313constructorimpl13, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl13, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash13 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl13.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl13.rememberedValue(), Integer.valueOf(currentCompositeKeyHash13))) {
                composerM3313constructorimpl13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash13));
                composerM3313constructorimpl13.apply(Integer.valueOf(currentCompositeKeyHash13), setCompositeKeyHash13);
            }
            Updater.m3320setimpl(composerM3313constructorimpl13, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer4, 68086299, "C368@15453L985:RideRecordingScreen.kt#2thlc2");
            Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_5 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(10.0f));
            ComposerKt.sourceInformationMarkerStart(composer4, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Modifier.Companion companion7 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_5, centerVertically3, composer4, 54);
            ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash14 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
            CompositionLocalMap currentCompositionLocalMap14 = composer4.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composer4, companion7);
            Function0<ComposeUiNode> constructor14 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer4.startReusableNode();
            if (composer4.getInserting()) {
                composer4.createNode(constructor14);
            } else {
                composer4.useNode();
            }
            Composer composerM3313constructorimpl14 = Updater.m3313constructorimpl(composer4);
            Updater.m3320setimpl(composerM3313constructorimpl14, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl14, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash14 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl14.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl14.rememberedValue(), Integer.valueOf(currentCompositeKeyHash14))) {
                composerM3313constructorimpl14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash14));
                composerM3313constructorimpl14.apply(Integer.valueOf(currentCompositeKeyHash14), setCompositeKeyHash14);
            }
            Updater.m3320setimpl(composerM3313constructorimpl14, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer4, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer4, 868711982, "C373@15742L393,373@15702L433,382@16160L256:RideRecordingScreen.kt#2thlc2");
            Modifier modifierM715size3ABfNKs = SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(16.0f));
            ComposerKt.sourceInformationMarkerStart(composer4, 2106233908, "CC(remember):RideRecordingScreen.kt#9igjgp");
            Object objRememberedValue10 = composer4.rememberedValue();
            if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue10 = new Function1() { // from class: com.example.ui.screens.RideRecordingScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RideRecordingScreenKt.RideRecordingScreen$lambda$74$lambda$50$lambda$49$lambda$43$lambda$42$lambda$41$lambda$40((DrawScope) obj);
                    }
                };
                composer4.updateRememberedValue(objRememberedValue10);
            }
            ComposerKt.sourceInformationMarkerEnd(composer4);
            CanvasKt.Canvas(modifierM715size3ABfNKs, (Function1) objRememberedValue10, composer4, 54);
            TextKt.m2354Text4IGK_g(RideRecordingScreen$lambda$19(stateCollectAsState8) ? "继续骑行" : "暂停骑行", (Modifier) null, ColorKt.getAlpineOnSurface(), TextUnitKt.getSp(18), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 200064, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerEnd(composer4);
            Modifier modifierM6638glassPanelIBj4UiM$default2 = GlassComponentsKt.m6638glassPanelIBj4UiM$default(TestTagKt.testTag(RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), "stop_ride_button"), RoundedCornerShapeKt.getCircleShape(), Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, null), Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.25f, 0.0f, 0.0f, 0.0f, 14, null), Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 16, null);
            ComposerKt.sourceInformationMarkerStart(composer4, 248008636, "CC(remember):RideRecordingScreen.kt#9igjgp");
            Object objRememberedValue11 = composer4.rememberedValue();
            if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue11 = InteractionSourceKt.MutableInteractionSource();
                composer4.updateRememberedValue(objRememberedValue11);
            }
            MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(composer4);
            IndicationNodeFactory indicationNodeFactoryM2065rippleH2RKhps$default2 = RippleKt.m2065rippleH2RKhps$default(false, 0.0f, ColorKt.getAlpineError(), 3, null);
            ComposerKt.sourceInformationMarkerStart(composer4, 248013397, "CC(remember):RideRecordingScreen.kt#9igjgp");
            Object objRememberedValue12 = composer4.rememberedValue();
            if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue12 = new Function0() { // from class: com.example.ui.screens.RideRecordingScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RideRecordingScreenKt.RideRecordingScreen$lambda$74$lambda$50$lambda$49$lambda$46$lambda$45(mutableState);
                    }
                };
                composer4.updateRememberedValue(objRememberedValue12);
            }
            ComposerKt.sourceInformationMarkerEnd(composer4);
            Modifier modifierM672paddingVpY3zN4$default2 = PaddingKt.m672paddingVpY3zN4$default(ClickableKt.m256clickableO2vRcR0$default(modifierM6638glassPanelIBj4UiM$default2, mutableInteractionSource2, indicationNodeFactoryM2065rippleH2RKhps$default2, false, null, null, (Function0) objRememberedValue12, 28, null), 0.0f, Dp.m6261constructorimpl(16.0f), 1, null);
            Alignment center3 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
            ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash15 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
            CompositionLocalMap currentCompositionLocalMap15 = composer4.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composer4, modifierM672paddingVpY3zN4$default2);
            Function0<ComposeUiNode> constructor15 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer4.startReusableNode();
            if (composer4.getInserting()) {
                composer4.createNode(constructor15);
            } else {
                composer4.useNode();
            }
            Composer composerM3313constructorimpl15 = Updater.m3313constructorimpl(composer4);
            Updater.m3320setimpl(composerM3313constructorimpl15, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl15, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash15 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl15.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl15.rememberedValue(), Integer.valueOf(currentCompositeKeyHash15))) {
                composerM3313constructorimpl15.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash15));
                composerM3313constructorimpl15.apply(Integer.valueOf(currentCompositeKeyHash15), setCompositeKeyHash15);
            }
            Updater.m3320setimpl(composerM3313constructorimpl15, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer4, 85900537, "C410@17442L722:RideRecordingScreen.kt#2thlc2");
            Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_6 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(10.0f));
            ComposerKt.sourceInformationMarkerStart(composer4, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Modifier.Companion companion8 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_6, centerVertically4, composer4, 54);
            ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash16 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
            CompositionLocalMap currentCompositionLocalMap16 = composer4.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composer4, companion8);
            Function0<ComposeUiNode> constructor16 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer4.startReusableNode();
            if (composer4.getInserting()) {
                composer4.createNode(constructor16);
            } else {
                composer4.useNode();
            }
            Composer composerM3313constructorimpl16 = Updater.m3313constructorimpl(composer4);
            Updater.m3320setimpl(composerM3313constructorimpl16, measurePolicyRowMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl16, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash16 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl16.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash16))) {
                composerM3313constructorimpl16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash16));
                composerM3313constructorimpl16.apply(Integer.valueOf(currentCompositeKeyHash16), setCompositeKeyHash16);
            }
            Updater.m3320setimpl(composerM3313constructorimpl16, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer4, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer4, 646534108, "C414@17643L244,420@17912L230:RideRecordingScreen.kt#2thlc2");
            BoxKt.Box(BackgroundKt.m225backgroundbw27NRU$default(ClipKt.clip(SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(16.0f)), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6261constructorimpl(3.0f))), ColorKt.getAlpineError(), null, 2, null), composer4, 0);
            TextKt.m2354Text4IGK_g("停止骑行", (Modifier) null, ColorKt.getAlpineOnSurface(), TextUnitKt.getSp(18), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 200070, 0, 131026);
            Composer composer5 = composer4;
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            ComposerKt.sourceInformationMarkerEnd(composer5);
            if (RideRecordingScreen$lambda$1(mutableState)) {
                composer5.startReplaceGroup(537883259);
                ComposerKt.sourceInformation(composer5, "434@18346L33,450@18952L2559,433@18298L3368");
                long jColor = androidx.compose.ui.graphics.ColorKt.Color(4028110875L);
                RoundedCornerShape roundedCornerShapeM953RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6261constructorimpl(24.0f));
                ComposerKt.sourceInformationMarkerStart(composer5, -1922312952, "CC(remember):RideRecordingScreen.kt#9igjgp");
                Object objRememberedValue13 = composer5.rememberedValue();
                if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue13 = new Function0() { // from class: com.example.ui.screens.RideRecordingScreenKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return RideRecordingScreenKt.RideRecordingScreen$lambda$74$lambda$52$lambda$51(mutableState);
                        }
                    };
                    composer5.updateRememberedValue(objRememberedValue13);
                }
                ComposerKt.sourceInformationMarkerEnd(composer5);
                context = context2;
                RoundedCornerShape roundedCornerShape = roundedCornerShapeM953RoundedCornerShape0680j_4;
                easing = null;
                z = true;
                str = "CC(remember):RideRecordingScreen.kt#9igjgp";
                i4 = 54;
                i3 = 0;
                i5 = 2;
                AndroidAlertDialog_androidKt.m1422AlertDialogOix01E0((Function0) objRememberedValue13, ComposableLambdaKt.rememberComposableLambda(392218548, true, new Function2() { // from class: com.example.ui.screens.RideRecordingScreenKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RideRecordingScreenKt.RideRecordingScreen$lambda$74$lambda$60(coroutineScope, context, repository, onRideStopped, onNavigateHome, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer5, 54), null, null, null, ComposableSingletons$RideRecordingScreenKt.INSTANCE.getLambda$2137338552$app(), ComposableSingletons$RideRecordingScreenKt.INSTANCE.m6635getLambda$647606919$app(), roundedCornerShape, jColor, 0L, 0L, 0L, 0.0f, null, composer5, 102435894, 0, 15892);
                composer5 = composer5;
            } else {
                str = "CC(remember):RideRecordingScreen.kt#9igjgp";
                i3 = 0;
                easing = null;
                i4 = 54;
                i5 = 2;
                z = true;
                context = context2;
                composer5.startReplaceGroup(519639387);
            }
            composer5.endReplaceGroup();
            boolean zRideRecordingScreen$lambda$7 = RideRecordingScreen$lambda$7(mutableState2);
            EnterTransition enterTransitionFadeIn$default = EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(ComposerKt.invocationKey, i3, easing, 6, easing), r40, i5, easing);
            TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(500, i3, easing, 6, easing);
            ComposerKt.sourceInformationMarkerStart(composer5, -1922197373, str);
            Object objRememberedValue14 = composer5.rememberedValue();
            if (objRememberedValue14 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue14 = new Function1() { // from class: com.example.ui.screens.RideRecordingScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(RideRecordingScreenKt.RideRecordingScreen$lambda$74$lambda$62$lambda$61(((Integer) obj).intValue()));
                    }
                };
                composer5.updateRememberedValue(objRememberedValue14);
            }
            ComposerKt.sourceInformationMarkerEnd(composer5);
            AnimatedVisibilityKt.AnimatedVisibility(zRideRecordingScreen$lambda$7, (Modifier) null, enterTransitionFadeIn$default, EnterExitTransitionKt.slideOutVertically(tweenSpecTween$default, (Function1) objRememberedValue14).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(400, i3, easing, 6, easing), 0.0f, i5, easing)), (String) null, ComposableLambdaKt.rememberComposableLambda(-1499212401, z, new Function3() { // from class: com.example.ui.screens.RideRecordingScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RideRecordingScreenKt.RideRecordingScreen$lambda$74$lambda$73(context, mutableIntState, mutableState2, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer5, i4), composer5, 196992, 18);
            composer2 = composer5;
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.screens.RideRecordingScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RideRecordingScreenKt.RideRecordingScreen$lambda$75(repository, onRideStopped, onNavigateHome, onNavigateHistory, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean RideRecordingScreen$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void RideRecordingScreen$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final int RideRecordingScreen$lambda$4(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean RideRecordingScreen$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RideRecordingScreen$lambda$8(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static final Unit RideRecordingScreen$lambda$10$lambda$9(MutableState mutableState) {
        RideRecordingScreen$lambda$2(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float RideRecordingScreen$lambda$21(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [com.example.ui.screens.RideRecordingScreenKt$RideRecordingScreen$3$1$listener$1] */
    static final DisposableEffectResult RideRecordingScreen$lambda$25$lambda$24(Context context, final MutableFloatState mutableFloatState, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        Object systemService = context.getSystemService("sensor");
        final SensorManager sensorManager = systemService instanceof SensorManager ? (SensorManager) systemService : null;
        Sensor defaultSensor = sensorManager != null ? sensorManager.getDefaultSensor(1) : null;
        final ?? r4 = new SensorEventListener() { // from class: com.example.ui.screens.RideRecordingScreenKt$RideRecordingScreen$3$1$listener$1
            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }

            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent event) {
                Sensor sensor;
                if (event == null || (sensor = event.sensor) == null || sensor.getType() != 1) {
                    return;
                }
                float f = event.values[0];
                float f2 = event.values[1];
                float f3 = event.values[2];
                float fSqrt = ((float) Math.sqrt(((f * f) + (f2 * f2)) + (f3 * f3))) / 9.80665f;
                MutableFloatState mutableFloatState2 = mutableFloatState;
                mutableFloatState2.setFloatValue((RideRecordingScreenKt.RideRecordingScreen$lambda$21(mutableFloatState2) * 0.7f) + (fSqrt * 0.3f));
                RideTrackingManager.INSTANCE.updateGForce(RideRecordingScreenKt.RideRecordingScreen$lambda$21(mutableFloatState));
            }
        };
        if (sensorManager != null && defaultSensor != null) {
            sensorManager.registerListener((SensorEventListener) r4, defaultSensor, 2);
        }
        return new DisposableEffectResult() { // from class: com.example.ui.screens.RideRecordingScreenKt$RideRecordingScreen$lambda$25$lambda$24$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                SensorManager sensorManager2 = sensorManager;
                if (sensorManager2 != null) {
                    sensorManager2.unregisterListener(r4);
                }
            }
        };
    }

    static final Unit RideRecordingScreen$lambda$74$lambda$50$lambda$49$lambda$38$lambda$37(State state) {
        if (RideRecordingScreen$lambda$19(state)) {
            RideTrackingManager.INSTANCE.resumeRecording();
        } else {
            RideTrackingManager.INSTANCE.pauseRecording();
        }
        return Unit.INSTANCE;
    }

    static final Unit RideRecordingScreen$lambda$74$lambda$50$lambda$49$lambda$43$lambda$42$lambda$41$lambda$40(DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        Path Path = AndroidPath_androidKt.Path();
        Path.moveTo(0.0f, 0.0f);
        Path.lineTo(Size.m3648getWidthimpl(Canvas.mo4370getSizeNHjbRc()), Size.m3645getHeightimpl(Canvas.mo4370getSizeNHjbRc()) / 2.0f);
        Path.lineTo(0.0f, Size.m3645getHeightimpl(Canvas.mo4370getSizeNHjbRc()));
        Path.close();
        DrawScope.m4360drawPathLG529CI$default(Canvas, Path, androidx.compose.ui.graphics.ColorKt.Color(4294956367L), 0.0f, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }

    static final Unit RideRecordingScreen$lambda$74$lambda$50$lambda$49$lambda$46$lambda$45(MutableState mutableState) {
        RideRecordingScreen$lambda$2(mutableState, true);
        return Unit.INSTANCE;
    }

    static final Unit RideRecordingScreen$lambda$74$lambda$52$lambda$51(MutableState mutableState) {
        RideRecordingScreen$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    static final Unit RideRecordingScreen$lambda$74$lambda$60(final CoroutineScope coroutineScope, final Context context, final RideRepository rideRepository, final Function1 function1, final Function0 function0, final MutableState mutableState, Composer composer, int i) {
        Object obj;
        final MutableState mutableState2;
        ComposerKt.sourceInformation(composer, "C451@18974L2519:RideRecordingScreen.kt#2thlc2");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(392218548, i, -1, "com.example.ui.screens.RideRecordingScreen.<anonymous>.<anonymous> (RideRecordingScreen.kt:451)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_4 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(8.0f));
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_4, Alignment.INSTANCE.getStart(), composer, 6);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1848761387, "C463@19610L175,456@19209L347,455@19163L957,481@20474L110,476@20200L220,475@20146L897,494@21119L33,493@21069L402:RideRecordingScreen.kt#2thlc2");
            ButtonColors buttonColorsM1469buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1469buttonColorsro_MJ88(ColorKt.getAlpinePrimaryContainer(), Color.INSTANCE.m3846getBlack0d7_KjU(), 0L, 0L, composer, (ButtonDefaults.$stable << 12) | 54, 12);
            RoundedCornerShape circleShape = RoundedCornerShapeKt.getCircleShape();
            Modifier modifierTestTag = TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "confirm_stop_button");
            ComposerKt.sourceInformationMarkerStart(composer, -1999300603, "CC(remember):RideRecordingScreen.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(context) | composer.changedInstance(rideRepository) | composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function0() { // from class: com.example.ui.screens.RideRecordingScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RideRecordingScreenKt.RideRecordingScreen$lambda$74$lambda$60$lambda$59$lambda$54$lambda$53(coroutineScope, mutableState, context, rideRepository, function1);
                    }
                };
                mutableState2 = mutableState;
                composer.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue;
                mutableState2 = mutableState;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.Button((Function0) obj, modifierTestTag, false, circleShape, buttonColorsM1469buttonColorsro_MJ88, null, null, null, null, ComposableSingletons$RideRecordingScreenKt.INSTANCE.m6634getLambda$1948878822$app(), composer, 805306416, 484);
            ButtonColors buttonColorsM1479outlinedButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1479outlinedButtonColorsro_MJ88(0L, ColorKt.getAlpineError(), 0L, 0L, composer, (ButtonDefaults.$stable << 12) | 48, 13);
            BorderStroke borderStrokeM252BorderStrokecXLIe8U = BorderStrokeKt.m252BorderStrokecXLIe8U(Dp.m6261constructorimpl(1.0f), Color.m3819copywmQWz5c$default(ColorKt.getAlpineError(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null));
            RoundedCornerShape circleShape2 = RoundedCornerShapeKt.getCircleShape();
            Modifier modifierTestTag2 = TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "exit_stop_button");
            ComposerKt.sourceInformationMarkerStart(composer, -1999269018, "CC(remember):RideRecordingScreen.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(context) | composer.changed(function0);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.example.ui.screens.RideRecordingScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RideRecordingScreenKt.RideRecordingScreen$lambda$74$lambda$60$lambda$59$lambda$56$lambda$55(context, function0, mutableState2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.OutlinedButton((Function0) objRememberedValue2, modifierTestTag2, false, circleShape2, buttonColorsM1479outlinedButtonColorsro_MJ88, null, borderStrokeM252BorderStrokecXLIe8U, null, null, ComposableSingletons$RideRecordingScreenKt.INSTANCE.getLambda$729438108$app(), composer, 806879280, 420);
            ComposerKt.sourceInformationMarkerStart(composer, -1999239797, "CC(remember):RideRecordingScreen.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.example.ui.screens.RideRecordingScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RideRecordingScreenKt.RideRecordingScreen$lambda$74$lambda$60$lambda$59$lambda$58$lambda$57(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0) objRememberedValue3, TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "cancel_stop_button"), false, null, null, null, null, null, null, ComposableSingletons$RideRecordingScreenKt.INSTANCE.getLambda$807411431$app(), composer, 805306422, 508);
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

    static final Unit RideRecordingScreen$lambda$74$lambda$60$lambda$59$lambda$54$lambda$53(CoroutineScope coroutineScope, MutableState mutableState, Context context, RideRepository rideRepository, Function1 function1) {
        RideRecordingScreen$lambda$2(mutableState, false);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new RideRecordingScreenKt$RideRecordingScreen$4$3$1$1$1$1(context, rideRepository, function1, null), 3, null);
        return Unit.INSTANCE;
    }

    static final Unit RideRecordingScreen$lambda$74$lambda$60$lambda$59$lambda$56$lambda$55(Context context, Function0 function0, MutableState mutableState) {
        RideRecordingScreen$lambda$2(mutableState, false);
        RideTrackingManager.INSTANCE.discardRecording(context);
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final Unit RideRecordingScreen$lambda$74$lambda$60$lambda$59$lambda$58$lambda$57(MutableState mutableState) {
        RideRecordingScreen$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    static final Unit RideRecordingScreen$lambda$74$lambda$73(final Context context, MutableIntState mutableIntState, final MutableState mutableState, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C523@22358L39,525@22463L2,518@22141L2705:RideRecordingScreen.kt#2thlc2");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1499212401, i, -1, "com.example.ui.screens.RideRecordingScreen.<anonymous>.<anonymous> (RideRecordingScreen.kt:518)");
        }
        Modifier modifierM225backgroundbw27NRU$default = BackgroundKt.m225backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.m3819copywmQWz5c$default(Color.INSTANCE.m3846getBlack0d7_KjU(), 0.9f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
        ComposerKt.sourceInformationMarkerStart(composer, -1929065770, "CC(remember):RideRecordingScreen.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
            composer.updateRememberedValue(objRememberedValue);
        }
        MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1929062447, "CC(remember):RideRecordingScreen.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: com.example.ui.screens.RideRecordingScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierM256clickableO2vRcR0$default = ClickableKt.m256clickableO2vRcR0$default(modifierM225backgroundbw27NRU$default, mutableInteractionSource, null, false, null, null, (Function0) objRememberedValue2, 28, null);
        Alignment center = Alignment.INSTANCE.getCenter();
        ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
        ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM256clickableO2vRcR0$default);
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
        ComposerKt.sourceInformationMarkerStart(composer, -1400966591, "C528@22599L2233:RideRecordingScreen.kt#2thlc2");
        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
        Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
        ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
        Modifier.Companion companion = Modifier.INSTANCE;
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center2, centerHorizontally, composer, 54);
        ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion);
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
        Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM3313constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 1020604830, "C532@22780L276,540@23078L41,544@23253L152,542@23141L727,558@23890L41,565@24196L162,561@23988L826:RideRecordingScreen.kt#2thlc2");
        TextKt.m2354Text4IGK_g("准备骑行", (Modifier) null, Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.75f, 0.0f, 0.0f, 0.0f, 14, null), TextUnitKt.getSp(22), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, TextUnitKt.getSp(2), (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 12782982, 0, 130898);
        SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(36.0f)), composer, 6);
        Integer numValueOf = Integer.valueOf(RideRecordingScreen$lambda$4(mutableIntState));
        ComposerKt.sourceInformationMarkerStart(composer, 725672651, "CC(remember):RideRecordingScreen.kt#9igjgp");
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function1() { // from class: com.example.ui.screens.RideRecordingScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RideRecordingScreenKt.RideRecordingScreen$lambda$74$lambda$73$lambda$72$lambda$71$lambda$67$lambda$66((AnimatedContentTransitionScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        AnimatedContentKt.AnimatedContent(numValueOf, null, (Function1) objRememberedValue3, null, "countdown_animation", null, ComposableSingletons$RideRecordingScreenKt.INSTANCE.getLambda$32645641$app(), composer, 1597824, 42);
        SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(52.0f)), composer, 6);
        Modifier modifierM225backgroundbw27NRU$default2 = BackgroundKt.m225backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.getCircleShape()), Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
        ComposerKt.sourceInformationMarkerStart(composer, 725702837, "CC(remember):RideRecordingScreen.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(context);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = new Function0() { // from class: com.example.ui.screens.RideRecordingScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return RideRecordingScreenKt.RideRecordingScreen$lambda$74$lambda$73$lambda$72$lambda$71$lambda$69$lambda$68(context, mutableState);
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierM671paddingVpY3zN4 = PaddingKt.m671paddingVpY3zN4(ClickableKt.m258clickableXHw0xAI$default(modifierM225backgroundbw27NRU$default2, false, null, null, (Function0) objRememberedValue4, 7, null), Dp.m6261constructorimpl(24.0f), Dp.m6261constructorimpl(10.0f));
        Alignment center3 = Alignment.INSTANCE.getCenter();
        ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
        ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierM671paddingVpY3zN4);
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
        Updater.m3320setimpl(composerM3313constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3320setimpl(composerM3313constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM3313constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
            composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
        }
        Updater.m3320setimpl(composerM3313constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 652855677, "C572@24543L249:RideRecordingScreen.kt#2thlc2");
        TextKt.m2354Text4IGK_g("跳过倒计时", (Modifier) null, Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.85f, 0.0f, 0.0f, 0.0f, 14, null), TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 200070, 0, 131026);
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
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    static final ContentTransform RideRecordingScreen$lambda$74$lambda$73$lambda$72$lambda$71$lambda$67$lambda$66(AnimatedContentTransitionScope AnimatedContent) {
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.m65scaleInL8ZKhE$default(null, 0.5f, 0L, 5, null)), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.m67scaleOutL8ZKhE$default(null, 1.5f, 0L, 5, null)));
    }

    static final Unit RideRecordingScreen$lambda$74$lambda$73$lambda$72$lambda$71$lambda$69$lambda$68(Context context, MutableState mutableState) {
        RideRecordingScreen$lambda$8(mutableState, false);
        RideTrackingManager.INSTANCE.startRecording(context);
        return Unit.INSTANCE;
    }

    private static final long RideRecordingScreen$lambda$12(State<Long> state) {
        return state.getValue().longValue();
    }

    private static final double RideRecordingScreen$lambda$13(State<Double> state) {
        return state.getValue().doubleValue();
    }

    private static final double RideRecordingScreen$lambda$14(State<Double> state) {
        return state.getValue().doubleValue();
    }

    private static final double RideRecordingScreen$lambda$15(State<Double> state) {
        return state.getValue().doubleValue();
    }

    private static final double RideRecordingScreen$lambda$16(State<Double> state) {
        return state.getValue().doubleValue();
    }

    private static final double RideRecordingScreen$lambda$17(State<Double> state) {
        return state.getValue().doubleValue();
    }

    private static final double RideRecordingScreen$lambda$18(State<Double> state) {
        return state.getValue().doubleValue();
    }

    private static final boolean RideRecordingScreen$lambda$19(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final float RideRecordingScreen$lambda$26(State<Float> state) {
        return state.getValue().floatValue();
    }
}
