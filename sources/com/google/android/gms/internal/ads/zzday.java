package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzday implements zzebi<zzbpc> {
    private final /* synthetic */ zzdav zzhcc;
    private final /* synthetic */ zzccf zzhcd;
    final /* synthetic */ zzdax zzhce;

    zzday(zzdax zzdax, zzdav zzdav, zzccf zzccf) {
        this.zzhce = zzdax;
        this.zzhcc = zzdav;
        this.zzhcd = zzccf;
    }

    public final void zzb(Throwable th) {
        zzvh zze = this.zzhcd.zzahd().zze(th);
        this.zzhcd.zzahe().zzd(zze);
        this.zzhce.zzgxu.zzafv().execute(new zzdba(this, zze));
        zzdqa.zza(zze.errorCode, th, "NativeAdLoader.onFailure");
        this.zzhcc.zzatg();
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbpc zzbpc = (zzbpc) obj;
        synchronized (this.zzhce) {
            zzbpc.zzaln().zza(this.zzhce.zzhca.zzatl());
            this.zzhcc.onSuccess(zzbpc);
            this.zzhce.zzgxu.zzafv().execute(new zzdbb(this));
        }
    }
}
