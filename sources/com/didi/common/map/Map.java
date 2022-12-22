package com.didi.common.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.didi.common.map.MapView;
import com.didi.common.map.constant.DiDiMapLanguage;
import com.didi.common.map.internal.IMapDelegate;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.internal.IProjectionDelegate;
import com.didi.common.map.internal.MapExceptionHandler;
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
import com.didi.common.map.util.DLog;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.map.constant.StringConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Map {

    /* renamed from: a */
    private Context f10682a;

    /* renamed from: b */
    private MapView f10683b;

    /* renamed from: c */
    private IMapDelegate f10684c;

    /* renamed from: d */
    private Projection f10685d;

    /* renamed from: e */
    private UiSettings f10686e;

    /* renamed from: f */
    private MapElementManager f10687f;

    /* renamed from: g */
    private int f10688g = -1;

    public Map(Context context, IMapDelegate iMapDelegate, MapView mapView) {
        this.f10682a = context;
        this.f10684c = iMapDelegate;
        this.f10683b = mapView;
        this.f10687f = new MapElementManager();
    }

    public int getMapStatus() {
        return this.f10688g;
    }

    public void setMapStatus(int i) {
        this.f10688g = i;
    }

    public void showErrorHint(String str) {
        MapView mapView = this.f10683b;
        if (mapView != null) {
            mapView.addErrorHintView(str);
        }
    }

    public void clearErrorHint() {
        MapView mapView = this.f10683b;
        if (mapView != null) {
            mapView.removeErrorHintView();
        }
    }

    public boolean setMapStyle(int i) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            return iMapDelegate.setMapStyle(i);
        }
        return false;
    }

    public boolean setMapStyle(String str) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            return iMapDelegate.setMapStyle(str);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public IMapDelegate mo44673a() {
        return this.f10684c;
    }

    public UiSettings getUiSettings() {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate == null) {
            return null;
        }
        if (this.f10686e == null) {
            try {
                this.f10686e = new UiSettings(iMapDelegate.getUiSettingsDelegate());
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
        return this.f10686e;
    }

    public Projection getProjection() {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate == null) {
            return null;
        }
        if (this.f10685d == null) {
            try {
                IProjectionDelegate projectionDelegate = iMapDelegate.getProjectionDelegate();
                if (projectionDelegate != null) {
                    this.f10685d = new Projection(projectionDelegate);
                }
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
        return this.f10685d;
    }

    public void setLanguage(DiDiMapLanguage diDiMapLanguage) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null && diDiMapLanguage != null) {
            iMapDelegate.setLanguage(diDiMapLanguage);
        }
    }

    public DiDiMapLanguage getLanguage() {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            return iMapDelegate.getLanguage();
        }
        return null;
    }

    public Context getContext() {
        return this.f10682a;
    }

    public View getView() {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate == null) {
            return null;
        }
        try {
            return iMapDelegate.getView();
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return null;
        }
    }

    public MapVendor getMapVendor() {
        return this.f10683b.getMapVendor();
    }

    public MapVendor getTargetMapVendor() {
        return this.f10683b.getTargetMapVendor();
    }

    public int getMapType() {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate == null) {
            return 1;
        }
        try {
            return iMapDelegate.getMapType();
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return 1;
        }
    }

    public Object getVendorMap() {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate == null) {
            return null;
        }
        return iMapDelegate.getVendorMap();
    }

    public void setMapType(int i) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            try {
                iMapDelegate.setMapType(i);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public CameraPosition getCameraPosition() {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate == null) {
            return new CameraPosition(new LatLng(0.0d, 0.0d), 0.0d, 0.0f, 0.0f);
        }
        try {
            CameraPosition cameraPosition = iMapDelegate.getCameraPosition();
            return cameraPosition == null ? new CameraPosition(new LatLng(0.0d, 0.0d), 0.0d, 0.0f, 0.0f) : cameraPosition;
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return new CameraPosition(new LatLng(0.0d, 0.0d), 0.0d, 0.0f, 0.0f);
        }
    }

    public double getMaxZoomLevel() {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate == null) {
            return -1.0d;
        }
        try {
            return iMapDelegate.getMaxZoomLevel();
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return -1.0d;
        }
    }

    public void setMaxZoomLevel(float f) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            iMapDelegate.setMaxZoomLevel(f);
        }
    }

    public double getMinZoomLevel() {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate == null) {
            return -1.0d;
        }
        try {
            return iMapDelegate.getMinZoomLevel();
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return -1.0d;
        }
    }

    public void captureMapView(OnCaptureMapViewListener onCaptureMapViewListener, Bitmap.Config config) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            try {
                iMapDelegate.captureMapView(onCaptureMapViewListener, config);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public boolean isBuildingsEnabled() {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate == null) {
            return false;
        }
        try {
            return iMapDelegate.isBuildingsEnabled();
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return true;
        }
    }

    public void setBuildingsEnabled(boolean z) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            try {
                iMapDelegate.setBuildingsEnabled(z);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public boolean isTrafficEnabled() {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate == null) {
            return false;
        }
        try {
            return iMapDelegate.isTrafficEnabled();
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return false;
        }
    }

    public void setTrafficEnabled(boolean z) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            try {
                iMapDelegate.setTrafficEnabled(z);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public boolean isIndoorEnabled() {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate == null) {
            return false;
        }
        try {
            return iMapDelegate.isIndoorEnabled();
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return false;
        }
    }

    public boolean setIndoorEnabled(boolean z) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate == null) {
            return false;
        }
        try {
            return iMapDelegate.setIndoorEnabled(z);
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return false;
        }
    }

    @Deprecated
    public void moveCamera(CameraUpdate cameraUpdate) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            try {
                iMapDelegate.moveCamera(cameraUpdate);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    @Deprecated
    public void animateCamera(CameraUpdate cameraUpdate) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            try {
                iMapDelegate.animateCamera(cameraUpdate);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    @Deprecated
    public void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            try {
                iMapDelegate.animateCameraWithCallback(cameraUpdate, cancelableCallback);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    @Deprecated
    public void animateCamera(CameraUpdate cameraUpdate, int i, CancelableCallback cancelableCallback) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            try {
                iMapDelegate.animateCameraWithDurationAndCallback(cameraUpdate, i, cancelableCallback);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public float calculateZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate == null) {
            return -1.0f;
        }
        try {
            return iMapDelegate.calculateZoomToSpanLevel(latLng, latLng2);
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return -1.0f;
        }
    }

    public float calculateZoomToSpanLevel(int i, int i2, int i3, int i4, LatLng latLng, LatLng latLng2) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate == null) {
            return -1.0f;
        }
        try {
            return iMapDelegate.calculateZoomToSpanLevel(i, i2, i3, i4, latLng, latLng2, (LatLng) null);
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return -1.0f;
        }
    }

    public boolean isMyLocationEnabled() {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate == null) {
            return false;
        }
        try {
            return iMapDelegate.isMyLocationEnabled();
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return false;
        }
    }

    public void setMyLocationEnabled(boolean z) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            try {
                iMapDelegate.setMyLocationEnabled(z);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    @Deprecated
    public Location getMyLocation() {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate == null) {
            return null;
        }
        try {
            return iMapDelegate.getMyLocation();
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return null;
        }
    }

    public void stopAnimation() {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            try {
                iMapDelegate.stopAnimation();
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    @Deprecated
    public GroundOverlay addGroundOverlay(String str, GroundOverlayOptions groundOverlayOptions) {
        IMapDelegate iMapDelegate;
        if (groundOverlayOptions == null || (iMapDelegate = this.f10684c) == null) {
            return null;
        }
        try {
            GroundOverlay addGroundOverlay = iMapDelegate.addGroundOverlay(groundOverlayOptions);
            if (addGroundOverlay != null) {
                this.f10687f.addElement(str, addGroundOverlay);
            }
            return addGroundOverlay;
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return null;
        }
    }

    @Deprecated
    public GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        if (groundOverlayOptions == null || this.f10684c == null) {
            return null;
        }
        return addGroundOverlay("GROUP_DEFAULT", groundOverlayOptions);
    }

    public Marker addMarker(MarkerOptions markerOptions) {
        if (this.f10684c == null) {
            return null;
        }
        return addMarker("GROUP_DEFAULT", markerOptions);
    }

    public Marker addMarker(String str, MarkerOptions markerOptions) {
        if (this.f10684c == null || markerOptions == null || markerOptions.getPosition() == null) {
            return null;
        }
        try {
            Marker addMarker = this.f10684c.addMarker(markerOptions);
            if (addMarker != null) {
                this.f10687f.addElement(str, addMarker);
            }
            return addMarker;
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return null;
        }
    }

    public Line addLine(LineOptions lineOptions) {
        if (this.f10684c == null) {
            return null;
        }
        return addLine("GROUP_DEFAULT", lineOptions);
    }

    public Line addLine(String str, LineOptions lineOptions) {
        List<LatLng> points;
        if (!(this.f10684c == null || lineOptions == null || (points = lineOptions.getPoints()) == null || points.isEmpty())) {
            try {
                Line addLine = this.f10684c.addLine(lineOptions);
                if (addLine != null) {
                    this.f10687f.addElement(str, addLine);
                }
                return addLine;
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
        return null;
    }

    public Polygon addPolygon(PolygonOptions polygonOptions) {
        if (this.f10684c == null) {
            return null;
        }
        return addPolygon("GROUP_DEFAULT", polygonOptions);
    }

    public Polygon addPolygon(String str, PolygonOptions polygonOptions) {
        List<LatLng> points;
        if (!(this.f10684c == null || polygonOptions == null || (points = polygonOptions.getPoints()) == null || points.isEmpty())) {
            try {
                Polygon addPolygon = this.f10684c.addPolygon(polygonOptions);
                if (addPolygon != null) {
                    this.f10687f.addElement(str, addPolygon);
                }
                return addPolygon;
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
        return null;
    }

    public Circle addCircle(CircleOptions circleOptions) {
        if (this.f10684c == null) {
            return null;
        }
        return addCircle("GROUP_DEFAULT", circleOptions);
    }

    public Circle addCircle(String str, CircleOptions circleOptions) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate == null || circleOptions == null) {
            return null;
        }
        try {
            Circle addCircle = iMapDelegate.addCircle(circleOptions);
            if (addCircle != null) {
                this.f10687f.addElement(str, addCircle);
            }
            return addCircle;
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return null;
        }
    }

    public MaskLayer addMaskLayer(MaskLayerOptions maskLayerOptions) {
        if (this.f10684c == null) {
            return null;
        }
        return addMaskLayer("GROUP_DEFAULT", maskLayerOptions);
    }

    @Deprecated
    public MaskLayer addMaskLayer(String str, MaskLayerOptions maskLayerOptions) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate == null || maskLayerOptions == null) {
            return null;
        }
        try {
            MaskLayer addMaskLayer = iMapDelegate.addMaskLayer(maskLayerOptions);
            if (addMaskLayer != null) {
                this.f10687f.addElement(str, addMaskLayer);
            }
            return addMaskLayer;
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
            return null;
        }
    }

    public void remove(IMapElement iMapElement) {
        if (this.f10684c != null && iMapElement != null) {
            this.f10687f.removeElement(iMapElement);
            this.f10684c.remove(iMapElement);
            iMapElement.remove();
        }
    }

    public void removeElementGroupByTag(String str) {
        ArrayList access$300;
        if (this.f10684c != null && (access$300 = this.f10687f.getElementGroupByTag(str)) != null) {
            if (access$300.isEmpty()) {
                this.f10687f.removeGroup(str);
                return;
            }
            Iterator it = access$300.iterator();
            while (it.hasNext()) {
                IMapElement iMapElement = (IMapElement) it.next();
                this.f10684c.remove(iMapElement);
                iMapElement.remove();
            }
            this.f10687f.removeGroup(str);
        }
    }

    public ArrayList<IMapElement> getElementGroup(String str) {
        if (this.f10684c == null) {
            return null;
        }
        return this.f10687f.getElementGroupByTag(str);
    }

    public void setGroupElementVisible(String str, boolean z) {
        ArrayList access$300;
        if (this.f10684c != null && (access$300 = this.f10687f.getElementGroupByTag(str)) != null) {
            if (access$300.isEmpty()) {
                this.f10687f.removeGroup(str);
                return;
            }
            Iterator it = access$300.iterator();
            while (it.hasNext()) {
                ((IMapElement) it.next()).setVisible(z);
            }
        }
    }

    public void setTopViewToCenter(View view, float f, float f2) {
        MapView mapView;
        if (this.f10684c != null && (mapView = this.f10683b) != null) {
            mapView.setTopViewToCenter(view, f, f2);
        }
    }

    public void setTopViewToCenter(View view, float f, float f2, int i) {
        MapView mapView;
        if (this.f10684c != null && (mapView = this.f10683b) != null) {
            mapView.setTopViewToCenter(view, f, f2, i);
        }
    }

    public void removeTopView() {
        MapView mapView;
        if (this.f10684c != null && (mapView = this.f10683b) != null) {
            mapView.removeTopView();
        }
    }

    public void clear() {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            try {
                iMapDelegate.clear();
                this.f10687f.clear();
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        if (this.f10684c != null) {
            try {
                DLog.m7384d(StringConstant.META_NAME, NachoLifecycleManager.LIFECYCLE_ON_CREATE, new Object[0]);
                this.f10684c.onCreate(bundle);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void onStart() {
        if (this.f10684c != null) {
            try {
                DLog.m7384d(StringConstant.META_NAME, "onStart", new Object[0]);
                this.f10684c.onStart();
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void onResume() {
        if (this.f10684c != null) {
            try {
                DLog.m7384d(StringConstant.META_NAME, "onResume", new Object[0]);
                this.f10684c.onResume();
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void onPause() {
        if (this.f10684c != null) {
            try {
                DLog.m7384d(StringConstant.META_NAME, "onPause", new Object[0]);
                this.f10684c.onPause();
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void onStop() {
        if (this.f10684c != null) {
            try {
                DLog.m7384d(StringConstant.META_NAME, "onStop", new Object[0]);
                this.f10684c.onStop();
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void onDestroy() {
        if (this.f10684c != null) {
            try {
                DLog.m7384d(StringConstant.META_NAME, NachoLifecycleManager.LIFECYCLE_ON_DESTROY, new Object[0]);
                this.f10684c.onDestroy();
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void onLowMemory() {
        if (this.f10684c != null) {
            try {
                DLog.m7384d(StringConstant.META_NAME, "onLowMemory", new Object[0]);
                this.f10684c.onLowMemory();
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.f10684c != null) {
            try {
                DLog.m7384d(StringConstant.META_NAME, "onSaveInstanceState", new Object[0]);
                this.f10684c.onSaveInstanceState(bundle);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.printMapNotExistApiException(e);
            }
        }
    }

    public void addMapViewTouchEventListener(MapView.TouchEventListener touchEventListener) {
        MapView mapView;
        if (this.f10684c != null && (mapView = this.f10683b) != null) {
            mapView.addTouchEventListener(touchEventListener);
        }
    }

    public void removeMapViewTouchEventListener(MapView.TouchEventListener touchEventListener) {
        MapView mapView;
        if (this.f10684c != null && (mapView = this.f10683b) != null) {
            mapView.removeTouchEventListener(touchEventListener);
        }
    }

    public void addOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            try {
                iMapDelegate.addOnCameraChangeListener(onCameraChangeListener);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public void removeOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            try {
                iMapDelegate.removeOnCameraChangeListener(onCameraChangeListener);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public void addOnMapGestureListener(OnMapGestureListener onMapGestureListener) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            try {
                iMapDelegate.addOnMapGestureListener(onMapGestureListener);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public void removeOnMapGestureListener(OnMapGestureListener onMapGestureListener) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            try {
                iMapDelegate.removeOnMapGestureListener(onMapGestureListener);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public void addOnPolygonClickListener(OnPolygonClickListener onPolygonClickListener) {
        try {
            this.f10684c.addOnPolygonClickListener(onPolygonClickListener);
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public void removeOnPolygonClickListener(OnPolygonClickListener onPolygonClickListener) {
        try {
            this.f10684c.removeOnPolygonClickListener(onPolygonClickListener);
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public void addOnLineClickListener(OnLineClickListener onLineClickListener) {
        try {
            this.f10684c.addOnLineClickListener(onLineClickListener);
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public void removeOnLineClickListener(OnLineClickListener onLineClickListener) {
        try {
            this.f10684c.removeOnLineClickListener(onLineClickListener);
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public void addOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        try {
            this.f10684c.addOnMarkerClickListener(onMarkerClickListener);
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public void removeOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        try {
            this.f10684c.removeOnMarkerClickListener(onMarkerClickListener);
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public void addOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        try {
            this.f10684c.addOnMarkerDragListener(onMarkerDragListener);
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public void removeOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        try {
            this.f10684c.removeOnMarkerDragListener(onMarkerDragListener);
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public void addOnGroundOverlayClickListener(OnGroundOverlayClickListener onGroundOverlayClickListener) {
        try {
            this.f10684c.addOnGroundOverlayClickListener(onGroundOverlayClickListener);
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public void removeOnGroundOverlayClickListener(OnGroundOverlayClickListener onGroundOverlayClickListener) {
        try {
            this.f10684c.removeOnGroundOverlayClickListener(onGroundOverlayClickListener);
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    @Deprecated
    public void addOnCircleClickListener(OnCircleClickListener onCircleClickListener) {
        try {
            this.f10684c.addOnCircleClickListener(onCircleClickListener);
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    @Deprecated
    public void removeOnCircleClickListener(OnCircleClickListener onCircleClickListener) {
        try {
            this.f10684c.removeOnCircleClickListener(onCircleClickListener);
        } catch (MapNotExistApiException e) {
            MapExceptionHandler.handleMapNotExistApiException(e);
        }
    }

    public void addOnMapClickListener(OnMapClickListener onMapClickListener) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            try {
                iMapDelegate.addOnMapClickListener(onMapClickListener);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public void removeOnMapClickListener(OnMapClickListener onMapClickListener) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            try {
                iMapDelegate.removeOnMapClickListener(onMapClickListener);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public void addOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            try {
                iMapDelegate.addOnMapLongClickListener(onMapLongClickListener);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public void removeOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            try {
                iMapDelegate.removeOnMapLongClickListener(onMapLongClickListener);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    @Deprecated
    public void setPadding(int i, int i2, int i3, int i4) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            try {
                iMapDelegate.setPadding(i, i2, i3, i4);
                this.f10683b.mo44776a(false);
                this.f10683b.updateErrorHintPosition();
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public Padding getPadding() {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate == null) {
            return null;
        }
        return iMapDelegate.getPadding();
    }

    public LatLng getMapVisibleRegionCenter() {
        PointF visibleRegionCenterInScreen;
        IProjectionDelegate projectionDelegate;
        if (this.f10684c == null || (visibleRegionCenterInScreen = getVisibleRegionCenterInScreen()) == null || (projectionDelegate = this.f10684c.getProjectionDelegate()) == null) {
            return null;
        }
        return projectionDelegate.fromScreenLocation(visibleRegionCenterInScreen);
    }

    public PointF getVisibleRegionCenterInScreen() {
        IMapDelegate iMapDelegate;
        int i;
        int i2;
        int i3;
        if (this.f10683b == null || (iMapDelegate = this.f10684c) == null) {
            return null;
        }
        int i4 = 0;
        if (iMapDelegate.getPadding() != null) {
            i4 = this.f10684c.getPadding().left;
            i3 = this.f10684c.getPadding().top;
            i2 = this.f10684c.getPadding().right;
            i = this.f10684c.getPadding().bottom;
        } else {
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        return new PointF((float) (i4 + (((this.f10683b.getWidth() - i4) - i2) / 2)), (float) (i3 + (((this.f10683b.getHeight() - i3) - i) / 2)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PointF mo44672a(int i, int i2, int i3, int i4) {
        MapView mapView = this.f10683b;
        if (mapView == null) {
            return null;
        }
        return new PointF((float) (i + (((mapView.getWidth() - i) - i3) / 2)), (float) (i2 + (((this.f10683b.getHeight() - i2) - i4) / 2)));
    }

    public void addOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            try {
                iMapDelegate.addOnMapLoadedCallback(onMapLoadedCallback);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    public void removeOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            try {
                iMapDelegate.removeOnMapLoadedCallback(onMapLoadedCallback);
            } catch (MapNotExistApiException e) {
                MapExceptionHandler.handleMapNotExistApiException(e);
            }
        }
    }

    private class MapElementManager {
        private static final String TAG_GROUP_DEFAULT = "GROUP_DEFAULT";
        private final ConcurrentHashMap<String, ArrayList<IMapElement>> mElementsGroup;

        private MapElementManager() {
            this.mElementsGroup = new ConcurrentHashMap<>();
        }

        /* access modifiers changed from: private */
        public void addElement(String str, IMapElement iMapElement) {
            ArrayList<IMapElement> orCreateElementGroup = getOrCreateElementGroup(str);
            synchronized (orCreateElementGroup) {
                orCreateElementGroup.add(iMapElement);
            }
        }

        private void removeElement(String str, IMapElement iMapElement) {
            synchronized (this.mElementsGroup) {
                ArrayList arrayList = this.mElementsGroup.get(str);
                if (arrayList != null && arrayList.contains(iMapElement)) {
                    arrayList.remove(iMapElement);
                }
                if (arrayList != null && arrayList.isEmpty()) {
                    this.mElementsGroup.remove(str);
                }
            }
        }

        /* access modifiers changed from: private */
        public void removeElement(IMapElement iMapElement) {
            synchronized (this.mElementsGroup) {
                Iterator<Map.Entry<String, ArrayList<IMapElement>>> it = this.mElementsGroup.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry next = it.next();
                    ArrayList arrayList = (ArrayList) next.getValue();
                    if (arrayList != null && arrayList.contains(iMapElement)) {
                        arrayList.remove(iMapElement);
                    }
                    if (arrayList.isEmpty() && ((String) next.getKey()) != null) {
                        it.remove();
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public void removeGroup(String str) {
            synchronized (this.mElementsGroup) {
                if (str != null) {
                    if (this.mElementsGroup.containsKey(str)) {
                        this.mElementsGroup.remove(str);
                    }
                }
            }
        }

        private ArrayList<IMapElement> getOrCreateElementGroup(String str) {
            ArrayList<IMapElement> arrayList;
            synchronized (this.mElementsGroup) {
                arrayList = this.mElementsGroup.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.mElementsGroup.put(str, arrayList);
                }
            }
            return arrayList;
        }

        /* access modifiers changed from: private */
        public ArrayList<IMapElement> getElementGroupByTag(String str) {
            ArrayList<IMapElement> arrayList;
            synchronized (this.mElementsGroup) {
                arrayList = this.mElementsGroup.get(str);
            }
            return arrayList;
        }

        /* access modifiers changed from: private */
        public void clear() {
            synchronized (this.mElementsGroup) {
                if (!this.mElementsGroup.isEmpty()) {
                    this.mElementsGroup.clear();
                }
            }
        }
    }

    public int getWidth() {
        View view = getView();
        if (view != null && view.getWidth() > 0) {
            return view.getWidth();
        }
        return 0;
    }

    public int getHeight() {
        View view = getView();
        if (view != null && view.getHeight() > 0) {
            return view.getHeight();
        }
        return 0;
    }

    public void updateIsNight(boolean z) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            iMapDelegate.updateIsNight(z);
        }
    }

    public void setRotateAngle(float f) {
        IMapDelegate iMapDelegate = this.f10684c;
        if (iMapDelegate != null) {
            iMapDelegate.setRotateAngle(f);
        }
    }
}
