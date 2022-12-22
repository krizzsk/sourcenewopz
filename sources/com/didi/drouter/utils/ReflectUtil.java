package com.didi.drouter.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectUtil {
    public static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            RouterLogger.getCoreLogger().mo59001e("ReflectUtil \"%s\" getClass exception %s", str, e);
            return null;
        }
    }

    public static Object getInstance(String str, Object... objArr) {
        try {
            return getInstance(Class.forName(str), objArr);
        } catch (ClassNotFoundException e) {
            RouterLogger.getCoreLogger().mo59001e("ReflectUtil \"%s\" getInstance exception %s", str, e);
            return null;
        }
    }

    public static Object getInstance(Class<?> cls, Object... objArr) {
        if (objArr == null) {
            try {
                objArr = new Object[]{null};
            } catch (Exception e) {
                RouterLogger.getCoreLogger().mo59001e("ReflectUtil \"%s\" getInstance Exception: %s", cls, e);
            }
        }
        if (objArr.length == 0) {
            return cls.newInstance();
        }
        Constructor[] constructors = cls.getConstructors();
        if (constructors != null) {
            for (Constructor constructor : constructors) {
                if (m14404a(constructor.getParameterTypes(), objArr)) {
                    return constructor.newInstance(objArr);
                }
            }
        }
        RouterLogger.getCoreLogger().mo59001e("ReflectUtil \"%s\" getInstance no match and return \"null\"", cls);
        return null;
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr) throws Exception {
        int i = 0;
        if (objArr == null || objArr.length == 0) {
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, new Class[0]);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, new Object[0]);
        }
        Method[] declaredMethods = obj.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        while (i < length) {
            Method method = declaredMethods[i];
            if (!method.getName().equals(str) || !m14404a(method.getParameterTypes(), objArr)) {
                i++;
            } else {
                method.setAccessible(true);
                return method.invoke(obj, objArr);
            }
        }
        throw new Exception("ReflectUtil invokeMethod no match");
    }

    /* renamed from: a */
    private static boolean m14404a(Class[] clsArr, Object[] objArr) {
        boolean z;
        if (clsArr.length != objArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= clsArr.length) {
                return true;
            }
            Class<?> cls = clsArr[i];
            Class<?> cls2 = objArr[i] != null ? objArr[i].getClass() : null;
            if (cls2 == null) {
                z = !cls.isPrimitive();
            } else {
                if (!(cls == cls2 || cls.isAssignableFrom(cls2) || m14403a(cls) == m14403a(cls2))) {
                    z2 = false;
                }
                z = z2;
            }
            if (!z) {
                return false;
            }
            i++;
        }
    }

    /* renamed from: a */
    private static Class<?> m14403a(Class<?> cls) {
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Character.class) {
            return Character.TYPE;
        }
        return cls == Boolean.class ? Boolean.TYPE : cls;
    }
}
