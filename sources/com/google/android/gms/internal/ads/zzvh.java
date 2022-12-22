package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzvh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvh> CREATOR = new zzvk();
    public final int errorCode;
    public final String zzchs;
    public final String zzcht;
    public zzvh zzchu;
    public IBinder zzchv;

    public zzvh(int i, String str, String str2, zzvh zzvh, IBinder iBinder) {
        this.errorCode = i;
        this.zzchs = str;
        this.zzcht = str2;
        this.zzchu = zzvh;
        this.zzchv = iBinder;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.errorCode);
        SafeParcelWriter.writeString(parcel, 2, this.zzchs, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzcht, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzchu, i, false);
        SafeParcelWriter.writeIBinder(parcel, 5, this.zzchv, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final AdError zzqh() {
        zzvh zzvh = this.zzchu;
        return new AdError(this.errorCode, this.zzchs, this.zzcht, zzvh == null ? null : new AdError(zzvh.errorCode, zzvh.zzchs, zzvh.zzcht));
    }

    public final LoadAdError zzqi() {
        zzvh zzvh = this.zzchu;
        zzzc zzzc = null;
        AdError adError = zzvh == null ? null : new AdError(zzvh.errorCode, zzvh.zzchs, zzvh.zzcht);
        int i = this.errorCode;
        String str = this.zzchs;
        String str2 = this.zzcht;
        IBinder iBinder = this.zzchv;
        if (iBinder != null) {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            if (queryLocalInterface instanceof zzzc) {
                zzzc = (zzzc) queryLocalInterface;
            } else {
                zzzc = new zzze(iBinder);
            }
        }
        return new LoadAdError(i, str, str2, adError, ResponseInfo.zza(zzzc));
    }
}
