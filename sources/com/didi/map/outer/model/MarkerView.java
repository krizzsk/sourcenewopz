package com.didi.map.outer.model;

import android.graphics.Rect;
import android.graphics.RectF;
import com.didi.map.alpha.maps.internal.MarkerViewControl;

public class MarkerView implements IMapElement {

    /* renamed from: a */
    private final MarkerViewControl f27984a;

    /* renamed from: b */
    private Object f27985b;

    public Rect getBound() {
        return null;
    }

    public RectF getPixel20Bound(float f) {
        return null;
    }

    public MarkerView(MarkerViewControl markerViewControl, Object obj) {
        this.f27984a = markerViewControl;
        this.f27985b = obj;
    }

    public void remove() {
        this.f27984a.remove(this, this.f27985b);
        this.f27985b = null;
    }

    public void setCenter(LatLng latLng) {
        this.f27984a.setCenter(this, this.f27985b, latLng);
    }
}
