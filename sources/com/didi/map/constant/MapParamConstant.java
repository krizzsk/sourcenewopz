package com.didi.map.constant;

import android.graphics.Color;
import com.didi.map.outer.map.DidiMap;

public class MapParamConstant {
    public static final int ACTION_TURN_LEFT = 2;
    public static final int ACTION_TURN_LEFTBACK1 = 31;
    public static final int ACTION_TURN_LEFTBACK2 = 32;
    public static final int ACTION_TURN_RIGHT = 3;
    public static final int ACTION_TURN_RIGHTBACK1 = 40;
    public static final int ACTION_TURN_RIGHTBACK2 = 41;
    public static int MAP_SKEW_ANGLE = 30;
    public static final String TRAFFIC_COLOR_BLOCK = "#7B72F5";
    public static final String TRAFFIC_COLOR_BLOCK_LIGHT = "#7B72F5";
    public static final String TRAFFIC_COLOR_BLOCK_NIGHT = "#554492";
    public static final String TRAFFIC_COLOR_HEAVYBLOCK = "#5C5CCF";
    public static final String TRAFFIC_COLOR_HEAVYBLOCK_LIGHT = "#5C5CCF";
    public static final String TRAFFIC_COLOR_HEAVYBLOCK_NIGHT = "#382B6B";
    public static final String TRAFFIC_COLOR_SLOWMOVING = "#59D6F5";
    public static final String TRAFFIC_COLOR_SLOWMOVING_LIGHT = "#59D6F5";
    public static final String TRAFFIC_COLOR_SLOWMOVING_NIGHT = "#277D7C";
    public static final String TRAFFIC_COLOR_UNBLOCK = "#B4D98F";
    public static final String TRAFFIC_COLOR_UNBLOCK_LIGHT = "#B4D98F";
    public static final String TRAFFIC_COLOR_UNBLOCK_NIGHT = "#4F5823";
    public static boolean mIsDriver = true;

    public static int getTrafficColor(String str) {
        return Color.parseColor(str);
    }

    public static void setMapSkewAngle(int i) {
        MAP_SKEW_ANGLE = i;
    }

    public static void setIsDriver(boolean z) {
        mIsDriver = z;
    }

    public static void setLightNavTrafficColor(DidiMap didiMap) {
        didiMap.setTrafficColor(getTrafficColor("#59D6F5"), getTrafficColor("#7B72F5"), getTrafficColor("#B4D98F"), getTrafficColor("#5C5CCF"));
    }

    public static void setTrafficColor(DidiMap didiMap, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        if (z) {
            i = getTrafficColor(TRAFFIC_COLOR_SLOWMOVING_NIGHT);
            i4 = getTrafficColor(TRAFFIC_COLOR_BLOCK_NIGHT);
            i3 = getTrafficColor(TRAFFIC_COLOR_UNBLOCK_NIGHT);
            i2 = getTrafficColor(TRAFFIC_COLOR_HEAVYBLOCK_NIGHT);
        } else {
            i = getTrafficColor("#59D6F5");
            i4 = getTrafficColor("#7B72F5");
            i3 = getTrafficColor("#B4D98F");
            i2 = getTrafficColor("#5C5CCF");
        }
        didiMap.setTrafficColor(i, i4, i3, i2);
    }
}
