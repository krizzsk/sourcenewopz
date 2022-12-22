package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbdz implements zzerm {
    private final ByteBuffer zzamu;

    zzbdz(ByteBuffer byteBuffer) {
        this.zzamu = byteBuffer.duplicate();
    }

    public final void close() throws IOException {
    }

    public final int read(ByteBuffer byteBuffer) throws IOException {
        if (this.zzamu.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), this.zzamu.remaining());
        byte[] bArr = new byte[min];
        this.zzamu.get(bArr);
        byteBuffer.put(bArr);
        return min;
    }

    public final long size() throws IOException {
        return (long) this.zzamu.limit();
    }

    public final long position() throws IOException {
        return (long) this.zzamu.position();
    }

    public final void zzfd(long j) throws IOException {
        this.zzamu.position((int) j);
    }

    public final ByteBuffer zzh(long j, long j2) throws IOException {
        int position = this.zzamu.position();
        this.zzamu.position((int) j);
        ByteBuffer slice = this.zzamu.slice();
        slice.limit((int) j2);
        this.zzamu.position(position);
        return slice;
    }
}
