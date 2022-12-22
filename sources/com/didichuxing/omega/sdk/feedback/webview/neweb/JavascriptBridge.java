package com.didichuxing.omega.sdk.feedback.webview.neweb;

import android.webkit.WebView;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class JavascriptBridge {
    private HashMap<String, Function> mFunctionMap;

    public static abstract class Function {
        private final boolean autoCallbackJs = true;

        public abstract JSONObject execute();

        public boolean isAutoCallbackJs() {
            return true;
        }
    }

    public JavascriptBridge() {
        init();
    }

    public static boolean matchBridgeProtocol(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.has("cmd") && jSONObject.has("id") && jSONObject.has("params");
    }

    public static void onGetDataFromJs(WebView webView, JSONObject jSONObject) {
        String optString = jSONObject.optString("cmd");
        jSONObject.optJSONObject("params");
        JsFunctionHandler.callHandler(webView, optString, new JsCallback(webView, jSONObject.optString("id")));
    }

    private void addFunction(String str, Function function) {
        this.mFunctionMap.put(str, function);
    }

    public Function getFunction(String str) {
        return this.mFunctionMap.get(str);
    }

    private void init() {
        this.mFunctionMap = new HashMap<>();
        addCommonFunctions();
    }

    private void addCommonFunctions() {
        addFunction("js_bridge_test", new Function() {
            public JSONObject execute() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("test_key", "test_value");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return jSONObject;
            }
        });
    }
}
