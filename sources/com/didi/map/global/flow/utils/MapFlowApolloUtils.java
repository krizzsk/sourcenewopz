package com.didi.map.global.flow.utils;

import android.text.TextUtils;
import com.didi.common.map.MapVendor;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import com.didi.map.global.model.location.NLPRegisterParam;
import com.didi.map.google.config.Config;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.push.ServerParam;
import com.didi.soda.customer.p165h5.CustomerWebActivity;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapFlowApolloUtils {

    /* renamed from: a */
    private static final boolean f27264a = false;

    /* renamed from: b */
    private static final boolean f27265b = true;

    /* renamed from: c */
    private static final String f27266c = "global_driver_available_navlist_config";

    /* renamed from: d */
    private static boolean f27267d = false;

    /* renamed from: e */
    private static boolean f27268e = false;
    public static boolean enableMapLoadMonitor = false;

    /* renamed from: f */
    private static int f27269f = 200;

    /* renamed from: g */
    private static List<String> f27270g = new ArrayList();

    /* renamed from: h */
    private static int f27271h = 50;

    /* renamed from: i */
    private static boolean f27272i = false;
    public static int mapLoadTimeoutMillis = 20000;

    public static boolean isQuickenOraRequestIntervalNearPickup() {
        IToggle toggle = Apollo.getToggle("global_passenger_sctx_interval_near_pickup");
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("isEnable", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    public static int getOraRequestDistanceNearPickup() {
        IToggle toggle = Apollo.getToggle("global_passenger_sctx_interval_near_pickup");
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("nearDistance", 150)).intValue();
        }
        return 150;
    }

    public static long getOraRequestIntervalNearPickup() {
        IToggle toggle = Apollo.getToggle("global_passenger_sctx_interval_near_pickup");
        if (toggle.allow()) {
            return (long) ((Integer) toggle.getExperiment().getParam("timeInterval", 3000)).intValue();
        }
        return 3000;
    }

    public static String getNavFilter() {
        IToggle toggle = Apollo.getToggle(f27266c);
        if (toggle.allow()) {
            return (String) toggle.getExperiment().getParam("nav_list", "");
        }
        return "";
    }

    public static boolean isShowCarInBubblePage() {
        IToggle toggle = Apollo.getToggle("EyeBall_Car_Show");
        int intValue = toggle.allow() ? ((Integer) toggle.getExperiment().getParam(CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() : 0;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(intValue == 1);
        DLog.m7384d("isShowCarInBubblePage", sb.toString(), new Object[0]);
        if (intValue == 1) {
            return true;
        }
        return false;
    }

    public static long getPickupSctxIntervalMillis() {
        IToggle toggle = Apollo.getToggle("sctx_passenger_interval_params");
        long j = 5;
        long longValue = toggle.allow() ? ((Long) toggle.getExperiment().getParam("pickup_interval", 5L)).longValue() : 5;
        if (longValue > 0) {
            j = longValue;
        }
        return j * 1000;
    }

    public static long getOnTripSxtxIntervalMillis() {
        IToggle toggle = Apollo.getToggle("sctx_passenger_interval_params");
        long j = 15;
        long longValue = toggle.allow() ? ((Long) toggle.getExperiment().getParam("ontrip_interval", 15L)).longValue() : 15;
        if (longValue > 0) {
            j = longValue;
        }
        return j * 1000;
    }

    public static boolean getRecPointStyleConfig() {
        try {
            IToggle toggle = Apollo.getToggle("gp_confirm_show_recommend_address_name", false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception unused) {
            DLog.m7384d("getRecPointStyleConfig", "getRecPointStyleConfig get apollo error", new Object[0]);
        }
        return false;
    }

    public static boolean getIsEnableCallForOther() {
        IToggle toggle = Apollo.getToggle("global_map_call_for_others_new_toggle");
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("is_enable", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    public static int getCallForOtherStationParam() {
        IToggle toggle = Apollo.getToggle("global_map_call_for_others_new_toggle");
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("station_parameter", 0)).intValue();
        }
        return 0;
    }

    public static int getCallForOtherCloseParam() {
        IToggle toggle = Apollo.getToggle("global_map_call_for_others_new_toggle");
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("close_parameter", 0)).intValue();
        }
        return 0;
    }

    public static int getCallForOtherFarParam() {
        IToggle toggle = Apollo.getToggle("global_map_call_for_others_new_toggle");
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("far_parameter", 0)).intValue();
        }
        return 0;
    }

    public static int getCallForOtherAccuracyParam() {
        IToggle toggle = Apollo.getToggle("global_map_call_for_others_new_toggle");
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam(ServerParam.PARAM_ACCURACY, 0)).intValue();
        }
        return 0;
    }

    public static int getCallForOtherSpeedParam() {
        IToggle toggle = Apollo.getToggle("global_map_call_for_others_new_toggle");
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("speed", 0)).intValue();
        }
        return 0;
    }

    public static List<String> getMultiLineSupportProductIds() {
        ArrayList arrayList = new ArrayList();
        IToggle toggle = Apollo.getToggle("global_map_passenger_bubblePage_routeProductId_toggle");
        if (toggle.allow()) {
            String str = (String) toggle.getExperiment().getParam("productId", "");
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(",");
                if (split.length > 0) {
                    arrayList.addAll(Arrays.asList(split));
                }
            }
        }
        return arrayList;
    }

    public static boolean enableMultiLineCache() {
        return Apollo.getToggle("global_multi_route_cache").allow();
    }

    public static int getMultiLineCacheTime() {
        IToggle toggle = Apollo.getToggle("global_multi_route_cache");
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("cache_time", 0)).intValue();
        }
        return 0;
    }

    public static NLPRegisterParam getDepartureNlpParam() {
        IExperiment experiment;
        String a = m19271a();
        IToggle toggle = !TextUtils.isEmpty(a) ? Apollo.getToggle(a) : null;
        if (!(toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null)) {
            int intValue = ((Integer) experiment.getParam("nlp_enable", 0)).intValue();
            int intValue2 = ((Integer) experiment.getParam("nlp_frequency", 1000)).intValue();
            int intValue3 = ((Integer) experiment.getParam("time_out", 1000)).intValue();
            if (intValue == 1) {
                return new NLPRegisterParam("", intValue3, intValue2);
            }
        }
        return null;
    }

    /* renamed from: a */
    private static String m19271a() {
        IExperiment experiment;
        try {
            IToggle toggle = Apollo.getToggle("global_map_caiman_parameter");
            if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
                return null;
            }
            String str = (String) experiment.getParam("global_nlp_location_ab", "");
            DLog.m7384d("loc_nlp_location_key", "" + str, new Object[0]);
            return str;
        } catch (Exception e) {
            DLog.m7384d("loc_nlp_location_key", "" + e.toString(), new Object[0]);
            e.printStackTrace();
            return null;
        }
    }

    public static float getSAZoomLevelParam(int i) {
        int i2;
        IToggle toggle = Apollo.getToggle("global_map_sa_zoom_toggle");
        float f = i == 1 ? 17.0f : 15.0f;
        if (!toggle.allow()) {
            return f;
        }
        if (i == 1) {
            i2 = ((Integer) toggle.getExperiment().getParam("didi_zoom", 17)).intValue();
        } else {
            i2 = ((Integer) toggle.getExperiment().getParam("google_zoom", 15)).intValue();
        }
        return (float) i2;
    }

    public static void updateMapLoadMonitorParam(MapVendor mapVendor) {
        IToggle iToggle;
        IExperiment experiment;
        if (mapVendor.equals(MapVendor.GOOGLE)) {
            iToggle = Apollo.getToggle("global_map_google_map_monitor");
        } else {
            iToggle = mapVendor.equals(MapVendor.DIDI) ? Apollo.getToggle("global_map_hawaii_map_monitor") : null;
        }
        if (iToggle != null && iToggle.allow() && (experiment = iToggle.getExperiment()) != null) {
            boolean z = false;
            if (((Integer) experiment.getParam("is_enable", 0)).intValue() == 1) {
                z = true;
            }
            enableMapLoadMonitor = z;
            mapLoadTimeoutMillis = ((Integer) experiment.getParam("duration", 20)).intValue() * 1000;
        }
    }

    static {
        initBluetoothMeetingV2Apollo();
        initSerialOrderOptimizedAb();
        initOrderFloatWindowAB();
    }

    public static void initBluetoothMeetingV2Apollo() {
        IExperiment experiment;
        try {
            IToggle toggle = Apollo.getToggle("global_map_bluetooth_meeting_ab_v2");
            if (toggle != null && toggle.allow() && (experiment = toggle.getExperiment()) != null) {
                boolean z = false;
                if (((Integer) experiment.getParam("enable", 0)).intValue() > 0) {
                    z = true;
                }
                f27267d = z;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean enableBluetoothMeetingV2() {
        return f27267d;
    }

    public static void initSerialOrderOptimizedAb() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("Android_serial_order_optimized_ab");
        if (toggle != null && toggle.allow() && (experiment = toggle.getExperiment()) != null) {
            boolean z = false;
            if (((Integer) experiment.getParam("enable", 0)).intValue() == 1) {
                z = true;
            }
            f27272i = z;
            f27271h = ((Integer) experiment.getParam("distance", 50)).intValue();
        }
    }

    public static boolean enableSerialOrderOptimized() {
        return f27272i;
    }

    public static int getTripStateActiveDistance() {
        return f27271h;
    }

    public static boolean getIsEnableTrackPermissionState() {
        IToggle toggle = Apollo.getToggle("global_map_location_permission_state_toggle");
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("enable", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    public static void initOrderFloatWindowAB() {
        IExperiment experiment;
        try {
            String b = m19272b();
            if (!TextUtils.isEmpty(b)) {
                DLog.m7384d(GlobalCashierCoreModule.APOLLO, "float window ab key =" + b, new Object[0]);
                IToggle toggle = Apollo.getToggle(b);
                if (toggle != null && toggle.allow() && (experiment = toggle.getExperiment()) != null) {
                    f27268e = ((Integer) experiment.getParam("enable", 0)).intValue() > 0;
                    f27269f = ((Integer) experiment.getParam("distance", 200)).intValue();
                    String str = (String) experiment.getParam(ParamKeys.PARAM_PRODUCT_IDS, "316,317");
                    if (!TextUtils.isEmpty(str)) {
                        String[] split = str.split(",");
                        if (!CollectionUtil.isEmpty((Object[]) split)) {
                            f27270g.addAll(Arrays.asList(split));
                        }
                    }
                    DLog.m7384d(GlobalCashierCoreModule.APOLLO, "init order float window enable:" + f27268e + ",distance:" + f27269f + ",product_ids:" + str, new Object[0]);
                    return;
                }
                return;
            }
            DLog.m7384d(GlobalCashierCoreModule.APOLLO, "float window ab key = null", new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean enableOrderFloatWindow() {
        return f27268e;
    }

    public static int getFarNearDistance() {
        return f27269f;
    }

    public static List<String> getSupportModels() {
        return f27270g;
    }

    /* renamed from: b */
    private static String m19272b() {
        IExperiment experiment;
        try {
            IToggle toggle = Apollo.getToggle("global_map_caiman_parameter");
            if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
                return null;
            }
            String str = (String) experiment.getParam("global_float_view_ab_key", "");
            if (Config.DEBUG) {
                String str2 = Config.DEBUG_TAG;
                SystemUtils.log(3, str2, "global_float_view_ab_key:" + str, (Throwable) null, "com.didi.map.global.flow.utils.MapFlowApolloUtils", 478);
            }
            return str;
        } catch (Exception e) {
            if (Config.DEBUG) {
                String str3 = Config.DEBUG_TAG;
                SystemUtils.log(3, str3, "getFloatWindowApolloKey, e :" + e.toString(), (Throwable) null, "com.didi.map.global.flow.utils.MapFlowApolloUtils", 485);
            }
            e.printStackTrace();
            return null;
        }
    }
}
