package com.didi.usercenter.util;

import com.didi.sdk.bff.BffConstants;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class ApolloUtil {
    public static boolean isBffStageThird() {
        return getStatus(BffConstants.Apollo.BFF_STAGE_THIRD, false);
    }

    /* renamed from: a */
    private static <T> T m32418a(String str, String str2, T t) {
        return getStatus(str) ? getParam(str, str2, t) : t;
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

    public static void addToTotalSample(String str) {
        try {
            Apollo.getToggle(str, false);
        } catch (Exception unused) {
        }
    }

    public static <T> T getParam(String str, String str2, T t) {
        try {
            return Apollo.getToggle(str).getExperiment().getParam(str2, t);
        } catch (Exception unused) {
            return t;
        }
    }
}
