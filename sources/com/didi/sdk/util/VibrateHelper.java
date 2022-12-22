package com.didi.sdk.util;

import android.content.Context;
import android.os.Vibrator;

public class VibrateHelper {
    public static void vibrate(Context context, long j) {
        ((Vibrator) context.getSystemService("vibrator")).vibrate(j);
    }

    public static void vibrate(Context context, long[] jArr, int i) {
        ((Vibrator) context.getSystemService("vibrator")).vibrate(jArr, i);
    }

    public static void virateCancle(Context context) {
        ((Vibrator) context.getSystemService("vibrator")).cancel();
    }
}
