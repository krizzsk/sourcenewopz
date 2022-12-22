package com.didichuxing.diface;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.didi.sdk.p146ad.model.AdParams;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.dfbasesdk.utils.GsonUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.diface.utils.HostArea;
import com.didichuxing.diface.utils.HttpUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class DiFaceParam implements Serializable {
    private Map<String, Object> allDataMap;
    private int bizCode;
    private String data;
    private String language;
    private String note1;
    private String note2;
    private String sessionId;
    private String token;
    private String userInfo;

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setHost(String str) {
        if (!TextUtils.isEmpty(str)) {
            HttpUtils.setHost(str);
        }
    }

    public int getBizCode() {
        return this.bizCode;
    }

    public void setBizCode(int i) {
        this.bizCode = i;
    }

    public String getUserInfo() {
        return this.userInfo;
    }

    public void setUserInfo(String str) {
        this.userInfo = str;
    }

    public void setData(String str) {
        this.data = str;
    }

    public String getData() {
        return this.data;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setGuideNotes(String str, String str2) {
        this.note1 = str;
        this.note2 = str2;
    }

    public void switchHost(HostArea hostArea) {
        HttpUtils.switchHost(hostArea);
    }

    public String getNote1() {
        return this.note1;
    }

    public String getNote2() {
        return this.note2;
    }

    public Map<String, Object> getAllData(Context context) {
        if (this.allDataMap == null) {
            this.allDataMap = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(this.data);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.allDataMap.put(next, jSONObject.get(next));
            }
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
        String versionName = SystemUtil.getVersionName(context);
        String format = String.format("Android/%s %s/%s", new Object[]{Build.VERSION.RELEASE, context.getPackageName(), versionName});
        this.allDataMap.put("appVersion", versionName);
        this.allDataMap.put("sdkVersion", BuildConfig.VERSION_NAME);
        this.allDataMap.put("model", SystemUtil.getModel());
        this.allDataMap.put(AdParams.USER_AGENT, format);
        this.allDataMap.put("recordTime", Long.valueOf(System.currentTimeMillis()));
        return this.allDataMap;
    }

    public String getAllData() {
        return GsonUtils.toJson(this.allDataMap);
    }

    public String toString() {
        return "DiFaceParam{token='" + this.token + '\'' + ", bizCode=" + this.bizCode + ", userInfo='" + this.userInfo + '\'' + ", data='" + this.data + '\'' + ", sessionId='" + this.sessionId + "'" + '}';
    }
}
