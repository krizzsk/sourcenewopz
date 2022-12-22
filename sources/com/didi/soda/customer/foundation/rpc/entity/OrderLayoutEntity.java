package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderLayoutEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "layouts", "", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderLayout;", "orderData", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderData;", "(Ljava/util/List;Lcom/didi/soda/customer/foundation/rpc/entity/OrderData;)V", "getLayouts", "()Ljava/util/List;", "getOrderData", "()Lcom/didi/soda/customer/foundation/rpc/entity/OrderData;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderLayoutEntity.kt */
public final class OrderLayoutEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 3971537513907690601L;
    private final List<OrderLayout> layouts;
    private final OrderData orderData;

    public OrderLayoutEntity() {
        this((List) null, (OrderData) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OrderLayoutEntity copy$default(OrderLayoutEntity orderLayoutEntity, List<OrderLayout> list, OrderData orderData2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = orderLayoutEntity.layouts;
        }
        if ((i & 2) != 0) {
            orderData2 = orderLayoutEntity.orderData;
        }
        return orderLayoutEntity.copy(list, orderData2);
    }

    public final List<OrderLayout> component1() {
        return this.layouts;
    }

    public final OrderData component2() {
        return this.orderData;
    }

    public final OrderLayoutEntity copy(List<OrderLayout> list, OrderData orderData2) {
        return new OrderLayoutEntity(list, orderData2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderLayoutEntity)) {
            return false;
        }
        OrderLayoutEntity orderLayoutEntity = (OrderLayoutEntity) obj;
        return Intrinsics.areEqual((Object) this.layouts, (Object) orderLayoutEntity.layouts) && Intrinsics.areEqual((Object) this.orderData, (Object) orderLayoutEntity.orderData);
    }

    public int hashCode() {
        List<OrderLayout> list = this.layouts;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        OrderData orderData2 = this.orderData;
        if (orderData2 != null) {
            i = orderData2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "OrderLayoutEntity(layouts=" + this.layouts + ", orderData=" + this.orderData + VersionRange.RIGHT_OPEN;
    }

    public OrderLayoutEntity(List<OrderLayout> list, OrderData orderData2) {
        this.layouts = list;
        this.orderData = orderData2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OrderLayoutEntity(List list, OrderData orderData2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : orderData2);
    }

    public final List<OrderLayout> getLayouts() {
        return this.layouts;
    }

    public final OrderData getOrderData() {
        return this.orderData;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderLayoutEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderLayoutEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
