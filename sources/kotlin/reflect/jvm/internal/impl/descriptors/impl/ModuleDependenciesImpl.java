package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModuleDescriptorImpl.kt */
public final class ModuleDependenciesImpl implements ModuleDependencies {

    /* renamed from: a */
    private final List<ModuleDescriptorImpl> f60242a;

    /* renamed from: b */
    private final Set<ModuleDescriptorImpl> f60243b;

    /* renamed from: c */
    private final List<ModuleDescriptorImpl> f60244c;

    /* renamed from: d */
    private final Set<ModuleDescriptorImpl> f60245d;

    public ModuleDependenciesImpl(List<ModuleDescriptorImpl> list, Set<ModuleDescriptorImpl> set, List<ModuleDescriptorImpl> list2, Set<ModuleDescriptorImpl> set2) {
        Intrinsics.checkNotNullParameter(list, "allDependencies");
        Intrinsics.checkNotNullParameter(set, "modulesWhoseInternalsAreVisible");
        Intrinsics.checkNotNullParameter(list2, "directExpectedByDependencies");
        Intrinsics.checkNotNullParameter(set2, "allExpectedByDependencies");
        this.f60242a = list;
        this.f60243b = set;
        this.f60244c = list2;
        this.f60245d = set2;
    }

    public List<ModuleDescriptorImpl> getAllDependencies() {
        return this.f60242a;
    }

    public Set<ModuleDescriptorImpl> getModulesWhoseInternalsAreVisible() {
        return this.f60243b;
    }

    public List<ModuleDescriptorImpl> getDirectExpectedByDependencies() {
        return this.f60244c;
    }
}
