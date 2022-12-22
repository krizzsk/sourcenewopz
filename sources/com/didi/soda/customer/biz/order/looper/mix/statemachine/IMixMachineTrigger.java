package com.didi.soda.customer.biz.order.looper.mix.statemachine;

public interface IMixMachineTrigger {

    public interface OnTriggerListener {
        void doTrigger();
    }

    void onCreate();

    void onDestroy();

    void setInterval(int i);

    void setTriggerListener(OnTriggerListener onTriggerListener);

    void start();

    void stop();
}
