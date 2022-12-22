package com.didi.global.fintech.cashier.model.net.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J3\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\""}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/SuccessInfoResponse;", "Ljava/io/Serializable;", "button", "Lcom/didi/global/fintech/cashier/model/net/response/ReturnButton;", "priceInfo", "Lcom/didi/global/fintech/cashier/model/net/response/ResultPriceInfo;", "payments", "", "Lcom/didi/global/fintech/cashier/model/net/response/ResultPayments;", "(Lcom/didi/global/fintech/cashier/model/net/response/ReturnButton;Lcom/didi/global/fintech/cashier/model/net/response/ResultPriceInfo;Ljava/util/List;)V", "getButton", "()Lcom/didi/global/fintech/cashier/model/net/response/ReturnButton;", "setButton", "(Lcom/didi/global/fintech/cashier/model/net/response/ReturnButton;)V", "getPayments", "()Ljava/util/List;", "setPayments", "(Ljava/util/List;)V", "getPriceInfo", "()Lcom/didi/global/fintech/cashier/model/net/response/ResultPriceInfo;", "setPriceInfo", "(Lcom/didi/global/fintech/cashier/model/net/response/ResultPriceInfo;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SuccessInfoResponse.kt */
public final class SuccessInfoResponse implements Serializable {
    @SerializedName("return_button")
    private ReturnButton button;
    @SerializedName("payments")
    private List<ResultPayments> payments;
    @SerializedName("price_info")
    private ResultPriceInfo priceInfo;

    public SuccessInfoResponse() {
        this((ReturnButton) null, (ResultPriceInfo) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SuccessInfoResponse copy$default(SuccessInfoResponse successInfoResponse, ReturnButton returnButton, ResultPriceInfo resultPriceInfo, List<ResultPayments> list, int i, Object obj) {
        if ((i & 1) != 0) {
            returnButton = successInfoResponse.button;
        }
        if ((i & 2) != 0) {
            resultPriceInfo = successInfoResponse.priceInfo;
        }
        if ((i & 4) != 0) {
            list = successInfoResponse.payments;
        }
        return successInfoResponse.copy(returnButton, resultPriceInfo, list);
    }

    public final ReturnButton component1() {
        return this.button;
    }

    public final ResultPriceInfo component2() {
        return this.priceInfo;
    }

    public final List<ResultPayments> component3() {
        return this.payments;
    }

    public final SuccessInfoResponse copy(ReturnButton returnButton, ResultPriceInfo resultPriceInfo, List<ResultPayments> list) {
        return new SuccessInfoResponse(returnButton, resultPriceInfo, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuccessInfoResponse)) {
            return false;
        }
        SuccessInfoResponse successInfoResponse = (SuccessInfoResponse) obj;
        return Intrinsics.areEqual((Object) this.button, (Object) successInfoResponse.button) && Intrinsics.areEqual((Object) this.priceInfo, (Object) successInfoResponse.priceInfo) && Intrinsics.areEqual((Object) this.payments, (Object) successInfoResponse.payments);
    }

    public int hashCode() {
        ReturnButton returnButton = this.button;
        int i = 0;
        int hashCode = (returnButton == null ? 0 : returnButton.hashCode()) * 31;
        ResultPriceInfo resultPriceInfo = this.priceInfo;
        int hashCode2 = (hashCode + (resultPriceInfo == null ? 0 : resultPriceInfo.hashCode())) * 31;
        List<ResultPayments> list = this.payments;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "SuccessInfoResponse(button=" + this.button + ", priceInfo=" + this.priceInfo + ", payments=" + this.payments + VersionRange.RIGHT_OPEN;
    }

    public SuccessInfoResponse(ReturnButton returnButton, ResultPriceInfo resultPriceInfo, List<ResultPayments> list) {
        this.button = returnButton;
        this.priceInfo = resultPriceInfo;
        this.payments = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuccessInfoResponse(ReturnButton returnButton, ResultPriceInfo resultPriceInfo, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : returnButton, (i & 2) != 0 ? null : resultPriceInfo, (i & 4) != 0 ? null : list);
    }

    public final ReturnButton getButton() {
        return this.button;
    }

    public final void setButton(ReturnButton returnButton) {
        this.button = returnButton;
    }

    public final ResultPriceInfo getPriceInfo() {
        return this.priceInfo;
    }

    public final void setPriceInfo(ResultPriceInfo resultPriceInfo) {
        this.priceInfo = resultPriceInfo;
    }

    public final List<ResultPayments> getPayments() {
        return this.payments;
    }

    public final void setPayments(List<ResultPayments> list) {
        this.payments = list;
    }
}
