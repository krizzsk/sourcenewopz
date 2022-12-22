package com.didi.map.alpha.maps.internal;

import android.graphics.Point;
import com.didi.map.core.point.DoublePoint;
import com.didi.map.core.point.GeoPoint;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.VisibleRegion;

public interface IProjectionDelegate {
    LatLng fromScreenLocation(Point point);

    VisibleRegion getVisibleRegion();

    double metersPerPixel(double d);

    Point toScreenLocation(LatLng latLng);

    DoublePoint toScreentLocation(GeoPoint geoPoint);
}
