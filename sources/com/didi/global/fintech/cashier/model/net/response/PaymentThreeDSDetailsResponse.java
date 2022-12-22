package com.didi.global.fintech.cashier.model.net.response;

import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006'"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/PaymentThreeDSDetailsResponse;", "Ljava/io/Serializable;", "needPollingResult", "", "pollingFrequency", "", "pollingTimes", "nextStep", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;)V", "getNeedPollingResult", "()Ljava/lang/Boolean;", "setNeedPollingResult", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getNextStep", "()Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "setNextStep", "(Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;)V", "getPollingFrequency", "()Ljava/lang/Integer;", "setPollingFrequency", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPollingTimes", "setPollingTimes", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;)Lcom/didi/global/fintech/cashier/model/net/response/PaymentThreeDSDetailsResponse;", "equals", "other", "", "hashCode", "toString", "", "Companion", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PaymentThreeDSDetailsResponse.kt */
public final class PaymentThreeDSDetailsResponse implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int RESULT_3DS = 2;
    public static final int RESULT_POLLING = 1;
    @SerializedName("need_polling_result")
    private Boolean needPollingResult;
    @SerializedName("next_step")
    private CashierAction nextStep;
    @SerializedName("polling_frequency")
    private Integer pollingFrequency;
    @SerializedName("polling_times")
    private Integer pollingTimes;

    public PaymentThreeDSDetailsResponse() {
        this((Boolean) null, (Integer) null, (Integer) null, (CashierAction) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PaymentThreeDSDetailsResponse copy$default(PaymentThreeDSDetailsResponse paymentThreeDSDetailsResponse, Boolean bool, Integer num, Integer num2, CashierAction cashierAction, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = paymentThreeDSDetailsResponse.needPollingResult;
        }
        if ((i & 2) != 0) {
            num = paymentThreeDSDetailsResponse.pollingFrequency;
        }
        if ((i & 4) != 0) {
            num2 = paymentThreeDSDetailsResponse.pollingTimes;
        }
        if ((i & 8) != 0) {
            cashierAction = paymentThreeDSDetailsResponse.nextStep;
        }
        return paymentThreeDSDetailsResponse.copy(bool, num, num2, cashierAction);
    }

    public final Boolean component1() {
        return this.needPollingResult;
    }

    public final Integer component2() {
        return this.pollingFrequency;
    }

    public final Integer component3() {
        return this.pollingTimes;
    }

    public final CashierAction component4() {
        return this.nextStep;
    }

    public final PaymentThreeDSDetailsResponse copy(Boolean bool, Integer num, Integer num2, CashierAction cashierAction) {
        return new PaymentThreeDSDetailsResponse(bool, num, num2, cashierAction);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentThreeDSDetailsResponse)) {
            return false;
        }
        PaymentThreeDSDetailsResponse paymentThreeDSDetailsResponse = (PaymentThreeDSDetailsResponse) obj;
        return Intrinsics.areEqual((Object) this.needPollingResult, (Object) paymentThreeDSDetailsResponse.needPollingResult) && Intrinsics.areEqual((Object) this.pollingFrequency, (Object) paymentThreeDSDetailsResponse.pollingFrequency) && Intrinsics.areEqual((Object) this.pollingTimes, (Object) paymentThreeDSDetailsResponse.pollingTimes) && Intrinsics.areEqual((Object) this.nextStep, (Object) paymentThreeDSDetailsResponse.nextStep);
    }

    public int hashCode() {
        Boolean bool = this.needPollingResult;
        int i = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Integer num = this.pollingFrequency;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.pollingTimes;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        CashierAction cashierAction = this.nextStep;
        if (cashierAction != null) {
            i = cashierAction.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "PaymentThreeDSDetailsResponse(needPollingResult=" + this.needPollingResult + ", pollingFrequency=" + this.pollingFrequency + ", pollingTimes=" + this.pollingTimes + ", nextStep=" + this.nextStep + VersionRange.RIGHT_OPEN;
    }

    public PaymentThreeDSDetailsResponse(Boolean bool, Integer num, Integer num2, CashierAction cashierAction) {
        this.needPollingResult = bool;
        this.pollingFrequency = num;
        this.pollingTimes = num2;
        this.nextStep = cashierAction;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentThreeDSDetailsResponse(Boolean bool, Integer num, Integer num2, CashierAction cashierAction, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : cashierAction);
    }

    public final Boolean getNeedPollingResult() {
        return this.needPollingResult;
    }

    public final void setNeedPollingResult(Boolean bool) {
        this.needPollingResult = bool;
    }

    public final Integer getPollingFrequency() {
        return this.pollingFrequency;
    }

    public final void setPollingFrequency(Integer num) {
        this.pollingFrequency = num;
    }

    public final Integer getPollingTimes() {
        return this.pollingTimes;
    }

    public final void setPollingTimes(Integer num) {
        this.pollingTimes = num;
    }

    public final CashierAction getNextStep() {
        return this.nextStep;
    }

    public final void setNextStep(CashierAction cashierAction) {
        this.nextStep = cashierAction;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/PaymentThreeDSDetailsResponse$Companion;", "", "()V", "RESULT_3DS", "", "RESULT_POLLING", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PaymentThreeDSDetailsResponse.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
