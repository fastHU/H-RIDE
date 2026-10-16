package com.example.ui.screens;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CheckKt;
import androidx.compose.material.icons.filled.CloseKt;
import androidx.compose.material.icons.filled.DeleteKt;
import androidx.compose.material.icons.filled.EditKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.example.ui.theme.ColorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: RideDetailModal.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$RideDetailModalKt {
    public static final ComposableSingletons$RideDetailModalKt INSTANCE = new ComposableSingletons$RideDetailModalKt();

    /* JADX INFO: renamed from: lambda$-19009500, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f69lambda$19009500 = ComposableLambdaKt.composableLambdaInstance(-19009500, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$RideDetailModalKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RideDetailModalKt.lambda__19009500$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-200821509, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f70lambda$200821509 = ComposableLambdaKt.composableLambdaInstance(-200821509, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$RideDetailModalKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RideDetailModalKt.lambda__200821509$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-950666465, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f72lambda$950666465 = ComposableLambdaKt.composableLambdaInstance(-950666465, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$RideDetailModalKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RideDetailModalKt.lambda__950666465$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-501847608, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f71lambda$501847608 = ComposableLambdaKt.composableLambdaInstance(-501847608, false, new Function2() { // from class: com.example.ui.screens.ComposableSingletons$RideDetailModalKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RideDetailModalKt.lambda__501847608$lambda$3((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-19009500$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6630getLambda$19009500$app() {
        return f69lambda$19009500;
    }

    /* JADX INFO: renamed from: getLambda$-200821509$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6631getLambda$200821509$app() {
        return f70lambda$200821509;
    }

    /* JADX INFO: renamed from: getLambda$-501847608$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6632getLambda$501847608$app() {
        return f71lambda$501847608;
    }

    /* JADX INFO: renamed from: getLambda$-950666465$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6633getLambda$950666465$app() {
        return f72lambda$950666465;
    }

    static final Unit lambda__19009500$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C138@5705L83:RideDetailModal.kt#2thlc2");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-19009500, i, -1, "com.example.ui.screens.ComposableSingletons$RideDetailModalKt.lambda$-19009500.<anonymous> (RideDetailModal.kt:138)");
            }
            IconKt.m1811Iconww6aTOc(CheckKt.getCheck(Icons.INSTANCE.getDefault()), "保存", (Modifier) null, ColorKt.getAlpinePrimaryContainer(), composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__200821509$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C152@6453L84:RideDetailModal.kt#2thlc2");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-200821509, i, -1, "com.example.ui.screens.ComposableSingletons$RideDetailModalKt.lambda$-200821509.<anonymous> (RideDetailModal.kt:152)");
            }
            IconKt.m1811Iconww6aTOc(EditKt.getEdit(Icons.INSTANCE.getDefault()), "修改标题", (Modifier) null, ColorKt.getAlpinePrimaryContainer(), composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__950666465$lambda$2(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C157@6731L75:RideDetailModal.kt#2thlc2");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-950666465, i, -1, "com.example.ui.screens.ComposableSingletons$RideDetailModalKt.lambda$-950666465.<anonymous> (RideDetailModal.kt:157)");
            }
            IconKt.m1811Iconww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), "删除记录", (Modifier) null, ColorKt.getAlpineError(), composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__501847608$lambda$3(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C161@6972L83:RideDetailModal.kt#2thlc2");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-501847608, i, -1, "com.example.ui.screens.ComposableSingletons$RideDetailModalKt.lambda$-501847608.<anonymous> (RideDetailModal.kt:161)");
            }
            IconKt.m1811Iconww6aTOc(CloseKt.getClose(Icons.INSTANCE.getDefault()), "关闭", (Modifier) null, ColorKt.getAlpineOnSurfaceVariant(), composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
