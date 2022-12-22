package com.didi.addressold.vamos;

import com.didi.address.AddressResult;
import com.didi.sdk.address.address.entity.Address;

public abstract class GlobalSugCallback {
    public void onAttach(int i) {
    }

    public void onCloseButtonClick() {
    }

    public boolean onCloseButtonIntercept() {
        return false;
    }

    public void onDepartureLocationChanged(int i, Address address, float f) {
    }

    public void onDetach(int i) {
    }

    public void onEnterWayPoint(Address address, Address address2) {
    }

    public abstract void setResult(AddressResult addressResult);
}
