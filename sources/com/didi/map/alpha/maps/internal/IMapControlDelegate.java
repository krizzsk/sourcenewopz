package com.didi.map.alpha.maps.internal;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import com.didi.map.base.TrafficEventRoutePoint;
import com.didi.map.core.base.impl.OnMapModeListener;
import com.didi.map.outer.map.CameraUpdate;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.model.CameraPosition;
import com.didi.map.outer.model.IMapElement;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;
import com.didi.map.outer.model.MapAllGestureListener;
import com.didi.map.outer.model.MapGestureListener;
import java.util.List;

public interface IMapControlDelegate {
    void addMapAllGestureListener(MapAllGestureListener mapAllGestureListener);

    void addMapGestureListener(MapGestureListener mapGestureListener);

    void addModeListener(OnMapModeListener onMapModeListener);

    void addOnMapClickListener(DidiMap.OnMapClickListener onMapClickListener);

    void animateCamera(CameraUpdate cameraUpdate, long j, DidiMap.CancelableCallback cancelableCallback);

    void animateToNaviPosition(LatLng latLng, float f, float f2, float f3, float f4, boolean z, boolean z2);

    void animateToNaviPosition(LatLng latLng, float f, float f2, float f3, boolean z);

    void animateToNaviPosition(LatLng latLng, float f, float f2, boolean z);

    void animateToNaviPosition2(LatLng latLng, float f, float f2, float f3, boolean z);

    float calNaviLevel(LatLngBounds latLngBounds, float f, int i, boolean z);

    float calNaviLevel2(LatLng latLng, LatLng latLng2, float f, float f2, int i, int i2, boolean z);

    float calNaviLevel3(LatLng latLng, LatLng latLng2, float f, float f2, int i, int i2, boolean z, float f3);

    CameraPosition calculateZoomToSpanLevel(List<IMapElement> list, List<LatLng> list2, int i, int i2, int i3, int i4);

    CameraPosition calculateZoomToSpanLevel(List<IMapElement> list, List<LatLng> list2, int i, int i2, int i3, int i4, LatLng latLng);

    float calcuteZoomToSpanLevel(int i, int i2, int i3, int i4, LatLng latLng, LatLng latLng2, LatLng latLng3);

    void clearAll();

    void clearOnMapClickListener();

    void clearRouteNameSegments();

    void clearTrafficEventData();

    CameraPosition getCameraPosition();

    String getCityName(LatLng latLng);

    List<Rect> getElementScreenBound(List<String> list);

    int getMapType();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    LatLng getRouteArrowFurthestPoint();

    void getScreenShot(Handler handler, Bitmap.Config config);

    List<TrafficEventRoutePoint> getTrafficEventRoutePointInfo();

    String getVersion();

    float getZoomToSpanLevel(LatLng latLng, LatLng latLng2);

    void hibernate();

    void hideTrafficEventExcludeClosure(boolean z);

    void moveCamera(CameraUpdate cameraUpdate);

    void onDestroy();

    void onPause();

    void onRestart();

    void onResume();

    void onStart();

    void onStop();

    void removeMapAllGestureListener(MapAllGestureListener mapAllGestureListener);

    void removeMapGestureListener(MapGestureListener mapGestureListener);

    void removeOnMapClickListener(DidiMap.OnMapClickListener onMapClickListener);

    void setClipArea(int i, int i2, int i3);

    void setCompassExtraPadding(int i);

    void setCompassExtraPadding(int i, int i2);

    void setDisplayFishBoneGrayBubbleOnly(boolean z);

    void setFps(int i);

    void setFpsMode(int i);

    void setInfoWindowStillVisible(boolean z);

    void setMapScreenCenterProportion(float f, float f2, boolean z);

    void setMapType();

    void setNaviFixingProportion(float f, float f2);

    void setNaviFixingProportion2D(float f, float f2);

    void setNaviOnMapClickListener(DidiMap.OnMapClickListener onMapClickListener);

    void setNaviOnPolylineClickListener(DidiMap.OnPolylineClickListener onPolylineClickListener);

    void setOnCameraChangeListener(DidiMap.OnCameraChangeListener onCameraChangeListener);

    void setOnCompassClickedListener(DidiMap.OnCompassClickedListener onCompassClickedListener);

    void setOnLableMarkerCallback(DidiMap.OnLableMarkerCallback onLableMarkerCallback);

    void setOnMapClickListener(DidiMap.OnMapClickListener onMapClickListener);

    void setOnMapLoadedCallback(DidiMap.OnMapLoadedCallback onMapLoadedCallback);

    void setOnMapLongClickListener(DidiMap.OnMapLongClickListener onMapLongClickListener);

    void setRouteNameVisible(boolean z);

    void setSatelliteEnabled(boolean z);

    void setTrafficEnabled(boolean z);

    void setTrafficEventData(byte[] bArr);

    void setVecEnlargeVisibleArea(int i, int i2, int i3, int i4, float f);

    void setZhongYanEventData(byte[] bArr, long j);

    void showTrafficEvent(boolean z);

    void stopAnimation();

    void updateTrafficItemState(long j, int i, boolean z);

    void zoomToSpan(LatLng latLng, LatLng latLng2, float f);
}
