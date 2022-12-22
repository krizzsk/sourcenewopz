package com.didiglobal.enginecore.utils;

import android.content.Context;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class XEngineUtil {
    public static boolean isDebugApp(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int dip2px(Context context, float f) {
        return context == null ? (int) f : (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Set<String> buildRequiredSet(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        return new HashSet(Arrays.asList(strArr));
    }
}
