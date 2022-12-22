package com.didichuxing.swarm.toolkit;

import java.util.EventObject;

public class CityChangeEvent extends EventObject {
    private final String mNewCityId;
    private final String mOldCityId;

    public CityChangeEvent(LocationService locationService, String str, String str2) {
        super(locationService);
        this.mOldCityId = str;
        this.mNewCityId = str2;
    }

    public String getOldCityId() {
        return this.mOldCityId;
    }

    public String getNewCityId() {
        return this.mNewCityId;
    }

    public LocationService getSource() {
        return (LocationService) super.getSource();
    }
}
