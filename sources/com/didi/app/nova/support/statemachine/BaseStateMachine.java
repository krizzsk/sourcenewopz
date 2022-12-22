package com.didi.app.nova.support.statemachine;

import com.didi.app.nova.support.helper.ActiveStateHelper;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class BaseStateMachine<T> {

    /* renamed from: a */
    private ActiveStateHelper f8541a = new ActiveStateHelper();

    /* renamed from: b */
    private HashMap<Class<? extends BaseState>, List<StateCallback>> f8542b = new HashMap<>();
    protected BaseState mCurrentState;

    public interface StateCallback {
        /* renamed from: on */
        void mo41162on(Class<? extends BaseState> cls, String str);
    }

    public abstract void reset();

    public void onCreate() {
        this.f8541a.active();
    }

    public void onDestroy() {
        BaseState baseState = this.mCurrentState;
        if (baseState != null) {
            baseState.onDestroy(this);
        }
        this.f8541a.inactive();
    }

    public Class getState() {
        BaseState baseState = this.mCurrentState;
        if (baseState == null) {
            return null;
        }
        return baseState.getClass();
    }

    public boolean isCreated() {
        return this.f8541a.isActive();
    }

    public void update(T t) {
        BaseState baseState = this.mCurrentState;
        if (baseState != null) {
            baseState.update(this, t);
        }
    }

    public void switchTo(Class<? extends BaseState> cls) {
        BaseState baseState = this.mCurrentState;
        if (baseState != null) {
            baseState.onDestroy(this);
            this.mCurrentState = null;
        }
        try {
            this.mCurrentState = (BaseState) cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            SystemUtils.log(3, "maxiee", "InstantiationException", (Throwable) null, "com.didi.app.nova.support.statemachine.BaseStateMachine", 100);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            SystemUtils.log(3, "maxiee", "IllegalAccessException", (Throwable) null, "com.didi.app.nova.support.statemachine.BaseStateMachine", 103);
        }
        BaseState baseState2 = this.mCurrentState;
        if (baseState2 != null) {
            baseState2.onCreate(this);
        }
    }

    public void registerStateCallback(Class<? extends BaseState> cls, StateCallback stateCallback) {
        if (!this.f8542b.containsKey(cls)) {
            this.f8542b.put(cls, new ArrayList());
        }
        if (!this.f8542b.get(cls).contains(stateCallback)) {
            this.f8542b.get(cls).add(stateCallback);
        }
    }

    public void unregisterStateCallback(Class<? extends BaseState> cls, StateCallback stateCallback) {
        if (this.f8542b.containsKey(cls) && this.f8542b.get(cls).contains(stateCallback)) {
            this.f8542b.get(cls).remove(stateCallback);
        }
    }

    public void unregisterAllStateCallbacks() {
        this.f8542b.clear();
    }

    public void dispatchStateCallback(Class<? extends BaseState> cls, String str) {
        if (this.f8542b.containsKey(cls)) {
            ArrayList arrayList = new ArrayList(this.f8542b.get(cls));
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((StateCallback) arrayList.get(i)).mo41162on(cls, str);
            }
        }
    }
}
