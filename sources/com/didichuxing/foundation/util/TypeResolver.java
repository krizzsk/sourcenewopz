package com.didichuxing.foundation.util;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

public abstract class TypeResolver {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Type[] f47652a = new Type[0];

    public static Type getGenericInterfaceTypeParameter(Object obj) {
        return getGenericInterfaceTypeParameter(obj.getClass());
    }

    public static Type getGenericInterfaceTypeParameter(Object obj, int i, int i2) {
        return getGenericInterfaceTypeParameter(obj.getClass(), i, i2);
    }

    public static Type getGenericInterfaceTypeParameter(Class<?> cls) {
        return getGenericInterfaceTypeParameter(cls, 0, 0);
    }

    public static Type getGenericInterfaceTypeParameter(Class<?> cls, int i, int i2) {
        Type[] genericInterfaces = cls.getGenericInterfaces();
        if (genericInterfaces != null && genericInterfaces.length > i) {
            return m34111a(genericInterfaces[i], i2);
        }
        throw new IllegalArgumentException("Missing generic interfaces");
    }

    public static Type getSuperclassTypeParameter(Object obj) {
        return getSuperclassTypeParameter(obj.getClass());
    }

    public static Type getSuperclassTypeParameter(Object obj, int i) {
        return getSuperclassTypeParameter(obj.getClass(), i);
    }

    public static Type getSuperclassTypeParameter(Class<?> cls) {
        return getSuperclassTypeParameter(cls, 0);
    }

