package com.microblink.blinkbarcode.recognition;

/* compiled from: line */
public enum Right {
    TIMESTAMP_USED(0, "licence key is time restricted"),
    PING_USED(1, "licence key requires regular network ping"),
    ALLOW_MULTIPLE_APPS(3, "allow using license key in multiple applications"),
    IS_TRIAL(4, "license key is trial"),
    ALLOW_CUSTOM_UI(10, "allow custom camera overlay when using library"),
    ALLOW_REMOVE_DEMO_OVERLAY(11, "allow removing demo overlay from RecognizerRunnerView"),
    ALLOW_REMOVE_PRODUCTION_OVERLAY(12, "allow removing production overlay from camera");
    
    private String IlIllIlIIl;
    private int llIIlIlIIl;

    private Right(int i, String str) {
        this.llIIlIlIIl = i;
        this.IlIllIlIIl = str;
    }

    public static Right fromIntValue(int i) {
        Right[] values = values();
        for (int i2 = 0; i2 < 7; i2++) {
            Right right = values[i2];
            if (right.llIIlIlIIl == i) {
                return right;
            }
        }
        return null;
    }

    public int llIIlIlIIl() {
        return this.llIIlIlIIl;
    }

    public String toString() {
        return this.IlIllIlIIl;
    }
}
