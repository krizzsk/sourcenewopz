package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcmo {
    public static Set<zzbzl<zzbtp>> zza(zzcmy zzcmy, Executor executor) {
        return zzc(zzcmy, executor);
    }

    public static Set<zzbzl<AppEventListener>> zzb(zzcmy zzcmy, Executor executor) {
        return zzc(zzcmy, executor);
    }

    public static Set<zzbzl<zzbuj>> zzc(zzcmy zzcmy, Executor executor) {
        return zzc(zzcmy, executor);
    }

    public static Set<zzbzl<zzbsz>> zzd(zzcmy zzcmy, Executor executor) {
        return zzc(zzcmy, executor);
    }

    public static Set<zzbzl<zzbsy>> zze(zzcmy zzcmy, Executor executor) {
        return zzc(zzcmy, executor);
    }

    public static Set<zzbzl<zzbtq>> zzf(zzcmy zzcmy, Executor executor) {
        return zzc(zzcmy, executor);
    }

    public static Set<zzbzl<zzve>> zzg(zzcmy zzcmy, Executor executor) {
        return zzc(zzcmy, executor);
    }

    public static Set<zzbzl<zzdtm>> zzh(zzcmy zzcmy, Executor executor) {
        return zzc(zzcmy, executor);
    }

    public static Set<zzbzl<zzbvm>> zzi(zzcmy zzcmy, Executor executor) {
        return zzc(zzcmy, executor);
    }

    private static <T> Set<zzbzl<T>> zzc(T t, Executor executor) {
        if (zzadm.zzdfe.get().booleanValue()) {
            return Collections.singleton(new zzbzl(t, executor));
        }
        return Collections.emptySet();
    }
}
