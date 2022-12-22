package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;

/* renamed from: kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver$mapJavaConstantToQualifierApplicabilityTypes$1 */
/* compiled from: AnnotationTypeQualifierResolver.kt */
final class C21581xefd2e52b extends Lambda implements Function2<EnumValue, AnnotationQualifierApplicabilityType, Boolean> {
    public static final C21581xefd2e52b INSTANCE = new C21581xefd2e52b();

    C21581xefd2e52b() {
        super(2);
    }

    public final Boolean invoke(EnumValue enumValue, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        Intrinsics.checkNotNullParameter(enumValue, "$this$mapConstantToQualifierApplicabilityTypes");
        Intrinsics.checkNotNullParameter(annotationQualifierApplicabilityType, "it");
        return Boolean.valueOf(Intrinsics.areEqual((Object) enumValue.getEnumEntryName().getIdentifier(), (Object) annotationQualifierApplicabilityType.getJavaTarget()));
    }
}
