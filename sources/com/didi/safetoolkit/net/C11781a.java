package com.didi.safetoolkit.net;

import com.didi.safetoolkit.util.SfLog;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.safetoolkit.net.a */
/* compiled from: SfHttpParamLoader */
final class C11781a {
    private C11781a() {
    }

    /* renamed from: a */
    public static Map<String, Object> m24390a(Object obj) {
        HashMap hashMap = new HashMap(64);
        m24391a(obj, hashMap);
        return SfHttpParamUtil.createCommonParams(hashMap);
    }

    /* renamed from: a */
    private static void m24391a(Object obj, Map<String, Object> map) {
        Field[] fields;
        String str;
        if (obj != null && map != null && (fields = obj.getClass().getFields()) != null && fields.length != 0) {
            for (Field field : fields) {
                Object obj2 = null;
                int modifiers = field.getModifiers();
                if ((modifiers & 8) == 0 && (modifiers & 128) == 0) {
                    if (field.isAnnotationPresent(SfRpcParam.class)) {
                        str = ((SfRpcParam) field.getAnnotation(SfRpcParam.class)).value();
                    } else {
                        str = field.getName();
                    }
                    try {
                        field.setAccessible(true);
                        obj2 = field.get(obj);
                    } catch (IllegalAccessException e) {
                        SfLog.m24407e((Throwable) e);
                    }
                    if (str == null || obj2 == null) {
                        SfLog.m24402d("SfHttpParamLoader", "paramName or paramValue is null.");
                    } else {
                        Class<?> cls = obj2.getClass();
                        if (Integer.class.equals(cls) || Double.class.equals(cls) || Float.class.equals(cls) || Long.class.equals(cls) || String.class.equals(cls) || Boolean.class.equals(cls) || Byte.class.equals(cls) || Short.class.equals(cls) || Character.class.equals(cls)) {
                            SfHttpParamUtil.put(map, str, obj2);
                        } else {
                            map.put(str, obj2);
                        }
                    }
                }
            }
        }
    }
}
