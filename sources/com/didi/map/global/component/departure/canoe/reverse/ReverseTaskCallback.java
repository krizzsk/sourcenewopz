package com.didi.map.global.component.departure.canoe.reverse;

import com.sdk.poibase.model.poi.ReverseStationsInfo;

public interface ReverseTaskCallback {
    void onDataFailed(int i);

    void onDataStart();

    void onDataSuccess(ReverseStationsInfo reverseStationsInfo);
}
