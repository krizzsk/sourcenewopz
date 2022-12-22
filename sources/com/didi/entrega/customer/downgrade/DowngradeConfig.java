package com.didi.entrega.customer.downgrade;

import android.os.Parcel;
import android.os.Parcelable;

public class DowngradeConfig implements Parcelable {
    public static final Parcelable.Creator<DowngradeConfig> CREATOR = new Parcelable.Creator<DowngradeConfig>() {
        public DowngradeConfig createFromParcel(Parcel parcel) {
            return new DowngradeConfig(parcel);
        }

        public DowngradeConfig[] newArray(int i) {
            return new DowngradeConfig[i];
        }
    };
    public int mDowngradeFacebookLogin;
    public int mDowngradeGoogleLogin;
    public int mDowngradeIM;
    public int mDowngradeMap;
    public int mDowngradeShare;
    public int mToggle;

    public int describeContents() {
        return 0;
    }

    public DowngradeConfig() {
    }

    private DowngradeConfig(Parcel parcel) {
        this.mToggle = parcel.readInt();
        this.mDowngradeMap = parcel.readInt();
        this.mDowngradeIM = parcel.readInt();
        this.mDowngradeShare = parcel.readInt();
        this.mDowngradeFacebookLogin = parcel.readInt();
        this.mDowngradeGoogleLogin = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mToggle);
        parcel.writeInt(this.mDowngradeMap);
        parcel.writeInt(this.mDowngradeIM);
        parcel.writeInt(this.mDowngradeShare);
        parcel.writeInt(this.mDowngradeFacebookLogin);
        parcel.writeInt(this.mDowngradeGoogleLogin);
    }
}
