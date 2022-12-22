package org.xidea.p087el.impl;

import java.util.Map;
import org.xidea.p087el.ValueStack;

/* renamed from: org.xidea.el.impl.ValueStackImpl */
public class ValueStackImpl implements ValueStack {
    protected Object[] stack;

    /* access modifiers changed from: protected */
    public Object fallback(Object obj) {
        return null;
    }

    public ValueStackImpl(Object... objArr) {
        this.stack = objArr;
    }

    public Object get(Object obj) {
        Object obj2;
        int length = this.stack.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return fallback(obj);
            }
            Object obj3 = this.stack[i];
            if (obj3 instanceof Map) {
                Map map = (Map) obj3;
                obj2 = map.get(obj);
                if (obj2 != null || map.containsKey(obj)) {
                    return obj2;
                }
            } else if (obj3 != null) {
                Object value = ReflectUtil.getValue(obj3, obj);
                Class<?> cls = obj3.getClass();
                if (value != null || ReflectUtil.getPropertyType(cls, obj) != null) {
                    return value;
                }
                if (obj instanceof String) {
                    return ReferenceImpl.getInvocable(cls, (String) obj, -1);
                }
            } else {
                continue;
            }
            length = i;
        }
        return obj2;
    }

    public void put(Object obj, Object obj2) {
        put(obj, obj2, -1);
    }

    public void put(Object obj, Object obj2, int i) {
        if (i < 0) {
            i += this.stack.length;
        }
        ReflectUtil.setValue(this.stack[i], obj, obj2);
    }
}
