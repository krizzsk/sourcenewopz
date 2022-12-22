package com.didi.soda.customer.foundation.rpc.entity.cart;

import com.didi.soda.customer.foundation.rpc.entity.GoodsActivityInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsSubItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import java.util.List;

public class MduEntity implements IEntity {
    private static final long serialVersionUID = 2457397003115479105L;
    public String abnormalDesc;
    public GoodsActivityInfoEntity activityInfo;
    public int activityType;
    public int amount;
    public int disCountNum;
    public String itemId;
    public String mduId;
    public int mduType;
    public long opTime;
    public int price;
    public String priceDisplay;
    public String remark;
    public int specialPrice;
    public String specialPriceDisplay;
    public int status;
    public String subItemName;
    public List<GoodsSubItemEntity> subItems;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MduEntity)) {
            return false;
        }
        MduEntity mduEntity = (MduEntity) obj;
        if (this.price != mduEntity.price || this.disCountNum != mduEntity.disCountNum || this.specialPrice != mduEntity.specialPrice || this.mduType != mduEntity.mduType) {
            return false;
        }
        String str = this.itemId;
        if (str == null ? mduEntity.itemId != null : !str.equals(mduEntity.itemId)) {
            return false;
        }
        String str2 = this.mduId;
        if (str2 == null ? mduEntity.mduId != null : !str2.equals(mduEntity.mduId)) {
            return false;
        }
        List<GoodsSubItemEntity> list = this.subItems;
        List<GoodsSubItemEntity> list2 = mduEntity.subItems;
        if (list != null) {
            return list.equals(list2);
        }
        if (list2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.price * 31;
        String str = this.itemId;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.mduId;
        int hashCode2 = (((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.disCountNum) * 31) + this.specialPrice) * 31;
        List<GoodsSubItemEntity> list = this.subItems;
        if (list != null) {
            i2 = list.hashCode();
        }
        return ((hashCode2 + i2) * 31) + this.mduType;
    }
}
