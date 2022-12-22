package com.didi.map.outer.model;

import com.didi.map.alpha.maps.internal.HeatOverlayControl;
import java.util.List;

public class HeatOverlay {

    /* renamed from: a */
    private String f27927a;

    /* renamed from: b */
    private final HeatOverlayControl f27928b;

    /* renamed from: c */
    private HeatOverlayOptions f27929c;

    public HeatOverlay(HeatOverlayControl heatOverlayControl, String str, HeatOverlayOptions heatOverlayOptions) {
        this.f27928b = heatOverlayControl;
        this.f27927a = str;
        this.f27929c = heatOverlayOptions;
    }

    public void updateData(List<HeatDataNode> list) {
        this.f27928b.updateData(this.f27927a, list);
    }

    public void remove() {
        this.f27928b.remove(this.f27927a);
    }

    public String getId() {
        return this.f27927a;
    }
}
