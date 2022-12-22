package com.didi.payment.kycservice.kyc.response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/payment/kycservice/kyc/response/MigrateTipData;", "", "migrateTitle", "", "migrateSubTitle", "migrateButton", "cancelButton", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCancelButton", "()Ljava/lang/String;", "getMigrateButton", "getMigrateSubTitle", "getMigrateTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CPFCheckResp.kt */
public final class MigrateTipData {

    /* renamed from: a */
    private final String f30843a;

    /* renamed from: b */
    private final String f30844b;

    /* renamed from: c */
    private final String f30845c;

    /* renamed from: d */
    private final String f30846d;

    public static /* synthetic */ MigrateTipData copy$default(MigrateTipData migrateTipData, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = migrateTipData.f30843a;
        }
        if ((i & 2) != 0) {
            str2 = migrateTipData.f30844b;
        }
        if ((i & 4) != 0) {
            str3 = migrateTipData.f30845c;
        }
        if ((i & 8) != 0) {
            str4 = migrateTipData.f30846d;
        }
        return migrateTipData.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.f30843a;
    }

    public final String component2() {
        return this.f30844b;
    }

    public final String component3() {
        return this.f30845c;
    }

    public final String component4() {
        return this.f30846d;
    }

    public final MigrateTipData copy(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "migrateTitle");
        Intrinsics.checkNotNullParameter(str2, "migrateSubTitle");
        Intrinsics.checkNotNullParameter(str3, "migrateButton");
        Intrinsics.checkNotNullParameter(str4, "cancelButton");
        return new MigrateTipData(str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MigrateTipData)) {
            return false;
        }
        MigrateTipData migrateTipData = (MigrateTipData) obj;
        return Intrinsics.areEqual((Object) this.f30843a, (Object) migrateTipData.f30843a) && Intrinsics.areEqual((Object) this.f30844b, (Object) migrateTipData.f30844b) && Intrinsics.areEqual((Object) this.f30845c, (Object) migrateTipData.f30845c) && Intrinsics.areEqual((Object) this.f30846d, (Object) migrateTipData.f30846d);
    }

    public int hashCode() {
        return (((((this.f30843a.hashCode() * 31) + this.f30844b.hashCode()) * 31) + this.f30845c.hashCode()) * 31) + this.f30846d.hashCode();
    }

    public String toString() {
        return "MigrateTipData(migrateTitle=" + this.f30843a + ", migrateSubTitle=" + this.f30844b + ", migrateButton=" + this.f30845c + ", cancelButton=" + this.f30846d + VersionRange.RIGHT_OPEN;
    }

    public MigrateTipData(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "migrateTitle");
        Intrinsics.checkNotNullParameter(str2, "migrateSubTitle");
        Intrinsics.checkNotNullParameter(str3, "migrateButton");
        Intrinsics.checkNotNullParameter(str4, "cancelButton");
        this.f30843a = str;
        this.f30844b = str2;
        this.f30845c = str3;
        this.f30846d = str4;
    }

    public final String getMigrateTitle() {
        return this.f30843a;
    }

    public final String getMigrateSubTitle() {
        return this.f30844b;
    }

    public final String getMigrateButton() {
        return this.f30845c;
    }

    public final String getCancelButton() {
        return this.f30846d;
    }
}
