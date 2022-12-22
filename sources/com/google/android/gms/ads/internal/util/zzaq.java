package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzdqh;
import com.google.android.gms.internal.ads.zzdyq;
import com.google.android.gms.internal.ads.zzvh;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzaq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaq> CREATOR = new zzas();
    public final int errorCode;
    public final String zzacu;

    public static zzaq zzc(Throwable th) {
        String str;
        zzvh zzh = zzdqh.zzh(th);
        if (zzdyq.zzar(th.getMessage())) {
            str = zzh.zzchs;
        } else {
            str = th.getMessage();
        }
        return new zzaq(str, zzh.errorCode);
    }

    zzaq(String str, int i) {
        this.zzacu = str == null ? "" : str;
        this.errorCode = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzacu, false);
        SafeParcelWriter.writeInt(parcel, 2, this.errorCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
