package com.example;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationConstants;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.view.PointerIconCompat;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.Navigator;
import androidx.navigation.PopUpToBuilder;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import com.example.data.db.AppDatabase;
import com.example.data.db.RideRepository;
import com.example.ui.screens.HomeScreenKt;
import com.example.ui.screens.RideHistoryScreenKt;
import com.example.ui.screens.RideRecordingScreenKt;
import com.example.ui.theme.GlassComponentsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003²\u0006\n\u0010\u0004\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\f\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u008a\u0084\u0002"}, d2 = {"SummitPathApp", "", "(Landroidx/compose/runtime/Composer;I)V", "app", "savedMapModeStr", "", "navBackStackEntry", "Landroidx/navigation/NavBackStackEntry;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MainActivityKt {
    static final int SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$22$lambda$21(int i) {
        return i;
    }

    static final int SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$24$lambda$23(int i) {
        return i;
    }

    static final int SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$26$lambda$25(int i) {
        return i;
    }

    static final int SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$28$lambda$27(int i) {
        return i;
    }

    static final Unit SummitPathApp$lambda$59(int i, Composer composer, int i2) {
        SummitPathApp(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SummitPathApp(Composer composer, final int i) {
        String route;
        Composer composer2;
        NavDestination destination;
        Composer composerStartRestartGroup = composer.startRestartGroup(1975034778);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SummitPathApp)62@2298L7,63@2325L45,64@2392L53,65@2470L23,67@2517L76,68@2621L140,72@2797L511,72@2767L541,86@3421L30,90@3599L3932:MainActivity.kt#to5c3");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1975034778, i, -1, "com.example.SummitPathApp (MainActivity.kt:61)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -367120185, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = AppDatabase.INSTANCE.getInstance(context);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            AppDatabase appDatabase = (AppDatabase) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -367118033, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new RideRepository(appDatabase.rideRecordDao());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final RideRepository rideRepository = (RideRepository) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final NavHostController navHostControllerRememberNavController = NavHostControllerKt.rememberNavController(new Navigator[0], composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -367114010, "CC(remember):MainActivity.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(context);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = PreferenceManager.getDefaultSharedPreferences(context);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final SharedPreferences sharedPreferences = (SharedPreferences) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -367110618, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                String string = sharedPreferences.getString("user_selected_map_mode", "DARK_SLATE");
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(string != null ? string : "DARK_SLATE", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState = (MutableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -367104615, "CC(remember):MainActivity.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(sharedPreferences);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MainActivityKt.SummitPathApp$lambda$9$lambda$8(sharedPreferences, mutableState, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(sharedPreferences, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue5, composerStartRestartGroup, 0);
            boolean zAreEqual = Intrinsics.areEqual(SummitPathApp$lambda$4(mutableState), "LIGHT_STANDARD");
            NavBackStackEntry navBackStackEntrySummitPathApp$lambda$10 = SummitPathApp$lambda$10(NavHostControllerKt.currentBackStackEntryAsState(navHostControllerRememberNavController, composerStartRestartGroup, 0));
            if (navBackStackEntrySummitPathApp$lambda$10 == null || (destination = navBackStackEntrySummitPathApp$lambda$10.getDestination()) == null || (route = destination.getRoute()) == null) {
                route = "home";
            }
            boolean z = Intrinsics.areEqual(route, "home") || Intrinsics.areEqual(route, "history");
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -70372630, "C95@3795L2971,91@3648L3118:MainActivity.kt#to5c3");
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2075943695, "CC(remember):MainActivity.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(navHostControllerRememberNavController) | composerStartRestartGroup.changedInstance(rideRepository);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49(navHostControllerRememberNavController, rideRepository, (NavGraphBuilder) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            Function1 function1 = (Function1) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final String str = route;
            composer2 = composerStartRestartGroup;
            NavHostKt.NavHost(navHostControllerRememberNavController, "home", modifierFillMaxSize$default2, null, null, null, null, null, null, null, function1, composer2, 432, 0, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
            if (z) {
                composer2.startReplaceGroup(-67353169);
                ComposerKt.sourceInformation(composer2, "171@6894L239,178@7171L224,169@6804L711");
                ComposerKt.sourceInformationMarkerStart(composer2, 2076040131, "CC(remember):MainActivity.kt#9igjgp");
                boolean zChanged2 = composer2.changed(str) | composer2.changedInstance(navHostControllerRememberNavController);
                Object objRememberedValue7 = composer2.rememberedValue();
                if (zChanged2 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MainActivityKt.SummitPathApp$lambda$58$lambda$54$lambda$53(str, navHostControllerRememberNavController);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                Function0 function0 = (Function0) objRememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, 2076048980, "CC(remember):MainActivity.kt#9igjgp");
                boolean zChanged3 = composer2.changed(str) | composer2.changedInstance(navHostControllerRememberNavController);
                Object objRememberedValue8 = composer2.rememberedValue();
                if (zChanged3 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue8 = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MainActivityKt.SummitPathApp$lambda$58$lambda$57$lambda$56(str, navHostControllerRememberNavController);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                GlassComponentsKt.LiquidDock(str, function0, (Function0) objRememberedValue8, zAreEqual, boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomCenter()), composer2, 0, 0);
            } else {
                composer2.startReplaceGroup(-74112626);
            }
            composer2.endReplaceGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivityKt.SummitPathApp$lambda$59(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String SummitPathApp$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    static final DisposableEffectResult SummitPathApp$lambda$9$lambda$8(final SharedPreferences sharedPreferences, final MutableState mutableState, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda16
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                MainActivityKt.SummitPathApp$lambda$9$lambda$8$lambda$6(mutableState, sharedPreferences2, str);
            }
        };
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        return new DisposableEffectResult() { // from class: com.example.MainActivityKt$SummitPathApp$lambda$9$lambda$8$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            }
        };
    }

    static final void SummitPathApp$lambda$9$lambda$8$lambda$6(MutableState mutableState, SharedPreferences sharedPreferences, String str) {
        if (!Intrinsics.areEqual(str, "user_selected_map_mode") || sharedPreferences == null) {
            return;
        }
        String string = sharedPreferences.getString("user_selected_map_mode", "DARK_SLATE");
        mutableState.setValue(string != null ? string : "DARK_SLATE");
    }

    static final Unit SummitPathApp$lambda$58$lambda$50$lambda$49(final NavHostController navHostController, final RideRepository rideRepository, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        NavGraphBuilderKt.composable$default(NavHost, "home", null, null, new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$11((AnimatedContentTransitionScope) obj);
            }
        }, new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda39
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$12((AnimatedContentTransitionScope) obj);
            }
        }, new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda40
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$13((AnimatedContentTransitionScope) obj);
            }
        }, new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$14((AnimatedContentTransitionScope) obj);
            }
        }, null, ComposableLambdaKt.composableLambdaInstance(1210527633, true, new Function4() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$20(navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 134, null);
        NavGraphBuilderKt.composable$default(NavHost, "recording", null, null, new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$22((AnimatedContentTransitionScope) obj);
            }
        }, new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$24((AnimatedContentTransitionScope) obj);
            }
        }, new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$26((AnimatedContentTransitionScope) obj);
            }
        }, new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$28((AnimatedContentTransitionScope) obj);
            }
        }, null, ComposableLambdaKt.composableLambdaInstance(-1663792006, true, new Function4() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$39(rideRepository, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 134, null);
        NavGraphBuilderKt.composable$default(NavHost, "history", null, null, new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$40((AnimatedContentTransitionScope) obj);
            }
        }, new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$41((AnimatedContentTransitionScope) obj);
            }
        }, new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$42((AnimatedContentTransitionScope) obj);
            }
        }, new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda37
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$43((AnimatedContentTransitionScope) obj);
            }
        }, null, ComposableLambdaKt.composableLambdaInstance(-1409402599, true, new Function4() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$48(rideRepository, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 134, null);
        return Unit.INSTANCE;
    }

    static final EnterTransition SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$11(AnimatedContentTransitionScope composable) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        return EnterTransition.INSTANCE.getNone();
    }

    static final ExitTransition SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$12(AnimatedContentTransitionScope composable) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        return ExitTransition.INSTANCE.getNone();
    }

    static final EnterTransition SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$13(AnimatedContentTransitionScope composable) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        return EnterTransition.INSTANCE.getNone();
    }

    static final ExitTransition SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$14(AnimatedContentTransitionScope composable) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        return ExitTransition.INSTANCE.getNone();
    }

    static final Unit SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$20(final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "C104@4181L83,107@4306L153,103@4126L351:MainActivity.kt#to5c3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1210527633, i, -1, "com.example.SummitPathApp.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:103)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -619079484, "CC(remember):MainActivity.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(navHostController);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$20$lambda$16$lambda$15(navHostController);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function0 function0 = (Function0) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -619075414, "CC(remember):MainActivity.kt#9igjgp");
        boolean zChangedInstance2 = composer.changedInstance(navHostController);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$20$lambda$19$lambda$18(navHostController);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        HomeScreenKt.HomeScreen(function0, (Function0) objRememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$20$lambda$16$lambda$15(NavHostController navHostController) {
        NavController.navigate$default((NavController) navHostController, "recording", (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    static final Unit SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$20$lambda$19$lambda$18(NavHostController navHostController) {
        navHostController.navigate("history", new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$20$lambda$19$lambda$18$lambda$17((NavOptionsBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    static final Unit SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$20$lambda$19$lambda$18$lambda$17(NavOptionsBuilder navigate) {
        Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
        NavOptionsBuilder.popUpTo$default(navigate, "home", (Function1) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    static final EnterTransition SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$22(AnimatedContentTransitionScope composable) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        return EnterExitTransitionKt.slideInVertically(AnimationSpecKt.tween$default(400, 0, null, 6, null), new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$22$lambda$21(((Integer) obj).intValue()));
            }
        }).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(AnimationConstants.DefaultDurationMillis, 0, null, 6, null), 0.0f, 2, null));
    }

    static final ExitTransition SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$24(AnimatedContentTransitionScope composable) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        return EnterExitTransitionKt.slideOutVertically(AnimationSpecKt.tween$default(400, 0, null, 6, null), new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$24$lambda$23(((Integer) obj).intValue()));
            }
        }).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(AnimationConstants.DefaultDurationMillis, 0, null, 6, null), 0.0f, 2, null));
    }

    static final EnterTransition SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$26(AnimatedContentTransitionScope composable) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        return EnterExitTransitionKt.slideInVertically(AnimationSpecKt.tween$default(400, 0, null, 6, null), new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$26$lambda$25(((Integer) obj).intValue()));
            }
        }).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(AnimationConstants.DefaultDurationMillis, 0, null, 6, null), 0.0f, 2, null));
    }

    static final ExitTransition SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$28(AnimatedContentTransitionScope composable) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        return EnterExitTransitionKt.slideOutVertically(AnimationSpecKt.tween$default(400, 0, null, 6, null), new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$28$lambda$27(((Integer) obj).intValue()));
            }
        }).plus(EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(AnimationConstants.DefaultDurationMillis, 0, null, 6, null), 0.0f, 2, null));
    }

    static final Unit SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$39(RideRepository rideRepository, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "C132@5513L168,137@5720L171,142@5933L153,130@5411L693:MainActivity.kt#to5c3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1663792006, i, -1, "com.example.SummitPathApp.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:130)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1176279646, "CC(remember):MainActivity.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(navHostController);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$39$lambda$31$lambda$30(navHostController, ((Long) obj).longValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function1 function1 = (Function1) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1176273019, "CC(remember):MainActivity.kt#9igjgp");
        boolean zChangedInstance2 = composer.changedInstance(navHostController);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$39$lambda$35$lambda$34(navHostController);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        Function0 function0 = (Function0) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1176266221, "CC(remember):MainActivity.kt#9igjgp");
        boolean zChangedInstance3 = composer.changedInstance(navHostController);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$39$lambda$38$lambda$37(navHostController);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        RideRecordingScreenKt.RideRecordingScreen(rideRepository, function1, function0, (Function0) objRememberedValue3, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$39$lambda$31$lambda$30(NavHostController navHostController, long j) {
        navHostController.navigate("history", new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$39$lambda$31$lambda$30$lambda$29((NavOptionsBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    static final Unit SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$39$lambda$31$lambda$30$lambda$29(NavOptionsBuilder navigate) {
        Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
        NavOptionsBuilder.popUpTo$default(navigate, "home", (Function1) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    static final Unit SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$39$lambda$35$lambda$34(NavHostController navHostController) {
        navHostController.navigate("home", new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$39$lambda$35$lambda$34$lambda$33((NavOptionsBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    static final Unit SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$39$lambda$35$lambda$34$lambda$33(NavOptionsBuilder navigate) {
        Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
        navigate.popUpTo("home", new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$39$lambda$35$lambda$34$lambda$33$lambda$32((PopUpToBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    static final Unit SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$39$lambda$35$lambda$34$lambda$33$lambda$32(PopUpToBuilder popUpTo) {
        Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
        popUpTo.setInclusive(true);
        return Unit.INSTANCE;
    }

    static final Unit SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$39$lambda$38$lambda$37(NavHostController navHostController) {
        navHostController.navigate("history", new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$39$lambda$38$lambda$37$lambda$36((NavOptionsBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    static final Unit SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$39$lambda$38$lambda$37$lambda$36(NavOptionsBuilder navigate) {
        Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
        NavOptionsBuilder.popUpTo$default(navigate, "home", (Function1) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    static final EnterTransition SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$40(AnimatedContentTransitionScope composable) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        return EnterTransition.INSTANCE.getNone();
    }

    static final ExitTransition SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$41(AnimatedContentTransitionScope composable) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        return ExitTransition.INSTANCE.getNone();
    }

    static final EnterTransition SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$42(AnimatedContentTransitionScope composable) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        return EnterTransition.INSTANCE.getNone();
    }

    static final ExitTransition SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$43(AnimatedContentTransitionScope composable) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        return ExitTransition.INSTANCE.getNone();
    }

    static final Unit SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$48(RideRepository rideRepository, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "C159@6553L171,157@6452L290:MainActivity.kt#to5c3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1409402599, i, -1, "com.example.SummitPathApp.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:157)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1521195420, "CC(remember):MainActivity.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(navHostController);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$48$lambda$47$lambda$46(navHostController);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        RideHistoryScreenKt.RideHistoryScreen(rideRepository, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$48$lambda$47$lambda$46(NavHostController navHostController) {
        navHostController.navigate("home", new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$48$lambda$47$lambda$46$lambda$45((NavOptionsBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    static final Unit SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$48$lambda$47$lambda$46$lambda$45(NavOptionsBuilder navigate) {
        Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
        navigate.popUpTo("home", new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivityKt.SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$48$lambda$47$lambda$46$lambda$45$lambda$44((PopUpToBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    static final Unit SummitPathApp$lambda$58$lambda$50$lambda$49$lambda$48$lambda$47$lambda$46$lambda$45$lambda$44(PopUpToBuilder popUpTo) {
        Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
        popUpTo.setInclusive(true);
        return Unit.INSTANCE;
    }

    static final Unit SummitPathApp$lambda$58$lambda$54$lambda$53(String str, NavHostController navHostController) {
        if (!Intrinsics.areEqual(str, "home")) {
            navHostController.navigate("home", new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MainActivityKt.SummitPathApp$lambda$58$lambda$54$lambda$53$lambda$52((NavOptionsBuilder) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    static final Unit SummitPathApp$lambda$58$lambda$54$lambda$53$lambda$52(NavOptionsBuilder navigate) {
        Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
        navigate.popUpTo("home", new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivityKt.SummitPathApp$lambda$58$lambda$54$lambda$53$lambda$52$lambda$51((PopUpToBuilder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    static final Unit SummitPathApp$lambda$58$lambda$54$lambda$53$lambda$52$lambda$51(PopUpToBuilder popUpTo) {
        Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
        popUpTo.setInclusive(true);
        return Unit.INSTANCE;
    }

    static final Unit SummitPathApp$lambda$58$lambda$57$lambda$56(String str, NavHostController navHostController) {
        if (!Intrinsics.areEqual(str, "history")) {
            navHostController.navigate("history", new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MainActivityKt.SummitPathApp$lambda$58$lambda$57$lambda$56$lambda$55((NavOptionsBuilder) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    static final Unit SummitPathApp$lambda$58$lambda$57$lambda$56$lambda$55(NavOptionsBuilder navigate) {
        Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
        NavOptionsBuilder.popUpTo$default(navigate, "home", (Function1) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    private static final NavBackStackEntry SummitPathApp$lambda$10(State<NavBackStackEntry> state) {
        return state.getValue();
    }
}
