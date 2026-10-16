package com.example.ui.map;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.unit.Dp;
import com.example.ui.theme.ColorKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MapModeSwitchButton.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u001f\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u000f\u001a\u00020\u000eX\u008a\u008e\u0002"}, d2 = {"MapModeSwitchButton", "", "selectedMode", "Lcom/example/ui/map/MapMode;", "onModeSelected", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/example/ui/map/MapMode;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "MapModeIconGraphic", "mode", "(Lcom/example/ui/map/MapMode;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "app", "isExpanded", "", "isAnimating"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MapModeSwitchButtonKt {

    /* JADX INFO: compiled from: MapModeSwitchButton.kt */
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
                iArr[MapMode.DARK_SLATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MapMode.SATELLITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static final Unit MapModeIconGraphic$lambda$25(MapMode mapMode, Modifier modifier, int i, int i2, Composer composer, int i3) {
        MapModeIconGraphic(mapMode, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit MapModeSwitchButton$lambda$19(MapMode mapMode, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        MapModeSwitchButton(mapMode, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0384  */
    /* JADX WARN: Code duplicated, block: B:102:0x0389  */
    /* JADX WARN: Code duplicated, block: B:105:0x03be  */
    /* JADX WARN: Code duplicated, block: B:106:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:109:0x03e3  */
    /* JADX WARN: Code duplicated, block: B:113:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:116:0x048a  */
    /* JADX WARN: Code duplicated, block: B:119:0x0496  */
    /* JADX WARN: Code duplicated, block: B:120:0x049a  */
    /* JADX WARN: Code duplicated, block: B:123:0x04bf  */
    /* JADX WARN: Code duplicated, block: B:125:0x04cd  */
    /* JADX WARN: Code duplicated, block: B:128:0x054e  */
    /* JADX WARN: Code duplicated, block: B:131:0x059f  */
    /* JADX WARN: Code duplicated, block: B:132:0x05a6  */
    /* JADX WARN: Code duplicated, block: B:135:0x05b0  */
    /* JADX WARN: Code duplicated, block: B:136:0x05b5  */
    /* JADX WARN: Code duplicated, block: B:139:0x05f3  */
    /* JADX WARN: Code duplicated, block: B:141:0x05fb  */
    /* JADX WARN: Code duplicated, block: B:144:0x065d  */
    /* JADX WARN: Code duplicated, block: B:147:0x0669  */
    /* JADX WARN: Code duplicated, block: B:148:0x066d  */
    /* JADX WARN: Code duplicated, block: B:151:0x0692  */
    /* JADX WARN: Code duplicated, block: B:153:0x06a0  */
    /* JADX WARN: Code duplicated, block: B:156:0x070c  */
    /* JADX WARN: Code duplicated, block: B:160:0x0717  */
    /* JADX WARN: Code duplicated, block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0077 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0079  */
    /* JADX WARN: Code duplicated, block: B:36:0x007f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0086  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:45:0x00db  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:51:0x0124  */
    /* JADX WARN: Code duplicated, block: B:54:0x0143  */
    /* JADX WARN: Code duplicated, block: B:57:0x018e  */
    /* JADX WARN: Code duplicated, block: B:60:0x019a  */
    /* JADX WARN: Code duplicated, block: B:61:0x019e  */
    /* JADX WARN: Code duplicated, block: B:64:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:66:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:69:0x0216  */
    /* JADX WARN: Code duplicated, block: B:71:0x024b  */
    /* JADX WARN: Code duplicated, block: B:73:0x0253  */
    /* JADX WARN: Code duplicated, block: B:76:0x02af  */
    /* JADX WARN: Code duplicated, block: B:79:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:80:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:83:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:85:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:88:0x0330  */
    /* JADX WARN: Code duplicated, block: B:90:0x0334  */
    /* JADX WARN: Code duplicated, block: B:91:0x0336  */
    /* JADX WARN: Code duplicated, block: B:94:0x0351  */
    /* JADX WARN: Code duplicated, block: B:95:0x0367  */
    /* JADX WARN: Code duplicated, block: B:98:0x0377  */
    /* JADX WARN: Code duplicated, block: B:99:0x037e  */
    public static final void MapModeSwitchButton(MapMode mapMode, final Function1<? super MapMode, Unit> onModeSelected, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Modifier modifier3;
        Object objRememberedValue;
        CoroutineScope coroutineScope;
        Object objRememberedValue2;
        final MutableState mutableState;
        Object objRememberedValue3;
        MutableState mutableState2;
        Object objRememberedValue4;
        final Animatable animatable;
        Object objRememberedValue5;
        Animatable animatable2;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM3313constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        Animatable animatable3;
        Modifier modifier4;
        MutableState mutableState3;
        int i5;
        String str;
        CoroutineScope coroutineScope2;
        float fM6261constructorimpl;
        long jM3819copywmQWz5c$default;
        boolean zChangedInstance;
        Object objRememberedValue6;
        int currentCompositeKeyHash2;
        Function0<ComposeUiNode> constructor2;
        Composer composerM3313constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        MapMode mapMode2;
        final Modifier modifier5;
        boolean zChangedInstance2;
        Object objRememberedValue7;
        int currentCompositeKeyHash3;
        Function0<ComposeUiNode> constructor3;
        String str2;
        Composer composerM3313constructorimpl3;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3;
        MapMode[] mapModeArrValues;
        int length;
        int i6;
        MapMode mapMode3;
        boolean z;
        long jColor;
        float fM6261constructorimpl2;
        long jM3819copywmQWz5c$default2;
        boolean z2;
        boolean zChangedInstance3;
        Object obj;
        final CoroutineScope coroutineScope3;
        final MutableState mutableState4;
        final Animatable animatable4;
        final MapMode mapMode4;
        int currentCompositeKeyHash4;
        Function0<ComposeUiNode> constructor4;
        Composer composerM3313constructorimpl4;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        MapMode selectedMode = mapMode;
        Intrinsics.checkNotNullParameter(selectedMode, "selectedMode");
        Intrinsics.checkNotNullParameter(onModeSelected, "onModeSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(-14288846);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MapModeSwitchButton)P(2,1)43@1469L24,44@1516L34,45@1574L34,47@1635L27,48@1687L27,132@4416L2906:MapModeSwitchButton.kt#8v18gj");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(selectedMode.ordinal()) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onModeSelected) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i3;
            if ((i4 & 147) != 146 && composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.skipToGroupEnd();
                mapMode2 = selectedMode;
                modifier5 = modifier2;
            } else {
                if (i7 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-14288846, i4, -1, "com.example.ui.map.MapModeSwitchButton (MapModeSwitchButton.kt:42)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -954367824, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                    objRememberedValue = compositionScopedCoroutineScopeCanceller;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -846672268, "CC(remember):MapModeSwitchButton.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -846670412, "CC(remember):MapModeSwitchButton.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState2 = (MutableState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -846668467, "CC(remember):MapModeSwitchButton.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                animatable = (Animatable) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -846666803, "CC(remember):MapModeSwitchButton.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                animatable2 = (Animatable) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Alignment bottomCenter = Alignment.INSTANCE.getBottomCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(bottomCenter, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM3313constructorimpl = Updater.m3313constructorimpl(composerStartRestartGroup);
                Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -698066107, "C191@7045L18,180@6577L739:MapModeSwitchButton.kt#8v18gj");
                if (((Number) animatable.getValue()).floatValue() > 0.01f) {
                    composerStartRestartGroup.startReplaceGroup(-698057645);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "141@4823L327,138@4658L1867");
                    Modifier modifierM674paddingqDBjuR0$default = PaddingKt.m674paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6261constructorimpl(58.0f), 7, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -438155821, "CC(remember):MapModeSwitchButton.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(animatable);
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: com.example.ui.map.MapModeSwitchButtonKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return MapModeSwitchButtonKt.MapModeSwitchButton$lambda$18$lambda$9$lambda$8(animatable, (GraphicsLayerScope) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierM674paddingqDBjuR0$default, (Function1) objRememberedValue7);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_4 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(10.0f));
                    Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_4, centerHorizontally, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    str2 = "C73@3429L9:Box.kt#2w3rfo";
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
                    composerM3313constructorimpl3 = Updater.m3313constructorimpl(composerStartRestartGroup);
                    Updater.m3320setimpl(composerM3313constructorimpl3, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3320setimpl(composerM3313constructorimpl3, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM3313constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m3320setimpl(composerM3313constructorimpl3, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1500695713, "C:MapModeSwitchButton.kt#8v18gj");
                    composerStartRestartGroup.startReplaceGroup(-879693005);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*166@6114L20,153@5431L1062");
                    mapModeArrValues = MapMode.values();
                    length = mapModeArrValues.length;
                    i6 = 0;
                    while (i6 < length) {
                        mapMode3 = mapModeArrValues[i6];
                        if (mapMode3 == selectedMode) {
                            z = true;
                        } else {
                            z = false;
                        }
                        MapMode[] mapModeArr = mapModeArrValues;
                        Modifier modifierClip = ClipKt.clip(SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(48.0f)), RoundedCornerShapeKt.getCircleShape());
                        if (z) {
                            jColor = Color.m3819copywmQWz5c$default(ColorKt.getAlpinePrimary(), 0.35f, 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            jColor = androidx.compose.ui.graphics.ColorKt.Color(4111669802L);
                        }
                        Modifier modifierM225backgroundbw27NRU$default = BackgroundKt.m225backgroundbw27NRU$default(modifierClip, jColor, null, 2, null);
                        if (z) {
                            fM6261constructorimpl2 = Dp.m6261constructorimpl(2.0f);
                        } else {
                            fM6261constructorimpl2 = Dp.m6261constructorimpl(1.0f);
                        }
                        if (z) {
                            jM3819copywmQWz5c$default2 = ColorKt.getAlpinePrimary();
                        } else {
                            jM3819copywmQWz5c$default2 = Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.25f, 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        int i8 = length;
                        int i9 = i6;
                        Modifier modifierM236borderxT4_qwU = BorderKt.m236borderxT4_qwU(modifierM225backgroundbw27NRU$default, fM6261constructorimpl2, jM3819copywmQWz5c$default2, RoundedCornerShapeKt.getCircleShape());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1898300391, "CC(remember):MapModeSwitchButton.kt#9igjgp");
                        if ((i4 & 112) == 32) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zChangedInstance3 = composerStartRestartGroup.changedInstance(coroutineScope) | z2 | composerStartRestartGroup.changedInstance(animatable) | composerStartRestartGroup.changedInstance(animatable2) | composerStartRestartGroup.changed(mapMode3.ordinal());
                        Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance3 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                            coroutineScope3 = coroutineScope;
                            mutableState4 = mutableState2;
                            animatable4 = animatable2;
                            mapMode4 = mapMode3;
                            obj = new Function0() { // from class: com.example.ui.map.MapModeSwitchButtonKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return MapModeSwitchButtonKt.MapModeSwitchButton$lambda$18$lambda$14$lambda$13$lambda$11$lambda$10(mapMode4, onModeSelected, coroutineScope3, mutableState4, animatable4, mutableState, animatable);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(obj);
                        } else {
                            obj = objRememberedValue8;
                            coroutineScope3 = coroutineScope;
                            mutableState4 = mutableState2;
                            animatable4 = animatable2;
                            mapMode4 = mapMode3;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierM258clickableXHw0xAI$default = ClickableKt.m258clickableXHw0xAI$default(modifierM236borderxT4_qwU, false, null, null, (Function0) obj, 7, null);
                        String lowerCase = mapMode4.name().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        Modifier modifierTestTag = TestTagKt.testTag(modifierM258clickableXHw0xAI$default, "map_mode_option_" + lowerCase);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
                        constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        MutableState mutableState5 = mutableState4;
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
                        composerM3313constructorimpl4 = Updater.m3313constructorimpl(composerStartRestartGroup);
                        Updater.m3320setimpl(composerM3313constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3320setimpl(composerM3313constructorimpl4, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM3313constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                            composerM3313constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                            composerM3313constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                        }
                        Updater.m3320setimpl(composerM3313constructorimpl4, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, str2);
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1690617244, "C170@6325L146:MapModeSwitchButton.kt#8v18gj");
                        MapModeIconGraphic(mapMode4, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(36.0f)), composerStartRestartGroup, 48, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        mutableState2 = mutableState5;
                        animatable2 = animatable4;
                        str2 = str2;
                        length = i8;
                        modifier3 = modifier3;
                        mapModeArrValues = mapModeArr;
                        coroutineScope = coroutineScope3;
                        i6 = i9 + 1;
                        selectedMode = mapMode;
                    }
                    animatable3 = animatable2;
                    modifier4 = modifier3;
                    coroutineScope2 = coroutineScope;
                    mutableState3 = mutableState2;
                    str = str2;
                    i5 = 48;
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    animatable3 = animatable2;
                    modifier4 = modifier3;
                    mutableState3 = mutableState2;
                    i5 = 48;
                    str = "C73@3429L9:Box.kt#2w3rfo";
                    coroutineScope2 = coroutineScope;
                    composerStartRestartGroup.startReplaceGroup(-702724106);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierM225backgroundbw27NRU$default2 = BackgroundKt.m225backgroundbw27NRU$default(ClipKt.clip(SizeKt.m715size3ABfNKs(OffsetKt.m631offsetVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m6261constructorimpl(((Number) animatable3.getValue()).floatValue()), 1, null), Dp.m6261constructorimpl(48.0f)), RoundedCornerShapeKt.getCircleShape()), androidx.compose.ui.graphics.ColorKt.Color(4111669802L), null, 2, null);
                if (MapModeSwitchButton$lambda$1(mutableState)) {
                    fM6261constructorimpl = Dp.m6261constructorimpl(1.5f);
                } else {
                    fM6261constructorimpl = Dp.m6261constructorimpl(1.0f);
                }
                if (MapModeSwitchButton$lambda$1(mutableState)) {
                    jM3819copywmQWz5c$default = ColorKt.getAlpinePrimary();
                } else {
                    jM3819copywmQWz5c$default = Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.25f, 0.0f, 0.0f, 0.0f, 14, null);
                }
                String str3 = str;
                Modifier modifierM236borderxT4_qwU2 = BorderKt.m236borderxT4_qwU(modifierM225backgroundbw27NRU$default2, fM6261constructorimpl, jM3819copywmQWz5c$default, RoundedCornerShapeKt.getCircleShape());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -438085026, "CC(remember):MapModeSwitchButton.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope2) | composerStartRestartGroup.changedInstance(animatable) | composerStartRestartGroup.changedInstance(animatable3);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    final MutableState mutableState6 = mutableState3;
                    final CoroutineScope coroutineScope4 = coroutineScope2;
                    final Animatable animatable5 = animatable3;
                    Function0 function0 = new Function0() { // from class: com.example.ui.map.MapModeSwitchButtonKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MapModeSwitchButtonKt.MapModeSwitchButton$lambda$18$lambda$16$lambda$15(coroutineScope4, mutableState6, mutableState, animatable, animatable5);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function0);
                    objRememberedValue6 = function0;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierTestTag2 = TestTagKt.testTag(ClickableKt.m258clickableXHw0xAI$default(modifierM236borderxT4_qwU2, false, null, null, (Function0) objRememberedValue6, 7, null), "map_mode_switch_button");
                Alignment center2 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag2);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM3313constructorimpl2 = Updater.m3313constructorimpl(composerStartRestartGroup);
                Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, str3);
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 959834279, "C195@7188L118:MapModeSwitchButton.kt#8v18gj");
                int i10 = (i4 & 14) | i5;
                mapMode2 = mapMode;
                MapModeIconGraphic(mapMode2, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(36.0f)), composerStartRestartGroup, i10, 0);
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
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final MapMode mapMode5 = mapMode2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.map.MapModeSwitchButtonKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return MapModeSwitchButtonKt.MapModeSwitchButton$lambda$19(mapMode5, onModeSelected, modifier5, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i3;
        if ((i4 & 147) != 146) {
            if (i7 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-14288846, i4, -1, "com.example.ui.map.MapModeSwitchButton (MapModeSwitchButton.kt:42)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -954367824, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller2 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller2);
                objRememberedValue = compositionScopedCoroutineScopeCanceller2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -846672268, "CC(remember):MapModeSwitchButton.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -846670412, "CC(remember):MapModeSwitchButton.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            mutableState2 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -846668467, "CC(remember):MapModeSwitchButton.kt#9igjgp");
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            animatable = (Animatable) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -846666803, "CC(remember):MapModeSwitchButton.kt#9igjgp");
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            animatable2 = (Animatable) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Alignment bottomCenter2 = Alignment.INSTANCE.getBottomCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(bottomCenter2, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            composerM3313constructorimpl = Updater.m3313constructorimpl(composerStartRestartGroup);
            Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3313constructorimpl.getInserting()) {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -698066107, "C191@7045L18,180@6577L739:MapModeSwitchButton.kt#8v18gj");
            if (((Number) animatable.getValue()).floatValue() > 0.01f) {
                composerStartRestartGroup.startReplaceGroup(-698057645);
                ComposerKt.sourceInformation(composerStartRestartGroup, "141@4823L327,138@4658L1867");
                Modifier modifierM674paddingqDBjuR0$default2 = PaddingKt.m674paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6261constructorimpl(58.0f), 7, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -438155821, "CC(remember):MapModeSwitchButton.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(animatable);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue7 = new Function1() { // from class: com.example.ui.map.MapModeSwitchButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return MapModeSwitchButtonKt.MapModeSwitchButton$lambda$18$lambda$9$lambda$8(animatable, (GraphicsLayerScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new Function1() { // from class: com.example.ui.map.MapModeSwitchButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return MapModeSwitchButtonKt.MapModeSwitchButton$lambda$18$lambda$9$lambda$8(animatable, (GraphicsLayerScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierGraphicsLayer2 = GraphicsLayerModifierKt.graphicsLayer(modifierM674paddingqDBjuR0$default2, (Function1) objRememberedValue7);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_5 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(10.0f));
                Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_5, centerHorizontally2, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer2);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                str2 = "C73@3429L9:Box.kt#2w3rfo";
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
                composerM3313constructorimpl3 = Updater.m3313constructorimpl(composerStartRestartGroup);
                Updater.m3320setimpl(composerM3313constructorimpl3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl3, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl3.getInserting()) {
                    composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                } else {
                    composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m3320setimpl(composerM3313constructorimpl3, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1500695713, "C:MapModeSwitchButton.kt#8v18gj");
                composerStartRestartGroup.startReplaceGroup(-879693005);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*166@6114L20,153@5431L1062");
                mapModeArrValues = MapMode.values();
                length = mapModeArrValues.length;
                i6 = 0;
                while (i6 < length) {
                    mapMode3 = mapModeArrValues[i6];
                    if (mapMode3 == selectedMode) {
                        z = true;
                    } else {
                        z = false;
                    }
                    MapMode[] mapModeArr2 = mapModeArrValues;
                    Modifier modifierClip2 = ClipKt.clip(SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(48.0f)), RoundedCornerShapeKt.getCircleShape());
                    if (z) {
                        jColor = Color.m3819copywmQWz5c$default(ColorKt.getAlpinePrimary(), 0.35f, 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jColor = androidx.compose.ui.graphics.ColorKt.Color(4111669802L);
                    }
                    Modifier modifierM225backgroundbw27NRU$default3 = BackgroundKt.m225backgroundbw27NRU$default(modifierClip2, jColor, null, 2, null);
                    if (z) {
                        fM6261constructorimpl2 = Dp.m6261constructorimpl(2.0f);
                    } else {
                        fM6261constructorimpl2 = Dp.m6261constructorimpl(1.0f);
                    }
                    if (z) {
                        jM3819copywmQWz5c$default2 = ColorKt.getAlpinePrimary();
                    } else {
                        jM3819copywmQWz5c$default2 = Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.25f, 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    int i11 = length;
                    int i12 = i6;
                    Modifier modifierM236borderxT4_qwU3 = BorderKt.m236borderxT4_qwU(modifierM225backgroundbw27NRU$default3, fM6261constructorimpl2, jM3819copywmQWz5c$default2, RoundedCornerShapeKt.getCircleShape());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1898300391, "CC(remember):MapModeSwitchButton.kt#9igjgp");
                    if ((i4 & 112) == 32) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChangedInstance3 = composerStartRestartGroup.changedInstance(coroutineScope) | z2 | composerStartRestartGroup.changedInstance(animatable) | composerStartRestartGroup.changedInstance(animatable2) | composerStartRestartGroup.changed(mapMode3.ordinal());
                    Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance3) {
                        coroutineScope3 = coroutineScope;
                        mutableState4 = mutableState2;
                        animatable4 = animatable2;
                        mapMode4 = mapMode3;
                        obj = new Function0() { // from class: com.example.ui.map.MapModeSwitchButtonKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MapModeSwitchButtonKt.MapModeSwitchButton$lambda$18$lambda$14$lambda$13$lambda$11$lambda$10(mapMode4, onModeSelected, coroutineScope3, mutableState4, animatable4, mutableState, animatable);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(obj);
                    } else {
                        coroutineScope3 = coroutineScope;
                        mutableState4 = mutableState2;
                        animatable4 = animatable2;
                        mapMode4 = mapMode3;
                        obj = new Function0() { // from class: com.example.ui.map.MapModeSwitchButtonKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MapModeSwitchButtonKt.MapModeSwitchButton$lambda$18$lambda$14$lambda$13$lambda$11$lambda$10(mapMode4, onModeSelected, coroutineScope3, mutableState4, animatable4, mutableState, animatable);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(obj);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierM258clickableXHw0xAI$default2 = ClickableKt.m258clickableXHw0xAI$default(modifierM236borderxT4_qwU3, false, null, null, (Function0) obj, 7, null);
                    String lowerCase2 = mapMode4.name().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    Modifier modifierTestTag3 = TestTagKt.testTag(modifierM258clickableXHw0xAI$default2, "map_mode_option_" + lowerCase2);
                    Alignment center3 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag3);
                    constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    MutableState mutableState7 = mutableState4;
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
                    composerM3313constructorimpl4 = Updater.m3313constructorimpl(composerStartRestartGroup);
                    Updater.m3320setimpl(composerM3313constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3320setimpl(composerM3313constructorimpl4, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM3313constructorimpl4.getInserting()) {
                        composerM3313constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        composerM3313constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    } else {
                        composerM3313constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        composerM3313constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    Updater.m3320setimpl(composerM3313constructorimpl4, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, str2);
                    BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1690617244, "C170@6325L146:MapModeSwitchButton.kt#8v18gj");
                    MapModeIconGraphic(mapMode4, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(36.0f)), composerStartRestartGroup, 48, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mutableState2 = mutableState7;
                    animatable2 = animatable4;
                    str2 = str2;
                    length = i11;
                    modifier3 = modifier3;
                    mapModeArrValues = mapModeArr2;
                    coroutineScope = coroutineScope3;
                    i6 = i12 + 1;
                    selectedMode = mapMode;
                }
                animatable3 = animatable2;
                modifier4 = modifier3;
                coroutineScope2 = coroutineScope;
                mutableState3 = mutableState2;
                str = str2;
                i5 = 48;
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                animatable3 = animatable2;
                modifier4 = modifier3;
                mutableState3 = mutableState2;
                i5 = 48;
                str = "C73@3429L9:Box.kt#2w3rfo";
                coroutineScope2 = coroutineScope;
                composerStartRestartGroup.startReplaceGroup(-702724106);
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierM225backgroundbw27NRU$default4 = BackgroundKt.m225backgroundbw27NRU$default(ClipKt.clip(SizeKt.m715size3ABfNKs(OffsetKt.m631offsetVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m6261constructorimpl(((Number) animatable3.getValue()).floatValue()), 1, null), Dp.m6261constructorimpl(48.0f)), RoundedCornerShapeKt.getCircleShape()), androidx.compose.ui.graphics.ColorKt.Color(4111669802L), null, 2, null);
            if (MapModeSwitchButton$lambda$1(mutableState)) {
                fM6261constructorimpl = Dp.m6261constructorimpl(1.5f);
            } else {
                fM6261constructorimpl = Dp.m6261constructorimpl(1.0f);
            }
            if (MapModeSwitchButton$lambda$1(mutableState)) {
                jM3819copywmQWz5c$default = ColorKt.getAlpinePrimary();
            } else {
                jM3819copywmQWz5c$default = Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.25f, 0.0f, 0.0f, 0.0f, 14, null);
            }
            String str4 = str;
            Modifier modifierM236borderxT4_qwU4 = BorderKt.m236borderxT4_qwU(modifierM225backgroundbw27NRU$default4, fM6261constructorimpl, jM3819copywmQWz5c$default, RoundedCornerShapeKt.getCircleShape());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -438085026, "CC(remember):MapModeSwitchButton.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope2) | composerStartRestartGroup.changedInstance(animatable) | composerStartRestartGroup.changedInstance(animatable3);
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                final MutableState mutableState8 = mutableState3;
                final CoroutineScope coroutineScope5 = coroutineScope2;
                final Animatable animatable6 = animatable3;
                Function0 function1 = new Function0() { // from class: com.example.ui.map.MapModeSwitchButtonKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MapModeSwitchButtonKt.MapModeSwitchButton$lambda$18$lambda$16$lambda$15(coroutineScope5, mutableState8, mutableState, animatable, animatable6);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function1);
                objRememberedValue6 = function1;
            } else {
                final MutableState mutableState9 = mutableState3;
                final CoroutineScope coroutineScope6 = coroutineScope2;
                final Animatable animatable7 = animatable3;
                Function0 function2 = new Function0() { // from class: com.example.ui.map.MapModeSwitchButtonKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MapModeSwitchButtonKt.MapModeSwitchButton$lambda$18$lambda$16$lambda$15(coroutineScope6, mutableState9, mutableState, animatable, animatable7);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function2);
                objRememberedValue6 = function2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierTestTag4 = TestTagKt.testTag(ClickableKt.m258clickableXHw0xAI$default(modifierM236borderxT4_qwU4, false, null, null, (Function0) objRememberedValue6, 7, null), "map_mode_switch_button");
            Alignment center4 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(center4, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag4);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
            composerM3313constructorimpl2 = Updater.m3313constructorimpl(composerStartRestartGroup);
            Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3313constructorimpl2.getInserting()) {
                composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, str4);
            BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 959834279, "C195@7188L118:MapModeSwitchButton.kt#8v18gj");
            int i13 = (i4 & 14) | i5;
            mapMode2 = mapMode;
            MapModeIconGraphic(mapMode2, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(36.0f)), composerStartRestartGroup, i13, 0);
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
        } else {
            if (i7 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-14288846, i4, -1, "com.example.ui.map.MapModeSwitchButton (MapModeSwitchButton.kt:42)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -954367824, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller3 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller3);
                objRememberedValue = compositionScopedCoroutineScopeCanceller3;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -846672268, "CC(remember):MapModeSwitchButton.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -846670412, "CC(remember):MapModeSwitchButton.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            mutableState2 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -846668467, "CC(remember):MapModeSwitchButton.kt#9igjgp");
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            animatable = (Animatable) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -846666803, "CC(remember):MapModeSwitchButton.kt#9igjgp");
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            animatable2 = (Animatable) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Alignment bottomCenter3 = Alignment.INSTANCE.getBottomCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(bottomCenter3, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            composerM3313constructorimpl = Updater.m3313constructorimpl(composerStartRestartGroup);
            Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3313constructorimpl.getInserting()) {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -698066107, "C191@7045L18,180@6577L739:MapModeSwitchButton.kt#8v18gj");
            if (((Number) animatable.getValue()).floatValue() > 0.01f) {
                composerStartRestartGroup.startReplaceGroup(-698057645);
                ComposerKt.sourceInformation(composerStartRestartGroup, "141@4823L327,138@4658L1867");
                Modifier modifierM674paddingqDBjuR0$default3 = PaddingKt.m674paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m6261constructorimpl(58.0f), 7, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -438155821, "CC(remember):MapModeSwitchButton.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(animatable);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue7 = new Function1() { // from class: com.example.ui.map.MapModeSwitchButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return MapModeSwitchButtonKt.MapModeSwitchButton$lambda$18$lambda$9$lambda$8(animatable, (GraphicsLayerScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new Function1() { // from class: com.example.ui.map.MapModeSwitchButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return MapModeSwitchButtonKt.MapModeSwitchButton$lambda$18$lambda$9$lambda$8(animatable, (GraphicsLayerScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierGraphicsLayer3 = GraphicsLayerModifierKt.graphicsLayer(modifierM674paddingqDBjuR0$default3, (Function1) objRememberedValue7);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_6 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(10.0f));
                Alignment.Horizontal centerHorizontally3 = Alignment.INSTANCE.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_6, centerHorizontally3, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer3);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                str2 = "C73@3429L9:Box.kt#2w3rfo";
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
                composerM3313constructorimpl3 = Updater.m3313constructorimpl(composerStartRestartGroup);
                Updater.m3320setimpl(composerM3313constructorimpl3, measurePolicyColumnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl3, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl3.getInserting()) {
                    composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                } else {
                    composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m3320setimpl(composerM3313constructorimpl3, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1500695713, "C:MapModeSwitchButton.kt#8v18gj");
                composerStartRestartGroup.startReplaceGroup(-879693005);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*166@6114L20,153@5431L1062");
                mapModeArrValues = MapMode.values();
                length = mapModeArrValues.length;
                i6 = 0;
                while (i6 < length) {
                    mapMode3 = mapModeArrValues[i6];
                    if (mapMode3 == selectedMode) {
                        z = true;
                    } else {
                        z = false;
                    }
                    MapMode[] mapModeArr3 = mapModeArrValues;
                    Modifier modifierClip3 = ClipKt.clip(SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(48.0f)), RoundedCornerShapeKt.getCircleShape());
                    if (z) {
                        jColor = Color.m3819copywmQWz5c$default(ColorKt.getAlpinePrimary(), 0.35f, 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jColor = androidx.compose.ui.graphics.ColorKt.Color(4111669802L);
                    }
                    Modifier modifierM225backgroundbw27NRU$default5 = BackgroundKt.m225backgroundbw27NRU$default(modifierClip3, jColor, null, 2, null);
                    if (z) {
                        fM6261constructorimpl2 = Dp.m6261constructorimpl(2.0f);
                    } else {
                        fM6261constructorimpl2 = Dp.m6261constructorimpl(1.0f);
                    }
                    if (z) {
                        jM3819copywmQWz5c$default2 = ColorKt.getAlpinePrimary();
                    } else {
                        jM3819copywmQWz5c$default2 = Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.25f, 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    int i14 = length;
                    int i15 = i6;
                    Modifier modifierM236borderxT4_qwU5 = BorderKt.m236borderxT4_qwU(modifierM225backgroundbw27NRU$default5, fM6261constructorimpl2, jM3819copywmQWz5c$default2, RoundedCornerShapeKt.getCircleShape());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1898300391, "CC(remember):MapModeSwitchButton.kt#9igjgp");
                    if ((i4 & 112) == 32) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChangedInstance3 = composerStartRestartGroup.changedInstance(coroutineScope) | z2 | composerStartRestartGroup.changedInstance(animatable) | composerStartRestartGroup.changedInstance(animatable2) | composerStartRestartGroup.changed(mapMode3.ordinal());
                    Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance3) {
                        coroutineScope3 = coroutineScope;
                        mutableState4 = mutableState2;
                        animatable4 = animatable2;
                        mapMode4 = mapMode3;
                        obj = new Function0() { // from class: com.example.ui.map.MapModeSwitchButtonKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MapModeSwitchButtonKt.MapModeSwitchButton$lambda$18$lambda$14$lambda$13$lambda$11$lambda$10(mapMode4, onModeSelected, coroutineScope3, mutableState4, animatable4, mutableState, animatable);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(obj);
                    } else {
                        coroutineScope3 = coroutineScope;
                        mutableState4 = mutableState2;
                        animatable4 = animatable2;
                        mapMode4 = mapMode3;
                        obj = new Function0() { // from class: com.example.ui.map.MapModeSwitchButtonKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MapModeSwitchButtonKt.MapModeSwitchButton$lambda$18$lambda$14$lambda$13$lambda$11$lambda$10(mapMode4, onModeSelected, coroutineScope3, mutableState4, animatable4, mutableState, animatable);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(obj);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierM258clickableXHw0xAI$default3 = ClickableKt.m258clickableXHw0xAI$default(modifierM236borderxT4_qwU5, false, null, null, (Function0) obj, 7, null);
                    String lowerCase3 = mapMode4.name().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                    Modifier modifierTestTag5 = TestTagKt.testTag(modifierM258clickableXHw0xAI$default3, "map_mode_option_" + lowerCase3);
                    Alignment center5 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(center5, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag5);
                    constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    MutableState mutableState10 = mutableState4;
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
                    composerM3313constructorimpl4 = Updater.m3313constructorimpl(composerStartRestartGroup);
                    Updater.m3320setimpl(composerM3313constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3320setimpl(composerM3313constructorimpl4, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM3313constructorimpl4.getInserting()) {
                        composerM3313constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        composerM3313constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    } else {
                        composerM3313constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        composerM3313constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    Updater.m3320setimpl(composerM3313constructorimpl4, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, str2);
                    BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1690617244, "C170@6325L146:MapModeSwitchButton.kt#8v18gj");
                    MapModeIconGraphic(mapMode4, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(36.0f)), composerStartRestartGroup, 48, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mutableState2 = mutableState10;
                    animatable2 = animatable4;
                    str2 = str2;
                    length = i14;
                    modifier3 = modifier3;
                    mapModeArrValues = mapModeArr3;
                    coroutineScope = coroutineScope3;
                    i6 = i15 + 1;
                    selectedMode = mapMode;
                }
                animatable3 = animatable2;
                modifier4 = modifier3;
                coroutineScope2 = coroutineScope;
                mutableState3 = mutableState2;
                str = str2;
                i5 = 48;
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                animatable3 = animatable2;
                modifier4 = modifier3;
                mutableState3 = mutableState2;
                i5 = 48;
                str = "C73@3429L9:Box.kt#2w3rfo";
                coroutineScope2 = coroutineScope;
                composerStartRestartGroup.startReplaceGroup(-702724106);
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierM225backgroundbw27NRU$default6 = BackgroundKt.m225backgroundbw27NRU$default(ClipKt.clip(SizeKt.m715size3ABfNKs(OffsetKt.m631offsetVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m6261constructorimpl(((Number) animatable3.getValue()).floatValue()), 1, null), Dp.m6261constructorimpl(48.0f)), RoundedCornerShapeKt.getCircleShape()), androidx.compose.ui.graphics.ColorKt.Color(4111669802L), null, 2, null);
            if (MapModeSwitchButton$lambda$1(mutableState)) {
                fM6261constructorimpl = Dp.m6261constructorimpl(1.5f);
            } else {
                fM6261constructorimpl = Dp.m6261constructorimpl(1.0f);
            }
            if (MapModeSwitchButton$lambda$1(mutableState)) {
                jM3819copywmQWz5c$default = ColorKt.getAlpinePrimary();
            } else {
                jM3819copywmQWz5c$default = Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.25f, 0.0f, 0.0f, 0.0f, 14, null);
            }
            String str5 = str;
            Modifier modifierM236borderxT4_qwU6 = BorderKt.m236borderxT4_qwU(modifierM225backgroundbw27NRU$default6, fM6261constructorimpl, jM3819copywmQWz5c$default, RoundedCornerShapeKt.getCircleShape());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -438085026, "CC(remember):MapModeSwitchButton.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope2) | composerStartRestartGroup.changedInstance(animatable) | composerStartRestartGroup.changedInstance(animatable3);
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                final MutableState mutableState11 = mutableState3;
                final CoroutineScope coroutineScope7 = coroutineScope2;
                final Animatable animatable8 = animatable3;
                Function0 function3 = new Function0() { // from class: com.example.ui.map.MapModeSwitchButtonKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MapModeSwitchButtonKt.MapModeSwitchButton$lambda$18$lambda$16$lambda$15(coroutineScope7, mutableState11, mutableState, animatable, animatable8);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function3);
                objRememberedValue6 = function3;
            } else {
                final MutableState mutableState12 = mutableState3;
                final CoroutineScope coroutineScope8 = coroutineScope2;
                final Animatable animatable9 = animatable3;
                Function0 function4 = new Function0() { // from class: com.example.ui.map.MapModeSwitchButtonKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MapModeSwitchButtonKt.MapModeSwitchButton$lambda$18$lambda$16$lambda$15(coroutineScope8, mutableState12, mutableState, animatable, animatable9);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function4);
                objRememberedValue6 = function4;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierTestTag6 = TestTagKt.testTag(ClickableKt.m258clickableXHw0xAI$default(modifierM236borderxT4_qwU6, false, null, null, (Function0) objRememberedValue6, 7, null), "map_mode_switch_button");
            Alignment center6 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(center6, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag6);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
            composerM3313constructorimpl2 = Updater.m3313constructorimpl(composerStartRestartGroup);
            Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3313constructorimpl2.getInserting()) {
                composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, str5);
            BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 959834279, "C195@7188L118:MapModeSwitchButton.kt#8v18gj");
            int i16 = (i4 & 14) | i5;
            mapMode2 = mapMode;
            MapModeIconGraphic(mapMode2, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(36.0f)), composerStartRestartGroup, i16, 0);
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final MapMode mapMode6 = mapMode2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.map.MapModeSwitchButtonKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return MapModeSwitchButtonKt.MapModeSwitchButton$lambda$19(mapMode6, onModeSelected, modifier5, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final boolean MapModeSwitchButton$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MapModeSwitchButton$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean MapModeSwitchButton$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MapModeSwitchButton$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void MapModeSwitchButton$toggleExpand(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Animatable<Float, AnimationVector1D> animatable, Animatable<Float, AnimationVector1D> animatable2) {
        if (MapModeSwitchButton$lambda$4(mutableState)) {
            return;
        }
        if (MapModeSwitchButton$lambda$1(mutableState2)) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MapModeSwitchButtonKt$MapModeSwitchButton$toggleExpand$2(animatable2, mutableState, mutableState2, animatable, null), 3, null);
        } else {
            MapModeSwitchButton$lambda$2(mutableState2, true);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MapModeSwitchButtonKt$MapModeSwitchButton$toggleExpand$1(animatable, mutableState, null), 3, null);
        }
    }

    private static final void MapModeSwitchButton$selectMode(Function1<? super MapMode, Unit> function1, CoroutineScope coroutineScope, MutableState<Boolean> mutableState, Animatable<Float, AnimationVector1D> animatable, MutableState<Boolean> mutableState2, Animatable<Float, AnimationVector1D> animatable2, MapMode mapMode) {
        if (MapModeSwitchButton$lambda$4(mutableState)) {
            return;
        }
        function1.invoke(mapMode);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MapModeSwitchButtonKt$MapModeSwitchButton$selectMode$1(animatable, mutableState, mutableState2, animatable2, null), 3, null);
    }

    static final Unit MapModeSwitchButton$lambda$18$lambda$9$lambda$8(Animatable animatable, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setScaleX(((Number) animatable.getValue()).floatValue());
        graphicsLayer.setScaleY(((Number) animatable.getValue()).floatValue());
        graphicsLayer.setAlpha(((Number) animatable.getValue()).floatValue());
        graphicsLayer.mo4012setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(0.5f, 1.0f));
        graphicsLayer.setTranslationY((1.0f - ((Number) animatable.getValue()).floatValue()) * 30.0f);
        return Unit.INSTANCE;
    }

    static final Unit MapModeSwitchButton$lambda$18$lambda$14$lambda$13$lambda$11$lambda$10(MapMode mapMode, Function1 function1, CoroutineScope coroutineScope, MutableState mutableState, Animatable animatable, MutableState mutableState2, Animatable animatable2) {
        MapModeSwitchButton$selectMode(function1, coroutineScope, mutableState, animatable, mutableState2, animatable2, mapMode);
        return Unit.INSTANCE;
    }

    static final Unit MapModeSwitchButton$lambda$18$lambda$16$lambda$15(CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, Animatable animatable, Animatable animatable2) {
        MapModeSwitchButton$toggleExpand(coroutineScope, mutableState, mutableState2, animatable, animatable2);
        return Unit.INSTANCE;
    }

    public static final void MapModeIconGraphic(final MapMode mode, final Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(mode, "mode");
        Composer composerStartRestartGroup = composer.startRestartGroup(919785880);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MapModeIconGraphic)211@7526L4467,211@7498L4495:MapModeSwitchButton.kt#8v18gj");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(mode.ordinal()) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i3 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(919785880, i3, -1, "com.example.ui.map.MapModeIconGraphic (MapModeSwitchButton.kt:210)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -849023829, "CC(remember):MapModeSwitchButton.kt#9igjgp");
            boolean z = (i3 & 14) == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.ui.map.MapModeSwitchButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MapModeSwitchButtonKt.MapModeIconGraphic$lambda$24$lambda$23(mode, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifier, (Function1) objRememberedValue, composerStartRestartGroup, (i3 >> 3) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.map.MapModeSwitchButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MapModeSwitchButtonKt.MapModeIconGraphic$lambda$25(mode, modifier, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit MapModeIconGraphic$lambda$24$lambda$23(MapMode mapMode, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float fM3648getWidthimpl = Size.m3648getWidthimpl(Canvas.mo4370getSizeNHjbRc());
        float fM3645getHeightimpl = Size.m3645getHeightimpl(Canvas.mo4370getSizeNHjbRc());
        float f = fM3648getWidthimpl / 2.0f;
        int i = WhenMappings.$EnumSwitchMapping$0[mapMode.ordinal()];
        if (i == 1) {
            DrawScope.m4351drawCircleVaOC9Bg$default(Canvas, androidx.compose.ui.graphics.ColorKt.Color(4293981434L), f, 0L, 0.0f, null, null, 0, 124, null);
            long jColor = androidx.compose.ui.graphics.ColorKt.Color(4290957024L);
            float f2 = fM3645getHeightimpl * 0.5f;
            float f3 = fM3648getWidthimpl * 0.8f;
            DrawScope.m4356drawLineNGM6Ib0$default(Canvas, jColor, androidx.compose.ui.geometry.OffsetKt.Offset(fM3648getWidthimpl * 0.2f, f2), androidx.compose.ui.geometry.OffsetKt.Offset(f3, f2), 1.5f, 0, null, 0.0f, null, 0, 496, null);
            float f4 = fM3648getWidthimpl * 0.5f;
            DrawScope.m4356drawLineNGM6Ib0$default(Canvas, jColor, androidx.compose.ui.geometry.OffsetKt.Offset(f4, fM3645getHeightimpl * 0.2f), androidx.compose.ui.geometry.OffsetKt.Offset(f4, fM3645getHeightimpl * 0.8f), 1.5f, 0, null, 0.0f, null, 0, 496, null);
            Path Path = AndroidPath_androidKt.Path();
            Path.moveTo(fM3648getWidthimpl * 0.25f, fM3645getHeightimpl * 0.75f);
            Path.cubicTo(fM3648getWidthimpl * 0.35f, fM3645getHeightimpl * 0.35f, fM3648getWidthimpl * 0.65f, fM3645getHeightimpl * 0.65f, f3, fM3645getHeightimpl * 0.25f);
            DrawScope.m4360drawPathLG529CI$default(Canvas, Path, androidx.compose.ui.graphics.ColorKt.Color(4278216447L), 0.0f, new Stroke(3.5f, 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
        } else if (i == 2) {
            DrawScope.m4351drawCircleVaOC9Bg$default(Canvas, androidx.compose.ui.graphics.ColorKt.Color(4279771184L), f, 0L, 0.0f, null, null, 0, 124, null);
            long jColor2 = androidx.compose.ui.graphics.ColorKt.Color(4281878624L);
            float f5 = fM3645getHeightimpl * 0.5f;
            float f6 = fM3648getWidthimpl * 0.8f;
            DrawScope.m4356drawLineNGM6Ib0$default(Canvas, jColor2, androidx.compose.ui.geometry.OffsetKt.Offset(fM3648getWidthimpl * 0.2f, f5), androidx.compose.ui.geometry.OffsetKt.Offset(f6, f5), 1.5f, 0, null, 0.0f, null, 0, 496, null);
            float f7 = fM3648getWidthimpl * 0.5f;
            DrawScope.m4356drawLineNGM6Ib0$default(Canvas, jColor2, androidx.compose.ui.geometry.OffsetKt.Offset(f7, fM3645getHeightimpl * 0.2f), androidx.compose.ui.geometry.OffsetKt.Offset(f7, fM3645getHeightimpl * 0.8f), 1.5f, 0, null, 0.0f, null, 0, 496, null);
            Path Path2 = AndroidPath_androidKt.Path();
            Path2.moveTo(fM3648getWidthimpl * 0.25f, fM3645getHeightimpl * 0.75f);
            Path2.cubicTo(fM3648getWidthimpl * 0.35f, fM3645getHeightimpl * 0.35f, fM3648getWidthimpl * 0.65f, fM3645getHeightimpl * 0.65f, f6, fM3645getHeightimpl * 0.25f);
            DrawScope.m4360drawPathLG529CI$default(Canvas, Path2, androidx.compose.ui.graphics.ColorKt.Color(4294951175L), 0.0f, new Stroke(3.5f, 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            DrawScope.m4351drawCircleVaOC9Bg$default(Canvas, androidx.compose.ui.graphics.ColorKt.Color(4279381024L), f, 0L, 0.0f, null, null, 0, 124, null);
            DrawScope.m4351drawCircleVaOC9Bg$default(Canvas, androidx.compose.ui.graphics.ColorKt.Color(4280700984L), f * 0.5f, androidx.compose.ui.geometry.OffsetKt.Offset(0.6f * fM3648getWidthimpl, fM3645getHeightimpl * 0.4f), 0.0f, null, null, 0, MenuKt.InTransitionDuration, null);
            DrawScope.m4351drawCircleVaOC9Bg$default(Canvas, androidx.compose.ui.graphics.ColorKt.Color(4280040747L), f * 0.4f, androidx.compose.ui.geometry.OffsetKt.Offset(fM3648getWidthimpl * 0.35f, fM3645getHeightimpl * 0.65f), 0.0f, null, null, 0, MenuKt.InTransitionDuration, null);
            Path Path3 = AndroidPath_androidKt.Path();
            Path3.addArc(new Rect(fM3648getWidthimpl * 0.15f, 0.15f * fM3645getHeightimpl, fM3648getWidthimpl * 0.85f, 0.85f * fM3645getHeightimpl), 200.0f, 140.0f);
            DrawScope.m4360drawPathLG529CI$default(Canvas, Path3, androidx.compose.ui.graphics.ColorKt.Color(4278249078L), 0.0f, new Stroke(2.5f, 0.0f, 0, 0, PathEffect.Companion.dashPathEffect$default(PathEffect.INSTANCE, new float[]{6.0f, 4.0f}, 0.0f, 2, null), 14, null), null, 0, 52, null);
            DrawScope.m4351drawCircleVaOC9Bg$default(Canvas, Color.INSTANCE.m3857getWhite0d7_KjU(), 2.5f, androidx.compose.ui.geometry.OffsetKt.Offset(fM3648getWidthimpl * 0.78f, 0.32f * fM3645getHeightimpl), 0.0f, null, null, 0, MenuKt.InTransitionDuration, null);
        }
        return Unit.INSTANCE;
    }
}
