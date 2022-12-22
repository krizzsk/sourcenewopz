package org.opencv.core;

import com.didichuxing.bigdata.p173dp.locsdk.Const;

public class Rect {
    public int height;
    public int width;

    /* renamed from: x */
    public int f6689x;

    /* renamed from: y */
    public int f6690y;

    public Rect(int i, int i2, int i3, int i4) {
        this.f6689x = i;
        this.f6690y = i2;
        this.width = i3;
        this.height = i4;
    }

    public Rect() {
        this(0, 0, 0, 0);
    }

    public Rect(Point point, Point point2) {
        this.f6689x = (int) (point.f6684x < point2.f6684x ? point.f6684x : point2.f6684x);
        this.f6690y = (int) (point.f6685y < point2.f6685y ? point.f6685y : point2.f6685y);
        this.width = ((int) (point.f6684x > point2.f6684x ? point.f6684x : point2.f6684x)) - this.f6689x;
        this.height = ((int) (point.f6685y > point2.f6685y ? point.f6685y : point2.f6685y)) - this.f6690y;
    }

    public Rect(Point point, Size size) {
        this((int) point.f6684x, (int) point.f6685y, (int) size.width, (int) size.height);
    }

    public Rect(double[] dArr) {
        set(dArr);
    }

    public void set(double[] dArr) {
        int i = 0;
        if (dArr != null) {
            this.f6689x = dArr.length > 0 ? (int) dArr[0] : 0;
            this.f6690y = dArr.length > 1 ? (int) dArr[1] : 0;
            this.width = dArr.length > 2 ? (int) dArr[2] : 0;
            if (dArr.length > 3) {
                i = (int) dArr[3];
            }
            this.height = i;
            return;
        }
        this.f6689x = 0;
        this.f6690y = 0;
        this.width = 0;
        this.height = 0;
    }

    public Rect clone() {
        return new Rect(this.f6689x, this.f6690y, this.width, this.height);
    }

    /* renamed from: tl */
    public Point mo36774tl() {
        return new Point((double) this.f6689x, (double) this.f6690y);
    }

    /* renamed from: br */
    public Point mo36766br() {
        return new Point((double) (this.f6689x + this.width), (double) (this.f6690y + this.height));
    }

    public Size size() {
        return new Size((double) this.width, (double) this.height);
    }

    public double area() {
        return (double) (this.width * this.height);
    }

    public boolean empty() {
        return this.width <= 0 || this.height <= 0;
    }

    public boolean contains(Point point) {
        return ((double) this.f6689x) <= point.f6684x && point.f6684x < ((double) (this.f6689x + this.width)) && ((double) this.f6690y) <= point.f6685y && point.f6685y < ((double) (this.f6690y + this.height));
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits((double) this.height);
        long doubleToLongBits2 = Double.doubleToLongBits((double) this.width);
        long doubleToLongBits3 = Double.doubleToLongBits((double) this.f6689x);
        long doubleToLongBits4 = Double.doubleToLongBits((double) this.f6690y);
        return ((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rect)) {
            return false;
        }
        Rect rect = (Rect) obj;
        if (this.f6689x == rect.f6689x && this.f6690y == rect.f6690y && this.width == rect.width && this.height == rect.height) {
            return true;
        }
        return false;
    }

    public String toString() {
        return Const.joLeft + this.f6689x + ", " + this.f6690y + ", " + this.width + "x" + this.height + "}";
    }
}
