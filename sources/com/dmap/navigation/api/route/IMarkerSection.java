package com.dmap.navigation.api.route;

import com.didi.map.outer.model.LatLng;

public interface IMarkerSection {
    LatLng getEnd();

    int getEndIndex();

    LatLng getStart();

    int getStartIndex();
}
