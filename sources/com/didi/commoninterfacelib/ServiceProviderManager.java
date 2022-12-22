package com.didi.commoninterfacelib;

import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceProviderManager {

    /* renamed from: a */
    private static ServiceProviderManager f10959a = new ServiceProviderManager();

    /* renamed from: b */
    private Map<Class, Object> f10960b = new ConcurrentHashMap();

    private ServiceProviderManager() {
    }

    public static ServiceProviderManager getInstance() {
        return f10959a;
    }

    public <S> S getComponent(Class<S> cls) {
        S s = this.f10960b.get(cls);
        if (s != null) {
            return s;
        }
        Iterator<S> it = ServiceLoader.load(cls).iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        this.f10960b.put(cls, next);
        return next;
    }

    public <S> Iterator<S> getComponentIterator(Class<S> cls) {
        return ServiceLoader.load(cls).iterator();
    }
}
