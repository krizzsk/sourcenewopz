package com.didi.common.map.util;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.LatLngBounds;

public class MapUtils {

    /* renamed from: a */
    private static final double f10950a = 6378137.0d;

    /* renamed from: b */
    private static final String f10951b = "MapUtils";

    /* renamed from: a */
    private static double m7390a(double d) {
        return (d * 3.141592653589793d) / 180.0d;
    }

    /* renamed from: b */
    private static double m7393b(double d) {
        return (d * 180.0d) / 3.141592653589793d;
    }

    /* renamed from: a */
    private static double m7391a(double d, double d2) {
        return m7393b(d2 / (Math.cos(m7390a(d)) * f10950a));
    }

    /* renamed from: c */
    private static double m7395c(double d) {
        return m7393b(d / f10950a);
    }

    /* renamed from: a */
    private static double m7392a(double... dArr) {
        double d = dArr[0];
        for (double d2 : dArr) {
            if (d2 > d) {
                d = d2;
            }
        }
        return d;
    }

    /* renamed from: b */
    private static double m7394b(double... dArr) {
        double d = dArr[0];
        for (double d2 : dArr) {
            if (d2 < d) {
                d = d2;
            }
        }
        return d;
    }

    public static final float calculateZoomLevel(Map map, LatLng latLng, double d, int i, int i2, int i3, int i4) {
        LatLng latLng2 = latLng;
        if (map == null || latLng2 == null) {
            return 0.0f;
        }
        double d2 = latLng2.latitude;
        double d3 = latLng2.longitude;
        double a = m7391a(d2, d);
        double c = m7395c(d);
        return map.calculateZoomToSpanLevel(i, i2, i3, i4, new LatLng(d2 - c, d3 - a), new LatLng(d2 + c, d3 + a));
    }

    public static final LatLngBounds recalculateBounds(LatLngBounds latLngBounds, LatLng latLng) {
        LatLngBounds latLngBounds2 = latLngBounds;
        LatLng latLng2 = latLng;
        LatLng latLng3 = latLngBounds2.southwest;
        LatLng latLng4 = latLngBounds2.northeast;
        LatLng symmetry = getSymmetry(latLng3, latLng2);
        LatLng symmetry2 = getSymmetry(latLng4, latLng2);
        return new LatLngBounds(new LatLng(m7394b(latLng3.latitude, symmetry.latitude, latLng4.latitude, symmetry2.latitude), m7394b(latLng3.longitude, symmetry.longitude, latLng4.longitude, symmetry2.longitude)), new LatLng(m7392a(latLng3.latitude, symmetry.latitude, latLng4.latitude, symmetry2.latitude), m7392a(latLng3.longitude, symmetry.longitude, latLng4.longitude, symmetry2.longitude)));
    }

    public static final LatLng getSymmetry(LatLng latLng, LatLng latLng2) {
        return new LatLng((latLng2.latitude * 2.0d) - latLng.latitude, (latLng2.longitude * 2.0d) - latLng.longitude);
    }

    public static final LatLng getLatLngByPixelOffset(LatLng latLng, int i, int i2, float f, float f2, float f3) {
        LatLng latLng2 = latLng;
        double pow = Math.pow(2.0d, 20.0d - ((double) f3));
        double cos = Math.cos((double) f);
        double d = (double) f2;
        double cos2 = Math.cos(d);
        double sin = Math.sin(d);
        double d2 = (((double) i) / cos) * pow;
        double d3 = (((double) i2) / cos) * pow;
        double d4 = d2 * sin;
        double d5 = (d2 * cos2) + (d3 * sin);
        double d6 = latLng2.latitude;
        double d7 = latLng2.longitude;
        double pow2 = (Math.pow(2.0d, 20.0d) * 256.0d) / 2.0d;
        return new LatLng(((double) Math.round((((Math.atan(Math.exp((((((((Math.log(Math.tan(((d6 + 90.0d) * 3.141592653589793d) / 360.0d)) / 0.017453292519943295d) * pow2) / 180.0d) + d5) * 180.0d) / pow2) * 3.141592653589793d) / 180.0d)) * 2.0d) - 1.5707963267948966d) * 57.29577951308232d) * 1000000.0d)) / 1000000.0d, ((double) Math.round((((((d7 * pow2) / 180.0d) + (d4 + (cos2 * d3))) * 180.0d) / pow2) * 1000000.0d)) / 1000000.0d);
    }

    public static Bitmap getViewBitmap(View view) {
        Bitmap bitmap = null;
        if (view == null) {
            return null;
        }
        try {
            view.setDrawingCacheEnabled(true);
            view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.buildDrawingCache(true);
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null && drawingCache.getWidth() > 0 && drawingCache.getHeight() > 0) {
                bitmap = Bitmap.createBitmap(drawingCache);
            }
            view.setDrawingCacheEnabled(false);
        } catch (Exception e) {
            DLog.m7384d(f10951b, "view change bitmap error :%s", e.toString());
        }
        if (bitmap != null) {
            return bitmap;
        }
        DLog.m7384d(f10951b, "view cache bitmap is null,创建1px的bitmap，保证bitmap 不为空", new Object[0]);
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
        createBitmap.eraseColor(Color.parseColor("#000000"));
        return createBitmap;
    }
}
