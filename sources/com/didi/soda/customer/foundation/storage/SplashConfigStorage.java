package com.didi.soda.customer.foundation.storage;

public class SplashConfigStorage extends CustomerStorage<SplashConfig> {
    public SplashConfig getData() {
        SplashConfig splashConfig = (SplashConfig) super.getData();
        if (splashConfig != null) {
            return splashConfig;
        }
        SplashConfig splashConfig2 = new SplashConfig();
        setData(splashConfig2);
        return splashConfig2;
    }
}
