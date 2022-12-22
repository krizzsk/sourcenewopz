package com.didi.entrega.customer.foundation.rpc.entity.order;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderListItemEntity;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "buttons", "", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/ButtonEntity;", "getButtons", "()Ljava/util/List;", "setButtons", "(Ljava/util/List;)V", "orderInfo", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/HistoryOrderInfoEntity;", "getOrderInfo", "()Lcom/didi/entrega/customer/foundation/rpc/entity/order/HistoryOrderInfoEntity;", "setOrderInfo", "(Lcom/didi/entrega/customer/foundation/rpc/entity/order/HistoryOrderInfoEntity;)V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HistoryOrderListEntity.kt */
public final class OrderListItemEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 6060087576082004355L;
    private List<ButtonEntity> buttons;
    private HistoryOrderInfoEntity orderInfo;

    public final List<ButtonEntity> getButtons() {
        return this.buttons;
    }

    public final void setButtons(List<ButtonEntity> list) {
        this.buttons = list;
    }

    public final HistoryOrderInfoEntity getOrderInfo() {
        return this.orderInfo;
    }

    public final void setOrderInfo(HistoryOrderInfoEntity historyOrderInfoEntity) {
        this.orderInfo = historyOrderInfoEntity;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderListItemEntity$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HistoryOrderListEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
