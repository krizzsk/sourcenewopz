package com.microblink.blinkbarcode.geometry;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkbarcode.util.Log;

/* compiled from: line */
public class Quadrilateral implements Parcelable {
    public static final Parcelable.Creator<Quadrilateral> CREATOR = new llIIlIlIIl();
    private Point IlIllIlIIl;
    private int IllIIIIllI;
    private Point IllIIIllII;
    private boolean lIlIIIIlIl;
    private Point llIIIlllll;
    private Point llIIlIlIIl;

    /* compiled from: line */
    public static class llIIlIlIIl implements Parcelable.Creator<Quadrilateral> {
        public Object createFromParcel(Parcel parcel) {
            return new Quadrilateral(parcel);
        }

        public Object[] newArray(int i) {
            return new Quadrilateral[i];
        }
    }

    public Quadrilateral(int i, int i2, int i3, int i4, int i5) {
        this.IllIIIIllI = -1;
        this.lIlIIIIlIl = false;
        setMargins(i, i2, i3, i4, i5);
    }

    public int describeContents() {
        return 0;
    }

    public int getColor() {
        return this.IllIIIIllI;
    }

    public Point getLowerLeft() {
        return this.IllIIIllII;
    }

    public Point getLowerRight() {
        return this.llIIIlllll;
    }

