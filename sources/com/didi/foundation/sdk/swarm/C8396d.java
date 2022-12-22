package com.didi.foundation.sdk.swarm;

import android.location.Location;
import android.os.Bundle;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.swarm.toolkit.LocationChangeEvent;
import com.didichuxing.swarm.toolkit.LocationService;
import com.didichuxing.swarm.toolkit.OnCityChangeListener;
import com.didichuxing.swarm.toolkit.OnLocationChangeListener;
import java.util.Vector;

/* renamed from: com.didi.foundation.sdk.swarm.d */
/* compiled from: LocationServiceImpl */
final class C8396d implements LocationService {

    /* renamed from: a */
    private final Vector<OnCityChangeListener> f21349a = new Vector<>();

    /* renamed from: b */
    private final Vector<OnLocationChangeListener> f21350b = new Vector<>();

    public String getCityId() {
        return "-1";
    }

    C8396d() {
        com.didi.foundation.sdk.location.LocationService.getInstance().registerLocationListener(new LocationServiceImpl$1(this));
    }

    public Location getLocation() {
        return m15692b(com.didi.foundation.sdk.location.LocationService.getInstance().getLastKnownLocation());
    }

    public void addLocationChangeListener(OnLocationChangeListener onLocationChangeListener) {
        this.f21350b.add(onLocationChangeListener);
    }

    public void removeLocationChangeListener(OnLocationChangeListener onLocationChangeListener) {
        this.f21350b.remove(onLocationChangeListener);
    }

    public void addCityChangeListener(OnCityChangeListener onCityChangeListener) {
        this.f21349a.add(onCityChangeListener);
    }

    public void removeCityChangeListener(OnCityChangeListener onCityChangeListener) {
        this.f21349a.remove(onCityChangeListener);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15691a(DIDILocation dIDILocation) {
        if (!this.f21350b.isEmpty()) {
            LocationChangeEvent locationChangeEvent = new LocationChangeEvent(this, m15692b(dIDILocation));
            Vector<OnLocationChangeListener> vector = this.f21350b;
            for (OnLocationChangeListener onLocationChangeListener : (OnLocationChangeListener[]) vector.toArray(new OnLocationChangeListener[vector.size()])) {
                if (onLocationChangeListener != null) {
                    onLocationChangeListener.onLocationChanged(locationChangeEvent);
                }
            }
        }
    }

    /* renamed from: b */
    private Location m15692b(DIDILocation dIDILocation) {
        if (dIDILocation == null) {
            return null;
        }
        Location location = new Location(dIDILocation.getProvider());
        Bundle bundle = new Bundle();
        bundle.putString("city_id", "-1");
        location.setLatitude(dIDILocation.getLatitude());
        location.setLongitude(dIDILocation.getLongitude());
        location.setAltitude(dIDILocation.getAltitude());
        location.setAccuracy(dIDILocation.getAccuracy());
        location.setBearing(dIDILocation.getBearing());
        location.setExtras(bundle);
        location.setSpeed(dIDILocation.getSpeed());
        location.setTime(dIDILocation.getTime());
        return location;
    }
}
