package com.didi.sofa.utils.Reflection;

import android.text.TextUtils;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import rui.config.RConfigConstants;

public class FieldUtils {

    /* renamed from: a */
    private static final Map<String, Field> f43955a = new HashMap();

    /* renamed from: a */
    private static String m31275a(Class<?> cls, String str) {
        return cls.toString() + "@" + cls.getClassLoader() + RConfigConstants.KEYWORD_COLOR_SIGN + str;
    }

    /* renamed from: a */
    private static Field m31276a(Class<?> cls, String str, boolean z) {
        Field field;
        m31277a(cls != null, "The class must not be null", new Object[0]);
        m31277a(!TextUtils.isEmpty(str), "The field name must not be blank/empty", new Object[0]);
        String a = m31275a(cls, str);
        synchronized (f43955a) {
            field = f43955a.get(a);
        }
        if (field != null) {
            if (z && !field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        Class<?> cls2 = cls;
        while (cls2 != null) {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                if (!Modifier.isPublic(declaredField.getModifiers())) {
                    if (z) {
                        declaredField.setAccessible(true);
                    } else {
                        continue;
                        cls2 = cls2.getSuperclass();
                    }
                }
                synchronized (f43955a) {
                    f43955a.put(a, declaredField);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field2 = null;
        for (Class field3 : ReflectUtils.getAllInterfaces(cls)) {
            try {
                Field field4 = field3.getField(str);
                m31277a(field2 == null, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", str, cls);
                field2 = field4;
            } catch (NoSuchFieldException unused2) {
            }
        }
        synchronized (f43955a) {
            f43955a.put(a, field2);
        }
        return field2;
    }

    public static Object readField(Field field, Object obj, boolean z) throws IllegalAccessException {
        m31277a(field != null, "The field must not be null", new Object[0]);
        if (!z || field.isAccessible()) {
            C14265a.m31292a((AccessibleObject) field);
        } else {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    public static void writeField(Field field, Object obj, Object obj2, boolean z) throws IllegalAccessException {
        m31277a(field != null, "The field must not be null", new Object[0]);
        if (!z || field.isAccessible()) {
            C14265a.m31292a((AccessibleObject) field);
        } else {
            field.setAccessible(true);
        }
        field.set(obj, obj2);
    }

    public static Object readField(Field field, Object obj) throws IllegalAccessException {
        return readField(field, obj, true);
    }

    public static Field getField(Class<?> cls, String str) {
        return m31276a(cls, str, true);
    }

    public static Object readField(Object obj, String str) throws IllegalAccessException {
        m31277a(obj != null, "target object must not be null", new Object[0]);
        Class<?> cls = obj.getClass();
        Field a = m31276a(cls, str, true);
        m31277a(a != null, "Cannot locate field %s on %s", str, cls);
        return readField(a, obj, false);
    }

    public static Object readField(Object obj, String str, boolean z) throws IllegalAccessException {
        m31277a(obj != null, "target object must not be null", new Object[0]);
        Class<?> cls = obj.getClass();
        Field a = m31276a(cls, str, z);
        m31277a(a != null, "Cannot locate field %s on %s", str, cls);
        return readField(a, obj, z);
    }

    public static void writeField(Object obj, String str, Object obj2) throws IllegalAccessException {
        writeField(obj, str, obj2, true);
    }

    public static void writeField(Object obj, String str, Object obj2, boolean z) throws IllegalAccessException {
        m31277a(obj != null, "target object must not be null", new Object[0]);
        Class<?> cls = obj.getClass();
        Field a = m31276a(cls, str, true);
        m31277a(a != null, "Cannot locate declared field %s.%s", cls.getName(), str);
        writeField(a, obj, obj2, z);
    }

    public static void writeField(Field field, Object obj, Object obj2) throws IllegalAccessException {
        writeField(field, obj, obj2, true);
    }

    public static Object readStaticField(Field field, boolean z) throws IllegalAccessException {
        m31277a(field != null, "The field must not be null", new Object[0]);
        m31277a(Modifier.isStatic(field.getModifiers()), "The field '%s' is not static", field.getName());
        return readField(field, (Object) null, z);
    }

    public static Object readStaticField(Class<?> cls, String str) throws IllegalAccessException {
        Field a = m31276a(cls, str, true);
        m31277a(a != null, "Cannot locate field '%s' on %s", str, cls);
        return readStaticField(a, true);
    }

    public static void writeStaticField(Field field, Object obj, boolean z) throws IllegalAccessException {
        m31277a(field != null, "The field must not be null", new Object[0]);
        m31277a(Modifier.isStatic(field.getModifiers()), "The field %s.%s is not static", field.getDeclaringClass().getName(), field.getName());
        writeField(field, (Object) null, obj, z);
    }

    public static void writeStaticField(Class<?> cls, String str, Object obj) throws IllegalAccessException {
        Field a = m31276a(cls, str, true);
        m31277a(a != null, "Cannot locate field %s on %s", str, cls);
        writeStaticField(a, obj, true);
    }

    public static Field getDeclaredField(Class<?> cls, String str, boolean z) {
        m31277a(cls != null, "The class must not be null", new Object[0]);
        m31277a(!TextUtils.isEmpty(str), "The field name must not be blank/empty", new Object[0]);
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (!C14265a.m31293a((Member) declaredField)) {
                if (!z) {
                    return null;
                }
                declaredField.setAccessible(true);
            }
            return declaredField;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    public static void writeDeclaredField(Object obj, String str, Object obj2) throws IllegalAccessException {
        Class<?> cls = obj.getClass();
        Field declaredField = getDeclaredField(cls, str, true);
        m31277a(declaredField != null, "Cannot locate declared field %s.%s", cls.getName(), str);
        writeField(declaredField, obj, obj2, false);
    }

    /* renamed from: a */
    static void m31277a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }
}
