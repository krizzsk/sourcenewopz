package com.didi.map.common;

import com.didi.map.MapOmegaUtil;
import com.didi.map.constant.OmegaEventConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatisticsManager {
    public static final ArrayList<String> BLACKLIST = new ArrayList<String>() {
        {
            add(OmegaEventConstant.HAWAII_MAP_FINGERROTATE_TWO_FINGER);
            add(OmegaEventConstant.HAWAII_MAP_MOVESKEW_TWO_FINGER);
            add(OmegaEventConstant.HAWAII_MAP_FLING);
            add(OmegaEventConstant.HAWAII_MAP_SCROLL);
        }
    };
    public static String cur_tap_event = null;
    public static boolean isOpen = false;

    public static void setCurTapEvent(String str) {
        cur_tap_event = str;
    }

    public static void addMapTapEvent(int i) {
        String str;
        if (isOpen && (str = cur_tap_event) != null && !BLACKLIST.contains(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("scaleLevel", Integer.valueOf(i));
            hashMap.put("source", "didimap");
            addStatistcsEvent(cur_tap_event, "", hashMap);
        }
    }

    public static void addStatistcsEvent(String str) {
        MapOmegaUtil.trackEvent(str);
    }

    public static void addStatistcsEvent(String str, String str2, Map<String, Object> map) {
        MapOmegaUtil.trackEvent(str, str2, map);
    }
}
