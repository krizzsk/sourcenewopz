package com.iproov.sdk.cameray;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import com.google.common.base.Ascii;
import com.iproov.sdk.cameray.C19788import;
import com.iproov.sdk.core.C19898import;
import com.iproov.sdk.core.C19909while;
import p093switch.C3127throw;
import p232do.C20821for;

/* renamed from: com.iproov.sdk.cameray.while */
/* compiled from: YUV420PackedFrame */
public class C19795while implements C20821for {

    /* renamed from: a */
    private final int f54078a;

    /* renamed from: b */
    private final int f54079b;

    /* renamed from: c */
    private final byte[] f54080c;

    /* renamed from: d */
    private final byte[] f54081d;

    /* renamed from: e */
    private final byte[] f54082e;

    /* renamed from: f */
    private final long f54083f;

    C19795while(Image image) {
        this((C19788import) new C19766a(image));
    }

    /* renamed from: do */
    public Bitmap mo161939do(int i) {
        int i2;
        int[] iArr = new int[(this.f54080c.length / (i * i))];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = this.f54079b;
            if (i3 > i6 - i) {
                return Bitmap.createBitmap(iArr, this.f54078a / i, i6 / i, Bitmap.Config.ARGB_8888);
            }
            int i7 = i4;
            int i8 = 0;
            while (true) {
                i2 = this.f54078a;
                if (i8 > i2 - i) {
                    break;
                }
                int i9 = C3127throw.m4047do((this.f54080c[i7] & 255) - 16, 0, 255);
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
    public Bitmap m47475for(int i) {
        int i2;
        float f = ((float) this.f54078a) / 2.0f;
        int[] iArr = new int[(this.f54080c.length / (i * i))];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = this.f54079b;
            if (i3 > i6 - i) {
                return Bitmap.createBitmap(iArr, this.f54078a / i, i6 / i, Bitmap.Config.ARGB_8888);
            }
            int i7 = i4;
            int i8 = 0;
            while (true) {
                i2 = this.f54078a;
                if (i8 > i2 - i) {
                    break;
                }
                int i9 = (int) ((((float) ((int) (((float) i3) / 2.0f))) * f) + (((float) i8) / 2.0f));
                int i10 = C3127throw.m4047do((this.f54080c[i7] & 255) - 16, 0, 255);
                byte b = this.f54081d[i9] & 255;
                byte b2 = this.f54082e[i9] & 255;
                iArr[i5] = Color.rgb(C3127throw.m4047do((((b2 * 1436) / 1024) + i10) - 179, 0, 255), C3127throw.m4047do((((i10 - ((46549 * b) / 131072)) + 44) - ((b2 * 93604) / 131072)) + 91, 0, 255), C3127throw.m4047do((i10 + ((b * Ascii.SYN) / 1024)) - 227, 0, 255));
                i7 += i;
                i8 += i;
                i5++;
            }
            i4 += i2 * i;
            i3 += i;
        }
    }

    /* renamed from: if */
    public byte[] mo161941if(int i) {
        C19909while.m39264do(C19898import.AND1);
        if (i == 19) {
            return m38776b();
        }
        if (i == 21 || i == 2130706688) {
            return m38775a();
        }
        throw new IllegalArgumentException("Unsupported codec format " + i);
    }

    C19795while(C19788import importR) {
        int a = importR.mo161886a();
        this.f54078a = a;
        int b = importR.mo161889b();
        this.f54079b = b;
        int i = b * a;
        this.f54080c = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < this.f54079b; i3++) {
            C19788import.C19789do doVar = C19788import.C19789do.f54069do;
            importR.mo161888a(doVar, i3 * importR.mo161890b(doVar), this.f54080c, i2, this.f54078a);
            i2 += this.f54078a;
        }
        C19788import.C19789do doVar2 = C19788import.C19789do.U;
        int a2 = importR.mo161887a(doVar2);
        int b2 = importR.mo161890b(doVar2);
        int i4 = i / 4;
        this.f54081d = new byte[i4];
        this.f54082e = new byte[i4];
        int i5 = this.f54078a / 2;
        int i6 = this.f54079b / 2;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < i6; i9++) {
            for (int i10 = 0; i10 < i5; i10++) {
                this.f54081d[i7] = importR.mo161885a(C19788import.C19789do.U, i8);
                this.f54082e[i7] = importR.mo161885a(C19788import.C19789do.f61752for, i8);
                i7++;
                i8 += a2;
            }
            i8 += b2 - (i5 * a2);
        }
        this.f54083f = System.currentTimeMillis();
    }

    /* renamed from: b */
    private byte[] m38776b() {
        int i = this.f54078a * this.f54079b;
        byte[] bArr = new byte[((int) (((float) i) * 1.5f))];
        byte[] bArr2 = this.f54080c;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        byte[] bArr3 = this.f54081d;
        System.arraycopy(bArr3, 0, bArr, i, bArr3.length);
        byte[] bArr4 = this.f54082e;
        System.arraycopy(bArr4, 0, bArr, i + this.f54081d.length, bArr4.length);
        return bArr;
    }

    /* renamed from: do */
    public long mo161938do() {
        return this.f54083f;
    }

    /* renamed from: a */
    private byte[] m38775a() {
        int i = this.f54078a * this.f54079b;
        byte[] bArr = new byte[((int) (((float) i) * 1.5f))];
        byte[] bArr2 = this.f54080c;
        int i2 = 0;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        while (true) {
            byte[] bArr3 = this.f54081d;
            if (i2 >= bArr3.length) {
                return bArr;
            }
            int i3 = i + 1;
            bArr[i] = bArr3[i2];
            i = i3 + 1;
            bArr[i3] = this.f54082e[i2];
            i2++;
        }
    }
}
