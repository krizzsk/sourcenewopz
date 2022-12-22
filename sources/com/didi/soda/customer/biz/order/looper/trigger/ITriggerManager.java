package com.didi.soda.customer.biz.order.looper.trigger;

public interface ITriggerManager {

    public interface TriggerListener {
        void doLoopWork(String str);
    }

    void active();

    void doRequestOnce();

    void inactive();

    boolean isActive();

    boolean isOverTime();

    boolean isWorking();

    void notifyWorkFinish();

    void reset();

    void serLooperTime(int i);

    void setTriggerListener(TriggerListener triggerListener);

    void start();

    void stop();

    void updateLastWorkTime();
}
