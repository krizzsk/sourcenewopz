package com.didi.soda.bill.model.datamodel;

import com.didi.soda.bill.model.ComponentAbsModel;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentDataEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.AbnormalItemDetailEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.AbnormalItemInfoEntity;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/soda/bill/model/datamodel/OutOfStockModel;", "Lcom/didi/soda/bill/model/ComponentAbsModel;", "Ljava/io/Serializable;", "()V", "currItem", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/AbnormalItemDetailEntity;", "getCurrItem", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/AbnormalItemDetailEntity;", "setCurrItem", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/AbnormalItemDetailEntity;)V", "options", "", "getOptions", "()Ljava/util/List;", "setOptions", "(Ljava/util/List;)V", "subTitle", "", "getSubTitle", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", "convertModel", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentDataEntity;", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OutOfStockModel.kt */
public final class OutOfStockModel extends ComponentAbsModel implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 2757790891334309205L;
    private AbnormalItemDetailEntity currItem;
    private List<AbnormalItemDetailEntity> options;
    private String subTitle;

    public final List<AbnormalItemDetailEntity> getOptions() {
        return this.options;
    }

    public final void setOptions(List<AbnormalItemDetailEntity> list) {
        this.options = list;
    }

    public final AbnormalItemDetailEntity getCurrItem() {
        return this.currItem;
    }

    public final void setCurrItem(AbnormalItemDetailEntity abnormalItemDetailEntity) {
        this.currItem = abnormalItemDetailEntity;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final void setSubTitle(String str) {
        this.subTitle = str;
    }

    public OutOfStockModel convertModel(BillComponentDataEntity billComponentDataEntity) {
        Intrinsics.checkNotNullParameter(billComponentDataEntity, "entity");
        AbnormalItemInfoEntity abnormalItemInfo = billComponentDataEntity.getAbnormalItemInfo();
        List<AbnormalItemDetailEntity> list = null;
        if (abnormalItemInfo == null) {
            return null;
        }
        setSubTitle(abnormalItemInfo.getSubTitle());
        List<AbnormalItemDetailEntity> options2 = abnormalItemInfo.getOptions();
        if (options2 != null) {
            Iterator<AbnormalItemDetailEntity> it = options2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbnormalItemDetailEntity next = it.next();
                if (next.isSelected() == 1) {
                    setCurrItem(next);
                    break;
                }
            }
            Unit unit = Unit.INSTANCE;
            list = options2;
        }
        setOptions(list);
        return this;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/bill/model/datamodel/OutOfStockModel$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OutOfStockModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
