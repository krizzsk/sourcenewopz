package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzar;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzamo {
    private static final zzar<zzakv> zzdmc = new zzamr();
    private static final zzar<zzakv> zzdmd = new zzamq();
    private final zzale zzdme;

    public zzamo(Context context, zzbar zzbar, String str) {
        this.zzdme = new zzale(context, zzbar, str, zzdmc, zzdmd);
    }

    public final <I, O> zzamg<I, O> zza(String str, zzaml<I> zzaml, zzami<O> zzami) {
        return new zzamt(this.zzdme, str, zzaml, zzami);
    }

    public final zzamx zzvb() {
        return new zzamx(this.zzdme);
    }
}
