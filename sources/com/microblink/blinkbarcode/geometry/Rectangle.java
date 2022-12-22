package com.microblink.blinkbarcode.geometry;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.microblink.blinkbarcode.util.Log;

/* compiled from: line */
public class Rectangle implements Parcelable {
    public static final Parcelable.Creator<Rectangle> CREATOR = new llIIlIlIIl();
    private float IlIllIlIIl;
    private float IllIIIllII;
    private float llIIIlllll;
    private float llIIlIlIIl;

    /* compiled from: line */
    public static class llIIlIlIIl implements Parcelable.Creator<Rectangle> {
        public Object createFromParcel(Parcel parcel) {
            return new Rectangle(parcel, (llIIlIlIIl) null);
        }

        public Object[] newArray(int i) {
            return new Rectangle[i];
        }
    }

    public /* synthetic */ Rectangle(Parcel parcel, llIIlIlIIl lliililiil) {
        this(parcel);
    }

    public static Rectangle getDefaultROI() {
        return new Rectangle(0.0f, 0.0f, 1.0f, 1.0f);
    }

    private boolean llIIlIlIIl(float f) {
        return f >= 0.0f && f <= 1.0f;
    }

    public int describeContents() {
        return 0;
    }

    public float getHeight() {
        return this.llIIIlllll;
    }

    public float getWidth() {
        return this.IllIIIllII;
    }

    public float getX() {
        return this.llIIlIlIIl;
    }

    public float getY() {
        return this.IlIllIlIIl;
    }

    public boolean isRelative() {
        return llIIlIlIIl(this.llIIlIlIIl) && llIIlIlIIl(this.IlIllIlIIl) && llIIlIlIIl(this.IllIIIllII) && llIIlIlIIl(this.llIIIlllll) && this.llIIlIlIIl + this.IllIIIllII <= 1.0f && this.IlIllIlIIl + this.llIIIlllll <= 1.0f;
    }

    public void log() {
        Log.m40227d(this, "Rectangle[{}, {}, {}, {}]", Float.valueOf(this.llIIlIlIIl), Float.valueOf(this.IlIllIlIIl), Float.valueOf(this.IllIIIllII), Float.valueOf(this.llIIIlllll));
    }

    public void normalizeToUnitRectangle() {
        if (this.llIIlIlIIl < 0.0f) {
            this.llIIlIlIIl = 0.0f;
        }
        if (this.IlIllIlIIl < 0.0f) {
            this.IlIllIlIIl = 0.0f;
        }
        if (this.IllIIIllII > 1.0f) {
            this.IllIIIllII = 1.0f;
        }
        if (this.llIIIlllll > 1.0f) {
            this.llIIIlllll = 1.0f;
        }
    }

    public RectF toRectF() {
        float f = this.llIIlIlIIl;
        float f2 = this.IlIllIlIIl;
        return new RectF(f, f2, this.IllIIIllII + f, this.llIIIlllll + f2);
    }

    public String toString() {
        return "Rectangle[" + this.llIIlIlIIl + ", " + this.IlIllIlIIl + ", " + this.IllIIIllII + ", " + this.llIIIlllll + Const.jaRight;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.llIIlIlIIl);
        parcel.writeFloat(this.IlIllIlIIl);
        parcel.writeFloat(this.IllIIIllII);
        parcel.writeFloat(this.llIIIlllll);
    }

    public Rectangle(float f, float f2, float f3, float f4) {
        this.llIIlIlIIl = f;
        this.IlIllIlIIl = f2;
        this.IllIIIllII = f3;
        this.llIIIlllll = f4;
    }

    private Rectangle(Parcel parcel) {
        this.llIIlIlIIl = parcel.readFloat();
        this.IlIllIlIIl = parcel.readFloat();
        this.IllIIIllII = parcel.readFloat();
        this.llIIIlllll = parcel.readFloat();
    }
}
