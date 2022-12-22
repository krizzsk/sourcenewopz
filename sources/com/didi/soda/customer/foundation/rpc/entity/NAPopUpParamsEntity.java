package com.didi.soda.customer.foundation.rpc.entity;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class NAPopUpParamsEntity implements IEntity {
    private static final long serialVersionUID = -5469154499466122538L;
    public NAPopUpExtEntity popUpExtEntity = new NAPopUpExtEntity();
    public int position;
    public List<Integer> reciveTriggerSet = new ArrayList();

    public class NAPopUpExtEntity implements IEntity {
        private static final long serialVersionUID = 3334862434806410120L;
        public String orderId;
        public String shopId;

        public NAPopUpExtEntity() {
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NAPopUpParamsEntity)) {
            return false;
        }
        NAPopUpParamsEntity nAPopUpParamsEntity = (NAPopUpParamsEntity) obj;
        if (!this.reciveTriggerSet.contains(Integer.valueOf(nAPopUpParamsEntity.position)) && !nAPopUpParamsEntity.reciveTriggerSet.contains(Integer.valueOf(this.position))) {
            return false;
        }
        if ((TextUtils.isEmpty(nAPopUpParamsEntity.popUpExtEntity.orderId) && !TextUtils.isEmpty(this.popUpExtEntity.orderId)) || (!TextUtils.isEmpty(nAPopUpParamsEntity.popUpExtEntity.orderId) && !nAPopUpParamsEntity.popUpExtEntity.orderId.equals(this.popUpExtEntity.orderId))) {
            return false;
        }
        if ((!TextUtils.isEmpty(nAPopUpParamsEntity.popUpExtEntity.shopId) || TextUtils.isEmpty(this.popUpExtEntity.shopId)) && (TextUtils.isEmpty(nAPopUpParamsEntity.popUpExtEntity.shopId) || nAPopUpParamsEntity.popUpExtEntity.shopId.equals(this.popUpExtEntity.shopId))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
