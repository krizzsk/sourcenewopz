package com.didi.entrega.order.contact;

import com.didi.entrega.customer.foundation.rpc.entity.order.CardData;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderCard;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderData;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderInfoEntity;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderLayout;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderRiderInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/entrega/order/contact/IMContactModel;", "", "()V", "orderId", "", "getOrderId", "()Ljava/lang/String;", "setOrderId", "(Ljava/lang/String;)V", "rideInfo", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderRiderInfo;", "getRideInfo", "()Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderRiderInfo;", "setRideInfo", "(Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderRiderInfo;)V", "status", "", "getStatus", "()I", "setStatus", "(I)V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IMContactModel.kt */
public final class IMContactModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private int f20861a;

    /* renamed from: b */
    private String f20862b = "";

    /* renamed from: c */
    private OrderRiderInfo f20863c;

    public final int getStatus() {
        return this.f20861a;
    }

    public final void setStatus(int i) {
        this.f20861a = i;
    }

    public final String getOrderId() {
        return this.f20862b;
    }

    public final void setOrderId(String str) {
        this.f20862b = str;
    }

    public final OrderRiderInfo getRideInfo() {
        return this.f20863c;
    }

    public final void setRideInfo(OrderRiderInfo orderRiderInfo) {
        this.f20863c = orderRiderInfo;
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/entrega/order/contact/IMContactModel$Companion;", "", "()V", "assemble", "Lcom/didi/entrega/order/contact/IMContactModel;", "entity", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderInfoEntity;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IMContactModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IMContactModel assemble(OrderInfoEntity orderInfoEntity) {
            List<OrderLayout> layouts;
            Object obj;
            CardData data;
            OrderRiderInfo flashRiderInfo;
            String str = null;
            if (!(orderInfoEntity == null || (layouts = orderInfoEntity.getLayouts()) == null)) {
                Collection arrayList = new ArrayList();
                for (OrderLayout cards : layouts) {
                    List<OrderCard> cards2 = cards.getCards();
                    if (cards2 != null) {
                        arrayList.add(cards2);
                    }
                }
                Collection arrayList2 = new ArrayList();
                for (List addAll : (List) arrayList) {
                    CollectionsKt.addAll(arrayList2, addAll);
                }
                Iterator it = ((List) arrayList2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual((Object) ((OrderCard) obj).getTemplate(), (Object) "Tem-FlashRiderInfo")) {
                        break;
                    }
                }
                OrderCard orderCard = (OrderCard) obj;
                if (!(orderCard == null || (data = orderCard.getData()) == null || (flashRiderInfo = data.getFlashRiderInfo()) == null)) {
                    IMContactModel iMContactModel = new IMContactModel();
                    OrderData orderData = orderInfoEntity.getOrderData();
                    iMContactModel.setStatus(orderData == null ? 0 : orderData.getStatus());
                    iMContactModel.setRideInfo(flashRiderInfo);
                    OrderData orderData2 = orderInfoEntity.getOrderData();
                    if (orderData2 != null) {
                        str = orderData2.getOrderId();
                    }
                    iMContactModel.setOrderId(str);
                    return iMContactModel;
                }
            }
            return null;
        }
    }
}
