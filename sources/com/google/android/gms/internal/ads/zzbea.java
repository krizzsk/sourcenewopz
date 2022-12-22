package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbea implements zzon {
    private Uri uri;
    private final zzon zzerj;
    private final long zzerk;
    private final zzon zzerl;
    private long zzerm;

    zzbea(zzon zzon, int i, zzon zzon2) {
        this.zzerj = zzon;
        this.zzerk = (long) i;
        this.zzerl = zzon2;
    }

    public final long zza(zzos zzos) throws IOException {
        zzos zzos2;
        long j;
        zzos zzos3 = zzos;
        this.uri = zzos3.uri;
        zzos zzos4 = null;
        if (zzos3.position >= this.zzerk) {
            zzos2 = null;
        } else {
            long j2 = zzos3.position;
            if (zzos3.zzco != -1) {
                j = Math.min(zzos3.zzco, this.zzerk - j2);
            } else {
                j = this.zzerk - j2;
            }
            zzos2 = new zzos(zzos3.uri, j2, j, (String) null);
        }
        if (zzos3.zzco == -1 || zzos3.position + zzos3.zzco > this.zzerk) {
            zzos4 = new zzos(zzos3.uri, Math.max(this.zzerk, zzos3.position), zzos3.zzco != -1 ? Math.min(zzos3.zzco, (zzos3.position + zzos3.zzco) - this.zzerk) : -1, (String) null);
        }
        long j3 = 0;
        long zza = zzos2 != null ? this.zzerj.zza(zzos2) : 0;
        if (zzos4 != null) {
            j3 = this.zzerl.zza(zzos4);
        }
        this.zzerm = zzos3.position;
        if (zza == -1 || j3 == -1) {
            return -1;
        }
        return zza + j3;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = this.zzerm;
        long j2 = this.zzerk;
        if (j < j2) {
            i3 = this.zzerj.read(bArr, i, (int) Math.min((long) i2, j2 - j));
            this.zzerm += (long) i3;
        } else {
            i3 = 0;
        }
        if (this.zzerm < this.zzerk) {
            return i3;
        }
        int read = this.zzerl.read(bArr, i + i3, i2 - i3);
        int i4 = i3 + read;
        this.zzerm += (long) read;
        return i4;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void close() throws IOException {
        this.zzerj.close();
        this.zzerl.close();
    }
}
