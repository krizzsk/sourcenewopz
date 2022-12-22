package com.didi.soda.customer.biz.order.looper.mix.statemachine.state;

import com.didi.app.nova.support.statemachine.BaseState;
import com.didi.soda.customer.biz.order.looper.mix.statemachine.MixStrategyStateMachine;

public abstract class CBaseState extends BaseState<Void, MixStrategyStateMachine> {
    public abstract void start();

    public abstract void stop();
}
