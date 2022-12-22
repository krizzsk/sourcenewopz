package com.didi.soda.customer.foundation.rpc.entity.bill;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/bill/PriceInfo;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "highLight", "", "getHighLight", "()I", "setHighLight", "(I)V", "oriPrice", "getOriPrice", "setOriPrice", "oriPriceDisplay", "", "getOriPriceDisplay", "()Ljava/lang/String;", "setOriPriceDisplay", "(Ljava/lang/String;)V", "payPrice", "getPayPrice", "setPayPrice", "payPriceDisplay", "getPayPriceDisplay", "setPayPriceDisplay", "ruleDesc", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/RuleDescEntity;", "getRuleDesc", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/RuleDescEntity;", "setRuleDesc", "(Lcom/didi/soda/customer/foundation/rpc/entity/bill/RuleDescEntity;)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PriceInfo.kt */
public final class PriceInfo implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 6884864473584381933L;
    private int highLight;
    private int oriPrice;
    private String oriPriceDisplay;
    private int payPrice;
    private String payPriceDisplay;
    private RuleDescEntity ruleDesc;

    public final int getOriPrice() {
        return this.oriPrice;
    }

    public final void setOriPrice(int i) {
        this.oriPrice = i;
    }

    public final String getOriPriceDisplay() {
        return this.oriPriceDisplay;
    }

    public final void setOriPriceDisplay(String str) {
        this.oriPriceDisplay = str;
    }

    public final int getPayPrice() {
        return this.payPrice;
    }

    public final void setPayPrice(int i) {
        this.payPrice = i;
    }

    public final String getPayPriceDisplay() {
        return this.payPriceDisplay;
    }

    public final void setPayPriceDisplay(String str) {
        this.payPriceDisplay = str;
    }

    public final int getHighLight() {
        return this.highLight;
    }

    public final void setHighLight(int i) {
        this.highLight = i;
    }

    public final RuleDescEntity getRuleDesc() {
        return this.ruleDesc;
    }

    public final void setRuleDesc(RuleDescEntity ruleDescEntity) {
        this.ruleDesc = ruleDescEntity;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/bill/PriceInfo$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PriceInfo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
