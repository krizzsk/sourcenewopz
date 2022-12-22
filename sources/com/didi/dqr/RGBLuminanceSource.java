package com.didi.dqr;

public final class RGBLuminanceSource extends LuminanceSource {

    /* renamed from: a */
    private final byte[] f18502a;

    /* renamed from: b */
    private final int f18503b;

    /* renamed from: c */
    private final int f18504c;

    /* renamed from: d */
    private final int f18505d;

    /* renamed from: e */
    private final int f18506e;

    public boolean isCropSupported() {
        return true;
    }

    public RGBLuminanceSource(int i, int i2, int[] iArr) {
        super(i, i2);
        this.f18503b = i;
        this.f18504c = i2;
        this.f18505d = 0;
        this.f18506e = 0;
        int i3 = i * i2;
        this.f18502a = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr[i4];
            this.f18502a[i4] = (byte) (((((i5 >> 16) & 255) + ((i5 >> 7) & 510)) + (i5 & 255)) / 4);
        }
    }

    private RGBLuminanceSource(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        super(i5, i6);
        if (i5 + i3 > i || i6 + i4 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f18502a = bArr;
        this.f18503b = i;
        this.f18504c = i2;
        this.f18505d = i3;
        this.f18506e = i4;
    }

    public byte[] getRow(int i, byte[] bArr) {
        if (i < 0 || i >= getHeight()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int width = getWidth();
        if (bArr == null || bArr.length < width) {
            bArr = new byte[width];
        }
        System.arraycopy(this.f18502a, ((i + this.f18506e) * this.f18503b) + this.f18505d, bArr, 0, width);
        return bArr;
    }

    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        if (width == this.f18503b && height == this.f18504c) {
            return this.f18502a;
        }
        int i = width * height;
        byte[] bArr = new byte[i];
        int i2 = this.f18506e;
        int i3 = this.f18503b;
        int i4 = (i2 * i3) + this.f18505d;
        if (width == i3) {
            System.arraycopy(this.f18502a, i4, bArr, 0, i);
            return bArr;
        }
        for (int i5 = 0; i5 < height; i5++) {
            System.arraycopy(this.f18502a, i4, bArr, i5 * width, width);
            i4 += this.f18503b;
        }
        return bArr;
    }

    public LuminanceSource crop(int i, int i2, int i3, int i4) {
        return new RGBLuminanceSource(this.f18502a, this.f18503b, this.f18504c, this.f18505d + i, this.f18506e + i2, i3, i4);
    }
}
