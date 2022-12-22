package com.didiglobal.p205sa.biz.estimate;

import com.didi.address.model.WayPoint;
import com.didi.sdk.address.address.entity.Address;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didiglobal.sa.biz.estimate.EstimateParams */
public class EstimateParams implements Serializable {
    private Address endAddress;
    private boolean isGuessDestination = false;
    private List<WayPoint> mWayPointAddressList = new ArrayList();
    private Address startAddress;

    public void setEndAddress(Address address) {
        this.endAddress = address;
    }

    public void setStartAddress(Address address) {
        this.startAddress = address;
    }

    public Address getEndAddress() {
        return this.endAddress;
    }

    public Address getStartAddress() {
        return this.startAddress;
    }

    public void setGuessDestination(boolean z) {
        this.isGuessDestination = z;
    }

    public boolean isGuessDestination() {
        return this.isGuessDestination;
    }

    public void setmWayPointAddressList(List<WayPoint> list) {
        this.mWayPointAddressList = list;
    }

    public List<WayPoint> getmWayPointAddressList() {
        return this.mWayPointAddressList;
    }
}
