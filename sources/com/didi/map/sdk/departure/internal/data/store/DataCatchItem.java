package com.didi.map.sdk.departure.internal.data.store;

import com.didi.common.map.model.LatLng;
import com.sdk.poibase.model.poi.ReverseStationsInfo;
import java.util.List;

public class DataCatchItem {
    public ReverseStationsInfo info;
    public List<LatLng> points;
}
