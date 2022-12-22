package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcco implements zzaig<Object> {
    private WeakReference<zzccn> zzgfd;

    private zzcco(zzccn zzccn) {
        this.zzgfd = new WeakReference<>(zzccn);
    }

    public final void zza(Object obj, Map<String, String> map) {
        zzccn zzccn = (zzccn) this.zzgfd.get();
        if (zzccn != null) {
            zzccn.zzgeq.onAdClicked();
        }
    }
}
