package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbjb implements zzdnc {
    private final /* synthetic */ zzbie zzfhy;
    private Context zzfob;
    private String zzfoc;
    private zzvt zzfqd;

    private zzbjb(zzbie zzbie) {
        this.zzfhy = zzbie;
    }

    public final zzdmz zzais() {
        zzesg.zza(this.zzfob, Context.class);
        zzesg.zza(this.zzfoc, String.class);
        zzesg.zza(this.zzfqd, zzvt.class);
        return new zzbje(this.zzfhy, this.zzfob, this.zzfoc, this.zzfqd);
    }

    public final /* synthetic */ zzdnc zzd(zzvt zzvt) {
        this.zzfqd = (zzvt) zzesg.checkNotNull(zzvt);
        return this;
    }

    public final /* synthetic */ zzdnc zzfr(String str) {
        this.zzfoc = (String) zzesg.checkNotNull(str);
        return this;
    }

    public final /* synthetic */ zzdnc zzcc(Context context) {
        this.zzfob = (Context) zzesg.checkNotNull(context);
        return this;
    }
}
