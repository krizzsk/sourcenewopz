package com.didi.foundation.sdk.map;

import com.didi.common.map.model.LatLng;
import java.util.List;

public abstract class SimpleSearchRouteCallback {
    public void onBeginToSearch() {
    }

    public void onFinishToSearch(List<LatLng> list, String str) {
    }
}
