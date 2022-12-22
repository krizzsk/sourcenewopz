package com.didi.soda.cart.model;

import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoAlertEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoPriceEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartItemEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010/\u001a\u0004\u0018\u00010\u00002\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020*J\b\u00103\u001a\u00020\nH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000eR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000eR\u001a\u0010)\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00064"}, mo175978d2 = {"Lcom/didi/soda/cart/model/CartInfoModel;", "", "()V", "alert", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoAlertEntity;", "getAlert", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoAlertEntity;", "setAlert", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoAlertEntity;)V", "cartId", "", "getCartId", "()Ljava/lang/String;", "setCartId", "(Ljava/lang/String;)V", "cartItems", "Ljava/util/ArrayList;", "Lcom/didi/soda/cart/model/CartItemBaseModel;", "Lkotlin/collections/ArrayList;", "getCartItems", "()Ljava/util/ArrayList;", "setCartItems", "(Ljava/util/ArrayList;)V", "cartTyingModel", "Lcom/didi/soda/cart/model/CartTyingModel;", "getCartTyingModel", "()Lcom/didi/soda/cart/model/CartTyingModel;", "setCartTyingModel", "(Lcom/didi/soda/cart/model/CartTyingModel;)V", "favorTip", "getFavorTip", "setFavorTip", "prices", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoPriceEntity;", "getPrices", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoPriceEntity;", "setPrices", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoPriceEntity;)V", "shopId", "getShopId", "setShopId", "version", "", "getVersion", "()I", "setVersion", "(I)V", "convertModel", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "businessStatus", "toString", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartInfoModel.kt */
public final class CartInfoModel {

    /* renamed from: a */
    private String f40044a = "";

    /* renamed from: b */
    private String f40045b;

    /* renamed from: c */
    private CartInfoPriceEntity f40046c;

    /* renamed from: d */
    private String f40047d;

    /* renamed from: e */
    private CartInfoAlertEntity f40048e;

    /* renamed from: f */
    private int f40049f;

    /* renamed from: g */
    private ArrayList<CartItemBaseModel> f40050g = new ArrayList<>();

    /* renamed from: h */
    private CartTyingModel f40051h;

    public final String getShopId() {
        return this.f40044a;
    }

    public final void setShopId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f40044a = str;
    }

    public final String getCartId() {
        return this.f40045b;
    }

    public final void setCartId(String str) {
        this.f40045b = str;
    }

    public final CartInfoPriceEntity getPrices() {
        return this.f40046c;
    }

    public final void setPrices(CartInfoPriceEntity cartInfoPriceEntity) {
        this.f40046c = cartInfoPriceEntity;
    }

    public final String getFavorTip() {
        return this.f40047d;
    }

    public final void setFavorTip(String str) {
        this.f40047d = str;
    }

    public final CartInfoAlertEntity getAlert() {
        return this.f40048e;
    }

    public final void setAlert(CartInfoAlertEntity cartInfoAlertEntity) {
        this.f40048e = cartInfoAlertEntity;
    }

    public final int getVersion() {
        return this.f40049f;
    }

    public final void setVersion(int i) {
        this.f40049f = i;
    }

    public final ArrayList<CartItemBaseModel> getCartItems() {
        return this.f40050g;
    }

    public final void setCartItems(ArrayList<CartItemBaseModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.f40050g = arrayList;
    }

    public final CartTyingModel getCartTyingModel() {
        return this.f40051h;
    }

    public final void setCartTyingModel(CartTyingModel cartTyingModel) {
        this.f40051h = cartTyingModel;
    }

    public final CartInfoModel convertModel(CartInfoEntity cartInfoEntity, int i) {
        CartItemBaseModel cartItemBaseModel;
        if (cartInfoEntity == null) {
            return null;
        }
        CartInfoModel cartInfoModel = new CartInfoModel();
        cartInfoModel.setPrices(cartInfoEntity.getPrices());
        cartInfoModel.setAlert(cartInfoEntity.getAlert());
        cartInfoModel.setCartId(cartInfoEntity.getCartId());
        cartInfoModel.setFavorTip(cartInfoEntity.getFavorTip());
        cartInfoModel.setShopId(cartInfoEntity.getShopId());
        Collection items = cartInfoEntity.getItems();
        if (!(items == null || items.isEmpty())) {
            List<CartItemEntity> items2 = cartInfoEntity.getItems();
            Intrinsics.checkNotNull(items2);
            for (CartItemEntity next : items2) {
                if (next.getMduType() == 1) {
                    cartItemBaseModel = new CartItemModel();
                } else {
                    cartItemBaseModel = new CartPresentItemModel();
                }
                CartItemBaseModel cartItemBaseModel2 = cartItemBaseModel;
                cartItemBaseModel2.setItemId(next.getItemId());
                cartItemBaseModel2.setItemUniqKey(next.getItemUniqKey());
                cartItemBaseModel2.setItemName(next.getItemName());
                cartItemBaseModel2.setShopId(cartInfoModel.getShopId());
                cartItemBaseModel2.setCartId(cartInfoModel.getCartId());
                cartItemBaseModel2.setShopStatus(i);
                cartItemBaseModel2.setMduId(next.getMduId());
                cartItemBaseModel2.setAmount(next.getAmount());
                cartItemBaseModel2.setHeadImg(next.getHeadImg());
                cartItemBaseModel2.setSubItemDesc(next.getSubItemDesc());
                cartItemBaseModel2.setPrice(next.getPrice());
                cartItemBaseModel2.setPriceDisplay(next.getPriceDisplay());
                cartItemBaseModel2.setSpecialPrice(next.getSpecialPrice());
                cartItemBaseModel2.setSpecialPriceDisplay(next.getSpecialPriceDisplay());
                cartItemBaseModel2.setItemFeature(next.getItemFeature());
                cartItemBaseModel2.setMActTagList(next.getActTag());
                cartItemBaseModel2.setActivityType(next.getActivityType());
                cartInfoModel.getCartItems().add(cartItemBaseModel2);
            }
        }
        cartInfoModel.setCartTyingModel(CartTyingModel.Companion.convert(cartInfoEntity.getTyingItems(), i, cartInfoModel.getCartId()));
        return cartInfoModel;
    }

    public String toString() {
        return "CartInfoModel(shopId='" + this.f40044a + "', cartId=" + this.f40045b + ", prices=" + this.f40046c + ", favorTip=" + this.f40047d + ", alert=" + this.f40048e + ", version=" + this.f40049f + ", cartItems=" + this.f40050g + VersionRange.RIGHT_OPEN;
    }
}
