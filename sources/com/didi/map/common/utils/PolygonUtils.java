package com.didi.map.common.utils;

import android.graphics.PointF;
import com.didi.map.outer.model.LatLng;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class PolygonUtils {
    public static final int CLIPTYPE_DIFFERENCE = 2;
    public static final int CLIPTYPE_INTERSECTION = 0;
    public static final int CLIPTYPE_IXOR = 3;
    public static final int CLIPTYPE_UNION = 1;

    public static List<List<LatLng>> clip(List<LatLng> list, List<LatLng> list2, int i) {
        try {
            return (List) Class.forName("com.didi.hawaii.mapsdkv2.PolygonUtilsV2").getMethod("polygonClipp", new Class[]{List.class, List.class, Integer.TYPE}).invoke((Object) null, new Object[]{list, list2, Integer.valueOf(i)});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return new ArrayList();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return new ArrayList();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return new ArrayList();
        }
    }

    public static List<LatLng> generateCirclePoints(LatLng latLng, float f) {
        try {
            return (List) Class.forName("com.didi.hawaii.mapsdkv2.PolygonUtilsV2").getMethod("generateCirclePoints", new Class[]{LatLng.class, Float.TYPE}).invoke((Object) null, new Object[]{latLng, Float.valueOf(f)});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return new ArrayList();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return new ArrayList();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return new ArrayList();
        }
    }

    public static double[] generateCircle(PointF pointF, PointF pointF2, PointF pointF3) {
        double d;
        double d2;
        PointF pointF4 = pointF;
        PointF pointF5 = pointF2;
        PointF pointF6 = pointF3;
        double d3 = (double) ((pointF4.x - pointF6.x) * 2.0f);
        double d4 = (double) ((pointF4.y - pointF6.y) * 2.0f);
        double d5 = (double) (((pointF4.y * pointF4.y) - (pointF6.y * pointF6.y)) + ((pointF4.x * pointF4.x) - (pointF6.x * pointF6.x)));
        double d6 = (double) ((pointF5.x - pointF6.x) * 2.0f);
        double d7 = (double) ((pointF5.y - pointF6.y) * 2.0f);
        double d8 = (double) (((pointF5.y * pointF5.y) - (pointF6.y * pointF6.y)) + ((pointF5.x * pointF5.x) - (pointF6.x * pointF6.x)));
        double d9 = 0.0d;
        if ((Math.abs(d3) >= 0.01d || Math.abs(d4) >= 0.01d) && (Math.abs(d6) >= 0.01d || Math.abs(d7) >= 0.01d)) {
            double d10 = ((d3 * d8) - (d6 * d5)) / ((d3 * d7) - (d6 * d4));
            double d11 = Math.abs(d3) > Math.abs(d6) ? (d5 - (d4 * d10)) / d3 : (d8 - (d7 * d10)) / d6;
            d = Math.sqrt(((d11 - ((double) pointF4.x)) * (d11 - ((double) pointF4.x))) + ((d10 - ((double) pointF4.y)) * (d10 - ((double) pointF4.y))));
            d2 = d10;
            d9 = d11;
        } else {
            d2 = 0.0d;
            d = 0.0d;
        }
        return new double[]{d9, d2, d};
    }
}
