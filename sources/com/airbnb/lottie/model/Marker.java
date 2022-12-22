package com.airbnb.lottie.model;

public class Marker {

    /* renamed from: a */
    private static String f1385a = "\r";

    /* renamed from: b */
    private final String f1386b;
    public final float durationFrames;
    public final float startFrame;

    public Marker(String str, float f, float f2) {
        this.f1386b = str;
        this.durationFrames = f2;
        this.startFrame = f;
    }

    public boolean matchesName(String str) {
        if (this.f1386b.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f1386b.endsWith(f1385a)) {
            String str2 = this.f1386b;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
