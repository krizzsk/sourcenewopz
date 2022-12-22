package com.didi.map.outer.model;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import com.didi.hawaii.log.HWLog;
import com.didi.map.alpha.maps.internal.PolylineControl;
import com.didi.map.base.RouteSectionWithName;
import com.didi.map.common.utils.TransformUtil;
import com.didi.map.core.point.GeoPoint;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.model.PolylineOptions;
import com.didi.map.outer.model.animation.AlphaAnimation;
import com.didi.map.outer.model.animation.Animation;
import com.didi.map.outer.model.animation.EmergeAnimation;
import com.didi.util.CrashTryCatcher;
import java.util.Collection;
import java.util.List;

public final class Polyline implements IMapElement {
    public static final int DARK_BLUE = 6;
    public static final int DASHED = 33;
    public static final int DIDI_PSG_BLUE = 20;
    public static final int DIDI_PSG_SLIGHTBLUE = 0;
    public static final int GREEN = 4;
    public static final int GREY = 0;
    public static final int LIGHT_BLUE = 1;
    public static final int RED = 2;
    public static final int WHITE_BLUE = 19;
    public static final int YELLOW = 3;

    /* renamed from: b */
    private static final float f28017b = 10.0f;

    /* renamed from: a */
    long f28018a;

    /* renamed from: c */
    private PolylineOptions f28019c;

    /* renamed from: d */
    private String f28020d;

    /* renamed from: e */
    private PolylineControl f28021e;

    /* renamed from: f */
    private boolean f28022f;

    /* renamed from: g */
    private int f28023g;

    public RectF getPixel20Bound(float f) {
        return null;
    }

    public boolean isBoTrafficUpdate() {
        return this.f28022f;
    }

    public void setBoTrafficUpdate(boolean z) {
        this.f28022f = z;
        this.f28021e.setBoTrafficUpdate(this.f28020d, z);
        this.f28019c.setBoTrafficUpdate(z);
    }

    public void setTurnArrowType(int i) {
        this.f28023g = i;
    }

    public long getRouteId() {
        return this.f28018a;
    }

    public void setRouteId(long j) {
        this.f28018a = j;
        this.f28019c.setRouteId(j);
        PolylineControl polylineControl = this.f28021e;
        if (polylineControl != null) {
            polylineControl.setRouteId(this.f28020d, j);
        }
    }

    public Polyline(PolylineOptions polylineOptions, PolylineControl polylineControl, String str) {
        this.f28019c = null;
        this.f28020d = "";
        this.f28021e = null;
        this.f28018a = -1;
        this.f28023g = 0;
        this.f28020d = str;
        this.f28019c = polylineOptions;
        this.f28021e = polylineControl;
    }

    public void setPolylineOptions(PolylineOptions polylineOptions) {
        if (polylineOptions != null) {
            this.f28019c.arrow(polylineOptions.isArrow());
            this.f28019c.zIndex(polylineOptions.getZIndex());
            this.f28019c.width(polylineOptions.getWidth());
            this.f28019c.color(polylineOptions.getColor());
            this.f28019c.aboveMaskLayer(polylineOptions.isAboveMaskLayer());
            this.f28019c.alpha(polylineOptions.getAlpha());
            this.f28019c.animation(polylineOptions.getAnimation());
            this.f28019c.mo77273a(polylineOptions.isGeodesic());
            this.f28019c.visible(polylineOptions.isVisible());
            this.f28021e.setPolylineOptions(this.f28020d, polylineOptions);
        }
    }

    public PolylineOptions getPolylineOptions() {
        return this.f28019c;
    }

    public void remove() {
        HWLog.m16761i("hw", "polyline remove = " + getRouteId() + " strId:" + this.f28020d);
        PolylineControl polylineControl = this.f28021e;
        if (polylineControl != null) {
            polylineControl.polyline_remove(this.f28020d);
        }
    }

    public void removeRoadName() {
        PolylineControl polylineControl = this.f28021e;
        if (polylineControl != null) {
            long j = this.f28018a;
            if (j > 0) {
                polylineControl.removeRoadName(j);
            }
        }
    }

