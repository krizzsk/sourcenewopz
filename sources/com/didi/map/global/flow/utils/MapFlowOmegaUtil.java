package com.didi.map.global.flow.utils;

import android.text.TextUtils;
import com.didi.map.google.util.OmegaCommonArgsAppender;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.SystemUtil;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;

public class MapFlowOmegaUtil {

    /* renamed from: a */
    private static final String f27273a = "inservice_page";

    /* renamed from: b */
    private static boolean f27274b = false;

    public static void trackSwitchBackAndFront(boolean z, String str, int i, boolean z2, long j, String str2, String str3, int i2, String str4, String str5, String str6) {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, Long.valueOf(j));
        hashMap.put("map_type", 0);
        hashMap.put("travelid", str3);
        hashMap.put("countryid", str2);
        OmegaCommonArgsAppender.append(hashMap, str4, str, i, z2, i2, str5, "inservice_page", str6);
        if (z) {
            OmegaSDKAdapter.trackEvent("com_map_PassengerEnterFront_sw_global", (Map<String, Object>) hashMap);
        } else {
            OmegaSDKAdapter.trackEvent("com_map_PassengerEnterBack_sw_global", (Map<String, Object>) hashMap);
        }
    }

    public static void google_map_usage() {
        HashMap hashMap = new HashMap();
        hashMap.put("os", "android");
        hashMap.put("source", "SugActivity");
        OmegaSDKAdapter.trackEvent("google_map_usage", (Map<String, Object>) hashMap);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void trackGuideEntranceShowOrClick(int r3, java.lang.String r4, long r5, java.lang.String r7, java.lang.String r8, long r9, java.lang.String r11, boolean r12, com.didi.common.map.MapVendor r13) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            java.lang.String r2 = "type"
            r0.put(r2, r1)
            java.lang.String r1 = "order_id"
            r0.put(r1, r4)
            com.didi.map.sdk.env.PaxEnvironment r4 = com.didi.map.sdk.env.PaxEnvironment.getInstance()
            java.lang.String r4 = r4.getUid()
            java.lang.String r1 = "uid"
            r0.put(r1, r4)
            java.lang.Long r4 = java.lang.Long.valueOf(r5)
            java.lang.String r5 = "timestamp"
            r0.put(r5, r4)
            java.lang.String r4 = "page"
            r0.put(r4, r11)
            r4 = 1
            if (r3 != r4) goto L_0x0049
            if (r12 == 0) goto L_0x0049
            java.lang.String r3 = "model"
            r0.put(r3, r7)
            java.lang.String r3 = "session"
            r0.put(r3, r8)
            java.lang.Long r3 = java.lang.Long.valueOf(r9)
            java.lang.String r5 = "load_time"
            r0.put(r5, r3)
        L_0x0049:
            r3 = -1
            r5 = 2
            if (r13 == 0) goto L_0x0061
            int[] r6 = com.didi.map.global.flow.utils.MapFlowOmegaUtil.C97541.$SwitchMap$com$didi$common$map$MapVendor
            int r7 = r13.ordinal()
            r6 = r6[r7]
            if (r6 == r4) goto L_0x005f
            if (r6 == r5) goto L_0x0062
            r4 = 3
            if (r6 == r4) goto L_0x005d
            goto L_0x0061
        L_0x005d:
            r4 = 2
            goto L_0x0062
        L_0x005f:
            r4 = 0
            goto L_0x0062
        L_0x0061:
            r4 = -1
        L_0x0062:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            java.lang.String r4 = "map_vendor"
            r0.put(r4, r3)
            if (r12 == 0) goto L_0x0073
            java.lang.String r3 = "ibt_gp_mapfromaddressscene_ck"
            com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r3, (java.util.Map<java.lang.String, java.lang.Object>) r0)
            goto L_0x0078
        L_0x0073:
            java.lang.String r3 = "ibt_gp_mapfromaddressscene_sw"
            com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r3, (java.util.Map<java.lang.String, java.lang.Object>) r0)
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.utils.MapFlowOmegaUtil.trackGuideEntranceShowOrClick(int, java.lang.String, long, java.lang.String, java.lang.String, long, java.lang.String, boolean, com.didi.common.map.MapVendor):void");
    }

    /* renamed from: com.didi.map.global.flow.utils.MapFlowOmegaUtil$1 */
    static /* synthetic */ class C97541 {
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
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.utils.MapFlowOmegaUtil.C97541.<clinit>():void");
        }
    }

    public static void trackArErrorDialogShow(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", PaxEnvironment.getInstance().getUid());
        hashMap.put("error_no", Integer.valueOf(i));
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        OmegaSDKAdapter.trackEvent("ibt_gp_armaperror_popup_sw", (Map<String, Object>) hashMap);
    }

    public static void trackOutArErrorDialogShow(String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", str);
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        OmegaSDKAdapter.trackEvent("map_outside_ar_pop_sw", (Map<String, Object>) hashMap);
    }

    public static void onLocateStatusChange(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", PaxEnvironment.getInstance().getUid());
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("country_id", PaxEnvironment.getInstance().getCountryCode());
        hashMap.put("driver_phone", PaxEnvironment.getInstance().getPhoneNumber());
        hashMap.put("product_id", PaxEnvironment.getInstance().getProductId());
        hashMap.put("page", PaxEnvironment.getInstance().getPage().toString());
        hashMap.put("entrance", PaxEnvironment.getInstance().getEntrance().toString());
        hashMap.put(ParamKeys.PARAM_MODE, Integer.valueOf(i));
        OmegaSDKAdapter.trackEvent("map_global_location_status_st", (Map<String, Object>) hashMap);
    }

    public static void onMapViewIsNull(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_map_ready", Boolean.valueOf(z));
        OmegaSDKAdapter.trackEvent("tech_mapview_null_error", (Map<String, Object>) hashMap);
    }

    public static void onSctxLineChoose(int i, int i2, int i3, int i4, double d) {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "click");
        hashMap.put("l", Integer.valueOf(i));
        hashMap.put("pretab", "pick");
        hashMap.put("r", Integer.valueOf(i3));
        hashMap.put("type", Integer.valueOf(i4));
        hashMap.put(RavenKey.VERSION, "routeclick");
        hashMap.put("view", Double.valueOf(d));
        OmegaSDKAdapter.trackEvent("map_tbd_route_ck", (Map<String, Object>) hashMap);
    }

    public static void showRecommendPoint(int i, int i2, int i3, double d) {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "show");
        hashMap.put("l", Integer.valueOf(i));
        hashMap.put("pretab", "pick");
        hashMap.put("r", Integer.valueOf(i2));
        hashMap.put("type", Integer.valueOf(i3));
        hashMap.put(RavenKey.VERSION, Const.ComponentType.BANNER);
        hashMap.put("view", Double.valueOf(d));
        OmegaSDKAdapter.trackEvent("map_tbd_sw", (Map<String, Object>) hashMap);
    }

    public static void useRecommendPoint(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "show");
        hashMap.put("pretab", "pick");
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put(RavenKey.VERSION, "newbanner");
        OmegaSDKAdapter.trackEvent("map_tbd_newtab_sw", (Map<String, Object>) hashMap);
    }

    public static void reportOmegaSACarShow() {
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_map_car_sw");
    }

    public static void reportOmegaSAFenceShow() {
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_map_fence_sw");
    }

    public static void onOptionLineShow(long j, String str, long j2, String str2, String str3) {
        if (j != 0 || j2 != 0) {
            String uid = PaxEnvironment.getInstance().getUid();
            String str4 = uid + "_" + j + "_" + j2;
            if (str3 == null) {
                str3 = "";
            }
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("main_route_id", Long.valueOf(j));
            hashMap.put("main_tag_name", str);
            hashMap.put(ParamKeys.PARAM_MULTI_ROUTE_ID, Long.valueOf(j2));
            hashMap.put("multi_tag_name", str2);
            hashMap.put("passenger_id", uid);
            hashMap.put("bubble_id", str3);
            hashMap.put(FirebaseAnalytics.Param.GROUP_ID, str4);
            OmegaSDKAdapter.trackEvent("map_bubble_multiroute_sw", (Map<String, Object>) hashMap);
        }
    }

    public static void onOptionLineClick(long j, String str, long j2, long j3, String str2) {
        if (j2 != 0 || j3 != 0) {
            String uid = PaxEnvironment.getInstance().getUid();
            String str3 = uid + "_" + j2 + "_" + j3;
            if (str2 == null) {
                str2 = "";
            }
            if (str == null) {
                str = "";
            }
            String str4 = (j > j2 ? 1 : (j == j2 ? 0 : -1)) == 0 ? "default" : "not_default";
            HashMap hashMap = new HashMap();
            hashMap.put(ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, Long.valueOf(j));
            hashMap.put("tag_name", str);
            hashMap.put("is_default_route", str4);
            hashMap.put("passenger_id", uid);
            hashMap.put("bubble_id", str2);
            hashMap.put(FirebaseAnalytics.Param.GROUP_ID, str3);
            OmegaSDKAdapter.trackEvent("map_bubble_multiroute_ck", (Map<String, Object>) hashMap);
        }
    }

    public static void trackMapLoadFailed(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("local_timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("map_vendor", str);
        hashMap.put("upload_version", 1);
        OmegaSDKAdapter.trackEvent("tech_map_tiles_load_fail", (Map<String, Object>) hashMap);
    }

    public static void orientationEnableOmega(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("passenger_id ", PaxEnvironment.getInstance().getUid());
        hashMap.put("order_id", str);
        hashMap.put("os_type", str2);
        hashMap.put(ParamConst.PARAM_DEVICE_MODEL, "" + SystemUtil.getModel());
        OmegaSDKAdapter.trackEvent("tech_map_direction_sensor_status", (Map<String, Object>) hashMap);
    }

    public static void trackLocationPermissionState(int i) {
        String uid = PaxEnvironment.getInstance().getUid();
        if (!f27274b && !TextUtils.isEmpty(uid)) {
            f27274b = true;
            HashMap hashMap = new HashMap();
            hashMap.put("permission", Integer.valueOf(i));
            hashMap.put("passenger_id", uid);
            OmegaSDKAdapter.trackEvent("map_locate_paxauthority_ck", (Map<String, Object>) hashMap);
        }
    }

    public static void trackTripStateUpdate(String str, int i) {
        if (str == null) {
            str = "";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("orderID", str);
        hashMap.put("state", Integer.valueOf(i));
        OmegaSDKAdapter.trackEvent("map_serialorder_xpanel_sw", (Map<String, Object>) hashMap);
    }

    public static void trackFloatWindowNoPermission(String str) {
        SystemUtils.log(3, "fm_track", "no permission track, orderId:" + str, (Throwable) null, "com.didi.map.global.flow.utils.MapFlowOmegaUtil", 343);
        if (str == null) {
            str = "";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", str);
        OmegaSDKAdapter.trackEvent("tech_map_float_window_no_permission", (Map<String, Object>) hashMap);
    }

    public static void trackFloatWindowNoShow(String str) {
        SystemUtils.log(3, "fm_track", "float window no show track, orderId:" + str, (Throwable) null, "com.didi.map.global.flow.utils.MapFlowOmegaUtil", 357);
        if (str == null) {
            str = "";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", str);
        OmegaSDKAdapter.trackEvent("tech_map_go_home_no_serving", (Map<String, Object>) hashMap);
    }

    public static void trackFloatWindow(String str, int i) {
        SystemUtils.log(3, "fm_track", "flow window status track, orderId:" + str + ",type:" + i, (Throwable) null, "com.didi.map.global.flow.utils.MapFlowOmegaUtil", 370);
        if (str == null) {
            str = "";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", str);
        hashMap.put("type", Integer.valueOf(i));
        OmegaSDKAdapter.trackEvent("tech_map_float_window_status", (Map<String, Object>) hashMap);
    }
}
