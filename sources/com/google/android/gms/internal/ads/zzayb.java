package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzayb implements zzays {
    private Context zzaai;
    private zzayd zzbrf;
    private zzf zzecu;

    private zzayb() {
    }

    public final zzayt zzxu() {
        zzesg.zza(this.zzaai, Context.class);
        zzesg.zza(this.zzecu, zzf.class);
        zzesg.zza(this.zzbrf, zzayd.class);
        return new zzaxz(this.zzaai, this.zzecu, this.zzbrf);
    }

    public final /* synthetic */ zzays zza(zzayd zzayd) {
        this.zzbrf = (zzayd) zzesg.checkNotNull(zzayd);
        return this;
    }

    public final /* synthetic */ zzays zza(zzf zzf) {
        this.zzecu = (zzf) zzesg.checkNotNull(zzf);
        return this;
    }

    public final /* synthetic */ zzays zzz(Context context) {
        this.zzaai = (Context) zzesg.checkNotNull(context);
        return this;
    }
}
