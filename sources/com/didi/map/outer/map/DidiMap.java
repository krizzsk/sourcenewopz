package com.didi.map.outer.map;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.location.Location;
import android.os.Handler;
import android.view.View;
import com.didi.map.alpha.maps.internal.LableMarkerManager;
import com.didi.map.base.RouteSectionWithName;
import com.didi.map.base.TextLableOnRoute;
import com.didi.map.base.TrafficEventModel;
import com.didi.map.base.bubble.TrafficHintShowBarn;
import com.didi.map.core.FrameCallback;
import com.didi.map.core.SurfaceChangeListener;
import com.didi.map.core.base.impl.OnMapGestureListener;
import com.didi.map.core.base.impl.OnMapModeListener;
import com.didi.map.core.element.OnMapElementClickListener;
import com.didi.map.core.point.DoublePoint;
import com.didi.map.core.point.GeoPoint;
import com.didi.map.outer.map.DiMapInterface;
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
import com.didi.map.outer.model.CollisionMarker;
import com.didi.map.outer.model.HeatOverlay;
import com.didi.map.outer.model.HeatOverlayOptions;
import com.didi.map.outer.model.IMapElement;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;
import com.didi.map.outer.model.MapAllGestureListener;
import com.didi.map.outer.model.MapGestureListener;
import com.didi.map.outer.model.Marker;
import com.didi.map.outer.model.MarkerGroup;
import com.didi.map.outer.model.MarkerOptions;
import com.didi.map.outer.model.MarkerView;
import com.didi.map.outer.model.MaskLayer;
import com.didi.map.outer.model.MaskLayerOptions;
import com.didi.map.outer.model.MyLocationOption;
import com.didi.map.outer.model.Polygon;
import com.didi.map.outer.model.PolygonOptions;
import com.didi.map.outer.model.Polyline;
import com.didi.map.outer.model.PolylineOptions;
import com.didi.navi.core.auto.OnMapAutoCameraExecutor;
import java.math.BigInteger;
import java.util.List;

