package com.didi.map.global.component.departure.canoe.reverse;

import com.didi.map.global.component.departure.model.DepartureAddress;

public interface IReverseCallback {
    void onLoading();

    void onReverseFailed();

    void onReverseSuccess(DepartureAddress departureAddress);
}
