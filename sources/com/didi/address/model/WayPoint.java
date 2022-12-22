package com.didi.address.model;

import android.text.TextUtils;
import com.didi.address.util.PoiidCompleteUtils;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.util.Utils;
import java.io.Serializable;

public class WayPoint implements Serializable {
    private Address address;
    private boolean isDraging = false;
    private boolean isEditable = true;
    private boolean mUIEnable = true;
    private boolean setCanAdd = false;
    private int tripState = 0;
    private int wayPointType = 0;

    public int getTripState() {
        return this.tripState;
    }

    public void setTripState(int i) {
        this.tripState = i;
    }

    public void setEditable(boolean z) {
        this.isEditable = z;
    }

    public boolean isDraging() {
        return this.isDraging;
    }

    public void setDraging(boolean z) {
        this.isDraging = z;
    }

    public boolean isCanAdd() {
        return this.setCanAdd;
    }

    public void setCanAdd(boolean z) {
        this.setCanAdd = z;
    }

    public Address getAddress() {
        PoiidCompleteUtils.completePoiid(this.address);
        return this.address;
    }

    public void setAddress(Address address2) {
        PoiidCompleteUtils.completePoiid(address2);
        this.address = address2;
    }

    public int getWayPointType() {
        return this.wayPointType;
    }

    public void setWayPointType(int i) {
        this.wayPointType = i;
    }

    public boolean isArrived() {
        return this.tripState != 0;
    }

    public boolean isEditable() {
        if (this.address != null) {
            return !isArrived() && this.isEditable;
        }
        return this.isEditable;
    }

    public WayPoint(int i, Address address2) {
        address2 = address2 == null ? new Address() : address2;
        this.wayPointType = i;
        this.address = address2;
        this.isEditable = true;
    }

    public boolean valid() {
        Address address2 = this.address;
        if (address2 != null) {
            if (this.wayPointType == 1) {
                return true;
            }
            String str = TextUtils.isEmpty(address2.poiId) ? this.address.uid : this.address.poiId;
            if (TextUtils.isEmpty(str) || str.equalsIgnoreCase("null") || !Utils.isValidLocation(this.address)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean isUIEnable() {
        return this.mUIEnable;
    }

    public void setUIEnable(boolean z) {
        this.mUIEnable = z;
    }

    public String toString() {
        return "WayPoint{tripState=" + this.tripState + ", wayPointType=" + this.wayPointType + ", isEditable=" + this.isEditable + ", isDraging=" + this.isDraging + ", setCanAdd=" + this.setCanAdd + ", address=" + this.address + '}';
    }
}
