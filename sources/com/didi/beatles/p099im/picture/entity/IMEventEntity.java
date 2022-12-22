package com.didi.beatles.p099im.picture.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.picture.entity.IMEventEntity */
public class IMEventEntity implements Parcelable {
    public static final Parcelable.Creator<IMEventEntity> CREATOR = new Parcelable.Creator<IMEventEntity>() {
        public IMEventEntity createFromParcel(Parcel parcel) {
            return new IMEventEntity(parcel);
        }

        public IMEventEntity[] newArray(int i) {
            return new IMEventEntity[i];
        }
    };
    public List<IMLocalMedia> medias = new ArrayList();
    public int position;
    public int what;

    public int describeContents() {
        return 0;
    }

    public IMEventEntity() {
    }

    public IMEventEntity(int i) {
        this.what = i;
    }

    public IMEventEntity(int i, int i2) {
        this.what = i;
        this.position = i2;
    }

    public IMEventEntity(int i, List<IMLocalMedia> list) {
        this.what = i;
        this.medias = list;
    }

    public IMEventEntity(int i, int i2, List<IMLocalMedia> list) {
        this.what = i;
        this.position = i2;
        this.medias = list;
    }

    protected IMEventEntity(Parcel parcel) {
        this.what = parcel.readInt();
        this.position = parcel.readInt();
        this.medias = parcel.createTypedArrayList(IMLocalMedia.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.what);
        parcel.writeInt(this.position);
        parcel.writeTypedList(this.medias);
    }
}
