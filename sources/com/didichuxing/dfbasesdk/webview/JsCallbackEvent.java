package com.didichuxing.dfbasesdk.webview;

import com.didichuxing.dfbasesdk.utils.LogUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class JsCallbackEvent {

    /* renamed from: a */
    static final int f46939a = 1000;

    /* renamed from: b */
    static final int f46940b = 1001;

    /* renamed from: c */
    static final int f46941c = 1002;

    /* renamed from: d */
    static final int f46942d = 1003;
    public final String command;

    /* renamed from: e */
    private String f46943e;

    /* renamed from: f */
    private final int f46944f;

    /* renamed from: g */
    private final String f46945g;

    /* renamed from: h */
    private final Map<String, Object> f46946h;

    public JsCallbackEvent(String str) {
        this(str, 1000, "SUCCESS");
    }

    public JsCallbackEvent(String str, int i, String str2) {
        this.command = str;
        this.f46944f = i;
        this.f46945g = str2;
        this.f46946h = new HashMap();
    }

    public JsCallbackEvent append(String str, Object obj) {
        this.f46946h.put(str, obj);
        return this;
    }

    public JsCallbackEvent build() {
        String str = "{}";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", this.f46944f);
            jSONObject.put("message", this.f46945g);
            if (this.f46946h.isEmpty()) {
                jSONObject.put("result", str);
            } else {
                jSONObject.put("result", new JSONObject(this.f46946h));
            }
            str = jSONObject.toString();
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
        this.f46943e = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo115940a() {
        return this.f46943e;
    }
}
