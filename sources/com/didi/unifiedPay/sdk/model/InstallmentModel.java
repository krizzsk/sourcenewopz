package com.didi.unifiedPay.sdk.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JO\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\tHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, mo175978d2 = {"Lcom/didi/unifiedPay/sdk/model/InstallmentModel;", "Ljava/io/Serializable;", "number", "", "eachAmount", "totalAmount", "serviceCharge", "info", "selected", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getEachAmount", "()Ljava/lang/String;", "getInfo", "getNumber", "getSelected", "()I", "getServiceCharge", "getTotalAmount", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "pay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Installment.kt */
public final class InstallmentModel implements Serializable {
    @SerializedName("each_amount_display")
    private final String eachAmount;
    private final String info;
    private final String number;
    private final int selected;
    @SerializedName("service_charge_display")
    private final String serviceCharge;
    @SerializedName("total_amount_display")
    private final String totalAmount;

    public static /* synthetic */ InstallmentModel copy$default(InstallmentModel installmentModel, String str, String str2, String str3, String str4, String str5, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = installmentModel.number;
        }
        if ((i2 & 2) != 0) {
            str2 = installmentModel.eachAmount;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = installmentModel.totalAmount;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = installmentModel.serviceCharge;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = installmentModel.info;
        }
        String str9 = str5;
        if ((i2 & 32) != 0) {
            i = installmentModel.selected;
        }
        return installmentModel.copy(str, str6, str7, str8, str9, i);
    }

    public final String component1() {
        return this.number;
    }

    public final String component2() {
        return this.eachAmount;
    }

    public final String component3() {
        return this.totalAmount;
    }

    public final String component4() {
        return this.serviceCharge;
    }

    public final String component5() {
        return this.info;
    }

    public final int component6() {
        return this.selected;
    }

    public final InstallmentModel copy(String str, String str2, String str3, String str4, String str5, int i) {
        return new InstallmentModel(str, str2, str3, str4, str5, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InstallmentModel)) {
            return false;
        }
        InstallmentModel installmentModel = (InstallmentModel) obj;
        return Intrinsics.areEqual((Object) this.number, (Object) installmentModel.number) && Intrinsics.areEqual((Object) this.eachAmount, (Object) installmentModel.eachAmount) && Intrinsics.areEqual((Object) this.totalAmount, (Object) installmentModel.totalAmount) && Intrinsics.areEqual((Object) this.serviceCharge, (Object) installmentModel.serviceCharge) && Intrinsics.areEqual((Object) this.info, (Object) installmentModel.info) && this.selected == installmentModel.selected;
    }

    public int hashCode() {
        String str = this.number;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.eachAmount;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.totalAmount;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.serviceCharge;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.info;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return ((hashCode4 + i) * 31) + this.selected;
    }

    public String toString() {
        return "InstallmentModel(number=" + this.number + ", eachAmount=" + this.eachAmount + ", totalAmount=" + this.totalAmount + ", serviceCharge=" + this.serviceCharge + ", info=" + this.info + ", selected=" + this.selected + VersionRange.RIGHT_OPEN;
    }

    public InstallmentModel(String str, String str2, String str3, String str4, String str5, int i) {
        this.number = str;
        this.eachAmount = str2;
        this.totalAmount = str3;
        this.serviceCharge = str4;
        this.info = str5;
        this.selected = i;
    }

    public final String getNumber() {
        return this.number;
    }

    public final String getEachAmount() {
        return this.eachAmount;
    }

    public final String getTotalAmount() {
        return this.totalAmount;
    }

    public final String getServiceCharge() {
        return this.serviceCharge;
    }

    public final String getInfo() {
        return this.info;
    }

    public final int getSelected() {
        return this.selected;
    }
}
