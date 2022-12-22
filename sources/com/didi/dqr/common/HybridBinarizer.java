package com.didi.dqr.common;

import com.didi.dqr.Binarizer;
import com.didi.dqr.LuminanceSource;
import com.didi.dqr.NotFoundException;
import com.didi.dqrutil.analysis.AnalysisManager;
import com.didi.dqrutil.analysis.EventId;
import java.lang.reflect.Array;

public final class HybridBinarizer extends GlobalHistogramBinarizer {

    /* renamed from: a */
    private static final int f18546a = 3;

    /* renamed from: b */
    private static final int f18547b = 8;

    /* renamed from: c */
    private static final int f18548c = 7;

    /* renamed from: d */
    private static final int f18549d = 40;

    /* renamed from: e */
    private static final int f18550e = 24;

    /* renamed from: f */
    private BitMatrix f18551f;

    /* renamed from: a */
    private static int m13728a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public HybridBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    public BitMatrix getBlackMatrix() throws NotFoundException {
        AnalysisManager.report(EventId.CREATE_HYBRID_BINARIZER);
        BitMatrix bitMatrix = this.f18551f;
        if (bitMatrix != null) {
            return bitMatrix;
        }
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        if (width < 40 || height < 40) {
            this.f18551f = super.getBlackMatrix();
        } else {
            byte[] matrix = luminanceSource.getMatrix();
            int i = width >> 3;
            if ((width & 7) != 0) {
                i++;
            }
            int i2 = height >> 3;
            if ((height & 7) != 0) {
                i2++;
            }
            int[][] a = m13731a(matrix, i, i2, width, height);
            BitMatrix bitMatrix2 = new BitMatrix(width, height);
            m13730a(matrix, i, i2, width, height, a, bitMatrix2);
            this.f18551f = bitMatrix2;
        }
        byte[] bArr = new byte[(width * height)];
        for (int i3 = 0; i3 < width; i3++) {
            for (int i4 = 0; i4 < height; i4++) {
                bArr[(i4 * width) + i3] = (byte) (this.f18551f.get(i3, i4) ? 0 : 255);
            }
        }
        this.f18551f.setSource(luminanceSource.getMatrix());
        return this.f18551f;
    }

    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new HybridBinarizer(luminanceSource);
    }

    /* renamed from: a */
    private static void m13730a(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, BitMatrix bitMatrix) {
        int i5 = i;
        int i6 = i2;
        int i7 = i4 - 8;
        int i8 = i3 - 8;
        for (int i9 = 0; i9 < i6; i9++) {
            int i10 = i9 << 3;
            int i11 = i10 > i7 ? i7 : i10;
            int a = m13728a(i9, 2, i6 - 3);
            for (int i12 = 0; i12 < i5; i12++) {
                int i13 = i12 << 3;
                int i14 = i13 > i8 ? i8 : i13;
                int a2 = m13728a(i12, 2, i5 - 3);
                int i15 = 0;
                for (int i16 = -2; i16 <= 2; i16++) {
                    int[] iArr2 = iArr[a + i16];
                    i15 += iArr2[a2 - 2] + iArr2[a2 - 1] + iArr2[a2] + iArr2[a2 + 1] + iArr2[a2 + 2];
                }
                m13729a(bArr, i14, i11, i15 / 25, i3, bitMatrix);
            }
        }
    }

    /* renamed from: a */
    private static void m13729a(byte[] bArr, int i, int i2, int i3, int i4, BitMatrix bitMatrix) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < 8) {
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i5 + i7] & 255) <= i3) {
                    bitMatrix.set(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    /* renamed from: a */
    private static int[][] m13731a(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = 8;
        int i8 = i4 - 8;
        int i9 = i3 - 8;
        int[] iArr = new int[2];
        iArr[1] = i5;
        iArr[0] = i6;
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
        int i10 = 0;
        while (i10 < i6) {
            int i11 = i10 << 3;
            if (i11 > i8) {
                i11 = i8;
            }
            int i12 = 0;
            while (i12 < i5) {
                int i13 = i12 << 3;
                if (i13 > i9) {
                    i13 = i9;
                }
                int i14 = (i11 * i3) + i13;
                byte b = 255;
                int i15 = 0;
                int i16 = 0;
                byte b2 = 0;
                while (i15 < i7) {
                    byte b3 = b2;
                    int i17 = 0;
                    while (i17 < i7) {
                        byte b4 = bArr[i14 + i17] & 255;
                        i16 += b4;
                        if (b4 < b) {
                            b = b4;
                        }
                        if (b4 > b3) {
                            b3 = b4;
                        }
                        i17++;
                        i7 = 8;
                    }
                    if (b3 - b <= 24) {
                        i15++;
                        i14 += i3;
                        b2 = b3;
                        i7 = 8;
                    }
                    while (true) {
                        i15++;
                        i14 += i3;
                        if (i15 >= 8) {
                            break;
                        }
                        int i18 = 0;
                        for (int i19 = 8; i18 < i19; i19 = 8) {
                            i16 += bArr[i14 + i18] & 255;
                            i18++;
                        }
                    }
                    i15++;
                    i14 += i3;
                    b2 = b3;
                    i7 = 8;
                }
                int i20 = i16 >> 6;
                if (b2 - b <= 24) {
                    i20 = b / 2;
                    if (i10 > 0 && i12 > 0) {
                        int i21 = i10 - 1;
                        int i22 = i12 - 1;
                        int i23 = ((iArr2[i21][i12] + (iArr2[i10][i22] * 2)) + iArr2[i21][i22]) / 4;
                        if (b < i23) {
                            i20 = i23;
                        }
                        iArr2[i10][i12] = i20;
                        i12++;
                        i7 = 8;
                    }
                }
                iArr2[i10][i12] = i20;
                i12++;
                i7 = 8;
            }
            i10++;
            i7 = 8;
        }
        return iArr2;
    }
}
