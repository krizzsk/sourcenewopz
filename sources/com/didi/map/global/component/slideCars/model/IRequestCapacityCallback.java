package com.didi.map.global.component.slideCars.model;

import com.didi.common.map.model.LatLng;
import com.didichuxing.carsliding.model.RenderParams;

public interface IRequestCapacityCallback {
    void onFailure();

    void onSuccess(LatLng latLng, RenderParams renderParams);
}
