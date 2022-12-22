package com.google.android.gms.internal.consent_sdk;

import android.os.Handler;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzbi implements zzcp<zzbe> {
    private final zzct<zzbh> zza;
    private final zzct<Handler> zzb;
    private final zzct<zzbj> zzc;

    public zzbi(zzct<zzbh> zzct, zzct<Handler> zzct2, zzct<zzbj> zzct3) {
        this.zza = zzct;
        this.zzb = zzct2;
        this.zzc = zzct3;
    }

    public final /* synthetic */ Object zza() {
        return new zzbe(this.zza.zza(), this.zzb.zza(), this.zzc.zza());
    }
}
