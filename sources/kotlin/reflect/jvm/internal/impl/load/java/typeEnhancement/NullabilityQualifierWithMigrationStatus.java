package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

/* compiled from: NullabilityQualifierWithMigrationStatus.kt */
public final class NullabilityQualifierWithMigrationStatus {

    /* renamed from: a */
    private final NullabilityQualifier f60602a;

    /* renamed from: b */
    private final boolean f60603b;

    public static /* synthetic */ NullabilityQualifierWithMigrationStatus copy$default(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, NullabilityQualifier nullabilityQualifier, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            nullabilityQualifier = nullabilityQualifierWithMigrationStatus.f60602a;
        }
        if ((i & 2) != 0) {
            z = nullabilityQualifierWithMigrationStatus.f60603b;
        }
        return nullabilityQualifierWithMigrationStatus.copy(nullabilityQualifier, z);
    }

    public final NullabilityQualifierWithMigrationStatus copy(NullabilityQualifier nullabilityQualifier, boolean z) {
        Intrinsics.checkNotNullParameter(nullabilityQualifier, "qualifier");
        return new NullabilityQualifierWithMigrationStatus(nullabilityQualifier, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NullabilityQualifierWithMigrationStatus)) {
            return false;
        }
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = (NullabilityQualifierWithMigrationStatus) obj;
        return this.f60602a == nullabilityQualifierWithMigrationStatus.f60602a && this.f60603b == nullabilityQualifierWithMigrationStatus.f60603b;
    }

    public int hashCode() {
        int hashCode = this.f60602a.hashCode() * 31;
        boolean z = this.f60603b;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.f60602a + ", isForWarningOnly=" + this.f60603b + VersionRange.RIGHT_OPEN;
    }

    public NullabilityQualifierWithMigrationStatus(NullabilityQualifier nullabilityQualifier, boolean z) {
        Intrinsics.checkNotNullParameter(nullabilityQualifier, "qualifier");
        this.f60602a = nullabilityQualifier;
        this.f60603b = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NullabilityQualifierWithMigrationStatus(NullabilityQualifier nullabilityQualifier, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(nullabilityQualifier, (i & 2) != 0 ? false : z);
    }

    public final NullabilityQualifier getQualifier() {
        return this.f60602a;
    }

    public final boolean isForWarningOnly() {
        return this.f60603b;
    }
}
