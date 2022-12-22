package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbpt implements zzebi<zzbpc> {
    private final /* synthetic */ zzebi zzfyz;
    private final /* synthetic */ zzbpn zzfza;

    zzbpt(zzbpn zzbpn, zzebi zzebi) {
        this.zzfza = zzbpn;
        this.zzfyz = zzebi;
    }

    public final void zzb(Throwable th) {
        this.zzfza.zzalo();
        this.zzfyz.zzb(th);
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zzfza.zzalo();
        this.zzfyz.onSuccess((zzbpc) obj);
    }
}
