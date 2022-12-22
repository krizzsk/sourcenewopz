package com.didi.onehybrid.adapter;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.didi.onehybrid.container.FusionWebView;
import com.didi.onehybrid.jsbridge.InvokeMessage;
import com.didi.onehybrid.jsbridge.WebViewJavascriptBridge;
import com.didi.onehybrid.util.C10393Util;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OldJavascriptBridgeAdapter {

    /* renamed from: a */
    private static final String f29506a = "DidiBridgeAdapter";

    /* renamed from: b */
    private static final String f29507b = "{\"code\": %d, \"result\": %s}";

    /* renamed from: c */
    private static final String f29508c = "didi.bridge._callback";

    /* renamed from: d */
    private WebViewJavascriptBridge f29509d;

    public OldJavascriptBridgeAdapter(FusionWebView fusionWebView) {
        this.f29509d = fusionWebView.getJavascriptBridge();
    }

    public boolean matchPreviousBridgeProtocol(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.has("cmd") && jSONObject.has("id");
    }

    public String handleInvokeFromAncientJS(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return m20784a(500, "call data empty");
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            String string = jSONObject2.getString("method");
            JSONArray jSONArray = jSONObject2.getJSONArray("types");
            JSONArray jSONArray2 = jSONObject2.getJSONArray("args");
            if (jSONArray.length() == 1) {
                jSONArray.put("object");
                jSONArray2.put(new JSONObject());
            }
            if (jSONArray.length() >= 2 && jSONArray.optString(1).equals(TypedValues.Custom.S_STRING)) {
                String string2 = jSONArray2.getString(1);
                if (TextUtils.isEmpty(string2)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(string2);
                }
                jSONArray2.put(1, jSONObject);
            }
            InvokeMessage invokeMessage = new InvokeMessage();
            invokeMessage.setTraceId(C10393Util.generateRandomString(11));
            invokeMessage.setModuleName("DidiBridgeAdapter");
            invokeMessage.setFunctionName(string);
            invokeMessage.setArgs(jSONArray2.toString());
            invokeMessage.setInvokeFrom("ancient");
            return m20784a(200, this.f29509d.invokeNativeMethod(invokeMessage));
        } catch (JSONException e) {
            if (e.getCause() != null) {
                return m20784a(500, "method execute error:" + e.getCause().getMessage());
            }
            return m20784a(500, "method execute error:" + e.getMessage());
        }
    }

    /* renamed from: a */
    private String m20784a(int i, Object obj) {
        String str;
        if (obj == null) {
            str = "null";
        } else if (obj instanceof Number) {
            str = String.valueOf(obj);
        } else if (obj instanceof String) {
            str = Const.jsQuote + ((String) obj).replace(Const.jsQuote, "\\\"") + Const.jsQuote;
        } else if (obj instanceof JSONObject) {
            str = Const.jsQuote + obj.toString().replace(Const.jsQuote, "\\\"") + Const.jsQuote;
        } else {
            str = Const.jsQuote + obj.toString() + Const.jsQuote;
        }
        return String.format(f29507b, new Object[]{Integer.valueOf(i), str});
    }

    public void handleInvokeOfPreviousJS(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("cmd");
            JSONObject optJSONObject = jSONObject.optJSONObject("params");
            if (optJSONObject != null && "{}".equals(optJSONObject.toString())) {
                optJSONObject = null;
            }
            String optString2 = jSONObject.optString("id");
            String optString3 = jSONObject.optString("callback", f29508c);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(optString).put(optJSONObject).put(optString3);
            InvokeMessage invokeMessage = new InvokeMessage();
            invokeMessage.setTraceId(C10393Util.generateRandomString(11));
            invokeMessage.setModuleName("DidiBridgeAdapter");
            invokeMessage.setFunctionName("callHandler");
            invokeMessage.setArgs(jSONArray.toString());
            invokeMessage.setInvokeFrom("previous");
            invokeMessage.setPreviousCallId(optString2);
            this.f29509d.invokeNativeMethod(invokeMessage);
        }
    }
}
