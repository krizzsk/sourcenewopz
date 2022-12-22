package com.didi.hawaii.mapsdkv2.adapter;

import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import com.didi.hawaii.mapsdkv2.adapter.option.GLBorderPolygonOptionAdapter;
import com.didi.hawaii.mapsdkv2.common.MathsUtils;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.overlay.GLBorderPolygon;
import com.didi.map.alpha.maps.internal.IPolygonDelegate;
import com.didi.map.alpha.maps.internal.PolygonControl;
import com.didi.map.common.utils.SystemUtil;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.Polygon;
import com.didi.map.outer.model.PolygonOptions;
import java.util.List;
import java.util.Map;

public class PolygonDelegate extends C9003b implements IPolygonDelegate {

    /* renamed from: b */
    private static final GLBorderPolygonOptionAdapter f23750b = new GLBorderPolygonOptionAdapter();

    public void clearPolygons() {
    }

    public RectF getPixel20Bound(String str, float f) {
        return null;
    }

    public void polygon_setGeodesic(String str, boolean z) {
    }

    public PolygonDelegate(GLViewManager gLViewManager, Map<String, Pair<?, GLOverlayView>> map) {
        super(gLViewManager, map);
    }

    public Polygon addPolygon(PolygonOptions polygonOptions, PolygonControl polygonControl) {
        GLBorderPolygon gLBorderPolygon = new GLBorderPolygon(this.viewManager, f23750b.get(polygonOptions, this.viewManager));
        Polygon polygon = new Polygon(polygonOptions, polygonControl, gLBorderPolygon.getId());
        add(polygon.getId(), polygon, gLBorderPolygon);
        return polygon;
    }

    public void setBellowRoute(String str, boolean z) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null && (a.second instanceof GLBorderPolygon)) {
            ((GLBorderPolygon) a.second).setBellowRoute(z);
        }
    }

    public void polygon_remove(String str) {
        remove(str);
    }

    public void polygon_setFillColor(String str, int i) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null && (a.second instanceof GLBorderPolygon)) {
            ((GLBorderPolygon) a.second).setColor(i);
        }
    }

    public void polygon_setPoints(String str, List<LatLng> list) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null && (a.second instanceof GLBorderPolygon)) {
            ((GLBorderPolygon) a.second).updatePolygonPoints(list);
        }
    }

    public void polygon_setStrokeColor(String str, int i) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null && (a.second instanceof GLBorderPolygon)) {
            ((GLBorderPolygon) a.second).setBorderColor(i);
        }
    }

    public void polygon_setStrokeWidth(String str, float f) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null && (a.second instanceof GLBorderPolygon)) {
            ((GLBorderPolygon) a.second).setBorderWidth(f / SystemUtil.getDensity(this.viewManager.getMapContext().getAndroidContext()));
        }
    }

    public void polygon_setVisible(String str, boolean z) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null && (a.second instanceof GLBorderPolygon)) {
            ((GLOverlayView) a.second).setVisible(z);
        }
    }

    public void polygon_setZIndex(String str, float f) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null && (a.second instanceof GLBorderPolygon)) {
            ((GLOverlayView) a.second).setZIndex((int) f);
        }
    }

    public void setOptions(String str, PolygonOptions polygonOptions) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null && (a.second instanceof GLBorderPolygon)) {
            GLBorderPolygon gLBorderPolygon = (GLBorderPolygon) a.second;
        }
    }

    public Rect getBound(String str) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a == null || !(a.second instanceof GLBorderPolygon)) {
            return null;
        }
        GLBorderPolygon gLBorderPolygon = (GLBorderPolygon) a.second;
        return MathsUtils.boundingBoxE6(gLBorderPolygon.getPts(), 0, gLBorderPolygon.getPts().length);
    }

    public void setOnPolygonClickListener(String str, final DidiMap.OnPolygonClickListener onPolygonClickListener) {
        final Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null && (a.second instanceof GLBorderPolygon)) {
            GLBorderPolygon gLBorderPolygon = (GLBorderPolygon) a.second;
            if (onPolygonClickListener != null) {
                gLBorderPolygon.setOnClickListener(new GLView.OnClickListener() {
                    public boolean onClick(GLView gLView, LatLng latLng, float f, float f2) {
                        onPolygonClickListener.onPolygonClick((Polygon) a.first, latLng);
                        return true;
                    }
                });
            }
        }
    }

    public void setClickable(String str, boolean z) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null && (a.second instanceof GLBorderPolygon)) {
            ((GLBorderPolygon) a.second).setClickable(z);
        }
    }
}
