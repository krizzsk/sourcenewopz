package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzvf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvf> CREATOR = new zzvi();
    public final String zzchp;
    public final String zzchq;

    public zzvf(String str, String str2) {
        this.zzchp = str;
        this.zzchq = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzchp, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzchq, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