    public Quadrilateral getSortedQuad() {
        Point point = this.llIIlIlIIl;
        Point[] pointArr = {point, this.IlIllIlIIl, this.IllIIIllII, this.llIIIlllll};
        Point[] pointArr2 = new Point[4];
        Point point2 = new Point((((point.getX() + this.IlIllIlIIl.getX()) + this.IllIIIllII.getX()) + this.llIIIlllll.getX()) / 4.0f, (((this.llIIlIlIIl.getY() + this.IlIllIlIIl.getY()) + this.IllIIIllII.getY()) + this.llIIIlllll.getY()) / 4.0f);
        double[] dArr = new double[4];
        int[] iArr = new int[4];
        int i = 0;
        while (i < 4) {
            Point point3 = pointArr[i];
            dArr[i] = Math.atan2((double) (point3.getY() - point2.getY()), (double) (point3.getX() - point2.getX()));
            iArr[i] = i;
            i++;
            point2 = point2;
        }
        int i2 = 0;
        while (i2 < 4) {
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < 4; i4++) {
                if (dArr[i2] > dArr[i4]) {
                    double d = dArr[i2];
                    dArr[i2] = dArr[i4];
                    dArr[i4] = d;
                    int i5 = iArr[i2];
                    iArr[i2] = iArr[i4];
                    iArr[i4] = i5;
                }
            }
            i2 = i3;
        }
        float f = Float.MAX_VALUE;
        int i6 = 0;
        for (int i7 = 0; i7 < 4; i7++) {
            float norm = pointArr[iArr[i7]].norm();
            if (norm < f) {
                i6 = i7;
                f = norm;
            }
        }
        pointArr2[0] = pointArr[iArr[(i6 + 0) % 4]];
        pointArr2[1] = pointArr[iArr[(i6 + 3) % 4]];
        pointArr2[2] = pointArr[iArr[(i6 + 1) % 4]];
        pointArr2[3] = pointArr[iArr[(i6 + 2) % 4]];
        return new Quadrilateral(pointArr2[0], pointArr2[1], pointArr2[2], pointArr2[3]);
    }

    public Point getUpperLeft() {
        return this.llIIlIlIIl;
    }

    public Point getUpperRight() {
        return this.IlIllIlIIl;
    }

    public boolean isDefaultQuad() {
        return this.lIlIIIIlIl;
    }

    public boolean isEmpty() {
        return this.llIIlIlIIl.isZero() && this.IlIllIlIIl.isZero() && this.IllIIIllII.isZero() && this.llIIIlllll.isZero();
    }

    public boolean matchesMargins(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 1 || i5 == 9) {
            float f = (float) i4;
            if (this.llIIlIlIIl.getX() != f) {
                return false;
            }
            float f2 = (float) i;
            if (this.llIIlIlIIl.getY() != f2) {
                return false;
            }
            float f3 = (float) i3;
            if (this.IlIllIlIIl.getX() != f3 || this.IlIllIlIIl.getY() != f2 || this.IllIIIllII.getX() != f) {
                return false;
            }
            float f4 = (float) i2;
            if (this.IllIIIllII.getY() == f4 && this.llIIIlllll.getX() == f3 && this.llIIIlllll.getY() == f4) {
                return true;
            }
            return false;
        }
        float f5 = (float) i3;
        if (this.llIIlIlIIl.getX() != f5) {
            return false;
        }
        float f6 = (float) i;
        if (this.llIIlIlIIl.getY() != f6 || this.IlIllIlIIl.getX() != f5) {
            return false;
        }
        float f7 = (float) i2;
        if (this.IlIllIlIIl.getY() != f7) {
            return false;
        }
        float f8 = (float) i4;
        if (this.IllIIIllII.getX() == f8 && this.IllIIIllII.getY() == f6 && this.llIIIlllll.getX() == f8 && this.llIIIlllll.getY() == f7) {
            return true;
        }
        return false;
    }

    public void mirror(int i, int i2, int i3) {
        Point point;
        Point point2;
        Point point3;
        Point point4;
        boolean z = true;
        if (!(i3 == 1 || i3 == 9)) {
            z = false;
        }
        if (z) {
            float f = (float) i2;
            point3 = this.llIIlIlIIl.mirrorY(f);
            point = this.IlIllIlIIl.mirrorY(f);
            point4 = this.IllIIIllII.mirrorY(f);
            point2 = this.llIIIlllll.mirrorY(f);
        } else {
            float f2 = (float) i;
            point4 = this.IlIllIlIIl.mirrorX(f2);
            Point mirrorX = this.llIIIlllll.mirrorX(f2);
            Point mirrorX2 = this.llIIlIlIIl.mirrorX(f2);
            point = this.IllIIIllII.mirrorX(f2);
            point3 = mirrorX;
            point2 = mirrorX2;
        }
        this.llIIlIlIIl = point4;
        this.IlIllIlIIl = point2;
        this.IllIIIllII = point3;
        this.llIIIlllll = point;
    }

    public void setColor(int i) {
        this.IllIIIIllI = i;
    }

    public void setIsDefaultQuad(boolean z) {
        this.lIlIIIIlIl = z;
    }

    public void setPoints(Point point, Point point2, Point point3, Point point4) {
        this.llIIlIlIIl = point;
        this.IlIllIlIIl = point2;
        this.IllIIIllII = point3;
        this.llIIIlllll = point4;
    }

    public void toFloatArray(float[] fArr) {
        fArr[0] = this.llIIlIlIIl.getX();
        fArr[1] = this.llIIlIlIIl.getY();
        fArr[2] = this.IlIllIlIIl.getX();
        fArr[3] = this.IlIllIlIIl.getY();
        fArr[4] = this.llIIIlllll.getX();
        fArr[5] = this.llIIIlllll.getY();
        fArr[6] = this.IllIIIllII.getX();
        fArr[7] = this.IllIIIllII.getY();
    }

    public String toString() {
        return "Quadrilateral{mUpperLeft=" + this.llIIlIlIIl + ", mUpperRight=" + this.IlIllIlIIl + ", mLowerLeft=" + this.IllIIIllII + ", mLowerRight=" + this.llIIIlllll + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.llIIlIlIIl, 0);
        parcel.writeParcelable(this.IlIllIlIIl, 0);
        parcel.writeParcelable(this.IllIIIllII, 0);
        parcel.writeParcelable(this.llIIIlllll, 0);
        parcel.writeInt(this.IllIIIIllI);
        parcel.writeByte(this.lIlIIIIlIl ? (byte) 1 : 0);
    }

    public Quadrilateral clone() {
        Quadrilateral quadrilateral = new Quadrilateral(this.llIIlIlIIl, this.IlIllIlIIl, this.IllIIIllII, this.llIIIlllll);
        quadrilateral.setIsDefaultQuad(this.lIlIIIIlIl);
        quadrilateral.setColor(this.IllIIIIllI);
        return quadrilateral;
    }

    public void setMargins(int i, int i2, int i3, int i4, int i5) {
        Log.m40233v(this, "Setting margins: top={}, bottom={}, left={}, right={}", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (i5 == 1 || i5 == 9) {
            float f = (float) i4;
            float f2 = (float) i;
            this.llIIlIlIIl = new Point(f, f2);
            float f3 = (float) i3;
            this.IlIllIlIIl = new Point(f3, f2);
            float f4 = (float) i2;
            this.IllIIIllII = new Point(f, f4);
            this.llIIIlllll = new Point(f3, f4);
            return;
        }
        float f5 = (float) i3;
        float f6 = (float) i;
        this.llIIlIlIIl = new Point(f5, f6);
        float f7 = (float) i2;
        this.IlIllIlIIl = new Point(f5, f7);
        float f8 = (float) i4;
        this.IllIIIllII = new Point(f8, f6);
        this.llIIIlllll = new Point(f8, f7);
    }

    public Quadrilateral() {
        this.IllIIIIllI = -1;
        this.lIlIIIIlIl = false;
        setMargins(100, 100, 200, 200, 1);
    }

    public Quadrilateral(Point point, Point point2, Point point3, Point point4) {
        this.IllIIIIllI = -1;
        this.lIlIIIIlIl = false;
        setPoints(point, point2, point3, point4);
    }

    public Quadrilateral(float[] fArr) {
        this.IllIIIIllI = -1;
        this.lIlIIIIlIl = false;
        setPoints(new Point(fArr[0], fArr[1]), new Point(fArr[2], fArr[3]), new Point(fArr[6], fArr[7]), new Point(fArr[4], fArr[5]));
    }

    public Quadrilateral(Parcel parcel) {
        this.IllIIIIllI = -1;
        boolean z = false;
        this.lIlIIIIlIl = false;
        this.llIIlIlIIl = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.IlIllIlIIl = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.IllIIIllII = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.llIIIlllll = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.IllIIIIllI = parcel.readInt();
        this.lIlIIIIlIl = parcel.readByte() != 0 ? true : z;
    }
}
