package com.example;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.example.ui.theme.ColorKt;
import com.example.ui.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$MainActivityKt {
    public static final ComposableSingletons$MainActivityKt INSTANCE = new ComposableSingletons$MainActivityKt();

    /* JADX INFO: renamed from: lambda$-1831378358, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f67lambda$1831378358 = ComposableLambdaKt.composableLambdaInstance(-1831378358, false, new Function2() { // from class: com.example.ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$MainActivityKt.lambda__1831378358$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$2035715247 = ComposableLambdaKt.composableLambdaInstance(2035715247, false, new Function2() { // from class: com.example.ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$MainActivityKt.lambda_2035715247$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-601144069, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f68lambda$601144069 = ComposableLambdaKt.composableLambdaInstance(-601144069, false, new Function2() { // from class: com.example.ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$MainActivityKt.lambda__601144069$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1831378358$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6626getLambda$1831378358$app() {
        return f67lambda$1831378358;
    }

    /* JADX INFO: renamed from: getLambda$-601144069$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6627getLambda$601144069$app() {
        return f68lambda$601144069;
    }

    public final Function2<Composer, Integer, Unit> getLambda$2035715247$app() {
        return lambda$2035715247;
    }

    static final Unit lambda__601144069$lambda$2(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C48@1983L230:MainActivity.kt#to5c3");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-601144069, i, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$-601144069.<anonymous> (MainActivity.kt:48)");
            }
            ThemeKt.SummitPathTheme(lambda$2035715247, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_2035715247$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C49@2017L182:MainActivity.kt#to5c3");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2035715247, i, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$2035715247.<anonymous> (MainActivity.kt:49)");
            }
            SurfaceKt.m2204SurfaceT9BRK9s(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, ColorKt.getAlpineBackground(), 0L, 0.0f, 0.0f, null, f67lambda$1831378358, composer, 12583302, 122);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__1831378358$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C53@2166L15:MainActivity.kt#to5c3");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1831378358, i, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$-1831378358.<anonymous> (MainActivity.kt:53)");
            }
            MainActivityKt.SummitPathApp(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
