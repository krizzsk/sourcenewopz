package com.didi.map.global.component.recmarker.model;

import com.didi.common.map.model.LatLng;

public class RecPoint {
    public String addrName;
    public LatLng location;
    public String srctag;

    public String toString() {
        return "RecPoint{location=" + this.location + ", addrName='" + this.addrName + '\'' + ", srctag='" + this.srctag + '\'' + '}';
    }
}
