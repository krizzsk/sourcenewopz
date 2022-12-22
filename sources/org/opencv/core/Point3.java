package org.opencv.core;

import com.didichuxing.bigdata.p173dp.locsdk.Const;

public class Point3 {

    /* renamed from: x */
    public double f6686x;

    /* renamed from: y */
    public double f6687y;

    /* renamed from: z */
    public double f6688z;

    public Point3(double d, double d2, double d3) {
        this.f6686x = d;
        this.f6687y = d2;
        this.f6688z = d3;
    }

    public Point3() {
        this(0.0d, 0.0d, 0.0d);
    }

    public Point3(Point point) {
        this.f6686x = point.f6684x;
        this.f6687y = point.f6685y;
        this.f6688z = 0.0d;
    }

    public Point3(double[] dArr) {
        this();
        set(dArr);
    }

    public void set(double[] dArr) {
        double d = 0.0d;
        if (dArr != null) {
            this.f6686x = dArr.length > 0 ? dArr[0] : 0.0d;
            this.f6687y = dArr.length > 1 ? dArr[1] : 0.0d;
            if (dArr.length > 2) {
                d = dArr[2];
            }
            this.f6688z = d;
            return;
        }
        this.f6686x = 0.0d;
        this.f6687y = 0.0d;
        this.f6688z = 0.0d;
    }

    public Point3 clone() {
        return new Point3(this.f6686x, this.f6687y, this.f6688z);
    }

    public double dot(Point3 point3) {
        return (this.f6686x * point3.f6686x) + (this.f6687y * point3.f6687y) + (this.f6688z * point3.f6688z);
    }

    public Point3 cross(Point3 point3) {
        Point3 point32 = point3;
        double d = this.f6687y;
        double d2 = point32.f6688z;
        double d3 = this.f6688z;
        double d4 = point32.f6687y;
        double d5 = point32.f6686x;
        double d6 = (d * d2) - (d3 * d4);
        double d7 = this.f6686x;
        double d8 = (d7 * d4) - (d * d5);
        return new Point3(d6, (d3 * d5) - (d2 * d7), d8);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f6686x);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f6687y);
        long doubleToLongBits3 = Double.doubleToLongBits(this.f6688z);
        return ((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point3)) {
            return false;
        }
        Point3 point3 = (Point3) obj;
        if (this.f6686x == point3.f6686x && this.f6687y == point3.f6687y && this.f6688z == point3.f6688z) {
            return true;
        }
        return false;
    }

    public String toString() {
        return Const.joLeft + this.f6686x + ", " + this.f6687y + ", " + this.f6688z + "}";
    }
}
