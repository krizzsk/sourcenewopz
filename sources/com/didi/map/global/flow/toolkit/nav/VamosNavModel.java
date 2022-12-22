package com.didi.map.global.flow.toolkit.nav;

import android.os.Parcel;
import android.os.Parcelable;

public class VamosNavModel implements Parcelable {
    public static final Parcelable.Creator<VamosNavModel> CREATOR = new Parcelable.Creator<VamosNavModel>() {
        public VamosNavModel createFromParcel(Parcel parcel) {
            return new VamosNavModel(parcel);
        }

        public VamosNavModel[] newArray(int i) {
            return new VamosNavModel[i];
        }
    };
    public boolean isInstalled;
    public String name;
    public String pkgName;

    public int describeContents() {
        return 0;
    }

    public VamosNavModel(String str, String str2, boolean z) {
        this.name = str;
        this.pkgName = str2;
        this.isInstalled = z;
    }

    public VamosNavModel() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.pkgName);
        parcel.writeByte(this.isInstalled ? (byte) 1 : 0);
    }

    protected VamosNavModel(Parcel parcel) {
        this.name = parcel.readString();
        this.pkgName = parcel.readString();
        this.isInstalled = parcel.readByte() != 0;
    }
}
