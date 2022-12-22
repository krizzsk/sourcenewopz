package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzis extends Thread {
    private final /* synthetic */ AudioTrack zzajz;
    private final /* synthetic */ zzit zzaka;

    zzis(zzit zzit, AudioTrack audioTrack) {
        this.zzaka = zzit;
        this.zzajz = audioTrack;
    }

    public final void run() {
        try {
            this.zzajz.flush();
            this.zzajz.release();
        } finally {
            this.zzaka.zzaki.open();
        }
    }
}
