package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
final class zzfx implements Runnable {
    final /* synthetic */ zzaa zza;
    final /* synthetic */ zzgm zzb;

    zzfx(zzgm zzgm, zzaa zzaa) {
        this.zzb = zzgm;
        this.zza = zzaa;
    }

    public final void run() {
        this.zzb.zza.zzG();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zzR(this.zza);
        } else {
            this.zzb.zza.zzP(this.zza);
        }
    }
}
