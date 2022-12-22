package com.didi.global.fintech.cashier.model.net.response.fastpay;

import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/fastpay/ChangePayLimitResponse;", "Ljava/io/Serializable;", "toast", "", "nextStep", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "(Ljava/lang/String;Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;)V", "getNextStep", "()Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "setNextStep", "(Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;)V", "getToast", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ChangePayLimitResponse.kt */
public final class ChangePayLimitResponse implements Serializable {
    @SerializedName("next_step")
    private CashierAction nextStep;
    @SerializedName("toast")
    private String toast;

    public ChangePayLimitResponse() {
        this((String) null, (CashierAction) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ChangePayLimitResponse copy$default(ChangePayLimitResponse changePayLimitResponse, String str, CashierAction cashierAction, int i, Object obj) {
        if ((i & 1) != 0) {
            str = changePayLimitResponse.toast;
        }
        if ((i & 2) != 0) {
            cashierAction = changePayLimitResponse.nextStep;
        }
        return changePayLimitResponse.copy(str, cashierAction);
    }

    public final String component1() {
        return this.toast;
    }

    public final CashierAction component2() {
        return this.nextStep;
    }

    public final ChangePayLimitResponse copy(String str, CashierAction cashierAction) {
        return new ChangePayLimitResponse(str, cashierAction);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChangePayLimitResponse)) {
            return false;
        }
        ChangePayLimitResponse changePayLimitResponse = (ChangePayLimitResponse) obj;
        return Intrinsics.areEqual((Object) this.toast, (Object) changePayLimitResponse.toast) && Intrinsics.areEqual((Object) this.nextStep, (Object) changePayLimitResponse.nextStep);
    }

    public int hashCode() {
        String str = this.toast;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        CashierAction cashierAction = this.nextStep;
        if (cashierAction != null) {
            i = cashierAction.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ChangePayLimitResponse(toast=" + this.toast + ", nextStep=" + this.nextStep + VersionRange.RIGHT_OPEN;
    }

    public ChangePayLimitResponse(String str, CashierAction cashierAction) {
        this.toast = str;
        this.nextStep = cashierAction;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChangePayLimitResponse(String str, CashierAction cashierAction, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : cashierAction);
    }

    public final String getToast() {
        return this.toast;
    }

    public final void setToast(String str) {
        this.toast = str;
    }

    public final CashierAction getNextStep() {
        return this.nextStep;
    }

    public final void setNextStep(CashierAction cashierAction) {
        this.nextStep = cashierAction;
    }
}
