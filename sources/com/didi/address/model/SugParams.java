package com.didi.address.model;

import com.didi.address.FromType;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.model.AddressParam;
import java.io.Serializable;

public class SugParams implements Serializable, Cloneable {
    public AddressParam addressParam;
    public boolean enable_way_point;
    public Address endAddress;
    public FromType fromType;
    public boolean is_start_address_new_select;
    public AddressManagerCallback managerCallback;
    public MapSelectOper map_select_oper = MapSelectOper.OTHER;
    public boolean showCommonAddress = true;
    public String usrType;
    public WayPointParam wayPointParam = new WayPointParam();

    public enum MapSelectOper {
        EDIT,
        CHOSE,
        OTHER
    }

    public SugParams clone() {
        SugParams sugParams;
        CloneNotSupportedException e;
        try {
            sugParams = (SugParams) super.clone();
            try {
                sugParams.addressParam = sugParams.addressParam.clone();
            } catch (CloneNotSupportedException e2) {
                e = e2;
            }
        } catch (CloneNotSupportedException e3) {
            CloneNotSupportedException cloneNotSupportedException = e3;
            sugParams = null;
            e = cloneNotSupportedException;
            e.printStackTrace();
            return sugParams;
        }
        return sugParams;
    }
}
