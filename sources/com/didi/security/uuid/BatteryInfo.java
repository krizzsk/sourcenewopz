package com.didi.security.uuid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.didi.hawaii.mapsdk.gesture.NNGestureClassfy;
import com.facebook.appevents.integrity.IntegrityManager;
import org.json.JSONException;
import org.json.JSONObject;

public class BatteryInfo {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f38520a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Object f38521b = new Object();

    /* renamed from: c */
    private BroadcastReceiver f38522c = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            JSONObject jSONObject = new JSONObject();
            boolean z = false;
            int intExtra = intent.getIntExtra(NNGestureClassfy.SCALE_LABLE, 0);
            int intExtra2 = intent.getIntExtra("level", 0);
            int intExtra3 = intent.getIntExtra("status", 0);
            int intExtra4 = intent.getIntExtra("temperature", 0);
            int intExtra5 = intent.getIntExtra("voltage", 0);
            int intExtra6 = intent.getIntExtra(IntegrityManager.INTEGRITY_TYPE_HEALTH, 0);
            boolean booleanExtra = intent.getBooleanExtra("present", false);
            if (intExtra3 == 2 || intExtra3 == 5) {
                z = true;
            }
            String stringExtra = intent.getStringExtra("technology");
            try {
                jSONObject.put(NNGestureClassfy.SCALE_LABLE, intExtra);
                jSONObject.put("level", intExtra2);
                jSONObject.put("status", intExtra3);
                jSONObject.put("temperature", intExtra4);
                jSONObject.put("voltage", intExtra5);
                jSONObject.put("ischarging", z);
                jSONObject.put(IntegrityManager.INTEGRITY_TYPE_HEALTH, intExtra6);
                jSONObject.put("present", booleanExtra);
                jSONObject.put("tech", stringExtra);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String unused = BatteryInfo.this.f38520a = jSONObject.toString();
            synchronized (BatteryInfo.this.f38521b) {
                BatteryInfo.this.f38521b.notifyAll();
            }
        }
    };

    public String getBatteryInfo(Context context) {
        if (context == null) {
            return null;
        }
        try {
            context.registerReceiver(this.f38522c, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
        synchronized (this.f38521b) {
            try {
                this.f38521b.wait(2000);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        try {
            context.unregisterReceiver(this.f38522c);
        } catch (Exception e3) {
            Log.d("Context", "unregisterReceiver", e3);
        }
        this.f38520a = null;
        return this.f38520a;
    }
}
