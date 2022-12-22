package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcjw {
    private final Map<String, zzcjx> zzgmt = new HashMap();

    zzcjw() {
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(String str, zzdqd zzdqd) {
        if (!this.zzgmt.containsKey(str)) {
            try {
                this.zzgmt.put(str, new zzcjx(str, zzdqd.zzvm(), zzdqd.zzvn()));
            } catch (zzdpq unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(String str, zzaqa zzaqa) {
        if (!this.zzgmt.containsKey(str)) {
            try {
                this.zzgmt.put(str, new zzcjx(str, zzaqa.zzvm(), zzaqa.zzvn()));
            } catch (Throwable unused) {
            }
        }
    }

    @Nullable
    private final synchronized zzcjx zzge(String str) {
        return this.zzgmt.get(str);
    }

    @Nullable
    public final zzcjx zzi(List<String> list) {
        for (String zzge : list) {
            zzcjx zzge2 = zzge(zzge);
            if (zzge2 != null) {
                return zzge2;
            }
        }
        return null;
    }
}
