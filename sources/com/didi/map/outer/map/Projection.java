package com.didi.map.outer.map;

import android.graphics.Point;
import com.didi.map.alpha.maps.internal.IProjectionDelegate;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.VisibleRegion;

public final class Projection {

    /* renamed from: a */
    private IProjectionDelegate f27876a;

    public Projection(IProjectionDelegate iProjectionDelegate) {
        this.f27876a = iProjectionDelegate;
    }

    public void exit() {
        if (this.f27876a != null) {
            this.f27876a = null;
        }
    }

    public LatLng fromScreenLocation(Point point) {
        IProjectionDelegate iProjectionDelegate = this.f27876a;
        if (iProjectionDelegate == null) {
            return null;
        }
        return iProjectionDelegate.fromScreenLocation(point);
    }

    public Point toScreenLocation(LatLng latLng) {
        IProjectionDelegate iProjectionDelegate = this.f27876a;
        if (iProjectionDelegate == null) {
            return null;
        }
        return iProjectionDelegate.toScreenLocation(latLng);
    }

    public double metersPerPixel(double d) {
        IProjectionDelegate iProjectionDelegate = this.f27876a;
        if (iProjectionDelegate == null) {
            return 0.0d;
        }
        return iProjectionDelegate.metersPerPixel(d);
    }

    public VisibleRegion getVisibleRegion() {
        IProjectionDelegate iProjectionDelegate = this.f27876a;
        if (iProjectionDelegate == null) {
            return null;
        }
        return iProjectionDelegate.getVisibleRegion();
    }
}
