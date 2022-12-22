package com.google.android.gms.ads.internal.overlay;

import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.util.zza;
import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzj extends zza {
    final /* synthetic */ zze zzdtu;

    private zzj(zze zze) {
        this.zzdtu = zze;
    }

    public final void zzwp() {
        Bitmap zza = zzr.zzlo().zza(Integer.valueOf(this.zzdtu.zzdtb.zzdum.zzbpt));
        if (zza != null) {
            com.google.android.gms.ads.internal.util.zzj.zzegq.post(new zzm(this, zzr.zzkx().zza(this.zzdtu.zzaax, zza, this.zzdtu.zzdtb.zzdum.zzbpr, this.zzdtu.zzdtb.zzdum.zzbps)));
        }
    }
}
