package com.android.didi.bfflib.concurrent;

public class BffConcurrentFormStore {
    private BffAbilityMapModel mAbilityMapModel;

    private BffConcurrentFormStore() {
    }

    private static class BffConcurrentFormStoreHolder {
        /* access modifiers changed from: private */
        public static final BffConcurrentFormStore INSTANCE = new BffConcurrentFormStore();

        private BffConcurrentFormStoreHolder() {
        }
    }

    public static final BffConcurrentFormStore getInstance() {
        return BffConcurrentFormStoreHolder.INSTANCE;
    }

    public void setAbilityMapModel(BffAbilityMapModel bffAbilityMapModel) {
        this.mAbilityMapModel = bffAbilityMapModel;
    }

    public BffAbilityMapModel getAbilityMapModel() {
        return this.mAbilityMapModel;
    }
}
