package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.C21490Reflection;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;

/* compiled from: AnnotationTypeQualifierResolver.kt */
/* synthetic */ class AnnotationTypeQualifierResolver$resolvedNicknames$1 extends FunctionReference implements Function1<ClassDescriptor, AnnotationDescriptor> {
    AnnotationTypeQualifierResolver$resolvedNicknames$1(Object obj) {
        super(1, obj);
    }

    public final String getName() {
        return "computeTypeQualifierNickname";
    }

    public final String getSignature() {
        return "computeTypeQualifierNickname(Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;)Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;";
    }

    public final KDeclarationContainer getOwner() {
        return C21490Reflection.getOrCreateKotlinClass(AnnotationTypeQualifierResolver.class);
    }

    public final AnnotationDescriptor invoke(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "p0");
        return ((AnnotationTypeQualifierResolver) this.receiver).m44574a(classDescriptor);
    }
}
