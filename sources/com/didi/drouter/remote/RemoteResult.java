package com.didi.drouter.remote;

import android.os.Parcel;
import android.os.Parcelable;

class RemoteResult implements Parcelable {
    public static final Parcelable.Creator<RemoteResult> CREATOR = new Parcelable.Creator<RemoteResult>() {
        public RemoteResult createFromParcel(Parcel parcel) {
            return new RemoteResult(parcel);
        }

        public RemoteResult[] newArray(int i) {
            return new RemoteResult[i];
        }
    };

    /* renamed from: a */
    static final String f19165a = "executing";

    /* renamed from: b */
    static final String f19166b = "success";

    /* renamed from: c */
    static final String f19167c = "fail";

    /* renamed from: d */
    String f19168d;

    /* renamed from: e */
    Object f19169e;

    public int describeContents() {
        return 0;
    }

    RemoteResult(String str) {
        this.f19168d = str;
    }

    RemoteResult(Parcel parcel) {
        this.f19168d = parcel.readString();
        this.f19169e = RemoteStream.m14344b(parcel.readValue(RemoteResult.class.getClassLoader()));
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f19168d);
        parcel.writeValue(RemoteStream.m14342a(this.f19169e));
    }
}
