package com.didi.map.common.accessibility;

import com.didi.map.outer.map.DMarker;

public interface MapAccessibilityEventSource {
    void removeMarkerEvent(DMarker dMarker);

    void sendMarkerEvent(DMarker dMarker);
}
