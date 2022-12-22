package com.didi.soda.customer.foundation.rpc.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class OrderListEntity implements IEntity {
    private static final long serialVersionUID = -4152506961932831976L;
    @SerializedName("orders")
    public List<OrderInfoEntity> mOrderDetailEntityList;

    public String toString() {
        return this.mOrderDetailEntityList.toString();
    }
}
