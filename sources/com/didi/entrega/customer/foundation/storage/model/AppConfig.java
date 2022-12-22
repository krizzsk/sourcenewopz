package com.didi.entrega.customer.foundation.storage.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class AppConfig implements Parcelable {
    public static final Parcelable.Creator<AppConfig> CREATOR = new Parcelable.Creator<AppConfig>() {
        public AppConfig createFromParcel(Parcel parcel) {
            return new AppConfig(parcel);
        }

        public AppConfig[] newArray(int i) {
            return new AppConfig[i];
        }
    };
    public boolean mAddressGuideShowed;
    public int mCityId = 0;
    public String mCityName = "";
    public boolean mHomePolicyAccepted;
    public String mLocationCountry;
    public long mNotificationRemindShowTime;
    public boolean mNumProtectShown = false;
    public long mPayMethodAdviceShowTime;
    public List<String> mPreloadList = new ArrayList();
    public int shownServiceRuleNum;

    public int describeContents() {
        return 0;
    }

    public AppConfig() {
    }

    protected AppConfig(Parcel parcel) {
        boolean z = false;
        this.mCityId = parcel.readInt();
        this.mCityName = parcel.readString();
        this.mNumProtectShown = parcel.readByte() != 0;
        this.mPreloadList = parcel.readArrayList(String.class.getClassLoader());
        this.mNotificationRemindShowTime = parcel.readLong();
        this.mPayMethodAdviceShowTime = parcel.readLong();
        this.mLocationCountry = parcel.readString();
        this.mHomePolicyAccepted = parcel.readByte() != 0;
        this.mAddressGuideShowed = parcel.readByte() != 0 ? true : z;
        this.shownServiceRuleNum = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mCityId);
        parcel.writeString(this.mCityName);
        parcel.writeByte(this.mNumProtectShown ? (byte) 1 : 0);
        parcel.writeList(this.mPreloadList);
        parcel.writeLong(this.mNotificationRemindShowTime);
        parcel.writeLong(this.mPayMethodAdviceShowTime);
        parcel.writeString(this.mLocationCountry);
        parcel.writeByte(this.mHomePolicyAccepted ? (byte) 1 : 0);
        parcel.writeByte(this.mAddressGuideShowed ? (byte) 1 : 0);
        parcel.writeInt(this.shownServiceRuleNum);
    }
}
