package com.didi.soda.customer.foundation.rpc.entity.bill;

import com.didi.entrega.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0013JH\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\nHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillUpdateParams;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "cartId", "", "shopId", "mduId", "nodeList", "", "Lcom/didi/soda/customer/foundation/rpc/entity/ItemNodeEntity;", "wineConfirm", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)V", "getCartId", "()Ljava/lang/String;", "getMduId", "getNodeList", "()Ljava/util/List;", "getShopId", "getWineConfirm", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillUpdateParams;", "equals", "", "other", "", "hashCode", "toString", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillUpdateParams.kt */
public final class BillUpdateParams implements IEntity {
    private final String cartId;
    private final String mduId;
    private final List<ItemNodeEntity> nodeList;
    private final String shopId;
    private final Integer wineConfirm;

    public static /* synthetic */ BillUpdateParams copy$default(BillUpdateParams billUpdateParams, String str, String str2, String str3, List<ItemNodeEntity> list, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = billUpdateParams.cartId;
        }
        if ((i & 2) != 0) {
            str2 = billUpdateParams.shopId;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = billUpdateParams.mduId;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            list = billUpdateParams.nodeList;
        }
        List<ItemNodeEntity> list2 = list;
        if ((i & 16) != 0) {
            num = billUpdateParams.wineConfirm;
        }
        return billUpdateParams.copy(str, str4, str5, list2, num);
    }

    public final String component1() {
        return this.cartId;
    }

    public final String component2() {
        return this.shopId;
    }

    public final String component3() {
        return this.mduId;
    }

    public final List<ItemNodeEntity> component4() {
        return this.nodeList;
    }

    public final Integer component5() {
        return this.wineConfirm;
    }

    public final BillUpdateParams copy(String str, String str2, String str3, List<? extends ItemNodeEntity> list, Integer num) {
        Intrinsics.checkNotNullParameter(str, Const.BundleKey.CART_ID);
        Intrinsics.checkNotNullParameter(str2, "shopId");
        Intrinsics.checkNotNullParameter(str3, "mduId");
        Intrinsics.checkNotNullParameter(list, "nodeList");
        return new BillUpdateParams(str, str2, str3, list, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BillUpdateParams)) {
            return false;
        }
        BillUpdateParams billUpdateParams = (BillUpdateParams) obj;
        return Intrinsics.areEqual((Object) this.cartId, (Object) billUpdateParams.cartId) && Intrinsics.areEqual((Object) this.shopId, (Object) billUpdateParams.shopId) && Intrinsics.areEqual((Object) this.mduId, (Object) billUpdateParams.mduId) && Intrinsics.areEqual((Object) this.nodeList, (Object) billUpdateParams.nodeList) && Intrinsics.areEqual((Object) this.wineConfirm, (Object) billUpdateParams.wineConfirm);
    }

    public int hashCode() {
        int hashCode = ((((((this.cartId.hashCode() * 31) + this.shopId.hashCode()) * 31) + this.mduId.hashCode()) * 31) + this.nodeList.hashCode()) * 31;
        Integer num = this.wineConfirm;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "BillUpdateParams(cartId=" + this.cartId + ", shopId=" + this.shopId + ", mduId=" + this.mduId + ", nodeList=" + this.nodeList + ", wineConfirm=" + this.wineConfirm + VersionRange.RIGHT_OPEN;
    }

    public BillUpdateParams(String str, String str2, String str3, List<? extends ItemNodeEntity> list, Integer num) {
        Intrinsics.checkNotNullParameter(str, Const.BundleKey.CART_ID);
        Intrinsics.checkNotNullParameter(str2, "shopId");
        Intrinsics.checkNotNullParameter(str3, "mduId");
        Intrinsics.checkNotNullParameter(list, "nodeList");
        this.cartId = str;
        this.shopId = str2;
        this.mduId = str3;
        this.nodeList = list;
        this.wineConfirm = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BillUpdateParams(String str, String str2, String str3, List list, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, list, (i & 16) != 0 ? null : num);
    }

    public final String getCartId() {
        return this.cartId;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final String getMduId() {
        return this.mduId;
    }

    public final List<ItemNodeEntity> getNodeList() {
        return this.nodeList;
    }

    public final Integer getWineConfirm() {
        return this.wineConfirm;
    }
}
