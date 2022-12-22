package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;

/* compiled from: JvmPackageScope.kt */
public final class JvmPackageScope implements MemberScope {

    /* renamed from: a */
    static final /* synthetic */ KProperty<Object>[] f60508a = {C21490Reflection.property1(new PropertyReference1Impl(C21490Reflection.getOrCreateKotlinClass(JvmPackageScope.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final LazyJavaResolverContext f60509b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final LazyJavaPackageFragment f60510c;

    /* renamed from: d */
    private final LazyJavaPackageScope f60511d;

    /* renamed from: e */
    private final NotNullLazyValue f60512e = this.f60509b.getStorageManager().createLazyValue(new JvmPackageScope$kotlinScopes$2(this));

    public JvmPackageScope(LazyJavaResolverContext lazyJavaResolverContext, JavaPackage javaPackage, LazyJavaPackageFragment lazyJavaPackageFragment) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(javaPackage, "jPackage");
        Intrinsics.checkNotNullParameter(lazyJavaPackageFragment, "packageFragment");
        this.f60509b = lazyJavaResolverContext;
        this.f60510c = lazyJavaPackageFragment;
        this.f60511d = new LazyJavaPackageScope(this.f60509b, javaPackage, this.f60510c);
    }

    public final LazyJavaPackageScope getJavaScope$descriptors_jvm() {
        return this.f60511d;
    }

    /* renamed from: a */
    private final MemberScope[] m44605a() {
        return (MemberScope[]) StorageKt.getValue(this.f60512e, (Object) this, (KProperty<?>) f60508a[0]);
    }

    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        recordLookup(name, lookupLocation);
        ClassDescriptor contributedClassifier = this.f60511d.getContributedClassifier(name, lookupLocation);
        if (contributedClassifier != null) {
            return contributedClassifier;
        }
        MemberScope[] a = m44605a();
        ClassifierDescriptor classifierDescriptor = null;
        int i = 0;
        int length = a.length;
        while (i < length) {
            MemberScope memberScope = a[i];
            i++;
            ClassifierDescriptor contributedClassifier2 = memberScope.getContributedClassifier(name, lookupLocation);
            if (contributedClassifier2 != null) {
                if (!(contributedClassifier2 instanceof ClassifierDescriptorWithTypeParameters) || !((ClassifierDescriptorWithTypeParameters) contributedClassifier2).isExpect()) {
                    return contributedClassifier2;
                }
                if (classifierDescriptor == null) {
                    classifierDescriptor = contributedClassifier2;
                }
            }
        }
        return classifierDescriptor;
    }

    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        recordLookup(name, lookupLocation);
        LazyJavaPackageScope lazyJavaPackageScope = this.f60511d;
        MemberScope[] a = m44605a();
        Collection contributedVariables = lazyJavaPackageScope.getContributedVariables(name, lookupLocation);
        int length = a.length;
        int i = 0;
        while (i < length) {
            MemberScope memberScope = a[i];
            i++;
            contributedVariables = ScopeUtilsKt.concat(contributedVariables, memberScope.getContributedVariables(name, lookupLocation));
        }
        return contributedVariables == null ? SetsKt.emptySet() : contributedVariables;
    }

    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        recordLookup(name, lookupLocation);
        LazyJavaPackageScope lazyJavaPackageScope = this.f60511d;
        MemberScope[] a = m44605a();
        Collection contributedFunctions = lazyJavaPackageScope.getContributedFunctions(name, lookupLocation);
        int length = a.length;
        int i = 0;
        while (i < length) {
            MemberScope memberScope = a[i];
            i++;
            contributedFunctions = ScopeUtilsKt.concat(contributedFunctions, memberScope.getContributedFunctions(name, lookupLocation));
        }
        return contributedFunctions == null ? SetsKt.emptySet() : contributedFunctions;
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [java.lang.Object, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter r6, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> r7) {
        /*
            r5 = this;
            java.lang.String r0 = "kindFilter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "nameFilter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope r0 = r5.f60511d
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope[] r1 = r5.m44605a()
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r0 = (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope) r0
            java.util.Collection r0 = r0.getContributedDescriptors(r6, r7)
            int r2 = r1.length
            r3 = 0
        L_0x0018:
            if (r3 >= r2) goto L_0x0027
            r4 = r1[r3]
            int r3 = r3 + 1
            java.util.Collection r4 = r4.getContributedDescriptors(r6, r7)
            java.util.Collection r0 = kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt.concat(r0, r4)
            goto L_0x0018
        L_0x0027:
            if (r0 != 0) goto L_0x0030
            java.util.Set r6 = kotlin.collections.SetsKt.emptySet()
            r0 = r6
            java.util.Collection r0 = (java.util.Collection) r0
        L_0x0030:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JvmPackageScope.getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter, kotlin.jvm.functions.Function1):java.util.Collection");
    }

    public Set<Name> getFunctionNames() {
        MemberScope[] a = m44605a();
        Collection linkedHashSet = new LinkedHashSet();
        for (MemberScope functionNames : a) {
            CollectionsKt.addAll(linkedHashSet, functionNames.getFunctionNames());
        }
        Set<Name> set = (Set) linkedHashSet;
        set.addAll(getJavaScope$descriptors_jvm().getFunctionNames());
        return set;
    }

    public Set<Name> getVariableNames() {
        MemberScope[] a = m44605a();
        Collection linkedHashSet = new LinkedHashSet();
        for (MemberScope variableNames : a) {
            CollectionsKt.addAll(linkedHashSet, variableNames.getVariableNames());
        }
        Set<Name> set = (Set) linkedHashSet;
        set.addAll(getJavaScope$descriptors_jvm().getVariableNames());
        return set;
    }

    public Set<Name> getClassifierNames() {
        Set<Name> flatMapClassifierNamesOrNull = MemberScopeKt.flatMapClassifierNamesOrNull(ArraysKt.asIterable((T[]) m44605a()));
        if (flatMapClassifierNamesOrNull == null) {
            return null;
        }
        flatMapClassifierNamesOrNull.addAll(getJavaScope$descriptors_jvm().getClassifierNames());
        return flatMapClassifierNamesOrNull;
    }

    public void recordLookup(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        UtilsKt.record(this.f60509b.getComponents().getLookupTracker(), lookupLocation, (PackageFragmentDescriptor) this.f60510c, name);
    }

    public String toString() {
        return Intrinsics.stringPlus("scope for ", this.f60510c);
    }
}
