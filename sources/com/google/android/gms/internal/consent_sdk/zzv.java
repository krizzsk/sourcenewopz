package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzv implements zzcp<zzp> {
    private final zzct<Application> zza;
    private final zzct<zzab> zzb;
    private final zzct<Handler> zzc;
    private final zzct<Executor> zzd;
    private final zzct<zzal> zze;
    private final zzct<zzaz> zzf;
    private final zzct<zzn> zzg;
    private final zzct<zzz> zzh;
    private final zzct<zze> zzi;

    public zzv(zzct<Application> zzct, zzct<zzab> zzct2, zzct<Handler> zzct3, zzct<Executor> zzct4, zzct<zzal> zzct5, zzct<zzaz> zzct6, zzct<zzn> zzct7, zzct<zzz> zzct8, zzct<zze> zzct9) {
        this.zza = zzct;
        this.zzb = zzct2;
        this.zzc = zzct3;
        this.zzd = zzct4;
        this.zze = zzct5;
        this.zzf = zzct6;
        this.zzg = zzct7;
        this.zzh = zzct8;
        this.zzi = zzct9;
    }

    public final /* synthetic */ Object zza() {
        zzn zza2 = this.zzg.zza();
        return new zzp(this.zza.zza(), this.zzb.zza(), this.zzc.zza(), this.zzd.zza(), this.zze.zza(), this.zzf.zza(), zza2, this.zzh.zza(), this.zzi.zza());
    }
}
