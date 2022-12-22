package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzajm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzajm> CREATOR = new zzajp();
    public final String description;
    public final String zzdka;
    public final boolean zzdkb;
    public final int zzdkc;

    public zzajm(String str, boolean z, int i, String str2) {
        this.zzdka = str;
        this.zzdkb = z;
        this.zzdkc = i;
        this.description = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdka, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzdkb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdkc);
        SafeParcelWriter.writeString(parcel, 4, this.description, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
