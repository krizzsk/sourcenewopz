package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzpy implements Parcelable {
    public static final Parcelable.Creator<zzpy> CREATOR = new zzpx();
    private int zzaih;
    public final int zzasf;
    public final int zzasg;
    public final int zzash;
    public final byte[] zzbld;

    public zzpy(int i, int i2, int i3, byte[] bArr) {
        this.zzasf = i;
        this.zzash = i2;
        this.zzasg = i3;
        this.zzbld = bArr;
    }

    public final int describeContents() {
        return 0;
    }

    zzpy(Parcel parcel) {
        this.zzasf = parcel.readInt();
        this.zzash = parcel.readInt();
        this.zzasg = parcel.readInt();
        this.zzbld = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzpy zzpy = (zzpy) obj;
            return this.zzasf == zzpy.zzasf && this.zzash == zzpy.zzash && this.zzasg == zzpy.zzasg && Arrays.equals(this.zzbld, zzpy.zzbld);
        }
    }

    public final String toString() {
        int i = this.zzasf;
        int i2 = this.zzash;
        int i3 = this.zzasg;
        boolean z = this.zzbld != null;
        StringBuilder sb = new StringBuilder(55);
        sb.append("ColorInfo(");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(z);
        sb.append(")");
        return sb.toString();
    }

    public final int hashCode() {
        if (this.zzaih == 0) {
            this.zzaih = ((((((this.zzasf + 527) * 31) + this.zzash) * 31) + this.zzasg) * 31) + Arrays.hashCode(this.zzbld);
        }
        return this.zzaih;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzasf);
        parcel.writeInt(this.zzash);
        parcel.writeInt(this.zzasg);
        parcel.writeInt(this.zzbld != null ? 1 : 0);
        byte[] bArr = this.zzbld;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
