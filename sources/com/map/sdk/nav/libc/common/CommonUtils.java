package com.map.sdk.nav.libc.common;

import android.content.Context;

public class CommonUtils {
    private static Context mContext;

    public static void setContext(Context context) {
        mContext = context.getApplicationContext();
    }

    public static int dp2pixel(int i) {
        float f;
        Context context = mContext;
        if (context != null) {
            f = ((float) i) * context.getResources().getDisplayMetrics().density;
        } else {
            f = (float) (i * 2);
        }
        return (int) (f + 0.5f);
    }

    public static int getScreenWidth() {
        Context context = mContext;
        if (context != null) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }
        return 0;
    }

    public static int getScreenHeight() {
        Context context = mContext;
        if (context != null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        return 0;
    }
}
