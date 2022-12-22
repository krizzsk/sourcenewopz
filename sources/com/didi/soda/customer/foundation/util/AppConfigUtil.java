package com.didi.soda.customer.foundation.util;

import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.storage.model.AppConfig;

public final class AppConfigUtil {
    private AppConfigUtil() {
    }

    public static boolean isGuideAnimShowed() {
        return ((AppConfigStorage) SingletonFactory.get(AppConfigStorage.class)).getData().mAddressGuideShowed;
    }

    public static void setGuideAnimShowed() {
        AppConfigStorage appConfigStorage = (AppConfigStorage) SingletonFactory.get(AppConfigStorage.class);
        AppConfig data = appConfigStorage.getData();
        data.mAddressGuideShowed = true;
        appConfigStorage.setData(data);
    }
}
