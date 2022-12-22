package com.didichuxing.xpanel.util;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class XPanelApolloUtil {
    public static boolean getStatus(String str) {
        return getStatus(str, false);
    }

    public static boolean getStatus(String str, boolean z) {
        try {
            IToggle toggle = Apollo.getToggle(str);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z;
    }

    public static boolean getApolloExperimentBoolean(String str, String str2, int i, int i2) {
        try {
            IToggle toggle = Apollo.getToggle(str);
            if (toggle == null || !toggle.allow() || ((Integer) toggle.getExperiment().getParam(str2, Integer.valueOf(i))).intValue() != i2) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getApolloExperimentValue(String str, String str2, String str3) {
        try {
            IToggle toggle = Apollo.getToggle(str);
            if (toggle != null && toggle.allow()) {
                return (String) toggle.getExperiment().getParam(str2, str3);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static <T> T getApolloExperimentParam(String str, String str2, T t) {
        try {
            return Apollo.getToggle(str).getExperiment().getParam(str2, t);
        } catch (Exception unused) {
            return t;
        }
    }

    public static int getApolloExperimentValue(String str, String str2, int i) {
        try {
            IToggle toggle = Apollo.getToggle(str);
            if (toggle != null && toggle.allow()) {
                return ((Integer) toggle.getExperiment().getParam(str2, Integer.valueOf(i))).intValue();
            }
        } catch (Exception unused) {
        }
        return i;
    }

    public static boolean isXPanelOmegaEnable() {
        try {
            int apolloExperimentValue = getApolloExperimentValue("xpanel_analytics_sampling", "newXpanel_fcload_sw", 0);
            return (apolloExperimentValue == 1 || apolloExperimentValue == 2) ? false : true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isXPanelMixOrderEnabled() {
        return getStatus("xpanel_mixed_order");
    }

    public static boolean isXPanelXCardV2Enabled() {
        return getStatus("global_xpanel_xcardV2_on");
    }

    public static boolean isXPanelCdnEnabled() {
        return getStatus("global_xpanel_cdn_enable");
    }

    public static boolean isXPanelWeexEnabled() {
        return getStatus("xpanel_weex_enable");
    }

    public static int getXPanelCdnTimeout() {
        return getApolloExperimentValue("global_xpanel_android_cdn_config", "timeout", 5000);
    }

    public static boolean isXPanelXdbgEnable() {
        return getStatus("global_xpanel_xdbg_on");
    }

    public static int getUseBffEnabled() {
        return getApolloExperimentValue("global_xpanel_sort_bff", "useBFF", 0);
    }

    public static boolean isGenericKitEnable() {
        return getStatus("global_xpanel_genericKit");
    }

    public static boolean isGenericKitDebugEnable() {
        return getStatus("global_xpanel_genericKit_debug");
    }
}
