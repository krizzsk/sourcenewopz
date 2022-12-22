package com.didi.map.global.flow.scene.order.serving;

import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.departure.model.DepartureAddress;

public interface ILocationCallback {
    void onDepartureLoading(LatLng latLng);

    void onDragging(int i);

    void onFail(LatLng latLng);

    void onUpdateLocation(DepartureAddress departureAddress);
}
