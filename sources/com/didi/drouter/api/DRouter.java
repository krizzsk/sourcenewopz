package com.didi.drouter.api;

import android.app.Application;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.IRouterMonitor;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.RouterMonitor;
import com.didi.drouter.service.ServiceLoader;
import com.didi.drouter.store.IRegister;
import com.didi.drouter.store.RouterKey;
import com.didi.drouter.store.RouterStore;
import com.didi.drouter.store.ServiceKey;
import com.didi.drouter.utils.SystemUtil;

public class DRouter {
    public static Application getContext() {
        return SystemUtil.getApplication();
    }

    public static void init(Application application) {
        SystemUtil.setApplication(application);
        RouterStore.load("host");
    }

    public static Request build(String str) {
        return Request.build(str);
    }

    public static <T> ServiceLoader<T> build(Class<T> cls) {
        return ServiceLoader.build(cls);
    }

    public static IRegister register(RouterKey routerKey, IRouterHandler iRouterHandler) {
        return RouterStore.register(routerKey, iRouterHandler);
    }

    public static <T> IRegister register(ServiceKey<T> serviceKey, T t) {
        return RouterStore.register(serviceKey, t);
    }

    public static void registerMonitor(IRouterMonitor iRouterMonitor) {
        RouterMonitor.register(iRouterMonitor);
    }

    public static void unregisterMonitor(IRouterMonitor iRouterMonitor) {
        RouterMonitor.unregister(iRouterMonitor);
    }
}
