package com.didi.map.sdk.sharetrack.google.inner.utils;

import com.didi.map.sdk.nav.inertia.ApolloParamsSctxPrediction;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.example.compapollovisitor.ApolloVisitHelper;

public class ApolloUtils {

    /* renamed from: a */
    private static final String f28888a = "ShareTrack || ApolloUtils";

    /* renamed from: b */
    private static IToggle f28889b = Apollo.getToggle("global_drvier_map_enable_match_mock");

    /* renamed from: c */
    private static int f28890c = 0;

    /* renamed from: d */
    private static float f28891d = 0.8f;

    /* renamed from: e */
    private static int f28892e = 10;

    /* renamed from: f */
    private static int f28893f = 0;

    /* renamed from: g */
    private static int f28894g = 300;

    /* renamed from: h */
    private static boolean f28895h = false;

    /* renamed from: i */
    private static int f28896i = 30;

    /* renamed from: j */
    private static int f28897j = 70;

    /* renamed from: k */
    private static boolean f28898k = false;

    /* renamed from: l */
    private static int f28899l = 30;

    public static int getEtaInterval(int i) {
        return 60000;
    }

    static {
        ApolloVisitHelper.getInstance().addApolloKey("global_drvier_map_enable_match_mock");
        if (f28889b.allow()) {
            IExperiment experiment = f28889b.getExperiment();
            boolean z = false;
            f28890c = ((Integer) experiment.getParam("enableMock", 0)).intValue();
            try {
                f28891d = Float.valueOf((String) experiment.getParam("coefficient", "0.8")).floatValue();
            } catch (Exception unused) {
            }
            f28892e = ((Integer) experiment.getParam("distDisableMock", 10)).intValue();
            f28893f = ((Integer) experiment.getParam("enableOmg", 0)).intValue();
            f28894g = ((Integer) experiment.getParam("startOmgDist", 300)).intValue();
            IToggle toggle = Apollo.getToggle("map_driver_route_end_unreachable");
            if (toggle != null && toggle.allow()) {
                IExperiment experiment2 = toggle.getExperiment();
                f28895h = ((Integer) experiment2.getParam("tts", 0)).intValue() == 1;
                f28896i = ((Integer) experiment2.getParam("tts_distance", 30)).intValue();
                f28897j = ((Integer) experiment2.getParam("tts_eda", 70)).intValue();
                if (((Integer) experiment2.getParam("guide_line", 0)).intValue() == 1) {
                    z = true;
                }
                f28898k = z;
                f28899l = ((Integer) experiment2.getParam("guide_line_distance", 30)).intValue();
            }
        }
    }

    public static boolean IsPickUpUploadeEnable() {
        IToggle toggle = Apollo.getToggle("global_driver_pickup_point_upload_switch");
        if (toggle == null || !toggle.allow()) {
            DLog.m20357d(f28888a, "IsPickUpUploadeEnable:false", new Object[0]);
            return false;
        }
        DLog.m20357d(f28888a, "IsPickUpUploadeEnable:true", new Object[0]);
        return true;
    }

    public static ApolloParamsSctxPrediction getSctxPredictionApolloParams() {
        ApolloParamsSctxPrediction apolloParamsSctxPrediction = new ApolloParamsSctxPrediction();
        apolloParamsSctxPrediction.enableMock = f28890c;
        apolloParamsSctxPrediction.coefficient = f28891d;
        apolloParamsSctxPrediction.distDisableMock = f28892e;
        apolloParamsSctxPrediction.enableOmg = f28893f;
        apolloParamsSctxPrediction.startOmgDist = f28894g;
        return apolloParamsSctxPrediction;
    }

    public static boolean isRetryRoute() {
        return Apollo.getToggle("map_global_driver_ora_retry").allow();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r0 = r0.getExperiment();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isServerRejectYaw() {
        /*
            java.lang.String r0 = "global_map_match_yaw_config_toggle_new"
            com.didichuxing.apollo.sdk.IToggle r0 = com.didichuxing.apollo.sdk.Apollo.getToggle(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0026
            boolean r2 = r0.allow()
            if (r2 == 0) goto L_0x0026
            com.didichuxing.apollo.sdk.IExperiment r0 = r0.getExperiment()
            if (r0 == 0) goto L_0x0026
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            java.lang.String r3 = "is_server_reject_yaw"
            java.lang.Object r0 = r0.getParam(r3, r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            goto L_0x0027
        L_0x0026:
            r0 = 0
        L_0x0027:
            if (r0 != 0) goto L_0x002a
            return r1
        L_0x002a:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.sharetrack.google.inner.utils.ApolloUtils.isServerRejectYaw():boolean");
    }

    public static int getYawModelType() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("global_map_match_yaw_config_toggle_new");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
            return 0;
        }
        return ((Integer) experiment.getParam("yaw_model_type", 0)).intValue();
    }

    public static boolean getBERTtsEnable() {
        return f28895h;
    }

    public static int getBERTtsDistance() {
        return f28896i;
    }

    public static int getBERTtsEda() {
        return f28897j;
    }

    public static boolean getBERGuideLineEnable() {
        return f28898k;
    }

    public static int getBERGuideLineDistance() {
        return f28899l;
    }
}
