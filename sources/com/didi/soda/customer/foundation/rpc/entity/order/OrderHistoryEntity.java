package com.didi.soda.customer.foundation.rpc.entity.order;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderHistoryEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "haveNext", "", "getHaveNext", "()I", "setHaveNext", "(I)V", "orderList", "", "Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderHistoryItemEntity;", "getOrderList", "()Ljava/util/List;", "setOrderList", "(Ljava/util/List;)V", "unEvaluatedPopUp", "Lcom/didi/soda/customer/foundation/rpc/entity/order/UnevaluatedPopupEntity;", "getUnEvaluatedPopUp", "()Lcom/didi/soda/customer/foundation/rpc/entity/order/UnevaluatedPopupEntity;", "setUnEvaluatedPopUp", "(Lcom/didi/soda/customer/foundation/rpc/entity/order/UnevaluatedPopupEntity;)V", "unfinished", "getUnfinished", "setUnfinished", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderHistoryEntity.kt */
public final class OrderHistoryEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 1050843316224584221L;
    private int haveNext;
    private List<OrderHistoryItemEntity> orderList;
    private UnevaluatedPopupEntity unEvaluatedPopUp;
    private int unfinished;

    public final int getHaveNext() {
        return this.haveNext;
    }

    public final void setHaveNext(int i) {
        this.haveNext = i;
    }

    public final int getUnfinished() {
        return this.unfinished;
    }

    public final void setUnfinished(int i) {
        this.unfinished = i;
    }

    public final List<OrderHistoryItemEntity> getOrderList() {
        return this.orderList;
    }

    public final void setOrderList(List<OrderHistoryItemEntity> list) {
        this.orderList = list;
    }

    public final UnevaluatedPopupEntity getUnEvaluatedPopUp() {
        return this.unEvaluatedPopUp;
    }

    public final void setUnEvaluatedPopUp(UnevaluatedPopupEntity unevaluatedPopupEntity) {
        this.unEvaluatedPopUp = unevaluatedPopupEntity;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/order/OrderHistoryEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderHistoryEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
