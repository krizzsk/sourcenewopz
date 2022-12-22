package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbva extends zzbxq<zzbvb> implements zzbtq, zzbus {
    private final zzdot zzftr;
    private AtomicBoolean zzgbw = new AtomicBoolean();

    public zzbva(Set<zzbzl<zzbvb>> set, zzdot zzdot) {
        super(set);
        this.zzftr = zzdot;
    }

    public final void onAdImpression() {
        if (this.zzftr.zzhlz == 2 || this.zzftr.zzhlz == 5 || this.zzftr.zzhlz == 4 || this.zzftr.zzhlz == 6) {
            zzaml();
        }
    }

    public final void zzamk() {
        if (this.zzftr.zzhlz == 1) {
            zzaml();
        }
    }

    private final void zzaml() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdae)).booleanValue() && this.zzgbw.compareAndSet(false, true) && this.zzftr.zzhmw != null && this.zzftr.zzhmw.type == 3) {
            zza(new zzbuz(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbvb zzbvb) throws Exception {
        zzbvb.zzb(this.zzftr.zzhmw);
    }
}
