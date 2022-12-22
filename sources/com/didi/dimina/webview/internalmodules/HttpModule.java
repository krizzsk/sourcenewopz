package com.didi.dimina.webview.internalmodules;

import android.text.TextUtils;
import com.didi.dimina.container.bridge.base.BaseHybridModule;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.base.JsInterface;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.didi.dimina.webview.util.HttpUtil;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import org.json.JSONObject;

public class HttpModule extends BaseHybridModule {

    /* renamed from: a */
    private static final String f18258a = "HttpModule";

    public HttpModule(WebViewEngine webViewEngine) {
        super(webViewEngine);
    }

    @JsInterface({"GET"})
    public void getRequest(final String str, final String str2, final CallbackFunction callbackFunction) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setRequestMethod("GET");
                    if (!TextUtils.isEmpty(str2) && !"null".equals(str2)) {
                        JSONObject jSONObject = new JSONObject(str2);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            httpURLConnection.addRequestProperty(next, (String) jSONObject.get(next));
                        }
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    JSONObject jSONObject2 = new JSONObject();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    JSONObject jSONObject3 = new JSONObject(HttpUtil.streamToString(inputStream));
                    inputStream.close();
                    callbackFunction.onCallBack(Integer.valueOf(responseCode), jSONObject2, jSONObject3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
