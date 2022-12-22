package com.didi.address.view;

import com.didi.sdk.address.address.entity.Address;

public interface IPoiChangeListener {
    void onPinFetchPoiFailed(Address address);

    void onPinLoading(double d, double d2);

    void onPinPoiChanged(Address address);
}
