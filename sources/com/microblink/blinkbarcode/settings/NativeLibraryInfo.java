package com.microblink.blinkbarcode.settings;

import com.microblink.blinkbarcode.recognition.IlIllIlIIl;
import com.microblink.blinkbarcode.secured.IIIlIllllI;
import com.microblink.blinkbarcode.secured.IlIIllIlII;

/* compiled from: line */
public class NativeLibraryInfo {
    private long llIIlIlIIl = 0;

    static {
        IlIllIlIIl.IllIIIllII();
        IlIllIlIIl.IllIIIllII();
    }

    public NativeLibraryInfo(long j) {
        this.llIIlIlIIl = j;
    }

    public static IIIlIllllI IllIIIllII() {
        return new IIIlIllllI(IlIIllIlII.values()[nativeObtainProductId()], getNativeBuildVersion());
    }

    public static native String getNativeBuildVersion();

    public static native boolean isProtectionEnabled();

    private static native void nativeDestruct(long j);

    private static native String nativeGetErrorList(long j);

    private static native boolean nativeIsLibrarySuccessfullyInitialized(long j);

    private static native int nativeObtainProductId();

    public final boolean IlIllIlIIl() {
        return nativeIsLibrarySuccessfullyInitialized(this.llIIlIlIIl);
    }

    public void finalize() throws Throwable {
        super.finalize();
        long j = this.llIIlIlIIl;
        if (j != 0) {
            nativeDestruct(j);
        }
    }

    public String llIIlIlIIl() {
        String nativeGetErrorList = nativeGetErrorList(this.llIIlIlIIl);
        return nativeGetErrorList == null ? "" : nativeGetErrorList;
    }
}
