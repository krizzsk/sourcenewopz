package com.didi.dqr;

import com.didi.dqr.common.BitArray;
import com.didi.dqr.common.BitMatrix;

public final class BinaryBitmap {

    /* renamed from: a */
    private final Binarizer f18477a;

    /* renamed from: b */
    private BitMatrix f18478b;

    public BinaryBitmap(Binarizer binarizer) {
        if (binarizer != null) {
            this.f18477a = binarizer;
            return;
        }
        throw new IllegalArgumentException("Binarizer must be non-null.");
    }

    public int getWidth() {
        return this.f18477a.getWidth();
    }

    public int getHeight() {
        return this.f18477a.getHeight();
    }

    public BitArray getBlackRow(int i, BitArray bitArray) throws NotFoundException {
        return this.f18477a.getBlackRow(i, bitArray);
    }

    public BitArray getRotatedBlackRow(int i, BitArray bitArray) throws NotFoundException {
        return this.f18477a.getRotatedBlackRow(i, bitArray);
    }

    public BitMatrix getBlackMatrix() throws NotFoundException {
        if (this.f18478b == null) {
            this.f18478b = this.f18477a.getBlackMatrix();
        }
        return this.f18478b;
    }

    public boolean isCropSupported() {
        return this.f18477a.getLuminanceSource().isCropSupported();
    }

    public BinaryBitmap crop(int i, int i2, int i3, int i4) {
        return new BinaryBitmap(this.f18477a.createBinarizer(this.f18477a.getLuminanceSource().crop(i, i2, i3, i4)));
    }

    public boolean isRotateSupported() {
        return this.f18477a.getLuminanceSource().isRotateSupported();
    }

    public BinaryBitmap rotateCounterClockwise() {
        return new BinaryBitmap(this.f18477a.createBinarizer(this.f18477a.getLuminanceSource().rotateCounterClockwise()));
    }

    public BinaryBitmap rotateCounterClockwise45() {
        return new BinaryBitmap(this.f18477a.createBinarizer(this.f18477a.getLuminanceSource().rotateCounterClockwise45()));
    }

    public LuminanceSource getSource() {
        return this.f18477a.getLuminanceSource();
    }

    public String toString() {
        try {
            return getBlackMatrix().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}
