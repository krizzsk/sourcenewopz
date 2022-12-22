package com.didi.entrega.customer.foundation.rpc.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003JI\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/PriceInfo;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "oriPrice", "", "oriPriceDisplay", "", "highLight", "payPrice", "payPriceDisplay", "ruleDesc", "Lcom/didi/entrega/customer/foundation/rpc/entity/RuleDesc;", "(ILjava/lang/String;IILjava/lang/String;Lcom/didi/entrega/customer/foundation/rpc/entity/RuleDesc;)V", "getHighLight", "()I", "getOriPrice", "setOriPrice", "(I)V", "getOriPriceDisplay", "()Ljava/lang/String;", "setOriPriceDisplay", "(Ljava/lang/String;)V", "getPayPrice", "getPayPriceDisplay", "getRuleDesc", "()Lcom/didi/entrega/customer/foundation/rpc/entity/RuleDesc;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillEntity.kt */
public final class PriceInfo implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -4407411452650366394L;
    private final int highLight;
    private int oriPrice;
    private String oriPriceDisplay;
    private final int payPrice;
    private final String payPriceDisplay;
    private final RuleDesc ruleDesc;

    public static /* synthetic */ PriceInfo copy$default(PriceInfo priceInfo, int i, String str, int i2, int i3, String str2, RuleDesc ruleDesc2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = priceInfo.oriPrice;
        }
        if ((i4 & 2) != 0) {
            str = priceInfo.oriPriceDisplay;
        }
        String str3 = str;
        if ((i4 & 4) != 0) {
            i2 = priceInfo.highLight;
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            i3 = priceInfo.payPrice;
        }
        int i6 = i3;
        if ((i4 & 16) != 0) {
            str2 = priceInfo.payPriceDisplay;
        }
        String str4 = str2;
        if ((i4 & 32) != 0) {
            ruleDesc2 = priceInfo.ruleDesc;
        }
        return priceInfo.copy(i, str3, i5, i6, str4, ruleDesc2);
    }

    public final int component1() {
        return this.oriPrice;
    }

    public final String component2() {
        return this.oriPriceDisplay;
    }

    public final int component3() {
        return this.highLight;
    }

    public final int component4() {
        return this.payPrice;
    }

    public final String component5() {
        return this.payPriceDisplay;
    }

    public final RuleDesc component6() {
        return this.ruleDesc;
    }

    public final PriceInfo copy(int i, String str, int i2, int i3, String str2, RuleDesc ruleDesc2) {
        Intrinsics.checkNotNullParameter(str2, "payPriceDisplay");
        return new PriceInfo(i, str, i2, i3, str2, ruleDesc2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PriceInfo)) {
            return false;
        }
        PriceInfo priceInfo = (PriceInfo) obj;
        return this.oriPrice == priceInfo.oriPrice && Intrinsics.areEqual((Object) this.oriPriceDisplay, (Object) priceInfo.oriPriceDisplay) && this.highLight == priceInfo.highLight && this.payPrice == priceInfo.payPrice && Intrinsics.areEqual((Object) this.payPriceDisplay, (Object) priceInfo.payPriceDisplay) && Intrinsics.areEqual((Object) this.ruleDesc, (Object) priceInfo.ruleDesc);
    }

    public int hashCode() {
        int i = this.oriPrice * 31;
        String str = this.oriPriceDisplay;
        int i2 = 0;
        int hashCode = (((((((i + (str == null ? 0 : str.hashCode())) * 31) + this.highLight) * 31) + this.payPrice) * 31) + this.payPriceDisplay.hashCode()) * 31;
        RuleDesc ruleDesc2 = this.ruleDesc;
        if (ruleDesc2 != null) {
            i2 = ruleDesc2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "PriceInfo(oriPrice=" + this.oriPrice + ", oriPriceDisplay=" + this.oriPriceDisplay + ", highLight=" + this.highLight + ", payPrice=" + this.payPrice + ", payPriceDisplay=" + this.payPriceDisplay + ", ruleDesc=" + this.ruleDesc + VersionRange.RIGHT_OPEN;
    }

    public PriceInfo(int i, String str, int i2, int i3, String str2, RuleDesc ruleDesc2) {
        Intrinsics.checkNotNullParameter(str2, "payPriceDisplay");
        this.oriPrice = i;
        this.oriPriceDisplay = str;
        this.highLight = i2;
        this.payPrice = i3;
        this.payPriceDisplay = str2;
        this.ruleDesc = ruleDesc2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PriceInfo(int i, String str, int i2, int i3, String str2, RuleDesc ruleDesc2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i4 & 2) != 0 ? null : str, i2, i3, str2, (i4 & 32) != 0 ? null : ruleDesc2);
    }

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

    public final int getHighLight() {
        return this.highLight;
    }

    public final int getPayPrice() {
        return this.payPrice;
    }

    public final String getPayPriceDisplay() {
        return this.payPriceDisplay;
    }

    public final RuleDesc getRuleDesc() {
        return this.ruleDesc;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/PriceInfo$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
