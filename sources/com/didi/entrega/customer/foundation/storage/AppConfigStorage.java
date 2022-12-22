package com.didi.entrega.customer.foundation.storage;

import com.didi.entrega.customer.foundation.storage.model.AppConfig;

public class AppConfigStorage extends CustomerStorage<AppConfig> {
    public AppConfig getData() {
        AppConfig appConfig = (AppConfig) super.getData();
        if (appConfig != null) {
            return appConfig;
        }
        AppConfig appConfig2 = new AppConfig();
        setData(appConfig2);
        return appConfig2;
    }
}
