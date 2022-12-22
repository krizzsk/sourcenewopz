package com.didiglobal.privacysdk.util;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class GlobalApolloUtils {
    public static <T> T getParamByStatus(String str, String str2, T t) {
        return getStatus(str) ? getParam(str, str2, t) : t;
    }

    public static <T> T getParamByStatus(String str, String str2, T t, boolean z) {
        if (z) {
            T valueFromCache = ApolloCache.getValueFromCache(str, str2);
            if (valueFromCache != null) {
                return valueFromCache;
            }
            if (getStatus(str)) {
                T param = getParam(str, str2, t);
                ApolloCache.putValueToCache(str, str2, param);
                return param;
            }
            ApolloCache.putValueToCache(str, str2, t);
        } else if (getStatus(str)) {
            return getParam(str, str2, t);
        }
        return t;
    }

    public static <T> T getParam(String str, String str2, T t) {
        try {
            return Apollo.getToggle(str).getExperiment().getParam(str2, t);
        } catch (Exception unused) {
            return t;
        }
    }

    public static boolean getStatus(String str) {
        return getStatus(str, false);
    }

    public static boolean getStatus(String str, boolean z) {
        try {
            IToggle toggle = Apollo.getToggle(str, z);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception unused) {
        }
        return z;
    }

    public static boolean getSettingsSwitch(String str, boolean z) {
        return ((Integer) getParamByStatus("ibt_privacy", str, Integer.valueOf(z ? 1 : 0))).intValue() == 1;
    }

    public static boolean getDiscountSMSSwitch(boolean z) {
        return getSettingsSwitch("switch_sms", z);
    }

    public static boolean getDiscountPushSwitch(boolean z) {
        return getSettingsSwitch("switch_push", z);
    }

    public static boolean getDiscountEmailSwitch(boolean z) {
        return getSettingsSwitch("switch_email", z);
    }

    public static boolean getShareLocationSwitch(boolean z) {
        return getSettingsSwitch("switch_location_sharing", z);
    }

    public static boolean getDownloadDataSwitch(boolean z) {
        return getSettingsSwitch("switch_download_data", z);
    }

    public static boolean getSystemPermissionsSwitch(boolean z) {
        return getSettingsSwitch("switch_system_permissions", z);
    }

    public static boolean getDeleteAccountSwitch(boolean z) {
        return getSettingsSwitch("switch_del_account", z);
    }
}
