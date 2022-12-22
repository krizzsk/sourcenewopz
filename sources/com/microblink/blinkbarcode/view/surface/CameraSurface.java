package com.microblink.blinkbarcode.view.surface;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: line */
public enum CameraSurface implements Parcelable {
    SURFACE_DEFAULT,
    SURFACE_TEXTURE_VIEW,
    SURFACE_SURFACE_VIEW;
    
    public static final Parcelable.Creator<CameraSurface> CREATOR = null;

    /* compiled from: line */
    public static class llIIlIlIIl implements Parcelable.Creator<CameraSurface> {
        public Object createFromParcel(Parcel parcel) {
            return CameraSurface.values()[parcel.readInt()];
        }

        public Object[] newArray(int i) {
            return new CameraSurface[i];
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
