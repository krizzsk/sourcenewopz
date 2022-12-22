package com.didi.dqr;

import com.didi.dqr.qrcode.decoder.DecodedBitStreamParser;
import com.didi.dqr.qrcode.decoder.ErrorCorrectionLevel;
import com.didi.dqr.qrcode.decoder.Version;
import java.util.Map;

public class NativeDecode {
    private long mNativeDecode = create();

    private native long create();

    private static native void destroy(long j);

    public native String decode(int i, int i2, byte[] bArr);

    static {
        SoLoader.load();
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        destroy();
    }

    public synchronized void destroy() {
        if (this.mNativeDecode != 0) {
            destroy(this.mNativeDecode);
            this.mNativeDecode = 0;
        }
    }

    public static String decode(byte[] bArr, int i) {
        try {
            return DecodedBitStreamParser.decode(bArr, Version.getVersionForNumber(i), ErrorCorrectionLevel.forBits(1), (Map<DecodeHintType, ?>) null).getText();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
