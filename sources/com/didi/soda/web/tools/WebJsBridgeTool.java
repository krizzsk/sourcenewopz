package com.didi.soda.web.tools;

import android.text.TextUtils;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.jsbridge.WebViewJavascriptBridge;
import com.didi.soda.web.model.CallBackModel;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class WebJsBridgeTool {
    @Deprecated
    public static void exportJsBridge(String str, Class<? extends BaseHybridModule> cls) {
        WebViewJavascriptBridge.export(str, cls);
    }

    @Deprecated
    public static void exportJsBridges(HashMap<String, Class<? extends BaseHybridModule>> hashMap) {
        if (hashMap.size() > 0) {
            for (Map.Entry next : hashMap.entrySet()) {
                WebViewJavascriptBridge.export((String) next.getKey(), (Class) next.getValue());
            }
        }
    }

    public static JSONObject buildResponse(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errno", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject buildResponse(CallBackModel callBackModel) {
        if (callBackModel == null) {
            return buildResponse(0);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errno", callBackModel.errno);
            jSONObject.put("errmsg", TextUtils.isEmpty(callBackModel.errmsg) ? "ok" : callBackModel.errmsg);
            jSONObject.put("data", callBackModel.data == null ? new JSONObject() : callBackModel.data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
