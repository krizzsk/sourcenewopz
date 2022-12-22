package com.didi.address.model;

import android.graphics.Color;

public interface SugMapConstants {
    public static final int DEFAULT_WAYPOINT_MAP_LINE_COLOR = Color.parseColor("#33BBFF");
    public static final String EXTRA_ADDRESS_PARAM = "ExtraAddressParam";
    public static final float MAP_DEFAULT_ZOOM_LEVEL = 18.0f;
    public static final int MAX_SUPPORT_WAYPOINT_COUNT = 2;
    public static final int WAYPOINT_TRIP_STATE_ARRIVED = 1;
    public static final int WAYPOINT_TRIP_STATE_NO_ARRIVED = 0;
    public static final int WAYPOINT_TRIP_STATE_PASSED = 2;
}
