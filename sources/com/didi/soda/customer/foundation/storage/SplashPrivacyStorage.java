package com.didi.soda.customer.foundation.storage;

import com.didi.soda.customer.foundation.storage.model.SplashPrivacyConfig;

public class SplashPrivacyStorage extends CustomerStorage<SplashPrivacyConfig> {
    public SplashPrivacyConfig getData() {
        SplashPrivacyConfig splashPrivacyConfig = (SplashPrivacyConfig) super.getData();
        if (splashPrivacyConfig != null) {
            return splashPrivacyConfig;
        }
        SplashPrivacyConfig splashPrivacyConfig2 = new SplashPrivacyConfig();
        setData(splashPrivacyConfig2);
        return splashPrivacyConfig2;
    }
}
