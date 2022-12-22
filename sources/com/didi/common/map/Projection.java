package com.didi.common.map;

import android.graphics.PointF;
import com.didi.common.map.internal.IProjectionDelegate;
import com.didi.common.map.internal.MapExceptionHandler;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.VisibleRegion;
import com.didi.common.map.model.throwable.MapNotExistApiException;

public final class Projection {

    /* renamed from: a */
    private IProjectionDelegate f10701a;

    public Projection(IProjectionDelegate iProjectionDelegate) {
        this.f10701a = iProjectionDelegate;
    }

    public PointF toScreenLocation(LatLng latLng) {
        IProjectionDelegate iProjectionDelegate = this.f10701a;
        if (iProjectionDelegate == null) {
            return new PointF();
        }
        try {
            return iProjectionDelegate.toScreenLocation(latLng);
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return new PointF();
        }
    }

    public LatLng fromScreenLocation(PointF pointF) {
        IProjectionDelegate iProjectionDelegate = this.f10701a;
        if (iProjectionDelegate == null) {
            return new LatLng(0.0d, 0.0d);
        }
        try {
            return iProjectionDelegate.fromScreenLocation(pointF);
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return new LatLng(0.0d, 0.0d);
        }
    }

    public VisibleRegion getVisibleRegion() {
        IProjectionDelegate iProjectionDelegate = this.f10701a;
        if (iProjectionDelegate == null) {
            return new VisibleRegion(new LatLng(0.0d, 0.0d), new LatLng(0.0d, 0.0d), new LatLng(0.0d, 0.0d), new LatLng(0.0d, 0.0d));
        }
        try {
            return iProjectionDelegate.getVisibleRegion();
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return null;
        }
    }

    public double metersPerPixel(double d) {
        IProjectionDelegate iProjectionDelegate = this.f10701a;
        if (iProjectionDelegate == null) {
            return -1.0d;
        }
        try {
            return iProjectionDelegate.metersPerPixel(d);
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return -1.0d;
        }
    }
}
