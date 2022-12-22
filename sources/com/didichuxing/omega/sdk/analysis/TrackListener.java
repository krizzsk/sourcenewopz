package com.didichuxing.omega.sdk.analysis;

import com.didichuxing.omega.sdk.common.record.Event;

public interface TrackListener {
    void afterTrackEvent(Event event);
}
