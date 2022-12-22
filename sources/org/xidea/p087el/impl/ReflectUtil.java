package org.xidea.p087el.impl;

import com.didi.soda.customer.p165h5.hybird.model.GuideParamModel;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* renamed from: org.xidea.el.impl.ReflectUtil */
public abstract class ReflectUtil {
    private static final String LENGTH = "length";
    private static Object initLock = new Object();
    private static final Log log = LogFactory.getLog(ReflectUtil.class);
    private static final Map<Class<?>, Map<String, Method>> readerMap = new WeakHashMap();
    private static final Map<Class<?>, Map<String, Class<?>>> typeMap = new WeakHashMap();
    private static final Map<Class<?>, Map<String, Method>> writerMap = new WeakHashMap();

    public static Map<String, Method> getGetterMap(Class<?> cls) {
        Map<String, Method> map = readerMap.get(cls);
        if (map != null) {
            return map;
        }
        initProperties(cls);
        return readerMap.get(cls);
    }

    public static Map<String, Method> getSetterMap(Class<?> cls) {
        Map<String, Method> map = writerMap.get(cls);
        if (map != null) {
            return map;
        }
        initProperties(cls);
        return writerMap.get(cls);
    }

    private static Map<String, Class<?>> getTypeMap(Class<?> cls) {
        Map<String, Class<?>> map = typeMap.get(cls);
        if (map != null) {
            return map;
        }
        initProperties(cls);
        return typeMap.get(cls);
    }

