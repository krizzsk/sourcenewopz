package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdmt implements zzebi<zzcaj> {
    private final /* synthetic */ zzdav zzhcc;
    private final /* synthetic */ zzcbj zzhkw;
    final /* synthetic */ zzdmr zzhkx;

    zzdmt(zzdmr zzdmr, zzdav zzdav, zzcbj zzcbj) {
        this.zzhkx = zzdmr;
        this.zzhcc = zzdav;
        this.zzhkw = zzcbj;
    }

    public final void zzb(Throwable th) {
        zzvh zze = this.zzhkw.zzahd().zze(th);
        synchronized (this.zzhkx) {
            zzebt unused = this.zzhkx.zzhjl = null;
            this.zzhkw.zzahe().zzd(zze);
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdau)).booleanValue()) {
                this.zzhkx.zzfur.execute(new zzdmy(this, zze));
                this.zzhkx.zzfur.execute(new zzdmx(this, zze));
            }
            zzdqa.zza(zze.errorCode, th, "InterstitialAdLoader.onFailure");
            this.zzhcc.zzatg();
        }
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzcaj zzcaj = (zzcaj) obj;
        synchronized (this.zzhkx) {
            zzebt unused = this.zzhkx.zzhjl = null;
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdau)).booleanValue()) {
                zzcaj.zzaln().zza(this.zzhkx.zzhas).zza(this.zzhkx.zzhkv);
            }
            this.zzhcc.onSuccess(zzcaj);
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdau)).booleanValue()) {
                this.zzhkx.zzfur.execute(new zzdmw(this));
                this.zzhkx.zzfur.execute(new zzdmv(this));
            }
        }
    }
}
