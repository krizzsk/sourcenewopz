package com.didi.netwitch;

import android.text.TextUtils;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public abstract class NetSwitch {

    /* renamed from: a */
    private static final String f29086a = "https_open_driver";

    private NetSwitch() {
    }

    public static String getNetworkScheme() {
        IToggle toggle = Apollo.getToggle(f29086a, false);
        return (toggle == null || !toggle.allow()) ? "http" : "https";
    }

    public static String from(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf(HWMapConstant.HTTP.SEPARATOR);
            if (indexOf >= 0) {
                return String.format("%s://%s", new Object[]{getNetworkScheme(), str.substring(indexOf + 3)});
            }
            return String.format("%s://%s", new Object[]{getNetworkScheme(), str});
        }
        throw new IllegalArgumentException("url is empty");
    }
}
