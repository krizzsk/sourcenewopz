package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new zzj();
    public final boolean zzbpo;
    public final boolean zzbpp;
    private final String zzbpq;
    public final boolean zzbpr;
    public final float zzbps;
    public final int zzbpt;
    public final boolean zzbpu;
    public final boolean zzbpv;
    public final boolean zzbpw;

    public zzk(boolean z, boolean z2, boolean z3, float f, int i, boolean z4, boolean z5, boolean z6) {
        this(z, z2, (String) null, z3, f, -1, z4, z5, z6);
    }

    zzk(boolean z, boolean z2, String str, boolean z3, float f, int i, boolean z4, boolean z5, boolean z6) {
        this.zzbpo = z;
        this.zzbpp = z2;
        this.zzbpq = str;
        this.zzbpr = z3;
        this.zzbps = f;
        this.zzbpt = i;
        this.zzbpu = z4;
        this.zzbpv = z5;
        this.zzbpw = z6;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzbpo);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzbpp);
        SafeParcelWriter.writeString(parcel, 4, this.zzbpq, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzbpr);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzbps);
        SafeParcelWriter.writeInt(parcel, 7, this.zzbpt);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbpu);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzbpv);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzbpw);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
