package com.didi.entrega.customer.foundation.rpc.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u0011\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001a\u0010\u0016\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/TipFeeInfo;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "maxTipFeePrice", "", "getMaxTipFeePrice", "()I", "setMaxTipFeePrice", "(I)V", "maxTipFeeRate", "getMaxTipFeeRate", "setMaxTipFeeRate", "tipFeeConfig", "", "", "getTipFeeConfig", "()Ljava/util/List;", "setTipFeeConfig", "(Ljava/util/List;)V", "tipFeeType", "getTipFeeType", "setTipFeeType", "tipFeeValue", "getTipFeeValue", "()J", "setTipFeeValue", "(J)V", "tipPayValue", "getTipPayValue", "setTipPayValue", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillEntity.kt */
public final class TipFeeInfo implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -1129740175797179735L;
    private int maxTipFeePrice;
    private int maxTipFeeRate;
    private List<Long> tipFeeConfig;
    private int tipFeeType;
    private long tipFeeValue;
    private long tipPayValue;

    public final int getMaxTipFeePrice() {
        return this.maxTipFeePrice;
    }

    public final void setMaxTipFeePrice(int i) {
        this.maxTipFeePrice = i;
    }

    public final int getMaxTipFeeRate() {
        return this.maxTipFeeRate;
    }

    public final void setMaxTipFeeRate(int i) {
        this.maxTipFeeRate = i;
    }

    public final List<Long> getTipFeeConfig() {
        return this.tipFeeConfig;
    }

    public final void setTipFeeConfig(List<Long> list) {
        this.tipFeeConfig = list;
    }

    public final int getTipFeeType() {
        return this.tipFeeType;
    }

    public final void setTipFeeType(int i) {
        this.tipFeeType = i;
    }

    public final long getTipFeeValue() {
        return this.tipFeeValue;
    }

    public final void setTipFeeValue(long j) {
        this.tipFeeValue = j;
    }

    public final long getTipPayValue() {
        return this.tipPayValue;
    }

    public final void setTipPayValue(long j) {
        this.tipPayValue = j;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/TipFeeInfo$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
