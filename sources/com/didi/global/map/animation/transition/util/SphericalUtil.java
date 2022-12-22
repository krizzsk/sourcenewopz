package com.didi.global.map.animation.transition.util;

import com.didi.common.map.model.LatLng;

public class SphericalUtil {
    public static double computeDistanceBetween(LatLng latLng, LatLng latLng2) {
        return m16425a(latLng, latLng2) * 6371009.0d;
    }

    /* renamed from: a */
    private static double m16425a(LatLng latLng, LatLng latLng2) {
        return m16424a(Math.toRadians(latLng.latitude), Math.toRadians(latLng.longitude), Math.toRadians(latLng2.latitude), Math.toRadians(latLng2.longitude));
    }

    /* renamed from: a */
    private static double m16424a(double d, double d2, double d3, double d4) {
        return m16422a(m16423a(d, d3, d2 - d4));
    }

    /* renamed from: a */
    private static double m16422a(double d) {
        return Math.asin(Math.sqrt(d)) * 2.0d;
    }

    /* renamed from: a */
    private static double m16423a(double d, double d2, double d3) {
        return m16426b(d - d2) + (m16426b(d3) * Math.cos(d) * Math.cos(d2));
    }

    /* renamed from: b */
    private static double m16426b(double d) {
        double sin = Math.sin(d * 0.5d);
        return sin * sin;
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
        double a = m16425a(latLng, latLng2);
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
}
