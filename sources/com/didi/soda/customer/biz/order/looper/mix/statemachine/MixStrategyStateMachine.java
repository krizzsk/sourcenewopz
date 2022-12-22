package com.didi.soda.customer.biz.order.looper.mix.statemachine;

import com.didi.soda.customer.biz.order.looper.mix.statemachine.IMixMachineTrigger;
import com.didi.soda.customer.biz.order.looper.mix.statemachine.state.CBaseState;
import com.didi.soda.customer.biz.order.looper.mix.statemachine.state.PushLoopState;
import com.didi.soda.customer.biz.order.looper.mix.statemachine.state.TimeLoopState;
import com.didi.soda.customer.biz.order.looper.trigger.ITriggerManager;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.push.LongConnectionProvider;
import java.util.HashMap;
import java.util.Map;

public class MixStrategyStateMachine extends MixBaseStateMachine {
    public static final int INTERVAL = 5000;

    /* renamed from: b */
    private static final String f40431b = "MixStrategyStateMachine";

    /* renamed from: a */
    IMixMachineTrigger.OnTriggerListener f40432a = new IMixMachineTrigger.OnTriggerListener() {
        public void doTrigger() {
            MixStrategyStateMachine.this.update((Void) null);
        }
    };

    /* renamed from: c */
    private Map<Class, ITriggerManager> f40433c = new HashMap();

    /* renamed from: d */
    private IMixMachineTrigger f40434d;

    public MixStrategyStateMachine(IMixMachineTrigger iMixMachineTrigger, ITriggerManager... iTriggerManagerArr) {
        for (ITriggerManager iTriggerManager : iTriggerManagerArr) {
            this.f40433c.put(iTriggerManager.getClass(), iTriggerManager);
        }
        this.f40434d = iMixMachineTrigger;
        if (iMixMachineTrigger == null) {
            this.f40434d = new MixMachineTrigger();
        }
    }

    public ITriggerManager getTrrigerManager(Class cls) {
        return this.f40433c.get(cls);
    }

    public void onActive() {
        LogUtil.m29100d("Looper", "MixedLooperStrategyStateMachine -> onActive");
        this.mCurrentState.onStart(this);
    }

    public void onCreate() {
        LogUtil.m29100d("Looper", "MixedLooperStrategyStateMachine -> onCreate");
        super.onCreate();
        reset();
        this.f40434d.setInterval(5000);
        this.f40434d.setTriggerListener(this.f40432a);
        this.f40434d.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
        LogUtil.m29100d("Looper", "MixedLooperStrategyStateMachine -> onDestroy");
        this.mCurrentState.onDestroy(this);
        this.f40433c = null;
        this.f40434d.onDestroy();
        this.f40434d = null;
    }

    public void onInactive() {
        LogUtil.m29100d("Looper", "MixedLooperStrategyStateMachine -> onInactive");
        this.mCurrentState.onStop(this);
    }

    public void reset() {
        LogUtil.m29100d("Looper", "MixedLooperStrategyStateMachine -> reset");
        if (LongConnectionProvider.getInstance().isConnected()) {
            switchTo(PushLoopState.class);
        } else {
            switchTo(TimeLoopState.class);
        }
    }

    public void start() {
        LogUtil.m29100d("Looper", "MixedLooperStrategyStateMachine -> start");
        this.f40434d.start();
        ((CBaseState) this.mCurrentState).start();
    }

    public void stop() {
        LogUtil.m29100d("Looper", "MixedLooperStrategyStateMachine -> stop");
        this.f40434d.stop();
        ((CBaseState) this.mCurrentState).stop();
    }

    public void update(Void voidR) {
        super.update(voidR);
        LogUtil.m29100d("Looper", "MixedLooperStrategyStateMachine -> update");
        if (this.mCurrentState == null) {
            LogUtil.m29100d("Looper", "MixedLooperStrategyStateMachine -> update mCurrentState is null");
        } else {
            this.mCurrentState.update(this, null);
        }
    }
}
