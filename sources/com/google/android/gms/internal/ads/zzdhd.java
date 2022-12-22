package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzr;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdhd<T> {
    private final Executor executor;
    private final Set<zzdhe<? extends zzdhb<T>>> zzhgm;

    public zzdhd(Executor executor2, Set<zzdhe<? extends zzdhb<T>>> set) {
        this.executor = executor2;
        this.zzhgm = set;
    }

    public final zzebt<T> zzs(T t) {
        ArrayList arrayList = new ArrayList(this.zzhgm.size());
        for (zzdhe next : this.zzhgm) {
            zzebt zzatu = next.zzatu();
            if (zzadm.zzdfe.get().booleanValue()) {
                zzatu.addListener(new zzdhg(next, zzr.zzlc().elapsedRealtime()), zzbat.zzekj);
            }
            arrayList.add(zzatu);
        }
        return zzebh.zzk(arrayList).zzb(new zzdhf(arrayList, t), this.executor);
    }
}
