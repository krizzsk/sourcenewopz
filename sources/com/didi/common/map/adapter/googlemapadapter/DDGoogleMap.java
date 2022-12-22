package com.didi.common.map.adapter.googlemapadapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.didi.common.map.MapVendor;
import com.didi.common.map.MapView;
import com.didi.common.map.adapter.googlemapadapter.CustomView.GoogleMapViewWrapper;
import com.didi.common.map.adapter.googlemapadapter.converter.Converter;
import com.didi.common.map.adapter.googlemapadapter.util.SystemUtil;
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
import com.didi.common.map.model.CameraUpdateFactory;
import com.didi.common.map.model.CircleOptions;
import com.didi.common.map.model.GroundOverlayOptions;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.model.MaskLayer;
import com.didi.common.map.model.MaskLayerOptions;
import com.didi.common.map.model.Padding;
import com.didi.common.map.model.PolygonOptions;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.didi.common.map.util.DLog;
import com.didi.map.sdk.navtracker.Tracker;
import com.didi.map.sdk.navtracker.TrackerMapInfo;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class DDGoogleMap implements IMapDelegate {
    public static final float MAX_ZOOM = 21.0f;
    private static final String TAG = "DDGoogleMap";
    private Context mContext;
    /* access modifiers changed from: private */
    public ImageView mGoogleLogo;
    /* access modifiers changed from: private */
    public GoogleMapViewWrapper mGoogleMapViewWrapper;
    private GoogleMap.OnMarkerClickListener mGoogleMarkerClickListener = new GoogleMap.OnMarkerClickListener() {
        public boolean onMarkerClick(Marker marker) {
            com.didi.common.map.model.Marker access$000 = DDGoogleMap.this.getCommonMarkerByGoogleMarker(marker);
            if (access$000 == null || DDGoogleMap.this.mOnMarkerClickListeners == null || DDGoogleMap.this.mOnMarkerClickListeners.isEmpty()) {
                return true;
            }
            Iterator it = DDGoogleMap.this.mOnMarkerClickListeners.iterator();
            while (it.hasNext()) {
                ((OnMarkerClickListener) it.next()).onMarkerClick(access$000);
            }
            return true;
        }
    };
    private GoogleMap.OnMarkerDragListener mGoogleMarkerDragListener = new GoogleMap.OnMarkerDragListener() {
        public void onMarkerDragStart(Marker marker) {
            com.didi.common.map.model.Marker access$000 = DDGoogleMap.this.getCommonMarkerByGoogleMarker(marker);
            if (access$000 != null && DDGoogleMap.this.mOnMarkerDragListeners != null && !DDGoogleMap.this.mOnMarkerDragListeners.isEmpty()) {
                Iterator it = DDGoogleMap.this.mOnMarkerDragListeners.iterator();
                while (it.hasNext()) {
                    ((OnMarkerDragListener) it.next()).onMarkerDragStart(access$000);
                }
            }
        }

        public void onMarkerDrag(Marker marker) {
            com.didi.common.map.model.Marker access$000 = DDGoogleMap.this.getCommonMarkerByGoogleMarker(marker);
            if (access$000 != null && DDGoogleMap.this.mOnMarkerDragListeners != null && !DDGoogleMap.this.mOnMarkerDragListeners.isEmpty()) {
                Iterator it = DDGoogleMap.this.mOnMarkerDragListeners.iterator();
                while (it.hasNext()) {
                    ((OnMarkerDragListener) it.next()).onMarkerDrag(access$000);
                }
            }
        }

        public void onMarkerDragEnd(Marker marker) {
            com.didi.common.map.model.Marker access$000 = DDGoogleMap.this.getCommonMarkerByGoogleMarker(marker);
            if (access$000 != null && DDGoogleMap.this.mOnMarkerDragListeners != null && !DDGoogleMap.this.mOnMarkerDragListeners.isEmpty()) {
                Iterator it = DDGoogleMap.this.mOnMarkerDragListeners.iterator();
                while (it.hasNext()) {
                    ((OnMarkerDragListener) it.next()).onMarkerDragEnd(access$000);
                }
            }
        }
    };
    private GoogleMap.OnCircleClickListener mGoogleOnCircleClickListener = new GoogleMap.OnCircleClickListener() {
        public void onCircleClick(Circle circle) {
            com.didi.common.map.model.Circle access$700 = DDGoogleMap.this.getCommonCircleByGoogleCircle(circle);
            if (access$700 != null && DDGoogleMap.this.mOnCircleClickListeners != null && !DDGoogleMap.this.mOnCircleClickListeners.isEmpty()) {
                Iterator it = DDGoogleMap.this.mOnCircleClickListeners.iterator();
                while (it.hasNext()) {
                    ((OnCircleClickListener) it.next()).onCircleClick(access$700);
                }
            }
        }
    };
    private GoogleMap.OnGroundOverlayClickListener mGoogleOnGroundOverlayClickListener = new GoogleMap.OnGroundOverlayClickListener() {
        public void onGroundOverlayClick(GroundOverlay groundOverlay) {
            com.didi.common.map.model.GroundOverlay access$500 = DDGoogleMap.this.getCommonGroundOverlayByGoogleGroundOverlay(groundOverlay);
            if (access$500 != null && DDGoogleMap.this.mOnGroundOverlayClickListeners != null && !DDGoogleMap.this.mOnGroundOverlayClickListeners.isEmpty()) {
                Iterator it = DDGoogleMap.this.mOnGroundOverlayClickListeners.iterator();
                while (it.hasNext()) {
                    ((OnGroundOverlayClickListener) it.next()).onGroundOverlayClicked(access$500);
                }
            }
        }
    };
    private GoogleMap.OnMapLoadedCallback mGoogleOnMapLoadedCallback = new GoogleMap.OnMapLoadedCallback() {
        public void onMapLoaded() {
            boolean unused = DDGoogleMap.this.mIsGoogleMapLoaded = true;
            if (DDGoogleMap.this.mOnMapLoadedCallbacks != null && !DDGoogleMap.this.mOnMapLoadedCallbacks.isEmpty()) {
                Iterator it = DDGoogleMap.this.mOnMapLoadedCallbacks.iterator();
                while (it.hasNext()) {
                    ((OnMapLoadedCallback) it.next()).onMapLoaded();
                }
            }
        }
    };
    private GoogleMap.OnPolygonClickListener mGoogleOnPolygonClickListener = new GoogleMap.OnPolygonClickListener() {
        public void onPolygonClick(Polygon polygon) {
            com.didi.common.map.model.Polygon access$300 = DDGoogleMap.this.getCommonPolygonByGooglePolygon(polygon);
            if (access$300 != null && DDGoogleMap.this.mOnPolygonClickListeners != null && !DDGoogleMap.this.mOnPolygonClickListeners.isEmpty()) {
                Iterator it = DDGoogleMap.this.mOnPolygonClickListeners.iterator();
                while (it.hasNext()) {
                    ((OnPolygonClickListener) it.next()).onPolygonClick(access$300);
                }
            }
        }
    };
    private GoogleMap.OnPolylineClickListener mGoogleOnPolylineClickListener = new GoogleMap.OnPolylineClickListener() {
        public void onPolylineClick(Polyline polyline) {
            Line access$900 = DDGoogleMap.this.getCommonLineByGoogleLine(polyline);
            if (access$900 != null && DDGoogleMap.this.mOnLineClickListeners != null && !DDGoogleMap.this.mOnLineClickListeners.isEmpty()) {
                Iterator it = DDGoogleMap.this.mOnLineClickListeners.iterator();
                while (it.hasNext()) {
                    ((OnLineClickListener) it.next()).onLineClick(access$900);
                }
            }
        }
    };
    private boolean mIsDegrade;
    /* access modifiers changed from: private */
    public boolean mIsGoogleMapLoaded;
    /* access modifiers changed from: private */
    public boolean mIsGoogleMapReady;
    /* access modifiers changed from: private */
    public GoogleMap mMap;
    private ConcurrentHashMap<Object, IMapElement> mMapElementMap;
    /* access modifiers changed from: private */
    public MapView mMapView;
    private float mMaxZoom = 21.0f;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<OnCircleClickListener> mOnCircleClickListeners;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<OnGroundOverlayClickListener> mOnGroundOverlayClickListeners;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<OnLineClickListener> mOnLineClickListeners;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<OnMapLoadedCallback> mOnMapLoadedCallbacks;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<OnMarkerClickListener> mOnMarkerClickListeners;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<OnMarkerDragListener> mOnMarkerDragListeners;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<OnPolygonClickListener> mOnPolygonClickListeners;
    private Padding mPadding = new Padding();
    private IProjectionDelegate mProjectionDelegate;
    private IUiSettingsDelegate mUiSettingsDelegate;

    public void updateIsNight(boolean z) {
    }

    public DDGoogleMap(Context context, boolean z) {
        this.mContext = context.getApplicationContext();
        this.mIsDegrade = z;
        GoogleMapViewWrapper googleMapViewWrapper = new GoogleMapViewWrapper(context);
        this.mGoogleMapViewWrapper = googleMapViewWrapper;
        this.mMapView = googleMapViewWrapper.getGoogleMapView();
    }

    public void getMapAsync(final MapView.InnerMapReadyCallBack innerMapReadyCallBack) {
        com.google.android.gms.maps.MapView mapView = this.mMapView;
        if (mapView != null && innerMapReadyCallBack != null) {
            if (this.mIsGoogleMapReady) {
                innerMapReadyCallBack.onMapReady();
            } else {
                mapView.getMapAsync(new OnMapReadyCallback() {
                    public void onMapReady(GoogleMap googleMap) {
                        boolean unused = DDGoogleMap.this.mIsGoogleMapReady = true;
                        DDGoogleMap dDGoogleMap = DDGoogleMap.this;
                        ImageView unused2 = dDGoogleMap.mGoogleLogo = (ImageView) dDGoogleMap.mMapView.findViewWithTag("GoogleWatermark");
                        GoogleMap unused3 = DDGoogleMap.this.mMap = googleMap;
                        if (DDGoogleMap.this.mGoogleMapViewWrapper != null) {
                            DDGoogleMap.this.mGoogleMapViewWrapper.setGoogleMap(DDGoogleMap.this.mMap);
                        }
                        DDGoogleMap.this.initAfterGetMap();
                        innerMapReadyCallBack.onMapReady();
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void initAfterGetMap() {
        GoogleMap googleMap = this.mMap;
        if (googleMap != null) {
            googleMap.setIndoorEnabled(false);
            this.mMap.getUiSettings().setIndoorLevelPickerEnabled(false);
            this.mMap.setBuildingsEnabled(false);
            this.mMap.setMaxZoomPreference(21.0f);
            this.mMapElementMap = new ConcurrentHashMap<>();
            this.mOnMapLoadedCallbacks = new CopyOnWriteArrayList<>();
            this.mOnPolygonClickListeners = new CopyOnWriteArrayList<>();
            this.mOnCircleClickListeners = new CopyOnWriteArrayList<>();
            this.mOnMarkerClickListeners = new CopyOnWriteArrayList<>();
            this.mOnMarkerDragListeners = new CopyOnWriteArrayList<>();
            this.mOnGroundOverlayClickListeners = new CopyOnWriteArrayList<>();
            this.mOnLineClickListeners = new CopyOnWriteArrayList<>();
            this.mMap.setOnMapLoadedCallback(this.mGoogleOnMapLoadedCallback);
            this.mMap.setOnMarkerClickListener(this.mGoogleMarkerClickListener);
            this.mMap.setOnMarkerDragListener(this.mGoogleMarkerDragListener);
            this.mMap.setOnPolygonClickListener(this.mGoogleOnPolygonClickListener);
            this.mMap.setOnGroundOverlayClickListener(this.mGoogleOnGroundOverlayClickListener);
            this.mMap.setOnCircleClickListener(this.mGoogleOnCircleClickListener);
            this.mMap.setOnPolylineClickListener(this.mGoogleOnPolylineClickListener);
        }
    }

    public boolean setMapStyle(int i) {
        GoogleMap googleMap = this.mMap;
        if (googleMap != null) {
            try {
                if (!googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(getContext(), i))) {
                    DLog.m7384d(TAG, "Style parsing failed.", new Object[0]);
                }
            } catch (Resources.NotFoundException e) {
                DLog.m7384d(TAG, "Can't find style. Error: ", e);
            }
        }
        return false;
    }

    public boolean setMapStyle(String str) {
        GoogleMap googleMap;
        if (!TextUtils.isEmpty(str) && (googleMap = this.mMap) != null) {
            try {
                if (!googleMap.setMapStyle(new MapStyleOptions(str))) {
                    DLog.m7384d(TAG, "Style parsing failed.", new Object[0]);
                }
            } catch (Resources.NotFoundException e) {
                DLog.m7384d(TAG, "Can't find style. Error: ", e);
            }
        }
        return false;
    }

    public com.didi.common.map.model.GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws MapNotExistApiException {
        com.google.android.gms.maps.model.GroundOverlayOptions groundOverlayOptions2;
        if (groundOverlayOptions == null || this.mMapElementMap == null || this.mMap == null) {
            return null;
        }
        try {
            groundOverlayOptions2 = Converter.convertToGoogleGroundOverlayOptions(groundOverlayOptions);
        } catch (Exception e) {
            DLog.m7384d(TAG, "add overlay exc:" + e.getMessage(), new Object[0]);
            groundOverlayOptions2 = null;
        }
        if (groundOverlayOptions2 == null) {
            return null;
        }
        GroundOverlay addGroundOverlay = this.mMap.addGroundOverlay(groundOverlayOptions2);
        com.didi.common.map.model.GroundOverlay groundOverlay = new com.didi.common.map.model.GroundOverlay(new GroundOverlayDelegate(addGroundOverlay, groundOverlayOptions));
        this.mMapElementMap.put(addGroundOverlay, groundOverlay);
        return groundOverlay;
    }

    public void remove(IMapElement iMapElement) {
        ConcurrentHashMap<Object, IMapElement> concurrentHashMap = this.mMapElementMap;
        if (concurrentHashMap != null && concurrentHashMap.containsValue(iMapElement)) {
            for (Map.Entry next : this.mMapElementMap.entrySet()) {
                IMapElement iMapElement2 = (IMapElement) next.getValue();
                Object key = next.getKey();
                if (iMapElement2 == iMapElement && key != null) {
                    this.mMapElementMap.remove(key);
                }
            }
        }
    }

    public void setMaxZoomLevel(float f) {
        this.mMaxZoom = f;
        if (f > 21.0f) {
            this.mMaxZoom = 21.0f;
        }
        GoogleMap googleMap = this.mMap;
        if (googleMap != null) {
            googleMap.setMaxZoomPreference(this.mMaxZoom);
        }
    }

    public MapVendor getMapVendor() {
        return MapVendor.GOOGLE;
    }

    public View getView() throws MapNotExistApiException {
        return this.mGoogleMapViewWrapper;
    }

    public IUiSettingsDelegate getUiSettingsDelegate() throws MapNotExistApiException {
        GoogleMap googleMap = this.mMap;
        if (googleMap == null) {
            return null;
        }
        if (this.mUiSettingsDelegate == null) {
            this.mUiSettingsDelegate = new UiSettingsDelegate(googleMap, this.mGoogleLogo);
        }
        return this.mUiSettingsDelegate;
    }

    public IProjectionDelegate getProjectionDelegate() throws MapNotExistApiException {
        Context context;
        GoogleMap googleMap = this.mMap;
        if (googleMap == null) {
            return null;
        }
        if (this.mProjectionDelegate == null && (context = this.mContext) != null) {
            this.mProjectionDelegate = new ProjectionDelegate(googleMap, context.getApplicationContext());
        }
        return this.mProjectionDelegate;
    }

    public int getMapType() throws MapNotExistApiException {
        GoogleMap googleMap = this.mMap;
        if (googleMap == null) {
            return Integer.MIN_VALUE;
        }
        return googleMap.getMapType();
    }

    public void setMapType(int i) throws MapNotExistApiException {
        GoogleMap googleMap = this.mMap;
        if (googleMap != null) {
            googleMap.setMapType(i);
        }
    }

    public DiDiMapLanguage getLanguage() throws MapNotExistApiException {
        DLog.m7384d(TAG, "Not Support getLanguage()", new Object[0]);
        return null;
    }

    public void setLanguage(DiDiMapLanguage diDiMapLanguage) throws MapNotExistApiException {
        DLog.m7384d(TAG, "Not Support setLanguage()", new Object[0]);
    }

    public CameraPosition getCameraPosition() throws MapNotExistApiException {
        GoogleMap googleMap = this.mMap;
        if (googleMap == null) {
            return null;
        }
        return Converter.convertFromGoogleCameraPosition(googleMap.getCameraPosition());
    }

    public double getMaxZoomLevel() throws MapNotExistApiException {
        GoogleMap googleMap = this.mMap;
        if (googleMap == null) {
            return Double.MIN_VALUE;
        }
        return (double) googleMap.getMaxZoomLevel();
    }

    public double getMinZoomLevel() throws MapNotExistApiException {
        GoogleMap googleMap = this.mMap;
        if (googleMap == null) {
            return Double.MIN_VALUE;
        }
        return (double) googleMap.getMinZoomLevel();
    }

    public void captureMapView(final OnCaptureMapViewListener onCaptureMapViewListener, Bitmap.Config config) throws MapNotExistApiException {
        GoogleMap googleMap = this.mMap;
        if (googleMap != null && onCaptureMapViewListener != null) {
            googleMap.snapshot(new GoogleMap.SnapshotReadyCallback() {
                public void onSnapshotReady(Bitmap bitmap) {
                    OnCaptureMapViewListener onCaptureMapViewListener = onCaptureMapViewListener;
                    if (onCaptureMapViewListener != null) {
                        onCaptureMapViewListener.onCaptureFinish(bitmap);
                    }
                }
            });
        }
    }

    public boolean isBuildingsEnabled() throws MapNotExistApiException {
        GoogleMap googleMap = this.mMap;
        if (googleMap == null) {
            return false;
        }
        return googleMap.isBuildingsEnabled();
    }

    public void setBuildingsEnabled(boolean z) throws MapNotExistApiException {
        GoogleMap googleMap = this.mMap;
        if (googleMap != null) {
            googleMap.setBuildingsEnabled(z);
        }
    }

    public boolean isTrafficEnabled() throws MapNotExistApiException {
        GoogleMap googleMap = this.mMap;
        if (googleMap == null) {
            return false;
        }
        return googleMap.isTrafficEnabled();
    }

    public void setTrafficEnabled(boolean z) throws MapNotExistApiException {
        GoogleMap googleMap = this.mMap;
        if (googleMap != null) {
            googleMap.setTrafficEnabled(z);
        }
    }

    public boolean isIndoorEnabled() throws MapNotExistApiException {
        GoogleMap googleMap = this.mMap;
        if (googleMap == null) {
            return false;
        }
        return googleMap.isIndoorEnabled();
    }

    public boolean setIndoorEnabled(boolean z) throws MapNotExistApiException {
        GoogleMap googleMap = this.mMap;
        if (googleMap == null) {
            return false;
        }
        return googleMap.setIndoorEnabled(z);
    }

    public void moveCamera(CameraUpdate cameraUpdate) throws MapNotExistApiException {
        if (cameraUpdate != null && this.mMap != null) {
            try {
                com.google.android.gms.maps.CameraUpdate convertToGoogleCameraUpdate = Converter.convertToGoogleCameraUpdate(this, cameraUpdate);
                if (convertToGoogleCameraUpdate != null) {
                    this.mMap.moveCamera(convertToGoogleCameraUpdate);
                }
            } catch (IllegalStateException e) {
                handleGoogleIllegalStateException(e, cameraUpdate);
            }
        }
    }

    public void animateCamera(CameraUpdate cameraUpdate) throws MapNotExistApiException, IllegalStateException {
        if (cameraUpdate != null && this.mMap != null) {
            try {
                com.google.android.gms.maps.CameraUpdate convertToGoogleCameraUpdate = Converter.convertToGoogleCameraUpdate(this, cameraUpdate);
                if (convertToGoogleCameraUpdate != null) {
                    this.mMap.animateCamera(convertToGoogleCameraUpdate);
                }
            } catch (IllegalStateException e) {
                handleGoogleIllegalStateException(e, cameraUpdate);
            }
        }
    }

    public void animateCameraWithCallback(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) throws MapNotExistApiException {
        if (cameraUpdate != null && this.mMap != null) {
            try {
                com.google.android.gms.maps.CameraUpdate convertToGoogleCameraUpdate = Converter.convertToGoogleCameraUpdate(this, cameraUpdate);
                if (convertToGoogleCameraUpdate != null) {
                    this.mMap.animateCamera(convertToGoogleCameraUpdate, Converter.convertToGoogleCallback(cancelableCallback));
                }
            } catch (IllegalStateException e) {
                handleGoogleIllegalStateException(e, cameraUpdate);
            }
        }
    }

    public void animateCameraWithDurationAndCallback(CameraUpdate cameraUpdate, int i, CancelableCallback cancelableCallback) throws MapNotExistApiException {
        if (cameraUpdate != null && this.mMap != null) {
            try {
                com.google.android.gms.maps.CameraUpdate convertToGoogleCameraUpdate = Converter.convertToGoogleCameraUpdate(this, cameraUpdate);
                if (convertToGoogleCameraUpdate != null) {
                    this.mMap.animateCamera(convertToGoogleCameraUpdate, i, Converter.convertToGoogleCallback(cancelableCallback));
                }
            } catch (IllegalStateException e) {
                handleGoogleIllegalStateException(e, cameraUpdate);
            }
        }
    }

    public float calculateZoomToSpanLevel(LatLng latLng, LatLng latLng2) throws MapNotExistApiException {
        return calculateZoomToSpanLevel(0, 0, 0, 0, latLng, latLng2, (LatLng) null);
    }

    public float calculateZoomToSpanLevel(int i, int i2, int i3, int i4, LatLng latLng, LatLng latLng2, LatLng latLng3) throws MapNotExistApiException {
        int i5;
        int i6;
        int i7;
        int i8;
        GoogleMap googleMap = this.mMap;
        if (googleMap == null || googleMap.getCameraPosition() == null) {
            DLog.m7384d(TAG, "map == null or getCameraPosition == null", new Object[0]);
            return 2.0f;
        }
        Padding padding = this.mPadding;
        if (padding != null) {
            i8 = padding.left;
            i7 = this.mPadding.right;
            i6 = this.mPadding.top;
            i5 = this.mPadding.bottom;
        } else {
            i8 = 0;
            i7 = 0;
            i6 = 0;
            i5 = 0;
        }
        float f = this.mMap.getCameraPosition().zoom;
        float f2 = (((((float) this.mContext.getResources().getDisplayMetrics().widthPixels) - ((float) i8)) - ((float) i7)) - ((float) i)) - ((float) i2);
        float f3 = (((((float) this.mContext.getResources().getDisplayMetrics().heightPixels) - ((float) i6)) - ((float) i5)) - ((float) i3)) - ((float) i4);
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        if (f3 <= 0.0f) {
            f3 = 1.0f;
        }
        LatLngBounds.Builder builder = LatLngBounds.builder();
        if (latLng != null) {
            builder.include(Converter.convertToGoogleLatLng(latLng));
        }
        if (latLng2 != null) {
            builder.include(Converter.convertToGoogleLatLng(latLng2));
        }
        if (latLng3 != null) {
            builder.include(Converter.convertToGoogleLatLng(latLng3));
        }
        try {
            LatLngBounds build = builder.build();
            float lng2Pixel = SystemUtil.lng2Pixel(this.mContext, build.northeast.longitude, f);
            float lat2Pixel = SystemUtil.lat2Pixel(this.mContext, build.northeast.latitude, f);
            float lng2Pixel2 = SystemUtil.lng2Pixel(this.mContext, build.southwest.longitude, f);
            float abs = Math.abs(lat2Pixel - SystemUtil.lat2Pixel(this.mContext, build.southwest.latitude, f));
            float abs2 = Math.abs(lng2Pixel - lng2Pixel2);
            if (abs / abs2 > f3 / f2) {
                f2 = f3;
            } else {
                abs = abs2;
            }
            float log10 = (float) (Math.log10((double) ((f2 / (abs / ((float) (((double) TypedValue.applyDimension(1, 256.0f, this.mContext.getResources().getDisplayMetrics())) * Math.pow(2.0d, (double) f))))) / TypedValue.applyDimension(1, 256.0f, this.mContext.getResources().getDisplayMetrics()))) / Math.log10(2.0d));
            if (Float.isNaN(log10)) {
                return this.mMap.getMaxZoomLevel();
            }
            if (log10 > this.mMap.getMaxZoomLevel()) {
                return this.mMap.getMaxZoomLevel();
            }
            return log10 < this.mMap.getMinZoomLevel() ? this.mMap.getMinZoomLevel() : log10;
        } catch (Exception e) {
            DLog.m7384d(TAG, "latLngBounds build error: %s", e.toString());
            return 2.0f;
        }
    }

    public void stopAnimation() throws MapNotExistApiException {
        GoogleMap googleMap = this.mMap;
        if (googleMap != null) {
            googleMap.stopAnimation();
        }
    }

    public com.didi.common.map.model.Marker addMarker(MarkerOptions markerOptions) throws MapNotExistApiException {
        if (markerOptions == null || this.mMapElementMap == null || this.mMap == null) {
            return null;
        }
        Marker addMarker = this.mMap.addMarker(Converter.convertToGoogleMarkerOption(markerOptions));
        com.didi.common.map.model.Marker marker = new com.didi.common.map.model.Marker(new MarkerDelegate(addMarker, markerOptions, this.mMap));
        this.mMapElementMap.put(addMarker, marker);
        addMarker.setTag(marker);
        return marker;
    }

    public Line addLine(LineOptions lineOptions) throws MapNotExistApiException {
        if (lineOptions == null || this.mMapElementMap == null || this.mMap == null) {
            return null;
        }
        Polyline addPolyline = this.mMap.addPolyline(Converter.convertToGooglePolyLineOption(lineOptions));
        Line line = new Line(new LineDelegate(addPolyline, lineOptions));
        this.mMapElementMap.put(addPolyline, line);
        return line;
    }

    public com.didi.common.map.model.Polygon addPolygon(PolygonOptions polygonOptions) throws MapNotExistApiException {
        if (polygonOptions == null || this.mMapElementMap == null || this.mMap == null) {
            return null;
        }
        Polygon addPolygon = this.mMap.addPolygon(Converter.convertToGooglePolygonOptions(polygonOptions));
        com.didi.common.map.model.Polygon polygon = new com.didi.common.map.model.Polygon(new PolygonDelegate(addPolygon, polygonOptions));
        this.mMapElementMap.put(addPolygon, polygon);
        return polygon;
    }

    public com.didi.common.map.model.Circle addCircle(CircleOptions circleOptions) throws MapNotExistApiException {
        if (circleOptions == null || this.mMapElementMap == null || this.mMap == null) {
            return null;
        }
        Circle addCircle = this.mMap.addCircle(Converter.convertToGoogleCircleOptions(circleOptions));
        com.didi.common.map.model.Circle circle = new com.didi.common.map.model.Circle(new CircleDelegate(addCircle, circleOptions));
        this.mMapElementMap.put(addCircle, circle);
        return circle;
    }

    public MaskLayer addMaskLayer(MaskLayerOptions maskLayerOptions) throws MapNotExistApiException {
        if (maskLayerOptions != null && this.mMapElementMap == null) {
        }
        return null;
    }

    public void clear() throws MapNotExistApiException {
        GoogleMap googleMap = this.mMap;
        if (googleMap != null) {
            googleMap.clear();
            ConcurrentHashMap<Object, IMapElement> concurrentHashMap = this.mMapElementMap;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
            }
        }
    }

    public boolean isMyLocationEnabled() throws MapNotExistApiException {
        GoogleMap googleMap = this.mMap;
        if (googleMap == null) {
            return false;
        }
        return googleMap.isMyLocationEnabled();
    }

    public void setMyLocationEnabled(boolean z) throws MapNotExistApiException {
        GoogleMap googleMap = this.mMap;
        if (googleMap != null) {
            googleMap.getUiSettings().setMyLocationButtonEnabled(z);
        }
    }

    @Deprecated
    public Location getMyLocation() throws MapNotExistApiException {
        GoogleMap googleMap = this.mMap;
        if (googleMap == null) {
            return null;
        }
        return googleMap.getMyLocation();
    }

    public void setPadding(int i, int i2, int i3, int i4) throws MapNotExistApiException {
        if (this.mMap != null) {
            this.mPadding = new Padding(i, i2, i3, i4);
            this.mMap.setPadding(i, i2, i3, i4);
        }
    }

    public Padding getPadding() {
        return this.mPadding;
    }

    public void onCreate(Bundle bundle) throws MapNotExistApiException {
        if (this.mMapView != null) {
            setMaxZoomLevel(21.0f);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                this.mMapView.onCreate(bundle);
            } catch (Exception e) {
                DLog.m7384d(TAG, "map create: " + e.getMessage(), new Object[0]);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            DLog.m7384d(TAG, "gmap create  timeConsuming: " + currentTimeMillis2, new Object[0]);
            TrackerMapInfo trackerMapInfo = new TrackerMapInfo();
            trackerMapInfo.mapId = UUID.randomUUID().toString();
            trackerMapInfo.appName = getContext() != null ? getContext().getPackageName() : "com.pkg.null";
            Tracker.onMapCreate(getContext(), trackerMapInfo, currentTimeMillis2);
        }
    }

    public void onStart() throws MapNotExistApiException {
        com.google.android.gms.maps.MapView mapView = this.mMapView;
        if (mapView != null) {
            mapView.onStart();
        }
    }

    public void onResume() throws MapNotExistApiException {
        com.google.android.gms.maps.MapView mapView = this.mMapView;
        if (mapView != null) {
            mapView.onResume();
        }
    }

    public void onPause() throws MapNotExistApiException {
        com.google.android.gms.maps.MapView mapView = this.mMapView;
        if (mapView != null) {
            mapView.onPause();
        }
    }

    public void onStop() throws MapNotExistApiException {
        com.google.android.gms.maps.MapView mapView = this.mMapView;
        if (mapView != null) {
            mapView.onStop();
        }
    }

    public void onDestroy() throws MapNotExistApiException {
        ConcurrentHashMap<Object, IMapElement> concurrentHashMap = this.mMapElementMap;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
            this.mMapElementMap = null;
        }
        this.mIsGoogleMapReady = false;
        this.mIsGoogleMapLoaded = false;
        com.google.android.gms.maps.MapView mapView = this.mMapView;
        if (mapView != null) {
            mapView.onDestroy();
            this.mMapView = null;
        }
        GoogleMapViewWrapper googleMapViewWrapper = this.mGoogleMapViewWrapper;
        if (googleMapViewWrapper != null) {
            googleMapViewWrapper.destroy();
            this.mGoogleMapViewWrapper = null;
        }
    }

    public void onLowMemory() throws MapNotExistApiException {
        com.google.android.gms.maps.MapView mapView = this.mMapView;
        if (mapView != null) {
            mapView.onLowMemory();
        }
    }

    public void onSaveInstanceState(Bundle bundle) throws MapNotExistApiException {
        com.google.android.gms.maps.MapView mapView = this.mMapView;
        if (mapView != null) {
            mapView.onSaveInstanceState(bundle);
        }
    }

    public void addOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) throws MapNotExistApiException {
        GoogleMapViewWrapper googleMapViewWrapper = this.mGoogleMapViewWrapper;
        if (googleMapViewWrapper != null) {
            googleMapViewWrapper.addOnCameraChangeListener(onCameraChangeListener);
        }
    }

    public void removeOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) throws MapNotExistApiException {
        GoogleMapViewWrapper googleMapViewWrapper = this.mGoogleMapViewWrapper;
        if (googleMapViewWrapper != null) {
            googleMapViewWrapper.removeOnCameraChangeListener(onCameraChangeListener);
        }
    }

    public void addOnMapGestureListener(OnMapGestureListener onMapGestureListener) throws MapNotExistApiException {
        GoogleMapViewWrapper googleMapViewWrapper = this.mGoogleMapViewWrapper;
        if (googleMapViewWrapper != null) {
            googleMapViewWrapper.addOnMapGestureListener(onMapGestureListener);
        }
    }

    public void removeOnMapGestureListener(OnMapGestureListener onMapGestureListener) throws MapNotExistApiException {
        GoogleMapViewWrapper googleMapViewWrapper = this.mGoogleMapViewWrapper;
        if (googleMapViewWrapper != null) {
            googleMapViewWrapper.removeOnMapGestureListener(onMapGestureListener);
        }
    }

    public void addOnMapClickListener(OnMapClickListener onMapClickListener) throws MapNotExistApiException {
        GoogleMapViewWrapper googleMapViewWrapper = this.mGoogleMapViewWrapper;
        if (googleMapViewWrapper != null) {
            googleMapViewWrapper.addOnMapClickListener(onMapClickListener);
        }
    }

    public void removeOnMapClickListener(OnMapClickListener onMapClickListener) throws MapNotExistApiException {
        GoogleMapViewWrapper googleMapViewWrapper = this.mGoogleMapViewWrapper;
        if (googleMapViewWrapper != null) {
            googleMapViewWrapper.removeOnMapClickListener(onMapClickListener);
        }
    }

    public void addOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) throws MapNotExistApiException {
        GoogleMapViewWrapper googleMapViewWrapper = this.mGoogleMapViewWrapper;
        if (googleMapViewWrapper != null) {
            googleMapViewWrapper.addOnMapLongClickListener(onMapLongClickListener);
        }
    }

    public void removeOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) throws MapNotExistApiException {
        GoogleMapViewWrapper googleMapViewWrapper = this.mGoogleMapViewWrapper;
        if (googleMapViewWrapper != null) {
            googleMapViewWrapper.removeOnMapLongClickListener(onMapLongClickListener);
        }
    }

    public void addOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) throws MapNotExistApiException {
        CopyOnWriteArrayList<OnMapLoadedCallback> copyOnWriteArrayList;
        if (onMapLoadedCallback != null && (copyOnWriteArrayList = this.mOnMapLoadedCallbacks) != null && !copyOnWriteArrayList.contains(onMapLoadedCallback)) {
            this.mOnMapLoadedCallbacks.add(onMapLoadedCallback);
            if (this.mIsGoogleMapLoaded) {
                onMapLoadedCallback.onMapLoaded();
            }
        }
    }

    public void removeOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) throws MapNotExistApiException {
        CopyOnWriteArrayList<OnMapLoadedCallback> copyOnWriteArrayList;
        if (onMapLoadedCallback != null && (copyOnWriteArrayList = this.mOnMapLoadedCallbacks) != null) {
            copyOnWriteArrayList.remove(onMapLoadedCallback);
        }
    }

    public void addOnPolygonClickListener(OnPolygonClickListener onPolygonClickListener) throws MapNotExistApiException {
        CopyOnWriteArrayList<OnPolygonClickListener> copyOnWriteArrayList;
        if (onPolygonClickListener != null && (copyOnWriteArrayList = this.mOnPolygonClickListeners) != null && !copyOnWriteArrayList.contains(onPolygonClickListener)) {
            this.mOnPolygonClickListeners.add(onPolygonClickListener);
        }
    }

    public void removeOnPolygonClickListener(OnPolygonClickListener onPolygonClickListener) throws MapNotExistApiException {
        CopyOnWriteArrayList<OnPolygonClickListener> copyOnWriteArrayList;
        if (onPolygonClickListener != null && (copyOnWriteArrayList = this.mOnPolygonClickListeners) != null) {
            copyOnWriteArrayList.remove(onPolygonClickListener);
        }
    }

    public void addOnLineClickListener(OnLineClickListener onLineClickListener) throws MapNotExistApiException {
        CopyOnWriteArrayList<OnLineClickListener> copyOnWriteArrayList;
        if (onLineClickListener != null && (copyOnWriteArrayList = this.mOnLineClickListeners) != null && !copyOnWriteArrayList.contains(onLineClickListener)) {
            this.mOnLineClickListeners.add(onLineClickListener);
        }
    }

    public void removeOnLineClickListener(OnLineClickListener onLineClickListener) throws MapNotExistApiException {
        CopyOnWriteArrayList<OnLineClickListener> copyOnWriteArrayList;
        if (onLineClickListener != null && (copyOnWriteArrayList = this.mOnLineClickListeners) != null) {
            copyOnWriteArrayList.remove(onLineClickListener);
        }
    }

    public void addOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) throws MapNotExistApiException {
        CopyOnWriteArrayList<OnMarkerClickListener> copyOnWriteArrayList;
        if (onMarkerClickListener != null && (copyOnWriteArrayList = this.mOnMarkerClickListeners) != null && !copyOnWriteArrayList.contains(onMarkerClickListener)) {
            this.mOnMarkerClickListeners.add(onMarkerClickListener);
        }
    }

    public void removeOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) throws MapNotExistApiException {
        CopyOnWriteArrayList<OnMarkerClickListener> copyOnWriteArrayList;
        if (onMarkerClickListener != null && (copyOnWriteArrayList = this.mOnMarkerClickListeners) != null) {
            copyOnWriteArrayList.remove(onMarkerClickListener);
        }
    }

    public void addOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) throws MapNotExistApiException {
        CopyOnWriteArrayList<OnMarkerDragListener> copyOnWriteArrayList;
        if (onMarkerDragListener != null && (copyOnWriteArrayList = this.mOnMarkerDragListeners) != null && !copyOnWriteArrayList.contains(onMarkerDragListener)) {
            this.mOnMarkerDragListeners.add(onMarkerDragListener);
        }
    }

    public void removeOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) throws MapNotExistApiException {
        CopyOnWriteArrayList<OnMarkerDragListener> copyOnWriteArrayList;
        if (onMarkerDragListener != null && (copyOnWriteArrayList = this.mOnMarkerDragListeners) != null) {
            copyOnWriteArrayList.remove(onMarkerDragListener);
        }
    }

    public void addOnGroundOverlayClickListener(OnGroundOverlayClickListener onGroundOverlayClickListener) throws MapNotExistApiException {
        CopyOnWriteArrayList<OnGroundOverlayClickListener> copyOnWriteArrayList;
        if (onGroundOverlayClickListener != null && (copyOnWriteArrayList = this.mOnGroundOverlayClickListeners) != null && !copyOnWriteArrayList.contains(onGroundOverlayClickListener)) {
            this.mOnGroundOverlayClickListeners.add(onGroundOverlayClickListener);
        }
    }

    public void removeOnGroundOverlayClickListener(OnGroundOverlayClickListener onGroundOverlayClickListener) throws MapNotExistApiException {
        CopyOnWriteArrayList<OnGroundOverlayClickListener> copyOnWriteArrayList;
        if (onGroundOverlayClickListener != null && (copyOnWriteArrayList = this.mOnGroundOverlayClickListeners) != null) {
            copyOnWriteArrayList.remove(onGroundOverlayClickListener);
        }
    }

    public void addOnCircleClickListener(OnCircleClickListener onCircleClickListener) {
        CopyOnWriteArrayList<OnCircleClickListener> copyOnWriteArrayList;
        if (onCircleClickListener != null && (copyOnWriteArrayList = this.mOnCircleClickListeners) != null && !copyOnWriteArrayList.contains(onCircleClickListener)) {
            this.mOnCircleClickListeners.add(onCircleClickListener);
        }
    }

    public void removeOnCircleClickListener(OnCircleClickListener onCircleClickListener) {
        CopyOnWriteArrayList<OnCircleClickListener> copyOnWriteArrayList;
        if (onCircleClickListener != null && (copyOnWriteArrayList = this.mOnCircleClickListeners) != null) {
            copyOnWriteArrayList.remove(onCircleClickListener);
        }
    }

    public Object getVendorMap() {
        return this.mMap;
    }

    /* access modifiers changed from: private */
    public com.didi.common.map.model.Marker getCommonMarkerByGoogleMarker(Marker marker) {
        ConcurrentHashMap<Object, IMapElement> concurrentHashMap = this.mMapElementMap;
        if (concurrentHashMap == null || concurrentHashMap.size() <= 0 || marker == null) {
            return null;
        }
        IMapElement iMapElement = this.mMapElementMap.get(marker);
        if (iMapElement instanceof com.didi.common.map.model.Marker) {
            return (com.didi.common.map.model.Marker) iMapElement;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public com.didi.common.map.model.Polygon getCommonPolygonByGooglePolygon(Polygon polygon) {
        ConcurrentHashMap<Object, IMapElement> concurrentHashMap = this.mMapElementMap;
        if (concurrentHashMap == null || concurrentHashMap.size() <= 0 || polygon == null) {
            return null;
        }
        IMapElement iMapElement = this.mMapElementMap.get(polygon);
        if (iMapElement instanceof com.didi.common.map.model.Polygon) {
            return (com.didi.common.map.model.Polygon) iMapElement;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public com.didi.common.map.model.GroundOverlay getCommonGroundOverlayByGoogleGroundOverlay(GroundOverlay groundOverlay) {
        ConcurrentHashMap<Object, IMapElement> concurrentHashMap = this.mMapElementMap;
        if (concurrentHashMap == null || concurrentHashMap.size() <= 0 || groundOverlay == null) {
            return null;
        }
        IMapElement iMapElement = this.mMapElementMap.get(groundOverlay);
        if (iMapElement instanceof com.didi.common.map.model.GroundOverlay) {
            return (com.didi.common.map.model.GroundOverlay) iMapElement;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public com.didi.common.map.model.Circle getCommonCircleByGoogleCircle(Circle circle) {
        ConcurrentHashMap<Object, IMapElement> concurrentHashMap = this.mMapElementMap;
        if (concurrentHashMap == null || concurrentHashMap.size() <= 0 || circle == null) {
            return null;
        }
        IMapElement iMapElement = this.mMapElementMap.get(circle);
        if (iMapElement instanceof com.didi.common.map.model.Circle) {
            return (com.didi.common.map.model.Circle) iMapElement;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public Line getCommonLineByGoogleLine(Polyline polyline) {
        ConcurrentHashMap<Object, IMapElement> concurrentHashMap = this.mMapElementMap;
        if (concurrentHashMap == null || concurrentHashMap.size() <= 0 || polyline == null) {
            return null;
        }
        IMapElement iMapElement = this.mMapElementMap.get(polyline);
        if (iMapElement instanceof Line) {
            return (Line) iMapElement;
        }
        return null;
    }

    private void handleGoogleIllegalStateException(IllegalStateException illegalStateException, final CameraUpdate cameraUpdate) {
        com.google.android.gms.maps.MapView mapView;
        if (this.mMap != null && (mapView = this.mMapView) != null && mapView.getViewTreeObserver().isAlive()) {
            this.mMapView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (Build.VERSION.SDK_INT < 16) {
                        DDGoogleMap.this.mMapView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    } else {
                        DDGoogleMap.this.mMapView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    try {
                        com.google.android.gms.maps.CameraUpdate convertToGoogleCameraUpdate = Converter.convertToGoogleCameraUpdate(DDGoogleMap.this, cameraUpdate);
                        if (convertToGoogleCameraUpdate != null) {
                            DDGoogleMap.this.mMap.animateCamera(convertToGoogleCameraUpdate);
                        }
                    } catch (Exception e) {
                        DLog.m7384d("zl map", e + "", new Object[0]);
                    }
                }
            });
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean IsDegrade() {
        return this.mIsDegrade;
    }

    public void setRotateAngle(float f) {
        CameraPosition cameraPosition;
        if (this.mMap != null && (cameraPosition = getCameraPosition()) != null) {
            CameraUpdate newCameraPosition = CameraUpdateFactory.newCameraPosition(CameraPosition.builder().bearing(f).target(cameraPosition.target).tilt(cameraPosition.tilt).zoom((float) cameraPosition.zoom).build());
            try {
                com.google.android.gms.maps.CameraUpdate convertToGoogleCameraUpdate = Converter.convertToGoogleCameraUpdate(this, newCameraPosition);
                if (convertToGoogleCameraUpdate != null) {
                    this.mMap.moveCamera(convertToGoogleCameraUpdate);
                }
            } catch (IllegalStateException e) {
                handleGoogleIllegalStateException(e, newCameraPosition);
            }
        }
    }

    public int getWidth() {
        com.google.android.gms.maps.MapView mapView = this.mMapView;
        if (mapView != null) {
            return mapView.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        com.google.android.gms.maps.MapView mapView = this.mMapView;
        if (mapView != null) {
            return mapView.getHeight();
        }
        return 0;
    }
}
