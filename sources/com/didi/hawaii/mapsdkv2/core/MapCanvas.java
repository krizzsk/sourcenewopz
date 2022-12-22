package com.didi.hawaii.mapsdkv2.core;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.didi.hawaii.mapsdkv2.jni.HWBSManager;
import com.didi.hawaii.mapsdkv2.jni.HWBSRAManager;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;

public interface MapCanvas {

    public interface TileCallback {
        Bitmap onLoadTile(int i, int i2, int i3);
    }

    int addCircle(LatLng latLng, float f, int i, int i2, boolean z, boolean z2, float f2, boolean z3);

    int addMarker(double d, double d2, String str, float f, float f2, float f3, float f4, float f5, float f6, int i, int i2, float f7, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3, float f8, boolean z7, boolean z8, LatLngBounds latLngBounds, boolean z9);

    int addMaskLayer(int i, int i2, int i3, int i4);

    int addPolygon(LatLng[] latLngArr, int i, int i2, float f, boolean z, boolean z2);

    int addPolyline(LatLng[] latLngArr, int i, float f, int i2, float f2, boolean z, boolean z2);

    int addRoute(LatLng[] latLngArr, int[] iArr, int[] iArr2, String str, float f, int i, float f2, boolean z, boolean z2, int i2, long j, boolean z3, HWBSRAManager hWBSRAManager, boolean z4);

    void addRouteNames(int i, long j, RouteName[] routeNameArr, LatLng[] latLngArr, boolean z);

    int addTile(TileCallback tileCallback);

    void addViolationParkingSection(int i, int i2, int i3, float f, int i4, float f2);

    void attachMapEngine(HWBSManager hWBSManager);

    LatLngBounds calculateLocatorGeoBound(int i);

    void calculateLocatorScreenBound(int i, float[] fArr);

    LatLngBounds calculateMarkerGeoBound(int i);

    void calculateMarkerScreenBound(int i, float[] fArr);

    void clearRouteNames(long j);

    int drawBezierCurve(double[] dArr, int[] iArr, float f, float f2, float f3);

    void flashViolationParkingSection(int i, int i2, boolean z);

    LatLng fromScreenLocation(float f, float f2);

    LatLng fromScreenLocationUnsafe(float f, float f2);

    boolean getBubbleRealVisible(long j);

    int getLocatorId();

    void getMapRouteTrueClearPoint_Wrap(int i, LatLng latLng);

    LatLng queryViolationParkingIconPosition(int i, int i2, int i3, LatLng latLng);

    void reloadTile(int i);

    void removeCircle(int i);

    void removeMarker(int i);

    void removeMaskLayer(int i);

    void removePolygon(int i);

    void removePolyline(int i);

    void removeRoute(int i);

    void removeTile(int i);

    void removeViolationParkingSection(int i, int i2);

    void setBellowRoute(int i, boolean z);

    void setBubblePosition(long j, LatLng latLng);

    void setBubbleVisible(long j, boolean z);

    void setCircleCenter(int i, LatLng latLng);

    void setCircleColor(int i, int i2);

    void setCircleRingWidth(int i, float f);

    void setCircleScale(int i, float f);

    void setCircleVisible(int i, boolean z);

    void setLocatorAccuracyVisible(boolean z);

    void setLocatorCarImage(String str, float f, float f2);

    void setLocatorCarVisible(boolean z);

    void setLocatorCompassImage(String str, String str2, String str3, String str4, String str5, float f, float f2);

    void setLocatorCompassVisible(boolean z);

    void setLocatorDestination(LatLng latLng);

    Camera setLocatorFollow(boolean z, boolean z2, boolean z3, boolean z4);

    void setLocatorInfo(LatLng latLng, float f, float f2, float f3, boolean z, boolean z2);

    void setLocatorInfoWithSkewAndScale(LatLng latLng, float f, float f2, float f3, float f4, float f5, boolean z, boolean z2);

    void setLocatorVisible(boolean z);

    void setLocatorZIndex(int i);

    boolean setMJOLocatorInfo(LatLng latLng, int i, int i2, long j, long j2);

    void setMarkerAlpha(int i, float f);

    void setMarkerIconAndAnchor(int i, String str, float f, float f2);

    void setMarkerOffset(int i, float f, float f2);

    void setMarkerPosition(int i, LatLng latLng);

    void setMarkerRotateAngle(int i, float f);

    void setMarkerScale(int i, float f, float f2);

    LatLng setMarkerScreenPosition(int i, Point point);

    void setMarkerVisible(int i, boolean z);

    void setMaskLayerAlpha(int i, float f);

    void setMaskLayerVisible(int i, boolean z);

    void setMaskLayerWidthHeightColor(int i, int i2, int i3, int i4);

    void setPolygonAlpha(int i, float f);

    void setPolygonColor(int i, int i2);

    void setPolygonVisible(int i, boolean z);

    void setPolylineAlpha(int i, float f);

    void setPolylineArrowTextureName(int i, String str);

    void setPolylineColor(int i, int i2);

    void setPolylinePoints(int i, LatLng[] latLngArr);

    void setPolylineVisible(int i, boolean z);

    void setPolylineWidth(int i, float f);

    void setRouteAlpha(int i, float f);

    void setRouteArrow(int i, boolean z);

    void setRouteClearPointErase(int i, int i2, LatLng latLng, long j, boolean z);

    void setRouteClearPointGrey(int i, int i2, LatLng latLng, long j, boolean z);

    void setRouteColors(int i, int[] iArr, int[] iArr2);

    void setRouteDrawCap(int i, boolean z);

    void setRouteNameKey(int i, long j, boolean z);

    void setRoutePercent(int i, float f);

    void setRoutePercent(int i, String str, float f, HWBSRAManager hWBSRAManager);

    void setRoutePoints(int i, LatLng[] latLngArr, int[] iArr, int[] iArr2, String str);

    void setRoutePulseCustomColor(int i, int i2);

    void setRoutePulseTexture(int i, String str);

    void setRouteTexture(int i, String str);

    void setRouteTurnArrow(int i, int i2, int i3, int i4);

    void setRouteTurnArrow(int i, int i2, int i3, int i4, int i5);

    void setRouteVisible(int i, boolean z);

    void setRouteWidth(int i, float f);

    void setZIndex(int i, int i2);

    void showLocatorGuideLine(boolean z, LatLng latLng);

    float[] toScreenLocation(LatLng latLng);

    float[] toScreenLocationUnsafe(LatLng latLng);

    void updateBezierCurve(int i, float f);

    void updateCircle(int i, LatLng latLng, float f, int i2, int i3, boolean z, boolean z2, float f2);

    void updateMarker(int i, double d, double d2, String str, float f, float f2, float f3, float f4, float f5, float f6, int i2, int i3, float f7, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i4, float f8, boolean z7, LatLngBounds latLngBounds, boolean z8);

    void updatePolygon(int i, LatLng[] latLngArr, int i2, int i3, float f, boolean z);

    void updatePolyline(int i, LatLng[] latLngArr, int i2, float f, int i3, float f2, boolean z);
}
