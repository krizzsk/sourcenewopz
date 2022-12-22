package org.xidea.p087el.impl;

import java.util.Map;

/* renamed from: org.xidea.el.impl.RefrenceStackImpl */
/* compiled from: ValueStackImpl */
class RefrenceStackImpl extends ValueStackImpl {
    public RefrenceStackImpl(Object... objArr) {
        super(objArr);
    }

    public Object get(Object obj) {
        int length = this.stack.length;
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return null;
            }
            Object obj2 = this.stack[i];
            if (obj2 instanceof Map) {
                return new ReferenceImpl(obj2, obj);
            }
            if (ReflectUtil.getPropertyType(obj2.getClass(), obj) != null) {
                return new ReferenceImpl(obj2, obj);
            }
            length = i;
        }
    }
}
