package com.didi.beatles.p099im.picture.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.picture.entity.IMLocalMediaFolder */
public class IMLocalMediaFolder implements Parcelable {
    public static final Parcelable.Creator<IMLocalMediaFolder> CREATOR = new Parcelable.Creator<IMLocalMediaFolder>() {
        public IMLocalMediaFolder createFromParcel(Parcel parcel) {
            return new IMLocalMediaFolder(parcel);
        }

        public IMLocalMediaFolder[] newArray(int i) {
            return new IMLocalMediaFolder[i];
        }
    };

    /* renamed from: a */
    private String f9396a;

    /* renamed from: b */
    private String f9397b;

    /* renamed from: c */
    private String f9398c;

    /* renamed from: d */
    private int f9399d;

    /* renamed from: e */
    private int f9400e;

    /* renamed from: f */
    private boolean f9401f;

    /* renamed from: g */
    private List<IMLocalMedia> f9402g = new ArrayList();

    public int describeContents() {
        return 0;
    }

    public boolean isChecked() {
        return this.f9401f;
    }

    public void setChecked(boolean z) {
        this.f9401f = z;
    }

    public String getName() {
        return this.f9396a;
    }

    public void setName(String str) {
        this.f9396a = str;
    }

    public String getPath() {
        return this.f9397b;
    }

    public void setPath(String str) {
        this.f9397b = str;
    }

    public String getFirstImagePath() {
        return this.f9398c;
    }

    public void setFirstImagePath(String str) {
        this.f9398c = str;
    }

    public int getImageNum() {
        return this.f9399d;
    }

    public void setImageNum(int i) {
        this.f9399d = i;
    }

    public List<IMLocalMedia> getImages() {
        if (this.f9402g == null) {
            this.f9402g = new ArrayList();
        }
        return this.f9402g;
    }

    public void setImages(List<IMLocalMedia> list) {
        this.f9402g = list;
    }

    public int getCheckedNum() {
        return this.f9400e;
    }

    public void setCheckedNum(int i) {
        this.f9400e = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9396a);
        parcel.writeString(this.f9397b);
        parcel.writeString(this.f9398c);
        parcel.writeInt(this.f9399d);
        parcel.writeInt(this.f9400e);
        parcel.writeByte(this.f9401f ? (byte) 1 : 0);
        parcel.writeTypedList(this.f9402g);
    }

    public IMLocalMediaFolder() {
    }

    protected IMLocalMediaFolder(Parcel parcel) {
        this.f9396a = parcel.readString();
        this.f9397b = parcel.readString();
        this.f9398c = parcel.readString();
        this.f9399d = parcel.readInt();
        this.f9400e = parcel.readInt();
        this.f9401f = parcel.readByte() != 0;
        this.f9402g = parcel.createTypedArrayList(IMLocalMedia.CREATOR);
    }
}
