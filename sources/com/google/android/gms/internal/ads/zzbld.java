package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbld {
    /* access modifiers changed from: private */
    public final Executor executor;
    private final String zzbry;
    private final zzamx zzfug;
    /* access modifiers changed from: private */
    public zzbli zzfuh;
    private final zzaig<Object> zzfui = new zzblc(this);
    private final zzaig<Object> zzfuj = new zzble(this);

    public zzbld(String str, zzamx zzamx, Executor executor2) {
        this.zzbry = str;
        this.zzfug = zzamx;
        this.executor = executor2;
    }

    public final void zza(zzbli zzbli) {
        this.zzfug.zzc("/updateActiveView", this.zzfui);
        this.zzfug.zzc("/untrackActiveViewUnit", this.zzfuj);
        this.zzfuh = zzbli;
    }

    public final void zza(zzbfi zzbfi) {
        zzbfi.zza("/updateActiveView", (zzaig<? super zzbfi>) this.zzfui);
        zzbfi.zza("/untrackActiveViewUnit", (zzaig<? super zzbfi>) this.zzfuj);
    }

    public final void zzb(zzbfi zzbfi) {
        zzbfi.zzb("/updateActiveView", this.zzfui);
        zzbfi.zzb("/untrackActiveViewUnit", this.zzfuj);
    }

    public final void zzajr() {
        this.zzfug.zzd("/updateActiveView", this.zzfui);
        this.zzfug.zzd("/untrackActiveViewUnit", this.zzfuj);
    }

    /* access modifiers changed from: private */
    public final boolean zzn(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = map.get("hashCode");
        if (TextUtils.isEmpty(str) || !str.equals(this.zzbry)) {
            return false;
        }
        return true;
    }
}
