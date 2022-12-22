package com.didi.soda.cart.model;

import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.PromptEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.TyingItems;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\b¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/cart/model/CartTyingModel;", "Lcom/didi/soda/cart/model/CartItemBaseModel;", "()V", "backgroundImg", "", "getBackgroundImg", "()Ljava/lang/String;", "setBackgroundImg", "(Ljava/lang/String;)V", "cartItems", "Ljava/util/ArrayList;", "Lcom/didi/soda/cart/model/CartTyingItemModel;", "Lkotlin/collections/ArrayList;", "getCartItems", "()Ljava/util/ArrayList;", "setCartItems", "(Ljava/util/ArrayList;)V", "title", "getTitle", "setTitle", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartTyingModel.kt */
public final class CartTyingModel extends CartItemBaseModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private String f40084a = "";

    /* renamed from: b */
    private String f40085b = "";

    /* renamed from: c */
    private ArrayList<CartTyingItemModel> f40086c = new ArrayList<>();

    public final String getTitle() {
        return this.f40084a;
    }

    public final void setTitle(String str) {
        this.f40084a = str;
    }

    public final String getBackgroundImg() {
        return this.f40085b;
    }

    public final void setBackgroundImg(String str) {
        this.f40085b = str;
    }

    public final ArrayList<CartTyingItemModel> getCartItems() {
        return this.f40086c;
    }

    public final void setCartItems(ArrayList<CartTyingItemModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.f40086c = arrayList;
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/cart/model/CartTyingModel$Companion;", "", "()V", "convert", "Lcom/didi/soda/cart/model/CartTyingModel;", "tyingItems", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/TyingItems;", "shopStatus", "", "cartId", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CartTyingModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ CartTyingModel convert$default(Companion companion, TyingItems tyingItems, int i, String str, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 1;
            }
            if ((i2 & 4) != 0) {
                str = null;
            }
            return companion.convert(tyingItems, i, str);
        }

        public final CartTyingModel convert(TyingItems tyingItems, int i, String str) {
            String str2;
            CartTyingModel cartTyingModel = new CartTyingModel();
            if (tyingItems == null) {
                return cartTyingModel;
            }
            String shopId = tyingItems.getShopId();
            if (shopId == null) {
                shopId = "";
            }
            cartTyingModel.setShopId(shopId);
            cartTyingModel.setCartId(str);
            cartTyingModel.setShopStatus(i);
            cartTyingModel.setTitle(tyingItems.getTitle());
            cartTyingModel.setBackgroundImg(tyingItems.getBackgroundImg());
            Collection items = tyingItems.getItems();
            if (!(items == null || items.isEmpty())) {
                List<GoodsItemEntity> items2 = tyingItems.getItems();
                Intrinsics.checkNotNull(items2);
                int i2 = 0;
                for (GoodsItemEntity next : items2) {
                    CartTyingItemModel cartTyingItemModel = new CartTyingItemModel();
                    cartTyingItemModel.setPosition(i2);
                    i2++;
                    String str3 = next.itemId;
                    Intrinsics.checkNotNullExpressionValue(str3, "item.itemId");
                    cartTyingItemModel.setItemId(str3);
                    cartTyingItemModel.setItemUniqKey(next.itemUniqKey);
                    String str4 = next.itemName;
                    Intrinsics.checkNotNullExpressionValue(str4, "item.itemName");
                    cartTyingItemModel.setItemName(str4);
                    String shopId2 = tyingItems.getShopId();
                    if (shopId2 == null) {
                        shopId2 = "";
                    }
                    cartTyingItemModel.setShopId(shopId2);
                    cartTyingItemModel.setCartId(str);
                    cartTyingItemModel.setShopStatus(i);
                    cartTyingItemModel.setHeadImg(next.headImg);
                    cartTyingItemModel.setPrice(next.price);
                    cartTyingItemModel.setPriceDisplay(next.priceDisplay);
                    cartTyingItemModel.setSpecialPrice(next.specialPrice);
                    cartTyingItemModel.setSpecialPriceDisplay(next.specialPriceDisplay);
                    cartTyingItemModel.setMActTagList(next.actTag);
                    cartTyingItemModel.setActivityType(next.activityType);
                    cartTyingItemModel.setStatus(next.status);
                    cartTyingItemModel.setSoldStatus(next.soldStatus);
                    GoodsItemEntity.LimitLabel limitLabel = next.limitLabel;
                    if (limitLabel == null || (str2 = limitLabel.limitLabelStr) == null) {
                        str2 = "";
                    }
                    cartTyingItemModel.setLimited_time(str2);
                    cartTyingItemModel.setCurrency(next.currency);
                    cartTyingItemModel.setDeliveryPriceAct(next.deliveryPriceAct);
                    cartTyingItemModel.setDeliveryPriceOri(next.deliveryPriceOri);
                    cartTyingItemModel.setDeliveryTime(next.deliveryTime);
                    Collection collection = next.contentList;
                    cartTyingItemModel.setMultiContent(!(collection == null || collection.isEmpty()));
                    cartTyingItemModel.setNode(next.node);
                    List<PromptEntity> list = next.tips;
                    if (list != null) {
                        for (PromptEntity next2 : list) {
                            if (next2 != null) {
                                cartTyingItemModel.getMGoodsMarketingTips().add(next2.content);
                            }
                        }
                    }
                    cartTyingModel.getCartItems().add(cartTyingItemModel);
                }
            }
            return cartTyingModel;
        }
    }
}
