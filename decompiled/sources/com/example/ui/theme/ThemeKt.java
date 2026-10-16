package com.example.ui.theme;

import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Theme.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"AlpineColorScheme", "Landroidx/compose/material3/ColorScheme;", "SummitPathTheme", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "app"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ThemeKt {
    private static final ColorScheme AlpineColorScheme;

    static final Unit SummitPathTheme$lambda$0(Function2 function2, int i, Composer composer, int i2) {
        SummitPathTheme(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static {
        long alpinePrimary = ColorKt.getAlpinePrimary();
        long alpineOnPrimary = ColorKt.getAlpineOnPrimary();
        long alpinePrimaryContainer = ColorKt.getAlpinePrimaryContainer();
        long alpineOnPrimaryContainer = ColorKt.getAlpineOnPrimaryContainer();
        long alpineBackground = ColorKt.getAlpineBackground();
        long alpineOnSurface = ColorKt.getAlpineOnSurface();
        long alpineSurface = ColorKt.getAlpineSurface();
        long alpineOnSurface2 = ColorKt.getAlpineOnSurface();
        long alpineSurfaceContainerHighest = ColorKt.getAlpineSurfaceContainerHighest();
        long alpineOnSurfaceVariant = ColorKt.getAlpineOnSurfaceVariant();
        long alpineOutline = ColorKt.getAlpineOutline();
        long alpineOutlineVariant = ColorKt.getAlpineOutlineVariant();
        long alpineError = ColorKt.getAlpineError();
        long alpineErrorContainer = ColorKt.getAlpineErrorContainer();
        AlpineColorScheme = ColorSchemeKt.m1592darkColorSchemeCXl9yA$default(alpinePrimary, alpineOnPrimary, alpinePrimaryContainer, alpineOnPrimaryContainer, 0L, ColorKt.getAlpineSecondary(), 0L, ColorKt.getAlpineSecondaryContainer(), ColorKt.getAlpineOnSecondaryContainer(), 0L, 0L, 0L, 0L, alpineBackground, alpineOnSurface, alpineSurface, alpineOnSurface2, alpineSurfaceContainerHighest, alpineOnSurfaceVariant, 0L, 0L, 0L, alpineError, ColorKt.getAlpineOnError(), alpineErrorContainer, ColorKt.getAlpineOnErrorContainer(), alpineOutline, alpineOutlineVariant, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -264757680, 15, null);
    }

    public static final void SummitPathTheme(Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        final Function2<? super Composer, ? super Integer, Unit> function2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1842821151);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SummitPathTheme)32@1047L120:Theme.kt#75kw8w");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(content) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            function2 = content;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1842821151, i2, -1, "com.example.ui.theme.SummitPathTheme (Theme.kt:31)");
            }
            function2 = content;
            MaterialThemeKt.MaterialTheme(AlpineColorScheme, null, TypeKt.getTypography(), function2, composerStartRestartGroup, ((i2 << 9) & 7168) | 390, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.ui.theme.ThemeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ThemeKt.SummitPathTheme$lambda$0(function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
