package com.iproov.sdk.core;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import org.json.JSONObject;

/* renamed from: com.iproov.sdk.core.for */
/* compiled from: CaptureResult */
public final class C19887for {

    /* renamed from: a */
    private String f54255a = "";

    /* renamed from: b */
    private String f54256b;

    /* renamed from: c */
    private String f54257c;

    /* renamed from: d */
    private String f54258d = "";

    public C19887for(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f54255a = jSONObject.optString("result", "");
            this.f54256b = jSONObject.optString("reason", (String) null);
            this.f54257c = jSONObject.optString("feedback_code", (String) null);
            this.f54258d = jSONObject.optString("token", "");
        }
    }

    /* renamed from: do */
    public String mo162086do() {
        return this.f54257c;
    }

    /* renamed from: for  reason: not valid java name */
    public boolean m47519for() {
        String str = this.f54257c;
        return str != null && (str.equalsIgnoreCase("network_problem") || this.f54257c.equalsIgnoreCase("user_timeout"));
    }

    /* renamed from: if */
    public String mo162089if() {
        return this.f54258d;
    }

    /* renamed from: new  reason: not valid java name */
    public boolean m47520new() {
        return this.f54255a.equals("Passed");
    }

    /* renamed from: do */
    public String mo162087do(Context context) {
        if (this.f54257c == null) {
            return this.f54256b;
        }
        String str = m39099do(context, "iproov__failure_" + this.f54257c);
        return str == null ? this.f54256b : str;
    }

    /* renamed from: do */
    public static String m39099do(Context context, String str) {
        int identifier = context.getResources().getIdentifier(str, TypedValues.Custom.S_STRING, context.getApplicationContext().getPackageName());
        if (identifier == 0) {
            return null;
        }
        return context.getString(identifier);
    }
}
