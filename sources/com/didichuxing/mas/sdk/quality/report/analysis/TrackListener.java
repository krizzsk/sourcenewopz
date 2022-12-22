package com.didichuxing.mas.sdk.quality.report.analysis;

import com.didichuxing.mas.sdk.quality.report.record.Event;

public interface TrackListener {
    void afterTrackEvent(Event event);
}
