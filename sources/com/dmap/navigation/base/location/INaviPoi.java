package com.dmap.navigation.base.location;

import com.didi.map.outer.model.LatLng;

public interface INaviPoi {
    String getChooseFlag();

    LatLng getLatLng();

    String getName();

    String getUid();
}
