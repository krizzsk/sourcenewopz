package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdkc implements zzebi<AppOpenAd> {
    private final /* synthetic */ zzdav zzhcc;
    private final /* synthetic */ zzdke zzhiq;
    final /* synthetic */ zzdjx zzhir;

    zzdkc(zzdjx zzdjx, zzdav zzdav, zzdke zzdke) {
        this.zzhir = zzdjx;
        this.zzhcc = zzdav;
        this.zzhiq = zzdke;
    }

    public final void zzb(Throwable th) {
        zzvh zzvh;
        zzbmm zzbmm = (zzbmm) this.zzhir.zzhim.zzavm();
        if (zzbmm == null) {
            zzvh = zzdqh.zza(th, (zzctc) null);
        } else {
            zzvh = zzbmm.zzahd().zze(th);
        }
        synchronized (this.zzhir) {
            zzebt unused = this.zzhir.zzhin = null;
            if (zzbmm != null) {
                zzbmm.zzahe().zzd(zzvh);
                if (((Boolean) zzww.zzra().zzd(zzabq.zzdat)).booleanValue()) {
                    this.zzhir.zzfur.execute(new zzdkb(this, zzvh));
                }
            } else {
                this.zzhir.zzhil.zzd(zzvh);
                ((zzbmm) this.zzhir.zzb((zzdmk) this.zzhiq).zzahg()).zzahd().zzalw().zzamr();
            }
            zzdqa.zza(zzvh.errorCode, th, "AppOpenAdLoader.onFailure");
            this.zzhcc.zzatg();
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbpc zzbpc = (zzbpc) obj;
        synchronized (this.zzhir) {
            zzebt unused = this.zzhir.zzhin = null;
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdat)).booleanValue()) {
                zzbpc.zzaln().zza(this.zzhir.zzhil);
            }
            this.zzhcc.onSuccess(zzbpc);
        }
    }
}
