package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzmq implements Parcelable.Creator<zzmn> {
    zzmq() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzmn[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzmn(parcel);
    }
}
