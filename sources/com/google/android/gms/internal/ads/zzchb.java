package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzchb {
    private final Executor zzfur;
    private final zzbzk zzget;
    private final zzblv zzgky;

    zzchb(Executor executor, zzblv zzblv, zzbzk zzbzk) {
        this.zzfur = executor;
        this.zzget = zzbzk;
        this.zzgky = zzblv;
    }

    public final void zzi(zzbfi zzbfi) {
        if (zzbfi != null) {
            this.zzget.zzv(zzbfi.getView());
            this.zzget.zza(new zzcha(zzbfi), this.zzfur);
            this.zzget.zza(new zzchd(zzbfi), this.zzfur);
            this.zzget.zza(this.zzgky, this.zzfur);
            this.zzgky.zzd(zzbfi);
            zzbfi.zza("/trackActiveViewUnit", (zzaig<? super zzbfi>) new zzchc(this));
            zzbfi.zza("/untrackActiveViewUnit", (zzaig<? super zzbfi>) new zzchf(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzbfi zzbfi, Map map) {
        this.zzgky.disable();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzbfi zzbfi, Map map) {
        this.zzgky.enable();
    }
}
