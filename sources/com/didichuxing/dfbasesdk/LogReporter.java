package com.didichuxing.dfbasesdk;

import com.didichuxing.dfbasesdk.logupload.LogSaver;
import com.didichuxing.dfbasesdk.logupload.LoggerParam;
import com.didichuxing.dfbasesdk.utils.GsonUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public class LogReporter implements ILogReporter {

    /* renamed from: a */
    private String f46471a;

    /* renamed from: b */
    private String f46472b;

    /* renamed from: c */
    private String f46473c = UUID.randomUUID().toString();

    /* renamed from: d */
    private String f46474d;

    /* renamed from: e */
    private final String f46475e;

    /* renamed from: f */
    private String f46476f;

    /* renamed from: g */
    private final String f46477g;

    public LogReporter(String str, String str2, String str3, String str4, String str5) {
        this.f46471a = str;
        this.f46472b = str2;
        this.f46474d = str3;
        this.f46475e = str4;
        this.f46477g = str5;
    }

    public void setAppealId(String str) {
        this.f46476f = str;
    }

    public void report(String str) {
        report(str, (Map<String, Object>) null);
    }

    public void reportEventWithCode(String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("code", Integer.valueOf(i));
        report(str, hashMap);
    }

    public void report(String str, Map<String, Object> map) {
        report(str, map, (Map<String, Object>) null);
    }

    public void report(String str, Map<String, Object> map, Map<String, Object> map2) {
        LoggerParam a = m33309a(str);
        if (map != null) {
            a.eventDetail = GsonUtils.toJson(map);
        } else {
            a.eventDetail = "{}";
        }
        if (map2 != null) {
            a.extra = GsonUtils.toJson(map2);
        } else {
            a.extra = "{}";
        }
        LogSaver.getInstance().save(a);
    }

    /* renamed from: a */
    private LoggerParam m33309a(String str) {
        LoggerParam loggerParam = new LoggerParam();
        loggerParam.token = this.f46472b;
        loggerParam.bizCode = this.f46471a;
        loggerParam.seqId = this.f46473c;
        loggerParam.channel = "1";
        loggerParam.eventId = str;
        loggerParam.sessionId = this.f46474d;
        return loggerParam;
    }

    public void report(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        LoggerParam a = m33309a(str);
        if (jSONObject != null) {
            a.eventDetail = jSONObject.toString();
        } else {
            a.eventDetail = "{}";
        }
        if (jSONObject2 != null) {
            a.extra = jSONObject2.toString();
        } else {
            a.extra = "{}";
        }
        LogSaver.getInstance().save(a);
    }

    public void enter() {
        LogSaver.getInstance().setSdkVer(this.f46477g);
        LogSaver.getInstance().onEnter(AppContextHolder.getAppContext(), this.f46474d, this.f46475e);
    }

    public void exit() {
        LogSaver.getInstance().onExit();
    }

    public void setSessionId(String str) {
        this.f46474d = str;
        LogSaver.getInstance().setSessionId(str);
    }
}
