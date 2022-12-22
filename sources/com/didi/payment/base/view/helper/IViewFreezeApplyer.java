package com.didi.payment.base.view.helper;

import android.os.Bundle;

public interface IViewFreezeApplyer {
    void apply(FreezeState freezeState);

    public static class FreezeState {
        public Bundle extras;
        public boolean isFreeze = false;

        public FreezeState(boolean z) {
            this.isFreeze = z;
        }
    }
}
