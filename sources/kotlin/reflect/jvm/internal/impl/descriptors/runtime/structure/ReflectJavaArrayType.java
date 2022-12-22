package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;

/* compiled from: ReflectJavaArrayType.kt */
public final class ReflectJavaArrayType extends ReflectJavaType implements JavaArrayType {

    /* renamed from: a */
    private final Type f60338a;

    /* renamed from: b */
    private final ReflectJavaType f60339b;

    /* renamed from: c */
    private final Collection<JavaAnnotation> f60340c;

    /* renamed from: d */
    private final boolean f60341d;

    public ReflectJavaArrayType(Type type) {
        ReflectJavaType reflectJavaType;
        Intrinsics.checkNotNullParameter(type, "reflectType");
        this.f60338a = type;
        Type reflectType = getReflectType();
        if (reflectType instanceof GenericArrayType) {
            ReflectJavaType.Factory factory = ReflectJavaType.Factory;
            Type genericComponentType = ((GenericArrayType) reflectType).getGenericComponentType();
            Intrinsics.checkNotNullExpressionValue(genericComponentType, "genericComponentType");
            reflectJavaType = factory.create(genericComponentType);
        } else {
            if (reflectType instanceof Class) {
                Class cls = (Class) reflectType;
                if (cls.isArray()) {
                    ReflectJavaType.Factory factory2 = ReflectJavaType.Factory;
                    Class<?> componentType = cls.getComponentType();
                    Intrinsics.checkNotNullExpressionValue(componentType, "getComponentType()");
                    reflectJavaType = factory2.create(componentType);
                }
            }
            throw new IllegalArgumentException("Not an array type (" + getReflectType().getClass() + "): " + getReflectType());
        }
        this.f60339b = reflectJavaType;
        this.f60340c = CollectionsKt.emptyList();
    }

    /* access modifiers changed from: protected */
    public Type getReflectType() {
        return this.f60338a;
    }

    public ReflectJavaType getComponentType() {
        return this.f60339b;
    }

    public Collection<JavaAnnotation> getAnnotations() {
        return this.f60340c;
    }

    public boolean isDeprecatedInJavaDoc() {
        return this.f60341d;
    }
}
