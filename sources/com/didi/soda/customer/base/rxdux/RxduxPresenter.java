package com.didi.soda.customer.base.rxdux;

import com.didi.soda.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.soda.customer.base.recycler.CustomerRecyclerView;

public abstract class RxduxPresenter<State, V extends CustomerRecyclerView> extends CustomerRecyclerPresenter<V> {
    protected State mState = null;

    /* access modifiers changed from: protected */
    public void setState(State state) {
    }

    /* access modifiers changed from: protected */
    public void updateState(State state) {
        if (!state.equals(this.mState)) {
            this.mState = state;
            setState(state);
        }
    }
}
