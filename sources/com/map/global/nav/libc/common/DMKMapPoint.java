package com.map.global.nav.libc.common;

public class DMKMapPoint {

    /* renamed from: x */
    public double f55702x;

    /* renamed from: y */
    public double f55703y;

    public double getX() {
        return this.f55702x;
    }

    public void setX(double d) {
        this.f55702x = d;
    }

    public double getY() {
        return this.f55703y;
    }

    public void setY(double d) {
        this.f55703y = d;
    }

    public DMKMapPoint() {
    }

    public DMKMapPoint(DMKMapPoint dMKMapPoint) {
        this(dMKMapPoint.f55702x, dMKMapPoint.f55703y);
    }

    public DMKMapPoint(double d, double d2) {
        this.f55702x = d;
        this.f55703y = d2;
    }

    public String toString() {
        return this.f55702x + "," + this.f55703y;
    }
}
