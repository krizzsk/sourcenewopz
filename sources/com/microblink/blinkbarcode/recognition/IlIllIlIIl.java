package com.microblink.blinkbarcode.recognition;

import com.microblink.blinkbarcode.hardware.MicroblinkDeviceManager;
import com.microblink.blinkbarcode.secured.IIIlIIlIll;
import com.microblink.blinkbarcode.util.Log;

/* compiled from: line */
public class IlIllIlIIl {
    private static Error IlIllIlIIl = null;
    public static final /* synthetic */ int IllIIIllII = 0;
    private static boolean llIIlIlIIl = false;

    public static boolean IlIllIlIIl() {
        return llIIlIlIIl;
    }

    public static boolean IllIIIllII() {
        Class<IlIllIlIIl> cls = IlIllIlIIl.class;
        if (!llIIlIlIIl) {
            try {
                if (MicroblinkDeviceManager.lIlIIIIlIl()) {
                    for (String str : IIIlIIlIll.IlIllIlIIl) {
                        Log.m40227d(cls, "Loading lib{}.so", str);
                        System.loadLibrary(str);
                    }
                    llIIlIlIIl = true;
                } else {
                    throw new UnsatisfiedLinkError("Incompatible CPU!");
                }
            } catch (Error e) {
                llIIlIlIIl = false;
                Log.m40230e(cls, e, "error loading native library", new Object[0]);
                IlIllIlIIl = e;
            }
        }
        return llIIlIlIIl;
    }

    public static void llIIlIlIIl() {
        if (!IllIIIllII()) {
            Error error = IlIllIlIIl;
            if (error != null) {
                throw error;
            }
            throw new RuntimeException("Native library is not loaded");
        }
    }
}
