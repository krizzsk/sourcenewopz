package com.didi.safetoolkit.util;

import android.content.Context;

public class SfContextHelper {

    /* renamed from: a */
    private static Context f34534a;

    public static void setContext(Context context) {
        f34534a = context.getApplicationContext();
    }

    public static Context getContext() {
        return f34534a;
    }
}
