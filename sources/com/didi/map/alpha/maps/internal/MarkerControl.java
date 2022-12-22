package com.didi.map.alpha.maps.internal;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.didi.map.base.bubble.BubbleManager;
import com.didi.map.common.accessibility.MapAccessibilityEventSource;
import com.didi.map.outer.map.DiMapInterface;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.map.InfoWindowAnimationManager;
import com.didi.map.outer.model.BaseMarkerOption;
import com.didi.map.outer.model.BitmapDescriptor;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;
import com.didi.map.outer.model.MainThreadChecker;
import com.didi.map.outer.model.Marker;
import com.didi.map.outer.model.MarkerInfoWindowOption;
import com.didi.map.outer.model.MarkerOptions;
import com.didi.map.outer.model.animation.Animation;
import java.util.List;

public class MarkerControl implements IMarkerDelegate<Marker> {

    /* renamed from: a */
    private IMarkerDelegate f24537a = null;

    /* renamed from: b */
    private BubbleManager f24538b;

    public MarkerControl(IMarkerDelegate iMarkerDelegate) {
        this.f24537a = iMarkerDelegate;
    }

    public void exit() {
        if (this.f24537a != null) {
            this.f24537a = null;
        }
    }

    public void setBubbleManager(BubbleManager bubbleManager) {
        this.f24538b = bubbleManager;
    }

