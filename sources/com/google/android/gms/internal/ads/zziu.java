package com.google.android.gms.internal.ads;

import android.media.AudioTimestamp;
import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zziu extends zziv {
    private final AudioTimestamp zzamd = new AudioTimestamp();
    private long zzame;
    private long zzamf;
    private long zzamg;

    public zziu() {
        super((zzis) null);
    }

    public final void zza(AudioTrack audioTrack, boolean z) {
        super.zza(audioTrack, z);
        this.zzame = 0;
        this.zzamf = 0;
        this.zzamg = 0;
    }

    public final boolean zzgc() {
        boolean timestamp = this.zzakm.getTimestamp(this.zzamd);
        if (timestamp) {
            long j = this.zzamd.framePosition;
            if (this.zzamf > j) {
                this.zzame++;
            }
            this.zzamf = j;
            this.zzamg = j + (this.zzame << 32);
        }
        return timestamp;
    }

    public final long zzgd() {
        return this.zzamd.nanoTime;
    }

    public final long zzge() {
        return this.zzamg;
    }
}
