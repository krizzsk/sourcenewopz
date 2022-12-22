package com.microblink.blinkbarcode.hardware.camera;

import com.microblink.blinkbarcode.secured.IIllIIllll;
import com.microblink.blinkbarcode.secured.lIlIllIIlI;
import java.nio.ByteBuffer;

/* compiled from: line */
public class Camera2Frame extends IIllIIllll {
    public Camera2Frame(lIlIllIIlI lililliili) {
        super(lililliili);
    }

    private static native long initializeNativeCamera2Frame(long j, int i, int i2, boolean z, boolean z2, int i3, float f, float f2, float f3, float f4, ByteBuffer byteBuffer, int i4, int i5, ByteBuffer byteBuffer2, int i6, int i7, ByteBuffer byteBuffer3, int i8, int i9);

    private static native double nativeGetCamera2FrameQuality(long j);

    private static native void terminateNativeCamera2Frame(long j);

    public double IlIllIlIIl(long j) {
        return nativeGetCamera2FrameQuality(j);
    }

    public void IllIIIllII(long j) {
        terminateNativeCamera2Frame(j);
    }

    public long llIIlIlIIl(long j, int i, int i2, boolean z, boolean z2, int i3, float f, float f2, float f3, float f4, ByteBuffer byteBuffer, int i4, int i5, ByteBuffer byteBuffer2, int i6, int i7, ByteBuffer byteBuffer3, int i8, int i9) {
        return initializeNativeCamera2Frame(j, i, i2, z, z2, i3, f, f2, f3, f4, byteBuffer, i4, i5, byteBuffer2, i6, i7, byteBuffer3, i8, i9);
    }
}
