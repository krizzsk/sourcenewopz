package com.didi.map.sdk.departure.internal.markers;

import com.didi.common.map.model.LatLng;

public class RecPoint {
    public String addrName;
    public LatLng location;
    public String srctag;

    public String toString() {
        return this.location.toString() + ",name=" + this.addrName;
    }
}
