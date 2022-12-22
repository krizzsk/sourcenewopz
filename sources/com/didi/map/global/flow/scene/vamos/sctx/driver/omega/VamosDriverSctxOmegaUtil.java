package com.didi.map.global.flow.scene.vamos.sctx.driver.omega;

import com.didi.map.google.model.OmegaTraceEvent;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.nav.car.CameraMode;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class VamosDriverSctxOmegaUtil {

    /* renamed from: a */
    private static final int f27149a = 1;

    /* renamed from: b */
    private static final String f27150b = "google";

    /* renamed from: c */
    private static int f27151c;

    /* renamed from: d */
    private static String f27152d;

    /* renamed from: e */
    private static String f27153e;

    /* renamed from: a */
    private static int m19186a(int i) {
        if (i == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 4 ? -1 : 2;
        }
        return 1;
    }

    /* renamed from: b */
    private static String m19188b(int i) {
        return i != 1 ? i != 2 ? i != 4 ? "" : "dropoff_vamos_driver" : "arrival_vamos_driver" : "pickup_vamos_driver";
    }

    public static void initCommonFields(String str, String str2, int i) {
        f27151c = m19186a(i);
        f27152d = str;
        f27153e = str2;
    }

    /* renamed from: a */
    private static HashMap<String, Object> m19187a() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("uid", PaxEnvironment.getInstance().getUid());
        hashMap.put("order_id", f27152d);
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        hashMap.put(OmegaTraceEvent.CommentParamNames.TRIP_STEP, Integer.valueOf(f27151c));
        hashMap.put("travel_id", f27153e);
        hashMap.put("country_id", PaxEnvironment.getInstance().getCountryCode());
        hashMap.put("map_type", "google");
        hashMap.put("driver_phone", PaxEnvironment.getInstance().getPhoneNumber());
        hashMap.put("product_id", PaxEnvironment.getInstance().getProductId());
        hashMap.put("user_type", 1);
        hashMap.put("page", PaxEnvironment.getInstance().getPage().toString());
        hashMap.put("entrance", PaxEnvironment.getInstance().getEntrance().toString());
        return hashMap;
    }

    public static void onPause() {
        OmegaSDKAdapter.trackEvent("com_map_PassengerEnterBack_sw_global", (Map<String, Object>) m19187a());
    }

    public static void onResume() {
        OmegaSDKAdapter.trackEvent("com_map_PassengerEnterFront_sw_global", (Map<String, Object>) m19187a());
    }

    public static void onSearchRouteSuccess() {
        OmegaSDKAdapter.trackEvent("map_d_locallightnavi_receivesucs_sw", (Map<String, Object>) m19187a());
    }

    public static void onSearchRouteFail() {
        OmegaSDKAdapter.trackEvent("map_d_locallightnavi_receivefailed_sw", (Map<String, Object>) m19187a());
    }

    public static void onSearchFailByNet() {
        OmegaSDKAdapter.trackEvent("com_map_wlwlj", (Map<String, Object>) m19187a());
    }

    public static void onSearchOffRouteSuccess() {
        OmegaSDKAdapter.trackEvent("map_d_locallightnavi_deviresucs_sw", (Map<String, Object>) m19187a());
    }

    public static void onSearchOffRouteFail() {
        OmegaSDKAdapter.trackEvent("map_d_locallightnavi_devirefailed_sw", (Map<String, Object>) m19187a());
    }

    public static void onResetButtonClick() {
        OmegaSDKAdapter.trackEvent("map_DriverRequestBestview_ck", (Map<String, Object>) m19187a());
    }

    public static void onCameraButtonClick(CameraMode cameraMode) {
        HashMap<String, Object> a = m19187a();
        a.put("switch_from", Integer.valueOf(cameraMode == CameraMode.NORTH_UP ? 0 : 1));
        OmegaSDKAdapter.trackEvent("rp_navi_mode_shift", (Map<String, Object>) a);
    }

    public static void onPaxLocationShow() {
        OmegaSDKAdapter.trackEvent("pax_location_show", (Map<String, Object>) m19187a());
    }

    public static void onLocateStatusChange(int i) {
        HashMap<String, Object> a = m19187a();
        a.put(ParamKeys.PARAM_MODE, Integer.valueOf(i));
        OmegaSDKAdapter.trackEvent("global_location_status", (Map<String, Object>) a);
    }

    public static void onLocateFail(int i) {
        HashMap<String, Object> a = m19187a();
        a.put("errno", Integer.valueOf(i));
        OmegaSDKAdapter.trackEvent("global_location_reason", (Map<String, Object>) a);
    }

    public static void onOpenNavAppFail() {
        OmegaSDKAdapter.trackEvent("com_map_dqdhsb", (Map<String, Object>) m19187a());
    }

    public static void onNavBtnClick(int i, int i2) {
        HashMap<String, Object> a = m19187a();
        a.put("navi_type", Integer.valueOf(i));
        a.put("select_type", Integer.valueOf(i2));
        OmegaSDKAdapter.trackEvent("map_d_navi_begin_ck", (Map<String, Object>) a);
    }
}
