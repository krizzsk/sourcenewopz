package com.microblink.blinkbarcode.hardware.camera;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: line */
public enum CameraType implements Parcelable {
    CAMERA_DEFAULT,
    CAMERA_BACKFACE,
    CAMERA_FRONTFACE;
    
    public static final Parcelable.Creator<CameraType> CREATOR = null;

    /* compiled from: line */
    public static class llIIlIlIIl implements Parcelable.Creator<CameraType> {
        public Object createFromParcel(Parcel parcel) {
            return CameraType.values()[parcel.readInt()];
        }

        public Object[] newArray(int i) {
            return new CameraType[i];
        }
    }

    /* access modifiers changed from: public */
    static {
        CREATOR = new llIIlIlIIl();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}
