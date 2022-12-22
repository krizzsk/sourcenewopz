package com.microblink.blinkbarcode.view;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: line */
public enum CameraAspectMode implements Parcelable {
    ASPECT_FIT,
    ASPECT_FILL;
    
    public static final Parcelable.Creator<CameraAspectMode> CREATOR = null;

    /* compiled from: line */
    public static class llIIlIlIIl implements Parcelable.Creator<CameraAspectMode> {
        public Object createFromParcel(Parcel parcel) {
            return CameraAspectMode.values()[parcel.readInt()];
        }

        public Object[] newArray(int i) {
            return new CameraAspectMode[i];
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
