package com.didi.common.map.internal;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LatLngBounds;
import java.util.List;

public interface IGroundOverlayDelegate extends IMapElementDelegate {
    List<LatLng> getBounderPoints();

    void position(LatLng latLng);

    void position(LatLngBounds latLngBounds);
}
