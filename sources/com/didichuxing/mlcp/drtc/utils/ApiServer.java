package com.didichuxing.mlcp.drtc.utils;

import android.util.Base64;
import com.didichuxing.mlcp.drtc.models.SessionConnInfo;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiServer extends HttpUtils {
    private static String API_FMT_CONN_INFO = "%s/drtc/sys/%s/conninfo";
    private static String X_TOKEN = "F1D45088-9ED9-7648-1075-0676C837AC2B";
    private static ApiServer instance;

    public static ApiServer getInstance() {
        if (instance == null) {
            instance = new ApiServer();
        }
        return instance;
    }

    public SessionConnInfo getSessionConnInfo(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(HttpGet_Sync(String.format(API_FMT_CONN_INFO, new Object[]{str, Base64.encodeToString(str2.getBytes(), 2)}), X_TOKEN));
            if (jSONObject.getInt("code") == 200 && jSONObject.has("data")) {
                return (SessionConnInfo) new Gson().fromJson(jSONObject.getJSONObject("data").toString(), SessionConnInfo.class);
            }
        } catch (NullPointerException | JSONException unused) {
        }
        return null;
    }
}
