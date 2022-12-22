package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001#BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003JQ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006$"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderItem;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "shopInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/ShopInfo;", "items", "", "Lcom/didi/soda/customer/foundation/rpc/entity/DishItem;", "showList", "Lcom/didi/soda/customer/foundation/rpc/entity/ShowList;", "receiptBtn", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderBtns;", "onceAgainOrderBtn", "(Lcom/didi/soda/customer/foundation/rpc/entity/ShopInfo;Ljava/util/List;Ljava/util/List;Lcom/didi/soda/customer/foundation/rpc/entity/OrderBtns;Lcom/didi/soda/customer/foundation/rpc/entity/OrderBtns;)V", "getItems", "()Ljava/util/List;", "getOnceAgainOrderBtn", "()Lcom/didi/soda/customer/foundation/rpc/entity/OrderBtns;", "getReceiptBtn", "getShopInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/ShopInfo;", "getShowList", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderLayoutEntity.kt */
public final class OrderItem implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -7369549445956730651L;
    private final List<DishItem> items;
    private final OrderBtns onceAgainOrderBtn;
    private final OrderBtns receiptBtn;
    private final ShopInfo shopInfo;
    private final List<ShowList> showList;

    public OrderItem() {
        this((ShopInfo) null, (List) null, (List) null, (OrderBtns) null, (OrderBtns) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OrderItem copy$default(OrderItem orderItem, ShopInfo shopInfo2, List<DishItem> list, List<ShowList> list2, OrderBtns orderBtns, OrderBtns orderBtns2, int i, Object obj) {
        if ((i & 1) != 0) {
            shopInfo2 = orderItem.shopInfo;
        }
        if ((i & 2) != 0) {
            list = orderItem.items;
        }
        List<DishItem> list3 = list;
        if ((i & 4) != 0) {
            list2 = orderItem.showList;
        }
        List<ShowList> list4 = list2;
        if ((i & 8) != 0) {
            orderBtns = orderItem.receiptBtn;
        }
        OrderBtns orderBtns3 = orderBtns;
        if ((i & 16) != 0) {
            orderBtns2 = orderItem.onceAgainOrderBtn;
        }
        return orderItem.copy(shopInfo2, list3, list4, orderBtns3, orderBtns2);
    }

    public final ShopInfo component1() {
        return this.shopInfo;
    }

    public final List<DishItem> component2() {
        return this.items;
    }

    public final List<ShowList> component3() {
        return this.showList;
    }

    public final OrderBtns component4() {
        return this.receiptBtn;
    }

    public final OrderBtns component5() {
        return this.onceAgainOrderBtn;
    }

    public final OrderItem copy(ShopInfo shopInfo2, List<DishItem> list, List<ShowList> list2, OrderBtns orderBtns, OrderBtns orderBtns2) {
        return new OrderItem(shopInfo2, list, list2, orderBtns, orderBtns2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderItem)) {
            return false;
        }
        OrderItem orderItem = (OrderItem) obj;
        return Intrinsics.areEqual((Object) this.shopInfo, (Object) orderItem.shopInfo) && Intrinsics.areEqual((Object) this.items, (Object) orderItem.items) && Intrinsics.areEqual((Object) this.showList, (Object) orderItem.showList) && Intrinsics.areEqual((Object) this.receiptBtn, (Object) orderItem.receiptBtn) && Intrinsics.areEqual((Object) this.onceAgainOrderBtn, (Object) orderItem.onceAgainOrderBtn);
    }

    public int hashCode() {
        ShopInfo shopInfo2 = this.shopInfo;
        int i = 0;
        int hashCode = (shopInfo2 == null ? 0 : shopInfo2.hashCode()) * 31;
        List<DishItem> list = this.items;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<ShowList> list2 = this.showList;
        int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        OrderBtns orderBtns = this.receiptBtn;
        int hashCode4 = (hashCode3 + (orderBtns == null ? 0 : orderBtns.hashCode())) * 31;
        OrderBtns orderBtns2 = this.onceAgainOrderBtn;
        if (orderBtns2 != null) {
            i = orderBtns2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "OrderItem(shopInfo=" + this.shopInfo + ", items=" + this.items + ", showList=" + this.showList + ", receiptBtn=" + this.receiptBtn + ", onceAgainOrderBtn=" + this.onceAgainOrderBtn + VersionRange.RIGHT_OPEN;
    }

    public OrderItem(ShopInfo shopInfo2, List<DishItem> list, List<ShowList> list2, OrderBtns orderBtns, OrderBtns orderBtns2) {
        this.shopInfo = shopInfo2;
        this.items = list;
        this.showList = list2;
        this.receiptBtn = orderBtns;
        this.onceAgainOrderBtn = orderBtns2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OrderItem(com.didi.soda.customer.foundation.rpc.entity.ShopInfo r5, java.util.List r6, java.util.List r7, com.didi.soda.customer.foundation.rpc.entity.OrderBtns r8, com.didi.soda.customer.foundation.rpc.entity.OrderBtns r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.foundation.rpc.entity.OrderItem.<init>(com.didi.soda.customer.foundation.rpc.entity.ShopInfo, java.util.List, java.util.List, com.didi.soda.customer.foundation.rpc.entity.OrderBtns, com.didi.soda.customer.foundation.rpc.entity.OrderBtns, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final ShopInfo getShopInfo() {
        return this.shopInfo;
    }

    public final List<DishItem> getItems() {
        return this.items;
    }

    public final List<ShowList> getShowList() {
        return this.showList;
    }

    public final OrderBtns getReceiptBtn() {
        return this.receiptBtn;
    }

    public final OrderBtns getOnceAgainOrderBtn() {
        return this.onceAgainOrderBtn;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderItem$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderLayoutEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
