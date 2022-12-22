package com.didi.soda.customer.foundation.rpc.entity;

import com.google.gson.annotations.SerializedName;

public class SearchShopsTagEntity implements IEntity {
    private static final long serialVersionUID = 2947748003884209280L;
    @SerializedName("shopId")
    public String mShopId;
    @SerializedName("shopName")
    public String mShopName;
}
