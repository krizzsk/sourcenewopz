package com.iproov.sdk.cameray;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.google.common.base.Ascii;
import com.iproov.sdk.core.C19898import;
import com.iproov.sdk.core.C19909while;
import p093switch.C3127throw;
import p232do.C20821for;

/* renamed from: com.iproov.sdk.cameray.throw */
/* compiled from: NV21Frame */
public class C19791throw implements C20821for {

    /* renamed from: a */
    private final int f54072a;

    /* renamed from: b */
    private final int f54073b;

    /* renamed from: c */
    private final byte[] f54074c;

    /* renamed from: d */
    private final long f54075d = System.currentTimeMillis();

    C19791throw(int i, int i2, byte[] bArr) {
        this.f54072a = i;
        this.f54073b = i2;
        this.f54074c = bArr;
    }

    /* renamed from: do */
    public Bitmap mo161939do(int i) {
        int i2;
        int[] iArr = new int[((this.f54072a * this.f54073b) / (i * i))];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = this.f54073b;
            if (i3 > i6 - i) {
                return Bitmap.createBitmap(iArr, this.f54072a / i, i6 / i, Bitmap.Config.ARGB_8888);
            }
            int i7 = i4;
            int i8 = 0;
            while (true) {
                i2 = this.f54072a;
                if (i8 > i2 - i) {
                    break;
                }
                int i9 = C3127throw.m4047do((this.f54074c[i7] & 255) - 16, 0, 255);
                iArr[i5] = Color.rgb(i9, i9, i9);
                i7 += i;
                i8 += i;
                i5++;
            }
            i4 += i2 * i;
            i3 += i;
        }
    }

    /* renamed from: for  reason: not valid java name */
    public Bitmap m47472for(int i) {
        int i2;
        int i3 = this.f54072a;
        float f = ((float) i3) / 2.0f;
        int i4 = i3 * this.f54073b;
        int[] iArr = new int[(i4 / (i * i))];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int i8 = this.f54073b;
            if (i5 > i8 - i) {
                return Bitmap.createBitmap(iArr, this.f54072a / i, i8 / i, Bitmap.Config.ARGB_8888);
            }
            int i9 = i6;
            int i10 = 0;
            while (true) {
                i2 = this.f54072a;
                if (i10 > i2 - i) {
                    break;
                }
                int i11 = C3127throw.m4047do((this.f54074c[i9] & 255) - 16, 0, 255);
                byte[] bArr = this.f54074c;
                int i12 = (((int) ((((float) ((int) (((float) i5) / 2.0f))) * f) + (((float) i10) / 2.0f))) * 2) + i4;
                byte b = bArr[i12 + 1] & 255;
                byte b2 = bArr[i12] & 255;
                iArr[i7] = Color.rgb(C3127throw.m4047do((((b2 * 1436) / 1024) + i11) - 179, 0, 255), C3127throw.m4047do((((i11 - ((46549 * b) / 131072)) + 44) - ((b2 * 93604) / 131072)) + 91, 0, 255), C3127throw.m4047do((i11 + ((b * Ascii.SYN) / 1024)) - 227, 0, 255));
                i9 += i;
                i10 += i;
                i7++;
            }
            i6 += i2 * i;
            i5 += i;
        }
    }

    /* renamed from: if */
    public byte[] mo161941if(int i) {
        C19909while.m39264do(C19898import.AND1);
        if (i == 19) {
            return m38758b(this.f54074c);
        }
        if (i == 21 || i == 2130706688) {
            return m38757a(this.f54074c);
        }
        throw new IllegalArgumentException("Unsupported codec format " + i);
    }

    /* renamed from: b */
    private static byte[] m38758b(byte[] bArr) {
        int length = (int) (((double) bArr.length) / 1.5d);
        int i = length / 4;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = (i2 * 2) + length;
            int i4 = length + i2;
            bArr2[i4 + i] = bArr[i3];
            bArr2[i4] = bArr[i3 + 1];
        }
        return bArr2;
    }

    /* renamed from: do */
    public long mo161938do() {
        return this.f54075d;
    }

    /* renamed from: a */
    private static byte[] m38757a(byte[] bArr) {
        int length = (int) (((double) bArr.length) / 1.5d);
        int i = length / 2;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        for (int i2 = length; i2 < length + i; i2 += 2) {
            int i3 = i2 + 1;
            bArr2[i2] = bArr[i3];
            bArr2[i3] = bArr[i2];
        }
        return bArr2;
    }
}
