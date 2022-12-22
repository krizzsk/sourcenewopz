package com.didichuxing.gbankcard.ocr.utils;

import android.graphics.RectF;
import com.didichuxing.dfbasesdk.utils.LogUtils;

public class YuvCroper {
    public static int YUV_420P = 1;
    public static int YUV_420SP;

    /* renamed from: a */
    private final int f47725a;

    /* renamed from: b */
    private byte[] f47726b;

    /* renamed from: c */
    private final int f47727c;

    /* renamed from: d */
    private final int f47728d;

    /* renamed from: e */
    private final int f47729e;

    /* renamed from: f */
    private final int f47730f;

    /* renamed from: g */
    private final int f47731g;

    /* renamed from: h */
    private int f47732h;

    /* renamed from: i */
    private int f47733i;

    /* renamed from: a */
    private int m34175a(int i, int i2) {
        if (i >= i2) {
            return i2;
        }
        float f = ((float) i) / 16.0f;
        int i3 = (int) f;
        int i4 = f - ((float) i3) > 0.5f ? ((int) (((double) f) + 0.5d)) * 16 : i3 * 16;
        if (i4 < 16) {
            return 16;
        }
        return i4;
    }

    public YuvCroper(int i, int i2, int i3, RectF rectF) {
        if (i2 <= 0 || i3 <= 0 || rectF == null || rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
            throw new IllegalArgumentException("YuvCroper: Wrong param! size:" + i2 + "*" + i3 + ". Crop:" + rectF);
        }
        this.f47725a = i;
        this.f47727c = i2;
        this.f47728d = i3;
        this.f47729e = i2 * i3;
        this.f47733i = (int) (rectF.height() * ((float) this.f47728d));
        this.f47732h = (int) (rectF.width() * ((float) this.f47727c));
        this.f47733i = m34175a(this.f47733i, this.f47728d);
        this.f47732h = m34175a(this.f47732h, this.f47727c);
        this.f47730f = (((int) (rectF.left * ((float) this.f47727c))) / 16) * 16;
        this.f47731g = (((int) (rectF.top * ((float) this.f47728d))) / 16) * 16;
        this.f47726b = new byte[(((this.f47733i * this.f47732h) * 3) / 2)];
        LogUtils.m33563d("crop  point:" + this.f47730f + "*" + this.f47731g + "     size:" + this.f47732h + "*" + this.f47733i);
    }

    public int getCropWidth() {
        return this.f47732h;
    }

    public int getCropHeight() {
        return this.f47733i;
    }

    public byte[] crop(byte[] bArr) {
        if (bArr == null || bArr.length != (this.f47729e * 3) / 2) {
            LogUtils.m33563d("crop:wrong oriData!!!");
            return this.f47726b;
        }
        int i = this.f47725a;
        if (i == YUV_420SP) {
            m34177a(bArr);
        } else if (i == YUV_420P) {
            m34178b(bArr);
        }
        return this.f47726b;
    }

    /* renamed from: a */
    private void m34177a(byte[] bArr) {
        int i = this.f47730f;
        int i2 = this.f47727c;
        int i3 = this.f47731g;
        int a = m34176a(bArr, (i2 * i3) + i, i2 * (i3 + this.f47733i), i2, this.f47732h, 0);
        int i4 = this.f47729e;
        int i5 = this.f47727c;
        int i6 = this.f47731g;
        m34176a(bArr, ((i5 * i6) / 2) + i4 + this.f47730f, i4 + (((i6 + this.f47733i) * i5) / 2), i5, this.f47732h, a);
    }

    /* renamed from: b */
    private void m34178b(byte[] bArr) {
        int i = this.f47730f;
        int i2 = this.f47731g;
        int i3 = this.f47727c;
        int a = m34176a(bArr, (i2 * i3) + i, i3 * (i2 + this.f47733i), i3, this.f47732h, 0);
        int i4 = this.f47729e;
        int i5 = this.f47727c;
        int i6 = this.f47731g;
        int i7 = ((i5 * i6) / 4) + (this.f47730f / 2) + i4;
        int i8 = i4 + (((i6 + this.f47733i) * i5) / 4);
        int i9 = i5 / 2;
        int i10 = this.f47732h / 2;
        int a2 = m34176a(bArr, i7, i8, i9, i10, a);
        int i11 = this.f47729e;
        int i12 = this.f47727c;
        int i13 = this.f47731g;
        m34176a(bArr, (this.f47730f / 2) + ((i11 / 4) * 5) + ((i12 * i13) / 4), ((i11 / 4) * 5) + ((i12 * (i13 + this.f47733i)) / 4), i9, i10, a2);
    }

    /* renamed from: a */
    private int m34176a(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        while (i < i2) {
            System.arraycopy(bArr, i, this.f47726b, i5, i4);
            i5 += i4;
            i += i3;
        }
        return i5;
    }
}
