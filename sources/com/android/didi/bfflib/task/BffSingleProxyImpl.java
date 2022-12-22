package com.android.didi.bfflib.task;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;

public abstract class BffSingleProxyImpl extends BffBaseProxyImpl {
    protected BffSingleProxyImpl(Context context, Bff.BffConfig bffConfig) {
        super(context, bffConfig);
    }

    public boolean canAddAbilityInThisTask(IBffProxy.Ability ability) {
        return this.mAbilityList.size() == 0;
    }

    /* access modifiers changed from: protected */
    public void setStatusAfterAddAbility() {
        this.mStatus = 0;
    }
}
