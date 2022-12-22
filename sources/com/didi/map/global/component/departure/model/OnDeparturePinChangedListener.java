package com.didi.map.global.component.departure.model;

import com.didi.common.map.model.LatLng;

public interface OnDeparturePinChangedListener {
    void onDepartureAddressChanged(DepartureAddress departureAddress);

    void onDepartureLoading(LatLng latLng);

    void onFetchAddressFailed(LatLng latLng);

    void onStartDragging();
}