    private static void initProperties(Class<?> cls) {
        Map<Class<?>, Map<String, Class<?>>> map;
        Map unmodifiableMap;
        synchronized (initLock) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            try {
                if (!cls.equals(Object.class)) {
                    hashMap.putAll(getGetterMap(cls.getSuperclass()));
                    hashMap2.putAll(getSetterMap(cls.getSuperclass()));
                    hashMap3.putAll(getTypeMap(cls.getSuperclass()));
                }
                for (Method method : cls.getDeclaredMethods()) {
                    if ((method.getModifiers() & 1) > 0) {
                        Class<?> returnType = method.getReturnType();
                        Class[] parameterTypes = method.getParameterTypes();
                        String name = method.getName();
                        if (returnType == Void.TYPE) {
                            if (parameterTypes.length == 1 && name.startsWith(GuideParamModel.ACTION_SET)) {
                                Class cls2 = parameterTypes[0];
                                initMethod(hashMap2, hashMap3, method, name.substring(3));
                            }
                        } else if (parameterTypes.length == 0) {
                            if (name.startsWith("get")) {
                                initMethod(hashMap, hashMap3, method, name.substring(3));
                            } else if (returnType == Boolean.TYPE && name.startsWith("is")) {
                                initMethod(hashMap, hashMap3, method, name.substring(2));
                            }
                        }
                    }
                }
                readerMap.put(cls, Collections.unmodifiableMap(hashMap));
                writerMap.put(cls, Collections.unmodifiableMap(hashMap2));
                map = typeMap;
                unmodifiableMap = Collections.unmodifiableMap(hashMap3);
            } catch (Exception e) {
                try {
                    log.warn("初始化属性集合异常", e);
                    readerMap.put(cls, Collections.unmodifiableMap(hashMap));
                    writerMap.put(cls, Collections.unmodifiableMap(hashMap2));
                    map = typeMap;
                    unmodifiableMap = Collections.unmodifiableMap(hashMap3);
                } catch (Throwable th) {
                    readerMap.put(cls, Collections.unmodifiableMap(hashMap));
                    writerMap.put(cls, Collections.unmodifiableMap(hashMap2));
                    typeMap.put(cls, Collections.unmodifiableMap(hashMap3));
                    throw th;
                }
            }
            map.put(cls, unmodifiableMap);
        }
    }

    private static void initMethod(Map<String, Method> map, Map<String, Class<?>> map2, Method method, String str) {
        if (str.length() > 0) {
            char charAt = str.charAt(0);
            if (Character.isUpperCase(charAt)) {
                String str2 = String.valueOf(Character.toLowerCase(charAt)) + str.substring(1);
                method.setAccessible(true);
                map.put(str2, method);
                Class<?> returnType = method.getReturnType();
                if (returnType == Void.TYPE) {
                    returnType = method.getParameterTypes()[0];
                }
                Class<?> cls = map2.get(str2);
                if (!(cls == null || cls == returnType)) {
                    log.warn("属性类型冲突：" + cls + "!=" + returnType);
                }
                map2.put(str2, returnType);
            }
        }
    }

    public static Map<String, ? extends Object> map(Object obj) {
        if (obj == null) {
            return Collections.EMPTY_MAP;
        }
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return new ProxyMap(obj, getTypeMap(obj.getClass()).keySet());
    }

    private static int toIndex(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        return Integer.parseInt(String.valueOf(obj));
    }

    public static Class<? extends Object> getValueType(Type type) {
        Class cls;
        Type type2;
        if (type instanceof ParameterizedType) {
            cls = (Class) ((ParameterizedType) type).getRawType();
        } else {
            cls = (Class) type;
        }
        if (Collection.class.isAssignableFrom(cls)) {
            type2 = getParameterizedType(type, Collection.class, 0);
        } else {
            type2 = Map.class.isAssignableFrom(cls) ? getParameterizedType(type, Map.class, 1) : null;
        }
        if (type2 != null) {
            return findClass(type2);
        }
        return Object.class;
    }

    public static Class<?> getKeyType(Type type) {
        Class cls;
        Type parameterizedType;
        if (type instanceof ParameterizedType) {
            cls = (Class) ((ParameterizedType) type).getRawType();
        } else {
            cls = (Class) type;
        }
        if (!Map.class.isAssignableFrom(cls) || (parameterizedType = getParameterizedType(type, Map.class, 0)) == null) {
            return Integer.TYPE;
        }
        return findClass(parameterizedType);
    }

    private static Type getParameterizedType(Type type, Class<?> cls, int i) {
        Class cls2;
        ParameterizedType parameterizedType = null;
        Type[] typeArr = null;
        TypeVariable[] typeVariableArr = null;
        if (type instanceof ParameterizedType) {
            parameterizedType = (ParameterizedType) type;
            cls2 = (Class) parameterizedType.getRawType();
            typeArr = parameterizedType.getActualTypeArguments();
            typeVariableArr = cls2.getTypeParameters();
        } else {
            cls2 = (Class) type;
        }
        if (!cls.equals(cls2)) {
            Class[] interfaces = cls2.getInterfaces();
            Type[] genericInterfaces = cls2.getGenericInterfaces();
            for (int i2 = 0; i2 < interfaces.length; i2++) {
                if (cls.isAssignableFrom(interfaces[i2])) {
                    return getTureType(getParameterizedType(genericInterfaces[i2], cls, i), typeVariableArr, typeArr);
                }
            }
            Class superclass = cls2.getSuperclass();
            if (superclass != null && cls.isAssignableFrom(superclass)) {
                return getTureType(getParameterizedType(cls2.getGenericSuperclass(), cls, i), typeVariableArr, typeArr);
            }
            throw new IllegalArgumentException("必须是Collection 子类");
        } else if (parameterizedType != null) {
            return parameterizedType.getActualTypeArguments()[i];
        } else {
            return Object.class;
        }
    }

    private static Type getTureType(Type type, TypeVariable<?>[] typeVariableArr, Type[] typeArr) {
        if (type instanceof Class) {
            return type;
        }
        boolean z = type instanceof TypeVariable;
        TypeVariable typeVariable = type;
        if (z) {
            TypeVariable typeVariable2 = (TypeVariable) type;
            String name = typeVariable2.getName();
            typeVariable = typeVariable2;
            if (typeArr != null) {
                for (int i = 0; i < typeVariableArr.length; i++) {
                    if (name.equals(typeVariableArr[i].getName())) {
                        return typeArr[i];
                    }
                }
                typeVariable = typeVariable2;
            }
        }
        return typeVariable;
    }

    private static Class<? extends Object> findClass(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return findClass(((ParameterizedType) type).getRawType());
        }
        if (type instanceof WildcardType) {
            return findClass(((WildcardType) type).getUpperBounds()[0]);
        }
        return null;
    }

    public static Class<? extends Object> getPropertyType(Type type, Object obj) {
        Class<? extends Object> findClass = findClass(type);
        if (findClass == null) {
            return null;
        }
        if (findClass.isArray()) {
            if (LENGTH.equals(obj)) {
                return Integer.TYPE;
            }
            if (Number.class.isInstance(obj)) {
                return findClass.getComponentType();
            }
            return null;
        } else if (Collection.class.isAssignableFrom(findClass)) {
            return getValueType(type);
        } else {
            if (Map.class.isAssignableFrom(findClass)) {
                return getValueType(type);
            }
            Class<? extends Object> cls = getTypeMap(findClass).get(String.valueOf(obj));
            if (cls != null) {
                return cls;
            }
            return null;
        }
    }

    public static Object getValue(Object obj, Object obj2) {
        if (obj != null) {
            try {
                if (!obj.getClass().isArray()) {
                    if (obj instanceof Collection) {
                        if (LENGTH.equals(obj2)) {
                            return Integer.valueOf(((Collection) obj).size());
                        }
                        if (obj instanceof List) {
                            return ((List) obj).get(toIndex(obj2));
                        }
                    } else if ((obj instanceof String) && LENGTH.equals(obj2)) {
                        return Integer.valueOf(((String) obj).length());
                    }
                    if (obj instanceof Map) {
                        return ((Map) obj).get(obj2);
                    }
                    Method method = getGetterMap(obj.getClass()).get(String.valueOf(obj2));
                    if (method != null) {
                        return method.invoke(obj, new Object[0]);
                    }
                } else if (LENGTH.equals(obj2)) {
                    return Integer.valueOf(Array.getLength(obj));
                } else {
                    return Array.get(obj, toIndex(obj2));
                }
            } catch (Exception e) {
                if (log.isDebugEnabled()) {
                    log.debug(e);
                }
            }
        }
        if (!(obj2 instanceof String)) {
            return null;
        }
        try {
            if (obj instanceof Class) {
                return ((Class) obj).getField((String) obj2).get(obj);
            }
            return obj.getClass().getField((String) obj2).get(obj);
        } catch (NoSuchFieldException unused) {
            return null;
        } catch (Exception e2) {
            if (!log.isDebugEnabled()) {
                return null;
            }
            log.debug(e2);
            return null;
        }
    }

    public static void setValues(Object obj, Map<String, Object> map) {
        for (String next : map.keySet()) {
            setValue(obj, next, map.get(next));
        }
    }

    public static void setValue(Object obj, Object obj2, Object obj3) {
        if (obj != null) {
            try {
                if (obj.getClass().isArray()) {
                    Array.set(obj, toIndex(obj2), obj3);
                } else if (obj instanceof List) {
                    ((List) obj).set(toIndex(obj2), obj3);
                }
                if (obj instanceof Map) {
                    ((Map) obj).put(obj2, obj3);
                }
                Method method = getSetterMap(obj.getClass()).get(String.valueOf(obj2));
                if (method != null) {
                    if (obj3 != null) {
                        Class cls = method.getParameterTypes()[0];
                        if (!cls.isInstance(obj3)) {
                            Class<? extends Object> wrapper = toWrapper(cls);
                            if (Number.class.isAssignableFrom(wrapper)) {
                                obj3 = toValue((Number) obj3, wrapper);
                            }
                        }
                    }
                    method.invoke(obj, new Object[]{obj3});
                }
            } catch (Exception e) {
                if (log.isDebugEnabled()) {
                    log.debug(e);
                }
            }
        }
    }

    public static Number toValue(Number number, Class<? extends Object> cls) {
        if (cls == Long.class) {
            return Long.valueOf(number.longValue());
        }
        if (cls == Integer.class) {
            return Integer.valueOf(number.intValue());
        }
        if (cls == Short.class) {
            return Short.valueOf(number.shortValue());
        }
        if (cls == Byte.class) {
            return Byte.valueOf(number.byteValue());
        }
        if (cls == Double.class) {
            return Double.valueOf(number.doubleValue());
        }
        if (cls == Float.class) {
            return Float.valueOf(number.floatValue());
        }
        Class<? extends Object> wrapper = toWrapper(cls);
        if (wrapper == cls) {
            return null;
        }
        return toValue(number, wrapper);
    }

    public static final Class<? extends Object> toWrapper(Class<? extends Object> cls) {
        if (!cls.isPrimitive()) {
            return cls;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Short.TYPE == cls) {
            return Short.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        return Boolean.TYPE == cls ? Boolean.class : cls;
    }
}
