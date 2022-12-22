package com.didi.map.sdk.nav.traffic;

import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.map.sdk.nav.traffic.model.TrafficLineAnimatorOptions;
import java.util.List;

public interface ITrafficLine {
    void addToMap(Map map);

    void addToMap(Map map, TrafficLineAnimatorOptions trafficLineAnimatorOptions);

    void erase(int i, LatLng latLng);

    List<Line> getLines();

    void highLight(boolean z);

    void remove();

    void setTrafficOptions(TrafficOptions trafficOptions);
}
