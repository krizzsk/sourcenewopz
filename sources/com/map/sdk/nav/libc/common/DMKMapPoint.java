package com.map.sdk.nav.libc.common;

public class DMKMapPoint {

    /* renamed from: x */
    public double f55724x;

    /* renamed from: y */
    public double f55725y;

    public double getX() {
        return this.f55724x;
    }

    public void setX(double d) {
        this.f55724x = d;
    }

    public double getY() {
        return this.f55725y;
    }

    public void setY(double d) {
        this.f55725y = d;
    }

    public DMKMapPoint() {
    }

    public DMKMapPoint(DMKMapPoint dMKMapPoint) {
        this(dMKMapPoint.f55724x, dMKMapPoint.f55725y);
    }

    public DMKMapPoint(double d, double d2) {
        this.f55724x = d;
        this.f55725y = d2;
    }

    public String toString() {
        return this.f55724x + "," + this.f55725y;
    }
}
