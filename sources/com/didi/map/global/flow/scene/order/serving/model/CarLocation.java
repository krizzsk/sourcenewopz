package com.didi.map.global.flow.scene.order.serving.model;

public class CarLocation {
    public int angle;
    public double latitude;
    public double longitude;
    public long timestamp;

    public CarLocation() {
    }

    public CarLocation(CarLocation carLocation) {
        this.latitude = carLocation.latitude;
        this.longitude = carLocation.longitude;
        this.angle = carLocation.angle;
        this.timestamp = carLocation.timestamp;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CarLocation)) {
            return false;
        }
        CarLocation carLocation = (CarLocation) obj;
        return Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(carLocation.latitude) && Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(carLocation.longitude) && this.angle == carLocation.angle && this.timestamp == carLocation.timestamp;
    }
}
