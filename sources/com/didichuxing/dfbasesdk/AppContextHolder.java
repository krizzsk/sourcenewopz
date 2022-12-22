package com.didichuxing.dfbasesdk;

import android.content.Context;

public class AppContextHolder {

    /* renamed from: a */
    private static Context f46467a;

    public static void init(Context context) {
        f46467a = context.getApplicationContext();
    }

    public static Context getAppContext() {
        return f46467a;
    }
}
