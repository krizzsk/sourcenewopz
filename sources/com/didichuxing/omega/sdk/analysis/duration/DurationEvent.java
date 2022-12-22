package com.didichuxing.omega.sdk.analysis.duration;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class DurationEvent {
    private static final String TAG = "OMGDE";
    private String mainName;
    private long mainTime;
    private long startTime = System.currentTimeMillis();
    private Map<String, SubDurationEvent> subs = new HashMap();

    public DurationEvent(String str) {
        this.mainName = str;
    }

    public void endMain() {
        this.mainTime = System.currentTimeMillis() - this.startTime;
    }

    public void startSub(String str) {
        if (!this.subs.containsKey(str)) {
            this.subs.put(str, new SubDurationEvent(str));
        } else if (OmegaConfig.LOG_PAGE_DURATION) {
            SystemUtils.log(3, TAG, str + "  has already start!", (Throwable) null, "com.didichuxing.omega.sdk.analysis.duration.DurationEvent", 39);
        }
    }

    public void endSub(String str) {
        if (this.subs.containsKey(str)) {
            this.subs.get(str).end();
        } else if (OmegaConfig.LOG_PAGE_DURATION) {
            SystemUtils.log(3, TAG, this.mainName + " doesn't contains " + str + ", you should start first!", (Throwable) null, "com.didichuxing.omega.sdk.analysis.duration.DurationEvent", 49);
        }
    }

    public String getMainName() {
        return this.mainName;
    }

    public long getMainTime() {
        return this.mainTime;
    }

    public String getSubInfoInJson() {
        if (this.subs.size() < 1) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry next : this.subs.entrySet()) {
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
        if (this.subs.size() < 1) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry next : this.subs.entrySet()) {
                jSONObject.put((String) next.getKey(), String.valueOf(((SubDurationEvent) next.getValue()).getSubEventTime()));
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "{}";
        }
    }

    public String toString() {
        return "\n{\nmainName: " + this.mainName + "\nmainTime: " + this.mainTime + "\nsubInfo: " + getSubInfoInJsonForLog() + "\n}";
    }
}
