package com.didi.entrega.address.list.component.feed.model;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.google.gson.annotations.SerializedName;

public class HomeAddressEntity implements IEntity {
    private static final long serialVersionUID = -4995825546654828809L;
    @SerializedName("address")
    public AddressEntity address;
}
