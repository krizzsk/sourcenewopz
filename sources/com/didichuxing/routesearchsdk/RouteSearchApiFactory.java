package com.didichuxing.routesearchsdk;

import android.content.Context;
import com.didi.common.map.util.NetUtils;
import com.didichuxing.routesearchsdk.bubblepage.BubblePageRouteSearchApiImpl;
import com.didichuxing.routesearchsdk.bubblepage.IBubblePageRouteSearchApi;
import com.didichuxing.routesearchsdk.multi.IMultiRouteSearchApi;
import com.didichuxing.routesearchsdk.multi.MultiRouteSearchApiImpl;
import com.didichuxing.routesearchsdk.walk.IWalkNavRouteSearchApi;
import com.didichuxing.routesearchsdk.walk.WalkNavRouteSearchApiImpl;

public class RouteSearchApiFactory {
    public static IRouteSearchApi createRouteSearch(Context context) {
        if (context != null) {
            m34795a(context);
            return new RouteSearchApiImpl();
        }
        throw new RuntimeException("context is null");
    }

    public static IRouteSearchApi createRouteSearch(Context context, String str) {
        RouteSearchUrls.setHostGlobal(str);
        return createRouteSearch(context);
    }

    public static IMultiRouteSearchApi createMultiRouteSearch(Context context, String str) {
        RouteSearchUrls.setHostGlobal(str);
        return createMultiRouteSearch(context);
    }

    public static IMultiRouteSearchApi createMultiRouteSearch(Context context) {
        if (context != null) {
            m34795a(context);
            return new MultiRouteSearchApiImpl();
        }
        throw new RuntimeException("context is null");
    }

    public static IBubblePageRouteSearchApi createBubblePageRouteSearch(Context context) {
        if (context != null) {
            m34795a(context);
            return new BubblePageRouteSearchApiImpl();
        }
        throw new RuntimeException("context is null");
    }

    public static IWalkNavRouteSearchApi createWalkNavSearch(Context context) {
        if (context != null) {
            m34795a(context);
            return new WalkNavRouteSearchApiImpl();
        }
        throw new RuntimeException("context is null");
    }

    /* renamed from: a */
    private static void m34795a(Context context) {
        NetUtils.init(context);
    }
}
