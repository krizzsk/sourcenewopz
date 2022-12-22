package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbiw implements zzbop {
    private zzesn<zzdot> zzfia;
    private zzesn<Set<zzbzl<zzbtp>>> zzfid;
    private zzesn<zzbts> zzfie;
    private zzesn<zzbvl> zzfif;
    private zzesn<zzdpi> zzfih;
    private zzesn<Set<zzbzl<zzbuj>>> zzfjm;
    private zzesn<zzbui> zzfjn;
    private zzesn<String> zzfkh;
    private zzesn<zzbsp> zzfki;
    private zzesn<zzbpf> zzfkj;
    private final /* synthetic */ zzbiu zzfpm;
    private final zzboo zzfqe;
    private zzesn<zzagm> zzfqf;
    private zzesn<Runnable> zzfqg;
    private zzesn<zzbok> zzfqh;

    private zzbiw(zzbiu zzbiu, zzbps zzbps, zzboo zzboo) {
        this.zzfpm = zzbiu;
        this.zzfqe = zzboo;
        this.zzfih = zzbpw.zze(zzbps);
        this.zzfia = zzbpv.zzc(zzbps);
        zzesj zzbnn = zzesj.zzau(0, 2).zzav(this.zzfpm.zzfgq).zzav(this.zzfpm.zzfgr).zzbnn();
        this.zzfid = zzbnn;
        this.zzfie = zzesb.zzas(zzbtv.zzj(zzbnn));
        zzesj zzbnn2 = zzesj.zzau(4, 3).zzau(this.zzfpm.zzfhf).zzau(this.zzfpm.zzfhg).zzau(this.zzfpm.zzfhh).zzav(this.zzfpm.zzfhi).zzav(this.zzfpm.zzfhj).zzav(this.zzfpm.zzfhk).zzau(this.zzfpm.zzfhl).zzbnn();
        this.zzfjm = zzbnn2;
        this.zzfjn = zzesb.zzas(zzbuk.zzl(zzbnn2));
        zzbpu zza = zzbpu.zza(zzbps);
        this.zzfkh = zza;
        this.zzfki = zzbss.zzm(this.zzfia, zza, this.zzfpm.zzfcq);
        this.zzfif = zzesb.zzas(zzbwr.zzamp());
        this.zzfkj = zzbqz.zza(this.zzfih, this.zzfia, this.zzfie, this.zzfjn, this.zzfpm.zzfht, this.zzfki, this.zzfif);
        this.zzfqf = new zzboq(zzboo);
        zzbor zzbor = new zzbor(zzboo);
        this.zzfqg = zzbor;
        this.zzfqh = zzesb.zzas(new zzbot(this.zzfkj, this.zzfqf, zzbor, this.zzfpm.zzfhy.zzezf));
    }

    public final zzbne zzaio() {
        return (zzbne) zzesg.zzbd(this.zzfqh.get());
    }
}
