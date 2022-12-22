package com.didi.soda.customer.foundation.location;

import com.didi.soda.customer.foundation.util.LocationUtil;

public class LocationWrapper {

    /* renamed from: a */
    private LocationUtil.LocationCallback f40940a;

    /* renamed from: b */
    private int f40941b;

    public static class Timeout {
        public static final int DEFAULT_GPS_TIMEOUT = 4000;
        public static final int SAFE_GPS_TIMEOUT = 1000;
    }

    public LocationWrapper(LocationUtil.LocationCallback locationCallback, int i) {
        this.f40940a = locationCallback;
        this.f40941b = i;
    }

    public void startLocation() {
        int i = this.f40941b;
        if (i < 1000) {
            new LocationTaskDefault(this.f40940a).startLocation();
        } else {
            new LocationTaskEnhanced(this.f40940a, i).startLocation();
        }
    }
}
