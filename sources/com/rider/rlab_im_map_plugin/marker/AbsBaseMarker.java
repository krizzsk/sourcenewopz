package com.rider.rlab_im_map_plugin.marker;

import android.graphics.PointF;
import com.didi.common.map.Projection;
import com.didi.common.map.model.LatLng;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public abstract class AbsBaseMarker implements IMarker {

    /* renamed from: a */
    private final Logger f55919a = LoggerFactory.getLogger("AbsBaseMarker");

    public boolean isVisible() {
        if (getMarker() != null) {
            return getMarker().isVisible();
        }
        return false;
    }

    public void setVisible(boolean z) {
        if (getMarker() != null) {
            getMarker().setVisible(z);
        }
    }

    public LatLng getLatLngByOffset(LatLng latLng, float f, float f2) {
        Projection projection;
        if (getMap() == null || (projection = getMap().getProjection()) == null || latLng == null) {
            return latLng;
        }
        PointF pointF = null;
        try {
            pointF = projection.toScreenLocation(latLng);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (pointF == null) {
            return latLng;
        }
        pointF.offset(f, f2);
        return projection.fromScreenLocation(pointF);
    }

    public PointF getLatLngPoint(LatLng latLng, float f, float f2) {
        PointF pointF = null;
        if (getMap() == null) {
            return null;
        }
        Projection projection = getMap().getProjection();
        if (projection == null || latLng == null) {
            return new PointF(f, f2);
        }
        try {
            pointF = projection.toScreenLocation(latLng);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pointF == null ? new PointF(f, f2) : pointF;
    }

    public LatLng fromScreenLocation(float f, float f2) {
        Projection projection;
        if (getMap() == null || (projection = getMap().getProjection()) == null) {
            return null;
        }
        LatLng fromScreenLocation = projection.fromScreenLocation(new PointF(f, f2));
        Logger logger = this.f55919a;
        logger.debug("form screen location " + fromScreenLocation, new Object[0]);
        return fromScreenLocation;
    }
}
