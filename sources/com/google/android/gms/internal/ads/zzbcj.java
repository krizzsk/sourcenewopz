package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import com.google.android.gms.ads.internal.util.zzj;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbcj {
    private final long zzemv = TimeUnit.MILLISECONDS.toNanos(((Long) zzww.zzra().zzd(zzabq.zzcnr)).longValue());
    private long zzemw;
    private boolean zzemx = true;

    zzbcj() {
    }

    public final void zzabe() {
        this.zzemx = true;
    }

    public final void zza(SurfaceTexture surfaceTexture, zzbca zzbca) {
        if (zzbca != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (this.zzemx || Math.abs(timestamp - this.zzemw) >= this.zzemv) {
                this.zzemx = false;
                this.zzemw = timestamp;
                zzj.zzegq.post(new zzbcm(this, zzbca));
            }
        }
    }
}
