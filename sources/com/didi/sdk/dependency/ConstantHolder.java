package com.didi.sdk.dependency;

public class ConstantHolder {

    /* renamed from: a */
    private ConstantListener f35810a;

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final ConstantHolder INSTANCE = new ConstantHolder();

        private SingletonHolder() {
        }
    }

    private ConstantHolder() {
    }

    public static final ConstantHolder getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public ConstantListener getConstantListener() {
        return this.f35810a;
    }

    public void setConstantListener(ConstantListener constantListener) {
        this.f35810a = constantListener;
    }
}
