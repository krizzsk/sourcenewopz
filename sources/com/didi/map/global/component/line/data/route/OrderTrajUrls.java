package com.didi.map.global.component.line.data.route;

import android.content.Context;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;

public class OrderTrajUrls {

    /* renamed from: a */
    private static final String f25822a = "https://apimap.didiglobal.com";

    /* renamed from: b */
    private static final String f25823b = "https://apimap.liggyglobal.com";

    /* renamed from: c */
    private static final String f25824c = "/navi/v1/ordertraj/";

    /* renamed from: d */
    private static final String f25825d = "com.linkee.global";

    /* renamed from: e */
    private static String f25826e = "https://apimap.didiglobal.com";

    public static String getOrderTrajUrl(Context context) {
        IToggle toggle = Apollo.getToggle("global_passenger_route_url_toggle");
        if (toggle != null && toggle.allow()) {
            IExperiment experiment = toggle.getExperiment();
            return ((String) experiment.getParam("order_traj_host", "https://apimap.didiglobal.com")) + ((String) experiment.getParam("order_traj_path", f25824c));
        } else if (m18388a(context)) {
            return "https://apimap.liggyglobal.com/navi/v1/ordertraj/";
        } else {
            return f25826e + f25824c;
        }
    }

    public static void setOrderTrajHost(String str) {
        f25826e = str;
    }

    /* renamed from: a */
    private static boolean m18388a(Context context) {
        return f25825d.equals(m18389b(context));
    }

    /* renamed from: b */
    private static String m18389b(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return null;
        }
        return context.getApplicationContext().getPackageName();
    }

    public static String getUrlHost(Context context) {
        return m18388a(context) ? f25823b : "https://apimap.didiglobal.com";
    }
}
