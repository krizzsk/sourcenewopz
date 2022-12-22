package com.didi.soda.customer.foundation.rpc.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class PromoCodeEntity implements Parcelable, IEntity {
    public static final Parcelable.Creator<PromoCodeEntity> CREATOR = new Parcelable.Creator<PromoCodeEntity>() {
        public PromoCodeEntity createFromParcel(Parcel parcel) {
            return new PromoCodeEntity(parcel);
        }

        public PromoCodeEntity[] newArray(int i) {
            return new PromoCodeEntity[i];
        }
    };
    private static final long serialVersionUID = 1880046587130011088L;
    public boolean firstFetch = true;
    public String promoCode;

    public int describeContents() {
        return 0;
    }

    public PromoCodeEntity() {
    }

    protected PromoCodeEntity(Parcel parcel) {
        boolean z = true;
        this.promoCode = parcel.readString();
        this.firstFetch = parcel.readInt() != 1 ? false : z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.promoCode);
        parcel.writeInt(this.firstFetch ? 1 : 0);
    }
}
