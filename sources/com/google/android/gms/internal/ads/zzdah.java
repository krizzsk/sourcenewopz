package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdah implements zzbvb {
    private final AtomicReference<zzyx> zzhbf = new AtomicReference<>();

    public final void zzc(zzyx zzyx) {
        this.zzhbf.set(zzyx);
    }

    public final void zzb(zzvv zzvv) {
        zzdlx.zza(this.zzhbf, new zzdag(zzvv));
    }
}
