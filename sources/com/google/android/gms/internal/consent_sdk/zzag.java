package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzag extends zzc {
    /* access modifiers changed from: private */
    public zzct<Application> zza;
    /* access modifiers changed from: private */
    public zzct<zzal> zzb;
    /* access modifiers changed from: private */
    public zzct<zzab> zzc;
    private zzct<zzau> zzd;
    private zzct<zzaz> zze;
    private zzct<zzb> zzf;
    private zzct<zzn> zzg;
    /* access modifiers changed from: private */
    public zzct<zze> zzh;
    /* access modifiers changed from: private */
    public zzct<zzaj> zzi;
    private zzct<zzz> zzj;
    private zzct<zzp> zzk;
    private zzct<zzj> zzl;

    private zzag(Application application) {
        zzcp zza2 = zzcs.zza(application);
        this.zza = zza2;
        this.zzb = zzcq.zza(new zzao(zza2));
        this.zzc = zzcq.zza(zzad.zza);
        zzaf zzaf = new zzaf(this);
        this.zzd = zzaf;
        this.zze = zzcq.zza(new zzbc(zzaf));
        zzd zzd2 = new zzd(this.zza);
        this.zzf = zzd2;
        this.zzg = new zzq(this.zza, zzd2, this.zzb);
        this.zzh = zzcq.zza(new zzh(zzas.zza));
        zzam zzam = new zzam(this.zza, this.zzb, zzas.zza);
        this.zzi = zzam;
        this.zzj = new zzac(this.zzh, zzam, this.zzb);
        zzv zzv = new zzv(this.zza, this.zzc, zzaq.zza, zzas.zza, this.zzb, this.zze, this.zzg, this.zzj, this.zzh);
        this.zzk = zzv;
        this.zzl = zzcq.zza(new zzm(this.zzb, zzv, this.zze));
    }

    public final zzj zza() {
        return this.zzl.zza();
    }

    public final zzaz zzb() {
        return this.zze.zza();
    }

    /* synthetic */ zzag(Application application, zzaf zzaf) {
        this(application);
    }
}
