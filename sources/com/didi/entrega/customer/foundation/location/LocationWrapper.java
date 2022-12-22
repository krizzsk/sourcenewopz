package com.didi.entrega.customer.foundation.location;

import com.didi.entrega.customer.foundation.util.LocationUtil;

public class LocationWrapper {

    /* renamed from: a */
    private LocationUtil.LocationCallback f19933a;

    /* renamed from: b */
    private int f19934b;

    public static class Timeout {
        public static final int DEFAULT_GPS_TIMEOUT = 4000;
        public static final int SAFE_GPS_TIMEOUT = 1000;
    }

    public LocationWrapper(LocationUtil.LocationCallback locationCallback, int i) {
        this.f19933a = locationCallback;
        this.f19934b = i;
    }

    public void startLocation() {
        int i = this.f19934b;
        if (i < 1000) {
            new LocationTaskDefault(this.f19933a).startLocation();
        } else {
            new LocationTaskEnhanced(this.f19933a, i).startLocation();
        }
    }
}
