package com.didi.rfusion.widget.progress;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/rfusion/widget/progress/RFVerticalProgressEntity;", "", "type", "", "title", "", "subTitle", "(ILjava/lang/String;Ljava/lang/String;)V", "getSubTitle", "()Ljava/lang/String;", "getTitle", "getType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFVerticalProgressEntity.kt */
public final class RFVerticalProgressEntity {

    /* renamed from: a */
    private final int f33658a;

    /* renamed from: b */
    private final String f33659b;

    /* renamed from: c */
    private final String f33660c;

    public static /* synthetic */ RFVerticalProgressEntity copy$default(RFVerticalProgressEntity rFVerticalProgressEntity, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = rFVerticalProgressEntity.f33658a;
        }
        if ((i2 & 2) != 0) {
            str = rFVerticalProgressEntity.f33659b;
        }
        if ((i2 & 4) != 0) {
            str2 = rFVerticalProgressEntity.f33660c;
        }
        return rFVerticalProgressEntity.copy(i, str, str2);
    }

    public final int component1() {
        return this.f33658a;
    }

    public final String component2() {
        return this.f33659b;
    }

    public final String component3() {
        return this.f33660c;
    }

    public final RFVerticalProgressEntity copy(int i, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        return new RFVerticalProgressEntity(i, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFVerticalProgressEntity)) {
            return false;
        }
        RFVerticalProgressEntity rFVerticalProgressEntity = (RFVerticalProgressEntity) obj;
        return this.f33658a == rFVerticalProgressEntity.f33658a && Intrinsics.areEqual((Object) this.f33659b, (Object) rFVerticalProgressEntity.f33659b) && Intrinsics.areEqual((Object) this.f33660c, (Object) rFVerticalProgressEntity.f33660c);
    }

    public int hashCode() {
        int i = this.f33658a * 31;
        String str = this.f33659b;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f33660c;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "RFVerticalProgressEntity(type=" + this.f33658a + ", title=" + this.f33659b + ", subTitle=" + this.f33660c + ")";
    }

    public RFVerticalProgressEntity(int i, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        this.f33658a = i;
        this.f33659b = str;
        this.f33660c = str2;
    }

    public final int getType() {
        return this.f33658a;
    }

    public final String getTitle() {
        return this.f33659b;
    }

    public final String getSubTitle() {
        return this.f33660c;
    }
}
