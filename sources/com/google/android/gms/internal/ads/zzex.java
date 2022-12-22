package com.google.android.gms.internal.ads;

import android.view.View;
import com.didi.raven.config.RavenKey;
import com.google.android.gms.internal.ads.zzcf;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzex implements zzdwy {
    private final zzfj zzxo;
    private final zzduz zzys;
    private final zzdvl zzyt;
    private final zzfa zzyu;

    zzex(zzduz zzduz, zzdvl zzdvl, zzfj zzfj, zzfa zzfa) {
        this.zzys = zzduz;
        this.zzyt = zzdvl;
        this.zzxo = zzfj;
        this.zzyu = zzfa;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(View view) {
        this.zzxo.zze(view);
    }

    private final Map<String, Object> zzcc() {
        HashMap hashMap = new HashMap();
        zzcf.zza zzcp = this.zzyt.zzcp();
        hashMap.put(RavenKey.VERSION, this.zzys.zzayo());
        hashMap.put("gms", Boolean.valueOf(this.zzys.zzcn()));
        hashMap.put("int", zzcp.zzaf());
        hashMap.put("up", Boolean.valueOf(this.zzyu.zzcg()));
        hashMap.put(RavenKey.TYPE, new Throwable());
        return hashMap;
    }

    public final Map<String, Object> zzcd() {
        Map<String, Object> zzcc = zzcc();
        zzcf.zza zzayv = this.zzyt.zzayv();
        zzcc.put("gai", Boolean.valueOf(this.zzys.zzayp()));
        zzcc.put("did", zzayv.zzak());
        zzcc.put("dst", Integer.valueOf(zzayv.zzal().zzv()));
        zzcc.put("doo", Boolean.valueOf(zzayv.zzam()));
        return zzcc;
    }

    public final Map<String, Object> zzce() {
        return zzcc();
    }

    public final Map<String, Object> zzcf() {
        Map<String, Object> zzcc = zzcc();
        zzcc.put("lts", Long.valueOf(this.zzxo.zzcv()));
        return zzcc;
    }
}
