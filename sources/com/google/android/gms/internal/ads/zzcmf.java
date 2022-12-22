package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcmf implements zzdtm {
    private final Clock zzbqq;
    private final Map<zzdth, Long> zzgoj = new HashMap();
    private final zzclz zzgok;
    private final Map<zzdth, zzcme> zzgol = new HashMap();

    public zzcmf(zzclz zzclz, Set<zzcme> set, Clock clock) {
        this.zzgok = zzclz;
        for (zzcme next : set) {
            this.zzgol.put(next.zzgoi, next);
        }
        this.zzbqq = clock;
    }

    public final void zza(zzdth zzdth, String str) {
    }

    public final void zzb(zzdth zzdth, String str) {
        this.zzgoj.put(zzdth, Long.valueOf(this.zzbqq.elapsedRealtime()));
    }

    public final void zza(zzdth zzdth, String str, Throwable th) {
        if (this.zzgoj.containsKey(zzdth)) {
            long elapsedRealtime = this.zzbqq.elapsedRealtime() - this.zzgoj.get(zzdth).longValue();
            Map<String, String> zzsx = this.zzgok.zzsx();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzsx.put(concat, valueOf2.length() != 0 ? "f.".concat(valueOf2) : new String("f."));
        }
        if (this.zzgol.containsKey(zzdth)) {
            zza(zzdth, false);
        }
    }

    public final void zzc(zzdth zzdth, String str) {
        if (this.zzgoj.containsKey(zzdth)) {
            long elapsedRealtime = this.zzbqq.elapsedRealtime() - this.zzgoj.get(zzdth).longValue();
            Map<String, String> zzsx = this.zzgok.zzsx();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzsx.put(concat, valueOf2.length() != 0 ? "s.".concat(valueOf2) : new String("s."));
        }
        if (this.zzgol.containsKey(zzdth)) {
            zza(zzdth, true);
        }
    }

    private final void zza(zzdth zzdth, boolean z) {
        zzdth zzb = this.zzgol.get(zzdth).zzgoh;
        String str = z ? "s." : "f.";
        if (this.zzgoj.containsKey(zzb)) {
            long elapsedRealtime = this.zzbqq.elapsedRealtime() - this.zzgoj.get(zzb).longValue();
            Map<String, String> zzsx = this.zzgok.zzsx();
            String valueOf = String.valueOf(this.zzgol.get(zzdth).label);
            String concat = valueOf.length() != 0 ? "label.".concat(valueOf) : new String("label.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzsx.put(concat, valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
        }
    }
}
