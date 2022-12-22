package com.didi.travel.psnger.log;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class LogOutput {
    public static String showOutputLog(Object obj, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(m31414a(obj));
        stringBuffer.append(" ");
        stringBuffer.append(LogConfig.LOG_SUFFIX);
        stringBuffer.append(" [");
        stringBuffer.append(str);
        stringBuffer.append(Const.jaRight);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static String m31414a(Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(LogConfig.LOG_PREFIX);
        stringBuffer.append(" ");
        if (obj != null) {
            stringBuffer = m31415a(obj, stringBuffer);
            try {
                Method method = obj.getClass().getSuperclass().getMethod("toString", new Class[0]);
                method.setAccessible(true);
                stringBuffer.append(method.invoke(obj, new Object[0]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static StringBuffer m31415a(Object obj, StringBuffer stringBuffer) {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        stringBuffer.append(obj.getClass().getSimpleName());
        stringBuffer.append(" [");
        try {
            for (Field field : declaredFields) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                Object obj2 = field.get(obj);
                if (!m31416a((Class<? extends Object>) type)) {
                    if (!m31417b((Class<? extends Object>) type)) {
                        if (m31420c(type)) {
                            List list = (List) obj2;
                            if (list != null) {
                                int size = list.size();
                                for (int i = 0; i < size; i++) {
                                    m31415a(list.get(i), stringBuffer);
                                }
                            }
                        } else if (m31421d(type) && obj2 != null) {
                            m31415a(obj2, stringBuffer);
                        }
                    }
                }
                stringBuffer.append(field.getName());
                stringBuffer.append("=");
                stringBuffer.append(obj2);
                stringBuffer.append(", ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (declaredFields != null && declaredFields.length > 0) {
            stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length());
        }
        stringBuffer.append("] ");
        return stringBuffer;
    }

    /* renamed from: b */
    private static boolean m31419b(Object obj, StringBuffer stringBuffer) {
        try {
            if (m31418b(obj)) {
                for (Method method : obj.getClass().getMethods()) {
                    if (method.getName().contains("toString")) {
                        stringBuffer.append(method.invoke(obj, new Object[0]));
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: b */
    private static boolean m31418b(Object obj) {
        for (Method name : obj.getClass().getMethods()) {
            if (name.getName().contains("toString")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m31416a(Class<? extends Object> cls) {
        return cls.isPrimitive();
    }

    /* renamed from: b */
    private static boolean m31417b(Class<? extends Object> cls) {
        return cls.isAssignableFrom(String.class);
    }

    /* renamed from: c */
    private static boolean m31420c(Class<? extends Object> cls) {
        return cls.isAssignableFrom(List.class) || cls.isAssignableFrom(ArrayList.class);
    }

    /* renamed from: d */
    private static boolean m31421d(Class<? extends Object> cls) {
        return cls.getName().contains(LogConfig.PACKAGE_GROUP_MODEL);
    }
}
