package com.didi.zxing.barcodescanner;

import com.didi.dqr.DecodeOptions;

public class Decoder {

    /* renamed from: a */
    private DecodeOptions f45262a;

    /* renamed from: b */
    private boolean f45263b;

    public Decoder(DecodeOptions decodeOptions, boolean z) {
        this.f45262a = decodeOptions;
        this.f45263b = z;
    }

    public DecodeOptions getDecodeOptions() {
        return this.f45262a;
    }

    public boolean isInverted() {
        return this.f45263b;
    }
}
