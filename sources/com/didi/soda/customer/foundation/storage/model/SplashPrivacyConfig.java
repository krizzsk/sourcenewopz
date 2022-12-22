package com.didi.soda.customer.foundation.storage.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SplashPrivacyConfig implements Parcelable {
    public static final Parcelable.Creator<SplashPrivacyConfig> CREATOR = new Parcelable.Creator<SplashPrivacyConfig>() {
        public SplashPrivacyConfig createFromParcel(Parcel parcel) {
            return new SplashPrivacyConfig(parcel);
        }

        public SplashPrivacyConfig[] newArray(int i) {
            return new SplashPrivacyConfig[i];
        }
    };
    public boolean isDisplayed;

    public int describeContents() {
        return 0;
    }

    public SplashPrivacyConfig() {
    }

    protected SplashPrivacyConfig(Parcel parcel) {
        this.isDisplayed = parcel.readInt() != 1 ? false : true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.isDisplayed ? (byte) 1 : 0);
    }
}
