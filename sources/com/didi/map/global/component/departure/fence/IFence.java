package com.didi.map.global.component.departure.fence;

import com.didi.common.map.Map;
import java.util.List;

public interface IFence {
    void addToMap(Map map);

    void remove();

    void setFenceVisible(boolean z);

    void updateFences(List<FencePolygon> list);
}
