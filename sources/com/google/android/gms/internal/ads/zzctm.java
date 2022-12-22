package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.overlay.zzx;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzctm implements zzcbr {
    private final zzbar zzbpj;
    private final zzdpm zzfzg;
    private final zzdot zzghi;
    private final zzail zzgvp;
    private final boolean zzgvq;
    private final zzebt<zzbmr> zzgvx;
    private final zzbfi zzgvy;

    zzctm(zzbar zzbar, zzebt<zzbmr> zzebt, zzdot zzdot, zzbfi zzbfi, zzdpm zzdpm, boolean z, zzail zzail) {
        this.zzbpj = zzbar;
        this.zzgvx = zzebt;
        this.zzghi = zzdot;
        this.zzgvy = zzbfi;
        this.zzfzg = zzdpm;
        this.zzgvq = z;
        this.zzgvp = zzail;
    }

    public final void zza(boolean z, Context context) {
        int i;
        int i2;
        zzbmr zzbmr = (zzbmr) zzebh.zzb(this.zzgvx);
        this.zzgvy.zzbe(true);
        zzk zzk = new zzk(this.zzgvq ? this.zzgvp.zzad(true) : true, true, this.zzgvq ? this.zzgvp.zzui() : false, this.zzgvq ? this.zzgvp.zzuj() : 0.0f, -1, z, this.zzghi.zzfvy, false);
        zzr.zzku();
        zzcbh zzahz = zzbmr.zzahz();
        zzbfi zzbfi = this.zzgvy;
        if (this.zzghi.zzhmq != -1) {
            i2 = this.zzghi.zzhmq;
        } else {
            if (this.zzfzg.zzhob != null) {
                if (this.zzfzg.zzhob.orientation == 1) {
                    i = 7;
                } else if (this.zzfzg.zzhob.orientation == 2) {
                    i = 6;
                }
                AdOverlayInfoParcel adOverlayInfoParcel = r4;
                AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel((zzve) null, (zzp) zzahz, (zzx) null, zzbfi, i, this.zzbpj, this.zzghi.zzdxn, zzk, this.zzghi.zzhmh.zzdug, this.zzghi.zzhmh.zzdui, this.zzfzg.zzhny);
                zzo.zza(context, adOverlayInfoParcel, true);
            }
            zzd.zzdz("Error setting app open orientation; no targeting orientation available.");
            i2 = this.zzghi.zzhmq;
        }
        i = i2;
        AdOverlayInfoParcel adOverlayInfoParcel3 = adOverlayInfoParcel2;
        AdOverlayInfoParcel adOverlayInfoParcel22 = new AdOverlayInfoParcel((zzve) null, (zzp) zzahz, (zzx) null, zzbfi, i, this.zzbpj, this.zzghi.zzdxn, zzk, this.zzghi.zzhmh.zzdug, this.zzghi.zzhmh.zzdui, this.zzfzg.zzhny);
        zzo.zza(context, adOverlayInfoParcel3, true);
    }
}
