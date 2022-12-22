package com.didi.soda.customer.widget.dialog;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J+\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/dialog/NumProtectModel;", "", "phoneNum", "", "callingCode", "countryId", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getCallingCode", "()Ljava/lang/String;", "setCallingCode", "(Ljava/lang/String;)V", "getCountryId", "()I", "setCountryId", "(I)V", "getPhoneNum", "setPhoneNum", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NumProtectModel.kt */
public final class NumProtectModel {

    /* renamed from: a */
    private String f41785a;

    /* renamed from: b */
    private String f41786b;

    /* renamed from: c */
    private int f41787c;

    public static /* synthetic */ NumProtectModel copy$default(NumProtectModel numProtectModel, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = numProtectModel.f41785a;
        }
        if ((i2 & 2) != 0) {
            str2 = numProtectModel.f41786b;
        }
        if ((i2 & 4) != 0) {
            i = numProtectModel.f41787c;
        }
        return numProtectModel.copy(str, str2, i);
    }

    public final String component1() {
        return this.f41785a;
    }

    public final String component2() {
        return this.f41786b;
    }

    public final int component3() {
        return this.f41787c;
    }

    public final NumProtectModel copy(String str, String str2, int i) {
        return new NumProtectModel(str, str2, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NumProtectModel)) {
            return false;
        }
        NumProtectModel numProtectModel = (NumProtectModel) obj;
        return Intrinsics.areEqual((Object) this.f41785a, (Object) numProtectModel.f41785a) && Intrinsics.areEqual((Object) this.f41786b, (Object) numProtectModel.f41786b) && this.f41787c == numProtectModel.f41787c;
    }

    public int hashCode() {
        String str = this.f41785a;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f41786b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + this.f41787c;
    }

    public String toString() {
        return "NumProtectModel(phoneNum=" + this.f41785a + ", callingCode=" + this.f41786b + ", countryId=" + this.f41787c + VersionRange.RIGHT_OPEN;
    }

    public NumProtectModel(String str, String str2, int i) {
        this.f41785a = str;
        this.f41786b = str2;
        this.f41787c = i;
    }

    public final String getCallingCode() {
        return this.f41786b;
    }

    public final int getCountryId() {
        return this.f41787c;
    }

    public final String getPhoneNum() {
        return this.f41785a;
    }

    public final void setCallingCode(String str) {
        this.f41786b = str;
    }

    public final void setCountryId(int i) {
        this.f41787c = i;
    }

    public final void setPhoneNum(String str) {
        this.f41785a = str;
    }
}
