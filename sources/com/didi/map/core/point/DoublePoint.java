package com.didi.map.core.point;

public class DoublePoint {

    /* renamed from: x */
    public double f24753x;

    /* renamed from: y */
    public double f24754y;

    public DoublePoint() {
    }

    public DoublePoint(double d, double d2) {
        this.f24753x = d;
        this.f24754y = d2;
    }

    public void set(double d, double d2) {
        this.f24753x = d;
        this.f24754y = d2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DoublePoint)) {
            return false;
        }
        DoublePoint doublePoint = (DoublePoint) obj;
        if (this.f24753x == doublePoint.f24753x && this.f24754y == doublePoint.f24754y) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.f24753x + "," + this.f24754y;
    }

    public double distanceTo(DoublePoint doublePoint) {
        double d = this.f24753x;
        double d2 = doublePoint.f24753x;
        double d3 = (d - d2) * (d - d2);
        double d4 = this.f24754y;
        double d5 = doublePoint.f24754y;
        return Math.sqrt(d3 + ((d4 - d5) * (d4 - d5)));
    }
}
