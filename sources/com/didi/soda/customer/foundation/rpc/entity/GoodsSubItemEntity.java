package com.didi.soda.customer.foundation.rpc.entity;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.goods.repo.SelectSubItemState;
import java.util.ArrayList;
import java.util.List;

public class GoodsSubItemEntity implements IEntity, Cloneable, Comparable<GoodsSubItemEntity> {
    private static final String TAG = "GoodsSubItemEntity";
    private static final long serialVersionUID = -810853859591751347L;
    public int amount = 0;
    public String contentId;
    public List<GoodsContentEntity> contentList;
    public String currency;
    public boolean hasSelect;
    public String itemId;
    public String itemName;
    public ItemNodeEntity node;
    public int price;
    public String priceDisplay;
    public String shopId;
    public String shortDesc;
    public int status;
    public int stock;

    public static List<String> transformEntityToId(List<GoodsSubItemEntity> list) {
        ArrayList arrayList = new ArrayList();
        if (!CollectionsUtil.isEmpty(list)) {
            for (GoodsSubItemEntity goodsSubItemEntity : list) {
                arrayList.add(goodsSubItemEntity.itemId);
            }
        }
        return arrayList;
    }

    public static List<String> transformEntityToName(List<GoodsSubItemEntity> list) {
        ArrayList arrayList = new ArrayList();
        if (!CollectionsUtil.isEmpty(list)) {
            for (GoodsSubItemEntity goodsSubItemEntity : list) {
                arrayList.add(goodsSubItemEntity.itemName);
            }
        }
        return arrayList;
    }

    public int compareTo(GoodsSubItemEntity goodsSubItemEntity) {
        return this.itemId.compareTo(goodsSubItemEntity.itemId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsSubItemEntity)) {
            return false;
        }
        GoodsSubItemEntity goodsSubItemEntity = (GoodsSubItemEntity) obj;
        String str = this.shopId;
        if (str == null ? goodsSubItemEntity.shopId != null : !str.equals(goodsSubItemEntity.shopId)) {
            return false;
        }
        String str2 = this.itemId;
        if (str2 == null ? goodsSubItemEntity.itemId != null : !str2.equals(goodsSubItemEntity.itemId)) {
            return false;
        }
        String str3 = this.contentId;
        if (str3 == null ? goodsSubItemEntity.contentId != null : !str3.equals(goodsSubItemEntity.contentId)) {
            return false;
        }
        ItemNodeEntity itemNodeEntity = this.node;
        ItemNodeEntity itemNodeEntity2 = goodsSubItemEntity.node;
        if (itemNodeEntity != null) {
            return itemNodeEntity.equals(itemNodeEntity2);
        }
        if (itemNodeEntity2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.shopId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.itemId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.contentId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        ItemNodeEntity itemNodeEntity = this.node;
        if (itemNodeEntity != null) {
            i = itemNodeEntity.hashCode();
        }
        return hashCode3 + i;
    }

    public boolean equalsOneOfList(List<GoodsSubItemEntity> list) {
        if (CollectionsUtil.isEmpty(list)) {
            return false;
        }
        for (GoodsSubItemEntity next : list) {
            if (next != null && next.equals(this)) {
                return true;
            }
        }
        return false;
    }

    public GoodsSubItemEntity filterSubItemFromList(List<GoodsSubItemEntity> list) {
        if (CollectionsUtil.isEmpty(list)) {
            return null;
        }
        for (GoodsSubItemEntity next : list) {
            if (next != null && next.equals(this)) {
                return next;
            }
        }
        return null;
    }

    public SelectSubItemState filterState(List<SelectSubItemState> list) {
        if (CollectionsUtil.isEmpty(list)) {
            return null;
        }
        for (SelectSubItemState next : list) {
            if (next != null && next.contentId != null && next.contentId.equals(this.contentId) && next.subItemId != null && next.subItemId.equals(this.itemId) && next.node != null) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public GoodsSubItemEntity clone() {
        try {
            return (GoodsSubItemEntity) super.clone();
        } catch (CloneNotSupportedException unused) {
            LogUtil.m29100d(TAG, "clone exception");
            return null;
        }
    }

    private boolean safeEquals(String str, String str2) {
        return (str == null && str2 == null) || !(str == null || str2 == null || !str.equals(str2));
    }
}
