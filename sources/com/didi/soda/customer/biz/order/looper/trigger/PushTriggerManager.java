package com.didi.soda.customer.biz.order.looper.trigger;

import com.didi.soda.customer.biz.order.looper.trigger.ITriggerManager;
import com.didi.soda.customer.foundation.log.util.LogUtil;

public class PushTriggerManager implements ITriggerManager {

    /* renamed from: a */
    private long f40439a = System.currentTimeMillis();

    /* renamed from: b */
    private long f40440b = 15000;

    /* renamed from: c */
    private ITriggerManager.TriggerListener f40441c;

    /* renamed from: d */
    private boolean f40442d;

    public boolean isWorking() {
        return false;
    }

    public void notifyWorkFinish() {
    }

    public void reset() {
    }

    public void serLooperTime(int i) {
    }

    public PushTriggerManager() {
        LogUtil.m29100d("ITriggerManager", "PushTriggerManager --> PushTriggerManager");
    }

    public void active() {
        LogUtil.m29100d("Push refactor", "LooperPushManager -> onStart");
        this.f40442d = true;
    }

    public void doRequestOnce() {
        ITriggerManager.TriggerListener triggerListener = this.f40441c;
        if (triggerListener != null) {
            triggerListener.doLoopWork((String) null);
        }
    }

    public void inactive() {
        LogUtil.m29100d("ITriggerManager", "PushTriggerManager --> inactive");
        this.f40442d = false;
    }

    public boolean isActive() {
        LogUtil.m29100d("ITriggerManager", "PushTriggerManager --> isForeground");
        return this.f40442d;
    }

    public boolean isOverTime() {
        return System.currentTimeMillis() - this.f40439a > this.f40440b;
    }

    public void setTriggerListener(ITriggerManager.TriggerListener triggerListener) {
        this.f40441c = triggerListener;
    }

    public void start() {
        LogUtil.m29100d("ITriggerManager", "PushTriggerManager --> start");
    }

    public void stop() {
        LogUtil.m29100d("ITriggerManager", "PushTriggerManager --> stop");
    }

    public void updateLastWorkTime() {
        this.f40439a = System.currentTimeMillis();
    }
}
