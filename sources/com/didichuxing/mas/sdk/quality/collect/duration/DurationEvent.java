package com.didichuxing.mas.sdk.quality.collect.duration;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class DurationEvent {

    /* renamed from: a */
    private static final String f48073a = "OMGDE";

    /* renamed from: b */
    private String f48074b;

    /* renamed from: c */
    private long f48075c = System.currentTimeMillis();

    /* renamed from: d */
    private long f48076d;

    /* renamed from: e */
    private Map<String, SubDurationEvent> f48077e = new HashMap();

    public DurationEvent(String str) {
        this.f48074b = str;
    }

    public void endMain() {
        this.f48076d = System.currentTimeMillis() - this.f48075c;
    }

    public void startSub(String str) {
        if (!this.f48077e.containsKey(str)) {
            this.f48077e.put(str, new SubDurationEvent(str));
        } else if (MASConfig.LOG_PAGE_DURATION) {
            SystemUtils.log(3, f48073a, str + "  has already start!", (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.duration.DurationEvent", 39);
        }
    }

    public void endSub(String str) {
        if (this.f48077e.containsKey(str)) {
            this.f48077e.get(str).end();
        } else if (MASConfig.LOG_PAGE_DURATION) {
            SystemUtils.log(3, f48073a, this.f48074b + " doesn't contains " + str + ", you should start first!", (Throwable) null, "com.didichuxing.mas.sdk.quality.collect.duration.DurationEvent", 49);
        }
    }

    public String getMainName() {
        return this.f48074b;
    }

    public long getMainTime() {
        return this.f48076d;
    }

    public String getSubInfoInJson() {
        if (this.f48077e.size() < 1) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry next : this.f48077e.entrySet()) {
                String str = (String) next.getKey();
                long subEventTime = ((SubDurationEvent) next.getValue()).getSubEventTime();
                if (0 < subEventTime && subEventTime < 86400000) {
                    jSONObject.put(str, String.valueOf(subEventTime));
                }
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "{}";
        }
    }

    public String getSubInfoInJsonForLog() {
        if (this.f48077e.size() < 1) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry next : this.f48077e.entrySet()) {
                jSONObject.put((String) next.getKey(), String.valueOf(((SubDurationEvent) next.getValue()).getSubEventTime()));
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "{}";
        }
    }

    public String toString() {
        return "\n{\nmainName: " + this.f48074b + "\nmainTime: " + this.f48076d + "\nsubInfo: " + getSubInfoInJsonForLog() + "\n}";
    }
}
