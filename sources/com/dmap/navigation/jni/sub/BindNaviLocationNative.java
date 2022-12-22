package com.dmap.navigation.jni.sub;

import com.dmap.navigation.base.location.INaviLocation;
import com.dmap.navigation.jni.swig.BindNaviLocation;

public class BindNaviLocationNative extends BindNaviLocation {
    public BindNaviLocationNative(INaviLocation iNaviLocation, int i) {
        setIndex(i);
        NaviLocationNative.m37050a(this, iNaviLocation);
    }
}
