package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: context.kt */
public final class LazyJavaResolverContext {

    /* renamed from: a */
    private final JavaResolverComponents f60492a;

    /* renamed from: b */
    private final TypeParameterResolver f60493b;

    /* renamed from: c */
    private final Lazy<JavaTypeQualifiersByElementType> f60494c;

    /* renamed from: d */
    private final Lazy f60495d;

    /* renamed from: e */
    private final JavaTypeResolver f60496e;

    public LazyJavaResolverContext(JavaResolverComponents javaResolverComponents, TypeParameterResolver typeParameterResolver, Lazy<JavaTypeQualifiersByElementType> lazy) {
        Intrinsics.checkNotNullParameter(javaResolverComponents, "components");
        Intrinsics.checkNotNullParameter(typeParameterResolver, "typeParameterResolver");
        Intrinsics.checkNotNullParameter(lazy, "delegateForDefaultTypeQualifiers");
        this.f60492a = javaResolverComponents;
        this.f60493b = typeParameterResolver;
        this.f60494c = lazy;
        this.f60495d = lazy;
        this.f60496e = new JavaTypeResolver(this, typeParameterResolver);
    }

    public final JavaResolverComponents getComponents() {
        return this.f60492a;
    }

    public final TypeParameterResolver getTypeParameterResolver() {
        return this.f60493b;
    }

    public final Lazy<JavaTypeQualifiersByElementType> getDelegateForDefaultTypeQualifiers$descriptors_jvm() {
        return this.f60494c;
    }

    public final JavaTypeQualifiersByElementType getDefaultTypeQualifiers() {
        return (JavaTypeQualifiersByElementType) this.f60495d.getValue();
    }

    public final JavaTypeResolver getTypeResolver() {
        return this.f60496e;
    }

    public final StorageManager getStorageManager() {
        return this.f60492a.getStorageManager();
    }

    public final ModuleDescriptor getModule() {
        return this.f60492a.getModule();
    }
}
