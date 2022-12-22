package org.opencv.core;

public class RotatedRect {
    public double angle;
    public Point center;
    public Size size;

    public RotatedRect() {
        this.center = new Point();
        this.size = new Size();
        this.angle = 0.0d;
    }

    public RotatedRect(Point point, Size size2, double d) {
        this.center = point.clone();
        this.size = size2.clone();
        this.angle = d;
    }

    public RotatedRect(double[] dArr) {
        this();
        set(dArr);
    }

    public void set(double[] dArr) {
        double d = 0.0d;
        if (dArr != null) {
            this.center.f6684x = dArr.length > 0 ? dArr[0] : 0.0d;
            this.center.f6685y = dArr.length > 1 ? dArr[1] : 0.0d;
            this.size.width = dArr.length > 2 ? dArr[2] : 0.0d;
            this.size.height = dArr.length > 3 ? dArr[3] : 0.0d;
            if (dArr.length > 4) {
                d = dArr[4];
            }
            this.angle = d;
            return;
        }
        this.center.f6684x = 0.0d;
        this.center.f6684x = 0.0d;
        this.size.width = 0.0d;
        this.size.height = 0.0d;
        this.angle = 0.0d;
    }

    public void points(Point[] pointArr) {
        double d = (this.angle * 3.141592653589793d) / 180.0d;
        double cos = Math.cos(d) * 0.5d;
        double sin = Math.sin(d) * 0.5d;
        pointArr[0] = new Point((this.center.f6684x - (this.size.height * sin)) - (this.size.width * cos), (this.center.f6685y + (this.size.height * cos)) - (this.size.width * sin));
        pointArr[1] = new Point((this.center.f6684x + (this.size.height * sin)) - (this.size.width * cos), (this.center.f6685y - (cos * this.size.height)) - (sin * this.size.width));
        pointArr[2] = new Point((this.center.f6684x * 2.0d) - pointArr[0].f6684x, (this.center.f6685y * 2.0d) - pointArr[0].f6685y);
        pointArr[3] = new Point((this.center.f6684x * 2.0d) - pointArr[1].f6684x, (this.center.f6685y * 2.0d) - pointArr[1].f6685y);
    }

    public Rect boundingRect() {
        Point[] pointArr = new Point[4];
        points(pointArr);
        Rect rect = new Rect((int) Math.floor(Math.min(Math.min(Math.min(pointArr[0].f6684x, pointArr[1].f6684x), pointArr[2].f6684x), pointArr[3].f6684x)), (int) Math.floor(Math.min(Math.min(Math.min(pointArr[0].f6685y, pointArr[1].f6685y), pointArr[2].f6685y), pointArr[3].f6685y)), (int) Math.ceil(Math.max(Math.max(Math.max(pointArr[0].f6684x, pointArr[1].f6684x), pointArr[2].f6684x), pointArr[3].f6684x)), (int) Math.ceil(Math.max(Math.max(Math.max(pointArr[0].f6685y, pointArr[1].f6685y), pointArr[2].f6685y), pointArr[3].f6685y)));
        rect.width -= rect.f6689x - 1;
        rect.height -= rect.f6690y - 1;
        return rect;
    }

    public RotatedRect clone() {
        return new RotatedRect(this.center, this.size, this.angle);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.center.f6684x);
        long doubleToLongBits2 = Double.doubleToLongBits(this.center.f6685y);
        long doubleToLongBits3 = Double.doubleToLongBits(this.size.width);
        long doubleToLongBits4 = Double.doubleToLongBits(this.size.height);
        long doubleToLongBits5 = Double.doubleToLongBits(this.angle);
        return ((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RotatedRect)) {
            return false;
        }
        RotatedRect rotatedRect = (RotatedRect) obj;
        if (!this.center.equals(rotatedRect.center) || !this.size.equals(rotatedRect.size) || this.angle != rotatedRect.angle) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "{ " + this.center + " " + this.size + " * " + this.angle + " }";
    }
}
