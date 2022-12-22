package com.didi.foundation.sdk.map;

import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
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
import java.util.List;

public interface IMapView {
    public static final int MARKER_MODEL_DEFAULT = 0;
    public static final int MARKER_MODEL_WITH_START_END = 1;
    public static final int MARKER_MODEL_WITH_UP_DOWN = 2;
    public static final String TAG_MARKER_END_NAME_LIST = "tag_marker_end_name_list";
    public static final String TAG_MARKER_END_VIEW = "tag_marker_end_view";
    public static final String TAG_MARKER_START_NAME_LIST = "tag_marker_start_name_list";
    public static final String TAG_MARKER_START_VIEW = "tag_marker_start_view";

    Circle addCircle(String str, CircleOptions circleOptions);

    Line addLine(String str, LineOptions lineOptions);

    Marker addMarker(String str, MarkerOptions markerOptions);

    void addOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener);

    void addOnMapClickListener(OnMapClickListener onMapClickListener);

    void addOnMapGestureListener(OnMapGestureListener onMapGestureListener);

    void animateCamera(LatLng latLng, List<LatLng> list, Padding padding, Padding padding2);

    void clearElements();

    Map getDidiCommonMap();

    LatLng getLatLngByOffset(LatLng latLng, float f, float f2);

    MapVendor getMapVendor();

    void hideTrafficRoute();

    double metersPerPixel(double d);

    void remove(IMapElement iMapElement);

    void removeElement(String str);

    void removeOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener);

    void removeOnMapClickListener(OnMapClickListener onMapClickListener);

    void removeOnMapGestureListener(OnMapGestureListener onMapGestureListener);

    void setAllGesturesEnable(boolean z);

    void setLogoGravity(int i, int i2, int i3, int i4, int i5);

    void setMarkerPosition(String str, LatLng latLng);

    void setRotateGesturesEnabled(boolean z);

    void setTiltEnabled(boolean z);

    void setZoomFromCenterByDoubleClickEnabled(boolean z);

    void setZoomFromCenterByGestureEnabled(boolean z);

    void showTrafficRoute();
}
