package com.didi.soda.customer.foundation.storage.model;

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
    public long landEFO;
    public long mAcceptedVersion;
    public boolean mAddressGuideShowed;
    public boolean mBusinessGuideShowed;
    public int mCityId = 0;
    public String mCityName = "";
    public long mEvaluateDialogShowTime;
    public long mFirstOpenTime;
    public boolean mHasGotoRate;
    public boolean mHasShowAlcoholRemind = false;
    public boolean mHomePolicyAccepted;
    public boolean mIsFirstOpen = false;
    public boolean mIsPurchaseNewStyle = true;
    public String mLoadUrl;
    public String mLocationCountry;
    public boolean mNewCustomerGuideShowed;
    public long mNotificationRemindShowTime;
    public boolean mNumProtectShown = false;
    public long mPayMethodAdviceShowTime;
    public long mPolicyVersion;
    public int mPopActivityId;
    public List<String> mPreloadList = new ArrayList();
    public long mRateDialogShowTime;

    public int describeContents() {
        return 0;
    }

    public AppConfig() {
    }

    protected AppConfig(Parcel parcel) {
        boolean z = false;
        this.mCityId = parcel.readInt();
        this.mCityName = parcel.readString();
        this.mPopActivityId = parcel.readInt();
        this.mIsFirstOpen = parcel.readByte() != 0;
        this.mNumProtectShown = parcel.readByte() != 0;
        this.mPreloadList = parcel.readArrayList(String.class.getClassLoader());
        this.mLoadUrl = parcel.readString();
        this.mRateDialogShowTime = parcel.readLong();
        this.mNotificationRemindShowTime = parcel.readLong();
        this.mPayMethodAdviceShowTime = parcel.readLong();
        this.mHasGotoRate = parcel.readByte() != 0;
        this.mHasShowAlcoholRemind = parcel.readByte() != 0;
        this.mLocationCountry = parcel.readString();
        this.mHomePolicyAccepted = parcel.readByte() != 0;
        this.mFirstOpenTime = parcel.readLong();
        this.mPolicyVersion = parcel.readLong();
        this.mAcceptedVersion = parcel.readLong();
        this.mAddressGuideShowed = parcel.readByte() != 0;
        this.landEFO = parcel.readLong();
        this.mNewCustomerGuideShowed = parcel.readByte() != 0;
        this.mBusinessGuideShowed = parcel.readByte() != 0;
        this.mIsPurchaseNewStyle = parcel.readByte() != 0 ? true : z;
        this.mEvaluateDialogShowTime = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mCityId);
        parcel.writeString(this.mCityName);
        parcel.writeInt(this.mPopActivityId);
        parcel.writeByte(this.mIsFirstOpen ? (byte) 1 : 0);
        parcel.writeByte(this.mNumProtectShown ? (byte) 1 : 0);
        parcel.writeList(this.mPreloadList);
        parcel.writeString(this.mLoadUrl);
        parcel.writeLong(this.mRateDialogShowTime);
        parcel.writeLong(this.mNotificationRemindShowTime);
        parcel.writeLong(this.mPayMethodAdviceShowTime);
        parcel.writeByte(this.mHasGotoRate ? (byte) 1 : 0);
        parcel.writeByte(this.mHasShowAlcoholRemind ? (byte) 1 : 0);
        parcel.writeString(this.mLocationCountry);
        parcel.writeByte(this.mHomePolicyAccepted ? (byte) 1 : 0);
        parcel.writeLong(this.mFirstOpenTime);
        parcel.writeLong(this.mPolicyVersion);
        parcel.writeLong(this.mAcceptedVersion);
        parcel.writeByte(this.mAddressGuideShowed ? (byte) 1 : 0);
        parcel.writeLong(this.landEFO);
        parcel.writeByte(this.mNewCustomerGuideShowed ? (byte) 1 : 0);
        parcel.writeByte(this.mBusinessGuideShowed ? (byte) 1 : 0);
        parcel.writeByte(this.mIsPurchaseNewStyle ? (byte) 1 : 0);
        parcel.writeLong(this.mEvaluateDialogShowTime);
    }
}
