package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzmj extends zzmo {
    public static final Parcelable.Creator<zzmj> CREATOR = new zzmm();
    public final String description;
    public final String text;
    private final String zzaif;

    public zzmj(String str, String str2, String str3) {
        super("COMM");
        this.zzaif = str;
        this.description = str2;
        this.text = str3;
    }

    zzmj(Parcel parcel) {
        super("COMM");
        this.zzaif = parcel.readString();
        this.description = parcel.readString();
        this.text = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzmj zzmj = (zzmj) obj;
            return zzpt.zza(this.description, zzmj.description) && zzpt.zza(this.zzaif, zzmj.zzaif) && zzpt.zza(this.text, zzmj.text);
        }
    }

    public final int hashCode() {
        String str = this.zzaif;
        int i = 0;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.text;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f52605id);
        parcel.writeString(this.zzaif);
        parcel.writeString(this.text);
    }
}
