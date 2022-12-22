package com.didichuxing.mas.sdk.quality.report.collector;

import android.content.Context;
import android.util.DisplayMetrics;

public class ScreenCollector {
    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    public static String getScreenSize() {
        int i;
        int i2 = 0;
        try {
            DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
            i = displayMetrics.widthPixels;
            try {
                i2 = displayMetrics.heightPixels;
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            i = 0;
        }
        return i + "x" + i2;
    }
}
