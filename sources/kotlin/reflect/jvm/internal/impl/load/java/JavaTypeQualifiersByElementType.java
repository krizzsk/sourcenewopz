package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.EnumMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JavaTypeQualifiersByElementType.kt */
public final class JavaTypeQualifiersByElementType {

    /* renamed from: a */
    private final EnumMap<AnnotationQualifierApplicabilityType, JavaDefaultQualifiers> f60396a;

    public JavaTypeQualifiersByElementType(EnumMap<AnnotationQualifierApplicabilityType, JavaDefaultQualifiers> enumMap) {
        Intrinsics.checkNotNullParameter(enumMap, "defaultQualifiers");
        this.f60396a = enumMap;
    }

    public final EnumMap<AnnotationQualifierApplicabilityType, JavaDefaultQualifiers> getDefaultQualifiers() {
        return this.f60396a;
    }

    public final JavaDefaultQualifiers get(AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        return this.f60396a.get(annotationQualifierApplicabilityType);
    }
}
