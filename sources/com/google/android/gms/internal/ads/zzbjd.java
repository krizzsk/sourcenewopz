package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbjd implements zzdoo {
    private final /* synthetic */ zzbie zzfhy;
    private Context zzfob;
    private String zzfoc;

    private zzbjd(zzbie zzbie) {
        this.zzfhy = zzbie;
    }

    public final zzdol zzaiv() {
        zzesg.zza(this.zzfob, Context.class);
        return new zzbjg(this.zzfhy, this.zzfob, this.zzfoc);
    }

    public final /* synthetic */ zzdoo zzfs(String str) {
        this.zzfoc = str;
        return this;
    }

    public final /* synthetic */ zzdoo zzcd(Context context) {
        this.zzfob = (Context) zzesg.checkNotNull(context);
        return this;
    }
}
