package com.didi.soda.customer.foundation.rpc.entity.lawcheck;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;

public class CheckLawKeyEntity implements Parcelable, IEntity {
    public static final Parcelable.Creator<CheckLawKeyEntity> CREATOR = new Parcelable.Creator<CheckLawKeyEntity>() {
        public CheckLawKeyEntity createFromParcel(Parcel parcel) {
            return new CheckLawKeyEntity(parcel);
        }

        public CheckLawKeyEntity[] newArray(int i) {
            return new CheckLawKeyEntity[i];
        }
    };
    private static final long serialVersionUID = -7594327371560731741L;
    public String uid = "";

    public int describeContents() {
        return 0;
    }

    public CheckLawKeyEntity(String str) {
        this.uid = str == null ? "" : str;
    }

    protected CheckLawKeyEntity(Parcel parcel) {
        this.uid = parcel.readString();
    }

    public boolean equals(Object obj) {
        return (obj instanceof CheckLawKeyEntity) && this.uid.equals(((CheckLawKeyEntity) obj).uid);
    }

    public int hashCode() {
        return this.uid.hashCode() + 31;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uid);
    }
}
