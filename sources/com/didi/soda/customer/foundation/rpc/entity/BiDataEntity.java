package com.didi.soda.customer.foundation.rpc.entity;

import com.google.gson.annotations.SerializedName;

public class BiDataEntity implements IEntity {
    private static final long serialVersionUID = -2977272824564691070L;
    @SerializedName("arrears_order_status")
    public int arrearsOrderStatus;
}
