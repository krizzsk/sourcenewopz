package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzq implements zzcp<zzn> {
    private final zzct<Application> zza;
    private final zzct<zzb> zzb;
    private final zzct<zzal> zzc;

    public zzq(zzct<Application> zzct, zzct<zzb> zzct2, zzct<zzal> zzct3) {
        this.zza = zzct;
        this.zzb = zzct2;
        this.zzc = zzct3;
    }

    public final /* synthetic */ Object zza() {
        return new zzn(this.zza.zza(), this.zzb.zza(), this.zzc.zza());
    }
}
