package com.dmap.navigation.engine.core.camera;

import com.didi.map.outer.model.LatLng;

public interface INaviCamera {
    public static final int DIRECTION_CENTER = 0;
    public static final int DIRECTION_LEFT = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int EYE_TYPE_BUBBLE = 1;
    public static final int EYE_TYPE_ICON = 0;

    int getBubbleType();

    String getDescribe();

    int getGroupId();

    LatLng getLatLng();

    int getSpeed();

    int getType();

    int getWeight();
}
