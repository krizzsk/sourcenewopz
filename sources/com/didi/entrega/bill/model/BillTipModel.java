package com.didi.entrega.bill.model;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import com.didi.entrega.customer.foundation.rpc.entity.TipFeeInfo;
import com.didi.entrega.customer.foundation.util.CloneUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00002\b\u0010#\u001a\u0004\u0018\u00010$J\u0006\u0010%\u001a\u00020$J\u0006\u0010&\u001a\u00020'R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001e¨\u0006)"}, mo175978d2 = {"Lcom/didi/entrega/bill/model/BillTipModel;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "currency", "", "getCurrency", "()Ljava/lang/String;", "setCurrency", "(Ljava/lang/String;)V", "maxTipFeePrice", "", "getMaxTipFeePrice", "()I", "setMaxTipFeePrice", "(I)V", "maxTipFeeRate", "getMaxTipFeeRate", "setMaxTipFeeRate", "tipFeeConfig", "", "", "getTipFeeConfig", "()Ljava/util/List;", "setTipFeeConfig", "(Ljava/util/List;)V", "tipFeeType", "tipFeeValue", "getTipFeeValue", "()J", "setTipFeeValue", "(J)V", "tipPayValue", "getTipPayValue", "setTipPayValue", "convertModel", "entity", "Lcom/didi/entrega/customer/foundation/rpc/entity/TipFeeInfo;", "convertToEntity", "isPercent", "", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillTipModel.kt */
public final class BillTipModel implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_CONFIG_SIZE = 5;
    public static final String PERCENT_SYMBOL = "%";
    public static final int TIPS_TYPE_PERCENT = 2;
    public static final int TIPS_TYPE_QUOTA = 1;
    private String currency;
    private int maxTipFeePrice = 10000;
    private int maxTipFeeRate = 30;
    private List<Long> tipFeeConfig;
    private int tipFeeType = 1;
    private long tipFeeValue;
    private long tipPayValue;

    public final String getCurrency() {
        return this.currency;
    }

    public final void setCurrency(String str) {
        this.currency = str;
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

    public final List<Long> getTipFeeConfig() {
        return this.tipFeeConfig;
    }

    public final void setTipFeeConfig(List<Long> list) {
        this.tipFeeConfig = list;
    }

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

    public final boolean isPercent() {
        return this.tipFeeType == 2;
    }

    public final BillTipModel convertModel(TipFeeInfo tipFeeInfo) {
        int i;
        long j;
        List<Long> list;
        int i2;
        int i3;
        List<Long> tipFeeConfig2;
        int indexOf;
        BillTipModel billTipModel = new BillTipModel();
        if (tipFeeInfo == null) {
            i = 1;
        } else {
            i = tipFeeInfo.getTipFeeType();
        }
        billTipModel.tipFeeType = i;
        long j2 = 0;
        if (tipFeeInfo == null) {
            j = 0;
        } else {
            j = tipFeeInfo.getTipFeeValue();
        }
        billTipModel.setTipFeeValue(j);
        if (tipFeeInfo != null) {
            j2 = tipFeeInfo.getTipPayValue();
        }
        billTipModel.setTipPayValue(j2);
        if (tipFeeInfo == null) {
            list = null;
        } else {
            list = tipFeeInfo.getTipFeeConfig();
        }
        billTipModel.setTipFeeConfig(list);
        if (tipFeeInfo == null) {
            i2 = 10000;
        } else {
            i2 = tipFeeInfo.getMaxTipFeePrice();
        }
        billTipModel.setMaxTipFeePrice(i2);
        if (tipFeeInfo == null) {
            i3 = 30;
        } else {
            i3 = tipFeeInfo.getMaxTipFeeRate();
        }
        billTipModel.setMaxTipFeeRate(i3);
        if (!(tipFeeInfo == null || (tipFeeConfig2 = tipFeeInfo.getTipFeeConfig()) == null || ((indexOf = tipFeeConfig2.indexOf(Long.valueOf(billTipModel.getTipFeeValue()))) != -1 && indexOf <= 4))) {
            tipFeeConfig2.add(0, Long.valueOf(billTipModel.getTipFeeValue()));
        }
        return billTipModel;
    }

    public final TipFeeInfo convertToEntity() {
        TipFeeInfo tipFeeInfo = new TipFeeInfo();
        tipFeeInfo.setTipFeeType(this.tipFeeType);
        tipFeeInfo.setTipFeeValue(getTipFeeValue());
        tipFeeInfo.setTipPayValue(getTipPayValue());
        tipFeeInfo.setTipFeeConfig(TypeIntrinsics.asMutableList(CloneUtil.deepClone(getTipFeeConfig())));
        tipFeeInfo.setMaxTipFeePrice(getMaxTipFeePrice());
        tipFeeInfo.setMaxTipFeeRate(getMaxTipFeeRate());
        return tipFeeInfo;
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didi/entrega/bill/model/BillTipModel$Companion;", "", "()V", "MAX_CONFIG_SIZE", "", "PERCENT_SYMBOL", "", "TIPS_TYPE_PERCENT", "TIPS_TYPE_QUOTA", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillTipModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
