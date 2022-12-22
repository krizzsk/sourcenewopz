package com.didi.sdk.util;

import android.text.TextUtils;
import com.didi.soda.web.config.WebConstant;
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

    public static boolean getSettingsSwitch(String str) {
        return ((Integer) getParamByStatus("policy_compatible_switch_release", str, 0)).intValue() == 1;
    }

    public static boolean isShowLockScreen() {
        return ((Integer) getParamByStatus("Lock_Screen", "type", 0)).intValue() == 1;
    }

    public static boolean getDiscountSMSSwitch() {
        return getSettingsSwitch("SMS");
    }

    public static boolean getDiscountPushSwitch() {
        return getSettingsSwitch("Push");
    }

    public static boolean getDiscountEmailSwitch() {
        return getSettingsSwitch(WebConstant.EMAIL_PLATFORM);
    }

    public static boolean getShareLocationSwitch() {
        return getSettingsSwitch("ShareLocation");
    }

    public static boolean isNetOpt() {
        return ((Integer) getParamByStatus("global_passenger_net_opt", "type", -1, true)).intValue() == 1;
    }

    public static boolean isBffMaptypeParamFix() {
        return ((Integer) getParamByStatus("common_online_bugfix_toggle", "bff_param_maptype", 0, true)).intValue() == 0;
    }

    public static boolean rule1Upload(String str) {
        return isEventContained(str, (String) getParamByStatus("global_omega_upload_rules", "rule1_report_event", "", true));
    }

    public static boolean rule2OrderOnce(String str) {
        return isEventContained(str, (String) getParamByStatus("global_omega_upload_rules", "rule2_order_once", "", false));
    }

    public static boolean rule3LifecycleOnce(String str) {
        return isEventContained(str, (String) getParamByStatus("global_omega_upload_rules", "rule3_lifecycle_once", "", false));
    }

    public static boolean rule4NotReport(String str) {
        return isEventContained(str, (String) getParamByStatus("global_omega_upload_rules", "rule0_not_report_event", "", false));
    }

    public static boolean isEventContained(String str, String str2) {
        String[] split;
        if (!TextUtils.isEmpty(str2) && (split = str2.split(",")) != null && split.length > 0) {
            for (String equals : split) {
                if (str.equals(equals)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int getConfRefreshDistance() {
        return ((Integer) getParamByStatus("refresh_product_conf_distance_filter", "mainMenu", 200, true)).intValue();
    }
}
