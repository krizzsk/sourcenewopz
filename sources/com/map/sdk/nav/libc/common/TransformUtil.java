package com.map.sdk.nav.libc.common;

import android.graphics.Point;
import android.location.Location;

public class TransformUtil {
    private static final double TRANSFORM_PARAM_LAT1 = 0.017453292519943295d;
    private static final double TRANSFORM_PARAM_LAT2 = 0.008726646259971648d;
    private static final double TRANSFORM_PARAM_LAT3 = 114.59155902616465d;
    private static final double TRANSFORM_PARAM_LON = 111319.49077777778d;
    private static final int X_OFFSET = 20037508;
    private static final int Y_OFFSET = 30240971;

    public static int client2ServerX(int i) {
        return i - X_OFFSET;
    }

    public static int client2ServerY(int i) {
        return i - Y_OFFSET;
    }

    public static double clientX2Longitude(int i) {
        return ((double) (i - X_OFFSET)) / 111319.49077777778d;
    }

    private static double deg2rad(double d) {
        return (d * 3.141592653589793d) / 180.0d;
    }

    public static int longitude2ClientX(double d) {
        return (int) ((d * 111319.49077777778d) + 2.0037508E7d);
    }

    public static int server2ClientX(int i) {
        return i + X_OFFSET;
    }

    public static int server2ClientY(int i) {
        return i + Y_OFFSET;
    }

    public static int latitude2ClientY(double d) {
        return (int) (((Math.log(Math.tan((d + 90.0d) * 0.008726646259971648d)) / 0.017453292519943295d) * 111319.49077777778d) + 3.0240971E7d);
    }

    public static double clientY2Latitude(int i) {
        return (Math.atan(Math.exp((((double) (i - Y_OFFSET)) / 111319.49077777778d) * 0.017453292519943295d)) * 114.59155902616465d) - 90.0d;
    }

    public static float distanceBetweenPoints(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (geoPoint != null && geoPoint2 != null) {
            return (float) distanceBetween(((double) geoPoint.getLatitudeE6()) / 1000000.0d, ((double) geoPoint.getLongitudeE6()) / 1000000.0d, ((double) geoPoint2.getLatitudeE6()) / 1000000.0d, ((double) geoPoint2.getLongitudeE6()) / 1000000.0d);
        }
        throw new IllegalArgumentException("point is null");
    }

    public static void distanceBetween(double d, double d2, double d3, double d4, float[] fArr) {
        if (fArr == null || fArr.length < 1) {
            throw new IllegalArgumentException("results is null or has length < 1");
        }
        Location.distanceBetween(d, d2, d3, d4, fArr);
        if (fArr.length > 1 && fArr[1] < 0.0f) {
            fArr[1] = fArr[1] + 360.0f;
        }
        fArr[0] = (float) distanceBetween(d, d2, d3, d4);
    }

    public static double distanceBetween(double d, double d2, double d3, double d4) {
        double deg2rad = deg2rad(d3 - d);
        double deg2rad2 = deg2rad(d4 - d2);
        double d5 = deg2rad / 2.0d;
        double d6 = deg2rad2 / 2.0d;
        double sin = (Math.sin(d5) * Math.sin(d5)) + (Math.sin(d6) * Math.sin(d6) * Math.cos(deg2rad(d)) * Math.cos(deg2rad(d3)));
        return Math.atan2(Math.sqrt(sin), Math.sqrt(1.0d - sin)) * 2.0d * 6371.0d * 1000.0d;
    }