    public final Marker addMarker(MarkerOptions markerOptions, MarkerControl markerControl) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate == null) {
            return null;
        }
        Marker addMarker = iMarkerDelegate.addMarker(markerOptions, markerControl);
        if (this.f24538b != null && markerOptions.isCollideRouteLableBubble()) {
            this.f24538b.addBusinessMarker(addMarker);
        }
        return addMarker;
    }

    public void removeMarker(String str) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.removeMarker(str);
            BubbleManager bubbleManager = this.f24538b;
            if (bubbleManager != null) {
                bubbleManager.removeBusinessMarker(str);
            }
        }
    }

    public final void setInfoWindowUnique(boolean z) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setInfoWindowUnique(z);
        }
    }

    public final void setAnchor(String str, float f, float f2) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setAnchor(str, f, f2);
        }
    }

    public final void setDraggable(String str, boolean z) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setDraggable(str, z);
        }
    }

    public final void setIcon(String str, BitmapDescriptor bitmapDescriptor) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null && bitmapDescriptor != null) {
            iMarkerDelegate.setIcon(str, bitmapDescriptor);
        }
    }

    public final void setPosition(String str, LatLng latLng) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setPosition(str, latLng);
        }
    }

    public void setMarkerInfoOption(String str, MarkerInfoWindowOption markerInfoWindowOption) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setMarkerInfoOption(str, markerInfoWindowOption);
        }
    }

    public final void setPositionNotUpdate(String str, LatLng latLng) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setPositionNotUpdate(str, latLng);
        }
    }

    public final void setSnippet(String str, String str2) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setSnippet(str, str2);
        }
    }

    public final LatLng getPosition(String str) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            return iMarkerDelegate.getPosition(str);
        }
        return null;
    }

    public final void setTitle(String str, String str2) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setTitle(str, str2);
        }
    }

    public final void setVisible(String str, boolean z) {
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setVisible(str, z);
        }
    }

    public final boolean showInfoWindow(String str) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            return iMarkerDelegate.showInfoWindow(str);
        }
        return false;
    }

    public final boolean showInfoWindowWithGravity(String str, int i) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            return iMarkerDelegate.showInfoWindowWithGravity(str, i);
        }
        return false;
    }

    public final void setOnTapMapInfoWindowHidden(String str, boolean z) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setOnTapMapInfoWindowHidden(str, z);
        }
    }

    public final void setBitmap(String str, Bitmap bitmap) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setBitmap(str, bitmap);
        }
    }

    public final boolean hideInfoWindow(String str) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            return iMarkerDelegate.hideInfoWindow(str);
        }
        return false;
    }

    public final boolean isInfoWindowShown(String str) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            return iMarkerDelegate.isInfoWindowShown(str);
        }
        return false;
    }

    public final void clearMarkers() {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.clearMarkers();
        }
    }

    public void setMarkerRotateAngle(String str, float f) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setMarkerRotateAngle(str, f);
        }
    }

    public final InfoWindowAnimationManager getInfoWindowAnimationManager() {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate == null) {
            return null;
        }
        return iMarkerDelegate.getInfoWindowAnimationManager();
    }

    public final float getRotateAngle(String str) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            return iMarkerDelegate.getRotateAngle(str);
        }
        return 0.0f;
    }

    public final void setRotateAngleNotUpdate(String str, float f) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setRotateAngleNotUpdate(str, f);
        }
    }

    public final void setNaviState(String str, boolean z, boolean z2) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setNaviState(str, z, z2);
        }
    }

    public void setAnimation(String str, Animation animation) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setAnimation(str, animation);
        }
    }

    public boolean startAnimation(String str) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            return iMarkerDelegate.startAnimation(str);
        }
        return false;
    }

    public void setAnimationListener(String str, Animation.AnimationListener animationListener) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setAnimationListener(str, animationListener);
        }
    }

    public void setAlpha(String str, float f) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setAlpha(str, f);
        }
    }

    public void setScale(String str, PointF pointF) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setScale(str, pointF);
        }
    }

    public void setOffset(String str, PointF pointF) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setOffset(str, pointF);
        }
    }

    public void setGroundIcon(String str, LatLngBounds latLngBounds, BitmapDescriptor bitmapDescriptor) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setGroundIcon(str, latLngBounds, bitmapDescriptor);
        }
    }

    public List<LatLng> getInfoWindowBoderPoints(String str) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            return iMarkerDelegate.getInfoWindowBoderPoints(str);
        }
        return null;
    }

    public void setClickable(String str, boolean z) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setClickable(str, z);
        }
    }

    public boolean isClickable(String str) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            return iMarkerDelegate.isClickable(str);
        }
        return false;
    }

    public void setFixingPointEnable(String str, boolean z) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setFixingPointEnable(str, z);
        }
    }

    public boolean isFixingPointEnabled(String str) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            return iMarkerDelegate.isFixingPointEnabled(str);
        }
        return false;
    }

    public void setFixingPoint(String str, int i, int i2) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setFixingPoint(str, i, i2);
        }
    }

    public Point getFixingPoint(String str) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            return iMarkerDelegate.getFixingPoint(str);
        }
        return null;
    }

    public void setMarkerOptions(String str, BaseMarkerOption baseMarkerOption) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setMarkerOptions(str, baseMarkerOption);
        }
    }

    public void setZIndex(String str, float f) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setZIndex(str, f);
        }
    }

    public void setOnClickListener(String str, DiMapInterface.IOnMarkerClickListener<Marker> iOnMarkerClickListener) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setOnClickListener(str, iOnMarkerClickListener);
        }
    }

    public void setOnVisibleChangeListener(String str, DidiMap.OnMarkerVisibleChangeListener onMarkerVisibleChangeListener) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setOnVisibleChangeListener(str, onMarkerVisibleChangeListener);
        }
    }

    public DidiMap.OnMarkerClickListener getOnClickListener(String str) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            return iMarkerDelegate.getOnClickListener(str);
        }
        return null;
    }

    public Rect getScreenRect(String str) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            return iMarkerDelegate.getScreenRect(str);
        }
        return null;
    }

    public RectF getInfoWindowScreenRect(String str) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            return iMarkerDelegate.getInfoWindowScreenRect(str);
        }
        return null;
    }

    public Rect getBound(String str) {
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            return iMarkerDelegate.getBound(str);
        }
        return new Rect();
    }

    public RectF getPixel20Bound(String str, float f) {
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            return iMarkerDelegate.getPixel20Bound(str, f);
        }
        return null;
    }

    public void onSetTouchableContent(Marker marker) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.onSetTouchableContent(marker);
        }
    }

    public void setAccessibilityDelegate(MapAccessibilityEventSource mapAccessibilityEventSource) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            iMarkerDelegate.setAccessibilityDelegate(mapAccessibilityEventSource);
        }
    }

    public List<LatLng> getBounderPoints(String str) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IMarkerDelegate iMarkerDelegate = this.f24537a;
        if (iMarkerDelegate != null) {
            return iMarkerDelegate.getBounderPoints(str);
        }
        return null;
    }
}
