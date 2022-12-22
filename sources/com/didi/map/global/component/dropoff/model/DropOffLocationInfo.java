package com.didi.map.global.component.dropoff.model;

import com.didi.common.map.model.LatLng;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.model.RpcPoiExtendInfo;

public class DropOffLocationInfo {
    public String coordinateType;
    public RpcPoiExtendInfo extendInfo;
    public LatLng latLng;
    public Address parentPoi;
    public Address sugPoi;
}
