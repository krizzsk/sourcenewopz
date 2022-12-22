package com.didi.global.fintech.cashier.model.net.response;

import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b-\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001Bk\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u00103\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00106\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017Jt\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\t\u0010=\u001a\u00020\u000eHÖ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R&\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006?"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/PayStatusResponse;", "Ljava/io/Serializable;", "payStatus", "", "showResultPage", "", "failedInfo", "Lcom/didi/global/fintech/cashier/model/net/response/FailedInfo;", "suggest", "", "Lcom/didi/global/fintech/cashier/model/net/response/PaymentSuggest;", "nextStep", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "pollingFrequency", "", "pollingTimes", "needPollingResult", "(Ljava/lang/String;Ljava/lang/Boolean;Lcom/didi/global/fintech/cashier/model/net/response/FailedInfo;Ljava/util/List;Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getFailedInfo", "()Lcom/didi/global/fintech/cashier/model/net/response/FailedInfo;", "setFailedInfo", "(Lcom/didi/global/fintech/cashier/model/net/response/FailedInfo;)V", "getNeedPollingResult", "()Ljava/lang/Boolean;", "setNeedPollingResult", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getNextStep", "()Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "setNextStep", "(Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;)V", "getPayStatus", "()Ljava/lang/String;", "setPayStatus", "(Ljava/lang/String;)V", "getPollingFrequency", "()Ljava/lang/Integer;", "setPollingFrequency", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPollingTimes", "setPollingTimes", "getShowResultPage", "setShowResultPage", "getSuggest", "()Ljava/util/List;", "setSuggest", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Lcom/didi/global/fintech/cashier/model/net/response/FailedInfo;Ljava/util/List;Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/didi/global/fintech/cashier/model/net/response/PayStatusResponse;", "equals", "other", "", "hashCode", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayStatusResponse.kt */
public final class PayStatusResponse implements Serializable {
    @SerializedName("failed_info")
    private FailedInfo failedInfo;
    @SerializedName("need_polling_result")
    private Boolean needPollingResult;
    @SerializedName("next_step")
    private CashierAction nextStep;
    @SerializedName("pay_status")
    private String payStatus;
    @SerializedName("polling_frequency")
    private Integer pollingFrequency;
    @SerializedName("polling_times")
    private Integer pollingTimes;
    @SerializedName("show_result_page")
    private Boolean showResultPage;
    @SerializedName("suggest")
    private List<PaymentSuggest> suggest;

