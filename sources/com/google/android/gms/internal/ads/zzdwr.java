package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzdwr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdwr> CREATOR = new zzdwq();
    private final int versionCode;
    private final String zzhvw;
    private final String zzhvx;
    private final int zzhvy;
    private final int zzhxo;

    zzdwr(int i, int i2, int i3, String str, String str2) {
        this.versionCode = i;
        this.zzhvy = i2;
        this.zzhvw = str;
        this.zzhvx = str2;
        this.zzhxo = i3;
    }

    public zzdwr(int i, zzgp zzgp, String str, String str2) {
        this(1, i, zzgp.zzv(), str, str2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeInt(parcel, 2, this.zzhvy);
        SafeParcelWriter.writeString(parcel, 3, this.zzhvw, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzhvx, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzhxo);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
