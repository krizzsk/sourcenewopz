package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.overlay.zzx;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcvd implements zzcbr {
    private final Context context;
    private final zzbar zzbpj;
    private final zzdpm zzfzg;
    private final zzdot zzghi;
    private final zzail zzgvp;
    private final boolean zzgvq;
    private final zzebt<zzcal> zzgvx;
    private final zzbfi zzgvy;

    private zzcvd(Context context2, zzbar zzbar, zzebt<zzcal> zzebt, zzdot zzdot, zzbfi zzbfi, zzdpm zzdpm, boolean z, zzail zzail) {
        this.context = context2;
        this.zzbpj = zzbar;
        this.zzgvx = zzebt;
        this.zzghi = zzdot;
        this.zzgvy = zzbfi;
        this.zzfzg = zzdpm;
        this.zzgvp = zzail;
        this.zzgvq = z;
    }

    public final void zza(boolean z, Context context2) {
        zzcal zzcal = (zzcal) zzebh.zzb(this.zzgvx);
        this.zzgvy.zzbe(true);
        boolean zzad = this.zzgvq ? this.zzgvp.zzad(false) : false;
        zzr.zzkv();
        zzk zzk = new zzk(zzad, zzj.zzba(this.context), this.zzgvq ? this.zzgvp.zzui() : false, this.zzgvq ? this.zzgvp.zzuj() : 0.0f, -1, z, this.zzghi.zzfvy, false);
        zzr.zzku();
        AdOverlayInfoParcel adOverlayInfoParcel = r4;
        AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel((zzve) null, (zzp) zzcal.zzahz(), (zzx) null, this.zzgvy, this.zzghi.zzhmq, this.zzbpj, this.zzghi.zzdxn, zzk, this.zzghi.zzhmh.zzdug, this.zzghi.zzhmh.zzdui, this.zzfzg.zzhny);
        zzo.zza(context2, adOverlayInfoParcel, true);
    }
}
