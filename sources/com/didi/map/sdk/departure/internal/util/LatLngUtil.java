package com.didi.map.sdk.departure.internal.util;

import android.content.Context;
import com.didi.common.map.model.LatLng;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;

public class LatLngUtil {

    /* renamed from: a */
    private static double f28242a = 0.01745329252d;

    /* renamed from: b */
    private static double f28243b = 6370693.5d;

    public static boolean isSameLatLng(LatLng latLng, LatLng latLng2) {
        return latLng != null && latLng2 != null && m20055a(latLng.latitude, latLng2.latitude) && m20055a(latLng.longitude, latLng2.longitude);
    }

    public static boolean isCompletedSameLatLng(LatLng latLng, LatLng latLng2) {
        return latLng != null && latLng2 != null && latLng.latitude == latLng2.latitude && latLng.longitude == latLng2.longitude;
    }

    /* renamed from: a */
    private static boolean m20055a(double d, double d2) {
        return Math.abs(d - d2) <= 9.999999747378752E-6d;
    }

    public static double getDistance(double d, double d2, double d3, double d4) {
        double d5 = f28242a;
        double d6 = d2 * d5;
        double d7 = d4 * d5;
        double sin = (Math.sin(d6) * Math.sin(d7)) + (Math.cos(d6) * Math.cos(d7) * Math.cos((d * d5) - (d3 * d5)));
        if (sin > 1.0d) {
            sin = 1.0d;
        } else if (sin < -1.0d) {
            sin = -1.0d;
        }
        return f28243b * Math.acos(sin);
    }

    public static double getDistance(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            return 0.0d;
        }
        return getDistance(latLng.longitude, latLng.latitude, latLng2.longitude, latLng2.latitude);
    }

    public static boolean equal(double d, double d2) {
        return Math.abs(d - d2) < 1.0E-6d;
    }

    public static boolean locateCorrect(double d, double d2) {
        return (!equal(d, 0.0d) || !equal(d2, 0.0d)) && d2 <= 180.0d && d <= 90.0d && d2 >= -180.0d && d >= -90.0d;
    }

    public static boolean locateCorrect(LatLng latLng) {
        if (latLng == null) {
            return false;
        }
        return locateCorrect(latLng.latitude, latLng.longitude);
    }

    public static DIDILocation getLastKnownLocation(Context context) {
        return DIDILocationManager.getInstance(context).getLastKnownLocation();
    }

    public static LatLng getLastLatLng(Context context) {
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(context).getLastKnownLocation();
        if (lastKnownLocation == null) {
            return null;
        }
        return new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
    }
}
