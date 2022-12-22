package com.iproov.sdk.bridge;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.iproov.sdk.bridge.if */
/* compiled from: JSDispatchEvent */
public class C19765if implements C19764do {

    /* renamed from: a */
    private final String f53998a;

    /* renamed from: b */
    private final Map<String, Object> f53999b;

    public C19765if(String str, Map<String, Object> map) {
        this.f53998a = str;
        this.f53999b = map;
    }

    /* renamed from: do */
    public String mo161872do() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f53999b != null) {
                jSONObject.put("detail", new JSONObject(this.f53999b));
            }
            return String.format("window.dispatchEvent(new CustomEvent('%s', %s));", new Object[]{"iproov-" + this.f53998a, jSONObject.toString()});
        } catch (JSONException unused) {
            throw new IllegalStateException("Error parsing JSDispatchEvent parameters for type: " + this.f53998a);
        }
    }
}
