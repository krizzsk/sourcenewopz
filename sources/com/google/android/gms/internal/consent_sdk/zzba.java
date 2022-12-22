package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzba implements zzcp<zzat> {
    private final zzct<Application> zza;
    private final zzct<zzab> zzb;
    private final zzct<zzbh> zzc;
    private final zzct<zzal> zzd;
    private final zzct<zzbb> zze;
    private final zzct<zzbe> zzf;

    public zzba(zzct<Application> zzct, zzct<zzab> zzct2, zzct<zzbh> zzct3, zzct<zzal> zzct4, zzct<zzbb> zzct5, zzct<zzbe> zzct6) {
        this.zza = zzct;
        this.zzb = zzct2;
        this.zzc = zzct3;
        this.zzd = zzct4;
        this.zze = zzct5;
        this.zzf = zzct6;
    }

    public final /* synthetic */ Object zza() {
        return new zzat(this.zza.zza(), this.zzb.zza(), this.zzc.zza(), this.zzd.zza(), this.zze.zza(), this.zzf);
    }
}
