package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbpq implements zzebi<zzbpi> {
    private final /* synthetic */ zzebi zzfyz;
    private final /* synthetic */ zzbpn zzfza;

    zzbpq(zzbpn zzbpn, zzebi zzebi) {
        this.zzfza = zzbpn;
        this.zzfyz = zzebi;
    }

    public final void zzb(Throwable th) {
        this.zzfyz.zzb(th);
        this.zzfza.zzalo();
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zzfza.zza(((zzbpi) obj).zzfys, this.zzfyz);
    }
}
