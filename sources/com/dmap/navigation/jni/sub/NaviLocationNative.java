package com.dmap.navigation.jni.sub;

import com.dmap.navigation.base.location.INaviLatLng;
import com.dmap.navigation.base.location.INaviLocation;
import com.dmap.navigation.jni.swig.NaviLocation;
import java.math.BigInteger;

public class NaviLocationNative extends NaviLocation {
    public NaviLocationNative(INaviLocation iNaviLocation) {
        m37050a(this, iNaviLocation);
    }

    /* renamed from: a */
    static void m37050a(NaviLocation naviLocation, INaviLocation iNaviLocation) {
        if (iNaviLocation != null) {
            naviLocation.setAccuracy(iNaviLocation.getAccuracy());
            naviLocation.setAngle(iNaviLocation.getAngle());
            naviLocation.setVelocity(iNaviLocation.getVelocity());
            naviLocation.setLatLng(new NaviLatLngNative((INaviLatLng) iNaviLocation.getLatLng()));
            naviLocation.setGpsProvider(iNaviLocation.getGpsProvider());
            naviLocation.setGpsSource(iNaviLocation.getGpsSource());
            naviLocation.setGpsTime(BigInteger.valueOf(iNaviLocation.getGpsTime()));
            if (iNaviLocation.getPhoneTime() <= 0) {
                naviLocation.setPhoneTime(BigInteger.valueOf(System.currentTimeMillis() / 1000));
            } else {
                naviLocation.setPhoneTime(BigInteger.valueOf(iNaviLocation.getPhoneTime() / 1000));
            }
            naviLocation.setNaviSource(iNaviLocation.getNaviSource().getValue());
            naviLocation.setSatellitesNum(iNaviLocation.getSatellitesNum());
            naviLocation.setFlpBearing(iNaviLocation.getFlpBearing());
            naviLocation.setFlpConfidence(iNaviLocation.getFlpConfidence());
            naviLocation.setFlpStatus(iNaviLocation.getFlpStatus());
            naviLocation.setFlpExt(iNaviLocation.getFlpExt());
            naviLocation.setVdrConf(iNaviLocation.getVdrConf());
        }
    }
}
