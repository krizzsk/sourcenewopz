package com.didi.address.view;

import com.didi.sdk.address.address.entity.Address;

public interface ISugViewController {
    IPoiChangeListener getPoiChangeListener();

    Address getTargetAddress();

    void onMapScroll();

    void onMapTouch();
}
