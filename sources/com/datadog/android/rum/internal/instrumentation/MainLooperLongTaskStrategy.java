package com.datadog.android.rum.internal.instrumentation;

import android.content.Context;
import android.os.Looper;
import android.util.Printer;
import com.datadog.android.rum.tracking.TrackingStrategy;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\u0012\u0010\u001b\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/instrumentation/MainLooperLongTaskStrategy;", "Landroid/util/Printer;", "Lcom/datadog/android/rum/tracking/TrackingStrategy;", "thresholdMs", "", "(J)V", "startUptimeNs", "target", "", "getThresholdMs$dd_sdk_android_release", "()J", "thresholdNS", "detectLongTask", "", "message", "equals", "", "other", "", "hashCode", "", "println", "x", "register", "context", "Landroid/content/Context;", "toString", "unregister", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: MainLooperLongTaskStrategy.kt */
public final class MainLooperLongTaskStrategy implements Printer, TrackingStrategy {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: e */
    private static final String f3830e = ">>>>> Dispatching to ";

    /* renamed from: f */
    private static final String f3831f = "<<<<< Finished to ";

    /* renamed from: g */
    private static final int f3832g = 21;

    /* renamed from: a */
    private final long f3833a;

    /* renamed from: b */
    private final long f3834b = TimeUnit.MILLISECONDS.toNanos(this.f3833a);

    /* renamed from: c */
    private long f3835c;

    /* renamed from: d */
    private String f3836d = "";

    public MainLooperLongTaskStrategy(long j) {
        this.f3833a = j;
    }

    public final long getThresholdMs$dd_sdk_android_release() {
        return this.f3833a;
    }

    public void register(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Looper.getMainLooper().setMessageLogging(this);
    }

    public void unregister(Context context) {
        Looper.getMainLooper().setMessageLogging((Printer) null);
    }

    public void println(String str) {
        if (str != null) {
            m2481a(str);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj != null) {
            return this.f3833a == ((MainLooperLongTaskStrategy) obj).f3833a;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.datadog.android.rum.internal.instrumentation.MainLooperLongTaskStrategy");
    }

    public int hashCode() {
        return C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f3833a);
    }

    public String toString() {
        return "MainLooperLongTaskStrategy(" + this.f3833a + VersionRange.RIGHT_OPEN;
    }

    /* JADX WARNING: type inference failed for: r7v3, types: [com.datadog.android.rum.RumMonitor] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m2481a(java.lang.String r7) {
        /*
            r6 = this;
            long r0 = java.lang.System.nanoTime()
            java.lang.String r2 = ">>>>> Dispatching to "
            r3 = 0
            r4 = 2
            r5 = 0
            boolean r2 = kotlin.text.StringsKt.startsWith$default(r7, r2, r3, r4, r5)
            if (r2 == 0) goto L_0x0029
            r2 = 21
            if (r7 == 0) goto L_0x0021
            java.lang.String r7 = r7.substring(r2)
            java.lang.String r2 = "(this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)
            r6.f3836d = r7
            r6.f3835c = r0
            goto L_0x004d
        L_0x0021:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r7.<init>(r0)
            throw r7
        L_0x0029:
            java.lang.String r2 = "<<<<< Finished to "
            boolean r7 = kotlin.text.StringsKt.startsWith$default(r7, r2, r3, r4, r5)
            if (r7 == 0) goto L_0x004d
            long r2 = r6.f3835c
            long r0 = r0 - r2
            long r2 = r6.f3834b
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 <= 0) goto L_0x004d
            com.datadog.android.rum.RumMonitor r7 = com.datadog.android.rum.GlobalRum.get()
            boolean r2 = r7 instanceof com.datadog.android.rum.internal.monitor.AdvancedRumMonitor
            if (r2 == 0) goto L_0x0045
            r5 = r7
            com.datadog.android.rum.internal.monitor.AdvancedRumMonitor r5 = (com.datadog.android.rum.internal.monitor.AdvancedRumMonitor) r5
        L_0x0045:
            if (r5 != 0) goto L_0x0048
            goto L_0x004d
        L_0x0048:
            java.lang.String r7 = r6.f3836d
            r5.addLongTask(r0, r7)
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.rum.internal.instrumentation.MainLooperLongTaskStrategy.m2481a(java.lang.String):void");
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/instrumentation/MainLooperLongTaskStrategy$Companion;", "", "()V", "PREFIX_END", "", "PREFIX_START", "PREFIX_START_LENGTH", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: MainLooperLongTaskStrategy.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
