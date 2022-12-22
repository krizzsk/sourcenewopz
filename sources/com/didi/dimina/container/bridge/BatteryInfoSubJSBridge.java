package com.didi.dimina.container.bridge;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import org.json.JSONObject;

public class BatteryInfoSubJSBridge {

    /* renamed from: a */
    private final Activity f16558a;

    BatteryInfoSubJSBridge(Activity activity) {
        this.f16558a = activity;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo54139a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        try {
            CallBackUtil.onSuccess(m12177a(), callbackFunction);
        } catch (Exception e) {
            e.printStackTrace();
            CallBackUtil.onFail("batteryInfo 加载失败" + e.getMessage(), callbackFunction);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public JSONObject mo54140b(JSONObject jSONObject, CallbackFunction callbackFunction) {
        try {
            return m12177a();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private JSONObject m12177a() {
        JSONObject jSONObject = new JSONObject();
        Intent intent = null;
        try {
            intent = this.f16558a.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
        String b = m12179b(intent);
        boolean a = m12178a(intent);
        JSONUtil.put(jSONObject, "batteryLevel", (Object) b);
        JSONUtil.put(jSONObject, "isCharging", a);
        return jSONObject;
    }

    /* renamed from: a */
    private boolean m12178a(Intent intent) {
        int intExtra = intent.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    /* renamed from: b */
    private String m12179b(Intent intent) {
        return Dimina.getConfig().getAdapterConfig().getWsgService().getBatteryLevel(this.f16558a.getApplicationContext());
    }
}
