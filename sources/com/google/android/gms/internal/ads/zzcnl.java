package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzr;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcnl implements zzebi<String> {
    final /* synthetic */ zzcna zzgpu;

    zzcnl(zzcna zzcna) {
        this.zzgpu = zzcna;
    }

    public final void zzb(Throwable th) {
        synchronized (this) {
            boolean unused = this.zzgpu.zzgpd = true;
            this.zzgpu.zza("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (zzr.zzlc().elapsedRealtime() - this.zzgpu.zzgpe));
            this.zzgpu.zzgpf.setException(new Exception());
        }
    }

    public final /* synthetic */ void onSuccess(@Nullable Object obj) {
        String str = (String) obj;
        synchronized (this) {
            boolean unused = this.zzgpu.zzgpd = true;
            this.zzgpu.zza("com.google.android.gms.ads.MobileAds", true, "", (int) (zzr.zzlc().elapsedRealtime() - this.zzgpu.zzgpe));
            this.zzgpu.executor.execute(new zzcnk(this, str));
        }
    }
}
