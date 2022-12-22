package com.didichuxing.omega.sdk.analysis;

import android.text.TextUtils;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.utils.OLog;
import java.util.Map;

public class OmegaTH {
    private String moduleId;
    private String moduleUrl;
    private String moduleVersion;
    private String thanosVersion;

    public OmegaTH(String str, String str2, String str3, String str4) {
        this.thanosVersion = str;
        this.moduleId = str2;
        this.moduleVersion = str3;
        this.moduleUrl = str4;
    }

    public void trackEvent(String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            OLog.m34763e("OmegaTH track event failed. event id cannot be empty.");
            return;
        }
        Event event = new Event(str);
        event.setFrom("th");
        if (map != null && map.size() > 0) {
            event.putAllAttrs(map);
        }
        event.putAttr("o_tv", this.thanosVersion);
        event.putAttr("o_mv", this.moduleVersion);
        event.putAttr("o_mi", this.moduleId);
        event.putAttr("o_url", this.moduleUrl);
        Tracker.trackEvent(event);
    }

    public void trackError(String str, String str2, String str3, String str4, Map<String, Object> map) {
        Event event = new Event("OMGError");
        event.setFrom("th");
        if (map != null) {
            event.putAllAttrs(map);
        }
        if (str != null) {
            event.putAttr("mn", str);
        }
        event.putAttr("en", str2);
        event.putAttr("et", str3);
        event.putAttr("em", str4);
        event.putAttr("o_tv", this.thanosVersion);
        event.putAttr("o_mv", this.moduleVersion);
        event.putAttr("o_mi", this.moduleId);
        event.putAttr("o_url", this.moduleUrl);
        Tracker.trackEvent(event);
    }

    public static void trackEngineInit(String str, Map<String, Object> map) {
        Event event = new Event("OMGTHEngineInit");
        event.setFrom("th");
        if (map != null) {
            event.putAllAttrs(map);
        }
        if (!TextUtils.isEmpty(str)) {
            event.putAttr("o_tv", str);
        }
        Tracker.trackEvent(event);
    }
}
