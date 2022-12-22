package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: JvmAnnotationNames.kt */
public final class JvmAnnotationNamesKt {

    /* renamed from: a */
    private static final FqName f60403a = new FqName("org.jspecify.nullness.Nullable");

    /* renamed from: b */
    private static final FqName f60404b = new FqName("org.jspecify.nullness.NullnessUnspecified");

    /* renamed from: c */
    private static final FqName f60405c = new FqName("org.jspecify.nullness.NullMarked");

    /* renamed from: d */
    private static final List<FqName> f60406d = CollectionsKt.listOf(JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, new FqName("androidx.annotation.Nullable"), new FqName("androidx.annotation.Nullable"), new FqName("android.annotation.Nullable"), new FqName("com.android.annotations.Nullable"), new FqName("org.eclipse.jdt.annotation.Nullable"), new FqName("org.checkerframework.checker.nullness.qual.Nullable"), new FqName("javax.annotation.Nullable"), new FqName("javax.annotation.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.Nullable"), new FqName("edu.umd.cs.findbugs.annotations.PossiblyNull"), new FqName("io.reactivex.annotations.Nullable"), new FqName("io.reactivex.rxjava3.annotations.Nullable"));

    /* renamed from: e */
    private static final FqName f60407e = new FqName("javax.annotation.Nonnull");

    /* renamed from: f */
    private static final FqName f60408f = new FqName("javax.annotation.CheckForNull");

    /* renamed from: g */
    private static final List<FqName> f60409g = CollectionsKt.listOf(JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, new FqName("edu.umd.cs.findbugs.annotations.NonNull"), new FqName("androidx.annotation.NonNull"), new FqName("androidx.annotation.NonNull"), new FqName("android.annotation.NonNull"), new FqName("com.android.annotations.NonNull"), new FqName("org.eclipse.jdt.annotation.NonNull"), new FqName("org.checkerframework.checker.nullness.qual.NonNull"), new FqName("lombok.NonNull"), new FqName("io.reactivex.annotations.NonNull"), new FqName("io.reactivex.rxjava3.annotations.NonNull"));

    /* renamed from: h */
    private static final FqName f60410h = new FqName("org.checkerframework.checker.nullness.compatqual.NullableDecl");

    /* renamed from: i */
    private static final FqName f60411i = new FqName("org.checkerframework.checker.nullness.compatqual.NonNullDecl");

    /* renamed from: j */
    private static final FqName f60412j = new FqName("androidx.annotation.RecentlyNullable");

    /* renamed from: k */
    private static final FqName f60413k = new FqName("androidx.annotation.RecentlyNonNull");

    /* renamed from: l */
    private static final Set<FqName> f60414l = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(new LinkedHashSet(), f60406d), f60407e), f60409g), f60410h), f60411i), f60412j), f60413k), f60403a), f60404b), f60405c);

    /* renamed from: m */
    private static final List<FqName> f60415m = CollectionsKt.listOf(JvmAnnotationNames.JETBRAINS_READONLY_ANNOTATION, JvmAnnotationNames.READONLY_ANNOTATION);

    /* renamed from: n */
    private static final List<FqName> f60416n = CollectionsKt.listOf(JvmAnnotationNames.JETBRAINS_MUTABLE_ANNOTATION, JvmAnnotationNames.MUTABLE_ANNOTATION);

    public static final FqName getJSPECIFY_NULLABLE() {
        return f60403a;
    }

    public static final FqName getJSPECIFY_NULLNESS_UNKNOWN() {
        return f60404b;
    }

    public static final FqName getJSPECIFY_NULL_MARKED() {
        return f60405c;
    }

    public static final List<FqName> getNULLABLE_ANNOTATIONS() {
        return f60406d;
    }

    public static final FqName getJAVAX_NONNULL_ANNOTATION() {
        return f60407e;
    }

    public static final FqName getJAVAX_CHECKFORNULL_ANNOTATION() {
        return f60408f;
    }

    public static final List<FqName> getNOT_NULL_ANNOTATIONS() {
        return f60409g;
    }

    public static final FqName getCOMPATQUAL_NULLABLE_ANNOTATION() {
        return f60410h;
    }

    public static final FqName getCOMPATQUAL_NONNULL_ANNOTATION() {
        return f60411i;
    }

    public static final FqName getANDROIDX_RECENTLY_NULLABLE_ANNOTATION() {
        return f60412j;
    }

    public static final FqName getANDROIDX_RECENTLY_NON_NULL_ANNOTATION() {
        return f60413k;
    }

    public static final List<FqName> getREAD_ONLY_ANNOTATIONS() {
        return f60415m;
    }

    public static final List<FqName> getMUTABLE_ANNOTATIONS() {
        return f60416n;
    }
}
