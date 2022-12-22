package com.didi.soda.customer.repo.model;

import android.text.TextUtils;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;

public class ItemState implements IEntity {
    private static final long serialVersionUID = 6273072057636093513L;
    public int amount;
    public String itemId;
    public String itemUniKey;
    public String mduId;
    public int mduType;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ItemState)) {
            return false;
        }
        ItemState itemState = (ItemState) obj;
        if (this.amount != itemState.amount || TextUtils.equals(this.itemId, itemState.itemId) || TextUtils.equals(this.mduId, itemState.mduId) || this.mduType != itemState.mduType) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.itemUniKey;
        int i = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        if (hashCode == 0) {
            String str2 = this.itemId;
            if (str2 != null) {
                i = str2.hashCode();
            }
            hashCode = i;
        }
        return (hashCode * 31) + this.amount;
    }

    public String toString() {
        return "ItemState{itemId='" + this.itemId + '\'' + ", amount=" + this.amount + '}';
    }
}
