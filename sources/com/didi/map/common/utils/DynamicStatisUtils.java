package com.didi.map.common.utils;

import android.text.TextUtils;
import com.didi.map.MapOmegaUtil;
import com.didi.map.constant.OmegaEventConstant;
import java.util.HashMap;
import java.util.Map;

public class DynamicStatisUtils {
    public static final int DYNAMIC_STATUS_CLOSE = 0;
    public static final int DYNAMIC_STATUS_WAITING_CHOOSE = 1;

    /* renamed from: a */
    static final String f24671a = "map_switchroute_screenaction_ck";

    /* renamed from: b */
    static final String f24672b = "ab_test_id";

    /* renamed from: c */
    static final String f24673c = "action_id";

    /* renamed from: d */
    static final String f24674d = "action_count";

    /* renamed from: e */
    static final String f24675e = "pinch";

    /* renamed from: f */
    static final String f24676f = "expand";

    /* renamed from: g */
    static final String f24677g = "move";

    /* renamed from: h */
    static String f24678h;

    /* renamed from: i */
    static Map<String, Object> f24679i = new HashMap();

    /* renamed from: j */
    static Map<String, Object> f24680j = new HashMap();

    /* renamed from: k */
    static Map<String, Object> f24681k = new HashMap();

    /* renamed from: l */
    private static int f24682l;

    private DynamicStatisUtils() {
    }

    public static void setDynamicStatus(int i) {
        f24682l = i;
    }

    public static int getDynamicStatus() {
        return f24682l;
    }

    public static void setCurrentEvent(String str) {
        f24678h = str;
    }

    public static void resetCurrentEvent() {
        f24678h = null;
    }

    public static void addEvent(String str) {
        if (str.equals(OmegaEventConstant.HAWAII_MAP_FLING)) {
            addFlingEvent();
        } else if (str.equals(OmegaEventConstant.HAWAII_MAP_ZOOMIN_TWO_FINGER)) {
            addZoominEvent();
        } else if (str.equals(OmegaEventConstant.HAWAII_MAP_ZOOMOUT_TWO_FINGER)) {
            addZoomoutEvent();
        }
    }

    public static void addFlingEvent() {
        if (f24681k == null) {
            f24681k = new HashMap();
        }
        if (!f24681k.containsKey("action_id")) {
            f24681k.put("action_id", f24677g);
        }
        if (f24681k.containsKey("action_count")) {
            Map<String, Object> map = f24681k;
            map.put("action_count", Integer.valueOf(Integer.parseInt(String.valueOf(map.get("action_count"))) + 1));
            return;
        }
        f24681k.put("action_count", "1");
    }

    public static void addZoominEvent() {
        if (f24679i == null) {
            f24679i = new HashMap();
        }
        if (!f24679i.containsKey("action_id")) {
            f24679i.put("action_id", f24675e);
        }
        if (f24679i.containsKey("action_count")) {
            Map<String, Object> map = f24679i;
            map.put("action_count", Integer.valueOf(Integer.parseInt(String.valueOf(map.get("action_count"))) + 1));
            return;
        }
        f24679i.put("action_count", "1");
    }

    public static void addZoomoutEvent() {
        if (f24680j == null) {
            f24680j = new HashMap();
        }
        if (!f24680j.containsKey("action_id")) {
            f24680j.put("action_id", f24676f);
        }
        if (f24680j.containsKey("action_count")) {
            Map<String, Object> map = f24680j;
            map.put("action_count", Integer.valueOf(Integer.parseInt(String.valueOf(map.get("action_count"))) + 1));
            return;
        }
        f24680j.put("action_count", "1");
    }

    public static void addCurrentEvent() {
        if (!TextUtils.isEmpty(f24678h)) {
            addEvent(f24678h);
        }
    }

    public static void trackDynamicEvent(String str) {
        if (f24682l == 1) {
            f24682l = 0;
            Map<String, Object> map = f24681k;
            if (map != null && map.size() > 0) {
                f24681k.put(f24672b, str);
                MapOmegaUtil.trackEvent(f24671a, f24681k);
                f24681k.clear();
            }
            Map<String, Object> map2 = f24679i;
            if (map2 != null && map2.size() > 0) {
                f24679i.put(f24672b, str);
                MapOmegaUtil.trackEvent(f24671a, f24679i);
                f24679i.clear();
            }
            Map<String, Object> map3 = f24680j;
            if (map3 != null && map3.size() > 0) {
                f24680j.put(f24672b, str);
                MapOmegaUtil.trackEvent(f24671a, f24680j);
                f24680j.clear();
            }
        }
    }
}
