package com.didi.map.common;

import android.os.Build;
import android.text.TextUtils;
import com.didi.hawaii.log.HWLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public final class ApolloHawaii {

    /* renamed from: A */
    private static final String f24596A = "hawaii_android_mapsdk_url";
    public static final boolean ADD_ENGINE_AFTER_FIRST_FRAME = m17536u();

    /* renamed from: B */
    private static final String f24597B = "hawaii_traffic_update_interval";

    /* renamed from: C */
    private static final String f24598C = "map_gl_exception_track";
    public static final boolean CANCEL_TILE_DATA_REQUEST = m17527l();

    /* renamed from: D */
    private static final String f24599D = "hawaii_glmaplib_UseVulkan";

    /* renamed from: E */
    private static final String f24600E = "map_sdk_version_v2_degradeto_v1";

    /* renamed from: F */
    private static final String f24601F = "map_sdk_fix_anr_cicle";

    /* renamed from: G */
    private static final String f24602G = "hawaii_android_new_gesture";

    /* renamed from: H */
    private static final String f24603H = "hawaii_reset_locator_position";
    public static final int HWBUSSThreshold = getHWBUsThreshold();
    public static final boolean HWBUSSThresholdOpen = openHWBUsThreshold();

    /* renamed from: I */
    private static final String f24604I = "hawaii_hwbuss_threshold";
    public static final boolean IS_MJO_MEMORY_LIMIT = m17522g();
    public static final boolean IS_OPEN_MSAA = m17525j();
    public static final boolean IS_RENDER_DROP_FRAME = m17526k();
    public static final boolean IS_USE_BLOCKOPT = m17535t();
    public static boolean IS_USE_TEXTUREVIEW = m17532q();

    /* renamed from: J */
    private static final String f24605J = "hawaii_create_bitmap_force_copy";

    /* renamed from: K */
    private static final String f24606K = "hawaii_map_nav_jam_view_param";

    /* renamed from: L */
    private static final String f24607L = "hawaii_android_navi_multi_route";

    /* renamed from: M */
    private static final String f24608M = "map_sdk_fix_anr_glsurface";
    public static int MEMORY_LIMIT_AVIABLE = 0;
    public static int MEMORY_LIMIT_TIME = 0;
    public static final boolean MJO_ENABLED = m17523h();

    /* renamed from: N */
    private static final String f24609N = "hawaii_fix_traffic_anr";

    /* renamed from: O */
    private static final String f24610O = "map_sdk_fix_arm64_bug";
    public static boolean OPEN_ANIMATE = false;
    public static boolean OPEN_ANIMATE_HAS_DEL_ANIMATE = false;

    /* renamed from: P */
    private static final String f24611P = "gray_map_navi_usedolphinhost";

    /* renamed from: Q */
    private static final String f24612Q = "hawaii_change_language_cancel";

    /* renamed from: R */
    private static final String f24613R = "hawaii_map_apollo_loopmap";
    public static final boolean RESET_LOCATOR_POSITION = m17521f();
    public static float ROTATE_DELTA = 0.0f;

    /* renamed from: S */
    private static final String f24614S = "map_navi_hmi_day_night_changetime";
    public static float SCALE_DELTA = 0.0f;

    /* renamed from: T */
    private static boolean f24615T = m17533r();

    /* renamed from: U */
    private static final String f24616U = "hawaii_map_use_textureview";
    public static final boolean USE_MAPSDK_V2 = true;
    public static boolean USE_NEWBUBBLE = m17516a();
    public static final boolean USE_NEWWAY_CONTEXT = m17530o();
    public static boolean USE_NEW_BLOCK_BUBBLE = m17518c();
    public static final boolean USE_SHARE_CONTEXT = m17529n();
    public static final boolean USE_VULKAN_MAP = m17531p();

    /* renamed from: V */
    private static final int f24617V = isVdrOrgForNavi();

    /* renamed from: a */
    private static final String f24618a = "hawaii_android_report_ops_uithread_check";

    /* renamed from: b */
    private static final String f24619b = "hawaii_android_use_didi_netutils";

    /* renamed from: c */
    private static final String f24620c = "hawaii_android_traffic_event";

    /* renamed from: d */
    private static final String f24621d = "hawaii_android_dynamic_bubbleAB";

    /* renamed from: e */
    private static final String f24622e = "apollo_hawaii_is_use_test_url";

    /* renamed from: f */
    private static final String f24623f = "hawaii_best_view_debug";

    /* renamed from: g */
    private static final String f24624g = "hawaii_map_time_view";

    /* renamed from: h */
    private static final String f24625h = "hawaii_android_log_crash";

    /* renamed from: i */
    private static final String f24626i = "hawaii_android_map_config_server_test_on";

    /* renamed from: j */
    private static final String f24627j = "hawaii_map_glthread_monitor";

    /* renamed from: k */
    private static final String f24628k = "hawaii_map_fishbone_bubbles";

    /* renamed from: l */
    private static final String f24629l = "hawaii_map_lock_glthread";

    /* renamed from: m */
    private static final String f24630m = "hawaii_osmodel_report";

    /* renamed from: n */
    private static final String f24631n = "hawaii_map_mjo_memory_limit";
    public static boolean newMultiBubbleCollision = m17520e();

    /* renamed from: o */
    private static final String f24632o = "map_navi_yaw_vdr";
    public static final boolean openCreateBitmapForceCopy = m17537v();
    public static final boolean openMapLoop = m17528m();

    /* renamed from: p */
    private static final String f24633p = "hawaii_sdk_version_v2_passenger";

    /* renamed from: q */
    private static final String f24634q = "hawaii_mapv2_share_context";

    /* renamed from: r */
    private static float f24635r = 16.5f;

    /* renamed from: s */
    private static float f24636s = 18.5f;

    /* renamed from: t */
    private static final String f24637t = "hawaii_map_area_bubble_refactor";

    /* renamed from: u */
    private static final String f24638u = "hawaii_new_multi_bubble_collision";
    public static final boolean useNewCameraPosition = m17524i();

    /* renamed from: v */
    private static final String f24639v = "map_navi_hmi_android_render";

    /* renamed from: w */
    private static final String f24640w = "hawaii_map_use_bubble";

    /* renamed from: x */
    private static final String f24641x = "gray_map_navi_pic_mjo";

    /* renamed from: y */
    private static final String f24642y = "hawii_camera_position_v2";

    /* renamed from: z */
    private static final String f24643z = "hawaii_map_render_msaa";

    /* renamed from: p */
    private static boolean m17531p() {
        return false;
    }

    public static boolean performanceGlSurfaceView() {
        return true;
    }

    static {
        boolean[] b = m17517b();
        OPEN_ANIMATE = b[0];
        OPEN_ANIMATE_HAS_DEL_ANIMATE = b[1];
        m17538w();
    }

    /* renamed from: a */
    private static boolean m17516a() {
        return !Apollo.getToggle("hawaii_close_new_bubble").allow();
    }

    /* renamed from: b */
    private static boolean[] m17517b() {
        IToggle toggle = Apollo.getToggle("hawaii_bubble_animate");
        if (!toggle.allow()) {
            return new boolean[]{false, false};
        }
        boolean z = false;
        int intValue = ((Integer) toggle.getExperiment().getParam("del_animate", 0)).intValue();
        boolean[] zArr = new boolean[2];
        zArr[0] = true;
        if (intValue == 1) {
            z = true;
        }
        zArr[1] = z;
        return zArr;
    }

    /* renamed from: c */
    private static boolean m17518c() {
        return Apollo.getToggle("apollo_hawaii_jam_bubble_refactor").allow();
    }

    /* renamed from: d */
    private static boolean m17519d() {
        boolean allow = Apollo.getToggle(f24637t).allow();
        HWLog.m16761i("Apollo", "isNewBubbleRefactor allow = " + allow);
        return allow;
    }

    /* renamed from: e */
    private static boolean m17520e() {
        boolean allow = Apollo.getToggle(f24638u).allow();
        HWLog.m16761i("Apollo", "hawaii_new_multi_bubble_collision allow = " + allow);
        return allow;
    }

    /* renamed from: f */
    private static boolean m17521f() {
        return Apollo.getToggle(f24603H).allow();
    }

    /* renamed from: g */
    private static boolean m17522g() {
        IToggle toggle = Apollo.getToggle(f24631n);
        MEMORY_LIMIT_AVIABLE = ((Integer) toggle.getExperiment().getParam("available", 200)).intValue();
        MEMORY_LIMIT_TIME = ((Integer) toggle.getExperiment().getParam("interval", 18)).intValue();
        return toggle.allow();
    }

    /* renamed from: h */
    private static boolean m17523h() {
        return Apollo.getToggle(f24641x).allow();
    }

    /* renamed from: i */
    private static boolean m17524i() {
        return Apollo.getToggle(f24642y).allow();
    }

    /* renamed from: j */
    private static boolean m17525j() {
        return Apollo.getToggle(f24641x).allow() && Apollo.getToggle(f24643z).allow();
    }

    /* renamed from: k */
    private static boolean m17526k() {
        IToggle toggle = Apollo.getToggle(f24639v);
        if (toggle.allow()) {
            SCALE_DELTA = Float.valueOf((String) toggle.getExperiment().getParam("scale_delta", "1.5")).floatValue();
            ROTATE_DELTA = (float) ((Integer) toggle.getExperiment().getParam("rotate_delta", 45)).intValue();
        }
        return toggle.allow();
    }

    /* renamed from: l */
    private static boolean m17527l() {
        return Apollo.getToggle(f24612Q).allow();
    }

    /* renamed from: m */
    private static boolean m17528m() {
        IToggle toggle = Apollo.getToggle(f24613R);
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("on", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    private ApolloHawaii() {
    }

    /* renamed from: n */
    private static boolean m17529n() {
        IToggle toggle = Apollo.getToggle(f24634q);
        boolean z = toggle.allow() && MJO_ENABLED;
        if (z) {
            String str = (String) toggle.getExperiment().getParam("os_models", "");
            if (!TextUtils.isEmpty(str)) {
                String str2 = Build.MODEL;
                for (String equals : str.split(",")) {
                    if (str2.equals(equals)) {
                        return false;
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: o */
    private static boolean m17530o() {
        IToggle toggle = Apollo.getToggle(f24634q);
        if (!USE_SHARE_CONTEXT || ((Integer) toggle.getExperiment().getParam("useNewWayContext", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    /* renamed from: q */
    private static boolean m17532q() {
        IToggle toggle = Apollo.getToggle(f24616U);
        if (toggle.allow()) {
            String str = Build.MODEL;
            for (String equals : ((String) toggle.getExperiment().getParam("os_models", "")).split(",")) {
                if (str.equals(equals)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean getTwilightFromNet() {
        return Apollo.getToggle(f24614S).allow();
    }

    public static String getSunriseExtra() {
        IToggle toggle = Apollo.getToggle(f24614S);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("sunrise_time", "10");
        }
        return "10";
    }

    public static String getSunsetExtra() {
        IToggle toggle = Apollo.getToggle(f24614S);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("sunset_time", "10");
        }
        return "10";
    }

    public static long getTrafficUpdateInterval() {
        IToggle toggle = Apollo.getToggle(f24597B);
        if (toggle.allow()) {
            toggle.getExperiment().getParam("interval_time", 2000L);
        }
        return 2000;
    }

    public static boolean isReportUIThreadCheck() {
        return Apollo.getToggle(f24618a).allow();
    }

    public static boolean useDidiNetUtils() {
        return Apollo.getToggle(f24619b).allow();
    }

    public static boolean openMapGLThreadMonitor() {
        return Apollo.getToggle("hawaii_map_glthread_monitor").allow();
    }

    public static boolean isTrafficEventOpen() {
        return Apollo.getToggle(f24620c).allow();
    }

    public static int isHaveMultiRouteBubble() {
        IToggle toggle = Apollo.getToggle(f24621d);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("dynamicBubbleTest", 1)).intValue();
        }
        return 1;
    }

    public static int isVdrOrgForNavi() {
        IToggle toggle = Apollo.getToggle(f24632o);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("vdr_org_for_navi", -1)).intValue();
        }
        return -1;
    }

    public static int getVdrOrgForNavi() {
        return f24617V;
    }

    public static boolean isUseTestUrl() {
        return Apollo.getToggle(f24622e).allow();
    }

    public static boolean isLockGLThread() {
        return f24615T;
    }

    /* renamed from: r */
    private static boolean m17533r() {
        String str = Build.VERSION.RELEASE;
        return "6.0".equals(str) || str.equals("6.0.1") || str.equals("5.1") || str.equals("5.1.1");
    }

    public static boolean isMapUseTestUrl() {
        return Apollo.getToggle(f24626i).allow();
    }

    public static String getTileHost() {
        IToggle toggle = Apollo.getToggle(f24626i);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("tile_server", "");
        }
        return "";
    }

    public static String getConfigHost() {
        IToggle toggle = Apollo.getToggle(f24626i);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("config_server", "");
        }
        return "";
    }

    public static String getTrafficHost() {
        IToggle toggle = Apollo.getToggle(f24626i);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("traffic_server", "");
        }
        return "";
    }

    public static boolean isBestViewDebug() {
        return Apollo.getToggle(f24623f).allow();
    }

    public static String getTestUrlIP() {
        IToggle toggle = Apollo.getToggle(f24622e);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("serverHost", "");
        }
        return "";
    }

    public static String getMapSdkUrl() {
        IToggle toggle = Apollo.getToggle(f24596A);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("url", "");
        }
        return "";
    }

    public static boolean isOpenMapTimeView() {
        return Apollo.getToggle(f24624g).allow();
    }

    public static boolean isOpenMapMemoryView() {
        IToggle toggle = Apollo.getToggle(f24624g);
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("MemoryProfile", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    public static boolean isHawaiiLogCrashOpen() {
        return Apollo.getToggle(f24625h).allow();
    }

    public static boolean isUseFishboneBubble() {
        return Apollo.getToggle(f24628k).allow();
    }

    /* renamed from: s */
    private static boolean m17534s() {
        return Apollo.getToggle(f24633p).allow();
    }

    public static boolean isTrackGLException() {
        return Apollo.getToggle(f24598C).allow();
    }

    public static boolean isFixANR() {
        return Apollo.getToggle(f24601F).allow();
    }

    public static boolean isUseNewGesture() {
        return Apollo.getToggle(f24602G).allow();
    }

    /* renamed from: t */
    private static boolean m17535t() {
        IToggle toggle = Apollo.getToggle(f24640w);
        int i = -1;
        if (toggle.allow()) {
            i = ((Integer) toggle.getExperiment().getParam("blockopt", -1)).intValue();
        }
        return i == 1;
    }

    public static boolean useAndroidOGLSurfaceView() {
        return Apollo.getToggle("hawaii_use_androido_glsurfaceview").allow();
    }

    /* renamed from: u */
    private static boolean m17536u() {
        IToggle toggle = Apollo.getToggle(f24608M);
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("firstFrame", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    public static boolean fixTrafficANR() {
        return Apollo.getToggle(f24609N).allow();
    }

    public static boolean fixarm64Bug() {
        return Apollo.getToggle(f24610O).allow();
    }

    public static boolean useDolphinHost() {
        return Apollo.getToggle(f24611P).allow();
    }

    public static boolean openHWBUsThreshold() {
        return Apollo.getToggle(f24604I).allow();
    }

    public static int getHWBUsThreshold() {
        IToggle toggle = Apollo.getToggle(f24604I);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("threshold", 1)).intValue();
        }
        return 1;
    }

    /* renamed from: v */
    private static boolean m17537v() {
        IToggle toggle = Apollo.getToggle(f24605J);
        boolean allow = toggle != null ? toggle.allow() : false;
        HWLog.m16761i("", "CreateBitmapForceCopy:" + allow);
        return allow;
    }

    /* renamed from: w */
    private static void m17538w() {
        IToggle toggle = Apollo.getToggle(f24606K);
        if (toggle.allow()) {
            f24635r = ((Float) toggle.getExperiment().getParam("minScale", Float.valueOf(16.5f))).floatValue();
            f24636s = ((Float) toggle.getExperiment().getParam("maxScale", Float.valueOf(18.5f))).floatValue();
        } else {
            f24635r = 16.5f;
            f24636s = 18.5f;
        }
        HWLog.m16761i("Apollo", "jam view scale between " + f24635r + " and " + f24636s);
    }

    public static float getJamViewMinScale() {
        return f24635r;
    }

    public static float getJamViewMaxScale() {
        return f24636s;
    }
}
