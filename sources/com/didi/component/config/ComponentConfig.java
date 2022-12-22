package com.didi.component.config;

import android.text.TextUtils;
import com.didi.sdk.app.DIDIApplication;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentConfig {

    /* renamed from: f */
    private static final String f12576f = "cid";

    /* renamed from: g */
    private static final String f12577g = "cname";

    /* renamed from: h */
    private static final String f12578h = "open";

    /* renamed from: i */
    private static final String f12579i = "desc";

    /* renamed from: j */
    private static final String f12580j = "params";

    /* renamed from: a */
    boolean f12581a;

    /* renamed from: b */
    String f12582b;

    /* renamed from: c */
    String f12583c;

    /* renamed from: d */
    String f12584d;
    @Deprecated

    /* renamed from: e */
    String f12585e;

    public String type() {
        return this.f12584d;
    }

    @Deprecated
    public String name() {
        return this.f12585e;
    }

    public boolean open() {
        return this.f12581a;
    }

    public String desc() {
        return this.f12582b;
    }

    public String params() {
        return this.f12583c;
    }

    public boolean valid() {
        return !TextUtils.isEmpty(this.f12584d);
    }

    public String toString() {
        return "{ " + "cid" + ":" + this.f12584d + ", " + f12577g + ":" + this.f12585e + ", " + "open" + ":" + this.f12581a + ", " + f12579i + ":" + this.f12582b + ", " + "params" + ":" + this.f12583c + "}";
    }

    /* renamed from: a */
    static ComponentConfig m8567a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || !jSONObject.has("cid")) {
            return null;
        }
        int optInt = jSONObject.optInt("cid");
        if (optInt > 0) {
            ComponentConfig componentConfig = new ComponentConfig();
            componentConfig.f12584d = ReflectIds.get(DIDIApplication.getAppContext().getApplicationContext()).type(optInt);
            boolean z = true;
            if (jSONObject.optInt("open") != 1) {
                z = false;
            }
            componentConfig.f12581a = z;
            componentConfig.f12582b = jSONObject.optString(f12579i, (String) null);
            componentConfig.f12583c = jSONObject.optString("params", (String) null);
            return componentConfig;
        }
        throw new JSONException("unknown component cid: " + optInt);
    }
}
