package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzazi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzazi> CREATOR = new zzazl();
    public final String zzbrw;
    @Deprecated
    public final String zzbvf;
    @Deprecated
    public final zzvt zzedt;
    public final zzvq zzedu;

    public zzazi(String str, String str2, zzvt zzvt, zzvq zzvq) {
        this.zzbvf = str;
        this.zzbrw = str2;
        this.zzedt = zzvt;
        this.zzedu = zzvq;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzbvf, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzbrw, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzedt, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzedu, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
