package com.didi.entrega.customer.flutter.service;

import com.didi.entrega.customer.foundation.util.LocationUtil;
import com.didi.rlab.uni_foundation.location.LocationResult;
import com.didi.rlab.uni_foundation.location.LocationService;
import com.didi.sofa.utils.LocationUtils;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/didi/entrega/customer/flutter/service/LocationServiceImp;", "Lcom/didi/rlab/uni_foundation/location/LocationService;", "()V", "checkLocationPermissions", "", "distanceBetween", "", "lat1", "lng1", "lat2", "lng2", "getCurrentLocation", "Lcom/didi/rlab/uni_foundation/location/LocationResult;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LocationServiceImp.kt */
public final class LocationServiceImp implements LocationService {
    public void checkLocationPermissions() {
    }

    public LocationResult getCurrentLocation() {
        LocationResult locationResult = new LocationResult();
        locationResult.setLatitude(LocationUtil.getCurrentLat());
        locationResult.setLongtitude(LocationUtil.getCurrentLng());
        return locationResult;
    }

    public double distanceBetween(double d, double d2, double d3, double d4) {
        return LocationUtils.getDistance(d, d2, d3, d4);
    }
}
