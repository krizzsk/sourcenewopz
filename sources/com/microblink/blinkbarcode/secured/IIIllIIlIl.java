package com.microblink.blinkbarcode.secured;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

/* compiled from: line */
abstract class IIIllIIlIl<T> {
    private final int IlIllIlIIl;
    private final Type llIIlIlIIl;

    /* compiled from: line */
    public static class IlIllIlIIl<T> extends IIIllIIlIl<T> {
        public IlIllIlIIl(Class<T> cls) {
            super(cls);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof IIIllIIlIl) && this.llIIlIlIIl.equals(((IIIllIIlIl) obj).llIIlIlIIl);
    }

    public int hashCode() {
        return this.IlIllIlIIl;
    }

    public Type llIIlIlIIl() {
        return this.llIIlIlIIl;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TypeReference<");
        llIIlIlIIl(this.llIIlIlIIl, sb);
        sb.append(IMTextUtils.STREET_IMAGE_TAG_END);
        return sb.toString();
    }

    public IIIllIIlIl() {
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.llIIlIlIIl = type;
        if (!llIIlIlIIl(type)) {
            this.IlIllIlIIl = type.hashCode();
            return;
        }
        throw new IllegalArgumentException("Including a type variable in a type reference is not allowed");
    }

    public static boolean llIIlIlIIl(Type type) {
        if (type == null) {
            return false;
        }
        if (type instanceof TypeVariable) {
            return true;
        }
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.getTypeParameters().length != 0) {
                return true;
            }
            return llIIlIlIIl((Type) cls.getDeclaringClass());
        } else if (type instanceof ParameterizedType) {
            for (Type llIIlIlIIl2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (llIIlIlIIl(llIIlIlIIl2)) {
                    return true;
                }
            }
            return false;
        } else if (!(type instanceof WildcardType)) {
            return false;
        } else {
            WildcardType wildcardType = (WildcardType) type;
            if (llIIlIlIIl(wildcardType.getLowerBounds()) || llIIlIlIIl(wildcardType.getUpperBounds())) {
                return true;
            }
            return false;
        }
    }

    private IIIllIIlIl(Type type) {
        this.llIIlIlIIl = type;
        if (!llIIlIlIIl(type)) {
            this.IlIllIlIIl = type.hashCode();
            return;
        }
        throw new IllegalArgumentException("Including a type variable in a type reference is not allowed");
    }

    private static void llIIlIlIIl(Type type, StringBuilder sb) {
        if (type != null) {
            if (type instanceof TypeVariable) {
                sb.append(((TypeVariable) type).getName());
            } else if (type instanceof Class) {
                Class cls = (Class) type;
                sb.append(cls.getName());
                llIIlIlIIl((Type[]) cls.getTypeParameters(), sb);
            } else if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                sb.append(((Class) parameterizedType.getRawType()).getName());
                llIIlIlIIl(parameterizedType.getActualTypeArguments(), sb);
            } else if (type instanceof GenericArrayType) {
                llIIlIlIIl(((GenericArrayType) type).getGenericComponentType(), sb);
                sb.append("[]");
            } else {
                sb.append(type.toString());
            }
        }
    }

    private static void llIIlIlIIl(Type[] typeArr, StringBuilder sb) {
        if (typeArr != null && typeArr.length != 0) {
            sb.append(IMTextUtils.STREET_IMAGE_TAG_START);
            for (int i = 0; i < typeArr.length; i++) {
                llIIlIlIIl(typeArr[i], sb);
                if (i != typeArr.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append(IMTextUtils.STREET_IMAGE_TAG_END);
        }
    }

    private static boolean llIIlIlIIl(Type[] typeArr) {
        if (typeArr == null) {
            return false;
        }
        for (Type llIIlIlIIl2 : typeArr) {
            if (llIIlIlIIl(llIIlIlIIl2)) {
                return true;
            }
        }
        return false;
    }
}
