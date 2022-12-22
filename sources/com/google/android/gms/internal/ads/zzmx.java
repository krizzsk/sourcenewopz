package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzmx implements zznn {
    /* access modifiers changed from: private */
    public final int track;
    private final /* synthetic */ zzms zzbdv;

    public zzmx(zzms zzms, int i) {
        this.zzbdv = zzms;
        this.track = i;
    }

    public final boolean isReady() {
        return this.zzbdv.zzbc(this.track);
    }

    public final void zzhw() throws IOException {
        this.zzbdv.zzhw();
    }

    public final int zzb(zzhv zzhv, zzjp zzjp, boolean z) {
        return this.zzbdv.zza(this.track, zzhv, zzjp, z);
    }

    public final void zzeh(long j) {
        this.zzbdv.zze(this.track, j);
    }
}
