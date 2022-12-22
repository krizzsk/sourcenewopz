package com.didi.dimina.webview.jsbridge;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InvokeMessage {
    public static final String INVOKE_FROM_ANCIENT = "ancient";
    public static final String INVOKE_FROM_FUSION = "fusion";
    public static final String INVOKE_FROM_PREVIOUS = "previous";
    public static final String KEY_ARGS = "arguments";
    public static final String KEY_FUNCTION_NAME = "method";
    public static final String KEY_NAMESPACE = "module";

    /* renamed from: a */
    private String f18277a;

    /* renamed from: b */
    private String f18278b;

    /* renamed from: c */
    private String f18279c;

    /* renamed from: d */
    private String f18280d;

    /* renamed from: e */
    private String f18281e;

    /* renamed from: f */
    private String f18282f;

    /* renamed from: g */
    private String f18283g;

    public void setTraceId(String str) {
        this.f18277a = str;
    }

    public String getTraceId() {
        return this.f18277a;
    }

    public void setModuleName(String str) {
        this.f18278b = str;
    }

    public String getModuleName() {
        return this.f18278b;
    }

    public void setFunctionName(String str) {
        this.f18279c = str;
    }

    public String getFunctionName() {
        return this.f18279c;
    }

    public void setArgs(String str) {
        this.f18280d = str;
    }

    public void setOrgProtocol(String str) {
        this.f18283g = str;
    }

    public String getOrgProtocol() {
        return this.f18283g;
    }

    public Object[] getArgsForNative() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(this.f18280d);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                Object obj = jSONArray.get(i);
                if (obj == JSONObject.NULL) {
                    arrayList.add((Object) null);
                } else {
                    arrayList.add(obj);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList.toArray();
    }

    public String getArgs() {
        return this.f18280d;
    }

    public void setInvokeFrom(String str) {
        this.f18281e = str;
    }

    public String getInvokeFrom() {
        return this.f18281e;
    }

    public void setPreviousCallId(String str) {
        this.f18282f = str;
    }

    public String getPreviousCallId() {
        return this.f18282f;
    }

    public String toString() {
        return "module:" + this.f18278b + "\nfunctionName:" + this.f18279c + "\nargs:" + this.f18280d + "\ninvokeFrom:" + this.f18281e + "\norgProtocol:" + this.f18283g;
    }
}
