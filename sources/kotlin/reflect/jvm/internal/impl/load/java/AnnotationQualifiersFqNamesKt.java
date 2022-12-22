package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: AnnotationQualifiersFqNames.kt */
public final class AnnotationQualifiersFqNamesKt {

    /* renamed from: a */
    private static final FqName f60363a = new FqName("javax.annotation.meta.TypeQualifierNickname");

    /* renamed from: b */
    private static final FqName f60364b = new FqName("javax.annotation.meta.TypeQualifier");

    /* renamed from: c */
    private static final FqName f60365c = new FqName("javax.annotation.meta.TypeQualifierDefault");

    /* renamed from: d */
    private static final FqName f60366d = new FqName("kotlin.annotations.jvm.UnderMigration");

    /* renamed from: e */
    private static final List<AnnotationQualifierApplicabilityType> f60367e = CollectionsKt.listOf(AnnotationQualifierApplicabilityType.FIELD, AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, AnnotationQualifierApplicabilityType.TYPE_USE);

    /* renamed from: f */
    private static final Map<FqName, JavaDefaultQualifiers> f60368f = MapsKt.mapOf(TuplesKt.m42317to(JvmAnnotationNamesKt.getJSPECIFY_NULL_MARKED(), new JavaDefaultQualifiers(new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, false, 2, (DefaultConstructorMarker) null), f60367e, false, false)));

    /* renamed from: g */
    private static final Map<FqName, JavaDefaultQualifiers> f60369g = MapsKt.plus(MapsKt.mapOf(TuplesKt.m42317to(new FqName("javax.annotation.ParametersAreNullableByDefault"), new JavaDefaultQualifiers(new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, false, 2, (DefaultConstructorMarker) null), CollectionsKt.listOf(AnnotationQualifierApplicabilityType.VALUE_PARAMETER), false, false, 12, (DefaultConstructorMarker) null)), TuplesKt.m42317to(new FqName("javax.annotation.ParametersAreNonnullByDefault"), new JavaDefaultQualifiers(new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, false, 2, (DefaultConstructorMarker) null), CollectionsKt.listOf(AnnotationQualifierApplicabilityType.VALUE_PARAMETER), false, false, 12, (DefaultConstructorMarker) null))), (Map) f60368f);

    /* renamed from: h */
    private static final Set<FqName> f60370h = SetsKt.setOf(JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION(), JvmAnnotationNamesKt.getJAVAX_CHECKFORNULL_ANNOTATION());

    public static final FqName getTYPE_QUALIFIER_NICKNAME_FQNAME() {
        return f60363a;
    }

    public static final FqName getTYPE_QUALIFIER_FQNAME() {
        return f60364b;
    }

    public static final FqName getTYPE_QUALIFIER_DEFAULT_FQNAME() {
        return f60365c;
    }

    public static final FqName getMIGRATION_ANNOTATION_FQNAME() {
        return f60366d;
    }

    public static final Map<FqName, JavaDefaultQualifiers> getJSPECIFY_DEFAULT_ANNOTATIONS() {
        return f60368f;
    }

    public static final Map<FqName, JavaDefaultQualifiers> getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS() {
        return f60369g;
    }

    public static final Set<FqName> getBUILT_IN_TYPE_QUALIFIER_FQ_NAMES() {
        return f60370h;
    }
}
