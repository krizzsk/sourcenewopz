package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaPackage.kt */
public final class ReflectJavaPackage extends ReflectJavaElement implements JavaPackage {

    /* renamed from: a */
    private final FqName f60351a;

    public JavaAnnotation findAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return null;
    }

    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    public ReflectJavaPackage(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        this.f60351a = fqName;
    }

    public FqName getFqName() {
        return this.f60351a;
    }

    public Collection<JavaClass> getClasses(Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return CollectionsKt.emptyList();
    }

    public Collection<JavaPackage> getSubPackages() {
        return CollectionsKt.emptyList();
    }

    public List<JavaAnnotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaPackage) && Intrinsics.areEqual((Object) getFqName(), (Object) ((ReflectJavaPackage) obj).getFqName());
    }

    public int hashCode() {
        return getFqName().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + getFqName();
    }
}
