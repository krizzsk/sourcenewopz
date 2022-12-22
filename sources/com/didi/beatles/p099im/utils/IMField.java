package com.didi.beatles.p099im.utils;

import android.content.Context;
import android.util.Log;

/* renamed from: com.didi.beatles.im.utils.IMField */
public class IMField {
    public static final boolean DEBUG = Log.isLoggable(TAG, 3);
    public static final String TAG = "BTS_IM";

    public static void init(Context context) {
    }

    public static String getTag(String str) {
        return "BTS_IM-" + str;
    }
}