    public String getId() {
        return this.f28020d;
    }

    public void setPoints(List<LatLng> list) {
        this.f28021e.polyline_setPoints(this.f28020d, list);
    }

    public void setPercent(float f) {
        this.f28021e.polyline_setPercent(this.f28020d, f);
    }

    public void setPulsePercent(float f) {
        this.f28021e.polyline_setPulsePercent(this.f28020d, f);
    }

    public void setPulseCustomColor(int i) {
        this.f28021e.polyline_setPulseCustomColor(this.f28020d, i);
    }

    public void setPulseBitmap(Bitmap bitmap) {
        this.f28021e.polyline_setPulseBitmap(this.f28020d, bitmap);
    }

    public void setPoints(List<LatLng> list, int[] iArr, int[] iArr2) {
        this.f28021e.polyline_setPoints(this.f28020d, list, iArr, iArr2);
    }

    public void setPoints(LatLng[] latLngArr, int[] iArr, int[] iArr2) {
        this.f28021e.polyline_setPoints(this.f28020d, latLngArr, iArr, iArr2);
    }

    public void setOriginPoints(List<LatLng> list) {
        this.f28021e.polyline_setOriginPoints(this.f28020d, list);
    }

    public void setOnPolylineClickListener(DidiMap.OnPolylineClickListener onPolylineClickListener) {
        this.f28021e.setOnPolylineClickListener(this.f28020d, onPolylineClickListener);
    }

    public void addAllFishBoneRoadNames(Collection<RouteSectionWithName> collection) {
        this.f28019c.addAllFishBoneRoadNames(collection);
    }

    public void addAllRoadNames(List<RouteSectionWithName> list) {
        this.f28019c.addAllRoadNames(list);
        this.f28021e.addRouteName(this.f28020d, list);
    }

    public void setRouteName(List<PolylineOptions.RouteWithName> list) {
        throw new IllegalStateException("driver no use this method");
    }

    public void addTurnArrow(int i, int i2) {
        if (i != -1) {
            i = this.f28019c.getNewIndex(i);
        }
        this.f28021e.polyline_addTurnArrow(this.f28020d, i, i2, this.f28023g);
    }

    public void addTurnArrow(int i, int i2, int i3) {
        if (i != -1) {
            i = this.f28019c.getNewIndex(i);
        }
        this.f28021e.polyline_addTurnArrow(this.f28020d, i, i2, i3, this.f28023g);
    }

    public void cleanTurnArrow() {
        HWLog.m16759d("navsdk", "cleanTurnArrow");
        this.f28021e.polyline_cleanTurnArrow(this.f28020d);
    }

    public List<LatLng> getPoints() {
        return this.f28019c.getPoints();
    }

    public void setWidth(float f) {
        this.f28021e.polyline_setWidth(this.f28020d, f);
        this.f28019c.width(f);
    }

    public float getWidth() {
        return this.f28019c.getWidth();
    }

    public void setColor(int i) {
        if (this.f28019c.getLineType() == 5) {
            this.f28021e.polyline_setCustomColor(this.f28020d, i);
        } else {
            this.f28021e.polyline_setColor(this.f28020d, i);
        }
        this.f28019c.color(i);
    }

    public void setColors(int[] iArr, int[] iArr2) {
        this.f28021e.setColors(this.f28020d, iArr, iArr2);
        this.f28019c.colors(iArr, iArr2);
    }

    public void setColor() {
        int[][] colors = this.f28019c.getColors();
        if (colors != null) {
            this.f28021e.setColors(this.f28020d, colors[0], colors[1]);
        }
    }

    public int[][] getColors() {
        return this.f28021e.getColors(this.f28020d);
    }

    public void setArrow(boolean z) {
        this.f28021e.polyline_setArrow(this.f28020d, z);
        this.f28019c.arrow(z);
    }

    public void setColorTexture(String str, String str2, int i) {
        this.f28021e.setCustomerColorTexture(this.f28020d, str, str2, i);
    }

