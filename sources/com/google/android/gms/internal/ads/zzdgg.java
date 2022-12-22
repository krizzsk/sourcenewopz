package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdgg implements zzdhe<zzdgd> {
    private final Context context;
    private final ScheduledExecutorService zzftq;
    private final zzdpm zzfzg;
    private final zzebs zzgka;
    private final zzcyz zzgyz;
    private String zzhcu;
    private final zzczb zzhfr;

    public zzdgg(zzebs zzebs, ScheduledExecutorService scheduledExecutorService, String str, zzczb zzczb, Context context2, zzdpm zzdpm, zzcyz zzcyz) {
        this.zzgka = zzebs;
        this.zzftq = scheduledExecutorService;
        this.zzhcu = str;
        this.zzhfr = zzczb;
        this.context = context2;
        this.zzfzg = zzdpm;
        this.zzgyz = zzcyz;
    }

    public final zzebt<zzdgd> zzatu() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcro)).booleanValue()) {
            return zzebh.zza(new zzdgf(this), (Executor) this.zzgka);
        }
        return zzebh.zzag(null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(String str, List list, Bundle bundle) throws Exception {
        zzbbe zzbbe = new zzbbe();
        this.zzgyz.zzgo(str);
        zzaqa zzgp = this.zzgyz.zzgp(str);
        if (zzgp != null) {
            Bundle bundle2 = bundle;
            zzgp.zza(ObjectWrapper.wrap(this.context), this.zzhcu, bundle2, (Bundle) list.get(0), this.zzfzg.zzbpy, (zzaqf) new zzczh(str, zzgp, zzbbe));
            return zzbbe;
        }
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzaul() {
        Map<String, List<Bundle>> zzu = this.zzhfr.zzu(this.zzhcu, this.zzfzg.zzhny);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : zzu.entrySet()) {
            String str = (String) next.getKey();
            arrayList.add(zzebc.zzg(zzebh.zza(new zzdgi(this, str, (List) next.getValue(), this.zzfzg.zzhnx.zzcih != null ? this.zzfzg.zzhnx.zzcih.getBundle(str) : null), (Executor) this.zzgka)).zza(((Long) zzww.zzra().zzd(zzabq.zzcrn)).longValue(), TimeUnit.MILLISECONDS, this.zzftq).zza(Throwable.class, new zzdgh(str), (Executor) this.zzgka));
        }
        return zzebh.zzk(arrayList).zzb(new zzdgk(arrayList), this.zzgka);
    }
}
