package com.microblink.blinkbarcode.geometry;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkbarcode.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: line */
public class PointSet implements Parcelable {
    public static final Parcelable.Creator<PointSet> CREATOR = new llIIlIlIIl();
    private ArrayList<Point> llIIlIlIIl = null;

    /* compiled from: line */
    public static class llIIlIlIIl implements Parcelable.Creator<PointSet> {
        public Object createFromParcel(Parcel parcel) {
            return new PointSet(parcel);
        }

        public Object[] newArray(int i) {
            return new PointSet[i];
        }
    }

    public PointSet(List<Point> list) {
        if (list instanceof ArrayList) {
            this.llIIlIlIIl = (ArrayList) list;
            return;
        }
        ArrayList<Point> arrayList = new ArrayList<>(list.size());
        this.llIIlIlIIl = arrayList;
        arrayList.addAll(list);
    }

    public int describeContents() {
        return 0;
    }

    public void draw(Canvas canvas, Paint paint, int i) {
        ArrayList<Point> arrayList = this.llIIlIlIIl;
        if (arrayList != null) {
            Iterator<Point> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().draw(canvas, paint, i);
            }
        }
    }

    public List<Point> getPoints() {
        return this.llIIlIlIIl;
    }

    public float[] toFloatArray() {
        float[] fArr = new float[(this.llIIlIlIIl.size() * 2)];
        for (int i = 0; i < this.llIIlIlIIl.size(); i++) {
            int i2 = i * 2;
            fArr[i2] = this.llIIlIlIIl.get(i).getX();
            fArr[i2 + 1] = this.llIIlIlIIl.get(i).getY();
        }
        return fArr;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.llIIlIlIIl);
    }

    public PointSet(float[] fArr) {
        this.llIIlIlIIl = new ArrayList<>(fArr.length / 2);
        for (int i = 0; i < fArr.length - 1; i += 2) {
            this.llIIlIlIIl.add(new Point(fArr[i], fArr[i + 1]));
        }
    }

    public PointSet(float[] fArr, int i, int i2, int i3, boolean z) {
        Log.m40227d(this, "Point set length: {}", Integer.valueOf(fArr.length));
        this.llIIlIlIIl = new ArrayList<>(fArr.length / 2);
        for (int i4 = 0; i4 < fArr.length - 1; i4 += 2) {
            Point mirrorXY = (i3 == 8 || i3 == 9) ? new Point(fArr[i4], fArr[i4 + 1]).mirrorXY(1.0f, 1.0f) : mirrorXY;
            mirrorXY = z ? mirrorXY.mirrorXY(1.0f, 1.0f) : mirrorXY;
            if (i3 == 1 || i3 == 9) {
                this.llIIlIlIIl.add(new Point((1.0f - mirrorXY.getY()) * ((float) i), mirrorXY.getX() * ((float) i2)));
            } else {
                this.llIIlIlIIl.add(new Point(mirrorXY.getX() * ((float) i), mirrorXY.getY() * ((float) i2)));
            }
        }
    }

    public PointSet(Parcel parcel) {
        this.llIIlIlIIl = parcel.createTypedArrayList(Point.CREATOR);
    }
}
