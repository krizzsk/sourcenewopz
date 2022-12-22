package com.didi.sdk.security;

import android.content.Context;
import com.didi.sdk.util.SystemUtil;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;

public class SecurityLib {
    public static native String getDeviceId(Context context);

    static {
        try {
            System.loadLibrary(ErrorConst.ModuleName.SECURITY);
        } catch (Throwable unused) {
        }
    }

    public static String getImei(Context context) {
        return SystemUtil.getIMEI();
    }

    public static String currentTime() {
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis + "";
    }
}
