package com.didi.map.global.component.departure.data;

import com.didi.common.map.model.LatLng;
import com.sdk.poibase.model.poi.ReverseStationsInfo;

public interface OnDepartureHttpTaskListener {
    void onFail(int i, int i2);

    void onPrepare(LatLng latLng, int i);

    void onSuccess(ReverseStationsInfo reverseStationsInfo, int i);
}
