package com.example.ui.theme;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.HomeKt;
import androidx.compose.material.icons.filled.InsightsKt;
import androidx.compose.material.icons.filled.PlayArrowKt;
import androidx.compose.material.icons.filled.WarningKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.RippleKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: GlassComponents.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0004\u001aC\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000b\u001aQ\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001aE\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u00122\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000e\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u001e\u001aK\u0010\u001f\u001a\u00020\r2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0!2\u0006\u0010\"\u001a\u00020\u001b2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\r0\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u000e\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010$\u001a%\u0010%\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u00122\b\b\u0002\u0010\u000e\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010&\u001a)\u0010'\u001a\u00020\r2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0\u00122\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0\u0012H\u0007¢\u0006\u0002\u0010*\u001a\u0015\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u001bH\u0003¢\u0006\u0002\u0010-¨\u0006.²\u0006\n\u0010/\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u00100\u001a\u000201X\u008a\u008e\u0002²\u0006\n\u00102\u001a\u000201X\u008a\u0084\u0002²\u0006\n\u00103\u001a\u000201X\u008a\u0084\u0002²\u0006\n\u00104\u001a\u000201X\u008a\u0084\u0002²\u0006\n\u00105\u001a\u000201X\u008a\u0084\u0002²\u0006\n\u0010/\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\n\u00100\u001a\u000201X\u008a\u008e\u0002²\u0006\n\u00102\u001a\u000201X\u008a\u0084\u0002²\u0006\n\u00103\u001a\u000201X\u008a\u0084\u0002²\u0006\n\u00104\u001a\u000201X\u008a\u0084\u0002²\u0006\n\u00105\u001a\u000201X\u008a\u0084\u0002"}, d2 = {"glassPanel", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "borderColorTopLeft", "borderColorBottomRight", "borderWidth", "Landroidx/compose/ui/unit/Dp;", "glassPanel-IBj4UiM", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJJF)Landroidx/compose/ui/Modifier;", "GlassCard", "", "modifier", "isLightBg", "", "onClick", "Lkotlin/Function0;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "LiquidDock", "currentRoute", "", "onNavigateHome", "onNavigateHistory", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "LiquidFilterDock", "options", "", "selectedOption", "onOptionSelected", "(Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "StartRideButton", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SafetyModalDialog", "onDismiss", "onConfirm", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SafetyItem", "text", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "app", "isPressed", "dragOffsetPx", "", "animatedThumbOffsetPx", "laggedThumbOffsetPx", "thumbScale", "specularBorderAlpha"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GlassComponentsKt {
    static final Unit GlassCard$lambda$1(Modifier modifier, boolean z, Function0 function0, Function3 function3, int i, int i2, Composer composer, int i3) {
        GlassCard(modifier, z, function0, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit LiquidDock$lambda$34(String str, Function0 function0, Function0 function1, boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        LiquidDock(str, function0, function1, z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit LiquidFilterDock$lambda$64(List list, String str, Function1 function1, boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        LiquidFilterDock(list, str, function1, z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit SafetyItem$lambda$79(String str, int i, Composer composer, int i2) {
        SafetyItem(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit SafetyModalDialog$lambda$77(Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        SafetyModalDialog(function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit StartRideButton$lambda$68(Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        StartRideButton(function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: glassPanel-IBj4UiM, reason: not valid java name */
    public static final Modifier m6637glassPanelIBj4UiM(Modifier glassPanel, Shape shape, long j, long j2, long j3, float f) {
        Intrinsics.checkNotNullParameter(glassPanel, "$this$glassPanel");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return BorderKt.m238borderziNgDLE(BackgroundKt.m224backgroundbw27NRU(ClipKt.clip(glassPanel, shape), j, shape), f, Brush.Companion.m3771linearGradientmHitzGk$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m3810boximpl(j2), Color.m3810boximpl(j3)}), OffsetKt.Offset(0.0f, 0.0f), OffsetKt.Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY), 0, 8, (Object) null), shape);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x028e  */
    /* JADX WARN: Code duplicated, block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0055  */
    /* JADX WARN: Code duplicated, block: B:27:0x0058  */
    /* JADX WARN: Code duplicated, block: B:29:0x005c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0064  */
    /* JADX WARN: Code duplicated, block: B:32:0x0067  */
    /* JADX WARN: Code duplicated, block: B:37:0x0071  */
    /* JADX WARN: Code duplicated, block: B:39:0x0077  */
    /* JADX WARN: Code duplicated, block: B:40:0x007a  */
    /* JADX WARN: Code duplicated, block: B:44:0x0083  */
    /* JADX WARN: Code duplicated, block: B:48:0x0091 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x0093  */
    /* JADX WARN: Code duplicated, block: B:50:0x0098  */
    /* JADX WARN: Code duplicated, block: B:53:0x009c  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:64:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:71:0x0104  */
    /* JADX WARN: Code duplicated, block: B:72:0x0110  */
    /* JADX WARN: Code duplicated, block: B:75:0x013d  */
    /* JADX WARN: Code duplicated, block: B:77:0x0161  */
    /* JADX WARN: Code duplicated, block: B:80:0x0170  */
    /* JADX WARN: Code duplicated, block: B:81:0x017a  */
    /* JADX WARN: Code duplicated, block: B:83:0x019e  */
    /* JADX WARN: Code duplicated, block: B:86:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:89:0x0209  */
    /* JADX WARN: Code duplicated, block: B:90:0x020d  */
    /* JADX WARN: Code duplicated, block: B:93:0x0232  */
    /* JADX WARN: Code duplicated, block: B:95:0x0240  */
    /* JADX WARN: Code duplicated, block: B:98:0x0283  */
    public static final void GlassCard(Modifier modifier, boolean z, Function0<Unit> function0, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        boolean z2;
        int i4;
        Function0<Unit> function1;
        int i5;
        Modifier.Companion companion;
        Function0<Unit> function2;
        long jColor;
        Color.Companion companion2;
        long jM3857getWhite0d7_KjU;
        Color.Companion companion3;
        long jM3857getWhite0d7_KjU2;
        int i6;
        Object obj;
        float f;
        Modifier.Companion companionM256clickableO2vRcR0$default;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM3313constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        final Function0<Unit> function3;
        Object objRememberedValue;
        long alpinePrimaryContainer;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i7;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-63185837);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(GlassCard)P(2,1,3)104@4125L72:GlassComponents.kt#75kw8w");
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 48) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    function1 = function0;
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changedInstance(content)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i3 & 1171) != 1170 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                    function3 = function1;
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        z2 = false;
                    }
                    if (i4 != 0) {
                        function2 = null;
                    } else {
                        function2 = function1;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-63185837, i3, -1, "com.example.ui.theme.GlassCard (GlassComponents.kt:79)");
                    }
                    RoundedCornerShape roundedCornerShapeM953RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6261constructorimpl(24.0f));
                    if (z2) {
                        jColor = Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.9f, 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        jColor = androidx.compose.ui.graphics.ColorKt.Color(2568493083L);
                    }
                    long j = jColor;
                    companion2 = Color.INSTANCE;
                    if (z2) {
                        jM3857getWhite0d7_KjU = companion2.m3846getBlack0d7_KjU();
                    } else {
                        jM3857getWhite0d7_KjU = companion2.m3857getWhite0d7_KjU();
                    }
                    long jM3819copywmQWz5c$default = Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU, 0.15f, 0.0f, 0.0f, 0.0f, 14, null);
                    companion3 = Color.INSTANCE;
                    if (z2) {
                        jM3857getWhite0d7_KjU2 = companion3.m3846getBlack0d7_KjU();
                        i6 = 14;
                        obj = null;
                        f = 0.08f;
                    } else {
                        jM3857getWhite0d7_KjU2 = companion3.m3857getWhite0d7_KjU();
                        i6 = 14;
                        obj = null;
                        f = 0.05f;
                    }
                    Modifier modifierM6638glassPanelIBj4UiM$default = m6638glassPanelIBj4UiM$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), roundedCornerShapeM953RoundedCornerShape0680j_4, j, jM3819copywmQWz5c$default, Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU2, f, 0.0f, 0.0f, 0.0f, i6, obj), 0.0f, 16, null);
                    if (function2 != null) {
                        composerStartRestartGroup.startReplaceGroup(-1172757820);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "96@3850L39");
                        Modifier.Companion companion4 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -592017990, "CC(remember):GlassComponents.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z2) {
                            alpinePrimaryContainer = androidx.compose.ui.graphics.ColorKt.Color(4279179050L);
                        } else {
                            alpinePrimaryContainer = ColorKt.getAlpinePrimaryContainer();
                        }
                        companionM256clickableO2vRcR0$default = ClickableKt.m256clickableO2vRcR0$default(companion4, mutableInteractionSource, RippleKt.m2065rippleH2RKhps$default(false, 0.0f, alpinePrimaryContainer, 3, null), false, null, null, function2, 28, null);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-592010757);
                        composerStartRestartGroup.endReplaceGroup();
                        companionM256clickableO2vRcR0$default = Modifier.INSTANCE;
                    }
                    Modifier modifierM670padding3ABfNKs = PaddingKt.m670padding3ABfNKs(modifierM6638glassPanelIBj4UiM$default.then(companionM256clickableO2vRcR0$default), Dp.m6261constructorimpl(20.0f));
                    int i10 = i3 & 7168;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM670padding3ABfNKs);
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
                    Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM3313constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                    content.invoke(ColumnScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i10 >> 6) & 112) | 6));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function3 = function2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier3 = companion;
                    final boolean z3 = z2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return GlassComponentsKt.GlassCard$lambda$1(modifier3, z3, function3, content, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            function1 = function0;
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i3 & 1171) != 1170) {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i9 != 0) {
                    z2 = false;
                }
                if (i4 != 0) {
                    function2 = null;
                } else {
                    function2 = function1;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-63185837, i3, -1, "com.example.ui.theme.GlassCard (GlassComponents.kt:79)");
                }
                RoundedCornerShape roundedCornerShapeM953RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6261constructorimpl(24.0f));
                if (z2) {
                    jColor = Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.9f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jColor = androidx.compose.ui.graphics.ColorKt.Color(2568493083L);
                }
                long j2 = jColor;
                companion2 = Color.INSTANCE;
                if (z2) {
                    jM3857getWhite0d7_KjU = companion2.m3846getBlack0d7_KjU();
                } else {
                    jM3857getWhite0d7_KjU = companion2.m3857getWhite0d7_KjU();
                }
                long jM3819copywmQWz5c$default2 = Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU, 0.15f, 0.0f, 0.0f, 0.0f, 14, null);
                companion3 = Color.INSTANCE;
                if (z2) {
                    jM3857getWhite0d7_KjU2 = companion3.m3846getBlack0d7_KjU();
                    i6 = 14;
                    obj = null;
                    f = 0.08f;
                } else {
                    jM3857getWhite0d7_KjU2 = companion3.m3857getWhite0d7_KjU();
                    i6 = 14;
                    obj = null;
                    f = 0.05f;
                }
                Modifier modifierM6638glassPanelIBj4UiM$default2 = m6638glassPanelIBj4UiM$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), roundedCornerShapeM953RoundedCornerShape0680j_5, j2, jM3819copywmQWz5c$default2, Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU2, f, 0.0f, 0.0f, 0.0f, i6, obj), 0.0f, 16, null);
                if (function2 != null) {
                    composerStartRestartGroup.startReplaceGroup(-1172757820);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "96@3850L39");
                    Modifier.Companion companion5 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -592017990, "CC(remember):GlassComponents.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z2) {
                        alpinePrimaryContainer = androidx.compose.ui.graphics.ColorKt.Color(4279179050L);
                    } else {
                        alpinePrimaryContainer = ColorKt.getAlpinePrimaryContainer();
                    }
                    companionM256clickableO2vRcR0$default = ClickableKt.m256clickableO2vRcR0$default(companion5, mutableInteractionSource2, RippleKt.m2065rippleH2RKhps$default(false, 0.0f, alpinePrimaryContainer, 3, null), false, null, null, function2, 28, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-592010757);
                    composerStartRestartGroup.endReplaceGroup();
                    companionM256clickableO2vRcR0$default = Modifier.INSTANCE;
                }
                Modifier modifierM670padding3ABfNKs2 = PaddingKt.m670padding3ABfNKs(modifierM6638glassPanelIBj4UiM$default2.then(companionM256clickableO2vRcR0$default), Dp.m6261constructorimpl(20.0f));
                int i11 = i3 & 7168;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM670padding3ABfNKs2);
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
                Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl.getInserting()) {
                    composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                content.invoke(ColumnScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i11 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function2;
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i9 != 0) {
                    z2 = false;
                }
                if (i4 != 0) {
                    function2 = null;
                } else {
                    function2 = function1;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-63185837, i3, -1, "com.example.ui.theme.GlassCard (GlassComponents.kt:79)");
                }
                RoundedCornerShape roundedCornerShapeM953RoundedCornerShape0680j_6 = RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6261constructorimpl(24.0f));
                if (z2) {
                    jColor = Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.9f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jColor = androidx.compose.ui.graphics.ColorKt.Color(2568493083L);
                }
                long j3 = jColor;
                companion2 = Color.INSTANCE;
                if (z2) {
                    jM3857getWhite0d7_KjU = companion2.m3846getBlack0d7_KjU();
                } else {
                    jM3857getWhite0d7_KjU = companion2.m3857getWhite0d7_KjU();
                }
                long jM3819copywmQWz5c$default3 = Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU, 0.15f, 0.0f, 0.0f, 0.0f, 14, null);
                companion3 = Color.INSTANCE;
                if (z2) {
                    jM3857getWhite0d7_KjU2 = companion3.m3846getBlack0d7_KjU();
                    i6 = 14;
                    obj = null;
                    f = 0.08f;
                } else {
                    jM3857getWhite0d7_KjU2 = companion3.m3857getWhite0d7_KjU();
                    i6 = 14;
                    obj = null;
                    f = 0.05f;
                }
                Modifier modifierM6638glassPanelIBj4UiM$default3 = m6638glassPanelIBj4UiM$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), roundedCornerShapeM953RoundedCornerShape0680j_6, j3, jM3819copywmQWz5c$default3, Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU2, f, 0.0f, 0.0f, 0.0f, i6, obj), 0.0f, 16, null);
                if (function2 != null) {
                    composerStartRestartGroup.startReplaceGroup(-1172757820);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "96@3850L39");
                    Modifier.Companion companion6 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -592017990, "CC(remember):GlassComponents.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableInteractionSource mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z2) {
                        alpinePrimaryContainer = androidx.compose.ui.graphics.ColorKt.Color(4279179050L);
                    } else {
                        alpinePrimaryContainer = ColorKt.getAlpinePrimaryContainer();
                    }
                    companionM256clickableO2vRcR0$default = ClickableKt.m256clickableO2vRcR0$default(companion6, mutableInteractionSource3, RippleKt.m2065rippleH2RKhps$default(false, 0.0f, alpinePrimaryContainer, 3, null), false, null, null, function2, 28, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-592010757);
                    composerStartRestartGroup.endReplaceGroup();
                    companionM256clickableO2vRcR0$default = Modifier.INSTANCE;
                }
                Modifier modifierM670padding3ABfNKs3 = PaddingKt.m670padding3ABfNKs(modifierM6638glassPanelIBj4UiM$default3.then(companionM256clickableO2vRcR0$default), Dp.m6261constructorimpl(20.0f));
                int i12 = i3 & 7168;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM670padding3ABfNKs3);
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
                Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyColumnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl.getInserting()) {
                    composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                content.invoke(ColumnScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i12 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier4 = companion;
                final boolean z4 = z2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return GlassComponentsKt.GlassCard$lambda$1(modifier4, z4, function3, content, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        z2 = z;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                function1 = function0;
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i3 & 1171) != 1170) {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i9 != 0) {
                    z2 = false;
                }
                if (i4 != 0) {
                    function2 = null;
                } else {
                    function2 = function1;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-63185837, i3, -1, "com.example.ui.theme.GlassCard (GlassComponents.kt:79)");
                }
                RoundedCornerShape roundedCornerShapeM953RoundedCornerShape0680j_7 = RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6261constructorimpl(24.0f));
                if (z2) {
                    jColor = Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.9f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jColor = androidx.compose.ui.graphics.ColorKt.Color(2568493083L);
                }
                long j4 = jColor;
                companion2 = Color.INSTANCE;
                if (z2) {
                    jM3857getWhite0d7_KjU = companion2.m3846getBlack0d7_KjU();
                } else {
                    jM3857getWhite0d7_KjU = companion2.m3857getWhite0d7_KjU();
                }
                long jM3819copywmQWz5c$default4 = Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU, 0.15f, 0.0f, 0.0f, 0.0f, 14, null);
                companion3 = Color.INSTANCE;
                if (z2) {
                    jM3857getWhite0d7_KjU2 = companion3.m3846getBlack0d7_KjU();
                    i6 = 14;
                    obj = null;
                    f = 0.08f;
                } else {
                    jM3857getWhite0d7_KjU2 = companion3.m3857getWhite0d7_KjU();
                    i6 = 14;
                    obj = null;
                    f = 0.05f;
                }
                Modifier modifierM6638glassPanelIBj4UiM$default4 = m6638glassPanelIBj4UiM$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), roundedCornerShapeM953RoundedCornerShape0680j_7, j4, jM3819copywmQWz5c$default4, Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU2, f, 0.0f, 0.0f, 0.0f, i6, obj), 0.0f, 16, null);
                if (function2 != null) {
                    composerStartRestartGroup.startReplaceGroup(-1172757820);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "96@3850L39");
                    Modifier.Companion companion7 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -592017990, "CC(remember):GlassComponents.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableInteractionSource mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z2) {
                        alpinePrimaryContainer = androidx.compose.ui.graphics.ColorKt.Color(4279179050L);
                    } else {
                        alpinePrimaryContainer = ColorKt.getAlpinePrimaryContainer();
                    }
                    companionM256clickableO2vRcR0$default = ClickableKt.m256clickableO2vRcR0$default(companion7, mutableInteractionSource4, RippleKt.m2065rippleH2RKhps$default(false, 0.0f, alpinePrimaryContainer, 3, null), false, null, null, function2, 28, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-592010757);
                    composerStartRestartGroup.endReplaceGroup();
                    companionM256clickableO2vRcR0$default = Modifier.INSTANCE;
                }
                Modifier modifierM670padding3ABfNKs4 = PaddingKt.m670padding3ABfNKs(modifierM6638glassPanelIBj4UiM$default4.then(companionM256clickableO2vRcR0$default), Dp.m6261constructorimpl(20.0f));
                int i13 = i3 & 7168;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM670padding3ABfNKs4);
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
                Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyColumnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl.getInserting()) {
                    composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                content.invoke(ColumnScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i13 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function2;
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i9 != 0) {
                    z2 = false;
                }
                if (i4 != 0) {
                    function2 = null;
                } else {
                    function2 = function1;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-63185837, i3, -1, "com.example.ui.theme.GlassCard (GlassComponents.kt:79)");
                }
                RoundedCornerShape roundedCornerShapeM953RoundedCornerShape0680j_8 = RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6261constructorimpl(24.0f));
                if (z2) {
                    jColor = Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.9f, 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    jColor = androidx.compose.ui.graphics.ColorKt.Color(2568493083L);
                }
                long j5 = jColor;
                companion2 = Color.INSTANCE;
                if (z2) {
                    jM3857getWhite0d7_KjU = companion2.m3846getBlack0d7_KjU();
                } else {
                    jM3857getWhite0d7_KjU = companion2.m3857getWhite0d7_KjU();
                }
                long jM3819copywmQWz5c$default5 = Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU, 0.15f, 0.0f, 0.0f, 0.0f, 14, null);
                companion3 = Color.INSTANCE;
                if (z2) {
                    jM3857getWhite0d7_KjU2 = companion3.m3846getBlack0d7_KjU();
                    i6 = 14;
                    obj = null;
                    f = 0.08f;
                } else {
                    jM3857getWhite0d7_KjU2 = companion3.m3857getWhite0d7_KjU();
                    i6 = 14;
                    obj = null;
                    f = 0.05f;
                }
                Modifier modifierM6638glassPanelIBj4UiM$default5 = m6638glassPanelIBj4UiM$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), roundedCornerShapeM953RoundedCornerShape0680j_8, j5, jM3819copywmQWz5c$default5, Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU2, f, 0.0f, 0.0f, 0.0f, i6, obj), 0.0f, 16, null);
                if (function2 != null) {
                    composerStartRestartGroup.startReplaceGroup(-1172757820);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "96@3850L39");
                    Modifier.Companion companion8 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -592017990, "CC(remember):GlassComponents.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    MutableInteractionSource mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z2) {
                        alpinePrimaryContainer = androidx.compose.ui.graphics.ColorKt.Color(4279179050L);
                    } else {
                        alpinePrimaryContainer = ColorKt.getAlpinePrimaryContainer();
                    }
                    companionM256clickableO2vRcR0$default = ClickableKt.m256clickableO2vRcR0$default(companion8, mutableInteractionSource5, RippleKt.m2065rippleH2RKhps$default(false, 0.0f, alpinePrimaryContainer, 3, null), false, null, null, function2, 28, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-592010757);
                    composerStartRestartGroup.endReplaceGroup();
                    companionM256clickableO2vRcR0$default = Modifier.INSTANCE;
                }
                Modifier modifierM670padding3ABfNKs5 = PaddingKt.m670padding3ABfNKs(modifierM6638glassPanelIBj4UiM$default5.then(companionM256clickableO2vRcR0$default), Dp.m6261constructorimpl(20.0f));
                int i14 = i3 & 7168;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM670padding3ABfNKs5);
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
                Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyColumnMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                content.invoke(ColumnScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i14 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier5 = companion;
                final boolean z5 = z2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return GlassComponentsKt.GlassCard$lambda$1(modifier5, z5, function3, content, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        function1 = function0;
        if ((i & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(content)) {
                i7 = 2048;
            } else {
                i7 = 1024;
            }
            i3 |= i7;
        }
        if ((i3 & 1171) != 1170) {
            if (i8 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i9 != 0) {
                z2 = false;
            }
            if (i4 != 0) {
                function2 = null;
            } else {
                function2 = function1;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-63185837, i3, -1, "com.example.ui.theme.GlassCard (GlassComponents.kt:79)");
            }
            RoundedCornerShape roundedCornerShapeM953RoundedCornerShape0680j_9 = RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6261constructorimpl(24.0f));
            if (z2) {
                jColor = Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.9f, 0.0f, 0.0f, 0.0f, 14, null);
            } else {
                jColor = androidx.compose.ui.graphics.ColorKt.Color(2568493083L);
            }
            long j6 = jColor;
            companion2 = Color.INSTANCE;
            if (z2) {
                jM3857getWhite0d7_KjU = companion2.m3846getBlack0d7_KjU();
            } else {
                jM3857getWhite0d7_KjU = companion2.m3857getWhite0d7_KjU();
            }
            long jM3819copywmQWz5c$default6 = Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU, 0.15f, 0.0f, 0.0f, 0.0f, 14, null);
            companion3 = Color.INSTANCE;
            if (z2) {
                jM3857getWhite0d7_KjU2 = companion3.m3846getBlack0d7_KjU();
                i6 = 14;
                obj = null;
                f = 0.08f;
            } else {
                jM3857getWhite0d7_KjU2 = companion3.m3857getWhite0d7_KjU();
                i6 = 14;
                obj = null;
                f = 0.05f;
            }
            Modifier modifierM6638glassPanelIBj4UiM$default6 = m6638glassPanelIBj4UiM$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), roundedCornerShapeM953RoundedCornerShape0680j_9, j6, jM3819copywmQWz5c$default6, Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU2, f, 0.0f, 0.0f, 0.0f, i6, obj), 0.0f, 16, null);
            if (function2 != null) {
                composerStartRestartGroup.startReplaceGroup(-1172757820);
                ComposerKt.sourceInformation(composerStartRestartGroup, "96@3850L39");
                Modifier.Companion companion9 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -592017990, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableInteractionSource mutableInteractionSource6 = (MutableInteractionSource) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z2) {
                    alpinePrimaryContainer = androidx.compose.ui.graphics.ColorKt.Color(4279179050L);
                } else {
                    alpinePrimaryContainer = ColorKt.getAlpinePrimaryContainer();
                }
                companionM256clickableO2vRcR0$default = ClickableKt.m256clickableO2vRcR0$default(companion9, mutableInteractionSource6, RippleKt.m2065rippleH2RKhps$default(false, 0.0f, alpinePrimaryContainer, 3, null), false, null, null, function2, 28, null);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-592010757);
                composerStartRestartGroup.endReplaceGroup();
                companionM256clickableO2vRcR0$default = Modifier.INSTANCE;
            }
            Modifier modifierM670padding3ABfNKs6 = PaddingKt.m670padding3ABfNKs(modifierM6638glassPanelIBj4UiM$default6.then(companionM256clickableO2vRcR0$default), Dp.m6261constructorimpl(20.0f));
            int i15 = i3 & 7168;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM670padding3ABfNKs6);
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
            Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyColumnMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3313constructorimpl.getInserting()) {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            content.invoke(ColumnScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i15 >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function3 = function2;
        } else {
            if (i8 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i9 != 0) {
                z2 = false;
            }
            if (i4 != 0) {
                function2 = null;
            } else {
                function2 = function1;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-63185837, i3, -1, "com.example.ui.theme.GlassCard (GlassComponents.kt:79)");
            }
            RoundedCornerShape roundedCornerShapeM953RoundedCornerShape0680j_10 = RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6261constructorimpl(24.0f));
            if (z2) {
                jColor = Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.9f, 0.0f, 0.0f, 0.0f, 14, null);
            } else {
                jColor = androidx.compose.ui.graphics.ColorKt.Color(2568493083L);
            }
            long j7 = jColor;
            companion2 = Color.INSTANCE;
            if (z2) {
                jM3857getWhite0d7_KjU = companion2.m3846getBlack0d7_KjU();
            } else {
                jM3857getWhite0d7_KjU = companion2.m3857getWhite0d7_KjU();
            }
            long jM3819copywmQWz5c$default7 = Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU, 0.15f, 0.0f, 0.0f, 0.0f, 14, null);
            companion3 = Color.INSTANCE;
            if (z2) {
                jM3857getWhite0d7_KjU2 = companion3.m3846getBlack0d7_KjU();
                i6 = 14;
                obj = null;
                f = 0.08f;
            } else {
                jM3857getWhite0d7_KjU2 = companion3.m3857getWhite0d7_KjU();
                i6 = 14;
                obj = null;
                f = 0.05f;
            }
            Modifier modifierM6638glassPanelIBj4UiM$default7 = m6638glassPanelIBj4UiM$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), roundedCornerShapeM953RoundedCornerShape0680j_10, j7, jM3819copywmQWz5c$default7, Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU2, f, 0.0f, 0.0f, 0.0f, i6, obj), 0.0f, 16, null);
            if (function2 != null) {
                composerStartRestartGroup.startReplaceGroup(-1172757820);
                ComposerKt.sourceInformation(composerStartRestartGroup, "96@3850L39");
                Modifier.Companion companion10 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -592017990, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableInteractionSource mutableInteractionSource7 = (MutableInteractionSource) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z2) {
                    alpinePrimaryContainer = androidx.compose.ui.graphics.ColorKt.Color(4279179050L);
                } else {
                    alpinePrimaryContainer = ColorKt.getAlpinePrimaryContainer();
                }
                companionM256clickableO2vRcR0$default = ClickableKt.m256clickableO2vRcR0$default(companion10, mutableInteractionSource7, RippleKt.m2065rippleH2RKhps$default(false, 0.0f, alpinePrimaryContainer, 3, null), false, null, null, function2, 28, null);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-592010757);
                composerStartRestartGroup.endReplaceGroup();
                companionM256clickableO2vRcR0$default = Modifier.INSTANCE;
            }
            Modifier modifierM670padding3ABfNKs7 = PaddingKt.m670padding3ABfNKs(modifierM6638glassPanelIBj4UiM$default7.then(companionM256clickableO2vRcR0$default), Dp.m6261constructorimpl(20.0f));
            int i16 = i3 & 7168;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy7 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM670padding3ABfNKs7);
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
            Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyColumnMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3313constructorimpl.getInserting()) {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            content.invoke(ColumnScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i16 >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function3 = function2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = companion;
            final boolean z6 = z2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return GlassComponentsKt.GlassCard$lambda$1(modifier6, z6, function3, content, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:103:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:106:0x031f  */
    /* JADX WARN: Code duplicated, block: B:107:0x0322  */
    /* JADX WARN: Code duplicated, block: B:110:0x032e  */
    /* JADX WARN: Code duplicated, block: B:114:0x033a  */
    /* JADX WARN: Code duplicated, block: B:117:0x0396  */
    /* JADX WARN: Code duplicated, block: B:120:0x03a2  */
    /* JADX WARN: Code duplicated, block: B:121:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:124:0x03cb  */
    /* JADX WARN: Code duplicated, block: B:126:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:129:0x0418  */
    /* JADX WARN: Code duplicated, block: B:131:0x0420  */
    /* JADX WARN: Code duplicated, block: B:134:0x0452  */
    /* JADX WARN: Code duplicated, block: B:136:0x045a  */
    /* JADX WARN: Code duplicated, block: B:139:0x048e  */
    /* JADX WARN: Code duplicated, block: B:141:0x0496  */
    /* JADX WARN: Code duplicated, block: B:144:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:146:0x04ba  */
    /* JADX WARN: Code duplicated, block: B:147:0x04be  */
    /* JADX WARN: Code duplicated, block: B:150:0x04e4  */
    /* JADX WARN: Code duplicated, block: B:151:0x04e8  */
    /* JADX WARN: Code duplicated, block: B:153:0x0514  */
    /* JADX WARN: Code duplicated, block: B:155:0x0525  */
    /* JADX WARN: Code duplicated, block: B:156:0x0529  */
    /* JADX WARN: Code duplicated, block: B:159:0x054f  */
    /* JADX WARN: Code duplicated, block: B:160:0x0555  */
    /* JADX WARN: Code duplicated, block: B:164:0x05e1  */
    /* JADX WARN: Code duplicated, block: B:167:0x05ed  */
    /* JADX WARN: Code duplicated, block: B:168:0x05f1  */
    /* JADX WARN: Code duplicated, block: B:171:0x0616  */
    /* JADX WARN: Code duplicated, block: B:173:0x0624  */
    /* JADX WARN: Code duplicated, block: B:177:0x0661  */
    /* JADX WARN: Code duplicated, block: B:180:0x071d  */
    /* JADX WARN: Code duplicated, block: B:183:0x0729  */
    /* JADX WARN: Code duplicated, block: B:184:0x072d  */
    /* JADX WARN: Code duplicated, block: B:187:0x0752  */
    /* JADX WARN: Code duplicated, block: B:189:0x0760  */
    /* JADX WARN: Code duplicated, block: B:192:0x0795 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:193:0x0797  */
    /* JADX WARN: Code duplicated, block: B:194:0x079e  */
    /* JADX WARN: Code duplicated, block: B:195:0x07a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:196:0x07a5  */
    /* JADX WARN: Code duplicated, block: B:197:0x07af  */
    /* JADX WARN: Code duplicated, block: B:200:0x07db  */
    /* JADX WARN: Code duplicated, block: B:202:0x07e3  */
    /* JADX WARN: Code duplicated, block: B:205:0x08ce  */
    /* JADX WARN: Code duplicated, block: B:208:0x08da  */
    /* JADX WARN: Code duplicated, block: B:209:0x08de  */
    /* JADX WARN: Code duplicated, block: B:212:0x0903  */
    /* JADX WARN: Code duplicated, block: B:214:0x0911  */
    /* JADX WARN: Code duplicated, block: B:217:0x0946 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:218:0x0948  */
    /* JADX WARN: Code duplicated, block: B:219:0x094f  */
    /* JADX WARN: Code duplicated, block: B:220:0x0954 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:221:0x0956  */
    /* JADX WARN: Code duplicated, block: B:222:0x0960  */
    /* JADX WARN: Code duplicated, block: B:225:0x0989  */
    /* JADX WARN: Code duplicated, block: B:227:0x0991  */
    /* JADX WARN: Code duplicated, block: B:230:0x09f0  */
    /* JADX WARN: Code duplicated, block: B:234:0x09fd  */
    /* JADX WARN: Code duplicated, block: B:236:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0076  */
    /* JADX WARN: Code duplicated, block: B:38:0x0079  */
    /* JADX WARN: Code duplicated, block: B:40:0x007d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0085  */
    /* JADX WARN: Code duplicated, block: B:43:0x0088  */
    /* JADX WARN: Code duplicated, block: B:48:0x0094  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:72:0x0111  */
    /* JADX WARN: Code duplicated, block: B:75:0x014d  */
    /* JADX WARN: Code duplicated, block: B:76:0x0157  */
    /* JADX WARN: Code duplicated, block: B:79:0x015e  */
    /* JADX WARN: Code duplicated, block: B:80:0x016a  */
    /* JADX WARN: Code duplicated, block: B:83:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:84:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:87:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:88:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:91:0x0200  */
    /* JADX WARN: Code duplicated, block: B:92:0x0202  */
    /* JADX WARN: Code duplicated, block: B:95:0x0260 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:98:0x0266  */
    public static final void LiquidDock(final String currentRoute, final Function0<Unit> onNavigateHome, final Function0<Unit> onNavigateHistory, boolean z, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        int i4;
        Modifier modifier2;
        int i5;
        int i6;
        Object objRememberedValue;
        MutableState mutableState;
        Object objRememberedValue2;
        MutableState mutableState2;
        Density density;
        float fMo362toPx0680j_4;
        float f;
        float fCoerceIn;
        int i7;
        SpringSpec springSpecSpring$default;
        boolean z3;
        final State<Float> stateAnimateFloatAsState;
        final float fCoerceIn2;
        final float fAbs;
        float fAbs2;
        float f2;
        boolean z4;
        float fCoerceIn3;
        final float fLiquidDock$lambda$13;
        final float fLiquidDock$lambda$14;
        float f3;
        final State<Float> stateAnimateFloatAsState2;
        State stateRememberUpdatedState;
        State stateRememberUpdatedState2;
        State stateRememberUpdatedState3;
        boolean zChanged;
        float f4;
        GlassComponentsKt$LiquidDock$1$1 glassComponentsKt$LiquidDock$1$1RememberedValue;
        boolean z5;
        boolean zChanged2;
        Object objRememberedValue3;
        final boolean z6;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        boolean z7;
        Composer composerM3313constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        boolean zChanged3;
        Object objRememberedValue4;
        boolean zChanged4;
        Object objRememberedValue5;
        boolean zChanged5;
        Object objRememberedValue6;
        float f5;
        float f6;
        Brush brushM3777verticalGradient8A3gB4$default;
        int currentCompositeKeyHash2;
        Function0<ComposeUiNode> constructor2;
        Composer composerM3313constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        boolean z8;
        final float fCoerceIn4;
        final float fSin;
        final float f7;
        final float f8;
        int currentCompositeKeyHash3;
        Function0<ComposeUiNode> constructor3;
        Composer composerM3313constructorimpl3;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3;
        long alpineOnSurfaceVariant;
        boolean zChanged6;
        Object objRememberedValue7;
        final float fCoerceIn5;
        final float fSin2;
        final float f9;
        final float f10;
        int currentCompositeKeyHash4;
        Function0<ComposeUiNode> constructor4;
        Composer composerM3313constructorimpl4;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4;
        long alpineOnSurfaceVariant2;
        boolean zChanged7;
        Object objRememberedValue8;
        final Modifier modifier3;
        final boolean z9;
        float f11;
        float f12;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(currentRoute, "currentRoute");
        Intrinsics.checkNotNullParameter(onNavigateHome, "onNavigateHome");
        Intrinsics.checkNotNullParameter(onNavigateHistory, "onNavigateHistory");
        Composer composerStartRestartGroup = composer.startRestartGroup(989699901);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LiquidDock)P(!1,4,3)125@4690L34,126@4749L31,129@4840L7,143@5348L324,157@5785L209,180@6824L197,194@7354L163,200@7547L34,201@7612L36,202@7682L39,209@7902L2320,258@10247L1197,204@7727L10897:GlassComponents.kt#75kw8w");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(currentRoute) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onNavigateHome) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onNavigateHistory) ? 256 : 128;
        }
        int i8 = i2 & 8;
        if (i8 == 0) {
            if ((i & 3072) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    modifier2 = modifier;
                    if (composerStartRestartGroup.changed(modifier2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((i3 & 9363) != 9362 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z9 = z2;
                    modifier3 = modifier2;
                } else {
                    if (i8 != 0) {
                        z2 = false;
                    }
                    if (i4 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(989699901, i3, -1, "com.example.ui.theme.LiquidDock (GlassComponents.kt:121)");
                    }
                    Intrinsics.areEqual(currentRoute, "home");
                    if (!Intrinsics.areEqual(currentRoute, "history") || Intrinsics.areEqual(currentRoute, "recording")) {
                        i6 = 1;
                    } else {
                        i6 = 0;
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1913843039, "CC(remember):GlassComponents.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1913844924, "CC(remember):GlassComponents.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float fM6261constructorimpl = Dp.m6261constructorimpl(76.0f);
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume;
                    fMo362toPx0680j_4 = density.mo362toPx0680j_4(fM6261constructorimpl);
                    f = i6 * fMo362toPx0680j_4;
                    if (LiquidDock$lambda$3(mutableState)) {
                        fCoerceIn = RangesKt.coerceIn(LiquidDock$lambda$6(mutableState2) + f, 0.0f, fMo362toPx0680j_4);
                    } else {
                        fCoerceIn = f;
                    }
                    if (LiquidDock$lambda$3(mutableState)) {
                        springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 10000.0f, null, 5, null);
                        i7 = 4;
                    } else {
                        i7 = 4;
                        springSpecSpring$default = AnimationSpecKt.spring$default(0.45f, 180.0f, null, 4, null);
                    }
                    float f13 = fCoerceIn;
                    Modifier modifier4 = modifier2;
                    z3 = z2;
                    stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f13, springSpecSpring$default, 0.0f, "thumb_offset", null, composerStartRestartGroup, 3072, 20);
                    float fLiquidDock$lambda$9 = LiquidDock$lambda$9(stateAnimateFloatAsState) - LiquidDock$lambda$10(AnimateAsStateKt.animateFloatAsState(f13, AnimationSpecKt.spring$default(0.55f, 85.0f, null, i7, null), 0.0f, "lagged_thumb_offset", null, composerStartRestartGroup, 3120, 20));
                    fCoerceIn2 = RangesKt.coerceIn(fLiquidDock$lambda$9 / density.mo362toPx0680j_4(Dp.m6261constructorimpl(14.0f)), -1.0f, 1.0f);
                    fAbs = Math.abs(fCoerceIn2);
                    fAbs2 = Math.abs(LiquidDock$lambda$9(stateAnimateFloatAsState) - f);
                    if (fMo362toPx0680j_4 > 0.0f) {
                        f2 = fMo362toPx0680j_4;
                    } else {
                        f2 = 1.0f;
                    }
                    if (fAbs2 > density.mo362toPx0680j_4(Dp.m6261constructorimpl(3.0f))) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (LiquidDock$lambda$3(mutableState)) {
                        fCoerceIn3 = 1.0f;
                    } else {
                        fCoerceIn3 = RangesKt.coerceIn(fAbs2 / (f2 * 0.7f), 0.0f, 1.0f);
                    }
                    State<Float> stateAnimateFloatAsState3 = AnimateAsStateKt.animateFloatAsState((fCoerceIn3 * 0.48f) + 1.0f, AnimationSpecKt.spring$default(0.65f, 220.0f, null, 4, null), 0.0f, "thumb_scale", null, composerStartRestartGroup, 3120, 20);
                    float fCoerceAtMost = RangesKt.coerceAtMost(Math.abs(LiquidDock$lambda$6(mutableState2)) / 240.0f, 0.09f);
                    fLiquidDock$lambda$13 = LiquidDock$lambda$13(stateAnimateFloatAsState3) * (fCoerceAtMost + 1.0f);
                    fLiquidDock$lambda$14 = LiquidDock$lambda$13(stateAnimateFloatAsState3) * (1.0f - (fCoerceAtMost * 0.45f));
                    if (!LiquidDock$lambda$3(mutableState) || z4) {
                        f3 = 0.5f;
                    } else {
                        f3 = 0.25f;
                    }
                    stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f3, AnimationSpecKt.tween$default(ComposerKt.invocationKey, 0, null, 6, null), 0.0f, "specular_border", null, composerStartRestartGroup, 3120, 20);
                    stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(currentRoute, composerStartRestartGroup, i3 & 14);
                    stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(onNavigateHome, composerStartRestartGroup, (i3 >> 3) & 14);
                    stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(onNavigateHistory, composerStartRestartGroup, (i3 >> 6) & 14);
                    Modifier modifierM674paddingqDBjuR0$default = PaddingKt.m674paddingqDBjuR0$default(WindowInsetsPadding_androidKt.navigationBarsPadding(TestTagKt.testTag(modifier4, "liquid_dock")), 0.0f, 0.0f, 0.0f, Dp.m6261constructorimpl(16.0f), 7, null);
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1913948109, "CC(remember):GlassComponents.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(stateRememberUpdatedState) | composerStartRestartGroup.changed(fMo362toPx0680j_4) | composerStartRestartGroup.changed(stateRememberUpdatedState3) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                    f4 = fMo362toPx0680j_4;
                    glassComponentsKt$LiquidDock$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || glassComponentsKt$LiquidDock$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        GlassComponentsKt$LiquidDock$1$1 glassComponentsKt$LiquidDock$1$1 = new GlassComponentsKt$LiquidDock$1$1(stateRememberUpdatedState, f4, stateRememberUpdatedState3, stateRememberUpdatedState2, mutableState, mutableState2, null);
                        f4 = f4;
                        glassComponentsKt$LiquidDock$1$1RememberedValue = glassComponentsKt$LiquidDock$1$1;
                        composerStartRestartGroup.updateRememberedValue(glassComponentsKt$LiquidDock$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierM674paddingqDBjuR0$default, unit, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) glassComponentsKt$LiquidDock$1$1RememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1914022026, "CC(remember):GlassComponents.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    zChanged2 = composerStartRestartGroup.changed(stateAnimateFloatAsState2) | z5;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        z6 = z3;
                        objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlassComponentsKt.LiquidDock$lambda$17$lambda$16(z6, stateAnimateFloatAsState2, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        z6 = z3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierM670padding3ABfNKs = PaddingKt.m670padding3ABfNKs(DrawModifierKt.drawBehind(modifierPointerInput, (Function1) objRememberedValue3), Dp.m6261constructorimpl(6.0f));
                    Alignment centerStart = Alignment.INSTANCE.getCenterStart();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(centerStart, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM670padding3ABfNKs);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    z7 = z6;
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 909961163, "C287@11670L60,289@11803L101,294@11973L1332,285@11609L2501,340@14220L4398:GlassComponents.kt#75kw8w");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910314061, "CC(remember):GlassComponents.kt#9igjgp");
                    zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlassComponentsKt.LiquidDock$lambda$33$lambda$19$lambda$18(stateAnimateFloatAsState, (Density) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierM717sizeVpY3zN4 = SizeKt.m717sizeVpY3zN4(androidx.compose.foundation.layout.OffsetKt.offset(companion, (Function1) objRememberedValue4), fM6261constructorimpl, Dp.m6261constructorimpl(44.0f));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910309764, "CC(remember):GlassComponents.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(fLiquidDock$lambda$13) | composerStartRestartGroup.changed(fLiquidDock$lambda$14);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlassComponentsKt.LiquidDock$lambda$33$lambda$21$lambda$20(fLiquidDock$lambda$13, fLiquidDock$lambda$14, (GraphicsLayerScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierClip = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierM717sizeVpY3zN4, (Function1) objRememberedValue5), RoundedCornerShapeKt.getCircleShape());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910303093, "CC(remember):GlassComponents.kt#9igjgp");
                    zChanged5 = composerStartRestartGroup.changed(fAbs) | composerStartRestartGroup.changed(fCoerceIn2);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged5 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlassComponentsKt.LiquidDock$lambda$33$lambda$23$lambda$22(fAbs, fCoerceIn2, (ContentDrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierDrawWithContent = DrawModifierKt.drawWithContent(modifierClip, (Function1) objRememberedValue6);
                    if (z7) {
                        Brush.Companion companion2 = Brush.INSTANCE;
                        Color[] colorArr = new Color[2];
                        long jM3846getBlack0d7_KjU = Color.INSTANCE.m3846getBlack0d7_KjU();
                        if (LiquidDock$lambda$3(mutableState)) {
                            f11 = 0.32f;
                        } else {
                            f11 = 0.2f;
                        }
                        colorArr[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU, f11, 0.0f, 0.0f, 0.0f, 14, null));
                        long jM3846getBlack0d7_KjU2 = Color.INSTANCE.m3846getBlack0d7_KjU();
                        if (LiquidDock$lambda$3(mutableState)) {
                            f12 = 0.18f;
                        } else {
                            f12 = 0.1f;
                        }
                        colorArr[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU2, f12, 0.0f, 0.0f, 0.0f, 14, null));
                        brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion2, CollectionsKt.listOf((Object[]) colorArr), 0.0f, 0.0f, 0, 14, (Object) null);
                    } else {
                        Brush.Companion companion3 = Brush.INSTANCE;
                        Color[] colorArr2 = new Color[2];
                        long jM3857getWhite0d7_KjU = Color.INSTANCE.m3857getWhite0d7_KjU();
                        if (LiquidDock$lambda$3(mutableState)) {
                            f5 = 0.28f;
                        } else {
                            f5 = 0.16f;
                        }
                        colorArr2[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU, f5, 0.0f, 0.0f, 0.0f, 14, null));
                        long jM3857getWhite0d7_KjU2 = Color.INSTANCE.m3857getWhite0d7_KjU();
                        if (LiquidDock$lambda$3(mutableState)) {
                            f6 = 0.12f;
                        } else {
                            f6 = 0.05f;
                        }
                        colorArr2[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU2, f6, 0.0f, 0.0f, 0.0f, 14, null));
                        brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion3, CollectionsKt.listOf((Object[]) colorArr2), 0.0f, 0.0f, 0, 14, (Object) null);
                    }
                    BoxKt.Box(BackgroundKt.background$default(modifierDrawWithContent, brushM3777verticalGradient8A3gB4$default, null, 0.0f, 6, null), composerStartRestartGroup, 0);
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_4 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(0.0f));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                    Modifier.Companion companion4 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_4, centerVertically, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion4);
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
                    Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM3313constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 192075972, "C363@15540L1022,402@17562L1046:GlassComponents.kt#75kw8w");
                    float f14 = f4 / 2.0f;
                    float fLiquidDock$lambda$10 = LiquidDock$lambda$9(stateAnimateFloatAsState) + f14;
                    z8 = LiquidDock$lambda$9(stateAnimateFloatAsState) <= f14;
                    float f15 = (f14 - fLiquidDock$lambda$10) / f14;
                    float fCoerceIn6 = RangesKt.coerceIn(Math.abs(f15) / 1.35f, 0.0f, 1.0f);
                    fCoerceIn4 = RangesKt.coerceIn(1.0f - (fCoerceIn6 * fCoerceIn6), 0.0f, 1.0f);
                    float f16 = fLiquidDock$lambda$9 * 0.14f;
                    fSin = (((float) Math.sin(((double) f15) * 3.141592653589793d)) * density.mo362toPx0680j_4(Dp.m6261constructorimpl(8.0f)) * fCoerceIn4) + (f16 * fCoerceIn4);
                    float f17 = (fCoerceIn4 * 0.18f) + 1.0f;
                    float fCoerceIn7 = 1.0f - RangesKt.coerceIn(Math.abs(f15), 0.0f, 1.0f);
                    f7 = f17 * (1.0f - ((0.08f * fCoerceIn7) * fCoerceIn4));
                    f8 = f17 * ((fCoerceIn7 * 0.05f * fCoerceIn4) + 1.0f);
                    Modifier modifierTestTag = TestTagKt.testTag(ClipKt.clip(SizeKt.m717sizeVpY3zN4(Modifier.INSTANCE, fM6261constructorimpl, Dp.m6261constructorimpl(44.0f)), RoundedCornerShapeKt.getCircleShape()), "dock_tab_home");
                    Alignment center = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
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
                    Updater.m3320setimpl(composerM3313constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3320setimpl(composerM3313constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM3313constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m3320setimpl(composerM3313constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1598213862, "C379@16245L248,370@15796L752:GlassComponents.kt#75kw8w");
                    ImageVector home = HomeKt.getHome(Icons.INSTANCE.getDefault());
                    if (z8) {
                        if (z7) {
                            alpineOnSurfaceVariant = Color.INSTANCE.m3857getWhite0d7_KjU();
                        } else {
                            alpineOnSurfaceVariant = ColorKt.getAlpinePrimaryContainer();
                        }
                    } else if (z7) {
                        alpineOnSurfaceVariant = androidx.compose.ui.graphics.ColorKt.Color(4281549141L);
                    } else {
                        alpineOnSurfaceVariant = ColorKt.getAlpineOnSurfaceVariant();
                    }
                    Modifier.Companion companion5 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -779714843, "CC(remember):GlassComponents.kt#9igjgp");
                    zChanged6 = composerStartRestartGroup.changed(fSin) | composerStartRestartGroup.changed(f7) | composerStartRestartGroup.changed(f8) | composerStartRestartGroup.changed(fCoerceIn4);
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged6 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$27$lambda$26$lambda$25(fSin, f7, f8, fCoerceIn4, (GraphicsLayerScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    IconKt.m1811Iconww6aTOc(home, "首页", SizeKt.m715size3ABfNKs(GraphicsLayerModifierKt.graphicsLayer(companion5, (Function1) objRememberedValue7), Dp.m6261constructorimpl(24.0f)), alpineOnSurfaceVariant, composerStartRestartGroup, 48, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float f18 = ((f4 + f14) - fLiquidDock$lambda$10) / f14;
                    float fCoerceIn8 = RangesKt.coerceIn(Math.abs(f18) / 1.35f, 0.0f, 1.0f);
                    fCoerceIn5 = RangesKt.coerceIn(1.0f - (fCoerceIn8 * fCoerceIn8), 0.0f, 1.0f);
                    fSin2 = (((float) Math.sin(((double) f18) * 3.141592653589793d)) * density.mo362toPx0680j_4(Dp.m6261constructorimpl(8.0f)) * fCoerceIn5) + (f16 * fCoerceIn5);
                    float f19 = (fCoerceIn5 * 0.18f) + 1.0f;
                    float fCoerceIn9 = 1.0f - RangesKt.coerceIn(Math.abs(f18), 0.0f, 1.0f);
                    f9 = (1.0f - ((0.08f * fCoerceIn9) * fCoerceIn5)) * f19;
                    f10 = f19 * ((fCoerceIn9 * 0.05f * fCoerceIn5) + 1.0f);
                    Modifier modifierTestTag2 = TestTagKt.testTag(ClipKt.clip(SizeKt.m717sizeVpY3zN4(Modifier.INSTANCE, fM6261constructorimpl, Dp.m6261constructorimpl(44.0f)), RoundedCornerShapeKt.getCircleShape()), "dock_tab_history");
                    Alignment center2 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag2);
                    constructor4 = ComposeUiNode.INSTANCE.getConstructor();
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
                    Updater.m3320setimpl(composerM3313constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3320setimpl(composerM3313constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM3313constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        composerM3313constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        composerM3313constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    Updater.m3320setimpl(composerM3313constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1026813592, "C418@18279L260,409@17821L773:GlassComponents.kt#75kw8w");
                    ImageVector insights = InsightsKt.getInsights(Icons.INSTANCE.getDefault());
                    if (z8) {
                        if (z7) {
                            alpineOnSurfaceVariant2 = androidx.compose.ui.graphics.ColorKt.Color(4281549141L);
                        } else {
                            alpineOnSurfaceVariant2 = ColorKt.getAlpineOnSurfaceVariant();
                        }
                    } else if (z7) {
                        alpineOnSurfaceVariant2 = Color.INSTANCE.m3857getWhite0d7_KjU();
                    } else {
                        alpineOnSurfaceVariant2 = ColorKt.getAlpinePrimaryContainer();
                    }
                    Modifier.Companion companion6 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1972771526, "CC(remember):GlassComponents.kt#9igjgp");
                    zChanged7 = composerStartRestartGroup.changed(fSin2) | composerStartRestartGroup.changed(f9) | composerStartRestartGroup.changed(f10) | composerStartRestartGroup.changed(fCoerceIn5);
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged7 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue8 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29(fSin2, f9, f10, fCoerceIn5, (GraphicsLayerScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    IconKt.m1811Iconww6aTOc(insights, "骑行历史", SizeKt.m715size3ABfNKs(GraphicsLayerModifierKt.graphicsLayer(companion6, (Function1) objRememberedValue8), Dp.m6261constructorimpl(24.0f)), alpineOnSurfaceVariant2, composerStartRestartGroup, 48, 0);
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
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z9 = z7;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return GlassComponentsKt.LiquidDock$lambda$34(currentRoute, onNavigateHome, onNavigateHistory, z9, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            modifier2 = modifier;
            if ((i3 & 9363) != 9362) {
                if (i8 != 0) {
                    z2 = false;
                }
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(989699901, i3, -1, "com.example.ui.theme.LiquidDock (GlassComponents.kt:121)");
                }
                Intrinsics.areEqual(currentRoute, "home");
                if (Intrinsics.areEqual(currentRoute, "history")) {
                    i6 = 1;
                } else {
                    i6 = 1;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1913843039, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1913844924, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fM6261constructorimpl2 = Dp.m6261constructorimpl(76.0f);
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume2;
                fMo362toPx0680j_4 = density.mo362toPx0680j_4(fM6261constructorimpl2);
                f = i6 * fMo362toPx0680j_4;
                if (LiquidDock$lambda$3(mutableState)) {
                    fCoerceIn = RangesKt.coerceIn(LiquidDock$lambda$6(mutableState2) + f, 0.0f, fMo362toPx0680j_4);
                } else {
                    fCoerceIn = f;
                }
                if (LiquidDock$lambda$3(mutableState)) {
                    springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 10000.0f, null, 5, null);
                    i7 = 4;
                } else {
                    i7 = 4;
                    springSpecSpring$default = AnimationSpecKt.spring$default(0.45f, 180.0f, null, 4, null);
                }
                float f110 = fCoerceIn;
                Modifier modifier5 = modifier2;
                z3 = z2;
                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f110, springSpecSpring$default, 0.0f, "thumb_offset", null, composerStartRestartGroup, 3072, 20);
                float fLiquidDock$lambda$11 = LiquidDock$lambda$9(stateAnimateFloatAsState) - LiquidDock$lambda$10(AnimateAsStateKt.animateFloatAsState(f110, AnimationSpecKt.spring$default(0.55f, 85.0f, null, i7, null), 0.0f, "lagged_thumb_offset", null, composerStartRestartGroup, 3120, 20));
                fCoerceIn2 = RangesKt.coerceIn(fLiquidDock$lambda$11 / density.mo362toPx0680j_4(Dp.m6261constructorimpl(14.0f)), -1.0f, 1.0f);
                fAbs = Math.abs(fCoerceIn2);
                fAbs2 = Math.abs(LiquidDock$lambda$9(stateAnimateFloatAsState) - f);
                if (fMo362toPx0680j_4 > 0.0f) {
                    f2 = fMo362toPx0680j_4;
                } else {
                    f2 = 1.0f;
                }
                if (fAbs2 > density.mo362toPx0680j_4(Dp.m6261constructorimpl(3.0f))) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (LiquidDock$lambda$3(mutableState)) {
                    fCoerceIn3 = 1.0f;
                } else {
                    fCoerceIn3 = RangesKt.coerceIn(fAbs2 / (f2 * 0.7f), 0.0f, 1.0f);
                }
                State<Float> stateAnimateFloatAsState4 = AnimateAsStateKt.animateFloatAsState((fCoerceIn3 * 0.48f) + 1.0f, AnimationSpecKt.spring$default(0.65f, 220.0f, null, 4, null), 0.0f, "thumb_scale", null, composerStartRestartGroup, 3120, 20);
                float fCoerceAtMost2 = RangesKt.coerceAtMost(Math.abs(LiquidDock$lambda$6(mutableState2)) / 240.0f, 0.09f);
                fLiquidDock$lambda$13 = LiquidDock$lambda$13(stateAnimateFloatAsState4) * (fCoerceAtMost2 + 1.0f);
                fLiquidDock$lambda$14 = LiquidDock$lambda$13(stateAnimateFloatAsState4) * (1.0f - (fCoerceAtMost2 * 0.45f));
                if (LiquidDock$lambda$3(mutableState)) {
                    f3 = 0.5f;
                } else {
                    f3 = 0.5f;
                }
                stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f3, AnimationSpecKt.tween$default(ComposerKt.invocationKey, 0, null, 6, null), 0.0f, "specular_border", null, composerStartRestartGroup, 3120, 20);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(currentRoute, composerStartRestartGroup, i3 & 14);
                stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(onNavigateHome, composerStartRestartGroup, (i3 >> 3) & 14);
                stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(onNavigateHistory, composerStartRestartGroup, (i3 >> 6) & 14);
                Modifier modifierM674paddingqDBjuR0$default2 = PaddingKt.m674paddingqDBjuR0$default(WindowInsetsPadding_androidKt.navigationBarsPadding(TestTagKt.testTag(modifier5, "liquid_dock")), 0.0f, 0.0f, 0.0f, Dp.m6261constructorimpl(16.0f), 7, null);
                Unit unit2 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1913948109, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateRememberUpdatedState) | composerStartRestartGroup.changed(fMo362toPx0680j_4) | composerStartRestartGroup.changed(stateRememberUpdatedState3) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                f4 = fMo362toPx0680j_4;
                glassComponentsKt$LiquidDock$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    GlassComponentsKt$LiquidDock$1$1 glassComponentsKt$LiquidDock$1$2 = new GlassComponentsKt$LiquidDock$1$1(stateRememberUpdatedState, f4, stateRememberUpdatedState3, stateRememberUpdatedState2, mutableState, mutableState2, null);
                    f4 = f4;
                    glassComponentsKt$LiquidDock$1$1RememberedValue = glassComponentsKt$LiquidDock$1$2;
                    composerStartRestartGroup.updateRememberedValue(glassComponentsKt$LiquidDock$1$1RememberedValue);
                } else {
                    GlassComponentsKt$LiquidDock$1$1 glassComponentsKt$LiquidDock$1$3 = new GlassComponentsKt$LiquidDock$1$1(stateRememberUpdatedState, f4, stateRememberUpdatedState3, stateRememberUpdatedState2, mutableState, mutableState2, null);
                    f4 = f4;
                    glassComponentsKt$LiquidDock$1$1RememberedValue = glassComponentsKt$LiquidDock$1$3;
                    composerStartRestartGroup.updateRememberedValue(glassComponentsKt$LiquidDock$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierPointerInput2 = SuspendingPointerInputFilterKt.pointerInput(modifierM674paddingqDBjuR0$default2, unit2, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) glassComponentsKt$LiquidDock$1$1RememberedValue);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1914022026, "CC(remember):GlassComponents.kt#9igjgp");
                if ((i3 & 7168) == 2048) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                zChanged2 = composerStartRestartGroup.changed(stateAnimateFloatAsState2) | z5;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    z6 = z3;
                    objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$17$lambda$16(z6, stateAnimateFloatAsState2, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    z6 = z3;
                    objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$17$lambda$16(z6, stateAnimateFloatAsState2, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM670padding3ABfNKs2 = PaddingKt.m670padding3ABfNKs(DrawModifierKt.drawBehind(modifierPointerInput2, (Function1) objRememberedValue3), Dp.m6261constructorimpl(6.0f));
                Alignment centerStart2 = Alignment.INSTANCE.getCenterStart();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(centerStart2, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM670padding3ABfNKs2);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                z7 = z6;
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 909961163, "C287@11670L60,289@11803L101,294@11973L1332,285@11609L2501,340@14220L4398:GlassComponents.kt#75kw8w");
                Modifier.Companion companion7 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910314061, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$19$lambda$18(stateAnimateFloatAsState, (Density) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$19$lambda$18(stateAnimateFloatAsState, (Density) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM717sizeVpY3zN5 = SizeKt.m717sizeVpY3zN4(androidx.compose.foundation.layout.OffsetKt.offset(companion7, (Function1) objRememberedValue4), fM6261constructorimpl2, Dp.m6261constructorimpl(44.0f));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910309764, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged4 = composerStartRestartGroup.changed(fLiquidDock$lambda$13) | composerStartRestartGroup.changed(fLiquidDock$lambda$14);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$21$lambda$20(fLiquidDock$lambda$13, fLiquidDock$lambda$14, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$21$lambda$20(fLiquidDock$lambda$13, fLiquidDock$lambda$14, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierClip2 = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierM717sizeVpY3zN5, (Function1) objRememberedValue5), RoundedCornerShapeKt.getCircleShape());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910303093, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged5 = composerStartRestartGroup.changed(fAbs) | composerStartRestartGroup.changed(fCoerceIn2);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!zChanged5) {
                    objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$23$lambda$22(fAbs, fCoerceIn2, (ContentDrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$23$lambda$22(fAbs, fCoerceIn2, (ContentDrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierDrawWithContent2 = DrawModifierKt.drawWithContent(modifierClip2, (Function1) objRememberedValue6);
                if (z7) {
                    Brush.Companion companion8 = Brush.INSTANCE;
                    Color[] colorArr3 = new Color[2];
                    long jM3846getBlack0d7_KjU3 = Color.INSTANCE.m3846getBlack0d7_KjU();
                    if (LiquidDock$lambda$3(mutableState)) {
                        f11 = 0.32f;
                    } else {
                        f11 = 0.2f;
                    }
                    colorArr3[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU3, f11, 0.0f, 0.0f, 0.0f, 14, null));
                    long jM3846getBlack0d7_KjU4 = Color.INSTANCE.m3846getBlack0d7_KjU();
                    if (LiquidDock$lambda$3(mutableState)) {
                        f12 = 0.18f;
                    } else {
                        f12 = 0.1f;
                    }
                    colorArr3[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU4, f12, 0.0f, 0.0f, 0.0f, 14, null));
                    brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion8, CollectionsKt.listOf((Object[]) colorArr3), 0.0f, 0.0f, 0, 14, (Object) null);
                } else {
                    Brush.Companion companion9 = Brush.INSTANCE;
                    Color[] colorArr4 = new Color[2];
                    long jM3857getWhite0d7_KjU3 = Color.INSTANCE.m3857getWhite0d7_KjU();
                    if (LiquidDock$lambda$3(mutableState)) {
                        f5 = 0.28f;
                    } else {
                        f5 = 0.16f;
                    }
                    colorArr4[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU3, f5, 0.0f, 0.0f, 0.0f, 14, null));
                    long jM3857getWhite0d7_KjU4 = Color.INSTANCE.m3857getWhite0d7_KjU();
                    if (LiquidDock$lambda$3(mutableState)) {
                        f6 = 0.12f;
                    } else {
                        f6 = 0.05f;
                    }
                    colorArr4[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU4, f6, 0.0f, 0.0f, 0.0f, 14, null));
                    brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion9, CollectionsKt.listOf((Object[]) colorArr4), 0.0f, 0.0f, 0, 14, (Object) null);
                }
                BoxKt.Box(BackgroundKt.background$default(modifierDrawWithContent2, brushM3777verticalGradient8A3gB4$default, null, 0.0f, 6, null), composerStartRestartGroup, 0);
                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_5 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(0.0f));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                Modifier.Companion companion10 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_5, centerVertically2, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion10);
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
                Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl2.getInserting()) {
                    composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 192075972, "C363@15540L1022,402@17562L1046:GlassComponents.kt#75kw8w");
                float f111 = f4 / 2.0f;
                float fLiquidDock$lambda$12 = LiquidDock$lambda$9(stateAnimateFloatAsState) + f111;
                if (LiquidDock$lambda$9(stateAnimateFloatAsState) <= f111) {
                }
                float f112 = (f111 - fLiquidDock$lambda$12) / f111;
                float fCoerceIn10 = RangesKt.coerceIn(Math.abs(f112) / 1.35f, 0.0f, 1.0f);
                fCoerceIn4 = RangesKt.coerceIn(1.0f - (fCoerceIn10 * fCoerceIn10), 0.0f, 1.0f);
                float f113 = fLiquidDock$lambda$11 * 0.14f;
                fSin = (((float) Math.sin(((double) f112) * 3.141592653589793d)) * density.mo362toPx0680j_4(Dp.m6261constructorimpl(8.0f)) * fCoerceIn4) + (f113 * fCoerceIn4);
                float f114 = (fCoerceIn4 * 0.18f) + 1.0f;
                float fCoerceIn11 = 1.0f - RangesKt.coerceIn(Math.abs(f112), 0.0f, 1.0f);
                f7 = f114 * (1.0f - ((0.08f * fCoerceIn11) * fCoerceIn4));
                f8 = f114 * ((fCoerceIn11 * 0.05f * fCoerceIn4) + 1.0f);
                Modifier modifierTestTag3 = TestTagKt.testTag(ClipKt.clip(SizeKt.m717sizeVpY3zN4(Modifier.INSTANCE, fM6261constructorimpl2, Dp.m6261constructorimpl(44.0f)), RoundedCornerShapeKt.getCircleShape()), "dock_tab_home");
                Alignment center3 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag3);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
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
                Updater.m3320setimpl(composerM3313constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl3, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl3.getInserting()) {
                    composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                } else {
                    composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m3320setimpl(composerM3313constructorimpl3, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1598213862, "C379@16245L248,370@15796L752:GlassComponents.kt#75kw8w");
                ImageVector home2 = HomeKt.getHome(Icons.INSTANCE.getDefault());
                if (z8) {
                    if (z7) {
                        alpineOnSurfaceVariant = Color.INSTANCE.m3857getWhite0d7_KjU();
                    } else {
                        alpineOnSurfaceVariant = ColorKt.getAlpinePrimaryContainer();
                    }
                } else if (z7) {
                    alpineOnSurfaceVariant = androidx.compose.ui.graphics.ColorKt.Color(4281549141L);
                } else {
                    alpineOnSurfaceVariant = ColorKt.getAlpineOnSurfaceVariant();
                }
                Modifier.Companion companion11 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -779714843, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged6 = composerStartRestartGroup.changed(fSin) | composerStartRestartGroup.changed(f7) | composerStartRestartGroup.changed(f8) | composerStartRestartGroup.changed(fCoerceIn4);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (!zChanged6) {
                    objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$27$lambda$26$lambda$25(fSin, f7, f8, fCoerceIn4, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$27$lambda$26$lambda$25(fSin, f7, f8, fCoerceIn4, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                IconKt.m1811Iconww6aTOc(home2, "首页", SizeKt.m715size3ABfNKs(GraphicsLayerModifierKt.graphicsLayer(companion11, (Function1) objRememberedValue7), Dp.m6261constructorimpl(24.0f)), alpineOnSurfaceVariant, composerStartRestartGroup, 48, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float f115 = ((f4 + f111) - fLiquidDock$lambda$12) / f111;
                float fCoerceIn12 = RangesKt.coerceIn(Math.abs(f115) / 1.35f, 0.0f, 1.0f);
                fCoerceIn5 = RangesKt.coerceIn(1.0f - (fCoerceIn12 * fCoerceIn12), 0.0f, 1.0f);
                fSin2 = (((float) Math.sin(((double) f115) * 3.141592653589793d)) * density.mo362toPx0680j_4(Dp.m6261constructorimpl(8.0f)) * fCoerceIn5) + (f113 * fCoerceIn5);
                float f116 = (fCoerceIn5 * 0.18f) + 1.0f;
                float fCoerceIn13 = 1.0f - RangesKt.coerceIn(Math.abs(f115), 0.0f, 1.0f);
                f9 = (1.0f - ((0.08f * fCoerceIn13) * fCoerceIn5)) * f116;
                f10 = f116 * ((fCoerceIn13 * 0.05f * fCoerceIn5) + 1.0f);
                Modifier modifierTestTag4 = TestTagKt.testTag(ClipKt.clip(SizeKt.m717sizeVpY3zN4(Modifier.INSTANCE, fM6261constructorimpl2, Dp.m6261constructorimpl(44.0f)), RoundedCornerShapeKt.getCircleShape()), "dock_tab_history");
                Alignment center4 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(center4, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag4);
                constructor4 = ComposeUiNode.INSTANCE.getConstructor();
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
                Updater.m3320setimpl(composerM3313constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl4, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl4.getInserting()) {
                    composerM3313constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composerM3313constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                } else {
                    composerM3313constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composerM3313constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m3320setimpl(composerM3313constructorimpl4, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1026813592, "C418@18279L260,409@17821L773:GlassComponents.kt#75kw8w");
                ImageVector insights2 = InsightsKt.getInsights(Icons.INSTANCE.getDefault());
                if (z8) {
                    if (z7) {
                        alpineOnSurfaceVariant2 = Color.INSTANCE.m3857getWhite0d7_KjU();
                    } else {
                        alpineOnSurfaceVariant2 = ColorKt.getAlpinePrimaryContainer();
                    }
                } else if (z7) {
                    alpineOnSurfaceVariant2 = androidx.compose.ui.graphics.ColorKt.Color(4281549141L);
                } else {
                    alpineOnSurfaceVariant2 = ColorKt.getAlpineOnSurfaceVariant();
                }
                Modifier.Companion companion12 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1972771526, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged7 = composerStartRestartGroup.changed(fSin2) | composerStartRestartGroup.changed(f9) | composerStartRestartGroup.changed(f10) | composerStartRestartGroup.changed(fCoerceIn5);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (!zChanged7) {
                    objRememberedValue8 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29(fSin2, f9, f10, fCoerceIn5, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29(fSin2, f9, f10, fCoerceIn5, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                IconKt.m1811Iconww6aTOc(insights2, "骑行历史", SizeKt.m715size3ABfNKs(GraphicsLayerModifierKt.graphicsLayer(companion12, (Function1) objRememberedValue8), Dp.m6261constructorimpl(24.0f)), alpineOnSurfaceVariant2, composerStartRestartGroup, 48, 0);
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
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
                z9 = z7;
            } else {
                if (i8 != 0) {
                    z2 = false;
                }
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(989699901, i3, -1, "com.example.ui.theme.LiquidDock (GlassComponents.kt:121)");
                }
                Intrinsics.areEqual(currentRoute, "home");
                if (Intrinsics.areEqual(currentRoute, "history")) {
                    i6 = 1;
                } else {
                    i6 = 1;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1913843039, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1913844924, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fM6261constructorimpl3 = Dp.m6261constructorimpl(76.0f);
                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localDensity3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume3;
                fMo362toPx0680j_4 = density.mo362toPx0680j_4(fM6261constructorimpl3);
                f = i6 * fMo362toPx0680j_4;
                if (LiquidDock$lambda$3(mutableState)) {
                    fCoerceIn = RangesKt.coerceIn(LiquidDock$lambda$6(mutableState2) + f, 0.0f, fMo362toPx0680j_4);
                } else {
                    fCoerceIn = f;
                }
                if (LiquidDock$lambda$3(mutableState)) {
                    springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 10000.0f, null, 5, null);
                    i7 = 4;
                } else {
                    i7 = 4;
                    springSpecSpring$default = AnimationSpecKt.spring$default(0.45f, 180.0f, null, 4, null);
                }
                float f117 = fCoerceIn;
                Modifier modifier6 = modifier2;
                z3 = z2;
                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f117, springSpecSpring$default, 0.0f, "thumb_offset", null, composerStartRestartGroup, 3072, 20);
                float fLiquidDock$lambda$15 = LiquidDock$lambda$9(stateAnimateFloatAsState) - LiquidDock$lambda$10(AnimateAsStateKt.animateFloatAsState(f117, AnimationSpecKt.spring$default(0.55f, 85.0f, null, i7, null), 0.0f, "lagged_thumb_offset", null, composerStartRestartGroup, 3120, 20));
                fCoerceIn2 = RangesKt.coerceIn(fLiquidDock$lambda$15 / density.mo362toPx0680j_4(Dp.m6261constructorimpl(14.0f)), -1.0f, 1.0f);
                fAbs = Math.abs(fCoerceIn2);
                fAbs2 = Math.abs(LiquidDock$lambda$9(stateAnimateFloatAsState) - f);
                if (fMo362toPx0680j_4 > 0.0f) {
                    f2 = fMo362toPx0680j_4;
                } else {
                    f2 = 1.0f;
                }
                if (fAbs2 > density.mo362toPx0680j_4(Dp.m6261constructorimpl(3.0f))) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (LiquidDock$lambda$3(mutableState)) {
                    fCoerceIn3 = 1.0f;
                } else {
                    fCoerceIn3 = RangesKt.coerceIn(fAbs2 / (f2 * 0.7f), 0.0f, 1.0f);
                }
                State<Float> stateAnimateFloatAsState5 = AnimateAsStateKt.animateFloatAsState((fCoerceIn3 * 0.48f) + 1.0f, AnimationSpecKt.spring$default(0.65f, 220.0f, null, 4, null), 0.0f, "thumb_scale", null, composerStartRestartGroup, 3120, 20);
                float fCoerceAtMost3 = RangesKt.coerceAtMost(Math.abs(LiquidDock$lambda$6(mutableState2)) / 240.0f, 0.09f);
                fLiquidDock$lambda$13 = LiquidDock$lambda$13(stateAnimateFloatAsState5) * (fCoerceAtMost3 + 1.0f);
                fLiquidDock$lambda$14 = LiquidDock$lambda$13(stateAnimateFloatAsState5) * (1.0f - (fCoerceAtMost3 * 0.45f));
                if (LiquidDock$lambda$3(mutableState)) {
                    f3 = 0.5f;
                } else {
                    f3 = 0.5f;
                }
                stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f3, AnimationSpecKt.tween$default(ComposerKt.invocationKey, 0, null, 6, null), 0.0f, "specular_border", null, composerStartRestartGroup, 3120, 20);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(currentRoute, composerStartRestartGroup, i3 & 14);
                stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(onNavigateHome, composerStartRestartGroup, (i3 >> 3) & 14);
                stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(onNavigateHistory, composerStartRestartGroup, (i3 >> 6) & 14);
                Modifier modifierM674paddingqDBjuR0$default3 = PaddingKt.m674paddingqDBjuR0$default(WindowInsetsPadding_androidKt.navigationBarsPadding(TestTagKt.testTag(modifier6, "liquid_dock")), 0.0f, 0.0f, 0.0f, Dp.m6261constructorimpl(16.0f), 7, null);
                Unit unit3 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1913948109, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateRememberUpdatedState) | composerStartRestartGroup.changed(fMo362toPx0680j_4) | composerStartRestartGroup.changed(stateRememberUpdatedState3) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                f4 = fMo362toPx0680j_4;
                glassComponentsKt$LiquidDock$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    GlassComponentsKt$LiquidDock$1$1 glassComponentsKt$LiquidDock$1$4 = new GlassComponentsKt$LiquidDock$1$1(stateRememberUpdatedState, f4, stateRememberUpdatedState3, stateRememberUpdatedState2, mutableState, mutableState2, null);
                    f4 = f4;
                    glassComponentsKt$LiquidDock$1$1RememberedValue = glassComponentsKt$LiquidDock$1$4;
                    composerStartRestartGroup.updateRememberedValue(glassComponentsKt$LiquidDock$1$1RememberedValue);
                } else {
                    GlassComponentsKt$LiquidDock$1$1 glassComponentsKt$LiquidDock$1$5 = new GlassComponentsKt$LiquidDock$1$1(stateRememberUpdatedState, f4, stateRememberUpdatedState3, stateRememberUpdatedState2, mutableState, mutableState2, null);
                    f4 = f4;
                    glassComponentsKt$LiquidDock$1$1RememberedValue = glassComponentsKt$LiquidDock$1$5;
                    composerStartRestartGroup.updateRememberedValue(glassComponentsKt$LiquidDock$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierPointerInput3 = SuspendingPointerInputFilterKt.pointerInput(modifierM674paddingqDBjuR0$default3, unit3, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) glassComponentsKt$LiquidDock$1$1RememberedValue);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1914022026, "CC(remember):GlassComponents.kt#9igjgp");
                if ((i3 & 7168) == 2048) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                zChanged2 = composerStartRestartGroup.changed(stateAnimateFloatAsState2) | z5;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    z6 = z3;
                    objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$17$lambda$16(z6, stateAnimateFloatAsState2, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    z6 = z3;
                    objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$17$lambda$16(z6, stateAnimateFloatAsState2, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM670padding3ABfNKs3 = PaddingKt.m670padding3ABfNKs(DrawModifierKt.drawBehind(modifierPointerInput3, (Function1) objRememberedValue3), Dp.m6261constructorimpl(6.0f));
                Alignment centerStart3 = Alignment.INSTANCE.getCenterStart();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(centerStart3, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM670padding3ABfNKs3);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                z7 = z6;
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 909961163, "C287@11670L60,289@11803L101,294@11973L1332,285@11609L2501,340@14220L4398:GlassComponents.kt#75kw8w");
                Modifier.Companion companion13 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910314061, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$19$lambda$18(stateAnimateFloatAsState, (Density) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$19$lambda$18(stateAnimateFloatAsState, (Density) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM717sizeVpY3zN6 = SizeKt.m717sizeVpY3zN4(androidx.compose.foundation.layout.OffsetKt.offset(companion13, (Function1) objRememberedValue4), fM6261constructorimpl3, Dp.m6261constructorimpl(44.0f));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910309764, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged4 = composerStartRestartGroup.changed(fLiquidDock$lambda$13) | composerStartRestartGroup.changed(fLiquidDock$lambda$14);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$21$lambda$20(fLiquidDock$lambda$13, fLiquidDock$lambda$14, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$21$lambda$20(fLiquidDock$lambda$13, fLiquidDock$lambda$14, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierClip3 = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierM717sizeVpY3zN6, (Function1) objRememberedValue5), RoundedCornerShapeKt.getCircleShape());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910303093, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged5 = composerStartRestartGroup.changed(fAbs) | composerStartRestartGroup.changed(fCoerceIn2);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!zChanged5) {
                    objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$23$lambda$22(fAbs, fCoerceIn2, (ContentDrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$23$lambda$22(fAbs, fCoerceIn2, (ContentDrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierDrawWithContent3 = DrawModifierKt.drawWithContent(modifierClip3, (Function1) objRememberedValue6);
                if (z7) {
                    Brush.Companion companion14 = Brush.INSTANCE;
                    Color[] colorArr5 = new Color[2];
                    long jM3846getBlack0d7_KjU5 = Color.INSTANCE.m3846getBlack0d7_KjU();
                    if (LiquidDock$lambda$3(mutableState)) {
                        f11 = 0.32f;
                    } else {
                        f11 = 0.2f;
                    }
                    colorArr5[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU5, f11, 0.0f, 0.0f, 0.0f, 14, null));
                    long jM3846getBlack0d7_KjU6 = Color.INSTANCE.m3846getBlack0d7_KjU();
                    if (LiquidDock$lambda$3(mutableState)) {
                        f12 = 0.18f;
                    } else {
                        f12 = 0.1f;
                    }
                    colorArr5[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU6, f12, 0.0f, 0.0f, 0.0f, 14, null));
                    brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion14, CollectionsKt.listOf((Object[]) colorArr5), 0.0f, 0.0f, 0, 14, (Object) null);
                } else {
                    Brush.Companion companion15 = Brush.INSTANCE;
                    Color[] colorArr6 = new Color[2];
                    long jM3857getWhite0d7_KjU5 = Color.INSTANCE.m3857getWhite0d7_KjU();
                    if (LiquidDock$lambda$3(mutableState)) {
                        f5 = 0.28f;
                    } else {
                        f5 = 0.16f;
                    }
                    colorArr6[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU5, f5, 0.0f, 0.0f, 0.0f, 14, null));
                    long jM3857getWhite0d7_KjU6 = Color.INSTANCE.m3857getWhite0d7_KjU();
                    if (LiquidDock$lambda$3(mutableState)) {
                        f6 = 0.12f;
                    } else {
                        f6 = 0.05f;
                    }
                    colorArr6[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU6, f6, 0.0f, 0.0f, 0.0f, 14, null));
                    brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion15, CollectionsKt.listOf((Object[]) colorArr6), 0.0f, 0.0f, 0, 14, (Object) null);
                }
                BoxKt.Box(BackgroundKt.background$default(modifierDrawWithContent3, brushM3777verticalGradient8A3gB4$default, null, 0.0f, 6, null), composerStartRestartGroup, 0);
                Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_6 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(0.0f));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                Modifier.Companion companion16 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_6, centerVertically3, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion16);
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
                Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl2.getInserting()) {
                    composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 192075972, "C363@15540L1022,402@17562L1046:GlassComponents.kt#75kw8w");
                float f118 = f4 / 2.0f;
                float fLiquidDock$lambda$16 = LiquidDock$lambda$9(stateAnimateFloatAsState) + f118;
                if (LiquidDock$lambda$9(stateAnimateFloatAsState) <= f118) {
                }
                float f119 = (f118 - fLiquidDock$lambda$16) / f118;
                float fCoerceIn14 = RangesKt.coerceIn(Math.abs(f119) / 1.35f, 0.0f, 1.0f);
                fCoerceIn4 = RangesKt.coerceIn(1.0f - (fCoerceIn14 * fCoerceIn14), 0.0f, 1.0f);
                float f1110 = fLiquidDock$lambda$15 * 0.14f;
                fSin = (((float) Math.sin(((double) f119) * 3.141592653589793d)) * density.mo362toPx0680j_4(Dp.m6261constructorimpl(8.0f)) * fCoerceIn4) + (f1110 * fCoerceIn4);
                float f1111 = (fCoerceIn4 * 0.18f) + 1.0f;
                float fCoerceIn15 = 1.0f - RangesKt.coerceIn(Math.abs(f119), 0.0f, 1.0f);
                f7 = f1111 * (1.0f - ((0.08f * fCoerceIn15) * fCoerceIn4));
                f8 = f1111 * ((fCoerceIn15 * 0.05f * fCoerceIn4) + 1.0f);
                Modifier modifierTestTag5 = TestTagKt.testTag(ClipKt.clip(SizeKt.m717sizeVpY3zN4(Modifier.INSTANCE, fM6261constructorimpl3, Dp.m6261constructorimpl(44.0f)), RoundedCornerShapeKt.getCircleShape()), "dock_tab_home");
                Alignment center5 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(center5, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag5);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
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
                Updater.m3320setimpl(composerM3313constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl3, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl3.getInserting()) {
                    composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                } else {
                    composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m3320setimpl(composerM3313constructorimpl3, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1598213862, "C379@16245L248,370@15796L752:GlassComponents.kt#75kw8w");
                ImageVector home3 = HomeKt.getHome(Icons.INSTANCE.getDefault());
                if (z8) {
                    if (z7) {
                        alpineOnSurfaceVariant = Color.INSTANCE.m3857getWhite0d7_KjU();
                    } else {
                        alpineOnSurfaceVariant = ColorKt.getAlpinePrimaryContainer();
                    }
                } else if (z7) {
                    alpineOnSurfaceVariant = androidx.compose.ui.graphics.ColorKt.Color(4281549141L);
                } else {
                    alpineOnSurfaceVariant = ColorKt.getAlpineOnSurfaceVariant();
                }
                Modifier.Companion companion17 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -779714843, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged6 = composerStartRestartGroup.changed(fSin) | composerStartRestartGroup.changed(f7) | composerStartRestartGroup.changed(f8) | composerStartRestartGroup.changed(fCoerceIn4);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (!zChanged6) {
                    objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$27$lambda$26$lambda$25(fSin, f7, f8, fCoerceIn4, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$27$lambda$26$lambda$25(fSin, f7, f8, fCoerceIn4, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                IconKt.m1811Iconww6aTOc(home3, "首页", SizeKt.m715size3ABfNKs(GraphicsLayerModifierKt.graphicsLayer(companion17, (Function1) objRememberedValue7), Dp.m6261constructorimpl(24.0f)), alpineOnSurfaceVariant, composerStartRestartGroup, 48, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float f1112 = ((f4 + f118) - fLiquidDock$lambda$16) / f118;
                float fCoerceIn16 = RangesKt.coerceIn(Math.abs(f1112) / 1.35f, 0.0f, 1.0f);
                fCoerceIn5 = RangesKt.coerceIn(1.0f - (fCoerceIn16 * fCoerceIn16), 0.0f, 1.0f);
                fSin2 = (((float) Math.sin(((double) f1112) * 3.141592653589793d)) * density.mo362toPx0680j_4(Dp.m6261constructorimpl(8.0f)) * fCoerceIn5) + (f1110 * fCoerceIn5);
                float f1113 = (fCoerceIn5 * 0.18f) + 1.0f;
                float fCoerceIn17 = 1.0f - RangesKt.coerceIn(Math.abs(f1112), 0.0f, 1.0f);
                f9 = (1.0f - ((0.08f * fCoerceIn17) * fCoerceIn5)) * f1113;
                f10 = f1113 * ((fCoerceIn17 * 0.05f * fCoerceIn5) + 1.0f);
                Modifier modifierTestTag6 = TestTagKt.testTag(ClipKt.clip(SizeKt.m717sizeVpY3zN4(Modifier.INSTANCE, fM6261constructorimpl3, Dp.m6261constructorimpl(44.0f)), RoundedCornerShapeKt.getCircleShape()), "dock_tab_history");
                Alignment center6 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(center6, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag6);
                constructor4 = ComposeUiNode.INSTANCE.getConstructor();
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
                Updater.m3320setimpl(composerM3313constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl4, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl4.getInserting()) {
                    composerM3313constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composerM3313constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                } else {
                    composerM3313constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composerM3313constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m3320setimpl(composerM3313constructorimpl4, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1026813592, "C418@18279L260,409@17821L773:GlassComponents.kt#75kw8w");
                ImageVector insights3 = InsightsKt.getInsights(Icons.INSTANCE.getDefault());
                if (z8) {
                    if (z7) {
                        alpineOnSurfaceVariant2 = Color.INSTANCE.m3857getWhite0d7_KjU();
                    } else {
                        alpineOnSurfaceVariant2 = ColorKt.getAlpinePrimaryContainer();
                    }
                } else if (z7) {
                    alpineOnSurfaceVariant2 = androidx.compose.ui.graphics.ColorKt.Color(4281549141L);
                } else {
                    alpineOnSurfaceVariant2 = ColorKt.getAlpineOnSurfaceVariant();
                }
                Modifier.Companion companion18 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1972771526, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged7 = composerStartRestartGroup.changed(fSin2) | composerStartRestartGroup.changed(f9) | composerStartRestartGroup.changed(f10) | composerStartRestartGroup.changed(fCoerceIn5);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (!zChanged7) {
                    objRememberedValue8 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29(fSin2, f9, f10, fCoerceIn5, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29(fSin2, f9, f10, fCoerceIn5, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                IconKt.m1811Iconww6aTOc(insights3, "骑行历史", SizeKt.m715size3ABfNKs(GraphicsLayerModifierKt.graphicsLayer(companion18, (Function1) objRememberedValue8), Dp.m6261constructorimpl(24.0f)), alpineOnSurfaceVariant2, composerStartRestartGroup, 48, 0);
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
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier6;
                z9 = z7;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return GlassComponentsKt.LiquidDock$lambda$34(currentRoute, onNavigateHome, onNavigateHistory, z9, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z2 = z;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                if (composerStartRestartGroup.changed(modifier2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((i3 & 9363) != 9362) {
                if (i8 != 0) {
                    z2 = false;
                }
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(989699901, i3, -1, "com.example.ui.theme.LiquidDock (GlassComponents.kt:121)");
                }
                Intrinsics.areEqual(currentRoute, "home");
                if (Intrinsics.areEqual(currentRoute, "history")) {
                    i6 = 1;
                } else {
                    i6 = 1;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1913843039, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1913844924, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fM6261constructorimpl4 = Dp.m6261constructorimpl(76.0f);
                ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume4 = composerStartRestartGroup.consume(localDensity4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume4;
                fMo362toPx0680j_4 = density.mo362toPx0680j_4(fM6261constructorimpl4);
                f = i6 * fMo362toPx0680j_4;
                if (LiquidDock$lambda$3(mutableState)) {
                    fCoerceIn = RangesKt.coerceIn(LiquidDock$lambda$6(mutableState2) + f, 0.0f, fMo362toPx0680j_4);
                } else {
                    fCoerceIn = f;
                }
                if (LiquidDock$lambda$3(mutableState)) {
                    springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 10000.0f, null, 5, null);
                    i7 = 4;
                } else {
                    i7 = 4;
                    springSpecSpring$default = AnimationSpecKt.spring$default(0.45f, 180.0f, null, 4, null);
                }
                float f1114 = fCoerceIn;
                Modifier modifier7 = modifier2;
                z3 = z2;
                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f1114, springSpecSpring$default, 0.0f, "thumb_offset", null, composerStartRestartGroup, 3072, 20);
                float fLiquidDock$lambda$17 = LiquidDock$lambda$9(stateAnimateFloatAsState) - LiquidDock$lambda$10(AnimateAsStateKt.animateFloatAsState(f1114, AnimationSpecKt.spring$default(0.55f, 85.0f, null, i7, null), 0.0f, "lagged_thumb_offset", null, composerStartRestartGroup, 3120, 20));
                fCoerceIn2 = RangesKt.coerceIn(fLiquidDock$lambda$17 / density.mo362toPx0680j_4(Dp.m6261constructorimpl(14.0f)), -1.0f, 1.0f);
                fAbs = Math.abs(fCoerceIn2);
                fAbs2 = Math.abs(LiquidDock$lambda$9(stateAnimateFloatAsState) - f);
                if (fMo362toPx0680j_4 > 0.0f) {
                    f2 = fMo362toPx0680j_4;
                } else {
                    f2 = 1.0f;
                }
                if (fAbs2 > density.mo362toPx0680j_4(Dp.m6261constructorimpl(3.0f))) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (LiquidDock$lambda$3(mutableState)) {
                    fCoerceIn3 = 1.0f;
                } else {
                    fCoerceIn3 = RangesKt.coerceIn(fAbs2 / (f2 * 0.7f), 0.0f, 1.0f);
                }
                State<Float> stateAnimateFloatAsState6 = AnimateAsStateKt.animateFloatAsState((fCoerceIn3 * 0.48f) + 1.0f, AnimationSpecKt.spring$default(0.65f, 220.0f, null, 4, null), 0.0f, "thumb_scale", null, composerStartRestartGroup, 3120, 20);
                float fCoerceAtMost4 = RangesKt.coerceAtMost(Math.abs(LiquidDock$lambda$6(mutableState2)) / 240.0f, 0.09f);
                fLiquidDock$lambda$13 = LiquidDock$lambda$13(stateAnimateFloatAsState6) * (fCoerceAtMost4 + 1.0f);
                fLiquidDock$lambda$14 = LiquidDock$lambda$13(stateAnimateFloatAsState6) * (1.0f - (fCoerceAtMost4 * 0.45f));
                if (LiquidDock$lambda$3(mutableState)) {
                    f3 = 0.5f;
                } else {
                    f3 = 0.5f;
                }
                stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f3, AnimationSpecKt.tween$default(ComposerKt.invocationKey, 0, null, 6, null), 0.0f, "specular_border", null, composerStartRestartGroup, 3120, 20);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(currentRoute, composerStartRestartGroup, i3 & 14);
                stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(onNavigateHome, composerStartRestartGroup, (i3 >> 3) & 14);
                stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(onNavigateHistory, composerStartRestartGroup, (i3 >> 6) & 14);
                Modifier modifierM674paddingqDBjuR0$default4 = PaddingKt.m674paddingqDBjuR0$default(WindowInsetsPadding_androidKt.navigationBarsPadding(TestTagKt.testTag(modifier7, "liquid_dock")), 0.0f, 0.0f, 0.0f, Dp.m6261constructorimpl(16.0f), 7, null);
                Unit unit4 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1913948109, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateRememberUpdatedState) | composerStartRestartGroup.changed(fMo362toPx0680j_4) | composerStartRestartGroup.changed(stateRememberUpdatedState3) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                f4 = fMo362toPx0680j_4;
                glassComponentsKt$LiquidDock$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    GlassComponentsKt$LiquidDock$1$1 glassComponentsKt$LiquidDock$1$6 = new GlassComponentsKt$LiquidDock$1$1(stateRememberUpdatedState, f4, stateRememberUpdatedState3, stateRememberUpdatedState2, mutableState, mutableState2, null);
                    f4 = f4;
                    glassComponentsKt$LiquidDock$1$1RememberedValue = glassComponentsKt$LiquidDock$1$6;
                    composerStartRestartGroup.updateRememberedValue(glassComponentsKt$LiquidDock$1$1RememberedValue);
                } else {
                    GlassComponentsKt$LiquidDock$1$1 glassComponentsKt$LiquidDock$1$7 = new GlassComponentsKt$LiquidDock$1$1(stateRememberUpdatedState, f4, stateRememberUpdatedState3, stateRememberUpdatedState2, mutableState, mutableState2, null);
                    f4 = f4;
                    glassComponentsKt$LiquidDock$1$1RememberedValue = glassComponentsKt$LiquidDock$1$7;
                    composerStartRestartGroup.updateRememberedValue(glassComponentsKt$LiquidDock$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierPointerInput4 = SuspendingPointerInputFilterKt.pointerInput(modifierM674paddingqDBjuR0$default4, unit4, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) glassComponentsKt$LiquidDock$1$1RememberedValue);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1914022026, "CC(remember):GlassComponents.kt#9igjgp");
                if ((i3 & 7168) == 2048) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                zChanged2 = composerStartRestartGroup.changed(stateAnimateFloatAsState2) | z5;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    z6 = z3;
                    objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$17$lambda$16(z6, stateAnimateFloatAsState2, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    z6 = z3;
                    objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$17$lambda$16(z6, stateAnimateFloatAsState2, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM670padding3ABfNKs4 = PaddingKt.m670padding3ABfNKs(DrawModifierKt.drawBehind(modifierPointerInput4, (Function1) objRememberedValue3), Dp.m6261constructorimpl(6.0f));
                Alignment centerStart4 = Alignment.INSTANCE.getCenterStart();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy10 = BoxKt.maybeCachedBoxMeasurePolicy(centerStart4, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM670padding3ABfNKs4);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                z7 = z6;
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
                Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl.getInserting()) {
                    composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance10 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 909961163, "C287@11670L60,289@11803L101,294@11973L1332,285@11609L2501,340@14220L4398:GlassComponents.kt#75kw8w");
                Modifier.Companion companion19 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910314061, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$19$lambda$18(stateAnimateFloatAsState, (Density) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$19$lambda$18(stateAnimateFloatAsState, (Density) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM717sizeVpY3zN7 = SizeKt.m717sizeVpY3zN4(androidx.compose.foundation.layout.OffsetKt.offset(companion19, (Function1) objRememberedValue4), fM6261constructorimpl4, Dp.m6261constructorimpl(44.0f));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910309764, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged4 = composerStartRestartGroup.changed(fLiquidDock$lambda$13) | composerStartRestartGroup.changed(fLiquidDock$lambda$14);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$21$lambda$20(fLiquidDock$lambda$13, fLiquidDock$lambda$14, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$21$lambda$20(fLiquidDock$lambda$13, fLiquidDock$lambda$14, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierClip4 = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierM717sizeVpY3zN7, (Function1) objRememberedValue5), RoundedCornerShapeKt.getCircleShape());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910303093, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged5 = composerStartRestartGroup.changed(fAbs) | composerStartRestartGroup.changed(fCoerceIn2);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!zChanged5) {
                    objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$23$lambda$22(fAbs, fCoerceIn2, (ContentDrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$23$lambda$22(fAbs, fCoerceIn2, (ContentDrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierDrawWithContent4 = DrawModifierKt.drawWithContent(modifierClip4, (Function1) objRememberedValue6);
                if (z7) {
                    Brush.Companion companion110 = Brush.INSTANCE;
                    Color[] colorArr7 = new Color[2];
                    long jM3846getBlack0d7_KjU7 = Color.INSTANCE.m3846getBlack0d7_KjU();
                    if (LiquidDock$lambda$3(mutableState)) {
                        f11 = 0.32f;
                    } else {
                        f11 = 0.2f;
                    }
                    colorArr7[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU7, f11, 0.0f, 0.0f, 0.0f, 14, null));
                    long jM3846getBlack0d7_KjU8 = Color.INSTANCE.m3846getBlack0d7_KjU();
                    if (LiquidDock$lambda$3(mutableState)) {
                        f12 = 0.18f;
                    } else {
                        f12 = 0.1f;
                    }
                    colorArr7[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU8, f12, 0.0f, 0.0f, 0.0f, 14, null));
                    brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion110, CollectionsKt.listOf((Object[]) colorArr7), 0.0f, 0.0f, 0, 14, (Object) null);
                } else {
                    Brush.Companion companion111 = Brush.INSTANCE;
                    Color[] colorArr8 = new Color[2];
                    long jM3857getWhite0d7_KjU7 = Color.INSTANCE.m3857getWhite0d7_KjU();
                    if (LiquidDock$lambda$3(mutableState)) {
                        f5 = 0.28f;
                    } else {
                        f5 = 0.16f;
                    }
                    colorArr8[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU7, f5, 0.0f, 0.0f, 0.0f, 14, null));
                    long jM3857getWhite0d7_KjU8 = Color.INSTANCE.m3857getWhite0d7_KjU();
                    if (LiquidDock$lambda$3(mutableState)) {
                        f6 = 0.12f;
                    } else {
                        f6 = 0.05f;
                    }
                    colorArr8[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU8, f6, 0.0f, 0.0f, 0.0f, 14, null));
                    brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion111, CollectionsKt.listOf((Object[]) colorArr8), 0.0f, 0.0f, 0, 14, (Object) null);
                }
                BoxKt.Box(BackgroundKt.background$default(modifierDrawWithContent4, brushM3777verticalGradient8A3gB4$default, null, 0.0f, 6, null), composerStartRestartGroup, 0);
                Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_7 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(0.0f));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                Modifier.Companion companion112 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_7, centerVertically4, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion112);
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
                Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl2.getInserting()) {
                    composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 192075972, "C363@15540L1022,402@17562L1046:GlassComponents.kt#75kw8w");
                float f1115 = f4 / 2.0f;
                float fLiquidDock$lambda$18 = LiquidDock$lambda$9(stateAnimateFloatAsState) + f1115;
                if (LiquidDock$lambda$9(stateAnimateFloatAsState) <= f1115) {
                }
                float f1116 = (f1115 - fLiquidDock$lambda$18) / f1115;
                float fCoerceIn18 = RangesKt.coerceIn(Math.abs(f1116) / 1.35f, 0.0f, 1.0f);
                fCoerceIn4 = RangesKt.coerceIn(1.0f - (fCoerceIn18 * fCoerceIn18), 0.0f, 1.0f);
                float f1117 = fLiquidDock$lambda$17 * 0.14f;
                fSin = (((float) Math.sin(((double) f1116) * 3.141592653589793d)) * density.mo362toPx0680j_4(Dp.m6261constructorimpl(8.0f)) * fCoerceIn4) + (f1117 * fCoerceIn4);
                float f1118 = (fCoerceIn4 * 0.18f) + 1.0f;
                float fCoerceIn19 = 1.0f - RangesKt.coerceIn(Math.abs(f1116), 0.0f, 1.0f);
                f7 = f1118 * (1.0f - ((0.08f * fCoerceIn19) * fCoerceIn4));
                f8 = f1118 * ((fCoerceIn19 * 0.05f * fCoerceIn4) + 1.0f);
                Modifier modifierTestTag7 = TestTagKt.testTag(ClipKt.clip(SizeKt.m717sizeVpY3zN4(Modifier.INSTANCE, fM6261constructorimpl4, Dp.m6261constructorimpl(44.0f)), RoundedCornerShapeKt.getCircleShape()), "dock_tab_home");
                Alignment center7 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy11 = BoxKt.maybeCachedBoxMeasurePolicy(center7, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag7);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
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
                Updater.m3320setimpl(composerM3313constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl3, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl3.getInserting()) {
                    composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                } else {
                    composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m3320setimpl(composerM3313constructorimpl3, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance11 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1598213862, "C379@16245L248,370@15796L752:GlassComponents.kt#75kw8w");
                ImageVector home4 = HomeKt.getHome(Icons.INSTANCE.getDefault());
                if (z8) {
                    if (z7) {
                        alpineOnSurfaceVariant = Color.INSTANCE.m3857getWhite0d7_KjU();
                    } else {
                        alpineOnSurfaceVariant = ColorKt.getAlpinePrimaryContainer();
                    }
                } else if (z7) {
                    alpineOnSurfaceVariant = androidx.compose.ui.graphics.ColorKt.Color(4281549141L);
                } else {
                    alpineOnSurfaceVariant = ColorKt.getAlpineOnSurfaceVariant();
                }
                Modifier.Companion companion113 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -779714843, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged6 = composerStartRestartGroup.changed(fSin) | composerStartRestartGroup.changed(f7) | composerStartRestartGroup.changed(f8) | composerStartRestartGroup.changed(fCoerceIn4);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (!zChanged6) {
                    objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$27$lambda$26$lambda$25(fSin, f7, f8, fCoerceIn4, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$27$lambda$26$lambda$25(fSin, f7, f8, fCoerceIn4, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                IconKt.m1811Iconww6aTOc(home4, "首页", SizeKt.m715size3ABfNKs(GraphicsLayerModifierKt.graphicsLayer(companion113, (Function1) objRememberedValue7), Dp.m6261constructorimpl(24.0f)), alpineOnSurfaceVariant, composerStartRestartGroup, 48, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float f1119 = ((f4 + f1115) - fLiquidDock$lambda$18) / f1115;
                float fCoerceIn110 = RangesKt.coerceIn(Math.abs(f1119) / 1.35f, 0.0f, 1.0f);
                fCoerceIn5 = RangesKt.coerceIn(1.0f - (fCoerceIn110 * fCoerceIn110), 0.0f, 1.0f);
                fSin2 = (((float) Math.sin(((double) f1119) * 3.141592653589793d)) * density.mo362toPx0680j_4(Dp.m6261constructorimpl(8.0f)) * fCoerceIn5) + (f1117 * fCoerceIn5);
                float f11110 = (fCoerceIn5 * 0.18f) + 1.0f;
                float fCoerceIn111 = 1.0f - RangesKt.coerceIn(Math.abs(f1119), 0.0f, 1.0f);
                f9 = (1.0f - ((0.08f * fCoerceIn111) * fCoerceIn5)) * f11110;
                f10 = f11110 * ((fCoerceIn111 * 0.05f * fCoerceIn5) + 1.0f);
                Modifier modifierTestTag8 = TestTagKt.testTag(ClipKt.clip(SizeKt.m717sizeVpY3zN4(Modifier.INSTANCE, fM6261constructorimpl4, Dp.m6261constructorimpl(44.0f)), RoundedCornerShapeKt.getCircleShape()), "dock_tab_history");
                Alignment center8 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy12 = BoxKt.maybeCachedBoxMeasurePolicy(center8, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag8);
                constructor4 = ComposeUiNode.INSTANCE.getConstructor();
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
                Updater.m3320setimpl(composerM3313constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl4, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl4.getInserting()) {
                    composerM3313constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composerM3313constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                } else {
                    composerM3313constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composerM3313constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m3320setimpl(composerM3313constructorimpl4, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance12 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1026813592, "C418@18279L260,409@17821L773:GlassComponents.kt#75kw8w");
                ImageVector insights4 = InsightsKt.getInsights(Icons.INSTANCE.getDefault());
                if (z8) {
                    if (z7) {
                        alpineOnSurfaceVariant2 = Color.INSTANCE.m3857getWhite0d7_KjU();
                    } else {
                        alpineOnSurfaceVariant2 = ColorKt.getAlpinePrimaryContainer();
                    }
                } else if (z7) {
                    alpineOnSurfaceVariant2 = androidx.compose.ui.graphics.ColorKt.Color(4281549141L);
                } else {
                    alpineOnSurfaceVariant2 = ColorKt.getAlpineOnSurfaceVariant();
                }
                Modifier.Companion companion114 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1972771526, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged7 = composerStartRestartGroup.changed(fSin2) | composerStartRestartGroup.changed(f9) | composerStartRestartGroup.changed(f10) | composerStartRestartGroup.changed(fCoerceIn5);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (!zChanged7) {
                    objRememberedValue8 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29(fSin2, f9, f10, fCoerceIn5, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29(fSin2, f9, f10, fCoerceIn5, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                IconKt.m1811Iconww6aTOc(insights4, "骑行历史", SizeKt.m715size3ABfNKs(GraphicsLayerModifierKt.graphicsLayer(companion114, (Function1) objRememberedValue8), Dp.m6261constructorimpl(24.0f)), alpineOnSurfaceVariant2, composerStartRestartGroup, 48, 0);
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
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier7;
                z9 = z7;
            } else {
                if (i8 != 0) {
                    z2 = false;
                }
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(989699901, i3, -1, "com.example.ui.theme.LiquidDock (GlassComponents.kt:121)");
                }
                Intrinsics.areEqual(currentRoute, "home");
                if (Intrinsics.areEqual(currentRoute, "history")) {
                    i6 = 1;
                } else {
                    i6 = 1;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1913843039, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1913844924, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fM6261constructorimpl5 = Dp.m6261constructorimpl(76.0f);
                ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume5 = composerStartRestartGroup.consume(localDensity5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume5;
                fMo362toPx0680j_4 = density.mo362toPx0680j_4(fM6261constructorimpl5);
                f = i6 * fMo362toPx0680j_4;
                if (LiquidDock$lambda$3(mutableState)) {
                    fCoerceIn = RangesKt.coerceIn(LiquidDock$lambda$6(mutableState2) + f, 0.0f, fMo362toPx0680j_4);
                } else {
                    fCoerceIn = f;
                }
                if (LiquidDock$lambda$3(mutableState)) {
                    springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 10000.0f, null, 5, null);
                    i7 = 4;
                } else {
                    i7 = 4;
                    springSpecSpring$default = AnimationSpecKt.spring$default(0.45f, 180.0f, null, 4, null);
                }
                float f11111 = fCoerceIn;
                Modifier modifier8 = modifier2;
                z3 = z2;
                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f11111, springSpecSpring$default, 0.0f, "thumb_offset", null, composerStartRestartGroup, 3072, 20);
                float fLiquidDock$lambda$19 = LiquidDock$lambda$9(stateAnimateFloatAsState) - LiquidDock$lambda$10(AnimateAsStateKt.animateFloatAsState(f11111, AnimationSpecKt.spring$default(0.55f, 85.0f, null, i7, null), 0.0f, "lagged_thumb_offset", null, composerStartRestartGroup, 3120, 20));
                fCoerceIn2 = RangesKt.coerceIn(fLiquidDock$lambda$19 / density.mo362toPx0680j_4(Dp.m6261constructorimpl(14.0f)), -1.0f, 1.0f);
                fAbs = Math.abs(fCoerceIn2);
                fAbs2 = Math.abs(LiquidDock$lambda$9(stateAnimateFloatAsState) - f);
                if (fMo362toPx0680j_4 > 0.0f) {
                    f2 = fMo362toPx0680j_4;
                } else {
                    f2 = 1.0f;
                }
                if (fAbs2 > density.mo362toPx0680j_4(Dp.m6261constructorimpl(3.0f))) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (LiquidDock$lambda$3(mutableState)) {
                    fCoerceIn3 = 1.0f;
                } else {
                    fCoerceIn3 = RangesKt.coerceIn(fAbs2 / (f2 * 0.7f), 0.0f, 1.0f);
                }
                State<Float> stateAnimateFloatAsState7 = AnimateAsStateKt.animateFloatAsState((fCoerceIn3 * 0.48f) + 1.0f, AnimationSpecKt.spring$default(0.65f, 220.0f, null, 4, null), 0.0f, "thumb_scale", null, composerStartRestartGroup, 3120, 20);
                float fCoerceAtMost5 = RangesKt.coerceAtMost(Math.abs(LiquidDock$lambda$6(mutableState2)) / 240.0f, 0.09f);
                fLiquidDock$lambda$13 = LiquidDock$lambda$13(stateAnimateFloatAsState7) * (fCoerceAtMost5 + 1.0f);
                fLiquidDock$lambda$14 = LiquidDock$lambda$13(stateAnimateFloatAsState7) * (1.0f - (fCoerceAtMost5 * 0.45f));
                if (LiquidDock$lambda$3(mutableState)) {
                    f3 = 0.5f;
                } else {
                    f3 = 0.5f;
                }
                stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f3, AnimationSpecKt.tween$default(ComposerKt.invocationKey, 0, null, 6, null), 0.0f, "specular_border", null, composerStartRestartGroup, 3120, 20);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(currentRoute, composerStartRestartGroup, i3 & 14);
                stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(onNavigateHome, composerStartRestartGroup, (i3 >> 3) & 14);
                stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(onNavigateHistory, composerStartRestartGroup, (i3 >> 6) & 14);
                Modifier modifierM674paddingqDBjuR0$default5 = PaddingKt.m674paddingqDBjuR0$default(WindowInsetsPadding_androidKt.navigationBarsPadding(TestTagKt.testTag(modifier8, "liquid_dock")), 0.0f, 0.0f, 0.0f, Dp.m6261constructorimpl(16.0f), 7, null);
                Unit unit5 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1913948109, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateRememberUpdatedState) | composerStartRestartGroup.changed(fMo362toPx0680j_4) | composerStartRestartGroup.changed(stateRememberUpdatedState3) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
                f4 = fMo362toPx0680j_4;
                glassComponentsKt$LiquidDock$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    GlassComponentsKt$LiquidDock$1$1 glassComponentsKt$LiquidDock$1$8 = new GlassComponentsKt$LiquidDock$1$1(stateRememberUpdatedState, f4, stateRememberUpdatedState3, stateRememberUpdatedState2, mutableState, mutableState2, null);
                    f4 = f4;
                    glassComponentsKt$LiquidDock$1$1RememberedValue = glassComponentsKt$LiquidDock$1$8;
                    composerStartRestartGroup.updateRememberedValue(glassComponentsKt$LiquidDock$1$1RememberedValue);
                } else {
                    GlassComponentsKt$LiquidDock$1$1 glassComponentsKt$LiquidDock$1$9 = new GlassComponentsKt$LiquidDock$1$1(stateRememberUpdatedState, f4, stateRememberUpdatedState3, stateRememberUpdatedState2, mutableState, mutableState2, null);
                    f4 = f4;
                    glassComponentsKt$LiquidDock$1$1RememberedValue = glassComponentsKt$LiquidDock$1$9;
                    composerStartRestartGroup.updateRememberedValue(glassComponentsKt$LiquidDock$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierPointerInput5 = SuspendingPointerInputFilterKt.pointerInput(modifierM674paddingqDBjuR0$default5, unit5, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) glassComponentsKt$LiquidDock$1$1RememberedValue);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1914022026, "CC(remember):GlassComponents.kt#9igjgp");
                if ((i3 & 7168) == 2048) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                zChanged2 = composerStartRestartGroup.changed(stateAnimateFloatAsState2) | z5;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    z6 = z3;
                    objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$17$lambda$16(z6, stateAnimateFloatAsState2, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    z6 = z3;
                    objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$17$lambda$16(z6, stateAnimateFloatAsState2, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM670padding3ABfNKs5 = PaddingKt.m670padding3ABfNKs(DrawModifierKt.drawBehind(modifierPointerInput5, (Function1) objRememberedValue3), Dp.m6261constructorimpl(6.0f));
                Alignment centerStart5 = Alignment.INSTANCE.getCenterStart();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy13 = BoxKt.maybeCachedBoxMeasurePolicy(centerStart5, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap17 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier17 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM670padding3ABfNKs5);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                z7 = z6;
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
                Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap17, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl.getInserting()) {
                    composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier17, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance13 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 909961163, "C287@11670L60,289@11803L101,294@11973L1332,285@11609L2501,340@14220L4398:GlassComponents.kt#75kw8w");
                Modifier.Companion companion115 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910314061, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$19$lambda$18(stateAnimateFloatAsState, (Density) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$19$lambda$18(stateAnimateFloatAsState, (Density) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM717sizeVpY3zN8 = SizeKt.m717sizeVpY3zN4(androidx.compose.foundation.layout.OffsetKt.offset(companion115, (Function1) objRememberedValue4), fM6261constructorimpl5, Dp.m6261constructorimpl(44.0f));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910309764, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged4 = composerStartRestartGroup.changed(fLiquidDock$lambda$13) | composerStartRestartGroup.changed(fLiquidDock$lambda$14);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$21$lambda$20(fLiquidDock$lambda$13, fLiquidDock$lambda$14, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$21$lambda$20(fLiquidDock$lambda$13, fLiquidDock$lambda$14, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierClip5 = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierM717sizeVpY3zN8, (Function1) objRememberedValue5), RoundedCornerShapeKt.getCircleShape());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910303093, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged5 = composerStartRestartGroup.changed(fAbs) | composerStartRestartGroup.changed(fCoerceIn2);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!zChanged5) {
                    objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$23$lambda$22(fAbs, fCoerceIn2, (ContentDrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$23$lambda$22(fAbs, fCoerceIn2, (ContentDrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierDrawWithContent5 = DrawModifierKt.drawWithContent(modifierClip5, (Function1) objRememberedValue6);
                if (z7) {
                    Brush.Companion companion116 = Brush.INSTANCE;
                    Color[] colorArr9 = new Color[2];
                    long jM3846getBlack0d7_KjU9 = Color.INSTANCE.m3846getBlack0d7_KjU();
                    if (LiquidDock$lambda$3(mutableState)) {
                        f11 = 0.32f;
                    } else {
                        f11 = 0.2f;
                    }
                    colorArr9[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU9, f11, 0.0f, 0.0f, 0.0f, 14, null));
                    long jM3846getBlack0d7_KjU10 = Color.INSTANCE.m3846getBlack0d7_KjU();
                    if (LiquidDock$lambda$3(mutableState)) {
                        f12 = 0.18f;
                    } else {
                        f12 = 0.1f;
                    }
                    colorArr9[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU10, f12, 0.0f, 0.0f, 0.0f, 14, null));
                    brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion116, CollectionsKt.listOf((Object[]) colorArr9), 0.0f, 0.0f, 0, 14, (Object) null);
                } else {
                    Brush.Companion companion117 = Brush.INSTANCE;
                    Color[] colorArr10 = new Color[2];
                    long jM3857getWhite0d7_KjU9 = Color.INSTANCE.m3857getWhite0d7_KjU();
                    if (LiquidDock$lambda$3(mutableState)) {
                        f5 = 0.28f;
                    } else {
                        f5 = 0.16f;
                    }
                    colorArr10[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU9, f5, 0.0f, 0.0f, 0.0f, 14, null));
                    long jM3857getWhite0d7_KjU10 = Color.INSTANCE.m3857getWhite0d7_KjU();
                    if (LiquidDock$lambda$3(mutableState)) {
                        f6 = 0.12f;
                    } else {
                        f6 = 0.05f;
                    }
                    colorArr10[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU10, f6, 0.0f, 0.0f, 0.0f, 14, null));
                    brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion117, CollectionsKt.listOf((Object[]) colorArr10), 0.0f, 0.0f, 0, 14, (Object) null);
                }
                BoxKt.Box(BackgroundKt.background$default(modifierDrawWithContent5, brushM3777verticalGradient8A3gB4$default, null, 0.0f, 6, null), composerStartRestartGroup, 0);
                Alignment.Vertical centerVertically5 = Alignment.INSTANCE.getCenterVertically();
                Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_8 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(0.0f));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                Modifier.Companion companion118 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_8, centerVertically5, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap18 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier18 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion118);
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
                Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyRowMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap18, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl2.getInserting()) {
                    composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier18, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 192075972, "C363@15540L1022,402@17562L1046:GlassComponents.kt#75kw8w");
                float f11112 = f4 / 2.0f;
                float fLiquidDock$lambda$110 = LiquidDock$lambda$9(stateAnimateFloatAsState) + f11112;
                if (LiquidDock$lambda$9(stateAnimateFloatAsState) <= f11112) {
                }
                float f11113 = (f11112 - fLiquidDock$lambda$110) / f11112;
                float fCoerceIn112 = RangesKt.coerceIn(Math.abs(f11113) / 1.35f, 0.0f, 1.0f);
                fCoerceIn4 = RangesKt.coerceIn(1.0f - (fCoerceIn112 * fCoerceIn112), 0.0f, 1.0f);
                float f11114 = fLiquidDock$lambda$19 * 0.14f;
                fSin = (((float) Math.sin(((double) f11113) * 3.141592653589793d)) * density.mo362toPx0680j_4(Dp.m6261constructorimpl(8.0f)) * fCoerceIn4) + (f11114 * fCoerceIn4);
                float f11115 = (fCoerceIn4 * 0.18f) + 1.0f;
                float fCoerceIn113 = 1.0f - RangesKt.coerceIn(Math.abs(f11113), 0.0f, 1.0f);
                f7 = f11115 * (1.0f - ((0.08f * fCoerceIn113) * fCoerceIn4));
                f8 = f11115 * ((fCoerceIn113 * 0.05f * fCoerceIn4) + 1.0f);
                Modifier modifierTestTag9 = TestTagKt.testTag(ClipKt.clip(SizeKt.m717sizeVpY3zN4(Modifier.INSTANCE, fM6261constructorimpl5, Dp.m6261constructorimpl(44.0f)), RoundedCornerShapeKt.getCircleShape()), "dock_tab_home");
                Alignment center9 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy14 = BoxKt.maybeCachedBoxMeasurePolicy(center9, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap19 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier19 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag9);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
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
                Updater.m3320setimpl(composerM3313constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl3, currentCompositionLocalMap19, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl3.getInserting()) {
                    composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                } else {
                    composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m3320setimpl(composerM3313constructorimpl3, modifierMaterializeModifier19, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance14 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1598213862, "C379@16245L248,370@15796L752:GlassComponents.kt#75kw8w");
                ImageVector home5 = HomeKt.getHome(Icons.INSTANCE.getDefault());
                if (z8) {
                    if (z7) {
                        alpineOnSurfaceVariant = Color.INSTANCE.m3857getWhite0d7_KjU();
                    } else {
                        alpineOnSurfaceVariant = ColorKt.getAlpinePrimaryContainer();
                    }
                } else if (z7) {
                    alpineOnSurfaceVariant = androidx.compose.ui.graphics.ColorKt.Color(4281549141L);
                } else {
                    alpineOnSurfaceVariant = ColorKt.getAlpineOnSurfaceVariant();
                }
                Modifier.Companion companion119 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -779714843, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged6 = composerStartRestartGroup.changed(fSin) | composerStartRestartGroup.changed(f7) | composerStartRestartGroup.changed(f8) | composerStartRestartGroup.changed(fCoerceIn4);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (!zChanged6) {
                    objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$27$lambda$26$lambda$25(fSin, f7, f8, fCoerceIn4, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$27$lambda$26$lambda$25(fSin, f7, f8, fCoerceIn4, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                IconKt.m1811Iconww6aTOc(home5, "首页", SizeKt.m715size3ABfNKs(GraphicsLayerModifierKt.graphicsLayer(companion119, (Function1) objRememberedValue7), Dp.m6261constructorimpl(24.0f)), alpineOnSurfaceVariant, composerStartRestartGroup, 48, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float f11116 = ((f4 + f11112) - fLiquidDock$lambda$110) / f11112;
                float fCoerceIn114 = RangesKt.coerceIn(Math.abs(f11116) / 1.35f, 0.0f, 1.0f);
                fCoerceIn5 = RangesKt.coerceIn(1.0f - (fCoerceIn114 * fCoerceIn114), 0.0f, 1.0f);
                fSin2 = (((float) Math.sin(((double) f11116) * 3.141592653589793d)) * density.mo362toPx0680j_4(Dp.m6261constructorimpl(8.0f)) * fCoerceIn5) + (f11114 * fCoerceIn5);
                float f11117 = (fCoerceIn5 * 0.18f) + 1.0f;
                float fCoerceIn115 = 1.0f - RangesKt.coerceIn(Math.abs(f11116), 0.0f, 1.0f);
                f9 = (1.0f - ((0.08f * fCoerceIn115) * fCoerceIn5)) * f11117;
                f10 = f11117 * ((fCoerceIn115 * 0.05f * fCoerceIn5) + 1.0f);
                Modifier modifierTestTag10 = TestTagKt.testTag(ClipKt.clip(SizeKt.m717sizeVpY3zN4(Modifier.INSTANCE, fM6261constructorimpl5, Dp.m6261constructorimpl(44.0f)), RoundedCornerShapeKt.getCircleShape()), "dock_tab_history");
                Alignment center10 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy15 = BoxKt.maybeCachedBoxMeasurePolicy(center10, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier110 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag10);
                constructor4 = ComposeUiNode.INSTANCE.getConstructor();
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
                Updater.m3320setimpl(composerM3313constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl4, currentCompositionLocalMap110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl4.getInserting()) {
                    composerM3313constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composerM3313constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                } else {
                    composerM3313constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composerM3313constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m3320setimpl(composerM3313constructorimpl4, modifierMaterializeModifier110, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance15 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1026813592, "C418@18279L260,409@17821L773:GlassComponents.kt#75kw8w");
                ImageVector insights5 = InsightsKt.getInsights(Icons.INSTANCE.getDefault());
                if (z8) {
                    if (z7) {
                        alpineOnSurfaceVariant2 = Color.INSTANCE.m3857getWhite0d7_KjU();
                    } else {
                        alpineOnSurfaceVariant2 = ColorKt.getAlpinePrimaryContainer();
                    }
                } else if (z7) {
                    alpineOnSurfaceVariant2 = androidx.compose.ui.graphics.ColorKt.Color(4281549141L);
                } else {
                    alpineOnSurfaceVariant2 = ColorKt.getAlpineOnSurfaceVariant();
                }
                Modifier.Companion companion1110 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1972771526, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged7 = composerStartRestartGroup.changed(fSin2) | composerStartRestartGroup.changed(f9) | composerStartRestartGroup.changed(f10) | composerStartRestartGroup.changed(fCoerceIn5);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (!zChanged7) {
                    objRememberedValue8 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29(fSin2, f9, f10, fCoerceIn5, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29(fSin2, f9, f10, fCoerceIn5, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                IconKt.m1811Iconww6aTOc(insights5, "骑行历史", SizeKt.m715size3ABfNKs(GraphicsLayerModifierKt.graphicsLayer(companion1110, (Function1) objRememberedValue8), Dp.m6261constructorimpl(24.0f)), alpineOnSurfaceVariant2, composerStartRestartGroup, 48, 0);
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
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier8;
                z9 = z7;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return GlassComponentsKt.LiquidDock$lambda$34(currentRoute, onNavigateHome, onNavigateHistory, z9, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        modifier2 = modifier;
        if ((i3 & 9363) != 9362) {
            if (i8 != 0) {
                z2 = false;
            }
            if (i4 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(989699901, i3, -1, "com.example.ui.theme.LiquidDock (GlassComponents.kt:121)");
            }
            Intrinsics.areEqual(currentRoute, "home");
            if (Intrinsics.areEqual(currentRoute, "history")) {
                i6 = 1;
            } else {
                i6 = 1;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1913843039, "CC(remember):GlassComponents.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1913844924, "CC(remember):GlassComponents.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float fM6261constructorimpl6 = Dp.m6261constructorimpl(76.0f);
            ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume6 = composerStartRestartGroup.consume(localDensity6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume6;
            fMo362toPx0680j_4 = density.mo362toPx0680j_4(fM6261constructorimpl6);
            f = i6 * fMo362toPx0680j_4;
            if (LiquidDock$lambda$3(mutableState)) {
                fCoerceIn = RangesKt.coerceIn(LiquidDock$lambda$6(mutableState2) + f, 0.0f, fMo362toPx0680j_4);
            } else {
                fCoerceIn = f;
            }
            if (LiquidDock$lambda$3(mutableState)) {
                springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 10000.0f, null, 5, null);
                i7 = 4;
            } else {
                i7 = 4;
                springSpecSpring$default = AnimationSpecKt.spring$default(0.45f, 180.0f, null, 4, null);
            }
            float f11118 = fCoerceIn;
            Modifier modifier9 = modifier2;
            z3 = z2;
            stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f11118, springSpecSpring$default, 0.0f, "thumb_offset", null, composerStartRestartGroup, 3072, 20);
            float fLiquidDock$lambda$111 = LiquidDock$lambda$9(stateAnimateFloatAsState) - LiquidDock$lambda$10(AnimateAsStateKt.animateFloatAsState(f11118, AnimationSpecKt.spring$default(0.55f, 85.0f, null, i7, null), 0.0f, "lagged_thumb_offset", null, composerStartRestartGroup, 3120, 20));
            fCoerceIn2 = RangesKt.coerceIn(fLiquidDock$lambda$111 / density.mo362toPx0680j_4(Dp.m6261constructorimpl(14.0f)), -1.0f, 1.0f);
            fAbs = Math.abs(fCoerceIn2);
            fAbs2 = Math.abs(LiquidDock$lambda$9(stateAnimateFloatAsState) - f);
            if (fMo362toPx0680j_4 > 0.0f) {
                f2 = fMo362toPx0680j_4;
            } else {
                f2 = 1.0f;
            }
            if (fAbs2 > density.mo362toPx0680j_4(Dp.m6261constructorimpl(3.0f))) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (LiquidDock$lambda$3(mutableState)) {
                fCoerceIn3 = 1.0f;
            } else {
                fCoerceIn3 = RangesKt.coerceIn(fAbs2 / (f2 * 0.7f), 0.0f, 1.0f);
            }
            State<Float> stateAnimateFloatAsState8 = AnimateAsStateKt.animateFloatAsState((fCoerceIn3 * 0.48f) + 1.0f, AnimationSpecKt.spring$default(0.65f, 220.0f, null, 4, null), 0.0f, "thumb_scale", null, composerStartRestartGroup, 3120, 20);
            float fCoerceAtMost6 = RangesKt.coerceAtMost(Math.abs(LiquidDock$lambda$6(mutableState2)) / 240.0f, 0.09f);
            fLiquidDock$lambda$13 = LiquidDock$lambda$13(stateAnimateFloatAsState8) * (fCoerceAtMost6 + 1.0f);
            fLiquidDock$lambda$14 = LiquidDock$lambda$13(stateAnimateFloatAsState8) * (1.0f - (fCoerceAtMost6 * 0.45f));
            if (LiquidDock$lambda$3(mutableState)) {
                f3 = 0.5f;
            } else {
                f3 = 0.5f;
            }
            stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f3, AnimationSpecKt.tween$default(ComposerKt.invocationKey, 0, null, 6, null), 0.0f, "specular_border", null, composerStartRestartGroup, 3120, 20);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(currentRoute, composerStartRestartGroup, i3 & 14);
            stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(onNavigateHome, composerStartRestartGroup, (i3 >> 3) & 14);
            stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(onNavigateHistory, composerStartRestartGroup, (i3 >> 6) & 14);
            Modifier modifierM674paddingqDBjuR0$default6 = PaddingKt.m674paddingqDBjuR0$default(WindowInsetsPadding_androidKt.navigationBarsPadding(TestTagKt.testTag(modifier9, "liquid_dock")), 0.0f, 0.0f, 0.0f, Dp.m6261constructorimpl(16.0f), 7, null);
            Unit unit6 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1913948109, "CC(remember):GlassComponents.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateRememberUpdatedState) | composerStartRestartGroup.changed(fMo362toPx0680j_4) | composerStartRestartGroup.changed(stateRememberUpdatedState3) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
            f4 = fMo362toPx0680j_4;
            glassComponentsKt$LiquidDock$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                GlassComponentsKt$LiquidDock$1$1 glassComponentsKt$LiquidDock$1$10 = new GlassComponentsKt$LiquidDock$1$1(stateRememberUpdatedState, f4, stateRememberUpdatedState3, stateRememberUpdatedState2, mutableState, mutableState2, null);
                f4 = f4;
                glassComponentsKt$LiquidDock$1$1RememberedValue = glassComponentsKt$LiquidDock$1$10;
                composerStartRestartGroup.updateRememberedValue(glassComponentsKt$LiquidDock$1$1RememberedValue);
            } else {
                GlassComponentsKt$LiquidDock$1$1 glassComponentsKt$LiquidDock$1$11 = new GlassComponentsKt$LiquidDock$1$1(stateRememberUpdatedState, f4, stateRememberUpdatedState3, stateRememberUpdatedState2, mutableState, mutableState2, null);
                f4 = f4;
                glassComponentsKt$LiquidDock$1$1RememberedValue = glassComponentsKt$LiquidDock$1$11;
                composerStartRestartGroup.updateRememberedValue(glassComponentsKt$LiquidDock$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierPointerInput6 = SuspendingPointerInputFilterKt.pointerInput(modifierM674paddingqDBjuR0$default6, unit6, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) glassComponentsKt$LiquidDock$1$1RememberedValue);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1914022026, "CC(remember):GlassComponents.kt#9igjgp");
            if ((i3 & 7168) == 2048) {
                z5 = true;
            } else {
                z5 = false;
            }
            zChanged2 = composerStartRestartGroup.changed(stateAnimateFloatAsState2) | z5;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2) {
                z6 = z3;
                objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$17$lambda$16(z6, stateAnimateFloatAsState2, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                z6 = z3;
                objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$17$lambda$16(z6, stateAnimateFloatAsState2, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM670padding3ABfNKs6 = PaddingKt.m670padding3ABfNKs(DrawModifierKt.drawBehind(modifierPointerInput6, (Function1) objRememberedValue3), Dp.m6261constructorimpl(6.0f));
            Alignment centerStart6 = Alignment.INSTANCE.getCenterStart();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy16 = BoxKt.maybeCachedBoxMeasurePolicy(centerStart6, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM670padding3ABfNKs6);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            z7 = z6;
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
            Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap111, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3313constructorimpl.getInserting()) {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier111, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance16 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 909961163, "C287@11670L60,289@11803L101,294@11973L1332,285@11609L2501,340@14220L4398:GlassComponents.kt#75kw8w");
            Modifier.Companion companion1111 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910314061, "CC(remember):GlassComponents.kt#9igjgp");
            zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChanged3) {
                objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$33$lambda$19$lambda$18(stateAnimateFloatAsState, (Density) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$33$lambda$19$lambda$18(stateAnimateFloatAsState, (Density) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM717sizeVpY3zN9 = SizeKt.m717sizeVpY3zN4(androidx.compose.foundation.layout.OffsetKt.offset(companion1111, (Function1) objRememberedValue4), fM6261constructorimpl6, Dp.m6261constructorimpl(44.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910309764, "CC(remember):GlassComponents.kt#9igjgp");
            zChanged4 = composerStartRestartGroup.changed(fLiquidDock$lambda$13) | composerStartRestartGroup.changed(fLiquidDock$lambda$14);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (!zChanged4) {
                objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$33$lambda$21$lambda$20(fLiquidDock$lambda$13, fLiquidDock$lambda$14, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$33$lambda$21$lambda$20(fLiquidDock$lambda$13, fLiquidDock$lambda$14, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierClip6 = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierM717sizeVpY3zN9, (Function1) objRememberedValue5), RoundedCornerShapeKt.getCircleShape());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910303093, "CC(remember):GlassComponents.kt#9igjgp");
            zChanged5 = composerStartRestartGroup.changed(fAbs) | composerStartRestartGroup.changed(fCoerceIn2);
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (!zChanged5) {
                objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$33$lambda$23$lambda$22(fAbs, fCoerceIn2, (ContentDrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$33$lambda$23$lambda$22(fAbs, fCoerceIn2, (ContentDrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierDrawWithContent6 = DrawModifierKt.drawWithContent(modifierClip6, (Function1) objRememberedValue6);
            if (z7) {
                Brush.Companion companion1112 = Brush.INSTANCE;
                Color[] colorArr11 = new Color[2];
                long jM3846getBlack0d7_KjU11 = Color.INSTANCE.m3846getBlack0d7_KjU();
                if (LiquidDock$lambda$3(mutableState)) {
                    f11 = 0.32f;
                } else {
                    f11 = 0.2f;
                }
                colorArr11[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU11, f11, 0.0f, 0.0f, 0.0f, 14, null));
                long jM3846getBlack0d7_KjU12 = Color.INSTANCE.m3846getBlack0d7_KjU();
                if (LiquidDock$lambda$3(mutableState)) {
                    f12 = 0.18f;
                } else {
                    f12 = 0.1f;
                }
                colorArr11[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU12, f12, 0.0f, 0.0f, 0.0f, 14, null));
                brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion1112, CollectionsKt.listOf((Object[]) colorArr11), 0.0f, 0.0f, 0, 14, (Object) null);
            } else {
                Brush.Companion companion1113 = Brush.INSTANCE;
                Color[] colorArr12 = new Color[2];
                long jM3857getWhite0d7_KjU11 = Color.INSTANCE.m3857getWhite0d7_KjU();
                if (LiquidDock$lambda$3(mutableState)) {
                    f5 = 0.28f;
                } else {
                    f5 = 0.16f;
                }
                colorArr12[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU11, f5, 0.0f, 0.0f, 0.0f, 14, null));
                long jM3857getWhite0d7_KjU12 = Color.INSTANCE.m3857getWhite0d7_KjU();
                if (LiquidDock$lambda$3(mutableState)) {
                    f6 = 0.12f;
                } else {
                    f6 = 0.05f;
                }
                colorArr12[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU12, f6, 0.0f, 0.0f, 0.0f, 14, null));
                brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion1113, CollectionsKt.listOf((Object[]) colorArr12), 0.0f, 0.0f, 0, 14, (Object) null);
            }
            BoxKt.Box(BackgroundKt.background$default(modifierDrawWithContent6, brushM3777verticalGradient8A3gB4$default, null, 0.0f, 6, null), composerStartRestartGroup, 0);
            Alignment.Vertical centerVertically6 = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_9 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(0.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Modifier.Companion companion1114 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_9, centerVertically6, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion1114);
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
            Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyRowMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap112, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3313constructorimpl2.getInserting()) {
                composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier112, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance6 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 192075972, "C363@15540L1022,402@17562L1046:GlassComponents.kt#75kw8w");
            float f11119 = f4 / 2.0f;
            float fLiquidDock$lambda$112 = LiquidDock$lambda$9(stateAnimateFloatAsState) + f11119;
            if (LiquidDock$lambda$9(stateAnimateFloatAsState) <= f11119) {
            }
            float f111110 = (f11119 - fLiquidDock$lambda$112) / f11119;
            float fCoerceIn116 = RangesKt.coerceIn(Math.abs(f111110) / 1.35f, 0.0f, 1.0f);
            fCoerceIn4 = RangesKt.coerceIn(1.0f - (fCoerceIn116 * fCoerceIn116), 0.0f, 1.0f);
            float f111111 = fLiquidDock$lambda$111 * 0.14f;
            fSin = (((float) Math.sin(((double) f111110) * 3.141592653589793d)) * density.mo362toPx0680j_4(Dp.m6261constructorimpl(8.0f)) * fCoerceIn4) + (f111111 * fCoerceIn4);
            float f111112 = (fCoerceIn4 * 0.18f) + 1.0f;
            float fCoerceIn117 = 1.0f - RangesKt.coerceIn(Math.abs(f111110), 0.0f, 1.0f);
            f7 = f111112 * (1.0f - ((0.08f * fCoerceIn117) * fCoerceIn4));
            f8 = f111112 * ((fCoerceIn117 * 0.05f * fCoerceIn4) + 1.0f);
            Modifier modifierTestTag11 = TestTagKt.testTag(ClipKt.clip(SizeKt.m717sizeVpY3zN4(Modifier.INSTANCE, fM6261constructorimpl6, Dp.m6261constructorimpl(44.0f)), RoundedCornerShapeKt.getCircleShape()), "dock_tab_home");
            Alignment center11 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy17 = BoxKt.maybeCachedBoxMeasurePolicy(center11, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap113 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier113 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag11);
            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
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
            Updater.m3320setimpl(composerM3313constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy17, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl3, currentCompositionLocalMap113, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3313constructorimpl3.getInserting()) {
                composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            } else {
                composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3320setimpl(composerM3313constructorimpl3, modifierMaterializeModifier113, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance17 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1598213862, "C379@16245L248,370@15796L752:GlassComponents.kt#75kw8w");
            ImageVector home6 = HomeKt.getHome(Icons.INSTANCE.getDefault());
            if (z8) {
                if (z7) {
                    alpineOnSurfaceVariant = Color.INSTANCE.m3857getWhite0d7_KjU();
                } else {
                    alpineOnSurfaceVariant = ColorKt.getAlpinePrimaryContainer();
                }
            } else if (z7) {
                alpineOnSurfaceVariant = androidx.compose.ui.graphics.ColorKt.Color(4281549141L);
            } else {
                alpineOnSurfaceVariant = ColorKt.getAlpineOnSurfaceVariant();
            }
            Modifier.Companion companion1115 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -779714843, "CC(remember):GlassComponents.kt#9igjgp");
            zChanged6 = composerStartRestartGroup.changed(fSin) | composerStartRestartGroup.changed(f7) | composerStartRestartGroup.changed(f8) | composerStartRestartGroup.changed(fCoerceIn4);
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (!zChanged6) {
                objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$27$lambda$26$lambda$25(fSin, f7, f8, fCoerceIn4, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            } else {
                objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$27$lambda$26$lambda$25(fSin, f7, f8, fCoerceIn4, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            IconKt.m1811Iconww6aTOc(home6, "首页", SizeKt.m715size3ABfNKs(GraphicsLayerModifierKt.graphicsLayer(companion1115, (Function1) objRememberedValue7), Dp.m6261constructorimpl(24.0f)), alpineOnSurfaceVariant, composerStartRestartGroup, 48, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float f111113 = ((f4 + f11119) - fLiquidDock$lambda$112) / f11119;
            float fCoerceIn118 = RangesKt.coerceIn(Math.abs(f111113) / 1.35f, 0.0f, 1.0f);
            fCoerceIn5 = RangesKt.coerceIn(1.0f - (fCoerceIn118 * fCoerceIn118), 0.0f, 1.0f);
            fSin2 = (((float) Math.sin(((double) f111113) * 3.141592653589793d)) * density.mo362toPx0680j_4(Dp.m6261constructorimpl(8.0f)) * fCoerceIn5) + (f111111 * fCoerceIn5);
            float f111114 = (fCoerceIn5 * 0.18f) + 1.0f;
            float fCoerceIn119 = 1.0f - RangesKt.coerceIn(Math.abs(f111113), 0.0f, 1.0f);
            f9 = (1.0f - ((0.08f * fCoerceIn119) * fCoerceIn5)) * f111114;
            f10 = f111114 * ((fCoerceIn119 * 0.05f * fCoerceIn5) + 1.0f);
            Modifier modifierTestTag12 = TestTagKt.testTag(ClipKt.clip(SizeKt.m717sizeVpY3zN4(Modifier.INSTANCE, fM6261constructorimpl6, Dp.m6261constructorimpl(44.0f)), RoundedCornerShapeKt.getCircleShape()), "dock_tab_history");
            Alignment center12 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy18 = BoxKt.maybeCachedBoxMeasurePolicy(center12, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier114 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag12);
            constructor4 = ComposeUiNode.INSTANCE.getConstructor();
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
            Updater.m3320setimpl(composerM3313constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy18, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl4, currentCompositionLocalMap114, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3313constructorimpl4.getInserting()) {
                composerM3313constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composerM3313constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            } else {
                composerM3313constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composerM3313constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3320setimpl(composerM3313constructorimpl4, modifierMaterializeModifier114, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance18 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1026813592, "C418@18279L260,409@17821L773:GlassComponents.kt#75kw8w");
            ImageVector insights6 = InsightsKt.getInsights(Icons.INSTANCE.getDefault());
            if (z8) {
                if (z7) {
                    alpineOnSurfaceVariant2 = Color.INSTANCE.m3857getWhite0d7_KjU();
                } else {
                    alpineOnSurfaceVariant2 = ColorKt.getAlpinePrimaryContainer();
                }
            } else if (z7) {
                alpineOnSurfaceVariant2 = androidx.compose.ui.graphics.ColorKt.Color(4281549141L);
            } else {
                alpineOnSurfaceVariant2 = ColorKt.getAlpineOnSurfaceVariant();
            }
            Modifier.Companion companion1116 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1972771526, "CC(remember):GlassComponents.kt#9igjgp");
            zChanged7 = composerStartRestartGroup.changed(fSin2) | composerStartRestartGroup.changed(f9) | composerStartRestartGroup.changed(f10) | composerStartRestartGroup.changed(fCoerceIn5);
            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (!zChanged7) {
                objRememberedValue8 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29(fSin2, f9, f10, fCoerceIn5, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29(fSin2, f9, f10, fCoerceIn5, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            IconKt.m1811Iconww6aTOc(insights6, "骑行历史", SizeKt.m715size3ABfNKs(GraphicsLayerModifierKt.graphicsLayer(companion1116, (Function1) objRememberedValue8), Dp.m6261constructorimpl(24.0f)), alpineOnSurfaceVariant2, composerStartRestartGroup, 48, 0);
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
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier9;
            z9 = z7;
        } else {
            if (i8 != 0) {
                z2 = false;
            }
            if (i4 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(989699901, i3, -1, "com.example.ui.theme.LiquidDock (GlassComponents.kt:121)");
            }
            Intrinsics.areEqual(currentRoute, "home");
            if (Intrinsics.areEqual(currentRoute, "history")) {
                i6 = 1;
            } else {
                i6 = 1;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1913843039, "CC(remember):GlassComponents.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1913844924, "CC(remember):GlassComponents.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float fM6261constructorimpl7 = Dp.m6261constructorimpl(76.0f);
            ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume7 = composerStartRestartGroup.consume(localDensity7);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume7;
            fMo362toPx0680j_4 = density.mo362toPx0680j_4(fM6261constructorimpl7);
            f = i6 * fMo362toPx0680j_4;
            if (LiquidDock$lambda$3(mutableState)) {
                fCoerceIn = RangesKt.coerceIn(LiquidDock$lambda$6(mutableState2) + f, 0.0f, fMo362toPx0680j_4);
            } else {
                fCoerceIn = f;
            }
            if (LiquidDock$lambda$3(mutableState)) {
                springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 10000.0f, null, 5, null);
                i7 = 4;
            } else {
                i7 = 4;
                springSpecSpring$default = AnimationSpecKt.spring$default(0.45f, 180.0f, null, 4, null);
            }
            float f111115 = fCoerceIn;
            Modifier modifier10 = modifier2;
            z3 = z2;
            stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f111115, springSpecSpring$default, 0.0f, "thumb_offset", null, composerStartRestartGroup, 3072, 20);
            float fLiquidDock$lambda$113 = LiquidDock$lambda$9(stateAnimateFloatAsState) - LiquidDock$lambda$10(AnimateAsStateKt.animateFloatAsState(f111115, AnimationSpecKt.spring$default(0.55f, 85.0f, null, i7, null), 0.0f, "lagged_thumb_offset", null, composerStartRestartGroup, 3120, 20));
            fCoerceIn2 = RangesKt.coerceIn(fLiquidDock$lambda$113 / density.mo362toPx0680j_4(Dp.m6261constructorimpl(14.0f)), -1.0f, 1.0f);
            fAbs = Math.abs(fCoerceIn2);
            fAbs2 = Math.abs(LiquidDock$lambda$9(stateAnimateFloatAsState) - f);
            if (fMo362toPx0680j_4 > 0.0f) {
                f2 = fMo362toPx0680j_4;
            } else {
                f2 = 1.0f;
            }
            if (fAbs2 > density.mo362toPx0680j_4(Dp.m6261constructorimpl(3.0f))) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (LiquidDock$lambda$3(mutableState)) {
                fCoerceIn3 = 1.0f;
            } else {
                fCoerceIn3 = RangesKt.coerceIn(fAbs2 / (f2 * 0.7f), 0.0f, 1.0f);
            }
            State<Float> stateAnimateFloatAsState9 = AnimateAsStateKt.animateFloatAsState((fCoerceIn3 * 0.48f) + 1.0f, AnimationSpecKt.spring$default(0.65f, 220.0f, null, 4, null), 0.0f, "thumb_scale", null, composerStartRestartGroup, 3120, 20);
            float fCoerceAtMost7 = RangesKt.coerceAtMost(Math.abs(LiquidDock$lambda$6(mutableState2)) / 240.0f, 0.09f);
            fLiquidDock$lambda$13 = LiquidDock$lambda$13(stateAnimateFloatAsState9) * (fCoerceAtMost7 + 1.0f);
            fLiquidDock$lambda$14 = LiquidDock$lambda$13(stateAnimateFloatAsState9) * (1.0f - (fCoerceAtMost7 * 0.45f));
            if (LiquidDock$lambda$3(mutableState)) {
                f3 = 0.5f;
            } else {
                f3 = 0.5f;
            }
            stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f3, AnimationSpecKt.tween$default(ComposerKt.invocationKey, 0, null, 6, null), 0.0f, "specular_border", null, composerStartRestartGroup, 3120, 20);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(currentRoute, composerStartRestartGroup, i3 & 14);
            stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(onNavigateHome, composerStartRestartGroup, (i3 >> 3) & 14);
            stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(onNavigateHistory, composerStartRestartGroup, (i3 >> 6) & 14);
            Modifier modifierM674paddingqDBjuR0$default7 = PaddingKt.m674paddingqDBjuR0$default(WindowInsetsPadding_androidKt.navigationBarsPadding(TestTagKt.testTag(modifier10, "liquid_dock")), 0.0f, 0.0f, 0.0f, Dp.m6261constructorimpl(16.0f), 7, null);
            Unit unit7 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1913948109, "CC(remember):GlassComponents.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateRememberUpdatedState) | composerStartRestartGroup.changed(fMo362toPx0680j_4) | composerStartRestartGroup.changed(stateRememberUpdatedState3) | composerStartRestartGroup.changed(stateRememberUpdatedState2);
            f4 = fMo362toPx0680j_4;
            glassComponentsKt$LiquidDock$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                GlassComponentsKt$LiquidDock$1$1 glassComponentsKt$LiquidDock$1$12 = new GlassComponentsKt$LiquidDock$1$1(stateRememberUpdatedState, f4, stateRememberUpdatedState3, stateRememberUpdatedState2, mutableState, mutableState2, null);
                f4 = f4;
                glassComponentsKt$LiquidDock$1$1RememberedValue = glassComponentsKt$LiquidDock$1$12;
                composerStartRestartGroup.updateRememberedValue(glassComponentsKt$LiquidDock$1$1RememberedValue);
            } else {
                GlassComponentsKt$LiquidDock$1$1 glassComponentsKt$LiquidDock$1$13 = new GlassComponentsKt$LiquidDock$1$1(stateRememberUpdatedState, f4, stateRememberUpdatedState3, stateRememberUpdatedState2, mutableState, mutableState2, null);
                f4 = f4;
                glassComponentsKt$LiquidDock$1$1RememberedValue = glassComponentsKt$LiquidDock$1$13;
                composerStartRestartGroup.updateRememberedValue(glassComponentsKt$LiquidDock$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierPointerInput7 = SuspendingPointerInputFilterKt.pointerInput(modifierM674paddingqDBjuR0$default7, unit7, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) glassComponentsKt$LiquidDock$1$1RememberedValue);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1914022026, "CC(remember):GlassComponents.kt#9igjgp");
            if ((i3 & 7168) == 2048) {
                z5 = true;
            } else {
                z5 = false;
            }
            zChanged2 = composerStartRestartGroup.changed(stateAnimateFloatAsState2) | z5;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2) {
                z6 = z3;
                objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$17$lambda$16(z6, stateAnimateFloatAsState2, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                z6 = z3;
                objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$17$lambda$16(z6, stateAnimateFloatAsState2, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM670padding3ABfNKs7 = PaddingKt.m670padding3ABfNKs(DrawModifierKt.drawBehind(modifierPointerInput7, (Function1) objRememberedValue3), Dp.m6261constructorimpl(6.0f));
            Alignment centerStart7 = Alignment.INSTANCE.getCenterStart();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy19 = BoxKt.maybeCachedBoxMeasurePolicy(centerStart7, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap115 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier115 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM670padding3ABfNKs7);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            z7 = z6;
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
            Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy19, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap115, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3313constructorimpl.getInserting()) {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier115, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance19 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 909961163, "C287@11670L60,289@11803L101,294@11973L1332,285@11609L2501,340@14220L4398:GlassComponents.kt#75kw8w");
            Modifier.Companion companion1117 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910314061, "CC(remember):GlassComponents.kt#9igjgp");
            zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChanged3) {
                objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$33$lambda$19$lambda$18(stateAnimateFloatAsState, (Density) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$33$lambda$19$lambda$18(stateAnimateFloatAsState, (Density) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM717sizeVpY3zN10 = SizeKt.m717sizeVpY3zN4(androidx.compose.foundation.layout.OffsetKt.offset(companion1117, (Function1) objRememberedValue4), fM6261constructorimpl7, Dp.m6261constructorimpl(44.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910309764, "CC(remember):GlassComponents.kt#9igjgp");
            zChanged4 = composerStartRestartGroup.changed(fLiquidDock$lambda$13) | composerStartRestartGroup.changed(fLiquidDock$lambda$14);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (!zChanged4) {
                objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$33$lambda$21$lambda$20(fLiquidDock$lambda$13, fLiquidDock$lambda$14, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$33$lambda$21$lambda$20(fLiquidDock$lambda$13, fLiquidDock$lambda$14, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierClip7 = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierM717sizeVpY3zN10, (Function1) objRememberedValue5), RoundedCornerShapeKt.getCircleShape());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1910303093, "CC(remember):GlassComponents.kt#9igjgp");
            zChanged5 = composerStartRestartGroup.changed(fAbs) | composerStartRestartGroup.changed(fCoerceIn2);
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (!zChanged5) {
                objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$33$lambda$23$lambda$22(fAbs, fCoerceIn2, (ContentDrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$33$lambda$23$lambda$22(fAbs, fCoerceIn2, (ContentDrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierDrawWithContent7 = DrawModifierKt.drawWithContent(modifierClip7, (Function1) objRememberedValue6);
            if (z7) {
                Brush.Companion companion1118 = Brush.INSTANCE;
                Color[] colorArr13 = new Color[2];
                long jM3846getBlack0d7_KjU13 = Color.INSTANCE.m3846getBlack0d7_KjU();
                if (LiquidDock$lambda$3(mutableState)) {
                    f11 = 0.32f;
                } else {
                    f11 = 0.2f;
                }
                colorArr13[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU13, f11, 0.0f, 0.0f, 0.0f, 14, null));
                long jM3846getBlack0d7_KjU14 = Color.INSTANCE.m3846getBlack0d7_KjU();
                if (LiquidDock$lambda$3(mutableState)) {
                    f12 = 0.18f;
                } else {
                    f12 = 0.1f;
                }
                colorArr13[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU14, f12, 0.0f, 0.0f, 0.0f, 14, null));
                brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion1118, CollectionsKt.listOf((Object[]) colorArr13), 0.0f, 0.0f, 0, 14, (Object) null);
            } else {
                Brush.Companion companion1119 = Brush.INSTANCE;
                Color[] colorArr14 = new Color[2];
                long jM3857getWhite0d7_KjU13 = Color.INSTANCE.m3857getWhite0d7_KjU();
                if (LiquidDock$lambda$3(mutableState)) {
                    f5 = 0.28f;
                } else {
                    f5 = 0.16f;
                }
                colorArr14[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU13, f5, 0.0f, 0.0f, 0.0f, 14, null));
                long jM3857getWhite0d7_KjU14 = Color.INSTANCE.m3857getWhite0d7_KjU();
                if (LiquidDock$lambda$3(mutableState)) {
                    f6 = 0.12f;
                } else {
                    f6 = 0.05f;
                }
                colorArr14[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU14, f6, 0.0f, 0.0f, 0.0f, 14, null));
                brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion1119, CollectionsKt.listOf((Object[]) colorArr14), 0.0f, 0.0f, 0, 14, (Object) null);
            }
            BoxKt.Box(BackgroundKt.background$default(modifierDrawWithContent7, brushM3777verticalGradient8A3gB4$default, null, 0.0f, 6, null), composerStartRestartGroup, 0);
            Alignment.Vertical centerVertically7 = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_10 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(0.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Modifier.Companion companion11110 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_10, centerVertically7, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap116 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier116 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion11110);
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
            Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyRowMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap116, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3313constructorimpl2.getInserting()) {
                composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier116, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance7 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 192075972, "C363@15540L1022,402@17562L1046:GlassComponents.kt#75kw8w");
            float f111116 = f4 / 2.0f;
            float fLiquidDock$lambda$114 = LiquidDock$lambda$9(stateAnimateFloatAsState) + f111116;
            if (LiquidDock$lambda$9(stateAnimateFloatAsState) <= f111116) {
            }
            float f111117 = (f111116 - fLiquidDock$lambda$114) / f111116;
            float fCoerceIn1110 = RangesKt.coerceIn(Math.abs(f111117) / 1.35f, 0.0f, 1.0f);
            fCoerceIn4 = RangesKt.coerceIn(1.0f - (fCoerceIn1110 * fCoerceIn1110), 0.0f, 1.0f);
            float f111118 = fLiquidDock$lambda$113 * 0.14f;
            fSin = (((float) Math.sin(((double) f111117) * 3.141592653589793d)) * density.mo362toPx0680j_4(Dp.m6261constructorimpl(8.0f)) * fCoerceIn4) + (f111118 * fCoerceIn4);
            float f111119 = (fCoerceIn4 * 0.18f) + 1.0f;
            float fCoerceIn1111 = 1.0f - RangesKt.coerceIn(Math.abs(f111117), 0.0f, 1.0f);
            f7 = f111119 * (1.0f - ((0.08f * fCoerceIn1111) * fCoerceIn4));
            f8 = f111119 * ((fCoerceIn1111 * 0.05f * fCoerceIn4) + 1.0f);
            Modifier modifierTestTag13 = TestTagKt.testTag(ClipKt.clip(SizeKt.m717sizeVpY3zN4(Modifier.INSTANCE, fM6261constructorimpl7, Dp.m6261constructorimpl(44.0f)), RoundedCornerShapeKt.getCircleShape()), "dock_tab_home");
            Alignment center13 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy110 = BoxKt.maybeCachedBoxMeasurePolicy(center13, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier117 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag13);
            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
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
            Updater.m3320setimpl(composerM3313constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy110, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl3, currentCompositionLocalMap117, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3313constructorimpl3.getInserting()) {
                composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            } else {
                composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3320setimpl(composerM3313constructorimpl3, modifierMaterializeModifier117, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance110 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1598213862, "C379@16245L248,370@15796L752:GlassComponents.kt#75kw8w");
            ImageVector home7 = HomeKt.getHome(Icons.INSTANCE.getDefault());
            if (z8) {
                if (z7) {
                    alpineOnSurfaceVariant = Color.INSTANCE.m3857getWhite0d7_KjU();
                } else {
                    alpineOnSurfaceVariant = ColorKt.getAlpinePrimaryContainer();
                }
            } else if (z7) {
                alpineOnSurfaceVariant = androidx.compose.ui.graphics.ColorKt.Color(4281549141L);
            } else {
                alpineOnSurfaceVariant = ColorKt.getAlpineOnSurfaceVariant();
            }
            Modifier.Companion companion11111 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -779714843, "CC(remember):GlassComponents.kt#9igjgp");
            zChanged6 = composerStartRestartGroup.changed(fSin) | composerStartRestartGroup.changed(f7) | composerStartRestartGroup.changed(f8) | composerStartRestartGroup.changed(fCoerceIn4);
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (!zChanged6) {
                objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$27$lambda$26$lambda$25(fSin, f7, f8, fCoerceIn4, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            } else {
                objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$27$lambda$26$lambda$25(fSin, f7, f8, fCoerceIn4, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            IconKt.m1811Iconww6aTOc(home7, "首页", SizeKt.m715size3ABfNKs(GraphicsLayerModifierKt.graphicsLayer(companion11111, (Function1) objRememberedValue7), Dp.m6261constructorimpl(24.0f)), alpineOnSurfaceVariant, composerStartRestartGroup, 48, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float f1111110 = ((f4 + f111116) - fLiquidDock$lambda$114) / f111116;
            float fCoerceIn1112 = RangesKt.coerceIn(Math.abs(f1111110) / 1.35f, 0.0f, 1.0f);
            fCoerceIn5 = RangesKt.coerceIn(1.0f - (fCoerceIn1112 * fCoerceIn1112), 0.0f, 1.0f);
            fSin2 = (((float) Math.sin(((double) f1111110) * 3.141592653589793d)) * density.mo362toPx0680j_4(Dp.m6261constructorimpl(8.0f)) * fCoerceIn5) + (f111118 * fCoerceIn5);
            float f1111111 = (fCoerceIn5 * 0.18f) + 1.0f;
            float fCoerceIn1113 = 1.0f - RangesKt.coerceIn(Math.abs(f1111110), 0.0f, 1.0f);
            f9 = (1.0f - ((0.08f * fCoerceIn1113) * fCoerceIn5)) * f1111111;
            f10 = f1111111 * ((fCoerceIn1113 * 0.05f * fCoerceIn5) + 1.0f);
            Modifier modifierTestTag14 = TestTagKt.testTag(ClipKt.clip(SizeKt.m717sizeVpY3zN4(Modifier.INSTANCE, fM6261constructorimpl7, Dp.m6261constructorimpl(44.0f)), RoundedCornerShapeKt.getCircleShape()), "dock_tab_history");
            Alignment center14 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy111 = BoxKt.maybeCachedBoxMeasurePolicy(center14, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap118 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier118 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag14);
            constructor4 = ComposeUiNode.INSTANCE.getConstructor();
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
            Updater.m3320setimpl(composerM3313constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy111, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl4, currentCompositionLocalMap118, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3313constructorimpl4.getInserting()) {
                composerM3313constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composerM3313constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            } else {
                composerM3313constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composerM3313constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3320setimpl(composerM3313constructorimpl4, modifierMaterializeModifier118, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance111 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1026813592, "C418@18279L260,409@17821L773:GlassComponents.kt#75kw8w");
            ImageVector insights7 = InsightsKt.getInsights(Icons.INSTANCE.getDefault());
            if (z8) {
                if (z7) {
                    alpineOnSurfaceVariant2 = Color.INSTANCE.m3857getWhite0d7_KjU();
                } else {
                    alpineOnSurfaceVariant2 = ColorKt.getAlpinePrimaryContainer();
                }
            } else if (z7) {
                alpineOnSurfaceVariant2 = androidx.compose.ui.graphics.ColorKt.Color(4281549141L);
            } else {
                alpineOnSurfaceVariant2 = ColorKt.getAlpineOnSurfaceVariant();
            }
            Modifier.Companion companion11112 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1972771526, "CC(remember):GlassComponents.kt#9igjgp");
            zChanged7 = composerStartRestartGroup.changed(fSin2) | composerStartRestartGroup.changed(f9) | composerStartRestartGroup.changed(f10) | composerStartRestartGroup.changed(fCoerceIn5);
            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (!zChanged7) {
                objRememberedValue8 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29(fSin2, f9, f10, fCoerceIn5, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GlassComponentsKt.LiquidDock$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29(fSin2, f9, f10, fCoerceIn5, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            IconKt.m1811Iconww6aTOc(insights7, "骑行历史", SizeKt.m715size3ABfNKs(GraphicsLayerModifierKt.graphicsLayer(companion11112, (Function1) objRememberedValue8), Dp.m6261constructorimpl(24.0f)), alpineOnSurfaceVariant2, composerStartRestartGroup, 48, 0);
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
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier10;
            z9 = z7;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GlassComponentsKt.LiquidDock$lambda$34(currentRoute, onNavigateHome, onNavigateHistory, z9, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean LiquidDock$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LiquidDock$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final float LiquidDock$lambda$6(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LiquidDock$lambda$7(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    static final Unit LiquidDock$lambda$17$lambda$16(boolean z, State state, DrawScope drawBehind) {
        long jM3857getWhite0d7_KjU;
        float fLiquidDock$lambda$14;
        int i;
        Object obj;
        Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
        float fM3645getHeightimpl = Size.m3645getHeightimpl(drawBehind.mo4370getSizeNHjbRc()) / 2.0f;
        Color.Companion companion = Color.INSTANCE;
        long jM3819copywmQWz5c$default = Color.m3819copywmQWz5c$default(z ? companion.m3846getBlack0d7_KjU() : companion.m3857getWhite0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, null);
        Color.Companion companion2 = Color.INSTANCE;
        if (z) {
            jM3857getWhite0d7_KjU = companion2.m3846getBlack0d7_KjU();
            i = 14;
            obj = null;
            fLiquidDock$lambda$14 = 0.22f;
        } else {
            jM3857getWhite0d7_KjU = companion2.m3857getWhite0d7_KjU();
            fLiquidDock$lambda$14 = LiquidDock$lambda$14(state);
            i = 14;
            obj = null;
        }
        long jM3819copywmQWz5c$default2 = Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU, fLiquidDock$lambda$14, 0.0f, 0.0f, 0.0f, i, obj);
        Color.Companion companion3 = Color.INSTANCE;
        long jM3819copywmQWz5c$default3 = Color.m3819copywmQWz5c$default(z ? companion3.m3846getBlack0d7_KjU() : companion3.m3857getWhite0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null);
        DrawScope.m4366drawRoundRectuAw5IA$default(drawBehind, jM3819copywmQWz5c$default, 0L, 0L, CornerRadiusKt.CornerRadius$default(fM3645getHeightimpl, 0.0f, 2, null), null, 0.0f, null, 0, 246, null);
        DrawScope.m4365drawRoundRectZuiqVtQ$default(drawBehind, Brush.Companion.m3771linearGradientmHitzGk$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m3810boximpl(jM3819copywmQWz5c$default2), Color.m3810boximpl(jM3819copywmQWz5c$default3)}), OffsetKt.Offset(0.0f, 0.0f), OffsetKt.Offset(Size.m3648getWidthimpl(drawBehind.mo4370getSizeNHjbRc()), Size.m3645getHeightimpl(drawBehind.mo4370getSizeNHjbRc())), 0, 8, (Object) null), 0L, 0L, CornerRadiusKt.CornerRadius$default(fM3645getHeightimpl, 0.0f, 2, null), 0.0f, new Stroke(drawBehind.mo362toPx0680j_4(Dp.m6261constructorimpl(1.0f)), 0.0f, 0, 0, null, 30, null), null, 0, 214, null);
        return Unit.INSTANCE;
    }

    static final IntOffset LiquidDock$lambda$33$lambda$19$lambda$18(State state, Density offset) {
        Intrinsics.checkNotNullParameter(offset, "$this$offset");
        return IntOffset.m6380boximpl(IntOffsetKt.IntOffset(MathKt.roundToInt(LiquidDock$lambda$9(state)), 0));
    }

    static final Unit LiquidDock$lambda$33$lambda$21$lambda$20(float f, float f2, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setScaleX(f);
        graphicsLayer.setScaleY(f2);
        return Unit.INSTANCE;
    }

    static final Unit LiquidDock$lambda$33$lambda$23$lambda$22(float f, float f2, ContentDrawScope drawWithContent) {
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        drawWithContent.drawContent();
        float fM3648getWidthimpl = Size.m3648getWidthimpl(drawWithContent.mo4370getSizeNHjbRc());
        float fM3645getHeightimpl = Size.m3645getHeightimpl(drawWithContent.mo4370getSizeNHjbRc());
        float f3 = (0.18f * f) + 0.12f;
        float f4 = fM3645getHeightimpl / 2.0f;
        DrawScope.m4365drawRoundRectZuiqVtQ$default(drawWithContent, Brush.INSTANCE.m3785sweepGradientUv8p0NA(CollectionsKt.listOf((Object[]) new Color[]{Color.m3810boximpl(Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), f3, 0.0f, 0.0f, 0.0f, 14, null)), Color.m3810boximpl(Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), (RangesKt.coerceAtLeast(f2, 0.0f) * 0.2f) + f3, 0.0f, 0.0f, 0.0f, 14, null)), Color.m3810boximpl(Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.04f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m3810boximpl(Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), (RangesKt.coerceAtLeast(-f2, 0.0f) * 0.2f) + f3, 0.0f, 0.0f, 0.0f, 14, null)), Color.m3810boximpl(Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), f3, 0.0f, 0.0f, 0.0f, 14, null))}), OffsetKt.Offset(fM3648getWidthimpl / 2.0f, f4)), 0L, 0L, CornerRadiusKt.CornerRadius$default(f4, 0.0f, 2, null), 0.0f, new Stroke(drawWithContent.mo362toPx0680j_4(Dp.m6261constructorimpl(1.0f)), 0.0f, 0, 0, null, 30, null), null, 0, 214, null);
        return Unit.INSTANCE;
    }

    static final Unit LiquidDock$lambda$33$lambda$32$lambda$27$lambda$26$lambda$25(float f, float f2, float f3, float f4, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setTranslationX(f);
        graphicsLayer.setScaleX(f2);
        graphicsLayer.setScaleY(f3);
        graphicsLayer.setAlpha((f4 * 0.18f) + 0.82f);
        return Unit.INSTANCE;
    }

    static final Unit LiquidDock$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29(float f, float f2, float f3, float f4, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setTranslationX(f);
        graphicsLayer.setScaleX(f2);
        graphicsLayer.setScaleY(f3);
        graphicsLayer.setAlpha((f4 * 0.18f) + 0.82f);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x034e  */
    /* JADX WARN: Code duplicated, block: B:103:0x0351  */
    /* JADX WARN: Code duplicated, block: B:106:0x035d  */
    /* JADX WARN: Code duplicated, block: B:108:0x0365  */
    /* JADX WARN: Code duplicated, block: B:111:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:114:0x03c9  */
    /* JADX WARN: Code duplicated, block: B:115:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:118:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:120:0x0400  */
    /* JADX WARN: Code duplicated, block: B:123:0x0441  */
    /* JADX WARN: Code duplicated, block: B:125:0x0449  */
    /* JADX WARN: Code duplicated, block: B:128:0x0482  */
    /* JADX WARN: Code duplicated, block: B:130:0x048a  */
    /* JADX WARN: Code duplicated, block: B:133:0x04be  */
    /* JADX WARN: Code duplicated, block: B:135:0x04c6  */
    /* JADX WARN: Code duplicated, block: B:138:0x04d9  */
    /* JADX WARN: Code duplicated, block: B:140:0x04ea A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:143:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:146:0x0516 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:149:0x051d  */
    /* JADX WARN: Code duplicated, block: B:151:0x054a  */
    /* JADX WARN: Code duplicated, block: B:153:0x055b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:156:0x0562  */
    /* JADX WARN: Code duplicated, block: B:159:0x0587 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:162:0x058e  */
    /* JADX WARN: Code duplicated, block: B:166:0x0611  */
    /* JADX WARN: Code duplicated, block: B:169:0x061d  */
    /* JADX WARN: Code duplicated, block: B:170:0x0621  */
    /* JADX WARN: Code duplicated, block: B:173:0x0646  */
    /* JADX WARN: Code duplicated, block: B:175:0x0654  */
    /* JADX WARN: Code duplicated, block: B:178:0x068c  */
    /* JADX WARN: Code duplicated, block: B:179:0x06a0  */
    /* JADX WARN: Code duplicated, block: B:183:0x06bc  */
    /* JADX WARN: Code duplicated, block: B:185:0x06c4  */
    /* JADX WARN: Code duplicated, block: B:188:0x0740  */
    /* JADX WARN: Code duplicated, block: B:189:0x0743  */
    /* JADX WARN: Code duplicated, block: B:191:0x0746  */
    /* JADX WARN: Code duplicated, block: B:192:0x074d  */
    /* JADX WARN: Code duplicated, block: B:194:0x0753  */
    /* JADX WARN: Code duplicated, block: B:195:0x075d  */
    /* JADX WARN: Code duplicated, block: B:198:0x07de  */
    /* JADX WARN: Code duplicated, block: B:201:0x07ea  */
    /* JADX WARN: Code duplicated, block: B:202:0x07ee  */
    /* JADX WARN: Code duplicated, block: B:205:0x0813  */
    /* JADX WARN: Code duplicated, block: B:207:0x0821  */
    /* JADX WARN: Code duplicated, block: B:211:0x084f  */
    /* JADX WARN: Code duplicated, block: B:214:0x085c  */
    /* JADX WARN: Code duplicated, block: B:215:0x0863  */
    /* JADX WARN: Code duplicated, block: B:218:0x088c  */
    /* JADX WARN: Code duplicated, block: B:220:0x0894  */
    /* JADX WARN: Code duplicated, block: B:224:0x092a  */
    /* JADX WARN: Code duplicated, block: B:228:0x0936  */
    /* JADX WARN: Code duplicated, block: B:233:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0076  */
    /* JADX WARN: Code duplicated, block: B:38:0x0079  */
    /* JADX WARN: Code duplicated, block: B:40:0x007d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0085  */
    /* JADX WARN: Code duplicated, block: B:43:0x0088  */
    /* JADX WARN: Code duplicated, block: B:48:0x0094  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:56:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:57:0x00af  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:69:0x0146  */
    /* JADX WARN: Code duplicated, block: B:70:0x0154  */
    /* JADX WARN: Code duplicated, block: B:73:0x0161  */
    /* JADX WARN: Code duplicated, block: B:74:0x0174  */
    /* JADX WARN: Code duplicated, block: B:77:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:78:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:81:0x0208  */
    /* JADX WARN: Code duplicated, block: B:82:0x020b  */
    /* JADX WARN: Code duplicated, block: B:85:0x0213  */
    /* JADX WARN: Code duplicated, block: B:86:0x0216  */
    /* JADX WARN: Code duplicated, block: B:89:0x0277 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:92:0x027d  */
    /* JADX WARN: Code duplicated, block: B:95:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:99:0x030e  */
    public static final void LiquidFilterDock(final List<String> options, final String selectedOption, final Function1<? super String, Unit> onOptionSelected, boolean z, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        int i4;
        Modifier modifier2;
        int i5;
        Modifier.Companion companion;
        Object objRememberedValue;
        MutableState mutableState;
        Object objRememberedValue2;
        final boolean z3;
        MutableState mutableState2;
        float fM6261constructorimpl;
        Density density;
        int i6;
        float fMo362toPx0680j_4;
        float size;
        int iCoerceAtLeast;
        float f;
        float f2;
        float fCoerceIn;
        Object obj;
        float f3;
        int i7;
        SpringSpec springSpecSpring$default;
        final State<Float> stateAnimateFloatAsState;
        float fLiquidFilterDock$lambda$42;
        final float fCoerceIn2;
        final float fAbs;
        float fAbs2;
        float f4;
        boolean z4;
        float fCoerceIn3;
        final float fLiquidFilterDock$lambda$46;
        final float fLiquidFilterDock$lambda$47;
        float f5;
        final State<Float> stateAnimateFloatAsState2;
        Composer composer2;
        State stateRememberUpdatedState;
        State stateRememberUpdatedState2;
        boolean zChanged;
        GlassComponentsKt$LiquidFilterDock$1$1 glassComponentsKt$LiquidFilterDock$1$1RememberedValue;
        String str;
        float f6;
        boolean z5;
        boolean zChanged2;
        Object objRememberedValue3;
        String str2;
        String str3;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        String str4;
        Composer composerM3313constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        boolean zChanged3;
        Object objRememberedValue4;
        boolean zChanged4;
        Object objRememberedValue5;
        boolean zChanged5;
        Object objRememberedValue6;
        float f7;
        float f8;
        Brush brushM3777verticalGradient8A3gB4$default;
        int currentCompositeKeyHash2;
        Function0<ComposeUiNode> constructor2;
        Composer composerM3313constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        float f9;
        float fLiquidFilterDock$lambda$43;
        int iCoerceIn;
        Iterator it;
        int i8;
        Composer composer3;
        final boolean z6;
        final Modifier modifier3;
        final float fCoerceIn4;
        final float fMo362toPx0680j_5;
        final float f10;
        final float f11;
        boolean z7;
        long alpinePrimaryContainer;
        long jM3819copywmQWz5c$default;
        boolean z8;
        int currentCompositeKeyHash3;
        Function0<ComposeUiNode> constructor3;
        Composer composerM3313constructorimpl3;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3;
        FontWeight medium;
        boolean zChanged6;
        Object objRememberedValue7;
        float f12;
        float f13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(selectedOption, "selectedOption");
        Intrinsics.checkNotNullParameter(onOptionSelected, "onOptionSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1883659240);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LiquidFilterDock)P(3,4,2)443@18995L34,444@19054L31,447@19145L7,461@19681L331,475@20125L216,498@21171L204,512@21708L170,518@21910L36,519@21979L38,524@22131L2391,570@24547L1197,521@22023L9146:GlassComponents.kt#75kw8w");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(options) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(selectedOption) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onOptionSelected) ? 256 : 128;
        }
        int i9 = i2 & 8;
        if (i9 == 0) {
            if ((i & 3072) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    modifier2 = modifier;
                    if (composerStartRestartGroup.changed(modifier2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((i3 & 9363) != 9362 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    composer3 = composerStartRestartGroup;
                    z6 = z2;
                    modifier3 = modifier2;
                } else {
                    if (i9 != 0) {
                        z2 = false;
                    }
                    if (i4 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1883659240, i3, -1, "com.example.ui.theme.LiquidFilterDock (GlassComponents.kt:442)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2015290950, "CC(remember):GlassComponents.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2015289065, "CC(remember):GlassComponents.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    z3 = z2;
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    fM6261constructorimpl = Dp.m6261constructorimpl(76.0f);
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume;
                    i6 = i3;
                    fMo362toPx0680j_4 = density.mo362toPx0680j_4(fM6261constructorimpl);
                    size = (options.size() - 1) * fMo362toPx0680j_4;
                    iCoerceAtLeast = RangesKt.coerceAtLeast(options.indexOf(selectedOption), 0);
                    f = iCoerceAtLeast * fMo362toPx0680j_4;
                    if (LiquidFilterDock$lambda$36(mutableState)) {
                        f2 = 0.0f;
                        fCoerceIn = RangesKt.coerceIn(f + LiquidFilterDock$lambda$39(mutableState2), 0.0f, size);
                    } else {
                        f2 = 0.0f;
                        fCoerceIn = f;
                    }
                    float f14 = fCoerceIn;
                    if (LiquidFilterDock$lambda$36(mutableState)) {
                        obj = null;
                        springSpecSpring$default = AnimationSpecKt.spring$default(f2, 10000.0f, null, 5, null);
                        f3 = 0.45f;
                        i7 = 4;
                    } else {
                        obj = null;
                        f3 = 0.45f;
                        i7 = 4;
                        springSpecSpring$default = AnimationSpecKt.spring$default(0.45f, 180.0f, null, 4, null);
                    }
                    float f15 = f3;
                    stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f14, springSpecSpring$default, 0.0f, "filter_thumb_offset", null, composerStartRestartGroup, 3072, 20);
                    fLiquidFilterDock$lambda$42 = LiquidFilterDock$lambda$42(stateAnimateFloatAsState) - LiquidFilterDock$lambda$43(AnimateAsStateKt.animateFloatAsState(f14, AnimationSpecKt.spring$default(0.55f, 85.0f, obj, i7, obj), 0.0f, "filter_lagged_thumb_offset", null, composerStartRestartGroup, 3120, 20));
                    fCoerceIn2 = RangesKt.coerceIn(fLiquidFilterDock$lambda$42 / density.mo362toPx0680j_4(Dp.m6261constructorimpl(14.0f)), -1.0f, 1.0f);
                    fAbs = Math.abs(fCoerceIn2);
                    fAbs2 = Math.abs(LiquidFilterDock$lambda$42(stateAnimateFloatAsState) - f);
                    if (size > 0.0f) {
                        f4 = size;
                    } else {
                        f4 = 1.0f;
                    }
                    if (fAbs2 > density.mo362toPx0680j_4(Dp.m6261constructorimpl(3.0f))) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (LiquidFilterDock$lambda$36(mutableState)) {
                        fCoerceIn3 = 1.0f;
                    } else {
                        fCoerceIn3 = RangesKt.coerceIn(fAbs2 / (f4 * 0.7f), 0.0f, 1.0f);
                    }
                    State<Float> stateAnimateFloatAsState3 = AnimateAsStateKt.animateFloatAsState((fCoerceIn3 * 0.48f) + 1.0f, AnimationSpecKt.spring$default(0.65f, 220.0f, null, 4, null), 0.0f, "filter_thumb_scale", null, composerStartRestartGroup, 3120, 20);
                    float fCoerceAtMost = RangesKt.coerceAtMost(Math.abs(LiquidFilterDock$lambda$39(mutableState2)) / 240.0f, 0.09f);
                    fLiquidFilterDock$lambda$46 = LiquidFilterDock$lambda$46(stateAnimateFloatAsState3) * (fCoerceAtMost + 1.0f);
                    fLiquidFilterDock$lambda$47 = LiquidFilterDock$lambda$46(stateAnimateFloatAsState3) * (1.0f - (fCoerceAtMost * f15));
                    if (!LiquidFilterDock$lambda$36(mutableState) || z4) {
                        f5 = 0.5f;
                    } else {
                        f5 = 0.25f;
                    }
                    stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f5, AnimationSpecKt.tween$default(ComposerKt.invocationKey, 0, null, 6, null), 0.0f, "filter_specular_border", null, composerStartRestartGroup, 3120, 20);
                    composer2 = composerStartRestartGroup;
                    stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(selectedOption, composer2, (i6 >> 3) & 14);
                    stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(onOptionSelected, composer2, (i6 >> 6) & 14);
                    Modifier modifierTestTag = TestTagKt.testTag(companion, "liquid_filter_dock");
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -2015188241, "CC(remember):GlassComponents.kt#9igjgp");
                    zChanged = composer2.changed(stateRememberUpdatedState) | composer2.changedInstance(options) | composer2.changed(fMo362toPx0680j_4) | composer2.changed(size) | composer2.changed(stateRememberUpdatedState2);
                    glassComponentsKt$LiquidFilterDock$1$1RememberedValue = composer2.rememberedValue();
                    if (!zChanged || glassComponentsKt$LiquidFilterDock$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        str = "CC(remember):GlassComponents.kt#9igjgp";
                        f6 = 0.0f;
                        glassComponentsKt$LiquidFilterDock$1$1RememberedValue = new GlassComponentsKt$LiquidFilterDock$1$1(stateRememberUpdatedState, options, fMo362toPx0680j_4, size, stateRememberUpdatedState2, mutableState, mutableState2, null);
                        composer2.updateRememberedValue(glassComponentsKt$LiquidFilterDock$1$1RememberedValue);
                    } else {
                        str = "CC(remember):GlassComponents.kt#9igjgp";
                        f6 = 0.0f;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierTestTag, unit, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) glassComponentsKt$LiquidFilterDock$1$1RememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composer2, -2015112123, str);
                    if ((i6 & 7168) == 2048) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    zChanged2 = z5 | composer2.changed(stateAnimateFloatAsState2);
                    objRememberedValue3 = composer2.rememberedValue();
                    if (!zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return GlassComponentsKt.LiquidFilterDock$lambda$50$lambda$49(z3, stateAnimateFloatAsState2, (DrawScope) obj2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierM670padding3ABfNKs = PaddingKt.m670padding3ABfNKs(DrawModifierKt.drawBehind(modifierPointerInput, (Function1) objRememberedValue3), Dp.m6261constructorimpl(6.0f));
                    Alignment centerStart = Alignment.INSTANCE.getCenterStart();
                    str2 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(centerStart, false);
                    str3 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM670padding3ABfNKs);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    str4 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    composerM3313constructorimpl = Updater.m3313constructorimpl(composer2);
                    Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM3313constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -861614733, "C599@26022L60,601@26155L101,606@26325L1332,597@25961L2549,652@28626L2537:GlassComponents.kt#75kw8w");
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -304891878, str);
                    zChanged3 = composer2.changed(stateAnimateFloatAsState);
                    objRememberedValue4 = composer2.rememberedValue();
                    if (!zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$52$lambda$51(stateAnimateFloatAsState, (Density) obj2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierM717sizeVpY3zN4 = SizeKt.m717sizeVpY3zN4(androidx.compose.foundation.layout.OffsetKt.offset(companion2, (Function1) objRememberedValue4), fM6261constructorimpl, Dp.m6261constructorimpl(44.0f));
                    ComposerKt.sourceInformationMarkerStart(composer2, -304887581, str);
                    zChanged4 = composer2.changed(fLiquidFilterDock$lambda$46) | composer2.changed(fLiquidFilterDock$lambda$47);
                    objRememberedValue5 = composer2.rememberedValue();
                    if (!zChanged4 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$54$lambda$53(fLiquidFilterDock$lambda$46, fLiquidFilterDock$lambda$47, (GraphicsLayerScope) obj2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierClip = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierM717sizeVpY3zN4, (Function1) objRememberedValue5), RoundedCornerShapeKt.getCircleShape());
                    ComposerKt.sourceInformationMarkerStart(composer2, -304880910, str);
                    zChanged5 = composer2.changed(fAbs) | composer2.changed(fCoerceIn2);
                    objRememberedValue6 = composer2.rememberedValue();
                    if (!zChanged5 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$56$lambda$55(fAbs, fCoerceIn2, (ContentDrawScope) obj2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierDrawWithContent = DrawModifierKt.drawWithContent(modifierClip, (Function1) objRememberedValue6);
                    if (z3 != 0) {
                        Brush.Companion companion3 = Brush.INSTANCE;
                        Color[] colorArr = new Color[2];
                        long jM3846getBlack0d7_KjU = Color.INSTANCE.m3846getBlack0d7_KjU();
                        if (!LiquidFilterDock$lambda$36(mutableState) || z4) {
                            f12 = 0.32f;
                        } else {
                            f12 = 0.2f;
                        }
                        colorArr[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU, f12, 0.0f, 0.0f, 0.0f, 14, null));
                        long jM3846getBlack0d7_KjU2 = Color.INSTANCE.m3846getBlack0d7_KjU();
                        if (!LiquidFilterDock$lambda$36(mutableState) || z4) {
                            f13 = 0.18f;
                        } else {
                            f13 = 0.1f;
                        }
                        colorArr[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU2, f13, 0.0f, 0.0f, 0.0f, 14, null));
                        brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion3, CollectionsKt.listOf((Object[]) colorArr), 0.0f, 0.0f, 0, 14, (Object) null);
                    } else {
                        Brush.Companion companion4 = Brush.INSTANCE;
                        Color[] colorArr2 = new Color[2];
                        long jM3857getWhite0d7_KjU = Color.INSTANCE.m3857getWhite0d7_KjU();
                        if (!LiquidFilterDock$lambda$36(mutableState) || z4) {
                            f7 = 0.28f;
                        } else {
                            f7 = 0.16f;
                        }
                        colorArr2[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU, f7, 0.0f, 0.0f, 0.0f, 14, null));
                        long jM3857getWhite0d7_KjU2 = Color.INSTANCE.m3857getWhite0d7_KjU();
                        if (!LiquidFilterDock$lambda$36(mutableState) || z4) {
                            f8 = 0.12f;
                        } else {
                            f8 = 0.05f;
                        }
                        colorArr2[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU2, f8, 0.0f, 0.0f, 0.0f, 14, null));
                        brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion4, CollectionsKt.listOf((Object[]) colorArr2), 0.0f, 0.0f, 0, 14, (Object) null);
                    }
                    BoxKt.Box(BackgroundKt.background$default(modifierDrawWithContent, brushM3777verticalGradient8A3gB4$default, null, 0.0f, 6, null), composer2, 0);
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_4 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(f6));
                    ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                    Modifier.Companion companion5 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_4, centerVertically, composer2, 54);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion5);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    composerM3313constructorimpl2 = Updater.m3313constructorimpl(composer2);
                    Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM3313constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1636699622, "C:GlassComponents.kt#75kw8w");
                    f9 = fMo362toPx0680j_4 / 2.0f;
                    fLiquidFilterDock$lambda$43 = LiquidFilterDock$lambda$42(stateAnimateFloatAsState) + f9;
                    if (fMo362toPx0680j_4 > f6) {
                        iCoerceIn = RangesKt.coerceIn(MathKt.roundToInt(LiquidFilterDock$lambda$42(stateAnimateFloatAsState) / fMo362toPx0680j_4), 0, options.size() - 1);
                    } else {
                        iCoerceIn = iCoerceAtLeast;
                    }
                    composer2.startReplaceGroup(-1022619500);
                    ComposerKt.sourceInformation(composer2, "*677@30237L902");
                    it = options.iterator();
                    i8 = 0;
                    while (it.hasNext()) {
                        Object next = it.next();
                        int i10 = i8 + 1;
                        if (i8 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        String str5 = (String) next;
                        float f16 = (((i8 * fMo362toPx0680j_4) + f9) - fLiquidFilterDock$lambda$43) / f9;
                        float f17 = fLiquidFilterDock$lambda$43;
                        float f18 = f6;
                        Iterator it2 = it;
                        float fCoerceIn5 = RangesKt.coerceIn(Math.abs(f16) / 1.35f, f18, 1.0f);
                        fCoerceIn4 = RangesKt.coerceIn(1.0f - (fCoerceIn5 * fCoerceIn5), f18, 1.0f);
                        fMo362toPx0680j_5 = (density.mo362toPx0680j_4(Dp.m6261constructorimpl(8.0f)) * ((float) Math.sin(((double) f16) * 3.141592653589793d)) * fCoerceIn4) + (0.14f * fLiquidFilterDock$lambda$42 * fCoerceIn4);
                        float f19 = (0.18f * fCoerceIn4) + 1.0f;
                        float f20 = f9;
                        float fCoerceIn6 = 1.0f - RangesKt.coerceIn(Math.abs(f16), 0.0f, 1.0f);
                        f10 = f19 * (1.0f - ((0.08f * fCoerceIn6) * fCoerceIn4));
                        f11 = ((fCoerceIn6 * 0.05f * fCoerceIn4) + 1.0f) * f19;
                        if (i8 == iCoerceIn) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (z3 != 0) {
                            alpinePrimaryContainer = Color.INSTANCE.m3857getWhite0d7_KjU();
                        } else {
                            alpinePrimaryContainer = ColorKt.getAlpinePrimaryContainer();
                        }
                        if (z3 != 0) {
                            jM3819copywmQWz5c$default = androidx.compose.ui.graphics.ColorKt.Color(4281549141L);
                        } else {
                            jM3819copywmQWz5c$default = Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.65f, 0.0f, 0.0f, 0.0f, 14, null);
                        }
                        float f21 = fMo362toPx0680j_4;
                        z8 = z7;
                        Modifier modifierTestTag2 = TestTagKt.testTag(ClipKt.clip(SizeKt.m717sizeVpY3zN4(Modifier.INSTANCE, fM6261constructorimpl, Dp.m6261constructorimpl(44.0f)), RoundedCornerShapeKt.getCircleShape()), "filter_option_" + str5);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, str2);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                        String str6 = str2;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str3);
                        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierTestTag2);
                        constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        String str7 = str3;
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str4);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor3);
                        } else {
                            composer2.useNode();
                        }
                        composerM3313constructorimpl3 = Updater.m3313constructorimpl(composer2);
                        Updater.m3320setimpl(composerM3313constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3320setimpl(composerM3313constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM3313constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        Updater.m3320setimpl(composerM3313constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 195873989, "C689@30857L242,684@30529L592:GlassComponents.kt#75kw8w");
                        if (!z8) {
                            alpinePrimaryContainer = jM3819copywmQWz5c$default;
                        }
                        long sp = TextUnitKt.getSp(14);
                        if (z8) {
                            medium = FontWeight.INSTANCE.getBold();
                        } else {
                            medium = FontWeight.INSTANCE.getMedium();
                        }
                        Modifier.Companion companion6 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1794786656, str);
                        zChanged6 = composer2.changed(fMo362toPx0680j_5) | composer2.changed(f10) | composer2.changed(f11) | composer2.changed(fCoerceIn4);
                        objRememberedValue7 = composer2.rememberedValue();
                        if (!zChanged6 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$62$lambda$61$lambda$60$lambda$59$lambda$58(fMo362toPx0680j_5, f10, f11, fCoerceIn4, (GraphicsLayerScope) obj2);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue7);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Composer composer4 = composer2;
                        TextKt.m2354Text4IGK_g(str5, GraphicsLayerModifierKt.graphicsLayer(companion6, (Function1) objRememberedValue7), alpinePrimaryContainer, sp, (FontStyle) null, medium, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 3072, 0, 131024);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        fLiquidFilterDock$lambda$43 = f17;
                        str4 = str4;
                        str = str;
                        composer2 = composer4;
                        i8 = i10;
                        it = it2;
                        f9 = f20;
                        str2 = str6;
                        fMo362toPx0680j_4 = f21;
                        str3 = str7;
                        f6 = 0.0f;
                    }
                    composer3 = composer2;
                    composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z3;
                    modifier3 = companion;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$64(options, selectedOption, onOptionSelected, z6, modifier3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            modifier2 = modifier;
            if ((i3 & 9363) != 9362) {
                if (i9 != 0) {
                    z2 = false;
                }
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1883659240, i3, -1, "com.example.ui.theme.LiquidFilterDock (GlassComponents.kt:442)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2015290950, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2015289065, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                z3 = z2;
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                fM6261constructorimpl = Dp.m6261constructorimpl(76.0f);
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume2;
                i6 = i3;
                fMo362toPx0680j_4 = density.mo362toPx0680j_4(fM6261constructorimpl);
                size = (options.size() - 1) * fMo362toPx0680j_4;
                iCoerceAtLeast = RangesKt.coerceAtLeast(options.indexOf(selectedOption), 0);
                f = iCoerceAtLeast * fMo362toPx0680j_4;
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    f2 = 0.0f;
                    fCoerceIn = RangesKt.coerceIn(f + LiquidFilterDock$lambda$39(mutableState2), 0.0f, size);
                } else {
                    f2 = 0.0f;
                    fCoerceIn = f;
                }
                float f110 = fCoerceIn;
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    obj = null;
                    springSpecSpring$default = AnimationSpecKt.spring$default(f2, 10000.0f, null, 5, null);
                    f3 = 0.45f;
                    i7 = 4;
                } else {
                    obj = null;
                    f3 = 0.45f;
                    i7 = 4;
                    springSpecSpring$default = AnimationSpecKt.spring$default(0.45f, 180.0f, null, 4, null);
                }
                float f111 = f3;
                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f110, springSpecSpring$default, 0.0f, "filter_thumb_offset", null, composerStartRestartGroup, 3072, 20);
                fLiquidFilterDock$lambda$42 = LiquidFilterDock$lambda$42(stateAnimateFloatAsState) - LiquidFilterDock$lambda$43(AnimateAsStateKt.animateFloatAsState(f110, AnimationSpecKt.spring$default(0.55f, 85.0f, obj, i7, obj), 0.0f, "filter_lagged_thumb_offset", null, composerStartRestartGroup, 3120, 20));
                fCoerceIn2 = RangesKt.coerceIn(fLiquidFilterDock$lambda$42 / density.mo362toPx0680j_4(Dp.m6261constructorimpl(14.0f)), -1.0f, 1.0f);
                fAbs = Math.abs(fCoerceIn2);
                fAbs2 = Math.abs(LiquidFilterDock$lambda$42(stateAnimateFloatAsState) - f);
                if (size > 0.0f) {
                    f4 = size;
                } else {
                    f4 = 1.0f;
                }
                if (fAbs2 > density.mo362toPx0680j_4(Dp.m6261constructorimpl(3.0f))) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    fCoerceIn3 = 1.0f;
                } else {
                    fCoerceIn3 = RangesKt.coerceIn(fAbs2 / (f4 * 0.7f), 0.0f, 1.0f);
                }
                State<Float> stateAnimateFloatAsState4 = AnimateAsStateKt.animateFloatAsState((fCoerceIn3 * 0.48f) + 1.0f, AnimationSpecKt.spring$default(0.65f, 220.0f, null, 4, null), 0.0f, "filter_thumb_scale", null, composerStartRestartGroup, 3120, 20);
                float fCoerceAtMost2 = RangesKt.coerceAtMost(Math.abs(LiquidFilterDock$lambda$39(mutableState2)) / 240.0f, 0.09f);
                fLiquidFilterDock$lambda$46 = LiquidFilterDock$lambda$46(stateAnimateFloatAsState4) * (fCoerceAtMost2 + 1.0f);
                fLiquidFilterDock$lambda$47 = LiquidFilterDock$lambda$46(stateAnimateFloatAsState4) * (1.0f - (fCoerceAtMost2 * f111));
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    f5 = 0.5f;
                } else {
                    f5 = 0.5f;
                }
                stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f5, AnimationSpecKt.tween$default(ComposerKt.invocationKey, 0, null, 6, null), 0.0f, "filter_specular_border", null, composerStartRestartGroup, 3120, 20);
                composer2 = composerStartRestartGroup;
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(selectedOption, composer2, (i6 >> 3) & 14);
                stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(onOptionSelected, composer2, (i6 >> 6) & 14);
                Modifier modifierTestTag3 = TestTagKt.testTag(companion, "liquid_filter_dock");
                Unit unit2 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -2015188241, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged = composer2.changed(stateRememberUpdatedState) | composer2.changedInstance(options) | composer2.changed(fMo362toPx0680j_4) | composer2.changed(size) | composer2.changed(stateRememberUpdatedState2);
                glassComponentsKt$LiquidFilterDock$1$1RememberedValue = composer2.rememberedValue();
                if (!zChanged) {
                    str = "CC(remember):GlassComponents.kt#9igjgp";
                    f6 = 0.0f;
                    glassComponentsKt$LiquidFilterDock$1$1RememberedValue = new GlassComponentsKt$LiquidFilterDock$1$1(stateRememberUpdatedState, options, fMo362toPx0680j_4, size, stateRememberUpdatedState2, mutableState, mutableState2, null);
                    composer2.updateRememberedValue(glassComponentsKt$LiquidFilterDock$1$1RememberedValue);
                } else {
                    str = "CC(remember):GlassComponents.kt#9igjgp";
                    f6 = 0.0f;
                    glassComponentsKt$LiquidFilterDock$1$1RememberedValue = new GlassComponentsKt$LiquidFilterDock$1$1(stateRememberUpdatedState, options, fMo362toPx0680j_4, size, stateRememberUpdatedState2, mutableState, mutableState2, null);
                    composer2.updateRememberedValue(glassComponentsKt$LiquidFilterDock$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierPointerInput2 = SuspendingPointerInputFilterKt.pointerInput(modifierTestTag3, unit2, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) glassComponentsKt$LiquidFilterDock$1$1RememberedValue);
                ComposerKt.sourceInformationMarkerStart(composer2, -2015112123, str);
                if ((i6 & 7168) == 2048) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                zChanged2 = z5 | composer2.changed(stateAnimateFloatAsState2);
                objRememberedValue3 = composer2.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$50$lambda$49(z3, stateAnimateFloatAsState2, (DrawScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$50$lambda$49(z3, stateAnimateFloatAsState2, (DrawScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierM670padding3ABfNKs2 = PaddingKt.m670padding3ABfNKs(DrawModifierKt.drawBehind(modifierPointerInput2, (Function1) objRememberedValue3), Dp.m6261constructorimpl(6.0f));
                Alignment centerStart2 = Alignment.INSTANCE.getCenterStart();
                str2 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(centerStart2, false);
                str3 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifierM670padding3ABfNKs2);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                str4 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composerM3313constructorimpl = Updater.m3313constructorimpl(composer2);
                Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl.getInserting()) {
                    composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -861614733, "C599@26022L60,601@26155L101,606@26325L1332,597@25961L2549,652@28626L2537:GlassComponents.kt#75kw8w");
                Modifier.Companion companion7 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -304891878, str);
                zChanged3 = composer2.changed(stateAnimateFloatAsState);
                objRememberedValue4 = composer2.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$52$lambda$51(stateAnimateFloatAsState, (Density) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$52$lambda$51(stateAnimateFloatAsState, (Density) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierM717sizeVpY3zN5 = SizeKt.m717sizeVpY3zN4(androidx.compose.foundation.layout.OffsetKt.offset(companion7, (Function1) objRememberedValue4), fM6261constructorimpl, Dp.m6261constructorimpl(44.0f));
                ComposerKt.sourceInformationMarkerStart(composer2, -304887581, str);
                zChanged4 = composer2.changed(fLiquidFilterDock$lambda$46) | composer2.changed(fLiquidFilterDock$lambda$47);
                objRememberedValue5 = composer2.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$54$lambda$53(fLiquidFilterDock$lambda$46, fLiquidFilterDock$lambda$47, (GraphicsLayerScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$54$lambda$53(fLiquidFilterDock$lambda$46, fLiquidFilterDock$lambda$47, (GraphicsLayerScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierClip2 = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierM717sizeVpY3zN5, (Function1) objRememberedValue5), RoundedCornerShapeKt.getCircleShape());
                ComposerKt.sourceInformationMarkerStart(composer2, -304880910, str);
                zChanged5 = composer2.changed(fAbs) | composer2.changed(fCoerceIn2);
                objRememberedValue6 = composer2.rememberedValue();
                if (!zChanged5) {
                    objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$56$lambda$55(fAbs, fCoerceIn2, (ContentDrawScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$56$lambda$55(fAbs, fCoerceIn2, (ContentDrawScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierDrawWithContent2 = DrawModifierKt.drawWithContent(modifierClip2, (Function1) objRememberedValue6);
                if (z3 != 0) {
                    Brush.Companion companion8 = Brush.INSTANCE;
                    Color[] colorArr3 = new Color[2];
                    long jM3846getBlack0d7_KjU3 = Color.INSTANCE.m3846getBlack0d7_KjU();
                    if (LiquidFilterDock$lambda$36(mutableState)) {
                        f12 = 0.32f;
                    } else {
                        f12 = 0.32f;
                    }
                    colorArr3[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU3, f12, 0.0f, 0.0f, 0.0f, 14, null));
                    long jM3846getBlack0d7_KjU4 = Color.INSTANCE.m3846getBlack0d7_KjU();
                    if (LiquidFilterDock$lambda$36(mutableState)) {
                        f13 = 0.18f;
                    } else {
                        f13 = 0.18f;
                    }
                    colorArr3[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU4, f13, 0.0f, 0.0f, 0.0f, 14, null));
                    brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion8, CollectionsKt.listOf((Object[]) colorArr3), 0.0f, 0.0f, 0, 14, (Object) null);
                } else {
                    Brush.Companion companion9 = Brush.INSTANCE;
                    Color[] colorArr4 = new Color[2];
                    long jM3857getWhite0d7_KjU3 = Color.INSTANCE.m3857getWhite0d7_KjU();
                    if (LiquidFilterDock$lambda$36(mutableState)) {
                        f7 = 0.28f;
                    } else {
                        f7 = 0.28f;
                    }
                    colorArr4[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU3, f7, 0.0f, 0.0f, 0.0f, 14, null));
                    long jM3857getWhite0d7_KjU4 = Color.INSTANCE.m3857getWhite0d7_KjU();
                    if (LiquidFilterDock$lambda$36(mutableState)) {
                        f8 = 0.12f;
                    } else {
                        f8 = 0.12f;
                    }
                    colorArr4[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU4, f8, 0.0f, 0.0f, 0.0f, 14, null));
                    brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion9, CollectionsKt.listOf((Object[]) colorArr4), 0.0f, 0.0f, 0, 14, (Object) null);
                }
                BoxKt.Box(BackgroundKt.background$default(modifierDrawWithContent2, brushM3777verticalGradient8A3gB4$default, null, 0.0f, 6, null), composer2, 0);
                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_5 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(f6));
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                Modifier.Companion companion10 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_5, centerVertically2, composer2, 54);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer2, companion10);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                composerM3313constructorimpl2 = Updater.m3313constructorimpl(composer2);
                Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl2.getInserting()) {
                    composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -1636699622, "C:GlassComponents.kt#75kw8w");
                f9 = fMo362toPx0680j_4 / 2.0f;
                fLiquidFilterDock$lambda$43 = LiquidFilterDock$lambda$42(stateAnimateFloatAsState) + f9;
                if (fMo362toPx0680j_4 > f6) {
                    iCoerceIn = RangesKt.coerceIn(MathKt.roundToInt(LiquidFilterDock$lambda$42(stateAnimateFloatAsState) / fMo362toPx0680j_4), 0, options.size() - 1);
                } else {
                    iCoerceIn = iCoerceAtLeast;
                }
                composer2.startReplaceGroup(-1022619500);
                ComposerKt.sourceInformation(composer2, "*677@30237L902");
                it = options.iterator();
                i8 = 0;
                while (it.hasNext()) {
                    Object next2 = it.next();
                    int i11 = i8 + 1;
                    if (i8 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    String str8 = (String) next2;
                    float f112 = (((i8 * fMo362toPx0680j_4) + f9) - fLiquidFilterDock$lambda$43) / f9;
                    float f113 = fLiquidFilterDock$lambda$43;
                    float f114 = f6;
                    Iterator it3 = it;
                    float fCoerceIn7 = RangesKt.coerceIn(Math.abs(f112) / 1.35f, f114, 1.0f);
                    fCoerceIn4 = RangesKt.coerceIn(1.0f - (fCoerceIn7 * fCoerceIn7), f114, 1.0f);
                    fMo362toPx0680j_5 = (density.mo362toPx0680j_4(Dp.m6261constructorimpl(8.0f)) * ((float) Math.sin(((double) f112) * 3.141592653589793d)) * fCoerceIn4) + (0.14f * fLiquidFilterDock$lambda$42 * fCoerceIn4);
                    float f115 = (0.18f * fCoerceIn4) + 1.0f;
                    float f22 = f9;
                    float fCoerceIn8 = 1.0f - RangesKt.coerceIn(Math.abs(f112), 0.0f, 1.0f);
                    f10 = f115 * (1.0f - ((0.08f * fCoerceIn8) * fCoerceIn4));
                    f11 = ((fCoerceIn8 * 0.05f * fCoerceIn4) + 1.0f) * f115;
                    if (i8 == iCoerceIn) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (z3 != 0) {
                        alpinePrimaryContainer = Color.INSTANCE.m3857getWhite0d7_KjU();
                    } else {
                        alpinePrimaryContainer = ColorKt.getAlpinePrimaryContainer();
                    }
                    if (z3 != 0) {
                        jM3819copywmQWz5c$default = androidx.compose.ui.graphics.ColorKt.Color(4281549141L);
                    } else {
                        jM3819copywmQWz5c$default = Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.65f, 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    float f23 = fMo362toPx0680j_4;
                    z8 = z7;
                    Modifier modifierTestTag4 = TestTagKt.testTag(ClipKt.clip(SizeKt.m717sizeVpY3zN4(Modifier.INSTANCE, fM6261constructorimpl, Dp.m6261constructorimpl(44.0f)), RoundedCornerShapeKt.getCircleShape()), "filter_option_" + str8);
                    Alignment center2 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, str2);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                    String str9 = str2;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str3);
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap6 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer2, modifierTestTag4);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    String str10 = str3;
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str4);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    composerM3313constructorimpl3 = Updater.m3313constructorimpl(composer2);
                    Updater.m3320setimpl(composerM3313constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 195873989, "C689@30857L242,684@30529L592:GlassComponents.kt#75kw8w");
                    if (!z8) {
                        alpinePrimaryContainer = jM3819copywmQWz5c$default;
                    }
                    long sp2 = TextUnitKt.getSp(14);
                    if (z8) {
                        medium = FontWeight.INSTANCE.getBold();
                    } else {
                        medium = FontWeight.INSTANCE.getMedium();
                    }
                    Modifier.Companion companion11 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1794786656, str);
                    zChanged6 = composer2.changed(fMo362toPx0680j_5) | composer2.changed(f10) | composer2.changed(f11) | composer2.changed(fCoerceIn4);
                    objRememberedValue7 = composer2.rememberedValue();
                    if (!zChanged6) {
                        objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$62$lambda$61$lambda$60$lambda$59$lambda$58(fMo362toPx0680j_5, f10, f11, fCoerceIn4, (GraphicsLayerScope) obj2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    } else {
                        objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$62$lambda$61$lambda$60$lambda$59$lambda$58(fMo362toPx0680j_5, f10, f11, fCoerceIn4, (GraphicsLayerScope) obj2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Composer composer5 = composer2;
                    TextKt.m2354Text4IGK_g(str8, GraphicsLayerModifierKt.graphicsLayer(companion11, (Function1) objRememberedValue7), alpinePrimaryContainer, sp2, (FontStyle) null, medium, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer5, 3072, 0, 131024);
                    ComposerKt.sourceInformationMarkerEnd(composer5);
                    ComposerKt.sourceInformationMarkerEnd(composer5);
                    composer5.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer5);
                    ComposerKt.sourceInformationMarkerEnd(composer5);
                    ComposerKt.sourceInformationMarkerEnd(composer5);
                    fLiquidFilterDock$lambda$43 = f113;
                    str4 = str4;
                    str = str;
                    composer2 = composer5;
                    i8 = i11;
                    it = it3;
                    f9 = f22;
                    str2 = str9;
                    fMo362toPx0680j_4 = f23;
                    str3 = str10;
                    f6 = 0.0f;
                }
                composer3 = composer2;
                composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z3;
                modifier3 = companion;
            } else {
                if (i9 != 0) {
                    z2 = false;
                }
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1883659240, i3, -1, "com.example.ui.theme.LiquidFilterDock (GlassComponents.kt:442)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2015290950, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2015289065, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                z3 = z2;
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                fM6261constructorimpl = Dp.m6261constructorimpl(76.0f);
                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localDensity3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume3;
                i6 = i3;
                fMo362toPx0680j_4 = density.mo362toPx0680j_4(fM6261constructorimpl);
                size = (options.size() - 1) * fMo362toPx0680j_4;
                iCoerceAtLeast = RangesKt.coerceAtLeast(options.indexOf(selectedOption), 0);
                f = iCoerceAtLeast * fMo362toPx0680j_4;
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    f2 = 0.0f;
                    fCoerceIn = RangesKt.coerceIn(f + LiquidFilterDock$lambda$39(mutableState2), 0.0f, size);
                } else {
                    f2 = 0.0f;
                    fCoerceIn = f;
                }
                float f116 = fCoerceIn;
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    obj = null;
                    springSpecSpring$default = AnimationSpecKt.spring$default(f2, 10000.0f, null, 5, null);
                    f3 = 0.45f;
                    i7 = 4;
                } else {
                    obj = null;
                    f3 = 0.45f;
                    i7 = 4;
                    springSpecSpring$default = AnimationSpecKt.spring$default(0.45f, 180.0f, null, 4, null);
                }
                float f117 = f3;
                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f116, springSpecSpring$default, 0.0f, "filter_thumb_offset", null, composerStartRestartGroup, 3072, 20);
                fLiquidFilterDock$lambda$42 = LiquidFilterDock$lambda$42(stateAnimateFloatAsState) - LiquidFilterDock$lambda$43(AnimateAsStateKt.animateFloatAsState(f116, AnimationSpecKt.spring$default(0.55f, 85.0f, obj, i7, obj), 0.0f, "filter_lagged_thumb_offset", null, composerStartRestartGroup, 3120, 20));
                fCoerceIn2 = RangesKt.coerceIn(fLiquidFilterDock$lambda$42 / density.mo362toPx0680j_4(Dp.m6261constructorimpl(14.0f)), -1.0f, 1.0f);
                fAbs = Math.abs(fCoerceIn2);
                fAbs2 = Math.abs(LiquidFilterDock$lambda$42(stateAnimateFloatAsState) - f);
                if (size > 0.0f) {
                    f4 = size;
                } else {
                    f4 = 1.0f;
                }
                if (fAbs2 > density.mo362toPx0680j_4(Dp.m6261constructorimpl(3.0f))) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    fCoerceIn3 = 1.0f;
                } else {
                    fCoerceIn3 = RangesKt.coerceIn(fAbs2 / (f4 * 0.7f), 0.0f, 1.0f);
                }
                State<Float> stateAnimateFloatAsState5 = AnimateAsStateKt.animateFloatAsState((fCoerceIn3 * 0.48f) + 1.0f, AnimationSpecKt.spring$default(0.65f, 220.0f, null, 4, null), 0.0f, "filter_thumb_scale", null, composerStartRestartGroup, 3120, 20);
                float fCoerceAtMost3 = RangesKt.coerceAtMost(Math.abs(LiquidFilterDock$lambda$39(mutableState2)) / 240.0f, 0.09f);
                fLiquidFilterDock$lambda$46 = LiquidFilterDock$lambda$46(stateAnimateFloatAsState5) * (fCoerceAtMost3 + 1.0f);
                fLiquidFilterDock$lambda$47 = LiquidFilterDock$lambda$46(stateAnimateFloatAsState5) * (1.0f - (fCoerceAtMost3 * f117));
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    f5 = 0.5f;
                } else {
                    f5 = 0.5f;
                }
                stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f5, AnimationSpecKt.tween$default(ComposerKt.invocationKey, 0, null, 6, null), 0.0f, "filter_specular_border", null, composerStartRestartGroup, 3120, 20);
                composer2 = composerStartRestartGroup;
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(selectedOption, composer2, (i6 >> 3) & 14);
                stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(onOptionSelected, composer2, (i6 >> 6) & 14);
                Modifier modifierTestTag5 = TestTagKt.testTag(companion, "liquid_filter_dock");
                Unit unit3 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -2015188241, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged = composer2.changed(stateRememberUpdatedState) | composer2.changedInstance(options) | composer2.changed(fMo362toPx0680j_4) | composer2.changed(size) | composer2.changed(stateRememberUpdatedState2);
                glassComponentsKt$LiquidFilterDock$1$1RememberedValue = composer2.rememberedValue();
                if (!zChanged) {
                    str = "CC(remember):GlassComponents.kt#9igjgp";
                    f6 = 0.0f;
                    glassComponentsKt$LiquidFilterDock$1$1RememberedValue = new GlassComponentsKt$LiquidFilterDock$1$1(stateRememberUpdatedState, options, fMo362toPx0680j_4, size, stateRememberUpdatedState2, mutableState, mutableState2, null);
                    composer2.updateRememberedValue(glassComponentsKt$LiquidFilterDock$1$1RememberedValue);
                } else {
                    str = "CC(remember):GlassComponents.kt#9igjgp";
                    f6 = 0.0f;
                    glassComponentsKt$LiquidFilterDock$1$1RememberedValue = new GlassComponentsKt$LiquidFilterDock$1$1(stateRememberUpdatedState, options, fMo362toPx0680j_4, size, stateRememberUpdatedState2, mutableState, mutableState2, null);
                    composer2.updateRememberedValue(glassComponentsKt$LiquidFilterDock$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierPointerInput3 = SuspendingPointerInputFilterKt.pointerInput(modifierTestTag5, unit3, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) glassComponentsKt$LiquidFilterDock$1$1RememberedValue);
                ComposerKt.sourceInformationMarkerStart(composer2, -2015112123, str);
                if ((i6 & 7168) == 2048) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                zChanged2 = z5 | composer2.changed(stateAnimateFloatAsState2);
                objRememberedValue3 = composer2.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$50$lambda$49(z3, stateAnimateFloatAsState2, (DrawScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$50$lambda$49(z3, stateAnimateFloatAsState2, (DrawScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierM670padding3ABfNKs3 = PaddingKt.m670padding3ABfNKs(DrawModifierKt.drawBehind(modifierPointerInput3, (Function1) objRememberedValue3), Dp.m6261constructorimpl(6.0f));
                Alignment centerStart3 = Alignment.INSTANCE.getCenterStart();
                str2 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(centerStart3, false);
                str3 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap7 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composer2, modifierM670padding3ABfNKs3);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                str4 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composerM3313constructorimpl = Updater.m3313constructorimpl(composer2);
                Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl.getInserting()) {
                    composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -861614733, "C599@26022L60,601@26155L101,606@26325L1332,597@25961L2549,652@28626L2537:GlassComponents.kt#75kw8w");
                Modifier.Companion companion12 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -304891878, str);
                zChanged3 = composer2.changed(stateAnimateFloatAsState);
                objRememberedValue4 = composer2.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$52$lambda$51(stateAnimateFloatAsState, (Density) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$52$lambda$51(stateAnimateFloatAsState, (Density) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierM717sizeVpY3zN6 = SizeKt.m717sizeVpY3zN4(androidx.compose.foundation.layout.OffsetKt.offset(companion12, (Function1) objRememberedValue4), fM6261constructorimpl, Dp.m6261constructorimpl(44.0f));
                ComposerKt.sourceInformationMarkerStart(composer2, -304887581, str);
                zChanged4 = composer2.changed(fLiquidFilterDock$lambda$46) | composer2.changed(fLiquidFilterDock$lambda$47);
                objRememberedValue5 = composer2.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$54$lambda$53(fLiquidFilterDock$lambda$46, fLiquidFilterDock$lambda$47, (GraphicsLayerScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$54$lambda$53(fLiquidFilterDock$lambda$46, fLiquidFilterDock$lambda$47, (GraphicsLayerScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierClip3 = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierM717sizeVpY3zN6, (Function1) objRememberedValue5), RoundedCornerShapeKt.getCircleShape());
                ComposerKt.sourceInformationMarkerStart(composer2, -304880910, str);
                zChanged5 = composer2.changed(fAbs) | composer2.changed(fCoerceIn2);
                objRememberedValue6 = composer2.rememberedValue();
                if (!zChanged5) {
                    objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$56$lambda$55(fAbs, fCoerceIn2, (ContentDrawScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$56$lambda$55(fAbs, fCoerceIn2, (ContentDrawScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierDrawWithContent3 = DrawModifierKt.drawWithContent(modifierClip3, (Function1) objRememberedValue6);
                if (z3 != 0) {
                    Brush.Companion companion13 = Brush.INSTANCE;
                    Color[] colorArr5 = new Color[2];
                    long jM3846getBlack0d7_KjU5 = Color.INSTANCE.m3846getBlack0d7_KjU();
                    if (LiquidFilterDock$lambda$36(mutableState)) {
                        f12 = 0.32f;
                    } else {
                        f12 = 0.32f;
                    }
                    colorArr5[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU5, f12, 0.0f, 0.0f, 0.0f, 14, null));
                    long jM3846getBlack0d7_KjU6 = Color.INSTANCE.m3846getBlack0d7_KjU();
                    if (LiquidFilterDock$lambda$36(mutableState)) {
                        f13 = 0.18f;
                    } else {
                        f13 = 0.18f;
                    }
                    colorArr5[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU6, f13, 0.0f, 0.0f, 0.0f, 14, null));
                    brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion13, CollectionsKt.listOf((Object[]) colorArr5), 0.0f, 0.0f, 0, 14, (Object) null);
                } else {
                    Brush.Companion companion14 = Brush.INSTANCE;
                    Color[] colorArr6 = new Color[2];
                    long jM3857getWhite0d7_KjU5 = Color.INSTANCE.m3857getWhite0d7_KjU();
                    if (LiquidFilterDock$lambda$36(mutableState)) {
                        f7 = 0.28f;
                    } else {
                        f7 = 0.28f;
                    }
                    colorArr6[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU5, f7, 0.0f, 0.0f, 0.0f, 14, null));
                    long jM3857getWhite0d7_KjU6 = Color.INSTANCE.m3857getWhite0d7_KjU();
                    if (LiquidFilterDock$lambda$36(mutableState)) {
                        f8 = 0.12f;
                    } else {
                        f8 = 0.12f;
                    }
                    colorArr6[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU6, f8, 0.0f, 0.0f, 0.0f, 14, null));
                    brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion14, CollectionsKt.listOf((Object[]) colorArr6), 0.0f, 0.0f, 0, 14, (Object) null);
                }
                BoxKt.Box(BackgroundKt.background$default(modifierDrawWithContent3, brushM3777verticalGradient8A3gB4$default, null, 0.0f, 6, null), composer2, 0);
                Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_6 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(f6));
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                Modifier.Companion companion15 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_6, centerVertically3, composer2, 54);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap8 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composer2, companion15);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                composerM3313constructorimpl2 = Updater.m3313constructorimpl(composer2);
                Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
                ComposerKt.sourceInformationMarkerStart(composer2, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -1636699622, "C:GlassComponents.kt#75kw8w");
                f9 = fMo362toPx0680j_4 / 2.0f;
                fLiquidFilterDock$lambda$43 = LiquidFilterDock$lambda$42(stateAnimateFloatAsState) + f9;
                if (fMo362toPx0680j_4 > f6) {
                    iCoerceIn = RangesKt.coerceIn(MathKt.roundToInt(LiquidFilterDock$lambda$42(stateAnimateFloatAsState) / fMo362toPx0680j_4), 0, options.size() - 1);
                } else {
                    iCoerceIn = iCoerceAtLeast;
                }
                composer2.startReplaceGroup(-1022619500);
                ComposerKt.sourceInformation(composer2, "*677@30237L902");
                it = options.iterator();
                i8 = 0;
                while (it.hasNext()) {
                    Object next3 = it.next();
                    int i12 = i8 + 1;
                    if (i8 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    String str11 = (String) next3;
                    float f118 = (((i8 * fMo362toPx0680j_4) + f9) - fLiquidFilterDock$lambda$43) / f9;
                    float f119 = fLiquidFilterDock$lambda$43;
                    float f1110 = f6;
                    Iterator it4 = it;
                    float fCoerceIn9 = RangesKt.coerceIn(Math.abs(f118) / 1.35f, f1110, 1.0f);
                    fCoerceIn4 = RangesKt.coerceIn(1.0f - (fCoerceIn9 * fCoerceIn9), f1110, 1.0f);
                    fMo362toPx0680j_5 = (density.mo362toPx0680j_4(Dp.m6261constructorimpl(8.0f)) * ((float) Math.sin(((double) f118) * 3.141592653589793d)) * fCoerceIn4) + (0.14f * fLiquidFilterDock$lambda$42 * fCoerceIn4);
                    float f1111 = (0.18f * fCoerceIn4) + 1.0f;
                    float f24 = f9;
                    float fCoerceIn10 = 1.0f - RangesKt.coerceIn(Math.abs(f118), 0.0f, 1.0f);
                    f10 = f1111 * (1.0f - ((0.08f * fCoerceIn10) * fCoerceIn4));
                    f11 = ((fCoerceIn10 * 0.05f * fCoerceIn4) + 1.0f) * f1111;
                    if (i8 == iCoerceIn) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (z3 != 0) {
                        alpinePrimaryContainer = Color.INSTANCE.m3857getWhite0d7_KjU();
                    } else {
                        alpinePrimaryContainer = ColorKt.getAlpinePrimaryContainer();
                    }
                    if (z3 != 0) {
                        jM3819copywmQWz5c$default = androidx.compose.ui.graphics.ColorKt.Color(4281549141L);
                    } else {
                        jM3819copywmQWz5c$default = Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.65f, 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    float f25 = fMo362toPx0680j_4;
                    z8 = z7;
                    Modifier modifierTestTag6 = TestTagKt.testTag(ClipKt.clip(SizeKt.m717sizeVpY3zN4(Modifier.INSTANCE, fM6261constructorimpl, Dp.m6261constructorimpl(44.0f)), RoundedCornerShapeKt.getCircleShape()), "filter_option_" + str11);
                    Alignment center3 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, str2);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
                    String str12 = str2;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str3);
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap9 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composer2, modifierTestTag6);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    String str13 = str3;
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str4);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    composerM3313constructorimpl3 = Updater.m3313constructorimpl(composer2);
                    Updater.m3320setimpl(composerM3313constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3320setimpl(composerM3313constructorimpl3, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM3313constructorimpl3.getInserting()) {
                        composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    } else {
                        composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m3320setimpl(composerM3313constructorimpl3, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 195873989, "C689@30857L242,684@30529L592:GlassComponents.kt#75kw8w");
                    if (!z8) {
                        alpinePrimaryContainer = jM3819copywmQWz5c$default;
                    }
                    long sp3 = TextUnitKt.getSp(14);
                    if (z8) {
                        medium = FontWeight.INSTANCE.getBold();
                    } else {
                        medium = FontWeight.INSTANCE.getMedium();
                    }
                    Modifier.Companion companion16 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1794786656, str);
                    zChanged6 = composer2.changed(fMo362toPx0680j_5) | composer2.changed(f10) | composer2.changed(f11) | composer2.changed(fCoerceIn4);
                    objRememberedValue7 = composer2.rememberedValue();
                    if (!zChanged6) {
                        objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$62$lambda$61$lambda$60$lambda$59$lambda$58(fMo362toPx0680j_5, f10, f11, fCoerceIn4, (GraphicsLayerScope) obj2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    } else {
                        objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$62$lambda$61$lambda$60$lambda$59$lambda$58(fMo362toPx0680j_5, f10, f11, fCoerceIn4, (GraphicsLayerScope) obj2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Composer composer6 = composer2;
                    TextKt.m2354Text4IGK_g(str11, GraphicsLayerModifierKt.graphicsLayer(companion16, (Function1) objRememberedValue7), alpinePrimaryContainer, sp3, (FontStyle) null, medium, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer6, 3072, 0, 131024);
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    composer6.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    fLiquidFilterDock$lambda$43 = f119;
                    str4 = str4;
                    str = str;
                    composer2 = composer6;
                    i8 = i12;
                    it = it4;
                    f9 = f24;
                    str2 = str12;
                    fMo362toPx0680j_4 = f25;
                    str3 = str13;
                    f6 = 0.0f;
                }
                composer3 = composer2;
                composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z3;
                modifier3 = companion;
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return GlassComponentsKt.LiquidFilterDock$lambda$64(options, selectedOption, onOptionSelected, z6, modifier3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z2 = z;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                if (composerStartRestartGroup.changed(modifier2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((i3 & 9363) != 9362) {
                if (i9 != 0) {
                    z2 = false;
                }
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1883659240, i3, -1, "com.example.ui.theme.LiquidFilterDock (GlassComponents.kt:442)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2015290950, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2015289065, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                z3 = z2;
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                fM6261constructorimpl = Dp.m6261constructorimpl(76.0f);
                ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume4 = composerStartRestartGroup.consume(localDensity4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume4;
                i6 = i3;
                fMo362toPx0680j_4 = density.mo362toPx0680j_4(fM6261constructorimpl);
                size = (options.size() - 1) * fMo362toPx0680j_4;
                iCoerceAtLeast = RangesKt.coerceAtLeast(options.indexOf(selectedOption), 0);
                f = iCoerceAtLeast * fMo362toPx0680j_4;
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    f2 = 0.0f;
                    fCoerceIn = RangesKt.coerceIn(f + LiquidFilterDock$lambda$39(mutableState2), 0.0f, size);
                } else {
                    f2 = 0.0f;
                    fCoerceIn = f;
                }
                float f1112 = fCoerceIn;
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    obj = null;
                    springSpecSpring$default = AnimationSpecKt.spring$default(f2, 10000.0f, null, 5, null);
                    f3 = 0.45f;
                    i7 = 4;
                } else {
                    obj = null;
                    f3 = 0.45f;
                    i7 = 4;
                    springSpecSpring$default = AnimationSpecKt.spring$default(0.45f, 180.0f, null, 4, null);
                }
                float f1113 = f3;
                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f1112, springSpecSpring$default, 0.0f, "filter_thumb_offset", null, composerStartRestartGroup, 3072, 20);
                fLiquidFilterDock$lambda$42 = LiquidFilterDock$lambda$42(stateAnimateFloatAsState) - LiquidFilterDock$lambda$43(AnimateAsStateKt.animateFloatAsState(f1112, AnimationSpecKt.spring$default(0.55f, 85.0f, obj, i7, obj), 0.0f, "filter_lagged_thumb_offset", null, composerStartRestartGroup, 3120, 20));
                fCoerceIn2 = RangesKt.coerceIn(fLiquidFilterDock$lambda$42 / density.mo362toPx0680j_4(Dp.m6261constructorimpl(14.0f)), -1.0f, 1.0f);
                fAbs = Math.abs(fCoerceIn2);
                fAbs2 = Math.abs(LiquidFilterDock$lambda$42(stateAnimateFloatAsState) - f);
                if (size > 0.0f) {
                    f4 = size;
                } else {
                    f4 = 1.0f;
                }
                if (fAbs2 > density.mo362toPx0680j_4(Dp.m6261constructorimpl(3.0f))) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    fCoerceIn3 = 1.0f;
                } else {
                    fCoerceIn3 = RangesKt.coerceIn(fAbs2 / (f4 * 0.7f), 0.0f, 1.0f);
                }
                State<Float> stateAnimateFloatAsState6 = AnimateAsStateKt.animateFloatAsState((fCoerceIn3 * 0.48f) + 1.0f, AnimationSpecKt.spring$default(0.65f, 220.0f, null, 4, null), 0.0f, "filter_thumb_scale", null, composerStartRestartGroup, 3120, 20);
                float fCoerceAtMost4 = RangesKt.coerceAtMost(Math.abs(LiquidFilterDock$lambda$39(mutableState2)) / 240.0f, 0.09f);
                fLiquidFilterDock$lambda$46 = LiquidFilterDock$lambda$46(stateAnimateFloatAsState6) * (fCoerceAtMost4 + 1.0f);
                fLiquidFilterDock$lambda$47 = LiquidFilterDock$lambda$46(stateAnimateFloatAsState6) * (1.0f - (fCoerceAtMost4 * f1113));
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    f5 = 0.5f;
                } else {
                    f5 = 0.5f;
                }
                stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f5, AnimationSpecKt.tween$default(ComposerKt.invocationKey, 0, null, 6, null), 0.0f, "filter_specular_border", null, composerStartRestartGroup, 3120, 20);
                composer2 = composerStartRestartGroup;
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(selectedOption, composer2, (i6 >> 3) & 14);
                stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(onOptionSelected, composer2, (i6 >> 6) & 14);
                Modifier modifierTestTag7 = TestTagKt.testTag(companion, "liquid_filter_dock");
                Unit unit4 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -2015188241, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged = composer2.changed(stateRememberUpdatedState) | composer2.changedInstance(options) | composer2.changed(fMo362toPx0680j_4) | composer2.changed(size) | composer2.changed(stateRememberUpdatedState2);
                glassComponentsKt$LiquidFilterDock$1$1RememberedValue = composer2.rememberedValue();
                if (!zChanged) {
                    str = "CC(remember):GlassComponents.kt#9igjgp";
                    f6 = 0.0f;
                    glassComponentsKt$LiquidFilterDock$1$1RememberedValue = new GlassComponentsKt$LiquidFilterDock$1$1(stateRememberUpdatedState, options, fMo362toPx0680j_4, size, stateRememberUpdatedState2, mutableState, mutableState2, null);
                    composer2.updateRememberedValue(glassComponentsKt$LiquidFilterDock$1$1RememberedValue);
                } else {
                    str = "CC(remember):GlassComponents.kt#9igjgp";
                    f6 = 0.0f;
                    glassComponentsKt$LiquidFilterDock$1$1RememberedValue = new GlassComponentsKt$LiquidFilterDock$1$1(stateRememberUpdatedState, options, fMo362toPx0680j_4, size, stateRememberUpdatedState2, mutableState, mutableState2, null);
                    composer2.updateRememberedValue(glassComponentsKt$LiquidFilterDock$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierPointerInput4 = SuspendingPointerInputFilterKt.pointerInput(modifierTestTag7, unit4, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) glassComponentsKt$LiquidFilterDock$1$1RememberedValue);
                ComposerKt.sourceInformationMarkerStart(composer2, -2015112123, str);
                if ((i6 & 7168) == 2048) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                zChanged2 = z5 | composer2.changed(stateAnimateFloatAsState2);
                objRememberedValue3 = composer2.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$50$lambda$49(z3, stateAnimateFloatAsState2, (DrawScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$50$lambda$49(z3, stateAnimateFloatAsState2, (DrawScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierM670padding3ABfNKs4 = PaddingKt.m670padding3ABfNKs(DrawModifierKt.drawBehind(modifierPointerInput4, (Function1) objRememberedValue3), Dp.m6261constructorimpl(6.0f));
                Alignment centerStart4 = Alignment.INSTANCE.getCenterStart();
                str2 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(centerStart4, false);
                str3 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap10 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composer2, modifierM670padding3ABfNKs4);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                str4 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composerM3313constructorimpl = Updater.m3313constructorimpl(composer2);
                Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl.getInserting()) {
                    composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -861614733, "C599@26022L60,601@26155L101,606@26325L1332,597@25961L2549,652@28626L2537:GlassComponents.kt#75kw8w");
                Modifier.Companion companion17 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -304891878, str);
                zChanged3 = composer2.changed(stateAnimateFloatAsState);
                objRememberedValue4 = composer2.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$52$lambda$51(stateAnimateFloatAsState, (Density) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$52$lambda$51(stateAnimateFloatAsState, (Density) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierM717sizeVpY3zN7 = SizeKt.m717sizeVpY3zN4(androidx.compose.foundation.layout.OffsetKt.offset(companion17, (Function1) objRememberedValue4), fM6261constructorimpl, Dp.m6261constructorimpl(44.0f));
                ComposerKt.sourceInformationMarkerStart(composer2, -304887581, str);
                zChanged4 = composer2.changed(fLiquidFilterDock$lambda$46) | composer2.changed(fLiquidFilterDock$lambda$47);
                objRememberedValue5 = composer2.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$54$lambda$53(fLiquidFilterDock$lambda$46, fLiquidFilterDock$lambda$47, (GraphicsLayerScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$54$lambda$53(fLiquidFilterDock$lambda$46, fLiquidFilterDock$lambda$47, (GraphicsLayerScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierClip4 = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierM717sizeVpY3zN7, (Function1) objRememberedValue5), RoundedCornerShapeKt.getCircleShape());
                ComposerKt.sourceInformationMarkerStart(composer2, -304880910, str);
                zChanged5 = composer2.changed(fAbs) | composer2.changed(fCoerceIn2);
                objRememberedValue6 = composer2.rememberedValue();
                if (!zChanged5) {
                    objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$56$lambda$55(fAbs, fCoerceIn2, (ContentDrawScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$56$lambda$55(fAbs, fCoerceIn2, (ContentDrawScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierDrawWithContent4 = DrawModifierKt.drawWithContent(modifierClip4, (Function1) objRememberedValue6);
                if (z3 != 0) {
                    Brush.Companion companion18 = Brush.INSTANCE;
                    Color[] colorArr7 = new Color[2];
                    long jM3846getBlack0d7_KjU7 = Color.INSTANCE.m3846getBlack0d7_KjU();
                    if (LiquidFilterDock$lambda$36(mutableState)) {
                        f12 = 0.32f;
                    } else {
                        f12 = 0.32f;
                    }
                    colorArr7[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU7, f12, 0.0f, 0.0f, 0.0f, 14, null));
                    long jM3846getBlack0d7_KjU8 = Color.INSTANCE.m3846getBlack0d7_KjU();
                    if (LiquidFilterDock$lambda$36(mutableState)) {
                        f13 = 0.18f;
                    } else {
                        f13 = 0.18f;
                    }
                    colorArr7[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU8, f13, 0.0f, 0.0f, 0.0f, 14, null));
                    brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion18, CollectionsKt.listOf((Object[]) colorArr7), 0.0f, 0.0f, 0, 14, (Object) null);
                } else {
                    Brush.Companion companion19 = Brush.INSTANCE;
                    Color[] colorArr8 = new Color[2];
                    long jM3857getWhite0d7_KjU7 = Color.INSTANCE.m3857getWhite0d7_KjU();
                    if (LiquidFilterDock$lambda$36(mutableState)) {
                        f7 = 0.28f;
                    } else {
                        f7 = 0.28f;
                    }
                    colorArr8[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU7, f7, 0.0f, 0.0f, 0.0f, 14, null));
                    long jM3857getWhite0d7_KjU8 = Color.INSTANCE.m3857getWhite0d7_KjU();
                    if (LiquidFilterDock$lambda$36(mutableState)) {
                        f8 = 0.12f;
                    } else {
                        f8 = 0.12f;
                    }
                    colorArr8[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU8, f8, 0.0f, 0.0f, 0.0f, 14, null));
                    brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion19, CollectionsKt.listOf((Object[]) colorArr8), 0.0f, 0.0f, 0, 14, (Object) null);
                }
                BoxKt.Box(BackgroundKt.background$default(modifierDrawWithContent4, brushM3777verticalGradient8A3gB4$default, null, 0.0f, 6, null), composer2, 0);
                Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_7 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(f6));
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                Modifier.Companion companion110 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_7, centerVertically4, composer2, 54);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap11 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composer2, companion110);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                composerM3313constructorimpl2 = Updater.m3313constructorimpl(composer2);
                Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl2.getInserting()) {
                    composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -1636699622, "C:GlassComponents.kt#75kw8w");
                f9 = fMo362toPx0680j_4 / 2.0f;
                fLiquidFilterDock$lambda$43 = LiquidFilterDock$lambda$42(stateAnimateFloatAsState) + f9;
                if (fMo362toPx0680j_4 > f6) {
                    iCoerceIn = RangesKt.coerceIn(MathKt.roundToInt(LiquidFilterDock$lambda$42(stateAnimateFloatAsState) / fMo362toPx0680j_4), 0, options.size() - 1);
                } else {
                    iCoerceIn = iCoerceAtLeast;
                }
                composer2.startReplaceGroup(-1022619500);
                ComposerKt.sourceInformation(composer2, "*677@30237L902");
                it = options.iterator();
                i8 = 0;
                while (it.hasNext()) {
                    Object next4 = it.next();
                    int i13 = i8 + 1;
                    if (i8 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    String str14 = (String) next4;
                    float f1114 = (((i8 * fMo362toPx0680j_4) + f9) - fLiquidFilterDock$lambda$43) / f9;
                    float f1115 = fLiquidFilterDock$lambda$43;
                    float f1116 = f6;
                    Iterator it5 = it;
                    float fCoerceIn11 = RangesKt.coerceIn(Math.abs(f1114) / 1.35f, f1116, 1.0f);
                    fCoerceIn4 = RangesKt.coerceIn(1.0f - (fCoerceIn11 * fCoerceIn11), f1116, 1.0f);
                    fMo362toPx0680j_5 = (density.mo362toPx0680j_4(Dp.m6261constructorimpl(8.0f)) * ((float) Math.sin(((double) f1114) * 3.141592653589793d)) * fCoerceIn4) + (0.14f * fLiquidFilterDock$lambda$42 * fCoerceIn4);
                    float f1117 = (0.18f * fCoerceIn4) + 1.0f;
                    float f26 = f9;
                    float fCoerceIn12 = 1.0f - RangesKt.coerceIn(Math.abs(f1114), 0.0f, 1.0f);
                    f10 = f1117 * (1.0f - ((0.08f * fCoerceIn12) * fCoerceIn4));
                    f11 = ((fCoerceIn12 * 0.05f * fCoerceIn4) + 1.0f) * f1117;
                    if (i8 == iCoerceIn) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (z3 != 0) {
                        alpinePrimaryContainer = Color.INSTANCE.m3857getWhite0d7_KjU();
                    } else {
                        alpinePrimaryContainer = ColorKt.getAlpinePrimaryContainer();
                    }
                    if (z3 != 0) {
                        jM3819copywmQWz5c$default = androidx.compose.ui.graphics.ColorKt.Color(4281549141L);
                    } else {
                        jM3819copywmQWz5c$default = Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.65f, 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    float f27 = fMo362toPx0680j_4;
                    z8 = z7;
                    Modifier modifierTestTag8 = TestTagKt.testTag(ClipKt.clip(SizeKt.m717sizeVpY3zN4(Modifier.INSTANCE, fM6261constructorimpl, Dp.m6261constructorimpl(44.0f)), RoundedCornerShapeKt.getCircleShape()), "filter_option_" + str14);
                    Alignment center4 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, str2);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(center4, false);
                    String str15 = str2;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str3);
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap12 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composer2, modifierTestTag8);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    String str16 = str3;
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str4);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    composerM3313constructorimpl3 = Updater.m3313constructorimpl(composer2);
                    Updater.m3320setimpl(composerM3313constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3320setimpl(composerM3313constructorimpl3, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM3313constructorimpl3.getInserting()) {
                        composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    } else {
                        composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m3320setimpl(composerM3313constructorimpl3, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 195873989, "C689@30857L242,684@30529L592:GlassComponents.kt#75kw8w");
                    if (!z8) {
                        alpinePrimaryContainer = jM3819copywmQWz5c$default;
                    }
                    long sp4 = TextUnitKt.getSp(14);
                    if (z8) {
                        medium = FontWeight.INSTANCE.getBold();
                    } else {
                        medium = FontWeight.INSTANCE.getMedium();
                    }
                    Modifier.Companion companion111 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1794786656, str);
                    zChanged6 = composer2.changed(fMo362toPx0680j_5) | composer2.changed(f10) | composer2.changed(f11) | composer2.changed(fCoerceIn4);
                    objRememberedValue7 = composer2.rememberedValue();
                    if (!zChanged6) {
                        objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$62$lambda$61$lambda$60$lambda$59$lambda$58(fMo362toPx0680j_5, f10, f11, fCoerceIn4, (GraphicsLayerScope) obj2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    } else {
                        objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$62$lambda$61$lambda$60$lambda$59$lambda$58(fMo362toPx0680j_5, f10, f11, fCoerceIn4, (GraphicsLayerScope) obj2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Composer composer7 = composer2;
                    TextKt.m2354Text4IGK_g(str14, GraphicsLayerModifierKt.graphicsLayer(companion111, (Function1) objRememberedValue7), alpinePrimaryContainer, sp4, (FontStyle) null, medium, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer7, 3072, 0, 131024);
                    ComposerKt.sourceInformationMarkerEnd(composer7);
                    ComposerKt.sourceInformationMarkerEnd(composer7);
                    composer7.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer7);
                    ComposerKt.sourceInformationMarkerEnd(composer7);
                    ComposerKt.sourceInformationMarkerEnd(composer7);
                    fLiquidFilterDock$lambda$43 = f1115;
                    str4 = str4;
                    str = str;
                    composer2 = composer7;
                    i8 = i13;
                    it = it5;
                    f9 = f26;
                    str2 = str15;
                    fMo362toPx0680j_4 = f27;
                    str3 = str16;
                    f6 = 0.0f;
                }
                composer3 = composer2;
                composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z3;
                modifier3 = companion;
            } else {
                if (i9 != 0) {
                    z2 = false;
                }
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1883659240, i3, -1, "com.example.ui.theme.LiquidFilterDock (GlassComponents.kt:442)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2015290950, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2015289065, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                z3 = z2;
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                fM6261constructorimpl = Dp.m6261constructorimpl(76.0f);
                ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume5 = composerStartRestartGroup.consume(localDensity5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume5;
                i6 = i3;
                fMo362toPx0680j_4 = density.mo362toPx0680j_4(fM6261constructorimpl);
                size = (options.size() - 1) * fMo362toPx0680j_4;
                iCoerceAtLeast = RangesKt.coerceAtLeast(options.indexOf(selectedOption), 0);
                f = iCoerceAtLeast * fMo362toPx0680j_4;
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    f2 = 0.0f;
                    fCoerceIn = RangesKt.coerceIn(f + LiquidFilterDock$lambda$39(mutableState2), 0.0f, size);
                } else {
                    f2 = 0.0f;
                    fCoerceIn = f;
                }
                float f1118 = fCoerceIn;
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    obj = null;
                    springSpecSpring$default = AnimationSpecKt.spring$default(f2, 10000.0f, null, 5, null);
                    f3 = 0.45f;
                    i7 = 4;
                } else {
                    obj = null;
                    f3 = 0.45f;
                    i7 = 4;
                    springSpecSpring$default = AnimationSpecKt.spring$default(0.45f, 180.0f, null, 4, null);
                }
                float f1119 = f3;
                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f1118, springSpecSpring$default, 0.0f, "filter_thumb_offset", null, composerStartRestartGroup, 3072, 20);
                fLiquidFilterDock$lambda$42 = LiquidFilterDock$lambda$42(stateAnimateFloatAsState) - LiquidFilterDock$lambda$43(AnimateAsStateKt.animateFloatAsState(f1118, AnimationSpecKt.spring$default(0.55f, 85.0f, obj, i7, obj), 0.0f, "filter_lagged_thumb_offset", null, composerStartRestartGroup, 3120, 20));
                fCoerceIn2 = RangesKt.coerceIn(fLiquidFilterDock$lambda$42 / density.mo362toPx0680j_4(Dp.m6261constructorimpl(14.0f)), -1.0f, 1.0f);
                fAbs = Math.abs(fCoerceIn2);
                fAbs2 = Math.abs(LiquidFilterDock$lambda$42(stateAnimateFloatAsState) - f);
                if (size > 0.0f) {
                    f4 = size;
                } else {
                    f4 = 1.0f;
                }
                if (fAbs2 > density.mo362toPx0680j_4(Dp.m6261constructorimpl(3.0f))) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    fCoerceIn3 = 1.0f;
                } else {
                    fCoerceIn3 = RangesKt.coerceIn(fAbs2 / (f4 * 0.7f), 0.0f, 1.0f);
                }
                State<Float> stateAnimateFloatAsState7 = AnimateAsStateKt.animateFloatAsState((fCoerceIn3 * 0.48f) + 1.0f, AnimationSpecKt.spring$default(0.65f, 220.0f, null, 4, null), 0.0f, "filter_thumb_scale", null, composerStartRestartGroup, 3120, 20);
                float fCoerceAtMost5 = RangesKt.coerceAtMost(Math.abs(LiquidFilterDock$lambda$39(mutableState2)) / 240.0f, 0.09f);
                fLiquidFilterDock$lambda$46 = LiquidFilterDock$lambda$46(stateAnimateFloatAsState7) * (fCoerceAtMost5 + 1.0f);
                fLiquidFilterDock$lambda$47 = LiquidFilterDock$lambda$46(stateAnimateFloatAsState7) * (1.0f - (fCoerceAtMost5 * f1119));
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    f5 = 0.5f;
                } else {
                    f5 = 0.5f;
                }
                stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f5, AnimationSpecKt.tween$default(ComposerKt.invocationKey, 0, null, 6, null), 0.0f, "filter_specular_border", null, composerStartRestartGroup, 3120, 20);
                composer2 = composerStartRestartGroup;
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(selectedOption, composer2, (i6 >> 3) & 14);
                stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(onOptionSelected, composer2, (i6 >> 6) & 14);
                Modifier modifierTestTag9 = TestTagKt.testTag(companion, "liquid_filter_dock");
                Unit unit5 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -2015188241, "CC(remember):GlassComponents.kt#9igjgp");
                zChanged = composer2.changed(stateRememberUpdatedState) | composer2.changedInstance(options) | composer2.changed(fMo362toPx0680j_4) | composer2.changed(size) | composer2.changed(stateRememberUpdatedState2);
                glassComponentsKt$LiquidFilterDock$1$1RememberedValue = composer2.rememberedValue();
                if (!zChanged) {
                    str = "CC(remember):GlassComponents.kt#9igjgp";
                    f6 = 0.0f;
                    glassComponentsKt$LiquidFilterDock$1$1RememberedValue = new GlassComponentsKt$LiquidFilterDock$1$1(stateRememberUpdatedState, options, fMo362toPx0680j_4, size, stateRememberUpdatedState2, mutableState, mutableState2, null);
                    composer2.updateRememberedValue(glassComponentsKt$LiquidFilterDock$1$1RememberedValue);
                } else {
                    str = "CC(remember):GlassComponents.kt#9igjgp";
                    f6 = 0.0f;
                    glassComponentsKt$LiquidFilterDock$1$1RememberedValue = new GlassComponentsKt$LiquidFilterDock$1$1(stateRememberUpdatedState, options, fMo362toPx0680j_4, size, stateRememberUpdatedState2, mutableState, mutableState2, null);
                    composer2.updateRememberedValue(glassComponentsKt$LiquidFilterDock$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierPointerInput5 = SuspendingPointerInputFilterKt.pointerInput(modifierTestTag9, unit5, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) glassComponentsKt$LiquidFilterDock$1$1RememberedValue);
                ComposerKt.sourceInformationMarkerStart(composer2, -2015112123, str);
                if ((i6 & 7168) == 2048) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                zChanged2 = z5 | composer2.changed(stateAnimateFloatAsState2);
                objRememberedValue3 = composer2.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$50$lambda$49(z3, stateAnimateFloatAsState2, (DrawScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$50$lambda$49(z3, stateAnimateFloatAsState2, (DrawScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierM670padding3ABfNKs5 = PaddingKt.m670padding3ABfNKs(DrawModifierKt.drawBehind(modifierPointerInput5, (Function1) objRememberedValue3), Dp.m6261constructorimpl(6.0f));
                Alignment centerStart5 = Alignment.INSTANCE.getCenterStart();
                str2 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(centerStart5, false);
                str3 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap13 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composer2, modifierM670padding3ABfNKs5);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                str4 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composerM3313constructorimpl = Updater.m3313constructorimpl(composer2);
                Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl.getInserting()) {
                    composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -861614733, "C599@26022L60,601@26155L101,606@26325L1332,597@25961L2549,652@28626L2537:GlassComponents.kt#75kw8w");
                Modifier.Companion companion112 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -304891878, str);
                zChanged3 = composer2.changed(stateAnimateFloatAsState);
                objRememberedValue4 = composer2.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$52$lambda$51(stateAnimateFloatAsState, (Density) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$52$lambda$51(stateAnimateFloatAsState, (Density) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierM717sizeVpY3zN8 = SizeKt.m717sizeVpY3zN4(androidx.compose.foundation.layout.OffsetKt.offset(companion112, (Function1) objRememberedValue4), fM6261constructorimpl, Dp.m6261constructorimpl(44.0f));
                ComposerKt.sourceInformationMarkerStart(composer2, -304887581, str);
                zChanged4 = composer2.changed(fLiquidFilterDock$lambda$46) | composer2.changed(fLiquidFilterDock$lambda$47);
                objRememberedValue5 = composer2.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$54$lambda$53(fLiquidFilterDock$lambda$46, fLiquidFilterDock$lambda$47, (GraphicsLayerScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$54$lambda$53(fLiquidFilterDock$lambda$46, fLiquidFilterDock$lambda$47, (GraphicsLayerScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierClip5 = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierM717sizeVpY3zN8, (Function1) objRememberedValue5), RoundedCornerShapeKt.getCircleShape());
                ComposerKt.sourceInformationMarkerStart(composer2, -304880910, str);
                zChanged5 = composer2.changed(fAbs) | composer2.changed(fCoerceIn2);
                objRememberedValue6 = composer2.rememberedValue();
                if (!zChanged5) {
                    objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$56$lambda$55(fAbs, fCoerceIn2, (ContentDrawScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$56$lambda$55(fAbs, fCoerceIn2, (ContentDrawScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierDrawWithContent5 = DrawModifierKt.drawWithContent(modifierClip5, (Function1) objRememberedValue6);
                if (z3 != 0) {
                    Brush.Companion companion113 = Brush.INSTANCE;
                    Color[] colorArr9 = new Color[2];
                    long jM3846getBlack0d7_KjU9 = Color.INSTANCE.m3846getBlack0d7_KjU();
                    if (LiquidFilterDock$lambda$36(mutableState)) {
                        f12 = 0.32f;
                    } else {
                        f12 = 0.32f;
                    }
                    colorArr9[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU9, f12, 0.0f, 0.0f, 0.0f, 14, null));
                    long jM3846getBlack0d7_KjU10 = Color.INSTANCE.m3846getBlack0d7_KjU();
                    if (LiquidFilterDock$lambda$36(mutableState)) {
                        f13 = 0.18f;
                    } else {
                        f13 = 0.18f;
                    }
                    colorArr9[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU10, f13, 0.0f, 0.0f, 0.0f, 14, null));
                    brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion113, CollectionsKt.listOf((Object[]) colorArr9), 0.0f, 0.0f, 0, 14, (Object) null);
                } else {
                    Brush.Companion companion114 = Brush.INSTANCE;
                    Color[] colorArr10 = new Color[2];
                    long jM3857getWhite0d7_KjU9 = Color.INSTANCE.m3857getWhite0d7_KjU();
                    if (LiquidFilterDock$lambda$36(mutableState)) {
                        f7 = 0.28f;
                    } else {
                        f7 = 0.28f;
                    }
                    colorArr10[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU9, f7, 0.0f, 0.0f, 0.0f, 14, null));
                    long jM3857getWhite0d7_KjU10 = Color.INSTANCE.m3857getWhite0d7_KjU();
                    if (LiquidFilterDock$lambda$36(mutableState)) {
                        f8 = 0.12f;
                    } else {
                        f8 = 0.12f;
                    }
                    colorArr10[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU10, f8, 0.0f, 0.0f, 0.0f, 14, null));
                    brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion114, CollectionsKt.listOf((Object[]) colorArr10), 0.0f, 0.0f, 0, 14, (Object) null);
                }
                BoxKt.Box(BackgroundKt.background$default(modifierDrawWithContent5, brushM3777verticalGradient8A3gB4$default, null, 0.0f, 6, null), composer2, 0);
                Alignment.Vertical centerVertically5 = Alignment.INSTANCE.getCenterVertically();
                Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_8 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(f6));
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                Modifier.Companion companion115 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_8, centerVertically5, composer2, 54);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap14 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composer2, companion115);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                composerM3313constructorimpl2 = Updater.m3313constructorimpl(composer2);
                Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyRowMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl2.getInserting()) {
                    composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -1636699622, "C:GlassComponents.kt#75kw8w");
                f9 = fMo362toPx0680j_4 / 2.0f;
                fLiquidFilterDock$lambda$43 = LiquidFilterDock$lambda$42(stateAnimateFloatAsState) + f9;
                if (fMo362toPx0680j_4 > f6) {
                    iCoerceIn = RangesKt.coerceIn(MathKt.roundToInt(LiquidFilterDock$lambda$42(stateAnimateFloatAsState) / fMo362toPx0680j_4), 0, options.size() - 1);
                } else {
                    iCoerceIn = iCoerceAtLeast;
                }
                composer2.startReplaceGroup(-1022619500);
                ComposerKt.sourceInformation(composer2, "*677@30237L902");
                it = options.iterator();
                i8 = 0;
                while (it.hasNext()) {
                    Object next5 = it.next();
                    int i14 = i8 + 1;
                    if (i8 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    String str17 = (String) next5;
                    float f11110 = (((i8 * fMo362toPx0680j_4) + f9) - fLiquidFilterDock$lambda$43) / f9;
                    float f11111 = fLiquidFilterDock$lambda$43;
                    float f11112 = f6;
                    Iterator it6 = it;
                    float fCoerceIn13 = RangesKt.coerceIn(Math.abs(f11110) / 1.35f, f11112, 1.0f);
                    fCoerceIn4 = RangesKt.coerceIn(1.0f - (fCoerceIn13 * fCoerceIn13), f11112, 1.0f);
                    fMo362toPx0680j_5 = (density.mo362toPx0680j_4(Dp.m6261constructorimpl(8.0f)) * ((float) Math.sin(((double) f11110) * 3.141592653589793d)) * fCoerceIn4) + (0.14f * fLiquidFilterDock$lambda$42 * fCoerceIn4);
                    float f11113 = (0.18f * fCoerceIn4) + 1.0f;
                    float f28 = f9;
                    float fCoerceIn14 = 1.0f - RangesKt.coerceIn(Math.abs(f11110), 0.0f, 1.0f);
                    f10 = f11113 * (1.0f - ((0.08f * fCoerceIn14) * fCoerceIn4));
                    f11 = ((fCoerceIn14 * 0.05f * fCoerceIn4) + 1.0f) * f11113;
                    if (i8 == iCoerceIn) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (z3 != 0) {
                        alpinePrimaryContainer = Color.INSTANCE.m3857getWhite0d7_KjU();
                    } else {
                        alpinePrimaryContainer = ColorKt.getAlpinePrimaryContainer();
                    }
                    if (z3 != 0) {
                        jM3819copywmQWz5c$default = androidx.compose.ui.graphics.ColorKt.Color(4281549141L);
                    } else {
                        jM3819copywmQWz5c$default = Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.65f, 0.0f, 0.0f, 0.0f, 14, null);
                    }
                    float f29 = fMo362toPx0680j_4;
                    z8 = z7;
                    Modifier modifierTestTag10 = TestTagKt.testTag(ClipKt.clip(SizeKt.m717sizeVpY3zN4(Modifier.INSTANCE, fM6261constructorimpl, Dp.m6261constructorimpl(44.0f)), RoundedCornerShapeKt.getCircleShape()), "filter_option_" + str17);
                    Alignment center5 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, str2);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy10 = BoxKt.maybeCachedBoxMeasurePolicy(center5, false);
                    String str18 = str2;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str3);
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap15 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composer2, modifierTestTag10);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    String str19 = str3;
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str4);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    composerM3313constructorimpl3 = Updater.m3313constructorimpl(composer2);
                    Updater.m3320setimpl(composerM3313constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3320setimpl(composerM3313constructorimpl3, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM3313constructorimpl3.getInserting()) {
                        composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    } else {
                        composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m3320setimpl(composerM3313constructorimpl3, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance10 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 195873989, "C689@30857L242,684@30529L592:GlassComponents.kt#75kw8w");
                    if (!z8) {
                        alpinePrimaryContainer = jM3819copywmQWz5c$default;
                    }
                    long sp5 = TextUnitKt.getSp(14);
                    if (z8) {
                        medium = FontWeight.INSTANCE.getBold();
                    } else {
                        medium = FontWeight.INSTANCE.getMedium();
                    }
                    Modifier.Companion companion116 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1794786656, str);
                    zChanged6 = composer2.changed(fMo362toPx0680j_5) | composer2.changed(f10) | composer2.changed(f11) | composer2.changed(fCoerceIn4);
                    objRememberedValue7 = composer2.rememberedValue();
                    if (!zChanged6) {
                        objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$62$lambda$61$lambda$60$lambda$59$lambda$58(fMo362toPx0680j_5, f10, f11, fCoerceIn4, (GraphicsLayerScope) obj2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    } else {
                        objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$62$lambda$61$lambda$60$lambda$59$lambda$58(fMo362toPx0680j_5, f10, f11, fCoerceIn4, (GraphicsLayerScope) obj2);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Composer composer8 = composer2;
                    TextKt.m2354Text4IGK_g(str17, GraphicsLayerModifierKt.graphicsLayer(companion116, (Function1) objRememberedValue7), alpinePrimaryContainer, sp5, (FontStyle) null, medium, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer8, 3072, 0, 131024);
                    ComposerKt.sourceInformationMarkerEnd(composer8);
                    ComposerKt.sourceInformationMarkerEnd(composer8);
                    composer8.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer8);
                    ComposerKt.sourceInformationMarkerEnd(composer8);
                    ComposerKt.sourceInformationMarkerEnd(composer8);
                    fLiquidFilterDock$lambda$43 = f11111;
                    str4 = str4;
                    str = str;
                    composer2 = composer8;
                    i8 = i14;
                    it = it6;
                    f9 = f28;
                    str2 = str18;
                    fMo362toPx0680j_4 = f29;
                    str3 = str19;
                    f6 = 0.0f;
                }
                composer3 = composer2;
                composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z3;
                modifier3 = companion;
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return GlassComponentsKt.LiquidFilterDock$lambda$64(options, selectedOption, onOptionSelected, z6, modifier3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        modifier2 = modifier;
        if ((i3 & 9363) != 9362) {
            if (i9 != 0) {
                z2 = false;
            }
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1883659240, i3, -1, "com.example.ui.theme.LiquidFilterDock (GlassComponents.kt:442)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2015290950, "CC(remember):GlassComponents.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2015289065, "CC(remember):GlassComponents.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            z3 = z2;
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            fM6261constructorimpl = Dp.m6261constructorimpl(76.0f);
            ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume6 = composerStartRestartGroup.consume(localDensity6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume6;
            i6 = i3;
            fMo362toPx0680j_4 = density.mo362toPx0680j_4(fM6261constructorimpl);
            size = (options.size() - 1) * fMo362toPx0680j_4;
            iCoerceAtLeast = RangesKt.coerceAtLeast(options.indexOf(selectedOption), 0);
            f = iCoerceAtLeast * fMo362toPx0680j_4;
            if (LiquidFilterDock$lambda$36(mutableState)) {
                f2 = 0.0f;
                fCoerceIn = RangesKt.coerceIn(f + LiquidFilterDock$lambda$39(mutableState2), 0.0f, size);
            } else {
                f2 = 0.0f;
                fCoerceIn = f;
            }
            float f11114 = fCoerceIn;
            if (LiquidFilterDock$lambda$36(mutableState)) {
                obj = null;
                springSpecSpring$default = AnimationSpecKt.spring$default(f2, 10000.0f, null, 5, null);
                f3 = 0.45f;
                i7 = 4;
            } else {
                obj = null;
                f3 = 0.45f;
                i7 = 4;
                springSpecSpring$default = AnimationSpecKt.spring$default(0.45f, 180.0f, null, 4, null);
            }
            float f11115 = f3;
            stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f11114, springSpecSpring$default, 0.0f, "filter_thumb_offset", null, composerStartRestartGroup, 3072, 20);
            fLiquidFilterDock$lambda$42 = LiquidFilterDock$lambda$42(stateAnimateFloatAsState) - LiquidFilterDock$lambda$43(AnimateAsStateKt.animateFloatAsState(f11114, AnimationSpecKt.spring$default(0.55f, 85.0f, obj, i7, obj), 0.0f, "filter_lagged_thumb_offset", null, composerStartRestartGroup, 3120, 20));
            fCoerceIn2 = RangesKt.coerceIn(fLiquidFilterDock$lambda$42 / density.mo362toPx0680j_4(Dp.m6261constructorimpl(14.0f)), -1.0f, 1.0f);
            fAbs = Math.abs(fCoerceIn2);
            fAbs2 = Math.abs(LiquidFilterDock$lambda$42(stateAnimateFloatAsState) - f);
            if (size > 0.0f) {
                f4 = size;
            } else {
                f4 = 1.0f;
            }
            if (fAbs2 > density.mo362toPx0680j_4(Dp.m6261constructorimpl(3.0f))) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (LiquidFilterDock$lambda$36(mutableState)) {
                fCoerceIn3 = 1.0f;
            } else {
                fCoerceIn3 = RangesKt.coerceIn(fAbs2 / (f4 * 0.7f), 0.0f, 1.0f);
            }
            State<Float> stateAnimateFloatAsState8 = AnimateAsStateKt.animateFloatAsState((fCoerceIn3 * 0.48f) + 1.0f, AnimationSpecKt.spring$default(0.65f, 220.0f, null, 4, null), 0.0f, "filter_thumb_scale", null, composerStartRestartGroup, 3120, 20);
            float fCoerceAtMost6 = RangesKt.coerceAtMost(Math.abs(LiquidFilterDock$lambda$39(mutableState2)) / 240.0f, 0.09f);
            fLiquidFilterDock$lambda$46 = LiquidFilterDock$lambda$46(stateAnimateFloatAsState8) * (fCoerceAtMost6 + 1.0f);
            fLiquidFilterDock$lambda$47 = LiquidFilterDock$lambda$46(stateAnimateFloatAsState8) * (1.0f - (fCoerceAtMost6 * f11115));
            if (LiquidFilterDock$lambda$36(mutableState)) {
                f5 = 0.5f;
            } else {
                f5 = 0.5f;
            }
            stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f5, AnimationSpecKt.tween$default(ComposerKt.invocationKey, 0, null, 6, null), 0.0f, "filter_specular_border", null, composerStartRestartGroup, 3120, 20);
            composer2 = composerStartRestartGroup;
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(selectedOption, composer2, (i6 >> 3) & 14);
            stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(onOptionSelected, composer2, (i6 >> 6) & 14);
            Modifier modifierTestTag11 = TestTagKt.testTag(companion, "liquid_filter_dock");
            Unit unit6 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -2015188241, "CC(remember):GlassComponents.kt#9igjgp");
            zChanged = composer2.changed(stateRememberUpdatedState) | composer2.changedInstance(options) | composer2.changed(fMo362toPx0680j_4) | composer2.changed(size) | composer2.changed(stateRememberUpdatedState2);
            glassComponentsKt$LiquidFilterDock$1$1RememberedValue = composer2.rememberedValue();
            if (!zChanged) {
                str = "CC(remember):GlassComponents.kt#9igjgp";
                f6 = 0.0f;
                glassComponentsKt$LiquidFilterDock$1$1RememberedValue = new GlassComponentsKt$LiquidFilterDock$1$1(stateRememberUpdatedState, options, fMo362toPx0680j_4, size, stateRememberUpdatedState2, mutableState, mutableState2, null);
                composer2.updateRememberedValue(glassComponentsKt$LiquidFilterDock$1$1RememberedValue);
            } else {
                str = "CC(remember):GlassComponents.kt#9igjgp";
                f6 = 0.0f;
                glassComponentsKt$LiquidFilterDock$1$1RememberedValue = new GlassComponentsKt$LiquidFilterDock$1$1(stateRememberUpdatedState, options, fMo362toPx0680j_4, size, stateRememberUpdatedState2, mutableState, mutableState2, null);
                composer2.updateRememberedValue(glassComponentsKt$LiquidFilterDock$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifierPointerInput6 = SuspendingPointerInputFilterKt.pointerInput(modifierTestTag11, unit6, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) glassComponentsKt$LiquidFilterDock$1$1RememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer2, -2015112123, str);
            if ((i6 & 7168) == 2048) {
                z5 = true;
            } else {
                z5 = false;
            }
            zChanged2 = z5 | composer2.changed(stateAnimateFloatAsState2);
            objRememberedValue3 = composer2.rememberedValue();
            if (!zChanged2) {
                objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return GlassComponentsKt.LiquidFilterDock$lambda$50$lambda$49(z3, stateAnimateFloatAsState2, (DrawScope) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return GlassComponentsKt.LiquidFilterDock$lambda$50$lambda$49(z3, stateAnimateFloatAsState2, (DrawScope) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifierM670padding3ABfNKs6 = PaddingKt.m670padding3ABfNKs(DrawModifierKt.drawBehind(modifierPointerInput6, (Function1) objRememberedValue3), Dp.m6261constructorimpl(6.0f));
            Alignment centerStart6 = Alignment.INSTANCE.getCenterStart();
            str2 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy11 = BoxKt.maybeCachedBoxMeasurePolicy(centerStart6, false);
            str3 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap16 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composer2, modifierM670padding3ABfNKs6);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            str4 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            composerM3313constructorimpl = Updater.m3313constructorimpl(composer2);
            Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3313constructorimpl.getInserting()) {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance11 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -861614733, "C599@26022L60,601@26155L101,606@26325L1332,597@25961L2549,652@28626L2537:GlassComponents.kt#75kw8w");
            Modifier.Companion companion117 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -304891878, str);
            zChanged3 = composer2.changed(stateAnimateFloatAsState);
            objRememberedValue4 = composer2.rememberedValue();
            if (!zChanged3) {
                objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$52$lambda$51(stateAnimateFloatAsState, (Density) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$52$lambda$51(stateAnimateFloatAsState, (Density) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifierM717sizeVpY3zN9 = SizeKt.m717sizeVpY3zN4(androidx.compose.foundation.layout.OffsetKt.offset(companion117, (Function1) objRememberedValue4), fM6261constructorimpl, Dp.m6261constructorimpl(44.0f));
            ComposerKt.sourceInformationMarkerStart(composer2, -304887581, str);
            zChanged4 = composer2.changed(fLiquidFilterDock$lambda$46) | composer2.changed(fLiquidFilterDock$lambda$47);
            objRememberedValue5 = composer2.rememberedValue();
            if (!zChanged4) {
                objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$54$lambda$53(fLiquidFilterDock$lambda$46, fLiquidFilterDock$lambda$47, (GraphicsLayerScope) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$54$lambda$53(fLiquidFilterDock$lambda$46, fLiquidFilterDock$lambda$47, (GraphicsLayerScope) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifierClip6 = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierM717sizeVpY3zN9, (Function1) objRememberedValue5), RoundedCornerShapeKt.getCircleShape());
            ComposerKt.sourceInformationMarkerStart(composer2, -304880910, str);
            zChanged5 = composer2.changed(fAbs) | composer2.changed(fCoerceIn2);
            objRememberedValue6 = composer2.rememberedValue();
            if (!zChanged5) {
                objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$56$lambda$55(fAbs, fCoerceIn2, (ContentDrawScope) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$56$lambda$55(fAbs, fCoerceIn2, (ContentDrawScope) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifierDrawWithContent6 = DrawModifierKt.drawWithContent(modifierClip6, (Function1) objRememberedValue6);
            if (z3 != 0) {
                Brush.Companion companion118 = Brush.INSTANCE;
                Color[] colorArr11 = new Color[2];
                long jM3846getBlack0d7_KjU11 = Color.INSTANCE.m3846getBlack0d7_KjU();
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    f12 = 0.32f;
                } else {
                    f12 = 0.32f;
                }
                colorArr11[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU11, f12, 0.0f, 0.0f, 0.0f, 14, null));
                long jM3846getBlack0d7_KjU12 = Color.INSTANCE.m3846getBlack0d7_KjU();
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    f13 = 0.18f;
                } else {
                    f13 = 0.18f;
                }
                colorArr11[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU12, f13, 0.0f, 0.0f, 0.0f, 14, null));
                brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion118, CollectionsKt.listOf((Object[]) colorArr11), 0.0f, 0.0f, 0, 14, (Object) null);
            } else {
                Brush.Companion companion119 = Brush.INSTANCE;
                Color[] colorArr12 = new Color[2];
                long jM3857getWhite0d7_KjU11 = Color.INSTANCE.m3857getWhite0d7_KjU();
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    f7 = 0.28f;
                } else {
                    f7 = 0.28f;
                }
                colorArr12[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU11, f7, 0.0f, 0.0f, 0.0f, 14, null));
                long jM3857getWhite0d7_KjU12 = Color.INSTANCE.m3857getWhite0d7_KjU();
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    f8 = 0.12f;
                } else {
                    f8 = 0.12f;
                }
                colorArr12[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU12, f8, 0.0f, 0.0f, 0.0f, 14, null));
                brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion119, CollectionsKt.listOf((Object[]) colorArr12), 0.0f, 0.0f, 0, 14, (Object) null);
            }
            BoxKt.Box(BackgroundKt.background$default(modifierDrawWithContent6, brushM3777verticalGradient8A3gB4$default, null, 0.0f, 6, null), composer2, 0);
            Alignment.Vertical centerVertically6 = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_9 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(f6));
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Modifier.Companion companion1110 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_9, centerVertically6, composer2, 54);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap17 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier17 = ComposedModifierKt.materializeModifier(composer2, companion1110);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            composerM3313constructorimpl2 = Updater.m3313constructorimpl(composer2);
            Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyRowMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap17, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3313constructorimpl2.getInserting()) {
                composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier17, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance6 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1636699622, "C:GlassComponents.kt#75kw8w");
            f9 = fMo362toPx0680j_4 / 2.0f;
            fLiquidFilterDock$lambda$43 = LiquidFilterDock$lambda$42(stateAnimateFloatAsState) + f9;
            if (fMo362toPx0680j_4 > f6) {
                iCoerceIn = RangesKt.coerceIn(MathKt.roundToInt(LiquidFilterDock$lambda$42(stateAnimateFloatAsState) / fMo362toPx0680j_4), 0, options.size() - 1);
            } else {
                iCoerceIn = iCoerceAtLeast;
            }
            composer2.startReplaceGroup(-1022619500);
            ComposerKt.sourceInformation(composer2, "*677@30237L902");
            it = options.iterator();
            i8 = 0;
            while (it.hasNext()) {
                Object next6 = it.next();
                int i15 = i8 + 1;
                if (i8 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str110 = (String) next6;
                float f11116 = (((i8 * fMo362toPx0680j_4) + f9) - fLiquidFilterDock$lambda$43) / f9;
                float f11117 = fLiquidFilterDock$lambda$43;
                float f11118 = f6;
                Iterator it7 = it;
                float fCoerceIn15 = RangesKt.coerceIn(Math.abs(f11116) / 1.35f, f11118, 1.0f);
                fCoerceIn4 = RangesKt.coerceIn(1.0f - (fCoerceIn15 * fCoerceIn15), f11118, 1.0f);
                fMo362toPx0680j_5 = (density.mo362toPx0680j_4(Dp.m6261constructorimpl(8.0f)) * ((float) Math.sin(((double) f11116) * 3.141592653589793d)) * fCoerceIn4) + (0.14f * fLiquidFilterDock$lambda$42 * fCoerceIn4);
                float f11119 = (0.18f * fCoerceIn4) + 1.0f;
                float f210 = f9;
                float fCoerceIn16 = 1.0f - RangesKt.coerceIn(Math.abs(f11116), 0.0f, 1.0f);
                f10 = f11119 * (1.0f - ((0.08f * fCoerceIn16) * fCoerceIn4));
                f11 = ((fCoerceIn16 * 0.05f * fCoerceIn4) + 1.0f) * f11119;
                if (i8 == iCoerceIn) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z3 != 0) {
                    alpinePrimaryContainer = Color.INSTANCE.m3857getWhite0d7_KjU();
                } else {
                    alpinePrimaryContainer = ColorKt.getAlpinePrimaryContainer();
                }
                if (z3 != 0) {
                    jM3819copywmQWz5c$default = androidx.compose.ui.graphics.ColorKt.Color(4281549141L);
                } else {
                    jM3819copywmQWz5c$default = Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.65f, 0.0f, 0.0f, 0.0f, 14, null);
                }
                float f211 = fMo362toPx0680j_4;
                z8 = z7;
                Modifier modifierTestTag12 = TestTagKt.testTag(ClipKt.clip(SizeKt.m717sizeVpY3zN4(Modifier.INSTANCE, fM6261constructorimpl, Dp.m6261constructorimpl(44.0f)), RoundedCornerShapeKt.getCircleShape()), "filter_option_" + str110);
                Alignment center6 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, str2);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy12 = BoxKt.maybeCachedBoxMeasurePolicy(center6, false);
                String str111 = str2;
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str3);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap18 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier18 = ComposedModifierKt.materializeModifier(composer2, modifierTestTag12);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                String str112 = str3;
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str4);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor3);
                } else {
                    composer2.useNode();
                }
                composerM3313constructorimpl3 = Updater.m3313constructorimpl(composer2);
                Updater.m3320setimpl(composerM3313constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl3, currentCompositionLocalMap18, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl3.getInserting()) {
                    composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                } else {
                    composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m3320setimpl(composerM3313constructorimpl3, modifierMaterializeModifier18, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance12 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 195873989, "C689@30857L242,684@30529L592:GlassComponents.kt#75kw8w");
                if (!z8) {
                    alpinePrimaryContainer = jM3819copywmQWz5c$default;
                }
                long sp6 = TextUnitKt.getSp(14);
                if (z8) {
                    medium = FontWeight.INSTANCE.getBold();
                } else {
                    medium = FontWeight.INSTANCE.getMedium();
                }
                Modifier.Companion companion1111 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -1794786656, str);
                zChanged6 = composer2.changed(fMo362toPx0680j_5) | composer2.changed(f10) | composer2.changed(f11) | composer2.changed(fCoerceIn4);
                objRememberedValue7 = composer2.rememberedValue();
                if (!zChanged6) {
                    objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$62$lambda$61$lambda$60$lambda$59$lambda$58(fMo362toPx0680j_5, f10, f11, fCoerceIn4, (GraphicsLayerScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$62$lambda$61$lambda$60$lambda$59$lambda$58(fMo362toPx0680j_5, f10, f11, fCoerceIn4, (GraphicsLayerScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Composer composer9 = composer2;
                TextKt.m2354Text4IGK_g(str110, GraphicsLayerModifierKt.graphicsLayer(companion1111, (Function1) objRememberedValue7), alpinePrimaryContainer, sp6, (FontStyle) null, medium, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer9, 3072, 0, 131024);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                composer9.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer9);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                fLiquidFilterDock$lambda$43 = f11117;
                str4 = str4;
                str = str;
                composer2 = composer9;
                i8 = i15;
                it = it7;
                f9 = f210;
                str2 = str111;
                fMo362toPx0680j_4 = f211;
                str3 = str112;
                f6 = 0.0f;
            }
            composer3 = composer2;
            composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z6 = z3;
            modifier3 = companion;
        } else {
            if (i9 != 0) {
                z2 = false;
            }
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1883659240, i3, -1, "com.example.ui.theme.LiquidFilterDock (GlassComponents.kt:442)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2015290950, "CC(remember):GlassComponents.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2015289065, "CC(remember):GlassComponents.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            z3 = z2;
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            fM6261constructorimpl = Dp.m6261constructorimpl(76.0f);
            ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume7 = composerStartRestartGroup.consume(localDensity7);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume7;
            i6 = i3;
            fMo362toPx0680j_4 = density.mo362toPx0680j_4(fM6261constructorimpl);
            size = (options.size() - 1) * fMo362toPx0680j_4;
            iCoerceAtLeast = RangesKt.coerceAtLeast(options.indexOf(selectedOption), 0);
            f = iCoerceAtLeast * fMo362toPx0680j_4;
            if (LiquidFilterDock$lambda$36(mutableState)) {
                f2 = 0.0f;
                fCoerceIn = RangesKt.coerceIn(f + LiquidFilterDock$lambda$39(mutableState2), 0.0f, size);
            } else {
                f2 = 0.0f;
                fCoerceIn = f;
            }
            float f111110 = fCoerceIn;
            if (LiquidFilterDock$lambda$36(mutableState)) {
                obj = null;
                springSpecSpring$default = AnimationSpecKt.spring$default(f2, 10000.0f, null, 5, null);
                f3 = 0.45f;
                i7 = 4;
            } else {
                obj = null;
                f3 = 0.45f;
                i7 = 4;
                springSpecSpring$default = AnimationSpecKt.spring$default(0.45f, 180.0f, null, 4, null);
            }
            float f111111 = f3;
            stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f111110, springSpecSpring$default, 0.0f, "filter_thumb_offset", null, composerStartRestartGroup, 3072, 20);
            fLiquidFilterDock$lambda$42 = LiquidFilterDock$lambda$42(stateAnimateFloatAsState) - LiquidFilterDock$lambda$43(AnimateAsStateKt.animateFloatAsState(f111110, AnimationSpecKt.spring$default(0.55f, 85.0f, obj, i7, obj), 0.0f, "filter_lagged_thumb_offset", null, composerStartRestartGroup, 3120, 20));
            fCoerceIn2 = RangesKt.coerceIn(fLiquidFilterDock$lambda$42 / density.mo362toPx0680j_4(Dp.m6261constructorimpl(14.0f)), -1.0f, 1.0f);
            fAbs = Math.abs(fCoerceIn2);
            fAbs2 = Math.abs(LiquidFilterDock$lambda$42(stateAnimateFloatAsState) - f);
            if (size > 0.0f) {
                f4 = size;
            } else {
                f4 = 1.0f;
            }
            if (fAbs2 > density.mo362toPx0680j_4(Dp.m6261constructorimpl(3.0f))) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (LiquidFilterDock$lambda$36(mutableState)) {
                fCoerceIn3 = 1.0f;
            } else {
                fCoerceIn3 = RangesKt.coerceIn(fAbs2 / (f4 * 0.7f), 0.0f, 1.0f);
            }
            State<Float> stateAnimateFloatAsState9 = AnimateAsStateKt.animateFloatAsState((fCoerceIn3 * 0.48f) + 1.0f, AnimationSpecKt.spring$default(0.65f, 220.0f, null, 4, null), 0.0f, "filter_thumb_scale", null, composerStartRestartGroup, 3120, 20);
            float fCoerceAtMost7 = RangesKt.coerceAtMost(Math.abs(LiquidFilterDock$lambda$39(mutableState2)) / 240.0f, 0.09f);
            fLiquidFilterDock$lambda$46 = LiquidFilterDock$lambda$46(stateAnimateFloatAsState9) * (fCoerceAtMost7 + 1.0f);
            fLiquidFilterDock$lambda$47 = LiquidFilterDock$lambda$46(stateAnimateFloatAsState9) * (1.0f - (fCoerceAtMost7 * f111111));
            if (LiquidFilterDock$lambda$36(mutableState)) {
                f5 = 0.5f;
            } else {
                f5 = 0.5f;
            }
            stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f5, AnimationSpecKt.tween$default(ComposerKt.invocationKey, 0, null, 6, null), 0.0f, "filter_specular_border", null, composerStartRestartGroup, 3120, 20);
            composer2 = composerStartRestartGroup;
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(selectedOption, composer2, (i6 >> 3) & 14);
            stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(onOptionSelected, composer2, (i6 >> 6) & 14);
            Modifier modifierTestTag13 = TestTagKt.testTag(companion, "liquid_filter_dock");
            Unit unit7 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -2015188241, "CC(remember):GlassComponents.kt#9igjgp");
            zChanged = composer2.changed(stateRememberUpdatedState) | composer2.changedInstance(options) | composer2.changed(fMo362toPx0680j_4) | composer2.changed(size) | composer2.changed(stateRememberUpdatedState2);
            glassComponentsKt$LiquidFilterDock$1$1RememberedValue = composer2.rememberedValue();
            if (!zChanged) {
                str = "CC(remember):GlassComponents.kt#9igjgp";
                f6 = 0.0f;
                glassComponentsKt$LiquidFilterDock$1$1RememberedValue = new GlassComponentsKt$LiquidFilterDock$1$1(stateRememberUpdatedState, options, fMo362toPx0680j_4, size, stateRememberUpdatedState2, mutableState, mutableState2, null);
                composer2.updateRememberedValue(glassComponentsKt$LiquidFilterDock$1$1RememberedValue);
            } else {
                str = "CC(remember):GlassComponents.kt#9igjgp";
                f6 = 0.0f;
                glassComponentsKt$LiquidFilterDock$1$1RememberedValue = new GlassComponentsKt$LiquidFilterDock$1$1(stateRememberUpdatedState, options, fMo362toPx0680j_4, size, stateRememberUpdatedState2, mutableState, mutableState2, null);
                composer2.updateRememberedValue(glassComponentsKt$LiquidFilterDock$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifierPointerInput7 = SuspendingPointerInputFilterKt.pointerInput(modifierTestTag13, unit7, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) glassComponentsKt$LiquidFilterDock$1$1RememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer2, -2015112123, str);
            if ((i6 & 7168) == 2048) {
                z5 = true;
            } else {
                z5 = false;
            }
            zChanged2 = z5 | composer2.changed(stateAnimateFloatAsState2);
            objRememberedValue3 = composer2.rememberedValue();
            if (!zChanged2) {
                objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return GlassComponentsKt.LiquidFilterDock$lambda$50$lambda$49(z3, stateAnimateFloatAsState2, (DrawScope) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return GlassComponentsKt.LiquidFilterDock$lambda$50$lambda$49(z3, stateAnimateFloatAsState2, (DrawScope) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifierM670padding3ABfNKs7 = PaddingKt.m670padding3ABfNKs(DrawModifierKt.drawBehind(modifierPointerInput7, (Function1) objRememberedValue3), Dp.m6261constructorimpl(6.0f));
            Alignment centerStart7 = Alignment.INSTANCE.getCenterStart();
            str2 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy13 = BoxKt.maybeCachedBoxMeasurePolicy(centerStart7, false);
            str3 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap19 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier19 = ComposedModifierKt.materializeModifier(composer2, modifierM670padding3ABfNKs7);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            str4 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            composerM3313constructorimpl = Updater.m3313constructorimpl(composer2);
            Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap19, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3313constructorimpl.getInserting()) {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier19, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance13 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -861614733, "C599@26022L60,601@26155L101,606@26325L1332,597@25961L2549,652@28626L2537:GlassComponents.kt#75kw8w");
            Modifier.Companion companion1112 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -304891878, str);
            zChanged3 = composer2.changed(stateAnimateFloatAsState);
            objRememberedValue4 = composer2.rememberedValue();
            if (!zChanged3) {
                objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$52$lambda$51(stateAnimateFloatAsState, (Density) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$52$lambda$51(stateAnimateFloatAsState, (Density) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifierM717sizeVpY3zN10 = SizeKt.m717sizeVpY3zN4(androidx.compose.foundation.layout.OffsetKt.offset(companion1112, (Function1) objRememberedValue4), fM6261constructorimpl, Dp.m6261constructorimpl(44.0f));
            ComposerKt.sourceInformationMarkerStart(composer2, -304887581, str);
            zChanged4 = composer2.changed(fLiquidFilterDock$lambda$46) | composer2.changed(fLiquidFilterDock$lambda$47);
            objRememberedValue5 = composer2.rememberedValue();
            if (!zChanged4) {
                objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$54$lambda$53(fLiquidFilterDock$lambda$46, fLiquidFilterDock$lambda$47, (GraphicsLayerScope) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$54$lambda$53(fLiquidFilterDock$lambda$46, fLiquidFilterDock$lambda$47, (GraphicsLayerScope) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifierClip7 = ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierM717sizeVpY3zN10, (Function1) objRememberedValue5), RoundedCornerShapeKt.getCircleShape());
            ComposerKt.sourceInformationMarkerStart(composer2, -304880910, str);
            zChanged5 = composer2.changed(fAbs) | composer2.changed(fCoerceIn2);
            objRememberedValue6 = composer2.rememberedValue();
            if (!zChanged5) {
                objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$56$lambda$55(fAbs, fCoerceIn2, (ContentDrawScope) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$56$lambda$55(fAbs, fCoerceIn2, (ContentDrawScope) obj2);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifierDrawWithContent7 = DrawModifierKt.drawWithContent(modifierClip7, (Function1) objRememberedValue6);
            if (z3 != 0) {
                Brush.Companion companion1113 = Brush.INSTANCE;
                Color[] colorArr13 = new Color[2];
                long jM3846getBlack0d7_KjU13 = Color.INSTANCE.m3846getBlack0d7_KjU();
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    f12 = 0.32f;
                } else {
                    f12 = 0.32f;
                }
                colorArr13[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU13, f12, 0.0f, 0.0f, 0.0f, 14, null));
                long jM3846getBlack0d7_KjU14 = Color.INSTANCE.m3846getBlack0d7_KjU();
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    f13 = 0.18f;
                } else {
                    f13 = 0.18f;
                }
                colorArr13[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3846getBlack0d7_KjU14, f13, 0.0f, 0.0f, 0.0f, 14, null));
                brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion1113, CollectionsKt.listOf((Object[]) colorArr13), 0.0f, 0.0f, 0, 14, (Object) null);
            } else {
                Brush.Companion companion1114 = Brush.INSTANCE;
                Color[] colorArr14 = new Color[2];
                long jM3857getWhite0d7_KjU13 = Color.INSTANCE.m3857getWhite0d7_KjU();
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    f7 = 0.28f;
                } else {
                    f7 = 0.28f;
                }
                colorArr14[0] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU13, f7, 0.0f, 0.0f, 0.0f, 14, null));
                long jM3857getWhite0d7_KjU14 = Color.INSTANCE.m3857getWhite0d7_KjU();
                if (LiquidFilterDock$lambda$36(mutableState)) {
                    f8 = 0.12f;
                } else {
                    f8 = 0.12f;
                }
                colorArr14[1] = Color.m3810boximpl(Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU14, f8, 0.0f, 0.0f, 0.0f, 14, null));
                brushM3777verticalGradient8A3gB4$default = Brush.Companion.m3777verticalGradient8A3gB4$default(companion1114, CollectionsKt.listOf((Object[]) colorArr14), 0.0f, 0.0f, 0, 14, (Object) null);
            }
            BoxKt.Box(BackgroundKt.background$default(modifierDrawWithContent7, brushM3777verticalGradient8A3gB4$default, null, 0.0f, 6, null), composer2, 0);
            Alignment.Vertical centerVertically7 = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_10 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(f6));
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Modifier.Companion companion1115 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_10, centerVertically7, composer2, 54);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap110 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier110 = ComposedModifierKt.materializeModifier(composer2, companion1115);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            composerM3313constructorimpl2 = Updater.m3313constructorimpl(composer2);
            Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyRowMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3313constructorimpl2.getInserting()) {
                composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier110, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance7 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1636699622, "C:GlassComponents.kt#75kw8w");
            f9 = fMo362toPx0680j_4 / 2.0f;
            fLiquidFilterDock$lambda$43 = LiquidFilterDock$lambda$42(stateAnimateFloatAsState) + f9;
            if (fMo362toPx0680j_4 > f6) {
                iCoerceIn = RangesKt.coerceIn(MathKt.roundToInt(LiquidFilterDock$lambda$42(stateAnimateFloatAsState) / fMo362toPx0680j_4), 0, options.size() - 1);
            } else {
                iCoerceIn = iCoerceAtLeast;
            }
            composer2.startReplaceGroup(-1022619500);
            ComposerKt.sourceInformation(composer2, "*677@30237L902");
            it = options.iterator();
            i8 = 0;
            while (it.hasNext()) {
                Object next7 = it.next();
                int i16 = i8 + 1;
                if (i8 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str113 = (String) next7;
                float f111112 = (((i8 * fMo362toPx0680j_4) + f9) - fLiquidFilterDock$lambda$43) / f9;
                float f111113 = fLiquidFilterDock$lambda$43;
                float f111114 = f6;
                Iterator it8 = it;
                float fCoerceIn17 = RangesKt.coerceIn(Math.abs(f111112) / 1.35f, f111114, 1.0f);
                fCoerceIn4 = RangesKt.coerceIn(1.0f - (fCoerceIn17 * fCoerceIn17), f111114, 1.0f);
                fMo362toPx0680j_5 = (density.mo362toPx0680j_4(Dp.m6261constructorimpl(8.0f)) * ((float) Math.sin(((double) f111112) * 3.141592653589793d)) * fCoerceIn4) + (0.14f * fLiquidFilterDock$lambda$42 * fCoerceIn4);
                float f111115 = (0.18f * fCoerceIn4) + 1.0f;
                float f212 = f9;
                float fCoerceIn18 = 1.0f - RangesKt.coerceIn(Math.abs(f111112), 0.0f, 1.0f);
                f10 = f111115 * (1.0f - ((0.08f * fCoerceIn18) * fCoerceIn4));
                f11 = ((fCoerceIn18 * 0.05f * fCoerceIn4) + 1.0f) * f111115;
                if (i8 == iCoerceIn) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z3 != 0) {
                    alpinePrimaryContainer = Color.INSTANCE.m3857getWhite0d7_KjU();
                } else {
                    alpinePrimaryContainer = ColorKt.getAlpinePrimaryContainer();
                }
                if (z3 != 0) {
                    jM3819copywmQWz5c$default = androidx.compose.ui.graphics.ColorKt.Color(4281549141L);
                } else {
                    jM3819copywmQWz5c$default = Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.65f, 0.0f, 0.0f, 0.0f, 14, null);
                }
                float f213 = fMo362toPx0680j_4;
                z8 = z7;
                Modifier modifierTestTag14 = TestTagKt.testTag(ClipKt.clip(SizeKt.m717sizeVpY3zN4(Modifier.INSTANCE, fM6261constructorimpl, Dp.m6261constructorimpl(44.0f)), RoundedCornerShapeKt.getCircleShape()), "filter_option_" + str113);
                Alignment center7 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, str2);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy14 = BoxKt.maybeCachedBoxMeasurePolicy(center7, false);
                String str114 = str2;
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str3);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap111 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier111 = ComposedModifierKt.materializeModifier(composer2, modifierTestTag14);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                String str115 = str3;
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, str4);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor3);
                } else {
                    composer2.useNode();
                }
                composerM3313constructorimpl3 = Updater.m3313constructorimpl(composer2);
                Updater.m3320setimpl(composerM3313constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl3, currentCompositionLocalMap111, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl3.getInserting()) {
                    composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                } else {
                    composerM3313constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM3313constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m3320setimpl(composerM3313constructorimpl3, modifierMaterializeModifier111, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance14 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 195873989, "C689@30857L242,684@30529L592:GlassComponents.kt#75kw8w");
                if (!z8) {
                    alpinePrimaryContainer = jM3819copywmQWz5c$default;
                }
                long sp7 = TextUnitKt.getSp(14);
                if (z8) {
                    medium = FontWeight.INSTANCE.getBold();
                } else {
                    medium = FontWeight.INSTANCE.getMedium();
                }
                Modifier.Companion companion1116 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -1794786656, str);
                zChanged6 = composer2.changed(fMo362toPx0680j_5) | composer2.changed(f10) | composer2.changed(f11) | composer2.changed(fCoerceIn4);
                objRememberedValue7 = composer2.rememberedValue();
                if (!zChanged6) {
                    objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$62$lambda$61$lambda$60$lambda$59$lambda$58(fMo362toPx0680j_5, f10, f11, fCoerceIn4, (GraphicsLayerScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new Function1() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return GlassComponentsKt.LiquidFilterDock$lambda$63$lambda$62$lambda$61$lambda$60$lambda$59$lambda$58(fMo362toPx0680j_5, f10, f11, fCoerceIn4, (GraphicsLayerScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Composer composer10 = composer2;
                TextKt.m2354Text4IGK_g(str113, GraphicsLayerModifierKt.graphicsLayer(companion1116, (Function1) objRememberedValue7), alpinePrimaryContainer, sp7, (FontStyle) null, medium, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer10, 3072, 0, 131024);
                ComposerKt.sourceInformationMarkerEnd(composer10);
                ComposerKt.sourceInformationMarkerEnd(composer10);
                composer10.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer10);
                ComposerKt.sourceInformationMarkerEnd(composer10);
                ComposerKt.sourceInformationMarkerEnd(composer10);
                fLiquidFilterDock$lambda$43 = f111113;
                str4 = str4;
                str = str;
                composer2 = composer10;
                i8 = i16;
                it = it8;
                f9 = f212;
                str2 = str114;
                fMo362toPx0680j_4 = f213;
                str3 = str115;
                f6 = 0.0f;
            }
            composer3 = composer2;
            composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z6 = z3;
            modifier3 = companion;
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return GlassComponentsKt.LiquidFilterDock$lambda$64(options, selectedOption, onOptionSelected, z6, modifier3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final boolean LiquidFilterDock$lambda$36(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LiquidFilterDock$lambda$37(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final float LiquidFilterDock$lambda$39(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LiquidFilterDock$lambda$40(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    static final Unit LiquidFilterDock$lambda$50$lambda$49(boolean z, State state, DrawScope drawBehind) {
        long jM3857getWhite0d7_KjU;
        float fLiquidFilterDock$lambda$47;
        int i;
        Object obj;
        Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
        float fM3645getHeightimpl = Size.m3645getHeightimpl(drawBehind.mo4370getSizeNHjbRc()) / 2.0f;
        Color.Companion companion = Color.INSTANCE;
        long jM3819copywmQWz5c$default = Color.m3819copywmQWz5c$default(z ? companion.m3846getBlack0d7_KjU() : companion.m3857getWhite0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, null);
        Color.Companion companion2 = Color.INSTANCE;
        if (z) {
            jM3857getWhite0d7_KjU = companion2.m3846getBlack0d7_KjU();
            i = 14;
            obj = null;
            fLiquidFilterDock$lambda$47 = 0.22f;
        } else {
            jM3857getWhite0d7_KjU = companion2.m3857getWhite0d7_KjU();
            fLiquidFilterDock$lambda$47 = LiquidFilterDock$lambda$47(state);
            i = 14;
            obj = null;
        }
        long jM3819copywmQWz5c$default2 = Color.m3819copywmQWz5c$default(jM3857getWhite0d7_KjU, fLiquidFilterDock$lambda$47, 0.0f, 0.0f, 0.0f, i, obj);
        Color.Companion companion3 = Color.INSTANCE;
        long jM3819copywmQWz5c$default3 = Color.m3819copywmQWz5c$default(z ? companion3.m3846getBlack0d7_KjU() : companion3.m3857getWhite0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null);
        DrawScope.m4366drawRoundRectuAw5IA$default(drawBehind, jM3819copywmQWz5c$default, 0L, 0L, CornerRadiusKt.CornerRadius$default(fM3645getHeightimpl, 0.0f, 2, null), null, 0.0f, null, 0, 246, null);
        DrawScope.m4365drawRoundRectZuiqVtQ$default(drawBehind, Brush.Companion.m3771linearGradientmHitzGk$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m3810boximpl(jM3819copywmQWz5c$default2), Color.m3810boximpl(jM3819copywmQWz5c$default3)}), OffsetKt.Offset(0.0f, 0.0f), OffsetKt.Offset(Size.m3648getWidthimpl(drawBehind.mo4370getSizeNHjbRc()), Size.m3645getHeightimpl(drawBehind.mo4370getSizeNHjbRc())), 0, 8, (Object) null), 0L, 0L, CornerRadiusKt.CornerRadius$default(fM3645getHeightimpl, 0.0f, 2, null), 0.0f, new Stroke(drawBehind.mo362toPx0680j_4(Dp.m6261constructorimpl(1.0f)), 0.0f, 0, 0, null, 30, null), null, 0, 214, null);
        return Unit.INSTANCE;
    }

    static final IntOffset LiquidFilterDock$lambda$63$lambda$52$lambda$51(State state, Density offset) {
        Intrinsics.checkNotNullParameter(offset, "$this$offset");
        return IntOffset.m6380boximpl(IntOffsetKt.IntOffset(MathKt.roundToInt(LiquidFilterDock$lambda$42(state)), 0));
    }

    static final Unit LiquidFilterDock$lambda$63$lambda$54$lambda$53(float f, float f2, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setScaleX(f);
        graphicsLayer.setScaleY(f2);
        return Unit.INSTANCE;
    }

    static final Unit LiquidFilterDock$lambda$63$lambda$56$lambda$55(float f, float f2, ContentDrawScope drawWithContent) {
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        drawWithContent.drawContent();
        float fM3648getWidthimpl = Size.m3648getWidthimpl(drawWithContent.mo4370getSizeNHjbRc());
        float fM3645getHeightimpl = Size.m3645getHeightimpl(drawWithContent.mo4370getSizeNHjbRc());
        float f3 = (0.18f * f) + 0.12f;
        float f4 = fM3645getHeightimpl / 2.0f;
        DrawScope.m4365drawRoundRectZuiqVtQ$default(drawWithContent, Brush.INSTANCE.m3785sweepGradientUv8p0NA(CollectionsKt.listOf((Object[]) new Color[]{Color.m3810boximpl(Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), f3, 0.0f, 0.0f, 0.0f, 14, null)), Color.m3810boximpl(Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), (RangesKt.coerceAtLeast(f2, 0.0f) * 0.2f) + f3, 0.0f, 0.0f, 0.0f, 14, null)), Color.m3810boximpl(Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.04f, 0.0f, 0.0f, 0.0f, 14, null)), Color.m3810boximpl(Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), (RangesKt.coerceAtLeast(-f2, 0.0f) * 0.2f) + f3, 0.0f, 0.0f, 0.0f, 14, null)), Color.m3810boximpl(Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), f3, 0.0f, 0.0f, 0.0f, 14, null))}), OffsetKt.Offset(fM3648getWidthimpl / 2.0f, f4)), 0L, 0L, CornerRadiusKt.CornerRadius$default(f4, 0.0f, 2, null), 0.0f, new Stroke(drawWithContent.mo362toPx0680j_4(Dp.m6261constructorimpl(1.0f)), 0.0f, 0, 0, null, 30, null), null, 0, 214, null);
        return Unit.INSTANCE;
    }

    static final Unit LiquidFilterDock$lambda$63$lambda$62$lambda$61$lambda$60$lambda$59$lambda$58(float f, float f2, float f3, float f4, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setTranslationX(f);
        graphicsLayer.setScaleX(f2);
        graphicsLayer.setScaleY(f3);
        graphicsLayer.setAlpha((f4 * 0.2f) + 0.8f);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x005c  */
    /* JADX WARN: Code duplicated, block: B:29:0x0062  */
    /* JADX WARN: Code duplicated, block: B:32:0x0069  */
    /* JADX WARN: Code duplicated, block: B:35:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:38:0x017e  */
    /* JADX WARN: Code duplicated, block: B:41:0x018a  */
    /* JADX WARN: Code duplicated, block: B:42:0x018e  */
    /* JADX WARN: Code duplicated, block: B:45:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:47:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:50:0x0232  */
    /* JADX WARN: Code duplicated, block: B:53:0x023e  */
    /* JADX WARN: Code duplicated, block: B:54:0x0242  */
    /* JADX WARN: Code duplicated, block: B:57:0x0267  */
    /* JADX WARN: Code duplicated, block: B:59:0x0275  */
    /* JADX WARN: Code duplicated, block: B:62:0x0334  */
    /* JADX WARN: Code duplicated, block: B:65:0x033d  */
    /* JADX WARN: Code duplicated, block: B:67:? A[RETURN, SYNTHETIC] */
    public static final void StartRideButton(Function0<Unit> function0, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Modifier modifier3;
        Object objRememberedValue;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM3313constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int currentCompositeKeyHash2;
        Function0<ComposeUiNode> constructor2;
        Composer composerM3313constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        Composer composer2;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Function0<Unit> onClick = function0;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1569412223);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(StartRideButton)P(1)726@31920L39,710@31370L1429:GlassComponents.kt#75kw8w");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(onClick) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i3 & 19) != 18 && composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
                composer2 = composerStartRestartGroup;
            } else {
                if (i4 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1569412223, i3, -1, "com.example.ui.theme.StartRideButton (GlassComponents.kt:709)");
                }
                Modifier modifierM236borderxT4_qwU = BorderKt.m236borderxT4_qwU(BackgroundKt.m225backgroundbw27NRU$default(ClipKt.clip(ShadowKt.m3484shadows4CzXII$default(TestTagKt.testTag(modifier3, "start_ride_button"), Dp.m6261constructorimpl(28.0f), RoundedCornerShapeKt.getCircleShape(), false, 0L, Color.m3819copywmQWz5c$default(ColorKt.getAlpinePrimaryContainer(), 0.45f, 0.0f, 0.0f, 0.0f, 14, null), 12, null), RoundedCornerShapeKt.getCircleShape()), ColorKt.getAlpinePrimaryContainer(), null, 2, null), Dp.m6261constructorimpl(1.0f), Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.35f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 671646246, "CC(remember):GlassComponents.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM671paddingVpY3zN4 = PaddingKt.m671paddingVpY3zN4(ClickableKt.m256clickableO2vRcR0$default(modifierM236borderxT4_qwU, (MutableInteractionSource) objRememberedValue, RippleKt.m2065rippleH2RKhps$default(false, 0.0f, Color.m3819copywmQWz5c$default(Color.INSTANCE.m3846getBlack0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), 3, null), false, null, null, onClick, 28, null), Dp.m6261constructorimpl(34.0f), Dp.m6261constructorimpl(18.0f));
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM671paddingVpY3zN4);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1791986305, "C733@32206L587:GlassComponents.kt#75kw8w");
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_4 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(10.0f));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_4, centerVertically, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
                Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM3313constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -66859098, "C737@32359L201,743@32573L210:GlassComponents.kt#75kw8w");
                IconKt.m1811Iconww6aTOc(PlayArrowKt.getPlayArrow(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(26.0f)), Color.INSTANCE.m3846getBlack0d7_KjU(), composerStartRestartGroup, 3504, 0);
                composer2 = composerStartRestartGroup;
                modifier4 = modifier3;
                onClick = function0;
                TextKt.m2354Text4IGK_g("开始骑行", (Modifier) null, Color.INSTANCE.m3846getBlack0d7_KjU(), TextUnitKt.getSp(22), (FontStyle) null, FontWeight.INSTANCE.getBlack(), (FontFamily) null, TextUnitKt.getSp(-0.3d), (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 200070, 0, 130898);
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
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return GlassComponentsKt.StartRideButton$lambda$68(onClick, modifier4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i3 & 19) != 18) {
            if (i4 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1569412223, i3, -1, "com.example.ui.theme.StartRideButton (GlassComponents.kt:709)");
            }
            Modifier modifierM236borderxT4_qwU2 = BorderKt.m236borderxT4_qwU(BackgroundKt.m225backgroundbw27NRU$default(ClipKt.clip(ShadowKt.m3484shadows4CzXII$default(TestTagKt.testTag(modifier3, "start_ride_button"), Dp.m6261constructorimpl(28.0f), RoundedCornerShapeKt.getCircleShape(), false, 0L, Color.m3819copywmQWz5c$default(ColorKt.getAlpinePrimaryContainer(), 0.45f, 0.0f, 0.0f, 0.0f, 14, null), 12, null), RoundedCornerShapeKt.getCircleShape()), ColorKt.getAlpinePrimaryContainer(), null, 2, null), Dp.m6261constructorimpl(1.0f), Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.35f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 671646246, "CC(remember):GlassComponents.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM671paddingVpY3zN5 = PaddingKt.m671paddingVpY3zN4(ClickableKt.m256clickableO2vRcR0$default(modifierM236borderxT4_qwU2, (MutableInteractionSource) objRememberedValue, RippleKt.m2065rippleH2RKhps$default(false, 0.0f, Color.m3819copywmQWz5c$default(Color.INSTANCE.m3846getBlack0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), 3, null), false, null, null, onClick, 28, null), Dp.m6261constructorimpl(34.0f), Dp.m6261constructorimpl(18.0f));
            Alignment center2 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM671paddingVpY3zN5);
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
            Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3313constructorimpl.getInserting()) {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM3313constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3313constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3320setimpl(composerM3313constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1791986305, "C733@32206L587:GlassComponents.kt#75kw8w");
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_5 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(10.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_5, centerVertically2, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
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
            Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3313constructorimpl2.getInserting()) {
                composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -66859098, "C737@32359L201,743@32573L210:GlassComponents.kt#75kw8w");
            IconKt.m1811Iconww6aTOc(PlayArrowKt.getPlayArrow(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(26.0f)), Color.INSTANCE.m3846getBlack0d7_KjU(), composerStartRestartGroup, 3504, 0);
            composer2 = composerStartRestartGroup;
            modifier4 = modifier3;
            onClick = function0;
            TextKt.m2354Text4IGK_g("开始骑行", (Modifier) null, Color.INSTANCE.m3846getBlack0d7_KjU(), TextUnitKt.getSp(22), (FontStyle) null, FontWeight.INSTANCE.getBlack(), (FontFamily) null, TextUnitKt.getSp(-0.3d), (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 200070, 0, 130898);
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            if (i4 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1569412223, i3, -1, "com.example.ui.theme.StartRideButton (GlassComponents.kt:709)");
            }
            Modifier modifierM236borderxT4_qwU3 = BorderKt.m236borderxT4_qwU(BackgroundKt.m225backgroundbw27NRU$default(ClipKt.clip(ShadowKt.m3484shadows4CzXII$default(TestTagKt.testTag(modifier3, "start_ride_button"), Dp.m6261constructorimpl(28.0f), RoundedCornerShapeKt.getCircleShape(), false, 0L, Color.m3819copywmQWz5c$default(ColorKt.getAlpinePrimaryContainer(), 0.45f, 0.0f, 0.0f, 0.0f, 14, null), 12, null), RoundedCornerShapeKt.getCircleShape()), ColorKt.getAlpinePrimaryContainer(), null, 2, null), Dp.m6261constructorimpl(1.0f), Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.35f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 671646246, "CC(remember):GlassComponents.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM671paddingVpY3zN6 = PaddingKt.m671paddingVpY3zN4(ClickableKt.m256clickableO2vRcR0$default(modifierM236borderxT4_qwU3, (MutableInteractionSource) objRememberedValue, RippleKt.m2065rippleH2RKhps$default(false, 0.0f, Color.m3819copywmQWz5c$default(Color.INSTANCE.m3846getBlack0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), 3, null), false, null, null, onClick, 28, null), Dp.m6261constructorimpl(34.0f), Dp.m6261constructorimpl(18.0f));
            Alignment center3 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM671paddingVpY3zN6);
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
            Updater.m3320setimpl(composerM3313constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1791986305, "C733@32206L587:GlassComponents.kt#75kw8w");
            Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_6 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(10.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_6, centerVertically3, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
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
            Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM3313constructorimpl2.getInserting()) {
                composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -66859098, "C737@32359L201,743@32573L210:GlassComponents.kt#75kw8w");
            IconKt.m1811Iconww6aTOc(PlayArrowKt.getPlayArrow(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(26.0f)), Color.INSTANCE.m3846getBlack0d7_KjU(), composerStartRestartGroup, 3504, 0);
            composer2 = composerStartRestartGroup;
            modifier4 = modifier3;
            onClick = function0;
            TextKt.m2354Text4IGK_g("开始骑行", (Modifier) null, Color.INSTANCE.m3846getBlack0d7_KjU(), TextUnitKt.getSp(22), (FontStyle) null, FontWeight.INSTANCE.getBlack(), (FontFamily) null, TextUnitKt.getSp(-0.3d), (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 200070, 0, 130898);
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GlassComponentsKt.StartRideButton$lambda$68(onClick, modifier4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void SafetyModalDialog(final Function0<Unit> onDismiss, final Function0<Unit> onConfirm, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1180875173);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SafetyModalDialog)P(1)765@33073L4369,762@32950L4492:GlassComponents.kt#75kw8w");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(onDismiss) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onConfirm) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            function0 = onDismiss;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1180875173, i2, -1, "com.example.ui.theme.SafetyModalDialog (GlassComponents.kt:761)");
            }
            function0 = onDismiss;
            AndroidDialog_androidKt.Dialog(function0, new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(-1946767566, true, new Function2() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GlassComponentsKt.SafetyModalDialog$lambda$76(onDismiss, onConfirm, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2 & 14) | 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GlassComponentsKt.SafetyModalDialog$lambda$77(function0, onConfirm, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit SafetyModalDialog$lambda$76(Function0 function0, Function0 function1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C766@33083L4353:GlassComponents.kt#75kw8w");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1946767566, i, -1, "com.example.ui.theme.SafetyModalDialog.<anonymous> (GlassComponents.kt:766)");
            }
            Modifier modifierM670padding3ABfNKs = PaddingKt.m670padding3ABfNKs(BackgroundKt.m225backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.m3819copywmQWz5c$default(Color.INSTANCE.m3846getBlack0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m6261constructorimpl(20.0f));
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1519854787, "C773@33316L4110:GlassComponents.kt#75kw8w");
            Modifier modifierM670padding3ABfNKs2 = PaddingKt.m670padding3ABfNKs(m6638glassPanelIBj4UiM$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6261constructorimpl(28.0f)), androidx.compose.ui.graphics.ColorKt.Color(4028110875L), Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 16, null), Dp.m6261constructorimpl(24.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM670padding3ABfNKs2);
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
            Updater.m3320setimpl(composerM3313constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM3313constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3313constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3320setimpl(composerM3313constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1729281662, "C784@33793L3619:GlassComponents.kt#75kw8w");
            Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_4 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(20.0f));
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_4, Alignment.INSTANCE.getStart(), composer, 6);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1760350728, "C788@33947L1229,816@35234L224,824@35513L236,832@35809L1585:GlassComponents.kt#75kw8w");
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_5 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(12.0f));
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_5, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer, companion2);
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
            Updater.m3320setimpl(composerM3313constructorimpl4, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                composerM3313constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composerM3313constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3320setimpl(composerM3313constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 208399997, "C792@34148L751,807@34924L230:GlassComponents.kt#75kw8w");
            Modifier modifierM236borderxT4_qwU = BorderKt.m236borderxT4_qwU(BackgroundKt.m225backgroundbw27NRU$default(ClipKt.clip(SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(40.0f)), RoundedCornerShapeKt.getCircleShape()), Color.m3819copywmQWz5c$default(ColorKt.getAlpineErrorContainer(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m6261constructorimpl(1.0f), Color.m3819copywmQWz5c$default(ColorKt.getAlpineError(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
            Alignment center2 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer, modifierM236borderxT4_qwU);
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
            Updater.m3320setimpl(composerM3313constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl5.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                composerM3313constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                composerM3313constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            Updater.m3320setimpl(composerM3313constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 208331822, "C800@34594L279:GlassComponents.kt#75kw8w");
            IconKt.m1811Iconww6aTOc(WarningKt.getWarning(Icons.INSTANCE.getDefault()), "警告", SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(22.0f)), ColorKt.getAlpineError(), composer, 3504, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m2354Text4IGK_g("安全提示", (Modifier) null, ColorKt.getAlpineOnSurface(), TextUnitKt.getSp(24), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 200070, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m2354Text4IGK_g("为了您的骑行安全，请在出发前确认以下事项：", (Modifier) null, ColorKt.getAlpineOnSurfaceVariant(), TextUnitKt.getSp(15), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(22), 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 3462, 6, 130034);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_6 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(10.0f));
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_6, Alignment.INSTANCE.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap6 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer, companion3);
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
            Updater.m3320setimpl(composerM3313constructorimpl6, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl6.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                composerM3313constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                composerM3313constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
            }
            Updater.m3320setimpl(composerM3313constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1919340549, "C827@35643L29,828@35697L30:GlassComponents.kt#75kw8w");
            SafetyItem("请佩戴头盔和护具", composer, 6);
            SafetyItem("检查车辆刹车和胎压", composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(end, centerVertically2, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap7 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
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
            Updater.m3320setimpl(composerM3313constructorimpl7, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3320setimpl(composerM3313constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3313constructorimpl7.getInserting() || !Intrinsics.areEqual(composerM3313constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                composerM3313constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                composerM3313constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
            }
            Updater.m3320setimpl(composerM3313constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1172329742, "C837@36058L482,848@36565L40,851@36739L175,849@36630L742:GlassComponents.kt#75kw8w");
            ButtonKt.TextButton(function0, TestTagKt.testTag(Modifier.INSTANCE, "safety_cancel_button"), false, null, null, null, null, null, null, ComposableSingletons$GlassComponentsKt.INSTANCE.getLambda$22120076$app(), composer, 805306416, 508);
            SpacerKt.Spacer(SizeKt.m720width3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(12.0f)), composer, 6);
            ButtonColors buttonColorsM1469buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m1469buttonColorsro_MJ88(ColorKt.getAlpinePrimaryContainer(), Color.INSTANCE.m3846getBlack0d7_KjU(), 0L, 0L, composer, (ButtonDefaults.$stable << 12) | 54, 12);
            ButtonKt.Button(function1, TestTagKt.testTag(Modifier.INSTANCE, "safety_confirm_button"), false, RoundedCornerShapeKt.getCircleShape(), buttonColorsM1469buttonColorsro_MJ88, null, null, null, null, ComposableSingletons$GlassComponentsKt.INSTANCE.getLambda$757710463$app(), composer, 805306416, 484);
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

    private static final void SafetyItem(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-40752624);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SafetyItem)874@37501L767:GlassComponents.kt#75kw8w");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(str) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-40752624, i2, -1, "com.example.ui.theme.SafetyItem (GlassComponents.kt:873)");
            }
            Modifier modifierM671paddingVpY3zN4 = PaddingKt.m671paddingVpY3zN4(BorderKt.m236borderxT4_qwU(BackgroundKt.m225backgroundbw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6261constructorimpl(12.0f))), Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.04f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m6261constructorimpl(1.0f), Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.06f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6261constructorimpl(12.0f))), Dp.m6261constructorimpl(14.0f), Dp.m6261constructorimpl(12.0f));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM550spacedBy0680j_4 = Arrangement.INSTANCE.m550spacedBy0680j_4(Dp.m6261constructorimpl(12.0f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM550spacedBy0680j_4, centerVertically, composerStartRestartGroup, 54);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 677672847, "C884@37942L161,890@38112L150:GlassComponents.kt#75kw8w");
            BoxKt.Box(BackgroundKt.m225backgroundbw27NRU$default(ClipKt.clip(SizeKt.m715size3ABfNKs(Modifier.INSTANCE, Dp.m6261constructorimpl(8.0f)), RoundedCornerShapeKt.getCircleShape()), ColorKt.getAlpinePrimaryContainer(), null, 2, null), composerStartRestartGroup, 0);
            composer2 = composerStartRestartGroup;
            TextKt.m2354Text4IGK_g(str, (Modifier) null, ColorKt.getAlpineOnSurface(), TextUnitKt.getSp(15), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, (i2 & 14) | 200064, 0, 131026);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.theme.GlassComponentsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GlassComponentsKt.SafetyItem$lambda$79(str, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: glassPanel-IBj4UiM$default, reason: not valid java name */
    public static /* synthetic */ Modifier m6638glassPanelIBj4UiM$default(Modifier modifier, Shape shape, long j, long j2, long j3, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            shape = RoundedCornerShapeKt.m953RoundedCornerShape0680j_4(Dp.m6261constructorimpl(16.0f));
        }
        return m6637glassPanelIBj4UiM(modifier, shape, (i & 2) != 0 ? Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.05f, 0.0f, 0.0f, 0.0f, 14, null) : j, (i & 4) != 0 ? Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.25f, 0.0f, 0.0f, 0.0f, 14, null) : j2, (i & 8) != 0 ? Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, null) : j3, (i & 16) != 0 ? Dp.m6261constructorimpl(1.0f) : f);
    }

    private static final float LiquidDock$lambda$9(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float LiquidDock$lambda$10(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float LiquidDock$lambda$13(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float LiquidDock$lambda$14(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float LiquidFilterDock$lambda$42(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float LiquidFilterDock$lambda$43(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float LiquidFilterDock$lambda$46(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float LiquidFilterDock$lambda$47(State<Float> state) {
        return state.getValue().floatValue();
    }
}
