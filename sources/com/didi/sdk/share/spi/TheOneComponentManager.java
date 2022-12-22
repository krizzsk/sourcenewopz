package com.didi.sdk.share.spi;

import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TheOneComponentManager {

    /* renamed from: a */
    private static TheOneComponentManager f37168a = new TheOneComponentManager();

    /* renamed from: b */
    private Map<Class, Object> f37169b = new ConcurrentHashMap();

    private TheOneComponentManager() {
    }

    public static TheOneComponentManager getInstance() {
        return f37168a;
    }

    public <S> S getComponent(Class<S> cls) {
        S s = this.f37169b.get(cls);
        if (s != null) {
            return s;
        }
        Iterator<S> it = ServiceLoader.load(cls).iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        this.f37169b.put(cls, next);
        return next;
    }

    public <S> Iterator<S> getComponentIterator(Class<S> cls) {
        return ServiceLoader.load(cls).iterator();
    }
}
