package com.didi.soda.web.config;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

public class WebConfig implements Parcelable {
    public static final Parcelable.Creator<WebConfig> CREATOR = new Parcelable.Creator<WebConfig>() {
        public WebConfig createFromParcel(Parcel parcel) {
            return new WebConfig(parcel);
        }

        public WebConfig[] newArray(int i) {
            return new WebConfig[i];
        }
    };
    public boolean canChangeTitle;
    public boolean isSupportCache;
    public boolean isUseNativeTitltBar;
    public HashMap<String, String> mCustomerParameters;
    public boolean needPreload;
    public boolean remoteDebuggable;
    public String title;
    public String url;

    public int describeContents() {
        return 0;
    }

    public WebConfig() {
        this.url = "";
        this.title = "";
        this.canChangeTitle = true;
        this.isSupportCache = false;
        this.isUseNativeTitltBar = true;
        this.remoteDebuggable = false;
        this.needPreload = false;
        this.mCustomerParameters = new HashMap<>();
    }

    protected WebConfig(Parcel parcel) {
        this.url = "";
        this.title = "";
        boolean z = true;
        this.canChangeTitle = true;
        this.isSupportCache = false;
        this.isUseNativeTitltBar = true;
        this.remoteDebuggable = false;
        this.needPreload = false;
        this.mCustomerParameters = new HashMap<>();
        this.url = parcel.readString();
        this.title = parcel.readString();
        this.canChangeTitle = parcel.readByte() != 0;
        this.isSupportCache = parcel.readByte() != 0;
        this.remoteDebuggable = parcel.readByte() != 0;
        this.isUseNativeTitltBar = parcel.readByte() == 0 ? false : z;
        this.mCustomerParameters = parcel.readHashMap(HashMap.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeString(this.title);
        parcel.writeByte(this.canChangeTitle ? (byte) 1 : 0);
        parcel.writeByte(this.isSupportCache ? (byte) 1 : 0);
        parcel.writeByte(this.remoteDebuggable ? (byte) 1 : 0);
        parcel.writeByte(this.isUseNativeTitltBar ? (byte) 1 : 0);
        parcel.writeMap(this.mCustomerParameters);
    }
}
