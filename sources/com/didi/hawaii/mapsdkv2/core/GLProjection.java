package com.didi.hawaii.mapsdkv2.core;

import android.graphics.PointF;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.VisibleRegion;

public interface GLProjection {
    LatLng fromScreen(float f, float f2);

    VisibleRegion getVisibleRegion();

    PointF toScreen(LatLng latLng);
}
