package com.didi.global.fintech.cashier.model.net.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/CashierInfo;", "Ljava/io/Serializable;", "brandName", "", "brandLogo", "(Ljava/lang/String;Ljava/lang/String;)V", "getBrandLogo", "()Ljava/lang/String;", "setBrandLogo", "(Ljava/lang/String;)V", "getBrandName", "setBrandName", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayInfoResponse.kt */
public final class CashierInfo implements Serializable {
    @SerializedName("brand_logo")
    private String brandLogo;
    @SerializedName("brand_name")
    private String brandName;

    public CashierInfo() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CashierInfo copy$default(CashierInfo cashierInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cashierInfo.brandName;
        }
        if ((i & 2) != 0) {
            str2 = cashierInfo.brandLogo;
        }
        return cashierInfo.copy(str, str2);
    }

    public final String component1() {
        return this.brandName;
    }

    public final String component2() {
        return this.brandLogo;
    }

    public final CashierInfo copy(String str, String str2) {
        return new CashierInfo(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CashierInfo)) {
            return false;
        }
        CashierInfo cashierInfo = (CashierInfo) obj;
        return Intrinsics.areEqual((Object) this.brandName, (Object) cashierInfo.brandName) && Intrinsics.areEqual((Object) this.brandLogo, (Object) cashierInfo.brandLogo);
    }

    public int hashCode() {
        String str = this.brandName;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.brandLogo;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CashierInfo(brandName=" + this.brandName + ", brandLogo=" + this.brandLogo + VersionRange.RIGHT_OPEN;
    }

    public CashierInfo(String str, String str2) {
        this.brandName = str;
        this.brandLogo = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CashierInfo(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getBrandName() {
        return this.brandName;
    }

    public final void setBrandName(String str) {
        this.brandName = str;
    }

    public final String getBrandLogo() {
        return this.brandLogo;
    }

    public final void setBrandLogo(String str) {
        this.brandLogo = str;
    }
}
