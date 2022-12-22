package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzepj extends InputStream {
    private int mark;
    private final /* synthetic */ zzepf zziww;
    private zzepg zzixg;
    private zzelx zzixh;
    private int zzixi;
    private int zzixj;
    private int zzixk;

    public zzepj(zzepf zzepf) {
        this.zziww = zzepf;
        initialize();
    }

    public final boolean markSupported() {
        return true;
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw null;
        } else if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        } else {
            int zzl = zzl(bArr, i, i2);
            if (zzl != 0) {
                return zzl;
            }
            if (i2 > 0 || zzblj() == 0) {
                return -1;
            }
            return zzl;
        }
    }

    public final long skip(long j) {
        if (j >= 0) {
            if (j > 2147483647L) {
                j = 2147483647L;
            }
            return (long) zzl((byte[]) null, 0, (int) j);
        }
        throw new IndexOutOfBoundsException();
    }

    private final int zzl(byte[] bArr, int i, int i2) {
        int i3 = i2;
        while (i3 > 0) {
            zzbli();
            if (this.zzixh == null) {
                break;
            }
            int min = Math.min(this.zzixi - this.zzixj, i3);
            if (bArr != null) {
                this.zzixh.zza(bArr, this.zzixj, i, min);
                i += min;
            }
            this.zzixj += min;
            i3 -= min;
        }
        return i2 - i3;
    }

    public final int read() throws IOException {
        zzbli();
        zzelx zzelx = this.zzixh;
        if (zzelx == null) {
            return -1;
        }
        int i = this.zzixj;
        this.zzixj = i + 1;
        return zzelx.zzgh(i) & 255;
    }

    public final int available() throws IOException {
        return zzblj();
    }

    public final void mark(int i) {
        this.mark = this.zzixk + this.zzixj;
    }

    public final synchronized void reset() {
        initialize();
        zzl((byte[]) null, 0, this.mark);
    }

    private final void initialize() {
        zzepg zzepg = new zzepg(this.zziww, (zzepe) null);
        this.zzixg = zzepg;
        zzelx zzelx = (zzelx) zzepg.next();
        this.zzixh = zzelx;
        this.zzixi = zzelx.size();
        this.zzixj = 0;
        this.zzixk = 0;
    }

    private final void zzbli() {
        int i;
        if (this.zzixh != null && this.zzixj == (i = this.zzixi)) {
            this.zzixk += i;
            this.zzixj = 0;
            if (this.zzixg.hasNext()) {
                zzelx zzelx = (zzelx) this.zzixg.next();
                this.zzixh = zzelx;
                this.zzixi = zzelx.size();
                return;
            }
            this.zzixh = null;
            this.zzixi = 0;
        }
    }

    private final int zzblj() {
        return this.zziww.size() - (this.zzixk + this.zzixj);
    }
}
