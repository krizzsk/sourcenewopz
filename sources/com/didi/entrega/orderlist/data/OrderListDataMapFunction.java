package com.didi.entrega.orderlist.data;

import com.didi.entrega.customer.datasource.listener.DataMapFunction;
import com.didi.entrega.customer.datasource.listener.PayloadProvider;
import com.didi.entrega.customer.datasource.parser.FeedPayload;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderListItemEntity;
import com.didi.entrega.orderlist.binder.OrderListItemModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/entrega/orderlist/data/OrderListDataMapFunction;", "Lcom/didi/entrega/customer/datasource/listener/DataMapFunction;", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderListItemEntity;", "Lcom/didi/entrega/orderlist/binder/OrderListItemModel;", "payloadProvider", "Lcom/didi/entrega/customer/datasource/listener/PayloadProvider;", "Lcom/didi/entrega/customer/datasource/parser/FeedPayload;", "(Lcom/didi/entrega/customer/datasource/listener/PayloadProvider;)V", "getPayloadProvider", "()Lcom/didi/entrega/customer/datasource/listener/PayloadProvider;", "setPayloadProvider", "mapData", "", "key", "", "source", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderListDataMapFunction.kt */
public final class OrderListDataMapFunction implements DataMapFunction<OrderListItemEntity, OrderListItemModel> {

    /* renamed from: a */
    private PayloadProvider<FeedPayload> f20988a;

    public OrderListDataMapFunction(PayloadProvider<FeedPayload> payloadProvider) {
        Intrinsics.checkNotNullParameter(payloadProvider, "payloadProvider");
        this.f20988a = payloadProvider;
    }

    public final PayloadProvider<FeedPayload> getPayloadProvider() {
        return this.f20988a;
    }

    public final void setPayloadProvider(PayloadProvider<FeedPayload> payloadProvider) {
        Intrinsics.checkNotNullParameter(payloadProvider, "<set-?>");
        this.f20988a = payloadProvider;
    }

    public List<OrderListItemModel> mapData(int i, List<OrderListItemEntity> list) {
        Intrinsics.checkNotNullParameter(list, "source");
        ArrayList arrayList = new ArrayList();
        Iterable<OrderListItemEntity> iterable = list;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (OrderListItemEntity orderListItemModel : iterable) {
            arrayList2.add(new OrderListItemModel(orderListItemModel));
        }
        arrayList.addAll((List) arrayList2);
        return arrayList;
    }
}
