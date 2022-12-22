package com.didichuxing.foundation.util;

import android.content.Context;

public abstract class ApplicationUtil {
    public static boolean isDebuggable(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    private ApplicationUtil() {
    }
}
