package com.didi.drouter.router;

import com.didi.drouter.store.RouterMeta;
import java.util.ArrayList;
import java.util.List;

public class RouterMonitor {

    /* renamed from: a */
    private static final List<IRouterMonitor> f19196a = new ArrayList();

    public static void register(IRouterMonitor iRouterMonitor) {
        f19196a.remove(iRouterMonitor);
        f19196a.add(iRouterMonitor);
    }

    public static void unregister(IRouterMonitor iRouterMonitor) {
        f19196a.remove(iRouterMonitor);
    }

    public static void handleRequest(Request request, RouterMeta routerMeta, String str) {
        for (IRouterMonitor next : f19196a) {
            if (next != null) {
                next.onRequest(request, routerMeta, str);
            }
        }
        if (routerMeta != null) {
            routerMeta.clearInterceptorHandled(request.getNumber());
        }
    }
}
