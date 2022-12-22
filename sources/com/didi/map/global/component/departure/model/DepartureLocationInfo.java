package com.didi.map.global.component.departure.model;

import com.didi.common.map.model.LatLng;
import com.didi.sdk.address.address.entity.Address;

public class DepartureLocationInfo {
    public String coordinateType;
    public LatLng latLng;
    public Address sugPoi;

    public DepartureLocationInfo(LatLng latLng2, Address address, String str) {
        this.latLng = latLng2;
        this.coordinateType = str;
        this.sugPoi = address;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DepartureLocationInfo= ");
        stringBuffer.append("coordinateType: " + this.coordinateType);
        if (this.latLng != null) {
            stringBuffer.append(", latLng: " + this.latLng.toString());
        } else {
            stringBuffer.append(", latLng: null");
        }
        if (this.sugPoi != null) {
            stringBuffer.append(", sugPoi: " + this.sugPoi.toString());
        } else {
            stringBuffer.append(", sugPoi: null");
        }
        return stringBuffer.toString();
    }
}
