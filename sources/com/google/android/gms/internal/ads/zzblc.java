package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzblc implements zzaig<Object> {
    final /* synthetic */ zzbld zzfuf;

    zzblc(zzbld zzbld) {
        this.zzfuf = zzbld;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (this.zzfuf.zzn(map)) {
            this.zzfuf.executor.execute(new zzblf(this));
        }
    }
}
