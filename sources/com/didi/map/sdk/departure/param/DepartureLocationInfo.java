package com.didi.map.sdk.departure.param;

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
        LatLng latLng2 = this.latLng;
        if (latLng2 != null) {
            stringBuffer.append(latLng2.toString());
        } else {
            stringBuffer.append("latlng=null;");
        }
        Address address = this.sugPoi;
        if (address != null) {
            stringBuffer.append(address.toString());
        } else {
            stringBuffer.append("sugPoi=null;");
        }
        String str = this.coordinateType;
        if (str != null) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append("coordinateType = null");
        }
        return stringBuffer.toString();
    }
}
