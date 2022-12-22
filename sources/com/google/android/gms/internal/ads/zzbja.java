package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbja implements zzcbi {
    private zzbsj zzfbg;
    private zzdpi zzfbh;
    private zzdmp zzfbk;
    private zzdlr zzfbl;
    private zzbxr zzfbo;
    private final /* synthetic */ zzbie zzfhy;
    private zzcyo zzfon;

    private zzbja(zzbie zzbie) {
        this.zzfhy = zzbie;
    }

    /* renamed from: zzair */
    public final zzcbj zzahg() {
        zzesg.zza(this.zzfbo, zzbxr.class);
        zzesg.zza(this.zzfbg, zzbsj.class);
        zzesg.zza(this.zzfon, zzcyo.class);
        return new zzbiz(this.zzfhy, new zzbqi(), new zzdqk(), new zzbrt(), new zzcmo(), this.zzfbo, this.zzfbg, new zzdqo(), this.zzfon, this.zzfbh, this.zzfbk, this.zzfbl);
    }

    public final /* synthetic */ zzcbi zzb(zzcyo zzcyo) {
        this.zzfon = (zzcyo) zzesg.checkNotNull(zzcyo);
        return this;
    }

    public final /* synthetic */ zzcbi zze(zzbsj zzbsj) {
        this.zzfbg = (zzbsj) zzesg.checkNotNull(zzbsj);
        return this;
    }

    public final /* synthetic */ zzcbi zze(zzbxr zzbxr) {
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
