package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbij implements zzbms {
    private zzbsj zzfbg;
    private zzdpi zzfbh;
    private zzdmp zzfbk;
    private zzdlr zzfbl;
    private zzbxr zzfbo;
    private final /* synthetic */ zzbie zzfhy;

    private zzbij(zzbie zzbie) {
        this.zzfhy = zzbie;
    }

    @Deprecated
    public final /* synthetic */ zzbms zzb(zzbnd zzbnd) {
        zzesg.checkNotNull(zzbnd);
        return this;
    }

    public final /* synthetic */ zzbms zzb(zzbsj zzbsj) {
        this.zzfbg = (zzbsj) zzesg.checkNotNull(zzbsj);
        return this;
    }

    public final /* synthetic */ zzbms zzb(zzbxr zzbxr) {
        this.zzfbo = (zzbxr) zzesg.checkNotNull(zzbxr);
        return this;
    }

    public final /* synthetic */ Object zzahg() {
        zzesg.zza(this.zzfbo, zzbxr.class);
        zzesg.zza(this.zzfbg, zzbsj.class);
        return new zzbim(this.zzfhy, new zzbqi(), new zzdqk(), new zzbrt(), new zzcmo(), this.zzfbo, this.zzfbg, new zzdqo(), this.zzfbh, this.zzfbk, this.zzfbl);
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
