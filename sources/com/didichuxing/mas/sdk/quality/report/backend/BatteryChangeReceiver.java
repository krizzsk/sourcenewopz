package com.didichuxing.mas.sdk.quality.report.backend;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.didi.hawaii.mapsdk.gesture.NNGestureClassfy;
import com.didichuxing.mas.sdk.quality.report.safe.SafetyManager;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;

public class BatteryChangeReceiver extends BroadcastReceiver {
    private static boolean batteryIsCharging = false;
    private static int batteryPercent;
    private static BatteryChangeReceiver mReceiver;

    public static void init(Context context) {
        mReceiver = new BatteryChangeReceiver();
        try {
            context.registerReceiver(mReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    public static int getBatteryPercent() {
        return batteryPercent;
    }

    public static boolean getBatteryIsCharging() {
        return batteryIsCharging;
    }

    public void onReceive(Context context, Intent intent) {
        boolean z = false;
        try {
            int intExtra = intent.getIntExtra("level", 0);
            int intExtra2 = intent.getIntExtra(NNGestureClassfy.SCALE_LABLE, 100);
            if (intExtra2 > 0) {
                batteryPercent = (intExtra * 100) / intExtra2;
            }
            int intExtra3 = intent.getIntExtra("status", -1);
            if (intExtra3 == 2 || intExtra3 == 5) {
                z = true;
            }
            batteryIsCharging = z;
            SafetyManager.trackBatteryEvent(z, batteryPercent);
        } catch (Throwable unused) {
            OLog.m34424w("BatteryChangeReceiver.onReceive fail!");
        }
    }
}
