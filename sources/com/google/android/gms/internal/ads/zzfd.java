package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzfd implements Runnable {
    private final /* synthetic */ int zzzr;
    private final /* synthetic */ boolean zzzs;
    private final /* synthetic */ zzfc zzzt;

    zzfd(zzfc zzfc, int i, boolean z) {
        this.zzzt = zzfc;
        this.zzzr = i;
        this.zzzs = z;
    }

    public final void run() {
        zzcf.zza zzb = this.zzzt.zzb(this.zzzr, this.zzzs);
        zzcf.zza unused = this.zzzt.zzzk = zzb;
        if (zzfc.zza(this.zzzr, zzb)) {
            this.zzzt.zza(this.zzzr + 1, this.zzzs);
        }
    }
}
