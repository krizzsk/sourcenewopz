package com.didi.common.map.internal;

import android.graphics.PointF;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.VisibleRegion;
import com.didi.common.map.model.throwable.MapNotExistApiException;

public interface IProjectionDelegate extends IMapInterface {
    LatLng fromScreenLocation(PointF pointF) throws MapNotExistApiException;

    VisibleRegion getVisibleRegion() throws MapNotExistApiException;

    double metersPerPixel(double d) throws MapNotExistApiException;

    PointF toScreenLocation(LatLng latLng) throws MapNotExistApiException;
}
