package com.android.didi.bfflib;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.android.didi.bfflib.task.BffBaseProxyImpl;
import java.util.List;

public abstract class BffProxyImpl extends BffBaseProxyImpl {
    BffProxyImpl(Context context, Bff.BffConfig bffConfig) {
        super(context, bffConfig);
    }

    public boolean request() {
        if (isRequesting()) {
            return false;
        }
        requestAbilityInLoop(this.mAbilityList);
        return true;
    }

    public IBffProxy addAlibilityList(List<IBffProxy.Ability> list) {
        if (list == null) {
            return this;
        }
        for (IBffProxy.Ability addAbility : list) {
            addAbility(addAbility);
        }
        return this;
    }

    public boolean canAddAbilityInThisTask(IBffProxy.Ability ability) {
        return this.mStatus != 1;
    }
}
