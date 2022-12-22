package com.didi.entrega.customer.foundation.rpc.entity.order;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class OrderListEntity implements IEntity {
    private static final long serialVersionUID = 2576457277923466485L;
    @SerializedName("orders")
    public List<OrderInfoEntity> mOrderDetailEntityList;

    public String toString() {
        return this.mOrderDetailEntityList.toString();
    }
}
