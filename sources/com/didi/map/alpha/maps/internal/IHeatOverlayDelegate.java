package com.didi.map.alpha.maps.internal;

import com.didi.map.outer.model.HeatDataNode;
import com.didi.map.outer.model.HeatOverlay;
import com.didi.map.outer.model.HeatOverlayOptions;
import java.util.List;

public interface IHeatOverlayDelegate {
    HeatOverlay addHeatOverlay(HeatOverlayOptions heatOverlayOptions, HeatOverlayControl heatOverlayControl);

    void remove(String str);

    void updateData(String str, List<HeatDataNode> list);

    void updateData(List<HeatDataNode> list);
}
