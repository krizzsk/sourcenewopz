package org.opencv.core;

import com.didichuxing.bigdata.p173dp.locsdk.Const;

public class Rect2d {
    public double height;
    public double width;

    /* renamed from: x */
    public double f6691x;

    /* renamed from: y */
    public double f6692y;

    public Rect2d(double d, double d2, double d3, double d4) {
        this.f6691x = d;
        this.f6692y = d2;
        this.width = d3;
        this.height = d4;
    }

    public Rect2d() {
        this(0.0d, 0.0d, 0.0d, 0.0d);
    }

    public Rect2d(Point point, Point point2) {
        this.f6691x = point.f6684x < point2.f6684x ? point.f6684x : point2.f6684x;
        this.f6692y = point.f6685y < point2.f6685y ? point.f6685y : point2.f6685y;
        this.width = (point.f6684x > point2.f6684x ? point.f6684x : point2.f6684x) - this.f6691x;
        this.height = (point.f6685y > point2.f6685y ? point.f6685y : point2.f6685y) - this.f6692y;
    }

    public Rect2d(Point point, Size size) {
        this(point.f6684x, point.f6685y, size.width, size.height);
    }

    public Rect2d(double[] dArr) {
        set(dArr);
    }

    public void set(double[] dArr) {
        double d = 0.0d;
        if (dArr != null) {
            this.f6691x = dArr.length > 0 ? dArr[0] : 0.0d;
            this.f6692y = dArr.length > 1 ? dArr[1] : 0.0d;
            this.width = dArr.length > 2 ? dArr[2] : 0.0d;
            if (dArr.length > 3) {
                d = dArr[3];
            }
            this.height = d;
            return;
        }
        this.f6691x = 0.0d;
        this.f6692y = 0.0d;
        this.width = 0.0d;
        this.height = 0.0d;
    }

    public Rect2d clone() {
        return new Rect2d(this.f6691x, this.f6692y, this.width, this.height);
    }

    /* renamed from: tl */
    public Point mo36785tl() {
        return new Point(this.f6691x, this.f6692y);
    }

    /* renamed from: br */
    public Point mo36777br() {
        return new Point(this.f6691x + this.width, this.f6692y + this.height);
    }

    public Size size() {
        return new Size(this.width, this.height);
    }

    public double area() {
        return this.width * this.height;
    }

    public boolean empty() {
        return this.width <= 0.0d || this.height <= 0.0d;
    }

    public boolean contains(Point point) {
        return this.f6691x <= point.f6684x && point.f6684x < this.f6691x + this.width && this.f6692y <= point.f6685y && point.f6685y < this.f6692y + this.height;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.height);
        long doubleToLongBits2 = Double.doubleToLongBits(this.width);
        long doubleToLongBits3 = Double.doubleToLongBits(this.f6691x);
        long doubleToLongBits4 = Double.doubleToLongBits(this.f6692y);
        return ((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rect2d)) {
            return false;
        }
        Rect2d rect2d = (Rect2d) obj;
        if (this.f6691x == rect2d.f6691x && this.f6692y == rect2d.f6692y && this.width == rect2d.width && this.height == rect2d.height) {
            return true;
        }
        return false;
    }

    public String toString() {
        return Const.joLeft + this.f6691x + ", " + this.f6692y + ", " + this.width + "x" + this.height + "}";
    }
}
