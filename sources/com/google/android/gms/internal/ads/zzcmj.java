package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzcmj {
    private final Executor executor;
    private final String zzdbu = zzadg.zzdec.get();
    private final boolean zzdcl;
    protected final zzbas zzeiw;
    protected final Map<String, String> zzgof = new HashMap();
    private final zzdug zzgoq;

    protected zzcmj(Executor executor2, zzbas zzbas, zzdug zzdug) {
        boolean z;
        this.executor = executor2;
        this.zzeiw = zzbas;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsd)).booleanValue()) {
            z = ((Boolean) zzww.zzra().zzd(zzabq.zzcse)).booleanValue();
        } else {
            z = ((double) zzww.zzrd().nextFloat()) <= zzadg.zzdeb.get().doubleValue();
        }
        this.zzdcl = z;
        this.zzgoq = zzdug;
    }

    /* access modifiers changed from: protected */
    public abstract void zzarr();

    public final void zzo(Map<String, String> map) {
        String zzp = zzp(map);
        if (this.zzdcl) {
            this.executor.execute(new zzcmi(this, zzp));
        }
        zzd.zzed(zzp);
    }

    /* access modifiers changed from: protected */
    public final String zzp(Map<String, String> map) {
        return this.zzgoq.zzr(map);
    }
}
