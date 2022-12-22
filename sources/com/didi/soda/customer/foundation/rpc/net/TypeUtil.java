package com.didi.soda.customer.foundation.rpc.net;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.didichuxing.foundation.util.TypeResolver;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public final class TypeUtil {
    private TypeUtil() {
    }

    /* renamed from: a */
    static boolean m29136a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static <T> T m29140c(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m29138b(Type type) {
        m29139b(!(type instanceof Class) || !((Class) type).isPrimitive());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m29139b(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static int m29141d(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static final class ParameterizedTypeImpl implements Serializable, ParameterizedType {
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
                TypeUtil.m29139b(z);
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
                    Object unused = TypeUtil.m29140c(typeArr2[i]);
                    TypeUtil.m29138b(this.mTypeArguments[i]);
                    Type[] typeArr3 = this.mTypeArguments;
                    typeArr3[i] = TypeResolver.canonicalize(typeArr3[i]);
                    i++;
                } else {
                    return;
                }
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) obj;
                return TypeUtil.m29136a(this.mRawType, parameterizedType.getRawType()) && TypeUtil.m29136a(this.mOwnerType, parameterizedType.getOwnerType()) && Arrays.equals(this.mTypeArguments, parameterizedType.getActualTypeArguments());
            }
        }

        public Type[] getActualTypeArguments() {
            return (Type[]) this.mTypeArguments.clone();
        }

        public Type getOwnerType() {
            return this.mOwnerType;
        }

        public Type getRawType() {
            return this.mRawType;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.mTypeArguments) ^ this.mRawType.hashCode()) ^ TypeUtil.m29141d(this.mOwnerType);
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
}
