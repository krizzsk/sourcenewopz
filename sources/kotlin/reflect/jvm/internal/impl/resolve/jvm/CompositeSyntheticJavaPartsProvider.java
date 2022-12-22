package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: SyntheticJavaPartsProvider.kt */
public final class CompositeSyntheticJavaPartsProvider implements SyntheticJavaPartsProvider {

    /* renamed from: a */
    private final List<SyntheticJavaPartsProvider> f60885a;

    public CompositeSyntheticJavaPartsProvider(List<? extends SyntheticJavaPartsProvider> list) {
        Intrinsics.checkNotNullParameter(list, "inner");
        this.f60885a = list;
    }

    public List<Name> getMethodNames(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        Collection arrayList = new ArrayList();
        for (SyntheticJavaPartsProvider methodNames : this.f60885a) {
            CollectionsKt.addAll(arrayList, methodNames.getMethodNames(classDescriptor));
        }
        return (List) arrayList;
    }

    public void generateMethods(ClassDescriptor classDescriptor, Name name, Collection<SimpleFunctionDescriptor> collection) {
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(collection, "result");
        for (SyntheticJavaPartsProvider generateMethods : this.f60885a) {
            generateMethods.generateMethods(classDescriptor, name, collection);
        }
    }

    public List<Name> getStaticFunctionNames(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        Collection arrayList = new ArrayList();
        for (SyntheticJavaPartsProvider staticFunctionNames : this.f60885a) {
            CollectionsKt.addAll(arrayList, staticFunctionNames.getStaticFunctionNames(classDescriptor));
        }
        return (List) arrayList;
    }

    public void generateStaticFunctions(ClassDescriptor classDescriptor, Name name, Collection<SimpleFunctionDescriptor> collection) {
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(collection, "result");
        for (SyntheticJavaPartsProvider generateStaticFunctions : this.f60885a) {
            generateStaticFunctions.generateStaticFunctions(classDescriptor, name, collection);
        }
    }

    public void generateConstructors(ClassDescriptor classDescriptor, List<ClassConstructorDescriptor> list) {
        Intrinsics.checkNotNullParameter(classDescriptor, "thisDescriptor");
        Intrinsics.checkNotNullParameter(list, "result");
        for (SyntheticJavaPartsProvider generateConstructors : this.f60885a) {
            generateConstructors.generateConstructors(classDescriptor, list);
        }
    }
}
