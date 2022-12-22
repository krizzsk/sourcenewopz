package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbtl extends zzbxq<zzbtq> {
    private boolean zzgbq = false;

    public zzbtl(Set<zzbzl<zzbtq>> set) {
        super(set);
    }

    public final synchronized void onAdImpression() {
        if (!this.zzgbq) {
            zza(zzbto.zzgbn);
            this.zzgbq = true;
        }
    }
}
