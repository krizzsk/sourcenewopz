package com.didi.dqr;

import org.opencv.core.Rect;

public abstract class LuminanceSource {

    /* renamed from: a */
    private final int f18482a;

    /* renamed from: b */
    private final int f18483b;

    /* renamed from: c */
    private Rect f18484c;

    public abstract byte[] getMatrix();

    public abstract byte[] getRow(int i, byte[] bArr);

    public boolean isCropSupported() {
        return false;
    }

    public boolean isRotateSupported() {
        return false;
    }

    protected LuminanceSource(int i, int i2) {
        this.f18482a = i;
        this.f18483b = i2;
    }

    public final int getWidth() {
        return this.f18482a;
    }

    public final int getHeight() {
        return this.f18483b;
    }

    public LuminanceSource crop(int i, int i2, int i3, int i4) {
        throw new UnsupportedOperationException("This luminance source does not support cropping.");
    }

    public LuminanceSource invert() {
        return new InvertedLuminanceSource(this);
    }

    public LuminanceSource rotateCounterClockwise() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public LuminanceSource rotateCounterClockwise45() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
    }

    public void setCropRect(Rect rect) {
        this.f18484c = rect;
    }
}
