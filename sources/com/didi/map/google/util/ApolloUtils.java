package com.didi.map.google.util;

import android.content.Context;
import android.text.TextUtils;
import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import com.didi.map.google.config.Config;
import com.didi.map.sdk.nav.inertia.ApolloParamsSctxPrediction;
import com.didi.map.sdk.nav.inertia.MatchPointType;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.dmap.navigation.api.core.INaviTrafficUpdater;

public final class ApolloUtils {

    /* renamed from: a */
    private static final String f27804a = "global_inertia_simulate_param_toggle_all";

    /* renamed from: b */
    private static final String f27805b = "com.linkee.global";

    /* renamed from: c */
    private static boolean f27806c = false;

    /* renamed from: d */
    private static boolean f27807d = false;

    /* renamed from: e */
    private static boolean f27808e = false;

    public static boolean isSimulateMotionOpened() {
        IToggle toggle = Apollo.getToggle(f27804a);
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("simulate", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    public static int getMaxMockDistance(MatchPointType matchPointType) {
        if (matchPointType == MatchPointType.WIFI || matchPointType == MatchPointType.MOBILE_STATION) {
            return 800;
        }
        return m19908a();
    }

    public static long getMaxMockTime(MatchPointType matchPointType) {
        if (matchPointType == MatchPointType.WIFI || matchPointType == MatchPointType.MOBILE_STATION) {
            return 120;
        }
        return m19910b() / 1000;
    }

    /* renamed from: a */
    private static int m19908a() {
        IToggle toggle = Apollo.getToggle(f27804a);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("max_mock_dis", 800)).intValue();
        }
        return 800;
    }

    /* renamed from: b */
    private static long m19910b() {
        IToggle toggle = Apollo.getToggle(f27804a);
        if (toggle.allow()) {
            return (long) ((Integer) toggle.getExperiment().getParam("max_mock_time", Integer.valueOf(INaviTrafficUpdater.PUSH_RECONNECT_TIME))).intValue();
        }
        return 120000;
    }

