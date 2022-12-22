package com.didi.soda.customer.biz.order.looper.mix.statemachine.state;

import com.didi.soda.customer.biz.order.looper.mix.statemachine.MixStrategyStateMachine;
import com.didi.soda.customer.biz.order.looper.trigger.TimerTriggerManager;
import com.didi.soda.customer.foundation.push.LongConnectionProvider;

public class TimeLoopState extends CBaseState {

    /* renamed from: b */
    private static final String f40437b = "TimeLoopState";

    /* renamed from: a */
    TimerTriggerManager f40438a;

    public void onCreate(MixStrategyStateMachine mixStrategyStateMachine) {
        super.onCreate(mixStrategyStateMachine);
        TimerTriggerManager timerTriggerManager = (TimerTriggerManager) mixStrategyStateMachine.getTrrigerManager(TimerTriggerManager.class);
        this.f40438a = timerTriggerManager;
        timerTriggerManager.start();
    }

    public void onDestroy(MixStrategyStateMachine mixStrategyStateMachine) {
        super.onDestroy(mixStrategyStateMachine);
        this.f40438a.stop();
    }

    public void onStart(MixStrategyStateMachine mixStrategyStateMachine) {
        super.onStart(mixStrategyStateMachine);
        this.f40438a.active();
    }

    public void onStop(MixStrategyStateMachine mixStrategyStateMachine) {
        super.onStop(mixStrategyStateMachine);
        this.f40438a.inactive();
    }

    public void start() {
        this.f40438a.start();
    }

    public void stop() {
        this.f40438a.stop();
    }

    public void update(MixStrategyStateMachine mixStrategyStateMachine, Void voidR) {
        if (LongConnectionProvider.getInstance().isConnected()) {
            mixStrategyStateMachine.switchTo(PushLoopState.class);
        }
    }
}
