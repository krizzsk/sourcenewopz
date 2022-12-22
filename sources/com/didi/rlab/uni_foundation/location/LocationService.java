package com.didi.rlab.uni_foundation.location;

public interface LocationService {
    void checkLocationPermissions();

    double distanceBetween(double d, double d2, double d3, double d4);

    LocationResult getCurrentLocation();
}
