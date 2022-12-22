package com.didi.hawaii.mapsdkv2;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.mapsdkv2.adapter.BezireCurveDelegate;
import com.didi.hawaii.mapsdkv2.adapter.CircleDelegate;
import com.didi.hawaii.mapsdkv2.adapter.CollisionGroupDelegate;
import com.didi.hawaii.mapsdkv2.adapter.HeatMapDelegate;
import com.didi.hawaii.mapsdkv2.adapter.LocatorDelegate;
import com.didi.hawaii.mapsdkv2.adapter.MapManagerDelegate;
import com.didi.hawaii.mapsdkv2.adapter.MarkerDelegate;
import com.didi.hawaii.mapsdkv2.adapter.MarkerViewDelegate;
import com.didi.hawaii.mapsdkv2.adapter.MaskLayerDelegate;
import com.didi.hawaii.mapsdkv2.adapter.MyLocationDelegate;
import com.didi.hawaii.mapsdkv2.adapter.PolygonDelegate;
import com.didi.hawaii.mapsdkv2.adapter.PolylineRouteDelegate;
import com.didi.hawaii.mapsdkv2.adapter.UiSettingDelegate;
import com.didi.hawaii.mapsdkv2.adapter.traffic.TrafficEventIconDelegate;
import com.didi.hawaii.mapsdkv2.core.GLBaseMapView;
import com.didi.hawaii.mapsdkv2.core.GLInstrumentation;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.RenderProfile;
import com.didi.hawaii.mapsdkv2.widget.MapWidgets;
import com.didi.map.alpha.adapt.MapUtil;
import com.didi.map.alpha.maps.internal.BezierCurveControl;
import com.didi.map.alpha.maps.internal.CircleControl;
import com.didi.map.alpha.maps.internal.HeatOverlayControl;
import com.didi.map.alpha.maps.internal.LableMarkerManager;
import com.didi.map.alpha.maps.internal.LableMarkerManager_v3;
import com.didi.map.alpha.maps.internal.LocationControl;
import com.didi.map.alpha.maps.internal.LocatorControl;
import com.didi.map.alpha.maps.internal.MarkerControl;
import com.didi.map.alpha.maps.internal.MaskLayerControl;
import com.didi.map.alpha.maps.internal.PolygonControl;
import com.didi.map.alpha.maps.internal.PolylineControl;
import com.didi.map.alpha.maps.internal.UiSettingControl;
import com.didi.map.base.RouteSectionWithName;
import com.didi.map.base.TextLableOnRoute;
import com.didi.map.base.TrafficEventModel;
import com.didi.map.base.TrafficEventRoutePoint;
import com.didi.map.base.bubble.Bubble;
import com.didi.map.base.bubble.BubbleManager;
import com.didi.map.base.bubble.TrafficHintShowBarn;
import com.didi.map.common.TrafficEventManager;
import com.didi.map.common.TrafficEventObserver;
import com.didi.map.common.utils.SystemUtil;
import com.didi.map.core.FrameCallback;
import com.didi.map.core.SurfaceChangeListener;
import com.didi.map.core.base.OnMapScaleChangedListener;
import com.didi.map.core.base.impl.OnMapGestureListener;
import com.didi.map.core.base.impl.OnMapModeListener;
import com.didi.map.core.element.MapTrafficIcon;
import com.didi.map.core.element.OnMapElementClickListener;
import com.didi.map.core.point.DoublePoint;
import com.didi.map.core.point.GeoPoint;
import com.didi.map.outer.map.CameraUpdate;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.map.DidiMapExt;
import com.didi.map.outer.map.InfoWindowAnimationManager;
import com.didi.map.outer.map.LocationSource;
import com.didi.map.outer.map.MapAccessManager;
import com.didi.map.outer.map.MapView;
import com.didi.map.outer.map.Projection;
import com.didi.map.outer.map.UiSettings;
import com.didi.map.outer.model.BezierCurve;
import com.didi.map.outer.model.BezierCurveOption;
import com.didi.map.outer.model.BitmapTileOverlay;
import com.didi.map.outer.model.BitmapTileOverlayOption;
import com.didi.map.outer.model.BubbleGroup;
import com.didi.map.outer.model.BubbleOptions;
import com.didi.map.outer.model.CameraPosition;
import com.didi.map.outer.model.Circle;
import com.didi.map.outer.model.CircleOptions;
import com.didi.map.outer.model.CollisionGroup;
import com.didi.map.outer.model.CollisionGroupOption;
import com.didi.map.outer.model.HeatOverlay;
import com.didi.map.outer.model.HeatOverlayOptions;
import com.didi.map.outer.model.IMapElement;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;
import com.didi.map.outer.model.Locator;
import com.didi.map.outer.model.MapAllGestureListener;
import com.didi.map.outer.model.MapGestureListener;
import com.didi.map.outer.model.Marker;
import com.didi.map.outer.model.MarkerGroup;
import com.didi.map.outer.model.MarkerOptions;
import com.didi.map.outer.model.MarkerView;
import com.didi.map.outer.model.MaskLayer;
import com.didi.map.outer.model.MaskLayerOptions;
import com.didi.map.outer.model.MyLocationOption;
import com.didi.map.outer.model.OutBlockInfo;
import com.didi.map.outer.model.Polygon;
import com.didi.map.outer.model.PolygonOptions;
import com.didi.map.outer.model.Polyline;
import com.didi.map.outer.model.PolylineOptions;
import com.didi.navi.core.auto.OnMapAutoCameraExecutor;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class HWDidiMap implements DidiMapExt {

    /* renamed from: b */
    private static final String f23648b = "HWDidiMap";

    /* renamed from: A */
    private final BubbleManager f23649A;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f23650a = false;

    /* renamed from: c */
    private final Map<String, Pair<?, GLOverlayView>> f23651c = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final MapManagerDelegate f23652d;

    /* renamed from: e */
    private final MarkerControl f23653e;

    /* renamed from: f */
    private final BezierCurveControl f23654f;

    /* renamed from: g */
    private final LocatorControl f23655g;

    /* renamed from: h */
    private final PolylineControl f23656h;

    /* renamed from: i */
    private final PolygonControl f23657i;

    /* renamed from: j */
    private final CircleControl f23658j;

    /* renamed from: k */
    private final MaskLayerControl f23659k;

    /* renamed from: l */
    private final HeatOverlayControl f23660l;

    /* renamed from: m */
    private final CollisionGroupDelegate f23661m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final TrafficEventIconDelegate f23662n;

    /* renamed from: o */
    private final WeakReference<MapHost> f23663o;

    /* renamed from: p */
    private final LocationControl f23664p;

    /* renamed from: q */
    private final UiSettingDelegate f23665q;

    /* renamed from: r */
    private WeakReference<MapView> f23666r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public final DidiMap.OnLableMarkerCallback f23667s;

    /* renamed from: t */
    private final MapAccessManager f23668t;

    /* renamed from: u */
    private final MarkerViewDelegate f23669u;

    /* renamed from: v */
    private final Handler f23670v;

    /* renamed from: w */
    private boolean f23671w = false;

    /* renamed from: x */
    private TrafficEventObserver f23672x;

    /* renamed from: y */
    private UiSettings f23673y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public DidiMapExt.BubbleLoadBitmapListener f23674z;

    public BitmapTileOverlay addBitmapTileOverlay(BitmapTileOverlayOption bitmapTileOverlayOption) {
        return null;
    }

    public int addBubble(BubbleOptions bubbleOptions) {
        return 0;
    }

    public BubbleGroup addBubbleGroup(List<BubbleOptions> list) {
        return null;
    }

    public List<Integer> addBubbles(List<BubbleOptions> list) {
        return null;
    }

    @Deprecated
    public void addMapClickListener(DidiMap.OnMapClickListener onMapClickListener) {
    }

    @Deprecated
    public void addMapGestureListener2(OnMapGestureListener onMapGestureListener) {
    }

    public MarkerGroup addMarkerGroup() {
        return null;
    }

    @Deprecated
    public void animateToNaviPosition(LatLng latLng, float f, float f2) {
    }

    @Deprecated
    public void animateToNaviPosition(LatLng latLng, float f, float f2, float f3) {
    }

    @Deprecated
    public void animateToNaviPosition(LatLng latLng, float f, float f2, float f3, float f4, boolean z, boolean z2) {
    }

    @Deprecated
    public void animateToNaviPosition(LatLng latLng, float f, float f2, float f3, boolean z) {
    }

    @Deprecated
    public void animateToNaviPosition2(LatLng latLng, float f, float f2, float f3, boolean z) {
    }

    public void clearBubbles() {
    }

    public void clearRealTrafficIcon() {
    }

    public List<Rect> getElementScreenBound(List<String> list) {
        return null;
    }

    public InfoWindowAnimationManager getInfoWindowAnimationManager() {
        return null;
    }

    public float getLogoMarginRate(int i) {
        return 0.0f;
    }

    public float getMapSkew() {
        return 0.0f;
    }

    public Rect getMarkerBound(Marker marker) {
        return null;
    }

    public GeoPoint getMarkerGeoPoint(Marker marker) {
        return null;
    }

    public OnMapAutoCameraExecutor getNavAutoMapActionExecutor() {
        return null;
    }

    public int getSDKVersion() {
        return 2;
    }

    public void onPause() {
    }

    public void onRestart() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public boolean removeBubble(int i) {
        return false;
    }

    public void setCompassExtraPadding(int i) {
    }

    public void setCompassExtraPadding(int i, int i2) {
    }

    public void setFrameCallback(FrameCallback frameCallback) {
    }

    public void setInfoWindowStillVisible(boolean z) {
    }

    public void setLocationInfo(GeoPoint geoPoint, float f, float f2, boolean z) {
    }

    public void setLogoAnchor(int i) {
    }

    public void setLogoAnchorWithMargin(int i, int i2, int i3, int i4, int i5) {
    }

    public void setLogoBottomMargin(int i) {
    }

    public void setLogoLeftMargin(int i) {
    }

    public void setLogoMarginRate(int i, float f) {
    }

    public void setLogoVisible(boolean z) {
    }

    public void setMapEventApollo(boolean z) {
    }

    public void setMapGestureListener(MapGestureListener mapGestureListener) {
    }

    public void setOnMapChangeCallback(DidiMapExt.OnMapParamChangeCallback onMapParamChangeCallback) {
    }

    public void setOnTapMapViewInfoWindowHidden(boolean z) {
    }

    public void setScaleAnchor(int i) {
    }

    public void setScaleAnchorWithMargin(int i, int i2, int i3, int i4, int i5) {
    }

    public void setSuid(String str) {
    }

    @Deprecated
    public void setTrafficColor(int i, int i2, int i3, int i4) {
    }

    @Deprecated
    public void updateScaleView() {
    }

    HWDidiMap(MapHost mapHost, MapView mapView) {
        MapUtil.getScreenType(mapHost.getContext());
        MapUtil.initBasicInfo(mapHost.getContext());
        this.f23663o = new WeakReference<>(mapHost);
        GLViewManager gLViewManage = mapHost.getGLViewManage();
        this.f23670v = gLViewManage.getMainHandler();
        this.f23666r = new WeakReference<>(mapView);
        MapWidgets mapWidgets = new MapWidgets(mapView, gLViewManage.getBaseMap());
        this.f23652d = new MapManagerDelegate(gLViewManage, this.f23651c, mapWidgets);
        this.f23669u = new MarkerViewDelegate(gLViewManage, this.f23651c, mapView, this);
        this.f23654f = new BezierCurveControl(new BezireCurveDelegate(gLViewManage, this.f23651c));
        this.f23653e = new MarkerControl(new MarkerDelegate(gLViewManage, this.f23651c, mapView, this.f23669u));
        this.f23656h = new PolylineControl(new PolylineRouteDelegate(gLViewManage, this.f23651c));
        this.f23657i = new PolygonControl(new PolygonDelegate(gLViewManage, this.f23651c));
        this.f23658j = new CircleControl(new CircleDelegate(gLViewManage, this.f23651c));
        this.f23659k = new MaskLayerControl(new MaskLayerDelegate(gLViewManage, this.f23651c));
        this.f23660l = new HeatOverlayControl(new HeatMapDelegate(gLViewManage, this.f23651c));
        this.f23661m = new CollisionGroupDelegate(new MarkerDelegate(gLViewManage, this.f23651c, mapView, this.f23669u), this.f23652d, gLViewManage, this.f23651c);
        this.f23655g = new LocatorControl(new LocatorDelegate(gLViewManage, this.f23651c));
        this.f23664p = new LocationControl(new MyLocationDelegate(gLViewManage, this.f23651c, this));
        this.f23665q = new UiSettingDelegate(gLViewManage, mapWidgets);
        BubbleManager bubbleManager = new BubbleManager(this);
        this.f23649A = bubbleManager;
        this.f23653e.setBubbleManager(bubbleManager);
        this.f23662n = new TrafficEventIconDelegate(this, this.f23652d);
        gLViewManage.getBaseMap().setBitmapLoaderListener(new GLBaseMapView.BitmapLoaderListener() {
            public Bitmap onLoadBitmap(int i, String str) {
                if (HWDidiMap.this.f23674z != null) {
                    return HWDidiMap.this.f23674z.onBitmapLoader(i, str);
                }
                return null;
            }
        });
        this.f23667s = new LableMarkerManager_v3(this);
        this.f23672x = new TrafficEventObserver() {
            public void showLocalTrafficIcon() {
                if (HWDidiMap.this.isShowFakeTrafficEvent()) {
                    TrafficEventManager.getInstance().showTrafficLocalIcon(HWDidiMap.this);
                }
            }
        };
        gLViewManage.getBaseMap().setLabelOnRouteCallback(new GLBaseMapView.LabelOnRouteCallback() {
            public void onRouteNew(List<TextLableOnRoute> list) {
                HWDidiMap.this.f23667s.onLableRouteCallback(list);
            }
        });
        m16815a();
        MapAccessibilityDelegate mapAccessibilityDelegate = new MapAccessibilityDelegate();
        this.f23668t = mapAccessibilityDelegate;
        this.f23653e.setAccessibilityDelegate(mapAccessibilityDelegate);
    }

    /* renamed from: a */
    private void m16815a() {
        TrafficEventManager.getInstance().addObserver(this.f23672x);
    }

    public void setModNav(boolean z) {
        this.f23652d.setModeNavi(z);
    }

    public void setModDark(boolean z) {
        if (this.f23650a) {
            this.f23662n.toggleDayNight(z);
        }
        this.f23652d.setModeNight(z);
        this.f23667s.setDayNight(z);
    }

    public GeoPoint getCenter() {
        return new GeoPoint((int) (this.f23652d.getCameraPosition().target.longitude * 1000000.0d), (int) (this.f23652d.getCameraPosition().target.latitude * 1000000.0d));
    }

    public void setCenter(GeoPoint geoPoint) {
        if (geoPoint != null) {
            this.f23652d.setCenter(new LatLng(((double) geoPoint.getLatitudeE6()) / 1000000.0d, ((double) geoPoint.getLongitudeE6()) / 1000000.0d));
        }
    }

    public void setCenter(LatLng latLng) {
        if (latLng != null) {
            this.f23652d.setCenter(latLng);
        }
    }

    @Deprecated
    public void setNaviCenter(int i, int i2) {
        this.f23652d.setNaviCenter(i, i2);
    }

    public void setInfoWindowUnique(boolean z) {
        this.f23653e.setInfoWindowUnique(z);
    }

    public void setRotateAngle(float f) {
        this.f23652d.setRotateAngle(f);
    }

    public void setSkewAngle(float f) {
        this.f23652d.setSkewAngle(f);
    }

    public void showTrafficHintIcon(long j, TrafficHintShowBarn trafficHintShowBarn) {
        if (this.f23650a) {
            this.f23662n.showTrafficHintIcon(j, trafficHintShowBarn);
        }
    }

    public void removeTrafficHintIcon() {
        if (this.f23650a) {
            this.f23662n.removeTrafficHintIcon();
        }
    }

    public void setTrafficEventIconCustomSize(int i) {
        this.f23662n.setTrafficEventIconCustomSize(i, this.f23650a);
        this.f23652d.setTrafficEventIconCustomSize(i);
    }

    public void resetTrafficEventIconCustomSize() {
        this.f23652d.resetTrafficEventIconCustomSize();
    }

    public CameraPosition getCameraPosition() {
        return this.f23652d.getCameraPosition();
    }

    public void setMaxSkew(float f) {
        this.f23652d.setMaxSkew(f);
    }

    public float getMaxSkew() {
        return this.f23652d.getMaxSkew();
    }

    public float getMaxZoomLevel() {
        return this.f23652d.getMaxZoomLevel();
    }

    public float getMinZoomLevel() {
        return this.f23652d.getMinZoomLevel();
    }

    public void moveCamera(CameraUpdate cameraUpdate) {
        this.f23652d.moveCamera(cameraUpdate);
    }

    public void animateCamera(CameraUpdate cameraUpdate) {
        this.f23652d.animateCamera(cameraUpdate, 500, (DidiMap.CancelableCallback) null);
    }

    public void animateCamera(CameraUpdate cameraUpdate, DidiMap.CancelableCallback cancelableCallback) {
        this.f23652d.animateCamera(cameraUpdate, 500, cancelableCallback);
    }

    public void animateCamera(CameraUpdate cameraUpdate, long j, DidiMap.CancelableCallback cancelableCallback) {
        this.f23652d.animateCamera(cameraUpdate, j, cancelableCallback);
    }

    public float getZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        return this.f23652d.getZoomToSpanLevel(latLng, latLng2);
    }

    public void stopAnimation() {
        this.f23652d.stopAnimation();
    }

    public HeatOverlay addHeatOverlay(HeatOverlayOptions heatOverlayOptions) {
        return this.f23660l.addHeatOverlay(heatOverlayOptions);
    }

    public Polyline addPolyline(PolylineOptions polylineOptions) {
        return this.f23656h.addPolyline(polylineOptions);
    }

    public Polygon addPolygon(PolygonOptions polygonOptions) {
        return this.f23657i.addPolygon(polygonOptions);
    }

    public Circle addCircle(CircleOptions circleOptions) {
        return this.f23658j.addCircle(circleOptions);
    }

    public Marker addMarker(MarkerOptions markerOptions) {
        MarkerControl markerControl = this.f23653e;
        Marker addMarker = markerControl.addMarker(markerOptions, markerControl);
        LableMarkerManager.addOtherMarker(addMarker);
        return addMarker;
    }

    public BezierCurve addBezierCurve(BezierCurveOption bezierCurveOption) {
        return this.f23654f.addBezierCurve(bezierCurveOption);
    }

    public Locator getLocator() {
        return this.f23655g.getLocator();
    }

    public void clear() {
        this.f23652d.clearAll();
        this.f23661m.clearGroup();
    }

    public int getMapType() {
        return this.f23652d.getMapType();
    }

    public void setSatelliteEnabled(boolean z) {
        this.f23652d.setSatelliteEnabled(z);
    }

    public boolean isMyLocationEnabled() {
        return this.f23664p.isProviderEnable();
    }

    public void setMyLocationEnabled(boolean z) {
        if (z) {
            this.f23664p.enableMylocation();
        } else {
            this.f23664p.disableMylocation();
        }
    }

    public void setMyLocationEnabled(boolean z, float f, float f2, float f3) {
        if (z) {
            this.f23664p.enableMylocation();
        } else {
            this.f23664p.disableMylocation();
        }
    }

    public void setMyLocationOption(MyLocationOption myLocationOption) {
        this.f23664p.setMyLocationOption(myLocationOption);
    }

    public void setMyLocationOption(MyLocationOption myLocationOption, float f, float f2, float f3) {
        this.f23664p.setMyLocationOption(myLocationOption, f, f2, f3);
    }

    public MyLocationOption getMyLocationOption() {
        return this.f23664p.getMyLocationOption();
    }

    public Location getMyLocation() {
        return this.f23664p.getMyLocation();
    }

    public void setLocationSource(LocationSource locationSource) {
        this.f23664p.setLocationSource(locationSource);
    }

    public UiSettings getUiSettings() {
        if (this.f23673y == null) {
            this.f23673y = new UiSettings(new UiSettingControl(this.f23665q));
        }
        return this.f23673y;
    }

    public Projection getProjection() {
        return this.f23652d.getProjection();
    }

    public void setNaviOnPolylineClickListener(DidiMap.OnPolylineClickListener onPolylineClickListener) {
        this.f23652d.setNaviOnPolylineClickListener(onPolylineClickListener);
    }

    public void setOnPolylineClickListener(DidiMap.OnPolylineClickListener onPolylineClickListener) {
        this.f23652d.setOnPolylineClickListenner(onPolylineClickListener);
    }

    public void setNaviOnMapClickListener(DidiMap.OnMapClickListener onMapClickListener) {
        this.f23652d.setNaviOnMapClickListener(onMapClickListener);
    }

    public void setOnCameraChangeListener(DidiMap.OnCameraChangeListener onCameraChangeListener) {
        this.f23652d.setOnCameraChangeListener(onCameraChangeListener);
    }

    public void addModeListener(OnMapModeListener onMapModeListener) {
        this.f23652d.addModeListener(onMapModeListener);
    }

    @Deprecated
    public void setOnMapClickListener(DidiMap.OnMapClickListener onMapClickListener) {
        this.f23652d.setOnMapClickListener(onMapClickListener);
    }

    public void addOnMapClickListener(DidiMap.OnMapClickListener onMapClickListener) {
        this.f23652d.addOnMapClickListener(onMapClickListener);
    }

    public void removeOnMapClickListener(DidiMap.OnMapClickListener onMapClickListener) {
        this.f23652d.removeOnMapClickListener(onMapClickListener);
    }

    public void clearOnMapClickListener() {
        this.f23652d.clearOnMapClickListener();
    }

    public void setOnMapLongClickListener(DidiMap.OnMapLongClickListener onMapLongClickListener) {
        this.f23652d.setOnMapLongClickListener(onMapLongClickListener);
    }

    public void setOnMyLocationChangeListener(DidiMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        this.f23664p.setOnMyLocationChangeListener(onMyLocationChangeListener);
    }

    public void setOnCompassClickedListener(DidiMap.OnCompassClickedListener onCompassClickedListener) {
        this.f23652d.setOnCompassClickedListener(onCompassClickedListener);
    }

    public void setOnMapLoadedCallback(DidiMap.OnMapLoadedCallback onMapLoadedCallback) {
        this.f23652d.setOnMapLoadedCallback(onMapLoadedCallback);
    }

    public void getScreenShot(Handler handler, Bitmap.Config config) {
        this.f23652d.getScreenShot(handler, config);
    }

    public String getCityName(LatLng latLng) {
        return this.f23652d.getCityName(latLng);
    }

    public void addMapGestureListener(MapGestureListener mapGestureListener) {
        this.f23652d.addMapGestureListener(mapGestureListener);
    }

    public void removeMapGestureListener(MapGestureListener mapGestureListener) {
        this.f23652d.removeMapGestureListener(mapGestureListener);
    }

    public void addMapAllGestureListener(MapAllGestureListener mapAllGestureListener) {
        this.f23652d.addMapAllGestureListener(mapAllGestureListener);
    }

    public void removeMapGestureListener(MapAllGestureListener mapAllGestureListener) {
        this.f23652d.removeMapAllGestureListener(mapAllGestureListener);
    }

    public void setVecEnlargeVisibleArea(int i, int i2, int i3, int i4, float f) {
        this.f23652d.setVecEnlargeVisibleArea(i, i2, i3, i4, f);
    }

    public float calcuteZoomToSpanLevel(int i, int i2, int i3, int i4, LatLng latLng, LatLng latLng2, LatLng latLng3) {
        return this.f23652d.calcuteZoomToSpanLevel(i, i2, i3, i4, latLng, latLng2, latLng3);
    }

    public CameraPosition calculateZoomToSpanLevel(List<IMapElement> list, List<LatLng> list2, int i, int i2, int i3, int i4) {
        return this.f23652d.calculateZoomToSpanLevel(list, list2, i, i2, i3, i4);
    }

    public CameraPosition calculateZoomToSpanLevel(List<IMapElement> list, List<LatLng> list2, int i, int i2, int i3, int i4, LatLng latLng) {
        return this.f23652d.calculateZoomToSpanLevel(list, list2, i, i2, i3, i4, latLng);
    }

    public CameraPosition calculateCameraPosition(List<IMapElement> list, List<LatLng> list2, List<DidiMap.ViewBounds> list3, int i, int i2, int i3, int i4) {
        return this.f23652d.calculateCameraPosition(list, list2, list3, new Rect(i, i2, i3, i4));
    }

    public float calNaviLevel(LatLngBounds latLngBounds, float f, int i, boolean z) {
        return this.f23652d.calNaviLevel(latLngBounds, f, i, z);
    }

    public float calNaviLevel2(LatLng latLng, LatLng latLng2, float f, float f2, int i, int i2, boolean z) {
        return this.f23652d.calNaviLevel2(latLng, latLng2, f, f2, i, i2, z);
    }

    public float calNaviLevel3(LatLng latLng, LatLng latLng2, float f, float f2, int i, int i2, boolean z, float f3) {
        return this.f23652d.calNaviLevel3(latLng, latLng2, f, f2, i, i2, z, f3);
    }

    public void setNaviFixingProportion(float f, float f2) {
        this.f23652d.setNaviFixingProportion(f, f2);
    }

    public void setNaviFixingProportion2D(float f, float f2) {
        this.f23652d.setNaviFixingProportion2D(f, f2);
    }

    public void setMapScreenCenterProportion(float f, float f2) {
        this.f23652d.setMapScreenCenterProportion(f, f2, true);
    }

    public void setMapScreenCenterProportion(float f, float f2, boolean z) {
        this.f23652d.setMapScreenCenterProportion(f, f2, z);
    }

    public String getVersion() {
        return this.f23652d.getVersion();
    }

    public boolean isDestroyed() {
        return this.f23671w;
    }

    public void setDrawPillarWith2DStyle(boolean z) {
        if (z) {
            this.f23652d.setDrawPillarWith2DStyle(z);
        }
    }

    public void setPillarVisible(boolean z) {
        setDrawPillarWith2DStyle(!z);
    }

    public void setScaleCenter(float f, float f2) {
        this.f23652d.setScaleCenter(f, f2);
    }

    public void setMapCenterAndScale(float f, float f2, float f3) {
        this.f23652d.setMapCenterAndScale(f, f2, f3);
    }

    public MaskLayer addMaskLayer(MaskLayerOptions maskLayerOptions) {
        return this.f23659k.addMaskLayer(maskLayerOptions);
    }

    public void setMapPadding(int i, int i2, int i3, int i4) {
        this.f23652d.setMapPadding(i, i2, i3, i4, true);
    }

    @Deprecated
    public void setMapPadding(int i, int i2, int i3, int i4, boolean z) {
        this.f23652d.setMapPadding(i, i2, i3, i4, false);
    }

    public void setCompassMarkerHidden(boolean z) {
        this.f23665q.setCompassEnabled(!z);
    }

    public Rect getMapPadding() {
        return this.f23652d.getMapPadding();
    }

    public List<LatLng> getBounderPoints(Marker marker) {
        if (marker == null) {
            return null;
        }
        return this.f23653e.getBounderPoints(marker.getId());
    }

    public float getLocationRadius(double d, LatLng latLng) {
        if (latLng != null) {
            return (float) (d / getProjection().metersPerPixel(latLng.latitude));
        }
        return 0.0f;
    }

    public List<LatLng> getInfoWindowBoderPoints(Marker marker) {
        if (marker == null) {
            return null;
        }
        return this.f23653e.getInfoWindowBoderPoints(marker.getId());
    }

    public void setMapMode() {
        this.f23652d.setMapMode();
    }

    public int getMapMode() {
        return this.f23652d.getMapMode();
    }

    public void setTrafficEnabled(boolean z) {
        this.f23652d.setTrafficEnabled(z);
    }

    public void switchTrafficDrawer(boolean z) {
        this.f23662n.switchOnOff(this.f23650a, z);
        this.f23650a = z;
    }

    public boolean removeTrafficIcon(long j, int i, double d) {
        if (this.f23650a) {
            return this.f23662n.removeTrafficIcon(j, i, d);
        }
        return false;
    }

    public void refeshTrafficIcon(List<Long> list) {
        if (this.f23650a) {
            this.f23662n.refeshTrafficIcon(list);
        }
    }

    public void showTrafficIconRadar(long j, MapTrafficIcon mapTrafficIcon, int i) {
        if (this.f23650a) {
            this.f23662n.showTrafficIconRadar(j, mapTrafficIcon, i);
        }
    }

    public boolean isNight() {
        return this.f23652d.isNight();
    }

    public void setAllTrafficIconVisible(boolean z) {
        this.f23662n.setAllTrafficIconVisible(z, this.f23650a);
    }

    public void setLanguage(int i) {
        this.f23652d.setLanguage(i);
    }

    public int getLanguage() {
        return this.f23652d.getLanguage();
    }

    public void setTheme(int i) {
        this.f23652d.setTheme(i);
    }

    public int getTheme() {
        return this.f23652d.getTheme();
    }

    public int getWidth() {
        MapHost mapHost = (MapHost) this.f23663o.get();
        if (mapHost != null) {
            return mapHost.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        MapHost mapHost = (MapHost) this.f23663o.get();
        if (mapHost != null) {
            return mapHost.getHeight();
        }
        return 0;
    }

    public void clearActions() {
        this.f23652d.stopAnimation();
    }

    public void setZoomInTapCenterSwitch(boolean z) {
        this.f23652d.setZoomInByCenter(z);
    }

    public void setZoomOutTapCenterSwitch(boolean z) {
        this.f23652d.setZoomOutByCenter(z);
    }

    public float getScreenCenterX() {
        return this.f23652d.getScreenCenterX();
    }

    public float getScreenCenterY() {
        return this.f23652d.getScreenCenterY();
    }

    @Deprecated
    public int getCurScaleLevel() {
        return (int) this.f23652d.getScaleLevel();
    }

    public DidiMap.OnLableMarkerCallback getLableMarkerCallback() {
        return this.f23667s;
    }

    public boolean isShowTrafficEvent() {
        if (this.f23650a) {
            return this.f23662n.isShowTrafficEvent();
        }
        return this.f23652d.isShowTrafficEvent();
    }

    public boolean isShowFakeTrafficEvent() {
        if (this.f23650a) {
            return this.f23662n.isShowFakeTrafficEvent();
        }
        return this.f23652d.isShowFakeTrafficEvent();
    }

    public void setShowFakeTrafficEvent(boolean z) {
        if (this.f23650a) {
            this.f23662n.setShowFakeTrafficEvent(z);
        }
        this.f23652d.setShowFakeTrafficEvent(z);
    }

    public void setShowTrafficEvent(boolean z) {
        if (this.f23650a) {
            this.f23662n.setShowTrafficEvent(z);
        }
        this.f23652d.setShowTrafficEvent(z);
    }

    public void addScaleChangeListener(OnMapScaleChangedListener onMapScaleChangedListener) {
        this.f23652d.addScaleChangedListener(onMapScaleChangedListener);
    }

    public void removeScaleChangeListener(OnMapScaleChangedListener onMapScaleChangedListener) {
        this.f23652d.removeScaleChangedListener(onMapScaleChangedListener);
    }

    public List<TrafficEventRoutePoint> getTrafficEventRoutePointInfo() {
        if (this.f23650a) {
            return this.f23662n.getTrafficEventRoutePointInfo();
        }
        return this.f23652d.getTrafficEventRoutePointInfo();
    }

    public List<TrafficEventRoutePoint> getTrafficEventsPointInfo() {
        if (this.f23650a) {
            return this.f23662n.getTrafficEventsPointInfo();
        }
        return this.f23652d.getTrafficEventsPointInfo();
    }

    public byte[] genVecEnlargePNGImage(byte[] bArr, long j) {
        if (bArr == null || j == 0) {
            return null;
        }
        return this.f23652d.genVecEnlargePNGImage(bArr, j);
    }

    public boolean setVecEnlargeData(String str, byte[] bArr, long j) {
        if (j == 0) {
            return false;
        }
        return this.f23652d.setVecEnlargeData(str, bArr, j);
    }

    public boolean setVecEnlargeIsVisible(String str, boolean z) {
        return this.f23652d.setVecEnlargeIsVisible(str, z);
    }

    public boolean destroyNewVecEnlarge(String str) {
        return this.f23652d.destroyNewVecEnlarge(str);
    }

    public void destroyAllVecEnlarge() {
        this.f23652d.destroyAllVecEnlarge();
    }

    public void setRenderPerformance(final DidiMapExt.RenderPerformance renderPerformance) {
        MapHost mapHost = (MapHost) this.f23663o.get();
        if (mapHost != null) {
            mapHost.setRenderProfile(new RenderProfile() {
                public int getSlowRenderInterval() {
                    return 200;
                }

                public void onSlowRender(long j, long j2, long j3) {
                }

                public void onFrame(long j, long j2, long j3) {
                    renderPerformance.onFrameFinish(j);
                }
            });
        }
    }

    public Point toScreenLocation(LatLng latLng) {
        return getProjection().toScreenLocation(latLng);
    }

    public void setTrafficEventData(final byte[] bArr) {
        if (!SystemUtil.isUIThread()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    HWDidiMap.this.f23662n.setNewestTrafficEventData(bArr);
                    if (HWDidiMap.this.f23650a) {
                        HWDidiMap.this.f23662n.setTrafficEventData(bArr);
                    } else {
                        HWDidiMap.this.f23652d.setTrafficEventData(bArr);
                    }
                }
            });
            return;
        }
        this.f23662n.setNewestTrafficEventData(bArr);
        if (this.f23650a) {
            this.f23662n.setTrafficEventData(bArr);
        } else {
            this.f23652d.setTrafficEventData(bArr);
        }
    }

    public void clearTrafficEventData() {
        if (!SystemUtil.isUIThread()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    HWDidiMap.this.f23662n.clearTrafficEventData();
                    HWDidiMap.this.f23652d.clearTrafficEventData();
                }
            });
            return;
        }
        this.f23662n.clearTrafficEventData();
        this.f23652d.clearTrafficEventData();
    }

    public void setExtendEventData(byte[] bArr) {
        this.f23652d.setExtendEventData(bArr);
    }

    public void setExtendIconVisible(long j, boolean z) {
        this.f23652d.setExtendIconVisible(j, z);
    }

    public void setExtendIconVisible(boolean z) {
        this.f23652d.setExtendIconVisible(z);
    }

    public int getRenderExtendIconNumber() {
        return this.f23652d.getRenderExtendIconNumber();
    }

    public void setPoiHidden(int i, LatLng latLng, boolean z) {
        this.f23652d.setPoiHidden(i, latLng, z);
    }

    public void setPoiHidden(BigInteger bigInteger, boolean z) {
        this.f23652d.setPoiHidden(bigInteger, z);
    }

    public void showHiddenPoi() {
        this.f23652d.showHiddenPoi();
    }

    public CollisionGroup addCollisionGroup(CollisionGroupOption collisionGroupOption) {
        return this.f23661m.addCollisionGroup(collisionGroupOption);
    }

    public void showRestrictArea(byte[] bArr) {
        this.f23652d.setExtendEventData(bArr);
        this.f23652d.setRestrictAreaVisible(true);
    }

    public void hideRestrictArea() {
        this.f23652d.setRestrictAreaVisible(false);
    }

    /* renamed from: a */
    private void m16816a(Runnable runnable) {
        this.f23670v.post(runnable);
    }

    public void setNavigationLineMargin(float f, float f2, float f3, float f4) {
        this.f23652d.setNavigationLineMargin(f, f2, f3, f4);
    }

    public void setRouteNameVisible(boolean z) {
        this.f23652d.setRouteNameVisible(z);
    }

    public void clearRouteNameSegments() {
        this.f23652d.clearRouteNameSegments();
    }

    public void deleteRouteNameSegments(long j) {
        this.f23652d.deleteRouteNameSegments(j);
    }

    public int getmPaddingLeft() {
        return this.f23652d.getMapPadding().left;
    }

    public int getmPaddingTop() {
        return this.f23652d.getMapPadding().top;
    }

    public int getmPaddingRight() {
        return this.f23652d.getMapPadding().right;
    }

    public int getmPaddingBottom() {
        return this.f23652d.getMapPadding().bottom;
    }

    public void addRouteNameSegmentsForMultiRouteBubble(List<RouteSectionWithName> list, long j, List<LatLng> list2, int i, int i2, String str, String str2, int i3, int i4) {
        this.f23652d.addMultipleRouteNameSegments(list, j, list2, i, i2, str, str2, i3, i4);
    }

    public void addSpecialBubble(List<RouteSectionWithName> list, List<LatLng> list2, long j, int i) {
        HWLog.m16761i("hw", "addSpecialBubble " + j + " type: " + i);
        this.f23652d.addSpecialBubble(list, list2, j, i);
    }

    public void updateSpecialBubble(List<RouteSectionWithName> list, long j) {
        this.f23652d.updateSpecialBubble(list, j);
    }

    public void removeSpecialBubble(long j) {
        HWLog.m16761i("hw", "removeSpecialBubble " + j);
        this.f23652d.removeSpecialBubble(j);
    }

    public void deleteSpecialBubbleWithType(int i) {
        HWLog.m16761i("hw", "deleteSpecialBubbleWithType " + i);
        this.f23652d.deleteSpecialBubbleWithType(i);
    }

    public void addBubble(Bubble bubble) {
        this.f23652d.addBubble(bubble);
    }

    public void removeBubble(long j) {
        this.f23652d.removeBubble(j);
    }

    public void removeRemoteBubble(long j) {
        this.f23652d.removeRemoteBubble(j);
    }

    public void updateBubble(Bubble bubble) {
        this.f23652d.updateBubble(bubble);
    }

    public void handleBubbleCollision() {
        this.f23652d.handleBubbleCollision();
    }

    public void setBlockInfo(int i, long j, List<LatLng> list, List<OutBlockInfo> list2) {
        this.f23652d.setBlockInfo(i, j, list, list2);
    }

    public float getMapScaleLevel() {
        return this.f23652d.getScaleLevel();
    }

    public float getMapRotate() {
        return this.f23652d.getRotate();
    }

    public void updateLocalTrafficIcon(final TrafficEventModel[] trafficEventModelArr) {
        m16816a((Runnable) new Runnable() {
            public void run() {
                if (HWDidiMap.this.f23650a) {
                    HWDidiMap.this.f23662n.updateLocalTrafficIcon(trafficEventModelArr);
                } else {
                    HWDidiMap.this.f23652d.updateLocalTrafficIcon(trafficEventModelArr);
                }
            }
        });
    }

    public DoublePoint toScreentLocation(GeoPoint geoPoint) {
        Point screenLocation = getProjection().toScreenLocation(new LatLng((((double) geoPoint.getLatitudeE6()) * 1.0d) / 1000000.0d, (((double) geoPoint.getLongitudeE6()) * 1.0d) / 1000000.0d));
        if (screenLocation == null) {
            return null;
        }
        return new DoublePoint((double) screenLocation.x, (double) screenLocation.y);
    }

    public void onDestroy() {
        this.f23662n.release();
        TrafficEventManager.getInstance().delObserver(this.f23672x);
        removeBubbleListener();
        this.f23653e.setBubbleManager((BubbleManager) null);
        this.f23651c.clear();
        this.f23667s.destroy();
        BubbleManager bubbleManager = this.f23649A;
        if (bubbleManager != null) {
            bubbleManager.onDestory();
        }
        this.f23664p.exit();
        this.f23652d.onDestroy();
        this.f23663o.clear();
        this.f23670v.removeCallbacksAndMessages((Object) null);
        this.f23671w = true;
    }

    public void setOnTop(boolean z) {
        MapHost mapHost = (MapHost) this.f23663o.get();
        if (mapHost != null) {
            mapHost.setZOrderMediaOverlay(true);
        }
    }

    public MapView getMapView() {
        MapView mapView;
        WeakReference<MapView> weakReference = this.f23666r;
        if (weakReference == null || (mapView = (MapView) weakReference.get()) == null) {
            return null;
        }
        return mapView;
    }

    public LatLng getRouteArrowFurthestPoint() {
        return this.f23652d.getRouteArrowFurthestPoint();
    }

    public LatLng getVehicleMarkerLocation() {
        return this.f23655g.getLocator().getPosition();
    }

    public void setMapElementClickListener(OnMapElementClickListener onMapElementClickListener) {
        this.f23652d.setMapElementClickListener(onMapElementClickListener);
    }

    public OnMapElementClickListener getMapElementClickListener() {
        return this.f23652d.getMapElementClickListener();
    }

    public void updateTrafficItemShowState(long j, int i, boolean z) {
        final long j2 = j;
        final int i2 = i;
        final boolean z2 = z;
        m16816a((Runnable) new Runnable() {
            public void run() {
                if (HWDidiMap.this.f23650a) {
                    HWDidiMap.this.f23662n.updateTrafficItemState(j2, i2, z2);
                } else {
                    HWDidiMap.this.f23652d.updateTrafficItemState(j2, i2, z2);
                }
            }
        });
    }

    public MarkerView addMarkerView(View view, LatLng latLng) {
        return this.f23669u.add(view, latLng);
    }

    public void setFPS(int i) {
        this.f23652d.setFps(i);
    }

    public void setFpsMode(int i) {
        this.f23652d.setFpsMode(i);
    }

    public void showTrafficEvent(boolean z) {
        this.f23652d.showTrafficEvent(z);
    }

    public void setZhongYanEventData(byte[] bArr, long j) {
        this.f23652d.setZhongYanEventData(bArr, j);
    }

    public void setUseLowMemoryMode(boolean z) {
        this.f23652d.setUseLowMemoryMMode(z);
    }

    public void setSurfaceChangeListener(SurfaceChangeListener surfaceChangeListener) {
        this.f23652d.setSurfaceChangeListener(surfaceChangeListener);
    }

    public void setDisplayFishBoneGrayBubbleOnly(boolean z) {
        this.f23652d.setDisplayFishBoneGrayBubbleOnly(z);
    }

    public void addOnCameraChangeListener(DidiMap.OnCameraChangeListener onCameraChangeListener) {
        this.f23652d.addOnCameraChangeListener(onCameraChangeListener);
    }

    public void removeOnCameraChangedListener(DidiMap.OnCameraChangeListener onCameraChangeListener) {
        this.f23652d.removeOnCameraChangedListener(onCameraChangeListener);
    }

    public void setMJOEnabled(boolean z) {
        this.f23652d.setMJOEnabled(z);
    }

    public ArrayList<LatLng> loadMJOAndGetBindRoute(long j, int i, DidiMapExt.MJOListener mJOListener, byte[] bArr, List<DidiMapExt.MJOLinkInfo> list, long j2) {
        return this.f23652d.loadMJOAndGetBindRoute(j, i, mJOListener, bArr, list, j2);
    }

    public void setBlockEventListener(DidiMapExt.BlockEventListener blockEventListener) {
        this.f23652d.setBlockEventListener(blockEventListener);
    }

    public void showMJO() {
        this.f23652d.showMJO();
    }

    public void hideMJO(boolean z) {
        this.f23652d.hideMJO(z);
    }

    public void clearMJORouteInfo() {
        this.f23652d.clearMJORouteInfo();
    }

    public void setClipArea(int i) {
        MapHost mapHost = (MapHost) this.f23663o.get();
        if (mapHost != null) {
            this.f23652d.setClipArea(i, mapHost.getWidth(), mapHost.getHeight());
        }
    }

    public void setBubbleLoadBitmapListener(DidiMapExt.BubbleLoadBitmapListener bubbleLoadBitmapListener) {
        this.f23674z = bubbleLoadBitmapListener;
    }

    public void setBubbleEdgePadding(float f) {
        HWLog.m16761i("setBubbleEdgePadding", "paddingTop = " + f);
        this.f23652d.setBubbleEdgePadding(f);
    }

    public void removeBubbleListener() {
        this.f23674z = null;
    }

    public BubbleManager getBubbleManager() {
        return this.f23649A;
    }

    public void hibernate() {
        this.f23652d.hibernate();
    }

    public GLInstrumentation getInstrumentation() {
        MapHost mapHost = (MapHost) this.f23663o.get();
        if (mapHost != null) {
            return mapHost.getGLViewManage().getGLInstrumentation();
        }
        return null;
    }

    public MapAccessManager getAccessManager() {
        return this.f23668t;
    }

    public void setIsInternationalWMS(boolean z) {
        MapView mapView;
        int isInternationalWMS = this.f23652d.setIsInternationalWMS(z);
        WeakReference<MapView> weakReference = this.f23666r;
        if (weakReference != null && (mapView = (MapView) weakReference.get()) != null) {
            mapView.showLogoForInternationalWms(isInternationalWMS);
        }
    }

    public void setAnnotationShowLight(boolean z) {
        this.f23652d.setAnnotationShowLight(z);
    }

    public void setAboardPointJson(String str) {
        this.f23652d.setAboardPointJson(str);
    }

    public void setPoiMarkerRect(Rect[] rectArr) {
        this.f23652d.setPoiMarkerRect(rectArr);
    }

    public void setVioParkingRegionData(byte[] bArr, int i) {
        this.f23652d.setVioParkingRegionData(bArr, i);
    }
}
