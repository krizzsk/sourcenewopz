package com.didichuxing.apollo.sdk.net;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.log.LogUtils;
import com.turbomanage.httpclient.HttpResponse;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonResponse {

    /* renamed from: a */
    private JSONObject f45635a;

    /* renamed from: b */
    private int f45636b;

    /* renamed from: c */
    private String f45637c;

    /* renamed from: d */
    private Map<String, List<String>> f45638d;

    public JSONObject getResponse() {
        return this.f45635a;
    }

    public int getStatus() {
        return this.f45636b;
    }

    public String getUrl() {
        return this.f45637c;
    }

    public Map<String, List<String>> getHeaders() {
        return this.f45638d;
    }

    public static JsonResponse convertFrom(HttpResponse httpResponse) {
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.f45636b = httpResponse.getStatus();
        jsonResponse.f45637c = httpResponse.getUrl();
        jsonResponse.f45638d = httpResponse.getHeaders();
        String bodyAsString = httpResponse.getBodyAsString();
        if (!TextUtils.isEmpty(bodyAsString)) {
            try {
                jsonResponse.f45635a = new JSONObject(bodyAsString);
            } catch (JSONException e) {
                e.printStackTrace();
                LogUtils.m32692e("JSONException while JsonResponse#convertFrom: " + e.getMessage());
            }
        }
        return jsonResponse;
    }
}
