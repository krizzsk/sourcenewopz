package com.didichuxing.swarm.toolkit;

import android.location.Location;
import java.util.EventObject;

public class LocationChangeEvent extends EventObject {
    private final Location mLocation;

    public LocationChangeEvent(LocationService locationService, Location location) {
        super(locationService);
        this.mLocation = location;
    }

    public Location getLocation() {
        return this.mLocation;
    }

    public LocationService getSource() {
        return (LocationService) super.getSource();
    }
}
