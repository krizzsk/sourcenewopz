package com.didi.global.map.animation.util;

import android.location.Location;
import com.didi.common.map.model.LatLng;
import com.didi.global.map.animation.SodaAnimEngine;
import java.util.HashMap;
import java.util.Map;

public class AngleUtil {

    /* renamed from: a */
    private static final float f22839a = 22.5f;

    /* renamed from: b */
    private static final float f22840b = 11.25f;

    /* renamed from: c */
    private static final float f22841c = 33.75f;

    /* renamed from: d */
    private static final float f22842d = 56.25f;

    /* renamed from: e */
    private static final float f22843e = 78.75f;

    /* renamed from: f */
    private static final float f22844f = 101.25f;

    /* renamed from: g */
    private static final float f22845g = 123.75f;

    /* renamed from: h */
    private static final float f22846h = 146.25f;

    /* renamed from: i */
    private static final float f22847i = 168.75f;

    /* renamed from: j */
    private static final float f22848j = 191.25f;

    /* renamed from: k */
    private static final float f22849k = 213.75f;

    /* renamed from: l */
    private static final float f22850l = 236.25f;

    /* renamed from: m */
    private static final float f22851m = 258.75f;
    public static Map<Integer, Float> mAngleMap = null;

    /* renamed from: n */
    private static final float f22852n = 281.25f;

    /* renamed from: o */
    private static final float f22853o = 303.75f;

    /* renamed from: p */
    private static final float f22854p = 326.25f;

    /* renamed from: q */
    private static final float f22855q = 348.75f;

    public static int getIndexByAngle(float f) {
        if (f >= f22840b && f < f22841c) {
            return 2;
        }
        if (f >= f22841c && f < f22842d) {
            return 3;
        }
        if (f >= f22842d && f < f22843e) {
            return 4;
        }
        if (f >= f22843e && f < f22844f) {
            return 5;
        }
        if (f >= f22844f && f < f22845g) {
            return 6;
        }
        if (f >= f22845g && f < f22846h) {
            return 7;
        }
        if (f >= f22846h && f < f22847i) {
            return 8;
        }
        if (f >= f22847i && f < f22848j) {
            return 9;
        }
        if (f >= f22848j && f < f22849k) {
            return 10;
        }
        if (f >= f22849k && f < f22850l) {
            return 11;
        }
        if (f >= f22850l && f < f22851m) {
            return 12;
        }
        if (f >= f22851m && f < f22852n) {
            return 13;
        }
        if (f >= f22852n && f < f22853o) {
            return 14;
        }
        if (f < f22853o || f >= f22854p) {
            return (f < f22854p || f >= f22855q) ? 1 : 16;
        }
        return 15;
    }

    /* renamed from: a */
    private static Location m16427a(LatLng latLng) {
        Location location = new Location("someLoc");
        location.setLatitude(latLng.latitude);
        location.setLongitude(latLng.longitude);
        return location;
    }

    public static float getAngle(LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null) {
            return (m16427a(latLng).bearingTo(m16427a(latLng2)) + 360.0f) % 360.0f;
        }
        LogUtil.m16428e("getAngle() from = null || to = null");
        return SodaAnimEngine.DefaultAngle;
    }

    public static int getIndexByLatLng(LatLng latLng, LatLng latLng2) {
        return getIndexByAngle(getAngle(latLng, latLng2));
    }

    public static float getSpecifiedAngle(int i) {
        if (i < 1 || i > 16) {
            return SodaAnimEngine.DefaultAngle;
        }
        if (mAngleMap == null) {
            HashMap hashMap = new HashMap();
            mAngleMap = hashMap;
            hashMap.put(1, Float.valueOf(0.0f));
            mAngleMap.put(2, Float.valueOf(f22839a));
            mAngleMap.put(3, Float.valueOf(45.0f));
            mAngleMap.put(4, Float.valueOf(67.5f));
            mAngleMap.put(5, Float.valueOf(90.0f));
            mAngleMap.put(6, Float.valueOf(112.5f));
            mAngleMap.put(7, Float.valueOf(135.0f));
            mAngleMap.put(8, Float.valueOf(157.5f));
            mAngleMap.put(9, Float.valueOf(180.0f));
            mAngleMap.put(10, Float.valueOf(202.5f));
            mAngleMap.put(11, Float.valueOf(225.0f));
            mAngleMap.put(12, Float.valueOf(247.5f));
            mAngleMap.put(13, Float.valueOf(270.0f));
            mAngleMap.put(14, Float.valueOf(292.5f));
            mAngleMap.put(15, Float.valueOf(315.0f));
            mAngleMap.put(16, Float.valueOf(337.5f));
        }
        return mAngleMap.get(Integer.valueOf(i)).floatValue();
    }

    public static float getSpecifiedAngle(LatLng latLng, LatLng latLng2) {
        return getSpecifiedAngle(getIndexByAngle(getAngle(latLng, latLng2)));
    }
}
