package com.didi.hawaii.mapsdkv2.jni;

import android.text.TextUtils;
import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import com.didi.hawaii.log.HWLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public final class ApolloJni {
    private String apolloKey = "";
    private IToggle toggle;

    public ApolloJni(String str) {
        this.toggle = Apollo.getToggle(str);
        this.apolloKey = str;
    }

    public String getString(String str) {
        String str2 = (String) this.toggle.getExperiment().getParam(str, "");
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2;
    }

    public int getInt(String str, int i) {
        Integer num = (Integer) this.toggle.getExperiment().getParam(str, Integer.valueOf(i));
        if (num == null) {
            return i;
        }
        return num.intValue();
    }

    public float getFloat(String str, float f) {
        Float f2 = (Float) this.toggle.getExperiment().getParam(str, Float.valueOf(f));
        if (f2 == null) {
            return f;
        }
        return f2.floatValue();
    }

    public boolean isAllow() {
        boolean allow = this.toggle.allow();
        if (!TextUtils.isEmpty(this.apolloKey)) {
            HWLog.m16761i(GlobalCashierCoreModule.APOLLO, this.apolloKey + "|" + allow);
        }
        return allow;
    }
}
