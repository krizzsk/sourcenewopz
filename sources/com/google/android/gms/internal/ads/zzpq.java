package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzpq {
    private byte[] data;
    private int zzbks;
    private int zzbkt = 0;
    private int zzbku;

    public zzpq(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.zzbks = i;
        this.zzbku = i2;
        zzjl();
    }

    public final void zzbp(int i) {
        int i2 = this.zzbks;
        int i3 = (i / 8) + i2;
        this.zzbks = i3;
        int i4 = this.zzbkt + (i % 8);
        this.zzbkt = i4;
        if (i4 > 7) {
            this.zzbks = i3 + 1;
            this.zzbkt = i4 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.zzbks) {
                zzjl();
                return;
            } else if (zzbq(i2)) {
                this.zzbks++;
                i2 += 2;
            }
        }
    }

    public final boolean zzjh() {
        return zzbo(1) == 1;
    }

    public final int zzbo(int i) {
        byte b;
        byte b2;
        if (i == 0) {
            return 0;
        }
        int i2 = i / 8;
        byte b3 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = zzbq(this.zzbks + 1) ? this.zzbks + 2 : this.zzbks + 1;
            int i5 = this.zzbkt;
            if (i5 != 0) {
                byte[] bArr = this.data;
                b2 = ((bArr[i4] & 255) >>> (8 - i5)) | ((bArr[this.zzbks] & 255) << i5);
            } else {
                b2 = this.data[this.zzbks];
            }
            i -= 8;
            b3 |= (255 & b2) << i;
            this.zzbks = i4;
        }
        if (i > 0) {
            int i6 = this.zzbkt + i;
            byte b4 = (byte) (255 >> (8 - i));
            int i7 = zzbq(this.zzbks + 1) ? this.zzbks + 2 : this.zzbks + 1;
            if (i6 > 8) {
                byte[] bArr2 = this.data;
                b = (b4 & (((255 & bArr2[i7]) >> (16 - i6)) | ((bArr2[this.zzbks] & 255) << (i6 - 8)))) | b3;
                this.zzbks = i7;
            } else {
                b = (b4 & ((255 & this.data[this.zzbks]) >> (8 - i6))) | b3;
                if (i6 == 8) {
                    this.zzbks = i7;
                }
            }
            b3 = b;
            this.zzbkt = i6 % 8;
        }
        zzjl();
        return b3;
    }

    public final int zzji() {
        return zzjk();
    }

    public final int zzjj() {
        int zzjk = zzjk();
        return (zzjk % 2 == 0 ? -1 : 1) * ((zzjk + 1) / 2);
    }

    private final int zzjk() {
        int i = 0;
        int i2 = 0;
        while (!zzjh()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = zzbo(i2);
        }
        return i3 + i;
    }

    private final boolean zzbq(int i) {
        if (2 > i || i >= this.zzbku) {
            return false;
        }
        byte[] bArr = this.data;
        return bArr[i] == 3 && bArr[i + -2] == 0 && bArr[i - 1] == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r3.zzbkt;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
        r2 = r3.zzbku;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzjl() {
        /*
            r3 = this;
            int r0 = r3.zzbks
            if (r0 < 0) goto L_0x0016
            int r1 = r3.zzbkt
            if (r1 < 0) goto L_0x0016
            r2 = 8
            if (r1 >= r2) goto L_0x0016
            int r2 = r3.zzbku
            if (r0 < r2) goto L_0x0014
            if (r0 != r2) goto L_0x0016
            if (r1 != 0) goto L_0x0016
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            com.google.android.gms.internal.ads.zzpg.checkState(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpq.zzjl():void");
    }
}
