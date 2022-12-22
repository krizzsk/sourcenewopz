package com.didi.soda.customer.foundation.rpc.entity.bill;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartItemEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR.\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016¨\u0006!"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillCartItemsInfo;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "businessType", "", "getBusinessType", "()I", "setBusinessType", "(I)V", "items", "Ljava/util/ArrayList;", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartItemEntity;", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "shopId", "", "getShopId", "()Ljava/lang/String;", "setShopId", "(Ljava/lang/String;)V", "shopName", "getShopName", "setShopName", "shopReturnDesc", "getShopReturnDesc", "setShopReturnDesc", "url", "getUrl", "setUrl", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillCartItemsInfo.kt */
public final class BillCartItemsInfo implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -2234944627680386366L;
    private int businessType = 1;
    private ArrayList<CartItemEntity> items;
    private String shopId;
    private String shopName;
    private String shopReturnDesc;
    private String url;

    public final String getShopId() {
        return this.shopId;
    }

    public final void setShopId(String str) {
        this.shopId = str;
    }

    public final String getShopName() {
        return this.shopName;
    }

    public final void setShopName(String str) {
        this.shopName = str;
    }

    public final int getBusinessType() {
        return this.businessType;
    }

    public final void setBusinessType(int i) {
        this.businessType = i;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getShopReturnDesc() {
        return this.shopReturnDesc;
    }

    public final void setShopReturnDesc(String str) {
        this.shopReturnDesc = str;
    }

    public final ArrayList<CartItemEntity> getItems() {
        return this.items;
    }

    public final void setItems(ArrayList<CartItemEntity> arrayList) {
        this.items = arrayList;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillCartItemsInfo$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillCartItemsInfo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
