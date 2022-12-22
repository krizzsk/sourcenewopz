package com.didi.entrega.customer.biz.order.looper.trigger;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.entrega.customer.biz.order.looper.trigger.ITriggerManager;
import com.didi.entrega.customer.foundation.log.util.LogUtil;

public class TimerTriggerManager implements ITriggerManager {

    /* renamed from: a */
    private static final String f19823a = "TimerTriggerManager";

    /* renamed from: b */
    private Handler f19824b = new TimeHandler(Looper.getMainLooper(), new Runnable() {
        public void run() {
            TimerTriggerManager.this.doRequestOnce();
        }
    });
    /* access modifiers changed from: private */

    /* renamed from: c */
    public volatile boolean f19825c = false;

    /* renamed from: d */
    private volatile boolean f19826d = false;

    /* renamed from: e */
    private boolean f19827e;

    /* renamed from: f */
    private long f19828f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f19829g;
    protected ITriggerManager.TriggerListener mTriggerListener;

    public boolean isOverTime() {
        return false;
    }

    public TimerTriggerManager(int i) {
        this.f19829g = i;
        this.f19827e = true;
    }

    public void active() {
        LogUtil.m14765i(f19823a, "TimerTriggerManager --> active");
        this.f19827e = true;
    }

    public void doRequestOnce() {
        if (!this.f19826d) {
            m14695a();
            updateLastWorkTime();
        }
    }

    public void inactive() {
        LogUtil.m14765i(f19823a, "TimerTriggerManager --> inactive");
        this.f19827e = false;
    }

    public boolean isActive() {
        return this.f19827e;
    }

    public boolean isWorking() {
        return this.f19826d;
    }

    public void notifyWorkFinish() {
        this.f19826d = false;
    }

    public void reset() {
        this.f19824b.sendEmptyMessage(4);
    }

    public void serLooperTime(int i) {
        if (i < 3000) {
            i = 3000;
        }
        this.f19829g = i;
    }

    public void setTriggerListener(ITriggerManager.TriggerListener triggerListener) {
        this.mTriggerListener = triggerListener;
    }

    public void start() {
        if (!this.f19825c) {
            this.f19825c = true;
            LogUtil.m14765i(f19823a, "TimerTriggerManager --> start");
            this.f19824b.removeMessages(2);
            this.f19824b.sendEmptyMessage(2);
        }
    }

    public void stop() {
        if (this.f19825c) {
            this.f19824b.removeCallbacksAndMessages((Object) null);
            this.f19825c = false;
            notifyWorkFinish();
            LogUtil.m14765i(f19823a, "TimerTriggerManager --> stop");
        }
    }

    public void updateLastWorkTime() {
        this.f19828f = System.currentTimeMillis();
    }

    /* renamed from: a */
    private void m14695a() {
        this.f19826d = true;
        ITriggerManager.TriggerListener triggerListener = this.mTriggerListener;
        if (triggerListener != null) {
            triggerListener.doLoopWork((String) null);
            LogUtil.m14765i(f19823a, "TimerTriggerManager --> doWork");
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
                LogUtil.m14765i(TimerTriggerManager.f19823a, "timer DO_LOOP.");
                this.mRunnable.run();
                sendEmptyMessageDelayed(2, (long) TimerTriggerManager.this.f19829g);
            } else if (i == 3) {
                LogUtil.m14765i(TimerTriggerManager.f19823a, "looper ends");
                boolean unused = TimerTriggerManager.this.f19825c = false;
                removeCallbacksAndMessages((Object) null);
            } else if (i == 4) {
                LogUtil.m14765i(TimerTriggerManager.f19823a, "clear timer");
                removeMessages(2);
                sendEmptyMessageDelayed(2, (long) TimerTriggerManager.this.f19829g);
            }
        }
    }
}
