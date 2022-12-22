package com.didi.map.alpha.maps.internal;

import android.graphics.Rect;
import android.graphics.RectF;
import com.didi.map.outer.model.Circle;
import com.didi.map.outer.model.CircleOptions;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;

public final class CircleControl {

    /* renamed from: a */
    private ICircleDelegate f24491a = null;

    public CircleControl(ICircleDelegate iCircleDelegate) {
        this.f24491a = iCircleDelegate;
    }

    public void exit() {
        if (this.f24491a != null) {
            this.f24491a = null;
        }
    }

    public Circle addCircle(CircleOptions circleOptions) {
        ICircleDelegate iCircleDelegate = this.f24491a;
        if (iCircleDelegate == null) {
            return null;
        }
        return iCircleDelegate.addCircle(circleOptions, this);
    }

    public void circle_remove(String str) {
        ICircleDelegate iCircleDelegate = this.f24491a;
        if (iCircleDelegate != null) {
            iCircleDelegate.circle_remove(str);
        }
    }

    public void circle_setCenter(String str, LatLng latLng) {
        ICircleDelegate iCircleDelegate = this.f24491a;
        if (iCircleDelegate != null) {
            iCircleDelegate.circle_setCenter(str, latLng);
        }
    }

    public void circle_setFillColor(String str, int i) {
        ICircleDelegate iCircleDelegate = this.f24491a;
        if (iCircleDelegate != null) {
            iCircleDelegate.circle_setFillColor(str, i);
        }
    }

    public void circle_setRadius(String str, double d) {
        ICircleDelegate iCircleDelegate = this.f24491a;
        if (iCircleDelegate != null) {
            iCircleDelegate.circle_setRadius(str, d);
        }
    }

    public void circle_setStrokeColor(String str, int i) {
        ICircleDelegate iCircleDelegate = this.f24491a;
        if (iCircleDelegate != null) {
            iCircleDelegate.circle_setStrokeColor(str, i);
        }
    }

    public void circle_setStrokeWidth(String str, float f) {
        ICircleDelegate iCircleDelegate = this.f24491a;
        if (iCircleDelegate != null) {
            iCircleDelegate.circle_setStrokeWidth(str, f);
        }
    }

    public void circle_setVisible(String str, boolean z) {
        ICircleDelegate iCircleDelegate = this.f24491a;
        if (iCircleDelegate != null) {
            iCircleDelegate.circle_setVisible(str, z);
        }
    }

    public void circle_setZIndex(String str, float f) {
        ICircleDelegate iCircleDelegate = this.f24491a;
        if (iCircleDelegate != null) {
            iCircleDelegate.circle_setZIndex(str, f);
        }
    }

    public void clearCircles() {
        ICircleDelegate iCircleDelegate = this.f24491a;
        if (iCircleDelegate != null) {
            iCircleDelegate.clearCircles();
        }
    }

    public void setOptions(String str, CircleOptions circleOptions) {
        ICircleDelegate iCircleDelegate = this.f24491a;
        if (iCircleDelegate != null) {
            iCircleDelegate.setOptions(str, circleOptions);
        }
    }

    public LatLngBounds getBound(LatLng latLng, double d) {
        ICircleDelegate iCircleDelegate = this.f24491a;
        if (iCircleDelegate == null) {
            return null;
        }
        return iCircleDelegate.getBounds(latLng, d);
    }

    public Rect getBound(String str) {
        ICircleDelegate iCircleDelegate = this.f24491a;
        if (iCircleDelegate != null) {
            return iCircleDelegate.getBound(str);
        }
        return new Rect();
    }

    public RectF getPixel20Bound(String str, float f) {
        ICircleDelegate iCircleDelegate = this.f24491a;
        if (iCircleDelegate != null) {
            return iCircleDelegate.getPixel20Bound(str, f);
        }
        return null;
    }
}
