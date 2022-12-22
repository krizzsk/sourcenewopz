package org.xidea.lite;

import java.util.HashMap;
import java.util.Map;
import org.xidea.p087el.ValueStack;
import org.xidea.p087el.impl.ReflectUtil;

class Context implements ValueStack {
    private static final long serialVersionUID = 1;
    private Map<String, Object> base;
    private Map<Object, Object> cache = null;

    public Context(Object obj) {
        this.base = ReflectUtil.map(obj);
    }

    public Object get(Object obj) {
        Object obj2;
        Map<Object, Object> map = this.cache;
        if (map != null && ((obj2 = map.get(obj)) != null || this.cache.containsKey(obj))) {
            return obj2;
        }
        Map<String, Object> map2 = this.base;
        if (map2 == null) {
            return null;
        }
        return map2.get(obj);
    }

    public void put(Object obj, Object obj2) {
        if (this.cache == null) {
            this.cache = new HashMap();
        }
        this.cache.put(obj, obj2);
    }
}
