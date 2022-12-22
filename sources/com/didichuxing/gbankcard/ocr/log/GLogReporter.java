package com.didichuxing.gbankcard.ocr.log;

import com.didichuxing.dfbasesdk.AppContextHolder;
import com.didichuxing.dfbasesdk.data.BaseInnerResult;
import com.didichuxing.dfbasesdk.http.AbsOkHttpCallback;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.SPHelper;
import com.didichuxing.gbankcard.ocr.network.GBankcardApi;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public class GLogReporter {

    /* renamed from: f */
    private static final String f47703f = "gbankcard_logs_prefs";

    /* renamed from: a */
    private final String f47704a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final String f47705b;

    /* renamed from: c */
    private final String f47706c;

    /* renamed from: d */
    private final JSONArray f47707d = new JSONArray();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final SPHelper f47708e;

    public GLogReporter(String str, String str2) {
        this.f47704a = str;
        this.f47705b = UUID.randomUUID().toString();
        this.f47706c = str2;
        this.f47708e = new SPHelper(AppContextHolder.getAppContext(), f47703f);
    }

    public void report(LogData logData) {
        logData.setSeqId(this.f47705b);
        this.f47707d.put(logData.toJsonObj());
    }

    public void onEnter() {
        LogUtils.m33563d("onEnter called...");
        Map<String, ?> all = this.f47708e.getAll();
        if (all == null || all.isEmpty()) {
            LogUtils.m33563d("no logs left before, nice...");
        } else {
            m34163a(all);
        }
    }

    /* renamed from: a */
    private void m34163a(Map<String, ?> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uid", this.f47704a);
            jSONObject.put(GBankcardApi.KEY_CLIENT_DEVICE_INFO, this.f47706c);
            JSONArray jSONArray = new JSONArray();
            final Set<String> keySet = map.keySet();
            LogUtils.m33563d("uploadLeftLogs, size===" + keySet.size());
            for (Map.Entry next : map.entrySet()) {
                LogUtils.m33563d("leftLogs seqId===" + ((String) next.getKey()));
                JSONArray jSONArray2 = new JSONArray((String) next.getValue());
                for (int i = 0; i < jSONArray2.length(); i++) {
                    jSONArray.put(jSONArray2.getJSONObject(i));
                }
            }
            jSONObject.put("jsonArray", jSONArray);
            m34162a(jSONObject.toString(), new AbsOkHttpCallback<BaseInnerResult>() {
                public void onSuccess(BaseInnerResult baseInnerResult) {
                    LogUtils.m33563d("leftLogs, report_sdk_data ok...");
                    for (String remove : keySet) {
                        GLogReporter.this.f47708e.remove(remove);
                    }
                    GLogReporter.this.f47708e.apply();
                }

                public void onFailed(int i, String str) {
                    LogUtils.m33563d("leftLogs, report_sdk_data failed, code===" + i + ", msg=" + str);
                }
            });
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
    }

    /* renamed from: a */
    private void m34162a(String str, AbsOkHttpCallback<BaseInnerResult> absOkHttpCallback) {
        GBankcardApi.getInstance().reportSdkData("risk_ocr_global_report_sdk_data", str, absOkHttpCallback);
    }

    public void onExit() {
        LogUtils.m33563d("onExit called...");
        m34161a();
    }

    /* renamed from: a */
    private void m34161a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uid", this.f47704a);
            jSONObject.put(GBankcardApi.KEY_CLIENT_DEVICE_INFO, this.f47706c);
            jSONObject.put("jsonArray", this.f47707d);
            String jSONObject2 = jSONObject.toString();
            this.f47708e.put(this.f47705b, this.f47707d.toString()).apply();
            m34162a(jSONObject2, new AbsOkHttpCallback<BaseInnerResult>() {
                public void onSuccess(BaseInnerResult baseInnerResult) {
                    LogUtils.m33563d("report_sdk_data ok...");
                    GLogReporter.this.f47708e.remove(GLogReporter.this.f47705b).apply();
                }

                public void onFailed(int i, String str) {
                    LogUtils.m33563d("report_sdk_data failed, code===" + i + ", msg=" + str);
                }
            });
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
    }
}
