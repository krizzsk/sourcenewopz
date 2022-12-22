package com.didi.sdk.push;

import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class SpiComponentManager {
    private static SpiComponentManager INSTANCE = new SpiComponentManager();
    private Map<Class, Object> cacheMap = new ConcurrentHashMap();

    private SpiComponentManager() {
    }

    public static SpiComponentManager getInstance() {
        return INSTANCE;
    }

    public <S> S getComponent(Class<S> cls) {
        S s = this.cacheMap.get(cls);
        if (s != null) {
            return s;
        }
        Iterator<S> it = ServiceLoader.load(cls).iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        this.cacheMap.put(cls, next);
        return next;
    }

    public <S> Iterator<S> getComponentIterator(Class<S> cls) {
        return ServiceLoader.load(cls).iterator();
    }
}
