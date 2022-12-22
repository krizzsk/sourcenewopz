package com.didichuxing.mas.sdk.quality.report.collector;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtil {
    public static final String TAG = "ReflectionUtil";
    private static Method sForNameMethod;
    private static Method sGetDeclaredMethod;
    private static Method sGetFieldMethod;

    static {
        try {
            sForNameMethod = Class.class.getDeclaredMethod("forName", new Class[]{String.class});
            sGetDeclaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class});
            sGetFieldMethod = Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class});
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static Object getFiledObj(Object obj, String str, String str2, Object obj2) {
        try {
            Field filed = getFiled(str, str2);
            if (filed != null) {
                return filed.get(obj);
            }
            return obj2;
        } catch (Throwable th) {
            th.printStackTrace();
            return obj2;
        }
    }

    public static Field getFiled(String str, String str2) {
        Field field = null;
        if (!canReflection()) {
            return null;
        }
        try {
            Method method = sGetFieldMethod;
            Object[] objArr = {str2};
            Field field2 = (Field) method.invoke((Class) sForNameMethod.invoke((Object) null, new Object[]{str}), objArr);
            try {
                field2.setAccessible(true);
                return field2;
            } catch (Throwable th) {
                th = th;
                field = field2;
                th.printStackTrace();
                return field;
            }
        } catch (Throwable th2) {
            th = th2;
            th.printStackTrace();
            return field;
        }
    }

    public static void setFiled(Object obj, String str, String str2, Object obj2) {
        try {
            Field filed = getFiled(str, str2);
            if (filed != null) {
                filed.set(obj, obj2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static Method getMethod(String str, String str2, Class[] clsArr) {
        Method method = null;
        if (!canReflection()) {
            return null;
        }
        try {
            Method method2 = sGetDeclaredMethod;
            Object[] objArr = {str2, clsArr};
            Method method3 = (Method) method2.invoke((Class) sForNameMethod.invoke((Object) null, new Object[]{str}), objArr);
            try {
                method3.setAccessible(true);
                return method3;
            } catch (Throwable th) {
                th = th;
                method = method3;
                th.printStackTrace();
                return method;
            }
        } catch (Throwable th2) {
            th = th2;
            th.printStackTrace();
            return method;
        }
    }

    public static Object invokeMethod(Object obj, String str, String str2, Class[] clsArr, Object... objArr) {
        try {
            Method method = getMethod(str, str2, clsArr);
            if (method != null) {
                return method.invoke(obj, objArr);
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static boolean canReflection() {
        return (sForNameMethod == null || sGetDeclaredMethod == null || sGetFieldMethod == null) ? false : true;
    }
}
