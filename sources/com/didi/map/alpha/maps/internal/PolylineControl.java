package com.didi.map.alpha.maps.internal;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import com.didi.hawaii.log.HWLog;
import com.didi.map.base.RouteSectionWithName;
import com.didi.map.core.point.GeoPoint;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.MainThreadChecker;
import com.didi.map.outer.model.Polyline;
import com.didi.map.outer.model.PolylineOptions;
import com.didi.map.outer.model.animation.Animation;
import java.util.List;

public final class PolylineControl {

    /* renamed from: a */
    private IPolylineDelegate f24562a = null;

    public PolylineControl(IPolylineDelegate iPolylineDelegate) {
        this.f24562a = iPolylineDelegate;
    }

    public void exit() {
        if (this.f24562a != null) {
            this.f24562a = null;
        }
    }

    public final Polyline addPolyline(PolylineOptions polylineOptions) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            return iPolylineDelegate.addPolyline(polylineOptions, this);
        }
        HWLog.m16761i("hw", "addPolyline return null ,polyDelegat == null");
        return null;
    }

    public final void polyline_remove(String str) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate == null) {
            HWLog.m16761i("hw", "polyline_remove return null ,polyDelegat == null");
        } else {
            iPolylineDelegate.polyline_remove(str);
        }
    }

    public final void removeRoadName(long j) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate == null) {
            HWLog.m16761i("hw", "removeRoadName return null ,polyDelegat == null");
        } else {
            iPolylineDelegate.deleteRouteName(j);
        }
    }

    public final void polyline_setColor(String str, int i) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.polyline_setColor(str, i);
        }
    }

    public final void polyline_setCustomColor(String str, int i) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.polyline_setCustomColor(str, i);
        }
    }

    public final void setColors(String str, int[] iArr, int[] iArr2) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.polyline_setColors(str, iArr, iArr2);
        }
    }

    public final int[][] getColors(String str) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate == null) {
            return null;
        }
        return iPolylineDelegate.polyline_getColors(str);
    }

    public final void setCustomerColorTexture(String str, String str2, String str3, int i) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.polyline_setCustomerColorTexture(str, str2, str3, i);
        }
    }

    public final void polyline_setGeodesic(String str, boolean z) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.polyline_setGeodesic(str, z);
        }
    }

    public final void polyline_setPoints(String str, List<LatLng> list) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.polyline_setPoints(str, list);
        }
    }

    public final void polyline_setPercent(String str, float f) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.polyline_setPercent(str, f);
        }
    }

    public final void polyline_setPulsePercent(String str, float f) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.polyline_setPulsePercent(str, f);
        }
    }

    public final void polyline_setPulseCustomColor(String str, int i) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.polyline_setPulseCustomColor(str, i);
        }
    }

    public final void polyline_setPulseBitmap(String str, Bitmap bitmap) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.polyline_setPulseBitmap(str, bitmap);
        }
    }

    public final void polyline_setPoints(String str, List<LatLng> list, int[] iArr, int[] iArr2) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.polyline_setPoints(str, list, iArr, iArr2);
        }
    }

    public final void polyline_setPoints(String str, LatLng[] latLngArr, int[] iArr, int[] iArr2) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.polyline_setPoints(str, latLngArr, iArr, iArr2);
        }
    }

    public final void polyline_setOriginPoints(String str, List<LatLng> list) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.polyline_setOriginPoints(str, list);
        }
    }

    public final void polyline_addTurnArrow(String str, int i, int i2, int i3) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.polyline_addTurnArrow(str, i, i2, i3);
        }
    }

    public final void polyline_addTurnArrow(String str, int i, int i2, int i3, int i4) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.polyline_addTurnArrow(str, i, i2, i3, i4);
        }
    }

    public final void polyline_cleanTurnArrow(String str) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.polyline_cleanTurnArrow(str);
        }
    }

    public final void polyline_setVisible(String str, boolean z) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.polyline_setVisible(str, z);
        }
    }

    public final void polyline_setArrow(String str, boolean z) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.polyline_setArrow(str, z);
        }
    }

    public final void polyline_setWidth(String str, float f) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.polyline_setWidth(str, f);
        }
    }

    public final void polyline_setZIndex(String str, float f) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.polyline_setZIndex(str, f);
        }
    }

    public final void polyline_setAlpha(String str, float f) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.polyline_setAlpha(str, f);
        }
    }

    public final void polyline_setLineCap(String str, boolean z) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.polyline_setLineCap(str, z);
        }
    }

    public final void polyline_setAboveMaskLayer(String str, boolean z) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.polyline_setAboveMaskLayer(str, z);
        }
    }

    public final void addRouteName(String str, List<RouteSectionWithName> list) {
        if (this.f24562a != null && !TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            this.f24562a.addRouteName(str, list);
        }
    }

    public final void insertPoint(String str, int i, LatLng latLng, int i2) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        if (this.f24562a != null) {
            this.f24562a.insertPoint(str, i, latLng, i2);
        }
    }

    public final void clearPolylines() {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.clearPolylines();
        }
    }

    public void startAnimation(String str, Animation animation) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.startAnimation(str, animation);
        }
    }

    public void setAlpha(String str, float f) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.setAlpha(str, f);
        }
    }

    public void setNaviRouteLineErase(String str, boolean z) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.setNaviRouteLineErase(str, z);
        }
    }

    public void setRouteId(String str, long j) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.setRouteId(str, j);
        }
    }

    public Rect getNaviRouteLineVisibleRect(String str) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate == null) {
            return new Rect();
        }
        return iPolylineDelegate.getNaviRouteLineVisibleRect(str);
    }

    public Rect getNaviRouteLineVisibleRect(String str, int i) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate == null) {
            return new Rect();
        }
        return iPolylineDelegate.getNaviRouteLineVisibleRect(str, i);
    }

    public void setPolylineOptions(String str, PolylineOptions polylineOptions) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.setPolylineOptions(str, polylineOptions);
        }
    }

    public void setBoTrafficUpdate(String str, boolean z) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.setBoTrafficUpdate(str, z);
        }
    }

    public Rect getBound(String str) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate == null) {
            return new Rect();
        }
        return iPolylineDelegate.getBound(str);
    }

    public void setOnPolylineClickListener(String str, DidiMap.OnPolylineClickListener onPolylineClickListener) {
        MainThreadChecker.checkMainThread(MainThreadChecker.MAP_SDK);
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.setOnPolylineClickListener(str, onPolylineClickListener);
        }
    }

    public GeoPoint polylineGetTrueInsertPoint(String str) {
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            return iPolylineDelegate.getTrueInsertPoint(str);
        }
        return null;
    }

    public void addViolationParkingSection(String str, int i, int i2, float f, int i3, float f2) {
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.addViolationParkingSection(str, i, i2, f, i3, f2);
        }
    }

    public LatLng queryViolationParkingIconPosition(String str, int i, int i2, LatLng latLng) {
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            return iPolylineDelegate.queryViolationParkingIconPosition(str, i, i2, latLng);
        }
        return null;
    }

    public void flashViolationParkingSection(String str, int i, boolean z) {
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.flashViolationParkingSection(str, i, z);
        }
    }

    public void removeViolationParkingSection(String str, int i) {
        IPolylineDelegate iPolylineDelegate = this.f24562a;
        if (iPolylineDelegate != null) {
            iPolylineDelegate.removeViolationParkingSection(str, i);
        }
    }
}
