package com.didi.hawaii.mapsdkv2.adapter.option;

import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.overlay.GLHeatMap;
import com.didi.map.outer.model.HeatDataNode;
import com.didi.map.outer.model.HeatOverlayOptions;
import java.util.ArrayList;
import java.util.List;

public class GLHeatMapOptionAdapter implements GLViewOptionAdapter<GLHeatMap.Option, HeatOverlayOptions> {
    public GLHeatMap.Option get(HeatOverlayOptions heatOverlayOptions, GLViewManager gLViewManager) {
        GLHeatMap.Option option = new GLHeatMap.Option();
        option.setRadius(heatOverlayOptions.getRadius());
        option.setHeatNodes(changeHeatDataNode(heatOverlayOptions.getNodes()));
        option.setHeatTileGenerator(heatOverlayOptions.getHeatTileGenerator());
        option.setColorMapper(heatOverlayOptions.getColorMapper());
        return option;
    }

    public List<GLHeatMap.HeatDataNode> changeHeatDataNode(List<HeatDataNode> list) {
        ArrayList arrayList = new ArrayList();
        for (HeatDataNode next : list) {
            arrayList.add(new GLHeatMap.HeatDataNode(next.getPoint(), next.getValue()));
        }
        return arrayList;
    }
}
