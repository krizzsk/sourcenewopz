package com.didi.entrega.customer.foundation.locale;

import android.os.Parcel;
import android.os.Parcelable;
import com.didi.entrega.customer.foundation.rpc.entity.IEntity;

public class LocaleStorageConfig implements Parcelable, IEntity {
    public static final Parcelable.Creator<LocaleStorageConfig> CREATOR = new Parcelable.Creator<LocaleStorageConfig>() {
        public LocaleStorageConfig createFromParcel(Parcel parcel) {
            return new LocaleStorageConfig(parcel);
        }

        public LocaleStorageConfig[] newArray(int i) {
            return new LocaleStorageConfig[i];
        }
    };
    private static final long serialVersionUID = 4087274177736370873L;
    public String mJsonStr;

    public int describeContents() {
        return 0;
    }

    public LocaleStorageConfig() {
    }

    private LocaleStorageConfig(Parcel parcel) {
        this.mJsonStr = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mJsonStr);
    }
}
