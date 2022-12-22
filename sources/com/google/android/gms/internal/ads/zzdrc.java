package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdrc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdrc> CREATOR = new zzdrg();
    @Nullable
    public final Context context;
    private final zzdrf[] zzhqk;
    private final int[] zzhql;
    private final int[] zzhqm;
    private final int zzhqn;
    public final zzdrf zzhqo;
    public final int zzhqp;
    public final int zzhqq;
    public final int zzhqr;
    public final String zzhqs;
    private final int zzhqt;
    public final int zzhqu;
    private final int zzhqv;
    private final int zzhqw;

    private zzdrc(@Nullable Context context2, zzdrf zzdrf, int i, int i2, int i3, String str, String str2, String str3) {
        int i4;
        this.zzhqk = zzdrf.values();
        this.zzhql = zzdre.zzaxf();
        this.zzhqm = zzdrh.zzaxg();
        this.context = context2;
        this.zzhqn = zzdrf.ordinal();
        this.zzhqo = zzdrf;
        this.zzhqp = i;
        this.zzhqq = i2;
        this.zzhqr = i3;
        this.zzhqs = str;
        if ("oldest".equals(str2)) {
            i4 = zzdre.zzhqz;
        } else if ("lru".equals(str2) || !"lfu".equals(str2)) {
            i4 = zzdre.zzhra;
        } else {
            i4 = zzdre.zzhrb;
        }
        this.zzhqu = i4;
        this.zzhqt = i4 - 1;
        "onAdClosed".equals(str3);
        int i5 = zzdrh.zzhrh;
        this.zzhqw = i5;
        this.zzhqv = i5 - 1;
    }

    public zzdrc(int i, int i2, int i3, int i4, String str, int i5, int i6) {
        this.zzhqk = zzdrf.values();
        this.zzhql = zzdre.zzaxf();
        int[] zzaxg = zzdrh.zzaxg();
        this.zzhqm = zzaxg;
        this.context = null;
        this.zzhqn = i;
        this.zzhqo = this.zzhqk[i];
        this.zzhqp = i2;
        this.zzhqq = i3;
        this.zzhqr = i4;
        this.zzhqs = str;
        this.zzhqt = i5;
        this.zzhqu = this.zzhql[i5];
        this.zzhqv = i6;
        this.zzhqw = zzaxg[i6];
    }

    public static zzdrc zza(zzdrf zzdrf, Context context2) {
        if (zzdrf == zzdrf.Rewarded) {
            return new zzdrc(context2, zzdrf, ((Integer) zzww.zzra().zzd(zzabq.zzcyz)).intValue(), ((Integer) zzww.zzra().zzd(zzabq.zzczf)).intValue(), ((Integer) zzww.zzra().zzd(zzabq.zzczh)).intValue(), (String) zzww.zzra().zzd(zzabq.zzczj), (String) zzww.zzra().zzd(zzabq.zzczb), (String) zzww.zzra().zzd(zzabq.zzczd));
        } else if (zzdrf == zzdrf.Interstitial) {
            return new zzdrc(context2, zzdrf, ((Integer) zzww.zzra().zzd(zzabq.zzcza)).intValue(), ((Integer) zzww.zzra().zzd(zzabq.zzczg)).intValue(), ((Integer) zzww.zzra().zzd(zzabq.zzczi)).intValue(), (String) zzww.zzra().zzd(zzabq.zzczk), (String) zzww.zzra().zzd(zzabq.zzczc), (String) zzww.zzra().zzd(zzabq.zzcze));
        } else if (zzdrf != zzdrf.AppOpen) {
            return null;
        } else {
            return new zzdrc(context2, zzdrf, ((Integer) zzww.zzra().zzd(zzabq.zzczn)).intValue(), ((Integer) zzww.zzra().zzd(zzabq.zzczp)).intValue(), ((Integer) zzww.zzra().zzd(zzabq.zzczq)).intValue(), (String) zzww.zzra().zzd(zzabq.zzczl), (String) zzww.zzra().zzd(zzabq.zzczm), (String) zzww.zzra().zzd(zzabq.zzczo));
        }
    }

    public static boolean zzaxd() {
        return ((Boolean) zzww.zzra().zzd(zzabq.zzcyy)).booleanValue();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzhqn);
        SafeParcelWriter.writeInt(parcel, 2, this.zzhqp);
        SafeParcelWriter.writeInt(parcel, 3, this.zzhqq);
        SafeParcelWriter.writeInt(parcel, 4, this.zzhqr);
        SafeParcelWriter.writeString(parcel, 5, this.zzhqs, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzhqt);
        SafeParcelWriter.writeInt(parcel, 7, this.zzhqv);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
