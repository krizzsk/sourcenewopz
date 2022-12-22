package com.microblink.blinkbarcode.hardware.camera;

import com.microblink.blinkbarcode.secured.IlIlIlIIlI;
import com.microblink.blinkbarcode.secured.lIllIIlIIl;
import com.microblink.blinkbarcode.secured.lllIIIlIlI;

/* compiled from: line */
public class Camera1Frame extends lIllIIlIIl {
    public Camera1Frame(int i, int i2, int i3, IlIlIlIIlI ilIlIlIIlI, lllIIIlIlI llliiilili) {
        super(i, i2, i3, ilIlIlIIlI, llliiilili);
    }

    private static native long initializeNativeCamera1Frame(long j, int i, int i2, byte[] bArr, boolean z, boolean z2, int i3, float f, float f2, float f3, float f4);

    private static native double nativeGetCamera1FrameQuality(long j);

    private static native void terminateNativeCamera1Frame(long j);

    public double IllIIIllII(long j) {
        return nativeGetCamera1FrameQuality(j);
    }

    public void llIIIlllll(long j) {
        terminateNativeCamera1Frame(j);
    }

    public long llIIlIlIIl(long j, int i, int i2, byte[] bArr, boolean z, boolean z2, int i3, float f, float f2, float f3, float f4) {
        return initializeNativeCamera1Frame(j, i, i2, bArr, z, z2, i3, f, f2, f3, f4);
    }
}
