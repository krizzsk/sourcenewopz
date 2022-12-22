package com.dmap.navigation.jni.sub;

import com.dmap.navigation.base.location.INaviLatLng;
import com.dmap.navigation.jni.swig.NaviLatLng;

public class NaviLatLngNative extends NaviLatLng {
    public NaviLatLngNative(INaviLatLng iNaviLatLng) {
        setLat(iNaviLatLng.getLat());
        setLng(iNaviLatLng.getLng());
    }

    public NaviLatLngNative(double d, double d2) {
        setLat(d);
        setLng(d2);
    }
}