    public static int getAllowEDA() {
        IToggle toggle = Apollo.getToggle(f27804a);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("allow_dis", 150)).intValue();
        }
        return 150;
    }

    public static long getAllowETA() {
        IToggle toggle = Apollo.getToggle(f27804a);
        if (toggle.allow()) {
            return (long) ((Integer) toggle.getExperiment().getParam("allow_time", 60000)).intValue();
        }
        return 60000;
    }

    public static ApolloParamsSctxPrediction getSctxPredictionParams() {
        ApolloParamsSctxPrediction apolloParamsSctxPrediction = new ApolloParamsSctxPrediction();
        IToggle toggle = Apollo.getToggle("globalmap_enable_match_mock_ab");
        if (toggle != null && toggle.allow()) {
            IExperiment experiment = toggle.getExperiment();
            apolloParamsSctxPrediction.enableMock = ((Integer) experiment.getParam("enableMock", 0)).intValue();
            apolloParamsSctxPrediction.coefficient = ((Float) experiment.getParam("coefficient", Float.valueOf(0.8f))).floatValue();
            apolloParamsSctxPrediction.distDisableMock = ((Integer) experiment.getParam("distDisableMock", 10)).intValue();
            apolloParamsSctxPrediction.enableOmg = ((Integer) experiment.getParam("enableOmg", 0)).intValue();
            apolloParamsSctxPrediction.startOmgDist = ((Integer) experiment.getParam("startOmgDist", 300)).intValue();
        }
        return apolloParamsSctxPrediction;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getOraRequestUrl(android.content.Context r4) {
        /*
            java.lang.String r0 = "global_passenger_route_url_toggle"
            com.didichuxing.apollo.sdk.IToggle r0 = com.didichuxing.apollo.sdk.Apollo.getToggle(r0)
            com.didichuxing.apollo.sdk.IExperiment r0 = r0.getExperiment()
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            java.lang.String r2 = "ora_url_host"
            java.lang.String r3 = "https://apimap.didiglobal.com"
            java.lang.Object r2 = r0.getParam(r2, r3)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r4 = m19909a(r4)
            java.lang.String r3 = "com.linkee.global"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0030
            java.lang.String r4 = "canoe_ora_url_host"
            java.lang.String r2 = "https://apimap.liggyglobal.com"
            java.lang.Object r4 = r0.getParam(r4, r2)
            r2 = r4
            java.lang.String r2 = (java.lang.String) r2
        L_0x0030:
            r1.append(r2)
            java.lang.String r4 = "ora_url_path"
            java.lang.String r2 = "/navi/v1/passenger/orderroute/"
            java.lang.Object r4 = r0.getParam(r4, r2)
            java.lang.String r4 = (java.lang.String) r4
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.google.util.ApolloUtils.getOraRequestUrl(android.content.Context):java.lang.String");
    }

    public static boolean getAlarmOmegaToggle() {
        IToggle toggle = Apollo.getToggle("global_bi_alarm_passenger_upload");
        return toggle != null && toggle.allow() && ((String) toggle.getExperiment().getParam("android_event_name", "")).contains("tech_global_sctx_show_error");
    }

    public static boolean getSctxAbnormalErrorOmegaToggle() {
        IToggle toggle = Apollo.getToggle("global_bi_alarm_passenger_upload");
        return toggle != null && toggle.allow() && ((String) toggle.getExperiment().getParam("android_event_name", "")).contains("tech_global_sctx_abnormal_error");
    }

    public static boolean getPickupPrecToggle() {
        IToggle toggle = Apollo.getToggle("global_map_order_pickuprec_toggle");
        if (toggle == null || !toggle.allow() || ((Integer) toggle.getExperiment().getParam("is_enable", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    public static boolean supportHuaWeiToggle() {
        IToggle toggle = Apollo.getToggle("global_map_order_pickuprec_toggle");
        if (toggle == null || !toggle.allow() || ((Integer) toggle.getExperiment().getParam("support_huawei", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static String m19909a(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return null;
        }
        return context.getApplicationContext().getPackageName();
    }

    public static boolean enableBluetoothScan() {
        IExperiment experiment;
        boolean z = Config.DEFAULT_BLUETOOTH_SCAN;
        String c = m19911c();
        if (!TextUtils.isEmpty(c)) {
            DLog.m19914d(GlobalCashierCoreModule.APOLLO, "enableBluetoothScan key =" + c, new Object[0]);
            IToggle toggle = Apollo.getToggle(c);
            if (!(toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null)) {
                if (((Integer) experiment.getParam("enable", 0)).intValue() == 1) {
                    return true;
                }
                return false;
            }
        } else {
            DLog.m19914d(GlobalCashierCoreModule.APOLLO, "enableBluetoothScan key = null", new Object[0]);
        }
        return z;
    }

    /* renamed from: c */
    private static String m19911c() {
        IExperiment experiment;
        try {
            IToggle toggle = Apollo.getToggle("global_map_caiman_parameter");
            if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
                return null;
            }
            String str = (String) experiment.getParam("caiman_sctx_bluetooth_toggle", "");
            if (Config.DEBUG) {
                String str2 = Config.DEBUG_TAG;
                SystemUtils.log(3, str2, "caiman_sctx_bluetooth_toggle:" + str, (Throwable) null, "com.didi.map.google.util.ApolloUtils", 218);
            }
            return str;
        } catch (Exception e) {
            if (Config.DEBUG) {
                String str3 = Config.DEBUG_TAG;
                SystemUtils.log(3, str3, "getBluetoothScanApolloKey, e :" + e.toString(), (Throwable) null, "com.didi.map.google.util.ApolloUtils", 225);
            }
            e.printStackTrace();
            return null;
        }
    }

    public static int getBluetoothScanOmegaReportRate() {
        IExperiment experiment;
        try {
            IToggle toggle = Apollo.getToggle("global_map_bluetooth_parameter");
            if (!(toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null)) {
                int intValue = ((Integer) experiment.getParam("scan_result_sample_rate", 0)).intValue();
                if (Config.DEBUG) {
                    String str = Config.DEBUG_TAG;
                    SystemUtils.log(3, str, "scan_result_sample_rate:" + intValue, (Throwable) null, "com.didi.map.google.util.ApolloUtils", 244);
                }
                return intValue;
            }
        } catch (Exception e) {
            if (Config.DEBUG) {
                String str2 = Config.DEBUG_TAG;
                SystemUtils.log(3, str2, "getBluetoothScanOmegaReportRate, e :" + e.toString(), (Throwable) null, "com.didi.map.google.util.ApolloUtils", 251);
            }
            e.printStackTrace();
        }
        return 0;
    }

    static {
        initCompLineForSctx();
        m19912d();
    }

    public static boolean useCompLineForSctx() {
        return f27806c;
    }

    public static boolean useCompLineTexture() {
        return f27807d;
    }

    public static void initCompLineForSctx() {
        IExperiment experiment;
        try {
            IToggle toggle = Apollo.getToggle("global_map_sctx_traffic_line_ab");
            if (toggle != null && toggle.allow() && (experiment = toggle.getExperiment()) != null) {
                boolean z = false;
                f27806c = ((Integer) experiment.getParam("use_compline", 0)).intValue() > 0;
                if (((Integer) experiment.getParam("use_compline_texture", 0)).intValue() > 0) {
                    z = true;
                }
                f27807d = z;
                if (Config.DEBUG) {
                    String str = Config.DEBUG_TAG;
                    SystemUtils.log(3, str, "use compline component: " + f27806c + " compline texture: " + f27807d, (Throwable) null, "com.didi.map.google.util.ApolloUtils", 293);
                }
            }
        } catch (Exception e) {
            if (Config.DEBUG) {
                String str2 = Config.DEBUG_TAG;
                SystemUtils.log(3, str2, "getSctxTrafficParamAB, e :" + e.toString(), (Throwable) null, "com.didi.map.google.util.ApolloUtils", 299);
            }
            e.printStackTrace();
        }
    }

    public static boolean newEdaCalculator() {
        return com.map.sdk.nav.hawaii.ApolloUtils.INSTANCE.isPasNeedUseHawaiiMatcher() && f27808e;
    }

    /* renamed from: d */
    private static void m19912d() {
        IExperiment experiment;
        try {
            IToggle toggle = Apollo.getToggle("global_map_sctx_new_eda_cal_ab");
            if (toggle != null && toggle.allow() && (experiment = toggle.getExperiment()) != null) {
                boolean z = false;
                if (((Integer) experiment.getParam("status", 0)).intValue() > 0) {
                    z = true;
                }
                f27808e = z;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
