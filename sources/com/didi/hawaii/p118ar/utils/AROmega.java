package com.didi.hawaii.p118ar.utils;

import android.content.Context;
import com.didi.common.map.MapVendor;
import com.didi.common.map.model.LatLng;
import com.didi.hawaii.p118ar.utils.ARCoreCheckerAndGenerator;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.hawaii.ar.utils.AROmega */
public class AROmega {
    public static final String ARNAV_BACK_BACKCLICK = "arnav_back_backclick";
    public static final String ARNAV_END_ENDCLICK = "arnav_end_endclick";
    public static final String ARNAV_END_ENDONBOARD = "arnav_end_endonboard";
    public static final String ARNAV_END_SHOWEND = "arnav_end_showend";
    public static final String ARNAV_GUIDE = "arnav_guide";
    public static final String ARNAV_LOCATION_EXIT = "arnav_location_exit";
    public static final String ARNAV_LOCATION_TIME = "arnav_location_time";
    public static final String ARNAV_LOCATION_TURETIMEDURATION = "arnav_location_turetimeduration";
    public static final String ARNAV_LOCATION_VIEW = "arnav_location_view";
    public static final String ARNAV_LOCATION_WCMALLUSER = "arnav_location_wcmalluser";
    public static final String ARNAV_LOCATION_WCMALLUSER_YES = "arnav_location_wcmalluser_yes";
    public static final String ARNAV_NAVIGATION_50EXIT = "arnav_navigation_50exit";
    public static final String ARNAV_NAVIGATION_EXIT = "arnav_navigation_exit";
    public static final String ARNAV_NORMAL_EXIT = "arnav_normal_exit";
    public static final String ARNAV_START = "map_arnav_start_en";
    public static final String ARNAV_USETIME = "arnav_usetime";
    public static final String ARNAV_YC_EXIT = "arnav_yc_exit";
    public static final String ZG_MAP_ARNAV_DIRECT_100DISTANCE_EN = "map_arnav_direct_100distance_en";
    public static final String ZG_MAP_ARNAV_DIRECT_200DISTANCE_EN = "map_arnav_direct_200distance_en";
    public static final String ZG_MAP_ARNAV_DIRECT_ARRIVE_SW = "map_arnav_direct_arrive_sw";
    public static final String ZG_MAP_ARNAV_DIRECT_AUTHORIZE_CAM_SW = "map_arnav_direct_authorize_cam_sw";
    public static final String ZG_MAP_ARNAV_DIRECT_BACK_CK = "map_arnav_direct_back_ck";
    public static final String ZG_MAP_ARNAV_DIRECT_DISTANCE_EN = "map_arnav_direct_distance_en";
    public static final String ZG_MAP_ARNAV_DIRECT_EN = "map_arnav_direct_en";
    public static final String ZG_MAP_ARNAV_DIRECT_GPSTOAST_SW = "map_arnav_direct_gpstoast_sw";
    public static final String ZG_MAP_ARNAV_DIRECT_MAP_HIDE_CK = "map_arnav_direct_map_hide_ck";
    public static final String ZG_MAP_ARNAV_DIRECT_MAP_SHOW_CK = "map_arnav_direct_map_show_ck";
    public static final String ZG_MAP_ARNAV_DIRECT_USESECONDS_EN = "map_arnav_direct_useseconds_en";
    public static final String ZG_MAP_ARNAV_DIRECT_WARNING_SW = "map_arnav_direct_warning_sw";
    public static final String ZG_MAP_AR_NAV_NETWORK_EN = "map_arnav_network_en";
    public static final String ZG_MAP_AR_NAV_RES_DATA_ERROR = "map_arnav_resdataerror_en";
    public static final String ZG_MAP_AR_NAV_TYPE_ON = "map_arnav_type_en";
    public static final String ZG_TECH_MAP_ARNAV_DIRECT_LOCATE = "tech_map_arnav_direct_locate";

    /* renamed from: a */
    private static MapVendor f23297a;

