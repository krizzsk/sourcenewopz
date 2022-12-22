package com.didi.map;

import com.didi.hawaii.utils.JsonUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class MapApolloHawaii {
    public static final int BASE_MAP_VERSION = getSupport3DBaseMapVersion();
    public static final boolean GL_THREAD_LAG_TRACTLOG = m17470b();
    public static final String HAWAII_TRAFFIC_THREAD_INTERRUPT = "hawaii_traffic_thread_interrupt";
    public static final boolean USE_NEW_BLUE_BUBBLE = m17469a();

    /* renamed from: a */
    private static final String f24416a = "hawaii_android_omega_net_failed";

    /* renamed from: b */
    private static final String f24417b = "hawaii_android_omega_net_success";

    /* renamed from: c */
    private static final String f24418c = "hawaii_android_map_log_enable";

    /* renamed from: d */
    private static final String f24419d = "MapLogState";

    /* renamed from: e */
    private static final String f24420e = "didimap_android_hwi_navi_feature_toggle";

    /* renamed from: f */
    private static final String f24421f = "hawaii_andriod_map_overpass3d";

    /* renamed from: g */
    private static final String f24422g = "NAVI_FEATURE";

    /* renamed from: h */
    private static final String f24423h = "hawaii_map_wms_config";

    /* renamed from: i */
    private static final String f24424i = "hawaii_map_fishbone_bubbles";

    /* renamed from: j */
    private static final String f24425j = "glMapLib_Support3DBaseMap_android";

    /* renamed from: k */
    private static final String f24426k = "hawaii_android_map_fishbone_bubble_only";

    /* renamed from: l */
    private static final String f24427l = "hawaii_android_show_curvy_route_name";

    /* renamed from: m */
    private static final String f24428m = "hawaii_handmap_SupportJsonStyle";

    /* renamed from: n */
    private static final String f24429n = "hawaii_android_track_load_lib";

    /* renamed from: o */
    private static final String f24430o = "hawaii_android_setlogcase";

    /* renamed from: p */
    private static final String f24431p = "hawaii_map_guard_config";

    /* renamed from: q */
    private static final String f24432q = "hawaii_android_map_talkback";

    /* renamed from: r */
    private static final String f24433r = "hawaii_mapjni_post";

    /* renamed from: s */
    private static final String f24434s = "hawaii_mapdata_filter_language";

    /* renamed from: t */
    private static final int f24435t = m17473e();

    /* renamed from: u */
    private static final boolean f24436u = m17474f();

    /* renamed from: v */
    private static final String f24437v = "hawaii_android_traffic_lock_switch";

    /* renamed from: w */
    private static final String f24438w = "hawaii_map_set_native_apollo_callback";

    /* renamed from: x */
    private static final String f24439x = "hawaii_render_log_controll";

    /* renamed from: y */
    private static final boolean f24440y = m17471c();

    /* renamed from: z */
    private static final boolean f24441z = m17472d();

    public static boolean isMapResPack() {
        return true;
    }

    /* renamed from: a */
    private static boolean m17469a() {
        return Apollo.getToggle("hawaii_android_use_new_bluebubble").allow();
    }

    /* renamed from: b */
    private static boolean m17470b() {
        return Apollo.getToggle("hawaii_glthread_lag_tracelog").allow();
    }

    public static boolean isNativeLogEnable() {
        return f24440y;
    }

    public static boolean isNativeOmegaEnable() {
        return f24441z;
    }

    public static boolean getSupportJsonStyle() {
        IToggle toggle = Apollo.getToggle(f24428m);
        if ((toggle.allow() ? ((Integer) toggle.getExperiment().getParam("support_json_style", 0)).intValue() : 0) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isOmegaNetFailed() {
        return Apollo.getToggle(f24416a).allow();
    }

    public static boolean isOmegaNetSuccess() {
        return Apollo.getToggle(f24417b).allow();
    }

    public static boolean isSetLogCaseLogCallback() {
        return Apollo.getToggle(f24430o).allow();
    }

    /* renamed from: c */
    private static boolean m17471c() {
        IToggle toggle = Apollo.getToggle(f24439x);
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("native_log_enable", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    /* renamed from: d */
    private static boolean m17472d() {
        IToggle toggle = Apollo.getToggle(f24439x);
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("native_omega_enable", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    public static boolean isSetMapNativeApolloCallback() {
        return Apollo.getToggle(f24438w).allow();
    }

    public static boolean isMapJniPost() {
        return Apollo.getToggle(f24433r).allow();
    }

    public static boolean isMapLogOpen() {
        return Apollo.getToggle(f24418c).allow();
    }

    public static String getMapLogState() {
        return (String) Apollo.getToggle(f24418c).getExperiment().getParam(f24419d, "");
    }

    public static boolean isNavFeatureOpen() {
        return Apollo.getToggle(f24420e).allow();
    }

    public static String getNavFeature() {
        return (String) Apollo.getToggle(f24420e).getExperiment().getParam(f24422g, "");
    }

    public static boolean canShowRouteBubbles() {
        String navFeature = getNavFeature();
        if (navFeature != null && navFeature.length() > 0) {
            try {
                String string = JsonUtil.getString(new JSONObject(navFeature), "canShowRouteBubbles");
                if (string == null || string.length() <= 0 || !string.equalsIgnoreCase("1")) {
                    return false;
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static String getAndriodMapOverpass3dConfig() {
        IToggle toggle = Apollo.getToggle(f24421f);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("config", "");
        }
        return "";
    }

    public static boolean isMapWmsConfig() {
        return Apollo.getToggle(f24423h).allow();
    }

    public static String getMapWmsConfig() {
        IToggle toggle = Apollo.getToggle(f24423h);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("config", "");
        }
        return "";
    }

    public static boolean isOpenFbRoadName() {
        return Apollo.getToggle(f24424i).allow();
    }

    public static int getSupport3DBaseMapVersion() {
        return f24435t;
    }

    /* renamed from: e */
    private static int m17473e() {
        IToggle toggle = Apollo.getToggle(f24425j);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("version", 4)).intValue();
        }
        return 4;
    }

    public static String getFishboneBubbleOnlyConfig() {
        IToggle toggle = Apollo.getToggle(f24426k);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("config", "");
        }
        return "";
    }

    public static String getShowCurvyRouteName() {
        IToggle toggle = Apollo.getToggle(f24427l);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("canShowCurvyRouteName", "");
        }
        return "";
    }

    public static boolean isTrackInLoadLib() {
        return Apollo.getToggle(f24429n).allow();
    }

    public static HashMap<String, Integer> getGuardConfig() {
        IToggle toggle = Apollo.getToggle(f24431p);
        if (toggle.allow()) {
            try {
                HashMap<String, Integer> hashMap = new HashMap<>();
                IExperiment experiment = toggle.getExperiment();
                hashMap.put("crashNumMax", (Integer) experiment.getParam("crashNumMax", 0));
                hashMap.put("timeMax", (Integer) experiment.getParam("timeMax", 0));
                hashMap.put("timeFirst", (Integer) experiment.getParam("timeFirst", 0));
                return hashMap;
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static boolean isTalkbackOpen() {
        return Apollo.getToggle(f24432q).allow();
    }

    /* renamed from: f */
    private static boolean m17474f() {
        return Apollo.getToggle(f24437v).allow();
    }

    public static boolean isCloseTrafficLock() {
        return f24436u;
    }

    public static boolean isFilterMapData() {
        return Apollo.getToggle(f24434s).allow();
    }
}
