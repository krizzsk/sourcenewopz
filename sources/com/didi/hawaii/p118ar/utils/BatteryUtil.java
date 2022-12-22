package com.didi.hawaii.p118ar.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.didi.hawaii.mapsdk.gesture.NNGestureClassfy;

/* renamed from: com.didi.hawaii.ar.utils.BatteryUtil */
public class BatteryUtil {

    /* renamed from: a */
    private static Context f23303a = null;

    /* renamed from: b */
    private static BatteryStateReceiver f23304b = new BatteryStateReceiver();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static BatteryChangeListener f23305c = null;
    public static float curBatteryPcn = 100.0f;

    /* renamed from: d */
    private static boolean f23306d = false;

    /* renamed from: com.didi.hawaii.ar.utils.BatteryUtil$BatteryChangeListener */
    public interface BatteryChangeListener {
        void onBatteryChange(float f);
    }

    public static void init(Context context) {
        if (f23303a == null && context != null) {
            f23303a = context.getApplicationContext();
            m16709b();
        }
    }

    /* renamed from: com.didi.hawaii.ar.utils.BatteryUtil$BatteryStateReceiver */
    static class BatteryStateReceiver extends BroadcastReceiver {
        BatteryStateReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            BatteryUtil.m16710b(intent);
            if (BatteryUtil.f23305c != null) {
                BatteryUtil.f23305c.onBatteryChange(BatteryUtil.curBatteryPcn);
            }
        }
    }

    public static float getCurBatteryPcn(Context context) {
        if (context == null) {
            return -1.0f;
        }
        Intent intent = null;
        try {
            intent = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
        if (intent == null) {
            return -1.0f;
        }
        return (((float) intent.getIntExtra("level", -1)) / ((float) intent.getIntExtra(NNGestureClassfy.SCALE_LABLE, -1))) * 100.0f;
    }

    public static boolean isCharging(Context context) {
        Intent intent = null;
        try {
            intent = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
        if (intent == null || intent.getIntExtra("plugged", -1) == 0) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private static void m16709b() {
        if (f23303a != null) {
            Intent intent = null;
            try {
                intent = f23303a.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
            m16710b(intent);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m16710b(Intent intent) {
        if (intent != null) {
            curBatteryPcn = (((float) intent.getIntExtra("level", -1)) / ((float) intent.getIntExtra(NNGestureClassfy.SCALE_LABLE, -1))) * 100.0f;
        }
    }

    public static void startListenBatteryState(BatteryChangeListener batteryChangeListener) {
        if (f23303a != null) {
            try {
                f23303a.registerReceiver(f23304b, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
            f23305c = batteryChangeListener;
            f23306d = true;
        }
    }

    public static void stopListenBatteryState() {
        Context context = f23303a;
        if (context != null && f23306d) {
            try {
                context.unregisterReceiver(f23304b);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            f23306d = false;
            f23305c = null;
        }
    }
}
