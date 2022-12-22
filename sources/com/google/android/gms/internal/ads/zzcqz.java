package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.zzr;
import xcrash.TombstoneParser;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcqz implements zzbyw {
    private final zzdtw zzdjf;
    private final zzf zzeci;
    private boolean zzgos = false;
    private boolean zzgot = false;
    private final String zzgou;

    public zzcqz(String str, zzdtw zzdtw) {
        this.zzgou = str;
        this.zzdjf = zzdtw;
        this.zzeci = zzr.zzkz().zzyl();
    }

    public final void zzfu(String str) {
        this.zzdjf.zzb(zzgm("adapter_init_started").zzw("ancn", str));
    }

    public final void zzfv(String str) {
        this.zzdjf.zzb(zzgm("adapter_init_finished").zzw("ancn", str));
    }

    public final void zzn(String str, String str2) {
        this.zzdjf.zzb(zzgm("adapter_init_finished").zzw("ancn", str).zzw("rqe", str2));
    }

    public final synchronized void zzang() {
        if (!this.zzgos) {
            this.zzdjf.zzb(zzgm("init_started"));
            this.zzgos = true;
        }
    }

    public final synchronized void zzanh() {
        if (!this.zzgot) {
            this.zzdjf.zzb(zzgm("init_finished"));
            this.zzgot = true;
        }
    }

    private final zzdtx zzgm(String str) {
        return zzdtx.zzgy(str).zzw("tms", Long.toString(zzr.zzlc().elapsedRealtime(), 10)).zzw(TombstoneParser.keyThreadId, this.zzeci.zzzn() ? "" : this.zzgou);
    }
}
