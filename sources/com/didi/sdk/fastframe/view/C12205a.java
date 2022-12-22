package com.didi.sdk.fastframe.view;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.map.base.bubble.BaseBubbleBitmapLoader;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.fastframe.util.CollectionUtil;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.didi.sdk.fastframe.view.a */
/* compiled from: InstanceStateUtil */
class C12205a {

    /* renamed from: a */
    private static final String f35920a = "savedData";

    /* renamed from: b */
    private static final String f35921b = "int";

    /* renamed from: c */
    private static final String f35922c = "long";

    /* renamed from: d */
    private static final String f35923d = "double";

    /* renamed from: e */
    private static final String f35924e = "float";

    /* renamed from: f */
    private static final String f35925f = "boolean";

    /* renamed from: g */
    private static final String f35926g = "serializable";

    C12205a() {
    }

    /* renamed from: a */
    public static void m25435a(Bundle bundle, Object obj) {
        HashMap<String, Object> a = m25434a(obj, (Class) obj.getClass(), (HashMap<String, Object>) new HashMap());
        if (!CollectionUtil.isEmpty((Map) a)) {
            for (Map.Entry next : a.entrySet()) {
                m25436a(bundle, (String) next.getKey(), next.getValue());
            }
        }
        if (a != null) {
            bundle.putCharSequenceArrayList(f35920a, new ArrayList(a.keySet()));
        }
    }

    /* renamed from: b */
    public static void m25439b(Bundle bundle, Object obj) {
        if (bundle != null) {
            ArrayList<CharSequence> charSequenceArrayList = bundle.getCharSequenceArrayList(f35920a);
            if (!CollectionUtil.isEmpty((Collection) charSequenceArrayList)) {
                Iterator<CharSequence> it = charSequenceArrayList.iterator();
                while (it.hasNext()) {
                    CharSequence next = it.next();
                    if (!TextUtils.isEmpty(next)) {
                        m25437a(obj, next, bundle.get((String) next));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static HashMap<String, Object> m25434a(Object obj, Class cls, HashMap<String, Object> hashMap) {
        if (cls == null) {
            return null;
        }
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        if (cls == InstanceStateActivity.class || cls == InstanceStateFragment.class) {
            return hashMap;
        }
        Field[] declaredFields = cls.getDeclaredFields();
        if (!CollectionUtil.isEmpty((Object[]) declaredFields)) {
            for (Field field : declaredFields) {
                if (m25438a(field)) {
                    String a = m25432a(cls, field);
                    Object a2 = m25431a(obj, field);
                    if (!TextUtils.isEmpty(a) && a2 != null) {
                        hashMap.put(a, a2);
                    }
                }
            }
        }
        return m25434a(obj, cls.getSuperclass(), hashMap);
    }

    /* renamed from: a */
    private static void m25436a(Bundle bundle, String str, Object obj) {
        String a = m25433a(str);
        if (bundle == null) {
            return;
        }
        if (f35921b.equals(a)) {
            bundle.putInt(str, ((Integer) obj).intValue());
        } else if (f35922c.equals(a)) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if ("float".equals(a)) {
            bundle.putFloat(str, ((Float) obj).floatValue());
        } else if (f35923d.equals(a)) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if ("boolean".equals(a)) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (f35926g.equals(a)) {
            bundle.putSerializable(str, (Serializable) obj);
        } else {
            SystemUtils.log(6, "InstanceStateActivity", "不支持存储类型：" + str, (Throwable) null, "com.didi.sdk.fastframe.view.InstanceStateUtil", 167);
        }
    }

    /* renamed from: a */
    private static boolean m25438a(Field field) {
        if (field == null) {
            return false;
        }
        Type genericType = field.getGenericType();
        if (genericType instanceof ParameterizedType) {
            genericType = ((ParameterizedType) genericType).getRawType();
        }
        if (!(genericType instanceof Class)) {
            return false;
        }
        Class cls = (Class) genericType;
        if (!field.isAnnotationPresent(SavedInstance.class)) {
            return false;
        }
        if (Serializable.class.isAssignableFrom(cls) || cls.getSimpleName().equals(f35921b) || cls.getSimpleName().equals("java.lang.Integer") || cls.getSimpleName().equals(f35922c) || cls.getSimpleName().equals("java.lang.Long") || cls.getSimpleName().equals(f35923d) || cls.getSimpleName().equals("java.lang.Double") || cls.getSimpleName().equals("float") || cls.getSimpleName().equals("java.lang.Float") || cls.getSimpleName().equals("boolean") || cls.getSimpleName().equals("java.lang.Boolean")) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static String m25432a(Class cls, Field field) {
        if (cls == null || field == null) {
            return null;
        }
        Type genericType = field.getGenericType();
        if (genericType instanceof ParameterizedType) {
            genericType = ((ParameterizedType) genericType).getRawType();
        }
        if (!(genericType instanceof Class) || !Serializable.class.isAssignableFrom((Class) genericType)) {
            return cls.getName() + "|" + field.getName() + "|" + genericType;
        }
        return cls.getName() + "|" + field.getName() + "|" + "java.io.Serializable";
    }

    /* renamed from: a */
    private static String m25433a(String str) {
        String str2 = String.valueOf(str).split(BaseBubbleBitmapLoader.FILE_SPLIT_FLAG)[2];
        String str3 = f35921b;
        if (!str3.equals(str2) && !"java.lang.Integer".equals(str2)) {
            str3 = f35922c;
            if (!str3.equals(str2) && !"java.lang.Long".equals(str2)) {
                str3 = f35923d;
                if (!str3.equals(str2) && !"java.lang.Double".equals(str2)) {
                    str3 = "float";
                    if (!str3.equals(str2) && !"java.lang.Float".equals(str2)) {
                        str3 = "boolean";
                        if (!str3.equals(str2) && !"java.lang.Boolean".equals(str2)) {
                            if ("java.io.Serializable".equals(str2)) {
                                return f35926g;
                            }
                            return null;
                        }
                    }
                }
            }
        }
        return str3;
    }

    /* renamed from: a */
    private static Object m25431a(Object obj, Field field) {
        Object obj2 = null;
        if (field != null) {
            field.setAccessible(true);
            try {
                obj2 = field.get(obj);
            } catch (IllegalAccessException unused) {
            }
            field.setAccessible(false);
        }
        return obj2;
    }

    /* renamed from: a */
    private static void m25437a(Object obj, CharSequence charSequence, Object obj2) {
        String[] split = String.valueOf(charSequence).split(BaseBubbleBitmapLoader.FILE_SPLIT_FLAG);
        String str = split[0];
        try {
            Field declaredField = Class.forName(str).getDeclaredField(split[1]);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
            declaredField.setAccessible(false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
    }
}