    public static void requestLocation() {
        Map<String, Object> b = m16705b();
        if (b != null) {
            b.put("session", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getSession());
            b.put("model", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getModel());
            OmegaSDKAdapter.trackEvent(ARNAV_LOCATION_WCMALLUSER, "", b);
        }
    }

    /* renamed from: a */
    private static int m16704a() {
        if (f23297a == null) {
            return -1;
        }
        int i = C89081.$SwitchMap$com$didi$common$map$MapVendor[f23297a.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i != 3) {
            return -1;
        }
        return 2;
    }

    /* renamed from: com.didi.hawaii.ar.utils.AROmega$1 */
    static /* synthetic */ class C89081 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$common$map$MapVendor;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.common.map.MapVendor[] r0 = com.didi.common.map.MapVendor.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$common$map$MapVendor = r0
                com.didi.common.map.MapVendor r1 = com.didi.common.map.MapVendor.DIDI     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$common$map$MapVendor     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.common.map.MapVendor r1 = com.didi.common.map.MapVendor.GOOGLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$common$map$MapVendor     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.common.map.MapVendor r1 = com.didi.common.map.MapVendor.HUAWEI     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.p118ar.utils.AROmega.C89081.<clinit>():void");
        }
    }

    public static void setMapVendor(Context context) {
        if (context != null) {
            f23297a = MapVenderUtil.getCurrentMapType(context);
        }
    }

    public static void arStart() {
        Map<String, Object> b = m16705b();
        if (b != null) {
            b.put("session", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getSession());
            b.put("model", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getModel());
            OmegaSDKAdapter.trackEvent(ARNAV_START, "", b);
        }
    }

    public static void requestLocationClickyes() {
        Map<String, Object> b = m16705b();
        if (b != null) {
            b.put("session", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getSession());
            b.put("model", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getModel());
            OmegaSDKAdapter.trackEvent(ARNAV_LOCATION_WCMALLUSER_YES, "", b);
        }
    }

    public static void arNavEndShowend() {
        Map<String, Object> b = m16705b();
        if (b != null) {
            b.put("session", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getSession());
            b.put("model", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getModel());
            OmegaSDKAdapter.trackEvent(ARNAV_END_SHOWEND, "", b);
        }
    }

    public static void arNavEndClick() {
        Map<String, Object> b = m16705b();
        if (b != null) {
            b.put("session", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getSession());
            b.put("model", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getModel());
            OmegaSDKAdapter.trackEvent(ARNAV_END_ENDCLICK, "", b);
        }
    }

    public static void arNavGuide() {
        Map<String, Object> b = m16705b();
        if (b != null) {
            b.put("session", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getSession());
            b.put("model", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getModel());
            OmegaSDKAdapter.trackEvent(ARNAV_GUIDE, "", b);
        }
    }

    public static void arNavBackClick() {
        Map<String, Object> b = m16705b();
        if (b != null) {
            b.put("session", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getSession());
            b.put("model", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getModel());
            OmegaSDKAdapter.trackEvent(ARNAV_BACK_BACKCLICK, "", b);
        }
    }

    public static void arNav_UseTime(float f) {
        Map<String, Object> b = m16705b();
        if (b != null) {
            b.put("session", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getSession());
            b.put("model", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getModel());
            b.put("use_seconds", Float.valueOf(f));
            OmegaSDKAdapter.trackEvent(ARNAV_USETIME, "", b);
        }
    }

    public static void arNavDriverClick() {
        Map<String, Object> b = m16705b();
        if (b != null) {
            b.put("session", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getSession());
            b.put("model", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getModel());
            OmegaSDKAdapter.trackEvent(ARNAV_END_ENDONBOARD, "", b);
        }
    }

    public static void arNavNormalExit() {
        Map<String, Object> b = m16705b();
        if (b != null) {
            b.put("session", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getSession());
            b.put("model", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getModel());
            OmegaSDKAdapter.trackEvent(ARNAV_NORMAL_EXIT, "", b);
        }
    }

    public static void arNavYcExit() {
        Map<String, Object> b = m16705b();
        if (b != null) {
            b.put("session", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getSession());
            b.put("model", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getModel());
            OmegaSDKAdapter.trackEvent(ARNAV_YC_EXIT, "", b);
        }
    }

    public static void arNavLocationTime(float f) {
        Map<String, Object> b = m16705b();
        if (b != null) {
            b.put("use_seconds", Float.valueOf(f));
            b.put("model", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getModel());
            b.put("session", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getSession());
            OmegaSDKAdapter.trackEvent(ARNAV_LOCATION_TIME, "", b);
        }
    }

    public static void arNavLocationView() {
        Map<String, Object> b = m16705b();
        if (b != null) {
            b.put("model", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getModel());
            b.put("session", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getSession());
            OmegaSDKAdapter.trackEvent(ARNAV_LOCATION_VIEW, "", b);
        }
    }

    public static void arNavLocationTuretimeduration(float f) {
        Map<String, Object> b = m16705b();
        if (b != null) {
            b.put("model", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getModel());
            b.put("session", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getSession());
            b.put("use_seconds", Float.valueOf(f));
            OmegaSDKAdapter.trackEvent(ARNAV_LOCATION_TURETIMEDURATION, "", b);
        }
    }

    public static void arNavNavigation50exit() {
        Map<String, Object> b = m16705b();
        if (b != null) {
            b.put("model", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getModel());
            b.put("session", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getSession());
            OmegaSDKAdapter.trackEvent(ARNAV_NAVIGATION_50EXIT, "", b);
        }
    }

    public static void arNavLocationExit(LatLng latLng, String str) {
        Map<String, Object> b = m16705b();
        if (b != null) {
            b.put("model", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getModel());
            b.put("GPS", latLng.toString());
            b.put("session", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getSession());
            b.put("model_loation", str);
            OmegaSDKAdapter.trackEvent(ARNAV_LOCATION_EXIT, "", b);
        }
    }

    public static void arNavNavigationExit(LatLng latLng, String str) {
        Map<String, Object> b = m16705b();
        if (b != null) {
            b.put("model", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getModel());
            b.put("GPS", latLng.toString());
            b.put("model_loation", str);
            b.put("session", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getSession());
            OmegaSDKAdapter.trackEvent(ARNAV_NAVIGATION_EXIT, "", b);
        }
    }

    public static void zgMapARNavDirectLocate() {
        Map<String, Object> b = m16705b();
        if (b != null) {
            OmegaSDKAdapter.trackEvent(ZG_TECH_MAP_ARNAV_DIRECT_LOCATE, "", b);
        }
    }

    public static void zgMapARNavDirectAuthorizeCam() {
        Map<String, Object> b = m16705b();
        if (b != null) {
            OmegaSDKAdapter.trackEvent(ZG_MAP_ARNAV_DIRECT_AUTHORIZE_CAM_SW, "", b);
        }
    }

    public static void zgMapARNavDirectWarning() {
        Map<String, Object> b = m16705b();
        if (b != null) {
            OmegaSDKAdapter.trackEvent(ZG_MAP_ARNAV_DIRECT_WARNING_SW, "", b);
        }
    }

    public static void zgMapARNavDirectEn() {
        Map<String, Object> b = m16705b();
        if (b != null) {
            OmegaSDKAdapter.trackEvent(ZG_MAP_ARNAV_DIRECT_EN, "", b);
        }
    }

    public static void zgMapARNavDirectArrive() {
        Map<String, Object> b = m16705b();
        if (b != null) {
            OmegaSDKAdapter.trackEvent(ZG_MAP_ARNAV_DIRECT_ARRIVE_SW, "", b);
        }
    }

    public static void zgMapARNavDirectBack() {
        Map<String, Object> b = m16705b();
        if (b != null) {
            OmegaSDKAdapter.trackEvent(ZG_MAP_ARNAV_DIRECT_BACK_CK, "", b);
        }
    }

    public static void zgMapARNavDirectMapShow() {
        Map<String, Object> b = m16705b();
        if (b != null) {
            OmegaSDKAdapter.trackEvent(ZG_MAP_ARNAV_DIRECT_MAP_SHOW_CK, "", b);
        }
    }

    public static void zgMapARNavDirectMapHide() {
        Map<String, Object> b = m16705b();
        if (b != null) {
            OmegaSDKAdapter.trackEvent(ZG_MAP_ARNAV_DIRECT_MAP_HIDE_CK, "", b);
        }
    }

    public static void zgMapARNavDirectDistance(float f) {
        Map<String, Object> b = m16705b();
        if (b != null) {
            b.put("distanceoftarget", Float.valueOf(f));
            OmegaSDKAdapter.trackEvent(ZG_MAP_ARNAV_DIRECT_DISTANCE_EN, "", b);
        }
    }

    public static void zgMapARNavDirect200Distance() {
        Map<String, Object> b = m16705b();
        if (b != null) {
            OmegaSDKAdapter.trackEvent(ZG_MAP_ARNAV_DIRECT_200DISTANCE_EN, "", b);
        }
    }

    public static void zgMapARNavDirect100Distance() {
        Map<String, Object> b = m16705b();
        if (b != null) {
            OmegaSDKAdapter.trackEvent(ZG_MAP_ARNAV_DIRECT_100DISTANCE_EN, "", b);
        }
    }

    public static void zgMapARNavDirectGpsToast(double d, double d2) {
        Map<String, Object> b = m16705b();
        if (b != null) {
            b.put("lat", Double.valueOf(d));
            b.put("lng", Double.valueOf(d2));
            OmegaSDKAdapter.trackEvent(ZG_MAP_ARNAV_DIRECT_GPSTOAST_SW, "", b);
        }
    }

    public static void zgMapARNavDirectUseSeconds(float f) {
        Map<String, Object> b = m16705b();
        if (b != null) {
            b.put("session_id", ARCoreCheckerAndGenerator.cacheResponseData.getcResData().getSession());
            b.put("use_seconds", Float.valueOf(f));
            OmegaSDKAdapter.trackEvent(ZG_MAP_ARNAV_DIRECT_USESECONDS_EN, "", b);
        }
    }

    public static void zgMapARNavResDataError() {
        Map<String, Object> b = m16705b();
        if (b != null) {
            OmegaSDKAdapter.trackEvent(ZG_MAP_AR_NAV_RES_DATA_ERROR, "", b);
        }
    }

    public static void zgMapARNavTypeOn(int i) {
        Map<String, Object> b = m16705b();
        if (b != null) {
            b.put("type", Integer.valueOf(i));
            OmegaSDKAdapter.trackEvent(ZG_MAP_AR_NAV_TYPE_ON, "", b);
        }
    }

    public static void zgMapARNavPreNetWork(ARCoreCheckerAndGenerator.CheckOption checkOption) {
        if (checkOption != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("user_id", PaxEnvironment.getInstance().getUid());
            hashMap.put("order_id", checkOption.getOrderID());
            hashMap.put("scene", Integer.valueOf(checkOption.getScene()));
            hashMap.put("map_vendor", Integer.valueOf(m16704a()));
            hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            OmegaSDKAdapter.trackEvent(ZG_MAP_AR_NAV_NETWORK_EN, "", hashMap);
        }
    }

    /* renamed from: b */
    private static Map<String, Object> m16705b() {
        if (!m16706c()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("user_id", PaxEnvironment.getInstance().getUid());
        hashMap.put("order_id", ARCoreCheckerAndGenerator.cacheResponseData.getArRequestOption().getOrderID());
        hashMap.put("scene", Integer.valueOf(ARCoreCheckerAndGenerator.cacheResponseData.getArRequestOption().getScene()));
        hashMap.put("map_vendor", Integer.valueOf(m16704a()));
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        return hashMap;
    }

    /* renamed from: c */
    private static boolean m16706c() {
        return (ARCoreCheckerAndGenerator.cacheResponseData == null || ARCoreCheckerAndGenerator.cacheResponseData.getArRequestOption() == null || ARCoreCheckerAndGenerator.cacheResponseData.getcResData() == null) ? false : true;
    }
}
