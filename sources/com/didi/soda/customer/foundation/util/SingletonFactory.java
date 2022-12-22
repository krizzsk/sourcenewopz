package com.didi.soda.customer.foundation.util;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.storage.CreateInstance;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

public final class SingletonFactory {

    /* renamed from: a */
    private static final String f41255a = "SingletonFactory";

    /* renamed from: b */
    private static ConcurrentHashMap<Class<?>, Object> f41256b = new ConcurrentHashMap<>();

    private SingletonFactory() {
    }

    public static <T> T get(Class<T> cls) {
        return get(cls, (CreateInstance) null);
    }

    public static <T> T get(Class<T> cls, CreateInstance<T> createInstance) {
        T t;
        T t2 = f41256b.get(cls);
        if (t2 != null) {
            LogUtil.m29100d(f41255a, "SingletonFactory<" + cls.getSimpleName() + "> cache hit.");
            return t2;
        }
        if (createInstance == null) {
            LogUtil.m29100d(f41255a, "Create instance by createInstance()");
            t = m29220a(cls);
        } else {
            LogUtil.m29100d(f41255a, "Create instance by createInstance.create()");
            t = createInstance.create(cls);
        }
        f41256b.put(cls, t);
        return t;
    }

    public static void remove(Class<?> cls) {
        f41256b.remove(cls);
    }

    public static void clear() {
        f41256b.clear();
    }

    /* renamed from: a */
    private static <T> T m29220a(Class<T> cls) {
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
            LogUtil.m29100d(f41255a, "Create storage instance: " + cls.getSimpleName());
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
