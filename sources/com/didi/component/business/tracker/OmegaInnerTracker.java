package com.didi.component.business.tracker;

import com.didi.reactive.tracker.InnerTracker;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.Map;

public class OmegaInnerTracker implements InnerTracker {
    public String getName() {
        return "omega-tracker";
    }

    public void track(String str, Map map) {
        OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) map);
    }
}
