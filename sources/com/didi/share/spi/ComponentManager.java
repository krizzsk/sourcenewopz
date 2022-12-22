package com.didi.share.spi;

import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ComponentManager {

    /* renamed from: a */
    private static ComponentManager f38623a = new ComponentManager();

    /* renamed from: b */
    private Map<Class, Object> f38624b = new ConcurrentHashMap();

    private ComponentManager() {
    }

    public static ComponentManager getInstance() {
        return f38623a;
    }

    public <S> S getComponent(Class<S> cls) {
        S s = this.f38624b.get(cls);
        if (s != null) {
            return s;
        }
        Iterator<S> it = ServiceLoader.load(cls).iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        this.f38624b.put(cls, next);
        return next;
    }

    public <S> Iterator<S> getComponentIterator(Class<S> cls) {
        return ServiceLoader.load(cls).iterator();
    }
}
