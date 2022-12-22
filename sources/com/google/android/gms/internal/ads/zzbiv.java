package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbiv implements zzdlh {
    private final /* synthetic */ zzbie zzfhy;
    private Context zzfob;
    private String zzfoc;
    private zzvt zzfqd;

    private zzbiv(zzbie zzbie) {
        this.zzfhy = zzbie;
    }

    public final zzdli zzain() {
        zzesg.zza(this.zzfob, Context.class);
        zzesg.zza(this.zzfoc, String.class);
        zzesg.zza(this.zzfqd, zzvt.class);
        return new zzbiy(this.zzfhy, this.zzfob, this.zzfoc, this.zzfqd);
    }

    public final /* synthetic */ zzdlh zzc(zzvt zzvt) {
        this.zzfqd = (zzvt) zzesg.checkNotNull(zzvt);
        return this;
    }

    public final /* synthetic */ zzdlh zzfq(String str) {
        this.zzfoc = (String) zzesg.checkNotNull(str);
        return this;
    }

    public final /* synthetic */ zzdlh zzcb(Context context) {
        this.zzfob = (Context) zzesg.checkNotNull(context);
        return this;
    }
}
