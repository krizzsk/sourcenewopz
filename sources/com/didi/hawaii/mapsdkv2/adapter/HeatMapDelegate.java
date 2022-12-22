package com.didi.hawaii.mapsdkv2.adapter;

import android.util.Pair;
import com.didi.hawaii.mapsdkv2.adapter.option.GLHeatMapOptionAdapter;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.overlay.GLHeatMap;
import com.didi.map.alpha.maps.internal.HeatOverlayControl;
import com.didi.map.alpha.maps.internal.IHeatOverlayDelegate;
import com.didi.map.outer.model.HeatDataNode;
import com.didi.map.outer.model.HeatOverlay;
import com.didi.map.outer.model.HeatOverlayOptions;
import java.util.List;
import java.util.Map;

public class HeatMapDelegate extends C9003b implements IHeatOverlayDelegate {

    /* renamed from: b */
    private static final GLHeatMapOptionAdapter f23703b = new GLHeatMapOptionAdapter();

    public void updateData(List<HeatDataNode> list) {
    }

    public HeatMapDelegate(GLViewManager gLViewManager, Map<String, Pair<?, GLOverlayView>> map) {
        super(gLViewManager, map);
    }

    public HeatOverlay addHeatOverlay(HeatOverlayOptions heatOverlayOptions, HeatOverlayControl heatOverlayControl) {
        GLHeatMap gLHeatMap = new GLHeatMap(this.viewManager, f23703b.get(heatOverlayOptions, this.viewManager));
        HeatOverlay heatOverlay = new HeatOverlay(heatOverlayControl, gLHeatMap.getId(), heatOverlayOptions);
        add(heatOverlay.getId(), heatOverlay, gLHeatMap);
        return heatOverlay;
    }

    public void updateData(String str, List<HeatDataNode> list) {
        GLHeatMap b = m16843b(str);
        if (b != null) {
            b.reloadHeatMap(f23703b.changeHeatDataNode(list));
        }
    }

    public void remove(String str) {
        super.remove(str);
    }

    /* renamed from: b */
    private GLHeatMap m16843b(String str) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a == null || !(a.second instanceof GLHeatMap)) {
            return null;
        }
        return (GLHeatMap) a.second;
    }
}
