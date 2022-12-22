package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzeny extends zzenx {
    private zzeny() {
        super();
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j) {
        zzenk zzc = zzc(obj, j);
        if (zzc.zzbhd()) {
            return zzc;
        }
        int size = zzc.size();
        zzenk zzgg = zzc.zzgg(size == 0 ? 10 : size << 1);
        zzeqg.zza(obj, j, (Object) zzgg);
        return zzgg;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzbhe();
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzenk zzc = zzc(obj, j);
        zzenk zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zzbhd()) {
                zzc = zzc.zzgg(size2 + size);
            }
            zzc.addAll(zzc2);
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzeqg.zza(obj, j, (Object) zzc2);
    }

    private static <E> zzenk<E> zzc(Object obj, long j) {
        return (zzenk) zzeqg.zzp(obj, j);
    }
}
