package com.didi.soda.bill.model;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.PayMethodListInfoEntity;
import com.didi.soda.customer.foundation.util.StringUtils;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\r¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/soda/bill/model/PayMethodCardTraceModel;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "cardModel", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/PayMethodListInfoEntity$PayMethodInfo$CardInfo;", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/PayMethodListInfoEntity$PayMethodInfo$CardInfo;)V", "payMethodInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/PayMethodListInfoEntity$PayMethodInfo;", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/PayMethodListInfoEntity$PayMethodInfo;)V", "cardSuffix", "", "getCardSuffix", "()Ljava/lang/String;", "setCardSuffix", "(Ljava/lang/String;)V", "hasPayDiscount", "", "getHasPayDiscount", "()I", "setHasPayDiscount", "(I)V", "payMethod", "getPayMethod", "setPayMethod", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayMethodCardTraceModel.kt */
public final class PayMethodCardTraceModel implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 5080438906972406186L;
    @SerializedName("card_last_digit")
    private String cardSuffix;
    @SerializedName("has_pay_discount")
    private int hasPayDiscount;
    @SerializedName("pay_method")
    private String payMethod;

    public final String getPayMethod() {
        return this.payMethod;
    }

    public final void setPayMethod(String str) {
        this.payMethod = str;
    }

    public final String getCardSuffix() {
        return this.cardSuffix;
    }

    public final void setCardSuffix(String str) {
        this.cardSuffix = str;
    }

    public final int getHasPayDiscount() {
        return this.hasPayDiscount;
    }

    public final void setHasPayDiscount(int i) {
        this.hasPayDiscount = i;
    }

    public PayMethodCardTraceModel(PayMethodListInfoEntity.PayMethodInfo.CardInfo cardInfo) {
        Intrinsics.checkNotNullParameter(cardInfo, "cardModel");
        this.payMethod = "150";
        this.cardSuffix = cardInfo.cardSuffix;
        this.hasPayDiscount = StringUtils.isEmpty(cardInfo.tip) ^ true ? 1 : 0;
    }

    public PayMethodCardTraceModel(PayMethodListInfoEntity.PayMethodInfo payMethodInfo) {
        Intrinsics.checkNotNullParameter(payMethodInfo, "payMethodInfo");
        String str = payMethodInfo.channelId;
        this.payMethod = str == null ? "" : str;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/bill/model/PayMethodCardTraceModel$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PayMethodCardTraceModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
