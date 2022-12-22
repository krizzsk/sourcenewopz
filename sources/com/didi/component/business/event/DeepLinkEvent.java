package com.didi.component.business.event;

import com.didi.sdk.address.address.entity.Address;

public class DeepLinkEvent extends BaseDeepLinkEvent {
    public int mBid;
    public int mCarLevel;
    public Address mDropOffAddr;
    public Address mPickUpAddr;
    public int mTransportTime;

    public boolean isSameAddress() {
        return Math.abs(this.mPickUpAddr.longitude - this.mDropOffAddr.longitude) == 0.0d && Math.abs(this.mPickUpAddr.latitude - this.mDropOffAddr.latitude) == 0.0d;
    }
}
