package com.example.ui.map;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CloseKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: NavigationChoiceModal.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$NavigationChoiceModalKt {
    public static final ComposableSingletons$NavigationChoiceModalKt INSTANCE = new ComposableSingletons$NavigationChoiceModalKt();
    private static Function2<Composer, Integer, Unit> lambda$1075251433 = ComposableLambdaKt.composableLambdaInstance(1075251433, false, new Function2() { // from class: com.example.ui.map.ComposableSingletons$NavigationChoiceModalKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NavigationChoiceModalKt.lambda_1075251433$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1075251433$app() {
        return lambda$1075251433;
    }

    static final Unit lambda_1075251433$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C80@3252L215:NavigationChoiceModal.kt#8v18gj");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1075251433, i, -1, "com.example.ui.map.ComposableSingletons$NavigationChoiceModalKt.lambda$1075251433.<anonymous> (NavigationChoiceModal.kt:80)");
            }
            IconKt.m1811Iconww6aTOc(CloseKt.getClose(Icons.INSTANCE.getDefault()), "关闭", (Modifier) null, Color.m3819copywmQWz5c$default(Color.INSTANCE.m3857getWhite0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
