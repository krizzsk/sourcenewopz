package com.didi.map.global.model;

import android.content.Context;

public class URLHelper {

    /* renamed from: a */
    private static final String f27313a = "https://apimap.liggyglobal.com";

    /* renamed from: b */
    private static final String f27314b = "https://apimap.didiglobal.com";

    /* renamed from: c */
    private static final String f27315c = "com.linkee.global";

    public static boolean isCanoeApp(Context context) {
        return f27315c.equals(m19294a(context));
    }

    /* renamed from: a */
    private static String m19294a(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return null;
        }
        return context.getApplicationContext().getPackageName();
    }

    public static String getUrlHost(Context context) {
        return isCanoeApp(context) ? f27313a : "https://apimap.didiglobal.com";
    }
}
