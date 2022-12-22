package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzavt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzavt> CREATOR = new zzavs();
    public final String zzbvf;
    public final zzvq zzdvn;

    public zzavt(zzvq zzvq, String str) {
        this.zzdvn = zzvq;
        this.zzbvf = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdvn, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzbvf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
