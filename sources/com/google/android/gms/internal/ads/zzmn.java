package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzmn extends zzmo {
    public static final Parcelable.Creator<zzmn> CREATOR = new zzmq();
    private final String description;
    private final String value;

    public zzmn(String str, String str2, String str3) {
        super(str);
        this.description = null;
        this.value = str3;
    }

    zzmn(Parcel parcel) {
        super(parcel.readString());
        this.description = parcel.readString();
        this.value = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzmn zzmn = (zzmn) obj;
            return this.f52605id.equals(zzmn.f52605id) && zzpt.zza(this.description, zzmn.description) && zzpt.zza(this.value, zzmn.value);
        }
    }

    public final int hashCode() {
        int hashCode = (this.f52605id.hashCode() + 527) * 31;
        String str = this.description;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.value;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f52605id);
        parcel.writeString(this.description);
        parcel.writeString(this.value);
    }
}
