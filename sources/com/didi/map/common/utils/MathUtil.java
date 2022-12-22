package com.didi.map.common.utils;

import android.graphics.PointF;
import com.didi.map.outer.model.LatLng;

public class MathUtil {
    public static double calShortestAngleDistance(double d) {
        double d2 = d % 360.0d;
        return d2 > 180.0d ? d2 - 360.0d : d2 < -180.0d ? d2 + 360.0d : d2;
    }

    public static double[] calcLineEquation(LatLng latLng, LatLng latLng2) {
        double d;
        double d2 = Double.NaN;
        if (Math.abs(latLng.longitude - latLng2.longitude) < 1.0E-6d) {
            d = Double.NaN;
        } else if (Math.abs(latLng.latitude - latLng2.latitude) < 1.0E-6d) {
            d2 = 0.0d;
            d = latLng.latitude;
        } else {
            d2 = (latLng2.latitude - latLng.latitude) / (latLng2.longitude - latLng.longitude);
            d = ((latLng2.longitude * latLng.latitude) - (latLng.longitude * latLng2.latitude)) / (latLng2.longitude - latLng.latitude);
        }
        return new double[]{d2, d};
    }

    public static double calcMinDistanceFromPointToLine(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double calcDistance = calcDistance(latLng, latLng2);
        double calcDistance2 = calcDistance(latLng, latLng3);
        double calcDistance3 = calcDistance(latLng2, latLng3);
        double d = calcDistance + calcDistance2;
        if (d == calcDistance3) {
            return 0.0d;
        }
        if (calcDistance3 <= 1.0E-6d) {
            return calcDistance;
        }
        double d2 = calcDistance2 * calcDistance2;
        double d3 = calcDistance * calcDistance;
        double d4 = calcDistance3 * calcDistance3;
        if (d2 >= d3 + d4) {
            return calcDistance;
        }
        if (d3 >= d2 + d4) {
            return calcDistance2;
        }
        double d5 = (d + calcDistance3) / 2.0d;
        return (Math.sqrt((((d5 - calcDistance) * d5) * (d5 - calcDistance2)) * (d5 - calcDistance3)) * 2.0d) / calcDistance3;
    }

    public static double[] calcPerpendicularLineEquation(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d;
        double[] calcLineEquation = calcLineEquation(latLng2, latLng3);
        double d2 = Double.NaN;
        if (Double.isNaN(calcLineEquation[0])) {
            d = latLng.latitude;
            d2 = 0.0d;
        } else if (calcLineEquation[0] == 0.0d) {
            d = Double.NaN;
        } else {
            d2 = -1.0d / calcLineEquation[0];
            d = latLng.latitude + ((1.0d / calcLineEquation[0]) * latLng.longitude);
        }
        return new double[]{d2, d};
    }

    public static LatLng calcPerpendicularPoint(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d;
        double d2;
        double[] calcLineEquation = calcLineEquation(latLng2, latLng3);
        if (Double.isNaN(calcLineEquation[0])) {
            d = latLng2.longitude;
            d2 = latLng.latitude;
        } else if (calcLineEquation[0] == 0.0d) {
            d = latLng.longitude;
            d2 = latLng2.latitude;
        } else {
            double d3 = calcLineEquation[0];
            double d4 = d3 * d3;
            double d5 = (((latLng2.longitude * d4) + ((latLng.latitude - latLng2.latitude) * d3)) + latLng.longitude) / (d4 + 1.0d);
            d2 = (d3 * (d5 - latLng2.longitude)) + latLng2.latitude;
            d = d5;
        }
        return new LatLng(d2, d);
    }

    public static LatLng calcOffsetPoint(LatLng latLng, LatLng latLng2, int i) {
        double d;
        double d2;
        if (latLng2.longitude > latLng.longitude) {
            d = latLng.longitude - ((double) i);
        } else {
            d = latLng.longitude + ((double) i);
        }
        if (latLng2.latitude > latLng.latitude) {
            d2 = latLng.latitude - ((double) i);
        } else {
            d2 = latLng.latitude + ((double) i);
        }
        return new LatLng(d2, d);
    }

    public static double calcDistance(LatLng latLng, LatLng latLng2) {
        double d = latLng.longitude - latLng2.longitude;
        double d2 = latLng.latitude - latLng2.latitude;
        return Math.sqrt((d * d) + (d2 * d2));
    }

    public static boolean isOverlap(LatLng latLng, double d, LatLng latLng2, LatLng latLng3) {
        if (calcMinDistanceFromPointToLine(latLng, latLng2, latLng3) - d > 1.0E-6d) {
            return false;
        }
        return isPointOnLine(calcPerpendicularPoint(latLng, latLng2, latLng3), latLng2, latLng3);
    }

    public static boolean isPointOnLine(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        return (calcDistance(latLng2, latLng3) - calcDistance(latLng, latLng2)) - calcDistance(latLng, latLng3) < 1.0E-6d;
    }

    public static PointF getPoiWith2Line(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        if (pointF2.x == pointF.x || pointF4.x == pointF3.x) {
            return null;
        }
        float f = (pointF2.y - pointF.y) / (pointF2.x - pointF.x);
        float f2 = (pointF4.y - pointF3.y) / (pointF4.x - pointF3.x);
        if (f == f2) {
            return null;
        }
        float f3 = ((pointF.y * pointF2.x) - (pointF2.y * pointF.x)) / (pointF2.x - pointF.x);
        float f4 = ((pointF3.y * pointF4.x) - (pointF4.y * pointF3.x)) / (pointF4.x - pointF3.x);
        float f5 = (f4 - f3) / (f - f2);
        return new PointF(f5, (f2 * f5) + f4);
    }

    public static float compareAngle(float f, float f2) {
        return 180.0f - Math.abs(Math.abs(f - f2) - 180.0f);
    }
}
