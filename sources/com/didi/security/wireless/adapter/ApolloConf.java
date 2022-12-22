package com.didi.security.wireless.adapter;

import com.didi.security.wireless.ISecurityConf;
import com.didichuxing.apollo.sdk.Apollo;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApolloConf implements ISecurityConf {

    /* renamed from: a */
    private static final String f38584a = "wsg_sdk_config";

    /* renamed from: b */
    private static final String f38585b = "wsg_sensor_data";

    /* renamed from: c */
    private static final String f38586c = "wsg_priority_switch";

    /* renamed from: d */
    private static final String f38587d = "on";

    /* renamed from: e */
    private static final String f38588e = "capacity";

    /* renamed from: f */
    private static final String f38589f = "expire";

    /* renamed from: g */
    private static final String f38590g = "cache";

    /* renamed from: h */
    private static final String f38591h = "touch";

    /* renamed from: i */
    private static final String f38592i = "denyEvent";

    /* renamed from: j */
    private static final int f38593j = 128;

    /* renamed from: k */
    private static final long f38594k = 60000;

    /* renamed from: l */
    private static final int f38595l = 512;

    /* renamed from: m */
    private ArrayList<String> f38596m;

    /* renamed from: n */
    private JSONObject f38597n;

    /* renamed from: o */
    private JSONObject f38598o;

    /* renamed from: p */
    private HashMap<String, String> f38599p;

    public void addConfig(String str, String str2) {
    }

    /* renamed from: a */
    private void m27336a() {
        String str = (String) Apollo.getToggle(f38584a).getExperiment().getParam("cache", "");
        if (str != null) {
            try {
                this.f38598o = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
    }

    /* renamed from: b */
    private void m27337b() {
        String str = (String) Apollo.getToggle(f38584a).getExperiment().getParam("touch", "");
        if (str != null) {
            try {
                this.f38597n = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
    }

    /* renamed from: c */
    private void m27338c() {
        if (this.f38599p == null) {
            this.f38599p = new HashMap<>();
        }
        if (Apollo.getToggle(f38585b, false).allow()) {
            this.f38599p.put(ISecurityConf.KEY_SENSOR, "allow");
        }
    }

    public boolean isCacheOn() {
        if (this.f38598o == null) {
            m27336a();
        }
        JSONObject jSONObject = this.f38598o;
        if (jSONObject != null) {
            return jSONObject.optBoolean("on", false);
        }
        return false;
    }

    public int cacheCapacity() {
        if (this.f38598o == null) {
            m27336a();
        }
        JSONObject jSONObject = this.f38598o;
        if (jSONObject != null) {
            return jSONObject.optInt(f38588e, 128);
        }
        return 128;
    }

    public long cacheExpire() {
        if (this.f38598o == null) {
            m27336a();
        }
        JSONObject jSONObject = this.f38598o;
        if (jSONObject != null) {
            return jSONObject.optLong("expire", 60000);
        }
        return 60000;
    }

    public boolean isTouchOn() {
        if (this.f38597n == null) {
            m27337b();
        }
        JSONObject jSONObject = this.f38597n;
        if (jSONObject != null) {
            return jSONObject.optBoolean("on", false);
        }
        return false;
    }

    public int touchCapacity() {
        if (this.f38597n == null) {
            m27337b();
        }
        JSONObject jSONObject = this.f38597n;
        if (jSONObject != null) {
            return jSONObject.optInt(f38588e, 512);
        }
        return 512;
    }

    public boolean isAllow(String str) {
        if (this.f38596m == null) {
            try {
                String str2 = (String) Apollo.getToggle(f38584a).getExperiment().getParam(f38592i, "");
                if (str2 != null) {
                    JSONArray jSONArray = new JSONArray(str2);
                    this.f38596m = new ArrayList<>(jSONArray.length());
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.f38596m.add(jSONArray.getString(i));
                    }
                }
            } catch (JSONException unused) {
            }
        }
        ArrayList<String> arrayList = this.f38596m;
        if (arrayList == null || !arrayList.contains(str)) {
            return true;
        }
        return false;
    }

    public boolean isPriorityOn() {
        return Apollo.getToggle(f38586c, false).allow();
    }

    public String getConfig(String str) {
        if (this.f38599p == null) {
            m27338c();
        }
        return this.f38599p.get(str);
    }
}
