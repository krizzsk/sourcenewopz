package com.didi.map.alpha.maps.internal;

import android.graphics.Rect;
import android.graphics.RectF;
import com.didi.map.outer.model.Circle;
import com.didi.map.outer.model.CircleOptions;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;

public interface ICircleDelegate {
    Circle addCircle(CircleOptions circleOptions, CircleControl circleControl);

    void circle_remove(String str);

    void circle_setCenter(String str, LatLng latLng);

    void circle_setFillColor(String str, int i);

    void circle_setRadius(String str, double d);

    void circle_setStrokeColor(String str, int i);

    void circle_setStrokeWidth(String str, float f);

    void circle_setVisible(String str, boolean z);

    void circle_setZIndex(String str, float f);

    void clearCircles();

    Rect getBound(String str);

    LatLngBounds getBounds(LatLng latLng, double d);

    RectF getPixel20Bound(String str, float f);

    void setOptions(String str, CircleOptions circleOptions);
}
