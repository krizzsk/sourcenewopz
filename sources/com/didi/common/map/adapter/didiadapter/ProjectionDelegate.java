package com.didi.common.map.adapter.didiadapter;

import android.graphics.Point;
import android.graphics.PointF;
import com.didi.common.map.adapter.didiadapter.converter.Converter;
import com.didi.common.map.internal.IProjectionDelegate;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.VisibleRegion;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.map.Projection;

public class ProjectionDelegate implements IProjectionDelegate {

    /* renamed from: a */
    private Projection f10726a;

    public ProjectionDelegate(DidiMap didiMap) {
        if (didiMap != null) {
            this.f10726a = didiMap.getProjection();
        }
    }

    public PointF toScreenLocation(LatLng latLng) throws MapNotExistApiException {
        Projection projection = this.f10726a;
        if (projection == null) {
            return new PointF(0.0f, 0.0f);
        }
        Point screenLocation = projection.toScreenLocation(Converter.convertToDidiLatLng(latLng));
        if (screenLocation == null) {
            return new PointF(0.0f, 0.0f);
        }
        return Converter.convertToPointF(screenLocation);
    }

    public LatLng fromScreenLocation(PointF pointF) throws MapNotExistApiException {
        Projection projection = this.f10726a;
        if (projection == null) {
            return new LatLng(0.0d, 0.0d);
        }
        com.didi.map.outer.model.LatLng fromScreenLocation = projection.fromScreenLocation(Converter.convertToPoint(pointF));
        if (fromScreenLocation == null) {
            return new LatLng(0.0d, 0.0d);
        }
        return Converter.convertFromDidiLatLng(fromScreenLocation);
    }

    public VisibleRegion getVisibleRegion() {
        Projection projection = this.f10726a;
        if (projection == null) {
            return null;
        }
        return Converter.convertFromDidiVisibleRegion(projection.getVisibleRegion());
    }

    public double metersPerPixel(double d) {
        Projection projection = this.f10726a;
        if (projection == null) {
            return 0.0d;
        }
        return projection.metersPerPixel(d);
    }
}
