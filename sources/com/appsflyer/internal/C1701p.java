package com.appsflyer.internal;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.appsflyer.AndroidUtils;
import com.yanzhenjie.permission.runtime.Permission;

/* renamed from: com.appsflyer.internal.p */
public final class C1701p {

    /* renamed from: com.appsflyer.internal.p$a */
    public static final class C1702a {

        /* renamed from: Ι */
        public static final C1701p f2007 = new C1701p();
    }

    C1701p() {
    }

    /* renamed from: ǃ */
    private static boolean m1678(Context context, String[] strArr) {
        for (String isPermissionAvailable : strArr) {
            if (AndroidUtils.isPermissionAvailable(context, isPermissionAvailable)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ı */
    public static Location m1677(Context context) {
        Location location;
        Location location2;
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (m1678(context, new String[]{Permission.ACCESS_FINE_LOCATION, Permission.ACCESS_COARSE_LOCATION})) {
                location = locationManager.getLastKnownLocation("network");
            } else {
                location = null;
            }
            if (m1678(context, new String[]{Permission.ACCESS_FINE_LOCATION})) {
                location2 = locationManager.getLastKnownLocation("gps");
            } else {
                location2 = null;
            }
            if (location2 == null && location == null) {
                location = null;
            } else if (location2 != null || location == null) {
                if ((location == null && location2 != null) || 60000 >= location.getTime() - location2.getTime()) {
                    location = location2;
                }
            }
            if (location != null) {
                return location;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
