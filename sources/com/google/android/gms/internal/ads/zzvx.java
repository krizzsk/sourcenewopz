package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzvx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvx> CREATOR = new zzwa();
    public String zzcja;
    public long zzcjb;
    public zzvh zzcjc;
    public Bundle zzcjd;

    public zzvx(String str, long j, zzvh zzvh, Bundle bundle) {
        this.zzcja = str;
        this.zzcjb = j;
        this.zzcjc = zzvh;
        this.zzcjd = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzcja, false);
        SafeParcelWriter.writeLong(parcel, 2, this.zzcjb);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzcjc, i, false);
        SafeParcelWriter.writeBundle(parcel, 4, this.zzcjd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
