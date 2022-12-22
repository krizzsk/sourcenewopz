package com.didi.dimina.container.secondparty.bundle.util;

import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.storage.MMKVUtil;
import com.didi.dimina.container.secondparty.bundle.PmConstant;
import com.didi.dimina.container.util.LogUtil;

public class UpgradeUtil {
    public static final String TAG = "UpgradeUtil";

    public static boolean isNativeAppUpgrade() {
        int appVersionCode = Dimina.getConfig().getAdapterConfig().getWsgService().getAppVersionCode(Dimina.getConfig().getApp());
        int intValue = ((Integer) MMKVUtil.getInstance().get(PmConstant.KEY_NATIVE_APP_VERSION_CODE, 0)).intValue();
        LogUtil.iRelease(TAG, "当前versionCode:" + appVersionCode + "  mmkv中versionCode:" + intValue);
        if (appVersionCode == 0 || appVersionCode != intValue) {
            return true;
        }
        return false;
    }

    public static void saveNativeAppVersionCode2MMKV() {
        int appVersionCode = Dimina.getConfig().getAdapterConfig().getWsgService().getAppVersionCode(Dimina.getConfig().getApp());
        LogUtil.iRelease(TAG, "开始向mmkv中存储 versionCode:" + appVersionCode);
        MMKVUtil.getInstance().save(PmConstant.KEY_NATIVE_APP_VERSION_CODE, Integer.valueOf(appVersionCode));
    }
}
