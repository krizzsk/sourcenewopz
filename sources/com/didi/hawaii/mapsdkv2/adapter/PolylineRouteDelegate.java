package com.didi.hawaii.mapsdkv2.adapter;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Pair;
import com.didi.hawaii.mapsdkv2.adapter.option.GLPolylineOptionAdapter;
import com.didi.hawaii.mapsdkv2.adapter.option.GLRouteOptionAdapter;
import com.didi.hawaii.mapsdkv2.common.DataUtil;
import com.didi.hawaii.mapsdkv2.common.MathsUtils;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.MapPack;
import com.didi.hawaii.mapsdkv2.core.RouteName;
import com.didi.hawaii.mapsdkv2.core.Texture;
import com.didi.hawaii.mapsdkv2.core.overlay.GLPolyline;
import com.didi.hawaii.mapsdkv2.core.overlay.GLRoute;
import com.didi.map.alpha.maps.internal.IPolylineDelegate;
import com.didi.map.alpha.maps.internal.PolylineControl;
import com.didi.map.base.RouteSectionWithName;
import com.didi.map.core.point.GeoPoint;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.Polyline;
import com.didi.map.outer.model.PolylineOptions;
import com.didi.map.outer.model.animation.Animation;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public class PolylineRouteDelegate extends C9003b implements IPolylineDelegate {

    /* renamed from: b */
    private static final GLPolylineOptionAdapter f23751b = new GLPolylineOptionAdapter();

    /* renamed from: c */
    private static final GLRouteOptionAdapter f23752c = new GLRouteOptionAdapter();

    public void clearPolylines() {
    }

    public void polyline_setAboveMaskLayer(String str, boolean z) {
    }

    @Deprecated
    public void polyline_setGeodesic(String str, boolean z) {
    }

    public void polyline_setOriginPoints(String str, List<LatLng> list) {
    }

    public void setBoTrafficUpdate(String str, boolean z) {
    }

    public void startAnimation(String str, Animation animation) {
    }

    public PolylineRouteDelegate(GLViewManager gLViewManager, Map<String, Pair<?, GLOverlayView>> map) {
        super(gLViewManager, map);
    }

    public Polyline addPolyline(PolylineOptions polylineOptions, PolylineControl polylineControl) {
        GLOverlayView gLOverlayView;
        if (polylineOptions.isRoad()) {
            gLOverlayView = new GLRoute(this.viewManager, f23752c.get(polylineOptions, this.viewManager));
        } else {
            gLOverlayView = new GLPolyline(this.viewManager, f23751b.get(polylineOptions, this.viewManager));
        }
        Polyline polyline = new Polyline(polylineOptions, polylineControl, gLOverlayView.getId());
        super.add(gLOverlayView.getId(), polyline, gLOverlayView);
        return polyline;
    }

    public void polyline_remove(String str) {
        remove(str);
    }

    public void polyline_setColor(String str, int i) {
        GLPolyline c = m16894c(str);
        if (c != null) {
            c.setColor(i);
        }
    }

    public void polyline_setCustomColor(String str, int i) {
        GLRoute b = m16893b(str);
        if (b != null) {
            b.setTexture(Texture.customBitmap(i));
        }
    }

    public void polyline_setColors(String str, int[] iArr, int[] iArr2) {
        GLRoute b = m16893b(str);
        if (b != null && iArr != null && iArr2 != null && iArr2.length == iArr.length) {
            b.setColors(iArr2, iArr);
        }
    }

    public int[][] polyline_getColors(String str) {
        Class<int> cls = int.class;
        GLRoute b = m16893b(str);
        if (b == null) {
            return (int[][]) Array.newInstance(cls, new int[]{2, 0});
        }
        int[] colors = b.getColors();
        int[] colorIndexes = b.getColorIndexes();
        int[] iArr = new int[2];
        iArr[1] = colors.length;
        iArr[0] = 2;
        int[][] iArr2 = (int[][]) Array.newInstance(cls, iArr);
        iArr2[0] = colors;
        iArr2[1] = colorIndexes;
        return iArr2;
    }

    public void polyline_setPoints(String str, List<LatLng> list) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a == null) {
            return;
        }
        if (a.second instanceof GLRoute) {
            ((GLRoute) a.second).setPts(DataUtil.latLng2array(list), new int[]{0, list.size() - 1}, new int[]{0});
        } else if (a.second instanceof GLPolyline) {
            ((GLPolyline) a.second).setPts(DataUtil.latLng2array(list));
        }
    }

    public void polyline_setPercent(String str, float f) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null && (a.second instanceof GLRoute)) {
            ((GLRoute) a.second).setPercent(f);
        }
    }

    public void polyline_setPulsePercent(String str, float f) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null && (a.second instanceof GLRoute)) {
            ((GLRoute) a.second).setPulsePercent(f);
        }
    }

    public void polyline_setPulseCustomColor(String str, int i) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null && (a.second instanceof GLRoute)) {
            ((GLRoute) a.second).setPulseCustomColor(i);
        }
    }

    public void polyline_setPulseBitmap(String str, Bitmap bitmap) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null && (a.second instanceof GLRoute)) {
            ((GLRoute) a.second).setPulseTexture(Texture.bitmap(this.viewManager.getMapContext().getResources(), bitmap));
        }
    }

    public void polyline_setPoints(String str, List<LatLng> list, int[] iArr, int[] iArr2) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a == null) {
            return;
        }
        if (a.second instanceof GLRoute) {
            ((GLRoute) a.second).setPts(DataUtil.latLng2array(list), iArr, iArr2);
        } else if (a.second instanceof GLPolyline) {
            ((GLPolyline) a.second).setPts(DataUtil.latLng2array(list));
        }
    }

    public void polyline_setPoints(String str, LatLng[] latLngArr, int[] iArr, int[] iArr2) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a == null) {
            return;
        }
        if (a.second instanceof GLRoute) {
            ((GLRoute) a.second).setPts(latLngArr, iArr, iArr2);
        } else if (a.second instanceof GLPolyline) {
            ((GLPolyline) a.second).setPts(latLngArr);
        }
    }

    public void polyline_setVisible(String str, boolean z) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null) {
            ((GLOverlayView) a.second).setVisible(z);
        }
    }

    public void polyline_setArrow(String str, boolean z) {
        GLRoute b = m16893b(str);
        if (b != null) {
            b.setArrow(z);
        }
    }

    public void polyline_setWidth(String str, float f) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null) {
            if (a.second instanceof GLRoute) {
                ((GLRoute) a.second).setWidth(f);
            } else if (a.second instanceof GLPolyline) {
                ((GLPolyline) a.second).setWidth(f);
            }
        }
    }

    public void polyline_setZIndex(String str, float f) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null) {
            ((GLOverlayView) a.second).setZIndex((int) f);
        }
    }

    public void polyline_setAlpha(String str, float f) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null) {
            ((GLOverlayView) a.second).setAlpha(f);
        }
    }

    public void polyline_setLineCap(String str, boolean z) {
        GLRoute b = m16893b(str);
        if (b != null) {
            b.setDrawCap(z);
        }
    }

    public void polyline_addTurnArrow(String str, int i, int i2, int i3) {
        GLRoute b = m16893b(str);
        if (b != null) {
            b.addTurnArrow(i, i2, i3);
        }
    }

    public void polyline_addTurnArrow(String str, int i, int i2, int i3, int i4) {
        GLRoute b = m16893b(str);
        if (b != null) {
            b.addTurnArrow(i, i2, i3, i4);
        }
    }

    public void polyline_cleanTurnArrow(String str) {
        GLRoute b = m16893b(str);
        if (b != null) {
            b.clearTurnArrow();
        }
    }

    public void polyline_setCustomerColorTexture(String str, String str2, String str3, int i) {
        Texture texture;
        if (str2 == null) {
            texture = MapPack.POLYLINE_RAINBOW_TEXTURE;
        } else {
            texture = Texture.mappack(str2, i, i);
        }
        GLRoute b = m16893b(str);
        if (b != null) {
            b.setTexture(texture);
        }
    }

    public void addRouteName(String str, List<RouteSectionWithName> list) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null && (a.second instanceof GLRoute) && (a.first instanceof Polyline)) {
            GLRoute gLRoute = (GLRoute) a.second;
            long routeId = ((Polyline) a.first).getPolylineOptions().getRouteId();
            RouteName[] routeNameArr = new RouteName[list.size()];
            for (int i = 0; i < list.size(); i++) {
                RouteSectionWithName routeSectionWithName = list.get(i);
                routeNameArr[i] = new RouteName(routeSectionWithName.startNum, routeSectionWithName.endNum, routeSectionWithName.color, routeSectionWithName.roadName);
            }
            gLRoute.setRoadNames(routeNameArr, routeId);
        }
    }

    public void deleteRouteName(long j) {
        GLRoute gLRoute = null;
        for (Map.Entry value : this.f23761a.entrySet()) {
            Pair pair = (Pair) value.getValue();
            if (pair != null && (pair.first instanceof Polyline) && ((Polyline) pair.first).getRouteId() == j && (pair.second instanceof GLRoute)) {
                gLRoute = (GLRoute) pair.second;
            }
        }
        if (gLRoute != null) {
            gLRoute.clearRoadNames();
        }
    }

    public void insertPoint(String str, int i, LatLng latLng, int i2) {
        GLRoute b = m16893b(str);
        if (b != null) {
            b.setClearPoints(i, i2, latLng);
        }
    }

    public void setAlpha(String str, float f) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null) {
            ((GLOverlayView) a.second).setAlpha(f);
        }
    }

    public void setNaviRouteLineErase(String str, boolean z) {
        GLRoute b = m16893b(str);
        if (b != null) {
            b.setEraseWhenClear(z);
        }
    }

    public Rect getNaviRouteLineVisibleRect(String str) {
        GLRoute b = m16893b(str);
        int i = 0;
        if (b == null) {
            return new Rect(0, 0, 0, 0);
        }
        int clearIndex = b.getClearIndex();
        if (clearIndex != -1) {
            i = clearIndex;
        }
        return MathsUtils.boundingBoxE6(b.getPts(), i, b.getPts().length);
    }

    public Rect getNaviRouteLineVisibleRect(String str, int i) {
        GLRoute b = m16893b(str);
        int i2 = 0;
        if (b == null) {
            return new Rect(0, 0, 0, 0);
        }
        int clearIndex = b.getClearIndex();
        LatLng[] pts = b.getPts();
        if (clearIndex != -1) {
            i2 = clearIndex;
        }
        return MathsUtils.boundingBoxE6(pts, i2, i);
    }

    public void setPolylineOptions(String str, PolylineOptions polylineOptions) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a == null) {
            return;
        }
        if (a.second instanceof GLRoute) {
            ((GLOverlayView) a.second).updateOption(f23752c.get(polylineOptions, this.viewManager));
        } else if (a.second instanceof GLPolyline) {
            ((GLOverlayView) a.second).updateOption(f23751b.get(polylineOptions, this.viewManager));
        }
    }

    public Rect getBound(String str) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null) {
            if (a.second instanceof GLRoute) {
                return MathsUtils.boundingBoxE6(((GLRoute) a.second).getPts(), 0, ((GLRoute) a.second).getPts().length);
            }
            if (a.second instanceof GLPolyline) {
                return MathsUtils.boundingBoxE6(((GLPolyline) a.second).getPts(), 0, ((GLPolyline) a.second).getPts().length);
            }
        }
        return new Rect(0, 0, 0, 0);
    }

    public void setOnPolylineClickListener(String str, final DidiMap.OnPolylineClickListener onPolylineClickListener) {
        final Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null && (a.first instanceof Polyline)) {
            GLOverlayView gLOverlayView = (GLOverlayView) a.second;
            if (onPolylineClickListener != null) {
                gLOverlayView.setOnClickListener(new GLView.OnClickListener() {
                    public boolean onClick(GLView gLView, LatLng latLng, float f, float f2) {
                        onPolylineClickListener.onPolylineClick((Polyline) a.first, latLng);
                        return true;
                    }
                });
            }
        }
    }

    public GeoPoint getTrueInsertPoint(String str) {
        LatLng trueClearPoint;
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a == null || !(a.second instanceof GLRoute) || (trueClearPoint = ((GLRoute) a.second).getTrueClearPoint()) == null) {
            return null;
        }
        return new GeoPoint((int) (trueClearPoint.latitude * 1000000.0d), (int) (trueClearPoint.longitude * 1000000.0d));
    }

    /* renamed from: b */
    private GLRoute m16893b(String str) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a == null || !(a.second instanceof GLRoute)) {
            return null;
        }
        return (GLRoute) a.second;
    }

    /* renamed from: c */
    private GLPolyline m16894c(String str) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a == null || !(a.second instanceof GLPolyline)) {
            return null;
        }
        return (GLPolyline) a.second;
    }

    public void setRouteId(String str, long j) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null && (a.second instanceof GLRoute)) {
            ((GLRoute) a.second).setRouteNameKey(j);
        }
    }

    public void addViolationParkingSection(String str, int i, int i2, float f, int i3, float f2) {
        Pair<?, GLOverlayView> a = super.mo69649a(str);
        if (a != null && (a.second instanceof GLRoute)) {
            ((GLRoute) a.second).addViolationParkingSection(i, i2, f, i3, f2);
        }
    }

    public LatLng queryViolationParkingIconPosition(String str, int i, int i2, LatLng latLng) {
        Pair<?, GLOverlayView> a = super.mo69649a(str);
        if (a == null || !(a.second instanceof GLRoute)) {
            return null;
        }
        return ((GLRoute) a.second).queryViolationParkingIconPosition(i, i2, latLng);
    }

    public void flashViolationParkingSection(String str, int i, boolean z) {
        Pair<?, GLOverlayView> a = super.mo69649a(str);
        if (a != null && (a.second instanceof GLRoute)) {
            ((GLRoute) a.second).flashViolationParkingSection(i, z);
        }
    }

    public void removeViolationParkingSection(String str, int i) {
        Pair<?, GLOverlayView> a = super.mo69649a(str);
        if (a != null && (a.second instanceof GLRoute)) {
            ((GLRoute) a.second).removeViolationParkingSection(i);
        }
    }
}
