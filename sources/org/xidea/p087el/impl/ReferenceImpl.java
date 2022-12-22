package org.xidea.p087el.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.xidea.p087el.Invocable;
import org.xidea.p087el.Reference;

/* renamed from: org.xidea.el.impl.ReferenceImpl */
class ReferenceImpl implements Reference {
    private static Map<String, Invocable> cachedInvocableMap = new HashMap();
    private Object base;
    private Object name;
    private Class<? extends Object> type;

    public ReferenceImpl(Object obj, Object obj2) {
        this.base = obj;
        this.name = obj2;
    }

    public String toString() {
        return String.valueOf(getValue());
    }

    public Reference next(Object obj) {
        if (this.base != null) {
            Object value = getValue();
            if (value == null) {
                this.type = ReflectUtil.getPropertyType(this.base.getClass(), this.name);
                this.base = null;
            } else {
                this.base = value;
            }
        } else {
            Class<? extends Object> cls = this.type;
            if (cls != null) {
                this.type = ReflectUtil.getPropertyType(cls, this.name);
            }
        }
        this.name = obj;
        return this;
    }

    public Object getBase() {
        return this.base;
    }

    public Object getValue() {
        return ReflectUtil.getValue(this.base, this.name);
    }

    public Class<? extends Object> getType() {
        Class<? extends Object> cls = this.type;
        if (cls != null) {
            return ReflectUtil.getPropertyType(cls, this.name);
        }
        if (this.base == null) {
            return null;
        }
        Object value = getValue();
        if (value != null) {
            return value.getClass();
        }
        Class<? extends Object> propertyType = ReflectUtil.getPropertyType(this.base.getClass(), this.name);
        return propertyType == null ? Object.class : propertyType;
    }

    public Object setValue(Object obj) {
        ReflectUtil.setValue(this.base, this.name, obj);
        return null;
    }

    static Invocable createInvocable(Reference reference, Map<String, Map<String, Invocable>> map, Object[] objArr) {
        Invocable createInvocable = createInvocable(map, reference.getBase(), reference.getName().toString(), objArr);
        if (createInvocable != null) {
            return createInvocable;
        }
        Object value = reference.getValue();
        if (value instanceof Invocable) {
            return (Invocable) value;
        }
        if (!(value instanceof Method)) {
            return createInvocable;
        }
        return createProxy((Method) value);
    }

    static Invocable createInvocable(Map<String, Map<String, Invocable>> map, Object obj, String str, Object[] objArr) {
        Map map2 = map.get(str);
        Invocable findInvocable = map2 != null ? findInvocable(map2, obj.getClass()) : null;
        if (findInvocable != null) {
            return findInvocable;
        }
        Invocable invocable = getInvocable(obj.getClass(), str, objArr.length);
        return (invocable != null || !(obj instanceof Class)) ? invocable : getInvocable((Class) obj, str, objArr.length);
    }

    static Invocable getInvocable(Class<? extends Object> cls, String str, int i) {
        String str2 = String.valueOf(cls.getName()) + '.' + i + str;
        Invocable invocable = cachedInvocableMap.get(str2);
        if (invocable != null || cachedInvocableMap.containsKey(str2)) {
            return invocable;
        }
        ArrayList arrayList = new ArrayList();
        for (Method method : cls.getMethods()) {
            if (method.getName().equals(str) && (i < 0 || method.getParameterTypes().length == i)) {
                arrayList.add(method);
            }
        }
        if (arrayList.size() <= 0) {
            return invocable;
        }
        Invocable createProxy = createProxy((Method[]) arrayList.toArray(new Method[arrayList.size()]));
        cachedInvocableMap.put(str2, createProxy);
        return createProxy;
    }

    static Invocable findInvocable(Map<String, Invocable> map, Class<?> cls) {
        Invocable invocable = map.get(cls.getName());
        if (invocable != null) {
            return invocable;
        }
        for (Class findInvocable : cls.getInterfaces()) {
            Invocable findInvocable2 = findInvocable(map, findInvocable);
            if (findInvocable2 != null) {
                return findInvocable2;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == cls || superclass == null) {
            return null;
        }
        return findInvocable(map, superclass);
    }

    static Invocable createProxy(Method... methodArr) {
        for (Method accessible : methodArr) {
            try {
                accessible.setAccessible(true);
            } catch (Exception unused) {
            }
        }
        MethodInvocable methodInvocable = new MethodInvocable();
        methodInvocable.methods = methodArr;
        return methodInvocable;
    }

    public Object getName() {
        return this.name;
    }
}
