package com.didi.onehybrid;

import com.didi.onehybrid.container.HybridableContainer;

public class BaseHybridModule {
    public HybridableContainer mHybridContainer;

    public BaseHybridModule(HybridableContainer hybridableContainer) {
        this.mHybridContainer = hybridableContainer;
    }
}
