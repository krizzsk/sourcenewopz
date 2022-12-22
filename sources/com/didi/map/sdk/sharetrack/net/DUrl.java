package com.didi.map.sdk.sharetrack.net;

import android.content.Context;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class DUrl {
    public static final String PACKAGE_NAME_DRIVER_RU = "com.didiglobal.driver.ru";

    /* renamed from: a */
    private static final String f28901a = "DUrl";

    /* renamed from: b */
    private static final String f28902b = "com.didiglobal.driver";

    /* renamed from: c */
    private static final String f28903c = "com.didiglobal.driver.au";

    /* renamed from: d */
    private static final String f28904d = "com.sdu.didi.gsui.jp";

    /* renamed from: e */
    private static final String f28905e = "com.app99.driver";

    /* renamed from: a */
    private static String m20358a(Context context) {
        return "/navi/v1/routeplan/";
    }

    public static String getPathURL_PushRoute(Context context) {
        return "/navi/v1/driver/pushroute/sctx2/";
    }

    public static String getOrderFeatureDataUrl(Context context) {
        return getDomainURL(context) + "/navi/v1/orderfeature/";
    }

    public static String getOrderRouteUrl(Context context) {
        String str = getDomainURL(context) + m20359b(context);
        IToggle toggle = Apollo.getToggle("global_driver_route_url_toggle");
        if (toggle != null && toggle.allow()) {
            str = (String) toggle.getExperiment().getParam("orderroute", str);
        }
        DLog.m20357d(f28901a, "getRoutePlanUrl: %s", str);
        return str;
    }

    public static String getRoutePlanUrl(Context context) {
        String str = getDomainURL(context) + m20358a(context);
        IToggle toggle = Apollo.getToggle("global_driver_route_url_toggle");
        if (toggle != null && toggle.allow()) {
            str = (String) toggle.getExperiment().getParam("routeplan", str);
        }
        DLog.m20357d(f28901a, "getRoutePlanUrl: %s", str);
        return str;
    }

    public static String getPushRouteUrl(Context context) {
        String str = getDomainURL(context) + getPathURL_PushRoute(context);
        IToggle toggle = Apollo.getToggle("global_driver_route_url_toggle");
        if (toggle != null && toggle.allow()) {
            str = (String) toggle.getExperiment().getParam("pushRoute", str);
        }
        DLog.m20357d(f28901a, "getPushRouteUrl: %s", str);
        return str;
    }

    /* renamed from: b */
    private static String m20359b(Context context) {
        boolean equals = ((context == null || context.getApplicationContext() == null) ? "" : context.getApplicationContext().getPackageName()).equals("com.app99.driver");
        return "/navi/v1/driver/orderroute/";
    }

    public static String getDomainURL(Context context) {
        String packageName = (context == null || context.getApplicationContext() == null) ? "" : context.getApplicationContext().getPackageName();
        if (!packageName.equals(f28902b) && !packageName.equals(f28903c) && !packageName.equals(f28904d) && !packageName.equals("com.app99.driver")) {
            if (packageName.contains(PACKAGE_NAME_DRIVER_RU)) {
                return "https://apimap-ru.didiglobal.com";
            }
            boolean contains = packageName.contains("google");
        }
        return "https://apimap.didiglobal.com";
    }
}
