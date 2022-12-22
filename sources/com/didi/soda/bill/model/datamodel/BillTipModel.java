package com.didi.soda.bill.model.datamodel;

import com.didi.soda.bill.model.ComponentAbsModel;
import com.didi.soda.bill.view.item.tipfee.BillTipsFeeListItemAdapter;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentDataEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity;
import com.didi.soda.customer.foundation.util.CloneUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00018B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010.\u001a\u0004\u0018\u00010\u00002\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u0004\u0018\u00010\u00002\u0006\u0010/\u001a\u000200J\u0006\u00102\u001a\u000203J\u0010\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0000J\u0006\u00107\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR\u001a\u0010&\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*¨\u00069"}, mo175978d2 = {"Lcom/didi/soda/bill/model/datamodel/BillTipModel;", "Lcom/didi/soda/bill/model/ComponentAbsModel;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "mBillTipSWTracked", "", "getMBillTipSWTracked", "()Z", "setMBillTipSWTracked", "(Z)V", "mSelectIndex", "", "getMSelectIndex", "()I", "setMSelectIndex", "(I)V", "mSuggestionEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/TipFeeInfoEntity$TipFeeSuggestionEntity;", "getMSuggestionEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/TipFeeInfoEntity$TipFeeSuggestionEntity;", "setMSuggestionEntity", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/TipFeeInfoEntity$TipFeeSuggestionEntity;)V", "maxTipFeePrice", "getMaxTipFeePrice", "setMaxTipFeePrice", "maxTipFeeRate", "getMaxTipFeeRate", "setMaxTipFeeRate", "tipConfigList", "", "", "getTipConfigList", "()Ljava/util/List;", "setTipConfigList", "(Ljava/util/List;)V", "tipFeeType", "getTipFeeType", "setTipFeeType", "tipFeeValue", "getTipFeeValue", "()J", "setTipFeeValue", "(J)V", "tipPayValue", "getTipPayValue", "setTipPayValue", "convertModel", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentDataEntity;", "convertModelV2", "convertToEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/TipFeeInfoEntity;", "handleCustomerTipsFeeLogic", "", "billTipModel", "isPercent", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillTipModel.kt */
public final class BillTipModel extends ComponentAbsModel implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_CONFIG_SIZE = 5;
    public static final String PERCENT_SYMBOL = "%";
    public static final int TIPS_TYPE_PERCENT = 2;
    public static final int TIPS_TYPE_QUOTA = 1;
    private boolean mBillTipSWTracked;
    private int mSelectIndex;
    private TipFeeInfoEntity.TipFeeSuggestionEntity mSuggestionEntity;
    private int maxTipFeePrice = 10000;
    private int maxTipFeeRate = 30;
    private List<Long> tipConfigList;
    private int tipFeeType = 1;
    private long tipFeeValue;
    private long tipPayValue;

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

    public final List<Long> getTipConfigList() {
        return this.tipConfigList;
    }

    public final void setTipConfigList(List<Long> list) {
        this.tipConfigList = list;
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

    public final int getMSelectIndex() {
        return this.mSelectIndex;
    }

    public final void setMSelectIndex(int i) {
        this.mSelectIndex = i;
    }

    public final boolean getMBillTipSWTracked() {
        return this.mBillTipSWTracked;
    }

    public final void setMBillTipSWTracked(boolean z) {
        this.mBillTipSWTracked = z;
    }

    public final TipFeeInfoEntity.TipFeeSuggestionEntity getMSuggestionEntity() {
        return this.mSuggestionEntity;
    }

    public final void setMSuggestionEntity(TipFeeInfoEntity.TipFeeSuggestionEntity tipFeeSuggestionEntity) {
        this.mSuggestionEntity = tipFeeSuggestionEntity;
    }

    public final boolean isPercent() {
        return this.tipFeeType == 2;
    }

    public BillTipModel convertModel(BillComponentDataEntity billComponentDataEntity) {
        List<Long> list;
        int indexOf;
        Intrinsics.checkNotNullParameter(billComponentDataEntity, "entity");
        BillTipModel billTipModel = new BillTipModel();
        TipFeeInfoEntity tipFeeInfo = billComponentDataEntity.getTipFeeInfo();
        billTipModel.setTipFeeType(tipFeeInfo == null ? 1 : tipFeeInfo.tipFeeType);
        TipFeeInfoEntity tipFeeInfo2 = billComponentDataEntity.getTipFeeInfo();
        long j = 0;
        billTipModel.setTipFeeValue(tipFeeInfo2 == null ? 0 : tipFeeInfo2.tipFeeValue);
        TipFeeInfoEntity tipFeeInfo3 = billComponentDataEntity.getTipFeeInfo();
        if (tipFeeInfo3 != null) {
            j = tipFeeInfo3.tipPayValue;
        }
        billTipModel.setTipPayValue(j);
        TipFeeInfoEntity tipFeeInfo4 = billComponentDataEntity.getTipFeeInfo();
        billTipModel.setTipConfigList(tipFeeInfo4 == null ? null : tipFeeInfo4.tipFeeConfig);
        TipFeeInfoEntity tipFeeInfo5 = billComponentDataEntity.getTipFeeInfo();
        billTipModel.setMaxTipFeePrice(tipFeeInfo5 == null ? 10000 : tipFeeInfo5.maxTipFeePrice);
        TipFeeInfoEntity tipFeeInfo6 = billComponentDataEntity.getTipFeeInfo();
        billTipModel.setMaxTipFeeRate(tipFeeInfo6 == null ? 30 : tipFeeInfo6.maxTipFeeRate);
        TipFeeInfoEntity tipFeeInfo7 = billComponentDataEntity.getTipFeeInfo();
        if (!(tipFeeInfo7 == null || (list = tipFeeInfo7.tipFeeConfig) == null || ((indexOf = list.indexOf(Long.valueOf(billTipModel.getTipFeeValue()))) != -1 && indexOf <= 4))) {
            list.add(0, Long.valueOf(billTipModel.getTipFeeValue()));
        }
        return billTipModel;
    }

    public final BillTipModel convertModelV2(BillComponentDataEntity billComponentDataEntity) {
        Intrinsics.checkNotNullParameter(billComponentDataEntity, "entity");
        BillTipModel billTipModel = new BillTipModel();
        TipFeeInfoEntity tipFeeInfo = billComponentDataEntity.getTipFeeInfo();
        billTipModel.setTipFeeType(tipFeeInfo == null ? 1 : tipFeeInfo.tipFeeType);
        TipFeeInfoEntity tipFeeInfo2 = billComponentDataEntity.getTipFeeInfo();
        long j = 0;
        billTipModel.setTipFeeValue(tipFeeInfo2 == null ? 0 : tipFeeInfo2.tipFeeValue);
        TipFeeInfoEntity tipFeeInfo3 = billComponentDataEntity.getTipFeeInfo();
        if (tipFeeInfo3 != null) {
            j = tipFeeInfo3.tipPayValue;
        }
        billTipModel.setTipPayValue(j);
        TipFeeInfoEntity tipFeeInfo4 = billComponentDataEntity.getTipFeeInfo();
        TipFeeInfoEntity.TipFeeSuggestionEntity tipFeeSuggestionEntity = null;
        billTipModel.setTipConfigList(tipFeeInfo4 == null ? null : tipFeeInfo4.tipFeeConfig);
        TipFeeInfoEntity tipFeeInfo5 = billComponentDataEntity.getTipFeeInfo();
        billTipModel.setMaxTipFeePrice(tipFeeInfo5 == null ? 10000 : tipFeeInfo5.maxTipFeePrice);
        TipFeeInfoEntity tipFeeInfo6 = billComponentDataEntity.getTipFeeInfo();
        billTipModel.setMaxTipFeeRate(tipFeeInfo6 == null ? 30 : tipFeeInfo6.maxTipFeeRate);
        billTipModel.handleCustomerTipsFeeLogic(billTipModel);
        TipFeeInfoEntity tipFeeInfo7 = billComponentDataEntity.getTipFeeInfo();
        if (tipFeeInfo7 != null) {
            tipFeeSuggestionEntity = tipFeeInfo7.suggestion;
        }
        billTipModel.setMSuggestionEntity(tipFeeSuggestionEntity);
        return billTipModel;
    }

    public final void handleCustomerTipsFeeLogic(BillTipModel billTipModel) {
        List<Long> list;
        Long l;
        if (billTipModel != null && (list = billTipModel.tipConfigList) != null) {
            Long l2 = null;
            if (billTipModel == null) {
                l = null;
            } else {
                l = Long.valueOf(billTipModel.getTipFeeValue());
            }
            if (list.indexOf(l) < 0) {
                boolean z = false;
                if (billTipModel != null && billTipModel.getTipFeeValue() == 0) {
                    z = true;
                }
                if (z) {
                    Long l3 = BillTipsFeeListItemAdapter.FLAG_OF_OTHER_ITEM_VALUE;
                    Intrinsics.checkNotNullExpressionValue(l3, "FLAG_OF_OTHER_ITEM_VALUE");
                    list.add(l3);
                    return;
                }
                if (billTipModel != null) {
                    l2 = Long.valueOf(billTipModel.getTipFeeValue());
                }
                list.add(l2);
                return;
            }
            Long l4 = BillTipsFeeListItemAdapter.FLAG_OF_OTHER_ITEM_VALUE;
            Intrinsics.checkNotNullExpressionValue(l4, "FLAG_OF_OTHER_ITEM_VALUE");
            list.add(l4);
        }
    }

    public final TipFeeInfoEntity convertToEntity() {
        TipFeeInfoEntity tipFeeInfoEntity = new TipFeeInfoEntity();
        tipFeeInfoEntity.tipFeeType = getTipFeeType();
        tipFeeInfoEntity.tipFeeValue = getTipFeeValue();
        tipFeeInfoEntity.tipPayValue = getTipPayValue();
        tipFeeInfoEntity.tipFeeConfig = TypeIntrinsics.asMutableList(CloneUtil.deepClone(getTipConfigList()));
        tipFeeInfoEntity.maxTipFeePrice = getMaxTipFeePrice();
        tipFeeInfoEntity.maxTipFeeRate = getMaxTipFeeRate();
        return tipFeeInfoEntity;
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/bill/model/datamodel/BillTipModel$Companion;", "", "()V", "MAX_CONFIG_SIZE", "", "PERCENT_SYMBOL", "", "TIPS_TYPE_PERCENT", "TIPS_TYPE_QUOTA", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillTipModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
