package com.didi.map.global.component.dropoff.model;

import com.didi.sdk.address.address.entity.Address;

public class DropOffAddress {

    /* renamed from: a */
    private Address f25515a;

    /* renamed from: b */
    private DropOffAddressExtendInfo f25516b;

    /* renamed from: c */
    private int f25517c;
    public boolean isRecommmend;

    public Address getAddress() {
        return this.f25515a;
    }

    public void setAddress(Address address) {
        this.f25515a = address;
    }

    public boolean isRecommmend() {
        return this.isRecommmend;
    }

    public void setRecommmend(boolean z) {
        this.isRecommmend = z;
    }

    public DropOffAddressExtendInfo getExtendInfo() {
        return this.f25516b;
    }

    public void setExtendInfo(DropOffAddressExtendInfo dropOffAddressExtendInfo) {
        this.f25516b = dropOffAddressExtendInfo;
    }

    public int getRecPointSize() {
        return this.f25517c;
    }

    public void setRecPointSize(int i) {
        this.f25517c = i;
    }
}
