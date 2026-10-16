package com.example.ui.map;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.DirectionsBikeKt;
import androidx.compose.material.icons.filled.MapKt;
import androidx.compose.material.icons.filled.NavigationKt;
import androidx.compose.material.icons.filled.PublicKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
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
import androidx.compose.ui.window.AndroidDialog_androidKt;
import com.example.util.LocationSearchRepository;
import com.example.util.NavigationLauncher;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.osmdroid.util.GeoPoint;

/* JADX INFO: compiled from: NavigationChoiceModal.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\n\u001aE\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"NavigationChoiceModal", "", "destinationName", "", "destinationPoint", "Lorg/osmdroid/util/GeoPoint;", "distanceMeters", "", "onDismiss", "Lkotlin/Function0;", "(Ljava/lang/String;Lorg/osmdroid/util/GeoPoint;Ljava/lang/Double;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "NavEngineOptionCard", LinkHeader.Parameters.Title, "subtitle", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "accentColor", "Landroidx/compose/ui/graphics/Color;", "tag", "onClick", "NavEngineOptionCard-uDo3WH8", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;JLjava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NavigationChoiceModalKt {
    static final Unit NavEngineOptionCard_uDo3WH8$lambda$24(String str, String str2, ImageVector imageVector, long j, String str3, Function0 function0, int i, Composer composer, int i2) {
        m6628NavEngineOptionCarduDo3WH8(str, str2, imageVector, j, str3, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit NavigationChoiceModal$lambda$19(String str, GeoPoint geoPoint, Double d, Function0 function0, int i, Composer composer, int i2) {
        NavigationChoiceModal(str, geoPoint, d, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00a6  */
    public static final void NavigationChoiceModal(final String destinationName, final GeoPoint destinationPoint, final Double d, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        String distance;
        Composer composer2;
        Intrinsics.checkNotNullParameter(destinationName, "destinationName");
        Intrinsics.checkNotNullParameter(destinationPoint, "destinationPoint");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerStartRestartGroup = composer.startRestartGroup(-970662684);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationChoiceModal)39@1539L7,42@1687L7774,42@1650L7811:NavigationChoiceModal.kt#8v18gj");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(destinationName) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(destinationPoint) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(d) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDismiss) ? 2048 : 1024;
        }
        int i3 = i2;
        if ((i3 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-970662684, i3, -1, "com.example.ui.map.NavigationChoiceModal (NavigationChoiceModal.kt:38)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Context context = (Context) objConsume;
            if (d != null) {
                distance = LocationSearchRepository.INSTANCE.formatDistance(d.doubleValue());
                if (distance == null) {
                    distance = "";
                }
            } else {
                distance = "";
            }
            final String str = distance;
            composer2 = composerStartRestartGroup;
            AndroidDialog_androidKt.Dialog(onDismiss, null, ComposableLambdaKt.rememberComposableLambda(1670131821, true, new Function2() { // from class: com.example.ui.map.NavigationChoiceModalKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationChoiceModalKt.NavigationChoiceModal$lambda$18(onDismiss, str, destinationName, context, destinationPoint, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, ((i3 >> 9) & 14) | 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.map.NavigationChoiceModalKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationChoiceModalKt.NavigationChoiceModal$lambda$19(destinationName, destinationPoint, d, onDismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit NavigationChoiceModal$lambda$18(final Function0 function0, final String str, final String str2, final Context context, final GeoPoint geoPoint, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C51@2012L7443,43@1697L7758:NavigationChoiceModal.kt#8v18gj");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1670131821, i, -1, "com.example.ui.map.NavigationChoiceModal.<anonymous> (NavigationChoiceModal.kt:43)");
            }
            SurfaceKt.m2204SurfaceT9BRK9s(PaddingKt.m670padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6261constructorimpl(12.0f)), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6261constructorimpl(24.0f)), ColorKt.Color(4279244582L), 0L, Dp.m6261constructorimpl(8.0f), 0.0f, BorderStrokeKt.m252BorderStrokecXLIe8U(Dp.m6261constructorimpl(1.0f), Color.m3819copywmQWz5c$default(ColorKt.Color(4278248959L), 0.4f, 0.0f, 0.0f, 0.0f, 14, null)), ComposableLambdaKt.rememberComposableLambda(1339385202, true, new Function2() { // from class: com.example.ui.map.NavigationChoiceModalKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationChoiceModalKt.NavigationChoiceModal$lambda$18$lambda$17(function0, str, str2, context, geoPoint, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 14180742, 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit NavigationChoiceModal$lambda$18$lambda$17(final Function0 function0, final String str, final String str2, final Context context, final GeoPoint geoPoint, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C52@2026L7419:NavigationChoiceModal.kt#8v18gj");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1339385202, i, -1, "com.example.ui.map.NavigationChoiceModal.<anonymous>.<anonymous> (NavigationChoiceModal.kt:52)");
            }
            Modifier modifierM670padding3ABfNKs = PaddingKt.m670padding3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(20.0f));
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM670padding3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composer, 195235363, "C56@2143L1364,88@3525L41,96@3885L1892,91@3620L2157,137@5795L41,139@5854L239,147@6149L3282:NavigationChoiceModal.kt#8v18gj");
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
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
            Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1552746915, "C61@2381L689,76@3091L398:NavigationChoiceModal.kt#8v18gj");
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, companion);
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
            Updater.m3320setimpl(composerM3313constructorimpl3, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3320setimpl(composerM3313constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 187926118, "C62@2459L268,68@2752L39,69@2816L232:NavigationChoiceModal.kt#8v18gj");
            IconKt.m1811Iconww6aTOc(NavigationKt.getNavigation(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(24.0f)), ColorKt.Color(4278248959L), composer, 3504, 0);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(8.0f)), composer, 6);
            TextKt.m2354Text4IGK_g("选择专业导航地图引擎", (Modifier) null, Color.INSTANCE.m3857getWhite0d7_KjU(), TextUnitKt.getSp(18), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 200070, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton(function0, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(24.0f)), false, null, null, ComposableSingletons$NavigationChoiceModalKt.INSTANCE.getLambda$1075251433$app(), composer, 196656, 28);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(10.0f)), composer, 6);
            long jColor = ColorKt.Color(4279771960L);
            SurfaceKt.m2204SurfaceT9BRK9s(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6261constructorimpl(16.0f)), jColor, 0L, 0.0f, 0.0f, BorderStrokeKt.m252BorderStrokecXLIe8U(Dp.m6261constructorimpl(1.0f), Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null)), ComposableLambdaKt.rememberComposableLambda(737956611, true, new Function2() { // from class: com.example.ui.map.NavigationChoiceModalKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationChoiceModalKt.NavigationChoiceModal$lambda$18$lambda$17$lambda$16$lambda$6(str, str2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 14156166, 56);
            SpacerKt.Spacer(SizeKt.m701height3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(16.0f)), composer, 6);
            TextKt.m2354Text4IGK_g("唤起专业地图导航APP，享受精准实时语音巡航：", PaddingKt.m674paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6261constructorimpl(12.0f), 7, null), Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 3510, 0, 131056);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_4 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(10.0f));
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_4, Alignment.INSTANCE.getStart(), composer, 6);
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
            Updater.m3320setimpl(composerM3313constructorimpl4, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                composerM3313constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composerM3313constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3320setimpl(composerM3313constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -445859319, "C158@6703L370,152@6377L718,176@7466L370,170@7160L698,194@8238L372,188@7925L707,212@9021L370,206@8705L708:NavigationChoiceModal.kt#8v18gj");
            ImageVector directionsBike = DirectionsBikeKt.getDirectionsBike(Icons.INSTANCE.getDefault());
            long jColor2 = ColorKt.Color(4278248959L);
            ComposerKt.sourceInformationMarkerStart(composer, 816909200, "CC(remember):NavigationChoiceModal.kt#9igjgp");
            boolean zChanged = composer.changed(function0) | composer.changedInstance(context) | composer.changedInstance(geoPoint) | composer.changed(str2);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.ui.map.NavigationChoiceModalKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NavigationChoiceModalKt.NavigationChoiceModal$lambda$18$lambda$17$lambda$16$lambda$15$lambda$8$lambda$7(function0, context, geoPoint, str2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m6628NavEngineOptionCarduDo3WH8("高德地图 (推荐)", "高精度实时语音骑行导航 / 车道级指引", directionsBike, jColor2, "gaode_map_option", (Function0) objRememberedValue, composer, 27702);
            ImageVector map = MapKt.getMap(Icons.INSTANCE.getDefault());
            long jColor3 = ColorKt.Color(4294922834L);
            ComposerKt.sourceInformationMarkerStart(composer, 816933616, "CC(remember):NavigationChoiceModal.kt#9igjgp");
            boolean zChanged2 = composer.changed(function0) | composer.changedInstance(context) | composer.changedInstance(geoPoint) | composer.changed(str2);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.example.ui.map.NavigationChoiceModalKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NavigationChoiceModalKt.NavigationChoiceModal$lambda$18$lambda$17$lambda$16$lambda$15$lambda$10$lambda$9(function0, context, geoPoint, str2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m6628NavEngineOptionCarduDo3WH8("百度地图", "实时精准路线规划 / 骑行导航", map, jColor3, "baidu_map_option", (Function0) objRememberedValue2, composer, 27702);
            ImageVector navigation = NavigationKt.getNavigation(Icons.INSTANCE.getDefault());
            long jColor4 = ColorKt.Color(4283215696L);
            ComposerKt.sourceInformationMarkerStart(composer, 816958322, "CC(remember):NavigationChoiceModal.kt#9igjgp");
            boolean zChanged3 = composer.changed(function0) | composer.changedInstance(context) | composer.changedInstance(geoPoint) | composer.changed(str2);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.example.ui.map.NavigationChoiceModalKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NavigationChoiceModalKt.NavigationChoiceModal$lambda$18$lambda$17$lambda$16$lambda$15$lambda$12$lambda$11(function0, context, geoPoint, str2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m6628NavEngineOptionCarduDo3WH8("腾讯地图", "精准绿道 / 街区导航指引", navigation, jColor4, "tencent_map_option", (Function0) objRememberedValue3, composer, 27702);
            ImageVector imageVector = PublicKt.getPublic(Icons.INSTANCE.getDefault());
            long jColor5 = ColorKt.Color(4294951175L);
            ComposerKt.sourceInformationMarkerStart(composer, 816983376, "CC(remember):NavigationChoiceModal.kt#9igjgp");
            boolean zChanged4 = composer.changed(function0) | composer.changedInstance(context) | composer.changedInstance(geoPoint) | composer.changed(str2);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.example.ui.map.NavigationChoiceModalKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NavigationChoiceModalKt.NavigationChoiceModal$lambda$18$lambda$17$lambda$16$lambda$15$lambda$14$lambda$13(function0, context, geoPoint, str2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m6628NavEngineOptionCarduDo3WH8("高德网页高精度导航", "无需下载APP，浏览器即开即用语音导航", imageVector, jColor5, "web_map_option", (Function0) objRememberedValue4, composer, 27702);
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

    static final Unit NavigationChoiceModal$lambda$18$lambda$17$lambda$16$lambda$6(final String str, String str2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C97@3907L1852:NavigationChoiceModal.kt#8v18gj");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(737956611, i, -1, "com.example.ui.map.NavigationChoiceModal.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NavigationChoiceModal.kt:97)");
            }
            Modifier modifierM670padding3ABfNKs = PaddingKt.m670padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6261constructorimpl(14.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM670padding3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1924036297, "C104@4238L654:NavigationChoiceModal.kt#8v18gj");
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 47885931, "C105@4307L202,110@4538L328:NavigationChoiceModal.kt#8v18gj");
            TextKt.m2354Text4IGK_g("目的地", (Modifier) null, Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 3462, 0, 131058);
            TextKt.m2354Text4IGK_g(str2, PaddingKt.m674paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6261constructorimpl(2.0f), 0.0f, 0.0f, 13, null), Color.INSTANCE.m3857getWhite0d7_KjU(), TextUnitKt.getSp(16), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 200112, 0, 131024);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (str.length() > 0) {
                composer.startReplaceGroup(1924720528);
                ComposerKt.sourceInformation(composer, "124@5261L450,120@4980L731");
                long jM3819copywmQWz5c$default = Color.m3819copywmQWz5c$default(ColorKt.Color(4294951175L), 0.2f, 0.0f, 0.0f, 0.0f, 14, null);
                SurfaceKt.m2204SurfaceT9BRK9s(null, RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6261constructorimpl(8.0f)), jM3819copywmQWz5c$default, 0L, 0.0f, 0.0f, BorderStrokeKt.m252BorderStrokecXLIe8U(Dp.m6261constructorimpl(1.0f), Color.m3819copywmQWz5c$default(ColorKt.Color(4294951175L), 0.5f, 0.0f, 0.0f, 0.0f, 14, null)), ComposableLambdaKt.rememberComposableLambda(1193319465, true, new Function2() { // from class: com.example.ui.map.NavigationChoiceModalKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationChoiceModalKt.NavigationChoiceModal$lambda$18$lambda$17$lambda$16$lambda$6$lambda$5$lambda$4(str, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, 14156160, 57);
            } else {
                composer.startReplaceGroup(1919784739);
            }
            composer.endReplaceGroup();
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

    static final Unit NavigationChoiceModal$lambda$18$lambda$17$lambda$16$lambda$6$lambda$5$lambda$4(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C125@5295L386:NavigationChoiceModal.kt#8v18gj");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1193319465, i, -1, "com.example.ui.map.NavigationChoiceModal.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NavigationChoiceModal.kt:125)");
            }
            TextKt.m2354Text4IGK_g("距 " + str, PaddingKt.m671paddingVpY3zN4(Modifier.INSTANCE, Dp.m6261constructorimpl(10.0f), Dp.m6261constructorimpl(5.0f)), ColorKt.Color(4294951175L), TextUnitKt.getSp(12), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 200112, 0, 131024);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit NavigationChoiceModal$lambda$18$lambda$17$lambda$16$lambda$15$lambda$8$lambda$7(Function0 function0, Context context, GeoPoint geoPoint, String str) {
        function0.invoke();
        NavigationLauncher.INSTANCE.openGaodeMapNavi(context, geoPoint.getLatitude(), geoPoint.getLongitude(), str);
        return Unit.INSTANCE;
    }

    static final Unit NavigationChoiceModal$lambda$18$lambda$17$lambda$16$lambda$15$lambda$10$lambda$9(Function0 function0, Context context, GeoPoint geoPoint, String str) {
        function0.invoke();
        NavigationLauncher.INSTANCE.openBaiduMapNavi(context, geoPoint.getLatitude(), geoPoint.getLongitude(), str);
        return Unit.INSTANCE;
    }

    static final Unit NavigationChoiceModal$lambda$18$lambda$17$lambda$16$lambda$15$lambda$12$lambda$11(Function0 function0, Context context, GeoPoint geoPoint, String str) {
        function0.invoke();
        NavigationLauncher.INSTANCE.openTencentMapNavi(context, geoPoint.getLatitude(), geoPoint.getLongitude(), str);
        return Unit.INSTANCE;
    }

    static final Unit NavigationChoiceModal$lambda$18$lambda$17$lambda$16$lambda$15$lambda$14$lambda$13(Function0 function0, Context context, GeoPoint geoPoint, String str) {
        function0.invoke();
        NavigationLauncher.INSTANCE.openGaodeWebNavi(context, geoPoint.getLatitude(), geoPoint.getLongitude(), str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: NavEngineOptionCard-uDo3WH8, reason: not valid java name */
    private static final void m6628NavEngineOptionCarduDo3WH8(final String str, final String str2, final ImageVector imageVector, final long j, final String str3, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1128088119);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavEngineOptionCard)P(5,3,1,0:c#ui.graphics.Color,4)237@9647L1595:NavigationChoiceModal.kt#8v18gj");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(imageVector) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(str3) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        int i3 = i2;
        if ((74899 & i3) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1128088119, i3, -1, "com.example.ui.map.NavEngineOptionCard (NavigationChoiceModal.kt:236)");
            }
            Modifier modifierTestTag = TestTagKt.testTag(PaddingKt.m671paddingVpY3zN4(ClickableKt.m258clickableXHw0xAI$default(BorderKt.m236borderxT4_qwU(BackgroundKt.m225backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6261constructorimpl(14.0f))), Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.06f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m6261constructorimpl(1.0f), Color.m3819copywmQWz5c$default(j, 0.35f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6261constructorimpl(14.0f))), false, null, null, function0, 7, null), Dp.m6261constructorimpl(14.0f), Dp.m6261constructorimpl(12.0f)), str3);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
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
            Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2097729093, "C252@10244L300,248@10095L449,263@10554L40,265@10604L440,280@11054L182:NavigationChoiceModal.kt#8v18gj");
            SurfaceKt.m2204SurfaceT9BRK9s(SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(40.0f)), RoundedCornerShapeKt.getCircleShape(), Color.m3819copywmQWz5c$default(j, 0.18f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(904821464, true, new Function2() { // from class: com.example.ui.map.NavigationChoiceModalKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationChoiceModalKt.NavEngineOptionCard_uDo3WH8$lambda$23$lambda$21(imageVector, str, j, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582918, MenuKt.InTransitionDuration);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(12.0f)), composerStartRestartGroup, 6);
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -26331475, "C266@10657L165,272@10835L199:NavigationChoiceModal.kt#8v18gj");
            composer2 = composerStartRestartGroup;
            TextKt.m2354Text4IGK_g(str, (Modifier) null, Color.INSTANCE.m3857getWhite0d7_KjU(), TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, (i3 & 14) | 200064, 0, 131026);
            TextKt.m2354Text4IGK_g(str2, PaddingKt.m674paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6261constructorimpl(2.0f), 0.0f, 0.0f, 13, null), Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.55f, 0.0f, 0.0f, 0.0f, 14, null), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, ((i3 >> 3) & 14) | 3504, 0, 131056);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            IconKt.m1811Iconww6aTOc(NavigationKt.getNavigation(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(16.0f)), j, composer2, (i3 & 7168) | 432, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.map.NavigationChoiceModalKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationChoiceModalKt.NavEngineOptionCard_uDo3WH8$lambda$24(str, str2, imageVector, j, str3, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit NavEngineOptionCard_uDo3WH8$lambda$23$lambda$21(ImageVector imageVector, String str, long j, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C253@10258L276:NavigationChoiceModal.kt#8v18gj");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(904821464, i, -1, "com.example.ui.map.NavEngineOptionCard.<anonymous>.<anonymous> (NavigationChoiceModal.kt:253)");
            }
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1085058630, "C254@10317L203:NavigationChoiceModal.kt#8v18gj");
            IconKt.m1811Iconww6aTOc(imageVector, str, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(20.0f)), j, composer, 384, 0);
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
}
