package com.didichuxing.request;

import android.text.TextUtils;
import com.didichuxing.upgrade.UpgradeConfig;

public class UpgradeBaseRequest {
    protected static final String HOST = "https://apm.didiglobal.com";
    protected static final String PATH_SWITCH = "/muse/update/switch";
    protected static final String PATH_USER = "/muse-center/muse/user";
    protected static final String PATH_V2 = "/muse/update/v2?";

    protected static String getHost() {
        String customHost = UpgradeConfig.iConfig.getCustomHost();
        if (!TextUtils.isEmpty(customHost)) {
            return '/' == customHost.charAt(customHost.length() + -1) ? customHost.substring(0, customHost.length() - 1) : customHost;
        }
        return "https://apm.didiglobal.com";
    }
}
