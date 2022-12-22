package com.microblink.blinkbarcode.results.date;

import android.os.Parcel;
import android.os.Parcelable;
import com.microblink.blinkbarcode.results.Result;

/* compiled from: line */
public class DateResult implements Parcelable, Result {
    public static final Parcelable.Creator<DateResult> CREATOR = new Parcelable.Creator<DateResult>() {
        public DateResult createFromParcel(Parcel parcel) {
            return new DateResult(parcel);
        }

        public DateResult[] newArray(int i) {
            return new DateResult[i];
        }
    };
    private String IlIllIlIIl;
    private Date llIIlIlIIl;

    public static DateResult createFromDMY(int i, int i2, int i3, String str) {
        return new DateResult(new Date(i, i2, i3), str);
    }

    public static DateResult createUnparsed(String str) {
        return new DateResult((Date) null, str);
    }

    private void llIIlIlIIl(Parcel parcel) {
        if (parcel.readByte() == 1) {
            this.llIIlIlIIl = new Date(parcel.readInt(), parcel.readInt(), parcel.readInt());
        } else {
            this.llIIlIlIIl = null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public Date getDate() {
        return this.llIIlIlIIl;
    }

    public Object getNativeResult() {
        return getDate();
    }

    public String getOriginalDateString() {
        return this.IlIllIlIIl;
    }

    public String getStringResult() {
        return getOriginalDateString();
    }

    public String toString() {
        String str;
        Object[] objArr = new Object[2];
        Date date = this.llIIlIlIIl;
        if (date == null) {
            str = "null";
        } else {
            str = date.toString();
        }
        objArr[0] = str;
        objArr[1] = this.IlIllIlIIl;
        return String.format("Date: %s, original string: %s", objArr);
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.llIIlIlIIl != null) {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.llIIlIlIIl.getDay());
            parcel.writeInt(this.llIIlIlIIl.getMonth());
            parcel.writeInt(this.llIIlIlIIl.getYear());
        } else {
            parcel.writeByte((byte) 0);
        }
        parcel.writeString(this.IlIllIlIIl);
    }

    private DateResult(Date date, String str) {
        this.llIIlIlIIl = date;
        this.IlIllIlIIl = str;
    }

    private DateResult(Parcel parcel) {
        llIIlIlIIl(parcel);
        this.IlIllIlIIl = parcel.readString();
    }
}
