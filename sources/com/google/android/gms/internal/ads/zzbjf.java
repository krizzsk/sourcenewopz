package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbjf implements zzciv {
    private zzbsj zzfbg;
    private zzdpi zzfbh;
    private zzdmp zzfbk;
    private zzdlr zzfbl;
    private zzbxr zzfbo;
    private final /* synthetic */ zzbie zzfhy;

    private zzbjf(zzbie zzbie) {
        this.zzfhy = zzbie;
    }

    /* renamed from: zzaix */
    public final zzcis zzahg() {
        zzesg.zza(this.zzfbo, zzbxr.class);
        zzesg.zza(this.zzfbg, zzbsj.class);
        return new zzbji(this.zzfhy, new zzbqi(), new zzdqk(), new zzbrt(), new zzcmo(), this.zzfbo, this.zzfbg, new zzdqo(), this.zzfbh, this.zzfbk, this.zzfbl);
    }

    public final /* synthetic */ zzciv zzf(zzbsj zzbsj) {
        this.zzfbg = (zzbsj) zzesg.checkNotNull(zzbsj);
        return this;
    }

    public final /* synthetic */ zzciv zzf(zzbxr zzbxr) {
        this.zzfbo = (zzbxr) zzesg.checkNotNull(zzbxr);
        return this;
    }

    public final /* synthetic */ zzbsg zza(zzdlr zzdlr) {
        this.zzfbl = zzdlr;
        return this;
    }

    public final /* synthetic */ zzbsg zza(zzdmp zzdmp) {
        this.zzfbk = zzdmp;
        return this;
    }

    public final /* synthetic */ zzbsg zza(zzdpi zzdpi) {
        this.zzfbh = zzdpi;
        return this;
    }
}
