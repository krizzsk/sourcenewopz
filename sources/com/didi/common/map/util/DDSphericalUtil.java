package com.didi.common.map.util;

import com.didi.common.map.model.LatLng;
import java.util.List;

public class DDSphericalUtil {
    private DDSphericalUtil() {
    }

    public static double computeHeading(LatLng latLng, LatLng latLng2) {
        double radians = Math.toRadians(latLng.latitude);
        double radians2 = Math.toRadians(latLng.longitude);
        double radians3 = Math.toRadians(latLng2.latitude);
        double radians4 = Math.toRadians(latLng2.longitude) - radians2;
        return DDMathUtil.wrap(Math.toDegrees(Math.atan2(Math.sin(radians4) * Math.cos(radians3), (Math.cos(radians) * Math.sin(radians3)) - ((Math.sin(radians) * Math.cos(radians3)) * Math.cos(radians4)))), -180.0d, 180.0d);
    }

    public static LatLng computeOffset(LatLng latLng, double d, double d2) {
        double d3 = d / 6371009.0d;
        double radians = Math.toRadians(d2);
        double radians2 = Math.toRadians(latLng.latitude);
        double radians3 = Math.toRadians(latLng.longitude);
        double cos = Math.cos(d3);
        double sin = Math.sin(d3);
        double sin2 = Math.sin(radians2);
        double cos2 = sin * Math.cos(radians2);
        double cos3 = (cos * sin2) + (Math.cos(radians) * cos2);
        return new LatLng(Math.toDegrees(Math.asin(cos3)), Math.toDegrees(radians3 + Math.atan2(cos2 * Math.sin(radians), cos - (sin2 * cos3))));
    }

    public static LatLng computeOffsetOrigin(LatLng latLng, double d, double d2) {
        LatLng latLng2 = latLng;
        double radians = Math.toRadians(d2);
        double d3 = d / 6371009.0d;
        double cos = Math.cos(d3);
        double sin = Math.sin(d3) * Math.cos(radians);
        double sin2 = Math.sin(d3) * Math.sin(radians);
        double sin3 = Math.sin(Math.toRadians(latLng2.latitude));
        double d4 = cos * cos;
        double d5 = sin * sin;
        double d6 = ((d5 * d4) + (d4 * d4)) - ((d4 * sin3) * sin3);
        if (d6 < 0.0d) {
            return null;
        }
        double d7 = sin * sin3;
        double d8 = d4 + d5;
        double sqrt = (d7 + Math.sqrt(d6)) / d8;
        double d9 = (sin3 - (sin * sqrt)) / cos;
        double atan2 = Math.atan2(d9, sqrt);
        if (atan2 < -1.5707963267948966d || atan2 > 1.5707963267948966d) {
            atan2 = Math.atan2(d9, (d7 - Math.sqrt(d6)) / d8);
        }
        if (atan2 < -1.5707963267948966d || atan2 > 1.5707963267948966d) {
            return null;
        }
        return new LatLng(Math.toDegrees(atan2), Math.toDegrees(Math.toRadians(latLng2.longitude) - Math.atan2(sin2, (cos * Math.cos(atan2)) - (sin * Math.sin(atan2)))));
    }

    public static LatLng interpolate(LatLng latLng, LatLng latLng2, double d) {
        LatLng latLng3 = latLng;
        LatLng latLng4 = latLng2;
        double radians = Math.toRadians(latLng3.latitude);
        double radians2 = Math.toRadians(latLng3.longitude);
        double radians3 = Math.toRadians(latLng4.latitude);
        double radians4 = Math.toRadians(latLng4.longitude);
        double cos = Math.cos(radians);
        double cos2 = Math.cos(radians3);
        double a = m7381a(latLng, latLng2);
        double sin = Math.sin(a);
        if (sin < 1.0E-6d) {
            return latLng3;
        }
        double sin2 = Math.sin((1.0d - d) * a) / sin;
        double sin3 = Math.sin(a * d) / sin;
        double d2 = cos * sin2;
        double d3 = cos2 * sin3;
        double d4 = sin3;
        double cos3 = (Math.cos(radians2) * d2) + (Math.cos(radians4) * d3);
        double sin4 = (d2 * Math.sin(radians2)) + (d3 * Math.sin(radians4));
        return new LatLng(Math.toDegrees(Math.atan2((sin2 * Math.sin(radians)) + (Math.sin(radians3) * d4), Math.sqrt((cos3 * cos3) + (sin4 * sin4)))), Math.toDegrees(Math.atan2(sin4, cos3)));
    }

