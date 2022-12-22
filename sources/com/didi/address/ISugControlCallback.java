package com.didi.address;

import com.didi.common.map.model.Padding;
import com.didi.sdk.address.address.entity.Address;

public interface ISugControlCallback {
    void onDeparturePinShow(boolean z, int i, Address address, Padding padding);

    void onResetBtnClick();
}
