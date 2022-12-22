package com.dmap.navigation.base.location;

import com.didi.map.outer.model.LatLng;

public interface IPassPoint {
    int getCoorIndex();

    LatLng getLatLng();

    int getPointIndex();
}
