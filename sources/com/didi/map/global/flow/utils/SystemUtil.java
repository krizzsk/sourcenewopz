package com.didi.map.global.flow.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.core.content.ContextCompat;

public class SystemUtil {
    public static int[] getBatteryLevelAndStatus(Context context) {
        int[] iArr = new int[2];
        Intent intent = null;
        try {
            intent = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
        int intExtra = intent.getIntExtra("status", -1);
        int i = (intExtra == 2 || intExtra == 5) ? 1 : 0;
        iArr[0] = intent.getIntExtra("level", -1);
        iArr[1] = i;
        return iArr;
    }

    public static int checkSystemPermission(Context context, String str) {
        try {
            return ContextCompat.checkSelfPermission(context, str);
        } catch (Exception unused) {
            return -1;
        }
    }
}
