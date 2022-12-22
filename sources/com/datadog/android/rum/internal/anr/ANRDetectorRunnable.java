package com.datadog.android.rum.internal.anr;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0002\r\u000eB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\f\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/anr/ANRDetectorRunnable;", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "anrThresholdMs", "", "anrTestDelayMs", "(Landroid/os/Handler;JJ)V", "shouldStop", "", "run", "", "stop", "CallbackRunnable", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ANRDetectorRunnable.kt */
public final class ANRDetectorRunnable implements Runnable {
    public static final String ANR_MESSAGE = "Application Not Responding";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: e */
    private static final long f3680e = 5000;

    /* renamed from: f */
    private static final long f3681f = 500;

    /* renamed from: a */
    private final Handler f3682a;

    /* renamed from: b */
    private final long f3683b;

    /* renamed from: c */
    private final long f3684c;

    /* renamed from: d */
    private boolean f3685d;

    public ANRDetectorRunnable(Handler handler, long j, long j2) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f3682a = handler;
        this.f3683b = j;
        this.f3684c = j2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ANRDetectorRunnable(Handler handler, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, (i & 2) != 0 ? 5000 : j, (i & 4) != 0 ? 500 : j2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
        java.lang.Thread.sleep(r7.f3684c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r7 = this;
        L_0x0000:
            boolean r0 = java.lang.Thread.interrupted()
            if (r0 != 0) goto L_0x005d
            boolean r0 = r7.f3685d
            if (r0 == 0) goto L_0x000b
            return
        L_0x000b:
            com.datadog.android.rum.internal.anr.ANRDetectorRunnable$CallbackRunnable r0 = new com.datadog.android.rum.internal.anr.ANRDetectorRunnable$CallbackRunnable     // Catch:{ InterruptedException -> 0x005d }
            r0.<init>()     // Catch:{ InterruptedException -> 0x005d }
            monitor-enter(r0)     // Catch:{ InterruptedException -> 0x005d }
            android.os.Handler r1 = r7.f3682a     // Catch:{ all -> 0x005a }
            r2 = r0
            java.lang.Runnable r2 = (java.lang.Runnable) r2     // Catch:{ all -> 0x005a }
            boolean r1 = r1.post(r2)     // Catch:{ all -> 0x005a }
            if (r1 != 0) goto L_0x001e
            monitor-exit(r0)     // Catch:{ InterruptedException -> 0x005d }
            return
        L_0x001e:
            long r1 = r7.f3683b     // Catch:{ all -> 0x005a }
            r0.wait(r1)     // Catch:{ all -> 0x005a }
            boolean r1 = r0.wasCalled()     // Catch:{ all -> 0x005a }
            if (r1 != 0) goto L_0x0051
            com.datadog.android.rum.RumMonitor r1 = com.datadog.android.rum.GlobalRum.get()     // Catch:{ all -> 0x005a }
            java.lang.String r2 = "Application Not Responding"
            com.datadog.android.rum.RumErrorSource r3 = com.datadog.android.rum.RumErrorSource.SOURCE     // Catch:{ all -> 0x005a }
            com.datadog.android.rum.internal.anr.ANRException r4 = new com.datadog.android.rum.internal.anr.ANRException     // Catch:{ all -> 0x005a }
            android.os.Handler r5 = r7.f3682a     // Catch:{ all -> 0x005a }
            android.os.Looper r5 = r5.getLooper()     // Catch:{ all -> 0x005a }
            java.lang.Thread r5 = r5.getThread()     // Catch:{ all -> 0x005a }
            java.lang.String r6 = "handler.looper.thread"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ all -> 0x005a }
            r4.<init>(r5)     // Catch:{ all -> 0x005a }
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ all -> 0x005a }
            java.util.Map r5 = kotlin.collections.MapsKt.emptyMap()     // Catch:{ all -> 0x005a }
            r1.addError(r2, r3, r4, r5)     // Catch:{ all -> 0x005a }
            r0.wait()     // Catch:{ all -> 0x005a }
        L_0x0051:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005a }
            monitor-exit(r0)     // Catch:{ InterruptedException -> 0x005d }
            long r0 = r7.f3684c     // Catch:{ InterruptedException -> 0x005d }
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x005d }
            goto L_0x0000
        L_0x005a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ InterruptedException -> 0x005d }
            throw r1     // Catch:{ InterruptedException -> 0x005d }
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.rum.internal.anr.ANRDetectorRunnable.run():void");
    }

    public final void stop() {
        this.f3685d = true;
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/anr/ANRDetectorRunnable$CallbackRunnable;", "Ljava/lang/Object;", "Ljava/lang/Runnable;", "()V", "called", "", "run", "", "wasCalled", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ANRDetectorRunnable.kt */
    public static final class CallbackRunnable implements Runnable {
        private boolean called;

        public synchronized void run() {
            this.called = true;
            notifyAll();
        }

        public final boolean wasCalled() {
            return this.called;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/anr/ANRDetectorRunnable$Companion;", "", "()V", "ANR_MESSAGE", "", "ANR_TEST_DELAY_MS", "", "ANR_THRESHOLD_MS", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ANRDetectorRunnable.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
