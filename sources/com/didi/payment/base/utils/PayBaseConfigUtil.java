package com.didi.payment.base.utils;

import com.didi.payment.base.proxy.ConfigProxyHolder;

public class PayBaseConfigUtil {
    public static boolean isDebugMode() {
        return ConfigProxyHolder.getProxy() != null && ConfigProxyHolder.getProxy().isDebugMode();
    }
}
