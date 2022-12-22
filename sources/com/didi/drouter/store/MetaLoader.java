package com.didi.drouter.store;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class MetaLoader {

    public interface IMetaGetter<T> {
        T getService();

        Class<T> getServiceClass();
    }

    public abstract void load(Map<?, ?> map);

    /* access modifiers changed from: protected */
    public void put(String str, RouterMeta routerMeta, Map<String, Map<String, RouterMeta>> map) {
        Map map2 = map.get("RegexRouter");
        if (map2 == null) {
            map2 = new ConcurrentHashMap();
            map.put("RegexRouter", map2);
        }
        map2.put(str, routerMeta);
    }

    /* access modifiers changed from: protected */
    public void put(Class<?> cls, RouterMeta routerMeta, Map<Class<?>, Set<RouterMeta>> map) {
        Set set = map.get(cls);
        if (set == null) {
            set = Collections.newSetFromMap(new ConcurrentHashMap());
            map.put(cls, set);
        }
        set.add(routerMeta);
    }
}
