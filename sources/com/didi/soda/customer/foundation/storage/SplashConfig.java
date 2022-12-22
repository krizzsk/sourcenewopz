package com.didi.soda.customer.foundation.storage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class SplashConfig implements Parcelable {
    public static final Parcelable.Creator<SplashConfig> CREATOR = new Parcelable.Creator<SplashConfig>() {
        public SplashConfig createFromParcel(Parcel parcel) {
            return new SplashConfig(parcel);
        }

        public SplashConfig[] newArray(int i) {
            return new SplashConfig[i];
        }
    };
    public List<SplashConfigItem> mConfigList;
    public long mLastShowTime;

    public int describeContents() {
        return 0;
    }

    public SplashConfig() {
    }

    protected SplashConfig(Parcel parcel) {
        if (this.mConfigList == null) {
            this.mConfigList = new ArrayList();
        }
        this.mLastShowTime = parcel.readLong();
        parcel.readTypedList(this.mConfigList, SplashConfigItem.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mLastShowTime);
        parcel.writeTypedList(this.mConfigList);
    }

    public static class SplashConfigItem implements Parcelable, Comparable<SplashConfigItem> {
        public static final Parcelable.Creator<SplashConfigItem> CREATOR = new Parcelable.Creator<SplashConfigItem>() {
            public SplashConfigItem createFromParcel(Parcel parcel) {
                return new SplashConfigItem(parcel);
            }

            public SplashConfigItem[] newArray(int i) {
                return new SplashConfigItem[i];
            }
        };
        public long mEffectiveTimeFrom;
        public long mEffectiveTimeTo;
        public String mId;
        public String mImageUrl;
        public int mIsExclusive;
        public String mLocalPath;
        public String mRedirectUrl;
        public int mShow;
        public int mValid;
        public int mWeight;

        public int describeContents() {
            return 0;
        }

        public SplashConfigItem() {
        }

        protected SplashConfigItem(Parcel parcel) {
            this.mId = parcel.readString();
            this.mWeight = parcel.readInt();
            this.mEffectiveTimeFrom = parcel.readLong();
            this.mEffectiveTimeTo = parcel.readLong();
            this.mImageUrl = parcel.readString();
            this.mRedirectUrl = parcel.readString();
            this.mIsExclusive = parcel.readInt();
            this.mShow = parcel.readInt();
            this.mValid = parcel.readInt();
            this.mLocalPath = parcel.readString();
        }

        public int compareTo(SplashConfigItem splashConfigItem) {
            return this.mWeight - splashConfigItem.mWeight;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mId);
            parcel.writeInt(this.mWeight);
            parcel.writeLong(this.mEffectiveTimeFrom);
            parcel.writeLong(this.mEffectiveTimeTo);
            parcel.writeString(this.mImageUrl);
            parcel.writeString(this.mRedirectUrl);
            parcel.writeInt(this.mIsExclusive);
            parcel.writeInt(this.mShow);
            parcel.writeInt(this.mValid);
            parcel.writeString(this.mLocalPath);
        }
    }
}
