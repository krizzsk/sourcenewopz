package com.didichuxing.gbankcard.ocr.log;

import com.didichuxing.dfbasesdk.utils.GsonUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class LogData {
    public static final String EVENT_BEGIN_SCAN = "BeginScan";
    public static final String EVENT_ENTER = "Enter";
    public static final String EVENT_EXIT = "Exit";
    public static final String EVENT_FALLBACK_CARDIO = "FallbackCardIO";
    public static final String EVENT_GUIDE = "Guide";
    public static final String EVENT_GUIDE_CALLBACK = "GuideCallback";
    public static final String EVENT_QUIT = "Quit";
    public static final String EVENT_RESCAN = "Rescan";
    private final String channel = "1";
    private final long clientTime = System.currentTimeMillis();
    private final Map<String, Object> details = new HashMap();
    private final String eventId;
    private String seqId;

    public LogData(String str) {
        this.eventId = str;
    }

    /* access modifiers changed from: package-private */
    public void setSeqId(String str) {
        this.seqId = str;
    }

    public void addDetails(Map<String, Object> map) {
        if (map != null) {
            this.details.putAll(map);
        }
    }

    public LogData addDetail(String str, Object obj) {
        this.details.put(str, obj);
        return this;
    }

    /* access modifiers changed from: package-private */
    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("eventId", this.eventId);
            jSONObject.put("channel", this.channel);
            jSONObject.put("seqId", this.seqId);
            jSONObject.put("details", this.details.isEmpty() ? "{}" : GsonUtils.toJson(this.details));
            jSONObject.put("clientTime", this.clientTime);
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
        return jSONObject;
    }
}
