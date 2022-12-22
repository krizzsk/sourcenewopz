package com.didi.soda.cart.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.rpc.entity.ActTagEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartItemFeatureEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010M\u001a\u00020\rH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001c\u0010!\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R.\u0010+\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r0,j\n\u0012\u0006\u0012\u0004\u0018\u00010\r`-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000f\"\u0004\b4\u0010\u0011R\u001a\u00105\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR\u001a\u00108\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR\u001c\u0010;\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u000f\"\u0004\b=\u0010\u0011R\u001a\u0010>\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u000f\"\u0004\b@\u0010\u0011R\u001a\u0010A\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0006\"\u0004\bC\u0010\bR\u001a\u0010D\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0006\"\u0004\bF\u0010\bR\u001c\u0010G\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u000f\"\u0004\bI\u0010\u0011R\u001c\u0010J\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u000f\"\u0004\bL\u0010\u0011¨\u0006N"}, mo175978d2 = {"Lcom/didi/soda/cart/model/CartItemBaseModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "activityType", "", "getActivityType", "()I", "setActivityType", "(I)V", "amount", "getAmount", "setAmount", "cartId", "", "getCartId", "()Ljava/lang/String;", "setCartId", "(Ljava/lang/String;)V", "headImg", "getHeadImg", "setHeadImg", "itemFeature", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartItemFeatureEntity;", "getItemFeature", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartItemFeatureEntity;", "setItemFeature", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartItemFeatureEntity;)V", "itemId", "getItemId", "setItemId", "itemName", "getItemName", "setItemName", "itemUniqKey", "getItemUniqKey", "setItemUniqKey", "mActTagList", "", "Lcom/didi/soda/customer/foundation/rpc/entity/ActTagEntity;", "getMActTagList", "()Ljava/util/List;", "setMActTagList", "(Ljava/util/List;)V", "mGoodsMarketingTips", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMGoodsMarketingTips", "()Ljava/util/ArrayList;", "setMGoodsMarketingTips", "(Ljava/util/ArrayList;)V", "mduId", "getMduId", "setMduId", "mduType", "getMduType", "setMduType", "price", "getPrice", "setPrice", "priceDisplay", "getPriceDisplay", "setPriceDisplay", "shopId", "getShopId", "setShopId", "shopStatus", "getShopStatus", "setShopStatus", "specialPrice", "getSpecialPrice", "setSpecialPrice", "specialPriceDisplay", "getSpecialPriceDisplay", "setSpecialPriceDisplay", "subItemDesc", "getSubItemDesc", "setSubItemDesc", "toString", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartItemBaseModel.kt */
public class CartItemBaseModel implements RecyclerModel {

    /* renamed from: a */
    private String f40052a = "";

    /* renamed from: b */
    private int f40053b = 1;

    /* renamed from: c */
    private String f40054c = "";

    /* renamed from: d */
    private String f40055d = "";

    /* renamed from: e */
    private String f40056e = "";

    /* renamed from: f */
    private String f40057f = "";

    /* renamed from: g */
    private int f40058g;

    /* renamed from: h */
    private String f40059h;

    /* renamed from: i */
    private int f40060i = 1;
    public String itemId;

    /* renamed from: j */
    private String f40061j;

    /* renamed from: k */
    private int f40062k;

    /* renamed from: l */
    private String f40063l;

    /* renamed from: m */
    private int f40064m;

    /* renamed from: n */
    private String f40065n;

    /* renamed from: o */
    private List<? extends ActTagEntity> f40066o;

    /* renamed from: p */
    private int f40067p;

    /* renamed from: q */
    private CartItemFeatureEntity f40068q;

    /* renamed from: r */
    private ArrayList<String> f40069r = new ArrayList<>();

    public final String getItemId() {
        String str = this.itemId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException(BlocksConst.ACTION_PARAMS_ITEM_ID);
        return null;
    }

    public final void setItemId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.itemId = str;
    }

    public final String getItemUniqKey() {
        return this.f40052a;
    }

    public final void setItemUniqKey(String str) {
        this.f40052a = str;
    }

    public final int getShopStatus() {
        return this.f40053b;
    }

    public final void setShopStatus(int i) {
        this.f40053b = i;
    }

    public final String getItemName() {
        return this.f40054c;
    }

    public final void setItemName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f40054c = str;
    }

    public final String getShopId() {
        return this.f40055d;
    }

    public final void setShopId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f40055d = str;
    }

    public final String getCartId() {
        return this.f40056e;
    }

    public final void setCartId(String str) {
        this.f40056e = str;
    }

    public final String getMduId() {
        return this.f40057f;
    }

    public final void setMduId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f40057f = str;
    }

    public final int getAmount() {
        return this.f40058g;
    }

    public final void setAmount(int i) {
        this.f40058g = i;
    }

    public final String getHeadImg() {
        return this.f40059h;
    }

    public final void setHeadImg(String str) {
        this.f40059h = str;
    }

    public int getMduType() {
        return this.f40060i;
    }

    public void setMduType(int i) {
        this.f40060i = i;
    }

    public final String getSubItemDesc() {
        return this.f40061j;
    }

    public final void setSubItemDesc(String str) {
        this.f40061j = str;
    }

    public final int getPrice() {
        return this.f40062k;
    }

    public final void setPrice(int i) {
        this.f40062k = i;
    }

    public final String getPriceDisplay() {
        return this.f40063l;
    }

    public final void setPriceDisplay(String str) {
        this.f40063l = str;
    }

    public final int getSpecialPrice() {
        return this.f40064m;
    }

    public final void setSpecialPrice(int i) {
        this.f40064m = i;
    }

    public final String getSpecialPriceDisplay() {
        return this.f40065n;
    }

    public final void setSpecialPriceDisplay(String str) {
        this.f40065n = str;
    }

    public final List<ActTagEntity> getMActTagList() {
        return this.f40066o;
    }

    public final void setMActTagList(List<? extends ActTagEntity> list) {
        this.f40066o = list;
    }

    public final int getActivityType() {
        return this.f40067p;
    }

    public final void setActivityType(int i) {
        this.f40067p = i;
    }

    public final CartItemFeatureEntity getItemFeature() {
        return this.f40068q;
    }

    public final void setItemFeature(CartItemFeatureEntity cartItemFeatureEntity) {
        this.f40068q = cartItemFeatureEntity;
    }

    public final ArrayList<String> getMGoodsMarketingTips() {
        return this.f40069r;
    }

    public final void setMGoodsMarketingTips(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.f40069r = arrayList;
    }

    public String toString() {
        return "CartItemBaseModel(itemId='" + getItemId() + "', shopStatus=" + this.f40053b + ", itemName='" + this.f40054c + "', shopId='" + this.f40055d + "', mduId='" + this.f40057f + "', amount=" + this.f40058g + ", headImg=" + this.f40059h + ", mduType=" + getMduType() + ", subItemDesc=" + this.f40061j + ", price=" + this.f40062k + ", priceDisplay=" + this.f40063l + ", specialPrice=" + this.f40064m + ", specialPriceDisplay=" + this.f40065n + ", itemFeature=" + this.f40068q + VersionRange.RIGHT_OPEN;
    }
}
