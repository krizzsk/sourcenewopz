package com.didi.soda.customer.foundation.rpc.entity.cart;

import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.rpc.entity.ActTagEntity;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.RuleDescEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 \\2\u00020\u0001:\u0001\\B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010[\u001a\u00020\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\u001a\u0010.\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\u001c\u00101\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR\u001a\u00104\u001a\u000205X.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR\u001a\u0010=\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0019\"\u0004\b?\u0010\u001bR\u001c\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0019\"\u0004\bH\u0010\u001bR\u001c\u0010I\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\bR\u001a\u0010L\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0019\"\u0004\bN\u0010\u001bR\u001c\u0010O\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010\bR\u001c\u0010R\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0006\"\u0004\bT\u0010\bR\u001a\u0010U\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0019\"\u0004\bW\u0010\u001bR\u001c\u0010X\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0006\"\u0004\bZ\u0010\b¨\u0006]"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartItemEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "actDesc", "", "getActDesc", "()Ljava/lang/String;", "setActDesc", "(Ljava/lang/String;)V", "actRules", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/RuleDescEntity;", "getActRules", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/RuleDescEntity;", "setActRules", "(Lcom/didi/soda/customer/foundation/rpc/entity/bill/RuleDescEntity;)V", "actTag", "", "Lcom/didi/soda/customer/foundation/rpc/entity/ActTagEntity;", "getActTag", "()Ljava/util/List;", "setActTag", "(Ljava/util/List;)V", "activityType", "", "getActivityType", "()I", "setActivityType", "(I)V", "amount", "getAmount", "setAmount", "businessType", "getBusinessType", "setBusinessType", "headImg", "getHeadImg", "setHeadImg", "itemFeature", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartItemFeatureEntity;", "getItemFeature", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartItemFeatureEntity;", "setItemFeature", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartItemFeatureEntity;)V", "itemId", "getItemId", "setItemId", "itemName", "getItemName", "setItemName", "itemUniqKey", "getItemUniqKey", "setItemUniqKey", "mdu", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/MduEntity;", "getMdu", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/MduEntity;", "setMdu", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/MduEntity;)V", "mduId", "getMduId", "setMduId", "mduType", "getMduType", "setMduType", "node", "Lcom/didi/soda/customer/foundation/rpc/entity/ItemNodeEntity;", "getNode", "()Lcom/didi/soda/customer/foundation/rpc/entity/ItemNodeEntity;", "setNode", "(Lcom/didi/soda/customer/foundation/rpc/entity/ItemNodeEntity;)V", "price", "getPrice", "setPrice", "priceDisplay", "getPriceDisplay", "setPriceDisplay", "specialPrice", "getSpecialPrice", "setSpecialPrice", "specialPriceDisplay", "getSpecialPriceDisplay", "setSpecialPriceDisplay", "subItemDesc", "getSubItemDesc", "setSubItemDesc", "tyingItemsFlag", "getTyingItemsFlag", "setTyingItemsFlag", "url", "getUrl", "setUrl", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartItemEntity.kt */
public final class CartItemEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 2019609776948868006L;
    private String actDesc;
    private RuleDescEntity actRules;
    private List<? extends ActTagEntity> actTag;
    private int activityType;
    private int amount;
    private int businessType = 1;
    private String headImg;
    private CartItemFeatureEntity itemFeature;
    public String itemId;
    public String itemName;
    private String itemUniqKey = "";
    public MduEntity mdu;
    private String mduId = "";
    private int mduType = 1;
    private ItemNodeEntity node;
    private int price;
    private String priceDisplay;
    private int specialPrice;
    private String specialPriceDisplay;
    private String subItemDesc;
    private int tyingItemsFlag;
    private String url;

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
        return this.itemUniqKey;
    }

    public final void setItemUniqKey(String str) {
        this.itemUniqKey = str;
    }

    public final String getItemName() {
        String str = this.itemName;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("itemName");
        return null;
    }

    public final void setItemName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.itemName = str;
    }

    public final String getMduId() {
        return this.mduId;
    }

    public final void setMduId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mduId = str;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final void setAmount(int i) {
        this.amount = i;
    }

    public final String getHeadImg() {
        return this.headImg;
    }

    public final void setHeadImg(String str) {
        this.headImg = str;
    }

    public final String getSubItemDesc() {
        return this.subItemDesc;
    }

    public final void setSubItemDesc(String str) {
        this.subItemDesc = str;
    }

    public final int getPrice() {
        return this.price;
    }

    public final void setPrice(int i) {
        this.price = i;
    }

    public final String getPriceDisplay() {
        return this.priceDisplay;
    }

    public final void setPriceDisplay(String str) {
        this.priceDisplay = str;
    }

    public final int getSpecialPrice() {
        return this.specialPrice;
    }

    public final void setSpecialPrice(int i) {
        this.specialPrice = i;
    }

    public final String getSpecialPriceDisplay() {
        return this.specialPriceDisplay;
    }

    public final void setSpecialPriceDisplay(String str) {
        this.specialPriceDisplay = str;
    }

    public final String getActDesc() {
        return this.actDesc;
    }

    public final void setActDesc(String str) {
        this.actDesc = str;
    }

    public final int getActivityType() {
        return this.activityType;
    }

    public final void setActivityType(int i) {
        this.activityType = i;
    }

    public final List<ActTagEntity> getActTag() {
        return this.actTag;
    }

    public final void setActTag(List<? extends ActTagEntity> list) {
        this.actTag = list;
    }

    public final int getMduType() {
        return this.mduType;
    }

    public final void setMduType(int i) {
        this.mduType = i;
    }

    public final CartItemFeatureEntity getItemFeature() {
        return this.itemFeature;
    }

    public final void setItemFeature(CartItemFeatureEntity cartItemFeatureEntity) {
        this.itemFeature = cartItemFeatureEntity;
    }

    public final ItemNodeEntity getNode() {
        return this.node;
    }

    public final void setNode(ItemNodeEntity itemNodeEntity) {
        this.node = itemNodeEntity;
    }

    public final MduEntity getMdu() {
        MduEntity mduEntity = this.mdu;
        if (mduEntity != null) {
            return mduEntity;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mdu");
        return null;
    }

    public final void setMdu(MduEntity mduEntity) {
        Intrinsics.checkNotNullParameter(mduEntity, "<set-?>");
        this.mdu = mduEntity;
    }

    public final RuleDescEntity getActRules() {
        return this.actRules;
    }

    public final void setActRules(RuleDescEntity ruleDescEntity) {
        this.actRules = ruleDescEntity;
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

    public final int getTyingItemsFlag() {
        return this.tyingItemsFlag;
    }

    public final void setTyingItemsFlag(int i) {
        this.tyingItemsFlag = i;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartItemEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CartItemEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public String toString() {
        return "CartItemEntity(itemId='" + getItemId() + "', itemName='" + getItemName() + "', mduId='" + this.mduId + "', amount=" + this.amount + ", headImg=" + this.headImg + ", subItemDesc=" + this.subItemDesc + ", price=" + this.price + ", priceDisplay=" + this.priceDisplay + ", specialPrice=" + this.specialPrice + ", specialPriceDisplay=" + this.specialPriceDisplay + ", mduType=" + this.mduType + ", itemFeature=" + this.itemFeature + ", node=" + this.node + VersionRange.RIGHT_OPEN;
    }
}
