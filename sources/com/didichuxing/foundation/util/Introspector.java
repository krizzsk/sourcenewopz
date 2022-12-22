package com.didichuxing.foundation.util;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public abstract class Introspector {

    /* renamed from: a */
    private static final Set<Method> f47645a = Collections.unmodifiableSet(new HashSet(Arrays.asList(Object.class.getMethods())));

    public static Map<String, Object> properties(Object obj) {
        return properties(obj, false);
    }

    public static Map<String, Object> properties(Object obj, boolean z) {
        return Collections.unmodifiableMap(m34106a(obj, z));
    }

    /* renamed from: a */
    private static Map<String, Object> m34106a(Object obj, boolean z) {
        TreeMap treeMap = new TreeMap();
        Class<?> cls = obj.getClass();
        if (cls.getClassLoader() == null) {
            z = false;
        }
        Method[] a = m34108a(z ? cls.getMethods() : cls.getDeclaredMethods());
        int i = 0;
        while (i < a.length) {
            try {
                Method method = a[i];
                String name = method.getName();
                String str = "";
                if (name.startsWith("get")) {
                    str = name.substring(3);
                } else if (name.startsWith("is")) {
                    str = name.substring(2);
                }
                if (str.length() > 0 && Character.isUpperCase(str.charAt(0)) && method.getParameterTypes().length == 0) {
                    if (str.length() == 1) {
                        str = str.toLowerCase();
                    } else if (!Character.isUpperCase(str.charAt(1))) {
                        str = str.substring(0, 1).toLowerCase() + str.substring(1);
                    }
                    Object invoke = method.invoke(obj, new Object[0]);
                    if (invoke == null) {
                        treeMap.put(str, (Object) null);
                    } else if (invoke.getClass().isArray()) {
                        ArrayList arrayList = new ArrayList();
                        int length = Array.getLength(invoke);
                        for (int i2 = 0; i2 < length; i2++) {
                            arrayList.add(Array.get(invoke, i2));
                        }
                        treeMap.put(str, arrayList);
                    } else if (invoke instanceof Collection) {
                        treeMap.put(str, (Collection) invoke);
                    } else if (invoke instanceof Map) {
                        treeMap.put(str, (Map) invoke);
                    } else if (m34107a(invoke.getClass())) {
                        treeMap.put(str, invoke);
                    } else if (m34109b(invoke.getClass())) {
                        treeMap.put(str, invoke.toString());
                    } else {
                        treeMap.put(str, m34106a(invoke, z));
                    }
                }
                i++;
            } catch (Throwable th) {
                throw new IllegalArgumentException(th);
            }
        }
        return treeMap;
    }

    /* renamed from: a */
    private static Method[] m34108a(Method[] methodArr) {
        HashSet hashSet = new HashSet(Arrays.asList(methodArr));
        hashSet.removeAll(f47645a);
        return (Method[]) hashSet.toArray(new Method[hashSet.size()]);
    }

    /* renamed from: a */
    private static boolean m34107a(Class<?> cls) {
        return cls.isPrimitive() || cls.isAssignableFrom(Byte.class) || cls.isAssignableFrom(Short.class) || cls.isAssignableFrom(Integer.class) || cls.isAssignableFrom(Long.class) || cls.isAssignableFrom(Float.class) || cls.isAssignableFrom(Double.class) || cls.isAssignableFrom(Character.class) || cls.isAssignableFrom(String.class) || cls.isAssignableFrom(Boolean.class);
    }

    /* renamed from: b */
    private static boolean m34109b(Class<?> cls) {
        String name = cls.getPackage().getName();
        return name.startsWith("android.") || name.startsWith("java.") || name.startsWith("javax.") || cls.getClassLoader() == null;
    }

    private Introspector() {
    }
}
