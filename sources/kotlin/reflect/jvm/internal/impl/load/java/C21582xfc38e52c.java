package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver$mapKotlinConstantToQualifierApplicabilityTypes$1 */
/* compiled from: AnnotationTypeQualifierResolver.kt */
final class C21582xfc38e52c extends Lambda implements Function2<EnumValue, AnnotationQualifierApplicabilityType, Boolean> {
    final /* synthetic */ AnnotationTypeQualifierResolver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C21582xfc38e52c(AnnotationTypeQualifierResolver annotationTypeQualifierResolver) {
        super(2);
        this.this$0 = annotationTypeQualifierResolver;
    }

    public final Boolean invoke(EnumValue enumValue, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        Intrinsics.checkNotNullParameter(enumValue, "$this$mapConstantToQualifierApplicabilityTypes");
        Intrinsics.checkNotNullParameter(annotationQualifierApplicabilityType, "it");
        return Boolean.valueOf(this.this$0.m44571a(annotationQualifierApplicabilityType.getJavaTarget()).contains(enumValue.getEnumEntryName().getIdentifier()));
    }
}
