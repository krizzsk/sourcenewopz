package com.didi.sdk.onehotpatch.commonstatic.util;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectUtil {
    public static Object getField(Class cls, Object obj, String str) throws Exception {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static void setField(Class cls, Object obj, String str, Object obj2) throws Exception {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    public static Field findField(Object obj, String str) throws NoSuchFieldException {
        Field field;
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                field = cls.getDeclaredField(str);
            } catch (NoSuchFieldException e) {
                try {
                    field = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(cls, new Object[]{str});
                } catch (Exception unused) {
                    throw e;
                } catch (NoSuchFieldException unused2) {
                    cls = cls.getSuperclass();
                }
            }
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    public static Method findMethod(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method method;
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException e) {
                try {
                    method = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(cls, new Object[]{str, clsArr});
                } catch (Exception unused) {
                    throw e;
                } catch (NoSuchMethodException unused2) {
                    cls = cls.getSuperclass();
                }
            }
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    public static Constructor<?> findConstructor(Object obj, Class<?>... clsArr) throws NoSuchMethodException {
        Constructor<?> constructor;
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                constructor = cls.getDeclaredConstructor(clsArr);
            } catch (NoSuchMethodException e) {
                try {
                    constructor = (Constructor) Class.class.getDeclaredMethod("getDeclaredConstructor", new Class[]{Class[].class}).invoke(cls, clsArr);
                } catch (Exception unused) {
                    throw e;
                } catch (NoSuchMethodException unused2) {
                    cls = cls.getSuperclass();
                }
            }
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor;
        }
        throw new NoSuchMethodException("Constructor  with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    public static void expandFieldArray(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field findField = findField(obj, str);
        Object[] objArr2 = (Object[]) findField.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
        System.arraycopy(objArr2, 0, objArr3, objArr.length, objArr2.length);
        findField.set(obj, objArr3);
    }

    public static Object getField(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
        return findField(obj, str).get(obj);
    }

    public static void setField(Object obj, String str, Object obj2) throws NoSuchFieldException, IllegalAccessException {
        findField(obj, str).set(obj, obj2);
    }

    public static Object combineArray(Object obj, Object obj2) {
        Class<?> componentType = obj2.getClass().getComponentType();
        int length = Array.getLength(obj2);
        int length2 = Array.getLength(obj) + length;
        Object newInstance = Array.newInstance(componentType, length2);
        for (int i = 0; i < length2; i++) {
            if (i < length) {
                Array.set(newInstance, i, Array.get(obj2, i));
            } else {
                Array.set(newInstance, i, Array.get(obj, i - length));
            }
        }
        return newInstance;
    }

    public static Object appendArray(Object obj, Object obj2) {
        Class<?> componentType = obj.getClass().getComponentType();
        int length = Array.getLength(obj) + 1;
        Object newInstance = Array.newInstance(componentType, length);
        Array.set(newInstance, 0, obj2);
        for (int i = 1; i < length; i++) {
            Array.set(newInstance, i, Array.get(obj, i - 1));
        }
        return newInstance;
    }

    public static Class forName(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    public static Field getDeclaredField(Class cls, String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        if (!declaredField.isAccessible()) {
            declaredField.setAccessible(true);
        }
        return declaredField;
    }

    public static Method getDeclaredMethod(Class cls, String str, Class... clsArr) throws NoSuchMethodException {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod;
    }
}
