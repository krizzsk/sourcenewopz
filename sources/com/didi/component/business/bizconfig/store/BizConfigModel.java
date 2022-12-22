package com.didi.component.business.bizconfig.store;

import org.json.JSONObject;

public class BizConfigModel {
    public static final String KEY_SERVICE_PHONE = "service_phone";
    public static final String KEY_VERSION = "version";
    public static final String KEY_k2 = "k2";

    /* renamed from: a */
    private String f11170a;

    /* renamed from: b */
    private int f11171b;

    /* renamed from: c */
    private String f11172c;

    /* renamed from: d */
    private String f11173d;

    private BizConfigModel() {
    }

    public static BizConfigModel parseFromJSON(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        BizConfigModel bizConfigModel = new BizConfigModel();
        bizConfigModel.f11170a = str;
        bizConfigModel.f11171b = jSONObject.optInt("version");
        bizConfigModel.f11172c = jSONObject.optString(KEY_SERVICE_PHONE);
        bizConfigModel.f11173d = jSONObject.optString(KEY_k2);
        return bizConfigModel;
    }

    public String toString() {
        return "BizConfigModel{bid='" + this.f11170a + '\'' + ", version=" + this.f11171b + ", servicePhone='" + this.f11172c + '\'' + ", k2='" + this.f11173d + '\'' + '}';
    }

    public String getBid() {
        return this.f11170a;
    }

    public int getVersion() {
        return this.f11171b;
    }

    public String getServicePhone() {
        return this.f11172c;
    }

    public String getK2() {
        return this.f11173d;
    }
}
