package com.didi.soda.bill.model.datamodel;

import android.text.TextUtils;
import com.didi.soda.customer.foundation.rpc.entity.ActTagEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.RuleDescEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartItemFeatureEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 T2\u00020\u0001:\u0003TUVB\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010SH\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001c\u0010#\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\u001c\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\u001a\u0010/\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR\u001c\u00102\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR\u001a\u00105\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR\u001a\u00108\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001a\"\u0004\b:\u0010\u001cR\u001a\u0010;\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001a\"\u0004\b=\u0010\u001cR\u001c\u0010>\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0006\"\u0004\b@\u0010\bR\u001a\u0010A\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001a\"\u0004\bC\u0010\u001cR\u001c\u0010D\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0006\"\u0004\bF\u0010\bR\u001c\u0010G\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0006\"\u0004\bI\u0010\bR\u001a\u0010J\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u001a\"\u0004\bL\u0010\u001cR\u001c\u0010M\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0006\"\u0004\bO\u0010\b¨\u0006W"}, mo175978d2 = {"Lcom/didi/soda/bill/model/datamodel/BillCartItemModel;", "Ljava/io/Serializable;", "()V", "actDesc", "", "getActDesc", "()Ljava/lang/String;", "setActDesc", "(Ljava/lang/String;)V", "actRules", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/RuleDescEntity;", "getActRules", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/RuleDescEntity;", "setActRules", "(Lcom/didi/soda/customer/foundation/rpc/entity/bill/RuleDescEntity;)V", "actTag", "Ljava/util/ArrayList;", "Lcom/didi/soda/bill/model/datamodel/BillCartItemModel$DishActTag;", "Lkotlin/collections/ArrayList;", "getActTag", "()Ljava/util/ArrayList;", "setActTag", "(Ljava/util/ArrayList;)V", "activityType", "", "getActivityType", "()I", "setActivityType", "(I)V", "amount", "getAmount", "setAmount", "businessType", "getBusinessType", "setBusinessType", "headImg", "getHeadImg", "setHeadImg", "itemFeature", "Lcom/didi/soda/bill/model/datamodel/BillCartItemModel$ItemFeatureModel;", "getItemFeature", "()Lcom/didi/soda/bill/model/datamodel/BillCartItemModel$ItemFeatureModel;", "setItemFeature", "(Lcom/didi/soda/bill/model/datamodel/BillCartItemModel$ItemFeatureModel;)V", "itemId", "getItemId", "setItemId", "itemName", "getItemName", "setItemName", "itemUniKey", "getItemUniKey", "setItemUniKey", "mduId", "getMduId", "setMduId", "mduType", "getMduType", "setMduType", "price", "getPrice", "setPrice", "priceDisplay", "getPriceDisplay", "setPriceDisplay", "specialPrice", "getSpecialPrice", "setSpecialPrice", "specialPriceDisplay", "getSpecialPriceDisplay", "setSpecialPriceDisplay", "subItemDesc", "getSubItemDesc", "setSubItemDesc", "tyingItemsFlag", "getTyingItemsFlag", "setTyingItemsFlag", "url", "getUrl", "setUrl", "equals", "", "other", "", "Companion", "DishActTag", "ItemFeatureModel", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillCartItemModel.kt */
public final class BillCartItemModel implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private String actDesc;
    private RuleDescEntity actRules;
    private ArrayList<DishActTag> actTag = new ArrayList<>();
    private int activityType;
    private int amount;
    private int businessType = 1;
    private String headImg;
    private ItemFeatureModel itemFeature;
    private String itemId;
    private String itemName = "";
    private String itemUniKey;
    private String mduId = "";
    private int mduType;
    private int price;
    private String priceDisplay;
    private int specialPrice;
    private String specialPriceDisplay;
    private String subItemDesc;
    private int tyingItemsFlag;
    private String url;

    public final String getItemId() {
        return this.itemId;
    }

    public final void setItemId(String str) {
        this.itemId = str;
    }

    public final String getItemUniKey() {
        return this.itemUniKey;
    }

    public final void setItemUniKey(String str) {
        this.itemUniKey = str;
    }

    public final String getItemName() {
        return this.itemName;
    }

    public final void setItemName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.itemName = str;
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

    public final String getMduId() {
        return this.mduId;
    }

    public final void setMduId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mduId = str;
    }

    public final int getMduType() {
        return this.mduType;
    }

    public final void setMduType(int i) {
        this.mduType = i;
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

    public final int getAmount() {
        return this.amount;
    }

    public final void setAmount(int i) {
        this.amount = i;
    }

    public final ItemFeatureModel getItemFeature() {
        return this.itemFeature;
    }

    public final void setItemFeature(ItemFeatureModel itemFeatureModel) {
        this.itemFeature = itemFeatureModel;
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

    public final ArrayList<DishActTag> getActTag() {
        return this.actTag;
    }

    public final void setActTag(ArrayList<DishActTag> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.actTag = arrayList;
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

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/bill/model/datamodel/BillCartItemModel$DishActTag;", "", "icon", "", "content", "(Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getIcon", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillCartItemModel.kt */
    public static final class DishActTag {
        private final String content;
        private final String icon;

        public static /* synthetic */ DishActTag copy$default(DishActTag dishActTag, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = dishActTag.icon;
            }
            if ((i & 2) != 0) {
                str2 = dishActTag.content;
            }
            return dishActTag.copy(str, str2);
        }

        public final String component1() {
            return this.icon;
        }

        public final String component2() {
            return this.content;
        }

        public final DishActTag copy(String str, String str2) {
            return new DishActTag(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DishActTag)) {
                return false;
            }
            DishActTag dishActTag = (DishActTag) obj;
            return Intrinsics.areEqual((Object) this.icon, (Object) dishActTag.icon) && Intrinsics.areEqual((Object) this.content, (Object) dishActTag.content);
        }

        public int hashCode() {
            String str = this.icon;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.content;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "DishActTag(icon=" + this.icon + ", content=" + this.content + VersionRange.RIGHT_OPEN;
        }

        public DishActTag(String str, String str2) {
            this.icon = str;
            this.content = str2;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getIcon() {
            return this.icon;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/bill/model/datamodel/BillCartItemModel$ItemFeatureModel;", "", "()V", "isWine", "", "()I", "setWine", "(I)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillCartItemModel.kt */
    public static final class ItemFeatureModel {
        private int isWine;

        public final int isWine() {
            return this.isWine;
        }

        public final void setWine(int i) {
            this.isWine = i;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof BillCartItemModel) {
            BillCartItemModel billCartItemModel = (BillCartItemModel) obj;
            return TextUtils.equals(this.itemId, billCartItemModel.itemId) && this.amount == billCartItemModel.amount && TextUtils.equals(this.subItemDesc, billCartItemModel.subItemDesc) && TextUtils.equals(this.specialPriceDisplay, billCartItemModel.specialPriceDisplay) && TextUtils.equals(this.priceDisplay, billCartItemModel.priceDisplay);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/bill/model/datamodel/BillCartItemModel$Companion;", "", "()V", "convertEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartItemEntity;", "model", "Lcom/didi/soda/bill/model/datamodel/BillCartItemModel;", "convertModel", "entity", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillCartItemModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BillCartItemModel convertModel(CartItemEntity cartItemEntity) {
            Intrinsics.checkNotNullParameter(cartItemEntity, "entity");
            BillCartItemModel billCartItemModel = new BillCartItemModel();
            billCartItemModel.setItemId(cartItemEntity.getItemId());
            billCartItemModel.setItemUniKey(cartItemEntity.getItemUniqKey());
            billCartItemModel.setItemName(cartItemEntity.getItemName());
            billCartItemModel.setHeadImg(cartItemEntity.getHeadImg());
            billCartItemModel.setSubItemDesc(cartItemEntity.getSubItemDesc());
            billCartItemModel.setMduId(cartItemEntity.getMduId());
            billCartItemModel.setMduType(cartItemEntity.getMduType());
            billCartItemModel.setPrice(cartItemEntity.getPrice());
            billCartItemModel.setPriceDisplay(cartItemEntity.getPriceDisplay());
            billCartItemModel.setSpecialPrice(cartItemEntity.getSpecialPrice());
            billCartItemModel.setSpecialPriceDisplay(cartItemEntity.getSpecialPriceDisplay());
            billCartItemModel.setAmount(cartItemEntity.getAmount());
            billCartItemModel.setActDesc(cartItemEntity.getActDesc());
            billCartItemModel.setActivityType(cartItemEntity.getActivityType());
            billCartItemModel.setBusinessType(cartItemEntity.getBusinessType());
            billCartItemModel.setUrl(cartItemEntity.getUrl());
            billCartItemModel.setTyingItemsFlag(cartItemEntity.getTyingItemsFlag());
            billCartItemModel.getActTag().clear();
            List<ActTagEntity> actTag = cartItemEntity.getActTag();
            if (actTag != null) {
                for (ActTagEntity actTagEntity : actTag) {
                    billCartItemModel.getActTag().add(new DishActTag(actTagEntity.icon, actTagEntity.content));
                }
            }
            ItemFeatureModel itemFeatureModel = new ItemFeatureModel();
            CartItemFeatureEntity itemFeature = cartItemEntity.getItemFeature();
            if (itemFeature != null) {
                itemFeatureModel.setWine(itemFeature.isWine());
            }
            billCartItemModel.setItemFeature(itemFeatureModel);
            billCartItemModel.setActRules(cartItemEntity.getActRules());
            return billCartItemModel;
        }

        public final CartItemEntity convertEntity(BillCartItemModel billCartItemModel) {
            Intrinsics.checkNotNullParameter(billCartItemModel, "model");
            CartItemEntity cartItemEntity = new CartItemEntity();
            String itemId = billCartItemModel.getItemId();
            if (itemId == null) {
                itemId = "";
            }
            cartItemEntity.setItemId(itemId);
            cartItemEntity.setItemName(billCartItemModel.getItemName());
            cartItemEntity.setHeadImg(billCartItemModel.getHeadImg());
            cartItemEntity.setSubItemDesc(billCartItemModel.getSubItemDesc());
            cartItemEntity.setMduId(billCartItemModel.getMduId());
            cartItemEntity.setMduType(billCartItemModel.getMduType());
            cartItemEntity.setPrice(billCartItemModel.getPrice());
            cartItemEntity.setPriceDisplay(billCartItemModel.getPriceDisplay());
            cartItemEntity.setSpecialPrice(billCartItemModel.getSpecialPrice());
            cartItemEntity.setSpecialPriceDisplay(billCartItemModel.getSpecialPriceDisplay());
            cartItemEntity.setAmount(billCartItemModel.getAmount());
            CartItemFeatureEntity cartItemFeatureEntity = new CartItemFeatureEntity();
            ItemFeatureModel itemFeature = billCartItemModel.getItemFeature();
            if (itemFeature != null) {
                cartItemFeatureEntity.setWine(itemFeature.isWine());
            }
            cartItemEntity.setItemFeature(cartItemFeatureEntity);
            cartItemEntity.setActRules(billCartItemModel.getActRules());
            cartItemEntity.setBusinessType(billCartItemModel.getBusinessType());
            cartItemEntity.setUrl(billCartItemModel.getUrl());
            return cartItemEntity;
        }
    }
}
