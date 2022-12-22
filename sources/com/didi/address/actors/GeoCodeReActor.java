package com.didi.address.actors;

import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.RpcPoi;

public interface GeoCodeReActor {
    void onGeoCodeFailed(AddressParam addressParam, Exception exc);

    void onGeoCodeSuccess(AddressParam addressParam, Address address, RpcPoi rpcPoi);
}
