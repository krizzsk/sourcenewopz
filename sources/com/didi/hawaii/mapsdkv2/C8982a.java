package com.didi.hawaii.mapsdkv2;

import android.text.TextUtils;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.mapsdkv2.core.EngineDynamicConfigProvider;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

/* renamed from: com.didi.hawaii.mapsdkv2.a */
/* compiled from: ApolloDynamicConfigProvider */
final class C8982a implements EngineDynamicConfigProvider {
    C8982a() {
    }

    public EngineDynamicConfigProvider.DynamicConfig getInt(String str, String str2) {
        EngineDynamicConfigProvider.DynamicConfig dynamicConfig = new EngineDynamicConfigProvider.DynamicConfig();
        if (str != null) {
            IToggle toggle = Apollo.getToggle(str);
            if (toggle.allow() && str2 != null) {
                dynamicConfig.allow = true;
                dynamicConfig.intValue = ((Integer) toggle.getExperiment().getParam(str2, 0)).intValue();
            }
        }
        HWLog.m16761i("NativeApollo", "apolloKey=" + str + ", apolloSubKey=" + str2 + ",apolloReturnIntValue=" + dynamicConfig.intValue);
        return dynamicConfig;
    }

    public EngineDynamicConfigProvider.DynamicConfig getString(String str, String str2) {
        EngineDynamicConfigProvider.DynamicConfig dynamicConfig = new EngineDynamicConfigProvider.DynamicConfig();
        if (str != null) {
            IToggle toggle = Apollo.getToggle(str);
            if (toggle.allow() && str2 != null) {
                dynamicConfig.allow = true;
                dynamicConfig.stringValue = (String) toggle.getExperiment().getParam(str2, "");
            }
        }
        HWLog.m16761i("NativeApollo", "apolloKey=" + str + ", apolloSubKey=" + str2 + ",apolloReturnStrValue=" + dynamicConfig.stringValue);
        return dynamicConfig;
    }

    public EngineDynamicConfigProvider.DynamicConfig getStringLength(String str, String str2) {
        EngineDynamicConfigProvider.DynamicConfig dynamicConfig = new EngineDynamicConfigProvider.DynamicConfig();
        if (str != null) {
            IToggle toggle = Apollo.getToggle(str);
            if (toggle.allow() && str2 != null) {
                dynamicConfig.allow = true;
                String str3 = (String) toggle.getExperiment().getParam(str2, "");
                dynamicConfig.intValue = TextUtils.isEmpty(str3) ? 0 : str3.length();
            }
        }
        return dynamicConfig;
    }
}
