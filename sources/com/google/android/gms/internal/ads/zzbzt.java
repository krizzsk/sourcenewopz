package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbzt implements zzbzq {
    private final List<String> zzdxk;
    private final zzdup zzftn;
    private boolean zzgdj;

    public zzbzt(zzdot zzdot, zzdup zzdup) {
        this.zzdxk = zzdot.zzdxk;
        this.zzftn = zzdup;
    }

    public final void zzanl() {
        if (!this.zzgdj) {
            this.zzftn.zzk(this.zzdxk);
            this.zzgdj = true;
        }
    }
}
