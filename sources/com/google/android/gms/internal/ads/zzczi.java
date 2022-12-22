package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzczi extends zzxm {
    private zzxc zzbqc;
    private final zzbhh zzgxu;
    private final Context zzham;
    private final zzdpo zzhan = new zzdpo();
    private final zzcea zzhao = new zzcea();

    public zzczi(zzbhh zzbhh, Context context, String str) {
        this.zzgxu = zzbhh;
        this.zzhan.zzgt(str);
        this.zzham = context;
    }

    public final zzxi zzrf() {
        zzcdy zzapk = this.zzhao.zzapk();
        this.zzhan.zzc(zzapk.zzapi());
        this.zzhan.zzd(zzapk.zzapj());
        zzdpo zzdpo = this.zzhan;
        if (zzdpo.zzkk() == null) {
            zzdpo.zzg(zzvt.zzqk());
        }
        return new zzczl(this.zzham, this.zzgxu, this.zzhan, zzapk, this.zzbqc);
    }

    public final void zzb(zzxc zzxc) {
        this.zzbqc = zzxc;
    }

    public final void zza(zzafs zzafs) {
        this.zzhao.zzb(zzafs);
    }

    public final void zza(zzagl zzagl) {
        this.zzhao.zzb(zzagl);
    }

    public final void zza(zzafx zzafx) {
        this.zzhao.zzb(zzafx);
    }

    public final void zza(String str, zzagd zzagd, zzafy zzafy) {
        this.zzhao.zzb(str, zzagd, zzafy);
    }

    public final void zza(zzaei zzaei) {
        this.zzhan.zzd(zzaei);
    }

    public final void zza(zzajy zzajy) {
        this.zzhan.zzb(zzajy);
    }

    public final void zza(zzakg zzakg) {
        this.zzhao.zzb(zzakg);
    }

    public final void zzb(zzye zzye) {
        this.zzhan.zzc(zzye);
    }

    public final void zza(zzagg zzagg, zzvt zzvt) {
        this.zzhao.zza(zzagg);
        this.zzhan.zzg(zzvt);
    }

    public final void zza(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzhan.zzb(publisherAdViewOptions);
    }

    public final void zza(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zzhan.zzb(adManagerAdViewOptions);
    }
}
