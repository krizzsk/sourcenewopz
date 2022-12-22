package com.didi.map.alpha.maps.internal;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.didi.map.base.RouteSectionWithName;
import com.didi.map.core.point.GeoPoint;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.Polyline;
import com.didi.map.outer.model.PolylineOptions;
import com.didi.map.outer.model.animation.Animation;
import java.util.List;

public interface IPolylineDelegate {
    Polyline addPolyline(PolylineOptions polylineOptions, PolylineControl polylineControl);

    void addRouteName(String str, List<RouteSectionWithName> list);

    void addViolationParkingSection(String str, int i, int i2, float f, int i3, float f2);

    void clearPolylines();

    void deleteRouteName(long j);

    void flashViolationParkingSection(String str, int i, boolean z);

    Rect getBound(String str);

    Rect getNaviRouteLineVisibleRect(String str);

    Rect getNaviRouteLineVisibleRect(String str, int i);

    GeoPoint getTrueInsertPoint(String str);

    void insertPoint(String str, int i, LatLng latLng, int i2);

    void polyline_addTurnArrow(String str, int i, int i2, int i3);

    void polyline_addTurnArrow(String str, int i, int i2, int i3, int i4);

    void polyline_cleanTurnArrow(String str);

    int[][] polyline_getColors(String str);

    void polyline_remove(String str);

    void polyline_setAboveMaskLayer(String str, boolean z);

    void polyline_setAlpha(String str, float f);

    void polyline_setArrow(String str, boolean z);

    void polyline_setColor(String str, int i);

    void polyline_setColors(String str, int[] iArr, int[] iArr2);

    void polyline_setCustomColor(String str, int i);

    void polyline_setCustomerColorTexture(String str, String str2, String str3, int i);

    void polyline_setGeodesic(String str, boolean z);

    void polyline_setLineCap(String str, boolean z);

    void polyline_setOriginPoints(String str, List<LatLng> list);

    void polyline_setPercent(String str, float f);

    void polyline_setPoints(String str, List<LatLng> list);

    void polyline_setPoints(String str, List<LatLng> list, int[] iArr, int[] iArr2);

    void polyline_setPoints(String str, LatLng[] latLngArr, int[] iArr, int[] iArr2);

    void polyline_setPulseBitmap(String str, Bitmap bitmap);

    void polyline_setPulseCustomColor(String str, int i);

    void polyline_setPulsePercent(String str, float f);

    void polyline_setVisible(String str, boolean z);

    void polyline_setWidth(String str, float f);

    void polyline_setZIndex(String str, float f);

    LatLng queryViolationParkingIconPosition(String str, int i, int i2, LatLng latLng);

    void removeViolationParkingSection(String str, int i);

    void setAlpha(String str, float f);

    void setBoTrafficUpdate(String str, boolean z);

    void setNaviRouteLineErase(String str, boolean z);

    void setOnPolylineClickListener(String str, DidiMap.OnPolylineClickListener onPolylineClickListener);

    void setPolylineOptions(String str, PolylineOptions polylineOptions);

    void setRouteId(String str, long j);

    void startAnimation(String str, Animation animation);
}
