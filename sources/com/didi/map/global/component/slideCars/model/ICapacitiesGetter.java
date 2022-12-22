package com.didi.map.global.component.slideCars.model;

import com.didi.common.map.model.LatLng;

public interface ICapacitiesGetter {
    void requestCapacities(LatLng latLng, IRequestCapacityCallback iRequestCapacityCallback);
}
