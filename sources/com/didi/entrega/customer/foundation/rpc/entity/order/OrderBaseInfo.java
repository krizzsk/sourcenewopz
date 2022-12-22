package com.didi.entrega.customer.foundation.rpc.entity.order;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderBaseInfo;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "showList", "", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/ShowList;", "(Ljava/util/List;)V", "getShowList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderInfoEntity.kt */
public final class OrderBaseInfo implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 6552464594876521750L;
    private final List<ShowList> showList;

    public OrderBaseInfo() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OrderBaseInfo copy$default(OrderBaseInfo orderBaseInfo, List<ShowList> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = orderBaseInfo.showList;
        }
        return orderBaseInfo.copy(list);
    }

    public final List<ShowList> component1() {
        return this.showList;
    }

    public final OrderBaseInfo copy(List<ShowList> list) {
        return new OrderBaseInfo(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OrderBaseInfo) && Intrinsics.areEqual((Object) this.showList, (Object) ((OrderBaseInfo) obj).showList);
    }

    public int hashCode() {
        List<ShowList> list = this.showList;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "OrderBaseInfo(showList=" + this.showList + VersionRange.RIGHT_OPEN;
    }

    public OrderBaseInfo(List<ShowList> list) {
        this.showList = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OrderBaseInfo(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public final List<ShowList> getShowList() {
        return this.showList;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderBaseInfo$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderInfoEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
