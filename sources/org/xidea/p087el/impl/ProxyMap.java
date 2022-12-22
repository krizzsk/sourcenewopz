package org.xidea.p087el.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: org.xidea.el.impl.ProxyMap */
class ProxyMap extends HashMap<String, Object> {
    private static final long serialVersionUID = 1;

    ProxyMap(Object obj, Set<String> set) {
        for (String next : set) {
            super.put(next, new ReferenceImpl(obj, next));
        }
    }

    public Object get(Object obj) {
        Object obj2 = super.get(obj);
        return obj2 instanceof ReferenceImpl ? ((ReferenceImpl) obj2).getValue() : obj2;
    }

    public Set<Map.Entry<String, Object>> entrySet() {
        Set<Map.Entry<String, Object>> entrySet = super.entrySet();
        for (Map.Entry next : entrySet) {
            Object value = next.getValue();
            if (value instanceof ReferenceImpl) {
                next.setValue(((ReferenceImpl) value).getValue());
            }
        }
        return entrySet;
    }

    public Collection<Object> values() {
        entrySet();
        return super.values();
    }

    public Object put(String str, Object obj) {
        Object put = super.put(str, obj);
        return put instanceof ReferenceImpl ? ((ReferenceImpl) put).setValue(obj) : put;
    }
}
