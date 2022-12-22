package com.didi.soda.customer.biz.order.looper.mix.statemachine;

import com.didi.app.nova.support.statemachine.BaseStateMachine;

public abstract class MixBaseStateMachine extends BaseStateMachine<Void> {
    public abstract void onActive();

    public abstract void onInactive();

    public abstract void start();

    public abstract void stop();
}
