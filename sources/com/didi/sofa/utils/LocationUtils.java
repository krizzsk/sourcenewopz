package com.didi.sofa.utils;

import android.location.Location;

public final class LocationUtils {
    private LocationUtils() {
    }

    public static double getDistance(double d, double d2, double d3, double d4) {
        try {
            float[] fArr = new float[1];
            Location.distanceBetween(d2, d, d4, d3, fArr);
            return (double) fArr[0];
        } catch (IllegalArgumentException unused) {
            return 0.0d;
        }
    }

    public static boolean isCoordinateValid(Location location) {
        if (location == null) {
            return false;
        }
        return isCoordinateValid(location.getLongitude(), location.getLatitude());
    }

    public static boolean isCoordinateValid(double d, double d2) {
        return Math.abs(d - 0.0d) >= 1.0E-6d || Math.abs(d2 - 0.0d) >= 1.0E-6d;
    }
}
