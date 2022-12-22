package com.cardinalcommerce.p060a;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import org.osgi.framework.VersionRange;

/* renamed from: com.cardinalcommerce.a.l */
final class C2019l implements LocationListener {

    /* renamed from: c */
    private static int f2607c = 0;

    /* renamed from: d */
    private static int f2608d = 1;

    /* renamed from: a */
    private final setAutoSizeTextTypeUniformWithPresetSizes f2609a;

    /* renamed from: b */
    private final LocationManager f2610b;

    public final void onProviderDisabled(String str) {
        int i = f2608d;
        int i2 = i & 109;
        int i3 = (i2 - (~((i ^ 109) | i2))) - 1;
        f2607c = i3 % 128;
        if (i3 % 2 != 0) {
            Object obj = null;
            super.hashCode();
        }
    }

    public final void onProviderEnabled(String str) {
        int i = f2607c;
        int i2 = i & 83;
        int i3 = (i ^ 83) | i2;
        int i4 = (i2 ^ i3) + ((i3 & i2) << 1);
        f2608d = i4 % 128;
        if ((i4 % 2 == 0 ? VersionRange.RIGHT_OPEN : 'Y') == ')') {
            int i5 = 64 / 0;
        }
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
        int i2 = f2607c;
        int i3 = i2 & 97;
        int i4 = (i3 - (~((i2 ^ 97) | i3))) - 1;
        f2608d = i4 % 128;
        int i5 = i4 % 2;
    }

    public C2019l(setCompoundDrawablePadding setcompounddrawablepadding, Context context) {
        long j;
        this.f2609a = setcompounddrawablepadding;
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        this.f2610b = locationManager;
        Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
        Location lastKnownLocation2 = this.f2610b.getLastKnownLocation("network");
        long time = lastKnownLocation != null ? lastKnownLocation.getTime() : 0;
        if (lastKnownLocation2 != null) {
            j = lastKnownLocation2.getTime();
        } else {
            j = 0;
        }
        if (0 < time - j && lastKnownLocation != null) {
            this.f2609a.init(new setCompoundDrawableTintBlendMode(lastKnownLocation));
        } else if (lastKnownLocation2 != null) {
            this.f2609a.init(new setCompoundDrawableTintBlendMode(lastKnownLocation2));
        }
    }

    public final void onLocationChanged(Location location) {
        this.f2609a.init(new setCompoundDrawableTintBlendMode(location));
        int i = (((f2607c + 75) - 1) + 0) - 1;
        f2608d = i % 128;
        int i2 = i % 2;
    }
}
