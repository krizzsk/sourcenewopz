package com.microblink.blinkbarcode.geometry;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkbarcode.util.Log;

/* compiled from: line */
public class Point implements Parcelable {
    public static final Parcelable.Creator<Point> CREATOR = new llIIlIlIIl();
    private float IlIllIlIIl;
    private float IllIIIllII;
    private float llIIlIlIIl;

    /* compiled from: line */
    public static class llIIlIlIIl implements Parcelable.Creator<Point> {
        public Object createFromParcel(Parcel parcel) {
            return new Point(parcel);
        }

        public Object[] newArray(int i) {
            return new Point[i];
        }
    }

    public Point() {
        this.IllIIIllII = -1.0f;
        this.llIIlIlIIl = 0.0f;
        this.IlIllIlIIl = 0.0f;
    }

    public Point clamp(float f) {
        if (norm() > f) {
            return normalize(f);
        }
        return new Point(this.llIIlIlIIl, this.IlIllIlIIl);
    }

    public int describeContents() {
        return 0;
    }

    public float distance(Point point) {
        float f = this.llIIlIlIIl - point.llIIlIlIIl;
        float f2 = this.IlIllIlIIl - point.IlIllIlIIl;
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
    }

    public void draw(Canvas canvas, Paint paint, int i) {
        canvas.drawCircle(this.llIIlIlIIl, this.IlIllIlIIl, (float) i, paint);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        if (this.llIIlIlIIl == point.llIIlIlIIl && this.IlIllIlIIl == point.IlIllIlIIl) {
            return true;
        }
        return false;
    }

    public float getX() {
        return this.llIIlIlIIl;
    }

    public float getY() {
        return this.IlIllIlIIl;
    }

    public boolean isZero() {
        return this.llIIlIlIIl == 0.0f && this.IlIllIlIIl == 0.0f;
    }

    public void log() {
        Log.m40227d(this, String.format("(%f,%f)", new Object[]{Float.valueOf(this.llIIlIlIIl), Float.valueOf(this.IlIllIlIIl)}), new Object[0]);
    }

    public Point makeCopy() {
        return new Point(this.llIIlIlIIl, this.IlIllIlIIl);
    }

    public Point mirrorX(float f) {
        Point makeCopy = makeCopy();
        makeCopy.mirrorXInPlace(f);
        return makeCopy;
    }

    public void mirrorXInPlace(float f) {
        this.llIIlIlIIl = f - this.llIIlIlIIl;
    }

    public Point mirrorXY(float f, float f2) {
        Point makeCopy = makeCopy();
        makeCopy.mirrorXYInPlace(f, f2);
        return makeCopy;
    }

    public void mirrorXYInPlace(float f, float f2) {
        this.llIIlIlIIl = f - this.llIIlIlIIl;
        this.IlIllIlIIl = f2 - this.IlIllIlIIl;
    }

    public Point mirrorY(float f) {
        Point makeCopy = makeCopy();
        makeCopy.mirrorYInPlace(f);
        return makeCopy;
    }

    public void mirrorYInPlace(float f) {
        this.IlIllIlIIl = f - this.IlIllIlIIl;
    }

    public Point negative() {
        this.llIIlIlIIl = -this.llIIlIlIIl;
        this.IlIllIlIIl = -this.IlIllIlIIl;
        return this;
    }

    public Point negativeClone() {
        return new Point(-this.llIIlIlIIl, -this.IlIllIlIIl);
    }

    public float norm() {
        if (this.IllIIIllII < 0.0f) {
            float f = this.llIIlIlIIl;
            float f2 = this.IlIllIlIIl;
            this.IllIIIllII = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
        }
        return this.IllIIIllII;
    }

    public Point normalize() {
        float norm = norm();
        return new Point(this.llIIlIlIIl / norm, this.IlIllIlIIl / norm);
    }

    public Point operatorMinus(Point point) {
        return new Point(this.llIIlIlIIl - point.llIIlIlIIl, this.IlIllIlIIl - point.IlIllIlIIl);
    }

    public Point operatorMinusEquals(Point point) {
        this.llIIlIlIIl -= point.llIIlIlIIl;
        this.IlIllIlIIl -= point.IlIllIlIIl;
        return this;
    }

    public Point operatorMultiply(float f) {
        return new Point(this.llIIlIlIIl * f, this.IlIllIlIIl * f);
    }

    public Point operatorMultiplyEquals(float f) {
        this.llIIlIlIIl *= f;
        this.IlIllIlIIl *= f;
        return this;
    }

    public Point operatorPlus(Point point) {
        return new Point(this.llIIlIlIIl + point.llIIlIlIIl, this.IlIllIlIIl + point.IlIllIlIIl);
    }

    public void operatorPlusEquals(Point point) {
        this.llIIlIlIIl += point.llIIlIlIIl;
        this.IlIllIlIIl += point.IlIllIlIIl;
    }

    public void setX(float f) {
        this.llIIlIlIIl = f;
    }

    public void setY(float f) {
        this.IlIllIlIIl = f;
    }

    public String toString() {
        return "Point{mX=" + this.llIIlIlIIl + ", mY=" + this.IlIllIlIIl + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.llIIlIlIIl);
        parcel.writeFloat(this.IlIllIlIIl);
        parcel.writeFloat(this.IllIIIllII);
    }

    public Point normalize(float f) {
        float norm = norm();
        return new Point((this.llIIlIlIIl * f) / norm, (this.IlIllIlIIl * f) / norm);
    }

    public Point clamp(float f, float f2) {
        float norm = norm();
        if (norm > f2) {
            return normalize(f2);
        }
        if (norm < f) {
            return normalize(f);
        }
        return new Point(this.llIIlIlIIl, this.IlIllIlIIl);
    }

    public Point(float f, float f2) {
        this.IllIIIllII = -1.0f;
        this.llIIlIlIIl = f;
        this.IlIllIlIIl = f2;
    }

    public Point(Parcel parcel) {
        this.IllIIIllII = -1.0f;
        this.llIIlIlIIl = parcel.readFloat();
        this.IlIllIlIIl = parcel.readFloat();
        this.IllIIIllII = parcel.readFloat();
    }
}
