package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbbs implements Runnable {
    private final /* synthetic */ zzbbq zzelq;
    private final /* synthetic */ MediaPlayer zzelr;

    zzbbs(zzbbq zzbbq, MediaPlayer mediaPlayer) {
        this.zzelq = zzbbq;
        this.zzelr = mediaPlayer;
    }

    public final void run() {
        this.zzelq.zza(this.zzelr);
        if (this.zzelq.zzelo != null) {
            this.zzelq.zzelo.zzff();
        }
    }
}
