package com.didi.sdk.utdevice;

public class UTDeviceHolder {

    /* renamed from: a */
    private UTDeviceListener f37547a;

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final UTDeviceHolder INSTANCE = new UTDeviceHolder();

        private SingletonHolder() {
        }
    }

    private UTDeviceHolder() {
    }

    public static final UTDeviceHolder getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public UTDeviceListener getDeviceListener() {
        return this.f37547a;
    }

    public void setDeviceListener(UTDeviceListener uTDeviceListener) {
        this.f37547a = uTDeviceListener;
    }
}
