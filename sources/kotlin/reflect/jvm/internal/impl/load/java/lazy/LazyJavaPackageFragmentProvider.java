package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Collection;
import java.util.List;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;

/* compiled from: LazyJavaPackageFragmentProvider.kt */
public final class LazyJavaPackageFragmentProvider implements PackageFragmentProviderOptimized {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final LazyJavaResolverContext f60490a;

    /* renamed from: b */
    private final CacheWithNotNullValues<FqName, LazyJavaPackageFragment> f60491b;

    public LazyJavaPackageFragmentProvider(JavaResolverComponents javaResolverComponents) {
        Intrinsics.checkNotNullParameter(javaResolverComponents, "components");
        LazyJavaResolverContext lazyJavaResolverContext = new LazyJavaResolverContext(javaResolverComponents, TypeParameterResolver.EMPTY.INSTANCE, LazyKt.lazyOf(null));
        this.f60490a = lazyJavaResolverContext;
        this.f60491b = lazyJavaResolverContext.getStorageManager().createCacheWithNotNullValues();
    }

    /* renamed from: a */
    private final LazyJavaPackageFragment m44604a(FqName fqName) {
        JavaPackage findPackage = this.f60490a.getComponents().getFinder().findPackage(fqName);
        if (findPackage == null) {
            return null;
        }
        return this.f60491b.computeIfAbsent(fqName, new LazyJavaPackageFragmentProvider$getPackageFragment$1(this, findPackage));
    }

    public List<LazyJavaPackageFragment> getPackageFragments(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return CollectionsKt.listOfNotNull(m44604a(fqName));
    }

    public void collectPackageFragments(FqName fqName, Collection<PackageFragmentDescriptor> collection) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(collection, "packageFragments");
        kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(collection, m44604a(fqName));
    }

    public boolean isEmpty(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return this.f60490a.getComponents().getFinder().findPackage(fqName) == null;
    }

    public List<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        LazyJavaPackageFragment a = m44604a(fqName);
        List<FqName> subPackageFqNames$descriptors_jvm = a == null ? null : a.getSubPackageFqNames$descriptors_jvm();
        return subPackageFqNames$descriptors_jvm != null ? subPackageFqNames$descriptors_jvm : CollectionsKt.emptyList();
    }

    public String toString() {
        return Intrinsics.stringPlus("LazyJavaPackageFragmentProvider of module ", this.f60490a.getComponents().getModule());
    }
}
