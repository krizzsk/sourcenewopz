package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
import net.lingala.zip4j.util.InternalZipConstants;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
class zziv {
    private int zzahz;
    protected AudioTrack zzakm;
    private boolean zzamh;
    private long zzami;
    private long zzamj;
    private long zzamk;
    private long zzaml;
    private long zzamm;
    private long zzamn;

    private zziv() {
    }

    public boolean zzgc() {
        return false;
    }

    public void zza(AudioTrack audioTrack, boolean z) {
        this.zzakm = audioTrack;
        this.zzamh = z;
        this.zzaml = -9223372036854775807L;
        this.zzami = 0;
        this.zzamj = 0;
        this.zzamk = 0;
        if (audioTrack != null) {
            this.zzahz = audioTrack.getSampleRate();
        }
    }

    public final void zzdy(long j) {
        this.zzamm = zzgf();
        this.zzaml = SystemClock.elapsedRealtime() * 1000;
        this.zzamn = j;
        this.zzakm.stop();
    }

    public final void pause() {
        if (this.zzaml == -9223372036854775807L) {
            this.zzakm.pause();
        }
    }

    public final long zzgf() {
        if (this.zzaml != -9223372036854775807L) {
            return Math.min(this.zzamn, this.zzamm + ((((SystemClock.elapsedRealtime() * 1000) - this.zzaml) * ((long) this.zzahz)) / 1000000));
        }
        int playState = this.zzakm.getPlayState();
        if (playState == 1) {
            return 0;
        }
        long playbackHeadPosition = InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) this.zzakm.getPlaybackHeadPosition());
        if (this.zzamh) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.zzamk = this.zzami;
            }
            playbackHeadPosition += this.zzamk;
        }
        if (this.zzami > playbackHeadPosition) {
            this.zzamj++;
        }
        this.zzami = playbackHeadPosition;
        return playbackHeadPosition + (this.zzamj << 32);
    }

    public final long zzgg() {
        return (zzgf() * 1000000) / ((long) this.zzahz);
    }

    public long zzgd() {
        throw new UnsupportedOperationException();
    }

    public long zzge() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ zziv(zzis zzis) {
        this();
    }
}
