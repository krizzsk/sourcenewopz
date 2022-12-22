package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzdss<E> {
    /* access modifiers changed from: private */
    public static final zzebt<?> zzhsu = zzebh.zzag(null);
    /* access modifiers changed from: private */
    public final ScheduledExecutorService zzfvp;
    /* access modifiers changed from: private */
    public final zzebs zzgka;
    /* access modifiers changed from: private */
    public final zzdte<E> zzhsv;

    public zzdss(zzebs zzebs, ScheduledExecutorService scheduledExecutorService, zzdte<E> zzdte) {
        this.zzgka = zzebs;
        this.zzfvp = scheduledExecutorService;
        this.zzhsv = zzdte;
    }

    /* access modifiers changed from: protected */
    public abstract String zzu(E e);

    public final zzdsw zzt(E e) {
        return new zzdsw(this, e);
    }

    public final <I> zzdsy<I> zza(E e, zzebt<I> zzebt) {
        return new zzdsy(this, e, (String) null, zzebt, Collections.singletonList(zzebt), zzebt, (zzdsv) null);
    }

    public final zzdsu zza(E e, zzebt<?>... zzebtArr) {
        return new zzdsu(this, e, Arrays.asList(zzebtArr));
    }
}
