package com.didi.hawaii.mapsdkv2.adapter;

import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import com.didi.hawaii.mapsdkv2.adapter.option.GLCircleOptionAdapter;
import com.didi.hawaii.mapsdkv2.common.MathsUtils;
import com.didi.hawaii.mapsdkv2.common.Tranform2Piex20Utils;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.overlay.GLBorderCircle;
import com.didi.map.alpha.maps.internal.CircleControl;
import com.didi.map.alpha.maps.internal.ICircleDelegate;
import com.didi.map.common.utils.SystemUtil;
import com.didi.map.common.utils.TransformUtil;
import com.didi.map.core.point.DoublePoint;
import com.didi.map.outer.model.Circle;
import com.didi.map.outer.model.CircleOptions;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;
import java.util.Map;

public final class CircleDelegate extends C9003b implements ICircleDelegate {

    /* renamed from: b */
    private static final GLCircleOptionAdapter f23691b = new GLCircleOptionAdapter();

    public void clearCircles() {
    }

    public RectF getPixel20Bound(String str, float f) {
        return null;
    }

    public CircleDelegate(GLViewManager gLViewManager, Map<String, Pair<?, GLOverlayView>> map) {
        super(gLViewManager, map);
    }

    public Circle addCircle(CircleOptions circleOptions, CircleControl circleControl) {
        GLBorderCircle gLBorderCircle = new GLBorderCircle(this.viewManager, f23691b.get(circleOptions, this.viewManager));
        Circle circle = new Circle(circleOptions, circleControl, gLBorderCircle.getId());
        add(gLBorderCircle.getId(), circle, gLBorderCircle);
        return circle;
    }

    public void circle_remove(String str) {
        remove(str);
    }

    public void circle_setCenter(String str, LatLng latLng) {
        GLBorderCircle b = m16828b(str);
        if (b != null) {
            b.setCenter(latLng);
        }
    }

    public void circle_setFillColor(String str, int i) {
        GLBorderCircle b = m16828b(str);
        if (b != null) {
            b.setFillColor(i);
        }
    }

    public void circle_setRadius(String str, double d) {
        GLBorderCircle b = m16828b(str);
        if (b != null) {
            b.setRadius((float) d);
        }
    }

    public void circle_setStrokeColor(String str, int i) {
        GLBorderCircle b = m16828b(str);
        if (b != null) {
            b.setBorderColor(i);
        }
    }

    public void circle_setStrokeWidth(String str, float f) {
        GLBorderCircle b = m16828b(str);
        if (b != null) {
            b.setBorderWidth(f / SystemUtil.getDensity(this.viewManager.getMapContext().getAndroidContext()));
        }
    }

    public void circle_setVisible(String str, boolean z) {
        GLBorderCircle b = m16828b(str);
        if (b != null) {
            b.setVisible(z);
        }
    }

    public void circle_setZIndex(String str, float f) {
        GLBorderCircle b = m16828b(str);
        if (b != null) {
            b.setZIndex((int) f);
        }
    }

    public void setOptions(String str, CircleOptions circleOptions) {
        GLBorderCircle b = m16828b(str);
        if (b != null) {
            b.updateOption(f23691b.get(circleOptions, this.viewManager));
        }
    }

    /* renamed from: b */
    private GLBorderCircle m16828b(String str) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a == null || !(a.second instanceof GLBorderCircle)) {
            return null;
        }
        return (GLBorderCircle) a.second;
    }

    public LatLngBounds getBounds(LatLng latLng, double d) {
        if (latLng == null) {
            return null;
        }
        if (d == 0.0d) {
            return new LatLngBounds(latLng, latLng);
        }
        double[] calculateEqualLatitudePoint = MathsUtils.calculateEqualLatitudePoint(latLng.longitude, latLng.latitude, d);
        DoublePoint latlng2PixelStandardScaleLevel = Tranform2Piex20Utils.latlng2PixelStandardScaleLevel(latLng, (DoublePoint) null);
        DoublePoint latlng2PixelStandardScaleLevel2 = Tranform2Piex20Utils.latlng2PixelStandardScaleLevel(new LatLng(calculateEqualLatitudePoint[1], calculateEqualLatitudePoint[0]), (DoublePoint) null);
        double sqrt = Math.sqrt(Math.pow(latlng2PixelStandardScaleLevel2.f24753x - latlng2PixelStandardScaleLevel.f24753x, 2.0d) + Math.pow(latlng2PixelStandardScaleLevel2.f24754y - latlng2PixelStandardScaleLevel.f24754y, 2.0d));
        return new LatLngBounds(Tranform2Piex20Utils.pixel20ToLatlng(new DoublePoint(latlng2PixelStandardScaleLevel.f24753x - sqrt, latlng2PixelStandardScaleLevel.f24754y + sqrt), (LatLng) null), Tranform2Piex20Utils.pixel20ToLatlng(new DoublePoint(latlng2PixelStandardScaleLevel.f24753x + sqrt, latlng2PixelStandardScaleLevel.f24754y - sqrt), (LatLng) null));
    }

    public Rect getBound(String str) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a == null || !(a.second instanceof GLBorderCircle)) {
            return null;
        }
        GLBorderCircle gLBorderCircle = (GLBorderCircle) a.second;
        DoublePoint DDMapPointForCoordinate = TransformUtil.DDMapPointForCoordinate(gLBorderCircle.getCenter());
        double radius = (double) gLBorderCircle.getRadius();
        LatLng DDCoordinateForMapPoint = TransformUtil.DDCoordinateForMapPoint(new DoublePoint(DDMapPointForCoordinate.f24753x - radius, DDMapPointForCoordinate.f24754y + radius));
        LatLng DDCoordinateForMapPoint2 = TransformUtil.DDCoordinateForMapPoint(new DoublePoint(DDMapPointForCoordinate.f24753x + radius, DDMapPointForCoordinate.f24754y - radius));
        Rect rect = new Rect();
        rect.left = (int) (DDCoordinateForMapPoint.longitude * 1000000.0d);
        rect.bottom = (int) (DDCoordinateForMapPoint.latitude * 1000000.0d);
        rect.right = (int) (DDCoordinateForMapPoint2.longitude * 1000000.0d);
        rect.top = (int) (DDCoordinateForMapPoint2.latitude * 1000000.0d);
        return rect;
    }
}
