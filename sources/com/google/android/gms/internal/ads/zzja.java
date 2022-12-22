package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzja implements zzij {
    private int zzahy = -1;
    private ByteBuffer zzalt = zzajm;
    private int zzamq = -1;
    private int[] zzamr;
    private boolean zzams;
    private int[] zzamt;
    private ByteBuffer zzamu = zzajm;
    private boolean zzamv;

    public final int zzfo() {
        return 2;
    }

    public final void zzb(int[] iArr) {
        this.zzamr = iArr;
    }

    public final boolean zzb(int i, int i2, int i3) throws zzii {
        boolean z = !Arrays.equals(this.zzamr, this.zzamt);
        int[] iArr = this.zzamr;
        this.zzamt = iArr;
        if (iArr == null) {
            this.zzams = false;
            return z;
        } else if (i3 != 2) {
            throw new zzii(i, i2, i3);
        } else if (!z && this.zzamq == i && this.zzahy == i2) {
            return false;
        } else {
            this.zzamq = i;
            this.zzahy = i2;
            this.zzams = i2 != this.zzamt.length;
            int i4 = 0;
            while (true) {
                int[] iArr2 = this.zzamt;
                if (i4 >= iArr2.length) {
                    return true;
                }
                int i5 = iArr2[i4];
                if (i5 < i2) {
                    this.zzams = (i5 != i4) | this.zzams;
                    i4++;
                } else {
                    throw new zzii(i, i2, i3);
                }
            }
        }
    }

    public final boolean isActive() {
        return this.zzams;
    }

    public final int zzfn() {
        int[] iArr = this.zzamt;
        return iArr == null ? this.zzahy : iArr.length;
    }

    public final void zzn(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = (((limit - position) / (this.zzahy * 2)) * this.zzamt.length) << 1;
        if (this.zzamu.capacity() < length) {
            this.zzamu = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.zzamu.clear();
        }
        while (position < limit) {
            for (int i : this.zzamt) {
                this.zzamu.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.zzahy << 1;
        }
        byteBuffer.position(limit);
        this.zzamu.flip();
        this.zzalt = this.zzamu;
    }

    public final void zzfp() {
        this.zzamv = true;
    }

    public final ByteBuffer zzfq() {
        ByteBuffer byteBuffer = this.zzalt;
        this.zzalt = zzajm;
        return byteBuffer;
    }

    public final boolean zzfi() {
        return this.zzamv && this.zzalt == zzajm;
    }

    public final void flush() {
        this.zzalt = zzajm;
        this.zzamv = false;
    }

    public final void reset() {
        flush();
        this.zzamu = zzajm;
        this.zzahy = -1;
        this.zzamq = -1;
        this.zzamt = null;
        this.zzams = false;
    }
}
