package com.didi.global.fintech.cashier.model.net.response.fastpay;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayOrderResponse;", "Ljava/io/Serializable;", "autoDeduction", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/Deduction;", "noAutoDeduction", "showInfo", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/ShowInfo;", "(Lcom/didi/global/fintech/cashier/model/net/response/fastpay/Deduction;Lcom/didi/global/fintech/cashier/model/net/response/fastpay/Deduction;Lcom/didi/global/fintech/cashier/model/net/response/fastpay/ShowInfo;)V", "getAutoDeduction", "()Lcom/didi/global/fintech/cashier/model/net/response/fastpay/Deduction;", "setAutoDeduction", "(Lcom/didi/global/fintech/cashier/model/net/response/fastpay/Deduction;)V", "getNoAutoDeduction", "setNoAutoDeduction", "getShowInfo", "()Lcom/didi/global/fintech/cashier/model/net/response/fastpay/ShowInfo;", "setShowInfo", "(Lcom/didi/global/fintech/cashier/model/net/response/fastpay/ShowInfo;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayOrderResponse.kt */
public final class FastPayOrderResponse implements Serializable {
    @SerializedName("auto_deduction")
    private Deduction autoDeduction;
    @SerializedName("non_auto_deduction")
    private Deduction noAutoDeduction;
    @SerializedName("show_info")
    private ShowInfo showInfo;

    public static /* synthetic */ FastPayOrderResponse copy$default(FastPayOrderResponse fastPayOrderResponse, Deduction deduction, Deduction deduction2, ShowInfo showInfo2, int i, Object obj) {
        if ((i & 1) != 0) {
            deduction = fastPayOrderResponse.autoDeduction;
        }
        if ((i & 2) != 0) {
            deduction2 = fastPayOrderResponse.noAutoDeduction;
        }
        if ((i & 4) != 0) {
            showInfo2 = fastPayOrderResponse.showInfo;
        }
        return fastPayOrderResponse.copy(deduction, deduction2, showInfo2);
    }

    public final Deduction component1() {
        return this.autoDeduction;
    }

    public final Deduction component2() {
        return this.noAutoDeduction;
    }

    public final ShowInfo component3() {
        return this.showInfo;
    }

    public final FastPayOrderResponse copy(Deduction deduction, Deduction deduction2, ShowInfo showInfo2) {
        return new FastPayOrderResponse(deduction, deduction2, showInfo2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FastPayOrderResponse)) {
            return false;
        }
        FastPayOrderResponse fastPayOrderResponse = (FastPayOrderResponse) obj;
        return Intrinsics.areEqual((Object) this.autoDeduction, (Object) fastPayOrderResponse.autoDeduction) && Intrinsics.areEqual((Object) this.noAutoDeduction, (Object) fastPayOrderResponse.noAutoDeduction) && Intrinsics.areEqual((Object) this.showInfo, (Object) fastPayOrderResponse.showInfo);
    }

    public int hashCode() {
        Deduction deduction = this.autoDeduction;
        int i = 0;
        int hashCode = (deduction == null ? 0 : deduction.hashCode()) * 31;
        Deduction deduction2 = this.noAutoDeduction;
        int hashCode2 = (hashCode + (deduction2 == null ? 0 : deduction2.hashCode())) * 31;
        ShowInfo showInfo2 = this.showInfo;
        if (showInfo2 != null) {
            i = showInfo2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "FastPayOrderResponse(autoDeduction=" + this.autoDeduction + ", noAutoDeduction=" + this.noAutoDeduction + ", showInfo=" + this.showInfo + VersionRange.RIGHT_OPEN;
    }

    public FastPayOrderResponse(Deduction deduction, Deduction deduction2, ShowInfo showInfo2) {
        this.autoDeduction = deduction;
        this.noAutoDeduction = deduction2;
        this.showInfo = showInfo2;
    }

    public final Deduction getAutoDeduction() {
        return this.autoDeduction;
    }

    public final void setAutoDeduction(Deduction deduction) {
        this.autoDeduction = deduction;
    }

    public final Deduction getNoAutoDeduction() {
        return this.noAutoDeduction;
    }

    public final void setNoAutoDeduction(Deduction deduction) {
        this.noAutoDeduction = deduction;
    }

    public final ShowInfo getShowInfo() {
        return this.showInfo;
    }

    public final void setShowInfo(ShowInfo showInfo2) {
        this.showInfo = showInfo2;
    }
}
