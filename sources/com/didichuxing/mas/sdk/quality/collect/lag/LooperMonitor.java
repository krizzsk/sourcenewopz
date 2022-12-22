package com.didichuxing.mas.sdk.quality.collect.lag;

import android.os.SystemClock;
import android.util.Printer;
import com.didichuxing.mas.sdk.quality.report.backend.AppStateMonitor;
import com.didichuxing.mas.sdk.quality.report.backend.ScreenChangeReceiver;

class LooperMonitor implements Printer {

    /* renamed from: a */
    private static long f48111a = 3000;

    /* renamed from: b */
    private long f48112b = f48111a;

    /* renamed from: c */
    private long f48113c = 0;

    /* renamed from: d */
    private long f48114d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public BlockListener f48115e = null;

    /* renamed from: f */
    private boolean f48116f = false;

    /* renamed from: g */
    private final boolean f48117g;

    public interface BlockListener {
        void onBlockEvent(long j, long j2, long j3, long j4);
    }

    public LooperMonitor(BlockListener blockListener, long j, boolean z) {
        if (blockListener != null) {
            this.f48115e = blockListener;
            this.f48112b = j;
            this.f48117g = z;
            return;
        }
        throw new IllegalArgumentException("blockListener should not be null.");
    }

    public void println(String str) {
        if (!this.f48116f) {
            this.f48113c = System.currentTimeMillis();
            this.f48114d = SystemClock.currentThreadTimeMillis();
            this.f48116f = true;
            m34316a();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f48116f = false;
        if (m34317a(currentTimeMillis)) {
            m34319b(currentTimeMillis);
        }
        m34318b();
    }

    /* renamed from: a */
    private boolean m34317a(long j) {
        return j - this.f48113c > this.f48112b && AppStateMonitor.getInstance().isInForeground() && ScreenChangeReceiver.SCREEN_STATE == ScreenChangeReceiver.ScreenState.ON;
    }

    /* renamed from: b */
    private void m34319b(long j) {
        final long j2 = this.f48113c;
        final long j3 = this.f48114d;
        final long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        final long j4 = j;
        HandlerThreadFactory.getWriteLogThreadHandler().post(new Runnable() {
            public void run() {
                LooperMonitor.this.f48115e.onBlockEvent(j2, j4, j3, currentThreadTimeMillis);
            }
        });
    }

    /* renamed from: a */
    private void m34316a() {
        if (BlockCanaryInternals.m34310a().f48106b != null) {
            BlockCanaryInternals.m34310a().f48106b.mo118404a();
        }
        if (BlockCanaryInternals.m34310a().f48107c != null) {
            BlockCanaryInternals.m34310a().f48107c.mo118404a();
        }
    }

    /* renamed from: b */
    private void m34318b() {
        if (BlockCanaryInternals.m34310a().f48106b != null) {
            BlockCanaryInternals.m34310a().f48106b.mo118405b();
        }
        if (BlockCanaryInternals.m34310a().f48107c != null) {
            BlockCanaryInternals.m34310a().f48107c.mo118405b();
        }
    }
}
