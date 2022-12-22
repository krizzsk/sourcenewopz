package com.didi.common.map.adapter.emptymapadapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.didi.common.map.MapVendor;
import com.didi.common.map.MapView;
import com.didi.common.map.constant.DiDiMapLanguage;
import com.didi.common.map.internal.IMapDelegate;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.internal.IProjectionDelegate;
import com.didi.common.map.internal.IUiSettingsDelegate;
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

public class EmptyMap implements IMapDelegate {
    private final Context mContext;
    private boolean mIsDegrade;
    private Padding mPadding = new Padding(0, 0, 0, 0);

    public Circle addCircle(CircleOptions circleOptions) throws MapNotExistApiException {
        return null;
    }

    public GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws MapNotExistApiException {
        return null;
    }

    public Line addLine(LineOptions lineOptions) throws MapNotExistApiException {
        return null;
    }

    public Marker addMarker(MarkerOptions markerOptions) throws MapNotExistApiException {
        return null;
    }

    public MaskLayer addMaskLayer(MaskLayerOptions maskLayerOptions) throws MapNotExistApiException {
        return null;
    }

    public void addOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) throws MapNotExistApiException {
    }

    public void addOnCircleClickListener(OnCircleClickListener onCircleClickListener) {
    }

    public void addOnGroundOverlayClickListener(OnGroundOverlayClickListener onGroundOverlayClickListener) {
    }

    public void addOnLineClickListener(OnLineClickListener onLineClickListener) {
    }

    public void addOnMapClickListener(OnMapClickListener onMapClickListener) throws MapNotExistApiException {
    }

    public void addOnMapGestureListener(OnMapGestureListener onMapGestureListener) throws MapNotExistApiException {
    }

    public void addOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) throws MapNotExistApiException {
    }

    public void addOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) throws MapNotExistApiException {
    }

    public void addOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
    }

    public void addOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
    }

    public void addOnPolygonClickListener(OnPolygonClickListener onPolygonClickListener) {
    }

    public Polygon addPolygon(PolygonOptions polygonOptions) throws MapNotExistApiException {
        return null;
    }

    public void animateCamera(CameraUpdate cameraUpdate) throws MapNotExistApiException {
    }

    public void animateCameraWithCallback(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) throws MapNotExistApiException {
    }

    public void animateCameraWithDurationAndCallback(CameraUpdate cameraUpdate, int i, CancelableCallback cancelableCallback) throws MapNotExistApiException {
    }

    public float calculateZoomToSpanLevel(int i, int i2, int i3, int i4, LatLng latLng, LatLng latLng2, LatLng latLng3) throws MapNotExistApiException {
        return 0.0f;
    }

    public float calculateZoomToSpanLevel(LatLng latLng, LatLng latLng2) throws MapNotExistApiException {
        return 0.0f;
    }

    public void captureMapView(OnCaptureMapViewListener onCaptureMapViewListener, Bitmap.Config config) throws MapNotExistApiException {
    }

    public void clear() throws MapNotExistApiException {
    }

    public CameraPosition getCameraPosition() throws MapNotExistApiException {
        return null;
    }

    public int getMapType() throws MapNotExistApiException {
        return 0;
    }

    public double getMaxZoomLevel() throws MapNotExistApiException {
        return 0.0d;
    }

    public double getMinZoomLevel() throws MapNotExistApiException {
        return 0.0d;
    }

    public Location getMyLocation() throws MapNotExistApiException {
        return null;
    }

    public IProjectionDelegate getProjectionDelegate() throws MapNotExistApiException {
        return null;
    }

    public IUiSettingsDelegate getUiSettingsDelegate() throws MapNotExistApiException {
        return null;
    }

    public Object getVendorMap() {
        return null;
    }

    public boolean isBuildingsEnabled() throws MapNotExistApiException {
        return false;
    }

    public boolean isIndoorEnabled() throws MapNotExistApiException {
        return false;
    }

    public boolean isMyLocationEnabled() throws MapNotExistApiException {
        return false;
    }

    public boolean isTrafficEnabled() throws MapNotExistApiException {
        return false;
    }

    public void moveCamera(CameraUpdate cameraUpdate) throws MapNotExistApiException {
    }

    public void onCreate(Bundle bundle) throws MapNotExistApiException {
    }

    public void onDestroy() throws MapNotExistApiException {
    }

    public void onLowMemory() throws MapNotExistApiException {
    }

    public void onPause() throws MapNotExistApiException {
    }

    public void onResume() throws MapNotExistApiException {
    }

    public void onSaveInstanceState(Bundle bundle) throws MapNotExistApiException {
    }

    public void onStart() throws MapNotExistApiException {
    }

    public void onStop() throws MapNotExistApiException {
    }

    public void remove(IMapElement iMapElement) {
    }

    public void removeOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) throws MapNotExistApiException {
    }

    public void removeOnCircleClickListener(OnCircleClickListener onCircleClickListener) {
    }

    public void removeOnGroundOverlayClickListener(OnGroundOverlayClickListener onGroundOverlayClickListener) {
    }

    public void removeOnLineClickListener(OnLineClickListener onLineClickListener) {
    }

    public void removeOnMapClickListener(OnMapClickListener onMapClickListener) throws MapNotExistApiException {
    }

    public void removeOnMapGestureListener(OnMapGestureListener onMapGestureListener) throws MapNotExistApiException {
    }

    public void removeOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) throws MapNotExistApiException {
    }

    public void removeOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) throws MapNotExistApiException {
    }

    public void removeOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
    }

    public void removeOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
    }

    public void removeOnPolygonClickListener(OnPolygonClickListener onPolygonClickListener) {
    }

    public void setBuildingsEnabled(boolean z) throws MapNotExistApiException {
    }

    public boolean setIndoorEnabled(boolean z) throws MapNotExistApiException {
        return false;
    }

    public void setLanguage(DiDiMapLanguage diDiMapLanguage) throws MapNotExistApiException {
    }

    public boolean setMapStyle(int i) {
        return false;
    }

    public boolean setMapStyle(String str) {
        return false;
    }

    public void setMapType(int i) throws MapNotExistApiException {
    }

    public void setMaxZoomLevel(float f) {
    }

    public void setMyLocationEnabled(boolean z) throws MapNotExistApiException {
    }

    public void setRotateAngle(float f) {
    }

    public void setTrafficEnabled(boolean z) throws MapNotExistApiException {
    }

    public void stopAnimation() throws MapNotExistApiException {
    }

    public void updateIsNight(boolean z) {
    }

    public EmptyMap(Context context, boolean z) {
        this.mIsDegrade = z;
        this.mContext = context.getApplicationContext();
    }

    public boolean IsDegrade() {
        return this.mIsDegrade;
    }

    public View getView() throws MapNotExistApiException {
        return new View(this.mContext);
    }

    public DiDiMapLanguage getLanguage() throws MapNotExistApiException {
        return DiDiMapLanguage.LAN_ENGLISH;
    }

    public void setPadding(int i, int i2, int i3, int i4) throws MapNotExistApiException {
        this.mPadding.left = i;
        this.mPadding.right = i3;
        this.mPadding.top = i2;
        this.mPadding.bottom = i4;
    }

    public Padding getPadding() {
        return this.mPadding;
    }

    public void getMapAsync(MapView.InnerMapReadyCallBack innerMapReadyCallBack) {
        innerMapReadyCallBack.onMapReady();
    }

    public MapVendor getMapVendor() {
        return MapVendor.Empty;
    }
}
