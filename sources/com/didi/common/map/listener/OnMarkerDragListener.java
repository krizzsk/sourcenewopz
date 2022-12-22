package com.didi.common.map.listener;

import com.didi.common.map.model.Marker;

public interface OnMarkerDragListener {
    void onMarkerDrag(Marker marker);

    void onMarkerDragEnd(Marker marker);

    void onMarkerDragStart(Marker marker);
}
