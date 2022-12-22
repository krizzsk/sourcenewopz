package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbjk implements zzdbc {
    private zzbsj zzfbg;
    private final /* synthetic */ zzbie zzfhy;
    private zzdbs zzfsm;

    private zzbjk(zzbie zzbie) {
        this.zzfhy = zzbie;
    }

    public final zzdbd zzajg() {
        zzesg.zza(this.zzfbg, zzbsj.class);
        zzesg.zza(this.zzfsm, zzdbs.class);
        return new zzbjj(this.zzfhy, this.zzfsm, new zzbqi(), new zzcmo(), this.zzfbg, new zzdqo(), (zzdmp) null, (zzdlr) null, (zzbid) null);
    }

    @Deprecated
    public final /* synthetic */ zzdbc zzg(zzbxr zzbxr) {
        zzesg.checkNotNull(zzbxr);
        return this;
    }

    public final /* synthetic */ zzdbc zza(zzdbs zzdbs) {
        this.zzfsm = (zzdbs) zzesg.checkNotNull(zzdbs);
        return this;
    }

    public final /* synthetic */ zzdbc zzg(zzbsj zzbsj) {
        this.zzfbg = (zzbsj) zzesg.checkNotNull(zzbsj);
        return this;
    }
}
