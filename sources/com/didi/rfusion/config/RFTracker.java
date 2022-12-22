package com.didi.rfusion.config;

import com.didi.rfusion.RFusion;
import com.didi.rfusion.config.RFusionConfig;
import java.util.Map;

public class RFTracker implements RFusionConfig.IRFusionTracker {

    /* renamed from: a */
    private RFusionConfig.IRFusionTracker f33193a;

    private RFTracker() {
        this.f33193a = RFusion.getTracker();
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static RFTracker INSTANCE = new RFTracker();

        private SingletonHolder() {
        }
    }

    public static RFusionConfig.IRFusionTracker getTracker() {
        return SingletonHolder.INSTANCE;
    }

    public void track(String str, Map<String, Object> map) {
        RFusionConfig.IRFusionTracker iRFusionTracker = this.f33193a;
        if (iRFusionTracker != null) {
            iRFusionTracker.track(str, map);
        }
    }
}
