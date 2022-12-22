package com.didi.soda.cart.model;

import com.didi.soda.customer.foundation.rpc.entity.cart.CartItemEntity;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0000H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/cart/model/CartItemModel;", "Lcom/didi/soda/cart/model/CartItemBaseModel;", "()V", "mduType", "", "getMduType", "()I", "setMduType", "(I)V", "convertModel", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartItemEntity;", "model", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartItemModel.kt */
public final class CartItemModel extends CartItemBaseModel {

    /* renamed from: a */
    private int f40070a = 1;

    public int getMduType() {
        return this.f40070a;
    }

    public void setMduType(int i) {
        this.f40070a = i;
    }

    public CartItemEntity convertModel(CartItemModel cartItemModel) {
        if (cartItemModel == null) {
            return null;
        }
        CartItemEntity cartItemEntity = new CartItemEntity();
        cartItemEntity.setItemId(cartItemModel.getItemId());
        cartItemEntity.setItemName(cartItemModel.getItemName());
        setShopId(cartItemModel.getShopId());
        cartItemEntity.setMduId(cartItemModel.getMduId());
        cartItemEntity.setAmount(cartItemModel.getAmount());
        cartItemEntity.setHeadImg(cartItemModel.getHeadImg());
        cartItemEntity.setSubItemDesc(cartItemModel.getSubItemDesc());
        cartItemEntity.setPrice(cartItemModel.getPrice());
        cartItemEntity.setPriceDisplay(cartItemModel.getPriceDisplay());
        cartItemEntity.setSpecialPrice(cartItemModel.getSpecialPrice());
        cartItemEntity.setSpecialPriceDisplay(cartItemModel.getSpecialPriceDisplay());
        cartItemEntity.setItemFeature(cartItemModel.getItemFeature());
        cartItemEntity.setActTag(cartItemModel.getMActTagList());
        return cartItemEntity;
    }
}
