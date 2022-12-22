package com.dmap.navigation.simple;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.base.location.INaviLatLng;

public class SimpleLatlng extends LatLng implements INaviLatLng {
    public SimpleLatlng(double d, double d2) {
        super(d, d2);
    }

    public SimpleLatlng(LatLng latLng) {
        super(latLng.latitude, latLng.longitude);
    }

    public String toString() {
        return "SimpleLatlng{lat=" + this.latitude + ", lng=" + this.longitude + '}';
    }

    public double getLat() {
        return this.latitude;
    }

    public double getLng() {
        return this.longitude;
    }
}