    public static void computeDistanceAndBearing(double d, double d2, double d3, double d4, float[] fArr) {
        double d5;
        double d6;
        float[] fArr2 = fArr;
        double d7 = (0.017453292519943295d * d4) - (d2 * 0.017453292519943295d);
        double atan = Math.atan(Math.tan(d * 0.017453292519943295d) * 0.996647189328169d);
        double atan2 = Math.atan(0.996647189328169d * Math.tan(d3 * 0.017453292519943295d));
        double cos = Math.cos(atan);
        double cos2 = Math.cos(atan2);
        double sin = Math.sin(atan);
        double sin2 = Math.sin(atan2);
        double d8 = cos * cos2;
        double d9 = sin * sin2;
        double d10 = d7;
        double d11 = 0.0d;
        double d12 = 0.0d;
        double d13 = 0.0d;
        double d14 = 0.0d;
        double d15 = 0.0d;
        int i = 0;
        while (true) {
            if (i >= 20) {
                d5 = sin;
                d6 = sin2;
                break;
            }
            d11 = Math.cos(d10);
            d13 = Math.sin(d10);
            double d16 = cos2 * d13;
            double d17 = (cos * sin2) - ((sin * cos2) * d11);
            d5 = sin;
            double sqrt = Math.sqrt((d16 * d16) + (d17 * d17));
            d6 = sin2;
            double d18 = d9 + (d8 * d11);
            d14 = Math.atan2(sqrt, d18);
            double d19 = sqrt == 0.0d ? 0.0d : (d8 * d13) / sqrt;
            double d20 = 1.0d - (d19 * d19);
            double d21 = d20 == 0.0d ? 0.0d : d18 - ((d9 * 2.0d) / d20);
            double d22 = 0.006739496756586903d * d20;
            double d23 = ((d22 / 16384.0d) * (((((320.0d - (175.0d * d22)) * d22) - 0.005859375d) * d22) + 4096.0d)) + 1.0d;
            double d24 = (d22 / 1024.0d) * ((d22 * (((74.0d - (47.0d * d22)) * d22) - 0.03125d)) + 256.0d);
            double d25 = 2.0955066698943685E-4d * d20 * (((4.0d - (d20 * 3.0d)) * 0.0033528106718309896d) + 4.0d);
            double d26 = d21 * d21;
            d15 = d24 * sqrt * (d21 + ((d24 / 4.0d) * ((((d26 * 2.0d) - 4.0d) * d18) - ((((d24 / 6.0d) * d21) * (((sqrt * 4.0d) * sqrt) - 1.5d)) * ((d26 * 4.0d) - 1.5d)))));
            double d27 = d7 + ((1.0d - d25) * 0.0033528106718309896d * d19 * (d14 + (sqrt * d25 * (d21 + (d25 * d18 * (((2.0d * d21) * d21) - 4.0d))))));
            if (Math.abs((d27 - d10) / d27) < 1.0E-12d) {
                d12 = d23;
                break;
            }
            i++;
            sin = d5;
            sin2 = d6;
            d10 = d27;
            d12 = d23;
        }
        float[] fArr3 = fArr;
        fArr3[0] = (float) (6356752.3142d * d12 * (d14 - d15));
        if (fArr3.length > 1) {
            double d28 = cos * d6;
            fArr3[1] = (float) (((double) ((float) Math.atan2(cos2 * d13, d28 - ((d5 * cos2) * d11)))) * 57.29577951308232d);
            if (fArr3.length > 2) {
                fArr3[2] = (float) (((double) ((float) Math.atan2(cos * d13, ((-d5) * cos2) + (d28 * d11)))) * 57.29577951308232d);
            }
        }
    }

    public static GeoPoint clientPointToGeoPoint(int i, int i2) {
        return new GeoPoint((int) (clientY2Latitude(i2) * 1000000.0d), (int) (clientX2Longitude(i) * 1000000.0d));
    }

    public static Point geoPointToClientPoint(GeoPoint geoPoint) {
        if (geoPoint != null) {
            return new Point(longitude2ClientX(((double) geoPoint.getLongitudeE6()) / 1000000.0d), latitude2ClientY(((double) geoPoint.getLatitudeE6()) / 1000000.0d));
        }
        throw new IllegalArgumentException("point is null");
    }

    public static GeoPoint serverPointToGeoPoint(int i, int i2) {
        return new GeoPoint((int) (clientY2Latitude(server2ClientY(i2)) * 1000000.0d), (int) (clientX2Longitude(server2ClientX(i)) * 1000000.0d));
    }

    public static Point geoPointToServerPoint(GeoPoint geoPoint) {
        if (geoPoint != null) {
            return new Point(client2ServerX(longitude2ClientX(((double) geoPoint.getLongitudeE6()) / 1000000.0d)), client2ServerY(latitude2ClientY(((double) geoPoint.getLatitudeE6()) / 1000000.0d)));
        }
        throw new IllegalArgumentException("point is null");
    }

    public static Point geoPointToServerPoint(int i, int i2) {
        return new Point(client2ServerX(longitude2ClientX(((double) i) / 1000000.0d)), client2ServerY(latitude2ClientY(((double) i2) / 1000000.0d)));
    }

    public static Point geo2EnginePoint(GeoPoint geoPoint) {
        if (geoPoint != null) {
            Point point = new Point();
            point.x = (int) ((((((double) geoPoint.getLongitudeE6()) / 1000000.0d) + 180.0d) / 360.0d) * 2.68435456E8d);
            point.y = (int) (((180.0d - (Math.log(Math.tan(((((double) geoPoint.getLatitudeE6()) / 1000000.0d) + 90.0d) * 0.008726646259971648d)) / 0.01745329238474369d)) / 360.0d) * 2.68435456E8d);
            return point;
        }
        throw new IllegalArgumentException("point is null");
    }

    public static GeoPoint enginePoint2Geo(int i, int i2) {
        return new GeoPoint((int) Math.ceil(((Math.atan(Math.exp((180.0d - ((double) ((((float) i2) * 360.0f) / 2.68435456E8f))) * 0.017453292519943295d)) / 0.008726646259971648d) - 90.0d) * 1000000.0d), (int) Math.ceil((((double) ((((float) i) * 360.0f) / 2.68435456E8f)) - 180.0d) * 1000000.0d));
    }

    public static float getDirection(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (geoPoint == null || geoPoint2 == null) {
            return 0.0f;
        }
        float[] fArr = new float[10];
        distanceBetween(((double) geoPoint.getLatitudeE6()) / 1000000.0d, ((double) geoPoint.getLongitudeE6()) / 1000000.0d, ((double) geoPoint2.getLatitudeE6()) / 1000000.0d, ((double) geoPoint2.getLongitudeE6()) / 1000000.0d, fArr);
        return fArr[1];
    }
}
