package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzaja extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaja> CREATOR = new zzajd();
    public final byte[] data;
    public final int statusCode;
    public final boolean zzak;
    public final long zzal;
    public final String zzchs;
    public final String[] zzdju;
    public final String[] zzdjv;
    public final boolean zzdjw;

    zzaja(boolean z, String str, int i, byte[] bArr, String[] strArr, String[] strArr2, boolean z2, long j) {
        this.zzdjw = z;
        this.zzchs = str;
        this.statusCode = i;
        this.data = bArr;
        this.zzdju = strArr;
        this.zzdjv = strArr2;
        this.zzak = z2;
        this.zzal = j;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zzdjw);
        SafeParcelWriter.writeString(parcel, 2, this.zzchs, false);
        SafeParcelWriter.writeInt(parcel, 3, this.statusCode);
        SafeParcelWriter.writeByteArray(parcel, 4, this.data, false);
        SafeParcelWriter.writeStringArray(parcel, 5, this.zzdju, false);
        SafeParcelWriter.writeStringArray(parcel, 6, this.zzdjv, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzak);
        SafeParcelWriter.writeLong(parcel, 8, this.zzal);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
