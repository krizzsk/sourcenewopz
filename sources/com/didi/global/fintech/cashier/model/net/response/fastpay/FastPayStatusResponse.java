package com.didi.global.fintech.cashier.model.net.response.fastpay;

import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003JE\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006("}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayStatusResponse;", "Ljava/io/Serializable;", "nextStep", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "switchStatus", "", "button", "toast", "questionnaire", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/Questionnaire;", "(Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/didi/global/fintech/cashier/model/net/response/fastpay/Questionnaire;)V", "getButton", "()Ljava/lang/String;", "setButton", "(Ljava/lang/String;)V", "getNextStep", "()Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "setNextStep", "(Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;)V", "getQuestionnaire", "()Lcom/didi/global/fintech/cashier/model/net/response/fastpay/Questionnaire;", "setQuestionnaire", "(Lcom/didi/global/fintech/cashier/model/net/response/fastpay/Questionnaire;)V", "getSwitchStatus", "setSwitchStatus", "getToast", "setToast", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayStatusResponse.kt */
public final class FastPayStatusResponse implements Serializable {
    @SerializedName("button")
    private String button;
    @SerializedName("next_step")
    private CashierAction nextStep;
    @SerializedName("questionnaire")
    private Questionnaire questionnaire;
    @SerializedName("switch_status")
    private String switchStatus;
    @SerializedName("toast")
    private String toast;

    public static /* synthetic */ FastPayStatusResponse copy$default(FastPayStatusResponse fastPayStatusResponse, CashierAction cashierAction, String str, String str2, String str3, Questionnaire questionnaire2, int i, Object obj) {
        if ((i & 1) != 0) {
            cashierAction = fastPayStatusResponse.nextStep;
        }
        if ((i & 2) != 0) {
            str = fastPayStatusResponse.switchStatus;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = fastPayStatusResponse.button;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = fastPayStatusResponse.toast;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            questionnaire2 = fastPayStatusResponse.questionnaire;
        }
        return fastPayStatusResponse.copy(cashierAction, str4, str5, str6, questionnaire2);
    }

    public final CashierAction component1() {
        return this.nextStep;
    }

    public final String component2() {
        return this.switchStatus;
    }

    public final String component3() {
        return this.button;
    }

    public final String component4() {
        return this.toast;
    }

    public final Questionnaire component5() {
        return this.questionnaire;
    }

    public final FastPayStatusResponse copy(CashierAction cashierAction, String str, String str2, String str3, Questionnaire questionnaire2) {
        return new FastPayStatusResponse(cashierAction, str, str2, str3, questionnaire2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FastPayStatusResponse)) {
            return false;
        }
        FastPayStatusResponse fastPayStatusResponse = (FastPayStatusResponse) obj;
        return Intrinsics.areEqual((Object) this.nextStep, (Object) fastPayStatusResponse.nextStep) && Intrinsics.areEqual((Object) this.switchStatus, (Object) fastPayStatusResponse.switchStatus) && Intrinsics.areEqual((Object) this.button, (Object) fastPayStatusResponse.button) && Intrinsics.areEqual((Object) this.toast, (Object) fastPayStatusResponse.toast) && Intrinsics.areEqual((Object) this.questionnaire, (Object) fastPayStatusResponse.questionnaire);
    }

    public int hashCode() {
        CashierAction cashierAction = this.nextStep;
        int i = 0;
        int hashCode = (cashierAction == null ? 0 : cashierAction.hashCode()) * 31;
        String str = this.switchStatus;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.button;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.toast;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Questionnaire questionnaire2 = this.questionnaire;
        if (questionnaire2 != null) {
            i = questionnaire2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "FastPayStatusResponse(nextStep=" + this.nextStep + ", switchStatus=" + this.switchStatus + ", button=" + this.button + ", toast=" + this.toast + ", questionnaire=" + this.questionnaire + VersionRange.RIGHT_OPEN;
    }

    public FastPayStatusResponse(CashierAction cashierAction, String str, String str2, String str3, Questionnaire questionnaire2) {
        this.nextStep = cashierAction;
        this.switchStatus = str;
        this.button = str2;
        this.toast = str3;
        this.questionnaire = questionnaire2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FastPayStatusResponse(CashierAction cashierAction, String str, String str2, String str3, Questionnaire questionnaire2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : cashierAction, str, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : questionnaire2);
    }

    public final CashierAction getNextStep() {
        return this.nextStep;
    }

    public final void setNextStep(CashierAction cashierAction) {
        this.nextStep = cashierAction;
    }

    public final String getSwitchStatus() {
        return this.switchStatus;
    }

    public final void setSwitchStatus(String str) {
        this.switchStatus = str;
    }

    public final String getButton() {
        return this.button;
    }

    public final void setButton(String str) {
        this.button = str;
    }

    public final String getToast() {
        return this.toast;
    }

    public final void setToast(String str) {
        this.toast = str;
    }

    public final Questionnaire getQuestionnaire() {
        return this.questionnaire;
    }

    public final void setQuestionnaire(Questionnaire questionnaire2) {
        this.questionnaire = questionnaire2;
    }
}
