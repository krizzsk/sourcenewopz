package com.didi.global.map.animation.transition.util;

import android.location.Location;
import com.didi.common.map.model.LatLng;
import com.didi.global.map.animation.transition.SodaAnimEngine;
import java.util.HashMap;
import java.util.Map;

public class AngleUtil {

    /* renamed from: a */
    private static final float f22818a = 22.5f;

    /* renamed from: b */
    private static final float f22819b = 11.25f;

    /* renamed from: c */
    private static final float f22820c = 33.75f;

    /* renamed from: d */
    private static final float f22821d = 56.25f;

    /* renamed from: e */
    private static final float f22822e = 78.75f;

    /* renamed from: f */
    private static final float f22823f = 101.25f;

    /* renamed from: g */
    private static final float f22824g = 123.75f;

    /* renamed from: h */
    private static final float f22825h = 146.25f;

    /* renamed from: i */
    private static final float f22826i = 168.75f;

    /* renamed from: j */
    private static final float f22827j = 191.25f;

    /* renamed from: k */
    private static final float f22828k = 213.75f;

    /* renamed from: l */
    private static final float f22829l = 236.25f;

    /* renamed from: m */
    private static final float f22830m = 258.75f;
    public static Map<Integer, Float> mAngleMap = null;

    /* renamed from: n */
    private static final float f22831n = 281.25f;

    /* renamed from: o */
    private static final float f22832o = 303.75f;

    /* renamed from: p */
    private static final float f22833p = 326.25f;

    /* renamed from: q */
    private static final float f22834q = 348.75f;

    public static int getIndexByAngle(float f) {
        if (f >= f22819b && f < f22820c) {
            return 2;
        }
        if (f >= f22820c && f < f22821d) {
            return 3;
        }
        if (f >= f22821d && f < f22822e) {
            return 4;
        }
        if (f >= f22822e && f < f22823f) {
            return 5;
        }
        if (f >= f22823f && f < f22824g) {
            return 6;
        }
        if (f >= f22824g && f < f22825h) {
            return 7;
        }
        if (f >= f22825h && f < f22826i) {
            return 8;
        }
        if (f >= f22826i && f < f22827j) {
            return 9;
        }
        if (f >= f22827j && f < f22828k) {
            return 10;
        }
        if (f >= f22828k && f < f22829l) {
            return 11;
        }
        if (f >= f22829l && f < f22830m) {
            return 12;
        }
        if (f >= f22830m && f < f22831n) {
            return 13;
        }
        if (f >= f22831n && f < f22832o) {
            return 14;
        }
        if (f < f22832o || f >= f22833p) {
            return (f < f22833p || f >= f22834q) ? 1 : 16;
        }
        return 15;
    }

    /* renamed from: a */
    private static Location m16418a(LatLng latLng) {
        Location location = new Location("someLoc");
        location.setLatitude(latLng.latitude);
        location.setLongitude(latLng.longitude);
        return location;
    }

    public static float getAngle(LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null) {
            return (m16418a(latLng).bearingTo(m16418a(latLng2)) + 360.0f) % 360.0f;
        }
        LogUtil.m16419e("getAngle() from = null || to = null");
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
            mAngleMap.put(2, Float.valueOf(f22818a));
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
