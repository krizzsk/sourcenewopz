package com.rider.rlab_im_map_plugin.marker;

import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;

public interface IMarker {
    void addMarker();

    LatLng getLatLng();

    Map getMap();

    Marker getMarker();

    void removeMarker();

    void updatePosition(LatLng latLng);
}
