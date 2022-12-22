package com.didi.soda.customer.foundation.util;

import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.storage.model.AppConfig;

public final class SplashUtil {
    private SplashUtil() {
    }

    public static boolean isFirstOpen() {
        if (LoginUtil.isLogin()) {
            return false;
        }
        return ((AppConfigStorage) SingletonFactory.get(AppConfigStorage.class)).getData().mIsFirstOpen;
    }

    public static boolean judgeFirstOpenAndReset() {
        if (LoginUtil.isLogin()) {
            return false;
        }
        AppConfigStorage appConfigStorage = (AppConfigStorage) SingletonFactory.get(AppConfigStorage.class);
        AppConfig data = appConfigStorage.getData();
        boolean z = data.mIsFirstOpen;
        if (z) {
            data.mIsFirstOpen = false;
            appConfigStorage.setData(data);
        }
        return z;
    }
}
