package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzepf extends zzelq {
    static final int[] zziwx = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zziwy;
    /* access modifiers changed from: private */
    public final zzelq zziwz;
    /* access modifiers changed from: private */
    public final zzelq zzixa;
    private final int zzixb;
    private final int zzixc;

    private zzepf(zzelq zzelq, zzelq zzelq2) {
        this.zziwz = zzelq;
        this.zzixa = zzelq2;
        int size = zzelq.size();
        this.zzixb = size;
        this.zziwy = size + zzelq2.size();
        this.zzixc = Math.max(zzelq.zzbhl(), zzelq2.zzbhl()) + 1;
    }

    static zzelq zza(zzelq zzelq, zzelq zzelq2) {
        if (zzelq2.size() == 0) {
            return zzelq;
        }
        if (zzelq.size() == 0) {
            return zzelq2;
        }
        int size = zzelq.size() + zzelq2.size();
        if (size < 128) {
            return zzb(zzelq, zzelq2);
        }
        if (zzelq instanceof zzepf) {
            zzepf zzepf = (zzepf) zzelq;
            if (zzepf.zzixa.size() + zzelq2.size() < 128) {
                return new zzepf(zzepf.zziwz, zzb(zzepf.zzixa, zzelq2));
            } else if (zzepf.zziwz.zzbhl() > zzepf.zzixa.zzbhl() && zzepf.zzbhl() > zzelq2.zzbhl()) {
                return new zzepf(zzepf.zziwz, new zzepf(zzepf.zzixa, zzelq2));
            }
        }
        if (size >= zzhz(Math.max(zzelq.zzbhl(), zzelq2.zzbhl()) + 1)) {
            return new zzepf(zzelq, zzelq2);
        }
        return new zzeph((zzepe) null).zzc(zzelq, zzelq2);
    }

    private static zzelq zzb(zzelq zzelq, zzelq zzelq2) {
        int size = zzelq.size();
        int size2 = zzelq2.size();
        byte[] bArr = new byte[(size + size2)];
        zzelq.zza(bArr, 0, 0, size);
        zzelq2.zza(bArr, 0, size, size2);
        return zzelq.zzu(bArr);
    }

    static int zzhz(int i) {
        int[] iArr = zziwx;
        if (i >= iArr.length) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    public final byte zzgh(int i) {
        zzad(i, this.zziwy);
        return zzgi(i);
    }

    /* access modifiers changed from: package-private */
    public final byte zzgi(int i) {
        int i2 = this.zzixb;
        if (i < i2) {
            return this.zziwz.zzgi(i);
        }
        return this.zzixa.zzgi(i - i2);
    }

    public final int size() {
        return this.zziwy;
    }

    public final zzelv zzbhg() {
        return new zzepe(this);
    }

    /* access modifiers changed from: protected */
    public final int zzbhl() {
        return this.zzixc;
    }

    /* access modifiers changed from: protected */
    public final boolean zzbhm() {
        return this.zziwy >= zzhz(this.zzixc);
    }

    public final zzelq zzac(int i, int i2) {
        int zzi = zzi(i, i2, this.zziwy);
        if (zzi == 0) {
            return zzelq.zzipc;
        }
        if (zzi == this.zziwy) {
            return this;
        }
        int i3 = this.zzixb;
        if (i2 <= i3) {
            return this.zziwz.zzac(i, i2);
        }
        if (i >= i3) {
            return this.zzixa.zzac(i - i3, i2 - i3);
        }
        zzelq zzelq = this.zziwz;
        return new zzepf(zzelq.zzac(i, zzelq.size()), this.zzixa.zzac(0, i2 - this.zzixb));
    }

    /* access modifiers changed from: protected */
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.zzixb;
        if (i4 <= i5) {
            this.zziwz.zzb(bArr, i, i2, i3);
        } else if (i >= i5) {
            this.zzixa.zzb(bArr, i - i5, i2, i3);
        } else {
            int i6 = i5 - i;
            this.zziwz.zzb(bArr, i, i2, i6);
            this.zzixa.zzb(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzeln zzeln) throws IOException {
        this.zziwz.zza(zzeln);
        this.zzixa.zza(zzeln);
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(toByteArray(), charset);
    }

    public final boolean zzbhi() {
        int zzg = this.zziwz.zzg(0, 0, this.zzixb);
        zzelq zzelq = this.zzixa;
        if (zzelq.zzg(zzg, 0, zzelq.size()) == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final int zzg(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzixb;
        if (i4 <= i5) {
            return this.zziwz.zzg(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zzixa.zzg(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zzixa.zzg(this.zziwz.zzg(i, i2, i6), 0, i3 - i6);
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzelq)) {
            return false;
        }
        zzelq zzelq = (zzelq) obj;
        if (this.zziwy != zzelq.size()) {
            return false;
        }
        if (this.zziwy == 0) {
            return true;
        }
        int zzbhn = zzbhn();
        int zzbhn2 = zzelq.zzbhn();
        if (zzbhn != 0 && zzbhn2 != 0 && zzbhn != zzbhn2) {
            return false;
        }
        zzepg zzepg = new zzepg(this, (zzepe) null);
        zzelx zzelx = (zzelx) zzepg.next();
        zzepg zzepg2 = new zzepg(zzelq, (zzepe) null);
        zzelx zzelx2 = (zzelx) zzepg2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = zzelx.size() - i;
            int size2 = zzelx2.size() - i2;
            int min = Math.min(size, size2);
            if (i == 0) {
                z = zzelx.zza(zzelx2, i2, min);
            } else {
                z = zzelx2.zza(zzelx, i, min);
            }
            if (!z) {
                return false;
            }
            i3 += min;
            int i4 = this.zziwy;
            if (i3 < i4) {
                if (min == size) {
                    zzelx = (zzelx) zzepg.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == size2) {
                    zzelx2 = (zzelx) zzepg2.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
            } else if (i3 == i4) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final int zzh(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzixb;
        if (i4 <= i5) {
            return this.zziwz.zzh(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zzixa.zzh(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zzixa.zzh(this.zziwz.zzh(i, i2, i6), 0, i3 - i6);
    }

    public final zzemb zzbhj() {
        return new zzemg(new zzepj(this));
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    /* synthetic */ zzepf(zzelq zzelq, zzelq zzelq2, zzepe zzepe) {
        this(zzelq, zzelq2);
    }
}
