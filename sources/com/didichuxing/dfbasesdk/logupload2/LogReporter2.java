package com.didichuxing.dfbasesdk.logupload2;

import android.text.TextUtils;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import com.didichuxing.dfbasesdk.AppContextHolder;
import com.didichuxing.dfbasesdk.utils.GsonUtils;
import com.didichuxing.dfbasesdk.utils.SPHelper;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public class LogReporter2 {

    /* renamed from: f */
    private static final String f46648f = "logNum";

    /* renamed from: g */
    private static final String f46649g = "seqId";

    /* renamed from: h */
    private static final String f46650h = "clientTime";

    /* renamed from: i */
    private static final String f46651i = "channel";

    /* renamed from: j */
    private static final String f46652j = "1";

    /* renamed from: k */
    private static final String f46653k = "logDBData";

    /* renamed from: a */
    private String f46654a;

    /* renamed from: b */
    private String f46655b;

    /* renamed from: c */
    private final Map<String, Object> f46656c;

    /* renamed from: d */
    private String f46657d;

    /* renamed from: e */
    private final String f46658e;

    public LogReporter2(String str) {
        this(str, (Map<String, Object>) null);
    }

    public LogReporter2(String str, Map<String, Object> map) {
        this.f46654a = str;
        this.f46656c = map;
        if (map != null) {
            this.f46657d = GsonUtils.toJson(map);
        }
        this.f46658e = UUID.randomUUID().toString();
        CrashHandler.getInstance().init(AppContextHolder.getAppContext());
        checkLogDataBase();
    }

    public void setFullUrl(String str) {
        this.f46654a = str;
    }

    @Deprecated
    public static void setRsaPublic(String str, String str2) {
        LogInnerTask.m33492a().setEncrypt(str, !TextUtils.isEmpty(str2));
    }

    public void setEncrypt(String str, boolean z) {
        LogInnerTask.m33492a().setEncrypt(str, z);
    }

    public void setCallerVersion(String str, String str2) {
        LogInnerTask.m33492a().setCallerVersion(str, str2);
    }

    public void setCallerName(String str) {
        this.f46655b = str;
    }

    public static void saveDBStatus(boolean z) {
        new SPHelper(AppContextHolder.getAppContext(), "share_data").put(f46653k, Boolean.valueOf(z)).apply();
    }

    public static void checkLogDataBase() {
        if (((Boolean) new SPHelper(AppContextHolder.getAppContext(), "share_data").get(f46653k, true)).booleanValue()) {
            LogDBTask.m33469b().mo115671a();
        }
    }

    public String getSeqId() {
        return this.f46658e;
    }

    /* renamed from: a */
    private void m33503a(String str, String str2) {
        LogInnerTask.m33492a().mo115692a(str2, str, this.f46657d);
    }

    public <T> void log(T t, String str, String str2) {
        String str3;
        JSONObject jSONObject;
        if (t != null && !TextUtils.isEmpty(str)) {
            if (t instanceof IOnesdkLog) {
                str3 = GsonUtils.toJson(t, true);
            } else if (t instanceof BaseLogBean) {
                BaseLogBean baseLogBean = (BaseLogBean) t;
                baseLogBean.clientTime = System.currentTimeMillis();
                baseLogBean.seqId = this.f46658e;
                baseLogBean.channel = "1";
                baseLogBean.logNum = LogInnerTask.m33492a().mo115691a(m33504b(str, str2));
                str3 = GsonUtils.toJsonStr(baseLogBean);
            } else if (t instanceof Map) {
                Map map = (Map) t;
                map.put(f46649g, this.f46658e);
                map.put(f46650h, Long.valueOf(System.currentTimeMillis()));
                map.put("channel", "1");
                map.put(f46648f, Integer.valueOf(LogInnerTask.m33492a().mo115691a(m33504b(str, str2))));
                str3 = GsonUtils.toJsonStr(map);
            } else {
                try {
                    if (t instanceof JSONObject) {
                        jSONObject = (JSONObject) t;
                    } else {
                        jSONObject = new JSONObject(GsonUtils.toJsonStr(t));
                    }
                    jSONObject.put(f46649g, this.f46658e);
                    jSONObject.put(f46650h, System.currentTimeMillis());
                    jSONObject.put("channel", "1");
                    jSONObject.put(f46648f, LogInnerTask.m33492a().mo115691a(m33504b(str, str2)));
                    str3 = jSONObject.toString();
                } catch (Throwable unused) {
                    str3 = "{}";
                }
            }
            m33503a(str3, str);
        }
    }

    @Deprecated
    public <T> void log(T t) {
        log(t, this.f46654a, this.f46655b);
    }

    /* renamed from: a */
    private String m33502a() {
        return m33504b(this.f46654a, this.f46655b);
    }

    /* renamed from: b */
    private String m33504b(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        String trim = str.toLowerCase().trim();
        int indexOf = trim.indexOf(HWMapConstant.HTTP.SEPARATOR);
        int indexOf2 = trim.indexOf(63);
        int i = indexOf >= 0 ? indexOf + 3 : 0;
        if (indexOf2 < 0) {
            indexOf2 = trim.length();
        }
        return trim.substring(i, indexOf2);
    }

    @Deprecated
    public void log(Map<String, Object> map) {
        log(map, this.f46654a, this.f46655b);
    }
}
