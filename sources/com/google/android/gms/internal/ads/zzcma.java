package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcma {
    private final Map<String, String> zzdcn = new ConcurrentHashMap();
    private final /* synthetic */ zzcmb zzgoe;

    zzcma(zzcmb zzcmb) {
        this.zzgoe = zzcmb;
    }

    /* access modifiers changed from: private */
    public final zzcma zzarl() {
        this.zzdcn.putAll(this.zzgoe.zzgof);
        return this;
    }

    public final zzcma zza(zzdoy zzdoy) {
        this.zzdcn.put("gqi", zzdoy.zzbwe);
        return this;
    }

    public final zzcma zzc(zzdot zzdot) {
        this.zzdcn.put("aai", zzdot.zzdnw);
        return this;
    }

    public final zzcma zzs(String str, String str2) {
        this.zzdcn.put(str, str2);
        return this;
    }

    public final void zzarm() {
        this.zzgoe.executor.execute(new zzcmd(this));
    }

    public final String zzarn() {
        return this.zzgoe.zzgob.zzp(this.zzdcn);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaro() {
        this.zzgoe.zzgob.zzo(this.zzdcn);
    }
}
