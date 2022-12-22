package com.didi.foundation.sdk.map;

import android.content.Context;
import android.graphics.PointF;
import android.text.TextUtils;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.Projection;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnCameraChangeListener;
import com.didi.common.map.listener.OnMapClickListener;
import com.didi.common.map.listener.OnMapGestureListener;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.CircleOptions;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.model.LineOptions;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.model.Padding;
import com.didi.common.map.model.Polygon;
import com.didi.common.map.model.PolygonOptions;
import com.didi.foundation.sdk.log.LogService;
import com.didi.sdk.logging.Logger;
import java.util.ArrayList;
import java.util.List;

public final class MapViewImpl implements IMapView {

    /* renamed from: a */
    private static final Logger f21254a = LogService.getLogger((Class<?>) MapViewImpl.class);

    /* renamed from: b */
    private Context f21255b;

    /* renamed from: c */
    private List<String> f21256c = new ArrayList();

    /* renamed from: d */
    private Map f21257d;

    public MapViewImpl(Context context, Map map) {
        this.f21255b = context;
        this.f21257d = map;
    }

    public MapVendor getMapVendor() {
        return this.f21257d.getMapVendor();
    }

    public Map getDidiCommonMap() {
        return this.f21257d;
    }

    public void setRotateGesturesEnabled(boolean z) {
        this.f21257d.getUiSettings().setRotateGesturesEnabled(z);
    }

    public void setTiltEnabled(boolean z) {
        this.f21257d.getUiSettings().setTiltEnabled(z);
    }

    public void setZoomControlsEnabled(boolean z) {
        this.f21257d.getUiSettings().setZoomControlsEnabled(z);
    }

    public void setZoomFromCenterByDoubleClickEnabled(boolean z) {
        this.f21257d.getUiSettings().setZoomFromCenterByDoubleClickEnabled(z);
    }

    public void setZoomFromCenterByGestureEnabled(boolean z) {
        this.f21257d.getUiSettings().setZoomFromCenterByGestureEnabled(z);
    }

    public void setMapPadding(int i, int i2, int i3, int i4) {
        this.f21257d.setPadding(i, i2, i3, i4);
    }

    public void setAllGesturesEnable(boolean z) {
        this.f21257d.getUiSettings().setAllGesturesEnabled(z);
    }

    public void setLogoGravity(int i, int i2, int i3, int i4, int i5) {
        this.f21257d.getUiSettings().setLogoGravityWithMargin(i, i3, i5, i2, i4);
    }

    public void showTrafficRoute() {
        this.f21257d.setTrafficEnabled(true);
    }

    public void hideTrafficRoute() {
        this.f21257d.setTrafficEnabled(false);
    }

    public void clearElements() {
        for (String str : new ArrayList(this.f21256c)) {
            Logger logger = f21254a;
            logger.debug("clearElements---->" + str, new Object[0]);
            removeElement(str);
        }
        this.f21256c.clear();
    }

    public Marker addMarker(String str, MarkerOptions markerOptions) {
        this.f21256c.add(str);
        Marker addMarker = this.f21257d.addMarker(str, markerOptions);
        if (addMarker != null) {
            Logger logger = f21254a;
            logger.debug("addMarker---->" + str, new Object[0]);
        }
        return addMarker;
    }

    public void setMarkerPosition(String str, LatLng latLng) {
        Marker oneMarkerByTag = getOneMarkerByTag(str, this.f21257d);
        if (oneMarkerByTag != null) {
            oneMarkerByTag.setPosition(latLng);
        }
    }

    public static Marker getOneMarkerByTag(String str, Map map) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ArrayList<IMapElement> elementGroup = map.getElementGroup(str);
            if (elementGroup != null && elementGroup.size() > 0) {
                IMapElement iMapElement = elementGroup.get(0);
                if (iMapElement instanceof Marker) {
                    return (Marker) iMapElement;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Line addLine(String str, LineOptions lineOptions) {
        this.f21256c.add(str);
        return this.f21257d.addLine(str, lineOptions);
    }

    public void removeElement(String str) {
        this.f21256c.remove(str);
        this.f21257d.removeElementGroupByTag(str);
    }

    public void remove(IMapElement iMapElement) {
        this.f21257d.remove(iMapElement);
    }

    public Polygon addPolygon(String str, PolygonOptions polygonOptions) {
        this.f21256c.add(str);
        return this.f21257d.addPolygon(str, polygonOptions);
    }

    public LatLng getLatLngByOffset(LatLng latLng, float f, float f2) {
        Projection projection = this.f21257d.getProjection();
        if (projection == null || latLng == null) {
            return latLng;
        }
        PointF pointF = null;
        try {
            pointF = projection.toScreenLocation(latLng);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (pointF == null) {
            return latLng;
        }
        pointF.offset(f, f2);
        return projection.fromScreenLocation(pointF);
    }

    public Circle addCircle(String str, CircleOptions circleOptions) {
        this.f21256c.add(str);
        return this.f21257d.addCircle(str, circleOptions);
    }

    public double metersPerPixel(double d) {
        if (this.f21257d.getProjection() != null) {
            return this.f21257d.getProjection().metersPerPixel(d);
        }
        return 0.0d;
    }

    public void addOnMapGestureListener(OnMapGestureListener onMapGestureListener) {
        this.f21257d.addOnMapGestureListener(onMapGestureListener);
    }

    public void removeOnMapGestureListener(OnMapGestureListener onMapGestureListener) {
        this.f21257d.removeOnMapGestureListener(onMapGestureListener);
    }

    public void addOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        this.f21257d.addOnCameraChangeListener(onCameraChangeListener);
    }

    public void removeOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        this.f21257d.removeOnCameraChangeListener(onCameraChangeListener);
    }

    public void addOnMapClickListener(OnMapClickListener onMapClickListener) {
        this.f21257d.addOnMapClickListener(onMapClickListener);
    }

    public void removeOnMapClickListener(OnMapClickListener onMapClickListener) {
        this.f21257d.removeOnMapClickListener(onMapClickListener);
    }

    public void animateCamera(LatLng latLng, List<LatLng> list, Padding padding, Padding padding2) {
        BestViewer.doBestView(this.f21257d, true, latLng, list, padding, padding2);
    }
}
