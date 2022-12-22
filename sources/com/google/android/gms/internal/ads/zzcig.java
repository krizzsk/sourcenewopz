package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcig<T> implements zzaig<Object> {
    private final WeakReference<T> zzglu;
    private final String zzglv;
    private final zzaig<T> zzglw;
    private final /* synthetic */ zzchu zzglx;

    private zzcig(zzchu zzchu, WeakReference<T> weakReference, String str, zzaig<T> zzaig) {
        this.zzglx = zzchu;
        this.zzglu = weakReference;
        this.zzglv = str;
        this.zzglw = zzaig;
    }

    public final void zza(Object obj, Map<String, String> map) {
        Object obj2 = this.zzglu.get();
        if (obj2 == null) {
            this.zzglx.zzb(this.zzglv, this);
        } else {
            this.zzglw.zza(obj2, map);
        }
    }

    /* synthetic */ zzcig(zzchu zzchu, WeakReference weakReference, String str, zzaig zzaig, zzchz zzchz) {
        this(zzchu, weakReference, str, zzaig);
    }
}
