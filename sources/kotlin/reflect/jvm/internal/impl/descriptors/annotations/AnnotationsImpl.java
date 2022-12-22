package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: AnnotationsImpl.kt */
public final class AnnotationsImpl implements Annotations {

    /* renamed from: a */
    private final List<AnnotationDescriptor> f60199a;

    public AnnotationsImpl(List<? extends AnnotationDescriptor> list) {
        Intrinsics.checkNotNullParameter(list, "annotations");
        this.f60199a = list;
    }

    public AnnotationDescriptor findAnnotation(FqName fqName) {
        return Annotations.DefaultImpls.findAnnotation(this, fqName);
    }

    public boolean hasAnnotation(FqName fqName) {
        return Annotations.DefaultImpls.hasAnnotation(this, fqName);
    }

    public boolean isEmpty() {
        return this.f60199a.isEmpty();
    }

    public Iterator<AnnotationDescriptor> iterator() {
        return this.f60199a.iterator();
    }

    public String toString() {
        return this.f60199a.toString();
    }
}
