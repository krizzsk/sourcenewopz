package com.didi.soda.customer.foundation.rpc.entity.address;

import com.didi.soda.address.manager.AddressTipInfo;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.google.gson.annotations.SerializedName;

public class HomeAddressEntity implements IEntity {
    private static final long serialVersionUID = -4995825546654828809L;
    @SerializedName("address")
    public AddressEntity address;
    @SerializedName("tip")
    public AddressTipInfo tipInfo;
}
