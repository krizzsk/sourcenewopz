package com.didi.component.framework.tracker;

import com.didi.component.common.util.FireBaseEventUtils;
import com.didi.unifylogin.track.FirebaseEventTrack;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({FirebaseEventTrack.class})
public class FirebaseTracker implements FirebaseEventTrack {
    public void trackEvent() {
        FireBaseEventUtils.traceEvent("global_reg_success", true);
    }
}
