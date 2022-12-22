package org.opencv.core;

import com.didichuxing.bigdata.p173dp.locsdk.Const;

public class Point {

    /* renamed from: x */
    public double f6684x;

    /* renamed from: y */
    public double f6685y;

    public Point(double d, double d2) {
        this.f6684x = d;
        this.f6685y = d2;
    }

    public Point() {
        this(0.0d, 0.0d);
    }

    public Point(double[] dArr) {
        this();
        set(dArr);
    }

    public void set(double[] dArr) {
        double d = 0.0d;
        if (dArr != null) {
            this.f6684x = dArr.length > 0 ? dArr[0] : 0.0d;
            if (dArr.length > 1) {
                d = dArr[1];
            }
            this.f6685y = d;
            return;
        }
        this.f6684x = 0.0d;
        this.f6685y = 0.0d;
    }

    public Point clone() {
        return new Point(this.f6684x, this.f6685y);
    }

    public double dot(Point point) {
        return (this.f6684x * point.f6684x) + (this.f6685y * point.f6685y);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f6684x);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f6685y);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        if (this.f6684x == point.f6684x && this.f6685y == point.f6685y) {
            return true;
        }
        return false;
    }

    public boolean inside(Rect rect) {
        return rect.contains(this);
    }

    public String toString() {
        return Const.joLeft + this.f6684x + ", " + this.f6685y + "}";
    }
}
