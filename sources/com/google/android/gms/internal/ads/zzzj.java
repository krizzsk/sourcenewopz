package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzzj> CREATOR = new zzzm();
    private final int zzckk;

    public zzzj(int i) {
        this.zzckk = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzckk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
