package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbsh;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdlz<RequestComponentT extends zzbsh<AdT>, AdT> implements zzdmh<RequestComponentT, AdT> {
    private RequestComponentT zzhjx;

    /* access modifiers changed from: private */
    /* renamed from: zzavn */
    public final synchronized RequestComponentT zzavm() {
        return this.zzhjx;
    }

    public final synchronized zzebt<AdT> zza(zzdmm zzdmm, zzdmj<RequestComponentT> zzdmj) {
        RequestComponentT requestcomponentt;
        requestcomponentt = (zzbsh) zzdmj.zzc(zzdmm.zzhku).zzahg();
        this.zzhjx = requestcomponentt;
        return requestcomponentt.zzahd().zzalv();
    }
}
