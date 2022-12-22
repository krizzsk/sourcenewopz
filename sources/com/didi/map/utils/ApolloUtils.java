package com.didi.map.utils;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;

public class ApolloUtils {

    /* renamed from: a */
    private static int f29024a = -1;

    /* renamed from: b */
    private static boolean f29025b;

    static {
        m20429a();
    }

    public static boolean getSctxCaseParserOn() {
        IExperiment experiment;
        int i = f29024a;
        if (i >= 0) {
            return i > 0;
        }
        IToggle toggle = Apollo.getToggle("global_map_sctx_case_parser_toggle");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
            return false;
        }
        int intValue = ((Integer) experiment.getParam("switch_on", 0)).intValue();
        f29024a = intValue;
        if (intValue > 0) {
            return true;
        }
        return false;
    }

    public static boolean oraErrorDoSimulate() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("global_map_ora_error_do_simulate_toggle_1");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null || ((Integer) experiment.getParam("enable", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    public static boolean enableRefreshTraffic() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("global_map_refresh_traffic_enable");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null || ((Integer) experiment.getParam("enable", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static void m20429a() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("global_map_order_float_window_ab");
        if (toggle != null && toggle.allow() && (experiment = toggle.getExperiment()) != null) {
            boolean z = false;
            if (((Integer) experiment.getParam("enable", 0)).intValue() == 1) {
                z = true;
            }
            f29025b = z;
        }
    }

    public static boolean enableOrderFloatWindow() {
        return f29025b;
    }
}
