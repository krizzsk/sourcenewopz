package com.didichuxing.mas.sdk.quality.report.safe;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.didichuxing.mas.sdk.quality.report.analysis.AnalysisDelegater;
import com.didichuxing.mas.sdk.quality.report.analysis.Tracker;
import com.didichuxing.mas.sdk.quality.report.backend.BatteryChangeReceiver;
import com.didichuxing.mas.sdk.quality.report.collector.NetworkCollector;
import com.didichuxing.mas.sdk.quality.report.record.Event;

public class SafetyMenuPowerSDK {
    private static IntentFilter intentFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    private static SafetyPhoneReceiver phoneReceiver;

    public static void registerPhoneReceiver(Context context) {
        if (context != null) {
            if (phoneReceiver == null) {
                phoneReceiver = new SafetyPhoneReceiver();
            }
            try {
                context.registerReceiver(phoneReceiver, intentFilter);
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
        }
    }

    public static void unregisterPhoneReceiver(Context context) {
        SafetyPhoneReceiver safetyPhoneReceiver;
        if (context != null && (safetyPhoneReceiver = phoneReceiver) != null) {
            try {
                context.unregisterReceiver(safetyPhoneReceiver);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
        }
    }

    public static class SafetyPhoneReceiver extends BroadcastReceiver {
        final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
        final String SYSTEM_DIALOG_REASON_KEY = "reason";
        final String SYSTEM_DIALOG_REASON_POWER_KEY = "globalactions";
        final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";
        private long lastReceiveTime;

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction()) && System.currentTimeMillis() - this.lastReceiveTime > 200) {
                this.lastReceiveTime = System.currentTimeMillis();
                String stringExtra = intent.getStringExtra("reason");
                if (stringExtra == null) {
                    return;
                }
                if (stringExtra.equalsIgnoreCase("globalactions")) {
                    SafetyMenuPowerSDK.trackPhoneEvent("OMGSafeLongPressedPower");
                } else if (!stringExtra.equals("homekey") && stringExtra.equals("recentapps")) {
                    SafetyMenuPowerSDK.trackPhoneEvent("OMGSafeClickMenu");
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static void trackPhoneEvent(String str) {
        Event event = new Event(str);
        event.putAttr("bi", Integer.valueOf(BatteryChangeReceiver.getBatteryPercent()));
        event.putAttr("sig", Integer.valueOf(NetworkCollector.getNetWorkStrength()));
        event.putAttr("carrier", NetworkCollector.getNetworkOperatorType());
        event.putAttr("nt", NetworkCollector.getNetworkType());
        event.putAttr("bs", Integer.valueOf(BatteryChangeReceiver.getBatteryIsCharging() ? 1 : 0));
        event.putAttr("isAppFront", Boolean.valueOf(AnalysisDelegater.isAppAtFront()));
        Tracker.trackRealtimeEvent(event);
    }
}
