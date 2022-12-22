package com.didi.entrega.address.list.component.feed.model;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class AddressPageListEntity implements IEntity {
    private static final long serialVersionUID = 3281386780977083389L;
    @SerializedName("addressList")
    public List<AddressEntity> addressList;
    @SerializedName("locationAddress")
    public AddressEntity locationAddress;
    @SerializedName("nearbyAddress")
    public List<AddressEntity> nearbyAddress;
    @SerializedName("addressStrategyVersion")
    public String recid;
    @SerializedName("sodaAddressList")
    public List<AddressEntity> sodaAddressList;
}
