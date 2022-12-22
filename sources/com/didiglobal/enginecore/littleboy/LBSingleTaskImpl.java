package com.didiglobal.enginecore.littleboy;

import android.content.Context;

public abstract class LBSingleTaskImpl extends LBBaseTask {
    protected LBSingleTaskImpl(Context context) {
        super(context);
    }

    public boolean canAddAbilityInThisTask(LBAbility lBAbility) {
        return this.mAbilityList.size() == 0;
    }

    /* access modifiers changed from: protected */
    public void setStatusAfterAddAbility() {
        this.mStatus = 0;
    }
}
