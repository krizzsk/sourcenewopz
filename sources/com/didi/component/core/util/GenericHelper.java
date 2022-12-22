package com.didi.component.core.util;

import com.didi.component.core.event.BaseEventPublisher;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericHelper {
    public static Class<?> getGenericTypeArgument(Class<?> cls, Class<?> cls2, int i) {
        Class<?> a = m8712a(cls2, i, cls.getGenericSuperclass());
        if (a != null) {
            return a;
        }
        Class<?> a2 = m8712a(cls2, i, cls.getGenericInterfaces());
        if (a2 != null) {
            return a2;
        }
        return getGenericTypeArgument(m8713a(cls, cls2), cls2, i);
    }

    /* renamed from: a */
    private static Class<?> m8713a(Class<?> cls, Class<?> cls2) {
        Class<? super Object> superclass = cls != null ? cls.getSuperclass() : null;
        if (superclass != null && cls2.isAssignableFrom(superclass)) {
            return superclass;
        }
        Class<?>[] interfaces = cls != null ? cls.getInterfaces() : null;
        int length = interfaces != null ? interfaces.length : 0;
        for (int i = 0; i < length; i++) {
            if (cls2.isAssignableFrom(interfaces[i])) {
                return interfaces[i];
            }
        }
        return null;
    }

    /* renamed from: a */
    private static Class<?> m8712a(Class<?> cls, int i, Type... typeArr) {
        int length = typeArr != null ? typeArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (typeArr[i2] instanceof ParameterizedType) {
                ParameterizedType parameterizedType = typeArr[i2];
                if ((parameterizedType.getRawType() instanceof Class) && cls.isAssignableFrom((Class) parameterizedType.getRawType())) {
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    if (i >= actualTypeArguments.length || i < 0 || !(actualTypeArguments[i] instanceof Class)) {
                        return null;
                    }
                    return (Class) actualTypeArguments[i];
                }
            }
        }
        return null;
    }

    public static Class<?> getDeclaredGenericType(BaseEventPublisher.OnEventListener<?> onEventListener) {
        try {
            return onEventListener.getClass().getDeclaredMethods()[0].getParameterTypes()[1];
        } catch (Exception unused) {
            return null;
        }
    }
}
