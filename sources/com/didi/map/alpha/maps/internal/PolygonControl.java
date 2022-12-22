package com.didi.map.alpha.maps.internal;

import android.graphics.Rect;
import android.graphics.RectF;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.Polygon;
import com.didi.map.outer.model.PolygonOptions;
import java.util.List;

public class PolygonControl {

    /* renamed from: a */
    private IPolygonDelegate f24561a = null;

    public PolygonControl(IPolygonDelegate iPolygonDelegate) {
        this.f24561a = iPolygonDelegate;
    }

    public void exit() {
        if (this.f24561a != null) {
            this.f24561a = null;
        }
    }

    public final Polygon addPolygon(PolygonOptions polygonOptions) {
        IPolygonDelegate iPolygonDelegate = this.f24561a;
        if (iPolygonDelegate == null) {
            return null;
        }
        return iPolygonDelegate.addPolygon(polygonOptions, this);
    }

    public final void polygon_remove(String str) {
        IPolygonDelegate iPolygonDelegate = this.f24561a;
        if (iPolygonDelegate != null) {
            iPolygonDelegate.polygon_remove(str);
        }
    }

    public final void setBellowRoute(String str, boolean z) {
        IPolygonDelegate iPolygonDelegate = this.f24561a;
        if (iPolygonDelegate != null) {
            iPolygonDelegate.setBellowRoute(str, z);
        }
    }

    public final void polygon_setFillColor(String str, int i) {
        IPolygonDelegate iPolygonDelegate = this.f24561a;
        if (iPolygonDelegate != null) {
            iPolygonDelegate.polygon_setFillColor(str, i);
        }
    }

    public final void polygon_setGeodesic(String str, boolean z) {
        IPolygonDelegate iPolygonDelegate = this.f24561a;
        if (iPolygonDelegate != null) {
            iPolygonDelegate.polygon_setGeodesic(str, z);
        }
    }

    public final void polygon_setPoints(String str, List<LatLng> list) {
        IPolygonDelegate iPolygonDelegate = this.f24561a;
        if (iPolygonDelegate != null) {
            iPolygonDelegate.polygon_setPoints(str, list);
        }
    }

    public final void polygon_setStrokeColor(String str, int i) {
        IPolygonDelegate iPolygonDelegate = this.f24561a;
        if (iPolygonDelegate != null) {
            iPolygonDelegate.polygon_setStrokeColor(str, i);
        }
    }

    public final void polygon_setStrokeWidth(String str, float f) {
        IPolygonDelegate iPolygonDelegate = this.f24561a;
        if (iPolygonDelegate != null) {
            iPolygonDelegate.polygon_setStrokeWidth(str, f);
        }
    }

    public final void polygon_setVisible(String str, boolean z) {
        IPolygonDelegate iPolygonDelegate = this.f24561a;
        if (iPolygonDelegate != null) {
            iPolygonDelegate.polygon_setVisible(str, z);
        }
    }

    public final void polygon_setZIndex(String str, float f) {
        IPolygonDelegate iPolygonDelegate = this.f24561a;
        if (iPolygonDelegate != null) {
            iPolygonDelegate.polygon_setZIndex(str, f);
        }
    }

    public final void clearPolygons() {
        IPolygonDelegate iPolygonDelegate = this.f24561a;
        if (iPolygonDelegate != null) {
            iPolygonDelegate.clearPolygons();
        }
    }

    public final void setOptions(String str, PolygonOptions polygonOptions) {
        IPolygonDelegate iPolygonDelegate = this.f24561a;
        if (iPolygonDelegate != null) {
            iPolygonDelegate.setOptions(str, polygonOptions);
        }
    }

    public Rect getBound(String str) {
        IPolygonDelegate iPolygonDelegate = this.f24561a;
        if (iPolygonDelegate != null) {
            return iPolygonDelegate.getBound(str);
        }
        return new Rect();
    }

    public RectF getPixel20Bound(String str, float f) {
        IPolygonDelegate iPolygonDelegate = this.f24561a;
        if (iPolygonDelegate != null) {
            return iPolygonDelegate.getPixel20Bound(str, f);
        }
        return null;
    }

    public void setOnPolygonClickListener(String str, DidiMap.OnPolygonClickListener onPolygonClickListener) {
        IPolygonDelegate iPolygonDelegate = this.f24561a;
        if (iPolygonDelegate != null) {
            iPolygonDelegate.setOnPolygonClickListener(str, onPolygonClickListener);
        }
    }

    public void setClickable(String str, boolean z) {
        IPolygonDelegate iPolygonDelegate = this.f24561a;
        if (iPolygonDelegate != null) {
            iPolygonDelegate.setClickable(str, z);
        }
    }
}
