package com.didiglobal.privacy.disclosure;

import android.content.Context;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import java.util.Map;

public class DisclosureApolloUtils {
    /* renamed from: a */
    static boolean m36288a(Context context, IPrivacyType iPrivacyType) {
        Map<String, Boolean> privacyTypeIdApolloEnableDefautValue = PrivacyDisclosureManager.getInitParam().getPrivacyTypeIdApolloEnableDefautValue();
        boolean z = true;
        if (((Integer) getParamByStatus("privacy_disclosure", iPrivacyType.getTypeId(), Integer.valueOf(privacyTypeIdApolloEnableDefautValue.containsKey(iPrivacyType.getTypeId()) ? privacyTypeIdApolloEnableDefautValue.get(iPrivacyType.getTypeId()).booleanValue() : true ? 1 : 0))).intValue() != 1) {
            z = false;
        }
        DisclosureSpUtils.m36298b(context, iPrivacyType, z);
        return z;
    }

    /* renamed from: a */
    static int m36287a(Context context) {
        int intValue = ((Integer) getParamByStatus("privacy_disclosure_most_times", "most_disclosure_times", Integer.valueOf(PrivacyDisclosureManager.getInitParam().getMostDisclosureTimesApolloDefaultValue()))).intValue();
        DisclosureSpUtils.m36291a(context, intValue);
        return intValue;
    }

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
}
