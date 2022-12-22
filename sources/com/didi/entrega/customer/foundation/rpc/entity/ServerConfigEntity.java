package com.didi.entrega.customer.foundation.rpc.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class ServerConfigEntity implements Parcelable, IEntity {
    public static final Parcelable.Creator<ServerConfigEntity> CREATOR = new Parcelable.Creator<ServerConfigEntity>() {
        public ServerConfigEntity createFromParcel(Parcel parcel) {
            return new ServerConfigEntity(parcel);
        }

        public ServerConfigEntity[] newArray(int i) {
            return new ServerConfigEntity[i];
        }
    };
    private static final long serialVersionUID = -3151043849858372300L;
    public long countyGroupId;
    public long countyId;
    public int payTimeout;
    public String servicePhone;

    public int describeContents() {
        return 0;
    }

    public ServerConfigEntity() {
    }

    protected ServerConfigEntity(Parcel parcel) {
        this.countyId = parcel.readLong();
        this.countyGroupId = parcel.readLong();
        this.payTimeout = parcel.readInt();
        this.servicePhone = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.countyId);
        parcel.writeLong(this.countyGroupId);
        parcel.writeInt(this.payTimeout);
        parcel.writeString(this.servicePhone);
    }
}
