package com.didi.dimina.container.secondparty.permission.checker;

import android.content.Context;
import android.location.LocationManager;

/* renamed from: com.didi.dimina.container.secondparty.permission.checker.b */
/* compiled from: LocationCoarseTest */
class C7589b implements PermissionTest {

    /* renamed from: a */
    private final Context f17352a;

    C7589b(Context context) {
        this.f17352a = context;
    }

    /* renamed from: a */
    public boolean mo55894a() throws Throwable {
        LocationManager locationManager = (LocationManager) this.f17352a.getSystemService("location");
        if (!locationManager.getProviders(true).contains("network") && this.f17352a.getPackageManager().hasSystemFeature("android.hardware.location.network")) {
            return !locationManager.isProviderEnabled("network");
        }
        return true;
    }
}
