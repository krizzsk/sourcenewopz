package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: resolvers.kt */
public final class LazyJavaTypeParameterResolver implements TypeParameterResolver {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final LazyJavaResolverContext f60497a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final DeclarationDescriptor f60498b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final int f60499c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Map<JavaTypeParameter, Integer> f60500d;

    /* renamed from: e */
    private final MemoizedFunctionToNullable<JavaTypeParameter, LazyJavaTypeParameterDescriptor> f60501e = this.f60497a.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaTypeParameterResolver$resolve$1(this));

    public LazyJavaTypeParameterResolver(LazyJavaResolverContext lazyJavaResolverContext, DeclarationDescriptor declarationDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int i) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics.checkNotNullParameter(javaTypeParameterListOwner, "typeParameterOwner");
        this.f60497a = lazyJavaResolverContext;
        this.f60498b = declarationDescriptor;
        this.f60499c = i;
        this.f60500d = CollectionsKt.mapToIndex(javaTypeParameterListOwner.getTypeParameters());
    }

    public TypeParameterDescriptor resolveTypeParameter(JavaTypeParameter javaTypeParameter) {
        Intrinsics.checkNotNullParameter(javaTypeParameter, "javaTypeParameter");
        LazyJavaTypeParameterDescriptor invoke = this.f60501e.invoke(javaTypeParameter);
        return invoke == null ? this.f60497a.getTypeParameterResolver().resolveTypeParameter(javaTypeParameter) : invoke;
    }
}
