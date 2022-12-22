package com.didi.sofa.utils.Reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodUtils {
    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class[] a = ReflectUtils.m31283a(clsArr);
        Object[] b = ReflectUtils.m31285b(objArr);
        Method matchedMethod = getMatchedMethod(obj.getClass(), str, a);
        if (matchedMethod != null) {
            matchedMethod.setAccessible(true);
            return matchedMethod.invoke(obj, b);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
    }

    public static Object invokeStaticMethod(Class cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class[] a = ReflectUtils.m31283a(clsArr);
        Object[] b = ReflectUtils.m31285b(objArr);
        Method matchedMethod = getMatchedMethod(cls, str, a);
        if (matchedMethod != null) {
            matchedMethod.setAccessible(true);
            return matchedMethod.invoke((Object) null, b);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + cls.getName());
    }

    public static Object invokeStaticMethod(Class cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] b = ReflectUtils.m31285b(objArr);
        return invokeStaticMethod(cls, str, b, ReflectUtils.m31284a(b));
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] b = ReflectUtils.m31285b(objArr);
        return invokeMethod(obj, str, b, ReflectUtils.m31284a(b));
    }

    public static Method getMatchedMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            C14265a.m31292a((AccessibleObject) declaredMethod);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            Method method = null;
            for (Class<? super Object> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                for (Method method2 : cls2.getDeclaredMethods()) {
                    if (method2.getName().equals(str) && C14265a.m31294a(clsArr, (Class<?>[]) method2.getParameterTypes(), true)) {
                        method = m31279a(method2);
                        if (method != null && C14265a.m31287a((Class<?>[]) method.getParameterTypes(), (Class<?>[]) method2.getParameterTypes(), clsArr) < 0) {
                            break;
                        }
                        method = method2;
                    }
                }
                if (method != null) {
                    break;
                }
            }
            if (method != null) {
                C14265a.m31292a((AccessibleObject) method);
            }
            return method;
        }
    }

    /* renamed from: a */
    private static Method m31279a(Method method) {
        Class<?> declaringClass = method.getDeclaringClass();
        String name = method.getName();
        Class[] parameterTypes = method.getParameterTypes();
        Method b = m31280b(declaringClass, name, parameterTypes);
        return b == null ? m31278a(declaringClass, name, parameterTypes) : b;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.reflect.Method m31278a(java.lang.Class<?> r0, java.lang.String r1, java.lang.Class<?>... r2) {
        /*
            java.lang.Class r0 = r0.getSuperclass()
        L_0x0004:
            if (r0 == 0) goto L_0x0010
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ NoSuchMethodException -> 0x000b }
            return r0
        L_0x000b:
            java.lang.Class r0 = r0.getSuperclass()
            goto L_0x0004
        L_0x0010:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sofa.utils.Reflection.MethodUtils.m31278a(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    /* renamed from: b */
    private static Method m31280b(Class<?> cls, String str, Class<?>... clsArr) {
        Class<? super Object> cls2;
        while (cls2 != null) {
            Class[] interfaces = cls2.getInterfaces();
            int i = 0;
            while (i < interfaces.length) {
                try {
                    return interfaces[i].getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException unused) {
                    Method b = m31280b(interfaces[i], str, clsArr);
                    if (b != null) {
                        return b;
                    }
                    i++;
                }
            }
            Class<? super Object> superclass = cls2.getSuperclass();
            cls2 = cls;
            cls2 = superclass;
        }
        return null;
    }
}
