package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import org.osgi.framework.VersionRange;

/* compiled from: AnnotationQualifiersFqNames.kt */
public final class JavaDefaultQualifiers {

    /* renamed from: a */
    private final NullabilityQualifierWithMigrationStatus f60379a;

    /* renamed from: b */
    private final Collection<AnnotationQualifierApplicabilityType> f60380b;

    /* renamed from: c */
    private final boolean f60381c;

    /* renamed from: d */
    private final boolean f60382d;

    public static /* synthetic */ JavaDefaultQualifiers copy$default(JavaDefaultQualifiers javaDefaultQualifiers, NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection<AnnotationQualifierApplicabilityType> collection, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            nullabilityQualifierWithMigrationStatus = javaDefaultQualifiers.f60379a;
        }
        if ((i & 2) != 0) {
            collection = javaDefaultQualifiers.f60380b;
        }
        if ((i & 4) != 0) {
            z = javaDefaultQualifiers.f60381c;
        }
        if ((i & 8) != 0) {
            z2 = javaDefaultQualifiers.f60382d;
        }
        return javaDefaultQualifiers.copy(nullabilityQualifierWithMigrationStatus, collection, z, z2);
    }

    public final JavaDefaultQualifiers copy(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection<? extends AnnotationQualifierApplicabilityType> collection, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(nullabilityQualifierWithMigrationStatus, "nullabilityQualifier");
        Intrinsics.checkNotNullParameter(collection, "qualifierApplicabilityTypes");
        return new JavaDefaultQualifiers(nullabilityQualifierWithMigrationStatus, collection, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JavaDefaultQualifiers)) {
            return false;
        }
        JavaDefaultQualifiers javaDefaultQualifiers = (JavaDefaultQualifiers) obj;
        return Intrinsics.areEqual((Object) this.f60379a, (Object) javaDefaultQualifiers.f60379a) && Intrinsics.areEqual((Object) this.f60380b, (Object) javaDefaultQualifiers.f60380b) && this.f60381c == javaDefaultQualifiers.f60381c && this.f60382d == javaDefaultQualifiers.f60382d;
    }

    public int hashCode() {
        int hashCode = ((this.f60379a.hashCode() * 31) + this.f60380b.hashCode()) * 31;
        boolean z = this.f60381c;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.f60382d;
        if (!z3) {
            z2 = z3;
        }
        return i + (z2 ? 1 : 0);
    }

    public String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.f60379a + ", qualifierApplicabilityTypes=" + this.f60380b + ", affectsTypeParameterBasedTypes=" + this.f60381c + ", affectsStarProjection=" + this.f60382d + VersionRange.RIGHT_OPEN;
    }

    public JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection<? extends AnnotationQualifierApplicabilityType> collection, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(nullabilityQualifierWithMigrationStatus, "nullabilityQualifier");
        Intrinsics.checkNotNullParameter(collection, "qualifierApplicabilityTypes");
        this.f60379a = nullabilityQualifierWithMigrationStatus;
        this.f60380b = collection;
        this.f60381c = z;
        this.f60382d = z2;
    }

    public final NullabilityQualifierWithMigrationStatus getNullabilityQualifier() {
        return this.f60379a;
    }

    public final Collection<AnnotationQualifierApplicabilityType> getQualifierApplicabilityTypes() {
        return this.f60380b;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ JavaDefaultQualifiers(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus r1, java.util.Collection r2, boolean r3, boolean r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r0 = this;
            r6 = r5 & 4
            if (r6 == 0) goto L_0x000f
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r3 = r1.getQualifier()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            if (r3 != r6) goto L_0x000e
            r3 = 1
            goto L_0x000f
        L_0x000e:
            r3 = 0
        L_0x000f:
            r5 = r5 & 8
            if (r5 == 0) goto L_0x0014
            r4 = r3
        L_0x0014:
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers.<init>(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus, java.util.Collection, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final boolean getAffectsTypeParameterBasedTypes() {
        return this.f60381c;
    }

    public final boolean getAffectsStarProjection() {
        return this.f60382d;
    }

    public final boolean getMakesTypeParameterNotNull() {
        return this.f60379a.getQualifier() == NullabilityQualifier.NOT_NULL && this.f60381c;
    }
}
