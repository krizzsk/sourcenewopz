package com.didi.map.alpha.maps.internal;

import android.graphics.Rect;
import android.graphics.RectF;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.Polygon;
import com.didi.map.outer.model.PolygonOptions;
import java.util.List;

public interface IPolygonDelegate {
    Polygon addPolygon(PolygonOptions polygonOptions, PolygonControl polygonControl);

    void clearPolygons();

    Rect getBound(String str);

    RectF getPixel20Bound(String str, float f);

    void polygon_remove(String str);

    void polygon_setFillColor(String str, int i);

    void polygon_setGeodesic(String str, boolean z);

    void polygon_setPoints(String str, List<LatLng> list);

    void polygon_setStrokeColor(String str, int i);

    void polygon_setStrokeWidth(String str, float f);

    void polygon_setVisible(String str, boolean z);

    void polygon_setZIndex(String str, float f);

    void setBellowRoute(String str, boolean z);

    void setClickable(String str, boolean z);

    void setOnPolygonClickListener(String str, DidiMap.OnPolygonClickListener onPolygonClickListener);

    void setOptions(String str, PolygonOptions polygonOptions);
}
