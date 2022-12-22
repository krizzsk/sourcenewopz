package com.didi.map.core.base;

import android.graphics.PointF;
import com.didi.map.core.point.DoublePoint;
import com.didi.map.core.point.GeoPoint;

public interface OnMapTransformer {
    GeoPoint fromScreenLocation(DoublePoint doublePoint);

    double metersPerPixel(double d);

    PointF toGLLocation(GeoPoint geoPoint);

    DoublePoint toScreentLocation(GeoPoint geoPoint);
}
