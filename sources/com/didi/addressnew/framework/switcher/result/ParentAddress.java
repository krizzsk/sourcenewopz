package com.didi.addressnew.framework.switcher.result;

import com.didi.sdk.address.address.entity.Address;

public class ParentAddress implements Cloneable {
    public Address address;
    public int addressType;

    /* access modifiers changed from: protected */
    public ParentAddress clone() {
        ParentAddress parentAddress = new ParentAddress();
        parentAddress.addressType = this.addressType;
        parentAddress.address = this.address.clone();
        return parentAddress;
    }
}
