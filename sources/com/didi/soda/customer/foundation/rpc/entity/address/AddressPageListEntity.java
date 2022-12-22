package com.didi.soda.customer.foundation.rpc.entity.address;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class AddressPageListEntity implements IEntity {
    private static final long serialVersionUID = 3281386780977083389L;
    @SerializedName("deliveryAddress")
    public HomeAddressEntity deliveryAddress;
    @SerializedName("historyAddressList")
    public List<AddressEntity> historyAddressList;
    @SerializedName("locationAddress")
    public HomeAddressEntity locationAddress;
    @SerializedName("addressStrategyVersion")
    public String recid;
}
