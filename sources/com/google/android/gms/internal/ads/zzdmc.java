package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbsh;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdmc<RequestComponentT extends zzbsh<AdT>, AdT> implements zzdmh<RequestComponentT, AdT> {
    private RequestComponentT zzhjx;
    private final zzdmh<RequestComponentT, AdT> zzhkr;

    public zzdmc(zzdmh<RequestComponentT, AdT> zzdmh) {
        this.zzhkr = zzdmh;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzavn */
    public final synchronized RequestComponentT zzavm() {
        return this.zzhjx;
    }

    public final synchronized zzebt<AdT> zza(zzdmm zzdmm, zzdmj<RequestComponentT> zzdmj) {
        if (zzdmm.zzhkt != null) {
            RequestComponentT requestcomponentt = (zzbsh) zzdmj.zzc(zzdmm.zzhku).zzahg();
            this.zzhjx = requestcomponentt;
            return requestcomponentt.zzahd().zzb(zzdmm.zzhkt);
        }
        zzebt<AdT> zza = this.zzhkr.zza(zzdmm, zzdmj);
        this.zzhjx = (zzbsh) this.zzhkr.zzavm();
        return zza;
    }
}
