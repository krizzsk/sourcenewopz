package com.didi.dqr;

import com.didi.dqr.common.BitArray;
import com.didi.dqr.common.BitMatrix;

public abstract class Binarizer {

    /* renamed from: a */
    private final LuminanceSource f18475a;

    /* renamed from: b */
    private LuminanceSource f18476b;

    public abstract Binarizer createBinarizer(LuminanceSource luminanceSource);

    public abstract BitMatrix getBlackMatrix() throws NotFoundException;

    public abstract BitArray getBlackRow(int i, BitArray bitArray) throws NotFoundException;

    public abstract BitArray getRotatedBlackRow(int i, BitArray bitArray) throws NotFoundException;

    protected Binarizer(LuminanceSource luminanceSource) {
        this.f18475a = luminanceSource;
    }

    public final LuminanceSource getLuminanceSource() {
        return this.f18475a;
    }

    public final int getWidth() {
        return this.f18475a.getWidth();
    }

    public final int getHeight() {
        return this.f18475a.getHeight();
    }

    public final LuminanceSource getRotateLuminanceSource() {
        if (this.f18476b == null) {
            this.f18476b = new PlanarYUVLuminanceSource(this.f18475a.getMatrix(), this.f18475a.getHeight(), this.f18475a.getWidth());
        }
        return this.f18476b;
    }
}
