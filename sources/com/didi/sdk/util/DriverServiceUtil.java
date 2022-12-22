package com.didi.sdk.util;

import android.text.TextUtils;
import java.util.HashMap;

public class DriverServiceUtil {
    public static final String SID_DRIVER_SERVICE = "driver-service";

    public static final HashMap<String, Object> getExtraMap(String str) {
        if (TextUtils.equals(str, SID_DRIVER_SERVICE)) {
            return new HashMap<>();
        }
        return null;
    }
}
