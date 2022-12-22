package com.map.global.nav.libc.common;

public class DMKGPSPoint {
    public int errorCode;
    public float heading;
    public int locationAccuracy;
    public DMKMapPoint mapPoint = new DMKMapPoint();
    public int projectDistance;
    public int segmentIndex;
    public int segmentOffset;
    public int source;
    public long timestamp;
    public float velocity;

    public String toString() {
        return "segmentIndex:" + this.segmentIndex + ",pt(" + this.mapPoint.toString() + "),heading:" + this.heading + ",timestamp:" + this.timestamp + ",velocity:" + this.velocity + ",source:" + this.source + ",accuracy:" + this.locationAccuracy + ",projectDistance:" + this.projectDistance + ",segmentOffset:" + this.segmentOffset + ", DMKMatchErrorCode" + this.errorCode;
    }

    public DMKGPSPoint copy() {
        DMKGPSPoint dMKGPSPoint = new DMKGPSPoint();
        dMKGPSPoint.mapPoint = new DMKMapPoint(this.mapPoint);
        dMKGPSPoint.velocity = this.velocity;
        dMKGPSPoint.timestamp = this.timestamp;
        dMKGPSPoint.source = this.source;
        dMKGPSPoint.segmentOffset = this.segmentOffset;
        dMKGPSPoint.segmentIndex = this.segmentIndex;
        dMKGPSPoint.heading = this.heading;
        dMKGPSPoint.projectDistance = this.projectDistance;
        dMKGPSPoint.locationAccuracy = this.locationAccuracy;
        dMKGPSPoint.errorCode = this.errorCode;
        return dMKGPSPoint;
    }
}
