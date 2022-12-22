package com.didi.map.global.component.collide.strategy2;

import com.didi.common.map.model.LatLng;
import java.util.List;

public class RouteInfo {
    public List<LatLng> latLngs;

    public RouteInfo(List<LatLng> list) {
        this.latLngs = list;
    }
}
