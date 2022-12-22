package com.dmap.navigation.base.location;

import com.didi.map.outer.model.LatLng;

public interface INaviLocation {
    float getAccuracy();

    float getAngle();

    float getFlpBearing();

    float getFlpConfidence();

    String getFlpExt();

    int getFlpStatus();

    int getGpsProvider();

    String getGpsSource();

    long getGpsTime();

    LatLng getLatLng();

    NaviSource getNaviSource();

    long getPhoneTime();

    String getProvider();

    int getSatellitesNum();

    int getVdrConf();

    float getVelocity();

    void setNaviSource(NaviSource naviSource);

    public enum NaviSource {
        UNKNOWN(1000),
        ORIGINAL(0),
        VIRTUAL(1),
        VIRTUAL_TUNNEL(2),
        VIRTUAL_WEAK(3);
        
        private final int value;

        private NaviSource(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }
}
