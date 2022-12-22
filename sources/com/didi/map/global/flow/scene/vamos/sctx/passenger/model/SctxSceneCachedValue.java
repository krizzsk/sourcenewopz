package com.didi.map.global.flow.scene.vamos.sctx.passenger.model;

import android.content.Context;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.map.global.flow.scene.order.serving.components.DrivingStartEndMarker;

public class SctxSceneCachedValue {
    public EtaEda etaEda;
    public boolean isRouteExtAnimating;
    public DrivingStartEndMarker startEndMarker;

    public SctxSceneCachedValue(Context context) {
        this.startEndMarker = new DrivingStartEndMarker(context);
    }
}
