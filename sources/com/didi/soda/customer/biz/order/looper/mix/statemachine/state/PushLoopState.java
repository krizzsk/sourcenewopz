package com.didi.soda.customer.biz.order.looper.mix.statemachine.state;

import com.didi.soda.customer.biz.order.looper.mix.statemachine.MixStrategyStateMachine;
import com.didi.soda.customer.biz.order.looper.trigger.PushTriggerManager;
import com.didi.soda.customer.foundation.push.LongConnectionProvider;

public class PushLoopState extends CBaseState {

    /* renamed from: b */
    private static final String f40435b = "PushLoopState";

    /* renamed from: a */
    PushTriggerManager f40436a;

    public void onCreate(MixStrategyStateMachine mixStrategyStateMachine) {
        super.onCreate(mixStrategyStateMachine);
        PushTriggerManager pushTriggerManager = (PushTriggerManager) mixStrategyStateMachine.getTrrigerManager(PushTriggerManager.class);
        this.f40436a = pushTriggerManager;
        pushTriggerManager.start();
    }

    public void onDestroy(MixStrategyStateMachine mixStrategyStateMachine) {
        super.onDestroy(mixStrategyStateMachine);
        this.f40436a.stop();
    }

    public void onStart(MixStrategyStateMachine mixStrategyStateMachine) {
        super.onStart(mixStrategyStateMachine);
        this.f40436a.active();
    }

    public void onStop(MixStrategyStateMachine mixStrategyStateMachine) {
        super.onStop(mixStrategyStateMachine);
        this.f40436a.inactive();
    }

    public void start() {
        this.f40436a.start();
    }

    public void stop() {
        this.f40436a.stop();
    }

    public void update(MixStrategyStateMachine mixStrategyStateMachine, Void voidR) {
        if (!LongConnectionProvider.getInstance().isConnected()) {
            mixStrategyStateMachine.switchTo(TimeLoopState.class);
        } else if (this.f40436a.isOverTime()) {
            this.f40436a.doRequestOnce();
            this.f40436a.updateLastWorkTime();
        }
    }
}
