package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzvq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvq> CREATOR = new zzvs();
    public final Bundle extras;
    public final int versionCode;
    public final int zzadv;
    public final int zzadw;
    public final String zzadx;
    public final boolean zzbns;
    @Deprecated
    public final long zzcia;
    @Deprecated
    public final int zzcib;
    public final List<String> zzcic;
    public final boolean zzcid;
    public final String zzcie;
    public final zzaav zzcif;
    public final String zzcig;
    public final Bundle zzcih;
    public final Bundle zzcii;
    public final List<String> zzcij;
    public final String zzcik;
    public final String zzcil;
    @Deprecated
    public final boolean zzcim;
    public final List<String> zzcin;
    public final int zzcio;
    public final zzvf zzcip;
    public final Location zzng;

    public zzvq(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, zzaav zzaav, Location location, String str2, Bundle bundle2, Bundle bundle3, List<String> list2, String str3, String str4, boolean z3, zzvf zzvf, int i4, String str5, List<String> list3, int i5) {
        this.versionCode = i;
        this.zzcia = j;
        this.extras = bundle == null ? new Bundle() : bundle;
        this.zzcib = i2;
        this.zzcic = list;
        this.zzcid = z;
        this.zzadv = i3;
        this.zzbns = z2;
        this.zzcie = str;
        this.zzcif = zzaav;
        this.zzng = location;
        this.zzcig = str2;
        this.zzcih = bundle2 == null ? new Bundle() : bundle2;
        this.zzcii = bundle3;
        this.zzcij = list2;
        this.zzcik = str3;
        this.zzcil = str4;
        this.zzcim = z3;
        this.zzcip = zzvf;
        this.zzadw = i4;
        this.zzadx = str5;
        this.zzcin = list3 == null ? new ArrayList<>() : list3;
        this.zzcio = i5;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeLong(parcel, 2, this.zzcia);
        SafeParcelWriter.writeBundle(parcel, 3, this.extras, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzcib);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzcic, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzcid);
        SafeParcelWriter.writeInt(parcel, 7, this.zzadv);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbns);
        SafeParcelWriter.writeString(parcel, 9, this.zzcie, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzcif, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzng, i, false);
        SafeParcelWriter.writeString(parcel, 12, this.zzcig, false);
        SafeParcelWriter.writeBundle(parcel, 13, this.zzcih, false);
        SafeParcelWriter.writeBundle(parcel, 14, this.zzcii, false);
        SafeParcelWriter.writeStringList(parcel, 15, this.zzcij, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzcik, false);
        SafeParcelWriter.writeString(parcel, 17, this.zzcil, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzcim);
        SafeParcelWriter.writeParcelable(parcel, 19, this.zzcip, i, false);
        SafeParcelWriter.writeInt(parcel, 20, this.zzadw);
        SafeParcelWriter.writeString(parcel, 21, this.zzadx, false);
        SafeParcelWriter.writeStringList(parcel, 22, this.zzcin, false);
        SafeParcelWriter.writeInt(parcel, 23, this.zzcio);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzvq)) {
            return false;
        }
        zzvq zzvq = (zzvq) obj;
        if (this.versionCode != zzvq.versionCode || this.zzcia != zzvq.zzcia || !Objects.equal(this.extras, zzvq.extras) || this.zzcib != zzvq.zzcib || !Objects.equal(this.zzcic, zzvq.zzcic) || this.zzcid != zzvq.zzcid || this.zzadv != zzvq.zzadv || this.zzbns != zzvq.zzbns || !Objects.equal(this.zzcie, zzvq.zzcie) || !Objects.equal(this.zzcif, zzvq.zzcif) || !Objects.equal(this.zzng, zzvq.zzng) || !Objects.equal(this.zzcig, zzvq.zzcig) || !Objects.equal(this.zzcih, zzvq.zzcih) || !Objects.equal(this.zzcii, zzvq.zzcii) || !Objects.equal(this.zzcij, zzvq.zzcij) || !Objects.equal(this.zzcik, zzvq.zzcik) || !Objects.equal(this.zzcil, zzvq.zzcil) || this.zzcim != zzvq.zzcim || this.zzadw != zzvq.zzadw || !Objects.equal(this.zzadx, zzvq.zzadx) || !Objects.equal(this.zzcin, zzvq.zzcin) || this.zzcio != zzvq.zzcio) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.versionCode), Long.valueOf(this.zzcia), this.extras, Integer.valueOf(this.zzcib), this.zzcic, Boolean.valueOf(this.zzcid), Integer.valueOf(this.zzadv), Boolean.valueOf(this.zzbns), this.zzcie, this.zzcif, this.zzng, this.zzcig, this.zzcih, this.zzcii, this.zzcij, this.zzcik, this.zzcil, Boolean.valueOf(this.zzcim), Integer.valueOf(this.zzadw), this.zzadx, this.zzcin, Integer.valueOf(this.zzcio));
    }
}
