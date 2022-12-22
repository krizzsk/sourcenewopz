package com.didi.soda.customer.biz.order.looper.trigger;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.soda.customer.biz.order.looper.trigger.ITriggerManager;
import com.didi.soda.customer.foundation.log.util.LogUtil;

public class TimerTriggerManager implements ITriggerManager {

    /* renamed from: a */
    private static final String f40443a = "TimerTriggerManager";

    /* renamed from: b */
    private Handler f40444b = new TimeHandler(Looper.getMainLooper(), new Runnable() {
        public void run() {
            TimerTriggerManager.this.doRequestOnce();
        }
    });
    /* access modifiers changed from: private */

    /* renamed from: c */
    public volatile boolean f40445c = false;

    /* renamed from: d */
    private volatile boolean f40446d = false;

    /* renamed from: e */
    private boolean f40447e;

    /* renamed from: f */
    private long f40448f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f40449g;
    protected ITriggerManager.TriggerListener mTriggerListener;

    public boolean isOverTime() {
        return false;
    }

    public TimerTriggerManager(int i) {
        this.f40449g = i;
        this.f40447e = true;
    }

    public void active() {
        LogUtil.m29104i(f40443a, "TimerTriggerManager --> active");
        this.f40447e = true;
    }

    public void doRequestOnce() {
        if (!this.f40446d) {
            m28673a();
            updateLastWorkTime();
        }
    }

    public void inactive() {
        LogUtil.m29104i(f40443a, "TimerTriggerManager --> inactive");
        this.f40447e = false;
    }

    public boolean isActive() {
        return this.f40447e;
    }

    public boolean isWorking() {
        return this.f40446d;
    }

    public void notifyWorkFinish() {
        this.f40446d = false;
    }

    public void reset() {
        this.f40444b.sendEmptyMessage(4);
    }

    public void serLooperTime(int i) {
        if (i < 3000) {
            i = 3000;
        }
        this.f40449g = i;
    }

    public void setTriggerListener(ITriggerManager.TriggerListener triggerListener) {
        this.mTriggerListener = triggerListener;
    }

    public void start() {
        if (!this.f40445c) {
            this.f40445c = true;
            LogUtil.m29104i(f40443a, "TimerTriggerManager --> start");
            this.f40444b.removeMessages(2);
            this.f40444b.sendEmptyMessage(2);
        }
    }

    public void stop() {
        if (this.f40445c) {
            this.f40444b.removeCallbacksAndMessages((Object) null);
            this.f40445c = false;
            notifyWorkFinish();
            LogUtil.m29104i(f40443a, "TimerTriggerManager --> stop");
        }
    }

    public void updateLastWorkTime() {
        this.f40448f = System.currentTimeMillis();
    }

    /* renamed from: a */
    private void m28673a() {
        this.f40446d = true;
        ITriggerManager.TriggerListener triggerListener = this.mTriggerListener;
        if (triggerListener != null) {
            triggerListener.doLoopWork((String) null);
            LogUtil.m29104i(f40443a, "TimerTriggerManager --> doWork");
        }
    }

    private class TimeHandler extends Handler {
        static final int DO_LOOP = 2;
        static final int RESET_TIMER = 4;
        static final int SHUT_DOWN = 3;
        private Runnable mRunnable;

        public TimeHandler(Looper looper, Runnable runnable) {
            super(looper);
            this.mRunnable = runnable;
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 2) {
                LogUtil.m29104i(TimerTriggerManager.f40443a, "timer DO_LOOP.");
                this.mRunnable.run();
                sendEmptyMessageDelayed(2, (long) TimerTriggerManager.this.f40449g);
            } else if (i == 3) {
                LogUtil.m29104i(TimerTriggerManager.f40443a, "looper ends");
                boolean unused = TimerTriggerManager.this.f40445c = false;
                removeCallbacksAndMessages((Object) null);
            } else if (i == 4) {
                LogUtil.m29104i(TimerTriggerManager.f40443a, "clear timer");
                removeMessages(2);
                sendEmptyMessageDelayed(2, (long) TimerTriggerManager.this.f40449g);
            }
        }
    }
}
