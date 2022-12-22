package com.microblink.blinkbarcode.hardware.camera;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: line */
public enum VideoResolutionPreset implements Parcelable {
    VIDEO_RESOLUTION_DEFAULT(1080),
    VIDEO_RESOLUTION_480p(480),
    VIDEO_RESOLUTION_720p(720),
    VIDEO_RESOLUTION_1080p(1080),
    VIDEO_RESOLUTION_2160p(2160),
    VIDEO_RESOLUTION_MAX_AVAILABLE(4320);
    
    public static final Parcelable.Creator<VideoResolutionPreset> CREATOR = null;
    private int llIIlIlIIl;

    /* compiled from: line */
    public static class llIIlIlIIl implements Parcelable.Creator<VideoResolutionPreset> {
        public Object createFromParcel(Parcel parcel) {
            return VideoResolutionPreset.values()[parcel.readInt()];
        }

        public Object[] newArray(int i) {
            return new VideoResolutionPreset[i];
        }
    }

    /* access modifiers changed from: public */
    static {
        CREATOR = new llIIlIlIIl();
    }

    private VideoResolutionPreset(int i) {
        this.llIIlIlIIl = i;
    }

    public int describeContents() {
        return 0;
    }

    public int getIdealHeight() {
        return this.llIIlIlIIl;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ordinal());
    }
}
