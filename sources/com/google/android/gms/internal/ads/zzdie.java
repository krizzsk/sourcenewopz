package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdie implements zzesa<zzdic> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<Context> zzeyq;
    private final zzesn<zzaum> zzfad;
    private final zzesn<String> zzgaw;

    public zzdie(zzesn<zzaum> zzesn, zzesn<Context> zzesn2, zzesn<String> zzesn3, zzesn<zzebs> zzesn4) {
        this.zzfad = zzesn;
        this.zzeyq = zzesn2;
        this.zzgaw = zzesn3;
        this.zzeyl = zzesn4;
    }

    public final /* synthetic */ Object get() {
        return new zzdic(this.zzfad.get(), this.zzeyq.get(), this.zzgaw.get(), this.zzeyl.get());
    }
}
