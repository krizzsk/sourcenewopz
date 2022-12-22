package com.didi.onehybrid.jsbridge;

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
    private String f29615a;

    /* renamed from: b */
    private String f29616b;

    /* renamed from: c */
    private String f29617c;

    /* renamed from: d */
    private String f29618d;

    /* renamed from: e */
    private String f29619e;

    /* renamed from: f */
    private String f29620f;

    /* renamed from: g */
    private String f29621g;

    public void setTraceId(String str) {
        this.f29615a = str;
    }

    public String getTraceId() {
        return this.f29615a;
    }

    public void setModuleName(String str) {
        this.f29616b = str;
    }

    public String getModuleName() {
        return this.f29616b;
    }

    public void setFunctionName(String str) {
        this.f29617c = str;
    }

    public String getFunctionName() {
        return this.f29617c;
    }

    public void setArgs(String str) {
        this.f29618d = str;
    }

    public void setOrgProtocol(String str) {
        this.f29621g = str;
    }

    public String getOrgProtocol() {
        return this.f29621g;
    }

    public Object[] getArgsForNative() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(this.f29618d);
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
        return this.f29618d;
    }

    public void setInvokeFrom(String str) {
        this.f29619e = str;
    }

    public String getInvokeFrom() {
        return this.f29619e;
    }

    public void setPreviousCallId(String str) {
        this.f29620f = str;
    }

    public String getPreviousCallId() {
        return this.f29620f;
    }

    public String toString() {
        return "module:" + this.f29616b + "\n" + "functionName:" + this.f29617c + "\n" + "args:" + this.f29618d + "\n" + "invokeFrom:" + this.f29619e + "\n" + "orgProtocol:" + this.f29621g;
    }
}
