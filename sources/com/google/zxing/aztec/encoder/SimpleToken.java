package com.google.zxing.aztec.encoder;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.google.zxing.common.BitArray;
import kotlin.text.Typography;

final class SimpleToken extends Token {
    private final short bitCount;
    private final short value;

    SimpleToken(Token token, int i, int i2) {
        super(token);
        this.value = (short) i;
        this.bitCount = (short) i2;
    }

    /* access modifiers changed from: package-private */
    public void appendTo(BitArray bitArray, byte[] bArr) {
        bitArray.appendBits(this.value, this.bitCount);
    }

    public String toString() {
        short s = this.value;
        short s2 = this.bitCount;
        short s3 = (s & ((1 << s2) - 1)) | (1 << s2);
        return IMTextUtils.STREET_IMAGE_TAG_START + Integer.toBinaryString(s3 | (1 << this.bitCount)).substring(1) + Typography.greater;
    }
}
