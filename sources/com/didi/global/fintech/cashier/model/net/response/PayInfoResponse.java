package com.didi.global.fintech.cashier.model.net.response;

import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b=\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\b\u0018\u0000 [2\u00020\u0001:\u0001[B¡\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010)J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0011\u0010O\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003J\u0011\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011HÆ\u0003Jª\u0001\u0010Q\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010RJ\u0013\u0010S\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010VHÖ\u0003J\t\u0010W\u001a\u00020\u0016HÖ\u0001J\u0006\u0010X\u001a\u00020TJ\u0006\u0010Y\u001a\u00020TJ\t\u0010Z\u001a\u00020\u0003HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR&\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R \u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R&\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u0010!R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R \u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010#\"\u0004\bD\u0010%¨\u0006\\"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "Ljava/io/Serializable;", "status", "", "initAction", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "cashierInfo", "Lcom/didi/global/fintech/cashier/model/net/response/CashierInfo;", "policyInfo", "Lcom/didi/global/fintech/cashier/model/net/response/PolicyInfo;", "orderInfo", "Lcom/didi/global/fintech/cashier/model/net/response/OrderInfo;", "showInfo", "Lcom/didi/global/fintech/cashier/model/net/response/ShowInfo;", "priceInfo", "Lcom/didi/global/fintech/cashier/model/net/response/PriceInfo;", "paymentGroups", "", "Lcom/didi/global/fintech/cashier/model/net/response/PaymentGroup;", "extraPayChannels", "Lcom/didi/global/fintech/cashier/model/net/response/BasicPayment;", "failedType", "", "failedTitle", "failedReason", "(Ljava/lang/String;Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;Lcom/didi/global/fintech/cashier/model/net/response/CashierInfo;Lcom/didi/global/fintech/cashier/model/net/response/PolicyInfo;Lcom/didi/global/fintech/cashier/model/net/response/OrderInfo;Lcom/didi/global/fintech/cashier/model/net/response/ShowInfo;Lcom/didi/global/fintech/cashier/model/net/response/PriceInfo;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getCashierInfo", "()Lcom/didi/global/fintech/cashier/model/net/response/CashierInfo;", "setCashierInfo", "(Lcom/didi/global/fintech/cashier/model/net/response/CashierInfo;)V", "getExtraPayChannels", "()Ljava/util/List;", "setExtraPayChannels", "(Ljava/util/List;)V", "getFailedReason", "()Ljava/lang/String;", "setFailedReason", "(Ljava/lang/String;)V", "getFailedTitle", "setFailedTitle", "getFailedType", "()Ljava/lang/Integer;", "setFailedType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getInitAction", "()Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "setInitAction", "(Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;)V", "getOrderInfo", "()Lcom/didi/global/fintech/cashier/model/net/response/OrderInfo;", "setOrderInfo", "(Lcom/didi/global/fintech/cashier/model/net/response/OrderInfo;)V", "getPaymentGroups", "setPaymentGroups", "getPolicyInfo", "()Lcom/didi/global/fintech/cashier/model/net/response/PolicyInfo;", "setPolicyInfo", "(Lcom/didi/global/fintech/cashier/model/net/response/PolicyInfo;)V", "getPriceInfo", "()Lcom/didi/global/fintech/cashier/model/net/response/PriceInfo;", "setPriceInfo", "(Lcom/didi/global/fintech/cashier/model/net/response/PriceInfo;)V", "getShowInfo", "()Lcom/didi/global/fintech/cashier/model/net/response/ShowInfo;", "setShowInfo", "(Lcom/didi/global/fintech/cashier/model/net/response/ShowInfo;)V", "getStatus", "setStatus", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;Lcom/didi/global/fintech/cashier/model/net/response/CashierInfo;Lcom/didi/global/fintech/cashier/model/net/response/PolicyInfo;Lcom/didi/global/fintech/cashier/model/net/response/OrderInfo;Lcom/didi/global/fintech/cashier/model/net/response/ShowInfo;Lcom/didi/global/fintech/cashier/model/net/response/PriceInfo;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse;", "equals", "", "other", "", "hashCode", "pix", "success", "toString", "Companion", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayInfoResponse.kt */
public final class PayInfoResponse implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int FAILED_TYPE_CUSTOM = 1;
    public static final int FAILED_TYPE_UPGRADE = 2;
    @SerializedName("cashier_info")
    private CashierInfo cashierInfo;
    @SerializedName("extra_pay_channels")
    private List<? extends BasicPayment> extraPayChannels;
    @SerializedName("failed_reason")
    private String failedReason;
    @SerializedName("failed_title")
    private String failedTitle;
    @SerializedName("failed_type")
    private Integer failedType;
    @SerializedName("init_action")
    private CashierAction initAction;
    @SerializedName("order_info")
    private OrderInfo orderInfo;
    @SerializedName("payment_groups")
    private List<PaymentGroup> paymentGroups;
    @SerializedName("policy_info")
    private PolicyInfo policyInfo;
    @SerializedName("price_info")
    private PriceInfo priceInfo;
    @SerializedName("show_info")
    private ShowInfo showInfo;
    @SerializedName("status")
    private String status;

    public PayInfoResponse() {
        this((String) null, (CashierAction) null, (CashierInfo) null, (PolicyInfo) null, (OrderInfo) null, (ShowInfo) null, (PriceInfo) null, (List) null, (List) null, (Integer) null, (String) null, (String) null, 4095, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PayInfoResponse copy$default(PayInfoResponse payInfoResponse, String str, CashierAction cashierAction, CashierInfo cashierInfo2, PolicyInfo policyInfo2, OrderInfo orderInfo2, ShowInfo showInfo2, PriceInfo priceInfo2, List list, List list2, Integer num, String str2, String str3, int i, Object obj) {
        PayInfoResponse payInfoResponse2 = payInfoResponse;
        int i2 = i;
        return payInfoResponse.copy((i2 & 1) != 0 ? payInfoResponse2.status : str, (i2 & 2) != 0 ? payInfoResponse2.initAction : cashierAction, (i2 & 4) != 0 ? payInfoResponse2.cashierInfo : cashierInfo2, (i2 & 8) != 0 ? payInfoResponse2.policyInfo : policyInfo2, (i2 & 16) != 0 ? payInfoResponse2.orderInfo : orderInfo2, (i2 & 32) != 0 ? payInfoResponse2.showInfo : showInfo2, (i2 & 64) != 0 ? payInfoResponse2.priceInfo : priceInfo2, (i2 & 128) != 0 ? payInfoResponse2.paymentGroups : list, (i2 & 256) != 0 ? payInfoResponse2.extraPayChannels : list2, (i2 & 512) != 0 ? payInfoResponse2.failedType : num, (i2 & 1024) != 0 ? payInfoResponse2.failedTitle : str2, (i2 & 2048) != 0 ? payInfoResponse2.failedReason : str3);
    }

    public final String component1() {
        return this.status;
    }

    public final Integer component10() {
        return this.failedType;
    }

    public final String component11() {
        return this.failedTitle;
    }

    public final String component12() {
        return this.failedReason;
    }

    public final CashierAction component2() {
        return this.initAction;
    }

    public final CashierInfo component3() {
        return this.cashierInfo;
    }

    public final PolicyInfo component4() {
        return this.policyInfo;
    }

    public final OrderInfo component5() {
        return this.orderInfo;
    }

    public final ShowInfo component6() {
        return this.showInfo;
    }

    public final PriceInfo component7() {
        return this.priceInfo;
    }

    public final List<PaymentGroup> component8() {
        return this.paymentGroups;
    }

    public final List<BasicPayment> component9() {
        return this.extraPayChannels;
    }

    public final PayInfoResponse copy(String str, CashierAction cashierAction, CashierInfo cashierInfo2, PolicyInfo policyInfo2, OrderInfo orderInfo2, ShowInfo showInfo2, PriceInfo priceInfo2, List<PaymentGroup> list, List<? extends BasicPayment> list2, Integer num, String str2, String str3) {
        return new PayInfoResponse(str, cashierAction, cashierInfo2, policyInfo2, orderInfo2, showInfo2, priceInfo2, list, list2, num, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PayInfoResponse)) {
            return false;
        }
        PayInfoResponse payInfoResponse = (PayInfoResponse) obj;
        return Intrinsics.areEqual((Object) this.status, (Object) payInfoResponse.status) && Intrinsics.areEqual((Object) this.initAction, (Object) payInfoResponse.initAction) && Intrinsics.areEqual((Object) this.cashierInfo, (Object) payInfoResponse.cashierInfo) && Intrinsics.areEqual((Object) this.policyInfo, (Object) payInfoResponse.policyInfo) && Intrinsics.areEqual((Object) this.orderInfo, (Object) payInfoResponse.orderInfo) && Intrinsics.areEqual((Object) this.showInfo, (Object) payInfoResponse.showInfo) && Intrinsics.areEqual((Object) this.priceInfo, (Object) payInfoResponse.priceInfo) && Intrinsics.areEqual((Object) this.paymentGroups, (Object) payInfoResponse.paymentGroups) && Intrinsics.areEqual((Object) this.extraPayChannels, (Object) payInfoResponse.extraPayChannels) && Intrinsics.areEqual((Object) this.failedType, (Object) payInfoResponse.failedType) && Intrinsics.areEqual((Object) this.failedTitle, (Object) payInfoResponse.failedTitle) && Intrinsics.areEqual((Object) this.failedReason, (Object) payInfoResponse.failedReason);
    }

    public int hashCode() {
        String str = this.status;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        CashierAction cashierAction = this.initAction;
        int hashCode2 = (hashCode + (cashierAction == null ? 0 : cashierAction.hashCode())) * 31;
        CashierInfo cashierInfo2 = this.cashierInfo;
        int hashCode3 = (hashCode2 + (cashierInfo2 == null ? 0 : cashierInfo2.hashCode())) * 31;
        PolicyInfo policyInfo2 = this.policyInfo;
        int hashCode4 = (hashCode3 + (policyInfo2 == null ? 0 : policyInfo2.hashCode())) * 31;
        OrderInfo orderInfo2 = this.orderInfo;
        int hashCode5 = (hashCode4 + (orderInfo2 == null ? 0 : orderInfo2.hashCode())) * 31;
        ShowInfo showInfo2 = this.showInfo;
        int hashCode6 = (hashCode5 + (showInfo2 == null ? 0 : showInfo2.hashCode())) * 31;
        PriceInfo priceInfo2 = this.priceInfo;
        int hashCode7 = (hashCode6 + (priceInfo2 == null ? 0 : priceInfo2.hashCode())) * 31;
        List<PaymentGroup> list = this.paymentGroups;
        int hashCode8 = (hashCode7 + (list == null ? 0 : list.hashCode())) * 31;
        List<? extends BasicPayment> list2 = this.extraPayChannels;
        int hashCode9 = (hashCode8 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Integer num = this.failedType;
        int hashCode10 = (hashCode9 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.failedTitle;
        int hashCode11 = (hashCode10 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.failedReason;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode11 + i;
    }

    public String toString() {
        return "PayInfoResponse(status=" + this.status + ", initAction=" + this.initAction + ", cashierInfo=" + this.cashierInfo + ", policyInfo=" + this.policyInfo + ", orderInfo=" + this.orderInfo + ", showInfo=" + this.showInfo + ", priceInfo=" + this.priceInfo + ", paymentGroups=" + this.paymentGroups + ", extraPayChannels=" + this.extraPayChannels + ", failedType=" + this.failedType + ", failedTitle=" + this.failedTitle + ", failedReason=" + this.failedReason + VersionRange.RIGHT_OPEN;
    }

    public PayInfoResponse(String str, CashierAction cashierAction, CashierInfo cashierInfo2, PolicyInfo policyInfo2, OrderInfo orderInfo2, ShowInfo showInfo2, PriceInfo priceInfo2, List<PaymentGroup> list, List<? extends BasicPayment> list2, Integer num, String str2, String str3) {
        this.status = str;
        this.initAction = cashierAction;
        this.cashierInfo = cashierInfo2;
        this.policyInfo = policyInfo2;
        this.orderInfo = orderInfo2;
        this.showInfo = showInfo2;
        this.priceInfo = priceInfo2;
        this.paymentGroups = list;
        this.extraPayChannels = list2;
        this.failedType = num;
        this.failedTitle = str2;
        this.failedReason = str3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PayInfoResponse(java.lang.String r14, com.didi.global.fintech.cashier.model.net.request.CashierAction r15, com.didi.global.fintech.cashier.model.net.response.CashierInfo r16, com.didi.global.fintech.cashier.model.net.response.PolicyInfo r17, com.didi.global.fintech.cashier.model.net.response.OrderInfo r18, com.didi.global.fintech.cashier.model.net.response.ShowInfo r19, com.didi.global.fintech.cashier.model.net.response.PriceInfo r20, java.util.List r21, java.util.List r22, java.lang.Integer r23, java.lang.String r24, java.lang.String r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r13 = this;
            r0 = r26
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r14
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r15
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0019
        L_0x0017:
            r4 = r16
        L_0x0019:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001f
            r5 = r2
            goto L_0x0021
        L_0x001f:
            r5 = r17
        L_0x0021:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0027
            r6 = r2
            goto L_0x0029
        L_0x0027:
            r6 = r18
        L_0x0029:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002f
            r7 = r2
            goto L_0x0031
        L_0x002f:
            r7 = r19
        L_0x0031:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0037
            r8 = r2
            goto L_0x0039
        L_0x0037:
            r8 = r20
        L_0x0039:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003f
            r9 = r2
            goto L_0x0041
        L_0x003f:
            r9 = r21
        L_0x0041:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0047
            r10 = r2
            goto L_0x0049
        L_0x0047:
            r10 = r22
        L_0x0049:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x004f
            r11 = r2
            goto L_0x0051
        L_0x004f:
            r11 = r23
        L_0x0051:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0057
            r12 = r2
            goto L_0x0059
        L_0x0057:
            r12 = r24
        L_0x0059:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r2 = r25
        L_0x0060:
            r14 = r13
            r15 = r1
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r20 = r7
            r21 = r8
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r12
            r26 = r2
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.model.net.response.PayInfoResponse.<init>(java.lang.String, com.didi.global.fintech.cashier.model.net.request.CashierAction, com.didi.global.fintech.cashier.model.net.response.CashierInfo, com.didi.global.fintech.cashier.model.net.response.PolicyInfo, com.didi.global.fintech.cashier.model.net.response.OrderInfo, com.didi.global.fintech.cashier.model.net.response.ShowInfo, com.didi.global.fintech.cashier.model.net.response.PriceInfo, java.util.List, java.util.List, java.lang.Integer, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final CashierAction getInitAction() {
        return this.initAction;
    }

    public final void setInitAction(CashierAction cashierAction) {
        this.initAction = cashierAction;
    }

    public final CashierInfo getCashierInfo() {
        return this.cashierInfo;
    }

    public final void setCashierInfo(CashierInfo cashierInfo2) {
        this.cashierInfo = cashierInfo2;
    }

    public final PolicyInfo getPolicyInfo() {
        return this.policyInfo;
    }

    public final void setPolicyInfo(PolicyInfo policyInfo2) {
        this.policyInfo = policyInfo2;
    }

    public final OrderInfo getOrderInfo() {
        return this.orderInfo;
    }

    public final void setOrderInfo(OrderInfo orderInfo2) {
        this.orderInfo = orderInfo2;
    }

    public final ShowInfo getShowInfo() {
        return this.showInfo;
    }

    public final void setShowInfo(ShowInfo showInfo2) {
        this.showInfo = showInfo2;
    }

    public final PriceInfo getPriceInfo() {
        return this.priceInfo;
    }

    public final void setPriceInfo(PriceInfo priceInfo2) {
        this.priceInfo = priceInfo2;
    }

    public final List<PaymentGroup> getPaymentGroups() {
        return this.paymentGroups;
    }

    public final void setPaymentGroups(List<PaymentGroup> list) {
        this.paymentGroups = list;
    }

    public final List<BasicPayment> getExtraPayChannels() {
        return this.extraPayChannels;
    }

    public final void setExtraPayChannels(List<? extends BasicPayment> list) {
        this.extraPayChannels = list;
    }

    public final Integer getFailedType() {
        return this.failedType;
    }

    public final void setFailedType(Integer num) {
        this.failedType = num;
    }

    public final String getFailedTitle() {
        return this.failedTitle;
    }

    public final void setFailedTitle(String str) {
        this.failedTitle = str;
    }

    public final String getFailedReason() {
        return this.failedReason;
    }

    public final void setFailedReason(String str) {
        this.failedReason = str;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/PayInfoResponse$Companion;", "", "()V", "FAILED_TYPE_CUSTOM", "", "FAILED_TYPE_UPGRADE", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PayInfoResponse.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final boolean success() {
        return Intrinsics.areEqual((Object) this.status, (Object) "success");
    }

    public final boolean pix() {
        CashierAction cashierAction = this.initAction;
        return cashierAction != null && cashierAction.pix();
    }
}
