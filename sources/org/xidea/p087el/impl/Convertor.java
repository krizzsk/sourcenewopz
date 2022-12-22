package org.xidea.p087el.impl;

import java.util.Map;

/* renamed from: org.xidea.el.impl.Convertor */
public interface Convertor<T> {
    public static final Convertor<Object> DEFAULT = new DefaultConvertor();
    public static final Map<Class<?>, Convertor<?>> DEFAULT_MAP = DefaultConvertor.toMap();

    T getValue(String str, Class<? extends T> cls, Object obj, String str2);
}
