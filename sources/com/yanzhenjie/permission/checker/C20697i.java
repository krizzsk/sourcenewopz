package com.yanzhenjie.permission.checker;

import android.content.Context;
import android.location.LocationManager;

/* renamed from: com.yanzhenjie.permission.checker.i */
/* compiled from: LocationCoarseTest */
class C20697i implements PermissionTest {

    /* renamed from: a */
    private Context f56187a;

    C20697i(Context context) {
        this.f56187a = context;
    }

    /* renamed from: a */
    public boolean mo169065a() throws Throwable {
        LocationManager locationManager = (LocationManager) this.f56187a.getSystemService("location");
        if (!locationManager.getProviders(true).contains("network") && this.f56187a.getPackageManager().hasSystemFeature("android.hardware.location.network")) {
            return !locationManager.isProviderEnabled("network");
        }
        return true;
    }
}
