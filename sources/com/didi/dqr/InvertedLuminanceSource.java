package com.didi.dqr;

public final class InvertedLuminanceSource extends LuminanceSource {

    /* renamed from: a */
    private final LuminanceSource f18481a;

    public InvertedLuminanceSource(LuminanceSource luminanceSource) {
        super(luminanceSource.getWidth(), luminanceSource.getHeight());
        this.f18481a = luminanceSource;
    }

    public byte[] getRow(int i, byte[] bArr) {
        byte[] row = this.f18481a.getRow(i, bArr);
        int width = getWidth();
        for (int i2 = 0; i2 < width; i2++) {
            row[i2] = (byte) (255 - (row[i2] & 255));
        }
        return row;
    }

    public byte[] getMatrix() {
        byte[] matrix = this.f18481a.getMatrix();
        int width = getWidth() * getHeight();
        byte[] bArr = new byte[width];
        for (int i = 0; i < width; i++) {
            bArr[i] = (byte) (255 - (matrix[i] & 255));
        }
        return bArr;
    }

    public boolean isCropSupported() {
        return this.f18481a.isCropSupported();
    }

    public LuminanceSource crop(int i, int i2, int i3, int i4) {
        return new InvertedLuminanceSource(this.f18481a.crop(i, i2, i3, i4));
    }

    public boolean isRotateSupported() {
        return this.f18481a.isRotateSupported();
    }

    public LuminanceSource invert() {
        return this.f18481a;
    }

    public LuminanceSource rotateCounterClockwise() {
        return new InvertedLuminanceSource(this.f18481a.rotateCounterClockwise());
    }

    public LuminanceSource rotateCounterClockwise45() {
        return new InvertedLuminanceSource(this.f18481a.rotateCounterClockwise45());
    }
}
