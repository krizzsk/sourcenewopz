package com.didi.entrega.customer.foundation.rpc.entity.order;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderDeliveryInfo;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "title", "", "senderAddress", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/AddressInfo;", "receiverAddress", "showList", "", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/ShowList;", "(Ljava/lang/String;Lcom/didi/entrega/customer/foundation/rpc/entity/order/AddressInfo;Lcom/didi/entrega/customer/foundation/rpc/entity/order/AddressInfo;Ljava/util/List;)V", "getReceiverAddress", "()Lcom/didi/entrega/customer/foundation/rpc/entity/order/AddressInfo;", "getSenderAddress", "getShowList", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderInfoEntity.kt */
public final class OrderDeliveryInfo implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -5571523440375728147L;
    private final AddressInfo receiverAddress;
    private final AddressInfo senderAddress;
    private final List<ShowList> showList;
    private final String title;

    public OrderDeliveryInfo() {
        this((String) null, (AddressInfo) null, (AddressInfo) null, (List) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OrderDeliveryInfo copy$default(OrderDeliveryInfo orderDeliveryInfo, String str, AddressInfo addressInfo, AddressInfo addressInfo2, List<ShowList> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = orderDeliveryInfo.title;
        }
        if ((i & 2) != 0) {
            addressInfo = orderDeliveryInfo.senderAddress;
        }
        if ((i & 4) != 0) {
            addressInfo2 = orderDeliveryInfo.receiverAddress;
        }
        if ((i & 8) != 0) {
            list = orderDeliveryInfo.showList;
        }
        return orderDeliveryInfo.copy(str, addressInfo, addressInfo2, list);
    }

    public final String component1() {
        return this.title;
    }

    public final AddressInfo component2() {
        return this.senderAddress;
    }

    public final AddressInfo component3() {
        return this.receiverAddress;
    }

    public final List<ShowList> component4() {
        return this.showList;
    }

    public final OrderDeliveryInfo copy(String str, AddressInfo addressInfo, AddressInfo addressInfo2, List<ShowList> list) {
        return new OrderDeliveryInfo(str, addressInfo, addressInfo2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderDeliveryInfo)) {
            return false;
        }
        OrderDeliveryInfo orderDeliveryInfo = (OrderDeliveryInfo) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) orderDeliveryInfo.title) && Intrinsics.areEqual((Object) this.senderAddress, (Object) orderDeliveryInfo.senderAddress) && Intrinsics.areEqual((Object) this.receiverAddress, (Object) orderDeliveryInfo.receiverAddress) && Intrinsics.areEqual((Object) this.showList, (Object) orderDeliveryInfo.showList);
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        AddressInfo addressInfo = this.senderAddress;
        int hashCode2 = (hashCode + (addressInfo == null ? 0 : addressInfo.hashCode())) * 31;
        AddressInfo addressInfo2 = this.receiverAddress;
        int hashCode3 = (hashCode2 + (addressInfo2 == null ? 0 : addressInfo2.hashCode())) * 31;
        List<ShowList> list = this.showList;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "OrderDeliveryInfo(title=" + this.title + ", senderAddress=" + this.senderAddress + ", receiverAddress=" + this.receiverAddress + ", showList=" + this.showList + VersionRange.RIGHT_OPEN;
    }

    public OrderDeliveryInfo(String str, AddressInfo addressInfo, AddressInfo addressInfo2, List<ShowList> list) {
        this.title = str;
        this.senderAddress = addressInfo;
        this.receiverAddress = addressInfo2;
        this.showList = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OrderDeliveryInfo(String str, AddressInfo addressInfo, AddressInfo addressInfo2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : addressInfo, (i & 4) != 0 ? null : addressInfo2, (i & 8) != 0 ? null : list);
    }

    public final String getTitle() {
        return this.title;
    }

    public final AddressInfo getSenderAddress() {
        return this.senderAddress;
    }

    public final AddressInfo getReceiverAddress() {
        return this.receiverAddress;
    }

    public final List<ShowList> getShowList() {
        return this.showList;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderDeliveryInfo$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderInfoEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
