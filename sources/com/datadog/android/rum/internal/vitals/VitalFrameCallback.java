package com.datadog.android.rum.internal.vitals;

import android.view.Choreographer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/vitals/VitalFrameCallback;", "Landroid/view/Choreographer$FrameCallback;", "observer", "Lcom/datadog/android/rum/internal/vitals/VitalObserver;", "keepRunning", "Lkotlin/Function0;", "", "(Lcom/datadog/android/rum/internal/vitals/VitalObserver;Lkotlin/jvm/functions/Function0;)V", "lastFrameTimestampNs", "", "doFrame", "", "frameTimeNanos", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: VitalFrameCallback.kt */
public final class VitalFrameCallback implements Choreographer.FrameCallback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final double f3906d = ((double) TimeUnit.SECONDS.toNanos(1));

    /* renamed from: e */
    private static final double f3907e = 1.0d;

    /* renamed from: f */
    private static final double f3908f = 240.0d;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final ClosedFloatingPointRange<Double> f3909g = RangesKt.rangeTo(1.0d, (double) f3908f);

    /* renamed from: a */
    private final VitalObserver f3910a;

    /* renamed from: b */
    private final Function0<Boolean> f3911b;

    /* renamed from: c */
    private long f3912c;

    public VitalFrameCallback(VitalObserver vitalObserver, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(vitalObserver, "observer");
        Intrinsics.checkNotNullParameter(function0, "keepRunning");
        this.f3910a = vitalObserver;
        this.f3911b = function0;
    }

    public void doFrame(long j) {
        long j2 = this.f3912c;
        if (j2 != 0) {
            double d = (double) (j - j2);
            if (d > 0.0d) {
                double d2 = f3906d / d;
                if (f3909g.contains(Double.valueOf(d2))) {
                    this.f3910a.onNewSample(d2);
                }
            }
        }
        this.f3912c = j;
        if (this.f3911b.invoke().booleanValue()) {
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/vitals/VitalFrameCallback$Companion;", "", "()V", "MAX_FPS", "", "MIN_FPS", "ONE_SECOND_NS", "getONE_SECOND_NS", "()D", "VALID_FPS_RANGE", "Lkotlin/ranges/ClosedFloatingPointRange;", "getVALID_FPS_RANGE", "()Lkotlin/ranges/ClosedFloatingPointRange;", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: VitalFrameCallback.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final double getONE_SECOND_NS() {
            return VitalFrameCallback.f3906d;
        }

        public final ClosedFloatingPointRange<Double> getVALID_FPS_RANGE() {
            return VitalFrameCallback.f3909g;
        }
    }
}
