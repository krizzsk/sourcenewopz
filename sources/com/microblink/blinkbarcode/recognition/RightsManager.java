package com.microblink.blinkbarcode.recognition;

/* compiled from: line */
public class RightsManager {
    public static String IlIllIlIIl() {
        String nativeGetLicensee = nativeGetLicensee();
        return nativeGetLicensee == null ? "" : nativeGetLicensee;
    }

    public static int IllIIIllII() {
        return nativeGetPingInterval();
    }

    public static boolean llIIIlllll() {
        return nativeIsLicenseOk();
    }

    public static boolean llIIlIlIIl(Right right) {
        return nativeIsRightEnabled(right.llIIlIlIIl());
    }

    private static native String nativeGetLicenseID();

    private static native String nativeGetLicensee();

    private static native int nativeGetPingInterval();

    private static native boolean nativeIsLicenseOk();

    private static native boolean nativeIsRightEnabled(int i);

    public static String llIIlIlIIl() {
        String nativeGetLicenseID = nativeGetLicenseID();
        return nativeGetLicenseID == null ? "" : nativeGetLicenseID;
    }
}
