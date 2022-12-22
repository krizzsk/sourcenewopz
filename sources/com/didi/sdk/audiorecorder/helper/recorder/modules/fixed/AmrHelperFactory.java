package com.didi.sdk.audiorecorder.helper.recorder.modules.fixed;

import com.didi.sdk.audiorecorder.AmrHelper;
import com.didi.sdk.audiorecorder.utils.LogUtil;

public class AmrHelperFactory {
    public static IAmrHelper create(int i, int i2) {
        FixedAmrHelper fixedAmrHelper;
        boolean z = false;
        boolean z2 = i == 1;
        LogUtil.log("AmrHelperFactory create - need switch:" + z2);
        if (z2) {
            fixedAmrHelper = FixedAmrHelper.tryNewInstance(i2);
            StringBuilder sb = new StringBuilder();
            sb.append("AmrHelperFactory create - switch instance:");
            if (fixedAmrHelper != null) {
                z = true;
            }
            sb.append(z);
            LogUtil.log(sb.toString());
        } else {
            fixedAmrHelper = null;
        }
        return fixedAmrHelper != null ? fixedAmrHelper : new AmrHelper();
    }
}
