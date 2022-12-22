package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
final class zzak implements zzar {
    private zzct<zzbh> zza;
    private zzct<zzbb> zzb;
    private zzct<zzat> zzc;
    private zzct zzd;
    private zzct<zzbe> zze;
    private final /* synthetic */ zzag zzf;

    private zzak(zzag zzag, zzbb zzbb) {
        this.zzf = zzag;
        this.zza = zzcq.zza(new zzbk(this.zzf.zza));
        this.zzb = zzcs.zza(zzbb);
        this.zzc = new zzcn();
        this.zzd = new zzbo(this.zzf.zza, this.zza, zzaq.zza, zzas.zza, this.zzf.zzh, this.zzf.zzi, this.zzc);
        this.zze = new zzbi(this.zza, zzaq.zza, this.zzd);
        zzcn.zza(this.zzc, zzcq.zza(new zzba(this.zzf.zza, this.zzf.zzc, this.zza, this.zzf.zzb, this.zzb, this.zze)));
    }

    public final zzat zza() {
        return this.zzc.zza();
    }

    /* synthetic */ zzak(zzag zzag, zzbb zzbb, zzaf zzaf) {
        this(zzag, zzbb);
    }
}
