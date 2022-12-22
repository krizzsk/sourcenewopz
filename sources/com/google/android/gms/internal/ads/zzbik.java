package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbik extends zzdhw {
    private zzesn<String> zzfbr;
    private zzesn<zzcln> zzfbt;
    private zzesn<Map<zzdth, zzcln>> zzfbv;
    private zzesn<Set<zzbzl<zzdtm>>> zzfbx;
    private zzesn<Set<zzbzl<zzdtm>>> zzfcl;
    private zzesn zzfcm;
    private zzesn<zzdtg> zzfcn;
    private final /* synthetic */ zzbie zzfhy;
    private final zzdjb zzfmc;
    private zzesn<Integer> zzfmd;
    private zzesn<zzdhs> zzfme;
    private zzesn<String> zzfmf;
    private zzesn<zzdic> zzfmg;
    private zzesn<zzdig> zzfmh;
    private zzesn<zzdim> zzfmi;
    private zzesn<zzdir> zzfmj;
    private zzesn<zzdja> zzfmk;
    private zzesn<zzdjm> zzfml;
    private zzesn<zzcln> zzfmm;
    private zzesn<zzcln> zzfmn;
    private zzesn<zzcln> zzfmo;

    private zzbik(zzbie zzbie, zzdjb zzdjb) {
        this.zzfhy = zzbie;
        this.zzfmc = zzdjb;
        this.zzfmd = new zzdjd(zzdjb);
        this.zzfme = new zzdht(zzbkg.zzfte, this.zzfhy.zzeyx, this.zzfhy.zzezd, zzdsg.zzaxv(), this.zzfmd);
        this.zzfmf = new zzdje(zzdjb);
        this.zzfmg = new zzdie(zzbhv.zzeyo, this.zzfhy.zzeyx, this.zzfmf, zzdsg.zzaxv());
        this.zzfmh = new zzdik(zzbkg.zzfte, this.zzfmd, this.zzfhy.zzeyx, this.zzfhy.zzfah, this.zzfhy.zzezd, zzdsg.zzaxv());
        this.zzfmi = new zzdio(zzbka.zzftb, zzdsg.zzaxv(), this.zzfhy.zzeyx);
        this.zzfmj = new zzdit(zzbkc.zzftc, zzdsg.zzaxv(), this.zzfmf);
        this.zzfmk = new zzdjc(zzbke.zzftd, this.zzfhy.zzezd, this.zzfhy.zzeyx);
        this.zzfml = new zzdjo(zzdsg.zzaxv());
        this.zzfbr = new zzdjg(zzdjb);
        this.zzfbt = zzesb.zzas(zzclc.zzarb());
        this.zzfmm = zzesb.zzas(zzcla.zzara());
        this.zzfmn = zzesb.zzas(zzcle.zzard());
        this.zzfmo = zzesb.zzas(zzclg.zzarf());
        this.zzfbv = ((zzese) ((zzese) ((zzese) ((zzese) zzesc.zzip(4).zza(zzdth.GMS_SIGNALS, this.zzfbt)).zza(zzdth.BUILD_URL, this.zzfmm)).zza(zzdth.HTTP, this.zzfmn)).zza(zzdth.PRE_PROCESS, this.zzfmo)).zzbnm();
        this.zzfbx = zzesb.zzas(new zzcli(this.zzfbr, this.zzfhy.zzeyx, zzdsg.zzaxv(), this.zzfbv));
        zzesj<Set<zzbzl<zzdtm>>> zzbnn = zzesj.zzau(0, 1).zzav(this.zzfbx).zzbnn();
        this.zzfcl = zzbnn;
        this.zzfcm = zzdto.zzar(zzbnn);
        this.zzfcn = zzesb.zzas(zzdtp.zzad(zzdsg.zzaxv(), this.zzfhy.zzezd, this.zzfcm));
    }

    private final zzdiv zzahs() {
        return new zzdiv((zzabd) zzesg.zzbd(new zzabd()), zzdsg.zzaxw(), (List) zzesg.zzbd(this.zzfmc.zzaux()));
    }

    private final zzdhy zzaht() {
        return new zzdhy(zzbkh.zzajq(), zzdsg.zzaxw(), (String) zzesg.zzbd(this.zzfmc.zzauv()), this.zzfmc.zzauw(), this.zzfmc.zzauz());
    }

    public final zzdhd<JSONObject> zzahu() {
        zzebs zzaxw = zzdsg.zzaxw();
        long longValue = ((Long) zzww.zzra().zzd(zzabq.zzcuq)).longValue();
        return zzdhi.zza(zzaxw, zzdzd.zza((zzdhe) zzesg.zzbd(new zzdfu(new zzdir(zzbkd.zzajm(), zzdsg.zzaxw(), zzdje.zzb(this.zzfmc)), 0, (ScheduledExecutorService) this.zzfhy.zzezd.get())), (zzdhe) zzesg.zzbd(new zzdfu(new zzdja(zzbkf.zzajo(), (ScheduledExecutorService) this.zzfhy.zzezd.get(), zzbhj.zza(this.zzfhy.zzeys)), longValue, (ScheduledExecutorService) this.zzfhy.zzezd.get())), (zzdhe) zzesg.zzbd(new zzdfu(new zzdhs(zzbkh.zzajq(), zzbhj.zza(this.zzfhy.zzeys), (ScheduledExecutorService) this.zzfhy.zzezd.get(), zzdsg.zzaxw(), this.zzfmc.zzauz()), 0, (ScheduledExecutorService) this.zzfhy.zzezd.get())), (zzdhe) zzesg.zzbd(new zzdfu(new zzdjm(zzdsg.zzaxw()), 0, (ScheduledExecutorService) this.zzfhy.zzezd.get())), (zzdhe) zzesg.zzbd(zzdjf.zzava()), new zzdic((zzaum) null, zzbhj.zza(this.zzfhy.zzeys), zzdje.zzb(this.zzfmc), zzdsg.zzaxw()), new zzdim(zzbkb.zzajk(), zzdsg.zzaxw(), zzbhj.zza(this.zzfhy.zzeys)), zzahs(), zzaht(), new zzdig(zzbkh.zzajq(), this.zzfmc.zzauz(), zzbhj.zza(this.zzfhy.zzeys), (zzazs) this.zzfhy.zzfah.get(), (ScheduledExecutorService) this.zzfhy.zzezd.get(), zzdsg.zzaxw()), (zzdhe) this.zzfhy.zzfbe.get()));
    }

    public final zzdhd<JSONObject> zzahv() {
        return zzdjk.zza(zzbkd.zzajm(), this.zzfhy.zzfbe.get(), zzaht(), zzahs(), zzesb.zzat(this.zzfme), zzesb.zzat(this.zzfmg), zzesb.zzat(this.zzfmh), zzesb.zzat(this.zzfmi), zzesb.zzat(this.zzfmj), zzesb.zzat(this.zzfmk), zzesb.zzat(this.zzfml), zzdsg.zzaxw(), (ScheduledExecutorService) this.zzfhy.zzezd.get());
    }

    public final zzdtg zzahw() {
        return this.zzfcn.get();
    }
}
