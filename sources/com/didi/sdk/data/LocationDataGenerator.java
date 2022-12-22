package com.didi.sdk.data;

@Deprecated
public abstract class LocationDataGenerator implements DataGenerator {
    public static final String NAME = "FRAMEWORK_LOCATION";

    public abstract String getCityID();

    public String getGeneratorName() {
        return "FRAMEWORK_LOCATION";
    }

    public abstract double getLat();

    public abstract double getLng();

    public abstract String getMapType();

    public abstract double getUserLat();

    public abstract double getUserLng();
}
