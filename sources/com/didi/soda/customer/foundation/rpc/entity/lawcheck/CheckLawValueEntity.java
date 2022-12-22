package com.didi.soda.customer.foundation.rpc.entity.lawcheck;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;

public class CheckLawValueEntity implements Parcelable, IEntity {
    public static final Parcelable.Creator<CheckLawValueEntity> CREATOR = new Parcelable.Creator<CheckLawValueEntity>() {
        public CheckLawValueEntity createFromParcel(Parcel parcel) {
            return new CheckLawValueEntity(parcel);
        }

        public CheckLawValueEntity[] newArray(int i) {
            return new CheckLawValueEntity[i];
        }
    };
    private static final long serialVersionUID = -4684347435402903594L;
    public boolean isAgree;

    public int describeContents() {
        return 0;
    }

    public CheckLawValueEntity() {
        this.isAgree = false;
    }

    protected CheckLawValueEntity(Parcel parcel) {
        this.isAgree = parcel.readInt() != 1 ? false : true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.isAgree ? 1 : 0);
    }
}
