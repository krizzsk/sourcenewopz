package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcrd implements zzdtm {
    private final zzdtx zzgsu;
    private final Map<zzdth, String> zzgsw = new HashMap();
    private final Map<zzdth, String> zzgsx = new HashMap();

    public zzcrd(Set<zzcrc> set, zzdtx zzdtx) {
        this.zzgsu = zzdtx;
        for (zzcrc next : set) {
            this.zzgsw.put(next.zzgoh, next.label);
            this.zzgsx.put(next.zzgoi, next.label);
        }
    }

    public final void zza(zzdth zzdth, String str) {
    }

    public final void zzb(zzdth zzdth, String str) {
        zzdtx zzdtx = this.zzgsu;
        String valueOf = String.valueOf(str);
        zzdtx.zzha(valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task."));
        if (this.zzgsw.containsKey(zzdth)) {
            zzdtx zzdtx2 = this.zzgsu;
            String valueOf2 = String.valueOf(this.zzgsw.get(zzdth));
            zzdtx2.zzha(valueOf2.length() != 0 ? "label.".concat(valueOf2) : new String("label."));
        }
    }

    public final void zza(zzdth zzdth, String str, Throwable th) {
        zzdtx zzdtx = this.zzgsu;
        String valueOf = String.valueOf(str);
        zzdtx.zzx(valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task."), "f.");
        if (this.zzgsx.containsKey(zzdth)) {
            zzdtx zzdtx2 = this.zzgsu;
            String valueOf2 = String.valueOf(this.zzgsx.get(zzdth));
            zzdtx2.zzx(valueOf2.length() != 0 ? "label.".concat(valueOf2) : new String("label."), "f.");
        }
    }

    public final void zzc(zzdth zzdth, String str) {
        zzdtx zzdtx = this.zzgsu;
        String valueOf = String.valueOf(str);
        zzdtx.zzx(valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task."), "s.");
        if (this.zzgsx.containsKey(zzdth)) {
            zzdtx zzdtx2 = this.zzgsu;
            String valueOf2 = String.valueOf(this.zzgsx.get(zzdth));
            zzdtx2.zzx(valueOf2.length() != 0 ? "label.".concat(valueOf2) : new String("label."), "s.");
        }
    }
}
