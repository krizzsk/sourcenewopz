package com.google.android.gms.internal.ads;

import java.io.OutputStream;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzelz extends OutputStream {
    private static final byte[] zzipi = new byte[0];
    private byte[] buffer = new byte[128];
    private final int zzipj = 128;
    private final ArrayList<zzelq> zzipk = new ArrayList<>();
    private int zzipl;
    private int zzipm;

    zzelz(int i) {
    }

    public final synchronized void write(int i) {
        if (this.zzipm == this.buffer.length) {
            zzgk(1);
        }
        byte[] bArr = this.buffer;
        int i2 = this.zzipm;
        this.zzipm = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        if (i2 <= this.buffer.length - this.zzipm) {
            System.arraycopy(bArr, i, this.buffer, this.zzipm, i2);
            this.zzipm += i2;
            return;
        }
        int length = this.buffer.length - this.zzipm;
        System.arraycopy(bArr, i, this.buffer, this.zzipm, length);
        int i3 = i2 - length;
        zzgk(i3);
        System.arraycopy(bArr, i + length, this.buffer, 0, i3);
        this.zzipm = i3;
    }

    public final synchronized zzelq zzbgy() {
        if (this.zzipm >= this.buffer.length) {
            this.zzipk.add(new zzema(this.buffer));
            this.buffer = zzipi;
        } else if (this.zzipm > 0) {
            byte[] bArr = this.buffer;
            int i = this.zzipm;
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
            this.zzipk.add(new zzema(bArr2));
        }
        this.zzipl += this.zzipm;
        this.zzipm = 0;
        return zzelq.zzl(this.zzipk);
    }

    private final synchronized int size() {
        return this.zzipl + this.zzipm;
    }

    public final String toString() {
        return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    private final void zzgk(int i) {
        this.zzipk.add(new zzema(this.buffer));
        int length = this.zzipl + this.buffer.length;
        this.zzipl = length;
        this.buffer = new byte[Math.max(this.zzipj, Math.max(i, length >>> 1))];
        this.zzipm = 0;
    }
}
