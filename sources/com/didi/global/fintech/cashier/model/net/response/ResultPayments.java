package com.didi.global.fintech.cashier.model.net.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001$B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006%"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/ResultPayments;", "Ljava/io/Serializable;", "icon", "", "displayName", "price", "Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;", "installment", "Lcom/didi/global/fintech/cashier/model/net/response/ResultPayments$InstallmentVo;", "(Ljava/lang/String;Ljava/lang/String;Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;Lcom/didi/global/fintech/cashier/model/net/response/ResultPayments$InstallmentVo;)V", "getDisplayName", "()Ljava/lang/String;", "setDisplayName", "(Ljava/lang/String;)V", "getIcon", "setIcon", "getInstallment", "()Lcom/didi/global/fintech/cashier/model/net/response/ResultPayments$InstallmentVo;", "setInstallment", "(Lcom/didi/global/fintech/cashier/model/net/response/ResultPayments$InstallmentVo;)V", "getPrice", "()Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;", "setPrice", "(Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "InstallmentVo", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SuccessInfoResponse.kt */
public final class ResultPayments implements Serializable {
    @SerializedName("name_display")
    private String displayName;
    @SerializedName("icon")
    private String icon;
    @SerializedName("installment")
    private InstallmentVo installment;
    @SerializedName("price")
    private PriceAmount price;

    public ResultPayments() {
        this((String) null, (String) null, (PriceAmount) null, (InstallmentVo) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ResultPayments copy$default(ResultPayments resultPayments, String str, String str2, PriceAmount priceAmount, InstallmentVo installmentVo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = resultPayments.icon;
        }
        if ((i & 2) != 0) {
            str2 = resultPayments.displayName;
        }
        if ((i & 4) != 0) {
            priceAmount = resultPayments.price;
        }
        if ((i & 8) != 0) {
            installmentVo = resultPayments.installment;
        }
        return resultPayments.copy(str, str2, priceAmount, installmentVo);
    }

    public final String component1() {
        return this.icon;
    }

    public final String component2() {
        return this.displayName;
    }

    public final PriceAmount component3() {
        return this.price;
    }

    public final InstallmentVo component4() {
        return this.installment;
    }

    public final ResultPayments copy(String str, String str2, PriceAmount priceAmount, InstallmentVo installmentVo) {
        return new ResultPayments(str, str2, priceAmount, installmentVo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResultPayments)) {
            return false;
        }
        ResultPayments resultPayments = (ResultPayments) obj;
        return Intrinsics.areEqual((Object) this.icon, (Object) resultPayments.icon) && Intrinsics.areEqual((Object) this.displayName, (Object) resultPayments.displayName) && Intrinsics.areEqual((Object) this.price, (Object) resultPayments.price) && Intrinsics.areEqual((Object) this.installment, (Object) resultPayments.installment);
    }

    public int hashCode() {
        String str = this.icon;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.displayName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        PriceAmount priceAmount = this.price;
        int hashCode3 = (hashCode2 + (priceAmount == null ? 0 : priceAmount.hashCode())) * 31;
        InstallmentVo installmentVo = this.installment;
        if (installmentVo != null) {
            i = installmentVo.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ResultPayments(icon=" + this.icon + ", displayName=" + this.displayName + ", price=" + this.price + ", installment=" + this.installment + VersionRange.RIGHT_OPEN;
    }

    public ResultPayments(String str, String str2, PriceAmount priceAmount, InstallmentVo installmentVo) {
        this.icon = str;
        this.displayName = str2;
        this.price = priceAmount;
        this.installment = installmentVo;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ResultPayments(String str, String str2, PriceAmount priceAmount, InstallmentVo installmentVo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : priceAmount, (i & 8) != 0 ? null : installmentVo);
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final void setDisplayName(String str) {
        this.displayName = str;
    }

    public final PriceAmount getPrice() {
        return this.price;
    }

    public final void setPrice(PriceAmount priceAmount) {
        this.price = priceAmount;
    }

    public final InstallmentVo getInstallment() {
        return this.installment;
    }

    public final void setInstallment(InstallmentVo installmentVo) {
        this.installment = installmentVo;
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/ResultPayments$InstallmentVo;", "Ljava/io/Serializable;", "number", "", "nameDisplay", "", "eachAmount", "Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;)V", "getEachAmount", "()Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;", "setEachAmount", "(Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;)V", "getNameDisplay", "()Ljava/lang/String;", "setNameDisplay", "(Ljava/lang/String;)V", "getNumber", "()Ljava/lang/Integer;", "setNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;)Lcom/didi/global/fintech/cashier/model/net/response/ResultPayments$InstallmentVo;", "equals", "", "other", "", "hashCode", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SuccessInfoResponse.kt */
    public static final class InstallmentVo implements Serializable {
        @SerializedName("each_amount")
        private PriceAmount eachAmount;
        @SerializedName("name_display")
        private String nameDisplay;
        @SerializedName("number")
        private Integer number;

        public InstallmentVo() {
            this((Integer) null, (String) null, (PriceAmount) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ InstallmentVo copy$default(InstallmentVo installmentVo, Integer num, String str, PriceAmount priceAmount, int i, Object obj) {
            if ((i & 1) != 0) {
                num = installmentVo.number;
            }
            if ((i & 2) != 0) {
                str = installmentVo.nameDisplay;
            }
            if ((i & 4) != 0) {
                priceAmount = installmentVo.eachAmount;
            }
            return installmentVo.copy(num, str, priceAmount);
        }

        public final Integer component1() {
            return this.number;
        }

        public final String component2() {
            return this.nameDisplay;
        }

        public final PriceAmount component3() {
            return this.eachAmount;
        }

        public final InstallmentVo copy(Integer num, String str, PriceAmount priceAmount) {
            return new InstallmentVo(num, str, priceAmount);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InstallmentVo)) {
                return false;
            }
            InstallmentVo installmentVo = (InstallmentVo) obj;
            return Intrinsics.areEqual((Object) this.number, (Object) installmentVo.number) && Intrinsics.areEqual((Object) this.nameDisplay, (Object) installmentVo.nameDisplay) && Intrinsics.areEqual((Object) this.eachAmount, (Object) installmentVo.eachAmount);
        }

        public int hashCode() {
            Integer num = this.number;
            int i = 0;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.nameDisplay;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            PriceAmount priceAmount = this.eachAmount;
            if (priceAmount != null) {
                i = priceAmount.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "InstallmentVo(number=" + this.number + ", nameDisplay=" + this.nameDisplay + ", eachAmount=" + this.eachAmount + VersionRange.RIGHT_OPEN;
        }

        public InstallmentVo(Integer num, String str, PriceAmount priceAmount) {
            this.number = num;
            this.nameDisplay = str;
            this.eachAmount = priceAmount;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ InstallmentVo(Integer num, String str, PriceAmount priceAmount, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : priceAmount);
        }

        public final Integer getNumber() {
            return this.number;
        }

        public final void setNumber(Integer num) {
            this.number = num;
        }

        public final String getNameDisplay() {
            return this.nameDisplay;
        }

        public final void setNameDisplay(String str) {
            this.nameDisplay = str;
        }

        public final PriceAmount getEachAmount() {
            return this.eachAmount;
        }

        public final void setEachAmount(PriceAmount priceAmount) {
            this.eachAmount = priceAmount;
        }
    }
}
