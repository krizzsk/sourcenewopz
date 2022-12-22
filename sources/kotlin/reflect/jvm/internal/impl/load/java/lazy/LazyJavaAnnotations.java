package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.sequences.SequencesKt;

/* compiled from: LazyJavaAnnotations.kt */
public final class LazyJavaAnnotations implements Annotations {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final LazyJavaResolverContext f60486a;

    /* renamed from: b */
    private final JavaAnnotationOwner f60487b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final boolean f60488c;

    /* renamed from: d */
    private final MemoizedFunctionToNullable<JavaAnnotation, AnnotationDescriptor> f60489d;

    public LazyJavaAnnotations(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotationOwner javaAnnotationOwner, boolean z) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(javaAnnotationOwner, "annotationOwner");
        this.f60486a = lazyJavaResolverContext;
        this.f60487b = javaAnnotationOwner;
        this.f60488c = z;
        this.f60489d = lazyJavaResolverContext.getComponents().getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaAnnotations$annotationDescriptors$1(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyJavaAnnotations(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotationOwner javaAnnotationOwner, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, javaAnnotationOwner, (i & 4) != 0 ? false : z);
    }

    public boolean hasAnnotation(FqName fqName) {
        return Annotations.DefaultImpls.hasAnnotation(this, fqName);
    }

    public AnnotationDescriptor findAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        JavaAnnotation findAnnotation = this.f60487b.findAnnotation(fqName);
        AnnotationDescriptor annotationDescriptor = findAnnotation == null ? null : (AnnotationDescriptor) this.f60489d.invoke(findAnnotation);
        return annotationDescriptor == null ? JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(fqName, this.f60487b, this.f60486a) : annotationDescriptor;
    }

    public Iterator<AnnotationDescriptor> iterator() {
        return SequencesKt.filterNotNull(SequencesKt.plus(SequencesKt.map(CollectionsKt.asSequence(this.f60487b.getAnnotations()), this.f60489d), JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(StandardNames.FqNames.deprecated, this.f60487b, this.f60486a))).iterator();
    }

    public boolean isEmpty() {
        return this.f60487b.getAnnotations().isEmpty() && !this.f60487b.isDeprecatedInJavaDoc();
    }
}
