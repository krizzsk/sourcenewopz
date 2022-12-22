package com.didi.map.alpha.maps.internal;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.didi.map.common.accessibility.MapAccessibilityEventSource;
import com.didi.map.outer.map.DMarker;
import com.didi.map.outer.map.DiMapInterface;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.map.InfoWindowAnimationManager;
import com.didi.map.outer.model.BaseMarkerOption;
import com.didi.map.outer.model.BitmapDescriptor;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;
import com.didi.map.outer.model.Marker;
import com.didi.map.outer.model.MarkerInfoWindowOption;
import com.didi.map.outer.model.MarkerOptions;
import com.didi.map.outer.model.animation.Animation;
import java.util.List;

public interface IMarkerDelegate<T extends DMarker> {
    Marker addMarker(MarkerOptions markerOptions, MarkerControl markerControl);

    void clearMarkers();

    Rect getBound(String str);

    List<LatLng> getBounderPoints(String str);

    Point getFixingPoint(String str);

    InfoWindowAnimationManager getInfoWindowAnimationManager();

    List<LatLng> getInfoWindowBoderPoints(String str);

    RectF getInfoWindowScreenRect(String str);

    DidiMap.OnMarkerClickListener getOnClickListener(String str);

    RectF getPixel20Bound(String str, float f);

    LatLng getPosition(String str);

    float getRotateAngle(String str);

    Rect getScreenRect(String str);

    boolean hideInfoWindow(String str);

    boolean isClickable(String str);

    boolean isFixingPointEnabled(String str);

    boolean isInfoWindowShown(String str);

    void onSetTouchableContent(T t);

    void removeMarker(String str);

    void setAccessibilityDelegate(MapAccessibilityEventSource mapAccessibilityEventSource);

    void setAlpha(String str, float f);

    void setAnchor(String str, float f, float f2);

    void setAnimation(String str, Animation animation);

    void setAnimationListener(String str, Animation.AnimationListener animationListener);

    void setBitmap(String str, Bitmap bitmap);

    void setClickable(String str, boolean z);

    void setDraggable(String str, boolean z);

    void setFixingPoint(String str, int i, int i2);

    void setFixingPointEnable(String str, boolean z);

    void setGroundIcon(String str, LatLngBounds latLngBounds, BitmapDescriptor bitmapDescriptor);

    void setIcon(String str, BitmapDescriptor bitmapDescriptor);

    void setInfoWindowUnique(boolean z);

    void setMarkerInfoOption(String str, MarkerInfoWindowOption markerInfoWindowOption);

    void setMarkerOptions(String str, BaseMarkerOption baseMarkerOption);

    void setMarkerRotateAngle(String str, float f);

    void setNaviState(String str, boolean z, boolean z2);

    void setOffset(String str, PointF pointF);

    void setOnClickListener(String str, DiMapInterface.IOnMarkerClickListener<T> iOnMarkerClickListener);

    void setOnTapMapInfoWindowHidden(String str, boolean z);

    void setOnVisibleChangeListener(String str, DidiMap.OnMarkerVisibleChangeListener onMarkerVisibleChangeListener);

    void setPosition(String str, LatLng latLng);

    void setPositionNotUpdate(String str, LatLng latLng);

    void setRotateAngleNotUpdate(String str, float f);

    void setScale(String str, PointF pointF);

    void setSnippet(String str, String str2);

    void setTitle(String str, String str2);

    void setVisible(String str, boolean z);

    void setZIndex(String str, float f);

    boolean showInfoWindow(String str);

    boolean showInfoWindowWithGravity(String str, int i);

    boolean startAnimation(String str);
}
