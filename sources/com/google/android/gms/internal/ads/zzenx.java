package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
abstract class zzenx {
    private static final zzenx zzivf = new zzenz();
    private static final zzenx zzivg = new zzeny();

    private zzenx() {
    }

    /* access modifiers changed from: package-private */
    public abstract <L> List<L> zza(Object obj, long j);

    /* access modifiers changed from: package-private */
    public abstract <L> void zza(Object obj, Object obj2, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzb(Object obj, long j);

    static zzenx zzbkn() {
        return zzivf;
    }

    static zzenx zzbko() {
        return zzivg;
    }
}
