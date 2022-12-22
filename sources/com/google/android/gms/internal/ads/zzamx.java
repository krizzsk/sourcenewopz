package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzamx {
    private zzale zzdmm;
    private zzebt<zzamc> zzdmn;

    zzamx(zzale zzale) {
        this.zzdmm = zzale;
    }

    private final void zzvc() {
        if (this.zzdmn == null) {
            zzbbe zzbbe = new zzbbe();
            this.zzdmn = zzbbe;
            this.zzdmm.zzb((zzei) null).zza(new zzamw(zzbbe), new zzamz(zzbbe));
        }
    }

    public final <I, O> zzana<I, O> zzb(String str, zzaml<I> zzaml, zzami<O> zzami) {
        zzvc();
        return new zzana<>(this.zzdmn, str, zzaml, zzami);
    }

    public final void zzc(String str, zzaig<? super zzamc> zzaig) {
        zzvc();
        this.zzdmn = zzebh.zzb(this.zzdmn, new zzamy(str, zzaig), (Executor) zzbat.zzekj);
    }

    public final void zzd(String str, zzaig<? super zzamc> zzaig) {
        this.zzdmn = zzebh.zzb(this.zzdmn, new zzanb(str, zzaig), (Executor) zzbat.zzekj);
    }
}
