package com.didi.hawaii.mapsdkv2.core;

import java.util.Timer;
import java.util.TimerTask;

final class RenderHeartbeat {

    /* renamed from: a */
    private static final int f23977a = 60;

    /* renamed from: b */
    private final Timer f23978b = new Timer("RenderHeartbeat");

    /* renamed from: c */
    private TimerTask f23979c;

    /* renamed from: d */
    private boolean f23980d = false;

    /* renamed from: e */
    private RenderListener f23981e;

    interface RenderListener {
        void invokeRequestRender();
    }

    RenderHeartbeat(RenderListener renderListener) {
        this.f23981e = renderListener;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo70581a(int i) {
        m17053d(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo70583b(int i) {
        m17053d(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo70580a() {
        m17052c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized void mo70584c(int i) {
        m17052c();
        m17053d(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo70582b() {
        m17052c();
        this.f23978b.cancel();
    }

    /* renamed from: d */
    private void m17053d(int i) {
        if (i <= 0 || i > 6) {
            throw new IllegalArgumentException("Wrong fps ratios. Must between of FPS_60 and FPS_10");
        } else if (!this.f23980d) {
            RateTimerTask rateTimerTask = new RateTimerTask(this.f23981e);
            this.f23979c = rateTimerTask;
            try {
                this.f23978b.schedule(rateTimerTask, 0, 1000 / ((long) (60 / i)));
            } catch (Exception unused) {
            }
            this.f23980d = true;
        }
    }

    /* renamed from: c */
    private void m17052c() {
        if (this.f23980d) {
            TimerTask timerTask = this.f23979c;
            if (timerTask != null) {
                timerTask.cancel();
            }
            this.f23980d = false;
        }
    }

    static class RateTimerTask extends TimerTask {
        private boolean isCancel = false;
        final RenderListener listener;

        RateTimerTask(RenderListener renderListener) {
            this.listener = renderListener;
        }

        public void run() {
            if (!this.isCancel) {
                this.listener.invokeRequestRender();
            }
        }

        public boolean cancel() {
            this.isCancel = true;
            return super.cancel();
        }
    }
}
