package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Substitutable;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: SubstitutingScope.kt */
public final class SubstitutingScope implements MemberScope {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final MemberScope f60917a;

    /* renamed from: b */
    private final TypeSubstitutor f60918b;

    /* renamed from: c */
    private Map<DeclarationDescriptor, DeclarationDescriptor> f60919c;

    /* renamed from: d */
    private final Lazy f60920d = LazyKt.lazy(new SubstitutingScope$_allDescriptors$2(this));

    public SubstitutingScope(MemberScope memberScope, TypeSubstitutor typeSubstitutor) {
        Intrinsics.checkNotNullParameter(memberScope, "workerScope");
        Intrinsics.checkNotNullParameter(typeSubstitutor, "givenSubstitutor");
        this.f60917a = memberScope;
        TypeSubstitution substitution = typeSubstitutor.getSubstitution();
        Intrinsics.checkNotNullExpressionValue(substitution, "givenSubstitutor.substitution");
        this.f60918b = CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(substitution, false, 1, (Object) null).buildSubstitutor();
    }

    public void recordLookup(Name name, LookupLocation lookupLocation) {
        MemberScope.DefaultImpls.recordLookup(this, name, lookupLocation);
    }

    /* renamed from: a */
    private final Collection<DeclarationDescriptor> m44958a() {
        return (Collection) this.f60920d.getValue();
    }

    /* renamed from: a */
    private final <D extends DeclarationDescriptor> D m44960a(D d) {
        if (this.f60918b.isEmpty()) {
            return d;
        }
        if (this.f60919c == null) {
            this.f60919c = new HashMap();
        }
        Map<DeclarationDescriptor, DeclarationDescriptor> map = this.f60919c;
        Intrinsics.checkNotNull(map);
        D d2 = map.get(d);
        if (d2 == null) {
            if (d instanceof Substitutable) {
                D substitute = ((Substitutable) d).substitute(this.f60918b);
                if (substitute != null) {
                    d2 = (DeclarationDescriptor) substitute;
                    map.put(d, d2);
                } else {
                    throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d + " substitution fails");
                }
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("Unknown descriptor in scope: ", d).toString());
            }
        }
        return (DeclarationDescriptor) d2;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final <D extends DeclarationDescriptor> Collection<D> m44959a(Collection<? extends D> collection) {
        if (this.f60918b.isEmpty() || collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet newLinkedHashSetWithExpectedSize = CollectionsKt.newLinkedHashSetWithExpectedSize(collection.size());
        Iterator<? extends D> it = collection.iterator();
        while (it.hasNext()) {
            newLinkedHashSetWithExpectedSize.add(m44960a((DeclarationDescriptor) it.next()));
        }
        return newLinkedHashSetWithExpectedSize;
    }

    public Collection<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return m44959a(this.f60917a.getContributedVariables(name, lookupLocation));
    }

    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        ClassifierDescriptor contributedClassifier = this.f60917a.getContributedClassifier(name, lookupLocation);
        if (contributedClassifier == null) {
            return null;
        }
        return (ClassifierDescriptor) m44960a(contributedClassifier);
    }

    public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return m44959a(this.f60917a.getContributedFunctions(name, lookupLocation));
    }

    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return m44958a();
    }

    public Set<Name> getFunctionNames() {
        return this.f60917a.getFunctionNames();
    }

    public Set<Name> getVariableNames() {
        return this.f60917a.getVariableNames();
    }

    public Set<Name> getClassifierNames() {
        return this.f60917a.getClassifierNames();
    }
}
