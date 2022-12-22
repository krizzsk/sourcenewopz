package com.didi.dqr;

public final class PlanarYUVLuminanceSource extends LuminanceSource {

    /* renamed from: a */
    private static final int f18496a = 2;

    /* renamed from: b */
    private byte[] f18497b;

    /* renamed from: c */
    private final int f18498c;

    /* renamed from: d */
    private final int f18499d;

    /* renamed from: e */
    private final int f18500e;

    /* renamed from: f */
    private final int f18501f;

    public boolean isCropSupported() {
        return true;
    }

    public PlanarYUVLuminanceSource(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        super(i5, i6);
        if (i3 + i5 > i || i4 + i6 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f18497b = bArr;
        this.f18498c = i;
        this.f18499d = i2;
        this.f18500e = i3;
        this.f18501f = i4;
        if (z) {
            m13720a(i5, i6);
        }
    }

    public PlanarYUVLuminanceSource(byte[] bArr, int i, int i2) {
        super(i, i2);
        this.f18497b = bArr;
        this.f18498c = i;
        this.f18499d = i2;
        this.f18500e = 0;
        this.f18501f = 0;
        m13721b(i, i2);
    }

    public byte[] getRow(int i, byte[] bArr) {
        if (i < 0 || i >= getHeight()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int width = getWidth();
        if (bArr == null || bArr.length < width) {
            bArr = new byte[width];
        }
        System.arraycopy(this.f18497b, ((i + this.f18501f) * this.f18498c) + this.f18500e, bArr, 0, width);
        return bArr;
    }

    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        if (width == this.f18498c && height == this.f18499d) {
            return this.f18497b;
        }
        int i = width * height;
        byte[] bArr = new byte[i];
        int i2 = this.f18501f;
        int i3 = this.f18498c;
        int i4 = (i2 * i3) + this.f18500e;
        if (width == i3) {
            System.arraycopy(this.f18497b, i4, bArr, 0, i);
            return bArr;
        }
        for (int i5 = 0; i5 < height; i5++) {
            System.arraycopy(this.f18497b, i4, bArr, i5 * width, width);
            i4 += this.f18498c;
        }
        return bArr;
    }

    public LuminanceSource crop(int i, int i2, int i3, int i4) {
        return new PlanarYUVLuminanceSource(this.f18497b, this.f18498c, this.f18499d, this.f18500e + i, this.f18501f + i2, i3, i4, false);
    }

    public int[] renderThumbnail() {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int[] iArr = new int[(width * height)];
        byte[] bArr = this.f18497b;
        int i = (this.f18501f * this.f18498c) + this.f18500e;
        for (int i2 = 0; i2 < height; i2++) {
            int i3 = i2 * width;
            for (int i4 = 0; i4 < width; i4++) {
                iArr[i3 + i4] = ((bArr[(i4 * 2) + i] & 255) * 65793) | -16777216;
            }
            i += this.f18498c * 2;
        }
        return iArr;
    }

    public int getThumbnailWidth() {
        return getWidth() / 2;
    }

    public int getThumbnailHeight() {
        return getHeight() / 2;
    }

    /* renamed from: a */
    private void m13720a(int i, int i2) {
        byte[] bArr = this.f18497b;
        int i3 = (this.f18501f * this.f18498c) + this.f18500e;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = (i / 2) + i3;
            int i6 = (i3 + i) - 1;
            int i7 = i3;
            while (i7 < i5) {
                byte b = bArr[i7];
                bArr[i7] = bArr[i6];
                bArr[i6] = b;
                i7++;
                i6--;
            }
            i4++;
            i3 += this.f18498c;
        }
    }

    /* renamed from: b */
    private void m13721b(int i, int i2) {
        byte[] bArr = new byte[(i * i2)];
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                bArr[(i4 * i) + i3] = this.f18497b[(i3 * i2) + i4];
            }
        }
        this.f18497b = bArr;
    }

    public int getDataWidth() {
        return this.f18498c;
    }

    public int getDataHeight() {
        return this.f18499d;
    }

    public int getAverageLum(int i) {
        int i2 = this.f18499d * this.f18498c;
        long j = 0;
        int i3 = 0;
        while (i3 < this.f18498c) {
            int i4 = 0;
            while (i4 < this.f18499d) {
                j += (long) (this.f18497b[(this.f18498c * i4) + i3] & 255);
                i4 += i;
            }
            i3 += i;
        }
        return (int) (j / ((long) ((i2 / i) / i)));
    }
}