public interface DidiMap {
    public static final int ANIMATE_MODE = 3;
    public static final int FPS_10 = 6;
    public static final int FPS_30 = 2;
    public static final int FPS_60 = 1;
    public static final int FPS_FRAME = 60;
    public static final int MASK_LAYER_NONE = -1;
    public static final int POI_TYPE_BUSSTATION = 1;
    public static final int POI_TYPE_NONE = 0;
    public static final int POI_TYPE_SUBWAYSTATION = 2;
    public static final int ThemeBus = 1;
    public static final int ThemeBusStation = 2;
    public static final int ThemeDefault = 0;
    public static final int ThemeHaiTun = 11;
    public static final int UNRESTRICTED_MODE = 2;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface CollisionMarkerInfoWindowAdapter extends DiMapInterface.IWindowAdapter<CollisionMarker> {
        public static final int NORMAL = 0;
        public static final int PRESS = 1;

        /* renamed from: com.didi.map.outer.map.DidiMap$CollisionMarkerInfoWindowAdapter$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
        }

        View getInfoContents(CollisionMarker collisionMarker);

        View[] getInfoWindow(CollisionMarker collisionMarker);

        View[] getOverturnInfoWindow(CollisionMarker collisionMarker);
    }

    public static class MapTrafficEventType {
        public static final int SCENE_TYPE_INDEX = 1;
        public static final int SCENE_TYPE_NAV = 3;
        public static final int SCENE_TYPE_PLAN = 2;
    }

    public interface MultiPositionInfoWindowAdapter extends DiMapInterface.IWindowAdapter<Marker> {

        /* renamed from: com.didi.map.outer.map.DidiMap$MultiPositionInfoWindowAdapter$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
        }

        View getInfoContents(Marker marker);

        View[] getInfoWindow(Marker marker);

        View[] getOverturnInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnCollisionInfoWindowClickListener extends DiMapInterface.IOnInfoWindowClickListener<CollisionMarker> {

        /* renamed from: com.didi.map.outer.map.DidiMap$OnCollisionInfoWindowClickListener$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
        }

        void onInfoWindowClick(CollisionMarker collisionMarker);
    }

    public interface OnCollisionMarkerClickListener extends DiMapInterface.IOnMarkerClickListener<CollisionMarker> {

        /* renamed from: com.didi.map.outer.map.DidiMap$OnCollisionMarkerClickListener$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
        }

        boolean onMarkerClick(CollisionMarker collisionMarker);

        boolean onMarkerClick(CollisionMarker collisionMarker, float f, float f2);
    }

    public interface OnCompassClickedListener {
        void onCompassClicked();
    }

    public interface OnInfoWindowClickListener extends DiMapInterface.IOnInfoWindowClickListener<Marker> {

        /* renamed from: com.didi.map.outer.map.DidiMap$OnInfoWindowClickListener$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
        }

        void onInfoWindowClick(Marker marker);
    }

    public interface OnInfoWindowVisibleChangeListener {
        void onInfoWindowVisibleChange(boolean z);
    }

    public interface OnLableMarkerCallback {
        void callBackCurRouteName(String str);

        void clearRefeshData();

        void destroy();

        LableMarkerManager.BubblesSwitch getBubbleSwitch();

        List<Rect> getCollideRects();

        void onLableRouteCallback(List<TextLableOnRoute> list);

        void refeshMultiBubbleEta(long j, TextLableOnRoute textLableOnRoute);

        void setBubblesSwitch(LableMarkerManager.BubblesSwitch bubblesSwitch);

        void setCollideMarker(Marker marker);

        void setCollideMarkers(List<Marker> list);

        void setDayNight(boolean z);

        void setNaviMapMode(int i);

        void setOnSelectMapRouteIdListener(LableMarkerManager.OnSelectMapRouteIdListener onSelectMapRouteIdListener);

        void setVisible(boolean z);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener extends DiMapInterface.IOnMarkerClickListener<Marker> {

        /* renamed from: com.didi.map.outer.map.DidiMap$OnMarkerClickListener$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
        }

        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMarkerVisibleChangeListener {
        void onVisibleChange(boolean z, long j);
    }

    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface OnPolygonClickListener {
        void onPolygonClick(Polygon polygon, LatLng latLng);
    }

    public interface OnPolylineClickListener {
        void onPolylineClick(Polyline polyline, LatLng latLng);
    }

    BezierCurve addBezierCurve(BezierCurveOption bezierCurveOption);

    BitmapTileOverlay addBitmapTileOverlay(BitmapTileOverlayOption bitmapTileOverlayOption);

    int addBubble(BubbleOptions bubbleOptions);

    BubbleGroup addBubbleGroup(List<BubbleOptions> list);

    List<Integer> addBubbles(List<BubbleOptions> list);

    Circle addCircle(CircleOptions circleOptions);

    CollisionGroup addCollisionGroup(CollisionGroupOption collisionGroupOption);

    HeatOverlay addHeatOverlay(HeatOverlayOptions heatOverlayOptions);

    void addMapAllGestureListener(MapAllGestureListener mapAllGestureListener);

    @Deprecated
    void addMapClickListener(OnMapClickListener onMapClickListener);

    void addMapGestureListener(MapGestureListener mapGestureListener);

    @Deprecated
    void addMapGestureListener2(OnMapGestureListener onMapGestureListener);

    Marker addMarker(MarkerOptions markerOptions);

    MarkerGroup addMarkerGroup();

    MarkerView addMarkerView(View view, LatLng latLng);

    MaskLayer addMaskLayer(MaskLayerOptions maskLayerOptions);

    @Deprecated
    void addModeListener(OnMapModeListener onMapModeListener);

    void addOnMapClickListener(OnMapClickListener onMapClickListener);

    Polygon addPolygon(PolygonOptions polygonOptions);

    Polyline addPolyline(PolylineOptions polylineOptions);

    void addRouteNameSegmentsForMultiRouteBubble(List<RouteSectionWithName> list, long j, List<LatLng> list2, int i, int i2, String str, String str2, int i3, int i4);

    void animateCamera(CameraUpdate cameraUpdate);

    void animateCamera(CameraUpdate cameraUpdate, long j, CancelableCallback cancelableCallback);

    void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback);

    void animateToNaviPosition(LatLng latLng, float f, float f2);

    void animateToNaviPosition(LatLng latLng, float f, float f2, float f3);

    void animateToNaviPosition(LatLng latLng, float f, float f2, float f3, boolean z);

    void animateToNaviPosition2(LatLng latLng, float f, float f2, float f3, boolean z);

    float calNaviLevel(LatLngBounds latLngBounds, float f, int i, boolean z);

    float calNaviLevel2(LatLng latLng, LatLng latLng2, float f, float f2, int i, int i2, boolean z);

    float calNaviLevel3(LatLng latLng, LatLng latLng2, float f, float f2, int i, int i2, boolean z, float f3);

    CameraPosition calculateCameraPosition(List<IMapElement> list, List<LatLng> list2, List<ViewBounds> list3, int i, int i2, int i3, int i4);

    CameraPosition calculateZoomToSpanLevel(List<IMapElement> list, List<LatLng> list2, int i, int i2, int i3, int i4);

    CameraPosition calculateZoomToSpanLevel(List<IMapElement> list, List<LatLng> list2, int i, int i2, int i3, int i4, LatLng latLng);

    float calcuteZoomToSpanLevel(int i, int i2, int i3, int i4, LatLng latLng, LatLng latLng2, LatLng latLng3);

    void clear();

    void clearActions();

    void clearBubbles();

    void clearOnMapClickListener();

    void clearRealTrafficIcon();

    void clearRouteNameSegments();

    void clearTrafficEventData();

    void deleteRouteNameSegments(long j);

    MapAccessManager getAccessManager();

    List<LatLng> getBounderPoints(Marker marker);

    CameraPosition getCameraPosition();

    GeoPoint getCenter();

    String getCityName(LatLng latLng);

    @Deprecated
    int getCurScaleLevel();

    List<Rect> getElementScreenBound(List<String> list);

    int getHeight();

    InfoWindowAnimationManager getInfoWindowAnimationManager();

    List<LatLng> getInfoWindowBoderPoints(Marker marker);

    OnLableMarkerCallback getLableMarkerCallback();

    int getLanguage();

    float getLocationRadius(double d, LatLng latLng);

    float getLogoMarginRate(int i);

    int getMapMode();

    Rect getMapPadding();

    float getMapRotate();

    float getMapScaleLevel();

    float getMapSkew();

    int getMapType();

    MapView getMapView();

    Rect getMarkerBound(Marker marker);

    GeoPoint getMarkerGeoPoint(Marker marker);

    float getMaxSkew();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    Location getMyLocation();

    MyLocationOption getMyLocationOption();

    OnMapAutoCameraExecutor getNavAutoMapActionExecutor();

    Projection getProjection();

    int getRenderExtendIconNumber();

    LatLng getRouteArrowFurthestPoint();

    int getSDKVersion();

    float getScreenCenterX();

    float getScreenCenterY();

    void getScreenShot(Handler handler, Bitmap.Config config);

    int getTheme();

    UiSettings getUiSettings();

    LatLng getVehicleMarkerLocation();

    String getVersion();

    int getWidth();

    float getZoomToSpanLevel(LatLng latLng, LatLng latLng2);

    int getmPaddingBottom();

    int getmPaddingLeft();

    int getmPaddingRight();

    int getmPaddingTop();

    void hideRestrictArea();

    boolean isDestroyed();

    boolean isMyLocationEnabled();

    boolean isShowFakeTrafficEvent();

    boolean isShowTrafficEvent();

    void moveCamera(CameraUpdate cameraUpdate);

    void onDestroy();

    void onPause();

    void onRestart();

    void onResume();

    void onStart();

    void onStop();

    boolean removeBubble(int i);

    void removeMapGestureListener(MapAllGestureListener mapAllGestureListener);

    void removeMapGestureListener(MapGestureListener mapGestureListener);

    void removeOnMapClickListener(OnMapClickListener onMapClickListener);

    void removeTrafficHintIcon();

    void resetTrafficEventIconCustomSize();

    void setAboardPointJson(String str);

    void setAnnotationShowLight(boolean z);

    @Deprecated
    void setCenter(GeoPoint geoPoint);

    void setCenter(LatLng latLng);

    void setCompassExtraPadding(int i);

    void setCompassExtraPadding(int i, int i2);

    void setCompassMarkerHidden(boolean z);

    void setDrawPillarWith2DStyle(boolean z);

    void setExtendIconVisible(long j, boolean z);

    void setExtendIconVisible(boolean z);

    void setFPS(int i);

    void setFpsMode(int i);

    void setFrameCallback(FrameCallback frameCallback);

    void setInfoWindowStillVisible(boolean z);

    void setInfoWindowUnique(boolean z);

    void setIsInternationalWMS(boolean z);

    void setLanguage(int i);

    void setLocationInfo(GeoPoint geoPoint, float f, float f2, boolean z);

    void setLocationSource(LocationSource locationSource);

    void setLogoAnchor(int i);

    void setLogoAnchorWithMargin(int i, int i2, int i3, int i4, int i5);

    void setLogoBottomMargin(int i);

    void setLogoLeftMargin(int i);

    void setLogoMarginRate(int i, float f);

    void setLogoVisible(boolean z);

    void setMapCenterAndScale(float f, float f2, float f3);

    void setMapElementClickListener(OnMapElementClickListener onMapElementClickListener);

    void setMapEventApollo(boolean z);

    @Deprecated
    void setMapGestureListener(MapGestureListener mapGestureListener);

    void setMapMode();

    void setMapPadding(int i, int i2, int i3, int i4);

    @Deprecated
    void setMapPadding(int i, int i2, int i3, int i4, boolean z);

    void setMapScreenCenterProportion(float f, float f2);

    void setMapScreenCenterProportion(float f, float f2, boolean z);

    void setMaxSkew(float f);

    void setModDark(boolean z);

    void setModNav(boolean z);

    void setMyLocationEnabled(boolean z);

    void setMyLocationEnabled(boolean z, float f, float f2, float f3);

    void setMyLocationOption(MyLocationOption myLocationOption);

    void setMyLocationOption(MyLocationOption myLocationOption, float f, float f2, float f3);

    void setNaviCenter(int i, int i2);

    void setNaviFixingProportion(float f, float f2);

    void setNaviFixingProportion2D(float f, float f2);

    void setNavigationLineMargin(float f, float f2, float f3, float f4);

    void setOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener);

    void setOnCompassClickedListener(OnCompassClickedListener onCompassClickedListener);

    void setOnMapClickListener(OnMapClickListener onMapClickListener);

    void setOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback);

    void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener);

    void setOnMyLocationChangeListener(OnMyLocationChangeListener onMyLocationChangeListener);

    void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener);

    void setOnTapMapViewInfoWindowHidden(boolean z);

    void setOnTop(boolean z);

    void setPillarVisible(boolean z);

    void setPoiHidden(int i, LatLng latLng, boolean z);

    void setPoiHidden(BigInteger bigInteger, boolean z);

    void setPoiMarkerRect(Rect[] rectArr);

    void setRotateAngle(float f);

    void setRouteNameVisible(boolean z);

    void setSatelliteEnabled(boolean z);

    void setScaleAnchor(int i);

    void setScaleAnchorWithMargin(int i, int i2, int i3, int i4, int i5);

    void setScaleCenter(float f, float f2);

    void setShowFakeTrafficEvent(boolean z);

    void setShowTrafficEvent(boolean z);

    void setSkewAngle(float f);

    void setSuid(String str);

    void setSurfaceChangeListener(SurfaceChangeListener surfaceChangeListener);

    void setTheme(int i);

    void setTrafficColor(int i, int i2, int i3, int i4);

    void setTrafficEnabled(boolean z);

    void setTrafficEventData(byte[] bArr);

    void setTrafficEventIconCustomSize(int i);

    void setUseLowMemoryMode(boolean z);

    void setVecEnlargeVisibleArea(int i, int i2, int i3, int i4, float f);

    void setVioParkingRegionData(byte[] bArr, int i);

    void setZhongYanEventData(byte[] bArr, long j);

    void setZoomInTapCenterSwitch(boolean z);

    void setZoomOutTapCenterSwitch(boolean z);

    void showHiddenPoi();

    void showRestrictArea(byte[] bArr);

    void showTrafficEvent(boolean z);

    void showTrafficHintIcon(long j, TrafficHintShowBarn trafficHintShowBarn);

    void stopAnimation();

    DoublePoint toScreentLocation(GeoPoint geoPoint);

    void updateLocalTrafficIcon(TrafficEventModel[] trafficEventModelArr);

    @Deprecated
    void updateScaleView();

    void updateTrafficItemShowState(long j, int i, boolean z);

    public static class ViewBounds {
        public static int P_CENTER_TOP = 5;
        public static int P_LEFT_BOTTOM = 3;
        public static int P_LEFT_TOP = 1;
        public static int P_RIGHT_BOTTOM = 4;
        public static int P_RIGHT_TOP = 2;
        private final int position;
        private final Rect rect;

        public ViewBounds(Rect rect2, int i) {
            this.rect = rect2;
            this.position = i;
        }

        public int getPosition() {
            return this.position;
        }

        public Rect getRect() {
            return this.rect;
        }
    }
}