    public int getColor() {
        return this.f28019c.getColor();
    }

    public void setZIndex(float f) {
        this.f28021e.polyline_setZIndex(this.f28020d, f);
        this.f28019c.zIndex(f);
    }

    public float getZIndex() {
        return this.f28019c.getZIndex();
    }

    public void setAlpha(float f) {
        this.f28021e.polyline_setAlpha(this.f28020d, f);
        this.f28019c.alpha(f);
    }

    public void setLineCap(boolean z) {
        this.f28021e.polyline_setLineCap(this.f28020d, z);
        this.f28019c.lineCap(z);
    }

    public boolean getLineCap() {
        return this.f28019c.getLineCap();
    }

    public void setVisible(boolean z) {
        this.f28021e.polyline_setVisible(this.f28020d, z);
        this.f28019c.visible(z);
    }

    public boolean isVisible() {
        return this.f28019c.isVisible();
    }

    public void setAboveMaskLayer(boolean z) {
        this.f28021e.polyline_setAboveMaskLayer(this.f28020d, z);
        this.f28019c.aboveMaskLayer(z);
    }

    public boolean isAboveMaskLayer() {
        return this.f28019c.isAboveMaskLayer();
    }

    public void setGeodesic(boolean z) {
        this.f28021e.polyline_setGeodesic(this.f28020d, z);
        this.f28019c.mo77273a(z);
    }

    public boolean isGeodesic() {
        return this.f28019c.isGeodesic();
    }

    public Polyline(PolylineOptions polylineOptions) {
        this(polylineOptions, (PolylineControl) null, (String) null);
    }

    public void insertPoint(int i, LatLng latLng) {
        this.f28021e.insertPoint(this.f28020d, this.f28019c.getNewIndex(i), latLng, i);
    }

    public void insertPoint(int i, LatLng latLng, int i2, int i3) {
        if (!m19951a(i, latLng)) {
            HWLog.m16761i("hw", "!isIndexVaild(index, point)");
        } else {
            this.f28021e.insertPoint(this.f28020d, this.f28019c.getNewIndex(i), latLng, i3);
        }
    }

    public GeoPoint getTrueInsertPoint() {
        return this.f28021e.polylineGetTrueInsertPoint(this.f28020d);
    }

    public void setNaviRouteLineErase(boolean z) {
        this.f28021e.setNaviRouteLineErase(this.f28020d, z);
        this.f28019c.setErase(z);
    }

    public Rect getNaviRouteLineVisibleRect() {
        PolylineControl polylineControl = this.f28021e;
        if (polylineControl == null) {
            return null;
        }
        return polylineControl.getNaviRouteLineVisibleRect(this.f28020d);
    }