    public static Type getSuperclassTypeParameter(Class<?> cls, int i) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            return getGenericTypeParameter((Class<?>) (Class) genericSuperclass);
        }
        return m34111a(genericSuperclass, i);
    }

    public static Type getGenericTypeParameter(Object obj) {
        return getGenericTypeParameter(obj.getClass());
    }

    public static Type getGenericTypeParameter(Object obj, int i, int i2) {
        return getGenericTypeParameter(obj.getClass(), i, i2);
    }

    public static Type getGenericTypeParameter(Class<?> cls) {
        return getGenericTypeParameter(cls, 0, 0);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:2|3|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        throw new java.lang.IllegalArgumentException("Missing generic type parameter");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        return getSuperclassTypeParameter(r0, r1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0005 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.reflect.Type getGenericTypeParameter(java.lang.Class<?> r0, int r1, int r2) {
        /*
            java.lang.reflect.Type r0 = getGenericInterfaceTypeParameter((java.lang.Class<?>) r0, (int) r1, (int) r2)     // Catch:{ Exception -> 0x0005 }
            goto L_0x0009
        L_0x0005:
            java.lang.reflect.Type r0 = getSuperclassTypeParameter((java.lang.Class<?>) r0, (int) r1)     // Catch:{ Exception -> 0x000a }
        L_0x0009:
            return r0
        L_0x000a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Missing generic type parameter"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.foundation.util.TypeResolver.getGenericTypeParameter(java.lang.Class, int, int):java.lang.reflect.Type");
    }

    /* renamed from: a */
    private static Type m34111a(Type type, int i) {
        return canonicalize(((ParameterizedType) type).getActualTypeArguments()[i]);
    }

    /* JADX WARNING: type inference failed for: r0v8, types: [com.didichuxing.foundation.util.TypeResolver$GenericArrayTypeImpl] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.reflect.Type canonicalize(java.lang.reflect.Type r3) {
        /*
            boolean r0 = r3 instanceof java.lang.Class
            if (r0 == 0) goto L_0x001d
            java.lang.Class r3 = (java.lang.Class) r3
            boolean r0 = r3.isArray()
            if (r0 == 0) goto L_0x001a
            com.didichuxing.foundation.util.TypeResolver$GenericArrayTypeImpl r0 = new com.didichuxing.foundation.util.TypeResolver$GenericArrayTypeImpl
            java.lang.Class r3 = r3.getComponentType()
            java.lang.reflect.Type r3 = canonicalize(r3)
            r0.<init>(r3)
            r3 = r0
        L_0x001a:
            java.lang.reflect.Type r3 = (java.lang.reflect.Type) r3
            return r3
        L_0x001d:
            boolean r0 = r3 instanceof java.lang.reflect.ParameterizedType
            if (r0 == 0) goto L_0x0035
            java.lang.reflect.ParameterizedType r3 = (java.lang.reflect.ParameterizedType) r3
            com.didichuxing.foundation.util.TypeResolver$ParameterizedTypeImpl r0 = new com.didichuxing.foundation.util.TypeResolver$ParameterizedTypeImpl
            java.lang.reflect.Type r1 = r3.getOwnerType()
            java.lang.reflect.Type r2 = r3.getRawType()
            java.lang.reflect.Type[] r3 = r3.getActualTypeArguments()
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0035:
            boolean r0 = r3 instanceof java.lang.reflect.GenericArrayType
            if (r0 == 0) goto L_0x0045
            java.lang.reflect.GenericArrayType r3 = (java.lang.reflect.GenericArrayType) r3
            com.didichuxing.foundation.util.TypeResolver$GenericArrayTypeImpl r0 = new com.didichuxing.foundation.util.TypeResolver$GenericArrayTypeImpl
            java.lang.reflect.Type r3 = r3.getGenericComponentType()
            r0.<init>(r3)
            return r0
        L_0x0045:
            boolean r0 = r3 instanceof java.lang.reflect.WildcardType
            if (r0 == 0) goto L_0x0059
            java.lang.reflect.WildcardType r3 = (java.lang.reflect.WildcardType) r3
            com.didichuxing.foundation.util.TypeResolver$WildcardTypeImpl r0 = new com.didichuxing.foundation.util.TypeResolver$WildcardTypeImpl
            java.lang.reflect.Type[] r1 = r3.getUpperBounds()
            java.lang.reflect.Type[] r3 = r3.getLowerBounds()
            r0.<init>(r1, r3)
            return r0
        L_0x0059:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.foundation.util.TypeResolver.canonicalize(java.lang.reflect.Type):java.lang.reflect.Type");
    }

    public static Class<?> getRawType(Type type) {
        String str;
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            m34118b(rawType instanceof Class);
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(getRawType(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return getRawType(((WildcardType) type).getUpperBounds()[0]);
            }
            if (type == null) {
                str = "null";
            } else {
                str = type.getClass().getName();
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + str);
        }
    }

    public static String typeToString(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    /* renamed from: a */
    static boolean m34114a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static <T> T m34119c(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m34117b(Type type) {
        m34118b(!(type instanceof Class) || !((Class) type).isPrimitive());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m34118b(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static int m34120d(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    private static final class WildcardTypeImpl implements Serializable, WildcardType {
        private final Type mLowerBound;
        private final Type mUpperBound;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            boolean z = true;
            TypeResolver.m34118b(typeArr2.length <= 1);
            TypeResolver.m34118b(typeArr.length == 1);
            if (typeArr2.length == 1) {
                Object unused = TypeResolver.m34119c(typeArr2[0]);
                TypeResolver.m34117b(typeArr2[0]);
                TypeResolver.m34118b(typeArr[0] != Object.class ? false : z);
                this.mLowerBound = TypeResolver.canonicalize(typeArr2[0]);
                this.mUpperBound = Object.class;
                return;
            }
            Object unused2 = TypeResolver.m34119c(typeArr[0]);
            TypeResolver.m34117b(typeArr[0]);
            this.mLowerBound = null;
            this.mUpperBound = TypeResolver.canonicalize(typeArr[0]);
        }

        public Type[] getUpperBounds() {
            return new Type[]{this.mUpperBound};
        }

        public Type[] getLowerBounds() {
            Type type = this.mLowerBound;
            if (type == null) {
                return TypeResolver.f47652a;
            }
            return new Type[]{type};
        }

        public boolean equals(Object obj) {
            if (obj instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) obj;
                return TypeResolver.m34114a((Object) this.mLowerBound, (Object) wildcardType.getLowerBounds()) && TypeResolver.m34114a((Object) this.mUpperBound, (Object) wildcardType.getUpperBounds());
            }
        }

        public int hashCode() {
            Type type = this.mLowerBound;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.mUpperBound.hashCode() + 31);
        }

        public String toString() {
            if (this.mLowerBound != null) {
                return "? super " + TypeResolver.typeToString(this.mLowerBound);
            } else if (this.mUpperBound == Object.class) {
                return "?";
            } else {
                return "? extends " + TypeResolver.typeToString(this.mUpperBound);
            }
        }
    }

    private static final class ParameterizedTypeImpl implements Serializable, ParameterizedType {
        private final Type mOwnerType;
        private final Type mRawType;
        private final Type[] mTypeArguments;

        public ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
            Type type3;
            int i = 0;
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z = true;
                boolean z2 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
                if (type == null && !z2) {
                    z = false;
                }
                TypeResolver.m34118b(z);
            }
            if (type == null) {
                type3 = null;
            } else {
                type3 = TypeResolver.canonicalize(type);
            }
            this.mOwnerType = type3;
            this.mRawType = TypeResolver.canonicalize(type2);
            this.mTypeArguments = (Type[]) typeArr.clone();
            while (true) {
                Type[] typeArr2 = this.mTypeArguments;
                if (i < typeArr2.length) {
                    Object unused = TypeResolver.m34119c(typeArr2[i]);
                    TypeResolver.m34117b(this.mTypeArguments[i]);
                    Type[] typeArr3 = this.mTypeArguments;
                    typeArr3[i] = TypeResolver.canonicalize(typeArr3[i]);
                    i++;
                } else {
                    return;
                }
            }
        }

        public Type[] getActualTypeArguments() {
            return (Type[]) this.mTypeArguments.clone();
        }

        public Type getRawType() {
            return this.mRawType;
        }

        public Type getOwnerType() {
            return this.mOwnerType;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) obj;
                return TypeResolver.m34114a((Object) this.mRawType, (Object) parameterizedType.getRawType()) && TypeResolver.m34114a((Object) this.mOwnerType, (Object) parameterizedType.getOwnerType()) && Arrays.equals(this.mTypeArguments, parameterizedType.getActualTypeArguments());
            }
        }

        public int hashCode() {
            return (Arrays.hashCode(this.mTypeArguments) ^ this.mRawType.hashCode()) ^ TypeResolver.m34120d(this.mOwnerType);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((this.mTypeArguments.length + 1) * 30);
            sb.append(TypeResolver.typeToString(this.mRawType));
            if (this.mTypeArguments.length == 0) {
                return sb.toString();
            }
            sb.append(IMTextUtils.STREET_IMAGE_TAG_START);
            sb.append(TypeResolver.typeToString(this.mTypeArguments[0]));
            for (int i = 1; i < this.mTypeArguments.length; i++) {
                sb.append(", ");
                sb.append(TypeResolver.typeToString(this.mTypeArguments[i]));
            }
            sb.append(IMTextUtils.STREET_IMAGE_TAG_END);
            return sb.toString();
        }
    }

    private static final class GenericArrayTypeImpl implements Serializable, GenericArrayType {
        private final Type mComponentType;

        public GenericArrayTypeImpl(Type type) {
            this.mComponentType = TypeResolver.canonicalize(type);
        }

        public Type getGenericComponentType() {
            return this.mComponentType;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && TypeResolver.m34114a((Object) this.mComponentType, (Object) ((GenericArrayType) obj).getGenericComponentType());
        }

        public int hashCode() {
            return this.mComponentType.hashCode();
        }

        public String toString() {
            return TypeResolver.typeToString(this.mComponentType) + "[]";
        }
    }

    private TypeResolver() {
    }
}
