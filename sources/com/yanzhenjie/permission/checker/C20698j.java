package com.yanzhenjie.permission.checker;

import android.content.Context;
import android.location.LocationManager;
import java.util.List;

/* renamed from: com.yanzhenjie.permission.checker.j */
/* compiled from: LocationFineTest */
class C20698j implements PermissionTest {

    /* renamed from: a */
    private Context f56188a;

    C20698j(Context context) {
        this.f56188a = context;
    }

    /* renamed from: a */
    public boolean mo169065a() throws Throwable {
        LocationManager locationManager = (LocationManager) this.f56188a.getSystemService("location");
        List<String> providers = locationManager.getProviders(true);
        boolean contains = providers.contains("gps");
        boolean contains2 = providers.contains("passive");
        if (contains || contains2 || !this.f56188a.getPackageManager().hasSystemFeature("android.hardware.location.gps")) {
            return true;
        }
        return !locationManager.isProviderEnabled("gps");
    }
}
