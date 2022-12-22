package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzpo {
    private byte[] data;
    private int zzbks;
    private int zzbkt;
    private int zzbku;

    public zzpo() {
    }

    public zzpo(byte[] bArr) {
        this(bArr, bArr.length);
    }

    private zzpo(byte[] bArr, int i) {
        this.data = bArr;
        this.zzbku = i;
    }

    public final int zzbo(int i) {
        int i2;
        int i3;
        byte b;
        byte b2;
        boolean z = false;
        if (i == 0) {
            return 0;
        }
        int i4 = i / 8;
        byte b3 = 0;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = this.zzbkt;
            if (i6 != 0) {
                byte[] bArr = this.data;
                int i7 = this.zzbks;
                b2 = ((bArr[i7 + 1] & 255) >>> (8 - i6)) | ((bArr[i7] & 255) << i6);
            } else {
                b2 = this.data[this.zzbks];
            }
            i -= 8;
            b3 |= (255 & b2) << i;
            this.zzbks++;
        }
        if (i > 0) {
            int i8 = this.zzbkt + i;
            byte b4 = (byte) (255 >> (8 - i));
            if (i8 > 8) {
                byte[] bArr2 = this.data;
                int i9 = this.zzbks;
                b = (b4 & (((255 & bArr2[i9 + 1]) >> (16 - i8)) | ((bArr2[i9] & 255) << (i8 - 8)))) | b3;
                this.zzbks = i9 + 1;
            } else {
                byte[] bArr3 = this.data;
                int i10 = this.zzbks;
                b = (b4 & ((255 & bArr3[i10]) >> (8 - i8))) | b3;
                if (i8 == 8) {
                    this.zzbks = i10 + 1;
                }
            }
            b3 = b;
            this.zzbkt = i8 % 8;
        }
        int i11 = this.zzbks;
        if (i11 >= 0 && (i2 = this.zzbkt) >= 0 && i2 < 8 && (i11 < (i3 = this.zzbku) || (i11 == i3 && i2 == 0))) {
            z = true;
        }
        zzpg.checkState(z);
        return b3;
    }
}
