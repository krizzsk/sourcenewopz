package com.didi.map.sdk.nav.car;

import com.didi.common.map.model.LatLng;
import java.util.List;

public interface onCarAnimationListener {
    void onErase(int i, int i2, LatLng latLng);

    void onErase(List<LatLng> list);

    void onUpdateAllLine(List<LatLng> list, List<LatLng> list2);
}
