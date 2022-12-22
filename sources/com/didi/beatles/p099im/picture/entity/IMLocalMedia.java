package com.didi.beatles.p099im.picture.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* renamed from: com.didi.beatles.im.picture.entity.IMLocalMedia */
public class IMLocalMedia implements Parcelable {
    public static final Parcelable.Creator<IMLocalMedia> CREATOR = new Parcelable.Creator<IMLocalMedia>() {
        public IMLocalMedia createFromParcel(Parcel parcel) {
            return new IMLocalMedia(parcel);
        }

        public IMLocalMedia[] newArray(int i) {
            return new IMLocalMedia[i];
        }
    };

    /* renamed from: a */
    private String f9383a;

    /* renamed from: b */
    private String f9384b;

    /* renamed from: c */
    private String f9385c;

    /* renamed from: d */
    private long f9386d;

    /* renamed from: e */
    private boolean f9387e;

    /* renamed from: f */
    private boolean f9388f;

    /* renamed from: g */
    private int f9389g;

    /* renamed from: h */
    private int f9390h;

    /* renamed from: i */
    private String f9391i;

    /* renamed from: j */
    private boolean f9392j;

    /* renamed from: k */
    private int f9393k;

    /* renamed from: l */
    private int f9394l;

    /* renamed from: m */
    private long f9395m;
    public int position;

    public int describeContents() {
        return 0;
    }

    public IMLocalMedia() {
    }

    public IMLocalMedia(String str, long j, int i, String str2) {
        this.f9383a = str;
        this.f9386d = j;
        this.f9390h = i;
        this.f9391i = str2;
    }

    public IMLocalMedia(String str, long j, int i, String str2, int i2, int i3, int i4) {
        this.f9383a = str;
        this.f9386d = j;
        this.f9390h = i;
        this.f9391i = str2;
        this.f9393k = i2;
        this.f9394l = i3;
        this.f9395m = (long) i4;
    }

    public IMLocalMedia(String str, long j, boolean z, int i, int i2, int i3) {
        this.f9383a = str;
        this.f9386d = j;
        this.f9387e = z;
        this.position = i;
        this.f9389g = i2;
        this.f9390h = i3;
    }

    public String getPictureType() {
        if (TextUtils.isEmpty(this.f9391i)) {
            this.f9391i = "image/jpeg";
        }
        return this.f9391i;
    }

    public void setPictureType(String str) {
        this.f9391i = str;
    }

    public String getPath() {
        return this.f9383a;
    }

    public void setPath(String str) {
        this.f9383a = str;
    }

    public String getCompressPath() {
        return this.f9384b;
    }

    public void setCompressPath(String str) {
        this.f9384b = str;
    }

    public String getCutPath() {
        return this.f9385c;
    }

    public void setCutPath(String str) {
        this.f9385c = str;
    }

    public long getDuration() {
        return this.f9386d;
    }

    public void setDuration(long j) {
        this.f9386d = j;
    }

    public boolean isChecked() {
        return this.f9387e;
    }

    public void setChecked(boolean z) {
        this.f9387e = z;
    }

    public boolean isCut() {
        return this.f9388f;
    }

    public void setCut(boolean z) {
        this.f9388f = z;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public int getNum() {
        return this.f9389g;
    }

    public void setNum(int i) {
        this.f9389g = i;
    }

    public int getMimeType() {
        return this.f9390h;
    }

    public void setMimeType(int i) {
        this.f9390h = i;
    }

    public boolean isCompressed() {
        return this.f9392j;
    }

    public void setCompressed(boolean z) {
        this.f9392j = z;
    }

    public int getWidth() {
        return this.f9393k;
    }

    public void setWidth(int i) {
        this.f9393k = i;
    }

    public int getHeight() {
        return this.f9394l;
    }

    public void setHeight(int i) {
        this.f9394l = i;
    }

    public long getSize() {
        return this.f9395m;
    }

    public void setSize(long j) {
        this.f9395m = j;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9383a);
        parcel.writeString(this.f9384b);
        parcel.writeString(this.f9385c);
        parcel.writeLong(this.f9386d);
        parcel.writeByte(this.f9387e ? (byte) 1 : 0);
        parcel.writeByte(this.f9388f ? (byte) 1 : 0);
        parcel.writeInt(this.position);
        parcel.writeInt(this.f9389g);
        parcel.writeInt(this.f9390h);
        parcel.writeString(this.f9391i);
        parcel.writeByte(this.f9392j ? (byte) 1 : 0);
        parcel.writeInt(this.f9393k);
        parcel.writeInt(this.f9394l);
        parcel.writeLong(this.f9395m);
    }

    protected IMLocalMedia(Parcel parcel) {
        this.f9383a = parcel.readString();
        this.f9384b = parcel.readString();
        this.f9385c = parcel.readString();
        this.f9386d = parcel.readLong();
        boolean z = true;
        this.f9387e = parcel.readByte() != 0;
        this.f9388f = parcel.readByte() != 0;
        this.position = parcel.readInt();
        this.f9389g = parcel.readInt();
        this.f9390h = parcel.readInt();
        this.f9391i = parcel.readString();
        this.f9392j = parcel.readByte() == 0 ? false : z;
        this.f9393k = parcel.readInt();
        this.f9394l = parcel.readInt();
        this.f9395m = parcel.readLong();
    }
}
