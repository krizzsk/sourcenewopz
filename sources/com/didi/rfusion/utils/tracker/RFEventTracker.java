package com.didi.rfusion.utils.tracker;

import com.didi.rfusion.RFusion;
import com.didi.rfusion.config.RFLogger;
import com.didi.rfusion.config.RFusionConfig;
import java.util.HashMap;
import java.util.Map;

public class RFEventTracker {

    /* renamed from: a */
    private static final String f33309a = "RFEventTracker";

    /* renamed from: b */
    private RFusionConfig.IRFusionLogger f33310b = RFLogger.getLogger();

    /* renamed from: c */
    private RFusionConfig.IRFusionTracker f33311c = RFusion.getTracker();

    /* renamed from: d */
    private String f33312d;

    /* renamed from: e */
    private Map<String, Object> f33313e = new HashMap();

    private RFEventTracker(String str) {
        this.f33312d = str;
    }

    public static RFEventTracker event(String str) {
        return new RFEventTracker(str);
    }

    public RFEventTracker param(String str, int i) {
        this.f33313e.put(str, Integer.valueOf(i));
        return this;
    }

    public RFEventTracker param(String str, long j) {
        this.f33313e.put(str, Long.valueOf(j));
        return this;
    }

    public RFEventTracker param(String str, String str2) {
        this.f33313e.put(str, str2);
        return this;
    }

    public RFEventTracker param(String str, boolean z) {
        this.f33313e.put(str, Boolean.valueOf(z));
        return this;
    }

    public RFEventTracker param(Map<String, String> map) {
        if (map != null) {
            this.f33313e.putAll(map);
        }
        return this;
    }

    public RFEventTracker track() {
        RFusionConfig.IRFusionLogger iRFusionLogger = this.f33310b;
        iRFusionLogger.debug(f33309a, "track eventId:" + this.f33312d + ", params:" + this.f33313e);
        this.f33311c.track(this.f33312d, this.f33313e);
        return this;
    }
}
