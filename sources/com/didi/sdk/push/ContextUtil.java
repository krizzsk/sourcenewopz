package com.didi.sdk.push;

import android.content.Context;

class ContextUtil {
    private static Context sApplicationContext;

    ContextUtil() {
    }

    public static void initApplicationContext(Context context) {
        sApplicationContext = context.getApplicationContext();
    }

    public static Context getApplicationContext() {
        return sApplicationContext;
    }
}
