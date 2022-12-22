package com.didi.common.map.adapter.didiadapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.TypedValue;
import android.view.View;
import com.didi.common.map.MapVendor;
import com.didi.common.map.MapView;
import com.didi.common.map.adapter.didiadapter.converter.Converter;
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
import com.didi.common.map.model.CameraUpdate;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.CircleOptions;
import com.didi.common.map.model.GroundOverlay;
import com.didi.common.map.model.GroundOverlayOptions;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.model.MaskLayer;
import com.didi.common.map.model.MaskLayerOptions;
import com.didi.common.map.model.Padding;
import com.didi.common.map.model.Polygon;
import com.didi.common.map.model.PolygonOptions;
import com.didi.common.map.model.throwable.MapNotExistApiException;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DynamicLayerApollo;
import com.didi.common.map.util.MapApolloTools;
import com.didi.common.map.util.SystemUtil;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.map.MapOptions;
import com.didi.map.outer.map.MapView;
import com.didi.map.outer.map.OnMapReadyCallback;
import com.didi.map.outer.model.CameraPosition;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;
import com.didi.map.outer.model.Marker;
import com.didi.map.outer.model.Polyline;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class DDMap implements IMapDelegate {
    private static final String TAG = "DDMap";
    /* access modifiers changed from: private */
    public Context mContext;
    private DidiMap.OnMarkerClickListener mDidiOnMarkerClickListener;
    private DidiMap.OnMarkerDragListener mDidiOnMarkerDragListener;
    /* access modifiers changed from: private */
    public DidiMap.OnPolylineClickListener mDidiOnPolylineClickListener;
    private boolean mIsBuildingEnabled;
    private boolean mIsDegrade;
    /* access modifiers changed from: private */
    public boolean mIsLoadGoogleTile;
    private boolean mIsTraficEnabled;
    /* access modifiers changed from: private */
    public DidiMap mMap;
    private ConcurrentHashMap<Object, IMapElement> mMapElementMap;
    /* access modifiers changed from: private */
    public MapTouchEventListener mMapTouchEventListener;
    private MapView mMapView;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<OnLineClickListener> mOnLineClickListeners;
    private OnMapReadyCallback mOnMapReadyCallback;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<MapView.InnerMapReadyCallBack> mOnMapReadyListeners;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<OnMarkerClickListener> mOnMarkerClickListeners;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<OnMarkerDragListener> mOnMarkerDragListeners;
    private Padding mPadding;
    private IProjectionDelegate mProjectionDelegate;
    /* access modifiers changed from: private */
    public float mScreenCenterX;
    /* access modifiers changed from: private */
    public float mScreenCenterY;
    private IUiSettingsDelegate mUiSettingsDelegate;

    public DDMap(Context context, boolean z) {
        this(context, false, z);
    }

    public DDMap(Context context, boolean z, boolean z2) {
        this.mIsDegrade = false;
        this.mScreenCenterX = 0.5f;
        this.mScreenCenterY = 0.5f;
        this.mPadding = new Padding();
        this.mIsBuildingEnabled = true;
        this.mIsTraficEnabled = false;
        this.mIsLoadGoogleTile = false;
        this.mDidiOnPolylineClickListener = new DidiMap.OnPolylineClickListener() {
            public void onPolylineClick(Polyline polyline, LatLng latLng) {
                Line access$000 = DDMap.this.getCommonLineByDidiLine(polyline);
                if (access$000 != null && DDMap.this.mOnLineClickListeners != null && !DDMap.this.mOnLineClickListeners.isEmpty()) {
                    Iterator it = DDMap.this.mOnLineClickListeners.iterator();
                    while (it.hasNext()) {
                        ((OnLineClickListener) it.next()).onLineClick(access$000);
                    }
                }
            }
        };
        this.mDidiOnMarkerClickListener = new DidiMap.OnMarkerClickListener() {
            public boolean onMarkerClick(Marker marker) {
                com.didi.common.map.model.Marker access$200 = DDMap.this.getCommonMarkerByDidiMarker(marker);
                if (access$200 == null || DDMap.this.mOnMarkerClickListeners == null || DDMap.this.mOnMarkerClickListeners.isEmpty()) {
                    return true;
                }
                Iterator it = DDMap.this.mOnMarkerClickListeners.iterator();
                while (it.hasNext()) {
                    ((OnMarkerClickListener) it.next()).onMarkerClick(access$200);
                }
                return true;
            }
        };
        this.mDidiOnMarkerDragListener = new DidiMap.OnMarkerDragListener() {
            public void onMarkerDragStart(Marker marker) {
                com.didi.common.map.model.Marker access$200 = DDMap.this.getCommonMarkerByDidiMarker(marker);
                if (access$200 != null && DDMap.this.mOnMarkerDragListeners != null && !DDMap.this.mOnMarkerDragListeners.isEmpty()) {
                    Iterator it = DDMap.this.mOnMarkerDragListeners.iterator();
                    while (it.hasNext()) {
                        ((OnMarkerDragListener) it.next()).onMarkerDragStart(access$200);
                    }
                }
            }

            public void onMarkerDrag(Marker marker) {
                com.didi.common.map.model.Marker access$200 = DDMap.this.getCommonMarkerByDidiMarker(marker);
                if (access$200 != null && DDMap.this.mOnMarkerDragListeners != null && !DDMap.this.mOnMarkerDragListeners.isEmpty()) {
                    Iterator it = DDMap.this.mOnMarkerDragListeners.iterator();
                    while (it.hasNext()) {
                        ((OnMarkerDragListener) it.next()).onMarkerDrag(access$200);
                    }
                }
            }

            public void onMarkerDragEnd(Marker marker) {
                com.didi.common.map.model.Marker access$200 = DDMap.this.getCommonMarkerByDidiMarker(marker);
                if (access$200 != null && DDMap.this.mOnMarkerDragListeners != null && !DDMap.this.mOnMarkerDragListeners.isEmpty()) {
                    Iterator it = DDMap.this.mOnMarkerDragListeners.iterator();
                    while (it.hasNext()) {
                        ((OnMarkerDragListener) it.next()).onMarkerDragEnd(access$200);
                    }
                }
            }
        };
        this.mOnMapReadyCallback = new OnMapReadyCallback() {
            public void onMapReady(DidiMap didiMap) {
                DidiMap unused = DDMap.this.mMap = didiMap;
                DDMap.this.mMap.setMapScreenCenterProportion(DDMap.this.mScreenCenterX, DDMap.this.mScreenCenterY);
                DDMap.this.mMap.setIsInternationalWMS(DDMap.this.mIsLoadGoogleTile);
                DDMap.this.mMap.setOnPolylineClickListener(DDMap.this.mDidiOnPolylineClickListener);
                DDMap dDMap = DDMap.this;
                MapTouchEventListener unused2 = dDMap.mMapTouchEventListener = new MapTouchEventListener(dDMap.mMap, DDMap.this.mContext);
                if (DDMap.this.mOnMapReadyListeners != null && !DDMap.this.mOnMapReadyListeners.isEmpty()) {
                    Iterator it = DDMap.this.mOnMapReadyListeners.iterator();
                    while (it.hasNext()) {
                        ((MapView.InnerMapReadyCallBack) it.next()).onMapReady();
                    }
                }
            }
        };
        this.mIsDegrade = z2;
        this.mContext = context.getApplicationContext();
        this.mMapElementMap = new ConcurrentHashMap<>();
        this.mOnMarkerDragListeners = new CopyOnWriteArrayList<>();
        this.mOnMarkerClickListeners = new CopyOnWriteArrayList<>();
        this.mOnLineClickListeners = new CopyOnWriteArrayList<>();
        this.mOnMapReadyListeners = new CopyOnWriteArrayList<>();
        this.mIsLoadGoogleTile = z;
        MapOptions mapOptions = new MapOptions();
        CameraPosition.Builder builder = new CameraPosition.Builder();
        builder.target(new LatLng(-23.550083287919108d, -46.633068323135376d));
        builder.tilt(0.0f);
        builder.zoom(15.0f);
        builder.bearing(0.0f);
        mapOptions.cameraPosition(builder.build());
        if (MapApolloTools.getDidiMapEnableVectorGraph()) {
            mapOptions.useBetterDisplay(true);
        }
        if (DynamicLayerApollo.isEnableHawaiiDynamicLayer()) {
            mapOptions.isDynamicLayerEnable(true);
        }
        com.didi.map.outer.map.MapView mapView = new com.didi.map.outer.map.MapView(context.getApplicationContext(), mapOptions);
        this.mMapView = mapView;
        mapView.getMapAsync(this.mOnMapReadyCallback);
    }

    public DDMap(Context context, boolean z, boolean z2, boolean z3) {
        this.mIsDegrade = false;
        this.mScreenCenterX = 0.5f;
        this.mScreenCenterY = 0.5f;
        this.mPadding = new Padding();
        this.mIsBuildingEnabled = true;
        this.mIsTraficEnabled = false;
        this.mIsLoadGoogleTile = false;
        this.mDidiOnPolylineClickListener = new DidiMap.OnPolylineClickListener() {
            public void onPolylineClick(Polyline polyline, LatLng latLng) {
                Line access$000 = DDMap.this.getCommonLineByDidiLine(polyline);
                if (access$000 != null && DDMap.this.mOnLineClickListeners != null && !DDMap.this.mOnLineClickListeners.isEmpty()) {
                    Iterator it = DDMap.this.mOnLineClickListeners.iterator();
                    while (it.hasNext()) {
                        ((OnLineClickListener) it.next()).onLineClick(access$000);
                    }
                }
            }
        };
        this.mDidiOnMarkerClickListener = new DidiMap.OnMarkerClickListener() {
            public boolean onMarkerClick(Marker marker) {
                com.didi.common.map.model.Marker access$200 = DDMap.this.getCommonMarkerByDidiMarker(marker);
                if (access$200 == null || DDMap.this.mOnMarkerClickListeners == null || DDMap.this.mOnMarkerClickListeners.isEmpty()) {
                    return true;
                }
                Iterator it = DDMap.this.mOnMarkerClickListeners.iterator();
                while (it.hasNext()) {
                    ((OnMarkerClickListener) it.next()).onMarkerClick(access$200);
                }
                return true;
            }
        };
        this.mDidiOnMarkerDragListener = new DidiMap.OnMarkerDragListener() {
            public void onMarkerDragStart(Marker marker) {
                com.didi.common.map.model.Marker access$200 = DDMap.this.getCommonMarkerByDidiMarker(marker);
                if (access$200 != null && DDMap.this.mOnMarkerDragListeners != null && !DDMap.this.mOnMarkerDragListeners.isEmpty()) {
                    Iterator it = DDMap.this.mOnMarkerDragListeners.iterator();
                    while (it.hasNext()) {
                        ((OnMarkerDragListener) it.next()).onMarkerDragStart(access$200);
                    }
                }
            }

            public void onMarkerDrag(Marker marker) {
                com.didi.common.map.model.Marker access$200 = DDMap.this.getCommonMarkerByDidiMarker(marker);
                if (access$200 != null && DDMap.this.mOnMarkerDragListeners != null && !DDMap.this.mOnMarkerDragListeners.isEmpty()) {
                    Iterator it = DDMap.this.mOnMarkerDragListeners.iterator();
                    while (it.hasNext()) {
                        ((OnMarkerDragListener) it.next()).onMarkerDrag(access$200);
                    }
                }
            }

            public void onMarkerDragEnd(Marker marker) {
                com.didi.common.map.model.Marker access$200 = DDMap.this.getCommonMarkerByDidiMarker(marker);
                if (access$200 != null && DDMap.this.mOnMarkerDragListeners != null && !DDMap.this.mOnMarkerDragListeners.isEmpty()) {
                    Iterator it = DDMap.this.mOnMarkerDragListeners.iterator();
                    while (it.hasNext()) {
                        ((OnMarkerDragListener) it.next()).onMarkerDragEnd(access$200);
                    }
                }
            }
        };
        this.mOnMapReadyCallback = new OnMapReadyCallback() {
            public void onMapReady(DidiMap didiMap) {
                DidiMap unused = DDMap.this.mMap = didiMap;
                DDMap.this.mMap.setMapScreenCenterProportion(DDMap.this.mScreenCenterX, DDMap.this.mScreenCenterY);
                DDMap.this.mMap.setIsInternationalWMS(DDMap.this.mIsLoadGoogleTile);
                DDMap.this.mMap.setOnPolylineClickListener(DDMap.this.mDidiOnPolylineClickListener);
                DDMap dDMap = DDMap.this;
                MapTouchEventListener unused2 = dDMap.mMapTouchEventListener = new MapTouchEventListener(dDMap.mMap, DDMap.this.mContext);
                if (DDMap.this.mOnMapReadyListeners != null && !DDMap.this.mOnMapReadyListeners.isEmpty()) {
                    Iterator it = DDMap.this.mOnMapReadyListeners.iterator();
                    while (it.hasNext()) {
                        ((MapView.InnerMapReadyCallBack) it.next()).onMapReady();
                    }
                }
            }
        };
        MapOptions mapOptions = new MapOptions();
        this.mIsDegrade = z2;
        this.mContext = context.getApplicationContext();
        this.mMapElementMap = new ConcurrentHashMap<>();
        this.mOnMarkerDragListeners = new CopyOnWriteArrayList<>();
        this.mOnMarkerClickListeners = new CopyOnWriteArrayList<>();
        this.mOnLineClickListeners = new CopyOnWriteArrayList<>();
        this.mOnMapReadyListeners = new CopyOnWriteArrayList<>();
        this.mIsLoadGoogleTile = z;
        CameraPosition.Builder builder = new CameraPosition.Builder();
        builder.target(new LatLng(-23.550083287919108d, -46.633068323135376d));
        builder.tilt(0.0f);
        builder.zoom(15.0f);
        builder.bearing(0.0f);
        mapOptions.cameraPosition(builder.build());
        mapOptions.useTextureMapView(z3);
        if (MapApolloTools.getDidiMapEnableVectorGraph()) {
            mapOptions.useBetterDisplay(true);
        }
        if (DynamicLayerApollo.isEnableHawaiiDynamicLayer()) {
            mapOptions.isDynamicLayerEnable(true);
        }
        com.didi.map.outer.map.MapView mapView = new com.didi.map.outer.map.MapView(context.getApplicationContext(), mapOptions);
        this.mMapView = mapView;
        mapView.getMapAsync(this.mOnMapReadyCallback);
    }

    public void setMaxZoomLevel(float f) {
        DLog.m7384d(TAG, "setMaxZoomLevel not support", new Object[0]);
    }

    public MapVendor getMapVendor() {
        return MapVendor.DIDI;
    }

    public GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws MapNotExistApiException {
        Marker addMarker = this.mMap.addMarker(Converter.convertToDidiMarkerOption(groundOverlayOptions));
        GroundOverlay groundOverlay = new GroundOverlay(new GroundOverlayDelegate(addMarker, groundOverlayOptions));
        this.mMapElementMap.put(addMarker, groundOverlay);
        addMarker.setOnClickListener(this.mDidiOnMarkerClickListener);
        addMarker.setOnDragListener(this.mDidiOnMarkerDragListener);
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

    public boolean setMapStyle(int i) {
        DLog.m7384d(TAG, "setMapStyle not support", new Object[0]);
        return false;
    }

    public boolean setMapStyle(String str) {
        DLog.m7384d(TAG, "setMapStyle not support", new Object[0]);
        return false;
    }

    public View getView() throws MapNotExistApiException {
        return this.mMapView;
    }

    public IUiSettingsDelegate getUiSettingsDelegate() throws MapNotExistApiException {
        if (this.mUiSettingsDelegate == null) {
            this.mUiSettingsDelegate = new UiSettingsDelegate(this.mMap);
        }
        return this.mUiSettingsDelegate;
    }

    public IProjectionDelegate getProjectionDelegate() throws MapNotExistApiException {
        DidiMap didiMap;
        if (this.mProjectionDelegate == null && (didiMap = this.mMap) != null) {
            this.mProjectionDelegate = new ProjectionDelegate(didiMap);
        }
        return this.mProjectionDelegate;
    }

    public int getMapType() throws MapNotExistApiException {
        return this.mMap.getMapType();
    }

    public void setMapType(int i) throws MapNotExistApiException {
        DLog.m7384d(TAG, "setMapType not support", new Object[0]);
    }

    /* renamed from: com.didi.common.map.adapter.didiadapter.DDMap$6 */
    static /* synthetic */ class C44606 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$common$map$constant$DiDiMapLanguage;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.common.map.constant.DiDiMapLanguage[] r0 = com.didi.common.map.constant.DiDiMapLanguage.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$common$map$constant$DiDiMapLanguage = r0
                com.didi.common.map.constant.DiDiMapLanguage r1 = com.didi.common.map.constant.DiDiMapLanguage.LAN_CHINESE_FON     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$common$map$constant$DiDiMapLanguage     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.common.map.constant.DiDiMapLanguage r1 = com.didi.common.map.constant.DiDiMapLanguage.LAN_CHINESE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$common$map$constant$DiDiMapLanguage     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.common.map.constant.DiDiMapLanguage r1 = com.didi.common.map.constant.DiDiMapLanguage.LAN_ENGLISH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.common.map.adapter.didiadapter.DDMap.C44606.<clinit>():void");
        }
    }

    public void setLanguage(DiDiMapLanguage diDiMapLanguage) throws MapNotExistApiException {
        int i = C44606.$SwitchMap$com$didi$common$map$constant$DiDiMapLanguage[diDiMapLanguage.ordinal()];
        int i2 = 2;
        if (i != 1) {
            i2 = i != 2 ? 1 : 0;
        }
        DidiMap didiMap = this.mMap;
        if (didiMap != null) {
            didiMap.setLanguage(i2);
        }
    }

    public DiDiMapLanguage getLanguage() throws MapNotExistApiException {
        DidiMap didiMap = this.mMap;
        if (didiMap != null) {
            if (didiMap.getLanguage() == 1) {
                return DiDiMapLanguage.LAN_ENGLISH;
            }
            if (this.mMap.getLanguage() == 2) {
                return DiDiMapLanguage.LAN_CHINESE_FON;
            }
            if (this.mMap.getLanguage() == 0) {
                return DiDiMapLanguage.LAN_CHINESE;
            }
        }
        return DiDiMapLanguage.LAN_ENGLISH;
    }

    public com.didi.common.map.model.CameraPosition getCameraPosition() throws MapNotExistApiException {
        DidiMap didiMap = this.mMap;
        if (didiMap == null) {
            return null;
        }
        return Converter.convertFromDidiCameraPosition(didiMap.getCameraPosition());
    }

    public double getMaxZoomLevel() throws MapNotExistApiException {
        return (double) this.mMap.getMaxZoomLevel();
    }

    public double getMinZoomLevel() throws MapNotExistApiException {
        return (double) this.mMap.getMinZoomLevel();
    }

    public void captureMapView(final OnCaptureMapViewListener onCaptureMapViewListener, Bitmap.Config config) throws MapNotExistApiException {
        this.mMap.getScreenShot(new Handler() {
            public void handleMessage(Message message) {
                OnCaptureMapViewListener onCaptureMapViewListener = onCaptureMapViewListener;
                if (onCaptureMapViewListener != null) {
                    onCaptureMapViewListener.onCaptureFinish((Bitmap) message.obj);
                }
            }
        }, config);
    }

    public boolean isBuildingsEnabled() throws MapNotExistApiException {
        return this.mIsBuildingEnabled;
    }

    public void setBuildingsEnabled(boolean z) throws MapNotExistApiException {
        DidiMap didiMap = this.mMap;
        if (didiMap != null) {
            this.mIsBuildingEnabled = z;
            didiMap.setDrawPillarWith2DStyle(!z);
        }
    }

    public boolean isTrafficEnabled() throws MapNotExistApiException {
        return this.mIsTraficEnabled;
    }

    public void setTrafficEnabled(boolean z) throws MapNotExistApiException {
        DidiMap didiMap = this.mMap;
        if (didiMap != null) {
            this.mIsTraficEnabled = z;
            didiMap.setTrafficEnabled(z);
        }
    }

    public boolean isIndoorEnabled() throws MapNotExistApiException {
        DLog.m7384d(TAG, "isIndoorEnabled not support", new Object[0]);
        return false;
    }

    public boolean setIndoorEnabled(boolean z) throws MapNotExistApiException {
        DLog.m7384d(TAG, "setIndoorEnabled not support", new Object[0]);
        return false;
    }

    public void moveCamera(CameraUpdate cameraUpdate) throws MapNotExistApiException {
        DidiMap didiMap;
        if (cameraUpdate != null && (didiMap = this.mMap) != null) {
            didiMap.moveCamera(Converter.convertToTencentCameraUpdate(this, cameraUpdate));
        }
    }

    public void animateCamera(CameraUpdate cameraUpdate) throws MapNotExistApiException {
        DidiMap didiMap;
        if (cameraUpdate != null && (didiMap = this.mMap) != null) {
            didiMap.animateCamera(Converter.convertToTencentCameraUpdate(this, cameraUpdate));
        }
    }

    public void animateCameraWithCallback(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) throws MapNotExistApiException {
        DidiMap didiMap;
        if (cameraUpdate != null && (didiMap = this.mMap) != null) {
            didiMap.animateCamera(Converter.convertToTencentCameraUpdate(this, cameraUpdate), Converter.convertToDidiCallback(cancelableCallback));
        }
    }

    public void animateCameraWithDurationAndCallback(CameraUpdate cameraUpdate, int i, CancelableCallback cancelableCallback) throws MapNotExistApiException {
        if (cameraUpdate != null && this.mMap != null) {
            try {
                com.didi.map.outer.map.CameraUpdate convertToTencentCameraUpdate = Converter.convertToTencentCameraUpdate(this, cameraUpdate);
                if (convertToTencentCameraUpdate != null) {
                    this.mMap.animateCamera(convertToTencentCameraUpdate, (long) i, Converter.convertToDidiCallback(cancelableCallback));
                }
            } catch (Exception e) {
                e.printStackTrace();
                DLog.m7384d(TAG, "animateCameraWithDurationAndCallback : " + e.toString(), new Object[0]);
            }
        }
    }

    public CameraPosition calculateZoomToSpanLevel(List<IMapElement> list, List<com.didi.common.map.model.LatLng> list2, int i, int i2, int i3, int i4) throws MapNotExistApiException {
        DidiMap didiMap = this.mMap;
        if (didiMap != null) {
            return didiMap.calculateZoomToSpanLevel(Converter.convertToDidiMapElements(list), Converter.convertToDidiLatLngs(list2), i, i2, i3, i4);
        }
        return null;
    }

    public float calculateZoomToSpanLevel(com.didi.common.map.model.LatLng latLng, com.didi.common.map.model.LatLng latLng2) throws MapNotExistApiException {
        return calculateZoomToSpanLevel(0, 0, 0, 0, latLng, latLng2, (com.didi.common.map.model.LatLng) null);
    }

    public float calculateZoomToSpanLevel(int i, int i2, int i3, int i4, com.didi.common.map.model.LatLng latLng, com.didi.common.map.model.LatLng latLng2, com.didi.common.map.model.LatLng latLng3) throws MapNotExistApiException {
        int i5;
        int i6;
        int i7;
        int i8;
        DidiMap didiMap = this.mMap;
        if (didiMap == null || didiMap.getCameraPosition() == null) {
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
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        if (latLng != null) {
            builder.include(Converter.convertToDidiLatLng(latLng));
        }
        if (latLng2 != null) {
            builder.include(Converter.convertToDidiLatLng(latLng2));
        }
        if (latLng3 != null) {
            builder.include(Converter.convertToDidiLatLng(latLng3));
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
        DidiMap didiMap = this.mMap;
        if (didiMap != null) {
            didiMap.stopAnimation();
        }
    }

    public com.didi.common.map.model.Marker addMarker(MarkerOptions markerOptions) throws MapNotExistApiException {
        if (markerOptions == null || this.mMapElementMap == null || this.mMap == null) {
            return null;
        }
        Marker addMarker = this.mMap.addMarker(Converter.convertToDidiMarkerOption(markerOptions));
        com.didi.common.map.model.Marker marker = new com.didi.common.map.model.Marker(new MarkerDelegate(addMarker, markerOptions, this.mMap));
        this.mMapElementMap.put(addMarker, marker);
        addMarker.setOnClickListener(this.mDidiOnMarkerClickListener);
        addMarker.setOnDragListener(this.mDidiOnMarkerDragListener);
        return marker;
    }

    public Line addLine(LineOptions lineOptions) throws MapNotExistApiException {
        DidiMap didiMap;
        if (lineOptions == null || this.mMapElementMap == null || (didiMap = this.mMap) == null) {
            return null;
        }
        Polyline addPolyline = this.mMap.addPolyline(Converter.convertToDidiPolyLineOption(lineOptions, didiMap.getMapView().getContext()));
        Line line = new Line(new LineDelegate(addPolyline, lineOptions, this.mMap.getMapView().getContext()));
        this.mMapElementMap.put(addPolyline, line);
        return line;
    }

    public Polygon addPolygon(PolygonOptions polygonOptions) throws MapNotExistApiException {
        if (polygonOptions == null || this.mMapElementMap == null || this.mMap == null) {
            return null;
        }
        com.didi.map.outer.model.Polygon addPolygon = this.mMap.addPolygon(Converter.convertToDidiPolygonOptions(polygonOptions));
        Polygon polygon = new Polygon(new PolygonDelegate(addPolygon, polygonOptions));
        this.mMapElementMap.put(addPolygon, polygon);
        return polygon;
    }

    public Circle addCircle(CircleOptions circleOptions) throws MapNotExistApiException {
        if (circleOptions == null || this.mMapElementMap == null || this.mMap == null) {
            return null;
        }
        com.didi.map.outer.model.Circle addCircle = this.mMap.addCircle(Converter.convertToDidiCircleOptions(circleOptions));
        Circle circle = new Circle(new CircleDelegate(addCircle, circleOptions));
        this.mMapElementMap.put(addCircle, circle);
        return circle;
    }

    @Deprecated
    public MaskLayer addMaskLayer(MaskLayerOptions maskLayerOptions) throws MapNotExistApiException {
        if (maskLayerOptions == null || this.mMapElementMap == null || this.mMap == null) {
            return null;
        }
        com.didi.map.outer.model.MaskLayer addMaskLayer = this.mMap.addMaskLayer(Converter.convertToDidiMaskLayerOptions(maskLayerOptions));
        MaskLayer maskLayer = new MaskLayer(new MaskLayerDelegate(addMaskLayer));
        this.mMapElementMap.put(addMaskLayer, maskLayer);
        return maskLayer;
    }

    public void clear() throws MapNotExistApiException {
        DidiMap didiMap = this.mMap;
        if (didiMap != null) {
            didiMap.clear();
        }
    }

    public boolean isMyLocationEnabled() throws MapNotExistApiException {
        DidiMap didiMap = this.mMap;
        return didiMap != null && didiMap.isMyLocationEnabled();
    }

    public void setMyLocationEnabled(boolean z) throws MapNotExistApiException {
        DidiMap didiMap = this.mMap;
        if (didiMap != null) {
            didiMap.setMyLocationEnabled(z);
        }
    }

    public Location getMyLocation() throws MapNotExistApiException {
        DidiMap didiMap = this.mMap;
        if (didiMap == null) {
            return null;
        }
        return didiMap.getMyLocation();
    }

    public void onCreate(Bundle bundle) throws MapNotExistApiException {
        DLog.m7384d(TAG, "didi onCreate not support", new Object[0]);
    }

    public void onStart() throws MapNotExistApiException {
        com.didi.map.outer.map.MapView mapView = this.mMapView;
        if (mapView != null) {
            mapView.onStart();
        }
    }

    public void onResume() throws MapNotExistApiException {
        com.didi.map.outer.map.MapView mapView = this.mMapView;
        if (mapView != null) {
            mapView.onResume();
        }
    }

    public void onPause() throws MapNotExistApiException {
        com.didi.map.outer.map.MapView mapView = this.mMapView;
        if (mapView != null) {
            mapView.onPause();
        }
    }

    public void onStop() throws MapNotExistApiException {
        com.didi.map.outer.map.MapView mapView = this.mMapView;
        if (mapView != null) {
            mapView.onStop();
        }
    }

    public void onDestroy() throws MapNotExistApiException {
        com.didi.map.outer.map.MapView mapView = this.mMapView;
        if (mapView != null) {
            mapView.onDestroy();
            this.mMapView = null;
        }
        MapTouchEventListener mapTouchEventListener = this.mMapTouchEventListener;
        if (mapTouchEventListener != null) {
            mapTouchEventListener.destroy();
            this.mMapTouchEventListener = null;
        }
    }

    public void onLowMemory() throws MapNotExistApiException {
        DLog.m7384d(TAG, "onLowMemory -- not support", new Object[0]);
    }

    public void onSaveInstanceState(Bundle bundle) throws MapNotExistApiException {
        DLog.m7384d(TAG, "onSaveInstanceState -- not support", new Object[0]);
    }

    public Padding getPadding() {
        return this.mPadding;
    }

    public void setPadding(int i, int i2, int i3, int i4) throws MapNotExistApiException {
        if (this.mMap != null) {
            if (this.mPadding.left != i || this.mPadding.right != i3 || this.mPadding.bottom != i4 || this.mPadding.top != i2) {
                this.mPadding.left = i;
                this.mPadding.right = i3;
                this.mPadding.top = i2;
                this.mPadding.bottom = i4;
                this.mMap.setMapPadding(i, i2, i3, i4);
            }
        }
    }

    public void getMapAsync(MapView.InnerMapReadyCallBack innerMapReadyCallBack) {
        if (this.mMap != null) {
            innerMapReadyCallBack.onMapReady();
            return;
        }
        CopyOnWriteArrayList<MapView.InnerMapReadyCallBack> copyOnWriteArrayList = this.mOnMapReadyListeners;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.contains(innerMapReadyCallBack)) {
            this.mOnMapReadyListeners.add(innerMapReadyCallBack);
        }
    }

    @Deprecated
    public void addOnPolygonClickListener(OnPolygonClickListener onPolygonClickListener) {
        DLog.m7384d(TAG, "addOnPolygonClickListener -- not support", new Object[0]);
    }

    @Deprecated
    public void removeOnPolygonClickListener(OnPolygonClickListener onPolygonClickListener) {
        DLog.m7384d(TAG, "removeOnPolygonClickListener -- not support", new Object[0]);
    }

    public void addOnLineClickListener(OnLineClickListener onLineClickListener) {
        if (!this.mOnLineClickListeners.contains(onLineClickListener)) {
            this.mOnLineClickListeners.add(onLineClickListener);
        }
    }

    public void removeOnLineClickListener(OnLineClickListener onLineClickListener) {
        this.mOnLineClickListeners.remove(onLineClickListener);
    }

    public void addOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (!this.mOnMarkerClickListeners.contains(onMarkerClickListener)) {
            this.mOnMarkerClickListeners.add(onMarkerClickListener);
        }
    }

    public void removeOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        this.mOnMarkerClickListeners.remove(onMarkerClickListener);
    }

    public void addOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        if (!this.mOnMarkerDragListeners.contains(onMarkerDragListener)) {
            this.mOnMarkerDragListeners.add(onMarkerDragListener);
        }
    }

    public void removeOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        this.mOnMarkerDragListeners.remove(onMarkerDragListener);
    }

    @Deprecated
    public void addOnGroundOverlayClickListener(OnGroundOverlayClickListener onGroundOverlayClickListener) {
        DLog.m7384d(TAG, "addOnGroundOverlayClickListener -- not support", new Object[0]);
    }

    @Deprecated
    public void removeOnGroundOverlayClickListener(OnGroundOverlayClickListener onGroundOverlayClickListener) {
        DLog.m7384d(TAG, "removeOnGroundOverlayClickListener -- not support", new Object[0]);
    }

    @Deprecated
    public void addOnCircleClickListener(OnCircleClickListener onCircleClickListener) {
        DLog.m7384d(TAG, "addOnCircleClickListener -- not support", new Object[0]);
    }

    @Deprecated
    public void removeOnCircleClickListener(OnCircleClickListener onCircleClickListener) {
        DLog.m7384d(TAG, "removeOnCircleClickListener -- not support", new Object[0]);
    }

    public Object getVendorMap() {
        return this.mMap;
    }

    public void addOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) throws MapNotExistApiException {
        MapTouchEventListener mapTouchEventListener = this.mMapTouchEventListener;
        if (mapTouchEventListener != null) {
            mapTouchEventListener.addOnCameraChangeListener(onCameraChangeListener);
        }
    }

    public void removeOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) throws MapNotExistApiException {
        MapTouchEventListener mapTouchEventListener = this.mMapTouchEventListener;
        if (mapTouchEventListener != null) {
            mapTouchEventListener.removeOnCameraChangeListener(onCameraChangeListener);
        }
    }

    public void addOnMapGestureListener(OnMapGestureListener onMapGestureListener) throws MapNotExistApiException {
        MapTouchEventListener mapTouchEventListener = this.mMapTouchEventListener;
        if (mapTouchEventListener != null) {
            mapTouchEventListener.addOnMapGestureListener(onMapGestureListener);
        }
    }

    public void removeOnMapGestureListener(OnMapGestureListener onMapGestureListener) throws MapNotExistApiException {
        MapTouchEventListener mapTouchEventListener = this.mMapTouchEventListener;
        if (mapTouchEventListener != null) {
            mapTouchEventListener.removeOnMapGestureListener(onMapGestureListener);
        }
    }

    public void addOnMapClickListener(OnMapClickListener onMapClickListener) throws MapNotExistApiException {
        MapTouchEventListener mapTouchEventListener = this.mMapTouchEventListener;
        if (mapTouchEventListener != null) {
            mapTouchEventListener.addOnMapClickListener(onMapClickListener);
        }
    }

    public void removeOnMapClickListener(OnMapClickListener onMapClickListener) throws MapNotExistApiException {
        MapTouchEventListener mapTouchEventListener = this.mMapTouchEventListener;
        if (mapTouchEventListener != null) {
            mapTouchEventListener.removeOnMapClickListener(onMapClickListener);
        }
    }

    public void addOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) throws MapNotExistApiException {
        MapTouchEventListener mapTouchEventListener = this.mMapTouchEventListener;
        if (mapTouchEventListener != null) {
            mapTouchEventListener.addOnMapLongClickListener(onMapLongClickListener);
        }
    }

    public void removeOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) throws MapNotExistApiException {
        MapTouchEventListener mapTouchEventListener = this.mMapTouchEventListener;
        if (mapTouchEventListener != null) {
            mapTouchEventListener.removeOnMapLongClickListener(onMapLongClickListener);
        }
    }

    public void addOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) throws MapNotExistApiException {
        MapTouchEventListener mapTouchEventListener = this.mMapTouchEventListener;
        if (mapTouchEventListener != null) {
            mapTouchEventListener.addOnMapLoadedCallback(onMapLoadedCallback);
        }
    }

    public void removeOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) throws MapNotExistApiException {
        MapTouchEventListener mapTouchEventListener = this.mMapTouchEventListener;
        if (mapTouchEventListener != null) {
            mapTouchEventListener.removeOnMapLoadedCallback(onMapLoadedCallback);
        }
    }

    /* access modifiers changed from: private */
    public Line getCommonLineByDidiLine(Polyline polyline) {
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

    /* access modifiers changed from: private */
    public com.didi.common.map.model.Marker getCommonMarkerByDidiMarker(Marker marker) {
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

    public boolean IsDegrade() {
        return this.mIsDegrade;
    }

    public void updateIsNight(boolean z) {
        DidiMap didiMap = this.mMap;
        if (didiMap != null) {
            didiMap.setModNav(true);
            this.mMap.setModDark(z);
        }
    }

    public void setRotateAngle(float f) {
        DidiMap didiMap = this.mMap;
        if (didiMap != null) {
            didiMap.setRotateAngle(f);
            this.mMap.setFPS(2);
        }
    }

    public Context getContext() {
        return this.mContext;
    }
}
