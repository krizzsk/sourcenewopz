package com.didi.soda.bill.model.datamodel;

import com.didi.soda.bill.model.ComponentAbsModel;
import com.didi.soda.customer.foundation.rpc.entity.address.DeliveryMethodEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentDataEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/soda/bill/model/datamodel/DeliveryModel;", "Lcom/didi/soda/bill/model/ComponentAbsModel;", "Ljava/io/Serializable;", "()V", "deliveryRulesModel", "Lcom/didi/soda/bill/model/datamodel/DeliveryRulesModel;", "getDeliveryRulesModel", "()Lcom/didi/soda/bill/model/datamodel/DeliveryRulesModel;", "setDeliveryRulesModel", "(Lcom/didi/soda/bill/model/datamodel/DeliveryRulesModel;)V", "methods", "", "Lcom/didi/soda/customer/foundation/rpc/entity/address/DeliveryMethodEntity;", "getMethods", "()Ljava/util/List;", "setMethods", "(Ljava/util/List;)V", "selectType", "", "getSelectType", "()I", "setSelectType", "(I)V", "convertModel", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentDataEntity;", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DeliveryModel.kt */
public final class DeliveryModel extends ComponentAbsModel implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 5557416769039335303L;
    private DeliveryRulesModel deliveryRulesModel;
    private List<? extends DeliveryMethodEntity> methods;
    private int selectType;

    public final List<DeliveryMethodEntity> getMethods() {
        return this.methods;
    }

    public final void setMethods(List<? extends DeliveryMethodEntity> list) {
        this.methods = list;
    }

    public final int getSelectType() {
        return this.selectType;
    }

    public final void setSelectType(int i) {
        this.selectType = i;
    }

    public final DeliveryRulesModel getDeliveryRulesModel() {
        return this.deliveryRulesModel;
    }

    public final void setDeliveryRulesModel(DeliveryRulesModel deliveryRulesModel2) {
        this.deliveryRulesModel = deliveryRulesModel2;
    }

    public DeliveryModel convertModel(BillComponentDataEntity billComponentDataEntity) {
        Intrinsics.checkNotNullParameter(billComponentDataEntity, "entity");
        ArrayList<DeliveryMethodEntity> deliveryMethods = billComponentDataEntity.getDeliveryMethods();
        if (deliveryMethods == null) {
            deliveryMethods = null;
        } else {
            Iterator<DeliveryMethodEntity> it = deliveryMethods.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DeliveryMethodEntity next = it.next();
                if (next.isSelected == 1) {
                    setSelectType(next.type);
                    break;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        this.methods = deliveryMethods;
        this.deliveryRulesModel = new DeliveryRulesModel().convertModel(billComponentDataEntity);
        return this;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/bill/model/datamodel/DeliveryModel$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: DeliveryModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
