package com.didichuxing.swarm.toolkit;

import android.location.Location;

public interface LocationService {
    void addCityChangeListener(OnCityChangeListener onCityChangeListener);

    void addLocationChangeListener(OnLocationChangeListener onLocationChangeListener);

    String getCityId();

    Location getLocation();

    void removeCityChangeListener(OnCityChangeListener onCityChangeListener);

    void removeLocationChangeListener(OnLocationChangeListener onLocationChangeListener);
}
