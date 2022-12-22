package com.didichuxing.diface.core;

import com.didichuxing.dfbasesdk.utils.DFApi;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.diface.BuildConfig;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class BaseParam implements Serializable {
    private String extra = DFApi.getCommonExtra(BuildConfig.VERSION_NAME);
    public String language;
    public String token;
    public String userInfo;

    public String getToken() {
        return this.token;
    }

    public String getUserInfo() {
        return this.userInfo;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getExtra() {
        return this.extra;
    }

    public void buildExtra(String str, Object obj) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, obj);
        buildExtra(hashMap);
    }

    public void buildExtra(Map<String, Object> map) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(this.extra);
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
            jSONObject = new JSONObject();
        }
        try {
            for (Map.Entry next : map.entrySet()) {
                jSONObject.put((String) next.getKey(), next.getValue());
            }
        } catch (Exception e2) {
            LogUtils.logStackTrace(e2);
        }
        this.extra = jSONObject.toString();
    }
}
