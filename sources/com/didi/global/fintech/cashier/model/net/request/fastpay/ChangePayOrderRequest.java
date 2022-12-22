package com.didi.global.fintech.cashier.model.net.request.fastpay;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/fastpay/ChangePayOrderRequest;", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPayRequestCommonParams;", "auto_deduction_channel_list", "", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/DeductionChannel;", "non_auto_deduction_channel_list", "(Ljava/util/List;Ljava/util/List;)V", "getAuto_deduction_channel_list", "()Ljava/util/List;", "setAuto_deduction_channel_list", "(Ljava/util/List;)V", "getNon_auto_deduction_channel_list", "setNon_auto_deduction_channel_list", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ChangePayOrderRequest.kt */
public final class ChangePayOrderRequest extends FastPayRequestCommonParams {
    @SerializedName("auto_deduction_channel_list")
    private List<? extends DeductionChannel> auto_deduction_channel_list;
    @SerializedName("non_auto_deduction_channel_list")
    private List<? extends DeductionChannel> non_auto_deduction_channel_list;

    public ChangePayOrderRequest() {
        this((List) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ChangePayOrderRequest copy$default(ChangePayOrderRequest changePayOrderRequest, List<? extends DeductionChannel> list, List<? extends DeductionChannel> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = changePayOrderRequest.auto_deduction_channel_list;
        }
        if ((i & 2) != 0) {
            list2 = changePayOrderRequest.non_auto_deduction_channel_list;
        }
        return changePayOrderRequest.copy(list, list2);
    }

    public final List<DeductionChannel> component1() {
        return this.auto_deduction_channel_list;
    }

    public final List<DeductionChannel> component2() {
        return this.non_auto_deduction_channel_list;
    }

    public final ChangePayOrderRequest copy(List<? extends DeductionChannel> list, List<? extends DeductionChannel> list2) {
        return new ChangePayOrderRequest(list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChangePayOrderRequest)) {
            return false;
        }
        ChangePayOrderRequest changePayOrderRequest = (ChangePayOrderRequest) obj;
        return Intrinsics.areEqual((Object) this.auto_deduction_channel_list, (Object) changePayOrderRequest.auto_deduction_channel_list) && Intrinsics.areEqual((Object) this.non_auto_deduction_channel_list, (Object) changePayOrderRequest.non_auto_deduction_channel_list);
    }

    public int hashCode() {
        List<? extends DeductionChannel> list = this.auto_deduction_channel_list;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<? extends DeductionChannel> list2 = this.non_auto_deduction_channel_list;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ChangePayOrderRequest(auto_deduction_channel_list=" + this.auto_deduction_channel_list + ", non_auto_deduction_channel_list=" + this.non_auto_deduction_channel_list + VersionRange.RIGHT_OPEN;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChangePayOrderRequest(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
    }

    public final List<DeductionChannel> getAuto_deduction_channel_list() {
        return this.auto_deduction_channel_list;
    }

    public final void setAuto_deduction_channel_list(List<? extends DeductionChannel> list) {
        this.auto_deduction_channel_list = list;
    }

    public final List<DeductionChannel> getNon_auto_deduction_channel_list() {
        return this.non_auto_deduction_channel_list;
    }

    public final void setNon_auto_deduction_channel_list(List<? extends DeductionChannel> list) {
        this.non_auto_deduction_channel_list = list;
    }

    public ChangePayOrderRequest(List<? extends DeductionChannel> list, List<? extends DeductionChannel> list2) {
        this.auto_deduction_channel_list = list;
        this.non_auto_deduction_channel_list = list2;
    }
}
