package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzbat;
import com.google.android.gms.internal.ads.zzebt;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zza {
    /* access modifiers changed from: private */
    public volatile Thread thread;
    private final Runnable zzefm = new zzc(this);
    private boolean zzefn = false;

    public abstract void zzwp();

    public final zzebt<?> zzyx() {
        return zzbat.zzeke.zzg(this.zzefm);
    }
}
