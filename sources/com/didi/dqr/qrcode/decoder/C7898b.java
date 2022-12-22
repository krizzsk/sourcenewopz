package com.didi.dqr.qrcode.decoder;

import com.didi.dqr.qrcode.decoder.Version;

/* renamed from: com.didi.dqr.qrcode.decoder.b */
/* compiled from: DataBlock */
final class C7898b {

    /* renamed from: a */
    private final int f19034a;

    /* renamed from: b */
    private final byte[] f19035b;

    private C7898b(int i, byte[] bArr) {
        this.f19034a = i;
        this.f19035b = bArr;
    }

    /* renamed from: a */
    static C7898b[] m14223a(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length == version.getTotalCodewords()) {
            Version.ECBlocks eCBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
            Version.ECB[] eCBlocks = eCBlocksForLevel.getECBlocks();
            int i = 0;
            for (Version.ECB count : eCBlocks) {
                i += count.getCount();
            }
            C7898b[] bVarArr = new C7898b[i];
            int i2 = 0;
            for (Version.ECB ecb : eCBlocks) {
                int i3 = 0;
                while (i3 < ecb.getCount()) {
                    int dataCodewords = ecb.getDataCodewords();
                    bVarArr[i2] = new C7898b(dataCodewords, new byte[(eCBlocksForLevel.getECCodewordsPerBlock() + dataCodewords)]);
                    i3++;
                    i2++;
                }
            }
            int length = bVarArr[0].f19035b.length;
            int i4 = i - 1;
            while (i4 >= 0 && bVarArr[i4].f19035b.length != length) {
                i4--;
            }
            int i5 = i4 + 1;
            int eCCodewordsPerBlock = length - eCBlocksForLevel.getECCodewordsPerBlock();
            int i6 = 0;
            for (int i7 = 0; i7 < eCCodewordsPerBlock; i7++) {
                int i8 = 0;
                while (i8 < i2) {
                    bVarArr[i8].f19035b[i7] = bArr[i6];
                    i8++;
                    i6++;
                }
            }
            int i9 = i5;
            while (i9 < i2) {
                bVarArr[i9].f19035b[eCCodewordsPerBlock] = bArr[i6];
                i9++;
                i6++;
            }
            int length2 = bVarArr[0].f19035b.length;
            while (eCCodewordsPerBlock < length2) {
                int i10 = 0;
                while (i10 < i2) {
                    bVarArr[i10].f19035b[i10 < i5 ? eCCodewordsPerBlock : eCCodewordsPerBlock + 1] = bArr[i6];
                    i10++;
                    i6++;
                }
                eCCodewordsPerBlock++;
            }
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo58601a() {
        return this.f19034a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public byte[] mo58602b() {
        return this.f19035b;
    }
}
