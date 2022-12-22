package com.didi.trackupload.sdk.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectUtils {
    public static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean getBooleanField(Class<?> cls, Object obj, String str, boolean z) {
        try {
            return cls.getField(str).getBoolean(obj);
        } catch (Exception unused) {
            return z;
        }
    }

    public static boolean getBooleanDeclaredField(Class<?> cls, Object obj, String str, boolean z) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getBoolean(obj);
        } catch (Exception unused) {
            return z;
        }
    }

    public static void setBooleanField(Class<?> cls, Object obj, String str, boolean z) {
        try {
            cls.getField(str).setBoolean(obj, z);
        } catch (Exception unused) {
        }
    }

    public static void setBooleanDeclaredField(Class<?> cls, Object obj, String str, boolean z) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.setBoolean(obj, z);
        } catch (Exception unused) {
        }
    }

    public static int getIntField(Class<?> cls, Object obj, String str, int i) {
        try {
            return cls.getField(str).getInt(obj);
        } catch (Exception unused) {
            return i;
        }
    }

    public static int getIntDeclaredField(Class<?> cls, Object obj, String str, int i) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Exception unused) {
            return i;
        }
    }

    public static void setIntField(Class<?> cls, Object obj, String str, int i) {
        try {
            cls.getField(str).setInt(obj, i);
        } catch (Exception unused) {
        }
    }

    public static void setIntDeclaredField(Class<?> cls, Object obj, String str, int i) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.setInt(obj, i);
        } catch (Exception unused) {
        }
    }

    public static long getLongField(Class<?> cls, Object obj, String str, long j) {
        try {
            return cls.getField(str).getLong(obj);
        } catch (Exception unused) {
            return j;
        }
    }

    public static long getLongDeclaredField(Class<?> cls, Object obj, String str, long j) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getLong(obj);
        } catch (Exception unused) {
            return j;
        }
    }

    public static void setLongField(Class<?> cls, Object obj, String str, long j) {
        try {
            cls.getField(str).setLong(obj, j);
        } catch (Exception unused) {
        }
    }

    public static void setLongDeclaredField(Class<?> cls, Object obj, String str, long j) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.setLong(obj, j);
        } catch (Exception unused) {
        }
    }

    public static String getStringField(Class<?> cls, Object obj, String str, String str2) {
        try {
            return (String) cls.getField(str).get(obj);
        } catch (Exception unused) {
            return str2;
        }
    }

    public static String getStringDeclaredField(Class<?> cls, Object obj, String str, String str2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return (String) declaredField.get(obj);
        } catch (Exception unused) {
            return str2;
        }
    }

    public static void setStringField(Class<?> cls, Object obj, String str, String str2) {
        try {
            cls.getField(str).set(obj, str2);
        } catch (Exception unused) {
        }
    }

    public static void setStringDeclaredField(Class<?> cls, Object obj, String str, String str2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, str2);
        } catch (Exception unused) {
        }
    }

    public static Object getObjectField(Class<?> cls, Object obj, String str) {
        try {
            return cls.getField(str).get(obj);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object getObjectDeclaredField(Class<?> cls, Object obj, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void setObjectField(Class<?> cls, Object obj, String str, Object obj2) {
        try {
            cls.getField(str).set(obj, obj2);
        } catch (Exception unused) {
        }
    }

    public static void setObjectDeclaredField(Class<?> cls, Object obj, String str, Object obj2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Class<?>[] m31341a(java.lang.Object... r5) {
        /*
            if (r5 == 0) goto L_0x003b
            int r0 = r5.length
            if (r0 <= 0) goto L_0x003b
            int r0 = r5.length
            int r1 = r5.length
            java.lang.Class[] r1 = new java.lang.Class[r1]
            if (r0 <= 0) goto L_0x003c
            r2 = 0
        L_0x000c:
            if (r2 == r0) goto L_0x003c
            r3 = r5[r2]
            if (r3 == 0) goto L_0x0034
            java.lang.Class r3 = r3.getClass()
            java.lang.Class<java.lang.Boolean> r4 = java.lang.Boolean.class
            if (r3 != r4) goto L_0x001f
            java.lang.Class r3 = java.lang.Boolean.TYPE
            r1[r2] = r3
            goto L_0x0038
        L_0x001f:
            java.lang.Class<java.lang.Integer> r4 = java.lang.Integer.class
            if (r3 != r4) goto L_0x0028
            java.lang.Class r3 = java.lang.Integer.TYPE
            r1[r2] = r3
            goto L_0x0038
        L_0x0028:
            java.lang.Class<java.lang.Long> r4 = java.lang.Long.class
            if (r3 != r4) goto L_0x0031
            java.lang.Class r3 = java.lang.Long.TYPE
            r1[r2] = r3
            goto L_0x0038
        L_0x0031:
            r1[r2] = r3
            goto L_0x0038
        L_0x0034:
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            r1[r2] = r3
        L_0x0038:
            int r2 = r2 + 1
            goto L_0x000c
        L_0x003b:
            r1 = 0
        L_0x003c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.trackupload.sdk.utils.ReflectUtils.m31341a(java.lang.Object[]):java.lang.Class[]");
    }

    /* renamed from: a */
    private static Method m31340a(Class<?> cls, String str, Object... objArr) {
        try {
            Class[] a = m31341a(objArr);
            return a != null ? cls.getMethod(str, a) : cls.getMethod(str, new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    private static Method m31342b(Class<?> cls, String str, Object... objArr) {
        Method method = null;
        try {
            Class[] a = m31341a(objArr);
            method = a != null ? cls.getDeclaredMethod(str, a) : cls.getDeclaredMethod(str, new Class[0]);
            if (method != null) {
                method.setAccessible(true);
            }
        } catch (Exception unused) {
        }
        return method;
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Method getDeclaredMethod(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            if (declaredMethod == null) {
                return declaredMethod;
            }
            try {
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Exception unused) {
                return declaredMethod;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static Object invokeMethodReturnObject(Class<?> cls, Object obj, String str, Object... objArr) {
        try {
            Method a = m31340a(cls, str, objArr);
            if (a != null) {
                return a.invoke(obj, objArr);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object invokeMethodReturnObject(Class<?> cls, Object obj, Method method, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object invokeDeclaredMethodReturnObject(Class<?> cls, Object obj, String str, Object... objArr) {
        try {
            Method b = m31342b(cls, str, objArr);
            if (b != null) {
                return b.invoke(obj, objArr);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object invokeDeclaredMethodReturnObject(Class<?> cls, Object obj, Method method, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean invokeMethodReturnBoolean(Class<?> cls, Object obj, String str, boolean z, Object... objArr) {
        try {
            Method a = m31340a(cls, str, objArr);
            return a != null ? ((Boolean) a.invoke(obj, objArr)).booleanValue() : z;
        } catch (Exception unused) {
            return z;
        }
    }

    public static boolean invokeDeclaredMethodReturnBoolean(Class<?> cls, Object obj, String str, boolean z, Object... objArr) {
        try {
            Method b = m31342b(cls, str, objArr);
            if (b != null) {
                return ((Boolean) b.invoke(obj, objArr)).booleanValue();
            }
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return z;
        }
    }

    public static int invokeMethodReturnInt(Class<?> cls, Object obj, String str, int i, Object... objArr) {
        try {
            Method a = m31340a(cls, str, objArr);
            return a != null ? ((Integer) a.invoke(obj, objArr)).intValue() : i;
        } catch (Exception unused) {
            return i;
        }
    }

    public static int invokeDeclaredMethodReturnInt(Class<?> cls, Object obj, String str, int i, Object... objArr) {
        try {
            Method b = m31342b(cls, str, objArr);
            return b != null ? ((Integer) b.invoke(obj, objArr)).intValue() : i;
        } catch (Exception unused) {
            return i;
        }
    }

    public static String invokeMethodReturnString(Class<?> cls, Object obj, String str, String str2, Object... objArr) {
        try {
            Method a = m31340a(cls, str, objArr);
            return a != null ? (String) a.invoke(obj, objArr) : str2;
        } catch (Exception unused) {
            return str2;
        }
    }

    public static String invokeDeclaredMethodReturnString(Class<?> cls, Object obj, String str, String str2, Object... objArr) {
        try {
            Method b = m31342b(cls, str, objArr);
            return b != null ? (String) b.invoke(obj, objArr) : str2;
        } catch (Exception unused) {
            return str2;
        }
    }
}
