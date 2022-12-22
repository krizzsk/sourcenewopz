package com.didi.soda.customer.foundation.rpc.entity.cart;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.ToastEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 42\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR\u001a\u0010\"\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR\u001a\u0010%\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR\u001c\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00065"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "alert", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoAlertEntity;", "getAlert", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoAlertEntity;", "setAlert", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoAlertEntity;)V", "cartId", "", "getCartId", "()Ljava/lang/String;", "setCartId", "(Ljava/lang/String;)V", "favorTip", "getFavorTip", "setFavorTip", "items", "", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartItemEntity;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "prices", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoPriceEntity;", "getPrices", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoPriceEntity;", "setPrices", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoPriceEntity;)V", "recId", "getRecId", "setRecId", "revision", "getRevision", "setRevision", "shopId", "getShopId", "setShopId", "toast", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/ToastEntity;", "getToast", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/ToastEntity;", "setToast", "(Lcom/didi/soda/customer/foundation/rpc/entity/bill/ToastEntity;)V", "tyingItems", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/TyingItems;", "getTyingItems", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/TyingItems;", "setTyingItems", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/TyingItems;)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartInfoEntity.kt */
public final class CartInfoEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 546476185131693976L;
    private CartInfoAlertEntity alert;
    private String cartId;
    private String favorTip;
    private List<CartItemEntity> items;
    private CartInfoPriceEntity prices;
    private String recId = "";
    private String revision = "";
    private String shopId = "";
    private ToastEntity toast;
    private TyingItems tyingItems;

    public final String getShopId() {
        return this.shopId;
    }

    public final void setShopId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shopId = str;
    }

    public final String getRecId() {
        return this.recId;
    }

    public final void setRecId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.recId = str;
    }

    public final String getCartId() {
        return this.cartId;
    }

    public final void setCartId(String str) {
        this.cartId = str;
    }

    public final CartInfoPriceEntity getPrices() {
        return this.prices;
    }

    public final void setPrices(CartInfoPriceEntity cartInfoPriceEntity) {
        this.prices = cartInfoPriceEntity;
    }

    public final String getFavorTip() {
        return this.favorTip;
    }

    public final void setFavorTip(String str) {
        this.favorTip = str;
    }

    public final CartInfoAlertEntity getAlert() {
        return this.alert;
    }

    public final void setAlert(CartInfoAlertEntity cartInfoAlertEntity) {
        this.alert = cartInfoAlertEntity;
    }

    public final String getRevision() {
        return this.revision;
    }

    public final void setRevision(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.revision = str;
    }

    public final ToastEntity getToast() {
        return this.toast;
    }

    public final void setToast(ToastEntity toastEntity) {
        this.toast = toastEntity;
    }

    public final List<CartItemEntity> getItems() {
        return this.items;
    }

    public final void setItems(List<CartItemEntity> list) {
        this.items = list;
    }

    public final TyingItems getTyingItems() {
        return this.tyingItems;
    }

    public final void setTyingItems(TyingItems tyingItems2) {
        this.tyingItems = tyingItems2;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CartInfoEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
