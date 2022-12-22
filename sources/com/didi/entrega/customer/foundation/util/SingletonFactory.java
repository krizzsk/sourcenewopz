package com.didi.entrega.customer.foundation.util;

import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.storage.CreateInstance;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

public final class SingletonFactory {

    /* renamed from: a */
    private static final String f20153a = "SingletonFactory";

    /* renamed from: b */
    private static ConcurrentHashMap<Class<?>, Object> f20154b = new ConcurrentHashMap<>();

    private SingletonFactory() {
    }

    public static <T> T get(Class<T> cls) {
        return get(cls, (CreateInstance) null);
    }

    public static <T> T get(Class<T> cls, CreateInstance<T> createInstance) {
        T t;
        T t2 = f20154b.get(cls);
        if (t2 != null) {
            LogUtil.m14761d(f20153a, "SingletonFactory<" + cls.getSimpleName() + "> cache hit.");
            return t2;
        }
        if (createInstance == null) {
            LogUtil.m14761d(f20153a, "Create instance by createInstance()");
            t = m14844a(cls);
        } else {
            LogUtil.m14761d(f20153a, "Create instance by createInstance.create()");
            t = createInstance.create(cls);
        }
        f20154b.put(cls, t);
        return t;
    }

    public static void remove(Class<?> cls) {
        f20154b.remove(cls);
    }

    public static void clear() {
        f20154b.clear();
    }

    /* renamed from: a */
    private static <T> T m14844a(Class<T> cls) {
        T t;
        Constructor constructor;
        Constructor[] declaredConstructors = cls.getDeclaredConstructors();
        int length = declaredConstructors.length;
        int i = 0;
        while (true) {
            t = null;
            if (i >= length) {
                constructor = null;
                break;
            }
            constructor = declaredConstructors[i];
            if (constructor.getParameterTypes().length == 0 && !constructor.isAccessible()) {
                constructor.setAccessible(true);
                break;
            }
            i++;
        }
        try {
            t = constructor.newInstance(new Object[0]);
            LogUtil.m14761d(f20153a, "Create storage instance: " + cls.getSimpleName());
            return t;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return t;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return t;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return t;
        }
    }
}
