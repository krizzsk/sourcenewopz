package com.didi.onehybrid.jsbridge;

import com.didi.onehybrid.devmode.FusionRuntimeInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class PreviousCallbackToJS implements CallbackFunction {
    public static final String FUSION_PACKAGED = "fusion_packaged";
    public static final String FUSION_RESULT = "result";

    /* renamed from: a */
    private static final String f29622a = "javascript:%s(%s);";

    /* renamed from: b */
    private WebViewJavascriptBridge f29623b;

    /* renamed from: c */
    private String f29624c;

    /* renamed from: d */
    private String f29625d;

    /* renamed from: e */
    private FusionRuntimeInfo f29626e;

    /* renamed from: f */
    private String f29627f;

    public PreviousCallbackToJS(WebViewJavascriptBridge webViewJavascriptBridge, String str, String str2, String str3) {
        this.f29623b = webViewJavascriptBridge;
        this.f29624c = str;
        this.f29625d = str2;
        this.f29627f = str3;
        this.f29626e = webViewJavascriptBridge.getFusionRuntimeInfo();
    }

    public void onCallBack(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            JSONObject jSONObject = objArr[0];
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("id", this.f29624c);
                jSONObject2.put("errno", 0);
                jSONObject2.put("errmsg", "");
                if (jSONObject instanceof JSONObject ? jSONObject.optBoolean("fusion_packaged") : false) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("result");
                    if (optJSONObject != null) {
                        jSONObject2.put("result", optJSONObject);
                    }
                } else {
                    jSONObject2.put("result", jSONObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String format = String.format(f29622a, new Object[]{this.f29625d, jSONObject2.toString()});
            this.f29623b.executeCallJS(format);
            this.f29626e.recordBridgeCallback(this.f29627f, format);
        }
    }
}
