package com.didichuxing.bigdata.p173dp.locsdk.once.util;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import com.google.android.gms.location.FusedLocationProviderApi;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.util.MockLocationChecker */
public class MockLocationChecker {

    /* renamed from: a */
    private static final String f46148a = "fused";

    /* renamed from: b */
    private static final float f46149b = 200.0f;

    /* renamed from: c */
    private static Location f46150c;

    public static boolean isMockLocation(Context context, Location location) {
        return isMockLocation(context, location, false);
    }

    public static boolean isMockLocation(Context context, Location location, boolean z) {
        boolean z2;
        if (Build.VERSION.SDK_INT < 23) {
            z2 = !isMockLocation(location) && !isMockSettingsOn(context);
        } else {
            z2 = isMockLocation(location);
            if (!z2) {
                z2 = m33146a(location);
            }
            if (!z2) {
                z2 = isMockLocationMarkedInFLPExtras(location);
            }
        }
        if (z && location != null) {
            if (!z2) {
                location = null;
            }
            m33147b(location);
        }
        return z2;
    }

    public static boolean isMockLocation(Location location) {
        if (Build.VERSION.SDK_INT < 18 || location == null || !location.isFromMockProvider()) {
            return false;
        }
        return true;
    }

    public static boolean isMockLocationMarkedInFLPExtras(Location location) {
        if (location == null || !f46148a.equals(location.getProvider()) || location.getAccuracy() <= 200.0f) {
            return false;
        }
        Bundle extras = location.getExtras();
        return extras == null || extras.getBoolean(FusedLocationProviderApi.KEY_MOCK_LOCATION);
    }

    public static boolean isMockSettingsOn(Context context) {
        if (Build.VERSION.SDK_INT >= 23 || context == null) {
            return false;
        }
        try {
            return !"0".equals(Settings.Secure.getString(context.getContentResolver(), "mock_location"));
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m33146a(Location location) {
        Location location2 = f46150c;
        if (location2 == null || location == null || Double.doubleToLongBits(location2.getLatitude()) != Double.doubleToLongBits(location.getLatitude()) || Double.doubleToLongBits(location2.getLongitude()) != Double.doubleToLongBits(location.getLongitude())) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private static void m33147b(Location location) {
        f46150c = location;
    }
}
