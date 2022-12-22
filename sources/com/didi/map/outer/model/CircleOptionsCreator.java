package com.didi.map.outer.model;

import android.os.Parcel;
import android.os.Parcelable;

public final class CircleOptionsCreator implements Parcelable.Creator<CircleOptions> {
    public CircleOptions createFromParcel(Parcel parcel) {
        return new CircleOptions(parcel);
    }

    public CircleOptions[] newArray(int i) {
        return new CircleOptions[i];
    }
}
