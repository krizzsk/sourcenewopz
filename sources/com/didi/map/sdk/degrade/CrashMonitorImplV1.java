package com.didi.map.sdk.degrade;

import com.didi.map.sdk.navtracker.log.DLog;
import com.didichuxing.omega.sdk.analysis.TrackListener;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.init.OmegaSDK;

public class CrashMonitorImplV1 implements ICrashMonitor {
    public void start(final ICrashListener iCrashListener) {
        if (iCrashListener != null) {
            OmegaSDK.addTrackListener(new TrackListener() {
                public void afterTrackEvent(Event event) {
                    ICrashListener iCrashListener;
                    if ("omg_crash_event".equals(event.getEventId()) && (iCrashListener = iCrashListener) != null) {
                        iCrashListener.onCrashed(event.toJson());
                    }
                }
            });
            DLog.m20199d("ccc", "omega sdk crash listen ready", new Object[0]);
        }
    }
}