    public PayStatusResponse() {
        this((String) null, (Boolean) null, (FailedInfo) null, (List) null, (CashierAction) null, (Integer) null, (Integer) null, (Boolean) null, 255, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PayStatusResponse copy$default(PayStatusResponse payStatusResponse, String str, Boolean bool, FailedInfo failedInfo2, List list, CashierAction cashierAction, Integer num, Integer num2, Boolean bool2, int i, Object obj) {
        PayStatusResponse payStatusResponse2 = payStatusResponse;
        int i2 = i;
        return payStatusResponse.copy((i2 & 1) != 0 ? payStatusResponse2.payStatus : str, (i2 & 2) != 0 ? payStatusResponse2.showResultPage : bool, (i2 & 4) != 0 ? payStatusResponse2.failedInfo : failedInfo2, (i2 & 8) != 0 ? payStatusResponse2.suggest : list, (i2 & 16) != 0 ? payStatusResponse2.nextStep : cashierAction, (i2 & 32) != 0 ? payStatusResponse2.pollingFrequency : num, (i2 & 64) != 0 ? payStatusResponse2.pollingTimes : num2, (i2 & 128) != 0 ? payStatusResponse2.needPollingResult : bool2);
    }

    public final String component1() {
        return this.payStatus;
    }

    public final Boolean component2() {
        return this.showResultPage;
    }

    public final FailedInfo component3() {
        return this.failedInfo;
    }

    public final List<PaymentSuggest> component4() {
        return this.suggest;
    }

    public final CashierAction component5() {
        return this.nextStep;
    }

    public final Integer component6() {
        return this.pollingFrequency;
    }

    public final Integer component7() {
        return this.pollingTimes;
    }

    public final Boolean component8() {
        return this.needPollingResult;
    }

    public final PayStatusResponse copy(String str, Boolean bool, FailedInfo failedInfo2, List<PaymentSuggest> list, CashierAction cashierAction, Integer num, Integer num2, Boolean bool2) {
        return new PayStatusResponse(str, bool, failedInfo2, list, cashierAction, num, num2, bool2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PayStatusResponse)) {
            return false;
        }
        PayStatusResponse payStatusResponse = (PayStatusResponse) obj;
        return Intrinsics.areEqual((Object) this.payStatus, (Object) payStatusResponse.payStatus) && Intrinsics.areEqual((Object) this.showResultPage, (Object) payStatusResponse.showResultPage) && Intrinsics.areEqual((Object) this.failedInfo, (Object) payStatusResponse.failedInfo) && Intrinsics.areEqual((Object) this.suggest, (Object) payStatusResponse.suggest) && Intrinsics.areEqual((Object) this.nextStep, (Object) payStatusResponse.nextStep) && Intrinsics.areEqual((Object) this.pollingFrequency, (Object) payStatusResponse.pollingFrequency) && Intrinsics.areEqual((Object) this.pollingTimes, (Object) payStatusResponse.pollingTimes) && Intrinsics.areEqual((Object) this.needPollingResult, (Object) payStatusResponse.needPollingResult);
    }

    public int hashCode() {
        String str = this.payStatus;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.showResultPage;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        FailedInfo failedInfo2 = this.failedInfo;
        int hashCode3 = (hashCode2 + (failedInfo2 == null ? 0 : failedInfo2.hashCode())) * 31;
        List<PaymentSuggest> list = this.suggest;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        CashierAction cashierAction = this.nextStep;
        int hashCode5 = (hashCode4 + (cashierAction == null ? 0 : cashierAction.hashCode())) * 31;
        Integer num = this.pollingFrequency;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.pollingTimes;
        int hashCode7 = (hashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool2 = this.needPollingResult;
        if (bool2 != null) {
            i = bool2.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        return "PayStatusResponse(payStatus=" + this.payStatus + ", showResultPage=" + this.showResultPage + ", failedInfo=" + this.failedInfo + ", suggest=" + this.suggest + ", nextStep=" + this.nextStep + ", pollingFrequency=" + this.pollingFrequency + ", pollingTimes=" + this.pollingTimes + ", needPollingResult=" + this.needPollingResult + VersionRange.RIGHT_OPEN;
    }

    public PayStatusResponse(String str, Boolean bool, FailedInfo failedInfo2, List<PaymentSuggest> list, CashierAction cashierAction, Integer num, Integer num2, Boolean bool2) {
        this.payStatus = str;
        this.showResultPage = bool;
        this.failedInfo = failedInfo2;
        this.suggest = list;
        this.nextStep = cashierAction;
        this.pollingFrequency = num;
        this.pollingTimes = num2;
        this.needPollingResult = bool2;
    }

    public final String getPayStatus() {
        return this.payStatus;
    }

    public final void setPayStatus(String str) {
        this.payStatus = str;
    }

    public final Boolean getShowResultPage() {
        return this.showResultPage;
    }

    public final void setShowResultPage(Boolean bool) {
        this.showResultPage = bool;
    }

    public final FailedInfo getFailedInfo() {
        return this.failedInfo;
    }

    public final void setFailedInfo(FailedInfo failedInfo2) {
        this.failedInfo = failedInfo2;
    }

    public final List<PaymentSuggest> getSuggest() {
        return this.suggest;
    }

    public final void setSuggest(List<PaymentSuggest> list) {
        this.suggest = list;
    }

    public final CashierAction getNextStep() {
        return this.nextStep;
    }

    public final void setNextStep(CashierAction cashierAction) {
        this.nextStep = cashierAction;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PayStatusResponse(java.lang.String r10, java.lang.Boolean r11, com.didi.global.fintech.cashier.model.net.response.FailedInfo r12, java.util.List r13, com.didi.global.fintech.cashier.model.net.request.CashierAction r14, java.lang.Integer r15, java.lang.Integer r16, java.lang.Boolean r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r2 = r14
        L_0x0025:
            r6 = r0 & 32
            r7 = 0
            if (r6 == 0) goto L_0x002f
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            goto L_0x0030
        L_0x002f:
            r6 = r15
        L_0x0030:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0039
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
            goto L_0x003b
        L_0x0039:
            r8 = r16
        L_0x003b:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0044
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r7)
            goto L_0x0046
        L_0x0044:
            r0 = r17
        L_0x0046:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r2
            r16 = r6
            r17 = r8
            r18 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.model.net.response.PayStatusResponse.<init>(java.lang.String, java.lang.Boolean, com.didi.global.fintech.cashier.model.net.response.FailedInfo, java.util.List, com.didi.global.fintech.cashier.model.net.request.CashierAction, java.lang.Integer, java.lang.Integer, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
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

    public final Boolean getNeedPollingResult() {
        return this.needPollingResult;
    }

    public final void setNeedPollingResult(Boolean bool) {
        this.needPollingResult = bool;
    }
}