    public Rect getNaviRouteLineVisibleRect(int i) {
        return this.f28021e.getNaviRouteLineVisibleRect(this.f28020d, i);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Polyline)) {
            return false;
        }
        return this.f28020d.equals(((Polyline) obj).f28020d);
    }

    public int hashCode() {
        return this.f28020d.hashCode();
    }

    public void startAnimation(Animation animation) {
        if ((animation instanceof AlphaAnimation) || (animation instanceof EmergeAnimation)) {
            PolylineControl polylineControl = this.f28021e;
            if (polylineControl != null) {
                polylineControl.startAnimation(this.f28020d, animation);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Unsupported animation, only AlphaAnimation and EmergeAnimation allowed.");
    }

    /* renamed from: a */
    private boolean m19951a(int i, LatLng latLng) {
        int i2;
        PolylineOptions polylineOptions = this.f28019c;
        if (polylineOptions == null) {
            return false;
        }
        List<LatLng> newPoints = polylineOptions.getNewPoints();
        List<LatLng> points = this.f28019c.getPoints();
        if (!(newPoints == null || newPoints.size() == 0)) {
            int size = points.size();
            if (i >= 0 && (i2 = i + 1) < size) {
                try {
                    LatLng latLng2 = newPoints.get(this.f28019c.getNewIndex(i));
                    if (this.f28019c.getNewIndex(i2) >= newPoints.size()) {
                        return false;
                    }
                    if (m19952a(latLng2, newPoints.get(this.f28019c.getNewIndex(i2)), latLng)) {
                        return true;
                    }
                    HWLog.m16761i("polyline", "index & point not inLine pos:" + latLng.toString() + ";index=" + i);
                } catch (IndexOutOfBoundsException e) {
                    CrashTryCatcher.logCrash(e);
                }
            } else if (i == size - 1) {
                return true;
            } else {
                HWLog.m16761i("hw", "index & point not inLine pos:" + latLng.toString() + ";index=" + i);
            }
            return false;
        }
        return false;
    }

    /* renamed from: a */
    private int m19950a(int i, LatLng latLng, int i2) {
        List<LatLng> points;
        PolylineOptions polylineOptions = this.f28019c;
        if (!(polylineOptions == null || (points = polylineOptions.getPoints()) == null || points.size() == 0)) {
            int size = points.size();
            boolean z = true;
            int i3 = i;
            while (i3 < size && i3 != size - 1) {
                int i4 = i3 + 1;
                if (m19952a(points.get(i3), points.get(i4), latLng)) {
                    return i3;
                }
                if (z) {
                    z = false;
                    for (int i5 = i3 - i2; i5 < i3; i5++) {
                        if (i5 >= 0 && m19952a(points.get(i5), points.get(i5 + 1), latLng)) {
                            return i5;
                        }
                    }
                    continue;
                }
                i3 = i4;
            }
            return i;
        }
        return i;
    }

    /* renamed from: a */
    private boolean m19952a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        LatLng latLng4 = latLng;
        LatLng latLng5 = latLng2;
        LatLng latLng6 = latLng3;
        if (latLng4 == null || latLng5 == null) {
            return false;
        }
        if (Math.abs((TransformUtil.distanceBetween(latLng4.latitude, latLng4.longitude, latLng5.latitude, latLng5.longitude) - TransformUtil.distanceBetween(latLng4.latitude, latLng4.longitude, latLng6.latitude, latLng6.longitude)) - TransformUtil.distanceBetween(latLng6.latitude, latLng6.longitude, latLng5.latitude, latLng5.longitude)) < 20.0d) {
            return true;
        }
        return false;
    }

    public Rect getBound() {
        return this.f28021e.getBound(this.f28020d);
    }

    public void addViolationParkingSection(int i, int i2, float f, int i3, float f2) {
        if (this.f28021e != null) {
            int newIndex = this.f28019c.getNewIndex(i2);
            int newIndex2 = this.f28019c.getNewIndex(i3);
            HWLog.m16761i("hw", "Polyline addViolationParkingSection2 section_uid:" + i + " startIndex:" + i2 + " endIndex:" + i3 + " lastStartIndex:" + newIndex + " lastEndIndex:" + newIndex2);
            this.f28021e.addViolationParkingSection(this.f28020d, i, newIndex, f, newIndex2, f2);
        }
    }

    public LatLng queryViolationParkingIconPosition(int i, int i2, LatLng latLng) {
        if (this.f28021e == null) {
            return null;
        }
        int newIndex = this.f28019c.getNewIndex(i2);
        HWLog.m16761i("hw", "Polyline queryViolationParkingIconPosition section_uid:" + i + " index:" + i2 + " lastIndex:" + newIndex);
        return this.f28021e.queryViolationParkingIconPosition(this.f28020d, i, newIndex, latLng);
    }

    public void flashViolationParkingSection(int i, boolean z) {
        PolylineControl polylineControl = this.f28021e;
        if (polylineControl != null) {
            polylineControl.flashViolationParkingSection(this.f28020d, i, z);
        }
    }

    public void removeViolationParkingSection(int i) {
        PolylineControl polylineControl = this.f28021e;
        if (polylineControl != null) {
            polylineControl.removeViolationParkingSection(this.f28020d, i);
        }
    }
}
