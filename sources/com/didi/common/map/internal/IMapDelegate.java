package com.didi.common.map.internal;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.didi.common.map.MapVendor;
import com.didi.common.map.MapView;
import com.didi.common.map.constant.DiDiMapLanguage;
import com.didi.common.map.listener.CancelableCallback;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnCaptureMapViewListener;
import com.didi.common.map.listener.OnCircleClickListener;
import com.didi.common.map.listener.OnGroundOverlayClickListener;
import com.didi.common.map.listener.OnLineClickListener;
import com.didi.common.map.listener.OnMapClickListener;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.listener.OnMapLoadedCallback;
import com.didi.common.map.listener.OnMapLongClickListener;
import com.didi.common.map.listener.OnMarkerClickListener;
import com.didi.common.map.listener.OnMarkerDragListener;
import com.didi.common.map.listener.OnPolygonClickListener;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.CameraUpdate;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.CircleOptions;
import com.didi.common.map.model.GroundOverlay;
import com.didi.common.map.model.GroundOverlayOptions;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.model.MaskLayer;
import com.didi.common.map.model.MaskLayerOptions;
import com.didi.common.map.model.Padding;
import com.didi.common.map.model.Polygon;
import com.didi.common.map.model.PolygonOptions;
import com.didi.common.map.model.throwable.MapNotExistApiException;

public interface IMapDelegate extends IMapInterface {
    boolean IsDegrade();

    Circle addCircle(CircleOptions circleOptions) throws MapNotExistApiException;

    GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws MapNotExistApiException;

    Line addLine(LineOptions lineOptions) throws MapNotExistApiException;

    Marker addMarker(MarkerOptions markerOptions) throws MapNotExistApiException;

    @Deprecated
    MaskLayer addMaskLayer(MaskLayerOptions maskLayerOptions) throws MapNotExistApiException;

    void addOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) throws MapNotExistApiException;

    @Deprecated
    void addOnCircleClickListener(OnCircleClickListener onCircleClickListener);

    @Deprecated
    void addOnGroundOverlayClickListener(OnGroundOverlayClickListener onGroundOverlayClickListener);

    void addOnLineClickListener(OnLineClickListener onLineClickListener);

    void addOnMapClickListener(OnMapClickListener onMapClickListener) throws MapNotExistApiException;

    void addOnMapGestureListener(OnMapGestureListener onMapGestureListener) throws MapNotExistApiException;

    void addOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) throws MapNotExistApiException;

    void addOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) throws MapNotExistApiException;

    void addOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener);

    void addOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener);

    @Deprecated
    void addOnPolygonClickListener(OnPolygonClickListener onPolygonClickListener);

    Polygon addPolygon(PolygonOptions polygonOptions) throws MapNotExistApiException;

    void animateCamera(CameraUpdate cameraUpdate) throws MapNotExistApiException;

    void animateCameraWithCallback(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) throws MapNotExistApiException;

    void animateCameraWithDurationAndCallback(CameraUpdate cameraUpdate, int i, CancelableCallback cancelableCallback) throws MapNotExistApiException;

    float calculateZoomToSpanLevel(int i, int i2, int i3, int i4, LatLng latLng, LatLng latLng2, LatLng latLng3) throws MapNotExistApiException;

    float calculateZoomToSpanLevel(LatLng latLng, LatLng latLng2) throws MapNotExistApiException;

    void captureMapView(OnCaptureMapViewListener onCaptureMapViewListener, Bitmap.Config config) throws MapNotExistApiException;

    void clear() throws MapNotExistApiException;

    CameraPosition getCameraPosition() throws MapNotExistApiException;

    DiDiMapLanguage getLanguage() throws MapNotExistApiException;

    void getMapAsync(MapView.InnerMapReadyCallBack innerMapReadyCallBack);

    int getMapType() throws MapNotExistApiException;

    MapVendor getMapVendor();

    double getMaxZoomLevel() throws MapNotExistApiException;

    double getMinZoomLevel() throws MapNotExistApiException;

    @Deprecated
    Location getMyLocation() throws MapNotExistApiException;

    Padding getPadding();

    IProjectionDelegate getProjectionDelegate() throws MapNotExistApiException;

    IUiSettingsDelegate getUiSettingsDelegate() throws MapNotExistApiException;

    Object getVendorMap();

    View getView() throws MapNotExistApiException;

    boolean isBuildingsEnabled() throws MapNotExistApiException;

    boolean isIndoorEnabled() throws MapNotExistApiException;

    boolean isMyLocationEnabled() throws MapNotExistApiException;

    boolean isTrafficEnabled() throws MapNotExistApiException;

    void moveCamera(CameraUpdate cameraUpdate) throws MapNotExistApiException;

    void onCreate(Bundle bundle) throws MapNotExistApiException;

    void onDestroy() throws MapNotExistApiException;

    void onLowMemory() throws MapNotExistApiException;

    void onPause() throws MapNotExistApiException;

    void onResume() throws MapNotExistApiException;

    void onSaveInstanceState(Bundle bundle) throws MapNotExistApiException;

    void onStart() throws MapNotExistApiException;

    void onStop() throws MapNotExistApiException;

    void remove(IMapElement iMapElement);

    void removeOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) throws MapNotExistApiException;

    void removeOnCircleClickListener(OnCircleClickListener onCircleClickListener);

    void removeOnGroundOverlayClickListener(OnGroundOverlayClickListener onGroundOverlayClickListener);

    void removeOnLineClickListener(OnLineClickListener onLineClickListener);

    void removeOnMapClickListener(OnMapClickListener onMapClickListener) throws MapNotExistApiException;

    void removeOnMapGestureListener(OnMapGestureListener onMapGestureListener) throws MapNotExistApiException;

    void removeOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) throws MapNotExistApiException;

    void removeOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) throws MapNotExistApiException;

    void removeOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener);

    void removeOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener);

    void removeOnPolygonClickListener(OnPolygonClickListener onPolygonClickListener);

    void setBuildingsEnabled(boolean z) throws MapNotExistApiException;

    boolean setIndoorEnabled(boolean z) throws MapNotExistApiException;

    void setLanguage(DiDiMapLanguage diDiMapLanguage) throws MapNotExistApiException;

    boolean setMapStyle(int i);

    boolean setMapStyle(String str);

    void setMapType(int i) throws MapNotExistApiException;

    void setMaxZoomLevel(float f);

    void setMyLocationEnabled(boolean z) throws MapNotExistApiException;

    void setPadding(int i, int i2, int i3, int i4) throws MapNotExistApiException;

    void setRotateAngle(float f);

    void setTrafficEnabled(boolean z) throws MapNotExistApiException;

    void stopAnimation() throws MapNotExistApiException;

    void updateIsNight(boolean z);
}
