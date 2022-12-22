package com.didi.dimina.container.secondparty.permission.checker;

import android.content.Context;
import android.location.LocationManager;
import java.util.List;

/* renamed from: com.didi.dimina.container.secondparty.permission.checker.c */
/* compiled from: LocationFineTest */
class C7590c implements PermissionTest {

    /* renamed from: a */
    private final Context f17353a;

    C7590c(Context context) {
        this.f17353a = context;
    }

    /* renamed from: a */
    public boolean mo55894a() throws Throwable {
        LocationManager locationManager = (LocationManager) this.f17353a.getSystemService("location");
        List<String> providers = locationManager.getProviders(true);
        boolean contains = providers.contains("gps");
        boolean contains2 = providers.contains("passive");
        if (contains || contains2 || !this.f17353a.getPackageManager().hasSystemFeature("android.hardware.location.gps")) {
            return true;
        }
        return !locationManager.isProviderEnabled("gps");
    }
}
