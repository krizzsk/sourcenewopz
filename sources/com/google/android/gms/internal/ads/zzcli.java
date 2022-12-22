package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcli implements zzesa<Set<zzbzl<zzdtm>>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<Context> zzeyq;
    private final zzesn<String> zzgno;
    private final zzesn<Map<zzdth, zzcln>> zzgnp;

    public zzcli(zzesn<String> zzesn, zzesn<Context> zzesn2, zzesn<Executor> zzesn3, zzesn<Map<zzdth, zzcln>> zzesn4) {
        this.zzgno = zzesn;
        this.zzeyq = zzesn2;
        this.zzeyl = zzesn3;
        this.zzgnp = zzesn4;
    }

    public final /* synthetic */ Object get() {
        Set set;
        String str = this.zzgno.get();
        Context context = this.zzeyq.get();
        Executor executor = this.zzeyl.get();
        Map map = this.zzgnp.get();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcwb)).booleanValue()) {
            zztz zztz = new zztz(new zzue(context));
            zztz.zza((zzty) new zzclk(str));
            set = Collections.singleton(new zzbzl(new zzcll(zztz, map), executor));
        } else {
            set = Collections.emptySet();
        }
        return (Set) zzesg.zzbd(set);
    }
}
