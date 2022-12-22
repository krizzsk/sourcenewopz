package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbky implements zzebi<String> {
    private final /* synthetic */ zzbkz zzftp;

    zzbky(zzbkz zzbkz) {
        this.zzftp = zzbkz;
    }

    public final void zzb(Throwable th) {
        int i;
        zzdpu zze = this.zzftp.zzfts;
        List<String> zza = this.zzftp.zzftm.zza(this.zzftp.zzftl, this.zzftp.zzftr, false, "", "failure_click_attok", this.zzftp.zzftr.zzdna);
        zzr.zzkv();
        if (zzj.zzbd(this.zzftp.context)) {
            i = zzcse.zzgui;
        } else {
            i = zzcse.zzguh;
        }
        zze.zza(zza, i);
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        int i;
        zzdpu zze = this.zzftp.zzfts;
        List<String> zza = this.zzftp.zzftm.zza(this.zzftp.zzftl, this.zzftp.zzftr, false, "", (String) obj, this.zzftp.zzftr.zzdna);
        zzr.zzkv();
        if (zzj.zzbd(this.zzftp.context)) {
            i = zzcse.zzgui;
        } else {
            i = zzcse.zzguh;
        }
        zze.zza(zza, i);
    }
}
