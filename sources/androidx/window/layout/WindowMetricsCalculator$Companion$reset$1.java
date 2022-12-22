package androidx.window.layout;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Landroidx/window/layout/WindowMetricsCalculator;", "it"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WindowMetricsCalculator.kt */
final class WindowMetricsCalculator$Companion$reset$1 extends Lambda implements Function1<WindowMetricsCalculator, WindowMetricsCalculator> {
    public static final WindowMetricsCalculator$Companion$reset$1 INSTANCE = new WindowMetricsCalculator$Companion$reset$1();

    WindowMetricsCalculator$Companion$reset$1() {
        super(1);
    }

    public final WindowMetricsCalculator invoke(WindowMetricsCalculator windowMetricsCalculator) {
        Intrinsics.checkNotNullParameter(windowMetricsCalculator, "it");
        return windowMetricsCalculator;
    }
}
