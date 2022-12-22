package com.didi.map.outer.model;

import android.os.Parcel;
import android.os.Parcelable;

public final class CameraPositionCreator implements Parcelable.Creator<CameraPosition> {
    public CameraPosition createFromParcel(Parcel parcel) {
        return new CameraPosition(parcel);
    }

    public CameraPosition[] newArray(int i) {
        return i <= 0 ? new CameraPosition[0] : new CameraPosition[i];
    }
}
