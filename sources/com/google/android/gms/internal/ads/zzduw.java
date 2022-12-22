package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbw;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final /* synthetic */ class zzduw implements Continuation {
    private final int zzehh;
    private final zzbw.zza.zzb zzhvp;

    zzduw(zzbw.zza.zzb zzb, int i) {
        this.zzhvp = zzb;
        this.zzehh = i;
    }

    public final Object then(Task task) {
        return zzduv.zza(this.zzhvp, this.zzehh, task);
    }
}
