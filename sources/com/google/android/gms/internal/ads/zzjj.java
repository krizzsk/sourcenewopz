package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzjj implements zzij {
    private int zzahy = -1;
    private float zzail = 1.0f;
    private float zzaim = 1.0f;
    private ByteBuffer zzalt;
    private int zzamq = -1;
    private ByteBuffer zzamu;
    private boolean zzamv;
    private zzjg zzaoc;
    private ShortBuffer zzaod;
    private long zzaoe;
    private long zzaof;

    public zzjj() {
        ByteBuffer byteBuffer = zzajm;
        this.zzamu = byteBuffer;
        this.zzaod = byteBuffer.asShortBuffer();
        this.zzalt = zzajm;
    }

    public final int zzfo() {
        return 2;
    }

    public final float zzb(float f) {
        float zza = zzpt.zza(f, 0.1f, 8.0f);
        this.zzail = zza;
        return zza;
    }

    public final float zzc(float f) {
        this.zzaim = zzpt.zza(f, 0.1f, 8.0f);
        return f;
    }

    public final long zzgo() {
        return this.zzaoe;
    }

    public final long zzgp() {
        return this.zzaof;
    }

    public final boolean zzb(int i, int i2, int i3) throws zzii {
        if (i3 != 2) {
            throw new zzii(i, i2, i3);
        } else if (this.zzamq == i && this.zzahy == i2) {
            return false;
        } else {
            this.zzamq = i;
            this.zzahy = i2;
            return true;
        }
    }

    public final boolean isActive() {
        return Math.abs(this.zzail - 1.0f) >= 0.01f || Math.abs(this.zzaim - 1.0f) >= 0.01f;
    }

    public final int zzfn() {
        return this.zzahy;
    }

    public final void zzn(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.zzaoe += (long) remaining;
            this.zzaoc.zza(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int zzgj = (this.zzaoc.zzgj() * this.zzahy) << 1;
        if (zzgj > 0) {
            if (this.zzamu.capacity() < zzgj) {
                ByteBuffer order = ByteBuffer.allocateDirect(zzgj).order(ByteOrder.nativeOrder());
                this.zzamu = order;
                this.zzaod = order.asShortBuffer();
            } else {
                this.zzamu.clear();
                this.zzaod.clear();
            }
            this.zzaoc.zzb(this.zzaod);
            this.zzaof += (long) zzgj;
            this.zzamu.limit(zzgj);
            this.zzalt = this.zzamu;
        }
    }

    public final void zzfp() {
        this.zzaoc.zzfp();
        this.zzamv = true;
    }

    public final ByteBuffer zzfq() {
        ByteBuffer byteBuffer = this.zzalt;
        this.zzalt = zzajm;
        return byteBuffer;
    }

    public final boolean zzfi() {
        if (!this.zzamv) {
            return false;
        }
        zzjg zzjg = this.zzaoc;
        return zzjg == null || zzjg.zzgj() == 0;
    }

    public final void flush() {
        zzjg zzjg = new zzjg(this.zzamq, this.zzahy);
        this.zzaoc = zzjg;
        zzjg.setSpeed(this.zzail);
        this.zzaoc.zza(this.zzaim);
        this.zzalt = zzajm;
        this.zzaoe = 0;
        this.zzaof = 0;
        this.zzamv = false;
    }

    public final void reset() {
        this.zzaoc = null;
        ByteBuffer byteBuffer = zzajm;
        this.zzamu = byteBuffer;
        this.zzaod = byteBuffer.asShortBuffer();
        this.zzalt = zzajm;
        this.zzahy = -1;
        this.zzamq = -1;
        this.zzaoe = 0;
        this.zzaof = 0;
        this.zzamv = false;
    }
}
