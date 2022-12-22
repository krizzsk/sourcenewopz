package com.didi.onehybrid.internalmodules;

import android.text.TextUtils;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import com.didi.onehybrid.util.HttpUtil;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import org.json.JSONObject;

public class HttpModule extends BaseHybridModule {

    /* renamed from: a */
    private static final String f29589a = "HttpModule";

    public HttpModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
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
