package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: ReflectJavaPrimitiveType.kt */
public final class ReflectJavaPrimitiveType extends ReflectJavaType implements JavaPrimitiveType {

    /* renamed from: a */
    private final Class<?> f60352a;

    /* renamed from: b */
    private final Collection<JavaAnnotation> f60353b = CollectionsKt.emptyList();

    /* renamed from: c */
    private final boolean f60354c;

    public ReflectJavaPrimitiveType(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "reflectType");
        this.f60352a = cls;
    }

    /* access modifiers changed from: protected */
    public Class<?> getReflectType() {
        return this.f60352a;
    }

    public PrimitiveType getType() {
        if (Intrinsics.areEqual((Object) getReflectType(), (Object) Void.TYPE)) {
            return null;
        }
        return JvmPrimitiveType.get(getReflectType().getName()).getPrimitiveType();
    }

    public Collection<JavaAnnotation> getAnnotations() {
        return this.f60353b;
    }

    public boolean isDeprecatedInJavaDoc() {
        return this.f60354c;
    }
}
