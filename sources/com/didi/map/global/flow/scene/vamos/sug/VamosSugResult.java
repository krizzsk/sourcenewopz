package com.didi.map.global.flow.scene.vamos.sug;

import com.didi.address.FromType;
import com.didi.sdk.address.address.entity.Address;

public class VamosSugResult {
    public Address common;
    public Address company;
    public Address end;
    public FromType fromType;
    public Address home;
    public boolean isStartNeedNearRoad;
    public Address start;
    public int type;

    public String toString() {
        return "AddressResult{\n, fromType=" + this.fromType + 10 + ", type=" + this.type + 10 + ", start=" + this.start + 10 + ", end=" + this.end + 10 + ", home=" + this.home + 10 + ", company=" + this.company + 10 + ", common=" + this.common + 10 + '}';
    }
}