    /* renamed from: a */
    private static double m7380a(double d, double d2, double d3, double d4) {
        return DDMathUtil.arcHav(DDMathUtil.havDistance(d, d3, d2 - d4));
    }

    /* renamed from: a */
    static double m7381a(LatLng latLng, LatLng latLng2) {
        return m7380a(Math.toRadians(latLng.latitude), Math.toRadians(latLng.longitude), Math.toRadians(latLng2.latitude), Math.toRadians(latLng2.longitude));
    }

    public static double computeAngleBetween(double d, double d2, double d3, double d4) {
        return m7380a(Math.toRadians(d), Math.toRadians(d2), Math.toRadians(d3), Math.toRadians(d4));
    }

    public static double computeDistanceBetween(LatLng latLng, LatLng latLng2) {
        return m7381a(latLng, latLng2) * 6371009.0d;
    }

    public static double computeLength(List<LatLng> list) {
        double d = 0.0d;
        if (list == null || list.size() < 2) {
            return 0.0d;
        }
        LatLng latLng = list.get(0);
        double radians = Math.toRadians(latLng.latitude);
        double radians2 = Math.toRadians(latLng.longitude);
        double d2 = radians;
        double d3 = radians2;
        for (LatLng next : list) {
            double radians3 = Math.toRadians(next.latitude);
            double radians4 = Math.toRadians(next.longitude);
            d += m7380a(d2, d3, radians3, radians4);
            d2 = radians3;
            d3 = radians4;
        }
        return d * 6371009.0d;
    }

    public static double computeArea(List<LatLng> list) {
        return Math.abs(computeSignedArea(list));
    }

    public static double computeSignedArea(List<LatLng> list) {
        return m7382a(list, 6371009.0d);
    }

    /* renamed from: a */
    static double m7382a(List<LatLng> list, double d) {
        int size = list.size();
        double d2 = 0.0d;
        if (size < 3) {
            return 0.0d;
        }
        LatLng latLng = list.get(size - 1);
        double tan = Math.tan((1.5707963267948966d - Math.toRadians(latLng.latitude)) / 2.0d);
        double radians = Math.toRadians(latLng.longitude);
        double d3 = tan;
        double d4 = radians;
        for (LatLng next : list) {
            double tan2 = Math.tan((1.5707963267948966d - Math.toRadians(next.latitude)) / 2.0d);
            double radians2 = Math.toRadians(next.longitude);
            d2 += m7383b(tan2, radians2, d3, d4);
            d3 = tan2;
            d4 = radians2;
        }
        return d2 * d * d;
    }

    /* renamed from: b */
    private static double m7383b(double d, double d2, double d3, double d4) {
        double d5 = d2 - d4;
        double d6 = d * d3;
        return Math.atan2(Math.sin(d5) * d6, (d6 * Math.cos(d5)) + 1.0d) * 2.0d;
    }

    public static double computeRouteLength(List<LatLng> list, int i, int i2) {
        double d = 0.0d;
        if (list == null || list.size() <= 1) {
            return 0.0d;
        }
        if (i < 0 || i >= list.size()) {
            return -1.0d;
        }
        if (i2 < 0 || i2 >= list.size()) {
            return -2.0d;
        }
        if (i2 <= i) {
            return -3.0d;
        }
        for (int i3 = i + 1; i3 <= i2; i3++) {
            d += computeDistanceBetween(list.get(i3 - 1), list.get(i3));
        }
        return d;
    }
}
