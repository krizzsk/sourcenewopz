package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.ads.zzbhg;
import com.google.android.gms.internal.ads.zzbjl;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzbhh implements zzbki {
    private static zzbhh zzeyh;

    /* access modifiers changed from: protected */
    public abstract zzdhw zza(zzdjb zzdjb);

    public abstract zzdtw zzafu();

    public abstract Executor zzafv();

    public abstract ScheduledExecutorService zzafw();

    public abstract Executor zzafx();

    public abstract zzebs zzafy();

    public abstract zzbve zzafz();

    public abstract zzckb zzaga();

    public abstract zzbjr zzagb();

    public abstract zzbod zzagc();

    public abstract zzdlh zzagd();

    public abstract zzbmj zzage();

    public abstract zzbms zzagf();

    public abstract zzdjy zzagg();

    public abstract zzcbi zzagh();

    public abstract zzdnc zzagi();

    public abstract zzcce zzagj();

    public abstract zzciv zzagk();

    public abstract zzdoo zzagl();

    public abstract zzdbc zzagm();

    public abstract zzdbf zzagn();

    public abstract zzcsr zzago();

    public abstract zzdqc<zzchu> zzagp();

    public static zzbhh zza(Context context, zzann zzann, int i) {
        zzbhh zzh = zzh(context, i);
        zzh.zzaga().zzb(zzann);
        return zzh;
    }

    @Deprecated
    public static zzbhh zzh(Context context, int i) {
        synchronized (zzbhh.class) {
            if (zzeyh == null) {
                return zza(new zzbar(204890000, i, true, false), context, (zzbjl.zza) new zzbib());
            }
            zzbhh zzbhh = zzeyh;
            return zzbhh;
        }
    }

    @Deprecated
    private static synchronized zzbhh zza(zzbar zzbar, Context context, zzbjl.zza zza) {
        zzbhh zzbhh;
        synchronized (zzbhh.class) {
            if (zzeyh == null) {
                zzeyh = new zzbix().zzc(new zzbhg(new zzbhg.zza().zza(zzbar).zzbz(context))).zza(new zzbjl(zza)).zzaip();
                zzabq.initialize(context);
                zzr.zzkz().zzd(context, zzbar);
                zzr.zzlb().initialize(context);
                zzr.zzkv().zzan(context);
                zzr.zzkv().zzao(context);
                zzb.zzam(context);
                zzr.zzky().initialize(context);
                zzr.zzlq().initialize(context);
                zzayt.zzaj(context);
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcyt)).booleanValue()) {
                    if (!((Boolean) zzww.zzra().zzd(zzabq.zzcph)).booleanValue()) {
                        zztz zztz = new zztz(new zzue(context));
                        zzcrl zzcrl = new zzcrl(new zzcrj(context), zzeyh.zzafy());
                        zzr.zzkv();
                        new zzcsb(context, zzbar, zztz, zzcrl, zzj.zzzr(), zzeyh.zzafu()).zzbo(zzr.zzkz().zzyl().zzzn());
                    }
                }
            }
            zzbhh = zzeyh;
        }
        return zzbhh;
    }

    public final zzdhw zza(zzauj zzauj, int i) {
        return zza(new zzdjb(zzauj, i));
    }
}
