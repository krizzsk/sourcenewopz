package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcaa extends zzbxq<VideoController.VideoLifecycleCallbacks> {
    private boolean zzewh;

    protected zzcaa(Set<zzbzl<VideoController.VideoLifecycleCallbacks>> set) {
        super(set);
    }

    public final void onVideoPause() {
        zza(zzcad.zzgbn);
    }

    public final void onVideoEnd() {
        zza(zzcac.zzgbn);
    }

    public final synchronized void onVideoStart() {
        zza(zzcaf.zzgbn);
        this.zzewh = true;
    }

    public final synchronized void onVideoPlay() {
        if (!this.zzewh) {
            zza(zzcae.zzgbn);
            this.zzewh = true;
        }
        zza(zzcah.zzgbn);
    }
}
