package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcnn extends zzajr {
    private final /* synthetic */ zzcna zzgpu;
    private final /* synthetic */ Object zzgpx;
    private final /* synthetic */ String zzgpy;
    private final /* synthetic */ long zzgpz;
    private final /* synthetic */ zzbbe zzgqa;

    zzcnn(zzcna zzcna, Object obj, String str, long j, zzbbe zzbbe) {
        this.zzgpu = zzcna;
        this.zzgpx = obj;
        this.zzgpy = str;
        this.zzgpz = j;
        this.zzgqa = zzbbe;
    }

    public final void onInitializationSucceeded() {
        synchronized (this.zzgpx) {
            this.zzgpu.zza(this.zzgpy, true, "", (int) (zzr.zzlc().elapsedRealtime() - this.zzgpz));
            this.zzgpu.zzgpi.zzgh(this.zzgpy);
            this.zzgpu.zzgpk.zzfv(this.zzgpy);
            this.zzgqa.set(true);
        }
    }

    public final void onInitializationFailed(String str) {
        synchronized (this.zzgpx) {
            this.zzgpu.zza(this.zzgpy, false, str, (int) (zzr.zzlc().elapsedRealtime() - this.zzgpz));
            this.zzgpu.zzgpi.zzt(this.zzgpy, "error");
            this.zzgpu.zzgpk.zzn(this.zzgpy, "error");
            this.zzgqa.set(false);
        }
    }
}
