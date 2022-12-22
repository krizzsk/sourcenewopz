package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzoo implements zzon {
    private final byte[] data;
    private Uri uri;
    private int zzbil;
    private int zzbim;

    public zzoo(byte[] bArr) {
        zzpg.checkNotNull(bArr);
        zzpg.checkArgument(bArr.length > 0);
        this.data = bArr;
    }

    public final long zza(zzos zzos) throws IOException {
        this.uri = zzos.uri;
        this.zzbil = (int) zzos.position;
        int length = (int) (zzos.zzco == -1 ? ((long) this.data.length) - zzos.position : zzos.zzco);
        this.zzbim = length;
        if (length > 0 && this.zzbil + length <= this.data.length) {
            return (long) length;
        }
        int i = this.zzbil;
        long j = zzos.zzco;
        int length2 = this.data.length;
        StringBuilder sb = new StringBuilder(77);
        sb.append("Unsatisfiable range: [");
        sb.append(i);
        sb.append(", ");
        sb.append(j);
        sb.append("], length: ");
        sb.append(length2);
        throw new IOException(sb.toString());
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzbim;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(this.data, this.zzbil, bArr, i, min);
        this.zzbil += min;
        this.zzbim -= min;
        return min;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void close() throws IOException {
        this.uri = null;
    }
}
