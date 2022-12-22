package com.didi.soda.customer.foundation.rpc.entity.address;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SearchPoiEntity implements IEntity {
    private static final long serialVersionUID = 8675423028429499751L;
    @SerializedName("poiList")
    public List<AddressEntity.PoiEntity> poiList;
    @SerializedName("address_strategy_version")
    public String recid;
    @SerializedName("searchId")
    public String searchId;
}
