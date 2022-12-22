package com.didichuxing.routesearchsdk;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;

public class RouteSearchUrls {

    /* renamed from: a */
    private static final String f48528a = "/navi/v1/routeplan/";

    /* renamed from: b */
    private static final String f48529b = "/navi/v1/multirouteplan/";

    /* renamed from: c */
    private static final String f48530c = "/bubblepage/";

    /* renamed from: d */
    private static final String f48531d = "/navi/v1/order/walking/";

    /* renamed from: e */
    private static String f48532e = "https://apimap.didiglobal.com";

    /* renamed from: f */
    private static String f48533f = "/preus/bubblepage/";

    public static void setHostGlobal(String str) {
        if (!TextUtils.isEmpty(str)) {
            f48532e = str;
        }
    }

    public static String getRoutePlanUrl() {
        IToggle toggle = Apollo.getToggle("global_passenger_route_url_toggle");
        if (toggle == null || !toggle.allow()) {
            return f48532e + f48528a;
        }
        IExperiment experiment = toggle.getExperiment();
        return ((String) experiment.getParam("rp_url_host", f48532e)) + ((String) experiment.getParam("rp_url_path", f48528a));
    }

    public static String getMultiRoutePlanUrl() {
        IToggle toggle = Apollo.getToggle("global_passenger_route_url_toggle");
        if (toggle == null || !toggle.allow()) {
            return f48532e + f48529b;
        }
        IExperiment experiment = toggle.getExperiment();
        return ((String) experiment.getParam("multi_rp_host", f48532e)) + ((String) experiment.getParam("multi_rp_path", f48529b));
    }

    public static String getBubblePageRouteSearchUrl() {
        IToggle toggle = Apollo.getToggle("global_passenger_route_url_toggle");
        if (toggle == null || !toggle.allow()) {
            return f48532e + f48530c;
        }
        IExperiment experiment = toggle.getExperiment();
        return ((String) experiment.getParam("bubpage_host", f48532e)) + ((String) experiment.getParam("bubpage_path", f48530c));
    }

    public static String getWalkNavRouteUrl() {
        IToggle toggle = Apollo.getToggle("global_passenger_route_url_toggle");
        if (toggle == null || !toggle.allow()) {
            return f48532e + f48531d;
        }
        return ((String) toggle.getExperiment().getParam("order_walk_ora_host", f48532e)) + f48531d;
    }
}
